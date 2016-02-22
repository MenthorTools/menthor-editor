package net.menthor.editor.v2.ui.menu;

import java.util.List;

import javax.swing.JPopupMenu;

import org.tinyuml.umldraw.shared.UmlDiagramElement;
import org.tinyuml.umldraw.shared.UmlNode;

import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.ui.icon.IconType;

public class ColorMenu extends MultiElementMenu {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public ColorMenu(ICommandListener listener, String text, List<UmlDiagramElement> elements, JPopupMenu parent){
		super(listener, text, elements);		
		createMenuItem("Set", IconType.MENTHOR_COLOR_CHOOSER, CommandType.SET_BACKGROUND_COLOR);
		
		//Can only copy the style if only one element is selected. 
		if(helper.isSingleContext())
			createMenuItem("Copy", CommandType.COPY_BACKGROUND_COLOR);
		
		createMenuItem("Paste", CommandType.PASTE_BACKGROUND_COLOR);		
		parent.add(this);
	}
	
	public ColorMenu(ICommandListener listener, List<UmlDiagramElement> elements, JPopupMenu parent){
		this(listener, "Background Color", elements, parent);		
  	}
	
	public ColorMenu(ICommandListener listener, String text, UmlNode node, JPopupMenu parent){
		this(listener, text, setUpList(node), parent);	
	}
	
	public ColorMenu(ICommandListener listener, UmlNode node, JPopupMenu parent){
		this(listener, setUpList(node), parent);		
  	}
	

}
