
package net.menthor.editor.v2.managers;

import java.text.ParseException;
import java.util.List;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.umldraw.ClassElement;

import RefOntoUML.LiteralInteger;
import RefOntoUML.LiteralUnlimitedNatural;
import RefOntoUML.Property;
import RefOntoUML.Relationship;
import RefOntoUML.Type;
import RefOntoUML.util.RefOntoUMLFactoryUtil;
import net.menthor.common.ontoumlfixer.Fix;
import net.menthor.common.ontoumlfixer.OutcomeFixer;
import net.menthor.editor.ui.Models;
import net.menthor.editor.v2.trees.ProjectTree;
import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.types.RelationshipType;

public class ChangeManager extends BaseManager {
	
	private static ChangeManager instance = new ChangeManager();
	public static ChangeManager get() { return instance; }
		
	/** Change relation stereotype */ 
	public void changeRelationStereotype(RelationshipType type, RefOntoUML.Relationship element){	
		changeRelationStereotype(element, type.getName());
	}	
	
	/** Change relation stereotype */ 
	public void changeRelationStereotype(Relationship type, String stereo){	
   		OutcomeFixer fixer = new OutcomeFixer(Models.getRefparser().getModel());
   		Fix fix = fixer.changeRelationStereotypeTo(type, fixer.getRelationshipStereotype(stereo));   		
   		UpdateManager.get().update(fix);   		   		
   	}
	
	/** Change a class stereotype */ 
	public void changeClassStereotype(ClassType type, RefOntoUML.Element element){ 
		changeClassStereotype((RefOntoUML.Type)element, type.getName());
	}
	
	/** Change a class stereotype */ 
	public void changeClassStereotype(Type type, String stereo){   
		List<DiagramElement> diagramElements = OccurenceManager.get().getDiagramElements(type);		
   		OutcomeFixer fixer = new OutcomeFixer(Models.getRefparser().getModel());
   		Fix fix = fixer.changeClassStereotypeTo(type, fixer.getClassStereotype(stereo));   	
   		for(DiagramElement de: diagramElements){
	   		if (de !=null && de instanceof ClassElement) {
	   			double x = ((ClassElement)de).getAbsoluteX1();
	   			double y = ((ClassElement)de).getAbsoluteY1();   	   		
	   	   		fix.setAddedPosition(fix.getAdded().get(0),x,y);
	   		}
   		}
  		UpdateManager.get().update(fix);
	}
	
	/** Change multiplicity from string */
	public void changeMultiplicity(RefOntoUML.Property property, String multiplicity) throws ParseException {
		RefOntoUMLFactoryUtil.setMultiplicityFromString(property, multiplicity);
		UpdateManager.get().notifyChange(property.getAssociation());
		browser.refresh();
	}
	
	/** Change multiplicity from integer values */
	public void changeMultiplicity(RefOntoUML.Property property, int lowerValue, int upperValue){
		LiteralInteger lower = factory.getFactory().createLiteralInteger();
		lower.setValue(lowerValue);
		LiteralUnlimitedNatural upper =  factory.getFactory().createLiteralUnlimitedNatural();
		upper.setValue(upperValue);				
		property.setLowerValue(lower);			
		property.setUpperValue(upper);
		UpdateManager.get().notifyChange(property.getAssociation());
		browser.refresh();
	}
	
	/** Invert end points of an association. */
	public void invertEndPoints(RefOntoUML.Association association){
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
   		ProjectTree tree = browser.getTree();
   		tree.checkElement(source);
   		tree.removeCurrentNode();   		
   		tree.checkElement(association);
   		tree.addElement(source);  
   		tree.updateUI();
   		UpdateManager.get().updateFromChange(association, true);
	}
	
	/** Invert names of end points of an association. */
	public void invertEndNames(RefOntoUML.Association association){
		Property source = association.getMemberEnd().get(0);
   		Property target = association.getMemberEnd().get(1);
   		String sourceName = source.getName();
   		String targetName = target.getName();
   		source.setName(targetName);
   		target.setName(sourceName);
   		UpdateManager.get().updateFromChange(association, false);
	}
	
	/** Invert multiplicities of end points of an association. */
	public void invertEndMultiplicities(RefOntoUML.Association association){
		Property source = association.getMemberEnd().get(0);
   		Property target = association.getMemberEnd().get(1);
   		LiteralInteger sourceLower = factory.getFactory().createLiteralInteger();
   		LiteralUnlimitedNatural sourceUpper = factory.getFactory().createLiteralUnlimitedNatural();
   		sourceLower.setValue(target.getLower());
   		sourceUpper.setValue(target.getUpper());   		
   		LiteralInteger targetLower = factory.getFactory().createLiteralInteger();
   		LiteralUnlimitedNatural targetUpper = factory.getFactory().createLiteralUnlimitedNatural();
   		targetUpper.setValue(source.getUpper());
   		targetLower.setValue(source.getLower());  	
   		source.setUpperValue(sourceUpper);
   		source.setLowerValue(sourceLower);
   		target.setUpperValue(targetUpper);
   		target.setLowerValue(targetLower);
   		UpdateManager.get().updateFromChange(association, false);
	}
	
	/** Invert types of end points of an association. */
	public void invertEndTypes(RefOntoUML.Association association){
		Property source = association.getMemberEnd().get(0);
   		Property target = association.getMemberEnd().get(1);
   		Type sourceType = source.getType();
   		Type targetType = target.getType();
   		source.setType(targetType);
   		target.setType(sourceType);
   		UpdateManager.get().updateFromChange(association, true);
	}
}
