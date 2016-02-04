package net.menthor.editor.v2.menu;

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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconMap;
import net.menthor.editor.v2.icon.IconType;

public class BaseMenu<T> extends JMenu implements ActionListener{

	private static final long serialVersionUID = -1451727867476622857L;
	
	protected List<CommandListener> listeners = new ArrayList<CommandListener>();
	public void addCommandListener(CommandListener l) { if(!listeners.contains(l)) listeners.add(l); }
	
	protected T context;
	
	public HashMap<CommandType,JMenuItem> menuItemsMap = new HashMap<CommandType,JMenuItem>();
	public void enableItem(CommandType cmdType, boolean flag) { menuItemsMap.get(cmdType).setEnabled(flag); }
	public JMenuItem getMenuItem(CommandType cmdType) { return menuItemsMap.get(cmdType); }
	public void enableAll(boolean value) { for(JMenuItem btn: menuItemsMap.values()) { btn.setEnabled(value); } }
	
	public BaseMenu(CommandListener listener, String text, T context) { 
		super(text);
		this.context = context;
		addCommandListener(listener);
	}
	
//	/** some actions are executed in the context of a given element, 
//	 *  called here of 'context' */ 
//	public void setContext(Object context){
//		this.context = context;		
//	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		for (CommandListener l : listeners) {
			if(context!=null) l.handleCommand(e.getActionCommand(), new Object[]{context});
			else l.handleCommand(e.getActionCommand());
		}		
	}

	/** create checkbox menu item */
	protected JCheckBoxMenuItem createCheckBoxMenuItem(String name, CommandType command){
		return createCheckBoxMenuItem(name,null,command);
	}
	
	/** create checkbox menu item */
	protected JCheckBoxMenuItem createCheckBoxMenuItem(String name, IconType icontype, CommandType command){
		JCheckBoxMenuItem item = new JCheckBoxMenuItem();
		setIcon(icontype, item);		
		configureMenuItem(name, icontype, command, item);
		return item;
	}
	
	/** create radio menu item */
	protected JRadioButtonMenuItem createRadioMenuItem(String name, CommandType command){
		return createRadioMenuItem(name,null,command);
	}
	
	/** create radio menu item */
	protected JRadioButtonMenuItem createRadioMenuItem(String name, IconType icontype, CommandType command){
		JRadioButtonMenuItem item = new JRadioButtonMenuItem();
		configureMenuItem(name, icontype, command, item);
		return item;
	}
		
	/** create regular menu item */
	protected JMenuItem createMenuItem(String name, CommandType command){
		return createMenuItem(name,null, command);
	}
	
	/** create regular menu item */
	protected JMenuItem createMenuItem(String name, IconType icontype, CommandType command){
		JMenuItem item = new JMenuItem();
		configureMenuItem(name, icontype, command, item);
		return item;
	}
	
	private void configureMenuItem(String name, IconType icontype, CommandType command, JMenuItem item) {
		setIcon(icontype, item);		
		
		if(name!=null) 
			item.setText(name);				
		
		item.setToolTipText(command.getDescription());
		
		item.setActionCommand(command.toString());
		item.addActionListener(this);
		menuItemsMap.put(command, item);
		add(item);		
		
	}
	
	private void setIcon(IconType icontype, JMenuItem item) {
		if(icontype!=null){
			Icon icon = IconMap.getInstance().getIcon(icontype);
			Image img = ((ImageIcon)icon).getImage();  
			Image newimg = img.getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH);  
			Icon newIcon = new ImageIcon(newimg);
			item.setIcon(newIcon);
		}
	}
	
	public void sort(){
  		ArrayList<JMenuItem> result = sort(menuItemsMap.values());		
  		for(JMenuItem pe: result){
  			add(pe);			
  		}
  	}
  	
  	class JMenuItemComparator implements Comparator<JMenuItem>{
          @Override
          public int compare(JMenuItem o1, JMenuItem o2) {        	
          	return o1.getText().compareToIgnoreCase(o2.getText());
          }
      }
  	
  	public ArrayList<JMenuItem> sort(Collection<JMenuItem> list){
  		ArrayList<JMenuItem> result = new ArrayList<JMenuItem>();
  		result.addAll(list);
  		Collections.sort(result,new JMenuItemComparator());
  		return result;
  	}
}

