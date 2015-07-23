package net.menthor.ontouml2infouml.impl;

import java.util.LinkedList;
import java.util.List;

import net.menthor.ontouml2infouml.Onto2InfoMap;
import net.menthor.ontouml2infouml.decision.DecisionHandler;
import net.menthor.ontouml2infouml.ui.Onto2InfoInterface;
import net.menthor.ontouml2infouml.uml.Onto2UMLReplicator;
import RefOntoUML.util.RefOntoUMLModelAbstraction;

public class Scope
{
	Transformation main;
	RefOntoUMLModelAbstraction ontoAbstraction;
	Onto2UMLReplicator fa;
	DecisionHandler dh;
	Onto2InfoInterface ui;

	
	Scope(Transformation t)
	{
		this.main = t;
		this.fa = new Onto2UMLReplicator();
		
		this.ontoAbstraction = main.ontoAbstraction;
		this.dh = main.dh;
		this.ui = main.ui;
	}
	
	public void dealScope()
	{
		createModel();
		createClasses();
		createAssociations();
		createGeneralizations();
	}
	
	private void createModel()
	{
		if (main.umlAbstraction.umlmodel == null)
		{
			// Transformation from scratch
			main.umlAbstraction.umlmodel = fa.partiallyCreateModel(ontoAbstraction.model);
		}
	}
	
	private void createClasses ()
	{
		// All OntoUML.ObjectClasses (except Roles, Phases and Qualities)
		for (RefOntoUML.Class c : ontoAbstraction.classes)
		{
			if (!(c instanceof RefOntoUML.AntiRigidSortalClass) && !(c instanceof RefOntoUML.Quality))
			{
				// Corresponding UML.Class
				org.eclipse.uml2.uml.Class c2 = Onto2InfoMap.getClass(c);
				
				// Scope
				if (dh.inScope(c))
				{
					// In Scope
					if (c2 == null)
					{
						// Create corresponding UML.Class
			        	c2 = fa.createClass(c);
			        	main.umlAbstraction.addPackageableElement(c2);
			        	
			        	if (c instanceof RefOntoUML.RoleMixin)
			        	{
			        		c2.setName("Potential".concat(c2.getName()));
			        	}
			        	
			        	ui.writeLog("Created UML.Class " + c2.getName());
			        	Log.addition();
					}
				}
				else
				{
					// Not in Scope
					if (c2 != null)
					{
						// Remove the corresponding UML.Class
						main.umlAbstraction.removePackageableElement(c2);
						// Remove the mapping between the OntoUML.Class and the UML.Class
						Onto2InfoMap.removeElement(c);
						// If some day OntoUML.Classes could have attributes, an OntoUML.Property<->UML.Property mapping would also have to be removed

						ui.writeLog("Removed UML.Class " + c2.getName());
						Log.removal();
					}
				}
			}
		}	
	}
	
	private void createAssociations ()
	{
		// Roles + RoleMixins
		List<RefOntoUML.Class> qroles = new LinkedList<RefOntoUML.Class>(ontoAbstraction.roles);
		qroles.addAll(ontoAbstraction.roleMixins);
		
		// For each Role/RoleMixin
        for (RefOntoUML.Class qrole : qroles)
        {
        	RefOntoUML.Role role = null;
        	RefOntoUML.RoleMixin roleMixin = null;
        	RefOntoUML.Mediation mediation = null;
        	boolean scope = true;
        	
        	if (qrole instanceof RefOntoUML.Role)
        	{
        		// Scope for Role
        		role = (RefOntoUML.Role) qrole;
        		RefOntoUML.Class relator = role.relator();
        		mediation = role.mediation();
        		RefOntoUML.Class rigidParent = role.rigidParent();
        		
        		// There must be a Relator/Mediation
        		if (relator!=null && mediation!=null && rigidParent!=null)
        		{
            		// The Role, the Relator and the RigidParent must be in Scope
        			scope = dh.inScope(role) && dh.inScope(relator) && dh.inScope(rigidParent);
        		}
        		else
        		{
        			scope = false;
        		}
        	}
        	else if (qrole instanceof RefOntoUML.RoleMixin)
        	{
        		// Scope for RoleMixin
        		roleMixin = (RefOntoUML.RoleMixin) qrole;
        		RefOntoUML.Class relator = roleMixin.relator();
        		mediation = roleMixin.mediation();

        		// There must be a Relator/Mediation
        		if (relator!=null && mediation!=null)
        		{
        			// The RoleMixin and the Relator must be in Scope
        			// FIXME: (and perhaps at least one rigidSortal corresponding to the RoleMixin must be in scope)
        			scope = dh.inScope(roleMixin) && dh.inScope(relator);
        		}
        		else
        		{
        			scope = false;
        		}
        	}
        	
        	// The corresponding UML.Association
        	org.eclipse.uml2.uml.Association a2 = null; 
        	if (mediation != null)	
        		a2 = Onto2InfoMap.getAssociation(mediation);
        	
        	if (scope)
        	{
        		// In Scope        		
        		if (a2 == null)
        		{
        			// No corresponding UML.Association yet
        			if (role != null)
        				a2 = fa.createAssociationRepresentingRole(role);
        			else if (roleMixin != null)
        				a2 = fa.createAssociationRepresentingRoleMixin(roleMixin);
        			
        			main.umlAbstraction.addPackageableElement(a2);
        			
					ui.writeLog("Created UML.Association: " + main.umlAbstraction.associationToString(a2));
					Log.addition();
        		}
        	}
        	else
        	{
        		// Out of Scope
        		if (a2 != null)
        		{					
					// Remove the corresponding UML.Association from the UML.Model
        			main.umlAbstraction.removePackageableElement(a2);
					// Remove the mapping between the OntoUML.Mediation and the UML.Association
					Onto2InfoMap.removeElement(mediation); // mediation won't be null here, since a2 is not
					Onto2InfoMap.removeElement(mediation.relatorEnd()); // subtle detail (OntoUML.Property<->UML.Property mapping)
					Onto2InfoMap.removeElement(mediation.mediatedEnd()); // subtle detail (OntoUML.Property<->UML.Property mapping)
											
					ui.writeLog("Removed UML.Association: " + main.umlAbstraction.associationToString(a2));
					Log.removal();
        		}
        	}
        }
	}
	
	private void createGeneralizations ()
	{
		createReplicateGeneralizations();
		createReplicateGeneralizationSets();
        createArtificialGeneralizationsforRoleMixin();
	}
	
	private void createReplicateGeneralizations ()
	{
		// RigidSortals + AllMixins
		List<RefOntoUML.Class> specifics = new LinkedList<RefOntoUML.Class>(ontoAbstraction.rigidSortals);
		specifics.addAll(ontoAbstraction.allMixins);
		
        // Generalizations (as long as both the specific and the general are in scope)
        for (RefOntoUML.Classifier specific : specifics)
        {
        	// For each Generalization of an OntoUML.Class (excluding Roles and Phases)
			for (RefOntoUML.Generalization gen1 : specific.getGeneralization())
			{
				org.eclipse.uml2.uml.Generalization gen2 = Onto2InfoMap.getGeneralization(gen1);
				
				// generalization.specific and generalization.general in scope
				if (dh.inScope(specific) && dh.inScope(gen1.getGeneral()))
				{
					// In Scope
					if (gen2 == null)
					{
						// Create the corresponding UML.Generalization
						gen2 = fa.createGeneralization(gen1);
						
						ui.writeLog("Created UML.Generalization: " + gen2.getSpecific().getName() + "->" + gen2.getGeneral().getName());
						Log.addition();
					}
				}
				else
				{
					// Out of Scope
					if (gen2 != null)
					{
						// Removes the reference in the map from the OntoUML.Generalization to the UML.Generalization
						Onto2InfoMap.removeElement(gen1);
						
						if (dh.inScope(specific))
						{
							// OntoUML.Specific is in scope
							// Get the UML.Classifier corresponding to the specific
							org.eclipse.uml2.uml.Classifier specific2 = Onto2InfoMap.getClassifier(specific);
							// Remove the UML.Generalization as an owned generalization of the specific UML.Classifier
							main.umlAbstraction.removeGeneralization(specific2, gen2); 
						}
												
						// If the OntoUML.Specific is out of scope then:
						// The corresponding UML.Classifier will be absent/removed from the UML.Model in the previously called method: createdClasses()
						// So, I won't need to remove the UML.Generalizations from the UML.Model or from the specific UML.Classifier

						// gen2.general and gen2.specific may be already gone, so I can't print them
						ui.writeLog("Removed UML.Generalization: " + gen1.getSpecific().getName() + "->" + gen1.getGeneral().getName());
						Log.removal();
					}
				}
			}
        }
	}
	
	private org.eclipse.uml2.uml.Generalization createOrGetArtificialGeneralization (RefOntoUML.RoleMixin roleMixin, RefOntoUML.Role role, List<org.eclipse.uml2.uml.Generalization> genlist)
	{
		// UML.Generalization corresponding to OntoUML.Role (in case the artificial UML.Generalization already exists)
		org.eclipse.uml2.uml.Generalization gen2 = Onto2InfoMap.getGeneralization(role);

		// Role's rigid parent (e.g., OntoUML.Kind.Person from OntoUML.Role.PrivateCustomer)
		RefOntoUML.RigidSortalClass rigidParent = role.rigidParent();
		// UML.Class corresponding to the OntoUML.RigidParent (e.g., UML.Person corresponding to OntoUML.Person)
		org.eclipse.uml2.uml.Classifier specific2 = Onto2InfoMap.getClassifier(rigidParent);

		// OntoUML.Role (<->UML.Generalization), RigidSortal (<->UML.Generalization.specific) and RoleMixin (<->UML.Generalization.general) in scope
		// Maybe I should constrain: OntoUML.Role in scope -> OntoUML.RigidParent in scope
		if (dh.inScope(role) && dh.inScope(rigidParent) && dh.inScope(roleMixin))
		{
			// In Scope
			if (gen2 == null)
			{
				// UML.Generalization (RigidSortal->RoleMixin) does not exist
				// Create artificial Generalization (RigidSortal -> RoleMixin)
				org.eclipse.uml2.uml.Classifier general2 = Onto2InfoMap.getClassifier(roleMixin);    					
				
				gen2 = main.umlAbstraction.createGeneralization (specific2, general2);
				
				// Relates the OntoUML.Role and the UML.Generalization
				Onto2InfoMap.relateElements(role, gen2);
				
				ui.writeLog("Created UML.Generalization (artificial): " + gen2.getSpecific().getName() + "->" + gen2.getGeneral().getName());
				Log.addition();
			}
			
			// The artificial UML.Generalization (that already existed or was just created) must be added to the return list
			genlist.add(gen2);
		}
		else
		{
			// Out of Scope
			if (gen2 != null)
			{
				// UML.Generalization exists    					
				// Removes the reference in the map from the OntoUML.Role to the UML.Generalization
				Onto2InfoMap.removeElement(role);
				
				if (dh.inScope(role)) // let us suppose this implies dh.inScope(rigidParent) (but, right now, this may cause a bug)
				{
					// OntoUML.Specific (UML.Generalization.specific) is in scope
					// Remove the UML.Generalization as an owned generalization of the specific UML.Classifier
					main.umlAbstraction.removeGeneralization(specific2, gen2); 
				}
										
				// If the OntoUML.Specific is out of scope then:
				// The corresponding UML.Classifier will be absent/removed from the UML.Model in the previously called method: createdClasses()
				// So, I won't need to remove the UML.Generalizations from the UML.Model or from the specific UML.Classifier
				
				// Can't print UML.Generalization.general or UML.Generalization.specific because they may be already gone
				ui.writeLog("Removed UML.Generalization (artificial): " + rigidParent.getName() + "->" + roleMixin.getName());
				Log.removal();
			}
		}
		
		return gen2;
	}
	
	private void createOrGetArtificialGeneralizations (RefOntoUML.RoleMixin roleMixin)
	{
		// For each OntoUML.Role of a RoleMixin there will be an (artificial) UML.Generalization between the UML<->Role'sRigidParent and the UML<->RoleMixin
		// (e.g., UML.Person -> UML.Customer, corresponding to OntoUML.Role.PrivateCustomer)
		
		// An already existing artificial UML.GeneralizationSet related to the artificial UML.Generalizations, if any
		org.eclipse.uml2.uml.GeneralizationSet gset2 = null;
		
    	// UML.Generalization List (important to link them later with a UML.GeneralizationSet, in case there must be one)
		List<org.eclipse.uml2.uml.Generalization> genlist = new LinkedList<org.eclipse.uml2.uml.Generalization>();
				
		// For each Role (e.g., PrivateCustomer, CorporateCustomer) of a RoleMixin (e.g., Customer)
		for (RefOntoUML.Role role : roleMixin.roles())
		{
			// UML.Generalization corresponding to OntoUML.Role (in case the artificial UML.Generalization already exists)
			org.eclipse.uml2.uml.Generalization gen2 = createOrGetArtificialGeneralization (roleMixin, role, genlist);
			
			// One more thing... There may be an artificial UML.GeneralizationSet
			if (gen2 != null)
			{
				if (gen2.getGeneralizationSets().size() > 0)
				{
					gset2 = gen2.getGeneralizationSets().get(0);
				}
			}
		}
		
		createArtificialGeneralizationSet (roleMixin, gset2, genlist);
	}
		
	private void createArtificialGeneralizationSet (RefOntoUML.RoleMixin roleMixin, org.eclipse.uml2.uml.GeneralizationSet gset2, List<org.eclipse.uml2.uml.Generalization> genlist)
	{				
		// The UML.GeneralizationSet is only necessary when there is at least two children (rigidSortals) in scope 
		if (genlist.size() > 1)
		{
			// UML.GeneralizationSet "in scope"
			if (gset2 == null)
			{
				// UML.GeneralizationSet does not exist
				// Linking the GeneralizationSet and the Generalizations
    			gset2 = main.umlAbstraction.createGeneralizationSetForRoleMixin (roleMixin, genlist);
    			main.umlAbstraction.addPackageableElement(gset2);
    			
    			ui.writeLog("Created UML.GeneralizationSet (artificial): " + main.umlAbstraction.generalizationSetToString(gset2));
    			Log.addition();
			}
		}
		else
		{
			// UML.GeneralizationSet "out of scope"
			if (gset2 != null)
			{
				// UML.GeneralizationSet exists
				// Remove it from the UML.Model
				main.umlAbstraction.removePackageableElement(gset2);
				
				// For each UML.Generalization in scope, remove its reference to the UML.GeneralizationSet
				for (org.eclipse.uml2.uml.Generalization sgen : genlist)
				{
					sgen.getGeneralizationSets().remove(gset2);
				}
				
				// Cannot print the UML.GeneralizationSet properly because references to UML.Generalizations, generals and specifics may be gone
				ui.writeLog("Removed UML.GeneralizationSet (artificial): " + gset2.getName());
				Log.removal();
			}
		}
	}
	
	private void createArtificialGeneralizationsforRoleMixin ()
	{
        // Artificial Generalizations between RoleMixin Types and RigidSortal Types (as long as both are in scope)
		
		// For each RoleMixin
        for (RefOntoUML.RoleMixin roleMixin : ontoAbstraction.roleMixins)
        {
        	// 1- Create or get (or remove) artificial UML.Generalizations, each corresponding to a Role of the RoleMixin
    		// 2- Create (or remove) an artificial UML.GeneralizationSet for the RoleMixin, if necessary
			createOrGetArtificialGeneralizations (roleMixin);
        }
	}
	
	List<RefOntoUML.Generalization> getGeneralizationsWithSpecificInScope (RefOntoUML.GeneralizationSet gset1)
	{
		List<RefOntoUML.Generalization> genList = new LinkedList<RefOntoUML.Generalization>();
		
		// For each OntoUML.Generalization in OntoUML.GeneralizationSet
		for (RefOntoUML.Generalization gen1 : gset1.getGeneralization())
		{
			// OntoUML.Generalization.specific in Scope
			if (dh.inScope(gen1.getSpecific()))
				genList.add(gen1);
		}
		
		return genList;
	}
	
	private void createReplicateGeneralizationSets ()
	{
		// Generalization Sets (as long as both the parent and (at least some) children are in scope)
		
		// For each OntoUML.GeneralizationSet
		for (RefOntoUML.GeneralizationSet gset1 : ontoAbstraction.generalizationSets)
		{
			// The corresponding UML.GeneralizationSet
			org.eclipse.uml2.uml.GeneralizationSet gset2 = Onto2InfoMap.getGeneralizationSet(gset1);
			
			// Couting OntoUML.GeneralizationSet.children() in scope
			List<RefOntoUML.Generalization> genInScope = getGeneralizationsWithSpecificInScope(gset1);
			
			// GeneralizationSet.parent and at least one GeneralizationSet.child in scope
			if (dh.inScope(gset1.parent()) && genInScope.size() > 1)
			{
				// In Scope
				if (gset2 == null)
				{
					// Creates the corresponding UML.GeneralizationSet
					gset2 = fa.createGeneralizationSet (gset1, genInScope);
					main.umlAbstraction.addPackageableElement(gset2);
					
					ui.writeLog("Created UML.GeneralizationSet: " + main.umlAbstraction.generalizationSetToString(gset2));
					Log.addition();
				}
			}
			else
			{
				// Out of Scope
				if (gset2 != null)
				{
					// Removes the links between the UML.GeneralizationSet and the related UML.Generalizations
					gset2.getGeneralizations().clear();
					// Removes the corresponding UML.GeneralizationSet from the UML.Model
					main.umlAbstraction.removePackageableElement(gset2);
					// Removes the mapping between the OntoUML.GeneralizationSet and the UML.GeneralizationSet
					Onto2InfoMap.removeElement(gset1);
					
					// Cannot print the UML.GeneralizationSet properly because references to UML.Generalizations, generals and specifics may be gone
					ui.writeLog("Removed UML.GeneralizationSet: " + gset2.getName());
					Log.removal();
				}
			}
		}
	}
}
