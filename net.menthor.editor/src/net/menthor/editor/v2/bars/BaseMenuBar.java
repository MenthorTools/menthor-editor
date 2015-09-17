package net.menthor.editor.v2.bars;

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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconMap;
import net.menthor.editor.v2.icon.IconType;

public class BaseMenuBar extends JMenuBar implements ActionListener{
	
	private static final long serialVersionUID = -665363641218269342L;
	
	private List<CommandListener> listeners = new ArrayList<CommandListener>();
	public void addCommandListener(CommandListener l) { listeners.add(l); }
	
	private Map<CommandType, JMenuItem> menuItemsMap = new HashMap<CommandType, JMenuItem>();		
	public void enableMenuItem(CommandType cmdType, boolean flag) { menuItemsMap.get(cmdType).setEnabled(flag); }
	public JMenuItem getMenuItem(CommandType cmdType) { return menuItemsMap.get(cmdType); }
	public void enableAll(boolean value) { for(JMenuItem btn: menuItemsMap.values()) { btn.setEnabled(value); } }
	public boolean isSelected(CommandType cmdType) { return menuItemsMap.get(cmdType).isSelected(); }
	public void select(CommandType cmdType, boolean value) { menuItemsMap.get(cmdType).setSelected(value); }
	
	/** constructor */
	public BaseMenuBar(Color backgroundColor){		
		setBackground(backgroundColor);		
	}
	
	/** constructor */
	public BaseMenuBar(CommandListener listener, Color backgroundColor){		
		addCommandListener(listener);
		setBackground(backgroundColor);		
	}
	
	/** handle commands */
	public void actionPerformed(ActionEvent e) {
		for (CommandListener l : listeners) {
			l.handleCommand(e.getActionCommand(), null);
		}
	}
	
	/** create menu item */
	protected JMenuItem createMenuItem(JMenu menu, String name, IconType icontype, CommandType command, Color background){
		JMenuItem item = new JMenuItem();
		if(icontype!=null){
			Icon icon = IconMap.getInstance().getIcon(icontype);
			Image img = ((ImageIcon)icon).getImage();  
			Image newimg = img.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);  
			Icon newIcon = new ImageIcon(newimg);
			item.setIcon(newIcon);
		}		
		if(background!=null) setBackground(background);
		if(name!=null) item.setText(name);				
		item.setActionCommand(command.toString());
		item.addActionListener(this);
		menuItemsMap.put(command, item);
		menu.add(item);		
		item.setToolTipText(command.getDescription());
		return item;
	}
	
	/** create menu item */
	protected JCheckBoxMenuItem createCheckBoxMenuItem(JMenu menu, String name, IconType icontype, CommandType command, Color background){
		JCheckBoxMenuItem item = new JCheckBoxMenuItem();
		if(icontype!=null){
			Icon icon = IconMap.getInstance().getIcon(icontype);
			Image img = ((ImageIcon)icon).getImage();  
			Image newimg = img.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);  
			Icon newIcon = new ImageIcon(newimg);
			item.setIcon(newIcon);
		}		
		if(background!=null) setBackground(background);
		if(name!=null) item.setText(name);				
		item.setActionCommand(command.toString());
		item.addActionListener(this);
		menuItemsMap.put(command, item);
		menu.add(item);		
		item.setToolTipText(command.getDescription());
		return item;
	}
	
	/** create menu item */
	protected JMenuItem createMenuItem(JMenu menu, String name, CommandType command, Color background){
		return createMenuItem(menu, name, null, command, background);
	}
	
	/** create menu item */
	protected JCheckBoxMenuItem createCheckBoxMenuItem(JMenu menu, String name, CommandType command, Color background){
		return createCheckBoxMenuItem(menu, name, null, command, background);
	}
	
	/** create menu item */
	protected JMenuItem createMenuItem(JMenu menu, String name, CommandType command, Color background, KeyStroke stroke){
		JMenuItem menuitem = createMenuItem(menu, name, null, command, background);
		menuitem.setAccelerator(stroke);
		return menuitem;
	}
}
