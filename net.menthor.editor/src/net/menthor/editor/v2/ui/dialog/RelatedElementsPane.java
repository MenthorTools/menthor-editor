package net.menthor.editor.v2.ui.dialog;

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
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.Element;
import RefOntoUML.Generalization;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.v2.ui.color.ColorMap;
import net.menthor.editor.v2.ui.color.ColorType;
import net.menthor.editor.v2.ui.table.AssociationTableModel;
import net.menthor.editor.v2.ui.table.GeneralizationTableModel;
import net.menthor.editor.v2.ui.table.TableColumnAdjuster;

public class RelatedElementsPane extends JPanel {

	private static final long serialVersionUID = 1L;

	private Element element;
	
	private JLabel lblTop;		
	private JTable topTable;
	private JTable bottomTable;
	
	private JLabel lblBottom; 
	private JScrollPane topScroll;
	private JScrollPane bottomScroll;
	
	public List<Association> getAssociations(OntoUMLParser refparser){
		List<Association> assocList = new ArrayList<Association>(); 
		assocList.addAll(refparser.getDirectAssociations(element));
		assocList.addAll(refparser.getIndirectAssociations(element));
		return assocList;
	}
	
	public List<Generalization> getGeneralizations(OntoUMLParser refparser){
		ArrayList<Generalization> genList = new ArrayList<Generalization>();
		genList.addAll(refparser.getDirectGeneralizations(element));
		genList.addAll(refparser.getIndirectGeneralizations(element));
		return genList;
	}

	public void createBottomTable(OntoUMLParser refparser){
		GeneralizationTableModel genModel = new GeneralizationTableModel(this.element, getGeneralizations(refparser));
		lblBottom = new JLabel("Related generalizations:");
		bottomTable = new JTable(genModel);
		bottomTable.setBorder(new EmptyBorder(0, 0, 0, 0));		
		bottomTable.setGridColor(Color.LIGHT_GRAY);		
		bottomTable.setSelectionBackground(ColorMap.getInstance().getColor(ColorType.MENTHOR_BLUE));
		bottomTable.setSelectionForeground(Color.BLACK);
		bottomTable.setFocusable(false);	    
		bottomTable.setRowHeight(23);		
		bottomScroll = new JScrollPane(bottomTable);
		bottomScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);		
		bottomTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);		
		TableColumnAdjuster tca = new TableColumnAdjuster(bottomTable);
		tca.adjustColumns();
	}
	
	public void createTopTable(OntoUMLParser refparser){
		AssociationTableModel assocModel = new AssociationTableModel(this.element, getAssociations(refparser));
		lblTop = new JLabel("Related associations:");		
		topTable = new JTable(assocModel);		
		topTable.setBorder(new EmptyBorder(0, 0, 0, 0));		
		topTable.setGridColor(Color.LIGHT_GRAY);		
		topTable.setSelectionBackground(ColorMap.getInstance().getColor(ColorType.MENTHOR_BLUE));
		topTable.setSelectionForeground(Color.BLACK);
		topTable.setFocusable(false);	    
		topTable.setRowHeight(23);				
		topScroll = new JScrollPane(topTable);
		topScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);		
		topTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);		
		TableColumnAdjuster tca = new TableColumnAdjuster(topTable);
		tca.adjustColumns();
	}
	
	public RelatedElementsPane(Classifier element, OntoUMLParser refparser){
		setBorder(new EmptyBorder(10, 10, 10, 10));			
		this.element = element;
		
		createTopTable(refparser);
		createBottomTable(refparser);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(lblTop, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
				.addComponent(topScroll, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
				.addComponent(lblBottom, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
				.addComponent(bottomScroll, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblTop)
					.addGap(5)
					.addComponent(topScroll, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(lblBottom)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bottomScroll, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);
	}
}
