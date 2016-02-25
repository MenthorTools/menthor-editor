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
import RefOntoUML.Comment;
import RefOntoUML.Constraintx;
import RefOntoUML.IntrinsicMomentClass;
import RefOntoUML.MaterialAssociation;
import RefOntoUML.Package;
import RefOntoUML.PackageableElement;
import RefOntoUML.Property;
import RefOntoUML.Relator;
import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.util.RefOntoUMLFactoryUtil;

import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.types.DataType;
import net.menthor.editor.v2.types.RelationshipType;

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
    
    private String nextClassTypeCount(ClassType elementType){	  
  	  if (classCounters.get(elementType)!=null) {
  		  int count = classCounters.get(elementType);
  		  classCounters.put(elementType, count+1);
  		  return Integer.toString(count+1);
  	  }else{
  		  classCounters.put(elementType, 0);
  		  return "";
  	  }
    }
    
    private String nextDataTypeCount(DataType elementType){	  
  	  if (datatypeCounters.get(elementType)!=null) {
  		  int count = datatypeCounters.get(elementType);
  		  datatypeCounters.put(elementType, count+1);
  		  return Integer.toString(count+1);
  	  }else{
  		  datatypeCounters.put(elementType, 0);
  		  return "";
  	  }
    }
    
    private String nextRelationshipCount(RelationshipType RelationshipType) {	  
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

    // ------------- RefOnto --------------
    
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
    
  //------------- Node --------------
  
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
    OccurenceMap.get().add(umlnode.getClassifier(), umlnode);
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
    OccurenceMap.get().add(umlnode.getClassifier(), umlnode);
    return umlnode;
  }
  
  public UmlNode createNode(RefOntoUML.Type type, StructureDiagram container){
	  UmlNode umlnode=null;  
	  if(type instanceof RefOntoUML.Class){
		  ClassType classType = ClassType.getClassEnum((RefOntoUML.Class)type);
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
	  OccurenceMap.get().add(umlnode.getClassifier(), umlnode);
	  return umlnode;
  }
  
  public UmlNode createNode(RefOntoUML.Type type, EObject eContainer){
	  UmlNode umlnode=null;  
	  if(type instanceof RefOntoUML.Class){
		  ClassType classType = ClassType.getClassEnum((RefOntoUML.Class)type);
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
	    UmlConnection prototype = relationPrototypes.get(RelationshipType.getRelationEnum(relationship));    
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
    UmlConnection prototype = relationPrototypes.get(RelationshipType.getRelationEnum(relationship));    
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
  public UmlConnection createConnection(RelationshipType relationType, DiagramElement de1, DiagramElement de2){
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
  
  public UmlConnection createConnection(RelationshipType relationType, RefOntoUML.Relationship toBeCloned, StructureDiagram diagram){
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
  
  public LineConnectMethod getDefaultConnectMethod(RelationshipType RelationshipType){
    UmlConnection connPrototype = relationPrototypes.get(RelationshipType);
    return (connPrototype == null) ? null : connPrototype.getConnectMethod();
  }
  
  private boolean shouldInvert(UmlConnection conn, DiagramElement source, DiagramElement target){
	  RefOntoUML.Relationship relationship = conn.getRelationship();
	  Object srcElement = source.getModelObject(),
			 tgtElement = target.getModelObject();
	  
	  boolean isInvertedDerivation = relationship instanceof RefOntoUML.Derivation && srcElement instanceof MaterialAssociation && tgtElement instanceof Relator,
			  isInvertedCharacterization = relationship instanceof RefOntoUML.Characterization && !(srcElement instanceof IntrinsicMomentClass) && tgtElement instanceof IntrinsicMomentClass,
			  isInvertedMediation = relationship instanceof RefOntoUML.Mediation && !(srcElement instanceof RefOntoUML.Relator) && tgtElement instanceof RefOntoUML.Relator,
			  isInvertedStructuration = relationship instanceof RefOntoUML.Structuration && (srcElement instanceof RefOntoUML.ReferenceStructure) && srcElement instanceof RefOntoUML.Quality;
	  
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
