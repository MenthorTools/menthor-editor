package net.menthor.editor.v2.menu;

import java.util.ArrayList;

import javax.swing.JPopupMenu;

import org.tinyuml.umldraw.shared.UmlDiagramElement;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class AlignMenu extends MultiElementMenu {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public AlignMenu(CommandListener listener, String text, ArrayList<UmlDiagramElement> elements, JPopupMenu parent){
		super(listener, text,elements);	

		createMenuItem("Top", CommandType.ALIGN_TOP);				
		createMenuItem("Bottom", CommandType.ALIGN_BOTTOM);
		createMenuItem("Left", CommandType.ALIGN_LEFT);
		createMenuItem("Right", CommandType.ALIGN_RIGHT);
		createMenuItem("Horizontal", CommandType.ALIGN_HORIZONTAL);
		createMenuItem("Vertical", CommandType.ALIGN_VERTICAL);
		
		parent.add(this);
	}
	
	public AlignMenu(CommandListener listener, ArrayList<UmlDiagramElement> elements, JPopupMenu parent){
		this(listener, "Align", elements, parent);		
  	}
}
