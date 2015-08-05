package net.menthor.editor.v2.menus;

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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class BasePopupMenu extends JPopupMenu implements ActionListener{

	private static final long serialVersionUID = -1451727867476622857L;
	
	protected Object context;
	
	protected List<CommandListener> listeners = new ArrayList<CommandListener>();
	public void addCommandListener(CommandListener l) { listeners.add(l); }
	
	public HashMap<CommandType,JMenuItem> elementsMap = new HashMap<CommandType,JMenuItem>();
	public void enableButton(CommandType cmdType, boolean flag) { elementsMap.get(cmdType).setEnabled(flag); }
	public JMenuItem getButton(CommandType cmdType) { return elementsMap.get(cmdType); }
	public void enableAll(boolean value) { for(JMenuItem btn: elementsMap.values()) { btn.setEnabled(value); } }
	
	/** some actions are executed in the context of a given element, 
	 *  called here of 'context' */ 
	public void setContext(Object context){
		this.context = context;		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (CommandListener l : listeners) {
			l.handleCommand(e.getActionCommand(), context);
		}		
	}

	public void sort(){
  		ArrayList<JMenuItem> result = sort(elementsMap.values());		
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
