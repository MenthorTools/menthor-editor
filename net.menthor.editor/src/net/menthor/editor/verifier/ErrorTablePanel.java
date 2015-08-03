package net.menthor.editor.verifier;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.menthor.common.file.FileUtil;
import net.menthor.editor.model.UmlProject;
import net.menthor.editor.v2.types.ColorMap;
import net.menthor.editor.v2.types.ColorType;

/**
 * @author John Guerson
 */

public class ErrorTablePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private UmlProject project;
	
	private JScrollPane scrollpane;
	private JTable table;
	private WarningTableModel tablemodel;
	private JLabel errorMessage;
	private JButton saveButton;
	private String content;
	
	public ErrorTablePanel(UmlProject project)
	{
		this();
		this.project = project;
	}
	
	public void selectRow (int row)
	{
		table.setRowSelectionInterval(row, row);
	}
	
	public void setProject(UmlProject project)
	{
		this.project = project;
	}
	
	public void reset()
	{
		Object[][] data = {};String[] columnNames = {};
		tablemodel = new WarningTableModel(columnNames,data);
		table.setModel(tablemodel);	
		table.repaint();
		table.validate();		
	}
	
	/**
	 * Set data
	 * 
	 * @param elem
	 */
	public void setData(ArrayList<ArrayList<String>> matrix, int errors)
	{
		int rows=matrix.size();
		
		errorMessage.setText("    ("+errors+" errors)");
		errorMessage.repaint();
		errorMessage.validate();
		
		String[][] data = new String[rows][3];
		
		int i=0;		
		for(ArrayList<String> row: matrix){
			int j=0;
			for(String str: row){
				if (j==0) data[i][j]="    "+str;
				else data[i][j]=" "+str;
				j++;
			}
			i++;
		}
		
		String[] columnNames = {"Description","Element","Path"};
		tablemodel = new WarningTableModel(columnNames,data);
		
		table.setModel(tablemodel);
		
		for(int j=0;j<table.getRowCount();j++){
			table.setRowHeight(j, 18);	
	    }
		
		table.repaint();
		table.validate();
		
		content = tablemodel.getData();
		
		repaint();
		validate();
	}	
	
	public String getContent()
	{
		return content;
	}
	
	/**
	 * Constructor.
	 */
	public ErrorTablePanel() 
	{
		setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setBorder(new EmptyBorder(0, 0, 0, 0));
				
		setLayout(new BorderLayout(0, 0));		

		String[] columnNames = {"Description","Element","Path"};
        Object[][] data = {};
        
        scrollpane = new JScrollPane();		
        scrollpane.setMinimumSize(new Dimension(0, 0));
	    setMinimumSize(new Dimension(0, 0));
		scrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setBorder(new EmptyBorder(0,0,0,0));
		
		table = new JTable(data,columnNames);
		scrollpane.setViewportView(table);
		
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		//table.setPreferredScrollableViewportSize(new Dimension(500, 150));		
		table.setFillsViewportHeight(true);
		table.setGridColor(Color.LIGHT_GRAY);		
	    table.setSelectionBackground(ColorMap.getInstance().getColor(ColorType.MENTHOR_BLUE_LIGHT));
	    table.setSelectionForeground(Color.BLACK);
	    table.setFocusable(false);	    
		add(scrollpane,BorderLayout.CENTER);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		add(toolBar, BorderLayout.NORTH);
				
		saveButton = new JButton("");
		saveButton.setToolTipText("export to a txt file");
		saveButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//saveContentToTxtFile();
			}
		});
		saveButton.setFocusable(false);
		//saveButton.setIcon(new ImageIcon(ErrorTablePanel.class.getResource("/resources/icon/export-16x16.png")));
		//toolBar.add(saveButton);
		
		errorMessage = new JLabel("    (0 errors)");
		errorMessage.setPreferredSize(new Dimension(100, 25));
		//toolBar.add(errorMessage);		
	}
	
	public static String saveTxtLocation(Component frame, String lastLocation)
	{
		JFileChooser fileChooser = new JFileChooser(lastLocation);
		fileChooser.setDialogTitle("Export");
		FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("Text Document (*.txt)", "txt");
		fileChooser.addChoosableFileFilter(txtFilter);
		fileChooser.setFileFilter(txtFilter);
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) 
		{
			if (fileChooser.getFileFilter() == txtFilter) 
			{
				String path = fileChooser.getSelectedFile().getPath();
				if (path.contains(".txt"))
					return fileChooser.getSelectedFile().getPath();
				else
					return fileChooser.getSelectedFile().getPath()+".txt";				
			}
		}
		return null;
	}
	
	public void saveContentToTxtFile (Component parent)
    {    	
    	String path = saveTxtLocation(parent, null);
    	
    	if(path!=null)
		try {
			
			FileUtil.writeToFile(
				errorMessage.getText().trim()+"\n"+
				"------------------------------------------------------------"+"\n"+
				content, 
				path
			);
		
		} catch (IOException e) {			
			e.printStackTrace();
		}    	
    }
}
