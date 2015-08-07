package net.menthor.editor.v2.toolbars;

import java.awt.Color;

import javax.swing.UIManager;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconType;

public class ProjectToolBar extends BaseToolBar {

	private static final long serialVersionUID = 1809611076455179596L;

	private static Color background = UIManager.getColor("Panel.background"); //Color.WHITE;
	
	public ProjectToolBar(CommandListener listener){
		super(listener, background, 16, 16);
		setBackground(background);
		createButton(IconType.MENTHOR_UP, CommandType.MOVE_UP_TREE, background);
		createButton(IconType.MENTHOR_DOWN, CommandType.MOVE_DOWN_TREE, background);
	}	
}