/**
 */
package net.menthor.metamodel.ontouml.impl;

import net.menthor.metamodel.ontouml.Attribute;
import net.menthor.metamodel.ontouml.Classifier;
import net.menthor.metamodel.ontouml.Comment;
import net.menthor.metamodel.ontouml.ContainedElement;
import net.menthor.metamodel.ontouml.Dimension;
import net.menthor.metamodel.ontouml.Domain;
import net.menthor.metamodel.ontouml.Element;
import net.menthor.metamodel.ontouml.EndPoint;
import net.menthor.metamodel.ontouml.GeneralizationSet;
import net.menthor.metamodel.ontouml.Literal;
import net.menthor.metamodel.ontouml.Model;
import net.menthor.metamodel.ontouml.NamedElement;
import net.menthor.metamodel.ontouml.OntoumlFactory;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.Primitive;
import net.menthor.metamodel.ontouml.Property;
import net.menthor.metamodel.ontouml.Quality;
import net.menthor.metamodel.ontouml.Region;
import net.menthor.metamodel.ontouml.Relation;
import net.menthor.metamodel.ontouml.Relationship;
import net.menthor.metamodel.ontouml.Scale;
import net.menthor.metamodel.ontouml.Structure;
import net.menthor.metamodel.ontouml.Temporal;
import net.menthor.metamodel.ontouml.Type;
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
	private EClass modelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containedElementEClass = null;

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
	private EClass commentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierEClass = null;

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
	private EClass typeEClass = null;

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
	private EClass literalEClass = null;

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
	private EClass structureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass regionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dimensionEClass = null;

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
	private EClass endPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationshipEClass = null;

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
	private EEnum qualityEEnum = null;

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
	private EEnum scaleEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum relationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum temporalEEnum = null;

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
	public EOperation getContainer__Packages() {
		return containerEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainer__AllPackages__Container_EList() {
		return containerEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainer__AllPackages() {
		return containerEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainer__Relationships() {
		return containerEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainer__AllRelationships__Container_EList() {
		return containerEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainer__AllRelationships() {
		return containerEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainer__GeneralizationSets() {
		return containerEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainer__AllGeneralizationSets__Container_EList() {
		return containerEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainer__AllGeneralizationSets() {
		return containerEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainer__Classes() {
		return containerEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainer__AllClasses__Container_EList() {
		return containerEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainer__AllClasses() {
		return containerEClass.getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainer__Structures() {
		return containerEClass.getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainer__AllStructures__Container_EList() {
		return containerEClass.getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainer__AllStructures() {
		return containerEClass.getEOperations().get(14);
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
	public EClass getContainedElement() {
		return containedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainedElement_Holder() {
		return (EReference)containedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainedElement_Comments() {
		return (EReference)containedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainedElement__GetModel__Container() {
		return containedElementEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainedElement__GetModel() {
		return containedElementEClass.getEOperations().get(1);
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
	public EClass getComment() {
		return commentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComment_Content() {
		return (EAttribute)commentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComment_Owner() {
		return (EReference)commentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifier() {
		return classifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifier_IsSpecializedVia() {
		return (EReference)classifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifier_SpecializesVia() {
		return (EReference)classifierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifier__Children() {
		return classifierEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifier__Parents() {
		return classifierEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifier__AllParents__Classifier_EList() {
		return classifierEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifier__AllParents() {
		return classifierEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifier__AllChildren__Classifier_EList() {
		return classifierEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifier__AllChildren() {
		return classifierEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifier__Siblings() {
		return classifierEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifier__Ends() {
		return classifierEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClassifier__AllEnds() {
		return classifierEClass.getEOperations().get(8);
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
	public EReference getGeneralizationSet_SpecializedClassifier() {
		return (EReference)generalizationSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneralizationSet_SpecializingClassifier() {
		return (EReference)generalizationSetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneralizationSet_HighOrder() {
		return (EReference)generalizationSetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getType() {
		return typeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getType__RelatedTypes() {
		return typeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getType__AllRelatedTypes() {
		return typeEClass.getEOperations().get(1);
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
	public EAttribute getClass_IsAbstract() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClass_IsDerived() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Attributes() {
		return (EReference)classEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClass_QualityType() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Literals() {
		return (EReference)classEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_GroundingStructure() {
		return (EReference)classEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_InstanceOf() {
		return (EReference)classEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_IstruthMakerOf() {
		return (EReference)classEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClass_IsExtensional() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsKind() {
		return classEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsSubKind() {
		return classEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsCollective() {
		return classEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsQuantity() {
		return classEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsRelator() {
		return classEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsMode() {
		return classEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsQuality() {
		return classEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsRole() {
		return classEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsRoleMixin() {
		return classEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsPhaseMixin() {
		return classEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsPhase() {
		return classEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsCategory() {
		return classEClass.getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsMixin() {
		return classEClass.getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsEvent() {
		return classEClass.getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsHighOrder() {
		return classEClass.getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsDataType() {
		return classEClass.getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsEnumeration() {
		return classEClass.getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsRigid() {
		return classEClass.getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsNonRigid() {
		return classEClass.getEOperations().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsAntiRigid() {
		return classEClass.getEOperations().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsSemiRigid() {
		return classEClass.getEOperations().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsMoment() {
		return classEClass.getEOperations().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsIdentityProvider() {
		return classEClass.getEOperations().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsTruthMaker() {
		return classEClass.getEOperations().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsMixinClass() {
		return classEClass.getEOperations().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IdentityProvidersAtAllParents() {
		return classEClass.getEOperations().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IdentityProvidersAtAllChildren() {
		return classEClass.getEOperations().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IdentityProviders() {
		return classEClass.getEOperations().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsAmountOfMatter() {
		return classEClass.getEOperations().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsFunctionalComplex() {
		return classEClass.getEOperations().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsCollection() {
		return classEClass.getEOperations().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsIntrinsic() {
		return classEClass.getEOperations().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLiteral() {
		return literalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLiteral_Owner() {
		return (EReference)literalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLiteral_GroundingRegion() {
		return (EReference)literalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLiteral_Value() {
		return (EAttribute)literalEClass.getEStructuralFeatures().get(2);
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
	public EAttribute getAttribute_Primitive() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructure() {
		return structureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructure_Regions() {
		return (EReference)structureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructure_GroundedEnumeration() {
		return (EReference)structureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRegion() {
		return regionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegion_OwnerStructure() {
		return (EReference)regionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegion_GroundedLiteral() {
		return (EReference)regionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRegion_ComposedBy() {
		return (EReference)regionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRegion_BasicType() {
		return (EAttribute)regionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRegion__IsBasic() {
		return regionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRegion__IsComposed() {
		return regionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRegion__IsNominal() {
		return regionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomain() {
		return domainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomain_Dimensions() {
		return (EReference)domainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDimension() {
		return dimensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDimension_OwnerDomain() {
		return (EReference)dimensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDimension_LowerBound() {
		return (EReference)dimensionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDimension_UpperBound() {
		return (EReference)dimensionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDimension_UnitOfMeasure() {
		return (EAttribute)dimensionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDimension_Scale() {
		return (EAttribute)dimensionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDimension_Measure() {
		return (EAttribute)dimensionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDimension__IsNominal() {
		return dimensionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDimension__IsInterval() {
		return dimensionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDimension__IsOrdinal() {
		return dimensionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDimension__IsRational() {
		return dimensionEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDimension__IsString() {
		return dimensionEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDimension__IsInteger() {
		return dimensionEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDimension__IsDecimal() {
		return dimensionEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDimension__IsNominalString() {
		return dimensionEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDimension__IsIntervalInteger() {
		return dimensionEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDimension__IsIntervalDecimal() {
		return dimensionEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDimension__IsOrdinalInteger() {
		return dimensionEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDimension__IsOrdinalDecimal() {
		return dimensionEClass.getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDimension__IsRationalInteger() {
		return dimensionEClass.getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDimension__IsRationalDecimal() {
		return dimensionEClass.getEOperations().get(13);
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
	public EAttribute getProperty_IsOrdered() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_IsDerived() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_LowerBound() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_UpperBound() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_IsDependency() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(4);
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
	public EReference getEndPoint_EndType() {
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
	public EReference getEndPoint_IsRedefinedBy() {
		return (EReference)endPointEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationship() {
		return relationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationship_Stereotype() {
		return (EAttribute)relationshipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationship_AllenRelation() {
		return (EAttribute)relationshipEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationship_EndPoints() {
		return (EReference)relationshipEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationship_DerivedFromTruthMaker() {
		return (EReference)relationshipEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsComponentOf() {
		return relationshipEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsMemberOf() {
		return relationshipEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsSubCollectionOf() {
		return relationshipEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsSubQuantityOf() {
		return relationshipEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsConstitution() {
		return relationshipEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsCharacterization() {
		return relationshipEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsMediation() {
		return relationshipEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsMaterial() {
		return relationshipEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsFormal() {
		return relationshipEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsStructuration() {
		return relationshipEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsParticipation() {
		return relationshipEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsSubEventOf() {
		return relationshipEClass.getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsCausation() {
		return relationshipEClass.getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsTemporal() {
		return relationshipEClass.getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsDerivation() {
		return relationshipEClass.getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsStarts() {
		return relationshipEClass.getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsPrecedes() {
		return relationshipEClass.getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsEquals() {
		return relationshipEClass.getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsMeets() {
		return relationshipEClass.getEOperations().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsFinishes() {
		return relationshipEClass.getEOperations().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsOverlaps() {
		return relationshipEClass.getEOperations().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsDuring() {
		return relationshipEClass.getEOperations().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsMeronymic() {
		return relationshipEClass.getEOperations().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsBinary() {
		return relationshipEClass.getEOperations().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsTernary() {
		return relationshipEClass.getEOperations().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__SourceEnd() {
		return relationshipEClass.getEOperations().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__TargetEnd() {
		return relationshipEClass.getEOperations().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__Source() {
		return relationshipEClass.getEOperations().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__Target() {
		return relationshipEClass.getEOperations().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__SourceClass() {
		return relationshipEClass.getEOperations().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__TargetClass() {
		return relationshipEClass.getEOperations().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__SourceRelationship() {
		return relationshipEClass.getEOperations().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__TargetRelationship() {
		return relationshipEClass.getEOperations().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsDerived() {
		return relationshipEClass.getEOperations().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsEnd__Classifier() {
		return relationshipEClass.getEOperations().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsPartEssential() {
		return relationshipEClass.getEOperations().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsPartInseparable() {
		return relationshipEClass.getEOperations().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsPartImmutable() {
		return relationshipEClass.getEOperations().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsWholeImmutable() {
		return relationshipEClass.getEOperations().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsPartMandatory() {
		return relationshipEClass.getEOperations().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsWholeMandatory() {
		return relationshipEClass.getEOperations().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsShareable() {
		return relationshipEClass.getEOperations().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__Material() {
		return relationshipEClass.getEOperations().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__Relator() {
		return relationshipEClass.getEOperations().get(43);
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
	public EEnum getQuality() {
		return qualityEEnum;
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
	public EEnum getScale() {
		return scaleEEnum;
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
	public EEnum getTemporal() {
		return temporalEEnum;
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
		createEOperation(containerEClass, CONTAINER___PACKAGES);
		createEOperation(containerEClass, CONTAINER___ALL_PACKAGES__CONTAINER_ELIST);
		createEOperation(containerEClass, CONTAINER___ALL_PACKAGES);
		createEOperation(containerEClass, CONTAINER___RELATIONSHIPS);
		createEOperation(containerEClass, CONTAINER___ALL_RELATIONSHIPS__CONTAINER_ELIST);
		createEOperation(containerEClass, CONTAINER___ALL_RELATIONSHIPS);
		createEOperation(containerEClass, CONTAINER___GENERALIZATION_SETS);
		createEOperation(containerEClass, CONTAINER___ALL_GENERALIZATION_SETS__CONTAINER_ELIST);
		createEOperation(containerEClass, CONTAINER___ALL_GENERALIZATION_SETS);
		createEOperation(containerEClass, CONTAINER___CLASSES);
		createEOperation(containerEClass, CONTAINER___ALL_CLASSES__CONTAINER_ELIST);
		createEOperation(containerEClass, CONTAINER___ALL_CLASSES);
		createEOperation(containerEClass, CONTAINER___STRUCTURES);
		createEOperation(containerEClass, CONTAINER___ALL_STRUCTURES__CONTAINER_ELIST);
		createEOperation(containerEClass, CONTAINER___ALL_STRUCTURES);

		modelEClass = createEClass(MODEL);

		containedElementEClass = createEClass(CONTAINED_ELEMENT);
		createEReference(containedElementEClass, CONTAINED_ELEMENT__HOLDER);
		createEReference(containedElementEClass, CONTAINED_ELEMENT__COMMENTS);
		createEOperation(containedElementEClass, CONTAINED_ELEMENT___GET_MODEL__CONTAINER);
		createEOperation(containedElementEClass, CONTAINED_ELEMENT___GET_MODEL);

		packageEClass = createEClass(PACKAGE);

		commentEClass = createEClass(COMMENT);
		createEAttribute(commentEClass, COMMENT__CONTENT);
		createEReference(commentEClass, COMMENT__OWNER);

		classifierEClass = createEClass(CLASSIFIER);
		createEReference(classifierEClass, CLASSIFIER__IS_SPECIALIZED_VIA);
		createEReference(classifierEClass, CLASSIFIER__SPECIALIZES_VIA);
		createEOperation(classifierEClass, CLASSIFIER___CHILDREN);
		createEOperation(classifierEClass, CLASSIFIER___PARENTS);
		createEOperation(classifierEClass, CLASSIFIER___ALL_PARENTS__CLASSIFIER_ELIST);
		createEOperation(classifierEClass, CLASSIFIER___ALL_PARENTS);
		createEOperation(classifierEClass, CLASSIFIER___ALL_CHILDREN__CLASSIFIER_ELIST);
		createEOperation(classifierEClass, CLASSIFIER___ALL_CHILDREN);
		createEOperation(classifierEClass, CLASSIFIER___SIBLINGS);
		createEOperation(classifierEClass, CLASSIFIER___ENDS);
		createEOperation(classifierEClass, CLASSIFIER___ALL_ENDS);

		generalizationSetEClass = createEClass(GENERALIZATION_SET);
		createEAttribute(generalizationSetEClass, GENERALIZATION_SET__IS_COVERING);
		createEReference(generalizationSetEClass, GENERALIZATION_SET__SPECIALIZED_CLASSIFIER);
		createEReference(generalizationSetEClass, GENERALIZATION_SET__SPECIALIZING_CLASSIFIER);
		createEReference(generalizationSetEClass, GENERALIZATION_SET__HIGH_ORDER);

		typeEClass = createEClass(TYPE);
		createEOperation(typeEClass, TYPE___RELATED_TYPES);
		createEOperation(typeEClass, TYPE___ALL_RELATED_TYPES);

		classEClass = createEClass(CLASS);
		createEAttribute(classEClass, CLASS__STEREOTYPE);
		createEAttribute(classEClass, CLASS__IS_ABSTRACT);
		createEAttribute(classEClass, CLASS__IS_DERIVED);
		createEReference(classEClass, CLASS__ATTRIBUTES);
		createEAttribute(classEClass, CLASS__QUALITY_TYPE);
		createEReference(classEClass, CLASS__LITERALS);
		createEReference(classEClass, CLASS__GROUNDING_STRUCTURE);
		createEReference(classEClass, CLASS__INSTANCE_OF);
		createEReference(classEClass, CLASS__ISTRUTH_MAKER_OF);
		createEAttribute(classEClass, CLASS__IS_EXTENSIONAL);
		createEOperation(classEClass, CLASS___IS_KIND);
		createEOperation(classEClass, CLASS___IS_SUB_KIND);
		createEOperation(classEClass, CLASS___IS_COLLECTIVE);
		createEOperation(classEClass, CLASS___IS_QUANTITY);
		createEOperation(classEClass, CLASS___IS_RELATOR);
		createEOperation(classEClass, CLASS___IS_MODE);
		createEOperation(classEClass, CLASS___IS_QUALITY);
		createEOperation(classEClass, CLASS___IS_ROLE);
		createEOperation(classEClass, CLASS___IS_ROLE_MIXIN);
		createEOperation(classEClass, CLASS___IS_PHASE_MIXIN);
		createEOperation(classEClass, CLASS___IS_PHASE);
		createEOperation(classEClass, CLASS___IS_CATEGORY);
		createEOperation(classEClass, CLASS___IS_MIXIN);
		createEOperation(classEClass, CLASS___IS_EVENT);
		createEOperation(classEClass, CLASS___IS_HIGH_ORDER);
		createEOperation(classEClass, CLASS___IS_DATA_TYPE);
		createEOperation(classEClass, CLASS___IS_ENUMERATION);
		createEOperation(classEClass, CLASS___IS_RIGID);
		createEOperation(classEClass, CLASS___IS_NON_RIGID);
		createEOperation(classEClass, CLASS___IS_ANTI_RIGID);
		createEOperation(classEClass, CLASS___IS_SEMI_RIGID);
		createEOperation(classEClass, CLASS___IS_MOMENT);
		createEOperation(classEClass, CLASS___IS_IDENTITY_PROVIDER);
		createEOperation(classEClass, CLASS___IS_TRUTH_MAKER);
		createEOperation(classEClass, CLASS___IS_MIXIN_CLASS);
		createEOperation(classEClass, CLASS___IDENTITY_PROVIDERS_AT_ALL_PARENTS);
		createEOperation(classEClass, CLASS___IDENTITY_PROVIDERS_AT_ALL_CHILDREN);
		createEOperation(classEClass, CLASS___IDENTITY_PROVIDERS);
		createEOperation(classEClass, CLASS___IS_AMOUNT_OF_MATTER);
		createEOperation(classEClass, CLASS___IS_FUNCTIONAL_COMPLEX);
		createEOperation(classEClass, CLASS___IS_COLLECTION);
		createEOperation(classEClass, CLASS___IS_INTRINSIC);

		literalEClass = createEClass(LITERAL);
		createEReference(literalEClass, LITERAL__OWNER);
		createEReference(literalEClass, LITERAL__GROUNDING_REGION);
		createEAttribute(literalEClass, LITERAL__VALUE);

		attributeEClass = createEClass(ATTRIBUTE);
		createEReference(attributeEClass, ATTRIBUTE__OWNER);
		createEAttribute(attributeEClass, ATTRIBUTE__PRIMITIVE);

		structureEClass = createEClass(STRUCTURE);
		createEReference(structureEClass, STRUCTURE__REGIONS);
		createEReference(structureEClass, STRUCTURE__GROUNDED_ENUMERATION);

		regionEClass = createEClass(REGION);
		createEReference(regionEClass, REGION__OWNER_STRUCTURE);
		createEReference(regionEClass, REGION__GROUNDED_LITERAL);
		createEReference(regionEClass, REGION__COMPOSED_BY);
		createEAttribute(regionEClass, REGION__BASIC_TYPE);
		createEOperation(regionEClass, REGION___IS_BASIC);
		createEOperation(regionEClass, REGION___IS_COMPOSED);
		createEOperation(regionEClass, REGION___IS_NOMINAL);

		domainEClass = createEClass(DOMAIN);
		createEReference(domainEClass, DOMAIN__DIMENSIONS);

		dimensionEClass = createEClass(DIMENSION);
		createEReference(dimensionEClass, DIMENSION__OWNER_DOMAIN);
		createEReference(dimensionEClass, DIMENSION__LOWER_BOUND);
		createEReference(dimensionEClass, DIMENSION__UPPER_BOUND);
		createEAttribute(dimensionEClass, DIMENSION__UNIT_OF_MEASURE);
		createEAttribute(dimensionEClass, DIMENSION__SCALE);
		createEAttribute(dimensionEClass, DIMENSION__MEASURE);
		createEOperation(dimensionEClass, DIMENSION___IS_NOMINAL);
		createEOperation(dimensionEClass, DIMENSION___IS_INTERVAL);
		createEOperation(dimensionEClass, DIMENSION___IS_ORDINAL);
		createEOperation(dimensionEClass, DIMENSION___IS_RATIONAL);
		createEOperation(dimensionEClass, DIMENSION___IS_STRING);
		createEOperation(dimensionEClass, DIMENSION___IS_INTEGER);
		createEOperation(dimensionEClass, DIMENSION___IS_DECIMAL);
		createEOperation(dimensionEClass, DIMENSION___IS_NOMINAL_STRING);
		createEOperation(dimensionEClass, DIMENSION___IS_INTERVAL_INTEGER);
		createEOperation(dimensionEClass, DIMENSION___IS_INTERVAL_DECIMAL);
		createEOperation(dimensionEClass, DIMENSION___IS_ORDINAL_INTEGER);
		createEOperation(dimensionEClass, DIMENSION___IS_ORDINAL_DECIMAL);
		createEOperation(dimensionEClass, DIMENSION___IS_RATIONAL_INTEGER);
		createEOperation(dimensionEClass, DIMENSION___IS_RATIONAL_DECIMAL);

		propertyEClass = createEClass(PROPERTY);
		createEAttribute(propertyEClass, PROPERTY__IS_ORDERED);
		createEAttribute(propertyEClass, PROPERTY__IS_DERIVED);
		createEAttribute(propertyEClass, PROPERTY__LOWER_BOUND);
		createEAttribute(propertyEClass, PROPERTY__UPPER_BOUND);
		createEAttribute(propertyEClass, PROPERTY__IS_DEPENDENCY);

		endPointEClass = createEClass(END_POINT);
		createEReference(endPointEClass, END_POINT__OWNER);
		createEReference(endPointEClass, END_POINT__END_TYPE);
		createEReference(endPointEClass, END_POINT__SUBSETS);
		createEReference(endPointEClass, END_POINT__REDEFINES);
		createEReference(endPointEClass, END_POINT__IS_SUBSETTED_BY);
		createEReference(endPointEClass, END_POINT__IS_REDEFINED_BY);

		relationshipEClass = createEClass(RELATIONSHIP);
		createEAttribute(relationshipEClass, RELATIONSHIP__STEREOTYPE);
		createEAttribute(relationshipEClass, RELATIONSHIP__ALLEN_RELATION);
		createEReference(relationshipEClass, RELATIONSHIP__END_POINTS);
		createEReference(relationshipEClass, RELATIONSHIP__DERIVED_FROM_TRUTH_MAKER);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_COMPONENT_OF);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_MEMBER_OF);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_SUB_COLLECTION_OF);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_SUB_QUANTITY_OF);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_CONSTITUTION);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_CHARACTERIZATION);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_MEDIATION);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_MATERIAL);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_FORMAL);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_STRUCTURATION);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_PARTICIPATION);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_SUB_EVENT_OF);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_CAUSATION);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_TEMPORAL);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_DERIVATION);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_STARTS);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_PRECEDES);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_EQUALS);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_MEETS);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_FINISHES);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_OVERLAPS);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_DURING);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_MERONYMIC);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_BINARY);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_TERNARY);
		createEOperation(relationshipEClass, RELATIONSHIP___SOURCE_END);
		createEOperation(relationshipEClass, RELATIONSHIP___TARGET_END);
		createEOperation(relationshipEClass, RELATIONSHIP___SOURCE);
		createEOperation(relationshipEClass, RELATIONSHIP___TARGET);
		createEOperation(relationshipEClass, RELATIONSHIP___SOURCE_CLASS);
		createEOperation(relationshipEClass, RELATIONSHIP___TARGET_CLASS);
		createEOperation(relationshipEClass, RELATIONSHIP___SOURCE_RELATIONSHIP);
		createEOperation(relationshipEClass, RELATIONSHIP___TARGET_RELATIONSHIP);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_DERIVED);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_END__CLASSIFIER);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_PART_ESSENTIAL);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_PART_INSEPARABLE);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_PART_IMMUTABLE);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_WHOLE_IMMUTABLE);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_PART_MANDATORY);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_WHOLE_MANDATORY);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_SHAREABLE);
		createEOperation(relationshipEClass, RELATIONSHIP___MATERIAL);
		createEOperation(relationshipEClass, RELATIONSHIP___RELATOR);

		// Create enums
		universalEEnum = createEEnum(UNIVERSAL);
		qualityEEnum = createEEnum(QUALITY);
		primitiveEEnum = createEEnum(PRIMITIVE);
		scaleEEnum = createEEnum(SCALE);
		relationEEnum = createEEnum(RELATION);
		temporalEEnum = createEEnum(TEMPORAL);
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
		modelEClass.getESuperTypes().add(this.getContainer());
		containedElementEClass.getESuperTypes().add(this.getElement());
		packageEClass.getESuperTypes().add(this.getContainer());
		packageEClass.getESuperTypes().add(this.getContainedElement());
		commentEClass.getESuperTypes().add(this.getElement());
		classifierEClass.getESuperTypes().add(this.getContainedElement());
		generalizationSetEClass.getESuperTypes().add(this.getNamedElement());
		generalizationSetEClass.getESuperTypes().add(this.getContainedElement());
		typeEClass.getESuperTypes().add(this.getNamedElement());
		typeEClass.getESuperTypes().add(this.getClassifier());
		classEClass.getESuperTypes().add(this.getType());
		literalEClass.getESuperTypes().add(this.getElement());
		attributeEClass.getESuperTypes().add(this.getProperty());
		structureEClass.getESuperTypes().add(this.getType());
		regionEClass.getESuperTypes().add(this.getType());
		domainEClass.getESuperTypes().add(this.getStructure());
		dimensionEClass.getESuperTypes().add(this.getStructure());
		propertyEClass.getESuperTypes().add(this.getNamedElement());
		endPointEClass.getESuperTypes().add(this.getProperty());
		relationshipEClass.getESuperTypes().add(this.getNamedElement());
		relationshipEClass.getESuperTypes().add(this.getClassifier());

		// Initialize classes, features, and operations; add parameters
		initEClass(elementEClass, Element.class, "Element", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), theEcorePackage.getEString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(containerEClass, net.menthor.metamodel.ontouml.Container.class, "Container", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainer_Elements(), this.getContainedElement(), this.getContainedElement_Holder(), "elements", null, 0, -1, net.menthor.metamodel.ontouml.Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEOperation(getContainer__Packages(), this.getPackage(), "packages", 0, -1, !IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getContainer__AllPackages__Container_EList(), null, "allPackages", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getContainer(), "c", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPackage(), "result", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getContainer__AllPackages(), this.getPackage(), "allPackages", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getContainer__Relationships(), this.getRelationship(), "relationships", 0, -1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getContainer__AllRelationships__Container_EList(), null, "allRelationships", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getContainer(), "c", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getRelationship(), "result", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getContainer__AllRelationships(), this.getRelationship(), "allRelationships", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getContainer__GeneralizationSets(), this.getGeneralizationSet(), "generalizationSets", 0, -1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getContainer__AllGeneralizationSets__Container_EList(), null, "allGeneralizationSets", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getContainer(), "c", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getGeneralizationSet(), "result", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getContainer__AllGeneralizationSets(), this.getGeneralizationSet(), "allGeneralizationSets", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getContainer__Classes(), this.getClass_(), "classes", 0, -1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getContainer__AllClasses__Container_EList(), null, "allClasses", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getContainer(), "c", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getClass_(), "result", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getContainer__AllClasses(), this.getClass_(), "allClasses", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getContainer__Structures(), this.getStructure(), "structures", 0, -1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getContainer__AllStructures__Container_EList(), null, "allStructures", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getContainer(), "c", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getStructure(), "result", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getContainer__AllStructures(), this.getStructure(), "allStructures", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(containedElementEClass, ContainedElement.class, "ContainedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainedElement_Holder(), this.getContainer(), this.getContainer_Elements(), "holder", null, 1, 1, ContainedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContainedElement_Comments(), this.getComment(), this.getComment_Owner(), "comments", null, 0, -1, ContainedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getContainedElement__GetModel__Container(), this.getModel(), "getModel", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getContainer(), "c", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getContainedElement__GetModel(), this.getModel(), "getModel", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(packageEClass, net.menthor.metamodel.ontouml.Package.class, "Package", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(commentEClass, Comment.class, "Comment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComment_Content(), theEcorePackage.getEString(), "content", null, 0, 1, Comment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComment_Owner(), this.getContainedElement(), this.getContainedElement_Comments(), "owner", null, 1, 1, Comment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classifierEClass, Classifier.class, "Classifier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassifier_IsSpecializedVia(), this.getGeneralizationSet(), this.getGeneralizationSet_SpecializedClassifier(), "isSpecializedVia", null, 0, -1, Classifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClassifier_SpecializesVia(), this.getGeneralizationSet(), this.getGeneralizationSet_SpecializingClassifier(), "specializesVia", null, 0, -1, Classifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEOperation(getClassifier__Children(), this.getClassifier(), "children", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClassifier__Parents(), this.getClassifier(), "parents", 0, -1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClassifier__AllParents__Classifier_EList(), null, "allParents", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getClassifier(), "c", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getClassifier(), "result", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClassifier__AllParents(), this.getClassifier(), "allParents", 0, -1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getClassifier__AllChildren__Classifier_EList(), null, "allChildren", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getClassifier(), "c", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getClassifier(), "result", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClassifier__AllChildren(), this.getClassifier(), "allChildren", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClassifier__Siblings(), this.getClassifier(), "siblings", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClassifier__Ends(), this.getEndPoint(), "ends", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClassifier__AllEnds(), this.getEndPoint(), "allEnds", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(generalizationSetEClass, GeneralizationSet.class, "GeneralizationSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGeneralizationSet_IsCovering(), theEcorePackage.getEBoolean(), "isCovering", null, 0, 1, GeneralizationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGeneralizationSet_SpecializedClassifier(), this.getClassifier(), this.getClassifier_IsSpecializedVia(), "specializedClassifier", null, 1, 1, GeneralizationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGeneralizationSet_SpecializingClassifier(), this.getClassifier(), this.getClassifier_SpecializesVia(), "specializingClassifier", null, 1, -1, GeneralizationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGeneralizationSet_HighOrder(), this.getClass_(), null, "highOrder", null, 0, 1, GeneralizationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeEClass, Type.class, "Type", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getType__RelatedTypes(), this.getType(), "relatedTypes", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getType__AllRelatedTypes(), this.getType(), "allRelatedTypes", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(classEClass, net.menthor.metamodel.ontouml.Class.class, "Class", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClass_Stereotype(), this.getUniversal(), "stereotype", null, 0, 1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClass_IsAbstract(), theEcorePackage.getEBoolean(), "isAbstract", null, 0, 1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClass_IsDerived(), theEcorePackage.getEBoolean(), "isDerived", null, 0, 1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_Attributes(), this.getAttribute(), this.getAttribute_Owner(), "attributes", null, 0, -1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getClass_QualityType(), this.getQuality(), "qualityType", null, 0, 1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_Literals(), this.getLiteral(), this.getLiteral_Owner(), "literals", null, 0, -1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_GroundingStructure(), this.getStructure(), this.getStructure_GroundedEnumeration(), "groundingStructure", null, 0, 1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_InstanceOf(), this.getClass_(), null, "instanceOf", null, 0, -1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClass_IstruthMakerOf(), this.getRelationship(), this.getRelationship_DerivedFromTruthMaker(), "istruthMakerOf", null, 0, -1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getClass_IsExtensional(), theEcorePackage.getEBoolean(), "isExtensional", null, 0, 1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getClass__IsKind(), theEcorePackage.getEBoolean(), "isKind", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsSubKind(), theEcorePackage.getEBoolean(), "isSubKind", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsCollective(), theEcorePackage.getEBoolean(), "isCollective", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsQuantity(), theEcorePackage.getEBoolean(), "isQuantity", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsRelator(), theEcorePackage.getEBoolean(), "isRelator", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsMode(), theEcorePackage.getEBoolean(), "isMode", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsQuality(), theEcorePackage.getEBoolean(), "isQuality", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsRole(), theEcorePackage.getEBoolean(), "isRole", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsRoleMixin(), theEcorePackage.getEBoolean(), "isRoleMixin", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsPhaseMixin(), theEcorePackage.getEBoolean(), "isPhaseMixin", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsPhase(), theEcorePackage.getEBoolean(), "isPhase", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsCategory(), theEcorePackage.getEBoolean(), "isCategory", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsMixin(), theEcorePackage.getEBoolean(), "isMixin", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsEvent(), theEcorePackage.getEBoolean(), "isEvent", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsHighOrder(), theEcorePackage.getEBoolean(), "isHighOrder", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsDataType(), theEcorePackage.getEBoolean(), "isDataType", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsEnumeration(), theEcorePackage.getEBoolean(), "isEnumeration", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsRigid(), theEcorePackage.getEBoolean(), "isRigid", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsNonRigid(), theEcorePackage.getEBoolean(), "isNonRigid", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsAntiRigid(), theEcorePackage.getEBoolean(), "isAntiRigid", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsSemiRigid(), theEcorePackage.getEBoolean(), "isSemiRigid", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsMoment(), theEcorePackage.getEBoolean(), "isMoment", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsIdentityProvider(), theEcorePackage.getEBoolean(), "isIdentityProvider", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsTruthMaker(), theEcorePackage.getEBoolean(), "isTruthMaker", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsMixinClass(), theEcorePackage.getEBoolean(), "isMixinClass", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IdentityProvidersAtAllParents(), this.getClass_(), "identityProvidersAtAllParents", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IdentityProvidersAtAllChildren(), this.getClass_(), "identityProvidersAtAllChildren", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IdentityProviders(), this.getClass_(), "identityProviders", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsAmountOfMatter(), theEcorePackage.getEBoolean(), "isAmountOfMatter", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsFunctionalComplex(), theEcorePackage.getEBoolean(), "isFunctionalComplex", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsCollection(), theEcorePackage.getEBoolean(), "isCollection", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsIntrinsic(), theEcorePackage.getEBoolean(), "isIntrinsic", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(literalEClass, Literal.class, "Literal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLiteral_Owner(), this.getClass_(), this.getClass_Literals(), "owner", null, 1, 1, Literal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLiteral_GroundingRegion(), this.getRegion(), this.getRegion_GroundedLiteral(), "groundingRegion", null, 0, 1, Literal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLiteral_Value(), theEcorePackage.getEString(), "value", null, 0, 1, Literal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttribute_Owner(), this.getClass_(), this.getClass_Attributes(), "owner", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_Primitive(), this.getPrimitive(), "primitive", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structureEClass, Structure.class, "Structure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructure_Regions(), this.getRegion(), this.getRegion_OwnerStructure(), "regions", null, 0, -1, Structure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructure_GroundedEnumeration(), this.getClass_(), this.getClass_GroundingStructure(), "groundedEnumeration", null, 0, 1, Structure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(regionEClass, Region.class, "Region", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRegion_OwnerStructure(), this.getStructure(), this.getStructure_Regions(), "ownerStructure", null, 0, 1, Region.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRegion_GroundedLiteral(), this.getLiteral(), this.getLiteral_GroundingRegion(), "groundedLiteral", null, 0, 1, Region.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRegion_ComposedBy(), this.getRegion(), null, "composedBy", null, 0, -1, Region.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRegion_BasicType(), this.getPrimitive(), "basicType", null, 0, 1, Region.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getRegion__IsBasic(), theEcorePackage.getEBoolean(), "isBasic", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRegion__IsComposed(), theEcorePackage.getEBoolean(), "isComposed", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRegion__IsNominal(), theEcorePackage.getEBoolean(), "isNominal", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(domainEClass, Domain.class, "Domain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDomain_Dimensions(), this.getDimension(), this.getDimension_OwnerDomain(), "dimensions", null, 0, -1, Domain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dimensionEClass, Dimension.class, "Dimension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDimension_OwnerDomain(), this.getDomain(), this.getDomain_Dimensions(), "ownerDomain", null, 0, 1, Dimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDimension_LowerBound(), this.getRegion(), null, "lowerBound", null, 0, 1, Dimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDimension_UpperBound(), this.getRegion(), null, "upperBound", null, 0, 1, Dimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDimension_UnitOfMeasure(), theEcorePackage.getEString(), "unitOfMeasure", null, 0, 1, Dimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDimension_Scale(), this.getScale(), "scale", null, 0, 1, Dimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDimension_Measure(), this.getPrimitive(), "measure", null, 0, 1, Dimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getDimension__IsNominal(), theEcorePackage.getEBoolean(), "isNominal", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDimension__IsInterval(), theEcorePackage.getEBoolean(), "isInterval", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDimension__IsOrdinal(), theEcorePackage.getEBoolean(), "isOrdinal", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDimension__IsRational(), theEcorePackage.getEBoolean(), "isRational", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDimension__IsString(), theEcorePackage.getEBoolean(), "isString", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDimension__IsInteger(), theEcorePackage.getEBoolean(), "isInteger", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDimension__IsDecimal(), theEcorePackage.getEBoolean(), "isDecimal", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDimension__IsNominalString(), theEcorePackage.getEBoolean(), "isNominalString", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDimension__IsIntervalInteger(), theEcorePackage.getEBoolean(), "isIntervalInteger", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDimension__IsIntervalDecimal(), theEcorePackage.getEBoolean(), "isIntervalDecimal", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDimension__IsOrdinalInteger(), theEcorePackage.getEBoolean(), "isOrdinalInteger", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDimension__IsOrdinalDecimal(), theEcorePackage.getEBoolean(), "isOrdinalDecimal", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDimension__IsRationalInteger(), theEcorePackage.getEBoolean(), "isRationalInteger", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDimension__IsRationalDecimal(), theEcorePackage.getEBoolean(), "isRationalDecimal", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(propertyEClass, Property.class, "Property", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProperty_IsOrdered(), theEcorePackage.getEBoolean(), "isOrdered", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_IsDerived(), theEcorePackage.getEBoolean(), "isDerived", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_LowerBound(), theEcorePackage.getEInt(), "lowerBound", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_UpperBound(), theEcorePackage.getEInt(), "upperBound", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_IsDependency(), theEcorePackage.getEBoolean(), "isDependency", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(endPointEClass, EndPoint.class, "EndPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEndPoint_Owner(), this.getRelationship(), this.getRelationship_EndPoints(), "owner", null, 1, 1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEndPoint_EndType(), this.getClassifier(), null, "endType", null, 1, 1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEndPoint_Subsets(), this.getEndPoint(), this.getEndPoint_IsSubsettedBy(), "subsets", null, 0, -1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEndPoint_Redefines(), this.getEndPoint(), this.getEndPoint_IsRedefinedBy(), "redefines", null, 0, -1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEndPoint_IsSubsettedBy(), this.getEndPoint(), this.getEndPoint_Subsets(), "isSubsettedBy", null, 0, -1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEndPoint_IsRedefinedBy(), this.getEndPoint(), this.getEndPoint_Redefines(), "isRedefinedBy", null, 0, -1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(relationshipEClass, Relationship.class, "Relationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelationship_Stereotype(), this.getRelation(), "stereotype", null, 0, 1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationship_AllenRelation(), this.getTemporal(), "allenRelation", null, 0, 1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationship_EndPoints(), this.getEndPoint(), this.getEndPoint_Owner(), "endPoints", null, 0, -1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationship_DerivedFromTruthMaker(), this.getClass_(), this.getClass_IstruthMakerOf(), "derivedFromTruthMaker", null, 0, 1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getRelationship__IsComponentOf(), theEcorePackage.getEBoolean(), "isComponentOf", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsMemberOf(), theEcorePackage.getEBoolean(), "isMemberOf", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsSubCollectionOf(), theEcorePackage.getEBoolean(), "isSubCollectionOf", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsSubQuantityOf(), theEcorePackage.getEBoolean(), "isSubQuantityOf", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsConstitution(), theEcorePackage.getEBoolean(), "isConstitution", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsCharacterization(), theEcorePackage.getEBoolean(), "isCharacterization", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsMediation(), theEcorePackage.getEBoolean(), "isMediation", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsMaterial(), theEcorePackage.getEBoolean(), "isMaterial", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsFormal(), theEcorePackage.getEBoolean(), "isFormal", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsStructuration(), theEcorePackage.getEBoolean(), "isStructuration", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsParticipation(), theEcorePackage.getEBoolean(), "isParticipation", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsSubEventOf(), theEcorePackage.getEBoolean(), "isSubEventOf", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsCausation(), theEcorePackage.getEBoolean(), "isCausation", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsTemporal(), theEcorePackage.getEBoolean(), "isTemporal", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsDerivation(), theEcorePackage.getEBoolean(), "isDerivation", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsStarts(), theEcorePackage.getEBoolean(), "isStarts", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsPrecedes(), theEcorePackage.getEBoolean(), "isPrecedes", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsEquals(), theEcorePackage.getEBoolean(), "isEquals", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsMeets(), theEcorePackage.getEBoolean(), "isMeets", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsFinishes(), theEcorePackage.getEBoolean(), "isFinishes", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsOverlaps(), theEcorePackage.getEBoolean(), "isOverlaps", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsDuring(), theEcorePackage.getEBoolean(), "isDuring", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsMeronymic(), theEcorePackage.getEBoolean(), "isMeronymic", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsBinary(), theEcorePackage.getEBoolean(), "isBinary", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsTernary(), theEcorePackage.getEBoolean(), "isTernary", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__SourceEnd(), this.getEndPoint(), "sourceEnd", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__TargetEnd(), this.getEndPoint(), "targetEnd", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__Source(), this.getClassifier(), "source", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__Target(), this.getClassifier(), "target", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__SourceClass(), this.getClass_(), "sourceClass", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__TargetClass(), this.getClass_(), "targetClass", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__SourceRelationship(), this.getRelationship(), "sourceRelationship", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__TargetRelationship(), this.getRelationship(), "targetRelationship", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsDerived(), theEcorePackage.getEBoolean(), "isDerived", 0, 1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getRelationship__IsEnd__Classifier(), theEcorePackage.getEBoolean(), "isEnd", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getClassifier(), "c", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsPartEssential(), theEcorePackage.getEBoolean(), "isPartEssential", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsPartInseparable(), theEcorePackage.getEBoolean(), "isPartInseparable", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsPartImmutable(), theEcorePackage.getEBoolean(), "isPartImmutable", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsWholeImmutable(), theEcorePackage.getEBoolean(), "isWholeImmutable", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsPartMandatory(), theEcorePackage.getEBoolean(), "isPartMandatory", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsWholeMandatory(), theEcorePackage.getEBoolean(), "isWholeMandatory", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsShareable(), null, "isShareable", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__Material(), this.getRelationship(), "material", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__Relator(), this.getClass_(), "relator", 0, 1, !IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(universalEEnum, Universal.class, "Universal");
		addEEnumLiteral(universalEEnum, Universal.KIND);
		addEEnumLiteral(universalEEnum, Universal.COLLECTIVE);
		addEEnumLiteral(universalEEnum, Universal.QUANTITY);
		addEEnumLiteral(universalEEnum, Universal.RELATOR);
		addEEnumLiteral(universalEEnum, Universal.MODE);
		addEEnumLiteral(universalEEnum, Universal.QUALITY);
		addEEnumLiteral(universalEEnum, Universal.ROLE);
		addEEnumLiteral(universalEEnum, Universal.PHASE);
		addEEnumLiteral(universalEEnum, Universal.SUB_KIND);
		addEEnumLiteral(universalEEnum, Universal.CATEGORY);
		addEEnumLiteral(universalEEnum, Universal.MIXIN);
		addEEnumLiteral(universalEEnum, Universal.ROLE_MIXIN);
		addEEnumLiteral(universalEEnum, Universal.PHASE_MIXIN);
		addEEnumLiteral(universalEEnum, Universal.DATA_TYPE);
		addEEnumLiteral(universalEEnum, Universal.ENUMERATION);
		addEEnumLiteral(universalEEnum, Universal.EVENT);
		addEEnumLiteral(universalEEnum, Universal.HOU);

		initEEnum(qualityEEnum, Quality.class, "Quality");
		addEEnumLiteral(qualityEEnum, Quality.NOMINAL);
		addEEnumLiteral(qualityEEnum, Quality.PERCEIVABLE);
		addEEnumLiteral(qualityEEnum, Quality.NON_PERCEIVABLE);

		initEEnum(primitiveEEnum, Primitive.class, "Primitive");
		addEEnumLiteral(primitiveEEnum, Primitive.BOOLEAN);
		addEEnumLiteral(primitiveEEnum, Primitive.STRING);
		addEEnumLiteral(primitiveEEnum, Primitive.REAL);
		addEEnumLiteral(primitiveEEnum, Primitive.INTEGER);
		addEEnumLiteral(primitiveEEnum, Primitive.DECIMAL);
		addEEnumLiteral(primitiveEEnum, Primitive.UNLIMITED_NATURAL);
		addEEnumLiteral(primitiveEEnum, Primitive.DATE);

		initEEnum(scaleEEnum, Scale.class, "Scale");
		addEEnumLiteral(scaleEEnum, Scale.INTERVAL);
		addEEnumLiteral(scaleEEnum, Scale.RATIONAL);
		addEEnumLiteral(scaleEEnum, Scale.ORDINAL);
		addEEnumLiteral(scaleEEnum, Scale.NOMINAL);

		initEEnum(relationEEnum, Relation.class, "Relation");
		addEEnumLiteral(relationEEnum, Relation.COMPONENT_OF);
		addEEnumLiteral(relationEEnum, Relation.MEMBER_OF);
		addEEnumLiteral(relationEEnum, Relation.SUB_COLLECTION_OF);
		addEEnumLiteral(relationEEnum, Relation.SUB_QUANTITY_OF);
		addEEnumLiteral(relationEEnum, Relation.CONSTITUTION);
		addEEnumLiteral(relationEEnum, Relation.CHARACTERIZATION);
		addEEnumLiteral(relationEEnum, Relation.MEDIATION);
		addEEnumLiteral(relationEEnum, Relation.MATERIAL);
		addEEnumLiteral(relationEEnum, Relation.FORMAL);
		addEEnumLiteral(relationEEnum, Relation.STRUCTURATION);
		addEEnumLiteral(relationEEnum, Relation.DERIVATION);
		addEEnumLiteral(relationEEnum, Relation.PARTICIPATION);
		addEEnumLiteral(relationEEnum, Relation.SUB_EVENT_OF);
		addEEnumLiteral(relationEEnum, Relation.CAUSATION);
		addEEnumLiteral(relationEEnum, Relation.TEMPORAL);

		initEEnum(temporalEEnum, Temporal.class, "Temporal");
		addEEnumLiteral(temporalEEnum, Temporal.STARTS);
		addEEnumLiteral(temporalEEnum, Temporal.PRECEDES);
		addEEnumLiteral(temporalEEnum, Temporal.EQUALS);
		addEEnumLiteral(temporalEEnum, Temporal.MEETS);
		addEEnumLiteral(temporalEEnum, Temporal.FINISHES);
		addEEnumLiteral(temporalEEnum, Temporal.OVERLAPS);
		addEEnumLiteral(temporalEEnum, Temporal.DURING);

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
