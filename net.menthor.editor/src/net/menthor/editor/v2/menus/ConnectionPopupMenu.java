package net.menthor.editor.v2.menus;

import org.tinyuml.umldraw.AssociationElement;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconType;

/**
 * @author John Guerson
 */
public class ConnectionPopupMenu extends BasePopupMenu {

	private static final long serialVersionUID = 1L;
	
	private VisibilityMenu visibilityMenu;
	private LineStyleMenu styleMenu;
	private ChangeRelationshipMenu changeMenu;
	private InvertMenu invertMenu;
	private ReadingDirectionMenu directionMenu;
	private MetaAttributeMenu attrMenu;
	private SourceMultiplicityMenu srcMultMenu;
	private TargetMultiplicityMenu tgtMultMenu;
	
	public ConnectionPopupMenu(CommandListener listener){   
		super(listener);
		createMenuItem("Edit Properties", IconType.MENTHOR_EDIT, CommandType.EDIT);
		createMenuItem("Find in Project Browser", IconType.MENTHOR_TREE, CommandType.FIND_IN_PROJECT_BROWSER);
		addSeparator();
		createMenuItem("Reset Points", CommandType.RESET_POINTS);
		styleMenu = MenuBuilder.buildLineStyle(listener, this, "Line Style");
		visibilityMenu = MenuBuilder.buildVisibility(listener, this, "Visibility");
		directionMenu = MenuBuilder.buildReadingDirection(listener, this, "Reading Direction");		
		addSeparator();
		attrMenu = MenuBuilder.buildMetaAttribute(listener,this,"Meta Attribute");
		changeMenu = MenuBuilder.buildChangeRelationshipTo(listener, this, "Change To");
		invertMenu = MenuBuilder.buildInvert(listener, this, "Invert");		
		addSeparator();
		createMenuItem("Source: End-Point Name",CommandType.SET_SOURCE_END_POINT_NAME);
		srcMultMenu = MenuBuilder.buildSourceMultiplicity(listener,this,"Source: Multiplicity");
		createMenuItem("Source: Subsets",CommandType.SUBSETS_SOURCE);		
		createMenuItem("Source: Redefines",CommandType.REDEFINES_SOURCE);				
		addSeparator();
		createMenuItem("Target: End-Point Name",CommandType.SET_TARGET_END_POINT_NAME);
		tgtMultMenu = MenuBuilder.buildTargetMultiplicity(listener,this,"Target: Multiplicity");
		createMenuItem("Target: Subsets",CommandType.SUBSETS_TARGET);
		createMenuItem("Target: Redefines",CommandType.REDEFINES_TARGET);		
		addSeparator();		
		createMenuItem("Erase",IconType.MENTHOR_ERASE, CommandType.ERASE);
		addSeparator();
		createMenuItem("Delete",IconType.MENTHOR_DELETE, CommandType.DELETE);
	}
		
	public void setContext(Object context){
		visibilityMenu.setContext(context);
		styleMenu.setContext(context);
		changeMenu.setContext(context);
		invertMenu.setContext(context);
		directionMenu.setContext(context);
		attrMenu.setContext(context);
		srcMultMenu.setContext(context);
		tgtMultMenu.setContext(context);
		if(context instanceof AssociationElement){
			visibilityMenu.getMenuItem(CommandType.SHOW_END_POINT_NAMES).setSelected(((AssociationElement)context).showRoles());
			visibilityMenu.getMenuItem(CommandType.SHOW_MULTIPLICITIES).setSelected(((AssociationElement)context).showMultiplicities());
			visibilityMenu.getMenuItem(CommandType.SHOW_NAME).setSelected(((AssociationElement)context).showName());
			visibilityMenu.getMenuItem(CommandType.SHOW_REDEFINITIONS).setSelected(((AssociationElement)context).showRedefining());
			visibilityMenu.getMenuItem(CommandType.SHOW_SUBSETTING).setSelected(((AssociationElement)context).showSubsetting());
			visibilityMenu.getMenuItem(CommandType.SHOW_STEREOTYPE).setSelected(((AssociationElement)context).showOntoUmlStereotype());
			RefOntoUML.Relationship rel = ((AssociationElement)context).getRelationship();
			if(rel instanceof RefOntoUML.Meronymic) attrMenu.setVisible(true);
			else attrMenu.setVisible(false);
		}
		super.setContext(context);
	}
}
