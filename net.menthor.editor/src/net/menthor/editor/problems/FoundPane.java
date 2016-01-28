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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.NamedElement;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.ui.Models;
import net.menthor.editor.ui.UmlProject;
import net.menthor.editor.v2.editors.Editor;
import net.menthor.editor.v2.types.EditorType;

/**
 * @author John Guerson
 */
public class FoundPane extends JPanel implements Editor {

	private static final long serialVersionUID = -3183962658000841153L;
	@SuppressWarnings("unused")
	private UmlProject project;
	private FoundScrollTable foundScrollTable;	
	private JLabel status;
	private FoundHeadPane foundHeadPane;
			
	protected void setProject(UmlProject project)
	{
		this.project = project;
	}
	
	protected void requestHeaderFocus()
	{
		foundHeadPane.getTextField().requestFocus();		
	}
	
	protected void addHeader()
	{
		foundHeadPane = new FoundHeadPane();
		add(foundHeadPane, BorderLayout.NORTH);		

		foundHeadPane.getRunButton().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
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
	
	protected void find() 
	{
		resetResult();		
		// find
		ArrayList<FoundElement> result = strictlyFindByName(foundHeadPane.getText());
		Collections.sort(result,new StereotypeComparator());
		foundScrollTable.setFound(result);
		status.setText("  "+result.size()+" items found.");
	}
	

	/** Strictly find by name */
	public ArrayList<FoundElement> strictlyFindByName(String text)
	{		
		ArrayList<FoundElement> result = new ArrayList<FoundElement>();
		OntoUMLParser refparser = Models.getRefparser();
		if(refparser!=null && text!=null /*&& !text.isEmpty()*/){
			for(EObject eobj: refparser.getAllInstances(EObject.class)){
				if (eobj instanceof NamedElement){
					String name = ((NamedElement)eobj).getName();
					if(name!=null){
						if(text.trim().isEmpty()) result.add(new FoundElement(eobj));
						else {
							if(name.trim().toLowerCase().compareToIgnoreCase(text)==0) result.add(new FoundElement(eobj));
							else if(name.trim().toLowerCase().contains(text.toLowerCase().trim())) result.add(new FoundElement(eobj));
						}
						
					}
				}
			}
		}		
		return result;
	}
	
	public FoundPane(UmlProject project, boolean header)
	{
		this();
		this.project = project;
		
		if(header) addHeader();		
		
		repaint(); 
		validate();
	}
		
	/**
	 * Constructor.
	 */
	protected FoundPane() 
	{
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout(0, 0));
				
		String[] columns = {"Name", "Stereotype","Location" };		
		foundScrollTable = new FoundScrollTable(columns);
		add(foundScrollTable, BorderLayout.CENTER);
		
		status = new JLabel("");
		status.setBackground(Color.LIGHT_GRAY);
		add(status, BorderLayout.SOUTH);
		status.setPreferredSize(new Dimension(450, 20));
				
		JTableHeader header = foundScrollTable.getTable().getTableHeader() ;		 
		header.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) 
		    {
		      JTableHeader h = (JTableHeader)e.getSource() ;
		      int nColumn = h.columnAtPoint(e.getPoint());		   
		      if (nColumn != -1) sortColumn(nColumn, h.getTable().getModel());
		    }		 
		    public void sortColumn(int nColumn, TableModel model)
		    {		      
		    	if(nColumn==0){
		    		resetResult();
		    		Collections.sort(foundScrollTable.getFound(),new NameComparator());
		    		foundScrollTable.setFound(foundScrollTable.getFound());
		    		
		    	}
		    	if(nColumn==1){
		    		resetResult();
		    		Collections.sort(foundScrollTable.getFound(),new StereotypeComparator());
		    		foundScrollTable.setFound(foundScrollTable.getFound());
		    	}
		    	if(nColumn==2){
		    		resetResult();
		    		Collections.sort(foundScrollTable.getFound(),new PathComparator());
		    		foundScrollTable.setFound(foundScrollTable.getFound());
		    	}
		    }
		  }
		);
		
		repaint(); 
		validate();
	}
	
	protected void resetResult() 
	{ 
		foundScrollTable.reset(); 
		repaint(); 
		validate(); 
	}	
	
	protected class NameComparator implements Comparator<FoundElement> 
    {
        @Override
        public int compare(FoundElement o1, FoundElement o2) {
            return o1.getName().compareToIgnoreCase(o2.getName());
        }
    }
	protected class StereotypeComparator implements Comparator<FoundElement> 
    {
        @Override
        public int compare(FoundElement o1, FoundElement o2) {
            return o1.getType().compareToIgnoreCase(o2.getType());
        }
    }
	protected class PathComparator implements Comparator<FoundElement> 
    {
        @Override
        public int compare(FoundElement o1, FoundElement o2) {
            return o1.getPath().compareToIgnoreCase(o2.getPath());
        }
    }
	
	@Override
	public boolean isSaveNeeded() {
		return false;
	}

	@Override
	public EditorType getEditorType() {
		return EditorType.FINDER_EDITOR;
	}

	@Override
	public void dispose() {
		
	}

}
