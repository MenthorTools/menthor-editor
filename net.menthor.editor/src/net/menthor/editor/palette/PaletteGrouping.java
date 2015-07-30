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

import net.menthor.editor.util.ApplicationResources;
import net.menthor.resources.icons.IconMap;
import net.menthor.resources.icons.IconType;
import net.menthor.resources.icons.PaletteItem;

public class PaletteGrouping extends JPanel
{
	private static final long serialVersionUID = -4131252046223204095L;
		
	private PaletteAccordion parent;
	
	private List<AppCommandListener> listeners = new ArrayList<AppCommandListener>();
	private Map<String, PaletteItem> elementMap = new HashMap<String, PaletteItem>();
	public Map<String, PaletteItem> getElementMap() { return elementMap; }
	
	private String name;
	private JPanel titlePane;
	private JLabel titleLabel;
	private Icon closedIcon;
	private Icon openIcon;
	private int iconHeight = 16;
	private int iconWidth = 16;
	private JPanel contentPane;
	private PaletteItem selectedElement = null;

	public String getName() { return this.name; }
	public PaletteItem getPalleteElement(String name){ return elementMap.get(name); }	
	public Collection<PaletteItem> getPaletteElements() { return elementMap.values(); }	
	public JPanel getTitle(){ return titlePane; }
	public JPanel getContent(){ return contentPane; }	
	public PaletteItem getSelectedElement(){ return selectedElement; }
	
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
	
	public PaletteItem createPaletteElement(String type, String name){
		String prefix = type + "." + name;
		String command = getResourceString(prefix + ".command");
		String caption = getResourceString(prefix + ".caption");
		Icon icon = IconMap.getInstance().getIcon(getResourceString(prefix + ".icon"));
		PaletteItem element = new PaletteItem(icon, caption, command, this,type);
		if (name.equals("derivation")) element.setEnabled(false);
		element.setToolTipText(getResourceString(prefix + ".tooltip"));
		elementMap.put(name, element);
		//content.add(element);
		//content.add(PaletteAccordion.getSpacer(0,1));
		return element;
	}
	
	public PaletteItem createStaticElement(Icon icon, String caption, String type ){
		PaletteItem element = new PaletteItem(icon, caption, "DOMAIN_PATTERN", this,type);
		elementMap.put(caption, element);
		return element;
	}
	
	public void sort() {
		ArrayList<PaletteItem> result = sort(elementMap.values());
		contentPane.add(createPaletteElement("staticpalette.classes", "select"));
		for(PaletteItem pe: result){
			contentPane.add(pe);
			contentPane.add(PaletteAccordion.getSpacer(0,1));;
		}
	}
	
	class PalleteElementComparator implements Comparator<PaletteItem> {
        @Override
        public int compare(PaletteItem o1, PaletteItem o2) {        	
        	if(o1.getType().contains("classes") && o2.getType().contains("relations")){
        		return -1;        	
        	}else if (o1.getType().contains("relations") && o2.getType().contains("classes")){        		
        		return 1;
        	} else
        		return o1.getCaption().compareToIgnoreCase(o2.getCaption());
        }
    }
	
	public ArrayList<PaletteItem> sort(Collection<PaletteItem> list){
		ArrayList<PaletteItem> result = new ArrayList<PaletteItem>();
		result.addAll(list);
		Collections.sort(result,new PalleteElementComparator());
		return result;
	}
	
	public void addSpacer(int width, int height){
		contentPane.add(PaletteAccordion.getSpacer(width, height));
	}
	
	public void selectDefault() {
		elementMap.get("select").setSelected(true);
	}
	
	public void unselectAllBut(PaletteItem item) {
		if(selectedElement != null && selectedElement != item)
			selectedElement.setSelected(false);
	}
	
	public void notifySelection(PaletteItem item) {
		if(selectedElement != null) {
			if(item != selectedElement) selectedElement.setSelected(false);
		}		
		if(parent.getFrame().getDiagramManager().getCurrentDiagramEditor()!=null){
			parent.getFrame().getDiagramManager().getCurrentDiagramEditor().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
		selectedElement = item;
		parent.NotifySelection(item);		
		for (AppCommandListener listener : listeners) {
			listener.handleCommand(item.getCommand());
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
	
	private String getResourceString(String property) {
		return ApplicationResources.getInstance().getString(property);
	}
}
