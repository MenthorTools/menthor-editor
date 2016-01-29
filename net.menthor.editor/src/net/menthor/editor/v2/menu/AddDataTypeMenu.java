package net.menthor.editor.v2.menu;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconType;
import net.menthor.editor.v2.types.DataType;

public class AddDataTypeMenu extends BaseMenu {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public AddDataTypeMenu(CommandListener listener, String text){
		super(listener, text);
		build();
	}
	public AddDataTypeMenu(CommandListener listener){
		super(listener, "Add DataType");
		build();
	}
	
	public void build(){
		createMenuItem(DataType.DATATYPE.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_DATATYPE);
		createMenuItem(DataType.ENUMERATION.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_ENUMERATION);
		createMenuItem(DataType.PRIMITIVETYPE.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_PRIMITIVETYPE);
		createMenuItem(DataType.INTEGERINTERVALDIMENSION.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_INTEGER_INTERVAL_DIMENSION);
		createMenuItem(DataType.INTEGERORDINALDIMENSION.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_INTEGER_ORDINAL_DIMENSION);
		createMenuItem(DataType.INTEGERRATIONALDIMENSION.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_INTEGER_RATIONAL_DIMENSION);
		createMenuItem(DataType.DECIMALRATIONALDIMENSION.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_DECIMAL_RATIONAL_DIMENSION);
		createMenuItem(DataType.DECIMALORDINALDIMENSION.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_DECIMAL_ORDINAL_DIMENSION);
		createMenuItem(DataType.DECIMALINTERVALDIMENSION.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_DECIMAL_INTERVAL_DIMENSION);
		createMenuItem(DataType.STRINGNOMINALSTRUCTURE.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_STRING_NOMINAL_STRUCTURE);
		createMenuItem(DataType.MEASUREMENTDOMAIN.getName(), IconType.MENTHOR_CLASS, CommandType.ADD_MEASUREMENT_DOMAIN);
		sort();
	}
}
