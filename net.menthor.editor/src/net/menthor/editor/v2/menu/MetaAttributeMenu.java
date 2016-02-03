package net.menthor.editor.v2.menu;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;

import org.tinyuml.umldraw.shared.UmlDiagramElement;

import RefOntoUML.Classifier;
import RefOntoUML.Collective;
import RefOntoUML.Meronymic;
import RefOntoUML.NamedElement;
import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class MetaAttributeMenu extends BaseMenu<UmlDiagramElement> {

	private static final long serialVersionUID = 3797953970276009760L;
	protected JCheckBoxMenuItem isAbstractMenu, isExtensionalMenu;
	protected JCheckBoxMenuItem isEssentialMenu, isInseparableMenu, isImmutablePartMenu, isImmutableWholeMenu, isShareableMenu;
	
	public MetaAttributeMenu(CommandListener listener, String text, UmlDiagramElement element, JPopupMenu parent){
		super(listener, text, element);	
		
		NamedElement modelElement = element.getClassifier();
		
		if(modelElement instanceof Classifier){
			isAbstractMenu = createCheckBoxMenuItem("isAbstract", CommandType.SET_ABSTRACT); //TODO: Check command
			isAbstractMenu.setSelected(((Classifier) modelElement).isIsAbstract());
		}
		
		if(modelElement instanceof Collective){
			isExtensionalMenu = createCheckBoxMenuItem("isExtensional", CommandType.SET_EXTENSIONAL); //TODO: Check command
			isExtensionalMenu.setSelected(((Collective) modelElement).isIsExtensional());
		}
		
		if(modelElement instanceof Meronymic){
			
			Meronymic meronymic = (Meronymic)modelElement;
			
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
		
		sort();
		parent.add(this);
	}
	
	public MetaAttributeMenu(CommandListener listener, UmlDiagramElement element, JPopupMenu parent){
		this(listener, "Meta Attribute", element, parent);		
  	}

}
