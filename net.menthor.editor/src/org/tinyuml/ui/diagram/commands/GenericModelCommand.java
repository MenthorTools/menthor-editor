package org.tinyuml.ui.diagram.commands;

import javax.swing.undo.AbstractUndoableEdit;

/**
 * Abstract class for all model commands
 * 
 * @author Tiago Prince
 */
public abstract class GenericModelCommand extends AbstractUndoableEdit implements Command {
	
	private static final long serialVersionUID = 733613330226013575L;
	
	protected boolean redo = false;
	
	public GenericModelCommand(){
		
	}
	
}
