package net.menthor.editor.v2.ui.menu;

import java.util.ArrayList;
import java.util.Set;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import org.tinyuml.umldraw.GeneralizationElement;
import org.tinyuml.umldraw.shared.UmlDiagramElement;

import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.managers.ProjectManager;

/** Assumes that this menu is only created if there is at least one instance of GeneralizationELement on the context. 
 * Verification if left for the caller, because it would not make sense to even create this menu.
 * 
*/
public class GenSetMenu extends MultiElementMenu {

	private static final long serialVersionUID = 3797953970276009760L;
	GenericMenu<Set<GeneralizationSet>> removeMenu, deleteMenu;
	GenericMenu<ArrayList<Generalization>> addMenu;
	JMenuItem newMenuItem;
	
	public GenSetMenu(ICommandListener listener, String text, ArrayList<UmlDiagramElement> elements, JPopupMenu parent){
		super(listener, text, elements);	
		ArrayList<Generalization> gList = filterGeneralizations();
		Set<GeneralizationSet> gsList = ProjectManager.get().getProject().getRefParser().getGeneralizationSets(gList);
		Set<GeneralizationSet> gsToAdd = ProjectManager.get().getProject().getRefParser().getAvailableGeneralizations(gsList, gList);
		
		newMenuItem = createMenuItem("New", CommandType.NEW_GEN_SET_DIAGRAM); 
		addMenu = new GenericMenu<ArrayList<Generalization>>(listener,"Add to",gList);
		removeMenu = new GenericMenu<Set<GeneralizationSet>>(listener,"Remove from",gsList);
		deleteMenu = new GenericMenu<Set<GeneralizationSet>>(listener,"Delete",gsList);
		
		add(addMenu);
		add(removeMenu);
		add(deleteMenu);
		
		//Can only create a new GS if all generalizations lead to the same classifier
		if(ProjectManager.get().getProject().getRefParser().sameGeneralOnGeneralizationList(gList))
			newMenuItem.setEnabled(true);
		else
			newMenuItem.setEnabled(false);
		
		//Can only add generalizations to an existing GS if they are not already added
		if(gsToAdd.size()>0){
			for (GeneralizationSet generalizationSet : gsToAdd) 
				addMenu.createMenuItem(generalizationSet.getName(), CommandType.ADD_TO_GEN_SET_DIAGRAM); //TODO: IMPLEMENT THIS ACTION
			addMenu.sort();
		}
		else
			addMenu.setEnabled(false);
		
		//Can only remove from or delete existing GSs if there are any! 
		if(gsList.size()==0){
			removeMenu.setEnabled(false);
			deleteMenu.setEnabled(false);
		}
		else{
			for (GeneralizationSet generalizationSet : gsList) {
				removeMenu.createMenuItem(generalizationSet.getName(), CommandType.REMOVE_FROM_GS_DIAGRAM); //TODO: IMPLEMENT THIS ACTION
				deleteMenu.createMenuItem(generalizationSet.getName(), CommandType.DELETE_GS_DIAGRAM); //TODO: IMPLEMENT THIS ACTION
			}
			removeMenu.sort();
			deleteMenu.sort();
		}
		
		
		
		parent.add(this);
	}
	
	public GenSetMenu(ICommandListener listener, ArrayList<UmlDiagramElement> elements, JPopupMenu parent){
		this(listener, "Generalization Set", elements, parent);		
  	}
	
	public GenSetMenu(ICommandListener listener, GeneralizationElement generalization, JPopupMenu parent){
		this(listener, setUpList(generalization), parent);		
  	}
	
	public GenSetMenu(ICommandListener listener,  String text, GeneralizationElement generalization, JPopupMenu parent){
		this(listener, text, setUpList(generalization), parent);		
  	}
	
	private ArrayList<Generalization> filterGeneralizations(){
		ArrayList<Generalization> generalizations = new ArrayList<>();
		
		for (UmlDiagramElement elem : context) {
			if(elem instanceof GeneralizationElement){
				generalizations.add(((GeneralizationElement) elem).getGeneralization());
			}
		}
		
		return generalizations;
	}
	
}
