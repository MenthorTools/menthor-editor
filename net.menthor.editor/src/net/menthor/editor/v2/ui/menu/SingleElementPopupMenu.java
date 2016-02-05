package net.menthor.editor.v2.ui.menu;

import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.GeneralizationElement;
import org.tinyuml.umldraw.shared.BaseConnection;
import org.tinyuml.umldraw.shared.NoteElement;
import org.tinyuml.umldraw.shared.UmlDiagramElement;
import org.tinyuml.umldraw.shared.UmlNode;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.ui.icon.IconType;

public class SingleElementPopupMenu extends GenericPopupMenu<UmlDiagramElement> {

	private static final long serialVersionUID = 6980238001925458188L;
	
	//General menus
	protected VisibilityMenu visibilityMenu;
	protected MetaAttributeMenu metaAttributeMenu;
	protected ChangeStereotypeMenu changeStereotypeMenu;
	
	//Class only menus
	protected ColorMenu colorMenu;
	
	//Connection only menus 
	protected LineStyleMenu lineStyleMenu;
	protected InvertMenu invertMenu;
	
	//Generalization only menus
	protected GenSetMenu genSetMenu;
	
	//Association only menus
	protected ReadingDirectionMenu readingDirectionMenu;
	protected EndPointMenu sourceEndMenu, targetEndMenu;
	
	//creates the menu according to the element being clicked.
	public SingleElementPopupMenu(CommandListener listener, UmlDiagramElement diagramElement) {
		super(listener, diagramElement);
		
		//add default items to all cases
		createMenuItem("Edit Properties", IconType.MENTHOR_EDIT, CommandType.EDIT);
		addSeparator();
		createMenuItem("Duplicate", CommandType.DUPLICATE);
		createMenuItem("Copy", CommandType.COPY);
		addSeparator();
		createMenuItem("Delete from Diagram",IconType.MENTHOR_ERASE, CommandType.ERASE);
		createMenuItem("Delete from Model",IconType.MENTHOR_DELETE, CommandType.DELETE);
		addSeparator();
		createMenuItem("Find in Project Browser", IconType.MENTHOR_TREE, CommandType.FIND_IN_PROJECT_BROWSER);
		createMenuItem("Find in Diagrams", IconType.MENTHOR_SEARCH, CommandType.FIND_IN_DIAGRAMS);
		addSeparator();
		
		if(diagramElement instanceof UmlNode){
			UmlNode node = (UmlNode) diagramElement;
			
			createMenuItem("Add All Related Elements", CommandType.ADD_ALL_RELATED_ELEMENTS);
			addSeparator();
			
			visibilityMenu = new VisibilityMenu(listener, node, this);
			colorMenu = new ColorMenu(listener,node,this); 		
					
			if(diagramElement instanceof ClassElement){
				ClassElement classElement = (ClassElement) diagramElement;  
				
				addSeparator();
				
				changeStereotypeMenu = new ChangeStereotypeMenu(listener, classElement.getClassifier(), this);
				metaAttributeMenu = new MetaAttributeMenu(listener,classElement,this);
				
			}
			if(diagramElement instanceof NoteElement){
				//NoteElement note = (NoteElement) diagramElement;
				//TODO: add actions exclusively for note elements
			}
		}
		
		else if(diagramElement instanceof BaseConnection){
			BaseConnection connection = (BaseConnection) diagramElement;
			
			
			visibilityMenu = new VisibilityMenu(listener, connection, this);
			lineStyleMenu = new LineStyleMenu(listener, connection, this);
			createMenuItem("Reset Points", CommandType.RESET_POINTS);

			if(diagramElement instanceof AssociationElement){
				AssociationElement association = (AssociationElement) diagramElement;
				
				readingDirectionMenu = new ReadingDirectionMenu(listener, association, this);
				
				addSeparator();
				invertMenu = new InvertMenu(listener, connection, this);	
				changeStereotypeMenu = new ChangeStereotypeMenu(listener, association.getAssociation(), this);
				metaAttributeMenu = new MetaAttributeMenu(listener,association,this);
				sourceEndMenu = new EndPointMenu(listener, association, this, true);
				targetEndMenu = new EndPointMenu(listener, association, this, false);
				
			}
			else if(diagramElement instanceof GeneralizationElement){
				GeneralizationElement generalization = (GeneralizationElement) diagramElement;
				
				addSeparator();
				invertMenu = new InvertMenu(listener, connection, this);	
				changeStereotypeMenu = new ChangeStereotypeMenu(listener, generalization.getGeneralization(), this);
				
				addSeparator();
				genSetMenu = new GenSetMenu(listener, generalization, this);
			}
		}
		
		
		
	}

}
