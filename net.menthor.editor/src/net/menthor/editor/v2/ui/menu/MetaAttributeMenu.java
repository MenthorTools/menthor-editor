package net.menthor.editor.v2.ui.menu;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;

import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.shared.UmlDiagramElement;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.Collective;
import RefOntoUML.Element;
import RefOntoUML.Meronymic;
import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class MetaAttributeMenu extends GenericMenu<UmlDiagramElement> {

	private static final long serialVersionUID = 3797953970276009760L;
	protected JCheckBoxMenuItem isAbstractMenu, isExtensionalMenu, isDerivedMenu;
	protected JCheckBoxMenuItem isEssentialMenu, isInseparableMenu, isImmutablePartMenu, isImmutableWholeMenu, isShareableMenu;
	
	public MetaAttributeMenu(CommandListener listener, String text, UmlDiagramElement element, JPopupMenu parent){
		super(listener, text, element);	
		
		Element modelElement = null;
		
		if(element instanceof ClassElement)
			modelElement = element.getClassifier();
		else if (element instanceof AssociationElement)
			modelElement = ((AssociationElement) element).getAssociation();
		
		if(modelElement instanceof Classifier){
			isAbstractMenu = createCheckBoxMenuItem("Abstract", CommandType.SET_ABSTRACT); //TODO: Check command
			isAbstractMenu.setSelected(((Classifier) modelElement).isIsAbstract());
		}
		
		if(modelElement instanceof Collective){
			isExtensionalMenu = createCheckBoxMenuItem("Extensional", CommandType.SET_EXTENSIONAL); //TODO: Check command
			isExtensionalMenu.setSelected(((Collective) modelElement).isIsExtensional());
		}
		
		if(modelElement instanceof Association){
			isDerivedMenu = createCheckBoxMenuItem("Derived", CommandType.SET_DERIVED);//TODO: Check command
			isDerivedMenu.setSelected(((Association) modelElement).isIsDerived());
		}
		
		if(modelElement instanceof Meronymic){
			
			Meronymic meronymic = (Meronymic)modelElement;
			
			addSeparator();
			
			isEssentialMenu = createCheckBoxMenuItem("Essential", CommandType.SET_ESSENTIAL);
			isEssentialMenu.setSelected(meronymic.isIsEssential());
			
			isInseparableMenu = createCheckBoxMenuItem("Inseparable", CommandType.SET_INSEPARABLE);		
			isInseparableMenu.setSelected(meronymic.isIsInseparable());
			
			isImmutablePartMenu = createCheckBoxMenuItem("Immutable Part", CommandType.SET_IMMUTABLEPART);
			isImmutablePartMenu.setSelected(meronymic.isIsImmutablePart());
			
			isImmutableWholeMenu = createCheckBoxMenuItem("Immutable Whole", CommandType.SET_IMMUTABLEWHOLE);
			isImmutableWholeMenu.setSelected(meronymic.isIsImmutableWhole());
			
			isShareableMenu = createCheckBoxMenuItem("Shareable", CommandType.SET_SHAREABLE);
			isShareableMenu.setSelected(meronymic.isIsShareable());
		}
		
		parent.add(this);
	}
	
	public MetaAttributeMenu(CommandListener listener, UmlDiagramElement element, JPopupMenu parent){
		this(listener, "Meta Attributes", element, parent);		
  	}

}
