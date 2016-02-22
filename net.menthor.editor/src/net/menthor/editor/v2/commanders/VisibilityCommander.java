
package net.menthor.editor.v2.commanders;

import java.util.ArrayList;
import java.util.List;

import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.GeneralizationElement;

import net.menthor.editor.v2.ui.operation.diagram.AssociationVisibilityOperation;
import net.menthor.editor.v2.ui.operation.diagram.ClassVisibilityOperation;
import net.menthor.editor.v2.ui.operation.diagram.GeneralizationVisibilityOperation;
import net.menthor.editor.v2.ui.operation.diagram.AssociationVisibilityOperation.AssociationVisibility;
import net.menthor.editor.v2.ui.operation.diagram.ClassVisibilityOperation.ClassVisibility;
import net.menthor.editor.v2.ui.operation.diagram.GeneralizationVisibilityOperation.GeneralizationVisibility;

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
		ArrayList<ClassElement> list = setUpAsList(obj, ClassElement.class);
		createAndRunVisibilityCommand(list, ClassVisibility.ATTRIBUTES, !hasVisibleAttribute(list));
	}
	
	public void showClassStereotype(Object obj){
		ArrayList<ClassElement> list = setUpAsList(obj, ClassElement.class);
		createAndRunVisibilityCommand(list, ClassVisibility.STEREOTYPE, !hasVisibleAttribute(list));
	}
	
	public void showNamespace(Object obj){
		ArrayList<ClassElement> list = setUpAsList(obj, ClassElement.class);
		createAndRunVisibilityCommand(list, ClassVisibility.NAMESPACE, !hasVisibleAttribute(list));
	}
	
	public void showParents(Object obj){
		ArrayList<ClassElement> list = setUpAsList(obj, ClassElement.class);
		createAndRunVisibilityCommand(list, ClassVisibility.PARENTS, !hasVisibleAttribute(list));
	}
   
	// Methods to prepare AssociationVisibilityCommands
	
	public void showEndPointNames(Object input){
		ArrayList<AssociationElement> list = setUpAsList(input, AssociationElement.class);			
		createAndRunVisibilityCommand(list, AssociationVisibility.ENDPOINTS, !hasVisibleEndName(list));
	}
	
	public void showSubsetting(Object input){
		ArrayList<AssociationElement> list = setUpAsList(input, AssociationElement.class);			
		createAndRunVisibilityCommand(list, AssociationVisibility.SUBSETS, !hasVisibleSubsetting(list));
	}
	
	public void showRedefinitions(Object input){
		ArrayList<AssociationElement> list = setUpAsList(input, AssociationElement.class);			
		createAndRunVisibilityCommand(list, AssociationVisibility.REDEFINES,!hasVisibleRedefinition(list));
	}

	public void showMultiplicities(Object input){
		ArrayList<AssociationElement> list = setUpAsList(input, AssociationElement.class);			
		createAndRunVisibilityCommand(list, AssociationVisibility.MULTIPLICITY, !hasVisibleMultiplicity(list));
	}
	
	public void showStereotype(Object input){
		ArrayList<AssociationElement> list = setUpAsList(input, AssociationElement.class);
		createAndRunVisibilityCommand(list, AssociationVisibility.STEREOTYPE, !hasVisibleStereotype(list));				
	}
	
	public void showName(Object input){
		ArrayList<AssociationElement> list = setUpAsList(input, AssociationElement.class);
		createAndRunVisibilityCommand(list, AssociationVisibility.NAME, !hasVisibleName(list));
	}
	
	public void showGeneralizationSet(Object input){
		ArrayList<GeneralizationElement> list = setUpAsList(input, GeneralizationElement.class);
		createAndRunVisibilityCommand(list, GeneralizationVisibility.GENSET, !hasVisibleGeneralizationSet(list));
	}
	
	
	public void showAll(Object input){
		
		ArrayList<AssociationElement> associations = setUpAsList(input, AssociationElement.class);
		ArrayList<ClassElement> classes = setUpAsList(input, ClassElement.class);
		boolean newValue;
		
		if(associations.size()>0){
			newValue = !hasVisibleName(associations) || !hasVisibleStereotype(associations) || !hasVisibleMultiplicity(associations) || 
					!hasVisibleRedefinition(associations) || !hasVisibleSubsetting(associations) || !hasVisibleEndName(associations);
			
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
		execute(new AssociationVisibilityOperation(currentEditor(), elementList, visibilityItem, value));
	}
	
	private void createAndRunVisibilityCommand(List<ClassElement> elementList, ClassVisibility visibilityItem, boolean value){
		execute(new ClassVisibilityOperation(currentEditor(), elementList, visibilityItem, value));
	}
	
	private void createAndRunVisibilityCommand(List<GeneralizationElement> elementList, GeneralizationVisibility visibilityItem, boolean value){
		execute(new GeneralizationVisibilityOperation(currentEditor(), elementList, visibilityItem, value));
	}
}
