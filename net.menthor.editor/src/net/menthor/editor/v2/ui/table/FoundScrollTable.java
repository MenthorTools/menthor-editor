package net.menthor.editor.v2.ui.table;

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
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.element.FoundElement;
import net.menthor.editor.v2.ui.color.ColorMap;
import net.menthor.editor.v2.ui.color.ColorType;
import net.menthor.editor.v2.ui.popupmenu.FoundPopupMenu;

public class FoundScrollTable extends JScrollPane{

	protected static final long serialVersionUID = 1732036629191359696L;

	protected List<FoundElement> elements = new ArrayList<FoundElement>();
	
	protected JTable table;
	protected GenericTableModel tablemodel;	
	protected String[] columnNames;
	
	public JTable getTable() { return table; }
	public void selectRow (int row) { table.setRowSelectionInterval(row, row); }	
	public List<FoundElement> getElements(){ return elements; };	
	
	public void reset(){
		Object[][] data = {}; String[] columnNames = {};
		tablemodel = new DataTableModel(columnNames,data);
		table.setModel(tablemodel);	
		table.repaint();
		table.validate();		
	}
	
	public FoundScrollTable(final ICommandListener listener, String[] columns){				
		columnNames = columns;
        Object[][] data = {};        
	    setMinimumSize(new Dimension(0, 0));	    
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		setBorder(new EmptyBorder(0,0,0,0));		
		table = new JTable(data,columnNames);
		setViewportView(table);		
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setFillsViewportHeight(true);
		table.setGridColor(Color.LIGHT_GRAY);		
	    table.setSelectionBackground(ColorMap.getInstance().getColor(ColorType.MENTHOR_BLUE));
	    table.setSelectionForeground(Color.BLACK);
	    table.setFocusable(false);	    
	    table.addMouseListener(new MouseAdapter(){
	    	public void mousePressed(MouseEvent e){
	    		if (SwingUtilities.isRightMouseButton(e)){
	    			Point p = e.getPoint();	     
	    			int rowNumber = table.rowAtPoint( p );	     
	    			ListSelectionModel model = table.getSelectionModel();	     
	    			model.setSelectionInterval( rowNumber, rowNumber );	    			
	    			FoundPopupMenu menu = new FoundPopupMenu(listener,elements.get(rowNumber));
	    			menu.show(e.getComponent(),e.getX(),e.getY());
	    		}
	    	}
	    });
	}
	
	public void setElements(List<FoundElement> elements){
		this.elements = elements;		
		int rows=elements.size();				
		String[][] data = new String[rows][columnNames.length];		
		int i=0;		
		for(FoundElement elem: this.elements){						
			data[i][0]="    "+elem.getName();
			data[i][1]=" "+elem.getType();
			data[i][2]=" "+elem.getPath();				
			i++;
		}		
		tablemodel = new DataTableModel(columnNames,data);		
		table.setModel(tablemodel);		
		for(int j=0;j<table.getRowCount();j++){
			table.setRowHeight(j, 18);	
	    }		
		table.repaint();
		table.validate();		
		repaint();
		validate();
	}	

}
