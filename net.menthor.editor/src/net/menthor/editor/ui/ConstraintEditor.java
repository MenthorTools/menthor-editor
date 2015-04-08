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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import net.menthor.editor.AppFrame;
import net.menthor.editor.model.OCLDocument;
import net.menthor.editor.model.UmlProject;
import net.menthor.tocl.editor.TOCLEditorPanel;

import org.tinyuml.draw.Diagram;
import org.tinyuml.ui.diagram.Editor;

public class ConstraintEditor extends TOCLEditorPanel implements Editor {

	private static final long serialVersionUID = 7380862047111803466L;
	public OCLDocument oclDoc;
	public JMenuItem parserMenuItem = new JMenuItem("Parse");
	
	public ConstraintEditor(final Component parent) {
		super(parent);
		
		addDocumentListener(new DocumentListener() {			
			@Override
			public void removeUpdate(DocumentEvent arg0) {
			}		
			@Override
			public void insertUpdate(DocumentEvent arg0) {
			}			
			@Override
			public void changedUpdate(DocumentEvent arg0) {				
				((AppFrame)parent).getDiagramManager().saveProjectNeeded(true);				
			}
		});
		
		parserMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		
		JMenuItem openMenuItem = new JMenuItem("Open");
		JMenuItem saveMenuItem = new JMenuItem("Save As");		
		getPopupMenu().add(parserMenuItem);
		getPopupMenu().add(openMenuItem);
		getPopupMenu().add(saveMenuItem);
		
		saveMenuItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				((AppFrame)parent).getDiagramManager().exportOCL();
			}
		});
		openMenuItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				((AppFrame)parent).getDiagramManager().importOCL();
			}
		});
		parserMenuItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				((AppFrame)parent).getDiagramManager().parseConstraints(true);
			}
		});
	}
		
	public OCLDocument getOCLDocument() { return oclDoc; }
	
	public ConstraintEditor(Component parent, OCLDocument oclDoc) {
		this(parent);
		this.oclDoc = oclDoc;
		setText(oclDoc.getContent());
	}
	
	@Override
	public void dispose() {

	}

	@Override
	public boolean isSaveNeeded() {
		return false;
	}

	@Override
	public EditorNature getEditorNature() {
		return EditorNature.OCL;
	}

	@Override
	public Diagram getDiagram() {
		return null;
	}

	@Override
	public UmlProject getProject() {
		return null;
	}
}
