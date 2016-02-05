package net.menthor.editor.v2.ui.util;

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
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JLabel;

public class JHyperLinkLabel extends JLabel {
	
	private static final long serialVersionUID = -4144795172729779055L;
	
	private Color underlineColor = null;
	  
	public JHyperLinkLabel(String label){
	    super(label);
	    setForeground(Color.BLUE.darker());
	    setCursor(new Cursor(Cursor.HAND_CURSOR));	    
	}

	@Override
	protected void paintComponent(Graphics g){
	    super.paintComponent(g);
	    g.setColor(underlineColor == null ? getForeground() : underlineColor);
	    Insets insets = getInsets();
	    int left = insets.left;
	    if (getIcon() != null) left += getIcon().getIconWidth() + getIconTextGap();
	    g.drawLine(left, getHeight() - 1 - insets.bottom, (int) getPreferredSize().getWidth() - insets.right, getHeight() - 1 - insets.bottom);
	}

	public Color getUnderlineColor() {
	    return underlineColor;
	}

	public void setUnderlineColor(Color underlineColor) {
	    this.underlineColor = underlineColor;
	}
}