package net.menthor.editor.v2.menus;

import java.util.List;

import org.tinyuml.umldraw.AssociationElement;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconType;

public class MultiConnectionPopupMenu extends BasePopupMenu {

	private static final long serialVersionUID = 1L;
	
	private LineStyleMenu styleMenu;
	private VisibilityMenu visMenu;
	@SuppressWarnings("unused")
	private AlignMenu alignMenu;
	private GenSetMenu genSetMenu;
	
	private boolean someShowEndNames(List<Object> objs){
		for(Object o: objs){
			if(o instanceof AssociationElement)
				if(((AssociationElement)o).showRoles()) return true;
		}
		return false;
	}
	
	private boolean someShowMultiplicities(List<Object> objs){
		for(Object o: objs){
			if(o instanceof AssociationElement)
				if(((AssociationElement)o).showMultiplicities()) return true;
		}
		return false;
	}
	
	private boolean someShowName(List<Object> objs){
		for(Object o: objs){
			if(o instanceof AssociationElement)
				if(((AssociationElement)o).showName()) return true;
		}
		return false;
	}
	
	private boolean someShowRedefining(List<Object> objs){
		for(Object o: objs){
			if(((AssociationElement)o).showRedefining()) return true;
		}
		return false;
	}
	
	private boolean someShowSubsetting(List<Object> objs){
		for(Object o: objs){
			if(o instanceof AssociationElement)
				if(((AssociationElement)o).showSubsetting()) return true;
		}
		return false;
	}
	
	private boolean someShowStereotype(List<Object> objs){
		for(Object o: objs){
			if(o instanceof AssociationElement)
				if(((AssociationElement)o).showOntoUmlStereotype()) return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setContext(Object object){
		styleMenu.setContext(object);
		visMenu.setContext(object);
		genSetMenu.setContext(object);
		
		//we do not set the context for this menu
		//the context is the set of selected elements of the diagram
		//alignMenu.setContext(object);
		
		if(context instanceof AssociationElement){
			visMenu.getMenuItem(CommandType.SHOW_END_POINT_NAMES).setSelected(someShowEndNames((List<Object>)object));
			visMenu.getMenuItem(CommandType.SHOW_MULTIPLICITIES).setSelected(someShowMultiplicities((List<Object>)object));
			visMenu.getMenuItem(CommandType.SHOW_NAME).setSelected(someShowName((List<Object>)object));
			visMenu.getMenuItem(CommandType.SHOW_REDEFINITIONS).setSelected(someShowRedefining((List<Object>)object));
			visMenu.getMenuItem(CommandType.SHOW_SUBSETTING).setSelected(someShowSubsetting((List<Object>)object));
			visMenu.getMenuItem(CommandType.SHOW_STEREOTYPE).setSelected(someShowStereotype((List<Object>)object));
		}
		super.setContext(object);
	}
	
	public MultiConnectionPopupMenu(CommandListener listener) {
		super(listener);				
		genSetMenu = MenuBuilder.buildGenSet(listener, this, "Generalization Set");
		addSeparator();
		createMenuItem("Reset Points", CommandType.RESET_POINTS);
		styleMenu = MenuBuilder.buildLineStyle(listener, this, "Line Style");
		visMenu = MenuBuilder.buildVisibility(listener, this, "Visibility");
		alignMenu = MenuBuilder.buildAlign(listener, this, "Align");		
		createMenuItem("Erase",IconType.MENTHOR_ERASE, CommandType.ERASE);
		addSeparator();
		createMenuItem("Delete",IconType.MENTHOR_DELETE, CommandType.DELETE);
	}
}

