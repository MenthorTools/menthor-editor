
package net.menthor.editor.v2.managers;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.ClassElement;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.Collective;
import RefOntoUML.Meronymic;
import RefOntoUML.util.RefOntoUMLFactoryUtil;
import net.menthor.editor.v2.commanders.UpdateCommander;
import net.menthor.editor.v2.commanders.VisibilityCommander;
import net.menthor.editor.v2.ui.app.AppManager;
import net.menthor.editor.v2.ui.dialog.edit.PropertyListEditDialog;

public class MetaPropertyManager extends AppManager {
	
	// -------- Lazy Initialization
	
	private static class ChangeLoader {
        private static final MetaPropertyManager INSTANCE = new MetaPropertyManager();
    }	
	public static MetaPropertyManager get() { 
		return ChangeLoader.INSTANCE; 
	}	
    private MetaPropertyManager() {
        if (ChangeLoader.INSTANCE != null) throw new IllegalStateException("ChangeManager already instantiated");
    }		
    
    // ----------------------------
	
    // ACTIONS
    
    public void endPointNameOnSource(Object element){
		if(element instanceof AssociationElement){
			AssociationElement con = (AssociationElement)element;
			RefOntoUML.Property endpoint = ((RefOntoUML.Association)con.getRelationship()).getMemberEnd().get(0);
			setEndPointName(con,endpoint);
		}
	}

	public void endPointNameOnTarget(Object element){
		if(element instanceof AssociationElement){
			AssociationElement con = (AssociationElement)element;
			RefOntoUML.Property endpoint = ((RefOntoUML.Association)con.getRelationship()).getMemberEnd().get(1);
			setEndPointName(con,endpoint);
		}
	}
	
	public void setEndPointName(DiagramElement con, RefOntoUML.Property endpoint){
		String name = (String)JOptionPane.showInputDialog(frame(), 
		     "Specify the end-point name: ",
		     "Set end-point name",
			 JOptionPane.PLAIN_MESSAGE,
			 null,
			 null,
			 endpoint.getType().getName().toLowerCase().trim()
		 );
		 if(name!=null){
			 endpoint.setName(name);
			 ((AssociationElement)con).setShowRoles(true);
			 UpdateCommander.get().notifyChange(endpoint.getAssociation());
		 }
	}
			
	public void otherOnTarget(Object element){
		if(element instanceof AssociationElement){
			AssociationElement con = (AssociationElement)element;
			RefOntoUML.Property endpoint = ((RefOntoUML.Association)con.getRelationship()).getMemberEnd().get(1);
			setMultiplicity(endpoint);
		}
	}
	
	public void otherOnSource(Object element){
		if(element instanceof AssociationElement){
			AssociationElement con = (AssociationElement)element;
			RefOntoUML.Property endpoint = ((RefOntoUML.Association)con.getRelationship()).getMemberEnd().get(0);
			setMultiplicity(endpoint);
		}
	}
	
	public void setMultiplicity(RefOntoUML.Property endpoint){
		//
		String multiplicity = (String)JOptionPane.showInputDialog(frame(), 
		     "Specify the new multiplicity: ",
		     "Set multiplicity",
			 JOptionPane.PLAIN_MESSAGE,
			 null,
			 null,
			 RefOntoUMLFactoryUtil.getMultiplicityAsString(endpoint)
		);
		 if(multiplicity!=null){
			 try{
				ChangeManager.get().changeMultiplicity(endpoint, multiplicity);
			 }catch(Exception e){
				 MessageManager.get().showError(e, "Multiplicity","Could not change the multiplicity");
			 }
		 }	
	}
	
	public void twoAtLeastOnSource(Object element){
		if(element instanceof AssociationElement){
			AssociationElement con = (AssociationElement)element;
			RefOntoUML.Property endpoint = ((RefOntoUML.Association)con.getRelationship()).getMemberEnd().get(0);
			ChangeManager.get().changeMultiplicity(endpoint, 2, -1);
		}
	}

	public void twoAtLeastOnTarget(Object element){
		if(element instanceof AssociationElement){
			AssociationElement con = (AssociationElement)element;
			RefOntoUML.Property endpoint = ((RefOntoUML.Association)con.getRelationship()).getMemberEnd().get(1);
			ChangeManager.get().changeMultiplicity(endpoint, 2, -1);
		}
	}
	
	public void twoOnSource(Object element){
		if(element instanceof AssociationElement){
			AssociationElement con = (AssociationElement)element;
			RefOntoUML.Property endpoint = ((RefOntoUML.Association)con.getRelationship()).getMemberEnd().get(0);
			ChangeManager.get().changeMultiplicity(endpoint, 2, 2);
		}
	}

	public void twoOnTarget(Object element){
		if(element instanceof AssociationElement){
			AssociationElement con = (AssociationElement)element;
			RefOntoUML.Property endpoint = ((RefOntoUML.Association)con.getRelationship()).getMemberEnd().get(1);
			ChangeManager.get().changeMultiplicity(endpoint, 2, 2);
		}
	}
	
	public void anyOnSource(Object element){
		if(element instanceof AssociationElement){
			AssociationElement con = (AssociationElement)element;
			RefOntoUML.Property endpoint = ((RefOntoUML.Association)con.getRelationship()).getMemberEnd().get(0);
			ChangeManager.get().changeMultiplicity(endpoint, 0, -1);
		}
	}

	public void anyOnTarget(Object element){
		if(element instanceof AssociationElement){
			AssociationElement con = (AssociationElement)element;
			RefOntoUML.Property endpoint = ((RefOntoUML.Association)con.getRelationship()).getMemberEnd().get(1);
			ChangeManager.get().changeMultiplicity(endpoint, 0, -1);
		}
	}
	
	public void someOnSource(Object element){
		if(element instanceof AssociationElement){
			AssociationElement con = (AssociationElement)element;
			RefOntoUML.Property endpoint = ((RefOntoUML.Association)con.getRelationship()).getMemberEnd().get(0);
			ChangeManager.get().changeMultiplicity(endpoint, 1, -1);
		}
	}

	public void someOnTarget(Object element){
		if(element instanceof AssociationElement){
			AssociationElement con = (AssociationElement)element;
			RefOntoUML.Property endpoint = ((RefOntoUML.Association)con.getRelationship()).getMemberEnd().get(1);
			ChangeManager.get().changeMultiplicity(endpoint, 1, -1);
		}
	}
	
	public void optionalOnSource(Object element){
		if(element instanceof AssociationElement){
			AssociationElement con = (AssociationElement)element;
			RefOntoUML.Property endpoint = ((RefOntoUML.Association)con.getRelationship()).getMemberEnd().get(0);
			ChangeManager.get().changeMultiplicity(endpoint, 0, 1);
		}
	}

	public void optionalOnTarget(Object element){
		if(element instanceof AssociationElement){
			AssociationElement con = (AssociationElement)element;
			RefOntoUML.Property endpoint = ((RefOntoUML.Association)con.getRelationship()).getMemberEnd().get(1);
			ChangeManager.get().changeMultiplicity(endpoint, 0, 1);
		}
	}
	
	public void singularOnSource(Object element){
		if(element instanceof AssociationElement){
			AssociationElement con = (AssociationElement)element;
			RefOntoUML.Property endpoint = ((RefOntoUML.Association)con.getRelationship()).getMemberEnd().get(0);
			ChangeManager.get().changeMultiplicity(endpoint, 1, 1);
		}
	}
	
	public void singularOnTarget(Object element){
		if(element instanceof AssociationElement){
			AssociationElement con = (AssociationElement)element;
			RefOntoUML.Property endpoint = ((RefOntoUML.Association)con.getRelationship()).getMemberEnd().get(1);
			ChangeManager.get().changeMultiplicity(endpoint, 1, 1);
		}
	}
	
	
	
	public void subsetsSource(final Object element){
		if(element instanceof AssociationElement){
			AssociationElement con = (AssociationElement)element;
			RefOntoUML.Property endpoint = ((RefOntoUML.Association)con.getRelationship()).getMemberEnd().get(0);
			subsets(con, endpoint);
		}
	}

	public void subsetsTarget(final Object element){
		if(element instanceof AssociationElement){
			AssociationElement con = (AssociationElement)element;
			RefOntoUML.Property endpoint = ((RefOntoUML.Association)con.getRelationship()).getMemberEnd().get(1);
			subsets(con, endpoint);
		}
	}
	
	public void subsets(final AssociationElement association, final RefOntoUML.Property endpoint){
		
		PropertyListEditDialog.open(
				frame(),null, "Subsetted", endpoint, 
				ProjectManager.get().getProject().getRefParser()
		);
		
		SwingUtilities.invokeLater(new Runnable() {						
			@Override
			public void run() {
				VisibilityCommander.get().showSubsetting(association);
			}
		});
	}
	
	public void redefinesSource(final Object element){
		if(element instanceof AssociationElement){
			AssociationElement con = (AssociationElement)element;
			RefOntoUML.Property endpoint = ((RefOntoUML.Association)con.getRelationship()).getMemberEnd().get(0);
			redefines(con, endpoint);
		}
	}

	public void redefinesTarget(final Object element){
		if(element instanceof AssociationElement){
			AssociationElement con = (AssociationElement)element;
			RefOntoUML.Property endpoint = ((RefOntoUML.Association)con.getRelationship()).getMemberEnd().get(1);
			redefines(con, endpoint);
		}
	}
	
	public void redefines(final AssociationElement association, final RefOntoUML.Property endpoint){
		PropertyListEditDialog.open(
				frame(),null, "Redefined", endpoint, 
				ProjectManager.get().getProject().getRefParser()
		);		
		
		SwingUtilities.invokeLater(new Runnable() {						
			@Override
			public void run() {
				VisibilityCommander.get().showRedefinitions(association);
			}
		});
	}
    
    public void setExtensional(Object con){
  		if (containsCollective(con)) {
  			Collective collective = getCollective(con);
  			collective.setIsExtensional(!collective.isIsExtensional());
  			UpdateCommander.get().notifyChange(collective);
  		}
  	}
    
    public void setAbstract(Object con){
  		if (containsClassifier(con)) {
  			Classifier classifier = getClassifier(con);
  			classifier.setIsAbstract(!classifier.isIsAbstract());
  			UpdateCommander.get().notifyChange(classifier);
  		}
  	}
    
    public void setDerived(Object con){
		if (containsAssociation(con)) {
			Association association = getAssociation(con);
			association.setIsDerived(!association.isIsDerived());
			UpdateCommander.get().notifyChange(association);
		}
	}
	
	public void setShareable(Object con){
		if (containsMeronymic(con)) {
			Meronymic meronymic = getMeronymic(con);
			meronymic.setIsShareable(!meronymic.isIsShareable());
			UpdateCommander.get().notifyChange(meronymic);
		}
	}
	
	public void setImmutablePart(Object con){
		if (containsMeronymic(con)) {
			Meronymic meronymic = getMeronymic(con);
			meronymic.setIsImmutablePart(!meronymic.isIsImmutablePart());
			UpdateCommander.get().notifyChange(meronymic);
		}
	}
	
	public void setImmutableWhole(Object con){
		if (containsMeronymic(con)) {
			Meronymic meronymic = getMeronymic(con);
			meronymic.setIsImmutableWhole(!meronymic.isIsImmutableWhole());
			UpdateCommander.get().notifyChange(meronymic);
		}
	}
	
	public void setInseparable(Object con){
		if (containsMeronymic(con)) {
			Meronymic meronymic = getMeronymic(con);
			
			meronymic.setIsInseparable(!meronymic.isIsInseparable());
			//inserparable implies immutableWhole
			if(meronymic.isIsInseparable())
				meronymic.setIsImmutableWhole(true);
			
			UpdateCommander.get().notifyChange(meronymic);
		}
	}
	
	 public void setEssential(Object con){
		 if (containsMeronymic(con)) {
				Meronymic meronymic = getMeronymic(con);
				
				meronymic.setIsEssential(!meronymic.isIsEssential());
				//inserparable implies immutableWhole
				if(meronymic.isIsEssential())
					meronymic.setIsImmutablePart(true);
				
				UpdateCommander.get().notifyChange(meronymic);
			}
		}
	
	
	// HELPERS 
	
	private boolean containsClassifier(Object diagramElement){
		return (diagramElement instanceof AssociationElement && ((AssociationElement) diagramElement).getAssociation() instanceof Association) || 
				(diagramElement instanceof ClassElement && ((ClassElement)diagramElement).getClassifier() instanceof Classifier);
	}
	
	private boolean containsMeronymic(Object con){
		return con instanceof AssociationElement && ((AssociationElement) con).getAssociation() instanceof Meronymic;
	}
	
	private boolean containsAssociation(Object con){
		return con instanceof AssociationElement && ((AssociationElement) con).getAssociation() instanceof Association;
	}
	
	private boolean containsCollective(Object con){
		return con instanceof ClassElement && ((ClassElement) con).getClassifier() instanceof Collective;
	}
	
	private Classifier getClassifier(Object diagramElement){
		if(diagramElement instanceof AssociationElement)
			return getAssociation(diagramElement);
		if(diagramElement instanceof ClassElement)
			return getClassElement(diagramElement);
		
		return null;
	}
	
	private Classifier getClassElement(Object diagramElement){
		return ((ClassElement)diagramElement).getClassifier();
	}
	
	private Collective getCollective(Object diagramElement){
		return (Collective) ((ClassElement)diagramElement).getClassifier();
	}
	
	private Meronymic getMeronymic(Object con) {
		return (Meronymic) ((AssociationElement) con).getAssociation();
	}
	
	private Association getAssociation(Object con) {
		return ((AssociationElement) con).getAssociation();
	}
}
