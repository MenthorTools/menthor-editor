package net.menthor.editor.v2.ui;

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

import javax.swing.border.EmptyBorder;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.ui.palette.PaletteAccordion;
import net.menthor.editor.v2.ui.palette.PaletteGrouping;
import net.menthor.editor.v2.ui.utilities.RoundedPanel;

public class PaletteUI extends RoundedPanel {

	private static final long serialVersionUID = 1752050268631906319L;
	
	// -------- Lazy Initialization

	private static class GUIPaletteLoader {
        private static final PaletteUI INSTANCE = new PaletteUI();
    }	
	public static PaletteUI get() { 
		return GUIPaletteLoader.INSTANCE; 
	}	
    private PaletteUI() {
    	super();
    	palettes = new PaletteAccordion(CommandListener.get());
        if (GUIPaletteLoader.INSTANCE != null) throw new IllegalStateException(this.getClass().getName()+" already instantiated");
        buildUI();
    }		
    
    // ----------------------------
	    
	private PaletteAccordion palettes;	
	
	public void buildUI(){		
		setOpaque(false);
		setBackground(Color.WHITE);
		setMinimumSize(new Dimension(0,0));
		setLayout(new BorderLayout(0,0));
		setBorder(new EmptyBorder(2,2,2,2));		
		setFocusable(false);
		if(palettes!=null){
			palettes.setBackground(Color.WHITE);
			palettes.createGroupings();				
			add(palettes,BorderLayout.CENTER);
		}
	}
	
	public PaletteGrouping getOpenPalette() { return palettes.getOpenPalette(); }
	public PaletteGrouping getClassPalette(){ return palettes.getClassPalette(); }	
	public PaletteGrouping getRelationshipPalette() { return palettes.getRelationshipPalette(); }	
	public PaletteGrouping getDataTypePalette() { return palettes.getDataTypePalette(); }	
	public PaletteGrouping getDerivationPatternsPalette() { return palettes.getDerivationPatternsPalette(); }	
	public PaletteGrouping getPatternsPalette() { return palettes.getPatternPalette(); }	
	public PaletteAccordion getPalleteAccordion() { return palettes; }
}
