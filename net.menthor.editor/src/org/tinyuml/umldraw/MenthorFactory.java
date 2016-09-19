package org.tinyuml.umldraw;

import java.util.ArrayList;

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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.LineConnectMethod;
import org.tinyuml.umldraw.shared.BaseConnection;
import org.tinyuml.umldraw.shared.UmlConnection;
import org.tinyuml.umldraw.shared.UmlDiagramElement;
import org.tinyuml.umldraw.shared.UmlNode;

import RefOntoUML.Association;
import RefOntoUML.Characterization;
import RefOntoUML.Comment;
import RefOntoUML.Constraintx;
import RefOntoUML.Derivation;
import RefOntoUML.IntrinsicMomentClass;
import RefOntoUML.MaterialAssociation;
import RefOntoUML.Mediation;
import RefOntoUML.Package;
import RefOntoUML.PackageableElement;
import RefOntoUML.Property;
import RefOntoUML.ReferenceStructure;
import RefOntoUML.Relator;
import RefOntoUML.Structuration;
import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.stereotypes.ClassStereotype;
import RefOntoUML.stereotypes.DataTypeStereotype;
import RefOntoUML.stereotypes.RelationshipStereotype;
import RefOntoUML.util.RefOntoUMLFactoryUtil;
import net.menthor.editor.v2.OntoumlDiagram;

public class MenthorFactory {

	// -------- Lazy Initialization
	
	private static class FactoryLoader {
        private static final MenthorFactory INSTANCE = new MenthorFactory();
    }	
	public static MenthorFactory get() { 
		return FactoryLoader.INSTANCE; 
	}	
    private MenthorFactory() {
    	createPrototypes();
        if (FactoryLoader.INSTANCE != null) throw new IllegalStateException("FactoryManager already instantiated");
    }		
    
    // ----------------------------
        
    private Map<ClassStereotype, UmlDiagramElement> classPrototypes = new HashMap<ClassStereotype, UmlDiagramElement>();  
    private Map<DataTypeStereotype, UmlDiagramElement> datatypesPrototypes = new HashMap<DataTypeStereotype, UmlDiagramElement>();
    private Map<RelationshipStereotype, UmlConnection> relationPrototypes = new HashMap<RelationshipStereotype, UmlConnection>();
    
    private Map<ClassStereotype, Integer> classCounters = new HashMap<ClassStereotype, Integer>();
    private Map<DataTypeStereotype, Integer> datatypeCounters = new HashMap<DataTypeStereotype, Integer>();
    private Map<RelationshipStereotype, Integer> relationCounters = new HashMap<RelationshipStereotype, Integer>();
    
    private void createClassPrototype(ClassStereotype classType){
    	 RefOntoUML.Class class_ = (RefOntoUML.Class)createClass(classType);    
    	 ClassElement classElement = (ClassElement) ClassElement.getPrototype().clone();
    	 classElement.setClassifier(class_);
    	 classPrototypes.put(classType, classElement);
    }
    
    private void createDataTypePrototype(DataTypeStereotype dataType){
    	RefOntoUML.DataType datatype_ = (RefOntoUML.DataType)createDataType(dataType);    
   	 	ClassElement datatypeElement = (ClassElement) ClassElement.getPrototype().clone();
   	 	datatypeElement.setClassifier(datatype_);   	 
   	 	datatypesPrototypes.put(dataType, datatypeElement);
    }
    
    private void createGeneralizationPrototype(RelationshipStereotype relType){
    	RefOntoUML.Relationship generalization = (RefOntoUML.Relationship)createRelationship(relType);    
	    BaseConnection generalizationElement = (BaseConnection) GeneralizationElement.getPrototype().clone();
	    generalizationElement.setRelationship(generalization);
	    relationPrototypes.put(relType, generalizationElement);
    }
    
    private String nextClassTypeCount(ClassStereotype elementType){	  
  	  if (classCounters.get(elementType)!=null) {
  		  int count = classCounters.get(elementType);
  		  classCounters.put(elementType, count+1);
  		  return Integer.toString(count+1);
  	  }else{
  		  classCounters.put(elementType, 0);
  		  return "";
  	  }
    }
    
    private String nextDataTypeCount(DataTypeStereotype elementType){	  
  	  if (datatypeCounters.get(elementType)!=null) {
  		  int count = datatypeCounters.get(elementType);
  		  datatypeCounters.put(elementType, count+1);
  		  return Integer.toString(count+1);
  	  }else{
  		  datatypeCounters.put(elementType, 0);
  		  return "";
  	  }
    }
    
    private String nextRelationshipCount(RelationshipStereotype RelationshipType) {	  
  	  if (relationCounters.get(RelationshipType)!=null) {
  		  int count = relationCounters.get(RelationshipType);
  		  relationCounters.put(RelationshipType, count+1);
  		  return Integer.toString(count+1);
  	  }else{
  		  relationCounters.put(RelationshipType, 0);
  		  return "";
  	  }	  
    }
    
    private void createAssociationPrototype(RelationshipStereotype relType){
    	RefOntoUML.Relationship assoc = (RefOntoUML.Relationship)createRelationship(relType);   
        AssociationElement assocElement = (AssociationElement) AssociationElement.getPrototype().clone();
        assocElement.setRelationship(assoc);
        assocElement.setAssociationType(relType);
        assocElement.setShowOntoUmlStereotype(true);
        if(relType==RelationshipStereotype.DERIVATION) assocElement.setIsDashed(true);
        if(relType==RelationshipStereotype.DERIVATION) assocElement.setShowOntoUmlStereotype(false);
        if(relType==RelationshipStereotype.MEMBEROF) assocElement.setShowOntoUmlStereotype(false);
        if(relType==RelationshipStereotype.SUBCOLLECTIONOF) assocElement.setShowOntoUmlStereotype(false);
        if(relType==RelationshipStereotype.SUBQUANTITYOF) assocElement.setShowOntoUmlStereotype(false);
        if(relType==RelationshipStereotype.COMPONENTOF) assocElement.setShowOntoUmlStereotype(false);
        if(relType==RelationshipStereotype.ASSOCIATION) assocElement.setShowOntoUmlStereotype(false);
        relationPrototypes.put(relType, assocElement);        
    }
    
    private void createPrototypes() {	
    	//factory = RefOntoUMLFactoryUtil.factory;    
    	//factory = RefOntoUMLFactory.eINSTANCE;
    	createClassPrototype(ClassStereotype.KIND);
    	createClassPrototype(ClassStereotype.QUANTITY);
    	createClassPrototype(ClassStereotype.COLLECTIVE);
    	createClassPrototype(ClassStereotype.SUBKIND);
    	createClassPrototype(ClassStereotype.PHASE);
    	createClassPrototype(ClassStereotype.ROLE);
    	createClassPrototype(ClassStereotype.CATEGORY);
    	createClassPrototype(ClassStereotype.ROLEMIXIN);
    	createClassPrototype(ClassStereotype.MIXIN);
    	createClassPrototype(ClassStereotype.MODE);
    	createClassPrototype(ClassStereotype.RELATOR);
    	createClassPrototype(ClassStereotype.PERCEIVABLE_QUALITY);
    	createClassPrototype(ClassStereotype.NONPERCEIVABLE_QUALITY);
    	createClassPrototype(ClassStereotype.NOMINAL_QUALITY);
    	createClassPrototype(ClassStereotype.CLASS);
    	createDataTypePrototype(DataTypeStereotype.DATATYPE);
    	createDataTypePrototype(DataTypeStereotype.STRINGNOMINAL_STRUCTURE);
    	createDataTypePrototype(DataTypeStereotype.MEASUREMENT_DOMAIN);
    	createDataTypePrototype(DataTypeStereotype.INTEGERINTERVAL_DIMENSION);    	
    	createDataTypePrototype(DataTypeStereotype.INTEGERRATIONAL_DIMENSION);
    	createDataTypePrototype(DataTypeStereotype.INTEGERORDINAL_DIMENSION);
    	createDataTypePrototype(DataTypeStereotype.DECIMALINTERVAL_DIMENSION);
    	createDataTypePrototype(DataTypeStereotype.DECIMALRATIONAL_DIMENSION);
    	createDataTypePrototype(DataTypeStereotype.DECIMALORDINAL_DIMENSION);
    	createDataTypePrototype(DataTypeStereotype.ENUMERATION);
    	createDataTypePrototype(DataTypeStereotype.PRIMITIVETYPE);
    	createGeneralizationPrototype(RelationshipStereotype.GENERALIZATION);
    	createAssociationPrototype(RelationshipStereotype.CHARACTERIZATION);
    	createAssociationPrototype(RelationshipStereotype.FORMAL);
    	createAssociationPrototype(RelationshipStereotype.MATERIAL);
    	createAssociationPrototype(RelationshipStereotype.MEDIATION);
    	createAssociationPrototype(RelationshipStereotype.MEMBEROF);
    	createAssociationPrototype(RelationshipStereotype.SUBQUANTITYOF);
    	createAssociationPrototype(RelationshipStereotype.SUBCOLLECTIONOF);
    	createAssociationPrototype(RelationshipStereotype.COMPONENTOF);
    	createAssociationPrototype(RelationshipStereotype.DERIVATION);
    	createAssociationPrototype(RelationshipStereotype.STRUCTURATION);
    	createAssociationPrototype(RelationshipStereotype.ASSOCIATION);
    }

    // ------------- RefOnto --------------
    
    public RefOntoUML.Element createClass(ClassStereotype elementType){
	  RefOntoUML.Element type = null;
	  String name = elementType.getName()+nextClassTypeCount(elementType);
	  if (elementType.equals(ClassStereotype.KIND)) type = RefOntoUMLFactoryUtil.createKind(name, null);
	  else if (elementType.equals(ClassStereotype.COLLECTIVE)) type = RefOntoUMLFactoryUtil.createCollective(name, null);
	  else if (elementType.equals(ClassStereotype.QUANTITY)) type = RefOntoUMLFactoryUtil.createQuantity(name, null);
	  else if (elementType.equals(ClassStereotype.SUBKIND)) type = RefOntoUMLFactoryUtil.createSubKind(name, null);
	  else if (elementType.equals(ClassStereotype.PHASE)) type = RefOntoUMLFactoryUtil.createPhase(name, null);
	  else if (elementType.equals(ClassStereotype.ROLE)) type = RefOntoUMLFactoryUtil.createRole(name, null);
	  else if (elementType.equals(ClassStereotype.CATEGORY)) type = RefOntoUMLFactoryUtil.createCategory(name, null); 	  
	  else if (elementType.equals(ClassStereotype.ROLEMIXIN)) type = RefOntoUMLFactoryUtil.createRoleMixin(name, null); 
	  else if (elementType.equals(ClassStereotype.MIXIN)) type = RefOntoUMLFactoryUtil.createMixin(name, null); 
	  else if (elementType.equals(ClassStereotype.MODE)) type = RefOntoUMLFactoryUtil.createMode(name, null); 
	  else if (elementType.equals(ClassStereotype.RELATOR)) type = RefOntoUMLFactoryUtil.createRelator(name, null); 
	  else if (elementType.equals(ClassStereotype.PERCEIVABLE_QUALITY)) type = RefOntoUMLFactoryUtil.createPerceivableQuality(name, null); 
	  else if (elementType.equals(ClassStereotype.NONPERCEIVABLE_QUALITY)) type = RefOntoUMLFactoryUtil.createNonPerceivableQuality(name, null); 
	  else if (elementType.equals(ClassStereotype.NOMINAL_QUALITY)) type = RefOntoUMLFactoryUtil.createNominalQuality(name, null); 
	  else if (elementType.equals(ClassStereotype.CLASS)) type = RefOntoUMLFactoryUtil.createClass(name, null);
	  return type;	  
  }
  
  public RefOntoUML.Element createDataType(DataTypeStereotype elementType) {
	  RefOntoUML.Element type = null;
	  String name = elementType.getName()+nextDataTypeCount(elementType);
	  if (elementType.equals(DataTypeStereotype.DATATYPE)) { type = RefOntoUMLFactoryUtil.createDataType(name, null);  }	  
	  if (elementType.equals(DataTypeStereotype.ENUMERATION)) { type = RefOntoUMLFactoryUtil.createEnumeration(name, new ArrayList<String>(), null); }
	  if (elementType.equals(DataTypeStereotype.PRIMITIVETYPE)) { type = RefOntoUMLFactoryUtil.createPrimitiveType(name, null);  }	  
	  if (elementType.equals(DataTypeStereotype.STRINGNOMINAL_STRUCTURE)) { type = RefOntoUMLFactoryUtil.createStringNominalStructure(name, null);  }
	  if (elementType.equals(DataTypeStereotype.INTEGERINTERVAL_DIMENSION)) { type = RefOntoUMLFactoryUtil.createIntegerIntervalDimension(name, null); }
	  if (elementType.equals(DataTypeStereotype.INTEGERORDINAL_DIMENSION)) { type = RefOntoUMLFactoryUtil.createIntegerOrdinalDimension(name, null); }
	  if (elementType.equals(DataTypeStereotype.INTEGERRATIONAL_DIMENSION)) { type = RefOntoUMLFactoryUtil.createIntegerRationalDimension(name, null); }
	  if (elementType.equals(DataTypeStereotype.DECIMALINTERVAL_DIMENSION)) { type = RefOntoUMLFactoryUtil.createDecimalIntervalDimension(name, null); }
	  if (elementType.equals(DataTypeStereotype.DECIMALORDINAL_DIMENSION)) { type = RefOntoUMLFactoryUtil.createDecimalOrdinalDimension(name, null); }
	  if (elementType.equals(DataTypeStereotype.DECIMALRATIONAL_DIMENSION)) { type = RefOntoUMLFactoryUtil.createDecimalRationalDimension(name, null); }
	  if (elementType.equals(DataTypeStereotype.MEASUREMENT_DOMAIN)) { type = RefOntoUMLFactoryUtil.createMeasurementDomain(name, null); }
	  return type;	  
  }
  
  public RefOntoUML.Relationship createRelationship(RelationshipStereotype relType){
	  RefOntoUML.Relationship rel = null;
	  String name = relType.getName()+nextRelationshipCount(relType);
	  if (relType.equals(RelationshipStereotype.GENERALIZATION)) rel = RefOntoUMLFactoryUtil.createGeneralization(null, null);
	  if (relType.equals(RelationshipStereotype.CHARACTERIZATION)) rel = RefOntoUMLFactoryUtil.createCharacterization(name, null);
	  if (relType.equals(RelationshipStereotype.FORMAL)) rel = RefOntoUMLFactoryUtil.createFormalAssociation(name, null);
	  if (relType.equals(RelationshipStereotype.MATERIAL)) rel = RefOntoUMLFactoryUtil.createMaterialAssociation(name, null);
	  if (relType.equals(RelationshipStereotype.MEDIATION)) rel = RefOntoUMLFactoryUtil.createMediation(name, null);
	  if (relType.equals(RelationshipStereotype.MEMBEROF)) rel = RefOntoUMLFactoryUtil.createMemberOf(name, null); 
	  if (relType.equals(RelationshipStereotype.SUBQUANTITYOF)) rel = RefOntoUMLFactoryUtil.createSubQuantityOf(name, null);
	  if (relType.equals(RelationshipStereotype.SUBCOLLECTIONOF)) rel = RefOntoUMLFactoryUtil.createSubCollectionOf(name, null); 
	  if (relType.equals(RelationshipStereotype.COMPONENTOF)) rel = RefOntoUMLFactoryUtil.createComponentOf(name, null); 
	  if (relType.equals(RelationshipStereotype.DERIVATION)) rel = RefOntoUMLFactoryUtil.createDerivation(name, null);
	  if (relType.equals(RelationshipStereotype.ASSOCIATION)) rel = RefOntoUMLFactoryUtil.createAssociation(name, null);	  
	  if (relType.equals(RelationshipStereotype.STRUCTURATION)) rel = RefOntoUMLFactoryUtil.createStructuration(name, null);
	  return rel;			  
  }
   
  public RefOntoUML.Element createPackage(){
	  return RefOntoUMLFactoryUtil.createPackage("Package");
  }
  
  public RefOntoUML.Element createGeneralizationSet(){
	  return RefOntoUMLFactoryUtil.createGeneralizationSet(true, true, null);
  }
  
  public Comment createComment(){
	  return RefOntoUMLFactoryUtil.createComment("", null);
  }
  
  public Constraintx createConstraintx(){
	  return RefOntoUMLFactoryUtil.createConstraint("", "", null);
  }
  
  public RefOntoUML.LiteralUnlimitedNatural createLiteralUnlimitedNatural() {
	  return RefOntoUMLFactoryUtil.createLiteralUnlimitedNatural();
  }
  
  public RefOntoUML.LiteralInteger createLiteralInteger(){
	 return RefOntoUMLFactoryUtil.createLiteralInteger();
  }
  
  public RefOntoUML.Classifier cloneClass(RefOntoUML.Class type){
	 return RefOntoUMLFactoryUtil.clone(type);
  }
  
  public RefOntoUML.Classifier cloneClass(ClassStereotype classType, RefOntoUML.Type type){
	  RefOntoUML.PackageableElement newType = (PackageableElement)createClass(classType);
	  return RefOntoUMLFactoryUtil.clone((RefOntoUML.Classifier)newType, (RefOntoUML.Classifier)type);
  }
  
  public RefOntoUML.Classifier cloneDataType(RefOntoUML.DataType type){
	 return RefOntoUMLFactoryUtil.clone(type);
  }
  
  public RefOntoUML.Classifier cloneDataType(DataTypeStereotype classType, RefOntoUML.Type type){
	  RefOntoUML.PackageableElement newType = (PackageableElement)createDataType(classType);
	  return RefOntoUMLFactoryUtil.clone((RefOntoUML.Classifier)newType, (RefOntoUML.Classifier)type);
  }
  
  public RefOntoUML.Relationship cloneRelationship(RefOntoUML.Relationship type){
	 return RefOntoUMLFactoryUtil.cloneRelationship(type);
  }
  
  public RefOntoUML.Relationship cloneRelationship(RelationshipStereotype relType, RefOntoUML.Relationship type){
	  RefOntoUML.Relationship newType = (RefOntoUML.Relationship)createRelationship(relType);
	  return RefOntoUMLFactoryUtil.cloneRelationship(newType, type);
  }
    
  //------------- Node --------------
  
  public UmlNode createNode(ClassStereotype classType, StructureDiagram container) {
    UmlNode umlnode = (UmlNode) classPrototypes.get(classType).clone(); 
    String name = umlnode.getClassifier().getName() + nextClassTypeCount(classType);
    if(umlnode.getClassifier()!=null) umlnode.getClassifier().setName(name);
    if(container.getContainer()!=null && container.getContainer() instanceof RefOntoUML.Package){
    	RefOntoUML.Package pack = ((RefOntoUML.Package)container.getContainer());
    	pack.getPackagedElement().add((RefOntoUML.PackageableElement)umlnode.getClassifier());
    }    
    //it is necessary that the node recognizes its parent here, 
    //in order for it to draw its absolute bounds
    umlnode.setParent(container); 
    //umlnode.addNodeChangeListener(diagram); (unnecessary I suspect)
    OccurenceMap.get().add(umlnode.getClassifier(), umlnode);
    return umlnode;
  }
  
  public UmlNode createNode(DataTypeStereotype dataType, StructureDiagram container){
    UmlNode umlnode = (UmlNode) datatypesPrototypes.get(dataType).clone();
    String name = umlnode.getClassifier().getName() + nextDataTypeCount(dataType);
    if(umlnode.getClassifier() != null) umlnode.getClassifier().setName(name);
    if(container.getContainer()!=null && container.getContainer() instanceof RefOntoUML.Package){
    	RefOntoUML.Package pack = ((RefOntoUML.Package)container.getContainer());
    	pack.getPackagedElement().add((RefOntoUML.PackageableElement)umlnode.getClassifier());    		
    }
    //it is necessary that the node recognizes its parent here, 
    //in order for it to draw its absolute bounds
    umlnode.setParent(container);
    //umlnode.addNodeChangeListener(diagram);  (unnecessary I suspect) 
    OccurenceMap.get().add(umlnode.getClassifier(), umlnode);
    return umlnode;
  }
  
  public UmlNode createNode(RefOntoUML.Type type, StructureDiagram container){
	  UmlNode umlnode=null;  
	  if(type instanceof RefOntoUML.Class){
		  ClassStereotype classType = ClassStereotype.getClassType((RefOntoUML.Class)type);
		  umlnode = (UmlNode) classPrototypes.get(classType).clone();
	  }else{ 
		  DataTypeStereotype dataType = DataTypeStereotype.getDataType((RefOntoUML.DataType)type);
		  umlnode = (UmlNode) datatypesPrototypes.get(dataType).clone();
	  }
	  ((ClassElement)umlnode).setClassifier((RefOntoUML.Classifier)type);	   
	  if(container!=null && container.getContainer()!=null && container.getContainer() instanceof RefOntoUML.Package){
		  RefOntoUML.Package pack = ((RefOntoUML.Package)container.getContainer());
		  pack.getPackagedElement().add((RefOntoUML.PackageableElement)umlnode.getClassifier());			 
	  }
	  //umlnode.addNodeChangeListener(diagram); (unnecessary I suspect)
	  OccurenceMap.get().add(umlnode.getClassifier(), umlnode);
	  return umlnode;
  }
  
  public UmlNode createNode(RefOntoUML.Type type, EObject eContainer){
	  UmlNode umlnode=null;  
	  if(type instanceof RefOntoUML.Class){
		  ClassStereotype classType = ClassStereotype.getClassType((RefOntoUML.Class)type);
		  umlnode = (UmlNode) classPrototypes.get(classType).clone();
	  }else{ 
		  DataTypeStereotype dataType = DataTypeStereotype.getDataType((RefOntoUML.DataType)type);
		  umlnode = (UmlNode) datatypesPrototypes.get(dataType).clone();
	  }
	  ((ClassElement)umlnode).setClassifier((RefOntoUML.Classifier)type);	   
	  if(eContainer!=null){
		  RefOntoUML.Package pack = (RefOntoUML.Package)eContainer;
		  pack.getPackagedElement().add((RefOntoUML.PackageableElement)umlnode.getClassifier());			 
	  }
	  OccurenceMap.get().add(umlnode.getClassifier(), umlnode);
	  return umlnode;
  }
  
  public UmlNode cloneNode(UmlNode node){
	  UmlNode ce = (UmlNode)node.clone();	        
	  //ce.addNodeChangeListener((StructureDiagram)node.getDiagram());
	  OccurenceMap.get().add(ce.getClassifier(), ce);
	  return ce;
  }
  
  // ------------- Connection --------------
 
 //Creates a visual representation for a relation (on the diagram) from an existing relation on the model. Called when draging and droping from the project browser.
  public UmlConnection createVisualConnectionFromModelRelationship(RefOntoUML.Relationship relationship, DiagramElement diagramElement1, DiagramElement diagramElement2){	
	    UmlConnection prototype = relationPrototypes.get(RelationshipStereotype.getRelationshipType(relationship));    
	    UmlConnection conn = null;
	    if (prototype != null){
			conn = (UmlConnection) prototype.clone();
			conn.setRelationship(relationship);		
			bind(conn, diagramElement1, diagramElement2);
	    }
	    if(conn!=null) 
	    	conn.setPoints();
	    
	    OccurenceMap.get().add(conn.getRelationship(), conn);
	    
	    return conn;
	}
		  
  
  public UmlConnection createConnection(RefOntoUML.Relationship relationship, DiagramElement de1, DiagramElement de2){	
    UmlConnection prototype = relationPrototypes.get(RelationshipStereotype.getRelationshipType(relationship));    
    UmlConnection conn = null;
    if (prototype != null){
		conn = (UmlConnection) prototype.clone();
		conn.setRelationship(relationship);		
		bind(conn, de1, de2);
		OntoumlDiagram diagram = de1.getDiagram();
		if(diagram!=null && diagram.getContainer()!=null && diagram.getContainer() instanceof RefOntoUML.Package){	      	
			Package container = (RefOntoUML.Package)de1.getDiagram().getContainer();
			EList<PackageableElement> packagedElement = container.getPackagedElement();
			PackageableElement rel = (RefOntoUML.PackageableElement)conn.getRelationship();
			packagedElement.add(rel);							    	      	      			      	
	    }
    }
    if(conn!=null) conn.setPoints();
    OccurenceMap.get().add(conn.getRelationship(), conn);
    return conn;
  }
    
  //Method called when creating a new relationship from the palette (either the fixed one and the popup one).
  public UmlConnection createConnection(RelationshipStereotype relationType, DiagramElement de1, DiagramElement de2){
	  UmlConnection prototype = relationPrototypes.get(relationType);	  
      UmlConnection conn = null;
      if (prototype != null){
	      conn = (UmlConnection) prototype.clone();
	      bind(conn, de1, de2);
	      OntoumlDiagram diagram = de1.getDiagram();
	      if(conn.getRelationship()!=null && conn.getRelationship() instanceof RefOntoUML.Association){
	    	  RefOntoUML.Association rel = (RefOntoUML.Association)conn.getRelationship();	    	  
	    	  rel.setName(rel.getName() + nextRelationshipCount(relationType));
	    	  setDefaultEndPointNames(rel);
	    	  if(diagram!=null && diagram.getContainer()!=null && diagram.getContainer() instanceof RefOntoUML.Package){	      	
	  			Package container = (RefOntoUML.Package)de1.getDiagram().getContainer();
	  			EList<PackageableElement> packagedElement = container.getPackagedElement();
	  			PackageableElement relationship = (RefOntoUML.PackageableElement)conn.getRelationship();
	  			packagedElement.add(relationship);							    	      	      			      	
	  		  }
	      }		  
		  	      	      
      }	    
      if(conn!=null) conn.setPoints();
      OccurenceMap.get().add(conn.getRelationship(), conn);
      return conn;
  }
  
  private void setDefaultEndPointNames(Association rel) {
	  setDefaultPropertyName(rel.getMemberEnd().get(0));
	  setDefaultPropertyName(rel.getMemberEnd().get(1));
  }
  
  private void setDefaultPropertyName(Property p) {
		if(p==null || p.getType()==null)
			return;
		
	  	String typeName = p.getType().getName();  
		
	  	if(typeName==null) { 
	  		typeName = "";
	  	}
	  	else {
	  		typeName = typeName.trim().replaceAll(" ", "").toLowerCase();
	  	}
	  	
	  	p.setName(typeName);
	  }
  
  public UmlConnection createConnection(RelationshipStereotype relationType, RefOntoUML.Relationship toBeCloned, StructureDiagram diagram){
	  UmlConnection prototype = relationPrototypes.get(relationType);	
	  UmlConnection conn = null;
      if (prototype != null){
	      conn = (UmlConnection) prototype.clone();
	      RefOntoUMLFactoryUtil.cloneRelationship(conn.getRelationship(), toBeCloned);
	      RefOntoUML.Classifier sourceType = OntoUMLParser.getSourceType(conn.getRelationship());
	      RefOntoUML.Classifier targetType = OntoUMLParser.getTargetType(conn.getRelationship());
	      DiagramElement source = OccurenceMap.get().getDiagramElement(sourceType,diagram);
	      DiagramElement target = OccurenceMap.get().getDiagramElement(targetType,diagram);
	      bind(conn, source, target);	      			   
	      conn.setPoints();			  
	  }	  
      OccurenceMap.get().add(conn.getRelationship(), conn);
	  return conn;
  }
  
  public LineConnectMethod getDefaultConnectMethod(RelationshipStereotype RelationshipType){
    UmlConnection connPrototype = relationPrototypes.get(RelationshipType);
    return (connPrototype == null) ? null : connPrototype.getConnectMethod();
  }
  
  private boolean shouldInvert(UmlConnection conn, DiagramElement sourceElement, DiagramElement targetElement){
	  RefOntoUML.Relationship relationship = conn.getRelationship();
	  Object source = sourceElement.getModelObject(),
			 target = targetElement.getModelObject();
	  
	  boolean isInvertedDerivation = relationship instanceof Derivation && !(source instanceof MaterialAssociation) && target instanceof MaterialAssociation,
			  isInvertedCharacterization = relationship instanceof Characterization && !(source instanceof IntrinsicMomentClass) && target instanceof IntrinsicMomentClass,
			  isInvertedMediation = relationship instanceof Mediation && !(source instanceof Relator) && target instanceof Relator,
			  isInvertedStructuration = relationship instanceof Structuration && !(source instanceof ReferenceStructure) && target instanceof ReferenceStructure;
	  
	  return isInvertedDerivation || isInvertedCharacterization || isInvertedMediation || isInvertedStructuration;
  }
  
  private void bind(UmlConnection conn, DiagramElement de1, DiagramElement de2){	  
	  if(de1 instanceof UmlNode && de2 instanceof UmlNode) {
		  if(shouldInvert(conn, de1, de2)) bind(conn, (UmlNode)de2, (UmlNode)de1);
		  else bind(conn, (UmlNode)de1, (UmlNode)de2);
	  }
	  if(de1 instanceof UmlNode && de2 instanceof UmlConnection) {
		  if(shouldInvert(conn, de1, de2)) bind(conn, (UmlConnection)de2, (UmlNode)de1);
		  else bind(conn, (UmlNode)de1, (UmlConnection)de2);
	  }
	  if(de1 instanceof UmlConnection && de2 instanceof UmlNode) {
		  if(shouldInvert(conn, de1, de2)) bind(conn, (UmlNode)de2, (UmlConnection)de1);
		  else bind(conn, (UmlConnection)de1, (UmlNode)de2);
	  }
	  if(de1 instanceof UmlConnection && de2 instanceof UmlConnection){
		  if(shouldInvert(conn, de1, de2)) bind(conn, (UmlConnection)de2, (UmlConnection)de1);
		  else bind(conn, (UmlConnection)de1, (UmlConnection)de2);
	  }
  }
  
  private void bind(UmlConnection conn, UmlNode node1, UmlNode node2) {
	  conn.setNode1(node1);
	  conn.setNode2(node2);
	  OntoUMLParser.setSourceType(conn.getRelationship(), (RefOntoUML.Classifier)node1.getClassifier());
	  OntoUMLParser.setTargetType(conn.getRelationship(), (RefOntoUML.Classifier)node2.getClassifier());
	  if(node1!=null) node1.addConnection(conn);
	  if(node2!=null) node2.addConnection(conn);
  }
  
  private void bind(UmlConnection conn, UmlNode node1, UmlConnection c2) {
	  conn.setNode1(node1);
	  conn.setConnection2(c2);
	  OntoUMLParser.setSourceType(conn.getRelationship(), (RefOntoUML.Classifier)node1.getClassifier());
	  OntoUMLParser.setTargetType(conn.getRelationship(), (RefOntoUML.Classifier)c2.getRelationship());
	  if(node1!=null) node1.addConnection(conn);
	  if(c2!=null) c2.addConnection(conn);  
  }
  
  private void bind(UmlConnection conn, UmlConnection c1, UmlNode node2) {
	  conn.setNode2(node2);
	  conn.setConnection1(c1);
	  OntoUMLParser.setSourceType(conn.getRelationship(), (RefOntoUML.Classifier)c1.getRelationship());
	  OntoUMLParser.setTargetType(conn.getRelationship(), (RefOntoUML.Classifier)node2.getClassifier());
	  if(node2!=null) node2.addConnection(conn);
	  if(c1!=null) c1.addConnection(conn);  
  }
  
  private void bind(UmlConnection conn, UmlConnection c1, UmlConnection c2) {
	  conn.setConnection1(c1);
	  conn.setConnection2(c2);
	  OntoUMLParser.setSourceType(conn.getRelationship(), (RefOntoUML.Classifier)c1.getRelationship());
	  OntoUMLParser.setTargetType(conn.getRelationship(), (RefOntoUML.Classifier)c2.getRelationship());
	  if(c2!=null) c2.addConnection(conn);
	  if(c1!=null) c1.addConnection(conn);  
  }

}
