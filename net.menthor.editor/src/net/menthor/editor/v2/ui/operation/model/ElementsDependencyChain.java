package net.menthor.editor.v2.ui.operation.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import RefOntoUML.Element;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.parser.OntoUMLParser;

public class ElementsDependencyChain {

	/** requested list */
	protected List<Element> requestedList= new ArrayList<Element>();
	
	/** not requested but connected to some of the elements requested  */
	protected List<Element> directRelationshipsList = new ArrayList<Element>(); 
	
	/** not requested but connected to an element which is also connected to a requested element */
	protected List<Element> indirectRelationshipsList = new ArrayList<Element>();
		
	/** generalizations with their generalization sets */
	protected Map<Generalization, GeneralizationSet> genMap = new HashMap<Generalization,GeneralizationSet>();
	
	protected List<GeneralizationSet> emptyGenSetList = new ArrayList<GeneralizationSet>();
	
	public void lookupForDependencies(OntoUMLParser refparser, List<Element> elements){
		requestedList.clear();
		requestedList.addAll(elements);
		
		//get relationships which were not requested 
		//but which are connected to some of the elements requested
		directRelationshipsList.clear();
		directRelationshipsList = refparser.getDirectRelationships(requestedList);
		
		//get relationships which were not requested and which are not in the list of direct dependency
		//such as derivations or any other relationship between relationship
		indirectRelationshipsList.clear();
		indirectRelationshipsList = refparser.getDirectRelationships(directRelationshipsList);
		indirectRelationshipsList.removeAll(requestedList);	
		
		genMap.clear();
		for(Element e: getAll()){
			if(e instanceof GeneralizationSet){		
				GeneralizationSet genSet = (GeneralizationSet)e;
				for(Generalization gen: genSet.getGeneralization()){				
					if(gen!=null) genMap.put(gen,genSet);
				}
			}
			if(e instanceof Generalization){		
				Generalization gen = (Generalization)e;
				for(GeneralizationSet genSet: gen.getGeneralizationSet()){				
					if(genSet!=null) genMap.put(gen,genSet);
				}
			}
		}
		
		emptyGenSetList.clear();
	}
	
	public GeneralizationSet getGeneralizationSet(Generalization gen){		
		return genMap.get(gen);
	}
	
	public List<Generalization> getGeneralizations(GeneralizationSet genSet){
		List<Generalization> gens = new ArrayList<Generalization>();
		for(Map.Entry<Generalization,GeneralizationSet> entry: genMap.entrySet()){
			if(entry.getValue().equals(genSet)){
				gens.add(entry.getKey());
			}
		}
		return gens;
	}
	
	public List<GeneralizationSet> getEmptyGeneralizationSets(){	
		emptyGenSetList.clear();
		for(GeneralizationSet gs: genMap.values()){
			if(gs.getGeneralization().size()==0) emptyGenSetList.add(gs);
		}
		return emptyGenSetList;
	}
	
	public List<Element> getRequested(){
		return requestedList;
	}
	
	public List<Element> getDirectRelationshipDependencies(){
		return directRelationshipsList;
	}
	
	public List<Element> getIndirectRelationshipDependencies(){
		return indirectRelationshipsList;
	}
	
	public List<Element> getAll(){		
		List<Element> result = new ArrayList<>();
		result.addAll(requestedList);
		result.addAll(indirectRelationshipsList);
		result.addAll(directRelationshipsList);
		result.addAll(emptyGenSetList);
		return result;
	}
		
}
