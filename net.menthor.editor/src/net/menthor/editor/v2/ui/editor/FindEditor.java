
package net.menthor.editor.v2.ui.editor;

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
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.element.FoundElement;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.ui.editor.base.EditorType;
import net.menthor.editor.v2.ui.editor.base.IEditor;
import net.menthor.editor.v2.ui.table.FoundScrollTable;

public class FindEditor extends JPanel implements IEditor {

	private static final long serialVersionUID = -3183962658000841153L;
	
	protected ICommandListener listener;
	protected FoundScrollTable foundScrollTable;	
	protected FindHeader foundHeadPane;
	protected JLabel status;
	
	@SuppressWarnings("unchecked")
	public void find(){
		List<FoundElement> elementsFound = (List<FoundElement>)listener.handleCommand(
			CommandType.FIND_BY_NAME.toString(), new Object[]{foundHeadPane.getText()}
		);
		setElements(elementsFound);
	}
	
	public FindEditor(ICommandListener listener, boolean addHeader){
		this.listener = listener;
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout(0, 0));				
		String[] columns = {"Name", "Stereotype","Location" };		
		foundScrollTable = new FoundScrollTable(listener, columns);
		add(foundScrollTable, BorderLayout.CENTER);		
		status = new JLabel("");
		status.setBackground(Color.LIGHT_GRAY);
		add(status, BorderLayout.SOUTH);
		status.setPreferredSize(new Dimension(450, 20));				
		JTableHeader header = foundScrollTable.getTable().getTableHeader() ;		 
		header.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e){
		      JTableHeader h = (JTableHeader)e.getSource() ;
		      int nColumn = h.columnAtPoint(e.getPoint());		   
		      if (nColumn != -1) sortColumn(nColumn, h.getTable().getModel());
		    }		 
		    public void sortColumn(int nColumn, TableModel model){
		    	sortColumn(nColumn,model);		    	
		    }
		  }
		);		
		repaint(); 
		validate();
		if(addHeader) addHeader();	
	}
	
	@Override
	public boolean isSaveNeeded() { return false; }

	@Override
	public EditorType getEditorType() { return EditorType.FINDER_EDITOR; }

	@Override
	public void propagateNewTitle(String title) { }
	
	@Override
	public void dispose() { }
	
	protected void requestHeaderFocus() { foundHeadPane.getTextField().requestFocus(); }
	
	public void addHeader(){
		foundHeadPane = new FindHeader();
		add(foundHeadPane, BorderLayout.NORTH);
		foundHeadPane.getRunButton().addActionListener(new ActionListener(){			
			public void actionPerformed(ActionEvent arg0){
				find();	
			}
		});
		foundHeadPane.getTextField().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				find();
			}
		});
	}
	
	public void resetResult(){ 
		foundScrollTable.reset(); 
		repaint(); 
		validate(); 
	}	
	
	public void setElements(List<FoundElement> elementsFound){
		resetResult();		
		Collections.sort(elementsFound,new StereotypeComparator());
		foundScrollTable.setElements(elementsFound);
		status.setText("  "+elementsFound.size()+" items found.");
	}
		
	public void sortColumn(int nColumn, TableModel model){
		if(nColumn==0){
    		resetResult();
    		Collections.sort(foundScrollTable.getElements(),new NameComparator());
    		foundScrollTable.setElements(foundScrollTable.getElements());
    		
    	}
    	if(nColumn==1){
    		resetResult();
    		Collections.sort(foundScrollTable.getElements(),new StereotypeComparator());
    		foundScrollTable.setElements(foundScrollTable.getElements());
    	}
    	if(nColumn==2){
    		resetResult();
    		Collections.sort(foundScrollTable.getElements(),new PathComparator());
    		foundScrollTable.setElements(foundScrollTable.getElements());
    	}
	}
		
	public class NameComparator implements Comparator<FoundElement> {
        @Override
        public int compare(FoundElement o1, FoundElement o2) {
            return o1.getName().compareToIgnoreCase(o2.getName());
        }
    }
	public class StereotypeComparator implements Comparator<FoundElement>{
        @Override
        public int compare(FoundElement o1, FoundElement o2) {
            return o1.getType().compareToIgnoreCase(o2.getType());
        }
    }
	public class PathComparator implements Comparator<FoundElement>{
        @Override
        public int compare(FoundElement o1, FoundElement o2) {
            return o1.getPath().compareToIgnoreCase(o2.getPath());
        }
    }
}
