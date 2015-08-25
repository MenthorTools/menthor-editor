package net.menthor.ontouml2temporalowl.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import RefOntoUML.*;
import RefOntoUML.Class;
import RefOntoUML.Package;
import RefOntoUML.parser.OntoUMLParser;

public class TreeProcessor
{
	private LinkedList<NodeClass> nodes;
	private List<NodeBinAssociation> assocNodes;
	private HashMap<Class, NodeClass> class2node;
	private List<String> kindsNames = null;
	private List<String> collectivesNames = null;
	private List<String> quantitiesNames = null;
	private List<String> relatorsNames = null;
	private List<String> modesNames = null;
	private List<String> qualitiesNames = null;
	private List<String> relationalquasNames = null;
	private List<String> phasedquasNames = null;

	public TreeProcessor (Package p)
	{
		setNodes(new LinkedList<NodeClass>());
		class2node = new HashMap<Class, NodeClass>();
		setAssocNodes(new LinkedList<NodeBinAssociation>());

		/*
		 	To maintain conformance with the Editor Application structure changes,
		 	the 2 following code line were added and the for iteration
		 	was adjusted for correctly access the packaged elements
		 */
		OntoUMLParser ontoParser = new OntoUMLParser(p);
		Set<Object> packagedElements = ontoParser.getAllInstances(Object.class);
		
		ArrayList<Association> associations = new ArrayList<Association>();
		// Pre Process
		for (Object pe : packagedElements) {
		//for (PackageableElement pe : p.getPackagedElement()){
			if (pe instanceof Class)
				ProcessClass((Class) pe);
			if (pe instanceof Association && !(pe instanceof Derivation))
//				ProcessAssociation((Association) pe);	
				associations.add((Association) pe);
		}
		
		for (Association association : associations) {
			ProcessAssociation(association);
		}

		// Set up the specialization tree
		ProcessNodes();		
				
	}

	private void ProcessClass (Class c)
	{
		NodeClass n = new NodeClass(c, this);
		getNodes().add(n);
		class2node.put(c, n);
		
		if (c instanceof Kind)
		{
			if (getKindsNames() == null)
				setKindsNames(new LinkedList<String>());
			getKindsNames().add(c.getName());
		}
		else if (c instanceof Collective)
		{
			if (getCollectivesNames() == null)
				setCollectivesNames(new LinkedList<String>());
			getCollectivesNames().add(c.getName());
		}
		else if (c instanceof Quantity)
		{
			if (getQuantitiesNames() == null)
				setQuantitiesNames(new LinkedList<String>());
			getQuantitiesNames().add(c.getName());
		}
		else if (c instanceof Relator)
		{
			if (getRelatorsNames() == null)
				setRelatorsNames(new LinkedList<String>());
			getRelatorsNames().add(c.getName());
		}
		else if (c instanceof Mode)
		{
			if (getModesNames() == null)
				setModesNames(new LinkedList<String>());
			getModesNames().add(c.getName());
		}
	}

	private void ProcessAssociation(Association a) 
	{
		NodeBinAssociation na = new NodeBinAssociation(a, this);
		getAssocNodes().add(na);
		
		/*
		 	To maintain conformance with the Editor Application structure changes,
		 	the following code couldn't find the classes envolvend
		 	in an association. 
		*/
		//String 	domain = na.getDomain().getName(),
		//		range = na.getRange().getName();
		String domain = a.getMemberEnd().get(0).getType().getName(),
				range = a.getMemberEnd().get(1).getType().getName();
		
		if (a instanceof MaterialAssociation)
		{
			na.mappingName = a.getName() + domain + range;
			na.addSuperAssociation(a.getName());
		} 
		else if (a instanceof FormalAssociation)
		{
			na.mappingName = a.getName() + domain + range;
			na.addSuperAssociation(a.getName());
		}
		else if (a instanceof Meronymic)
		{
			if (a instanceof componentOf)
				na.mappingName = "componentOf";
			else if (a instanceof subCollectionOf)
				na.mappingName = "subCollectionOf";
			else if (a instanceof subQuantityOf)
				na.mappingName = "subQuantityOf";
			else if (a instanceof memberOf)
				na.mappingName = "memberOf";
			//adding superProperty
			na.addSuperAssociation(na.mappingName);
			//renaming association
			na.mappingName += domain + range;
		}
		else if (a instanceof DependencyRelationship)
		{
			//na.mappingName = null => the property is not created
			if (a instanceof Mediation)
				na.addSuperAssociation("mediates"); //to be restricted
			else if (a instanceof Characterization)
				na.addSuperAssociation("inheresIn"); //to be restricted
		}
	}
	
	private void ProcessNodes ()
	{
		// For every node, add children and child partitions
		for (NodeClass n : getNodes())
		{
			// Get the related class
			Class c = n.getRelatedClass();
			
			// Get the generalizations of the class
			for (Generalization g : c.getGeneralization())
			{
				// Get the parent
				Classifier parent = g.getGeneral();
				// Get the parent's node
				NodeClass parentNode = class2node.get(parent);
				// Add the node as a child of the parent
				parentNode.addChild(n);
				
				if (g.getGeneralizationSet().size() != 0)
				{
					// Has partition
					GeneralizationSet gs = g.getGeneralizationSet().get(0);
					// Add the gs as a child partition of the parent
					parentNode.addChildPartition(gs, n);
				}
				else
				{
					// Does not have partition
					// Add the node as a Solitary Child of the parent
					parentNode.addSChild(n);
				}
			}
			
			if (n.isUltimateSortal())
			{
				if (c instanceof Kind)
					n.setDisjointSiblingsNames(getKindsNames());
				else if (c instanceof Quantity)
					n.setDisjointSiblingsNames(getQuantitiesNames());
				else if (c instanceof Collective)
					n.setDisjointSiblingsNames(getCollectivesNames());
			}
		}
		
	}

	public List<NodeClass> getNodes()
	{
		return nodes;
	}
	
	public NodeClass getNode (Class c)
	{
		NodeClass node = class2node.get(c);
		return class2node.get(c);
	}

	public void setNodes(LinkedList<NodeClass> nodes) {
		this.nodes = nodes;
	}

	public List<NodeBinAssociation> getAssocNodes() {
		return assocNodes;
	}

	public void setAssocNodes(List<NodeBinAssociation> assocNodes) {
		this.assocNodes = assocNodes;
	}

	public List<String> getKindsNames() {
		return kindsNames;
	}

	public void setKindsNames(List<String> kindsNames) {
		this.kindsNames = kindsNames;
	}

	public List<String> getCollectivesNames() {
		return collectivesNames;
	}

	public void setCollectivesNames(List<String> collectivesNames) {
		this.collectivesNames = collectivesNames;
	}

	public List<String> getQuantitiesNames() {
		return quantitiesNames;
	}

	public void setQuantitiesNames(List<String> quantitiesNames) {
		this.quantitiesNames = quantitiesNames;
	}

	public List<String> getRelatorsNames() {
		return relatorsNames;
	}

	public void setRelatorsNames(List<String> relatorsNames) {
		this.relatorsNames = relatorsNames;
	}

	public List<String> getModesNames() {
		return modesNames;
	}

	public void setModesNames(List<String> modesNames) {
		this.modesNames = modesNames;
	}

	public List<String> getRelationalquasNames() {
		return relationalquasNames;
	}

	public void setRelationalquasNames(List<String> relationalquasNames) {
		this.relationalquasNames = relationalquasNames;
	}

	public List<String> getPhasedquasNames() {
		return phasedquasNames;
	}

	public void setPhasedquasNames(List<String> phasedquasNames) {
		this.phasedquasNames = phasedquasNames;
	}

	public List<String> getQualitiesNames() {
		return qualitiesNames;
	}

	public void setQualitiesNames(List<String> qualitiesNames) {
		this.qualitiesNames = qualitiesNames;
	}		

}
