
package net.menthor.editor.v2.managers;

/**
 * ============================================================================================
 * Menthor Editor -- Copyright (c) 2015 
 *
 * This file is part of Menthor Editor. Menthor Editor is based on TinyUML and as so it is 
 * distributed under the same license terms.
 *
 * Menthor Editor is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 *
 * Menthor Editor is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Menthor Editor; 
 * if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, 
 * MA  02110-1301  USA
 * ============================================================================================
 */

import java.text.ParseException;
import java.util.List;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.GeneralizationElement;
import org.tinyuml.umldraw.shared.BaseConnection;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.Generalization;
import RefOntoUML.LiteralInteger;
import RefOntoUML.LiteralUnlimitedNatural;
import RefOntoUML.Property;
import RefOntoUML.Relationship;
import RefOntoUML.Type;
import RefOntoUML.util.RefOntoUMLFactoryUtil;
import net.menthor.common.ontoumlfixer.Fix;
import net.menthor.common.ontoumlfixer.OutcomeFixer;
import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.types.RelationshipType;
import net.menthor.editor.v2.ui.app.AppManager;

public class ChangeManager extends AppManager {
	
	// -------- Lazy Initialization
	
	private static class ChangeLoader {
        private static final ChangeManager INSTANCE = new ChangeManager();
    }	
	public static ChangeManager get() { 
		return ChangeLoader.INSTANCE; 
	}	
    private ChangeManager() {
        if (ChangeLoader.INSTANCE != null) throw new IllegalStateException("ChangeManager already instantiated");
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
   		UpdateManager.get().update(fix);   		   		
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
  		UpdateManager.get().update(fix);
	}
	
	/** Change multiplicity from string */
	public void changeMultiplicity(RefOntoUML.Property property, String multiplicity) throws ParseException {
		RefOntoUMLFactoryUtil.setMultiplicityFromString(property, multiplicity);
		UpdateManager.get().notifyChange(property.getAssociation());
		BrowserManager.get().updateUI();
	}
	
	/** Change multiplicity from integer values */
	public void changeMultiplicity(RefOntoUML.Property property, int lowerValue, int upperValue){
		LiteralInteger lower = FactoryManager.get().createLiteralInteger();
		lower.setValue(lowerValue);
		LiteralUnlimitedNatural upper =  FactoryManager.get().createLiteralUnlimitedNatural();
		upper.setValue(upperValue);				
		property.setLowerValue(lower);			
		property.setUpperValue(upper);
		UpdateManager.get().notifyChange(property.getAssociation());
		BrowserManager.get().updateUI();
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
	   		
	   		browser().getTree().checkObject(source);
	   		browser().getTree().removeCurrentNode();
	   		browser().getTree().checkObject(target);
	   		browser().getTree().removeCurrentNode();
	   		browser().getTree().checkObject(association);
	   		browser().getTree().addChild(source);  
	   		browser().getTree().addChild(target);  
	   		browser().getTree().updateUI();
	   		UpdateManager.get().updateFromChange(association, true);
		}
		else if (connection instanceof GeneralizationElement){
			Generalization generalization = ((GeneralizationElement) connection).getGeneralization();
			Classifier general = generalization.getGeneral();
			Classifier specific = generalization.getSpecific();
			
			generalization.setSpecific(general);
			generalization.setGeneral(specific);
			
			BrowserManager.get().updateUI();
			UpdateManager.get().updateFromChange(generalization, true);
			
		}
		
	}
	
	/** Invert names of end points of an association. */
	public void invertEndNames(BaseConnection connection){
		if(!(connection instanceof AssociationElement))
			return;
			
		Association association = ((AssociationElement) connection).getAssociation();	
		Property source = association.getMemberEnd().get(0);
   		Property target = association.getMemberEnd().get(1);
   		String sourceName = source.getName();
   		String targetName = target.getName();
   		source.setName(targetName);
   		target.setName(sourceName);
   		UpdateManager.get().updateFromChange(association, false);
	}
	
	/** Invert multiplicities of end points of an association. */
	public void invertEndMultiplicities(BaseConnection connection){
		if(!(connection instanceof AssociationElement))
			return;
			
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
   		UpdateManager.get().updateFromChange(association, false);
	}
	
	/** Invert types of end points of an association. */
	public void invertEndTypes(BaseConnection connection){
		if(!(connection instanceof AssociationElement))
			return;
			
		Association association = ((AssociationElement) connection).getAssociation();
		Property source = association.getMemberEnd().get(0);
   		Property target = association.getMemberEnd().get(1);
   		Type sourceType = source.getType();
   		Type targetType = target.getType();
   		source.setType(targetType);
   		target.setType(sourceType);
   		UpdateManager.get().updateFromChange(association, true);
	}
}
