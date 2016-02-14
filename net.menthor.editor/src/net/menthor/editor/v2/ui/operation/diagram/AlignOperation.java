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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.ClassElement;

import net.menthor.editor.v2.ui.operation.ActionType;
import net.menthor.editor.v2.ui.operation.DiagramOperation;
import net.menthor.editor.v2.ui.operation.OperationType;

public class AlignOperation extends DiagramOperation {

	private static final long serialVersionUID = 1L;
	
	public enum Alignment { 
		TOP, BOTTOM, LEFT, RIGHT, CENTER_VERTICAL, CENTER_HORIZONTAL 
	}
	
	protected List<DiagramElement> selected = new ArrayList<DiagramElement>();	
	protected Alignment direction;
	protected List<Double> oldPosXList = new ArrayList<Double>();
	protected List<Double> oldPosYList = new ArrayList<Double>();
	
	public AlignOperation(){
		super();
		this.operationType = OperationType.ALIGN;
	}
	
	public AlignOperation(OntoumlEditor editor, List<DiagramElement> selected, Alignment direction){
		this();
		this.ontoumlEditor = editor;		
		this.direction = direction;		
		for(DiagramElement dElem: selected){
			if(dElem instanceof ClassElement){
				ClassElement ce = (ClassElement)dElem;
				oldPosXList.add(ce.getAbsoluteX1());
				oldPosYList.add(ce.getAbsoluteY1());
				this.selected.add(ce);
			}
		}
	}
	
	@Override
	public void undo() {
		super.undo();				
		
		undoWithoutNotifying();			
		
		System.out.println(undoStatus());
		notifier.notifyViewChange(this, ActionType.UNDO,selected);		
	}
	
	protected void undoWithoutNotifying(){				
		int i =0;
		for(DiagramElement dElem: selected){
			if(dElem instanceof ClassElement){
				ClassElement ce = (ClassElement)dElem;
				ce.setAbsolutePos(oldPosXList.get(i), oldPosYList.get(i));				
				i++;
			}
		}				
	}
	
	@Override
	public void run() {		
		super.run();
		
		runWithoutNotifying();
		
		System.out.println(runStatus());
		notifier.notifyViewChange(this, isRedo ? ActionType.REDO : ActionType.DO,selected);		
	}
	
	public String undoStatus(){
		return "[undo "+operationType.presentTense()+"] "+ontoumlEditor.getDiagram()+": "+asString(selected);
	}	
	public String runStatus(){
		return "["+operationType.pastTense()+"] "+ontoumlEditor.getDiagram()+": "+asString(selected);
	}
	
	protected void runWithoutNotifying(){		
		if(direction==Alignment.TOP) alignTop(this.ontoumlEditor);
		else if(direction==Alignment.BOTTOM) alignBottom(this.ontoumlEditor);
		else if(direction==Alignment.LEFT) alignLeft(this.ontoumlEditor);
		else if(direction==Alignment.RIGHT) alignRight(this.ontoumlEditor);
		else if(direction==Alignment.CENTER_VERTICAL) alignCenterVertically(this.ontoumlEditor);
		else if(direction==Alignment.CENTER_HORIZONTAL) alignCenterHorizontally(this.ontoumlEditor);
	}
	
	private void alignBottom(OntoumlEditor de){		
		List<ClassElement> classElements = new ArrayList<ClassElement>(de.getSelectedClassElements());		
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
	
	private void alignTop(OntoumlEditor de){		
		List<ClassElement> classElements = new ArrayList<ClassElement>(de.getSelectedClassElements());		
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
	
	private void alignLeft(OntoumlEditor de){		
		List<ClassElement> classElements = new ArrayList<ClassElement>(de.getSelectedClassElements());		
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
	
	private void alignRight(OntoumlEditor de){		
		List<ClassElement> classElements = new ArrayList<ClassElement>(de.getSelectedClassElements());		
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
		
	private void alignCenterVertically(OntoumlEditor de){		
		List<ClassElement> classElements = new ArrayList<ClassElement>(de.getSelectedClassElements());		
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

	protected void alignCenterHorizontally (OntoumlEditor de){		
		List<ClassElement> classElements = new ArrayList<ClassElement>(de.getSelectedClassElements());		
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
	protected double calculateCenterAlignPosition(List<Double> coordList){
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
	protected ClassElement getClassElementLargestWidth(List<ClassElement> list){
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
	protected ClassElement getClassElementLargestHeight(List<ClassElement> list){
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
