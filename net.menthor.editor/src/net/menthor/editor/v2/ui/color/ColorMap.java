package net.menthor.editor.v2.ui.color;

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

public final class ColorMap {
	
	private static ColorMap instance = new ColorMap();	
	private Map<ColorType, Color> colorMap = new HashMap<ColorType, Color>();
	
	public static ColorMap getInstance() { return instance; }
	
	private ColorMap() {		
		colorMap.put(ColorType.MENTHOR_GREEN_LIGHTEST, new Color(0xF2FCAC));
		colorMap.put(ColorType.MENTHOR_GREEN_LIGHT, new Color(0xCAE70C)); //Alternatives BDEB07 , BFFA37 from STABILO_BOSS
		colorMap.put(ColorType.MENTHOR_GREEN_MEDIUM, new Color(0xB1D329));
		colorMap.put(ColorType.MENTHOR_GREEN_DARK, new Color(0x94B053));				
		colorMap.put(ColorType.MENTHOR_BLUE_LIGHTEST, new Color(0xc6dbef));
		colorMap.put(ColorType.MENTHOR_BLUE_LIGHT, new Color(0x9ecae1));		
		colorMap.put(ColorType.MENTHOR_BLUE, new Color(0x6baed6));
		colorMap.put(ColorType.MENTHOR_BLUE_DARK, new Color(0x2171b5));		
		colorMap.put(ColorType.MENTHOR_GREY, new Color(0X303B46));//0X2E3640, 0x82837E
		colorMap.put(ColorType.MENTHOR_GREY_LIGHT, new Color(0xE0E0E0));
		colorMap.put(ColorType.MENTHOR_GREY_MEDIUM, new Color(0xC0C0C0));
	    colorMap.put(ColorType.MENTHOR_GREY_DARK, new Color(0X262D36));	    
	    colorMap.put(ColorType.MENTHOR_ORANGE, new Color(0XF55B56));
	    colorMap.put(ColorType.MENTHOR_ORANGE_LIGHT, new Color(0XFC9272));	    
	    colorMap.put(ColorType.MENTHOR_BROWN, new Color(0X85504f));
	    colorMap.put(ColorType.MENTHOR_BROWN_DARK, new Color(0X351817));	    
	}
	
	public Color getColor(ColorType color) {
		return colorMap.get(color);
	}
}
