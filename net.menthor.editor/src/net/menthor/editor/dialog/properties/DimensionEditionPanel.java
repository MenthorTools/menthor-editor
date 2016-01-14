package net.menthor.editor.dialog.properties;

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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.tinyuml.umldraw.ClassElement;

import RefOntoUML.BasicMeasurementRegion;
import RefOntoUML.Classifier;
import RefOntoUML.DecimalMeasurementRegion;
import RefOntoUML.IntegerMeasurementRegion;
import RefOntoUML.MeasurementDimension;
import RefOntoUML.MeasurementDomain;
import RefOntoUML.impl.DecimalIntervalDimensionImpl;
import RefOntoUML.impl.DecimalMeasurementRegionImpl;
import RefOntoUML.impl.DecimalOrdinalDimensionImpl;
import RefOntoUML.impl.DecimalRationalDimensionImpl;
import RefOntoUML.impl.IntegerIntervalDimensionImpl;
import RefOntoUML.impl.IntegerMeasurementRegionImpl;
import RefOntoUML.impl.IntegerOrdinalDimensionImpl;
import RefOntoUML.impl.IntegerRationalDimensionImpl;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.ui.DiagramManager;
import net.menthor.editor.ui.Models;

/**
 * @author John Guerson
 */
public class DimensionEditionPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private ClassElement classElement;
	private Classifier dimension;
	private DiagramManager diagramManager;
	private JTextField unitField;
	private JPanel pane;
	private JLabel lblLower;
	private JLabel lblUnit;
	private JTextField lowerField;
	private JTextField upperField;
	private JLabel lblDomain;
	@SuppressWarnings("rawtypes")
	private JComboBox domainCombo;
	private JLabel label;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DimensionEditionPanel(final DiagramManager diagramManager, final ClassElement classElement, RefOntoUML.Classifier element) 
	{	
		this.diagramManager = diagramManager;
		this.classElement = classElement;
		this.dimension = element;
							
		pane = new JPanel();
		pane.setBounds(0, 0, 468, 80);
		pane.setBorder(null);
		
		lblUnit = new JLabel("Unit:");		
		unitField = new JTextField();
		unitField.setColumns(10);		
		lblLower = new JLabel("Lower/Upper Region:");
		
		lowerField = new JTextField();
		lowerField.setColumns(10);
		
		upperField = new JTextField();
		upperField.setColumns(10);
		
		lblDomain = new JLabel("Domain:");
		
		domainCombo = new JComboBox();
		
		label = new JLabel("");
		
		GroupLayout gl_classPropPanel = new GroupLayout(pane);
		gl_classPropPanel.setHorizontalGroup(
			gl_classPropPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_classPropPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_classPropPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblUnit, 0, 0, Short.MAX_VALUE)
						.addComponent(lblDomain, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_classPropPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_classPropPanel.createSequentialGroup()
							.addComponent(unitField, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblLower)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lowerField, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_classPropPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(label)
								.addComponent(upperField, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)))
						.addComponent(domainCombo, 0, 397, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_classPropPanel.setVerticalGroup(
			gl_classPropPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_classPropPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_classPropPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUnit, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(unitField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lowerField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(lblLower)
						.addComponent(upperField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_classPropPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDomain)
						.addComponent(domainCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		
		pane.setLayout(gl_classPropPanel);
		
		OntoUMLParser refparser = Models.getRefparser();							    	
		List<RefOntoUML.PackageableElement> types = new ArrayList<RefOntoUML.PackageableElement>();
		types.addAll(refparser.getAllInstances(RefOntoUML.MeasurementDomain.class));		
		Collections.sort(types);
    	domainCombo.setModel(new DefaultComboBoxModel(types.toArray()));
    	
		setInitialData();
		
		setPreferredSize(new Dimension(468, 80));
		setLayout(null);
		add(pane);
	}
	
	public void setInitialData()
	{
		if (dimension instanceof MeasurementDimension) {
			unitField.setText(((MeasurementDimension)dimension).getUnitOfMeasure());
			domainCombo.setSelectedItem(((MeasurementDimension)dimension).getDomain());
			
			BasicMeasurementRegion upper = ((MeasurementDimension)dimension).getUpperBound();		
			if(upper!=null) {
				if(upper instanceof IntegerMeasurementRegion) {
					String txt = Integer.toString(((IntegerMeasurementRegion)upper).getValue());
					upperField.setText(txt);
				}
				if(upper instanceof DecimalMeasurementRegion) {
					String txt = Double.toString(((DecimalMeasurementRegion)upper).getValue().doubleValue());
					upperField.setText(txt);				
				}
			}
			
			BasicMeasurementRegion lower = ((MeasurementDimension)dimension).getLowerBound();			
			if(lower!=null) {
				if(lower instanceof IntegerMeasurementRegion) {
					String txt = Integer.toString(((IntegerMeasurementRegion)lower).getValue());				
					lowerField.setText(txt);
				}
				if(lower instanceof DecimalMeasurementRegion) {
					String txt = Double.toString(((DecimalMeasurementRegion)lower).getValue().doubleValue());
					lowerField.setText(txt);				
				}
			}
		}
	}
		
	public void selectUnitText()
	{
		unitField.selectAll();
	}
	
	public void transferUpperRegion(){
		if(dimension instanceof IntegerOrdinalDimensionImpl || dimension instanceof IntegerRationalDimensionImpl || dimension instanceof IntegerIntervalDimensionImpl){
			IntegerMeasurementRegion upper = new IntegerMeasurementRegionImpl();
			try{ 
				int value = Integer.parseInt(upperField.getText()); 
				upper.setValue(value);
				((MeasurementDimension)dimension).setUpperBound(upper);				
			} catch(NumberFormatException e){ 
				System.err.println(e.getLocalizedMessage());
			}							
		}
		if(dimension instanceof DecimalOrdinalDimensionImpl || dimension instanceof DecimalRationalDimensionImpl || dimension instanceof DecimalIntervalDimensionImpl){
			DecimalMeasurementRegion upper = new DecimalMeasurementRegionImpl();
			try{ 
				double value = Double.parseDouble(upperField.getText()); 
				upper.setValue(new BigDecimal(value));
				((MeasurementDimension)dimension).setUpperBound(upper);				
			} catch(NumberFormatException e){ 
				System.err.println(e.getLocalizedMessage());
			}							
		}			
	}
	
	public void transferLowerRegion(){
		if(dimension instanceof IntegerOrdinalDimensionImpl || dimension instanceof IntegerRationalDimensionImpl || dimension instanceof IntegerIntervalDimensionImpl){
			IntegerMeasurementRegion lower = new IntegerMeasurementRegionImpl();
			try{ 
				int value = Integer.parseInt(lowerField.getText()); 
				lower.setValue(value);
				((MeasurementDimension)dimension).setLowerBound(lower);
			} catch(NumberFormatException e){ 
				System.err.println(e.getLocalizedMessage());
			}							
		}
		if(dimension instanceof DecimalOrdinalDimensionImpl || dimension instanceof DecimalRationalDimensionImpl || dimension instanceof DecimalIntervalDimensionImpl){
			DecimalMeasurementRegion lower = new DecimalMeasurementRegionImpl();
			try{ 
				double value = Double.parseDouble(lowerField.getText()); 
				lower.setValue(new BigDecimal(value));
				((MeasurementDimension)dimension).setLowerBound(lower);
			} catch(NumberFormatException e){ 
				System.err.println(e.getLocalizedMessage());
			}							
		}			
	}
	
	public void transferDimensionData()
	{
		if (dimension instanceof MeasurementDimension) {
			((MeasurementDimension)dimension).setUnitOfMeasure(unitField.getText());
			((MeasurementDimension)dimension).setDomain((MeasurementDomain)domainCombo.getSelectedItem());
			transferUpperRegion();		
			transferLowerRegion();
		}
		
		diagramManager.updateMenthorFromModification(dimension,false);	
	}
}
