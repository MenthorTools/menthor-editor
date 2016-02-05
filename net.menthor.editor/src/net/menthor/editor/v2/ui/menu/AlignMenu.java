package net.menthor.editor.v2.ui.menu;

import java.util.ArrayList;

import javax.swing.JPopupMenu;

import org.tinyuml.umldraw.shared.UmlDiagramElement;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class AlignMenu extends MultiElementMenu {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public AlignMenu(CommandListener listener, String text, ArrayList<UmlDiagramElement> elements, JPopupMenu parent){
		super(listener, text,elements);	
		
		createMenuItem("Horizontal Center", CommandType.ALIGN_HORIZONTAL);
		createMenuItem("Vertical Center", CommandType.ALIGN_VERTICAL);
		createMenuItem("Top", CommandType.ALIGN_TOP);				
		createMenuItem("Bottom", CommandType.ALIGN_BOTTOM);
		createMenuItem("Left", CommandType.ALIGN_LEFT);
		createMenuItem("Right", CommandType.ALIGN_RIGHT);
		
		parent.add(this);
	}
	
	public AlignMenu(CommandListener listener, ArrayList<UmlDiagramElement> elements, JPopupMenu parent){
		this(listener, "Align", elements, parent);		
  	}
}
