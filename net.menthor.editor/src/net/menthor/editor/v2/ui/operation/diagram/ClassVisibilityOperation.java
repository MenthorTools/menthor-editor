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
import java.util.HashMap;
import java.util.List;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.ClassElement;

import net.menthor.editor.v2.ui.operation.DiagramOperation;
import net.menthor.editor.v2.ui.operation.OperationType;

public class ClassVisibilityOperation extends DiagramOperation{

	private static final long serialVersionUID = -444736590798129291L;

	public enum ClassVisibility { 
		STEREOTYPE, PARENTS, NAMESPACE, ATTRIBUTES
	}
	
	protected HashMap<ClassElement, Boolean> valueMap = new HashMap<ClassElement, Boolean>();
	protected ArrayList<ClassElement> classList = new ArrayList<ClassElement>();
	protected ArrayList<DiagramElement> diagramElementList = new ArrayList<DiagramElement>();
	protected ClassVisibility visibility;	
	protected boolean value;
	
	private ClassVisibilityOperation(OntoumlEditor editor, ClassVisibility visibility, boolean value){
		super();
		this.ontoumlEditor=editor;		
		this.visibility = visibility;
		this.value = value;
		this.operationType = OperationType.VISIBILITY;
	}
	
	public ClassVisibilityOperation(OntoumlEditor editor, ClassElement element, ClassVisibility visibility, boolean value){
		this(editor,visibility,value);
		this.classList.add(element);
		this.diagramElementList.add(element);
		storeOldValues();
	}
	
	public ClassVisibilityOperation(OntoumlEditor editor, List<ClassElement> selected, ClassVisibility visibility, boolean value) {
		this(editor,visibility,value);
		this.classList.addAll(selected);
		this.diagramElementList.addAll(selected);
		storeOldValues();
	}
	
	private void storeOldValues(){
		for (ClassElement element : classList) {			
			switch(visibility){
			case STEREOTYPE:
				valueMap.put(element, element.showStereotypes());
				break;
			case PARENTS:
				valueMap.put(element, element.showNamespace());
				break;
			case NAMESPACE:
				valueMap.put(element, element.showNamespace());
				break;
			case ATTRIBUTES:
				valueMap.put(element, element.showAttributes());
				break;
			}			
		}
	}
	
	protected void undoWithoutNotifying(){		
		for (ClassElement element : classList) {
			switch(visibility){
			case STEREOTYPE:
				element.setShowStereotypes(valueMap.get(element));
				break;
			case PARENTS:
				element.setShowParents(valueMap.get(element));
				break;
			case NAMESPACE:
				element.setShowNamespace(valueMap.get(element));
				break;
			case ATTRIBUTES:
				element.setShowAttributes(valueMap.get(element));
				break;
			}
		}
		System.out.println(undoMessage());
	}
	
	protected void runWithoutNotifying(){		
		for (ClassElement element : classList) {
			switch(visibility){
			case STEREOTYPE:
				element.setShowStereotypes(value);
				break;
			case PARENTS:
				element.setShowParents(value);
				break;
			case NAMESPACE:
				element.setShowNamespace(value);
				break;
			case ATTRIBUTES:
				element.setShowAttributes(value);
				break;
			}
		}
		System.out.println(runMessage());
	}

	
	@Override
	public void undo() {
		super.undo();				
		undoWithoutNotifying();		
		notifier.notifyViewChange(this, diagramElementList);
	}
	
	@Override
	public String undoMessage(){
		return super.undoMessage()+asString(classList);
	}	
	
	@Override
	public String runMessage(){
		return super.runMessage()+asString(classList);
	}
	
	@Override
	public void run() {
		super.run();	
		runWithoutNotifying();		
		notifier.notifyViewChange(this, diagramElementList);		
	}
	
		
}
