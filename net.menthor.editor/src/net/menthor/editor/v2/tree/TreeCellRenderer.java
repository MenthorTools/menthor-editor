package net.menthor.editor.v2.tree;

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

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;

import it.cnr.imaa.essi.lablib.gui.checkboxtree.CheckboxTree;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.CheckboxTreeCellRenderer;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.TreeCheckingModel;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.icon.IconMap;
import net.menthor.editor.v2.icon.IconType;

public class TreeCellRenderer extends DefaultTreeCellRenderer implements CheckboxTreeCellRenderer {

	private static final long serialVersionUID = 1L;
	
	public JCheckBox checkbox = new JCheckBox();
	public JPanel panel = new JPanel();
	public JLabel label = new JLabel();    	
	public boolean checkBoxVisible=true;
	
	@Override
	public boolean isOnHotspot(int x, int y) { return (checkbox.getBounds().contains(x, y)); }
	
	public TreeCellRenderer(boolean checkBoxVisible){
		super();    		
		this.checkBoxVisible=checkBoxVisible;
		label.setFocusable(true);
		label.setOpaque(true);		
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(BorderLayout.WEST,checkbox);
		panel.add(BorderLayout.CENTER,label);		
		checkbox.setBackground(UIManager.getColor("Tree.textBackground"));    		
		panel.setBackground(UIManager.getColor("Tree.textBackground"));		    		
	}
   
	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus)
	{
		Object obj = ((DefaultMutableTreeNode)value).getUserObject();
	
		if(obj instanceof RefOntoUML.Class) label.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_CLASS));
		else if(obj instanceof RefOntoUML.PrimitiveType) label.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_CLASS));
		else if(obj instanceof RefOntoUML.Enumeration) label.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_CLASS));
		else if(obj instanceof RefOntoUML.DataType) label.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_CLASS));
		else if(obj instanceof RefOntoUML.componentOf) label.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_COMPONENTOF));
		else if(obj instanceof RefOntoUML.memberOf) label.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_MEMBEROF));
		else if(obj instanceof RefOntoUML.subCollectionOf) label.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_SUBCOLLECTIONOF));
		else if(obj instanceof RefOntoUML.subQuantityOf) label.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_SUBQUANTITYOF));
		else if(obj instanceof RefOntoUML.Derivation) label.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_DERIVATION));
		else if(obj instanceof RefOntoUML.Association) label.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_ASSOCIATION));
		else if(obj instanceof RefOntoUML.Generalization) label.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_GENERALIZATION));
		else if(obj instanceof RefOntoUML.GeneralizationSet) label.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_GENERALIZATIONSET));
		else if(obj instanceof RefOntoUML.Package) label.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_PACKAGE));
		else if(obj instanceof RefOntoUML.Comment) label.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_COMMENT));
		else if(obj instanceof RefOntoUML.Constraintx) label.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_NOTE));			
		else if(obj instanceof OntoumlDiagram) label.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_DIAGRAM));		
		else if(obj instanceof OclDocument) label.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_CONSTRAINTDOC));
		else label.setIcon(null);
		
		label.setText(value.toString());		
		TreeCheckingModel checkingModel = ((CheckboxTree)tree).getCheckingModel();
	   	TreePath path = tree.getPathForRow(row);	   	
	   	boolean enabled = checkingModel.isPathEnabled(path);
	   	boolean checked = checkingModel.isPathChecked(path);
	   	boolean grayed = checkingModel.isPathGreyed(path);	   	
	   	checkbox.setVisible(checkBoxVisible);
	   	checkbox.setEnabled(enabled);	   		   	
	   	if (grayed){
	   		label.setForeground(Color.BLACK);	   		
	   	}else{
	   		label.setForeground(Color.BLACK);
	   	}	   	
	   	checkbox.setSelected(checked);	   	
	   	if(!checked) {
	   		if (selected) {
				//label.setBackground(Color.LIGHT_GRAY);
				label.setBackground(UIManager.getColor("Tree.selectionBackground"));
			}else{
				label.setBackground(UIManager.getColor("Tree.textBackground"));
				label.setBorder(null);
			}
	   		label.setForeground(Color.RED);
	   	}else {
	   		if (selected) {
	   			//label.setBackground(Color.LIGHT_GRAY);
	   			label.setBackground(UIManager.getColor("Tree.selectionBackground"));
			}else{
				label.setBackground(UIManager.getColor("Tree.textBackground"));
				label.setBorder(null);
			}   		
	   	}	   	
	   	return panel;	   	
	}	
}

