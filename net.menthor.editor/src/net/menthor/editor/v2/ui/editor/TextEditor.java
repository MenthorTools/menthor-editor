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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.Theme;
import org.fife.ui.rtextarea.RTextScrollPane;

public class TextEditor extends JPanel implements IEditor {

	private static final long serialVersionUID = -1832428183354138999L;
	
	protected RSyntaxTextArea textArea = new RSyntaxTextArea();
	protected RTextScrollPane scrollPane;
	
	public TextEditor(){		
		setBorder(new EmptyBorder(0, 0, 0, 0));		
		textArea = new RSyntaxTextArea(5, 30);		
	    textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_NONE);
	    textArea.setAntiAliasingEnabled(true);
	    textArea.setCodeFoldingEnabled(false);
		textArea.setForeground(Color.BLACK);
		textArea.setBackground(new Color(255, 255, 255));				
		setTheme(textArea,"/resources/text/editor/themes/rsyntaxarea.xml");
	    setLayout(new BorderLayout(0, 0));      			
      	scrollPane = new RTextScrollPane(textArea);
      	scrollPane.getGutter().setBorder(new EmptyBorder(0, 0, 0, 0));
      	scrollPane.getGutter().setBorderColor(Color.LIGHT_GRAY);
      	scrollPane.setIconRowHeaderEnabled(true);
      	scrollPane.getGutter().setLineNumberColor(Color.GRAY);
      	scrollPane.getTextArea().setRows(5);
      	scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    	scrollPane.setBorder(null);    	
    	textArea.setMinimumSize(new Dimension(0, 0));
    	scrollPane.setMinimumSize(new Dimension(0, 0));
 	    setMinimumSize(new Dimension(0, 0));
      	add(scrollPane);				
	}

	 public void setTheme(RSyntaxTextArea textArea, String xmlPath){
		Theme theme;
		try {
			theme = Theme.load(getClass().getResourceAsStream(xmlPath));
			theme.apply(textArea);
		} catch (IOException e) {
			e.printStackTrace();
		}   
	 }
	   
	 public void loadFile(String filePath) {
		try {
			FileReader fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);
			textArea.read(br, null);
			br.close();			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void setText(String text) { textArea.setText(text); }
	public String getTextArea() { return textArea.getText(); }

	@Override
	public boolean isSaveNeeded() { 
		return false; 
	}
	
	@Override
	public void setSaveNeeded(boolean value) { 
		return; 
	}

	@Override
	public EditorType getEditorType() { return EditorType.TXT_EDITOR; }

	@Override
	public void propagateNewTitle(String title) {}
	
	@Override
	public void dispose() {}		
}
