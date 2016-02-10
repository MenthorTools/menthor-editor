
package net.menthor.editor.v2.managers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.ui.diagram.commands.SetVisibilityCommand;
import org.tinyuml.ui.diagram.commands.SetVisibilityCommand.Visibility;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.ClassElement;

public class VisibilityManager extends BaseManager {
	
	// -------- Lazy Initialization
	
	private static class ChangeLoader {
        private static final VisibilityManager INSTANCE = new VisibilityManager();
    }	
	public static VisibilityManager get() { 
		return ChangeLoader.INSTANCE; 
	}	
    private VisibilityManager() {
        if (ChangeLoader.INSTANCE != null) throw new IllegalStateException("ChangeManager already instantiated");
    }		
    
    // ----------------------------
	
    // ACTIONS
    
    public void showAttributes(List<DiagramElement> classList){
		for(DiagramElement elem: classList){
			ClassElement classElem = (ClassElement)elem;
			classElem.setShowAttributes(!classElem.showAttributes());
			UpdateManager.get().notifyChange(classElem.getClassifier());
		}		
	}
	
	public void showAttributes(Object obj){
		ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();
		
		if (obj instanceof ClassElement)	
			list.add((DiagramElement)obj);
		
		else if(obj instanceof Collection<?>)
			for(Object o: ((Collection<?>)obj))
				if(o instanceof ClassElement)
					list.add((DiagramElement)o);
				
		showAttributes(list);
	}
    
    public void showStereotype(boolean value)
	{		
		for(AssociationElement associationElement: TabManager.get().getCurrentDiagramEditor().getSelectedAssociationElements())
			associationElement.setShowOntoUmlStereotype(value);		
	}

	public void showEndPoints(boolean value)
	{		
		for(AssociationElement associationElement: TabManager.get().getCurrentDiagramEditor().getSelectedAssociationElements())
			associationElement.setShowRoles(value);		
	}

	public void showRedefining(boolean value)
	{		
		for(AssociationElement associationElement: TabManager.get().getCurrentDiagramEditor().getSelectedAssociationElements())
			associationElement.setShowRedefining(value);		
	}
	
	public void showSubsetting(boolean value)
	{		
		for(AssociationElement associationElement: TabManager.get().getCurrentDiagramEditor().getSelectedAssociationElements())
			associationElement.setShowSubsetting(value);		
	}
	
	public void showMultiplicities(boolean value)
	{		
		for(AssociationElement associationElement: TabManager.get().getCurrentDiagramEditor().getSelectedAssociationElements())
			associationElement.setShowMultiplicities(value);		
	}
	
	public void showName(boolean value)
	{		
		for(AssociationElement associationElement: TabManager.get().getCurrentDiagramEditor().getSelectedAssociationElements())
			associationElement.setShowName(value);
	}
    
	public void showEndPointNames(Object con){
		if (con instanceof AssociationElement) {	
			createAndExecuteVisibilityCommand(setUpList(con),Visibility.ENDPOINTS, !((AssociationElement)con).showRoles());
		}
		else if (con instanceof Collection<?>){			
			createAndExecuteVisibilityCommand(castList((Collection<?>) con), Visibility.ENDPOINTS, !someShowEndNames((Collection<?>)con));
		}
	}
	
	public void showSubsetting(Object con){
		if (con instanceof AssociationElement) {	
			createAndExecuteVisibilityCommand(setUpList(con),Visibility.SUBSETS, !((AssociationElement)con).showSubsetting());
		}
		else if (con instanceof Collection<?>){			
			createAndExecuteVisibilityCommand(castList((Collection<?>) con), Visibility.SUBSETS, !someShowSubsetting((Collection<?>)con));
		}
	}
	
	public void showRedefinitions(Object con){
		if (con instanceof AssociationElement) {	
			createAndExecuteVisibilityCommand(setUpList(con),Visibility.REDEFINES, !((AssociationElement)con).showRedefining());
		}
		else if (con instanceof Collection<?>){			
			createAndExecuteVisibilityCommand(castList((Collection<?>) con), Visibility.REDEFINES,!someShowRedefining((Collection<?>)con));
		}
	}

	public void showMultiplicities(Object con){
		if (con instanceof AssociationElement) {	
			createAndExecuteVisibilityCommand(setUpList(con),Visibility.MULTIPLICITY,!((AssociationElement)con).showMultiplicities());
		}
		else if (con instanceof Collection<?>){			
			createAndExecuteVisibilityCommand(castList((Collection<?>) con), Visibility.MULTIPLICITY, !someShowMultiplicities((Collection<?>)con));
		}
	}
	
	public void showStereotype(Object con){
		if (con instanceof AssociationElement) {	
			createAndExecuteVisibilityCommand(setUpList(con),Visibility.STEREOTYPE,!((AssociationElement)con).showOntoUmlStereotype());
		}
		else if (con instanceof Collection<?>){			
			createAndExecuteVisibilityCommand(castList((Collection<?>) con), Visibility.STEREOTYPE, !someShowStereotype((Collection<?>) con));				
		}
	}
	
	public void showName(Object con){
		if (con instanceof AssociationElement) {				
			createAndExecuteVisibilityCommand(setUpList(con), Visibility.NAME, !((AssociationElement)con).showName());
		}
		else if (con instanceof Collection<?>){			
			createAndExecuteVisibilityCommand(castList((Collection<?>) con), Visibility.NAME, !someShowName((Collection<?>)con));
		}
	}
	
	private boolean someShowEndNames(Collection<?> objs){
		for(Object o: objs){
			if(o instanceof AssociationElement)
				if(((AssociationElement)o).showRoles()) return true;
		}
		return false;
	}
	
	private boolean someShowMultiplicities(Collection<?> objs){
		for(Object o: objs){
			if(o instanceof AssociationElement)
				if(((AssociationElement)o).showMultiplicities()) return true;
		}
		return false;
	}
	
	private boolean someShowName(Collection<?> objs){
		for(Object o: objs){
			if(o instanceof AssociationElement)
				if(((AssociationElement)o).showName()) return true;
		}
		return false;
	}
	
	private boolean someShowRedefining(Collection<?> objs){
		for(Object o: objs){
			if(((AssociationElement)o).showRedefining()) return true;
		}
		return false;
	}
	
	private boolean someShowSubsetting(Collection<?> objs){
		for(Object o: objs){
			if(o instanceof AssociationElement)
				if(((AssociationElement)o).showSubsetting()) return true;
		}
		return false;
	}
	
	private boolean someShowStereotype(Collection<?> objs){
		for(Object o: objs){
			if(o instanceof AssociationElement)
				if(((AssociationElement)o).showOntoUmlStereotype()) return true;
		}
		return false;
	}
	
	//////////////////////////////////////////////////////////////////////////////
	// HELPERS																	// 
	//////////////////////////////////////////////////////////////////////////////
	
	private ArrayList<DiagramElement> setUpList(Object con) {
		ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();
		
		if(con instanceof DiagramElement)
			list.add((DiagramElement)con);
		
		return list;
	}
	
	private ArrayList<DiagramElement> castList(Collection<?> original){
		ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();
		
		for (Object element : original) {
			if(element instanceof DiagramElement)
				list.add((DiagramElement) element);
		}
		
		return list;
	}
	
	private void createAndExecuteVisibilityCommand(List<DiagramElement> elementList, Visibility visibilityItem, boolean value){
		DiagramEditor editor = TabManager.get().getCurrentDiagramEditor();
		SetVisibilityCommand command = new SetVisibilityCommand(editor, elementList, visibilityItem, value);
		editor.execute(command);
	}
}
