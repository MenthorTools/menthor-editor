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
import java.util.Map;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.GeneralizationElement;

import net.menthor.editor.v2.ui.operation.DiagramOperation;
import net.menthor.editor.v2.ui.operation.OperationType;

public class GeneralizationVisibilityOperation extends DiagramOperation{

	private static final long serialVersionUID = -444736590798129291L;

	public enum GeneralizationVisibility { 
		GENSET 
	}
	
	protected Map<GeneralizationElement, Boolean> valueMap = new HashMap<GeneralizationElement, Boolean>();
	protected List<GeneralizationElement> generalizationList = new ArrayList<GeneralizationElement>();
	protected List<DiagramElement> diagramElementList = new ArrayList<DiagramElement>();
	protected GeneralizationVisibility visibility;
	protected boolean value;
	
	private GeneralizationVisibilityOperation(OntoumlEditor editor, GeneralizationVisibility visibility, boolean value){
		this.ontoumlEditor = editor;	
		this.operationType = OperationType.VISIBILITY;
		this.visibility = visibility;
		this.value = value;
	}
	
	public GeneralizationVisibilityOperation(OntoumlEditor editor, List<GeneralizationElement> selected, GeneralizationVisibility visibility, boolean value){
		this(editor,visibility,value);
		this.generalizationList.addAll(selected);
		this.diagramElementList.addAll(selected);
		storeOldValues();
	}
	
	private void storeOldValues(){
		for (GeneralizationElement generalization : generalizationList) {			
			switch(visibility){
				case GENSET:
					valueMap.put(generalization, generalization.showName());
					break;
			}			
		}
	}
	
	@Override
	public void undo() {
		super.undo();						
		undoWithoutNotifying();		
		notifier.notifyViewChange(this, actionType, diagramElementList);
	}
	
	protected void undoWithoutNotifying(){
		for (GeneralizationElement generalization : generalizationList) {
			switch(visibility){
			case GENSET:
				generalization.setShowName(valueMap.get(generalization));
				break;
			}
		}	
		System.out.println(undoMessage());
	}
	
	protected void runWithoutNotifying(){
		for (GeneralizationElement generalization : generalizationList) {
			switch(visibility){
			case GENSET:
				generalization.setShowName(value);
				break;
			}
		}		
		System.out.println(runMessage());
	}
	
	@Override
	public void run() {
		super.run();
		runWithoutNotifying();		
		notifier.notifyViewChange(this,actionType, diagramElementList);			
	}
	
	@Override
	public String undoMessage(){
		return super.undoMessage()+asString(diagramElementList);
	}	
	
	@Override
	public String runMessage(){
		return super.runMessage()+asString(diagramElementList);
	}
}
