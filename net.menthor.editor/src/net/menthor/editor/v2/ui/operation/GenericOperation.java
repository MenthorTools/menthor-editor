package net.menthor.editor.v2.ui.operation;

import java.util.List;

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

import javax.swing.undo.AbstractUndoableEdit;

public abstract class GenericOperation extends AbstractUndoableEdit implements IUndoableOperation {

	private static final long serialVersionUID = 2761186015906877743L;
	
	protected Notifier notifier = Notifier.get();
	protected OperationType operationType;
	protected ActionType actionType;
	
	public OperationType getOperationType(){ 
		return operationType; 
	}
	
	public String asString(List<?> list){
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++){			
			if(list.get(i)!=null) sb.append(list.get(i) + (i < list.size()-1 ? ", " : ""));
		}
		return sb.toString();
	}
	
	@Override
	public void undo(){
		actionType = ActionType.UNDO;
		super.undo();		
	}
	
	@Override
	public void redo(){		
		actionType = ActionType.REDO;
		super.redo();		
		run();	
	}
	
	public String runMessage(){
		return "["+operationType.pastTense()+"] ";
	}
	
	public String undoMessage(){
		return "[undo "+operationType.presentTense()+"] ";		
	}
	
	public void run(){
		actionType = ActionType.DO;
	}
}
