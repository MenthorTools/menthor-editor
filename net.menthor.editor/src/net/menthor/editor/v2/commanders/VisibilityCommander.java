
package net.menthor.editor.v2.commanders;

import java.util.ArrayList;
import java.util.List;

import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.GeneralizationElement;

import net.menthor.editor.v2.ui.notify.command.AssociationVisibilityCommand;
import net.menthor.editor.v2.ui.notify.command.AssociationVisibilityCommand.AssociationVisibility;
import net.menthor.editor.v2.ui.notify.command.ClassVisibilityCommand;
import net.menthor.editor.v2.ui.notify.command.ClassVisibilityCommand.ClassVisibility;
import net.menthor.editor.v2.ui.notify.command.GeneralizationVisibilityCommand;
import net.menthor.editor.v2.ui.notify.command.GeneralizationVisibilityCommand.GeneralizationVisibility;

public class VisibilityCommander extends GenericCommander {
	
	// -------- Lazy Initialization
	
	private static class ChangeLoader {
        private static final VisibilityCommander INSTANCE = new VisibilityCommander();
    }	
	public static VisibilityCommander get() { 
		return ChangeLoader.INSTANCE; 
	}	
    private VisibilityCommander() {
        if (ChangeLoader.INSTANCE != null) throw new IllegalStateException("ChangeManager already instantiated");
    }		
    
    // ----------------------------
	
    // Methods to prepare ClassVisibilityCommands
    
	public void showAttributes(Object obj){
		ArrayList<ClassElement> list = setUpList(obj, ClassElement.class);
		createAndRunVisibilityCommand(list, ClassVisibility.ATTRIBUTES, !hasVisibleAttribute(list));
	}
	
	public void showClassStereotype(Object obj){
		ArrayList<ClassElement> list = setUpList(obj, ClassElement.class);
		createAndRunVisibilityCommand(list, ClassVisibility.STEREOTYPE, !hasVisibleAttribute(list));
	}
	
	public void showNamespace(Object obj){
		ArrayList<ClassElement> list = setUpList(obj, ClassElement.class);
		createAndRunVisibilityCommand(list, ClassVisibility.NAMESPACE, !hasVisibleAttribute(list));
	}
	
	public void showParents(Object obj){
		ArrayList<ClassElement> list = setUpList(obj, ClassElement.class);
		createAndRunVisibilityCommand(list, ClassVisibility.PARENTS, !hasVisibleAttribute(list));
	}
   
	// Methods to prepare AssociationVisibilityCommands
	
	public void showEndPointNames(Object input){
		ArrayList<AssociationElement> list = setUpList(input, AssociationElement.class);			
		createAndRunVisibilityCommand(list, AssociationVisibility.ENDPOINTS, !hasVisibleEndName(list));
	}
	
	public void showSubsetting(Object input){
		ArrayList<AssociationElement> list = setUpList(input, AssociationElement.class);			
		createAndRunVisibilityCommand(list, AssociationVisibility.SUBSETS, !hasVisibleSubsetting(list));
	}
	
	public void showRedefinitions(Object input){
		ArrayList<AssociationElement> list = setUpList(input, AssociationElement.class);			
		createAndRunVisibilityCommand(list, AssociationVisibility.REDEFINES,!hasVisibleRedefinition(list));
	}

	public void showMultiplicities(Object input){
		ArrayList<AssociationElement> list = setUpList(input, AssociationElement.class);			
		createAndRunVisibilityCommand(list, AssociationVisibility.MULTIPLICITY, !hasVisibleMultiplicity(list));
	}
	
	public void showStereotype(Object input){
		ArrayList<AssociationElement> list = setUpList(input, AssociationElement.class);
		createAndRunVisibilityCommand(list, AssociationVisibility.STEREOTYPE, !hasVisibleStereotype(list));				
	}
	
	public void showName(Object input){
		ArrayList<AssociationElement> list = setUpList(input, AssociationElement.class);
		createAndRunVisibilityCommand(list, AssociationVisibility.NAME, !hasVisibleName(list));
	}
	
	public void showGeneralizationSet(Object input){
		ArrayList<GeneralizationElement> list = setUpList(input, GeneralizationElement.class);
		createAndRunVisibilityCommand(list, GeneralizationVisibility.GENSET, !hasVisibleGeneralizationSet(list));
	}
	
	
	public void showAll(Object input){
		
		ArrayList<AssociationElement> associations = setUpList(input, AssociationElement.class);
		ArrayList<ClassElement> classes = setUpList(input, ClassElement.class);
		boolean newValue;
		
		if(associations.size()>0){
			newValue = !hasVisibleName(associations) && !hasVisibleStereotype(associations) && !hasVisibleMultiplicity(associations) && 
					!hasVisibleRedefinition(associations) && !hasVisibleSubsetting(associations) && !hasVisibleEndName(associations);
			
			createAndRunVisibilityCommand(associations, AssociationVisibility.NAME, newValue);
			createAndRunVisibilityCommand(associations, AssociationVisibility.STEREOTYPE, newValue);
			createAndRunVisibilityCommand(associations, AssociationVisibility.MULTIPLICITY, newValue);
			createAndRunVisibilityCommand(associations, AssociationVisibility.REDEFINES,newValue);
			createAndRunVisibilityCommand(associations, AssociationVisibility.SUBSETS, newValue);
			createAndRunVisibilityCommand(associations, AssociationVisibility.ENDPOINTS, newValue);
		}
		
		if(classes.size()>0){
			newValue = !hasVisibleAttribute(classes) && !hasVisibleClassStereotype(classes) && !hasVisibleNamespace(classes) && !hasVisibleParent(classes);
			createAndRunVisibilityCommand(classes, ClassVisibility.ATTRIBUTES, newValue);
		}
	}
	
	
	//////////////////////////////////////////////////////////////////////////////
	// HELPERS																	// 
	//////////////////////////////////////////////////////////////////////////////
	
	private boolean hasVisibleGeneralizationSet(ArrayList<GeneralizationElement> objs){
		for(GeneralizationElement g: objs){
			if(g.showName()) 
				return true;
		}
		return false;
	}
	
	private boolean hasVisibleEndName(ArrayList<AssociationElement> objs){
		for(AssociationElement o: objs){
			if(o.showRoles()) return true;
		}
		return false;
	}
	
	private boolean hasVisibleMultiplicity(ArrayList<AssociationElement> objs){
		for(AssociationElement o: objs){
			if(o.showMultiplicities()) 
				return true;
		}
		return false;
	}
	
	private boolean hasVisibleName(ArrayList<AssociationElement> objs){
		for(AssociationElement o: objs){
			if(o.showName()) return true;
		}
		return false;
	}
	
	private boolean hasVisibleRedefinition(ArrayList<AssociationElement> objs){
		for(AssociationElement o: objs){
			if(o.showRedefining()) return true;
		}
		return false;
	}
	
	private boolean hasVisibleSubsetting(ArrayList<AssociationElement> objs){
		for(AssociationElement o: objs){
				if(o.showSubsetting()) return true;
		}
		return false;
	}
	
	private boolean hasVisibleStereotype(ArrayList<AssociationElement> objs){
		for(AssociationElement o: objs){
				if(o.showOntoUmlStereotype()) return true;
		}
		return false;
	}
	
	private boolean hasVisibleNamespace(ArrayList<ClassElement> classes){
		for (ClassElement classElement : classes) {
			if(classElement.showNamespace())
				return true;
		}
		
		return false;
	}
	
	private boolean hasVisibleParent(ArrayList<ClassElement> classes){
		for (ClassElement classElement : classes) {
			if(classElement.showParents())
				return true;
		}
		
		return false;
	}
	
	private boolean hasVisibleClassStereotype(ArrayList<ClassElement> classes){
		for (ClassElement classElement : classes) {
			if(classElement.showStereotypes())
				return true;
		}
		
		return false;
	}
	
	private boolean hasVisibleAttribute(ArrayList<ClassElement> classes){
		for (ClassElement classElement : classes) {
			if(classElement.showAttributes())
				return true;
		}
		
		return false;
	}
	
	private void createAndRunVisibilityCommand(List<AssociationElement> elementList, AssociationVisibility visibilityItem, boolean value){
		execute(new AssociationVisibilityCommand(currentEditor(), elementList, visibilityItem, value));
	}
	
	private void createAndRunVisibilityCommand(List<ClassElement> elementList, ClassVisibility visibilityItem, boolean value){
		execute(new ClassVisibilityCommand(currentEditor(), elementList, visibilityItem, value));
	}
	
	private void createAndRunVisibilityCommand(List<GeneralizationElement> elementList, GeneralizationVisibility visibilityItem, boolean value){
		execute(new GeneralizationVisibilityCommand(currentEditor(), elementList, visibilityItem, value));
	}
}
