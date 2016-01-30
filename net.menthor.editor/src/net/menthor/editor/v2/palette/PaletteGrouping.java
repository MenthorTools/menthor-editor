package net.menthor.editor.v2.palette;

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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconMap;
import net.menthor.editor.v2.icon.IconType;
import net.menthor.editor.v2.ui.TitlePanel;

public class PaletteGrouping extends JPanel
{
	private static final long serialVersionUID = -4131252046223204095L;
		
	private PaletteAccordion parent;
	
	private Map<String, PaletteItem> itemMap = new HashMap<String, PaletteItem>();	
	public Map<String, PaletteItem> getItemMap() { return itemMap; }

	private PaletteItem selectedItem = null;
	private PaletteItem mousePointerItem;
	
	private String name;
	private TitlePanel titlePane;
	private JPanel contentPane;
	private Icon closedIcon;
	private Icon openIcon;
	private int iconHeight = 16;
	private int iconWidth = 16;	
	
	/** Handles the selection of the item then Notify parent about this selection */ 
	public void notifySelection(PaletteItem item){
		if(selectedItem != null) {
			if(item != selectedItem) selectedItem.setSelected(false);
		}		
		selectedItem = item;
		parent.notifySelection(item);		
	}
	
	/** Getters and Setters */
	public String getName() { return this.name; }
	public PaletteItem getPalleteItem(String name){ return itemMap.get(name); }	
	public Collection<PaletteItem> getPaletteItems() { return itemMap.values(); }	
	public JPanel getTitlePane(){ return titlePane; }
	public JPanel getContentPane(){ return contentPane; }	
	public PaletteItem getSelected(){ return selectedItem; }
	public void selectMousePointer() { mousePointerItem.setSelected(true); }
	
	/**Constructor*/
	public PaletteGrouping(PaletteAccordion parent, String name){
		super();
		this.name = name;
		this.parent = parent;
		this.setLayout(new BorderLayout());
		Icon icon = IconMap.getInstance().getIcon(IconType.MENTHOR_CLOSED);
		Image img = ((ImageIcon)icon).getImage();  
		Image newimg = img.getScaledInstance(iconWidth, iconHeight, java.awt.Image.SCALE_SMOOTH);  
		closedIcon = new ImageIcon(newimg);		
		icon = IconMap.getInstance().getIcon(IconType.MENTHOR_OPEN);
		img = ((ImageIcon)icon).getImage();  
		newimg = img.getScaledInstance(iconWidth, iconHeight, java.awt.Image.SCALE_SMOOTH);  
		openIcon = new ImageIcon(newimg);		
		createTitlePane();		
		createItemsPane();				
	}
	
	/** Create title pane */
	private void createTitlePane(){
		titlePane = new TitlePanel(name,closedIcon);
		titlePane.addMouseListener(new MouseAdapter() { 
			public void mousePressed(MouseEvent me) { 
				parent.openPalette(name); 
			} 
		});				
		this.add(titlePane, BorderLayout.NORTH);
	}

	/** Create items pane */
	private void createItemsPane(){
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setPreferredSize(new Dimension(200, 750));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));				
		this.add(contentPane, BorderLayout.CENTER);
	}
	
	/** Create a palette item */
	public PaletteItem createPaletteItem(IconType icontype, String name, CommandType command){
		PaletteItem element = new PaletteItem(icontype, name, command, this);		
		element.setToolTipText(command.getDescription());
		itemMap.put(name, element);
		return element;
	}
	
	/** Sort the set of palette items in this grouping */
	public void sort() {
		ArrayList<PaletteItem> result = sort(itemMap.values());		
		mousePointerItem = createPaletteItem(
			IconType.MENTHOR_MOUSE_POINTER, 
			"Mouse Pointer", 
			CommandType.PALLETE_POINTER_MODE
		);
		contentPane.add(mousePointerItem);
		for(PaletteItem pe: result){
			contentPane.add(pe);
			contentPane.add(getSpacer(0,1));;
		}
	}
	
	public static Component getSpacer(int width, int height) { return Box.createRigidArea(new Dimension(width, height)); }
	
	/** Palette item comparator */
	class PalleteItemComparator implements Comparator<PaletteItem>{
        @Override
        public int compare(PaletteItem o1, PaletteItem o2) {        	
        	return o1.getName().compareToIgnoreCase(o2.getName());
        }
    }
	
	/** Sort a given set of palette items */
	public ArrayList<PaletteItem> sort(Collection<PaletteItem> list){
		ArrayList<PaletteItem> result = new ArrayList<PaletteItem>();
		result.addAll(list);
		Collections.sort(result,new PalleteItemComparator());
		return result;
	}

	/** Select a default item which is the mouse pointer */
	public void selectDefault() {
		selectMousePointer();
	}
	
	/** Unselect all items but the given item */
	public void unselectAllBut(PaletteItem item) {
		if(selectedItem != null && selectedItem != item)
			selectedItem.setSelected(false);
	}
		
	/** Set selected layout */
	public void setSelectedLayout(){
		titlePane.setBorder(PaletteColors.getSelectedGroupingBorder());
		titlePane.setBackground(PaletteColors.getSelectedGroupingBackground());		
		titlePane.setIcon(openIcon);
	}

	/** Set unselected layout */
	public void setUnselectedLayout(){
		titlePane.setBorder(PaletteColors.getUnselectedGroupingBorder());
		titlePane.setBackground(PaletteColors.getUnselectedGroupingBackground());		
		titlePane.setIcon(closedIcon);
	}
}
