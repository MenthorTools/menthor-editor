package net.menthor.editor.v2.palette;

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
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconType;
import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.types.DataType;
import net.menthor.editor.v2.types.DerivedPatternType;
import net.menthor.editor.v2.types.PatternType;
import net.menthor.editor.v2.types.RelationshipType;

/**
 * This class provides an accordion pane for accomodating the many allElements 
 * used by the editor.
 */
public class PaletteAccordion extends JPanel{

	private static final long serialVersionUID = 8265628368514182832L;

	/** Listen to a command */
	private CommandListener listener;
	public CommandListener getCommanListener() { return listener; }
	
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
	public PaletteAccordion(CommandListener listener){
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
		createPatternGrouping();
		createDerivedGrouping();		
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
	
	private PaletteGrouping createDerivedGrouping() {
		String paletteName = "Derived Pattern";
		PaletteGrouping derivedGrouping = new PaletteGrouping(this, paletteName);
		derivedGrouping.createPaletteItem(
			IconType.MENTHOR_PATTERN, 
			DerivedPatternType.UNION.toString(),
			CommandType.TB_DND_UNION_PATTERN
		);
		derivedGrouping.createPaletteItem(
			IconType.MENTHOR_PATTERN, 
			DerivedPatternType.EXCLUSION.toString(),
			CommandType.TB_DND_EXCLUSION_PATTERN
		);
		derivedGrouping.createPaletteItem(
			IconType.MENTHOR_PATTERN, 
			DerivedPatternType.INTERSECTION.toString(),
			CommandType.TB_DND_INTERSECTION_PATTERN
		);
		derivedGrouping.createPaletteItem(
			IconType.MENTHOR_PATTERN, 
			DerivedPatternType.SPECIALIZATION.toString(),
			CommandType.TB_DND_SPECIALIZATION_PATTERN
		);
		derivedGrouping.createPaletteItem(
			IconType.MENTHOR_PATTERN, 
			DerivedPatternType.PASTSPECIALIZATION.toString(),
			CommandType.TB_DND_PASTSPECIALIZATION_PATTERN
		);
		derivedGrouping.createPaletteItem(
			IconType.MENTHOR_PATTERN, 
			DerivedPatternType.PARTICIPATION.toString(),
			CommandType.TB_DND_PARTICIPATION_PATTERN
		);		
		paletteMap.put(paletteName, derivedGrouping);
		if(openPalette == null) openPalette = paletteName;		
		derivedGrouping.sort();
		return derivedGrouping;
	}
	
	private PaletteGrouping createDataTypesGrouping() {
		String paletteName = "DataType";
		PaletteGrouping datatypeGrouping = new PaletteGrouping(this, paletteName);
		datatypeGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			DataType.DATATYPE.toString(),
			CommandType.TB_DND_DATATYPE
		);
		datatypeGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			DataType.ENUMERATION.toString(),
			CommandType.TB_DND_ENUMERATION
		);
		datatypeGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			DataType.PRIMITIVETYPE.toString(),
			CommandType.TB_DND_PRIMITIVETYPE
		);
		paletteMap.put(paletteName, datatypeGrouping);
		if(openPalette == null) openPalette = paletteName;		
		datatypeGrouping.sort();
		return datatypeGrouping;
	}
	
	public PaletteGrouping createPatternGrouping() {
		String name = "Pattern";				
		PaletteGrouping patternGrouping = new PaletteGrouping(this, name);		
		patternGrouping.createPaletteItem(
			IconType.MENTHOR_PATTERN, 
			PatternType.COMPLETER.toString(),
			CommandType.TB_DND_COMPLETER_PATTERN
		);
		patternGrouping.createPaletteItem(
			IconType.MENTHOR_PATTERN, 
			PatternType.MIXIN.toString(),
			CommandType.TB_DND_MIXIN_PATTERN
		);
		patternGrouping.createPaletteItem(
			IconType.MENTHOR_PATTERN, 
			PatternType.MIXIN_WITH_SUBKIND.toString(),
			CommandType.TB_DND_MIXIN_WITH_SUBKIND_PATTERN
		);
		patternGrouping.createPaletteItem(
			IconType.MENTHOR_PATTERN, 
			PatternType.PHASE_PARTITION.toString(),
			CommandType.TB_DND_PHASE_PARTITION_PATTERN
		);		
		patternGrouping.createPaletteItem(
			IconType.MENTHOR_PATTERN, 
			PatternType.SUBKIND_PARTITION.toString(),
			CommandType.TB_DND_SUBKIND_PARTITION_PATTERN
		);
		patternGrouping.createPaletteItem(
			IconType.MENTHOR_PATTERN, 
			PatternType.ROLE_PARTITION.toString(),
			CommandType.TB_DND_ROLE_PARTITION_PATTERN
		);
		patternGrouping.createPaletteItem(
			IconType.MENTHOR_PATTERN, 
			PatternType.ROLEMIXIN.toString(),
			CommandType.TB_DND_ROLEMIXIN_PATTERN
		);
		patternGrouping.createPaletteItem(
			IconType.MENTHOR_PATTERN, 
			PatternType.RELATOR.toString(),
			CommandType.TB_DND_RELATOR_PATTERN
		);
		patternGrouping.createPaletteItem(
			IconType.MENTHOR_PATTERN, 
			PatternType.DEPENDENT_ROLEMIXIN.toString(),
			CommandType.TB_DND_DEPENDENT_ROLEMIXIN_PATTERN
		);
		patternGrouping.createPaletteItem(
			IconType.MENTHOR_PATTERN, 
			PatternType.GENERIC_RELATOR.toString(),
			CommandType.TB_DND_GENERIC_RELATOR_PATTERN
		);
		patternGrouping.createPaletteItem(
			IconType.MENTHOR_PATTERN, 
			PatternType.CHARACTERIZATION.toString(),
			CommandType.TB_DND_CHARACTERIZATION_PATTERN
		);
		patternGrouping.createPaletteItem(
			IconType.MENTHOR_PATTERN, 
			PatternType.RIGID_WEAK_SUPPLEMENTATION.toString(),
			CommandType.TB_DND_RIGID_WS_PATTERN
		);
		patternGrouping.createPaletteItem(
			IconType.MENTHOR_PATTERN, 
			PatternType.ANTIRIGID_WEAK_SUPPLEMENTATION.toString(),
			CommandType.TB_DND_ANTIRIGID_WS_PATTERN
		);		
		patternGrouping.createPaletteItem(
			IconType.MENTHOR_PATTERN, 
			PatternType.KIND_PARTITION.toString(),
			CommandType.TB_DND_KIND_PARTITION_PATTERN
		);
		patternGrouping.createPaletteItem(
			IconType.MENTHOR_PATTERN, 
			PatternType.COLLECTIVE_PARTITION.toString(),
			CommandType.TB_DND_COLLECTIVE_PARTITION_PATTERN
		);
		patternGrouping.createPaletteItem(
			IconType.MENTHOR_PATTERN, 
			PatternType.QUANTITY_PARTITION.toString(),
			CommandType.TB_DND_QUANTITY_PARTITION_PATTERN
		);
		patternGrouping.createPaletteItem(
			IconType.MENTHOR_PATTERN, 
			PatternType.CATEGORY.toString(),
			CommandType.TB_DND_CATEGORY_PATTERN
		);		
		paletteMap.put(name, patternGrouping);
		if(openPalette == null) openPalette = name;
		patternGrouping.sort();
		return patternGrouping;
	}
	
	private PaletteGrouping createRelationshipsGrouping() {
		String paletteName = "Relationship";
		PaletteGrouping relationshipGrouping = new PaletteGrouping(this, paletteName);
		relationshipGrouping.createPaletteItem(
			IconType.MENTHOR_GEN_WHITE, 
			RelationshipType.GENERALIZATION.toString(),
			CommandType.TB_DND_GENERALIZATION
		);
		relationshipGrouping.createPaletteItem(
			IconType.MENTHOR_LINE, 
			RelationshipType.MATERIAL.toString(),
			CommandType.TB_DND_MATERIAL
		);
		relationshipGrouping.createPaletteItem(
			IconType.MENTHOR_LINE, 
			RelationshipType.FORMAL.toString(),
			CommandType.TB_DND_FORMAL
		);
		relationshipGrouping.createPaletteItem(
			IconType.MENTHOR_LINE, 
			RelationshipType.CHARACTERIZATION.toString(),
			CommandType.TB_DND_CHARACTERIZATION
		);
		relationshipGrouping.createPaletteItem(
			IconType.MENTHOR_LINE, 
			RelationshipType.MEDIATION.toString(),
			CommandType.TB_DND_MEDIATION
		);
		relationshipGrouping.createPaletteItem(
			IconType.MENTHOR_DERIVATION, 
			RelationshipType.DERIVATION.toString(),
			CommandType.TB_DND_DERIVATION
		);
		relationshipGrouping.createPaletteItem(
			IconType.MENTHOR_LINE, 
			RelationshipType.STRUCTURATION.toString(),
			CommandType.TB_DND_STRUCTURATION
		);
		relationshipGrouping.createPaletteItem(
			IconType.MENTHOR_LINE, 
			RelationshipType.ASSOCIATION.toString(),
			CommandType.TB_DND_ASSOCIATION
		);
		relationshipGrouping.createPaletteItem(
			IconType.MENTHOR_PARTHOOD_BLACK, 
			RelationshipType.COMPONENTOF.toString(),
			CommandType.TB_DND_COMPONENTOF
		);
		relationshipGrouping.createPaletteItem(
			IconType.MENTHOR_PARTHOOD_C, 
			RelationshipType.SUBCOLLECTIONOF.toString(),
			CommandType.TB_DND_SUBCOLLECTIONOF
		);
		relationshipGrouping.createPaletteItem(
			IconType.MENTHOR_PARTHOOD_Q, 
			RelationshipType.SUBQUANTITYOF.toString(),
			CommandType.TB_DND_SUBQUANTITYOF
		);
		relationshipGrouping.createPaletteItem(
			IconType.MENTHOR_PARTHOOD_M, 
			RelationshipType.MEMBEROF.toString(),
			CommandType.TB_DND_MEMBEROF
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
			ClassType.KIND.toString(),
			CommandType.TB_DND_KIND
		);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassType.COLLECTIVE.toString(),
			CommandType.TB_DND_COLLECTIVE
		);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassType.QUANTITY.toString(),
			CommandType.TB_DND_QUANTITY
		);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassType.RELATOR.toString(),
			CommandType.TB_DND_RELATOR
		);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassType.MODE.toString(),
			CommandType.TB_DND_MODE
		);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassType.ROLE.toString(),
			CommandType.TB_DND_ROLE
		);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassType.PHASE.toString(),
			CommandType.TB_DND_PHASE
		);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassType.SUBKIND.toString(),
			CommandType.TB_DND_SUBKIND
		);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassType.CATEGORY.toString(),
			CommandType.TB_DND_CATEGORY
		);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassType.MIXIN.toString(),
			CommandType.TB_DND_MIXIN
		);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassType.ROLEMIXIN.toString(),
			CommandType.TB_DND_ROLEMIXIN
		);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassType.PERCEIVABLEQUALITY.toString(),
			CommandType.TB_DND_PERCEIVABLE_QUALITY
		);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassType.NONPERCEIVABLEQUALITY.toString(),
			CommandType.TB_DND_NONPERCEIVABLE_QUALITY
		);
		classGrouping.createPaletteItem(
			IconType.MENTHOR_CLASS, 
			ClassType.NOMINALQUALITY.toString(),
			CommandType.TB_DND_NOMINAL_QUALITY
		);
		paletteMap.put(paletteName, classGrouping);
		if(openPalette == null) openPalette = paletteName;		
		classGrouping.sort();
		return classGrouping;
	}

	public PaletteGrouping createDomainGrouping(List<String> itemNamesList){				
		String paletteName = "Domain Pattern";
		PaletteGrouping domainGrouping = new PaletteGrouping(this, paletteName);		
		for(String name: itemNamesList)
		{
			domainGrouping.createPaletteItem(
				IconType.MENTHOR_CLASS,
				name, 
				CommandType.TB_DND_DOMAIN_PATTERN
			);			
		}
		paletteMap.put(paletteName, domainGrouping);
		if(openPalette == null) openPalette = paletteName;		
		domainGrouping.sort();
		this.render();
		return domainGrouping;
	}	
}
