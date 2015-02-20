package net.menthor.antipattern.partover;

import java.util.HashSet;

import net.menthor.antipattern.overlapping.OverlappingGroup;
import net.menthor.antipattern.overlapping.OverlappingOccurrence;
import RefOntoUML.Classifier;
import RefOntoUML.Meronymic;
import RefOntoUML.Property;
import RefOntoUML.parser.OntoUMLNameHelper;

public class PartOverOccurrence extends OverlappingOccurrence{

	public PartOverOccurrence(Classifier part, HashSet<Property> wholeEnds, PartOverAntipattern ap) throws Exception {
		super(ap, part, wholeEnds);
		
		for (Property p : getAllWholeEnds()) {
			if(!(p.getAssociation() instanceof Meronymic))
				throw new Exception(PartOverAntipattern.getAntipatternInfo().getAcronym()+": All provided properties must belong to a meronymc.");
		}
	}
	
	public Classifier getPart(){
		return getMainType();
	}
	
	public HashSet<Property> getAllWholeEnds(){
		return getAllProperties();
	}
	
	@Override
	public String toString() {
		String result;
		
		result = "Part: "+getParser().getStringRepresentation(getPart())+"\n"+
				 "All Wholes: ";
				
		for (Property p : getAllWholeEnds())
			result+="\n\t"+getParser().getStringRepresentation(p);
				
		for (OverlappingGroup variation : getGroups()) {
			result+="\n\n"+variation.toString();
		}
		
		return result;
	}

	@Override
	public String getShortName() {
		return "Part: "+parser.getStringRepresentation(getPart());
	}

	@Override
	public String getPropertyTypeString() {
		return "whole types of";
	}

	@Override
	public String getExclusiveExample() {
		return "";
	}

	@Override
	public String getBaseClassType() {
		return "Part";
	}

	@Override
	public String getGroupTypeLine() {
		return "The current overlapping group of part "+OntoUMLNameHelper.getTypeAndName(getPart(),true, true)+" is composed by the following wholes:";
	}
	

}
