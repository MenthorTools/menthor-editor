package net.menthor.editor.v2.ui.menu;

import java.util.List;

import javax.swing.JPopupMenu;

import org.tinyuml.umldraw.shared.UmlDiagramElement;

import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.commands.ICommandListener;

public class AlignMenu extends MultiElementMenu {

	private static final long serialVersionUID = 3797953970276009760L;
	
	public AlignMenu(ICommandListener listener, String text, List<UmlDiagramElement> elements, JPopupMenu parent){
		super(listener, text,elements);			
		createMenuItem("Horizontal Center", CommandType.ALIGN_HORIZONTAL);
		createMenuItem("Vertical Center", CommandType.ALIGN_VERTICAL);
		createMenuItem("Top", CommandType.ALIGN_TOP);				
		createMenuItem("Bottom", CommandType.ALIGN_BOTTOM);
		createMenuItem("Left", CommandType.ALIGN_LEFT);
		createMenuItem("Right", CommandType.ALIGN_RIGHT);
		
		parent.add(this);
	}
	
	public AlignMenu(ICommandListener listener, List<UmlDiagramElement> elements, JPopupMenu parent){
		this(listener, "Align", elements, parent);		
  	}
}
