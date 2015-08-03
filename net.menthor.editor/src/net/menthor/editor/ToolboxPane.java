package net.menthor.editor;

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

import javax.swing.JPanel;

import org.tinyuml.ui.commands.AppCommandDispatcher;

import net.menthor.editor.v2.palette.PaletteAccordion;
import net.menthor.editor.v2.palette.PaletteGrouping;

/**
 * @author John Guerson
 */
public class ToolboxPane extends JPanel {

	private static final long serialVersionUID = 1752050268631906319L;
	@SuppressWarnings("unused")
	private AppFrame frame;
	private AppCommandDispatcher editorDispatcher;
	private PaletteAccordion palettes;	

	public ToolboxPane(AppFrame frame, AppCommandDispatcher editorDispatcher)
	{
		super();
		setBackground(Color.WHITE);
		setMinimumSize(new Dimension(0,0));
		
		this.frame = frame;
		this.editorDispatcher = editorDispatcher;
		
		setFocusable(false);
		setLayout(new BorderLayout(0,0));
		
		palettes = new PaletteAccordion(frame);
		palettes.setBackground(Color.WHITE);
		palettes.createGroupings();
		
		//TitlePane panel = new TitlePane("Toolbox","/resources/icons/x16/hammer_screwdriver.png");	
				
		add(palettes,BorderLayout.CENTER);
		//add(panel,BorderLayout.NORTH);
		
		//addTab("Toolbox", palettes); //TODO Localize these
		//setIconAt(indexOfComponent(palettes),new ImageIcon(DiagramEditorWrapper.class.getResource("/resources/icons/x16/hammer_screwdriver.png")));
		
		//Assistent assistent = new Assistent();
		//Assistent patternsPanel = new Assistent();
		//this.addTab("Assistent", assistent);
		//this.addTab("Patterns", patternsPanel);
	}
	
	public AppCommandDispatcher getEditorDispatcher() {
		return editorDispatcher;
	}
	
	public PaletteGrouping getOpenPalette() {
		return palettes.getOpenPalette();
	}

	public PaletteGrouping getElementsPalette()
	{
		return palettes.getElementsPalette();
	}

	public PaletteGrouping getDerivationPatternsPalette()
	{
		return palettes.getDerivationPatternsPalette();
	}
	
	public PaletteGrouping getPatternsPalette()
	{
		return palettes.getPatternPalette();
	}
	
	public PaletteAccordion getPalleteAccordion()
	{
		return palettes;
	}


}
