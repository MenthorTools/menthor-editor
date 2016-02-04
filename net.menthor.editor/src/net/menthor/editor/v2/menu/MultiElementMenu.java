package net.menthor.editor.v2.menu;

import java.util.ArrayList;

import org.tinyuml.umldraw.shared.UmlDiagramElement;

import net.menthor.editor.v2.commands.CommandListener;

public class MultiElementMenu extends BaseMenu<ArrayList<UmlDiagramElement>> {

	private static final long serialVersionUID = -1814132796163307505L;
	
	public MultiElementHelper helper;
	
	public MultiElementMenu(CommandListener listener, String text, ArrayList<UmlDiagramElement> elements) {
		super(listener, text, elements);
		helper = new MultiElementHelper(elements);
	}
	
	static ArrayList<UmlDiagramElement> setUpList(UmlDiagramElement element){
		ArrayList<UmlDiagramElement> elements = new ArrayList<UmlDiagramElement>();
		elements.add(element);
		return elements;
	}

	
	
}
