package net.menthor.editor.v2.ui.menu;

import java.util.ArrayList;

import javax.swing.JPopupMenu;

import org.tinyuml.umldraw.shared.UmlDiagramElement;
import org.tinyuml.umldraw.shared.UmlNode;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.ui.icon.IconType;

public class ColorMenu extends MultiElementMenu {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public ColorMenu(CommandListener listener, String text, ArrayList<UmlDiagramElement> elements, JPopupMenu parent){
		super(listener, text, elements);	
		
		createMenuItem("Set", IconType.MENTHOR_COLOR_CHOOSER, CommandType.SETUP_BACKGROUND_COLOR);
		
		//Can only copy the style if only one element is selected. 
		if(helper.isSimpleContext())
			createMenuItem("Copy", CommandType.COPY_BACKGROUND_COLOR);
		
		createMenuItem("Paste", CommandType.PASTE_BACKGROUND_COLOR);	
		
		parent.add(this);
	}
	
	/**Constructor with default name.*/
	public ColorMenu(CommandListener listener, ArrayList<UmlDiagramElement> elements, JPopupMenu parent){
		this(listener, "Background Color", elements, parent);		
  	}
	
	public ColorMenu(CommandListener listener, String text, UmlNode node, JPopupMenu parent){
		this(listener, text, setUpList(node), parent);	
	}
	
	/**Constructor with default name.*/
	public ColorMenu(CommandListener listener, UmlNode node, JPopupMenu parent){
		this(listener, setUpList(node), parent);		
  	}
	

}
