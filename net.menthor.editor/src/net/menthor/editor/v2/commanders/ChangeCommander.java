
package net.menthor.editor.v2.commanders;

import java.util.List;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.GeneralizationElement;
import org.tinyuml.umldraw.shared.BaseConnection;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.Collective;
import RefOntoUML.Generalization;
import RefOntoUML.LiteralInteger;
import RefOntoUML.LiteralUnlimitedNatural;
import RefOntoUML.Meronymic;
import RefOntoUML.Property;
import RefOntoUML.Relationship;
import RefOntoUML.Type;
import RefOntoUML.util.RefOntoUMLFactoryUtil;
import net.menthor.common.ontoumlfixer.Fix;
import net.menthor.common.ontoumlfixer.OutcomeFixer;
import net.menthor.common.ontoumlverificator.MultiplicityValidator;
import net.menthor.editor.v2.managers.FactoryManager;
import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.types.RelationshipType;
import net.menthor.editor.v2.ui.app.AppFrame;
import net.menthor.editor.v2.ui.app.manager.AppBrowserManager;
import net.menthor.editor.v2.ui.app.manager.AppMessageManager;
import net.menthor.editor.v2.ui.dialog.edit.PropertyListEditDialog;
import net.menthor.editor.v2.ui.operation.model.MetaPropertyModelOperation;
import net.menthor.editor.v2.ui.operation.model.MetaPropertyModelOperation.MetaProperty;

public class ChangeCommander {
	
	// -------- Lazy Initialization
	
	private static class ChangeLoader {
        private static final ChangeCommander INSTANCE = new ChangeCommander();
    }	
	public static ChangeCommander get() { 
		return ChangeLoader.INSTANCE; 
	}	
    private ChangeCommander() {
        if (ChangeLoader.INSTANCE != null) throw new IllegalStateException("ChangeCommander already instantiated");
    }		
    
    // ----------------------------
	
	/** Change relation stereotype */ 
	public void changeRelationStereotype(RelationshipType type, RefOntoUML.Relationship element){	
		changeRelationStereotype(element, type.getName());
	}	
		
	/** Change relation stereotype */ 
	public void changeRelationStereotype(Relationship type, String stereo){	
   		OutcomeFixer fixer = new OutcomeFixer(ProjectManager.get().getProject().getModel());
   		Fix fix = fixer.changeRelationStereotypeTo(type, fixer.getRelationshipStereotype(stereo));   		
   		UpdateCommander.get().update(fix);   		   		
   	}
	
	/** Change a class stereotype */ 
	public void changeClassStereotype(ClassType type, RefOntoUML.Element element){ 
		changeClassStereotype((RefOntoUML.Type)element, type.getName());
	}
	
	/** Change a class stereotype */ 
	public void changeClassStereotype(Type type, String stereo){   
		List<DiagramElement> diagramElements = OccurenceManager.get().getDiagramElements(type);		
   		OutcomeFixer fixer = new OutcomeFixer(ProjectManager.get().getProject().getModel());
   		Fix fix = fixer.changeClassStereotypeTo(type, fixer.getClassStereotype(stereo));   	
   		for(DiagramElement de: diagramElements){
	   		if (de !=null && de instanceof ClassElement) {
	   			double x = ((ClassElement)de).getAbsoluteX1();
	   			double y = ((ClassElement)de).getAbsoluteY1();   	   		
	   	   		fix.setAddedPosition(fix.getAdded().get(0),x,y);
	   		}
   		}
  		UpdateCommander.get().update(fix);
	}
		
	/** Invert end points of an association. */
	public void invertEndPoints(BaseConnection connection){
		if(connection instanceof AssociationElement){
			Association association = ((AssociationElement) connection).getAssociation();
			Property source = association.getMemberEnd().get(0);
	   		Property target = association.getMemberEnd().get(1);	   		
	   		association.getMemberEnd().clear();	
	   		association.getOwnedEnd().clear();
	   		association.getNavigableOwnedEnd().clear();	   		
	   		association.getMemberEnd().add(target);
	   		association.getMemberEnd().add(source);   	
	   		association.getOwnedEnd().add(target);
	   		association.getOwnedEnd().add(source);
	   		association.getNavigableOwnedEnd().add(target);
	   		association.getNavigableOwnedEnd().add(source);	   		
	   		AppBrowserManager.get().changeTo(association, source, target);
	   		UpdateCommander.get().updateFromChange(association, true);
		}
		else if (connection instanceof GeneralizationElement){
			Generalization generalization = ((GeneralizationElement) connection).getGeneralization();
			Classifier general = generalization.getGeneral();
			Classifier specific = generalization.getSpecific();			
			generalization.setSpecific(general);
			generalization.setGeneral(specific);			
			AppBrowserManager.get().updateUI();
			UpdateCommander.get().updateFromChange(generalization, true);			
		}		
	}
	
	/** Invert names of end points of an association. */
	public void invertEndNames(BaseConnection connection){
		if(!(connection instanceof AssociationElement)) return;			
		Association association = ((AssociationElement) connection).getAssociation();	
		Property source = association.getMemberEnd().get(0);
   		Property target = association.getMemberEnd().get(1);
   		String sourceName = source.getName();
   		String targetName = target.getName();
   		source.setName(targetName);
   		target.setName(sourceName);
   		UpdateCommander.get().updateFromChange(association, false);
	}
	
	/** Invert multiplicities of end points of an association. */
	public void invertEndMultiplicities(BaseConnection connection){
		if(!(connection instanceof AssociationElement)) return;			
		Association association = ((AssociationElement) connection).getAssociation();
		Property source = association.getMemberEnd().get(0);
   		Property target = association.getMemberEnd().get(1);
   		LiteralInteger sourceLower = FactoryManager.get().createLiteralInteger();
   		LiteralUnlimitedNatural sourceUpper = FactoryManager.get().createLiteralUnlimitedNatural();
   		sourceLower.setValue(target.getLower());
   		sourceUpper.setValue(target.getUpper());   		
   		LiteralInteger targetLower = FactoryManager.get().createLiteralInteger();
   		LiteralUnlimitedNatural targetUpper = FactoryManager.get().createLiteralUnlimitedNatural();
   		targetUpper.setValue(source.getUpper());
   		targetLower.setValue(source.getLower());  	
   		source.setUpperValue(sourceUpper);
   		source.setLowerValue(sourceLower);
   		target.setUpperValue(targetUpper);
   		target.setLowerValue(targetLower);
   		UpdateCommander.get().updateFromChange(association, false);
	}
	
	/** Invert types of end points of an association. */
	public void invertEndTypes(BaseConnection connection){
		if(!(connection instanceof AssociationElement)) return;			
		Association association = ((AssociationElement) connection).getAssociation();
		Property source = association.getMemberEnd().get(0);
   		Property target = association.getMemberEnd().get(1);
   		Type sourceType = source.getType();
   		Type targetType = target.getType();
   		source.setType(targetType);
   		target.setType(sourceType);
   		UpdateCommander.get().updateFromChange(association, true);
	}
	
 // ACTIONS
    
	// End-point meta-properties
	
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
		Object newName = AppMessageManager.get().input("End-point name", "Input the a new name for the end-point:", null, endpoint.getType().getName().toLowerCase().trim());
		if(newName!=null && newName instanceof String){
			new MetaPropertyModelOperation(endpoint, MetaProperty.NAME, newName).run();;
		}
	}
	
	/** Change multiplicity from string */
	public void changeMultiplicity(RefOntoUML.Property endpoint, String newMultiplicity) {
		new MetaPropertyModelOperation(endpoint, MetaProperty.MULTIPLICITY, newMultiplicity).run();
	}
	
	private void changeMultiplicityOnSource(Object element, String value){
		if(element instanceof AssociationElement){
			AssociationElement con = (AssociationElement)element;
			RefOntoUML.Property endpoint = ((RefOntoUML.Association)con.getRelationship()).getMemberEnd().get(0);
			changeMultiplicity(endpoint, value);
		}
	}
    
	public void twoAtLeastOnSource(Object element){
		changeMultiplicityOnSource(element, "2..*");
	}
	
	public void twoOnSource(Object element){
		changeMultiplicityOnSource(element, "2");
	}
	
	public void anyOnSource(Object element){
		changeMultiplicityOnSource(element, "0..*");
	}
	
	public void someOnSource(Object element){
		changeMultiplicityOnSource(element, "1..*");
	}
	
	public void optionalOnSource(Object element){
		changeMultiplicityOnSource(element, "0..1");
	}
	
	public void singularOnSource(Object element){
		changeMultiplicityOnSource(element, "1");
	}
	

	private void changeMultiplicityOnTarget(Object element, String value){
		if(element instanceof AssociationElement){
			AssociationElement con = (AssociationElement)element;
			RefOntoUML.Property endpoint = ((RefOntoUML.Association)con.getRelationship()).getMemberEnd().get(1);
			changeMultiplicity(endpoint, value);
		}
	}
    
	public void twoAtLeastOnTarget(Object element){
		changeMultiplicityOnTarget(element, "2..*");
	}
	
	public void twoOnTarget(Object element){
		changeMultiplicityOnTarget(element, "2");
	}
	
	public void anyOnTarget(Object element){
		changeMultiplicityOnTarget(element, "0..*");
	}
	
	public void someOnTarget(Object element){
		changeMultiplicityOnTarget(element, "1..*");
	}
	
	public void optionalOnTarget(Object element){
		changeMultiplicityOnTarget(element, "0..1");
	}
	
	public void singularOnTarget(Object element){
		changeMultiplicityOnSource(element, "1");
	}
	
	
	public void otherOnTarget(Object element){
		if(element instanceof AssociationElement){
			AssociationElement con = (AssociationElement)element;
			RefOntoUML.Property endpoint = ((RefOntoUML.Association)con.getRelationship()).getMemberEnd().get(1);
			requestOtherMultiplicity(endpoint);
		}
	}
	
	public void otherOnSource(Object element){
		if(element instanceof AssociationElement){
			AssociationElement con = (AssociationElement)element;
			RefOntoUML.Property endpoint = ((RefOntoUML.Association)con.getRelationship()).getMemberEnd().get(0);
			requestOtherMultiplicity(endpoint);
		}
	}
	
	public void requestOtherMultiplicity(RefOntoUML.Property endpoint){
		Object newMultiplicity = AppMessageManager.get().input("End-point multiplicity","Input the new multiplicity for the end-point:",null,RefOntoUMLFactoryUtil.getMultiplicityAsString(endpoint)); 
		 if(newMultiplicity!=null && newMultiplicity instanceof String){
			 MultiplicityValidator validator = new MultiplicityValidator((String) newMultiplicity);
			 if(validator.isValid()){
				 changeMultiplicity(endpoint, (String) newMultiplicity);
			 }
			 else {
				 AppMessageManager.get().showError("End-point Multiplicity","Could not change the multiplicity");
			 }
		 }	
	}
	
	
	// Classifier Meta-Properties
	public void setExtensional(Object con){
  		if (containsCollective(con)) {
  			new MetaPropertyModelOperation(getCollective(con), MetaProperty.EXTENSIONAL).run();
  		}
  	}
    
    public void setAbstract(Object con){
  		if (containsClassifier(con)) {
  			new MetaPropertyModelOperation(getClassifier(con), MetaProperty.ABSTRACT).run();
  		}
  	}
    
    public void setDerived(Object con){
    	if (containsAssociation(con)) {
  			new MetaPropertyModelOperation(getAssociation(con), MetaProperty.DERIVED).run();
  		}
	}
	
	public void setShareable(Object con){
		if (containsMeronymic(con)) {
			new MetaPropertyModelOperation(getMeronymic(con), MetaProperty.SHAREABLE).run();
		}
	}
	
	public void setImmutablePart(Object con){
		if (containsMeronymic(con)) {
			new MetaPropertyModelOperation(getMeronymic(con), MetaProperty.IMMUTABLE_PART).run();
		}
	}
	
	public void setImmutableWhole(Object con){
		if (containsMeronymic(con)) {
			new MetaPropertyModelOperation(getMeronymic(con), MetaProperty.IMMUTABLE_WHOLE).run();
		}
	}
	
	public void setInseparable(Object con){
		if (containsMeronymic(con)) {
			new MetaPropertyModelOperation(getMeronymic(con), MetaProperty.INSEPARABLE).run();
		}
	}
	
	 public void setEssential(Object con){
		 if (containsMeronymic(con)) {
			 new MetaPropertyModelOperation(getMeronymic(con), MetaProperty.ESSENTIAL).run();
		}
	 }
	
	
	
	// THE ACTIONS BELOW (SUBSETTING AND REDEFINITION) DO NOT MAKE ANY DIRECT CHANGES IN THE MODEL 
	
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
	
	public void subsets(final AssociationElement association, final RefOntoUML.Property endpoint){
		PropertyListEditDialog.open(AppFrame.get(),null, "Subsetted", endpoint, ProjectManager.get().getProject().getRefParser());
		VisibilityCommander.get().showSubsetting(association);
	}
	
	public void redefines(final AssociationElement association, final RefOntoUML.Property endpoint){
		PropertyListEditDialog.open(AppFrame.get(),null, "Redefined", endpoint,ProjectManager.get().getProject().getRefParser());		
		VisibilityCommander.get().showRedefinitions(association);
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
