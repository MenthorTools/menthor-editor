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
 * 
 * @author John Guerson
 */


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconMap;
import net.menthor.editor.v2.icon.IconType;

public class PaletteItem extends JPanel implements MouseListener, MouseMotionListener
{
	private static final long serialVersionUID = 5550202293825101613L;
	
	private PaletteGrouping parent = null;
	private CommandType command = CommandType.TB_DND_POINTER_MODE; 
	private String name = new String();	
	private boolean isSelected = false;
	
	public String getName() { return name; }
	public CommandType getCommand() { return command; }
	
	public PaletteItem(IconType icontype, String name, CommandType command, PaletteGrouping palette){
		super();
		this.parent = palette;
		this.command = command;		
		this.name = name;
		this.setMaximumSize(new Dimension(32767, 24));
		this.setSize(new Dimension(200, 24));
		this.setPreferredSize(new Dimension(200, 24));
		this.setMinimumSize(new Dimension(0, 24));		
		this.setBorder(PaletteColors.getResetBorder());
		this.setBackground(PaletteColors.getResetBackground());
		this.setLayout(new BorderLayout());
		Icon icon = IconMap.getInstance().getSmallIcon(icontype);
		JLabel label = new JLabel(name, icon, JLabel.LEFT);
		label.setIconTextGap(10);
		label.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 1));		
		this.add(label, BorderLayout.CENTER);
		this.addMouseListener(this);
	}

	public void setSelected(boolean selected) {
		this.isSelected = selected;
		if(selected){
			setSelectedStyle();
			parent.notifySelection(this);
		} else {
			resetStyle();
		}
	}

	public boolean isSelected() {
		return isSelected;
	}

	private void setSelectedStyle(){
		setBackground(PaletteColors.getSelectedItemBackground());
		setBorder(PaletteColors.getSelectedItemBorder());
		setForeground(PaletteColors.getSelectedItemForeground());
		repaint();
	}

	private void setHoverStyle(){
		setBackground(PaletteColors.getHoverItemBackground());
		setBorder(PaletteColors.getHoverItemBorder());
		repaint();
	}

	private void resetStyle(){
		setBackground(PaletteColors.getResetBackground());
		setBorder(PaletteColors.getResetBorder());
		setForeground(PaletteColors.getResetForeground());
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {		
		if(!isSelected)
		setHoverStyle();
	}

	@Override
	public void mouseExited(MouseEvent e) {		
		if(!isSelected)
		resetStyle();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		setSelected(true);				
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {		
		
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}
	
	@Override
	public void mouseMoved(MouseEvent arg0) {
		
	}
}