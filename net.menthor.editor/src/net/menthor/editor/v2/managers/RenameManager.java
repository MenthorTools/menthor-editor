package net.menthor.editor.v2.managers;

/**
 * ============================================================================================
 * Menthor Editor -- Copyright (c) 2015 
 *
 * This file is part of Menthor Editor. Menthor Editor is based on TinyUML and as so it is 
 * distributed under the same license terms.
 *
 * Menthor Editor is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 *
 * Menthor Editor is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Menthor Editor; 
 * if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, 
 * MA  02110-1301  USA
 * ============================================================================================
 */

import java.awt.Component;
import java.util.List;

import javax.swing.SwingUtilities;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.ui.diagram.commands.DiagramNotification;
import org.tinyuml.ui.diagram.commands.SetLabelTextCommand;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.NamedElement;
import net.menthor.editor.v2.OclDocument;

public class RenameManager extends BaseManager {

	private static RenameManager instance = new RenameManager();
	public static RenameManager get() { return instance; }
	
	public String askForElementName(Component parentWindow, RefOntoUML.Element element){
		return (String)MessageManager.get().input(parentWindow,
			"Please, enter a new name for the model element:",
			"Rename Manager",			
			null,
			((NamedElement)element).getName()
		);
	}
	
	public String askForOCLDocName(Component parentWindow, OclDocument doc){
		return (String)MessageManager.get().input(parentWindow,
			"Please, enter a new name for the OCL document:",
			"Rename Manager",			
			null,
			doc.getName()
		);
	}
	
	public String askForDiagramName(Component parentWindow, StructureDiagram diagram){
		return (String)MessageManager.get().input(parentWindow,			
			"Rename Manager",
			"Please, enter a new name for the diagram:",			
			null,
			diagram.getName()
		);
	}
	
	/** Rename element. */
	public void renameElement(RefOntoUML.Element element){
		if (element instanceof NamedElement){
			String value = askForElementName(diagramManager, element);    						
			if(value!=null){
				((NamedElement)element).setName(value);
				List<DiagramEditor> editors = OccurenceManager.get().getDiagramEditors(element);
				List<DiagramElement> dElemList = OccurenceManager.get().getDiagramElements(element);
				for(DiagramElement dElem: dElemList){
					if (dElem instanceof ClassElement){
						new SetLabelTextCommand((DiagramNotification)editors.get(0),((ClassElement)dElem).getMainLabel(),value).run();						
					}
				}
				UpdateManager.get().updateFromChange(element, false);
			}
		}   
	}	
	
	/** Rename OCL document */
	public void renameOclDocument(final OclDocument oclDoc){
		String text = askForOCLDocName(diagramManager, oclDoc);					
		final String newtext = text;
		if(text!=null){
			if(diagramManager.getOclDocumentNames().contains(text)){
				//name must be unique
			}else{
				//update ocl tab
				SwingUtilities.invokeLater(new Runnable() {				
					@Override
					public void run() {
						oclDoc.setName(newtext);
						int index = diagramManager.getTabIndex(oclDoc);					
						if(index>=0) diagramManager.setTitleAt(index, newtext);			        
						diagramManager.updateUI();
						browser.refresh();					        
					}
				});
			}
		}		
	}
	
	/** Rename diagram */
	public void renameDiagram(final StructureDiagram diagram){
		String text = askForDiagramName(diagramManager, diagram);
		final String newtext = text;		
		if(text!=null){
			if(diagramManager.getDiagramNames().contains(text)){
				//diagram name must be unique
			}else{
				SwingUtilities.invokeLater(new Runnable() {				
					@Override
					public void run() {
						diagram.setName(newtext);
						int index = diagramManager.getTabIndex(diagram);					
						if(index>=0) diagramManager.setTitleAt(index, newtext);			        
						diagramManager.updateUI();
						browser.refresh();				        
					}
				});				
			}
		}		
	}
	
	public void rename(Object obj){		
		if (obj instanceof StructureDiagram) renameDiagram((StructureDiagram)obj);		
		else if (obj instanceof OclDocument) renameOclDocument((OclDocument)obj);							
		else if (obj instanceof RefOntoUML.Element) renameElement((RefOntoUML.Element)obj);		
	}
}
