package net.menthor.editor.ui;

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
import org.tinyuml.draw.Connection;
import org.tinyuml.draw.LineConnectMethod;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.GeneralizationElement;
import org.tinyuml.umldraw.StructureDiagram;
import org.tinyuml.umldraw.shared.BaseConnection;
import org.tinyuml.umldraw.shared.UmlConnection;
import org.tinyuml.umldraw.shared.UmlDiagramElement;
import org.tinyuml.umldraw.shared.UmlNode;

import RefOntoUML.Association;
import RefOntoUML.Comment;
import RefOntoUML.Constraintx;
import RefOntoUML.Package;
import RefOntoUML.PackageableElement;
import RefOntoUML.impl.AssociationImpl;
import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.util.RefOntoUMLFactoryUtil;
import net.menthor.editor.v2.managers.BaseManager;
import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.types.DataType;
import net.menthor.editor.v2.types.RelationshipType;

public class FactoryManager extends BaseManager {

	// -------- Lazy Initialization
	
	private static class FactoryLoader {
        private static final FactoryManager INSTANCE = new FactoryManager();
    }	
	public static FactoryManager get() { 
		return FactoryLoader.INSTANCE; 
	}	
    private FactoryManager() {
    	createPrototypes();
        if (FactoryLoader.INSTANCE != null) throw new IllegalStateException("FactoryManager already instantiated");
    }		
    
    // ----------------------------
        
    private Map<ClassType, UmlDiagramElement> classPrototypes = new HashMap<ClassType, UmlDiagramElement>();  
    private Map<DataType, UmlDiagramElement> datatypesPrototypes = new HashMap<DataType, UmlDiagramElement>();
    private Map<RelationshipType, UmlConnection> relationPrototypes = new HashMap<RelationshipType, UmlConnection>();
    
    private Map<ClassType, Integer> classCounters = new HashMap<ClassType, Integer>();
    private Map<DataType, Integer> datatypeCounters = new HashMap<DataType, Integer>();
    private Map<RelationshipType, Integer> relationCounters = new HashMap<RelationshipType, Integer>();
    
    private void createClassPrototype(ClassType classType){
    	 RefOntoUML.Class class_ = (RefOntoUML.Class)createClass(classType);    
    	 ClassElement classElement = (ClassElement) ClassElement.getPrototype().clone();
    	 classElement.setClassifier(class_);
    	 classPrototypes.put(classType, classElement);
    }
    
    private void createDataTypePrototype(DataType dataType){
    	RefOntoUML.DataType datatype_ = (RefOntoUML.DataType)createDataType(dataType);    
   	 	ClassElement datatypeElement = (ClassElement) ClassElement.getPrototype().clone();
   	 	datatypeElement.setClassifier(datatype_);   	 
   	 	datatypesPrototypes.put(dataType, datatypeElement);
    }
    
    private void createGeneralizationPrototype(RelationshipType relType){
    	RefOntoUML.Relationship generalization = (RefOntoUML.Relationship)createRelationship(relType);    
	    BaseConnection generalizationElement = (BaseConnection) GeneralizationElement.getPrototype().clone();
	    generalizationElement.setRelationship(generalization);
	    relationPrototypes.put(relType, generalizationElement);
    }
    
    public String nextClassTypeCount(ClassType elementType){	  
  	  if (classCounters.get(elementType)!=null) {
  		  int count = classCounters.get(elementType);
  		  classCounters.put(elementType, count+1);
  		  return Integer.toString(count+1);
  	  }else{
  		  classCounters.put(elementType, 0);
  		  return "";
  	  }
    }
    
    public String nextDataTypeCount(DataType elementType){	  
  	  if (datatypeCounters.get(elementType)!=null) {
  		  int count = datatypeCounters.get(elementType);
  		  datatypeCounters.put(elementType, count+1);
  		  return Integer.toString(count+1);
  	  }else{
  		  datatypeCounters.put(elementType, 0);
  		  return "";
  	  }
    }
    
    public String nextRelationshipCount(RelationshipType RelationshipType) {	  
  	  if (relationCounters.get(RelationshipType)!=null) {
  		  int count = relationCounters.get(RelationshipType);
  		  relationCounters.put(RelationshipType, count+1);
  		  return Integer.toString(count+1);
  	  }else{
  		  relationCounters.put(RelationshipType, 0);
  		  return "";
  	  }	  
    }
    
    private void createAssociationPrototype(RelationshipType relType){
    	RefOntoUML.Relationship assoc = (RefOntoUML.Relationship)createRelationship(relType);   
        AssociationElement assocElement = (AssociationElement) AssociationElement.getPrototype().clone();
        assocElement.setRelationship(assoc);
        assocElement.setAssociationType(relType);
        assocElement.setShowOntoUmlStereotype(true);
        if(relType==RelationshipType.DERIVATION) assocElement.setIsDashed(true);
        if(relType==RelationshipType.DERIVATION) assocElement.setShowOntoUmlStereotype(false);
        if(relType==RelationshipType.MEMBEROF) assocElement.setShowOntoUmlStereotype(false);
        if(relType==RelationshipType.SUBCOLLECTIONOF) assocElement.setShowOntoUmlStereotype(false);
        if(relType==RelationshipType.SUBQUANTITYOF) assocElement.setShowOntoUmlStereotype(false);
        if(relType==RelationshipType.COMPONENTOF) assocElement.setShowOntoUmlStereotype(false);
        if(relType==RelationshipType.ASSOCIATION) assocElement.setShowOntoUmlStereotype(false);
        relationPrototypes.put(relType, assocElement);        
    }
    
    private void createPrototypes() {	
    	//factory = RefOntoUMLFactoryUtil.factory;    
    	//factory = RefOntoUMLFactory.eINSTANCE;
    	createClassPrototype(ClassType.KIND);
    	createClassPrototype(ClassType.QUANTITY);
    	createClassPrototype(ClassType.COLLECTIVE);
    	createClassPrototype(ClassType.SUBKIND);
    	createClassPrototype(ClassType.PHASE);
    	createClassPrototype(ClassType.ROLE);
    	createClassPrototype(ClassType.CATEGORY);
    	createClassPrototype(ClassType.ROLEMIXIN);
    	createClassPrototype(ClassType.MIXIN);
    	createClassPrototype(ClassType.MODE);
    	createClassPrototype(ClassType.RELATOR);
    	createClassPrototype(ClassType.PERCEIVABLE_QUALITY);
    	createClassPrototype(ClassType.NONPERCEIVABLE_QUALITY);
    	createClassPrototype(ClassType.NOMINAL_QUALITY);
    	createDataTypePrototype(DataType.DATATYPE);
    	createDataTypePrototype(DataType.STRINGNOMINAL_STRUCTURE);
    	createDataTypePrototype(DataType.MEASUREMENT_DOMAIN);
    	createDataTypePrototype(DataType.INTEGERINTERVAL_DIMENSION);    	
    	createDataTypePrototype(DataType.INTEGERRATIONAL_DIMENSION);
    	createDataTypePrototype(DataType.INTEGERORDINAL_DIMENSION);
    	createDataTypePrototype(DataType.DECIMALINTERVAL_DIMENSION);
    	createDataTypePrototype(DataType.DECIMALRATIONAL_DIMENSION);
    	createDataTypePrototype(DataType.DECIMALORDINAL_DIMENSION);
    	createDataTypePrototype(DataType.ENUMERATION);
    	createDataTypePrototype(DataType.PRIMITIVETYPE);
    	createGeneralizationPrototype(RelationshipType.GENERALIZATION);
    	createAssociationPrototype(RelationshipType.CHARACTERIZATION);
    	createAssociationPrototype(RelationshipType.FORMAL);
    	createAssociationPrototype(RelationshipType.MATERIAL);
    	createAssociationPrototype(RelationshipType.MEDIATION);
    	createAssociationPrototype(RelationshipType.MEMBEROF);
    	createAssociationPrototype(RelationshipType.SUBQUANTITYOF);
    	createAssociationPrototype(RelationshipType.SUBCOLLECTIONOF);
    	createAssociationPrototype(RelationshipType.COMPONENTOF);
    	createAssociationPrototype(RelationshipType.DERIVATION);
    	createAssociationPrototype(RelationshipType.STRUCTURATION);
    	createAssociationPrototype(RelationshipType.ASSOCIATION);
    }

    public RefOntoUML.Element createClass(ClassType elementType){
	  RefOntoUML.Element type = null;
	  String name = elementType.getName()+nextClassTypeCount(elementType);
	  if (elementType.equals(ClassType.KIND)) type = RefOntoUMLFactoryUtil.createKind(name, null);
	  if (elementType.equals(ClassType.COLLECTIVE)) type = RefOntoUMLFactoryUtil.createCollective(name, null);
	  if (elementType.equals(ClassType.QUANTITY)) type = RefOntoUMLFactoryUtil.createQuantity(name, null);
	  if (elementType.equals(ClassType.SUBKIND)) type = RefOntoUMLFactoryUtil.createSubKind(name, null);
	  if (elementType.equals(ClassType.PHASE)) type = RefOntoUMLFactoryUtil.createPhase(name, null);
	  if (elementType.equals(ClassType.ROLE)) type = RefOntoUMLFactoryUtil.createRole(name, null);
	  if (elementType.equals(ClassType.CATEGORY)) type = RefOntoUMLFactoryUtil.createCategory(name, null); 	  
	  if (elementType.equals(ClassType.ROLEMIXIN)) type = RefOntoUMLFactoryUtil.createRoleMixin(name, null); 
	  if (elementType.equals(ClassType.MIXIN)) type = RefOntoUMLFactoryUtil.createMixin(name, null); 
	  if (elementType.equals(ClassType.MODE)) type = RefOntoUMLFactoryUtil.createMode(name, null); 
	  if (elementType.equals(ClassType.RELATOR)) type = RefOntoUMLFactoryUtil.createRelator(name, null); 
	  if (elementType.equals(ClassType.PERCEIVABLE_QUALITY)) type = RefOntoUMLFactoryUtil.createPerceivableQuality(name, null); 
	  if (elementType.equals(ClassType.NONPERCEIVABLE_QUALITY)) type = RefOntoUMLFactoryUtil.createNonPerceivableQuality(name, null); 
	  if (elementType.equals(ClassType.NOMINAL_QUALITY)) type = RefOntoUMLFactoryUtil.createNominalQuality(name, null); 
	  return type;	  
  }
  
  public RefOntoUML.Element createDataType(DataType elementType) {
	  RefOntoUML.Element type = null;
	  String name = elementType.getName()+nextDataTypeCount(elementType);
	  if (elementType.equals(DataType.DATATYPE)) { type = RefOntoUMLFactoryUtil.createDataType(name, null);  }	  
	  if (elementType.equals(DataType.ENUMERATION)) { type = RefOntoUMLFactoryUtil.createEnumeration(name, new ArrayList<String>(), null); }
	  if (elementType.equals(DataType.PRIMITIVETYPE)) { type = RefOntoUMLFactoryUtil.createPrimitiveType(name, null);  }	  
	  if (elementType.equals(DataType.STRINGNOMINAL_STRUCTURE)) { type = RefOntoUMLFactoryUtil.createStringNominalStructure(name, null);  }
	  if (elementType.equals(DataType.INTEGERINTERVAL_DIMENSION)) { type = RefOntoUMLFactoryUtil.createIntegerIntervalDimension(name, null); }
	  if (elementType.equals(DataType.INTEGERORDINAL_DIMENSION)) { type = RefOntoUMLFactoryUtil.createIntegerOrdinalDimension(name, null); }
	  if (elementType.equals(DataType.INTEGERRATIONAL_DIMENSION)) { type = RefOntoUMLFactoryUtil.createIntegerRationalDimension(name, null); }
	  if (elementType.equals(DataType.DECIMALINTERVAL_DIMENSION)) { type = RefOntoUMLFactoryUtil.createDecimalIntervalDimension(name, null); }
	  if (elementType.equals(DataType.DECIMALORDINAL_DIMENSION)) { type = RefOntoUMLFactoryUtil.createDecimalOrdinalDimension(name, null); }
	  if (elementType.equals(DataType.DECIMALRATIONAL_DIMENSION)) { type = RefOntoUMLFactoryUtil.createDecimalRationalDimension(name, null); }
	  if (elementType.equals(DataType.MEASUREMENT_DOMAIN)) { type = RefOntoUMLFactoryUtil.createMeasurementDomain(name, null); }
	  return type;	  
  }
  
  public RefOntoUML.Relationship createRelationship(RelationshipType relType){
	  RefOntoUML.Relationship rel = null;
	  String name = relType.getName()+nextRelationshipCount(relType);
	  if (relType.equals(RelationshipType.GENERALIZATION)) rel = RefOntoUMLFactoryUtil.createGeneralization(null, null);
	  if (relType.equals(RelationshipType.CHARACTERIZATION)) rel = RefOntoUMLFactoryUtil.createCharacterization(name, null);
	  if (relType.equals(RelationshipType.FORMAL)) rel = RefOntoUMLFactoryUtil.createFormalAssociation(name, null);
	  if (relType.equals(RelationshipType.MATERIAL)) rel = RefOntoUMLFactoryUtil.createMaterialAssociation(name, null);
	  if (relType.equals(RelationshipType.MEDIATION)) rel = RefOntoUMLFactoryUtil.createMediation(name, null);
	  if (relType.equals(RelationshipType.MEMBEROF)) rel = RefOntoUMLFactoryUtil.createMemberOf(name, null); 
	  if (relType.equals(RelationshipType.SUBQUANTITYOF)) rel = RefOntoUMLFactoryUtil.createSubQuantityOf(name, null);
	  if (relType.equals(RelationshipType.SUBCOLLECTIONOF)) rel = RefOntoUMLFactoryUtil.createSubCollectionOf(name, null); 
	  if (relType.equals(RelationshipType.COMPONENTOF)) rel = RefOntoUMLFactoryUtil.createComponentOf(name, null); 
	  if (relType.equals(RelationshipType.DERIVATION)) rel = RefOntoUMLFactoryUtil.createDerivation(name, null);
	  if (relType.equals(RelationshipType.ASSOCIATION)) rel = RefOntoUMLFactoryUtil.createAssociation(name, null);	  
	  if (relType.equals(RelationshipType.STRUCTURATION)) rel = RefOntoUMLFactoryUtil.createStructuration(name, null);
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
  
  public RefOntoUML.Classifier cloneClass(ClassType classType, RefOntoUML.Type type){
	  RefOntoUML.PackageableElement newType = (PackageableElement)createClass(classType);
	  return RefOntoUMLFactoryUtil.clone((RefOntoUML.Classifier)newType, (RefOntoUML.Classifier)type);
  }
  
  public RefOntoUML.Classifier cloneDataType(RefOntoUML.DataType type){
	 return RefOntoUMLFactoryUtil.clone(type);
  }
  
  public RefOntoUML.Classifier cloneDataType(DataType classType, RefOntoUML.Type type){
	  RefOntoUML.PackageableElement newType = (PackageableElement)createDataType(classType);
	  return RefOntoUMLFactoryUtil.clone((RefOntoUML.Classifier)newType, (RefOntoUML.Classifier)type);
  }
  
  public RefOntoUML.Relationship cloneRelationship(RefOntoUML.Relationship type){
	 return RefOntoUMLFactoryUtil.cloneRelationship(type);
  }
  
  public RefOntoUML.Relationship cloneRelationship(RelationshipType relType, RefOntoUML.Relationship type){
	  RefOntoUML.Relationship newType = (RefOntoUML.Relationship)createRelationship(relType);
	  return RefOntoUMLFactoryUtil.cloneRelationship(newType, type);
  }
    
  public UmlNode createNode(ClassType classType, StructureDiagram container) {
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
    OccurenceManager.get().add(umlnode.getClassifier(), umlnode);
    return umlnode;
  }
  
  public UmlNode createNode(DataType dataType, StructureDiagram container){
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
    OccurenceManager.get().add(umlnode.getClassifier(), umlnode);
    return umlnode;
  }
  
  public UmlNode createNode(RefOntoUML.Type type, StructureDiagram container){
	  UmlNode umlnode=null;  
	  if(type instanceof RefOntoUML.Class){
		  ClassType classType = ClassType.getClassType((RefOntoUML.Class)type);
		  umlnode = (UmlNode) classPrototypes.get(classType).clone();
	  }else{ 
		  DataType dataType = DataType.getDataType((RefOntoUML.DataType)type);
		  umlnode = (UmlNode) datatypesPrototypes.get(dataType).clone();
	  }
	  ((ClassElement)umlnode).setClassifier((RefOntoUML.Classifier)type);	   
	  if(container!=null && container.getContainer()!=null && container.getContainer() instanceof RefOntoUML.Package){
		  RefOntoUML.Package pack = ((RefOntoUML.Package)container.getContainer());
		  pack.getPackagedElement().add((RefOntoUML.PackageableElement)umlnode.getClassifier());			 
	  }
	  //umlnode.addNodeChangeListener(diagram); (unnecessary I suspect)
	  OccurenceManager.get().add(umlnode.getClassifier(), umlnode);
	  return umlnode;
  }
  
  public UmlNode createNode(RefOntoUML.Type type, EObject eContainer){
	  UmlNode umlnode=null;  
	  if(type instanceof RefOntoUML.Class){
		  ClassType classType = ClassType.getClassType((RefOntoUML.Class)type);
		  umlnode = (UmlNode) classPrototypes.get(classType).clone();
	  }else{ 
		  DataType dataType = DataType.getDataType((RefOntoUML.DataType)type);
		  umlnode = (UmlNode) datatypesPrototypes.get(dataType).clone();
	  }
	  ((ClassElement)umlnode).setClassifier((RefOntoUML.Classifier)type);	   
	  if(eContainer!=null){
		  RefOntoUML.Package pack = (RefOntoUML.Package)eContainer;
		  pack.getPackagedElement().add((RefOntoUML.PackageableElement)umlnode.getClassifier());			 
	  }
	  OccurenceManager.get().add(umlnode.getClassifier(), umlnode);
	  return umlnode;
  }
  
  public UmlNode cloneNode(UmlNode node){
	  UmlNode ce = (UmlNode)node.clone();	        
	  //ce.addNodeChangeListener((StructureDiagram)node.getDiagram());
	  OccurenceManager.get().add(ce.getClassifier(), ce);
	  return ce;
  }
  
  /**
   * {@inheritDoc}  This method also create the referred RefOntoUML Relationship of the UmlConnection. 
   */
  public UmlConnection createConnection(RelationshipType RelationshipType, UmlNode node1, UmlNode node2) 
  {
    UmlConnection prototype = relationPrototypes.get(RelationshipType);    
    UmlConnection conn = null;
    if (prototype != null) 
    {
      conn = (UmlConnection) prototype.clone();
      bindConnection(conn, node1, node2);
      if(conn.getRelationship() != null && conn.getRelationship() instanceof AssociationImpl)
      {
    	  Association association = (Association) conn.getRelationship();
    	  association.setName(association.getName() + nextRelationshipCount(RelationshipType));
    	  if(node1.getDiagram().getContainer()!=null){
	      	if(node1.getDiagram().getContainer() instanceof RefOntoUML.Package)
	      		((RefOntoUML.Package)node1.getDiagram().getContainer()).getPackagedElement().add((RefOntoUML.PackageableElement)conn.getRelationship());
	      }
      }      
    }    
    return conn;
  }
  
  /**
   * Create a UmlConnection from a relationship 
   */
  public UmlConnection createConnection(RefOntoUML.Relationship relationship, UmlNode node1, UmlNode node2) 
  {	
    UmlConnection prototype = relationPrototypes.get(RelationshipType.valueOf(OntoUMLParser.getStereotype(relationship).toUpperCase()));    
    UmlConnection conn = null;
    if (prototype != null) 
    {
		conn = (UmlConnection) prototype.clone();
		conn.setRelationship(relationship);
		bindConnection(conn, node1, node2);
		if(node1.getDiagram().getContainer()!=null && conn.getRelationship() instanceof AssociationImpl){
	      	if(node1.getDiagram().getContainer() instanceof RefOntoUML.Package)
	      		((RefOntoUML.Package)node1.getDiagram().getContainer()).getPackagedElement().add((RefOntoUML.PackageableElement)conn.getRelationship());
	      }
    }
    return conn;
  }
  
  /**
   * {@inheritDoc} This method also create the referred RefOntoUML Relationship of the UmlConnection. 
   */
  public UmlConnection createConnectionFromCon(RelationshipType relationType, UmlConnection c1, UmlNode node2) 
  {
	  UmlConnection prototype = relationPrototypes.get(relationType);	  
      UmlConnection conn = null;
      if (prototype != null) 
      {
	      conn = (UmlConnection) prototype.clone();
	      bindConnection(conn, c1, node2);
	      if(conn.getRelationship() != null && conn.getRelationship() instanceof AssociationImpl)
	      {
	    	  Association association = (Association) conn.getRelationship();
	    	  association.setName(association.getName() + nextRelationshipCount(relationType));
	    	  if(c1.getDiagram().getContainer()!=null){
		        	if(c1.getDiagram().getContainer() instanceof RefOntoUML.Package)
		        		((RefOntoUML.Package)c1.getDiagram().getContainer()).getPackagedElement().add((RefOntoUML.PackageableElement)conn.getRelationship());
		        }
	      }	      
      }	    
      return conn;
  }

  /**
   * Create a UmlConnection from a relationship 
   */
  public UmlConnection createConnectionFromCon(RefOntoUML.Relationship relationship, UmlConnection c1, UmlNode node2) 
  {
	  UmlConnection prototype = relationPrototypes.get(RelationshipType.valueOf(OntoUMLParser.getStereotype(relationship).toUpperCase()));	  
      UmlConnection conn = null;
      if (prototype != null) 
      {
	      conn = (UmlConnection) prototype.clone();
	      conn.setRelationship(relationship);
	      bindConnection(conn, c1, node2);
	      if(c1.getDiagram().getContainer()!=null && conn.getRelationship() instanceof AssociationImpl){
	        	if(c1.getDiagram().getContainer() instanceof RefOntoUML.Package)
	        		((RefOntoUML.Package)c1.getDiagram().getContainer()).getPackagedElement().add((RefOntoUML.PackageableElement)conn.getRelationship());
	        }
      }
      return conn;
  }
  
  /**
   * {@inheritDoc} This method also create the referred RefOntoUML Relationship of the UmlConnection. 
   */
  public UmlConnection createConnectionToCon(RelationshipType RelationshipType, UmlNode node1, UmlConnection c2) 
  {
    UmlConnection prototype = relationPrototypes.get(RelationshipType);    
    UmlConnection conn = null;
    if (prototype != null) 
    {
      conn = (UmlConnection) prototype.clone();
      bindConnection(conn, node1, c2);
      if(conn.getRelationship() != null && conn.getRelationship() instanceof AssociationImpl)
      {
    	  Association association = (Association) conn.getRelationship();
    	  association.setName(association.getName() + nextRelationshipCount(RelationshipType));
    	  if(node1.getDiagram().getContainer()!=null){
    	      	if(node1.getDiagram().getContainer() instanceof RefOntoUML.Package){
    	      		Package container = (RefOntoUML.Package)node1.getDiagram().getContainer();
    	      		EList<PackageableElement> packagedElement = container.getPackagedElement();
    	      		PackageableElement relationship = (RefOntoUML.PackageableElement)conn.getRelationship();
    	      		packagedElement.add(relationship);
    	      		System.out.println();
    	      	}
    	      }
      }      
    }    
    return conn;
  }

  /**
   *  Create a UmlConnection from a relationship
   */
  public UmlConnection createConnectionToCon(RefOntoUML.Relationship relationship, UmlNode node1, UmlConnection c2) 
  {
    UmlConnection prototype = relationPrototypes.get(RelationshipType.valueOf(OntoUMLParser.getStereotype(relationship).toUpperCase()));    
    UmlConnection conn = null;
    if (prototype != null) 
    {
      conn = (UmlConnection) prototype.clone();
      conn.setRelationship(relationship);
      bindConnection(conn, node1, c2);
      if(node1.getDiagram().getContainer()!=null  && conn.getRelationship() instanceof AssociationImpl){
        	if(node1.getDiagram().getContainer() instanceof RefOntoUML.Package)
        		((RefOntoUML.Package)node1.getDiagram().getContainer()).getPackagedElement().add((RefOntoUML.PackageableElement)conn.getRelationship());
        }
    }    
    return conn;
  }
  
  /**
   * {@inheritDoc} This method also create the referred RefOntoUML Relationship of the UmlConnection. 
   */
  public UmlConnection createConnectionBetweenCon(RelationshipType RelationshipType, UmlConnection c1, UmlConnection c2) 
  {
    UmlConnection prototype = relationPrototypes.get(RelationshipType);    
    UmlConnection conn = null;
    if (prototype != null) 
    {
      conn = (UmlConnection) prototype.clone();
      bindConnection(conn, c1, c2);
      if(conn.getRelationship() != null && conn.getRelationship() instanceof AssociationImpl)
      {
    	  Association association = (Association) conn.getRelationship();
    	  association.setName(association.getName() + nextRelationshipCount(RelationshipType));
    	  if(c1.getDiagram().getContainer()!=null){
          	if(c1.getDiagram().getContainer() instanceof RefOntoUML.Package)
          		((RefOntoUML.Package)c1.getDiagram().getContainer()).getPackagedElement().add((RefOntoUML.PackageableElement)conn.getRelationship());
          }
      }      
    }    
    return conn;
  }

  /**
   *  Create a UmlConnection from a RefOntoUML Relationship
   */
  public UmlConnection createConnectionBetweenCon(RefOntoUML.Relationship relationship, UmlConnection c1, UmlConnection c2) 
  {
    UmlConnection prototype = relationPrototypes.get(RelationshipType.valueOf(OntoUMLParser.getStereotype(relationship).toUpperCase()));    
    UmlConnection conn = null;
    if (prototype != null) 
    {
      conn = (UmlConnection) prototype.clone();
      conn.setRelationship(relationship);
      bindConnection(conn, c1, c2);
      if(c1.getDiagram().getContainer()!=null && conn.getRelationship() instanceof AssociationImpl){
      	if(c1.getDiagram().getContainer() instanceof RefOntoUML.Package)
      		((RefOntoUML.Package)c1.getDiagram().getContainer()).getPackagedElement().add((RefOntoUML.PackageableElement)conn.getRelationship());
      }
    }    
    return conn;
  }
  
  /**
   * {@inheritDoc}
   */
  public LineConnectMethod getConnectMethod(RelationshipType RelationshipType)
  {
    UmlConnection conn = relationPrototypes.get(RelationshipType);
    return (conn == null) ? null : conn.getConnectMethod();
  }

  /**
   * Binds the UmlConnection to the nodes.
   * @param conn the Connection
   * @param node1 the Node 1
   * @param node2 the Node 2
   */
  public void bindConnection(UmlConnection conn, UmlNode node1, UmlNode node2) {
    conn.setNode1(node1);
    conn.setNode2(node2);
    if(node1!=null) node1.addConnection(conn);
    if(node2!=null) node2.addConnection(conn);
  }
  
  public void bindConnection(UmlConnection conn, UmlNode node1, Connection c2) {
	  conn.setNode1(node1);
	  conn.setConnection2(c2);
	  if(node1!=null) node1.addConnection(conn);
	  if(c2!=null) c2.addConnection(conn);  
  }
  
  public void bindConnection(UmlConnection conn, UmlConnection c1, UmlNode node2) {
	  conn.setNode2(node2);
	  conn.setConnection1(c1);
	  if(node2!=null) node2.addConnection(conn);
	  if(c1!=null) c1.addConnection(conn);  
  }
  
  public void bindConnection(UmlConnection conn, UmlConnection c1, UmlConnection c2) {
	  conn.setConnection2(c2);
	  conn.setConnection1(c1);
	  if(c2!=null) c2.addConnection(conn);
	  if(c1!=null) c1.addConnection(conn);  
  }

}
