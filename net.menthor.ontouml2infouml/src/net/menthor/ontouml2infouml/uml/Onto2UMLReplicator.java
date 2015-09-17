package net.menthor.ontouml2infouml.uml;

import java.util.List;

import net.menthor.ontouml2infouml.Onto2InfoMap;

public class Onto2UMLReplicator
{		
	// Creates UML Objects	
	static org.eclipse.uml2.uml.UMLFactory myfactory;
	
	public Onto2UMLReplicator()
	{
		myfactory = org.eclipse.uml2.uml.UMLFactory.eINSTANCE;
	}
	
	public void replicateNamedElement (RefOntoUML.NamedElement ne1, org.eclipse.uml2.uml.NamedElement ne2)
	{
		// name
		ne2.setName(ne1.getName());

		// visibility
        RefOntoUML.VisibilityKind vk1 = ne1.getVisibility();
        // I'm not sure if this part is 100% right (it's different from the rcfront2ref plugin)
        if (vk1.getValue() == RefOntoUML.VisibilityKind.PUBLIC_VALUE)
        {
        	ne2.setVisibility(org.eclipse.uml2.uml.VisibilityKind.PUBLIC_LITERAL);
        }
        else if (vk1.getValue() == RefOntoUML.VisibilityKind.PRIVATE_VALUE)
        {
        	ne2.setVisibility(org.eclipse.uml2.uml.VisibilityKind.PRIVATE_LITERAL);
        }
        else if (vk1.getValue() == RefOntoUML.VisibilityKind.PROTECTED_VALUE)
        {
        	ne2.setVisibility(org.eclipse.uml2.uml.VisibilityKind.PROTECTED_LITERAL);
        }
        else if (vk1.getValue() == RefOntoUML.VisibilityKind.PACKAGE_VALUE)
        {
        	ne2.setVisibility(org.eclipse.uml2.uml.VisibilityKind.PACKAGE_LITERAL);
        }
    }
	
	public org.eclipse.uml2.uml.Model partiallyCreateModel (RefOntoUML.Package m1)
	{
		org.eclipse.uml2.uml.Model m2 = myfactory.createModel();
        replicateNamedElement(m1, m2);
        Onto2InfoMap.relateElements(m1, m2);
        return m2;
	}
    
	public void replicateProperty (RefOntoUML.Property p1, org.eclipse.uml2.uml.Property p2)
    {            
        replicateNamedElement (p1, p2);
        
        // isLeaf (RedefinableElement)
        p2.setIsLeaf(p1.isIsLeaf());
        // isStatic (Feature)
        p2.setIsStatic(p1.isIsStatic());
        // isReadOnly (StructuralFeature)
        p2.setIsReadOnly(p1.isIsReadOnly());                      

        // lower, upper (MultiplicityElement)            
        org.eclipse.uml2.uml.LiteralInteger lowerValue = myfactory.createLiteralInteger();
        org.eclipse.uml2.uml.LiteralUnlimitedNatural upperValue = myfactory.createLiteralUnlimitedNatural();
        lowerValue.setValue(p1.getLower());
        upperValue.setValue(p1.getUpper()); 
            
        p2.setLowerValue(lowerValue);
        p2.setUpperValue(upperValue);
                
        // Type (TypedElement)
        org.eclipse.uml2.uml.Type t2 = Onto2InfoMap.getType(p1.getType());
        p2.setType(t2);
        
        // isDerived
        p2.setIsDerived(p1.isIsDerived());
        
        // aggregation
        RefOntoUML.AggregationKind ak1 = p1.getAggregation();
        // I'm not sure if this part is 100% right (it's different from the rcfront2ref plugin)
        if (ak1.getValue() == RefOntoUML.AggregationKind.NONE_VALUE)
        {
        	p2.setAggregation(org.eclipse.uml2.uml.AggregationKind.NONE_LITERAL);                     
        }
        else if (ak1.getValue() == RefOntoUML.AggregationKind.SHARED_VALUE)
        {
            p2.setAggregation(org.eclipse.uml2.uml.AggregationKind.SHARED_LITERAL);
        }               
        else if (ak1.getValue() == RefOntoUML.AggregationKind.COMPOSITE_VALUE)
        {
            p2.setAggregation(org.eclipse.uml2.uml.AggregationKind.COMPOSITE_LITERAL);
        }        
    }
	
	public org.eclipse.uml2.uml.Property createProperty (RefOntoUML.Property p1)
	{
		org.eclipse.uml2.uml.Property p2 = myfactory.createProperty();
		replicateProperty(p1, p2);
		return p2;
	}
	
	public void replicateClassifier (RefOntoUML.Classifier c1, org.eclipse.uml2.uml.Classifier c2)
    {
        replicateNamedElement (c1, c2);
        // Important for Generalization, Property
        Onto2InfoMap.relateElements (c1, c2);
        // Is Abstract
        c2.setIsAbstract(c1.isIsAbstract());        
    }
	
	public void replicateClass (RefOntoUML.Class c1, org.eclipse.uml2.uml.Class c2)
    {		
        replicateClassifier (c1, c2);

        // Attributes
        org.eclipse.uml2.uml.Property p2;
        for (RefOntoUML.Property p1 : c1.getAttribute())
        {
            p2 = createProperty(p1);       
            c2.getOwnedAttributes().add(p2);
        }         
    }
	
	public org.eclipse.uml2.uml.Class createClass (RefOntoUML.Class c1)
	{
		org.eclipse.uml2.uml.Class c2 = myfactory.createClass();
		replicateClass (c1, c2);
		return c2;
	}
	
	private org.eclipse.uml2.uml.Property createMemberEnd (org.eclipse.uml2.uml.Association a2, RefOntoUML.Property p1)
	{
		org.eclipse.uml2.uml.Property p2 = createProperty(p1);
		
		// memberEnd
		a2.getMemberEnds().add(p2);
		// EOpposite of memberEnd
		p2.setAssociation(a2);

		// ownedEnd
		a2.getOwnedEnds().add(p2);
		// navigableOwnedEnd
		a2.getNavigableOwnedEnds().add(p2);
		
		Onto2InfoMap.relateElements(p1, p2);
		
		return p2;
	}
	
	public org.eclipse.uml2.uml.Association createAssociationRepresentingRoleMixin (RefOntoUML.RoleMixin roleMixin)
	{
		return createAssociationRepresentingRoleClass (roleMixin.mediation(), null, roleMixin.getName());
	}
	
	public org.eclipse.uml2.uml.Association createAssociationRepresentingRole (RefOntoUML.Role role)
	{
		return createAssociationRepresentingRoleClass (role.mediation(), role.rigidParent(), role.getName());
	}
	
	private org.eclipse.uml2.uml.Association createAssociationRepresentingRoleClass (RefOntoUML.Mediation mediation, RefOntoUML.RigidSortalClass rigidParent, String roleName)
	{
		// This will be an association between the RelatorType and the more specific RigidParentType
		org.eclipse.uml2.uml.Association a2 = myfactory.createAssociation();

		// The mapping will be between an RefOntoUML.Mediation and a UML.Association
		replicateClassifier(mediation, a2);
		
		// isDerived (I don't believe Mediations are ever derived)
		a2.setIsDerived(false);        

		// Create memberEnds
		org.eclipse.uml2.uml.Property p2;

		// Create Relator End
		p2 = createMemberEnd(a2, mediation.relatorEnd());
		// Setting the cardinality to [0, *]
		org.eclipse.uml2.uml.LiteralInteger lowerValue = myfactory.createLiteralInteger();
        org.eclipse.uml2.uml.LiteralUnlimitedNatural upperValue = myfactory.createLiteralUnlimitedNatural();
        lowerValue.setValue(0);
        upperValue.setValue(-1); // FIXME: depends on history tracking
        p2.setLowerValue(lowerValue);
        p2.setUpperValue(upperValue);
		
		// Create Rigid Parent End
		p2 = createMemberEnd(a2, mediation.mediatedEnd());
		// Roles only
		if (rigidParent != null)
		{
			// Property Type -> RigidParentType (since there is no RoleType)
			p2.setType(Onto2InfoMap.getType(rigidParent));
		}
		// Property name -> Role name
		p2.setName(roleName);
		
		return a2;
	}
	
	private void replicateGeneralization (RefOntoUML.Generalization gen1, org.eclipse.uml2.uml.Generalization gen2)
    {            
        // source (Specific)
        RefOntoUML.Classifier e1 = (RefOntoUML.Classifier) gen1.getSpecific();
        org.eclipse.uml2.uml.Classifier e2 = Onto2InfoMap.getClassifier(e1);
        
        // Poderia ter setado apenas um dos dois (Generalization::Specific, Classifier::Generalization), ja que sao EOpposites
        gen2.setSpecific(e2);
        // O Specific tem posse do generalization
        e2.getGeneralizations().add(gen2);

        // target (General)
        e1 = (RefOntoUML.Classifier) gen1.getGeneral();
        e2 = Onto2InfoMap.getClassifier(e1);

        gen2.setGeneral(e2);
        
        // Important for GeneralizationSet
        Onto2InfoMap.relateElements (gen1, gen2);
	}
	
	public org.eclipse.uml2.uml.Generalization createGeneralization (RefOntoUML.Generalization gen1)
	{
		org.eclipse.uml2.uml.Generalization gen2 = myfactory.createGeneralization();
        replicateGeneralization (gen1, gen2);
        return gen2;
	}
	
     public void createAllGeneralizations (RefOntoUML.Classifier c1)
     {
        // Generalizations
        for (RefOntoUML.Generalization gen1 : c1.getGeneralization())
        {
        	createGeneralization(gen1);
        }       
     }
     
     public org.eclipse.uml2.uml.GeneralizationSet createGeneralizationSet (RefOntoUML.GeneralizationSet gs1, List<RefOntoUML.Generalization> genList)
     {
        org.eclipse.uml2.uml.GeneralizationSet gs2 = myfactory.createGeneralizationSet();
             
        replicateNamedElement(gs1, gs2);
        		
        // Adds only the generalizations in list
        for  (RefOntoUML.Generalization gen1 : genList)
        {
        	org.eclipse.uml2.uml.Generalization gen2 = Onto2InfoMap.getGeneralization(gen1);

        	// Poderia ter setado apenas um dos dois (GeneralizationSet::Generalization, Generalization::GeneralizationSet), ja que sao EOpposites
            gs2.getGeneralizations().add(gen2);
            gen2.getGeneralizationSets().add(gs2);
        }
             
        // isCovering, isDisjoint
        gs2.setIsCovering(gs1.isIsCovering());
        gs2.setIsDisjoint(gs1.isIsDisjoint());
        
        // They are PackageableElements, don't forget it
        Onto2InfoMap.relateElements (gs1, gs2);
             
        return gs2;
     }
}
