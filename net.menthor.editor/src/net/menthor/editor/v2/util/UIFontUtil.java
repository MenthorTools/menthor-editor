package net.menthor.editor.v2.util;

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

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.util.Enumeration;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class UIFontUtil {

	/** This caches the result of the call to get all fonts. */
	private static String[] allFonts = null;

	/** Returns true if a font with that name exists on the system (comparison is case-insensitive). */
	public synchronized static boolean hasFont(String fontname) {
		if (allFonts == null) allFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for(int i = 0; i < allFonts.length; i++) if (fontname.compareToIgnoreCase(allFonts[i]) == 0) return true;
		return false;
	}
	
    /** Choose the appropriate Font according to the operating system */
	public static void set(){
	   // Choose the appropriate font		
	   int fontSize=11;
       String fontName="Tahoma";
       while(true) {
           if (!hasFont(fontName)) { fontName="Arial"; fontSize = 11;} else break; 
           if (!hasFont(fontName)) { fontName="Calibri"; fontSize=11; } else break; 
           if (!hasFont(fontName)) { fontName="Courier New"; } else break; 
           if (!hasFont(fontName)) { fontName="Lucida Grande"; fontSize=10; } 
           break;
       }			        
       setUIFont(new FontUIResource(new Font(fontName, Font.PLAIN, fontSize)));
	}
	
	/** Asks the user to choose a font; returns "" if the user cancels the request. */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized static String askFont() {
		if (allFonts == null) allFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		JComboBox jcombo = new JComboBox(allFonts);
		Object ans = Util.show("Font", JOptionPane.INFORMATION_MESSAGE,
			new Object[] {"Please choose the new font:", jcombo}, new Object[] {"Ok", "Cancel"}, "Cancel"
			);
		Object value = jcombo.getSelectedItem();
		if (ans=="Ok" && (value instanceof String)) return (String)value; else return "";
	}
	
    @SuppressWarnings("rawtypes")
	public static void setUIFont(FontUIResource f){
       Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                FontUIResource orig = (FontUIResource) value;
                Font font = new Font(f.getFontName(), orig.getStyle(), f.getSize());
                UIManager.put(key, new FontUIResource(font));
            }
        }
    }
}
