package net.menthor.editor.v2.ui.dialog.help;

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
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import net.menthor.editor.v2.ui.manager.MessageManager;

public class LicensesDialog extends JDialog {

	private static final long serialVersionUID = 3853224908119790266L;
	
	@SuppressWarnings("unused")
	private Component parent;
	@SuppressWarnings("rawtypes")
	private JComboBox choices;
	private JTextArea textArea;
	private JButton btnClose;
	private JScrollPane scrollPane;
	
	public static void open(Component parent){
		try {			
			LicensesDialog dialog = new LicensesDialog(parent);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(parent);						
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public LicensesDialog (Component parent)
	{	
		super((Frame) parent);		
		this.parent = parent;		
		choices = new JComboBox();
		choices.setModel(new DefaultComboBoxModel(new String[] {"TinyUML","Alloy", "Kodkod", "JavaCup", "SAT4J", "ZChaff", "MiniSat","AutoComplete","RSyntaxTextArea"}));
		choices.setPreferredSize(new Dimension(150, 20));
		choices.setFocusable(false);
		choices.addActionListener(new ActionListener(){
       		public void actionPerformed(ActionEvent event){       
       			String value = (String)choices.getSelectedItem();
       			setLicense(value);
       		}
		});				
		JLabel labelSee = new JLabel("See copyrights: ");		
		textArea = new JTextArea();		
		textArea.setEditable(false);
		textArea.setCaretPosition(0);		
		scrollPane = new JScrollPane();		
		scrollPane.setPreferredSize(new Dimension(400, 200));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);		
		scrollPane.setViewportView(textArea);		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener(){
       		public void actionPerformed(ActionEvent event){
       			dispose();
       		}
		});
		Panel buttonsPanel = new Panel();
		buttonsPanel.add(btnClose);		
		JPanel choicesPanel = new JPanel();		
		FlowLayout flowLayout = (FlowLayout) choicesPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);	
		choicesPanel.add(labelSee);		
		choicesPanel.add(BorderLayout.NORTH,choices);		
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(choicesPanel, BorderLayout.NORTH);
		getContentPane().add(buttonsPanel, BorderLayout.SOUTH);			
		setTitle("Licenses");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setPreferredSize(new Dimension(600, 400));		
		choices.setSelectedIndex(0);		
		setLicense((String)choices.getSelectedItem());		
		repaint();
		validate();
		pack();		
	}

	@SuppressWarnings("unused")
	public void setLicense(String value){		
		try{			
			InputStream is = LicensesDialog.class.getClassLoader().getResourceAsStream("resources/licenses/"+ value + ".txt");
			if(is == null) is = new FileInputStream("src/resources/licenses/"+ value + ".txt");			
			StringBuffer result = new StringBuffer();
			byte[] b = new byte[is.available()];
			is.read(b);
	        String text = new String(b);			
			textArea.setText(text);
			textArea.setCaretPosition(0);			
		}catch(IOException e){
			MessageManager.get().showError(e, "Reading License", "Could not display any license due to an internal error.");
		}
	}
}
