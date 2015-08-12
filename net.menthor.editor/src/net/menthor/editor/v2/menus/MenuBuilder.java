package net.menthor.editor.v2.menus;

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

import javax.swing.JPopupMenu;

import net.menthor.editor.v2.commands.CommandListener;

public class MenuBuilder {
	
	public static ChangeRelationshipMenu buildChangeRelationshipTo(CommandListener listener, JPopupMenu parent, String text)
	{	
		ChangeRelationshipMenu changeRelMenu = new ChangeRelationshipMenu(listener,text);		
		parent.add(changeRelMenu);
		return changeRelMenu;
	}
	
	public static ChangeClassMenu buildChangeClassTo(CommandListener listener, JPopupMenu parent, String text)
	{	
		ChangeClassMenu changeClassMenu = new ChangeClassMenu(listener, text);		
		parent.add(changeClassMenu);
		return changeClassMenu;
	}
	
	public static AddClassMenu buildAddClass(CommandListener listener, JPopupMenu parent, String text)
	{	
		AddClassMenu addClassMenu = new AddClassMenu(listener, text);		
		parent.add(addClassMenu);
		return addClassMenu;
	}
	
	public static AddRelationshipMenu buildAddRelationship(CommandListener listener, JPopupMenu parent, String text)
	{	
		AddRelationshipMenu addRelationMenu = new AddRelationshipMenu(listener, text);
		parent.add(addRelationMenu);
		return addRelationMenu;
	}
	
	public static AddDataTypeMenu buildAddDataType(CommandListener listener, JPopupMenu parent, String text)
	{	
		AddDataTypeMenu addDataTypeMenu = new AddDataTypeMenu(listener);
		parent.add(addDataTypeMenu);
		return addDataTypeMenu;
	}
	
	public static InvertMenu buildInvert(CommandListener listener, JPopupMenu parent, String text)
	{	
		InvertMenu invertMenu = new InvertMenu(listener, text);
		parent.add(invertMenu);
		return invertMenu;
	}
	
	public static ReadingDirectionMenu buildReadingDirection(CommandListener listener, JPopupMenu parent, String text)
	{	
		ReadingDirectionMenu directionMenu = new ReadingDirectionMenu(listener, text);
		parent.add(directionMenu);
		return directionMenu;
	}
	
	public static SourceMultiplicityMenu buildSourceMultiplicity(CommandListener listener, JPopupMenu parent, String text)
	{	
		SourceMultiplicityMenu srcMenu = new SourceMultiplicityMenu(listener, text);
		parent.add(srcMenu);
		return srcMenu;
	}
	public static TargetMultiplicityMenu buildTargetMultiplicity(CommandListener listener, JPopupMenu parent, String text)
	{	
		TargetMultiplicityMenu tgtMenu = new TargetMultiplicityMenu(listener, text);
		parent.add(tgtMenu);
		return tgtMenu;
	}
	
	public static MetaAttributeMenu buildMetaAttribute(CommandListener listener, JPopupMenu parent, String text)
	{	
		MetaAttributeMenu attrMenu = new MetaAttributeMenu(listener, text);
		parent.add(attrMenu);
		return attrMenu;
	}
	
	public static VisibilityMenu buildVisibility(CommandListener listener, JPopupMenu parent, String text)
	{	
		VisibilityMenu visibilityMenu = new VisibilityMenu(listener, text);
		parent.add(visibilityMenu);
		return visibilityMenu;
	}
	
	public static LineStyleMenu buildLineStyle(CommandListener listener, JPopupMenu parent, String text)
	{	
		LineStyleMenu styleMenu = new LineStyleMenu(listener, text);
		parent.add(styleMenu);
		return styleMenu;
	}
	
	public static AlignMenu buildAlign(CommandListener listener, JPopupMenu parent, String text)
	{	
		AlignMenu styleMenu = new AlignMenu(listener, text);
		parent.add(styleMenu);
		return styleMenu;
	}
	
	public static GenSetMenu buildGenSet(CommandListener listener, JPopupMenu parent, String text)
	{	
		GenSetMenu genSetMenu = new GenSetMenu(listener, text);
		parent.add(genSetMenu);
		return genSetMenu;
	}
	
	public static ColorMenu buildBackground(CommandListener listener, JPopupMenu parent, String text)
	{	
		ColorMenu colorMenu = new ColorMenu(listener, text);
		parent.add(colorMenu);
		return colorMenu;
	}
}
