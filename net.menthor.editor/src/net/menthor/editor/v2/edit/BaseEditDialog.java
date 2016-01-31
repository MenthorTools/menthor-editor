package net.menthor.editor.v2.edit;

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
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import net.menthor.editor.v2.icon.IconMap;
import net.menthor.editor.v2.icon.IconType;

public class BaseEditDialog extends JDialog {

	private static final long serialVersionUID = 1L;
		
	protected JTabbedPane tabbedPane;
	protected JPanel btnPane;	
	protected JButton btnConfirm;
	protected JButton btnCancel;
		
	public void selectTab (int index){
		tabbedPane.setSelectedIndex(index);
	}
	
	public void confirm(ActionEvent arg0){}
	
	public BaseEditDialog(final JDialog parent, boolean modal){
		super(parent, modal);
		buildUI();
		
	}
	
	public BaseEditDialog(final JFrame parent, boolean modal){
		super(parent, modal);	
		buildUI();		
	}	
	
	private void buildUI(){
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);		
		setIconImage(IconMap.getInstance().getImage(IconType.MENTHOR_EDIT));
		setSize(new Dimension(470, 450));		
		getContentPane().setLayout(new BorderLayout(0, 0));		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new EmptyBorder(0, 0, 0, 0));		
		btnPane = new JPanel();
		btnPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnPane.setPreferredSize(new Dimension(100, 40));
		btnConfirm = new JButton("Ok");		
		btnConfirm.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				confirm(e);
				dispose();
			}
		});		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});		
		getContentPane().add(btnPane, BorderLayout.SOUTH);
		btnPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnPane.add(btnConfirm);
		btnPane.add(btnCancel);
		getContentPane().add(tabbedPane);
	}
}
