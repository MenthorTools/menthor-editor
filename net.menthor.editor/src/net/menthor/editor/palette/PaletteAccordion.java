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
import net.menthor.resources.icons.IconMap;
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
	private static Color selectedPaletteBackground = UIManager.getColor("Panel.background");//ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY);

	private static Border unselectedPaletteBorder = UIManager.getBorder("Panel.border"); //new LineBorder(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY), 1, true);
	private static Color unselectedPaletteBackground = UIManager.getColor("Panel.background"); //ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY);

	private PaletteGrouping ontopatternPalette;

	private PaletteGrouping derivedPalette;

	private PaletteGrouping elementsPalette;

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
		createStaticClassesPalette(editorDispatcher);		
		createOntoUMLPatternsPalette(editorDispatcher);
		createPatternsPalette(editorDispatcher);		
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
				topTitles.add(paletteMap.get(item).getTitle());
				topTitles.add(Box.createRigidArea(new Dimension(0,1)));
			}
			else
			{
				paletteMap.get(item).setUnselectedLayout();
				bottomTitles.add(paletteMap.get(item).getTitle());
				bottomTitles.add(Box.createRigidArea(new Dimension(0,1)));
			}
			if(item == openPalette)
			{
				found = true;
				openContent.add(paletteMap.get(item).getContent(), BorderLayout.CENTER);				
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
		return paletteMap.get("Elements");
	}

	public PaletteGrouping getDerivationPatternsPalette()
	{
		return paletteMap.get("Derived Patterns");
	}
	
	public PaletteGrouping getPatternsPalette()
	{
		return paletteMap.get("Patterns");
	}
	
	public Map<String, PaletteGrouping> getPaletteMap() {
		return paletteMap;
	}
	
	private void createOntoUMLPatternsPalette(AppCommandDispatcher editorDispatcher) 
	{
		String pelleteName = "Patterns";
		ontopatternPalette = new PaletteGrouping(this, pelleteName);
		
		ontopatternPalette.createPaletteElement("staticpalette.pattern", "completer");
		ontopatternPalette.createPaletteElement("staticpalette.pattern", "mixinpattern");
		ontopatternPalette.createPaletteElement("staticpalette.pattern", "mixinpatternwithsubkind");
		ontopatternPalette.createPaletteElement("staticpalette.pattern", "phasepartition");
		ontopatternPalette.createPaletteElement("staticpalette.pattern", "subkindpartition");
		ontopatternPalette.createPaletteElement("staticpalette.pattern", "phasepartition");
		ontopatternPalette.createPaletteElement("staticpalette.pattern", "rolepartition");
		ontopatternPalette.createPaletteElement("staticpalette.pattern", "rolemixinpattern");
		ontopatternPalette.createPaletteElement("staticpalette.pattern", "relatorpattern");
		ontopatternPalette.createPaletteElement("staticpalette.pattern", "dependentrolemixinpattern");
		ontopatternPalette.createPaletteElement("staticpalette.pattern", "genericrelatorpattern");
		ontopatternPalette.createPaletteElement("staticpalette.pattern", "characterizationpattern");
		ontopatternPalette.createPaletteElement("staticpalette.pattern", "rigidweaksupplementation");
		ontopatternPalette.createPaletteElement("staticpalette.pattern", "antirigidweaksupplementation");
		ontopatternPalette.createPaletteElement("staticpalette.pattern", "kindpartition");
		ontopatternPalette.createPaletteElement("staticpalette.pattern", "quantitypartition");
		ontopatternPalette.createPaletteElement("staticpalette.pattern", "collectivepartition");
		ontopatternPalette.createPaletteElement("staticpalette.pattern", "categorypattern");
		
		ontopatternPalette.addCommandListener(editorDispatcher);
		
		paletteMap.put(pelleteName, ontopatternPalette);
		
		if(openPalette == null)
			openPalette = pelleteName;	

		ontopatternPalette.sort();
	}
	
	
	private void createPatternsPalette(AppCommandDispatcher editorDispatcher)
	{
		derivedPalette = new PaletteGrouping(this, "Derived Patterns");
		
		//palette.addSpacer(0,PALLETE_VSPACE);
		derivedPalette.createPaletteElement("staticpalette.patterns", "derivationbyunion");
		derivedPalette.createPaletteElement("staticpalette.patterns2", "derivationbyexclusion");
		derivedPalette.createPaletteElement("staticpalette.patterns3", "derivationbyintersection");
		derivedPalette.createPaletteElement("staticpalette.patterns4", "derivationbyspecialization");
		derivedPalette.createPaletteElement("staticpalette.patterns5", "derivationbypastspecialization");
		derivedPalette.createPaletteElement("staticpalette.patterns6", "derivationbyparticipation");
		
		derivedPalette.addCommandListener(editorDispatcher);
		
		paletteMap.put("Derived Patterns", derivedPalette);

		if(openPalette == null)
			openPalette = "Derived Patterns";
		
		derivedPalette.sort();
	}
	
	private void createStaticClassesPalette(AppCommandDispatcher editorDispatcher)
	{
		elementsPalette = new PaletteGrouping(this, "Elements");
		
		//palette.addSpacer(0,PALLETE_VSPACE);
		elementsPalette.createPaletteElement("staticpalette.classes", "kind");
		elementsPalette.createPaletteElement("staticpalette.classes", "quantity");
		elementsPalette.createPaletteElement("staticpalette.classes", "collective");
		elementsPalette.createPaletteElement("staticpalette.classes", "subkind");
		//palette.addSpacer(0,PALLETE_VSPACE);
		elementsPalette.createPaletteElement("staticpalette.classes", "phase");
		elementsPalette.createPaletteElement("staticpalette.classes", "role");
		//palette.addSpacer(0,PALLETE_VSPACE);
		elementsPalette.createPaletteElement("staticpalette.classes", "category");
		elementsPalette.createPaletteElement("staticpalette.classes", "rolemixin");
		elementsPalette.createPaletteElement("staticpalette.classes", "mixin");
		//palette.addSpacer(0,PALLETE_VSPACE);
		elementsPalette.createPaletteElement("staticpalette.classes", "mode");
		elementsPalette.createPaletteElement("staticpalette.classes", "relator");
		//palette.addSpacer(0,PALLETE_VSPACE);
		elementsPalette.createPaletteElement("staticpalette.classes", "datatype");
		elementsPalette.createPaletteElement("staticpalette.classes", "enumeration");
		elementsPalette.createPaletteElement("staticpalette.classes", "primitivetype");
		elementsPalette.createPaletteElement("staticpalette.classes", "perceivablequality");
		elementsPalette.createPaletteElement("staticpalette.classes", "nonperceivablequality");
		elementsPalette.createPaletteElement("staticpalette.classes", "nominalquality");
		
		elementsPalette.createPaletteElement("staticpalette.relations", "generalization");
		//palette.addSpacer(0,PALLETE_VSPACE);
		elementsPalette.createPaletteElement("staticpalette.relations", "material");
		elementsPalette.createPaletteElement("staticpalette.relations", "formal");
		//palette.addSpacer(0,PALLETE_VSPACE);
		elementsPalette.createPaletteElement("staticpalette.relations", "characterization");
		elementsPalette.createPaletteElement("staticpalette.relations", "mediation");
		elementsPalette.createPaletteElement("staticpalette.relations", "derivation");
		//palette.addSpacer(0,PALLETE_VSPACE);
		elementsPalette.createPaletteElement("staticpalette.relations", "componentof");
		elementsPalette.createPaletteElement("staticpalette.relations", "memberof");	
		elementsPalette.createPaletteElement("staticpalette.relations", "subcollectionof");
		elementsPalette.createPaletteElement("staticpalette.relations", "subquantityof");
		//palette.addSpacer(0,PALLETE_VSPACE);
		elementsPalette.createPaletteElement("staticpalette.relations", "structuration");
		elementsPalette.createPaletteElement("staticpalette.relations", "association");
		
//		elementsPalette.addSpacer(0,PALLETE_VSPACE);
//		elementsPalette.addSpacer(0,PALLETE_VSPACE);
//		elementsPalette.addSpacer(0,PALLETE_VSPACE);
//		elementsPalette.addSpacer(0,PALLETE_VSPACE);
//		elementsPalette.createElement("", "");
		
		elementsPalette.addCommandListener(editorDispatcher);
		
		paletteMap.put("Elements", elementsPalette);

		if(openPalette == null)
			openPalette = "Elements";	
		
		elementsPalette.sort();
	}

	public PaletteGrouping createDomainPalette(UmlProject patternProject,HashMap<PaletteItem, StructureDiagram> dynamicHash, AppCommandDispatcher dispatcher){
		Icon icon = IconMap.getInstance().getIcon("PATTERN");
		
		String pelleteName = "Domain Patterns";
		PaletteGrouping domainPallete = new PaletteGrouping(this, pelleteName);
		
		for(UmlDiagram umlDiagram: patternProject.getDiagrams()){
			StructureDiagram diagram =  (StructureDiagram)umlDiagram;
				PaletteItem paletteElement = domainPallete.createStaticElement(icon, diagram.getName(), "");
				dynamicHash.put(paletteElement, diagram);
		}
		
		domainPallete.addCommandListener(dispatcher);
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
		palette.createPaletteElement("staticpalette.relations", "select");
		palette.addSpacer(0,PALLETE_VSPACE);
		palette.createPaletteElement("staticpalette.relations", "generalization");
		palette.addSpacer(0,PALLETE_VSPACE);
		palette.createPaletteElement("staticpalette.relations", "material");
		palette.createPaletteElement("staticpalette.relations", "formal");
		palette.addSpacer(0,PALLETE_VSPACE);
		palette.createPaletteElement("staticpalette.relations", "characterization");
		palette.createPaletteElement("staticpalette.relations", "mediation");
		palette.createPaletteElement("staticpalette.relations", "derivation");
		palette.addSpacer(0,PALLETE_VSPACE);
		palette.createPaletteElement("staticpalette.relations", "componentof");
		palette.createPaletteElement("staticpalette.relations", "memberof");	
		palette.createPaletteElement("staticpalette.relations", "subcollectionof");
		palette.createPaletteElement("staticpalette.relations", "subquantityof");
		palette.addSpacer(0,PALLETE_VSPACE);
		palette.createPaletteElement("staticpalette.relations", "association");
		
		palette.addCommandListener(editorDispatcher);

		paletteMap.put("Relationships", palette);

		if(openPalette == null)
			openPalette = "Relationships";
	}

	@SuppressWarnings("unused")
	private void createMiscellaneousPalette(AppCommandDispatcher editorDispatcher)
	{
		PaletteGrouping palette =  new PaletteGrouping(this, "Miscellaneous");
		palette.createPaletteElement("staticpalette.misc", "select");
		palette.createPaletteElement("staticpalette.misc", "package");
		palette.createPaletteElement("staticpalette.misc", "note");
		palette.createPaletteElement("staticpalette.misc", "noteconnector");
		
		palette.addCommandListener(editorDispatcher);

		paletteMap.put("Miscellaneous", palette);

		if(openPalette == null)
			openPalette = "Miscellaneous";
	}
	
	@SuppressWarnings("unused")
	private void createStaticRulesPalette(AppCommandDispatcher editorDispatcher)
	{
		PaletteGrouping palette =  new PaletteGrouping(this, "Rules");
		palette.createPaletteElement("staticpalette.rules", "select");
		palette.createPaletteElement("staticpalette.rules", "condition");
		palette.createPaletteElement("staticpalette.rules", "derivationrule");
		palette.createPaletteElement("staticpalette.rules", "conclusion");
		
		palette.addCommandListener(editorDispatcher);

		paletteMap.put("Rules", palette);

		if(openPalette == null)
			openPalette = "Rules";
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
