package net.menthor.editor.v2.edit;

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

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.tinyuml.umldraw.ClassElement;

import RefOntoUML.Classifier;
import RefOntoUML.Enumeration;
import RefOntoUML.MeasurementDimension;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.dialog.properties.AttributesEditionPanel;
import net.menthor.editor.dialog.properties.ClassEditionPanel;
import net.menthor.editor.dialog.properties.CommentsEditionPanel;
import net.menthor.editor.dialog.properties.ConstraintEditionPanel;
import net.menthor.editor.dialog.properties.DimensionEditionPanel;
import net.menthor.editor.dialog.properties.EnumLiteralEditionPanel;
import net.menthor.editor.dialog.properties.RelatedElementsPanel;
import net.menthor.editor.ui.MainFrame;

public class ClassEditDialog extends BaseEditDialog {

	private static final long serialVersionUID = 1L;
	
	private ClassElement classElement;
	private Classifier element;
	
	private ClassEditionPanel classEdition;
	private CommentsEditionPanel commentsEdition;
	private AttributesEditionPanel attributesEdition;
	private EnumLiteralEditionPanel literalsEdition;
	private DimensionEditionPanel dimensionEdition;
	private ConstraintEditionPanel constraintsEdition;
	private RelatedElementsPanel relatedElements;
	
	@Override
	public void confirm(ActionEvent arg0){
		commentsEdition.transferCommentsData();
		if(attributesEdition!=null) attributesEdition.transferAttributesData();		
		if(literalsEdition!=null) literalsEdition.transferLiteralData();
		if(dimensionEdition!=null) dimensionEdition.transferDimensionData();
		constraintsEdition.transferConstraintsData();
		classEdition.transferClassData();
	}
	
	public ClassEditDialog(final MainFrame parent, final ClassElement classElement, Classifier element, boolean modal){
		super(parent, modal);		
		this.classElement = classElement;		
		this.element = element;
		setTitle(""+""+OntoUMLParser.getStereotype(element)+" "+element.getName());
		setSize(new Dimension(500, 452));
		
		JPanel classTab = new JPanel();
		classTab.setBorder(new EmptyBorder(0, 0, 0, 0));
		classTab.setLayout(new BorderLayout(4,4));
		tabbedPane.addTab("Class",classTab);
		
		classEdition = new ClassEditionPanel (diagramManager,this.classElement,this.element);
		if(element instanceof Enumeration){
			literalsEdition = new EnumLiteralEditionPanel(this,diagramManager,classElement,element);			
			classTab.add(classEdition, BorderLayout.NORTH);
			classTab.add(literalsEdition, BorderLayout.CENTER);
		}else if(element instanceof MeasurementDimension){
			dimensionEdition = new DimensionEditionPanel(diagramManager,classElement,element);			
			classTab.add(classEdition, BorderLayout.NORTH);
			classTab.add(dimensionEdition, BorderLayout.CENTER);
		}else{
			attributesEdition = new AttributesEditionPanel(this,diagramManager,classElement,element);
			classTab.add(classEdition, BorderLayout.NORTH);
			classTab.add(attributesEdition, BorderLayout.CENTER);
		}	
		
		commentsEdition = new CommentsEditionPanel (diagramManager,classElement,element);
		tabbedPane.addTab("Comments", commentsEdition);
		
		constraintsEdition = new ConstraintEditionPanel(diagramManager,classElement,element);
		tabbedPane.addTab("Constraints", constraintsEdition);
		
		relatedElements = new RelatedElementsPanel(diagramManager,classElement,element);
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
