package net.menthor.editor.palette;

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
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.tinyuml.ui.commands.AppCommandListener;
import org.tinyuml.ui.diagram.DiagramEditor;

import net.menthor.resources.icons.CommandType;
import net.menthor.resources.icons.IconMap;
import net.menthor.resources.icons.IconType;
import net.menthor.resources.icons.PaletteItem;

public class PaletteGrouping extends JPanel
{
	private static final long serialVersionUID = -4131252046223204095L;
		
	private PaletteAccordion parent;
	private PaletteItem mousePointerItem;
	private List<AppCommandListener> listeners = new ArrayList<AppCommandListener>();
	private Map<String, PaletteItem> itemMap = new HashMap<String, PaletteItem>();
	
	public Map<String, PaletteItem> getItemMap() { return itemMap; }
	
	private String name;
	private JPanel titlePane;
	private JLabel titleLabel;
	private Icon closedIcon;
	private Icon openIcon;
	private int iconHeight = 16;
	private int iconWidth = 16;
	private JPanel contentPane;
	private PaletteItem selectedItem = null;

	public String getName() { return this.name; }
	public PaletteItem getPalleteItem(String name){ return itemMap.get(name); }	
	public Collection<PaletteItem> getPaletteItems() { return itemMap.values(); }	
	public JPanel getTitlePane(){ return titlePane; }
	public JPanel getContentPane(){ return contentPane; }	
	public PaletteItem getSelected(){ return selectedItem; }
	public void selectMousePointer() { mousePointerItem.setSelected(true); }
	
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
		createContentPane();				
	}
	
	private void createTitlePane(){
		titlePane = new JPanel();
		titlePane.addMouseListener(new MouseAdapter() { 
			public void mousePressed(MouseEvent me) { 
				parent.setOpenPalette(name); 
			} 
		}); 
		titlePane.setLayout(new BorderLayout());
		titleLabel = new JLabel(name,closedIcon,JLabel.LEFT);		
		titleLabel.setFocusable(false);		
		titlePane.add(titleLabel, BorderLayout.CENTER);
		titlePane.setMaximumSize(new Dimension(32767, 24));
		Dimension size = new Dimension(200, 24);
		titlePane.setSize(size);
		titlePane.setPreferredSize(size);		
		this.add(titlePane, BorderLayout.NORTH);
	}

	private void createContentPane(){
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setPreferredSize(new Dimension(200, 750));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));				
		this.add(contentPane, BorderLayout.CENTER);
	}
	
	public PaletteItem createPaletteItem(Icon icon, String name, CommandType command, String tooltip){
		PaletteItem element = new PaletteItem(icon, name, command, this);		
		element.setToolTipText(tooltip);
		itemMap.put(name, element);
		return element;
	}
	
	public void sort() {
		ArrayList<PaletteItem> result = sort(itemMap.values());		
		mousePointerItem = createPaletteItem(null, "Mouse Pointer", CommandType.POINTER_MODE, "");
		contentPane.add(mousePointerItem);
		for(PaletteItem pe: result){
			contentPane.add(pe);
			contentPane.add(PaletteAccordion.getSpacer(0,1));;
		}
	}
	
	class PalleteItemComparator implements Comparator<PaletteItem>{
        @Override
        public int compare(PaletteItem o1, PaletteItem o2) {        	
        	return o1.getName().compareToIgnoreCase(o2.getName());
        }
    }
	
	public ArrayList<PaletteItem> sort(Collection<PaletteItem> list){
		ArrayList<PaletteItem> result = new ArrayList<PaletteItem>();
		result.addAll(list);
		Collections.sort(result,new PalleteItemComparator());
		return result;
	}
	
	public void addSpacer(int width, int height){
		contentPane.add(PaletteAccordion.getSpacer(width, height));
	}
	
	public void selectDefault() {
		selectMousePointer();
	}
	
	public void unselectAllBut(PaletteItem item) {
		if(selectedItem != null && selectedItem != item)
			selectedItem.setSelected(false);
	}
	
	public void notifySelection(PaletteItem item) {
		if(selectedItem != null) {
			if(item != selectedItem) selectedItem.setSelected(false);
		}	
		DiagramEditor ed = parent.getFrame().getDiagramManager().getCurrentDiagramEditor();
		if(ed!=null){
			ed.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
		selectedItem = item;
		parent.NotifySelection(item);		
		for (AppCommandListener listener : listeners) {
			listener.handleCommand(item.getCommand().toString());
		}
	}

	public void addCommandListener(AppCommandListener listener) {
		listeners.add(listener);
	}

	public void removeCommandListener(AppCommandListener listener) {
		listeners.remove(listener);
	}
	
	public void setSelectedLayout(){
		titlePane.setBorder(PaletteAccordion.getSelectedPaletteBorder());
		titlePane.setBackground(PaletteAccordion.getSelectedPaletteBackground());		
		titleLabel.setIcon(openIcon);
	}

	public void setUnselectedLayout(){
		titlePane.setBorder(PaletteAccordion.getUnselectedPaletteBorder());
		titlePane.setBackground(PaletteAccordion.getUnselectedPaletteBackground());		
		titleLabel.setIcon(closedIcon);
	}
}
