package net.menthor.editor.v2.menu;

import javax.swing.JPopupMenu;

import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.shared.BaseConnection;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class InvertMenu extends BaseMenu<BaseConnection> {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public InvertMenu(CommandListener listener, String text, BaseConnection connection, JPopupMenu parent){
		super(listener, text, connection);	
		
		createMenuItem("End-Points", CommandType.INVERT_END_POINTS);
		
		if(connection instanceof AssociationElement) {
			createMenuItem("End-Points Names", CommandType.INVERT_END_NAMES);
			createMenuItem("End-Points Multiplicities", CommandType.INVERT_END_MULTIPLICITIES);
			createMenuItem("End-Points Types", CommandType.INVERT_END_TYPES);
		}
		
		parent.add(this);
	}
	
	public InvertMenu(CommandListener listener, BaseConnection connection, JPopupMenu parent){
		this(listener, "Invert Ends", connection, parent);		
  	}
}
