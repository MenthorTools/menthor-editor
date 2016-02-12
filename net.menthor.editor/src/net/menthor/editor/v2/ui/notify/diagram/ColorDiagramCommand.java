package net.menthor.editor.v2.ui.notify.diagram;

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

import net.menthor.editor.v2.ui.notify.ActionType;
import net.menthor.editor.v2.ui.notify.DiagramCommand;
import net.menthor.editor.v2.ui.notify.NotificationType;

public class ColorDiagramCommand extends DiagramCommand {

	private static final long serialVersionUID = 1L;
	
	protected List<DiagramElement> elementList = new ArrayList<DiagramElement>();
	protected List<ClassElement> classList = new ArrayList<ClassElement>();
	protected List<Color> oldColorList = new ArrayList<Color>();
	protected Color color;
		
	public ColorDiagramCommand(OntoumlEditor editor, List<DiagramElement> selected, Color color){
		this.ontoumlEditor = editor;
		this.color = color;
		this.notificationType = NotificationType.COLOR;
		elementList.addAll(selected);		
		for(DiagramElement dElem: selected){
			if(dElem instanceof ClassElement){
				ClassElement ce = (ClassElement)dElem;
				oldColorList.add(ce.getBackgroundColor());
				this.classList.add(ce);
			}
		}
	}
	
	@Override
	public void undo() {
		super.undo();	
		undoWithoutNotifying();
		notifier.notify(this, elementList, ActionType.UNDO);		
	}
	
	protected void undoWithoutNotifying(){				
		int i =0;
		for(ClassElement ce: classList){
			ce.setBackgroundColor(oldColorList.get(i));
			i++;
		}
	}
	
	protected void runWithoutNotifying(){
		for(DiagramElement dElem: classList){
			if(dElem instanceof ClassElement){
				ClassElement ce = (ClassElement)dElem;
				ce.setBackgroundColor(color);				
			}
		}
	}
	
	@Override
	public void run() {
		super.run();
		runWithoutNotifying();
		notifier.notify(this, elementList, isRedo ? ActionType.REDO : ActionType.DO);			
	}
}
