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

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public final class ColorPalette {

	public enum ThemeColor {
		GREEN_LIGHTEST, GREEN_LIGHT, GREEN_MEDIUM, GREEN_DARK,
		GREY_LIGHT, GREY_MEDIUM, GREY_DARK,
		BLUE_LIGHTEST, BLUE_LIGHT, BLUE_MEDIUM, BLUE_DARK,
		MENTHOR_GREY, MENTHOR_GREY_DARK, 
		MENTHOR_ORANGE, MENTHOR_ORANGE_LIGHT, MENTHOR_BROWN, MENTHOR_BROWN_DARK
	}
	
	private static ColorPalette instance = new ColorPalette();
	
	private Map<ThemeColor, Color> colorMap = new HashMap<ThemeColor, Color>();
	
	public static ColorPalette getInstance() { return instance; }
	
	private ColorPalette() {
		//Green tones, as the NEMO theme.
		colorMap.put(ThemeColor.GREEN_LIGHTEST, new Color(0xF2FCAC));
		colorMap.put(ThemeColor.GREEN_LIGHT, new Color(0xCAE70C)); //Alternatives BDEB07 , BFFA37 from STABILO_BOSS
		colorMap.put(ThemeColor.GREEN_MEDIUM, new Color(0xB1D329));
		colorMap.put(ThemeColor.GREEN_DARK, new Color(0x94B053));
				
		//Grey tones, complementary to the green ones.
		colorMap.put(ThemeColor.GREY_LIGHT, new Color(0xE0E0E0));
		colorMap.put(ThemeColor.GREY_MEDIUM, new Color(0xC0C0C0));
		colorMap.put(ThemeColor.GREY_DARK, new Color(0x82837E));
		
		colorMap.put(ThemeColor.BLUE_LIGHTEST, new Color(0xc6dbef));
		colorMap.put(ThemeColor.BLUE_LIGHT, new Color(0x9ecae1));		
		colorMap.put(ThemeColor.BLUE_MEDIUM, new Color(0x6baed6));
		colorMap.put(ThemeColor.BLUE_DARK, new Color(0x2171b5));	
	
		colorMap.put(ThemeColor.MENTHOR_GREY, new Color(0X303B46));//0X2E3640
	    colorMap.put(ThemeColor.MENTHOR_GREY_DARK, new Color(0X262D36));
	    
	    colorMap.put(ThemeColor.MENTHOR_ORANGE, new Color(0XF55B56));
	    colorMap.put(ThemeColor.MENTHOR_ORANGE_LIGHT, new Color(0XFC9272));
	    
	    colorMap.put(ThemeColor.MENTHOR_BROWN, new Color(0X85504f));
	    colorMap.put(ThemeColor.MENTHOR_BROWN_DARK, new Color(0X351817));	    
	}
	
	public Color getColor(ThemeColor color) {
		return colorMap.get(color);
	}
}
