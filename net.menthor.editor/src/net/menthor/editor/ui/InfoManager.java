package net.menthor.editor.ui;

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

import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import net.menthor.editor.v2.editors.ConsoleEditor;
import net.menthor.editor.v2.editors.ErrorEditor;
import net.menthor.editor.v2.editors.ProblemEditor;
import net.menthor.editor.v2.editors.WarningEditor;

public class InfoManager extends JTabbedPane {

	private static final long serialVersionUID = 1L;	
	public static ConsoleEditor outputPane;	
	public MainFrame frame;
	public UmlProject project;
		
	public void set(UmlProject project)
	{
		this.project = project;		
	}
	
	public void empty()
	{
		this.project = null;
		
		outputPane.write("");
		
		for(Component c: getComponents()){
			if(c instanceof ProblemEditor) remove(((ProblemEditor)c));
		}
		repaint();
		revalidate();
	}
	
	public void selectWarnings()
	{
		for(Component c: getComponents())
		{
			if(c instanceof WarningEditor) setSelectedIndex(indexOfComponent(c));	
		}
	}
	
	public void selectProblems()
	{
		for(Component c: getComponents())
		{
			if(c instanceof ProblemEditor && !(c instanceof ErrorEditor) && !(c instanceof WarningEditor)) 
			{
				setSelectedIndex(indexOfComponent(c));				
			}
		}
	}
	
	public void selectStatistic()
	{
		for(Component c: getComponents())
		{
			if(c instanceof StatisticsPane){ setSelectedIndex(indexOfComponent(c)); }
		}
	}
	
	public void selectErrors()
	{
		for(Component c: getComponents())
		{
			if(c instanceof ErrorEditor) setSelectedIndex(indexOfComponent(c));	
		}
	}
		
	public void selectConsole()
	{
		for(Component c: getComponents())
		{
			if(c instanceof ConsoleEditor) setSelectedIndex(indexOfComponent(c));	
		}
	}
	
	public InfoManager (final MainFrame frame, final UmlProject project)
	{
		this.frame=frame;
		this.project = project;
				
		outputPane = new ConsoleEditor();
		
		setBorder(null);
		setBackground(UIManager.getColor("Panel.background"));
		setMinimumSize(new Dimension(0,0));
				
		addTab(" Console ",outputPane);						
	}
	
	public ConsoleEditor getOutput(){
		return outputPane;
	}
		
//	@SuppressWarnings("unused")
//	private String getResourceString(String property) {
//	    return ApplicationResources.getInstance().getString(property);
//	}

	public void showOutputText(String text, boolean clear, boolean showOutput)
	{		
		if(clear)
			outputPane.write(text);
		else
			outputPane.append(text);
				
		if(showOutput){
			outputPane.setVisible(true);
			frame.selectConsole();
		}		
	}
	
	public UmlProject getProject(){
		return project;
	}

}
