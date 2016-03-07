package net.menthor.editor.v2.ui.dialog;

import java.awt.BorderLayout;

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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.tinyuml.umldraw.ClassElement;

import RefOntoUML.Classifier;
import RefOntoUML.Enumeration;
import RefOntoUML.MeasurementDimension;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.v2.ui.controller.ProjectUIController;

public class ClassEditDialog extends GenericEditDialog {

	private static final long serialVersionUID = 1L;
	
	private Classifier element;
	
	private ClassEditPane classEdition;
	private CommentsEditPane commentsEdition;
	private AttributesEditPane attributesEdition;
	private LiteralEditPane literalsEdition;
	private DimensionEditPane dimensionEdition;
	private ConstraintEditPane constraintsEdition;
	private RelatedElementsPane relatedElements;
	
	@Override
	public void confirm(ActionEvent arg0){
		commentsEdition.transferData();
		if(attributesEdition!=null) attributesEdition.transferData();		
		if(literalsEdition!=null) literalsEdition.transferData();
		if(dimensionEdition!=null) dimensionEdition.transferData();
		constraintsEdition.transferData();
		classEdition.transferData();
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public ClassEditDialog(final JFrame parent, final ClassElement classElement, Classifier element, boolean modal){
		super(parent, modal);				
		initUI(classElement, element);
	}
	
	public ClassEditDialog(final JDialog parent, final ClassElement classElement, Classifier element, boolean modal){
		super(parent, modal);				
		initUI(classElement, element);
	}

	private void initUI(final ClassElement classElement, Classifier element) {
		this.element = element;
		setTitle(""+""+OntoUMLParser.getStereotype(element)+" "+element.getName());
		setSize(new Dimension(537, 410));
		
		JPanel classTab = new JPanel();
		classTab.setBorder(new EmptyBorder(0, 0, 0, 0));
		classTab.setLayout(new BorderLayout(4,4));
		tabbedPane.addTab("Class",classTab);
		
		classEdition = new ClassEditPane (this.element);
		if(element instanceof Enumeration){
			literalsEdition = new LiteralEditPane(classElement,element);			
			classTab.add(classEdition, BorderLayout.NORTH);
			classTab.add(literalsEdition, BorderLayout.CENTER);
		}else if(element instanceof MeasurementDimension){
			dimensionEdition = new DimensionEditPane(element);			
			classTab.add(classEdition, BorderLayout.NORTH);
			classTab.add(dimensionEdition, BorderLayout.CENTER);
		}else{
			attributesEdition = new AttributesEditPane(this,classElement,element);
			classTab.add(classEdition, BorderLayout.NORTH);
			classTab.add(attributesEdition, BorderLayout.CENTER);
		}	
		
		commentsEdition = new CommentsEditPane (element);
		tabbedPane.addTab("Comments", commentsEdition);
		
		constraintsEdition = new ConstraintEditPane(element);
		tabbedPane.addTab("Constraints", constraintsEdition);
		
		relatedElements = new RelatedElementsPane(element, ProjectUIController.get().getProject().getRefParser());
		tabbedPane.addTab("Related Elements", relatedElements);
		
		classEdition.selectNameText();
		if(element instanceof Enumeration) classEdition.getStereotypeComboBox().setEnabled(false);
	}
		
	public void refreshAttributesData(){		
		attributesEdition.refreshData();		
	}
	
	public void refreshLiteralsData(){
		literalsEdition.refreshData();
	}	
}
