package net.menthor.editor.popupmenu;

import javax.swing.JPopupMenu;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.menus.AddClassMenu;
import net.menthor.editor.v2.menus.AddDataTypeMenu;
import net.menthor.editor.v2.menus.AddRelationshipMenu;
import net.menthor.editor.v2.menus.ChangeClassMenu;
import net.menthor.editor.v2.menus.ChangeRelationshipMenu;

public class MenuBuilder {
	
	public static ChangeRelationshipMenu buildChangeRelationshipTo(CommandListener listener, JPopupMenu parent)
	{	
		ChangeRelationshipMenu changeRelMenu = new ChangeRelationshipMenu(listener);		
		parent.add(changeRelMenu);
		return changeRelMenu;
	}
	
	public static ChangeClassMenu buildChangeClassTo(CommandListener listener, JPopupMenu parent)
	{	
		ChangeClassMenu changeClassMenu = new ChangeClassMenu(listener);		
		parent.add(changeClassMenu);
		return changeClassMenu;
	}
	
	public static AddClassMenu buildAddClass(CommandListener listener, JPopupMenu parent)
	{	
		AddClassMenu addClassMenu = new AddClassMenu(listener);		
		parent.add(addClassMenu);
		return addClassMenu;
	}
	
	public static AddRelationshipMenu buildAddRelationship(CommandListener listener, JPopupMenu parent)
	{	
		AddRelationshipMenu addRelationMenu = new AddRelationshipMenu(listener);
		parent.add(addRelationMenu);
		return addRelationMenu;
	}
	
	public static AddDataTypeMenu buildAddDataType(CommandListener listener, JPopupMenu parent)
	{	
		AddDataTypeMenu addDataTypeMenu = new AddDataTypeMenu(listener);
		parent.add(addDataTypeMenu);
		return addDataTypeMenu;
	}	
}
