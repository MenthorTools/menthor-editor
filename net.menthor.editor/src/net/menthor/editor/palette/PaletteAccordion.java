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
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import org.tinyuml.ui.commands.AppCommandDispatcher;
import org.tinyuml.umldraw.StructureDiagram;

import net.menthor.editor.AppFrame;
import net.menthor.editor.model.UmlDiagram;
import net.menthor.editor.model.UmlProject;
import net.menthor.editor.palette.ColorPalette.ThemeColor;
import net.menthor.resources.icons.IconLoader;

/**
 * This class provides an accordion pane for accomodating the many allElements 
 * used by the editor.
 * 
 * @author Antognoni Albuquerque
 */
public class PaletteAccordion extends JPanel{

	private static final long serialVersionUID = 8265628368514182832L;

	private AppFrame frame;
	private Map<String, Palette> paletteMap = new LinkedHashMap<String, Palette>();
	private String openPalette = null;
	private JPanel openContent = null;

	private JPanel topTitles;
	private JPanel bottomTitles;

	private static int PALLETE_VSPACE = 20;
	private static Border resetBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
	private static Color resetBackground = Color.WHITE;
	private static Color resetForeground = Color.BLACK;
	
	private static Border selectedItemBorder = new LineBorder(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_ORANGE), 1, true);
	private static Color selectedItemBackground = ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_ORANGE);
	private static Color selectedItemForeground = Color.WHITE;
	
	private static Border hoverItemBorder = new LineBorder(ColorPalette.getInstance().getColor(ThemeColor.BLUE_DARK), 1, true);
	private static Color hoverItemBackground = ColorPalette.getInstance().getColor(ThemeColor.BLUE_LIGHT);

	private static Border selectedPaletteBorder = new LineBorder(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY), 1, true);
	private static Color selectedPaletteBackground = ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY);

	private static Border unselectedPaletteBorder = new LineBorder(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY), 1, true);
	private static Color unselectedPaletteBackground = ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY);

	private Palette ontopatternPalette;

	private Palette derivedPalette;

	private Palette elementsPalette;

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
		this.setBackground(Color.WHITE);
		
		topTitles = new JPanel();
		bottomTitles = new JPanel();
		openContent = new JPanel();

		openContentScroll = new JScrollPane();
		openContentScroll.setViewportView(openContent);
		openContentScroll.setBorder(null);
		openContentScroll.setBackground(Color.WHITE);
		
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
	
	public Palette getOpenPalette()
	{
		return paletteMap.get(openPalette);
	}
	
	public Palette getElementsPalette()
	{
		return paletteMap.get("Elements");
	}

	public Palette getDerivationPatternsPalette()
	{
		return paletteMap.get("Derived Patterns");
	}
	
	public Palette getPatternsPalette()
	{
		return paletteMap.get("Patterns");
	}
	
	public Map<String, Palette> getPaletteMap() {
		return paletteMap;
	}
	
	private void createOntoUMLPatternsPalette(AppCommandDispatcher editorDispatcher) 
	{
		String pelleteName = "Patterns";
		ontopatternPalette = new Palette(this, pelleteName);
		
		ontopatternPalette.createElement("staticpalette.pattern", "completer");
		ontopatternPalette.createElement("staticpalette.pattern", "mixinpattern");
		ontopatternPalette.createElement("staticpalette.pattern", "mixinpatternwithsubkind");
		ontopatternPalette.createElement("staticpalette.pattern", "phasepartition");
		ontopatternPalette.createElement("staticpalette.pattern", "subkindpartition");
		ontopatternPalette.createElement("staticpalette.pattern", "phasepartition");
		ontopatternPalette.createElement("staticpalette.pattern", "rolepartition");
		ontopatternPalette.createElement("staticpalette.pattern", "rolemixinpattern");
		ontopatternPalette.createElement("staticpalette.pattern", "relatorpattern");
		ontopatternPalette.createElement("staticpalette.pattern", "dependentrolemixinpattern");
		ontopatternPalette.createElement("staticpalette.pattern", "genericrelatorpattern");
		ontopatternPalette.createElement("staticpalette.pattern", "characterizationpattern");
		ontopatternPalette.createElement("staticpalette.pattern", "rigidweaksupplementation");
		ontopatternPalette.createElement("staticpalette.pattern", "antirigidweaksupplementation");
		ontopatternPalette.createElement("staticpalette.pattern", "kindpartition");
		ontopatternPalette.createElement("staticpalette.pattern", "quantitypartition");
		ontopatternPalette.createElement("staticpalette.pattern", "collectivepartition");
		ontopatternPalette.createElement("staticpalette.pattern", "categorypattern");
		
		ontopatternPalette.addCommandListener(editorDispatcher);
		
		paletteMap.put(pelleteName, ontopatternPalette);
		
		if(openPalette == null)
			openPalette = pelleteName;	

		ontopatternPalette.sort();
	}
	
	
	private void createPatternsPalette(AppCommandDispatcher editorDispatcher)
	{
		derivedPalette = new Palette(this, "Derived Patterns");
		
		//palette.addSpacer(0,PALLETE_VSPACE);
		derivedPalette.createElement("staticpalette.patterns", "derivationbyunion");
		derivedPalette.createElement("staticpalette.patterns2", "derivationbyexclusion");
		derivedPalette.createElement("staticpalette.patterns3", "derivationbyintersection");
		derivedPalette.createElement("staticpalette.patterns4", "derivationbyspecialization");
		derivedPalette.createElement("staticpalette.patterns5", "derivationbypastspecialization");
		derivedPalette.createElement("staticpalette.patterns6", "derivationbyparticipation");
		
		derivedPalette.addCommandListener(editorDispatcher);
		
		paletteMap.put("Derived Patterns", derivedPalette);

		if(openPalette == null)
			openPalette = "Derived Patterns";
		
		derivedPalette.sort();
	}
	
	private void createStaticClassesPalette(AppCommandDispatcher editorDispatcher)
	{
		elementsPalette = new Palette(this, "Elements");
		
		//palette.addSpacer(0,PALLETE_VSPACE);
		elementsPalette.createElement("staticpalette.classes", "kind");
		elementsPalette.createElement("staticpalette.classes", "quantity");
		elementsPalette.createElement("staticpalette.classes", "collective");
		elementsPalette.createElement("staticpalette.classes", "subkind");
		//palette.addSpacer(0,PALLETE_VSPACE);
		elementsPalette.createElement("staticpalette.classes", "phase");
		elementsPalette.createElement("staticpalette.classes", "role");
		//palette.addSpacer(0,PALLETE_VSPACE);
		elementsPalette.createElement("staticpalette.classes", "category");
		elementsPalette.createElement("staticpalette.classes", "rolemixin");
		elementsPalette.createElement("staticpalette.classes", "mixin");
		//palette.addSpacer(0,PALLETE_VSPACE);
		elementsPalette.createElement("staticpalette.classes", "mode");
		elementsPalette.createElement("staticpalette.classes", "relator");
		//palette.addSpacer(0,PALLETE_VSPACE);
		elementsPalette.createElement("staticpalette.classes", "datatype");
		elementsPalette.createElement("staticpalette.classes", "enumeration");
		elementsPalette.createElement("staticpalette.classes", "primitivetype");
		elementsPalette.createElement("staticpalette.classes", "perceivablequality");
		elementsPalette.createElement("staticpalette.classes", "nonperceivablequality");
		elementsPalette.createElement("staticpalette.classes", "nominalquality");
		
		elementsPalette.createElement("staticpalette.relations", "generalization");
		//palette.addSpacer(0,PALLETE_VSPACE);
		elementsPalette.createElement("staticpalette.relations", "material");
		elementsPalette.createElement("staticpalette.relations", "formal");
		//palette.addSpacer(0,PALLETE_VSPACE);
		elementsPalette.createElement("staticpalette.relations", "characterization");
		elementsPalette.createElement("staticpalette.relations", "mediation");
		elementsPalette.createElement("staticpalette.relations", "derivation");
		//palette.addSpacer(0,PALLETE_VSPACE);
		elementsPalette.createElement("staticpalette.relations", "componentof");
		elementsPalette.createElement("staticpalette.relations", "memberof");	
		elementsPalette.createElement("staticpalette.relations", "subcollectionof");
		elementsPalette.createElement("staticpalette.relations", "subquantityof");
		//palette.addSpacer(0,PALLETE_VSPACE);
		elementsPalette.createElement("staticpalette.relations", "structuration");
		elementsPalette.createElement("staticpalette.relations", "association");
		
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

	public Palette createDomainPalette(UmlProject patternProject,HashMap<PaletteElement, StructureDiagram> dynamicHash, AppCommandDispatcher dispatcher){
		Icon icon = IconLoader.getInstance().getIcon("PATTERN");
		
		String pelleteName = "Domain Patterns";
		Palette domainPallete = new Palette(this, pelleteName);
		
		for(UmlDiagram umlDiagram: patternProject.getDiagrams()){
			StructureDiagram diagram =  (StructureDiagram)umlDiagram;
				PaletteElement paletteElement = domainPallete.createStaticElement(icon, diagram.getName(), "");
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
		Palette palette =  new Palette(this, "Relationships");
		palette.createElement("staticpalette.relations", "select");
		palette.addSpacer(0,PALLETE_VSPACE);
		palette.createElement("staticpalette.relations", "generalization");
		palette.addSpacer(0,PALLETE_VSPACE);
		palette.createElement("staticpalette.relations", "material");
		palette.createElement("staticpalette.relations", "formal");
		palette.addSpacer(0,PALLETE_VSPACE);
		palette.createElement("staticpalette.relations", "characterization");
		palette.createElement("staticpalette.relations", "mediation");
		palette.createElement("staticpalette.relations", "derivation");
		palette.addSpacer(0,PALLETE_VSPACE);
		palette.createElement("staticpalette.relations", "componentof");
		palette.createElement("staticpalette.relations", "memberof");	
		palette.createElement("staticpalette.relations", "subcollectionof");
		palette.createElement("staticpalette.relations", "subquantityof");
		palette.addSpacer(0,PALLETE_VSPACE);
		palette.createElement("staticpalette.relations", "association");
		
		palette.addCommandListener(editorDispatcher);

		paletteMap.put("Relationships", palette);

		if(openPalette == null)
			openPalette = "Relationships";
	}

	@SuppressWarnings("unused")
	private void createMiscellaneousPalette(AppCommandDispatcher editorDispatcher)
	{
		Palette palette =  new Palette(this, "Miscellaneous");
		palette.createElement("staticpalette.misc", "select");
		palette.createElement("staticpalette.misc", "package");
		palette.createElement("staticpalette.misc", "note");
		palette.createElement("staticpalette.misc", "noteconnector");
		
		palette.addCommandListener(editorDispatcher);

		paletteMap.put("Miscellaneous", palette);

		if(openPalette == null)
			openPalette = "Miscellaneous";
	}
	
	@SuppressWarnings("unused")
	private void createStaticRulesPalette(AppCommandDispatcher editorDispatcher)
	{
		Palette palette =  new Palette(this, "Rules");
		palette.createElement("staticpalette.rules", "select");
		palette.createElement("staticpalette.rules", "condition");
		palette.createElement("staticpalette.rules", "derivationrule");
		palette.createElement("staticpalette.rules", "conclusion");
		
		palette.addCommandListener(editorDispatcher);

		paletteMap.put("Rules", palette);

		if(openPalette == null)
			openPalette = "Rules";
	}
	
	public void NotifySelection(PaletteElement item) {
		for (Palette palette : paletteMap.values()) {
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
