package org.tinyuml.ui.diagram.commands;

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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.ui.diagram.commands.DiagramNotification.ChangeType;
import org.tinyuml.ui.diagram.commands.DiagramNotification.NotificationType;
import org.tinyuml.umldraw.ClassElement;

import net.menthor.editor.ui.UmlProject;

/**
 * @author John Guerson
 */
public class AlignElementsCommand extends BaseDiagramCommand {

	private static final long serialVersionUID = 1L;
	
	public OntoumlEditor editor;
	public UmlProject project;
	public ArrayList<DiagramElement> selected = new ArrayList<DiagramElement>();
	public enum Alignment { TOP, BOTTOM, LEFT, RIGHT, CENTER_VERTICAL, CENTER_HORIZONTAL }
	public Alignment direction;
	public ArrayList<Double> oldPosXList = new ArrayList<Double>();
	public ArrayList<Double> oldPosYList = new ArrayList<Double>();
	
	public AlignElementsCommand(DiagramNotification editorNotification, List<DiagramElement> selected, Alignment direction) 
	{
		this.editor = (OntoumlEditor)editorNotification;
		notification = editorNotification;
		this.direction = direction;
		
		for(DiagramElement dElem: selected)
		{
			if(dElem instanceof ClassElement){
				ClassElement ce = (ClassElement)dElem;
				oldPosXList.add(ce.getAbsoluteX1());
				oldPosYList.add(ce.getAbsoluteY1());
				this.selected.add(ce);
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undo() {
		super.undo();
						
		if(notification!=null){
			ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();
		
			int i =0;
			for(DiagramElement dElem: selected)
			{
				if(dElem instanceof ClassElement)
				{
					ClassElement ce = (ClassElement)dElem;
					ce.setAbsolutePos(oldPosXList.get(i), oldPosYList.get(i));
					list.add(ce);
					i++;
				}
			}
			
			notification.notifyChange((List<DiagramElement>) list, ChangeType.ELEMENTS_ALIGNED, NotificationType.UNDO);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void redo() {
		redo = true;
		super.redo();
		run();		
	}

	/**
	 * {@inheritDoc}
	 */
	public void run() {
		
		if(direction==Alignment.TOP) 
			alignTop(this.editor);
		else if(direction==Alignment.BOTTOM) 
			alignBottom(this.editor);
		else if(direction==Alignment.LEFT) 
			alignLeft(this.editor);
		else if(direction==Alignment.RIGHT) 
			alignRight(this.editor);
		else if(direction==Alignment.CENTER_VERTICAL) 
			alignCenterVertically(this.editor);
		else if(direction==Alignment.CENTER_HORIZONTAL) 
			alignCenterHorizontally(this.editor);
		
		//notify
		if (notification!=null) {
			notification.notifyChange((List<DiagramElement>) selected, ChangeType.ELEMENTS_ALIGNED, redo ? NotificationType.REDO : NotificationType.DO);			
			UndoableEditEvent event = new UndoableEditEvent(((OntoumlEditor)editor), this);
			for (UndoableEditListener l : ((OntoumlEditor)editor).editListeners)  l.undoableEditHappened(event);			
		}	
	}
	
	public void alignBottom(OntoumlEditor de){		
		ArrayList<ClassElement> classElements = new ArrayList<ClassElement>(de.getSelectedClassElements());		
		ClassElement atbottom = de.getClassElementAtBottom(classElements);						
		if(atbottom!=null){
			double atbottomY2 = atbottom.getAbsoluteY2();
			for(ClassElement element: classElements){					
				ClassElement ce = element;	
				double ceHeight = ce.getAbsoluteBounds().getHeight();
				if(!ce.equals(atbottom)){
					ce.setAbsolutePos(ce.getAbsoluteX1(),atbottomY2-ceHeight);
				}
			}			
		}		
	}
	
	public void alignTop(OntoumlEditor de){		
		ArrayList<ClassElement> classElements = new ArrayList<ClassElement>(de.getSelectedClassElements());		
		ClassElement attop = de.getClassElementAtTop(classElements);						
		if(attop!=null){
			double attopY1 = attop.getAbsoluteY1();
			for(ClassElement element: classElements){					
				ClassElement ce = element;				
				if(!ce.equals(attop)){
					ce.setAbsolutePos(ce.getAbsoluteX1(),attopY1);
				}
			}			
		}
	}	
	
	public void alignLeft(OntoumlEditor de){		
		ArrayList<ClassElement> classElements = new ArrayList<ClassElement>(de.getSelectedClassElements());		
		ClassElement atleft = de.getClassElementAtLeft(classElements);				
		if(atleft!=null){
			double atrightX1 = atleft.getAbsoluteX1();
			for(ClassElement element: classElements){					
				ClassElement ce = element;				
				if(!ce.equals(atleft)){
					ce.setAbsolutePos(atrightX1,ce.getAbsoluteY1());
				}
			}			
		}		
	}
	
	public void alignRight(OntoumlEditor de){		
		ArrayList<ClassElement> classElements = new ArrayList<ClassElement>(de.getSelectedClassElements());		
		ClassElement atright = de.getClassElementAtRight(classElements);				
		if(atright!=null){
			double atrightX2 = atright.getAbsoluteX2();
			for(ClassElement element: classElements){					
				ClassElement ce = element;	
				double ceWidth = ce.getAbsoluteBounds().getWidth();
				if(!ce.equals(atright)){
					ce.setAbsolutePos(atrightX2-ceWidth,ce.getAbsoluteY1());
				}
			}			
		}		
	}
		
	public void alignCenterVertically(OntoumlEditor de){		
		ArrayList<ClassElement> classElements = new ArrayList<ClassElement>(de.getSelectedClassElements());		
		if (classElements.size() > 0){
			ArrayList<Double> coordList = new ArrayList<Double>();			
			for(DiagramElement elements: classElements){				
				ClassElement ce = (ClassElement)elements;				
				coordList.add(ce.getAbsCenterX());	
			}
			double finalpos = calculateCenterAlignPosition(coordList);
			ClassElement larger = getClassElementLargestWidth(classElements);			
			if(finalpos!=-1 && larger !=null){		
				double largerWidth = larger.getAbsoluteBounds().getWidth();
				((ClassElement)larger).setAbsolutePos(finalpos-(largerWidth/2),larger.getAbsoluteY1());
				for(ClassElement element: classElements){					
					ClassElement ce = element;	
					double ceWidth = ce.getAbsoluteBounds().getWidth();
					if(!ce.equals(larger)){
						ce.setAbsolutePos(finalpos-(ceWidth/2),ce.getAbsoluteY1());
					}
				}
			}			
		}
	}

	public void alignCenterHorizontally (OntoumlEditor de){		
		ArrayList<ClassElement> classElements = new ArrayList<ClassElement>(de.getSelectedClassElements());		
		if (classElements.size() > 0){
			ArrayList<Double> coordList = new ArrayList<Double>();			
			for(ClassElement element: classElements){				
				ClassElement ce = element;				
				coordList.add(ce.getAbsCenterY());	
			}
			double finalpos = calculateCenterAlignPosition(coordList);
			ClassElement larger = getClassElementLargestHeight(classElements);			
			if(finalpos!=-1 && larger !=null){		
				double largerHeight= larger.getAbsoluteBounds().getHeight();
				((ClassElement)larger).setAbsolutePos(larger.getAbsoluteX1(),finalpos-(largerHeight/2));
				for(ClassElement element: classElements){					
					ClassElement ce = element;	
					double ceHeight = ce.getAbsoluteBounds().getHeight();
					if(!ce.equals(larger)){
						ce.setAbsolutePos(ce.getAbsoluteX1(),finalpos-(ceHeight/2));
					}
				}
			}			
		}			
	}
	
	/** Algorithm to calculate the center alignment position */
	public double calculateCenterAlignPosition(ArrayList<Double> coordList){
		Collections.sort(coordList);
		int size = coordList.size();
		double offset = 1000;
		double finalpos = -1;			
		if(coordList.size()>0 && coordList.get(0)==coordList.get(size-1)) return finalpos;			
		for(int i =size-1; i>=0;i--){
			for(int j=i-1; j>=0;j--){
				double diff = coordList.get(i)-coordList.get(j);
				if(diff<offset) { finalpos = coordList.get(j)+(diff/2); offset = diff; }
			}
		}
		return finalpos;
	}
	
	/** Returns the class element with the largest width */
	public ClassElement getClassElementLargestWidth(ArrayList<ClassElement> list){
		double maxwidth = 0;
		ClassElement largerWidthElement = null;
		for(DiagramElement de: list){
			if(de.getAbsoluteBounds().getWidth()>maxwidth) {
				maxwidth = de.getAbsoluteBounds().getWidth();
				largerWidthElement = (ClassElement)de;				
			}
		}
		return largerWidthElement;		
	}
	
	/** Returns the class element with the largest height */
	public ClassElement getClassElementLargestHeight(ArrayList<ClassElement> list){
		double maxheight = 0;
		ClassElement largerHeightElement = null;
		for(DiagramElement de: list){
			if(de.getAbsoluteBounds().getHeight()>maxheight) {
				maxheight = de.getAbsoluteBounds().getHeight();
				largerHeightElement = (ClassElement)de;				
			}
		}		
		return largerHeightElement;		
	}
}
