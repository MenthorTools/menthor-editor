package net.menthor.editor.v2.ui.palette;

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
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import RefOntoUML.stereotypes.ClassStereotype;
import RefOntoUML.stereotypes.DataTypeStereotype;
import RefOntoUML.stereotypes.RelationshipStereotype;
import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.ui.icon.IconType;

/**
 * This class provides an accordion pane for accomodating the many allElements 
 * used by the editor.
 */
public class PaletteAccordion extends JPanel{

	private static final long serialVersionUID = 8265628368514182832L;

	/** Listen to a command */
	private ICommandListener listener;
	public ICommandListener getCommanListener() { return listener; }
	
	private static Map<String, PaletteGrouping> paletteMap = new LinkedHashMap<String, PaletteGrouping>();
	public Map<String, PaletteGrouping> getPaletteGMap() { return paletteMap; }
	
	private String openPalette;
	public PaletteGrouping getOpenPalette() { return paletteMap.get(openPalette); }
	
	private JPanel openContent;
	private JScrollPane openContentScroll;	
	private JPanel topTitles;
	private JPanel bottomTitles;
	
	/** Handles the selection of the item and then Handles the command to be executed */ 
	public void notifySelection(PaletteItem item) {
		for (PaletteGrouping palette : paletteMap.values()) {
			palette.unselectAllBut(item);
		}		
		listener.handleCommand(item.getCommand().toString(), null);		
	}
	
	/** Constructor */
	public PaletteAccordion(ICommandListener listener){
		super();
		this.listener = listener;		
		this.setLayout(new BorderLayout());		
		this.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));		
		topTitles = new JPanel();
		bottomTitles = new JPanel();
		openContent = new JPanel();
		openContentScroll = new JScrollPane();
		openContentScroll.setViewportView(openContent);
		openContentScroll.setBorder(null);		
		topTitles.setLayout(new BoxLayout(topTitles, BoxLayout.Y_AXIS));
		topTitles.setBackground(Color.WHITE);
		bottomTitles.setLayout(new BoxLayout(bottomTitles, BoxLayout.Y_AXIS));
		bottomTitles.setBackground(Color.WHITE);
		openContent.setLayout(new BorderLayout());
		openContent.setBackground(Color.WHITE);		
		this.add(topTitles, BorderLayout.NORTH);
		this.add(bottomTitles, BorderLayout.SOUTH);
		this.add(openContentScroll, BorderLayout.CENTER);
	}

	/** Automatically create all groupings */
	public void createGroupings()
	{
		createClassesGrouping();
		createDataTypesGrouping();
		createRelationshipsGrouping();	
		render();
	}
	
	/** Renders each palette's grouping in the accordion */
	public void render() {
		boolean found = false;
		topTitles.removeAll();
		bottomTitles.removeAll();
		openContent.removeAll();
		for (String item : paletteMap.keySet()) {
			if(!found){
				paletteMap.get(item).setUnselectedLayout();
				topTitles.add(paletteMap.get(item).getTitlePane());
				topTitles.add(Box.createRigidArea(new Dimension(0,1)));
			}else{
				paletteMap.get(item).setUnselectedLayout();
				bottomTitles.add(paletteMap.get(item).getTitlePane());
				bottomTitles.add(Box.createRigidArea(new Dimension(0,1)));
			}
			if(item == openPalette){
				found = true;
				openContent.add(paletteMap.get(item).getContentPane(), BorderLayout.CENTER);				
				paletteMap.get(item).setSelectedLayout();
			}			
		}
		this.validate();
	}

	/** Opens palette with that given name */
	public void openPalette(String name) {
		if(openPalette != name) {
			openPalette = name;
			render();
			openContentScroll.getVerticalScrollBar().setValue(0);
		}
	}
		
	public PaletteGrouping getClassPalette() { return paletteMap.get("Class"); }
	public PaletteGrouping getPatternPalette() { return paletteMap.get("Pattern"); }	
	public PaletteGrouping getDerivationPatternsPalette() { return paletteMap.get("Derived Pattern"); }
	public PaletteGrouping getRelationshipPalette() { return paletteMap.get("Relationship"); }	
	public PaletteGrouping getDataTypePalette() { return paletteMap.get("DataType"); }
	
	private PaletteGrouping createDataTypesGrouping() {
		String paletteName = "DataType";
		PaletteGrouping datatypeGrouping = new PaletteGrouping(this, paletteName);
		datatypeGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			DataTypeStereotype.DATATYPE.toString(),
			CommandType.PALLETE_DATATYPE
		);
		datatypeGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			DataTypeStereotype.ENUMERATION.toString(),
			CommandType.PALLETE_ENUMERATION
		);
		datatypeGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			DataTypeStereotype.PRIMITIVETYPE.toString(),
			CommandType.PALLETE_PRIMITIVETYPE
		);
		datatypeGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			DataTypeStereotype.MEASUREMENT_DOMAIN.toString(),
			CommandType.PALLETE_MEASUREMENT_DOMAIN
		);
		datatypeGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			DataTypeStereotype.STRINGNOMINAL_STRUCTURE.toString(),
			CommandType.PALLETE_STRINGNOMINAL_STRUCTURE
		);
		datatypeGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			DataTypeStereotype.INTEGERINTERVAL_DIMENSION.toString(),
			CommandType.PALLETE_INTEGERINTERVAL_DIMENSION
		);
		datatypeGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			DataTypeStereotype.INTEGERRATIONAL_DIMENSION.toString(),
			CommandType.PALLETE_INTEGERRATIONAL_DIMENSION
		);
		datatypeGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			DataTypeStereotype.INTEGERORDINAL_DIMENSION.toString(),
			CommandType.PALLETE_INTEGERORDINAL_DIMENSION
		);
		datatypeGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			DataTypeStereotype.DECIMALORDINAL_DIMENSION.toString(),
			CommandType.PALLETE_DECIMALORDINAL_DIMENSION
		);
		datatypeGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			DataTypeStereotype.DECIMALRATIONAL_DIMENSION.toString(),
			CommandType.PALLETE_DECIMALRATIONAL_DIMENSION
		);
		datatypeGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			DataTypeStereotype.DECIMALINTERVAL_DIMENSION.toString(),
			CommandType.PALLETE_DECIMALINTERVAL_DIMENSION
		);
		paletteMap.put(paletteName, datatypeGrouping);
		if(openPalette == null) openPalette = paletteName;		
		datatypeGrouping.sort();
		return datatypeGrouping;
	}
	
	private PaletteGrouping createRelationshipsGrouping() {
		String paletteName = "Relationship";
		PaletteGrouping relationshipGrouping = new PaletteGrouping(this, paletteName);
		relationshipGrouping.createPaletteItem(
			IconType.MENTHOR_GENERALIZATION, 
			RelationshipStereotype.GENERALIZATION.toString(),
			CommandType.PALLETE_GENERALIZATION
		);
		relationshipGrouping.createPaletteItem(
			IconType.MENTHOR_ASSOCIATION, 
			RelationshipStereotype.MATERIAL.toString(),
			CommandType.PALLETE_MATERIAL
		);
		relationshipGrouping.createPaletteItem(
			IconType.MENTHOR_ASSOCIATION, 
			RelationshipStereotype.FORMAL.toString(),
			CommandType.PALLETE_FORMAL
		);
		relationshipGrouping.createPaletteItem(
			IconType.MENTHOR_ASSOCIATION, 
			RelationshipStereotype.CHARACTERIZATION.toString(),
			CommandType.PALLETE_CHARACTERIZATION
		);
		relationshipGrouping.createPaletteItem(
			IconType.MENTHOR_ASSOCIATION, 
			RelationshipStereotype.MEDIATION.toString(),
			CommandType.PALLETE_MEDIATION
		);
		relationshipGrouping.createPaletteItem(
			IconType.MENTHOR_DERIVATION, 
			RelationshipStereotype.DERIVATION.toString(),
			CommandType.PALLETE_DERIVATION
		);
		relationshipGrouping.createPaletteItem(
			IconType.MENTHOR_ASSOCIATION, 
			RelationshipStereotype.STRUCTURATION.toString(),
			CommandType.PALLETE_STRUCTURATION
		);
		relationshipGrouping.createPaletteItem(
			IconType.MENTHOR_ASSOCIATION, 
			RelationshipStereotype.ASSOCIATION.toString(),
			CommandType.PALLETE_ASSOCIATION
		);
		relationshipGrouping.createPaletteItem(
			IconType.MENTHOR_COMPONENTOF, 
			RelationshipStereotype.COMPONENTOF.toString(),
			CommandType.PALLETE_COMPONENTOF
		);
		relationshipGrouping.createPaletteItem(
			IconType.MENTHOR_SUBCOLLECTIONOF, 
			RelationshipStereotype.SUBCOLLECTIONOF.toString(),
			CommandType.PALLETE_SUBCOLLECTIONOF
		);
		relationshipGrouping.createPaletteItem(
			IconType.MENTHOR_SUBQUANTITYOF, 
			RelationshipStereotype.SUBQUANTITYOF.toString(),
			CommandType.PALLETE_SUBQUANTITYOF
		);
		relationshipGrouping.createPaletteItem(
			IconType.MENTHOR_MEMBEROF, 
			RelationshipStereotype.MEMBEROF.toString(),
			CommandType.PALLETE_MEMBEROF
		);
		paletteMap.put(paletteName, relationshipGrouping);
		if(openPalette == null) openPalette = paletteName;		
		relationshipGrouping.sort();
		return relationshipGrouping;
	}
	
	
	private PaletteGrouping createClassesGrouping() {
		String paletteName = "Class";
		PaletteGrouping classGrouping = new PaletteGrouping(this, paletteName);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassStereotype.KIND.toString(),
			CommandType.PALLETE_KIND
		);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassStereotype.COLLECTIVE.toString(),
			CommandType.PALLETE_COLLECTIVE
		);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassStereotype.QUANTITY.toString(),
			CommandType.PALLETE_QUANTITY
		);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassStereotype.RELATOR.toString(),
			CommandType.PALLETE_RELATOR
		);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassStereotype.MODE.toString(),
			CommandType.PALLETE_MODE
		);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassStereotype.ROLE.toString(),
			CommandType.PALLETE_ROLE
		);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassStereotype.PHASE.toString(),
			CommandType.PALLETE_PHASE
		);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassStereotype.SUBKIND.toString(),
			CommandType.PALLETE_SUBKIND
		);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassStereotype.CATEGORY.toString(),
			CommandType.PALLETE_CATEGORY
		);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassStereotype.MIXIN.toString(),
			CommandType.PALLETE_MIXIN
		);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassStereotype.ROLEMIXIN.toString(),
			CommandType.PALLETE_ROLEMIXIN
		);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassStereotype.PERCEIVABLE_QUALITY.toString(),
			CommandType.PALLETE_PERCEIVABLE_QUALITY
		);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassStereotype.NONPERCEIVABLE_QUALITY.toString(),
			CommandType.PALLETE_NONPERCEIVABLE_QUALITY
		);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassStereotype.NOMINAL_QUALITY.toString(),
			CommandType.PALLETE_NOMINAL_QUALITY
		);
		paletteMap.put(paletteName, classGrouping);
		if(openPalette == null) openPalette = paletteName;		
		classGrouping.sort();
		return classGrouping;
	}
}
