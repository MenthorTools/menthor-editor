package net.menthor.editor.v2.ui.menu;

import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultMutableTreeNode;

import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.types.DataType;
import net.menthor.editor.v2.ui.icon.IconType;

public class AddDataTypeMenu extends GenericMenu<DefaultMutableTreeNode> {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public AddDataTypeMenu(ICommandListener listener, String text, DefaultMutableTreeNode treeNode, JPopupMenu parent){
		super(listener, text, treeNode);

		createMenuItem(DataType.DATATYPE.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_DATATYPE);
		createMenuItem(DataType.ENUMERATION.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_ENUMERATION);
		createMenuItem(DataType.PRIMITIVETYPE.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_PRIMITIVETYPE);
		createMenuItem(DataType.INTEGERINTERVAL_DIMENSION.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_INTEGERINTERVAL_DIMENSION);
		createMenuItem(DataType.INTEGERORDINAL_DIMENSION.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_INTEGERORDINAL_DIMENSION);
		createMenuItem(DataType.INTEGERRATIONAL_DIMENSION.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_INTEGERRATIONAL_DIMENSION);
		createMenuItem(DataType.DECIMALRATIONAL_DIMENSION.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_DECIMALRATIONAL_DIMENSION);
		createMenuItem(DataType.DECIMALORDINAL_DIMENSION.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_DECIMALORDINAL_DIMENSION);
		createMenuItem(DataType.DECIMALINTERVAL_DIMENSION.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_DECIMALINTERVAL_DIMENSION);
		createMenuItem(DataType.STRINGNOMINAL_STRUCTURE.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_STRINGNOMINAL_STRUCTURE);
		createMenuItem(DataType.MEASUREMENT_DOMAIN.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_MEASUREMENT_DOMAIN);
		sort();
		
		parent.add(this);
		
	}
	public AddDataTypeMenu(ICommandListener listener, DefaultMutableTreeNode treeNode, JPopupMenu parent){
		this(listener, "Add DataType", treeNode, parent);
	}
}
