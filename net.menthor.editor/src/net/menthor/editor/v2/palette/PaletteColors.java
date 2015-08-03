package net.menthor.editor.v2.palette;

/*
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

import javax.swing.BorderFactory;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import net.menthor.editor.v2.types.ColorMap;
import net.menthor.editor.v2.types.ColorType;

public class PaletteColors {

	private static Border resetBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
	private static Color resetBackground = Color.WHITE;
	private static Color resetForeground = Color.BLACK;
	
	private static Border selectedItemBorder = new LineBorder(ColorMap.getInstance().getColor(ColorType.MENTHOR_ORANGE), 1, true);
	private static Color selectedItemBackground = ColorMap.getInstance().getColor(ColorType.MENTHOR_ORANGE);
	private static Color selectedItemForeground = Color.WHITE;
	
	private static Border hoverItemBorder = new LineBorder(ColorMap.getInstance().getColor(ColorType.MENTHOR_BLUE_DARK), 1, true);
	private static Color hoverItemBackground = ColorMap.getInstance().getColor(ColorType.MENTHOR_BLUE_LIGHT);

	private static Border selectedGroupingBorder = UIManager.getBorder("Panel.border"); //new LineBorder(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY), 1, true);
	private static Color selectedGroupingBackground = UIManager.getColor("Panel.background");//ColorMap.getInstance().getColor(ColorType.MENTHOR_GREY_MEDIUM);

	private static Border unselectedGroupingBorder = UIManager.getBorder("Panel.border"); //new LineBorder(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY), 1, true);
	private static Color unselectedGroupingBackground = UIManager.getColor("Panel.background"); //ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY);

	public static Border getResetBorder() { return resetBorder; }
	public static Color getResetBackground() { return resetBackground; }
	public static Color getResetForeground() { return resetForeground; }
	
	public static Border getSelectedItemBorder() { return selectedItemBorder; }
	public static Color getSelectedItemBackground() { return selectedItemBackground; }
	public static Border getHoverItemBorder() { return hoverItemBorder; }
	public static Color getHoverItemBackground() { return hoverItemBackground; }	
	public static Color getSelectedItemForeground() { return selectedItemForeground; }
	
	public static Border getSelectedGroupingBorder() { return selectedGroupingBorder; }
	public static Color getSelectedGroupingBackground() { return selectedGroupingBackground; }
	public static Border getUnselectedGroupingBorder() { return unselectedGroupingBorder; }
	public static Color getUnselectedGroupingBackground() { return unselectedGroupingBackground; }
}
