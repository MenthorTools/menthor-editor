package net.menthor.editor.v2.toolbars;

import java.awt.Color;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconType;

public class MainToolbar extends BaseToolBar {

	private static final long serialVersionUID = 8870790907921523710L;
	
	private static Color background = null; //Color.WHITE;
	
	/** constructor */
	public MainToolbar(CommandListener listener){
		super(listener, background, 32, 32);
		setBackground(background);
		createButton(IconType.MENTHOR_DOC, CommandType.NEW_PROJECT, background);
		createButton(IconType.MENTHOR_FOLDER,CommandType.OPEN_PROJECT, background);	
		createButton(IconType.MENTHOR_SAVE, CommandType.SAVE_PROJECT, background);
		createButton(IconType.MENTHOR_SEARCH,CommandType.SEARCH_TERM, background);		
		createButton(IconType.MENTHOR_CHECK,CommandType.CHECK_SYNTAX, background);
		createButton(IconType.MENTHOR_STATS,CommandType.COLLECT_STATISTICS, background);
		createButton(IconType.MENTHOR_PLAY, CommandType.SIMULATE, background);
		createButton(IconType.MENTHOR_SEMANTIC_WEB, CommandType.IMPLEMENT_IN_OWL, background);				
		enableAll(false);
	}	
}
