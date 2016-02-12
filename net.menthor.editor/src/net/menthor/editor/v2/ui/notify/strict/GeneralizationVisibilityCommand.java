package net.menthor.editor.v2.ui.notify.strict;

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
import org.tinyuml.umldraw.GeneralizationElement;

import net.menthor.editor.v2.ui.notify.ActionType;
import net.menthor.editor.v2.ui.notify.DiagramStrictCommand;
import net.menthor.editor.v2.ui.notify.NotificationType;

/**
 * @author John Guerson
 */
public class GeneralizationVisibilityCommand extends DiagramStrictCommand{

	private static final long serialVersionUID = -444736590798129291L;

	//maps the selected elements to the previous values
	public HashMap<GeneralizationElement, Boolean> valueMap = new HashMap<GeneralizationElement, Boolean>();
	public ArrayList<GeneralizationElement> generalizationList = new ArrayList<GeneralizationElement>();
	public ArrayList<DiagramElement> diagramElementList = new ArrayList<DiagramElement>();
	
	public enum GeneralizationVisibility { GENSET }
	public GeneralizationVisibility visibility;
	public boolean value;
	
	// private constructor that sets up the basic data
	private GeneralizationVisibilityCommand(OntoumlEditor editor, GeneralizationVisibility visibility, boolean value){
		this.ontoumlEditor = editor;		
		this.visibility = visibility;
		this.value = value;
	}
	
	//creates command from a list of element
	public GeneralizationVisibilityCommand(OntoumlEditor editor, List<GeneralizationElement> selected, GeneralizationVisibility visibility, boolean value) 
	{
		this(editor,visibility,value);
		this.generalizationList.addAll(selected);
		this.diagramElementList.addAll(selected);
		populateMap();
	}
	
	private void populateMap(){
		for (GeneralizationElement generalization : generalizationList) {
			
			switch(visibility){
				case GENSET:
					valueMap.put(generalization, generalization.showName());
					break;
			}
			
		}
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undo() {
		super.undo();						
	
		for (GeneralizationElement generalization : generalizationList) {
			switch(visibility){
			case GENSET:
				generalization.setShowName(valueMap.get(generalization));
				break;
			}
		}
		
		if(notifier!=null)
			notifier.notify(this,diagramElementList, NotificationType.MODIFY_VISIBILITY, ActionType.UNDO);

	}
	
	@Override
	public void run() {

		for (GeneralizationElement generalization : generalizationList) {
			switch(visibility){
			case GENSET:
				generalization.setShowName(value);
				break;
			}
		}
		
		//notify
		if (notifier!=null) {
			notifier.notify(this,diagramElementList, NotificationType.MODIFY_VISIBILITY, isRedo ? ActionType.REDO : ActionType.DO);			
						
		}	
		
	}
	
}
