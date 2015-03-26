/**
 */
package net.menthor.metamodel.ontouml.impl;

import net.menthor.metamodel.ontouml.Attribute;
import net.menthor.metamodel.ontouml.ClassBinaryRelationship;
import net.menthor.metamodel.ontouml.ContainingElement;
import net.menthor.metamodel.ontouml.Element;
import net.menthor.metamodel.ontouml.EndPoint;
import net.menthor.metamodel.ontouml.GeneralizationSet;
import net.menthor.metamodel.ontouml.Model;
import net.menthor.metamodel.ontouml.NamedElement;
import net.menthor.metamodel.ontouml.OntoumlFactory;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.Primitive;
import net.menthor.metamodel.ontouml.PrimitiveType;
import net.menthor.metamodel.ontouml.Property;
import net.menthor.metamodel.ontouml.Relation;
import net.menthor.metamodel.ontouml.Universal;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OntoumlPackageImpl extends EPackageImpl implements OntoumlPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containingElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass generalizationSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classBinaryRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum universalEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum primitiveEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum relationEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OntoumlPackageImpl() {
		super(eNS_URI, OntoumlFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link OntoumlPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OntoumlPackage init() {
		if (isInited) return (OntoumlPackage)EPackage.Registry.INSTANCE.getEPackage(OntoumlPackage.eNS_URI);

		// Obtain or create and register package
		OntoumlPackageImpl theOntoumlPackage = (OntoumlPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OntoumlPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OntoumlPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theOntoumlPackage.createPackageContents();

		// Initialize created meta-data
		theOntoumlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOntoumlPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OntoumlPackage.eNS_URI, theOntoumlPackage);
		return theOntoumlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElement() {
		return elementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainer() {
		return containerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainer_Elements() {
		return (EReference)containerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainingElement() {
		return containingElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainingElement_Holder() {
		return (EReference)containingElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModel() {
		return modelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackage() {
		return packageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClass_() {
		return classEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClass_Stereotype() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClass_IsDerived() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClass_IsExtensional() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClass_EnumerationLiterals() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_InstanceOf() {
		return (EReference)classEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_IstruthMakerOf() {
		return (EReference)classEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Attributes() {
		return (EReference)classEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_IsSpecializedVia() {
		return (EReference)classEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_SpecializesVia() {
		return (EReference)classEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsRigid() {
		return classEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsNonRigid() {
		return classEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsAntiRigid() {
		return classEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveType() {
		return primitiveTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveType_Stereotype() {
		return (EAttribute)primitiveTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeneralizationSet() {
		return generalizationSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneralizationSet_IsCovering() {
		return (EAttribute)generalizationSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneralizationSet_SpecializedClass() {
		return (EReference)generalizationSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneralizationSet_SpecializingClasses() {
		return (EReference)generalizationSetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneralizationSet_Hou() {
		return (EReference)generalizationSetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_IsDerived() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_LowerBound() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_UpperBound() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_IsSpecificDependent() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttribute() {
		return attributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttribute_Owner() {
		return (EReference)attributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttribute_IsOfType() {
		return (EReference)attributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndPoint() {
		return endPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndPoint_Owner() {
		return (EReference)endPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndPoint_IsOfType() {
		return (EReference)endPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndPoint_Subsets() {
		return (EReference)endPointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndPoint_Redefines() {
		return (EReference)endPointEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndPoint_IsSubsettedBy() {
		return (EReference)endPointEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndPoint_IsRedefeinedBy() {
		return (EReference)endPointEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassBinaryRelationship() {
		return classBinaryRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassBinaryRelationship_Stereotype() {
		return (EAttribute)classBinaryRelationshipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassBinaryRelationship_EndPoints() {
		return (EReference)classBinaryRelationshipEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassBinaryRelationship_PartIsShareable() {
		return (EAttribute)classBinaryRelationshipEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassBinaryRelationship_TruthMaker() {
		return (EReference)classBinaryRelationshipEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassBinaryRelationship_IsDerived() {
		return (EAttribute)classBinaryRelationshipEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassBinaryRelationship_PartIsEssential() {
		return (EAttribute)classBinaryRelationshipEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassBinaryRelationship_PartIsInseparable() {
		return (EAttribute)classBinaryRelationshipEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassBinaryRelationship_PartIsImmutable() {
		return (EAttribute)classBinaryRelationshipEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassBinaryRelationship_WholeIsImmutable() {
		return (EAttribute)classBinaryRelationshipEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassBinaryRelationship_PartIsMandatory() {
		return (EAttribute)classBinaryRelationshipEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassBinaryRelationship_WholeIsMandatory() {
		return (EAttribute)classBinaryRelationshipEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassBinaryRelationship__SourceEnd() {
		return classBinaryRelationshipEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassBinaryRelationship__TargetEnd() {
		return classBinaryRelationshipEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassBinaryRelationship__IsMeronymic() {
		return classBinaryRelationshipEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUniversal() {
		return universalEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPrimitive() {
		return primitiveEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRelation() {
		return relationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OntoumlFactory getOntoumlFactory() {
		return (OntoumlFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		elementEClass = createEClass(ELEMENT);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		containerEClass = createEClass(CONTAINER);
		createEReference(containerEClass, CONTAINER__ELEMENTS);

		containingElementEClass = createEClass(CONTAINING_ELEMENT);
		createEReference(containingElementEClass, CONTAINING_ELEMENT__HOLDER);

		modelEClass = createEClass(MODEL);

		packageEClass = createEClass(PACKAGE);

		classEClass = createEClass(CLASS);
		createEAttribute(classEClass, CLASS__STEREOTYPE);
		createEAttribute(classEClass, CLASS__IS_DERIVED);
		createEAttribute(classEClass, CLASS__IS_EXTENSIONAL);
		createEAttribute(classEClass, CLASS__ENUMERATION_LITERALS);
		createEReference(classEClass, CLASS__INSTANCE_OF);
		createEReference(classEClass, CLASS__ISTRUTH_MAKER_OF);
		createEReference(classEClass, CLASS__ATTRIBUTES);
		createEReference(classEClass, CLASS__IS_SPECIALIZED_VIA);
		createEReference(classEClass, CLASS__SPECIALIZES_VIA);
		createEOperation(classEClass, CLASS___IS_RIGID);
		createEOperation(classEClass, CLASS___IS_NON_RIGID);
		createEOperation(classEClass, CLASS___IS_ANTI_RIGID);

		primitiveTypeEClass = createEClass(PRIMITIVE_TYPE);
		createEAttribute(primitiveTypeEClass, PRIMITIVE_TYPE__STEREOTYPE);

		generalizationSetEClass = createEClass(GENERALIZATION_SET);
		createEAttribute(generalizationSetEClass, GENERALIZATION_SET__IS_COVERING);
		createEReference(generalizationSetEClass, GENERALIZATION_SET__SPECIALIZED_CLASS);
		createEReference(generalizationSetEClass, GENERALIZATION_SET__SPECIALIZING_CLASSES);
		createEReference(generalizationSetEClass, GENERALIZATION_SET__HOU);

		propertyEClass = createEClass(PROPERTY);
		createEAttribute(propertyEClass, PROPERTY__IS_DERIVED);
		createEAttribute(propertyEClass, PROPERTY__LOWER_BOUND);
		createEAttribute(propertyEClass, PROPERTY__UPPER_BOUND);
		createEAttribute(propertyEClass, PROPERTY__IS_SPECIFIC_DEPENDENT);

		attributeEClass = createEClass(ATTRIBUTE);
		createEReference(attributeEClass, ATTRIBUTE__OWNER);
		createEReference(attributeEClass, ATTRIBUTE__IS_OF_TYPE);

		endPointEClass = createEClass(END_POINT);
		createEReference(endPointEClass, END_POINT__OWNER);
		createEReference(endPointEClass, END_POINT__IS_OF_TYPE);
		createEReference(endPointEClass, END_POINT__SUBSETS);
		createEReference(endPointEClass, END_POINT__REDEFINES);
		createEReference(endPointEClass, END_POINT__IS_SUBSETTED_BY);
		createEReference(endPointEClass, END_POINT__IS_REDEFEINED_BY);

		classBinaryRelationshipEClass = createEClass(CLASS_BINARY_RELATIONSHIP);
		createEAttribute(classBinaryRelationshipEClass, CLASS_BINARY_RELATIONSHIP__STEREOTYPE);
		createEReference(classBinaryRelationshipEClass, CLASS_BINARY_RELATIONSHIP__END_POINTS);
		createEAttribute(classBinaryRelationshipEClass, CLASS_BINARY_RELATIONSHIP__PART_IS_SHAREABLE);
		createEReference(classBinaryRelationshipEClass, CLASS_BINARY_RELATIONSHIP__TRUTH_MAKER);
		createEAttribute(classBinaryRelationshipEClass, CLASS_BINARY_RELATIONSHIP__IS_DERIVED);
		createEAttribute(classBinaryRelationshipEClass, CLASS_BINARY_RELATIONSHIP__PART_IS_ESSENTIAL);
		createEAttribute(classBinaryRelationshipEClass, CLASS_BINARY_RELATIONSHIP__PART_IS_INSEPARABLE);
		createEAttribute(classBinaryRelationshipEClass, CLASS_BINARY_RELATIONSHIP__PART_IS_IMMUTABLE);
		createEAttribute(classBinaryRelationshipEClass, CLASS_BINARY_RELATIONSHIP__WHOLE_IS_IMMUTABLE);
		createEAttribute(classBinaryRelationshipEClass, CLASS_BINARY_RELATIONSHIP__PART_IS_MANDATORY);
		createEAttribute(classBinaryRelationshipEClass, CLASS_BINARY_RELATIONSHIP__WHOLE_IS_MANDATORY);
		createEOperation(classBinaryRelationshipEClass, CLASS_BINARY_RELATIONSHIP___SOURCE_END);
		createEOperation(classBinaryRelationshipEClass, CLASS_BINARY_RELATIONSHIP___TARGET_END);
		createEOperation(classBinaryRelationshipEClass, CLASS_BINARY_RELATIONSHIP___IS_MERONYMIC);

		// Create enums
		universalEEnum = createEEnum(UNIVERSAL);
		primitiveEEnum = createEEnum(PRIMITIVE);
		relationEEnum = createEEnum(RELATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		namedElementEClass.getESuperTypes().add(this.getElement());
		containerEClass.getESuperTypes().add(this.getNamedElement());
		containingElementEClass.getESuperTypes().add(this.getElement());
		modelEClass.getESuperTypes().add(this.getContainer());
		packageEClass.getESuperTypes().add(this.getContainer());
		packageEClass.getESuperTypes().add(this.getContainingElement());
		classEClass.getESuperTypes().add(this.getNamedElement());
		classEClass.getESuperTypes().add(this.getContainingElement());
		primitiveTypeEClass.getESuperTypes().add(this.getContainingElement());
		generalizationSetEClass.getESuperTypes().add(this.getNamedElement());
		generalizationSetEClass.getESuperTypes().add(this.getContainingElement());
		propertyEClass.getESuperTypes().add(this.getNamedElement());
		attributeEClass.getESuperTypes().add(this.getProperty());
		endPointEClass.getESuperTypes().add(this.getProperty());
		classBinaryRelationshipEClass.getESuperTypes().add(this.getNamedElement());
		classBinaryRelationshipEClass.getESuperTypes().add(this.getContainingElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(elementEClass, Element.class, "Element", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), theEcorePackage.getEString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(containerEClass, net.menthor.metamodel.ontouml.Container.class, "Container", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainer_Elements(), this.getContainingElement(), this.getContainingElement_Holder(), "elements", null, 0, -1, net.menthor.metamodel.ontouml.Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(containingElementEClass, ContainingElement.class, "ContainingElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainingElement_Holder(), this.getContainer(), this.getContainer_Elements(), "holder", null, 1, 1, ContainingElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(packageEClass, net.menthor.metamodel.ontouml.Package.class, "Package", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classEClass, net.menthor.metamodel.ontouml.Class.class, "Class", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClass_Stereotype(), this.getUniversal(), "stereotype", null, 0, 1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClass_IsDerived(), theEcorePackage.getEBoolean(), "isDerived", null, 0, 1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClass_IsExtensional(), theEcorePackage.getEBoolean(), "isExtensional", null, 0, 1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClass_EnumerationLiterals(), theEcorePackage.getEString(), "enumerationLiterals", null, 0, -1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_InstanceOf(), this.getClass_(), null, "instanceOf", null, 0, -1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClass_IstruthMakerOf(), this.getClassBinaryRelationship(), this.getClassBinaryRelationship_TruthMaker(), "istruthMakerOf", null, 0, -1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClass_Attributes(), this.getAttribute(), this.getAttribute_Owner(), "attributes", null, 0, -1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClass_IsSpecializedVia(), this.getGeneralizationSet(), this.getGeneralizationSet_SpecializedClass(), "isSpecializedVia", null, 0, -1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClass_SpecializesVia(), this.getGeneralizationSet(), this.getGeneralizationSet_SpecializingClasses(), "specializesVia", null, 0, -1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEOperation(getClass__IsRigid(), theEcorePackage.getEBoolean(), "isRigid", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsNonRigid(), theEcorePackage.getEBoolean(), "isNonRigid", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsAntiRigid(), theEcorePackage.getEBoolean(), "isAntiRigid", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(primitiveTypeEClass, PrimitiveType.class, "PrimitiveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimitiveType_Stereotype(), this.getPrimitive(), "stereotype", null, 1, 1, PrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(generalizationSetEClass, GeneralizationSet.class, "GeneralizationSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGeneralizationSet_IsCovering(), theEcorePackage.getEBoolean(), "isCovering", null, 0, 1, GeneralizationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGeneralizationSet_SpecializedClass(), this.getClass_(), this.getClass_IsSpecializedVia(), "specializedClass", null, 1, 1, GeneralizationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGeneralizationSet_SpecializingClasses(), this.getClass_(), this.getClass_SpecializesVia(), "specializingClasses", null, 1, -1, GeneralizationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGeneralizationSet_Hou(), this.getClass_(), null, "hou", null, 0, 1, GeneralizationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyEClass, Property.class, "Property", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProperty_IsDerived(), theEcorePackage.getEBoolean(), "isDerived", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_LowerBound(), theEcorePackage.getEInt(), "lowerBound", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_UpperBound(), theEcorePackage.getEInt(), "upperBound", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_IsSpecificDependent(), theEcorePackage.getEBoolean(), "isSpecificDependent", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttribute_Owner(), this.getClass_(), this.getClass_Attributes(), "owner", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttribute_IsOfType(), this.getPrimitiveType(), null, "isOfType", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(endPointEClass, EndPoint.class, "EndPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEndPoint_Owner(), this.getClassBinaryRelationship(), this.getClassBinaryRelationship_EndPoints(), "owner", null, 1, 1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEndPoint_IsOfType(), this.getClass_(), null, "isOfType", null, 1, 1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEndPoint_Subsets(), this.getEndPoint(), this.getEndPoint_IsSubsettedBy(), "subsets", null, 0, -1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEndPoint_Redefines(), this.getEndPoint(), this.getEndPoint_IsRedefeinedBy(), "redefines", null, 0, -1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEndPoint_IsSubsettedBy(), this.getEndPoint(), this.getEndPoint_Subsets(), "isSubsettedBy", null, 0, -1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEndPoint_IsRedefeinedBy(), this.getEndPoint(), this.getEndPoint_Redefines(), "isRedefeinedBy", null, 0, -1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(classBinaryRelationshipEClass, ClassBinaryRelationship.class, "ClassBinaryRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClassBinaryRelationship_Stereotype(), this.getRelation(), "stereotype", null, 0, 1, ClassBinaryRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassBinaryRelationship_EndPoints(), this.getEndPoint(), this.getEndPoint_Owner(), "endPoints", null, 2, 2, ClassBinaryRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassBinaryRelationship_PartIsShareable(), theEcorePackage.getEBoolean(), "partIsShareable", null, 0, 1, ClassBinaryRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassBinaryRelationship_TruthMaker(), this.getClass_(), this.getClass_IstruthMakerOf(), "truthMaker", null, 0, 1, ClassBinaryRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassBinaryRelationship_IsDerived(), theEcorePackage.getEBoolean(), "isDerived", null, 0, 1, ClassBinaryRelationship.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassBinaryRelationship_PartIsEssential(), theEcorePackage.getEBoolean(), "partIsEssential", null, 0, 1, ClassBinaryRelationship.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassBinaryRelationship_PartIsInseparable(), theEcorePackage.getEBoolean(), "partIsInseparable", null, 0, 1, ClassBinaryRelationship.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassBinaryRelationship_PartIsImmutable(), theEcorePackage.getEBoolean(), "partIsImmutable", null, 0, 1, ClassBinaryRelationship.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassBinaryRelationship_WholeIsImmutable(), theEcorePackage.getEBoolean(), "wholeIsImmutable", null, 0, 1, ClassBinaryRelationship.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassBinaryRelationship_PartIsMandatory(), theEcorePackage.getEBoolean(), "partIsMandatory", null, 0, 1, ClassBinaryRelationship.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassBinaryRelationship_WholeIsMandatory(), theEcorePackage.getEBoolean(), "wholeIsMandatory", null, 0, 1, ClassBinaryRelationship.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getClassBinaryRelationship__SourceEnd(), this.getEndPoint(), "sourceEnd", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClassBinaryRelationship__TargetEnd(), this.getEndPoint(), "targetEnd", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClassBinaryRelationship__IsMeronymic(), theEcorePackage.getEBoolean(), "isMeronymic", 0, 1, !IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(universalEEnum, Universal.class, "Universal");
		addEEnumLiteral(universalEEnum, Universal.KIND);
		addEEnumLiteral(universalEEnum, Universal.COLLECTIVE);
		addEEnumLiteral(universalEEnum, Universal.QUANTITY);
		addEEnumLiteral(universalEEnum, Universal.RELATOR);
		addEEnumLiteral(universalEEnum, Universal.MODE);
		addEEnumLiteral(universalEEnum, Universal.QUALITY);
		addEEnumLiteral(universalEEnum, Universal.PERCEIVABLE_QUALITY);
		addEEnumLiteral(universalEEnum, Universal.NON_PERCEIVABLE_QUALITY);
		addEEnumLiteral(universalEEnum, Universal.NOMINAL_QUALITY);
		addEEnumLiteral(universalEEnum, Universal.ROLE);
		addEEnumLiteral(universalEEnum, Universal.PHASE);
		addEEnumLiteral(universalEEnum, Universal.SUB_KIND);
		addEEnumLiteral(universalEEnum, Universal.CATEGORY);
		addEEnumLiteral(universalEEnum, Universal.MIXIN);
		addEEnumLiteral(universalEEnum, Universal.ROLE_MIXIN);
		addEEnumLiteral(universalEEnum, Universal.EVENT);
		addEEnumLiteral(universalEEnum, Universal.HOU);
		addEEnumLiteral(universalEEnum, Universal.DATA_TYPE);
		addEEnumLiteral(universalEEnum, Universal.ENUMERATION);

		initEEnum(primitiveEEnum, Primitive.class, "Primitive");
		addEEnumLiteral(primitiveEEnum, Primitive.BOOLEAN);
		addEEnumLiteral(primitiveEEnum, Primitive.STRING);
		addEEnumLiteral(primitiveEEnum, Primitive.REAL);
		addEEnumLiteral(primitiveEEnum, Primitive.INTEGER);
		addEEnumLiteral(primitiveEEnum, Primitive.UNLIMITED_NATURAL);
		addEEnumLiteral(primitiveEEnum, Primitive.DATE);

		initEEnum(relationEEnum, Relation.class, "Relation");
		addEEnumLiteral(relationEEnum, Relation.COMPONENT_OF);
		addEEnumLiteral(relationEEnum, Relation.MEMBER_OF);
		addEEnumLiteral(relationEEnum, Relation.SUB_COLLECTION_OF);
		addEEnumLiteral(relationEEnum, Relation.SUB_QUANTITY_OF);
		addEEnumLiteral(relationEEnum, Relation.CHARACTERIZATION);
		addEEnumLiteral(relationEEnum, Relation.MEDIATION);
		addEEnumLiteral(relationEEnum, Relation.MATERIAL);
		addEEnumLiteral(relationEEnum, Relation.FORMAL);
		addEEnumLiteral(relationEEnum, Relation.STRUCTURATION);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";	
		addAnnotation
		  (elementEClass, 
		   source, 
		   new String[] {
			 "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot"
		   });
	}

} //OntoumlPackageImpl
