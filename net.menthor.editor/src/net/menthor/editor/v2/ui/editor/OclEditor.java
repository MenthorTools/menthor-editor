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

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.managers.SyntaxManager;
import net.menthor.tocl.editor.TOCLEditorPanel;

public class OclEditor extends TOCLEditorPanel implements IEditor {

	private static final long serialVersionUID = 7380862047111803466L;
	
	protected OclDocument oclDoc;
	protected JMenuItem verifyMenuItem;
	protected JMenuItem openMenuItem;
	protected JMenuItem saveMenuItem;
	
	public OclDocument getOclDocument() { return oclDoc; }
	public void saveOcl(String content) { }
	public String openOcl() { return ""; }
	public void verifyOcl() { SyntaxManager.get().verifyConstraints(true); }
	public void changeUpdate() { ProjectManager.get().getProject().setSaveModelNeeded(true); }
	
	public OclEditor(Component parent, OclDocument oclDoc) {
		this(parent);
		this.oclDoc = oclDoc;
		setText(oclDoc.getContentAsString());
	}
	
	public OclEditor(final Component parent) {
		super(parent);		
		addDocumentListener(new DocumentListener() {			
			@Override
			public void removeUpdate(DocumentEvent arg0){}		
			@Override
			public void insertUpdate(DocumentEvent arg0){}			
			@Override
			public void changedUpdate(DocumentEvent arg0){ changeUpdate(); }
		});
		verifyMenuItem = new JMenuItem("Parse");
		verifyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));		
		openMenuItem = new JMenuItem("Open");
		saveMenuItem = new JMenuItem("Save As");
		getPopupMenu().add(verifyMenuItem);
		getPopupMenu().add(openMenuItem);
		getPopupMenu().add(saveMenuItem);		
		saveMenuItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				saveOcl(getText());
			}
		});
		openMenuItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				addText(openOcl());
			}
		});
		verifyMenuItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				verifyOcl();
			}
		});
	}
	
	@Override
	public void dispose(){ }
	
	@Override
	public void propagateNewTitle(String title) { oclDoc.setName(title); }
	
	@Override
	public boolean isSaveNeeded() { return false; }
	
	@Override
	public EditorType getEditorType() { return EditorType.OCL_EDITOR; }
	
	public void reloadText(){
		setText(oclDoc.getContentAsString());
	}
}
