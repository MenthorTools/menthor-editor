package net.menthor.editor.v2.menu;

import java.util.ArrayList;

import javax.swing.JPopupMenu;

import org.tinyuml.umldraw.GeneralizationElement;
import org.tinyuml.umldraw.shared.UmlDiagramElement;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class GenSetMenu extends MultiElementMenu {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public GenSetMenu(CommandListener listener, String text, ArrayList<UmlDiagramElement> elements, JPopupMenu parent){
		super(listener, text, elements);	

		createMenuItem("Add", CommandType.ADD_GEN_SET_DIAGRAM);
		createMenuItem("Remove", CommandType.DELETE_GEN_SET_DIAGRAM);		
		sort();
		
		parent.add(this);
	}
	
	public GenSetMenu(CommandListener listener, ArrayList<UmlDiagramElement> elements, JPopupMenu parent){
		this(listener, "Generalization Set", elements, parent);		
  	}
	
	public GenSetMenu(CommandListener listener, GeneralizationElement generalization, JPopupMenu parent){
		this(listener, setUpList(generalization), parent);		
  	}
	
	public GenSetMenu(CommandListener listener,  String text, GeneralizationElement generalization, JPopupMenu parent){
		this(listener, text, setUpList(generalization), parent);		
  	}
	
}
