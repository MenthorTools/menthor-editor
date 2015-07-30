package net.menthor.editor.palette;

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
import java.awt.Component;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import org.tinyuml.ui.commands.AppCommandDispatcher;
import org.tinyuml.umldraw.StructureDiagram;

import net.menthor.editor.AppFrame;
import net.menthor.editor.model.UmlDiagram;
import net.menthor.editor.model.UmlProject;
import net.menthor.resources.icons.ColorMap;
import net.menthor.resources.icons.ColorType;
import net.menthor.resources.icons.CommandType;
import net.menthor.resources.icons.IconMap;
import net.menthor.resources.icons.IconType;
import net.menthor.resources.icons.PaletteItem;

/**
 * This class provides an accordion pane for accomodating the many allElements 
 * used by the editor.
 */
public class PaletteAccordion extends JPanel{

	private static final long serialVersionUID = 8265628368514182832L;

	private AppFrame frame;
	private Map<String, PaletteGrouping> paletteMap = new LinkedHashMap<String, PaletteGrouping>();
	private String openPalette = null;
	private JPanel openContent = null;

	private JPanel topTitles;
	private JPanel bottomTitles;

	private static int PALLETE_VSPACE = 20;
	private static Border resetBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
	private static Color resetBackground = Color.WHITE;
	private static Color resetForeground = Color.BLACK;
	
	private static Border selectedItemBorder = new LineBorder(ColorMap.getInstance().getColor(ColorType.MENTHOR_ORANGE), 1, true);
	private static Color selectedItemBackground = ColorMap.getInstance().getColor(ColorType.MENTHOR_ORANGE);
	private static Color selectedItemForeground = Color.WHITE;
	
	private static Border hoverItemBorder = new LineBorder(ColorMap.getInstance().getColor(ColorType.MENTHOR_BLUE_DARK), 1, true);
	private static Color hoverItemBackground = ColorMap.getInstance().getColor(ColorType.MENTHOR_BLUE_LIGHT);

	private static Border selectedPaletteBorder = UIManager.getBorder("Panel.border"); //new LineBorder(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY), 1, true);
	private static Color selectedPaletteBackground = UIManager.getColor("Panel.background");//ColorMap.getInstance().getColor(ColorType.MENTHOR_GREY_MEDIUM);

	private static Border unselectedPaletteBorder = UIManager.getBorder("Panel.border"); //new LineBorder(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY), 1, true);
	private static Color unselectedPaletteBackground = UIManager.getColor("Panel.background"); //ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY);

	private PaletteGrouping patternGrouping;
	private PaletteGrouping derivedGrouping;
	private PaletteGrouping classGrouping;
	private PaletteGrouping relationshipGrouping;
	private PaletteGrouping datatypeGrouping;
	
	private JScrollPane openContentScroll;
		
	public AppFrame getFrame()
	{
		return frame;
	}
	public PaletteAccordion(AppFrame frame) {

		super();
		this.frame = frame;
		
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

	public void createStaticStructurePalettes(AppCommandDispatcher editorDispatcher)
	{
		createClassesGrouping();
		createDataTypesGrouping();
		createRelationshipsGrouping();
		createPatternGrouping();
		createDerivedGrouping();		
		render();
	}
	
	public void render()
	{
		boolean found = false;

		topTitles.removeAll();
		bottomTitles.removeAll();
		openContent.removeAll();

		for (String item : paletteMap.keySet()) {
			if(!found)
			{
				paletteMap.get(item).setUnselectedLayout();
				topTitles.add(paletteMap.get(item).getTitlePane());
				topTitles.add(Box.createRigidArea(new Dimension(0,1)));
			}
			else
			{
				paletteMap.get(item).setUnselectedLayout();
				bottomTitles.add(paletteMap.get(item).getTitlePane());
				bottomTitles.add(Box.createRigidArea(new Dimension(0,1)));
			}
			if(item == openPalette)
			{
				found = true;
				openContent.add(paletteMap.get(item).getContentPane(), BorderLayout.CENTER);				
				paletteMap.get(item).setSelectedLayout();
			}			
		}

		this.validate();
	}

	public void setOpenPalette(String name)
	{
		if(openPalette != name)
		{
			openPalette = name;
			render();
			openContentScroll.getVerticalScrollBar().setValue(0);
		}
	}
	
	public PaletteGrouping getOpenPalette()
	{
		return paletteMap.get(openPalette);
	}
	
	public PaletteGrouping getElementsPalette()
	{
		return paletteMap.get("Class");
	}

	public PaletteGrouping getDerivationPatternsPalette()
	{
		return paletteMap.get("Derived Pattern");
	}

	public PaletteGrouping getRelationshipPalette()
	{
		return paletteMap.get("Relationship");
	}
	
	public PaletteGrouping getDataTypePalette()
	{
		return paletteMap.get("DataType");
	}
	
	public PaletteGrouping getPatternsPalette()
	{
		return paletteMap.get("Pattern");
	}
	
	public Map<String, PaletteGrouping> getPaletteMap() {
		return paletteMap;
	}
	
	private void createPatternGrouping() 
	{
		String paletteName = "Pattern";
		patternGrouping = new PaletteGrouping(this,paletteName);
		
		patternGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PATTERN), 
			"Completer",
			CommandType.CALL_COMPLETER_PATTERN,
			""
		);
		patternGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PATTERN), 
			"Mixin",
			CommandType.CALL_MIXIN_PATTERN,
			""
		);
		patternGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PATTERN), 
			"Mixin With Subkind",
			CommandType.CALL_MIXIN_WITH_SUBKIND_PATTERN,
			""
		);
		patternGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PATTERN), 
			"Phase Partition",
			CommandType.CALL_PHASE_PARTITION_PATTERN,
			""
		);		
		patternGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PATTERN), 
			"SubKind Partition",
			CommandType.CALL_SUBKIND_PARTITION_PATTERN,
			""
		);
		patternGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PATTERN), 
			"Role Partition",
			CommandType.CALL_ROLE_PARTITION_PATTERN,
			""
		);
		patternGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PATTERN), 
			"RoleMixin",
			CommandType.CALL_ROLEMIXIN_PATTERN,
			""
		);
		patternGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PATTERN), 
			"Relator",
			CommandType.CALL_RELATOR_PATTERN,
			""
		);
		patternGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PATTERN), 
			"Dependent Role Mixin",
			CommandType.CALL_DEPENDENT_ROLEMIXIN_PATTERN,
			""
		);
		patternGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PATTERN), 
			"Generic Relator",
			CommandType.CALL_GENERIC_RELATOR_PATTERN,
			""
		);
		patternGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PATTERN), 
			"Characterization",
			CommandType.CALL_CHARACTERIZATION_PATTERN,
			""
		);
		patternGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PATTERN), 
			"Rigid Weak Supplementation",
			CommandType.CALL_RIGID_WS_PATTERN,
			""
		);
		patternGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PATTERN), 
			"AntiRigid Weak Supplementation",
			CommandType.CALL_ANTIRIGID_WS_PATTERN,
			""
		);
		patternGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PATTERN), 
			"AntiRigid Weak Supplementation",
			CommandType.CALL_ANTIRIGID_WS_PATTERN,
			""
		);
		patternGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PATTERN), 
			"Kind Partition",
			CommandType.CALL_KIND_PARTITION_PATTERN,
			""
		);
		patternGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PATTERN), 
			"Collective Partition",
			CommandType.CALL_COLLECTIVE_PARTITION_PATTERN,
			""
		);
		patternGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PATTERN), 
			"Quantity Partition",
			CommandType.CALL_QUANTITY_PARTITION_PATTERN,
			""
		);
		patternGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PATTERN), 
			"Category",
			CommandType.CALL_CATEGORY_PATTERN,
			""
		);		
		patternGrouping.addCommandListener(frame);		
		paletteMap.put(paletteName, patternGrouping);		
		if(openPalette == null) openPalette = paletteName;
		patternGrouping.sort();
	}
	
	private void createDerivedGrouping()
	{
		String paletteName = "Derived Pattern";
		derivedGrouping = new PaletteGrouping(this, paletteName);
		derivedGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PATTERN), 
			"Union",
			CommandType.CALL_UNION_PATTERN,
			""
		);
		derivedGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PATTERN), 
			"Exclusion",
			CommandType.CALL_EXCLUSION_PATTERN,
			""
		);
		derivedGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PATTERN), 
			"Intersection",
			CommandType.CALL_INTERSECTION_PATTERN,
			""
		);
		derivedGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PATTERN), 
			"Specialization",
			CommandType.CALL_SPECIALIZATION_PATTERN,
			""
		);
		derivedGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PATTERN), 
			"Past Specialization",
			CommandType.CALL_PASTSPECIALIZATION_PATTERN,
			""
		);
		derivedGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PATTERN), 
			"Participation",
			CommandType.CALL_PARTICIPATION_PATTERN,
			""
		);		
		derivedGrouping.addCommandListener(frame);		
		paletteMap.put(paletteName, derivedGrouping);
		if(openPalette == null) openPalette = paletteName;		
		derivedGrouping.sort();
	}
	
	private void createDataTypesGrouping()
	{
		String paletteName = "DataType";
		datatypeGrouping = new PaletteGrouping(this, paletteName);
		datatypeGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_CLASS), 
			"DataType",
			CommandType.CREATE_DATATYPE,
			""
		);
		datatypeGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_CLASS), 
			"Enumeration",
			CommandType.CREATE_ENUMERATION,
			""
		);
		datatypeGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_CLASS), 
			"Primitive Type",
			CommandType.CREATE_PRIMITIVETYPE,
			""
		);
		datatypeGrouping.addCommandListener(frame);		
		paletteMap.put(paletteName, datatypeGrouping);
		if(openPalette == null) openPalette = paletteName;		
		datatypeGrouping.sort();
	}
	
	private void createRelationshipsGrouping()
	{
		String paletteName = "Relationship";
		relationshipGrouping = new PaletteGrouping(this, paletteName);
		relationshipGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_GEN_WHITE), 
			"Generalization",
			CommandType.CREATE_GENERALIZATION,
			""
		);
		relationshipGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_LINE), 
			"Material",
			CommandType.CREATE_MATERIAL,
			""
		);
		relationshipGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_LINE), 
			"Formal",
			CommandType.CREATE_FORMAL,
			""
		);
		relationshipGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_LINE), 
			"Characterization",
			CommandType.CREATE_CHARACTERIZATION,
			""
		);
		relationshipGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_LINE), 
			"Mediation",
			CommandType.CREATE_MEDIATION,
			""
		);
		relationshipGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_DERIVATION), 
			"Derivation",
			CommandType.CREATE_DERIVATION,
			""
		);
		relationshipGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_LINE), 
			"Structuration",
			CommandType.CREATE_STRUCTURATION,
			""
		);
		relationshipGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_LINE), 
			"Association",
			CommandType.CREATE_ASSOCIATION,
			""
		);
		relationshipGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PARTHOOD_BLACK), 
			"ComponentOf",
			CommandType.CREATE_COMPONENTOF,
			""
		);
		relationshipGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PARTHOOD_C), 
			"SubCollectionOf",
			CommandType.CREATE_SUBCOLLECTIONOF,
			""
		);
		relationshipGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PARTHOOD_Q), 
			"SubQuantityOf",
			CommandType.CREATE_SUBQUANTITYOF,
			""
		);
		relationshipGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_PARTHOOD_M), 
			"MemberOf",
			CommandType.CREATE_MEMBEROF,
			""
		);
		relationshipGrouping.addCommandListener(frame);		
		paletteMap.put(paletteName, relationshipGrouping);
		if(openPalette == null) openPalette = paletteName;		
		relationshipGrouping.sort();
	}
	
	
	private void createClassesGrouping()
	{
		String paletteName = "Class";
		classGrouping = new PaletteGrouping(this, paletteName);
		classGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_CLASS), 
			"Kind",
			CommandType.CREATE_KIND,
			""
		);
		classGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_CLASS), 
			"Collective",
			CommandType.CREATE_COLLECTIVE,
			""
		);
		classGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_CLASS), 
			"Quantity",
			CommandType.CREATE_QUANTITY,
			""
		);
		classGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_CLASS), 
			"Relator",
			CommandType.CREATE_RELATOR,
			""
		);
		classGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_CLASS), 
			"Mode",
			CommandType.CREATE_MODE,
			""
		);
		classGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_CLASS), 
			"Role",
			CommandType.CREATE_ROLE,
			""
		);
		classGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_CLASS), 
			"Phase",
			CommandType.CREATE_PHASE,
			""
		);
		classGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_CLASS), 
			"SubKind",
			CommandType.CREATE_SUBKIND,
			""
		);
		classGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_CLASS), 
			"Category",
			CommandType.CREATE_CATEGORY,
			""
		);
		classGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_CLASS), 
			"Mixin",
			CommandType.CREATE_MIXIN,
			""
		);
		classGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_CLASS), 
			"RoleMixin",
			CommandType.CREATE_ROLEMIXIN,
			""
		);
		classGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_CLASS), 
			"Perceivable Quality",
			CommandType.CREATE_PERCEIVABLE_QUALITY,
			""
		);
		classGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_CLASS), 
			"NonPerceivable Quality",
			CommandType.CREATE_NONPERCEIVABLE_QUALITY,
			""
		);
		classGrouping.createPaletteItem(
			IconMap.getInstance().getSmallIcon(IconType.MENTHOR_CLASS), 
			"Nominal Quality",
			CommandType.CREATE_NOMINAL_QUALITY,
			""
		);
		classGrouping.addCommandListener(frame);	
		paletteMap.put(paletteName, classGrouping);
		if(openPalette == null) openPalette = paletteName;		
		classGrouping.sort();
	}

	public PaletteGrouping createDomainPalette(UmlProject patternProject,HashMap<PaletteItem, StructureDiagram> dynamicHash, AppCommandDispatcher dispatcher){
		Icon icon = IconMap.getInstance().getIcon("PATTERN");
		
		String pelleteName = "Domain Patterns";
		PaletteGrouping domainPallete = new PaletteGrouping(this, pelleteName);
		
		for(UmlDiagram umlDiagram: patternProject.getDiagrams()){
			StructureDiagram diagram =  (StructureDiagram)umlDiagram;
			
			PaletteItem paletteElement = domainPallete.createPaletteItem(icon, diagram.getName(), CommandType.CALL_DOMAIN_PATTERN,"");
			dynamicHash.put(paletteElement, diagram);
		}
		
//		domainPallete.addCommandListener(dispatcher);
		paletteMap.put(pelleteName, domainPallete);
		
		openPalette = pelleteName;
		
		domainPallete.sort();
		this.render();

		return domainPallete;
	}
	
	@SuppressWarnings("unused")
	private void createStaticRelationshipsPalette(AppCommandDispatcher editorDispatcher)
	{
		PaletteGrouping palette =  new PaletteGrouping(this, "Relationships");
//		palette.createPaletteElement("staticpalette.relations", "select");
//		palette.addSpacer(0,PALLETE_VSPACE);
//		palette.createPaletteElement("staticpalette.relations", "generalization");
//		palette.addSpacer(0,PALLETE_VSPACE);
//		palette.createPaletteElement("staticpalette.relations", "material");
//		palette.createPaletteElement("staticpalette.relations", "formal");
//		palette.addSpacer(0,PALLETE_VSPACE);
//		palette.createPaletteElement("staticpalette.relations", "characterization");
//		palette.createPaletteElement("staticpalette.relations", "mediation");
//		palette.createPaletteElement("staticpalette.relations", "derivation");
//		palette.addSpacer(0,PALLETE_VSPACE);
//		palette.createPaletteElement("staticpalette.relations", "componentof");
//		palette.createPaletteElement("staticpalette.relations", "memberof");	
//		palette.createPaletteElement("staticpalette.relations", "subcollectionof");
//		palette.createPaletteElement("staticpalette.relations", "subquantityof");
//		palette.addSpacer(0,PALLETE_VSPACE);
//		palette.createPaletteElement("staticpalette.relations", "association");
//		
		//palette.addCommandListener(editorDispatcher);

		paletteMap.put("Relationships", palette);

		if(openPalette == null)
			openPalette = "Relationships";
	}

	public void NotifySelection(PaletteItem item) {
		for (PaletteGrouping palette : paletteMap.values()) {
			palette.unselectAllBut(item);
		}
	}

	public static Border getResetBorder() {
		return resetBorder;
	}

	public static Color getResetBackground() {
		return resetBackground;
	}

	public static Color getResetForeground()
	{
		return resetForeground;
	}
	
	public static Border getSelectedItemBorder() {
		return selectedItemBorder;
	}

	public static Color getSelectedItemBackground() {
		return selectedItemBackground;
	}

	public static Border getHoverItemBorder() {
		return hoverItemBorder;
	}

	public static Color getHoverItemBackground() {
		return hoverItemBackground;
	}

	public static Border getSelectedPaletteBorder() {
		return selectedPaletteBorder;
	}

	public static Color getSelectedItemForeground()
	{
		return selectedItemForeground;
	}
	
	public static Color getSelectedPaletteBackground() {
		return selectedPaletteBackground;
	}

	public static Border getUnselectedPaletteBorder() {
		return unselectedPaletteBorder;
	}

	public static Color getUnselectedPaletteBackground() {
		return unselectedPaletteBackground;
	}

	public static Component getSpacer(int width, int height) {
		return Box.createRigidArea(new Dimension(width, height));
	}	
}
