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

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

import net.menthor.editor.finder.FoundScrollTable;
import net.menthor.editor.finder.FoundTableModel;

public class ProblemScrollTable extends FoundScrollTable {

	private static final long serialVersionUID = -7920882969650069279L;
	protected ArrayList<ProblemElement> problemList = new ArrayList<ProblemElement>();
	
	protected ProblemScrollTable(String[] columns) 
	{
		super(columns);
	}
	 
	public ArrayList<ProblemElement>  getProblems() {
		return problemList;
	};
	
	public void setProblems(ArrayList<ProblemElement> problemList)
	{
		this.foundList.clear();
		this.foundList.addAll(problemList);
		this.problemList = problemList;				
		int rows=this.problemList.size();
				
		String[][] data = new String[rows][columnNames.length];
		
		int i=0;		
		for(ProblemElement elem: this.problemList){
			data[i][0]=" "+elem.getTypeProblemString();
			data[i][1]="    "+elem.getIdentifierString()+". "+elem.getDescription();
			data[i][2]=" "+elem.getType();
			data[i][3]=" "+elem.getName();							
			data[i][4]=" "+elem.getPath();			
			i++;
		}
		
		tablemodel = new FoundTableModel(columnNames,data);
		
		table.setModel(tablemodel);
		
		for(int j=0;j<table.getRowCount();j++){
			table.setRowHeight(j, 18);	
	    }
		
		TableColumn column = null;
		for (int j = 0; j < columnNames.length; j++) {
	        column = table.getColumnModel().getColumn(j);	        
	        if (j == 1) column.setPreferredWidth(370);
		}   
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		
		table.repaint();
		table.validate();		
		repaint();
		validate();
	}	
}
