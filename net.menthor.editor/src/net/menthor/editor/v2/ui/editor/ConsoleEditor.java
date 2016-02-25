package net.menthor.editor.v2.ui.editor;

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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import net.menthor.editor.v2.ui.color.ColorMap;
import net.menthor.editor.v2.ui.color.ColorType;
import net.menthor.editor.v2.ui.utilities.RoundedPanel;

public class ConsoleEditor extends RoundedPanel implements IEditor {
	
	private static final long serialVersionUID = -7066838889714939605L;
	
	protected JTextPane output = new JTextPane();
	protected Color background = ColorMap.getInstance().getColor(ColorType.MENTHOR_GREY_LIGHT);
	
	public ConsoleEditor(){
		super();		
		output.setEditable(false);
		output.setBorder(null);
		output.setBackground(background);		
		setBackground(background);
		output.setMinimumSize(new Dimension(0, 0));		
		BorderLayout layout = new BorderLayout(0,0);
		this.setLayout(layout);			
		JScrollPane scrollpane = new JScrollPane(output);
		scrollpane.getVerticalScrollBar().setUnitIncrement(10);
		scrollpane.getHorizontalScrollBar().setUnitIncrement(10);
		scrollpane.setBorder(null);		
		this.add(scrollpane, BorderLayout.CENTER);
		this.setMinimumSize(new Dimension(0, 0));		
	}
	
	public void append(String text){ output.setText(output.getText() + text); }	
	public void write(String text){ output.setText(text); }

	@Override
	public void dispose() {}

	@Override
	public void propagateNewTitle(String title) {}

	@Override
	public boolean isSaveNeeded() { return false; }

	@Override
	public EditorType getEditorType() { return EditorType.CONSOLE_EDITOR; }
}