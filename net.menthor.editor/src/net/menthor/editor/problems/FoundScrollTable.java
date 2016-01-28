package net.menthor.editor.problems;

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

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import net.menthor.editor.v2.tables.BaseTableModel;
import net.menthor.editor.v2.tables.DataTableModel;
import net.menthor.editor.v2.types.ColorMap;
import net.menthor.editor.v2.types.ColorType;

/**
 * @author John Guerson
 */
public class FoundScrollTable extends JScrollPane{

	protected static final long serialVersionUID = 1732036629191359696L;
	protected JTable table;
	protected BaseTableModel tablemodel;
	protected ArrayList<FoundElement> foundList = new ArrayList<FoundElement>();
	protected String[] columnNames;
	
	public JTable getTable() { return table; }
	
	public FoundScrollTable(String[] columns)
	{				
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
	    
	    table.addMouseListener(new MouseAdapter()
	    {
	    	public void mousePressed(MouseEvent e)
	    	{
	    		// Left mouse click
	    		if ( SwingUtilities.isLeftMouseButton(e))
	    		{
	    			// nothing
	    		}
	    		// Right mouse click
	    		else if (SwingUtilities.isRightMouseButton(e))
	    		{
	    			// get the coordinates of the mouse click
	    			Point p = e.getPoint();	     
	    			// get the row index that contains that coordinate
	    			int rowNumber = table.rowAtPoint( p );	     
	    			// Get the ListSelectionModel of the JTable
	    			ListSelectionModel model = table.getSelectionModel();	     
	    			// set the selected interval of rows. Using the "rowNumber"
	    			// variable for the beginning and end selects only that one row.
	    			model.setSelectionInterval( rowNumber, rowNumber );
	    			
	    			FoundPopupMenu menu = new FoundPopupMenu(foundList.get(rowNumber));
	    			menu.show(e.getComponent(),e.getX(),e.getY());
	    		}
	    	}
	    });
	}
	
	public void reset()
	{
		Object[][] data = {}; String[] columnNames = {};
		tablemodel = new DataTableModel(columnNames,data);
		table.setModel(tablemodel);	
		table.repaint();
		table.validate();		
	}
	
	public void selectRow (int row)
	{
		table.setRowSelectionInterval(row, row);
	}
	
	public ArrayList<FoundElement> getFound() 
	{
		return foundList;
	};
	
	public void setFound(ArrayList<FoundElement> foundList)
	{
		this.foundList = foundList;		
		int rows=foundList.size();
				
		String[][] data = new String[rows][columnNames.length];
		
		int i=0;		
		for(FoundElement elem: this.foundList){						
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
