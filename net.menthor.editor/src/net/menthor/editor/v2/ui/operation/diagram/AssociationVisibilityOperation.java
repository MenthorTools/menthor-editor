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
import org.tinyuml.umldraw.AssociationElement;

import net.menthor.editor.v2.ui.operation.DiagramOperation;
import net.menthor.editor.v2.ui.operation.OperationType;

public class AssociationVisibilityOperation extends DiagramOperation{

	private static final long serialVersionUID = -444736590798129291L;

	public enum AssociationVisibility { 
		NAME, ENDPOINTS, STEREOTYPE, MULTIPLICITY, SUBSETS, REDEFINES 
	}
	
	protected HashMap<AssociationElement, Boolean> valueMap = new HashMap<AssociationElement, Boolean>();
	protected List<AssociationElement> associationList = new ArrayList<AssociationElement>();
	protected List<DiagramElement> diagramElementList = new ArrayList<DiagramElement>();
	protected AssociationVisibility visibility;
	protected boolean value;

	private AssociationVisibilityOperation(OntoumlEditor editor, AssociationVisibility visibility, boolean value){
		super();
		this.ontoumlEditor = editor;		
		this.visibility = visibility;
		this.value = value;		
		this.operationType = OperationType.VISIBILITY;
	}
	
	public AssociationVisibilityOperation(OntoumlEditor editor, AssociationElement element, AssociationVisibility visibility, boolean value){
		this(editor,visibility,value);
		this.associationList.add(element);
		this.diagramElementList.add(element);		
		storeOldValues();
	}
	
	public AssociationVisibilityOperation(OntoumlEditor editor, List<AssociationElement> selected, AssociationVisibility visibility, boolean value){
		this(editor,visibility,value);
		this.associationList.addAll(selected);
		this.diagramElementList.addAll(selected);
		storeOldValues();
	}
	
	private void storeOldValues(){
		for (AssociationElement association : associationList) {			
			switch(visibility){
			case NAME:
				valueMap.put(association, association.showName());
				break;
			case STEREOTYPE:
				valueMap.put(association, association.showOntoUmlStereotype());
				break;
			case MULTIPLICITY:
				valueMap.put(association, association.showMultiplicities());
				break;
			case ENDPOINTS:
				valueMap.put(association, association.showRoles());
				break;
			case SUBSETS:
				valueMap.put(association, association.showSubsetting());
				break;
			case REDEFINES:
				valueMap.put(association, association.showRedefining());
				break;
			}			
		}
	}
	
	protected void undoWithoutNotifying(){		
		for (AssociationElement association : associationList) {
			switch(visibility){
			case NAME:
				association.setShowName(valueMap.get(association));
				break;
			case STEREOTYPE:
				association.setShowOntoUmlStereotype(valueMap.get(association));
				break;
			case MULTIPLICITY:
				association.setShowMultiplicities(valueMap.get(association));
				break;
			case ENDPOINTS:
				association.setShowRoles(valueMap.get(association));
				break;
			case SUBSETS:
				association.setShowSubsetting(valueMap.get(association));
				break;
			case REDEFINES:
				association.setShowRedefining(valueMap.get(association));
				break;
			}
		}
		System.out.println(undoMessage());
	}
	
	protected void runWithoutNotifying(){		
		for (AssociationElement association : associationList) {
			switch(visibility){
			case NAME:
				association.setShowName(value);
				break;
			case STEREOTYPE:
				association.setShowOntoUmlStereotype(value);
				break;
			case MULTIPLICITY:
				association.setShowMultiplicities(value);
				break;
			case ENDPOINTS:
				association.setShowRoles(value);
				break;
			case SUBSETS:
				association.setShowSubsetting(value);
				break;
			case REDEFINES:
				association.setShowRedefining(value);
				break;
			}
		}		
		System.out.println(runMessage());
	}
	
	@Override
	public String undoMessage(){
		return super.undoMessage()+asString(associationList);
	}
	
	@Override
	public String runMessage(){
		return super.runMessage()+asString(associationList);
	}
	
	@Override
	public void undo() {
		super.undo();		
		undoWithoutNotifying();
		notifier.notifyViewChange(this, diagramElementList);
	}
	
	@Override
	public void run() {
		super.run();
		runWithoutNotifying();
		notifier.notifyViewChange(this, diagramElementList);		
	}	
}
