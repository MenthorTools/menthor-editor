package net.menthor.editor.v2.toolbars;

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
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconMap;
import net.menthor.editor.v2.icon.IconType;

public class BaseToolBar extends JToolBar implements ActionListener {

	private static final long serialVersionUID = -665363641218269342L;
	
	private List<CommandListener> listeners = new ArrayList<CommandListener>();
	public void addCommandListener(CommandListener l) { if(!listeners.contains(l))  listeners.add(l); }
	
	private Map<CommandType, JButton> jbuttonMap = new HashMap<CommandType, JButton>();		
	public void enableButton(CommandType cmdType, boolean flag) { jbuttonMap.get(cmdType).setEnabled(flag); }
	public JButton getButton(CommandType cmdType) { return jbuttonMap.get(cmdType); }
	public void enableAll(boolean value) { for(JButton btn: jbuttonMap.values()) { btn.setEnabled(value); } }
	
	/** constructor */
	public BaseToolBar(Color backgroundColor){		
		setBackground(backgroundColor);
		setRollover(true);
		setMinimumSize(new Dimension(0,0));
		setMargin(new Insets(5,5,5,5));
	}
	
	/** constructor */
	public BaseToolBar(CommandListener listener, Color backgroundColor){		
		addCommandListener(listener);
		setBackground(backgroundColor);
		setRollover(true);
		setMargin(new Insets(5,5,5,5));
	}
	
	/** constructor */
	public BaseToolBar(CommandListener listener){		
		addCommandListener(listener);
		setRollover(true);
		setMargin(new Insets(5,5,5,5));
	}
		
	/** handle commands */
	public void actionPerformed(ActionEvent e) {
		for (CommandListener l : listeners) {
			l.handleCommand(e.getActionCommand());
		}
	}
		
	/** create toolbar button */
	protected JButton createButton(String name, Icon icon, CommandType command, Color background){
		JButton btn = createButton(name, icon, command);
		btn.setBackground(background);
		return btn;
	}
	
	protected JButton createButton(String name, IconType icontype, CommandType command, Color background){
		JButton btn = createButton(name, icontype, command);
		btn.setBackground(background);
		return btn;
	}
	
	/** create toolbar button */
	protected JButton createButton(String name, Icon icon, CommandType command){		
		JButton button = new JButton(icon);
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
	    button.setHorizontalTextPosition(SwingConstants.CENTER);
		if(name!=null) {
			button.setText(name);
		}
		button.setMargin(new Insets(1, 1, 1, 1));		
		button.setActionCommand(command.toString());
		button.addActionListener(this);
		//button.setOpaque(false);
		//button.setContentAreaFilled(false);		
		button.setBorderPainted(false);
	    button.setFocusable(false);
		jbuttonMap.put(command, button);
		add(button);		
		button.setToolTipText(command.getDescription());
		return button;
	}
	/** create toolbar button */
	protected JButton createButton(String name, IconType icontype, CommandType command){
		Icon icon = IconMap.getInstance().getIcon(icontype);
		return createButton(name,icon,command);
	}	
	
	protected JButton createButton(IconType icontype, CommandType command, Color background){
		JButton btn = createButton(icontype, command);
		btn.setBackground(background);
		return btn;
	}
	
	protected JButton createButton(IconType icontype, CommandType command){
		JButton btn = createButton(null,icontype, command);
		return btn;
	}
}
