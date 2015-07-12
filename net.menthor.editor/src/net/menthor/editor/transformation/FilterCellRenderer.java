package net.menthor.editor.transformation;

import it.cnr.imaa.essi.lablib.gui.checkboxtree.CheckboxTree;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.CheckboxTreeCellRenderer;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.TreeCheckingModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.util.RefOntoUMLElement;

public class FilterCellRenderer extends DefaultTreeCellRenderer implements CheckboxTreeCellRenderer {

	private static final long serialVersionUID = 1L;
	
	public JCheckBox checkbox = new JCheckBox();
	public JPanel panel = new JPanel();
	public JLabel label = new JLabel();    	
	
	@Override
	public boolean isOnHotspot(int x, int y) { return (checkbox.getBounds().contains(x, y)); }
	
	public FilterCellRenderer() 
	{
		super();    		
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
		if(obj instanceof StructureDiagram)
		{							
			label.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resources/icons/x16/tree/diagram.png")));
		}
		if(obj instanceof RefOntoUMLElement)
		{			
			EObject element = ((RefOntoUMLElement)obj).getElement();
			String elementType = new String();
			if (element != null) elementType = element.getClass().toString().replace("class " +"RefOntoUML.impl.", "").replace("Impl", "");				
			if (elementType.toLowerCase().equals("property") || elementType.toLowerCase().equals("enumerationliteral"))
    			label.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resources/icons/x16/tree/property.gif")));
    		else
    			label.setIcon(new ImageIcon(getClass().getClassLoader().getResource("resources/icons/x16/tree/"+elementType.toLowerCase()+".png")));
		}	
		
		label.setText(value.toString());
		
		TreeCheckingModel checkingModel = ((CheckboxTree)tree).getCheckingModel();
	   	TreePath path = tree.getPathForRow(row);	   	
	   	boolean enabled = checkingModel.isPathEnabled(path);
	   	boolean checked = checkingModel.isPathChecked(path);
	   	boolean grayed = checkingModel.isPathGreyed(path);	   	
	   	
	   	checkbox.setVisible(true);
	   	checkbox.setEnabled(enabled);	   	    	   	
	   		   	
	   	if (grayed){
	   		label.setForeground(Color.lightGray);
	   		label.setForeground(Color.black);
	   	}else{
	   		label.setForeground(Color.black);
	   	}	   	    	   	
	   	
	   	checkbox.setSelected(checked);	   	
	   	if(!checked) {
	   		if (selected) {
				label.setBackground(Color.LIGHT_GRAY);
				//label.setBackground(PaletteAccordion.getHoverItemBackground());			
				//label.setBorder(PaletteAccordion.getHoverItemBorder());
			}else{
				label.setBackground(UIManager.getColor("Tree.textBackground"));
				label.setBorder(null);
			}
	   		//label.setForeground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_ORANGE));
	   		label.setForeground(Color.RED);
	   	}else {
	   		if (selected) {
	   			label.setBackground(Color.LIGHT_GRAY);
				//label.setBackground(UIManager.getColor("List.selectionBackground"));
				//label.setBackground(PaletteAccordion.getHoverItemBackground());			
				//label.setBorder(PaletteAccordion.getHoverItemBorder());
			}else{
				label.setBackground(UIManager.getColor("Tree.textBackground"));
				label.setBorder(null);
			}   		
	   	}
	   	
	   	return panel;	   	
	}	
}

