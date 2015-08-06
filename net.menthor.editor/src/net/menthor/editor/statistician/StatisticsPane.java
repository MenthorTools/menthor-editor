package net.menthor.editor.statistician;

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
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
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

import org.tinyuml.draw.Diagram;
import org.tinyuml.ui.diagram.Editor;

import net.menthor.editor.explorer.ProjectBrowser;
import net.menthor.editor.ui.UmlProject;

/**
 * @author John Guerson
 */
public class StatisticsPane extends JPanel implements Editor {

	private static final long serialVersionUID = -3183962658000841153L;
	@SuppressWarnings("unused")
	private UmlProject project;
	private StatisticsScrollTable statScrollTable;
	private StatisticsHeadPane statHeadPane;
	private JLabel status;
	
	public StatisticsPane(UmlProject project)
	{
		this();
		this.project = project;
	}
		
	public void setProject(UmlProject project)
	{
		this.project = project;
	}
	
	/**
	 * Constructor.
	 */
	public StatisticsPane() 
	{
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout(0, 0));
		
		statHeadPane = new StatisticsHeadPane();
		add(statHeadPane, BorderLayout.NORTH);
		
		statScrollTable = new StatisticsScrollTable();
		add(statScrollTable, BorderLayout.CENTER);
		
		status = new JLabel("");
		status.setBackground(Color.LIGHT_GRAY);
		add(status, BorderLayout.SOUTH);
		status.setPreferredSize(new Dimension(450, 20));
		
		statHeadPane.getRunButton().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				collect();
				statHeadPane.getCopyButton().setEnabled(true);
			}
		});
		
		statHeadPane.getCopyButton().addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();  
				StringSelection selection = new StringSelection(statScrollTable.getTableText());  
				clipboard.setContents(selection, null);  
			}
		});
				
		JTableHeader header = statScrollTable.getTable().getTableHeader() ;		 
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
		    		Collections.sort(statScrollTable.getResult(),new MeasureComparator());
		    		statScrollTable.setData(statScrollTable.getResult());
		    		
		    	}
		    	if(nColumn==1){
		    		resetResult();
		    		Collections.sort(statScrollTable.getResult(),new CountComparator());
		    		statScrollTable.setData(statScrollTable.getResult());
		    	}	
		    	if(nColumn==2){
		    		resetResult();
		    		Collections.sort(statScrollTable.getResult(),new TypePercentageComparator());
		    		statScrollTable.setData(statScrollTable.getResult());
		    	}
		    	if(nColumn==3){
		    		resetResult();
		    		Collections.sort(statScrollTable.getResult(),new AllPercentageComparator());
		    		statScrollTable.setData(statScrollTable.getResult());
		    	}
		    }
		  }
		);
		
		repaint(); 
		validate();
	}
	
	public class MeasureComparator implements Comparator<StatisticalElement> 
    {
        @Override
        public int compare(StatisticalElement o1, StatisticalElement o2) {
            return o1.getMeasure().compareToIgnoreCase(o2.getMeasure());
        }
    }
	public class CountComparator implements Comparator<StatisticalElement> 
    {
        @Override
        public int compare(StatisticalElement o1, StatisticalElement o2) {
            if (o1.getCount()> o2.getCount()) return +1;
            else if(o1.getCount()< o2.getCount()) return -1;
            else return 0;
        }
    }
	
	public class TypePercentageComparator implements Comparator<StatisticalElement> 
    {
        @Override
        public int compare(StatisticalElement o1, StatisticalElement o2) {
            if (o1.getTypePercentageValue()> o2.getTypePercentageValue()) return +1;
            else if(o1.getTypePercentageValue()< o2.getTypePercentageValue()) return -1;
            else return 0;
        }
    }
	
	public class AllPercentageComparator implements Comparator<StatisticalElement> 
    {
        @Override
        public int compare(StatisticalElement o1, StatisticalElement o2) {
            if (o1.getAllPercentageValue()> o2.getAllPercentageValue()) return +1;
            else if(o1.getAllPercentageValue()< o2.getAllPercentageValue()) return -1;
            else return 0;
        }
    }
	
	public void collect() 
	{
		resetResult();		
		// collect statistics
		ArrayList<StatisticalElement> result = ProjectBrowser.frame.getDiagramManager().collectStatistic();
		Collections.sort(result,new MeasureComparator());
		statScrollTable.setData(result);
		//status.setText("  "+result.size()+"  found.");
	}
	
	public void resetResult() { statScrollTable.reset(); repaint(); validate(); }
	
	@Override
	public boolean isSaveNeeded() {
		return false;
	}

	@Override
	public EditorNature getEditorNature() {
		return EditorNature.STATISTICS;
	}

	@Override
	public Diagram getDiagram() {
		return null;
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public UmlProject getProject() {
		return null;
	}
}
