package net.menthor.editor.v2.ui;

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
import java.awt.Dimension;

import javax.swing.UIManager;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.ui.editor.ConsoleEditor;
import net.menthor.editor.v2.ui.editor.ProblemEditor;
import net.menthor.editor.v2.ui.generic.GenericTabbedPane;

public class BottomTabbedPaneUI extends GenericTabbedPane {

	private static final long serialVersionUID = 1L;	
	
	protected static ConsoleEditor consoleEditor;
	
	// -------- Lazy Initialization

	private static class GUIInfoPaneLoader {
        private static final BottomTabbedPaneUI INSTANCE = new BottomTabbedPaneUI();
    }	
	public static BottomTabbedPaneUI get() { 
		return GUIInfoPaneLoader.INSTANCE; 
	}	
    private BottomTabbedPaneUI() {
    	super(CommandListener.get());
        if (GUIInfoPaneLoader.INSTANCE != null) throw new IllegalStateException(this.getClass().getName()+" already instantiated");
        buildUI();
    }		
    
    // ----------------------------
	
	private void buildUI(){
		setBorder(null);
		setBackground(UIManager.getColor("Panel.background"));
		setMinimumSize(new Dimension(0,0));
		consoleEditor = new ConsoleEditor();						
		addTab(" Console ",consoleEditor);						
	}
	
	public ConsoleEditor getConsoleEditor(){ return consoleEditor; }

	public void showOutput(String text, boolean clear, boolean showOutput){		
		if(clear) consoleEditor.write(text);
		else consoleEditor.append(text);				
		if(showOutput){
			consoleEditor.setVisible(true);			
		}		
	}
	
	public void initialState(){
		removeAll();
		addTab(" Console ",consoleEditor);
		emptyOutput();
	}
	
	public void emptyOutput(){		
		consoleEditor.write("");		
		for(Component c: getComponents()){
			if(c instanceof ProblemEditor) remove(((ProblemEditor)c));
		}
		repaint();
		revalidate();
	}
}
