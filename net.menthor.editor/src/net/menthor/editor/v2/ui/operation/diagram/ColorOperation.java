package net.menthor.editor.v2.ui.operation.diagram;

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

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.ClassElement;

import net.menthor.editor.v2.ui.operation.DiagramOperation;
import net.menthor.editor.v2.ui.operation.OperationType;

public class ColorOperation extends DiagramOperation {

	private static final long serialVersionUID = 1L;
	
	protected List<DiagramElement> elementList = new ArrayList<DiagramElement>();
	protected List<ClassElement> classList = new ArrayList<ClassElement>();
	protected List<Color> oldColorList = new ArrayList<Color>();
	protected Color color;
		
	public ColorOperation(OntoumlEditor editor, List<DiagramElement> selected, Color color){
		this.ontoumlEditor = editor;
		this.color = color;
		this.operationType = OperationType.COLOR;
		elementList.addAll(selected);		
		for(DiagramElement dElem: selected){
			if(dElem instanceof ClassElement){
				ClassElement ce = (ClassElement)dElem;
				oldColorList.add(ce.getBackgroundColor());
				this.classList.add(ce);
			}
		}
	}
		
	protected void undoWithoutNotifying(){		
		int i =0;
		for(ClassElement ce: classList){
			ce.setBackgroundColor(oldColorList.get(i));
			i++;
		}
		System.out.println(undoMessage());
	}

	protected void runWithoutNotifying(){		
		for(DiagramElement dElem: classList){
			if(dElem instanceof ClassElement){
				ClassElement ce = (ClassElement)dElem;
				ce.setBackgroundColor(color);				
			}
		}
		System.out.println(runMessage());
	}
	
	@Override
	public void run() {
		super.run();		
		runWithoutNotifying();		
		notifier.notifyViewChange(this, elementList);			
	}
	
	@Override
	public void undo() {
		super.undo();	
		undoWithoutNotifying();		
		notifier.notifyViewChange(this, elementList);		
	}
	
	@Override
	public String undoMessage(){
		return super.undoMessage()+asString(classList)+" to "+asString(oldColorList);
	}	
	
	@Override
	public String runMessage(){
		return super.runMessage()+asString(classList)+" to "+color;
	}
}
