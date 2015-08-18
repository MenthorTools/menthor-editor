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

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public abstract class BaseApproachPane extends JPanel {

	private static final long serialVersionUID = 2408763450380277965L;
	
	@SuppressWarnings("rawtypes")
	protected JComboBox approachesCombo;
	protected JTextPane descriptionTextPane;	
	
	//====================================================
	//Constructor and Initializer Methods 
	//====================================================
	
	public BaseApproachPane()	{
		buildUI();
	}
	
	@SuppressWarnings({ "rawtypes" })
	private void buildUI(){
		setBorder(new TitledBorder(null, "Approach", TitledBorder.LEADING, TitledBorder.TOP, null, null));		
		approachesCombo = new JComboBox();		
		approachesCombo.setOpaque(false);
		approachesCombo.setFocusable(false);				
		descriptionTextPane = new JTextPane();
		descriptionTextPane.setBackground(UIManager.getColor("Panel.background"));		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(descriptionTextPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
						.addComponent(approachesCombo, Alignment.LEADING, 0, 418, Short.MAX_VALUE))
					.addContainerGap())
		);		
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(approachesCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(descriptionTextPane, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
					.addGap(10))
		);
		setLayout(groupLayout);
	}	
}
