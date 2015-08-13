package org.tinyuml.umldraw.shared;

/**
 * Copyright 2007 Wei-ju Wu
 *
 * This file is part of TinyUML.
 *
 * TinyUML is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * TinyUML is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with TinyUML; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.draw.Connection;
import org.tinyuml.draw.LineConnectMethod;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.GeneralizationElement;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.AggregationKind;
import RefOntoUML.Association;
import RefOntoUML.Category;
import RefOntoUML.Characterization;
import RefOntoUML.Classifier;
import RefOntoUML.Collective;
import RefOntoUML.Comment;
import RefOntoUML.Constraintx;
import RefOntoUML.DecimalIntervalDimension;
import RefOntoUML.DecimalOrdinalDimension;
import RefOntoUML.DecimalRationalDimension;
import RefOntoUML.Derivation;
import RefOntoUML.Enumeration;
import RefOntoUML.FormalAssociation;
import RefOntoUML.Generalization;
import RefOntoUML.IntegerIntervalDimension;
import RefOntoUML.IntegerOrdinalDimension;
import RefOntoUML.IntegerRationalDimension;
import RefOntoUML.Kind;
import RefOntoUML.MaterialAssociation;
import RefOntoUML.Mediation;
import RefOntoUML.Meronymic;
import RefOntoUML.Mixin;
import RefOntoUML.Mode;
import RefOntoUML.NamedElement;
import RefOntoUML.NominalQuality;
import RefOntoUML.NonPerceivableQuality;
import RefOntoUML.PackageableElement;
import RefOntoUML.PerceivableQuality;
import RefOntoUML.Phase;
import RefOntoUML.PrimitiveType;
import RefOntoUML.Property;
import RefOntoUML.Quantity;
import RefOntoUML.RefOntoUMLFactory;
import RefOntoUML.Relator;
import RefOntoUML.Role;
import RefOntoUML.RoleMixin;
import RefOntoUML.StringExpression;
import RefOntoUML.Structuration;
import RefOntoUML.SubKind;
import RefOntoUML.VisibilityKind;
import RefOntoUML.componentOf;
import RefOntoUML.memberOf;
import RefOntoUML.subCollectionOf;
import RefOntoUML.subQuantityOf;
import RefOntoUML.impl.AssociationImpl;
import RefOntoUML.impl.CharacterizationImpl;
import RefOntoUML.impl.DataTypeImpl;
import RefOntoUML.impl.DerivationImpl;
import RefOntoUML.impl.DirectedBinaryAssociationImpl;
import RefOntoUML.impl.FormalAssociationImpl;
import RefOntoUML.impl.MaterialAssociationImpl;
import RefOntoUML.impl.MediationImpl;
import RefOntoUML.impl.MeronymicImpl;
import RefOntoUML.impl.StructurationImpl;
import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.util.RefOntoUMLFactoryUtil;
import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.types.DataType;
import net.menthor.editor.v2.types.RelationshipType;

/**
 * Implementation of the DiagramElementFactory interface. A
 * DiagramElementFactory instance belongs to a particular UmlDiagram instance,
 * so it can automatically associate allElements to the diagram they belong to.
 *
 * @author Wei-ju Wu, John Guerson
 */
public class DiagramElementFactoryImpl implements DiagramElementFactory {

  //private Map<ElementType, UmlDiagramElement> elementPrototypes = new HashMap<ElementType, UmlDiagramElement>();
  private Map<ClassType, UmlDiagramElement> classPrototypes = new HashMap<ClassType, UmlDiagramElement>();
  private Map<ClassType, Integer> classCounters = new HashMap<ClassType, Integer>();
  
  private Map<DataType, UmlDiagramElement> datatypesPrototypes = new HashMap<DataType, UmlDiagramElement>();
  private Map<DataType, Integer> datatypeCounters = new HashMap<DataType, Integer>();
  
  private Map<RelationshipType, UmlConnection> relationPrototypes = new HashMap<RelationshipType, UmlConnection>();  
  private Map<RelationshipType, Integer> relationCounters = new HashMap<RelationshipType, Integer>();
  
  private RefOntoUMLFactory factory;
  
  /**
   * Constructor.
   * @param aDiagram the diagram this factory belongs to
   */
  public DiagramElementFactoryImpl() {  
    setupElementMaps();
    setupConnectionMaps();
  }
   

  /**
   * Initializes the element map with the element prototypes.
   */

  private void setupElementMaps() {
	
	factory = RefOntoUMLFactoryUtil.factory;
    
    Kind kind = (RefOntoUML.Kind)createClass(ClassType.KIND);    
    ClassElement kindElement = (ClassElement) ClassElement.getPrototype().clone();
    kindElement.setClassifier(kind);
    classPrototypes.put(ClassType.KIND, kindElement);
        
    Quantity quantity = (RefOntoUML.Quantity)createClass(ClassType.QUANTITY);
    ClassElement quantityElement = (ClassElement) ClassElement.getPrototype().clone();
    quantityElement.setClassifier(quantity);
    classPrototypes.put(ClassType.QUANTITY, quantityElement);
        
    Collective collective = (RefOntoUML.Collective)createClass(ClassType.COLLECTIVE);   
    ClassElement collectiveElement = (ClassElement) ClassElement.getPrototype().clone();
    collectiveElement.setClassifier(collective);
    classPrototypes.put(ClassType.COLLECTIVE, collectiveElement);
        
    SubKind subkind = (RefOntoUML.SubKind)createClass(ClassType.SUBKIND);   
    ClassElement subkindElement = (ClassElement) ClassElement.getPrototype().clone();
    subkindElement.setClassifier(subkind);
    classPrototypes.put(ClassType.SUBKIND, subkindElement);
        
    Phase phase = (RefOntoUML.Phase)createClass(ClassType.PHASE);    
    ClassElement phaseElement = (ClassElement) ClassElement.getPrototype().clone();
    phaseElement.setClassifier(phase);
    classPrototypes.put(ClassType.PHASE, phaseElement);
        
    Role role = (RefOntoUML.Role)createClass(ClassType.ROLE);  
    ClassElement roleElement = (ClassElement) ClassElement.getPrototype().clone();
    roleElement.setClassifier(role);
    classPrototypes.put(ClassType.ROLE, roleElement);
        
    Category category = (RefOntoUML.Category)createClass(ClassType.CATEGORY);  
    ClassElement categoryElement = (ClassElement) ClassElement.getPrototype().clone();
    categoryElement.setClassifier(category);
    classPrototypes.put(ClassType.CATEGORY, categoryElement);
        
    RoleMixin rolemixin = (RefOntoUML.RoleMixin)createClass(ClassType.ROLEMIXIN);   
    ClassElement rolemixinElement = (ClassElement) ClassElement.getPrototype().clone();
    rolemixinElement.setClassifier(rolemixin);
    classPrototypes.put(ClassType.ROLEMIXIN, rolemixinElement);
        
    Mixin mixin = (RefOntoUML.Mixin)createClass(ClassType.MIXIN);   
    ClassElement mixinElement = (ClassElement) ClassElement.getPrototype().clone();
    mixinElement.setClassifier(mixin);
    classPrototypes.put(ClassType.MIXIN, mixinElement);
        
    Mode mode = (RefOntoUML.Mode)createClass(ClassType.MODE);   
    ClassElement modeElement = (ClassElement) ClassElement.getPrototype().clone();
    modeElement.setClassifier(mode);
    classPrototypes.put(ClassType.MODE, modeElement);
        
    Relator relator = (RefOntoUML.Relator)createClass(ClassType.RELATOR);   
    ClassElement relatorElement = (ClassElement) ClassElement.getPrototype().clone();
    relatorElement.setClassifier(relator);
    classPrototypes.put(ClassType.RELATOR, relatorElement);
        
    PerceivableQuality perceivableQuality = (RefOntoUML.PerceivableQuality)createClass(ClassType.PERCEIVABLEQUALITY);
    ClassElement pqualityElement = (ClassElement) ClassElement.getPrototype().clone();
    pqualityElement.setClassifier(perceivableQuality);    
    classPrototypes.put(ClassType.PERCEIVABLEQUALITY, pqualityElement);
    
    NonPerceivableQuality nonperceivableQuality = (RefOntoUML.NonPerceivableQuality)createClass(ClassType.NONPERCEIVABLEQUALITY);
    ClassElement npqualityElement = (ClassElement) ClassElement.getPrototype().clone();
    npqualityElement.setClassifier(nonperceivableQuality);    
    classPrototypes.put(ClassType.NONPERCEIVABLEQUALITY, npqualityElement);
    
    NominalQuality nominalQuality = (RefOntoUML.NominalQuality)createClass(ClassType.NOMINALQUALITY);
    ClassElement nqElement = (ClassElement) ClassElement.getPrototype().clone();
    nqElement.setClassifier(nominalQuality);    
    classPrototypes.put(ClassType.NOMINALQUALITY, nqElement);
    
    RefOntoUML.DataType datatype = (RefOntoUML.DataType)createDataType(DataType.DATATYPE);
    ClassElement datatypeElement = (ClassElement) ClassElement.getPrototype().clone();
    datatypeElement.setClassifier(datatype);
    datatypeElement.setShowAttributes(true);
    datatypesPrototypes.put(DataType.DATATYPE, datatypeElement);
    
    RefOntoUML.StringNominalStructure nominal = (RefOntoUML.StringNominalStructure)createDataType(DataType.STRINGNOMINALSTRUCTURE);
    ClassElement nominalElement = (ClassElement) ClassElement.getPrototype().clone();
    nominalElement.setClassifier(nominal);
    datatypesPrototypes.put(DataType.STRINGNOMINALSTRUCTURE, nominalElement);
    
    RefOntoUML.MeasurementDomain domain = (RefOntoUML.MeasurementDomain)createDataType(DataType.MEASUREMENTDOMAIN);
    ClassElement domainElement = (ClassElement) ClassElement.getPrototype().clone();
    domainElement.setClassifier(domain);
    datatypesPrototypes.put(DataType.MEASUREMENTDOMAIN, domainElement);
    
    IntegerIntervalDimension iid = (IntegerIntervalDimension)createDataType(DataType.INTEGERINTERVALDIMENSION);
    ClassElement iidElement = (ClassElement) ClassElement.getPrototype().clone();
    iidElement.setClassifier(iid);
    datatypesPrototypes.put(DataType.INTEGERINTERVALDIMENSION, iidElement);
    
    IntegerRationalDimension ird = (IntegerRationalDimension)createDataType(DataType.INTEGERRATIONALDIMENSION);
    ClassElement irdElement = (ClassElement) ClassElement.getPrototype().clone();
    irdElement.setClassifier(ird);
    datatypesPrototypes.put(DataType.INTEGERRATIONALDIMENSION, irdElement);
    
    IntegerOrdinalDimension iod = (IntegerOrdinalDimension)createDataType(DataType.INTEGERORDINALDIMENSION);
    ClassElement iodElement = (ClassElement) ClassElement.getPrototype().clone();
    iodElement.setClassifier(iod);
    datatypesPrototypes.put(DataType.INTEGERORDINALDIMENSION, iodElement);
        
    DecimalIntervalDimension did = (DecimalIntervalDimension)createDataType(DataType.DECIMALINTERVALDIMENSION);
    ClassElement didElement = (ClassElement) ClassElement.getPrototype().clone();
    didElement.setClassifier(did);
    datatypesPrototypes.put(DataType.DECIMALINTERVALDIMENSION, didElement);    
    
    DecimalRationalDimension drd = (DecimalRationalDimension)createDataType(DataType.DECIMALRATIONALDIMENSION);
    ClassElement drdElement = (ClassElement) ClassElement.getPrototype().clone();
    drdElement.setClassifier(drd);
    datatypesPrototypes.put(DataType.DECIMALRATIONALDIMENSION, drdElement);
    
    DecimalOrdinalDimension dod = (DecimalOrdinalDimension)createDataType(DataType.DECIMALORDINALDIMENSION);
    ClassElement dodElement = (ClassElement) ClassElement.getPrototype().clone();
    dodElement.setClassifier(dod);
    datatypesPrototypes.put(DataType.DECIMALORDINALDIMENSION, dodElement);    
    
    Enumeration enumeration = (RefOntoUML.Enumeration)createDataType(DataType.ENUMERATION);
    ClassElement enumElement = (ClassElement) ClassElement.getPrototype().clone();
    enumElement.setClassifier(enumeration);
    enumElement.setShowAttributes(true);
    datatypesPrototypes.put(DataType.ENUMERATION, enumElement);    
    
    PrimitiveType primitive = (RefOntoUML.PrimitiveType)createDataType(DataType.PRIMITIVETYPE);
    ClassElement primitiveElement = (ClassElement) ClassElement.getPrototype().clone();
    primitiveElement.setClassifier(primitive);    
    datatypesPrototypes.put(DataType.PRIMITIVETYPE, primitiveElement);
  }

  public void createPropertiesByDefault(Association association)
  {
		Property node1Property, node2Property;	
		
		node1Property = RefOntoUMLFactoryUtil.createProperty(null, 1, 1);	    		
		//If the association is a ComponentOf, set the default cardinality to 2..*, to help in validation
		if(association instanceof MeronymicImpl) node2Property = RefOntoUMLFactoryUtil.createProperty(null, 2, -1);
		else node2Property = RefOntoUMLFactoryUtil.createProperty(null, 1, 1);
		
		if(association instanceof MeronymicImpl)
		{
			if(((Meronymic)association).isIsShareable()) node1Property.setAggregation(AggregationKind.SHARED);	    			
			else node1Property.setAggregation(AggregationKind.COMPOSITE);	    				
		}
		
		String node1Name  = new String();		
		if(node1Property.getType()!=null)
		{ 
			node1Name = node1Property.getType().getName();	    		
			if(node1Name==null || node1Name.trim().isEmpty()) node1Name = "source";
			else node1Name = node1Name.trim().toLowerCase();
		}
		String node2Name  = new String();
		if(node2Property.getType()!=null)
		{ 
			node2Name = node2Property.getType().getName();	    		
			if(node2Name==null || node2Name.trim().isEmpty()) node2Name = "target";
			else node2Name = node2Name.trim().toLowerCase();
		}
		
		node1Property.setName(node1Name);
		node2Property.setName(node2Name);
		
		association.getOwnedEnd().add(node1Property);
		association.getOwnedEnd().add(node2Property);	    		
		association.getMemberEnd().add(node1Property);
		association.getMemberEnd().add(node2Property);
		
		if(association instanceof DirectedBinaryAssociationImpl || association instanceof FormalAssociationImpl || association instanceof MaterialAssociationImpl)
		{
			association.getNavigableOwnedEnd().add(node1Property);
			association.getNavigableOwnedEnd().add(node2Property);	    			
			//If the association is Mediation or Characterization, set target readonly to help in validation
			if(association instanceof MediationImpl || association instanceof CharacterizationImpl || 
			   association instanceof DerivationImpl || association instanceof StructurationImpl) 
			node2Property.setIsReadOnly(true);
		}
		else
		{
			if(node1Property.getType() instanceof DataTypeImpl) association.getNavigableOwnedEnd().add(node1Property);	    		
			if(node2Property.getType() instanceof DataTypeImpl) association.getNavigableOwnedEnd().add(node2Property);
		}		
  }
	
  /**
   * Initializes the map with the connection prototypes.
   */
  private void setupConnectionMaps() {

	factory = RefOntoUMLFactory.eINSTANCE;
		
    Generalization generalization = (RefOntoUML.Generalization)createRelationship(RelationshipType.GENERALIZATION);    
    GeneralizationElement generalizationElement = (GeneralizationElement) GeneralizationElement.getPrototype().clone();
    generalizationElement.setRelationship(generalization);
    relationPrototypes.put(RelationshipType.GENERALIZATION, generalizationElement);
        
    Characterization characterization = (RefOntoUML.Characterization)createRelationship(RelationshipType.CHARACTERIZATION);   
    AssociationElement characterizationElement = (AssociationElement) AssociationElement.getPrototype().clone();
    characterizationElement.setRelationship(characterization);
    characterizationElement.setAssociationType(RelationshipType.CHARACTERIZATION);
    characterizationElement.setShowOntoUmlStereotype(true);
    relationPrototypes.put(RelationshipType.CHARACTERIZATION, characterizationElement);
    createPropertiesByDefault(characterization);
    
    FormalAssociation formalAssociation = (RefOntoUML.FormalAssociation)createRelationship(RelationshipType.FORMAL);
    AssociationElement formalAssociationElement = (AssociationElement) AssociationElement.getPrototype().clone();
    formalAssociationElement.setRelationship(formalAssociation);
    formalAssociationElement.setAssociationType(RelationshipType.FORMAL);
    formalAssociationElement.setShowOntoUmlStereotype(true);
    relationPrototypes.put(RelationshipType.FORMAL, formalAssociationElement);
    createPropertiesByDefault(formalAssociation);
          
    MaterialAssociation materialAssociation = (RefOntoUML.MaterialAssociation)createRelationship(RelationshipType.MATERIAL);    
    AssociationElement materialAssociationElement = (AssociationElement) AssociationElement.getPrototype().clone();
    materialAssociationElement.setRelationship(materialAssociation);
    materialAssociationElement.setAssociationType(RelationshipType.MATERIAL);
    materialAssociationElement.setShowOntoUmlStereotype(true);
    relationPrototypes.put(RelationshipType.MATERIAL, materialAssociationElement);
    createPropertiesByDefault(materialAssociation);
    
    Mediation mediation = (RefOntoUML.Mediation)createRelationship(RelationshipType.MEDIATION);   
    AssociationElement mediationElement = (AssociationElement) AssociationElement.getPrototype().clone();
    mediationElement.setRelationship(mediation);
    mediationElement.setAssociationType(RelationshipType.MEDIATION);
    mediationElement.setShowOntoUmlStereotype(true);
    relationPrototypes.put(RelationshipType.MEDIATION, mediationElement);
    createPropertiesByDefault(mediation);
        
    memberOf memberof = (RefOntoUML.memberOf)createRelationship(RelationshipType.MEMBEROF);   
    AssociationElement memberofElement = (AssociationElement) AssociationElement.getPrototype().clone();
    memberofElement.setAssociationType(RelationshipType.MEMBEROF);
    memberofElement.setRelationship(memberof);
    relationPrototypes.put(RelationshipType.MEMBEROF, memberofElement);
    createPropertiesByDefault(memberof);
    
    subQuantityOf subquantityof = (RefOntoUML.subQuantityOf)createRelationship(RelationshipType.SUBQUANTITYOF);    
    AssociationElement subquantityofElement = (AssociationElement) AssociationElement.getPrototype().clone();
    subquantityofElement.setAssociationType(RelationshipType.SUBQUANTITYOF);
    subquantityofElement.setRelationship(subquantityof);
    relationPrototypes.put(RelationshipType.SUBQUANTITYOF, subquantityofElement);
    createPropertiesByDefault(subquantityof);    
    
    subCollectionOf subcollectionof = (RefOntoUML.subCollectionOf)createRelationship(RelationshipType.SUBCOLLECTIONOF);    
    AssociationElement subcollectionofElement = (AssociationElement) AssociationElement.getPrototype().clone();
    subcollectionofElement.setAssociationType(RelationshipType.SUBCOLLECTIONOF);
    subcollectionofElement.setRelationship(subcollectionof);
    relationPrototypes.put(RelationshipType.SUBCOLLECTIONOF, subcollectionofElement);
    createPropertiesByDefault(subcollectionof);     
    
    componentOf componentof = (RefOntoUML.componentOf)createRelationship(RelationshipType.COMPONENTOF);    
    AssociationElement componentofElement = (AssociationElement) AssociationElement.getPrototype().clone();
    componentofElement.setAssociationType(RelationshipType.COMPONENTOF);
    componentofElement.setRelationship(componentof);
    relationPrototypes.put(RelationshipType.COMPONENTOF, componentofElement);
    createPropertiesByDefault(componentof); 
    
    Derivation derivation = (RefOntoUML.Derivation)createRelationship(RelationshipType.DERIVATION); 
    AssociationElement derivationeElement = (AssociationElement) AssociationElement.getPrototype().clone();
    derivationeElement.setAssociationType(RelationshipType.DERIVATION);
    derivationeElement.setRelationship(derivation);
    derivationeElement.setIsDashed(true);
    derivationeElement.setShowOntoUmlStereotype(false);
    relationPrototypes.put(RelationshipType.DERIVATION, derivationeElement);
    createPropertiesByDefault(derivation); 

    Structuration structuration = (RefOntoUML.Structuration)createRelationship(RelationshipType.STRUCTURATION);
    AssociationElement structurationElement = (AssociationElement) AssociationElement.getPrototype().clone();
    structurationElement.setRelationship(structuration);
    structurationElement.setShowOntoUmlStereotype(true);
    structurationElement.setAssociationType(RelationshipType.STRUCTURATION);
    relationPrototypes.put(RelationshipType.STRUCTURATION, structurationElement);     
    createPropertiesByDefault(structuration); 
    
    Association datatyperelationship = (RefOntoUML.Association)createRelationship(RelationshipType.ASSOCIATION);
    AssociationElement datatyperelationshipElement = (AssociationElement) AssociationElement.getPrototype().clone();
    datatyperelationshipElement.setRelationship(datatyperelationship);
    datatyperelationshipElement.setAssociationType(RelationshipType.ASSOCIATION);
    relationPrototypes.put(RelationshipType.ASSOCIATION, datatyperelationshipElement);     
    createPropertiesByDefault(datatyperelationship);
  }
  
  /**
   * Create only the RefOntoUML Type element and do not create the referred UmlNode on the Diagram.
   */
  public RefOntoUML.Element createClass(ClassType elementType)
  {
	  RefOntoUML.Element type = null;
	  if (elementType.equals(ClassType.KIND)) type = factory.createKind();
	  if (elementType.equals(ClassType.COLLECTIVE)) type = factory.createCollective();
	  if (elementType.equals(ClassType.QUANTITY)) type = factory.createQuantity();
	  if (elementType.equals(ClassType.SUBKIND)) type = factory.createSubKind();
	  if (elementType.equals(ClassType.PHASE)) type = factory.createPhase();
	  if (elementType.equals(ClassType.ROLE)) type = factory.createRole();
	  if (elementType.equals(ClassType.CATEGORY)) { type = factory.createCategory(); ((Classifier)type).setIsAbstract(true); }	  
	  if (elementType.equals(ClassType.ROLEMIXIN)) { type = factory.createRoleMixin(); ((Classifier)type).setIsAbstract(true); }
	  if (elementType.equals(ClassType.MIXIN)) { type = factory.createMixin(); ((Classifier)type).setIsAbstract(true); }
	  if (elementType.equals(ClassType.MODE)) { type = factory.createMode();}
	  if (elementType.equals(ClassType.RELATOR)) { type = factory.createRelator();  }
	  if (elementType.equals(ClassType.PERCEIVABLEQUALITY)) { type = factory.createPerceivableQuality();  }
	  if (elementType.equals(ClassType.NONPERCEIVABLEQUALITY)) { type = factory.createNonPerceivableQuality();  }
	  if (elementType.equals(ClassType.NOMINALQUALITY)) { type = factory.createNominalQuality();  }
	  if(type instanceof NamedElement){
		  ((NamedElement)type).setName(OntoUMLParser.getStereotype(type)+nextElementCount(elementType)); 
		  ((NamedElement)type).setVisibility(VisibilityKind.PUBLIC);
	  }		 
	  return type;	  
  }
  
  public RefOntoUML.Element createDataType(DataType elementType)
  {
	  RefOntoUML.Element type = null;
	  if (elementType.equals(DataType.DATATYPE)) { type = factory.createDataType();  }	  
	  if (elementType.equals(DataType.ENUMERATION)) { type = factory.createEnumeration();  }
	  if (elementType.equals(DataType.PRIMITIVETYPE)) { type = factory.createPrimitiveType();  }	  
	  if (elementType.equals(DataType.STRINGNOMINALSTRUCTURE)) { type = factory.createStringNominalStructure();  }
	  if (elementType.equals(DataType.INTEGERINTERVALDIMENSION)) { type = factory.createIntegerIntervalDimension(); }
	  if (elementType.equals(DataType.INTEGERORDINALDIMENSION)) { type = factory.createIntegerOrdinalDimension(); }
	  if (elementType.equals(DataType.INTEGERRATIONALDIMENSION)) { type = factory.createIntegerRationalDimension(); }
	  if (elementType.equals(DataType.DECIMALINTERVALDIMENSION)) { type = factory.createDecimalIntervalDimension(); }
	  if (elementType.equals(DataType.DECIMALORDINALDIMENSION)) { type = factory.createDecimalOrdinalDimension(); }
	  if (elementType.equals(DataType.DECIMALRATIONALDIMENSION)) { type = factory.createDecimalRationalDimension(); }
	  if (elementType.equals(DataType.MEASUREMENTDOMAIN)) { type = factory.createMeasurementDomain(); }
	  if(type instanceof NamedElement){
		  ((NamedElement)type).setName(OntoUMLParser.getStereotype(type)+nextElementCount(elementType)); 
		  ((NamedElement)type).setVisibility(VisibilityKind.PUBLIC);
	  }		 
	  return type;	  
  }
   
  public RefOntoUML.Element createPackage()
  {
	  RefOntoUML.Element type = factory.createPackage();
	  if(type instanceof NamedElement){
		  ((NamedElement)type).setName(OntoUMLParser.getStereotype(type)); 
		  ((NamedElement)type).setVisibility(VisibilityKind.PUBLIC);
	  }		 
	  return type;	  
  }
  
  public RefOntoUML.Element createGeneralizationSet()
  {
	  RefOntoUML.Element type = factory.createGeneralizationSet();
	  if(type instanceof NamedElement){
		  ((NamedElement)type).setName(OntoUMLParser.getStereotype(type)); 
		  ((NamedElement)type).setVisibility(VisibilityKind.PUBLIC);
	  }		 
	  return type;	  
  }
  
  public Comment createComment()
  {
	  Comment c = factory.createComment();
	  c.setBody("");
	  return c;
  }
  
  public Constraintx createConstraintx()
  {
	  Constraintx c = factory.createConstraintx();
	  c.setName("");
	  StringExpression expr = RefOntoUMLFactoryUtil.factory.createStringExpression();
	  expr.setSymbol("");
	  c.setSpecification(expr);
	  return c;
  }
  
  /**
   * Create an Element with the given stereotype that contains all the features of the given Type. 
   */
  public RefOntoUML.PackageableElement createClass(ClassType elementType, RefOntoUML.Type type)
  {
	  RefOntoUML.PackageableElement newType = (PackageableElement)createClass(elementType);
	  newType.setVisibility(type.getVisibility());
	  newType.setName(type.getName());
	  ((Classifier)newType).setIsAbstract(((Classifier)type).isIsAbstract());
	  return newType;
  }

  public RefOntoUML.PackageableElement createDataType(DataType elementType, RefOntoUML.Type type)
  {
	  RefOntoUML.PackageableElement newType = (PackageableElement)createDataType(elementType);
	  newType.setVisibility(type.getVisibility());
	  newType.setName(type.getName());
	  ((Classifier)newType).setIsAbstract(((Classifier)type).isIsAbstract());
	  return newType;
  }
  
  /**
   * Create only the RefOntoUML Relationship element and do not create the referred UmlConnection on the Diagram.
   */
  @SuppressWarnings("static-access")
public RefOntoUML.Relationship createRelationship(RelationshipType RelationshipType)
  {
	  RefOntoUML.Relationship rel = null;
	  if (RelationshipType.equals(RelationshipType.GENERALIZATION)) rel = factory.createGeneralization();
	  if (RelationshipType.equals(RelationshipType.CHARACTERIZATION)) rel = factory.createCharacterization();
	  if (RelationshipType.equals(RelationshipType.FORMAL)) rel = factory.createFormalAssociation();
	  if (RelationshipType.equals(RelationshipType.MATERIAL)) { rel = factory.createMaterialAssociation(); ((MaterialAssociation)rel).setIsDerived(true); }
	  if (RelationshipType.equals(RelationshipType.MEDIATION)) rel = factory.createMediation();
	  if (RelationshipType.equals(RelationshipType.MEMBEROF)) { rel = factory.creatememberOf(); ((memberOf)rel).setIsShareable(true); }
	  if (RelationshipType.equals(RelationshipType.SUBQUANTITYOF)) { rel = factory.createsubQuantityOf(); ((subQuantityOf)rel).setIsShareable(false); } 
	  if (RelationshipType.equals(RelationshipType.SUBCOLLECTIONOF)) { rel = factory.createsubCollectionOf(); ((subCollectionOf)rel).setIsShareable(true); } 
	  if (RelationshipType.equals(RelationshipType.COMPONENTOF)) { rel = factory.createcomponentOf(); ((componentOf)rel).setIsShareable(true); }
	  if (RelationshipType.equals(RelationshipType.DERIVATION)) rel = factory.createDerivation();
	  if (RelationshipType.equals(RelationshipType.ASSOCIATION)) rel = factory.createAssociation();	  
	  if (RelationshipType.equals(RelationshipType.STRUCTURATION)) rel = factory.createStructuration();
	  if (rel instanceof Classifier){
		  ((Classifier)rel).setName(OntoUMLParser.getStereotype(rel)+nextRelationCount(RelationshipType));		  
		  ((Classifier)rel).setVisibility(VisibilityKind.PUBLIC);
	  }
	  return rel;			  
  }
  
  public RefOntoUMLFactory getFactory(){
	  return factory;
  }
  
  /**
   * {@inheritDoc} This method also create the referred RefOntoUML Type of the UmlNode. 
   */
  public UmlNode createNode(ClassType classType, StructureDiagram diagram) 
  {
    UmlNode umlnode = (UmlNode) classPrototypes.get(classType).clone();    
    if(umlnode.getClassifier() != null) umlnode.getClassifier().setName(umlnode.getClassifier().getName() + nextElementCount(classType));
    umlnode.addNodeChangeListener(diagram);    
    return umlnode;
  }
  public UmlNode createNode(DataType dataType, StructureDiagram diagram) 
  {
    UmlNode umlnode = (UmlNode) datatypesPrototypes.get(dataType).clone();    
    if(umlnode.getClassifier() != null) umlnode.getClassifier().setName(umlnode.getClassifier().getName() + nextElementCount(dataType));
    umlnode.addNodeChangeListener(diagram);    
    return umlnode;
  }
  
  public UmlNode createNode(RefOntoUML.Type type, EObject eContainer, StructureDiagram diagram) 
  {
	  UmlNode umlnode=null;  
	  if(type instanceof RefOntoUML.Class){
		  umlnode = (UmlNode) classPrototypes.get(ClassType.valueOf(type.eClass().getName().toUpperCase())).clone();
	  }else{ 
		  umlnode = (UmlNode) datatypesPrototypes.get(DataType.valueOf(type.eClass().getName().toUpperCase())).clone();
	  }
	  ((ClassElement)umlnode).setClassifier((RefOntoUML.Classifier)type);        
	  umlnode.addNodeChangeListener(diagram);    
	  return umlnode;
  }
  
  public String nextElementCount(ClassType elementType)
  {	  
	  if (classCounters.get(elementType)!=null) {
		  int count = classCounters.get(elementType);
		  classCounters.put(elementType, count+1);
		  return Integer.toString(count+1);
	  }else{
		  classCounters.put(elementType, 0);
		  return "";
	  }
  }
  
  public String nextElementCount(DataType elementType)
  {	  
	  if (datatypeCounters.get(elementType)!=null) {
		  int count = datatypeCounters.get(elementType);
		  datatypeCounters.put(elementType, count+1);
		  return Integer.toString(count+1);
	  }else{
		  datatypeCounters.put(elementType, 0);
		  return "";
	  }
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
    	  association.setName(association.getName() + nextRelationCount(RelationshipType));
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
    }
    return conn;
  }
  
  /**
   * {@inheritDoc} This method also create the referred RefOntoUML Relationship of the UmlConnection. 
   */
  @Override
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
	    	  association.setName(association.getName() + nextRelationCount(relationType));
	      }
      }	    
      return conn;
  }

  /**
   * Create a UmlConnection from a relationship 
   */
  @Override
  public UmlConnection createConnectionFromCon(RefOntoUML.Relationship relationship, UmlConnection c1, UmlNode node2) 
  {
	  UmlConnection prototype = relationPrototypes.get(RelationshipType.valueOf(OntoUMLParser.getStereotype(relationship).toUpperCase()));	  
      UmlConnection conn = null;
      if (prototype != null) 
      {
	      conn = (UmlConnection) prototype.clone();
	      conn.setRelationship(relationship);
	      bindConnection(conn, c1, node2);
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
    	  association.setName(association.getName() + nextRelationCount(RelationshipType));    	 
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
    	  association.setName(association.getName() + nextRelationCount(RelationshipType));    	  
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
    }    
    return conn;
  }
  
  public String nextRelationCount(RelationshipType RelationshipType)
  {	  
	  if (relationCounters.get(RelationshipType)!=null) {
		  int count = relationCounters.get(RelationshipType);
		  relationCounters.put(RelationshipType, count+1);
		  return Integer.toString(count+1);
	  }else{
		  relationCounters.put(RelationshipType, 0);
		  return "";
	  }	  
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
