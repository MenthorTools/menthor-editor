package net.menthor.editor.v2.managers;

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

import java.awt.Component;

import javax.swing.JOptionPane;

import net.menthor.editor.v2.util.Util;

public class MessageManager extends BaseManager {

	// -------- Lazy Initialization

	private static class MessageLoader {
        private static final MessageManager INSTANCE = new MessageManager();
    }	
	public static MessageManager get() { 
		return MessageLoader.INSTANCE; 
	}	
    private MessageManager() {
        if (MessageLoader.INSTANCE != null) throw new IllegalStateException("MessageManager already instantiated");
    }		
    
    // ----------------------------
	
	//------- OPTION -------
	
	public boolean option(Component parent, String title, String customMessage, String[] options){
		int response = JOptionPane.showOptionDialog(parent,
			customMessage,
			"Option - "+title, 
			JOptionPane.YES_NO_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,
			options,
			"default"  
		);
		if(response == JOptionPane.YES_OPTION) return true;
		else return false;
	}
	
	//------- INPUT -------
	
	public Object input(Component parent, String title, String customMessage, Object[] values, Object selected){
		return JOptionPane.showInputDialog(parent, 
			customMessage, 
			"Input - "+title,
		    JOptionPane.QUESTION_MESSAGE, null, values, selected
		);
	}
	
	//------- CONFIRM -------
	
	public boolean confirm(String title, String customMessage){
		return confirm(frame(), title, customMessage);
	}
	
	public boolean confirm(Component parent, String title, String customMessage){
		int option = JOptionPane.showConfirmDialog(parent, 
			customMessage,
			"Confirmation - "+title, 
			JOptionPane.YES_NO_CANCEL_OPTION
		);
		if (option== JOptionPane.YES_OPTION) { return true; }
		else return false;
	}	
	
	//------- ERROR -------
	
	public void showError(Exception e, String dialogName, String customMessage){
		showError(frame(), e, dialogName, customMessage);
	}
	
	public void showError(Component parent, Exception e, String dialogName, String customMessage){
		JOptionPane.showMessageDialog(parent,
			customMessage+"\nMotive: "+Util.getExceptionMessage(e),
			"Error - "+dialogName,
			JOptionPane.ERROR_MESSAGE			
		);
	}
	
	public void showError(String dialogName, String customMessage){
		showError(frame(), dialogName, customMessage);
	}
	
	public void showError(Component parent, String dialogName, String customMessage){
		JOptionPane.showMessageDialog(parent,
			customMessage,
			"Error - "+dialogName,
			JOptionPane.ERROR_MESSAGE			
		);
	}
	
	//------- WARNING -------
	
	public void showWarning(String dialogName, String customMessage){
		showWarning(frame(), dialogName, customMessage);
	}
	
	public void showWarning(Component parent, String dialogName, String customMessage){
		JOptionPane.showMessageDialog(parent,
			customMessage,
			"Warning - "+dialogName,
			JOptionPane.WARNING_MESSAGE			
		);
	}
	
	//------- INFO -------
	
	public void showInfo(String dialogName, String customMessage){
		showInfo(frame(), dialogName, customMessage);
	}
		
	public void showInfo(Component parent, String dialogName, String customMessage){
		JOptionPane.showMessageDialog(parent,
			customMessage,
			"Information - "+dialogName,
			JOptionPane.INFORMATION_MESSAGE			
		);
	}
	
	//------- SUCESS -------
	
	public void showSuccess(Component parent, String dialogName, String customMessage){
		JOptionPane.showMessageDialog(parent	,
			customMessage,
			"Success - "+dialogName,
			JOptionPane.INFORMATION_MESSAGE			
		);
	}
	
	public void showSuccess(String dialogName, String customMessage){
		showSuccess(frame(),dialogName, customMessage);
	}
}
