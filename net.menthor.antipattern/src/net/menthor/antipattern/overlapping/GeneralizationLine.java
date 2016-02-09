package net.menthor.antipattern.overlapping;

import java.util.ArrayList;

import net.menthor.antipattern.Antipattern;
import net.menthor.antipattern.AntipatternOccurrence;
import net.menthor.antipattern.wizard.overlapping.GeneralizationLineComposite;
import net.menthor.common.ontoumlfixer.Fix;
import net.menthor.common.ontoumlfixer.OutcomeFixer;

import org.eclipse.swt.widgets.Composite;

import RefOntoUML.Class;
import RefOntoUML.Classifier;
import RefOntoUML.Property;
import RefOntoUML.parser.OntoUMLNameHelper;


public class GeneralizationLine extends OverlappingGroup {
	
	ArrayList<Property> orderedProperties;
	Property parent, child;
	
	public GeneralizationLine (ArrayList<Property> properties, Antipattern<?> antipattern)throws Exception {
		super(properties, antipattern);

		if(properties.size()!=2)
				throw new Exception("GeneralizationLine: Number of properties must be equal to 2.");
		
		Classifier source = (Classifier) properties.get(0).getType();
		Classifier target = (Classifier) properties.get(1).getType();
		
		if(source.allParents().contains(target)){
			child = properties.get(0);
			parent = properties.get(1);
		}
		else if (target.allParents().contains(source)){
			child = properties.get(1);
			parent = properties.get(0);
		}
		else
			throw new Exception("GeneralizationLine: One property type must specialize the other.");

	}
	
	@Override
	public String toString(){
		return	"Overllaping Group: Generalization Line" +
				"\r\n\tParent: "+OntoUMLNameHelper.getNameAndType(parent)+
				"\r\n\tChild: "+OntoUMLNameHelper.getNameAndType(child);
	}

	@Override
	public boolean makeEndsDisjoint(AntipatternOccurrence occurrence, ArrayList<Property> disjointProperties) {
		
		if(!disjointProperties.contains(child) || !disjointProperties.contains(parent))
			return false;
		
		Classifier parentType = (Classifier) parent.getType();
		Classifier childType = (Classifier) child.getType();
		
		if(parent.getAssociation()!=null){
			Fix aux = occurrence.getFixer().createSubTypeAsInvolvingLink(parent.getType(), OutcomeFixer.getDefaultSubtypeStereotype((Class) parent.getType()), parent.getAssociation());
		
			Classifier created = aux.getAddedByType(Class.class).get(0);
			ArrayList<Classifier> subtypes = new ArrayList<Classifier>();
			subtypes.add(created);
		
			if(childType.parents().contains(parentType))
				subtypes.add(childType);
			else{
				for (Classifier directSubtype : childType.allParents()) {
					if(directSubtype.parents().contains(parentType)){
						subtypes.add(directSubtype);
						break;
					}
				}
			}
			
			if(subtypes.size()!=2)
				return false;
			
			occurrence.getFix().addAll(occurrence.getFixer().createGeneralizationSet(parentType, subtypes, true, true));
			occurrence.getFix().addAll(aux);
			
			return true;
		}
		
		return true;
	}

	public ArrayList<Property> getOrderedProperties() {
		return orderedProperties;
	}

	public Property getParent() {
		return parent;
	}

	public Property getChild() {
		return child;
	}

	@Override
	public String getType() {
		return "Generalization Line";
	}

	@Override
	public Composite createComposite(Composite parent, int style) {
		return new GeneralizationLineComposite(parent, style, this);
	}
	
}
