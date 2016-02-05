package net.menthor.editor.v2.ui.menu;

import java.util.ArrayList;

import javax.swing.JCheckBoxMenuItem;

import org.tinyuml.umldraw.shared.UmlDiagramElement;

import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.ui.icon.IconType;

public class MultiElementPopupMenu extends GenericPopupMenu<ArrayList<UmlDiagramElement>> {

	private static final long serialVersionUID = 1L;
	
	public MultiElementHelper helper;
	
	protected LineStyleMenu styleMenu;
	protected VisibilityMenu visMenu;
	protected AlignMenu alignMenu;
	protected GenSetMenu genSetMenu;
	protected ColorMenu colorMenu;
	protected JCheckBoxMenuItem attrItem;
	
	
	public MultiElementPopupMenu(ICommandListener listener, ArrayList<UmlDiagramElement> elements) {
		super(listener,elements);				
		helper = new MultiElementHelper(elements);
		
		boolean addSeparator = false;
		
		createMenuItem("Duplicate", CommandType.DUPLICATE);
		createMenuItem("Copy", CommandType.COPY);
		
		addSeparator();
		
		createMenuItem("Delete from Diagram",IconType.MENTHOR_ERASE, CommandType.ERASE);
		createMenuItem("Delete from Model",IconType.MENTHOR_DELETE, CommandType.DELETE);
		
		addSeparator();
		
		visMenu = new VisibilityMenu(listener, elements, this);
		
		addSeparator();
		
		if(helper.hasConnection()){	
			addSeparator = true;
			
			styleMenu = new LineStyleMenu(listener, elements, this);
			createMenuItem("Reset Points", CommandType.RESET_POINTS);
		}
		
		if(helper.hasClass()){
			if(addSeparator)
				addSeparator();
			
			colorMenu = new ColorMenu(listener, elements, this);
			alignMenu = new AlignMenu(listener, elements, this);
		}
		
		if(helper.hasGeneralization()){
			addSeparator();
			genSetMenu = new GenSetMenu(listener, elements, this);
		}
					
	}
}

