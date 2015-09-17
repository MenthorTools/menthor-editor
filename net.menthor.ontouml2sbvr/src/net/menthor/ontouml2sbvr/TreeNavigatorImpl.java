package net.menthor.ontouml2sbvr;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedList;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.DataType;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.NamedElement;
import RefOntoUML.Package;
import RefOntoUML.Class;
import RefOntoUML.PackageableElement;
import RefOntoUML.Type;
import RefOntoUML.Derivation;
import RefOntoUML.Relator;

/**
 * 
 * @author petrux
 * @since 29 July 2014
 */
public class TreeNavigatorImpl implements TreeNavigator {

	private List<Classifier> classes;
	private List<Classifier> topClasses;
	private List<Association> associations;
	private List<DataType> dataTypes;
	private Map<String, Classifier> associationRoles;
	private Map<Classifier, List<Association>> class2associations;
	private Map<Classifier, List<Association>> class2ownedAssociations; 
	private Map<Classifier, List<Classifier>> class2solitaryChildren; 
	private Map<Relator, List<Derivation>> relator2derivations;
	
	public TreeNavigatorImpl() {
		this.init();
	}
	@Override
	public void build(Package rootPackage) {
		this.init();
		this.processPackage(rootPackage);
	}
	@Override
	public Iterable<Classifier> getClasses() {
		return new LinkedList<>(this.classes);
	}
	@Override
	public boolean hasAssociations(Classifier c) {
		return this.class2associations.containsKey(c);
	}
	@Override
	public Iterable<Association> getAssociations(Classifier c) {
		if (!this.class2associations.containsKey(c))
			return new LinkedList<Association>();
		return new LinkedList<>(this.class2associations.get(c));
	}
	@Override
	public boolean hasSolitaryChildren(Classifier c)	{
		return this.doGetSolitaryChildren(c).size() > 0;
	}
	@Override
	public Iterable<Classifier> getSolitatyChildren(Classifier c) {
		return new LinkedList<>(this.doGetSolitaryChildren(c));
	}
	@Override
	public boolean hasOwnedAssociations(Classifier c) {
		return this.class2ownedAssociations.containsKey(c);
	}
	@Override
	public Iterable<Association> getOwnedAssociations(Classifier c) {
		if (!this.class2ownedAssociations.containsKey(c))
			return new LinkedList<>();
		return new LinkedList<>(this.class2associations.get(c));
	}
	@Override
	public Iterable<Derivation> getDerivation(Relator r) 
	{
		if (!this.relator2derivations.containsKey(r)) {
			System.err.println("Relator with no derivation: " + r.getName());
			return new LinkedList<>();
		}
		return new LinkedList<>(this.relator2derivations.get(r));
	}
	
	@Override
	public Iterable<DataType> getDataTypes() {
		return new LinkedList<>(this.dataTypes);
	}
	
	@Override
	public Iterable<Map.Entry<String, Classifier>> getAssociationRoles() {
		return new LinkedList<>(this.associationRoles.entrySet());
	}
	
	private void init() {
		this.classes = new LinkedList<>();
		this.topClasses = new LinkedList<>();
		this.associations = new LinkedList<>();
		this.dataTypes = new LinkedList<>();
		this.associationRoles = new HashMap<>();
		this.class2associations = new HashMap<>();
		this.class2ownedAssociations = new HashMap<>();
		this.class2solitaryChildren = new HashMap<>();
		this.relator2derivations = new HashMap<>();
	}
	private void processPackage(Package p) {
		
		for (PackageableElement e : p.getPackagedElement())
			if (e instanceof Package)
				this.processPackage((Package)e);
		
		for (PackageableElement e : p.getPackagedElement())
			if (e instanceof Class)
				this.processClass((Class)e);
		
		for (PackageableElement e : p.getPackagedElement())
			if (e instanceof Association)
				this.processAssociation((Association)e);
		
		for (PackageableElement e : p.getPackagedElement())
			if (e instanceof DataType)
				this.processDataType((DataType)e);
	}
	private void processAssociation(Association a) {
	
		this.associations.add(a);
		
		if (a instanceof Derivation) {
			Derivation derivation = (Derivation)a;
			Relator relator = (Relator)derivation.relator();
			if (!this.relator2derivations.containsKey(relator))
				this.relator2derivations.put(relator, new ArrayList<Derivation>());
			this.relator2derivations.get(relator).add(derivation);
			return;
		}
		
		/*
		 * TODO: exactly as in the "old" version.
		 * Actually, pretty messy and useless. 
		 */
		
		if (a.getMemberEnd().size() != 2) {
			System.err.println("Non binary association: " 
				+ a.getQualifiedName() + "(" 
				+ a.getMemberEnd().size() + ")");
			return; 
		}
		
		Type t1 = a.getMemberEnd().get(0).getType();
		Type t2 = a.getMemberEnd().get(1).getType();
		
		if (t1 instanceof Class) {
			
			Class c1 = (Class)t1;
			if (!this.class2ownedAssociations.containsKey(c1))
				this.class2ownedAssociations.put(c1, new LinkedList<Association>());
			this.class2ownedAssociations.get(c1).add(a);
			if (!this.class2associations.containsKey(c1))
				this.class2associations.put(c1, new LinkedList<Association>());
			this.class2associations.get(c1).add(a);
			
			//TODO: what if t1 is Class and t2 is not?
			if (t2 instanceof Class) {
				
				Class c2 = (Class)t2;
				if (!this.class2associations.containsKey(c2))
					this.class2associations.put(c2, new LinkedList<Association>());
				this.class2associations.get(c2).add(a);
				
				//TODO: why property names and not classes?
				//HINT: maybe because otherwise ther would be conflict for 
				//      classes partecipating in more than one roles.
				if (hasValidName(a.getMemberEnd().get(0)))
					this.associationRoles.put(a.getMemberEnd().get(0).getName(), (Class)t1);
				if (hasValidName(a.getMemberEnd().get(1)))
					this.associationRoles.put(a.getMemberEnd().get(1).getName(), (Class)t2);
			}
		}
	}
	private void processClass(Class c) {
		
		this.classes.add(c);
		
		/*
		 * If c has no parents, set it 
		 * among the top class instances 
		 */
		if (c.parents().size() == 0)
			this.topClasses.add(c);
	}
	private void processDataType(DataType dt) {
		this.dataTypes.add(dt);
	}
	private boolean hasValidName(NamedElement e) {
		return e.getName() != null && e.getName().length() != 0;
	}
	private List<Classifier> doGetSolitaryChildren(Classifier c) {
		if (!this.class2solitaryChildren.containsKey(c)) {

			Set<Classifier> partitioned = new HashSet<>();
			for (GeneralizationSet gs : c.partitions())
				partitioned.addAll(gs.children());

			List<Classifier> solitaryChildren = new LinkedList<>();
			for (Classifier child : c.children())
				if (!partitioned.contains(child))
					solitaryChildren.add(child);
			
			this.class2solitaryChildren.put(c, solitaryChildren);
		}
		return this.class2solitaryChildren.get(c);
	}
}
