package net.menthor.editor.v2.settings;

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
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public abstract class BaseDestinationPane extends JPanel {

	private static final long serialVersionUID = 5020467392354283714L;
	
	protected JPanel radioPane;
	protected JPanel comboPane;
	protected JLabel pathLabel;
	protected JButton browseButton;
	protected JTextField pathText;	
	protected ButtonGroup group;	
	protected String fileDescription;
	protected String fileExtension;
	
	//====================================================
	//Constructor and Initializer Methods 
	//====================================================
	
	public BaseDestinationPane(String fileDescription, String fileExtension) 
	{
		this.fileDescription = fileDescription;
		this.fileExtension = fileExtension;
		buildUI();
	}
	
	private void buildUI(){
		setBorder(new TitledBorder(null, "Destination", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(5, 5));				
		group = new ButtonGroup();
		radioPane = new JPanel();
		add(radioPane, BorderLayout.SOUTH);		
		comboPane = new JPanel();
		add(comboPane, BorderLayout.NORTH);
		comboPane.setLayout(new BorderLayout(10, 10));		
		pathLabel = new JLabel("File Path:");
		pathLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		comboPane.add(pathLabel, BorderLayout.WEST);
		pathText = new JTextField();
		pathText.setBackground(Color.WHITE);
		comboPane.add(pathText, BorderLayout.CENTER);
		pathText.setColumns(10);
		pathText.setEditable(false);		
		browseButton = new JButton("...");
		browseButton.setPreferredSize(new Dimension(35, 23));
		comboPane.add(browseButton, BorderLayout.EAST);
		browseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getFilePath();
			}
		});
	}
	
	//====================================================
	//Getters & Setters 
	//====================================================
	
	public String getPath() { return pathText.getText(); }	
	public void setPath(String text) { pathText.setText(text); }
	
	protected void enableFileChooser(boolean flag){
		pathText.setEnabled(flag);
		pathText.setEditable(flag);
		browseButton.setEnabled(flag);
		pathLabel.setEnabled(flag);
	}
	
	protected void getFilePath(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Destination");
		FileNameExtensionFilter filter = new FileNameExtensionFilter(fileDescription, fileExtension);		
		fileChooser.addChoosableFileFilter(filter);
		fileChooser.setFileFilter(filter);
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
			File selectedFile = fileChooser.getSelectedFile();
			String filePath = selectedFile.getAbsolutePath();
			if(!filePath.endsWith("."+fileExtension)) filePath += "."+fileExtension;				
			pathText.setText(filePath);
		}
	}
}
