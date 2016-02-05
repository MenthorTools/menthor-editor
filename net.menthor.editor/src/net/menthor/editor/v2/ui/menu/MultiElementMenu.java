package net.menthor.editor.v2.ui.menu;

import java.util.ArrayList;

import org.tinyuml.umldraw.shared.UmlDiagramElement;

import net.menthor.editor.v2.commands.ICommandListener;

public class MultiElementMenu extends GenericMenu<ArrayList<UmlDiagramElement>> {

	private static final long serialVersionUID = -1814132796163307505L;
	
	public MultiElementHelper helper;
	
	public MultiElementMenu(ICommandListener listener, String text, ArrayList<UmlDiagramElement> elements) {
		super(listener, text, elements);
		helper = new MultiElementHelper(elements);
	}
	
	static ArrayList<UmlDiagramElement> setUpList(UmlDiagramElement element){
		ArrayList<UmlDiagramElement> elements = new ArrayList<UmlDiagramElement>();
		elements.add(element);
		return elements;
	}

	
	
}
