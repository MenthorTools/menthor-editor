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
import java.util.List;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.ui.diagram.commands.DiagramNotification.ChangeType;
import org.tinyuml.ui.diagram.commands.DiagramNotification.NotificationType;
import org.tinyuml.umldraw.ClassElement;

import net.menthor.editor.ui.UmlProject;

/**
 * @author John Guerson
 */
public class AlignElementsCommand extends BaseDiagramCommand {

	private static final long serialVersionUID = 1L;
	
	public DiagramEditor editor;
	public UmlProject project;
	public ArrayList<DiagramElement> selected = new ArrayList<DiagramElement>();
	public enum Alignment { TOP, BOTTOM, LEFT, RIGHT, CENTER_VERTICAL, CENTER_HORIZONTAL }
	public Alignment direction;
	public ArrayList<Double> oldPosXList = new ArrayList<Double>();
	public ArrayList<Double> oldPosYList = new ArrayList<Double>();
	
	public AlignElementsCommand(DiagramNotification editorNotification, List<DiagramElement> selected, Alignment direction) 
	{
		this.editor = (DiagramEditor)editorNotification;
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
		
		if(direction==Alignment.TOP) editor.alignTop();
		if(direction==Alignment.BOTTOM) editor.alignBottom();
		if(direction==Alignment.LEFT) editor.alignLeft();
		if(direction==Alignment.RIGHT) editor.alignRight();
		if(direction==Alignment.CENTER_VERTICAL) editor.alignCenterVertically();
		if(direction==Alignment.CENTER_HORIZONTAL) editor.alignCenterHorizontally();
		
		//notify
		if (notification!=null) {
			notification.notifyChange((List<DiagramElement>) selected, ChangeType.ELEMENTS_ALIGNED, redo ? NotificationType.REDO : NotificationType.DO);			
			UndoableEditEvent event = new UndoableEditEvent(((DiagramEditor)editor), this);
			for (UndoableEditListener l : ((DiagramEditor)editor).editListeners)  l.undoableEditHappened(event);			
		}	
	}
}
