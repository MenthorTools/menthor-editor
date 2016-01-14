package net.menthor.editor.v2.edit;

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

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JDialog;

import org.tinyuml.umldraw.ClassElement;

import RefOntoUML.Classifier;
import RefOntoUML.Property;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.dialog.properties.PropertyEditionPanel;
import net.menthor.editor.ui.DiagramManager;
import net.menthor.editor.ui.MainFrame;

public class AttributeEditDialog extends BaseEditDialog {

	private static final long serialVersionUID = 1L;

	private ClassElement classElement;
	private Classifier element;	
	private Property attribute;
	
	private PropertyEditionPanel propertyEdition;
	
	public AttributeEditDialog(final MainFrame parent, final DiagramManager diagramManager, final ClassElement classElement, Classifier element, Property attribute, boolean modal){
		super(parent, modal);				
		this.classElement = classElement;		
		this.element = element;		
		this.attribute = attribute;		
		initUI();		
	}
	
	/**
	 * @wbp.parser.constructor 
	 */
	public AttributeEditDialog(final JDialog parent, final DiagramManager diagramManager, final ClassElement classElement, Classifier element, Property attribute, boolean modal){
		super(parent, modal);				
		this.classElement = classElement;		
		this.element = element;		
		this.attribute = attribute;		
		initUI();		
	}
	
	@Override 
	public void confirm(ActionEvent arg0){
		propertyEdition.transferPropertyData();
		if (this.getParent() instanceof ClassEditDialog){
			ClassEditDialog parentDialog = (ClassEditDialog)this.getParent();
			parentDialog.refreshAttributesData();
		}
		dispose();
	}
	
	public void initUI(){
		setTitle(OntoUMLParser.getStereotype(attribute)+" "+attribute.getName()+": "+attribute.getType().getName());		
		propertyEdition = new PropertyEditionPanel(this.getParent(), diagramManager, classElement, element, attribute);		
		tabbedPane.addTab("Attribute", null, propertyEdition, null);	
		setSize(new Dimension(450, 380));
	}
}
