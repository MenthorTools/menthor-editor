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

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import net.menthor.editor.v2.ui.icon.IconMap;
import net.menthor.editor.v2.ui.icon.IconType;

public class FindHeader extends JPanel {

	private static final long serialVersionUID = -4542364815581324052L;
	
	protected JTextField textField;
	protected JButton btnRun;
	
	public String getText(){ return textField.getText(); }	
	public JTextField getTextField() { return textField; }	
	public JButton getRunButton() { return btnRun; }
	
	public FindHeader(){
		setBackground(Color.LIGHT_GRAY);		
		textField = new JTextField();
		textField.setColumns(10);		
		btnRun = new JButton("");
		btnRun.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_SEARCH));
		btnRun.setBackground(Color.LIGHT_GRAY);
		btnRun.setFocusable(false);		
		JLabel lblTerm = new JLabel("Find Term:");		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTerm, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRun, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(364, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTerm, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRun, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);		
		setLayout(groupLayout);
		setPreferredSize(new Dimension(710, 44));
	}
}
