/**
 */
package net.menthor.metamodel.ontouml.impl;

import net.menthor.metamodel.ontouml.Attribute;
import net.menthor.metamodel.ontouml.Ciclicity;
import net.menthor.metamodel.ontouml.ClassStereotype;
import net.menthor.metamodel.ontouml.Classification;
import net.menthor.metamodel.ontouml.Classifier;
import net.menthor.metamodel.ontouml.Comment;
import net.menthor.metamodel.ontouml.ContainedElement;
import net.menthor.metamodel.ontouml.DataType;
import net.menthor.metamodel.ontouml.DataTypeStereotype;
import net.menthor.metamodel.ontouml.Element;
import net.menthor.metamodel.ontouml.EndPoint;
import net.menthor.metamodel.ontouml.Existence;
import net.menthor.metamodel.ontouml.GeneralizationSet;
import net.menthor.metamodel.ontouml.Literal;
import net.menthor.metamodel.ontouml.Measurement;
import net.menthor.metamodel.ontouml.Model;
import net.menthor.metamodel.ontouml.NamedElement;
import net.menthor.metamodel.ontouml.OntoumlFactory;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.ParticipationNature;
import net.menthor.metamodel.ontouml.PrimitiveStereotype;
import net.menthor.metamodel.ontouml.Property;
import net.menthor.metamodel.ontouml.QualityNature;
import net.menthor.metamodel.ontouml.Reflexivity;
import net.menthor.metamodel.ontouml.Relationship;
import net.menthor.metamodel.ontouml.RelationshipStereotype;
import net.menthor.metamodel.ontouml.Scale;
import net.menthor.metamodel.ontouml.Symmetry;
import net.menthor.metamodel.ontouml.TemporalNature;
import net.menthor.metamodel.ontouml.Transitivity;
import net.menthor.metamodel.ontouml.Type;

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
	private EClass containedElementEClass = null;

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
	private EClass classifierEClass = null;

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
	private EClass generalizationSetEClass = null;

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
	private EClass dataTypeEClass = null;

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
	private EEnum primitiveStereotypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum classStereotypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dataTypeStereotypeEEnum = null;

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
	private EEnum measurementEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum qualityNatureEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum classificationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum existenceEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum relationshipStereotypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum temporalNatureEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum participationNatureEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum reflexivityEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum symmetryEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum transitivityEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum ciclicityEEnum = null;

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
	public EOperation getContainer__DataTypes() {
		return containerEClass.getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainer__AllDataTypes__Container_EList() {
		return containerEClass.getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainer__AllDataTypes() {
		return containerEClass.getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainer__Types() {
		return containerEClass.getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainer__AllTypes__Container_EList() {
		return containerEClass.getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getContainer__AllTypes() {
		return containerEClass.getEOperations().get(17);
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
	public EClass getClassifier() {
		return classifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifier_Definitions() {
		return (EAttribute)classifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifier_Synonyms() {
		return (EAttribute)classifierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifier_Text() {
		return (EAttribute)classifierEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifier_IsSpecializedVia() {
		return (EReference)classifierEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifier_SpecializesVia() {
		return (EReference)classifierEClass.getEStructuralFeatures().get(4);
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
	public EClass getType() {
		return typeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getType_Attributes() {
		return (EReference)typeEClass.getEStructuralFeatures().get(0);
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
	public EClass getAttribute() {
		return attributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute_Definitions() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute_Synonyms() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute_Text() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute_Stereotype() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttribute_Owner() {
		return (EReference)attributeEClass.getEStructuralFeatures().get(4);
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
	public EClass getLiteral() {
		return literalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLiteral_Value() {
		return (EAttribute)literalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLiteral_Owner() {
		return (EReference)literalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLiteral_UpperBoundRegion() {
		return (EAttribute)literalEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLiteral_LowerBoundRegion() {
		return (EAttribute)literalEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataType() {
		return dataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataType_Stereotype() {
		return (EAttribute)dataTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataType_Dimensions() {
		return (EReference)dataTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataType_Scale() {
		return (EAttribute)dataTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataType_Measurement() {
		return (EAttribute)dataTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataType_UnitOfMeasure() {
		return (EAttribute)dataTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataType_LowerBoundRegion() {
		return (EAttribute)dataTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataType_UpperBoundRegion() {
		return (EAttribute)dataTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataType_OwnerDomain() {
		return (EReference)dataTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataType_Literals() {
		return (EReference)dataTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataType_Structure() {
		return (EReference)dataTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataType__IsEnumeration() {
		return dataTypeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataType__IsDomain() {
		return dataTypeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataType__IsDimension() {
		return dataTypeEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataType__IsDataType() {
		return dataTypeEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataType__IsNominal() {
		return dataTypeEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataType__IsInterval() {
		return dataTypeEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataType__IsOrdinal() {
		return dataTypeEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataType__IsRational() {
		return dataTypeEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataType__IsString() {
		return dataTypeEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataType__IsInteger() {
		return dataTypeEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataType__IsDecimal() {
		return dataTypeEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataType__IsReal() {
		return dataTypeEClass.getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataType__IsNominalString() {
		return dataTypeEClass.getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataType__IsIntervalInteger() {
		return dataTypeEClass.getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataType__IsIntervalDecimal() {
		return dataTypeEClass.getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataType__IsOrdinalInteger() {
		return dataTypeEClass.getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataType__IsOrdinalDecimal() {
		return dataTypeEClass.getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataType__IsRationalInteger() {
		return dataTypeEClass.getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataType__IsRationalDecimal() {
		return dataTypeEClass.getEOperations().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataType__IsIntervalReal() {
		return dataTypeEClass.getEOperations().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataType__IsOrdinalReal() {
		return dataTypeEClass.getEOperations().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDataType__IsRationalReal() {
		return dataTypeEClass.getEOperations().get(21);
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
	public EAttribute getClass_IsExtensional() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClass_QualityNature() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClass_Existence() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClass_Classification() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(6);
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
	public EOperation getClass__IsRigid() {
		return classEClass.getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsNonRigid() {
		return classEClass.getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsAntiRigid() {
		return classEClass.getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsSemiRigid() {
		return classEClass.getEOperations().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsSubstanceSortalClass() {
		return classEClass.getEOperations().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsMomentClass() {
		return classEClass.getEOperations().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsIdentityProviderClass() {
		return classEClass.getEOperations().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsMixinClass() {
		return classEClass.getEOperations().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsAntiRigidMixinClass() {
		return classEClass.getEOperations().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsAmountOfMatter() {
		return classEClass.getEOperations().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsFunctionalComplex() {
		return classEClass.getEOperations().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsCollection() {
		return classEClass.getEOperations().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsMoment() {
		return classEClass.getEOperations().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsTruthMaker() {
		return classEClass.getEOperations().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IdentityProvidersAtAllParents() {
		return classEClass.getEOperations().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IdentityProvidersAtAllChildren() {
		return classEClass.getEOperations().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IdentityProviders() {
		return classEClass.getEOperations().get(31);
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
	public EAttribute getRelationship_Reflexivity() {
		return (EAttribute)relationshipEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationship_Symmetry() {
		return (EAttribute)relationshipEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationship_Transitivity() {
		return (EAttribute)relationshipEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationship_Ciclicity() {
		return (EAttribute)relationshipEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationship_EndPoints() {
		return (EReference)relationshipEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationship_TemporalNature() {
		return (EAttribute)relationshipEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationship_ParticipationNature() {
		return (EAttribute)relationshipEClass.getEStructuralFeatures().get(7);
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
	public EOperation getRelationship__IsInstanceOf() {
		return relationshipEClass.getEOperations().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsMeronymic() {
		return relationshipEClass.getEOperations().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsBinary() {
		return relationshipEClass.getEOperations().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsTernary() {
		return relationshipEClass.getEOperations().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsStarts() {
		return relationshipEClass.getEOperations().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsPrecedes() {
		return relationshipEClass.getEOperations().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsEquals() {
		return relationshipEClass.getEOperations().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsMeets() {
		return relationshipEClass.getEOperations().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsFinishes() {
		return relationshipEClass.getEOperations().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsOverlaps() {
		return relationshipEClass.getEOperations().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsDuring() {
		return relationshipEClass.getEOperations().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsCreation() {
		return relationshipEClass.getEOperations().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsDestruction() {
		return relationshipEClass.getEOperations().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsChange() {
		return relationshipEClass.getEOperations().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__SourceEnd() {
		return relationshipEClass.getEOperations().get(28);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__TargetEnd() {
		return relationshipEClass.getEOperations().get(29);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__Source() {
		return relationshipEClass.getEOperations().get(30);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__Target() {
		return relationshipEClass.getEOperations().get(31);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__SourceClass() {
		return relationshipEClass.getEOperations().get(32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__TargetClass() {
		return relationshipEClass.getEOperations().get(33);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__SourceDataType() {
		return relationshipEClass.getEOperations().get(34);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__TargetDataType() {
		return relationshipEClass.getEOperations().get(35);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__SourceRelationship() {
		return relationshipEClass.getEOperations().get(36);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__TargetRelationship() {
		return relationshipEClass.getEOperations().get(37);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsDerived() {
		return relationshipEClass.getEOperations().get(38);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsEnd__Classifier() {
		return relationshipEClass.getEOperations().get(39);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsPartEssential() {
		return relationshipEClass.getEOperations().get(40);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsPartInseparable() {
		return relationshipEClass.getEOperations().get(41);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsPartImmutable() {
		return relationshipEClass.getEOperations().get(42);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsWholeImmutable() {
		return relationshipEClass.getEOperations().get(43);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsPartMandatory() {
		return relationshipEClass.getEOperations().get(44);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsWholeMandatory() {
		return relationshipEClass.getEOperations().get(45);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsPartShareable() {
		return relationshipEClass.getEOperations().get(46);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPrimitiveStereotype() {
		return primitiveStereotypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getClassStereotype() {
		return classStereotypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDataTypeStereotype() {
		return dataTypeStereotypeEEnum;
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
	public EEnum getMeasurement() {
		return measurementEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getQualityNature() {
		return qualityNatureEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getClassification() {
		return classificationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getExistence() {
		return existenceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRelationshipStereotype() {
		return relationshipStereotypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTemporalNature() {
		return temporalNatureEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getParticipationNature() {
		return participationNatureEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getReflexivity() {
		return reflexivityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSymmetry() {
		return symmetryEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTransitivity() {
		return transitivityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCiclicity() {
		return ciclicityEEnum;
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
		createEOperation(containerEClass, CONTAINER___DATA_TYPES);
		createEOperation(containerEClass, CONTAINER___ALL_DATA_TYPES__CONTAINER_ELIST);
		createEOperation(containerEClass, CONTAINER___ALL_DATA_TYPES);
		createEOperation(containerEClass, CONTAINER___TYPES);
		createEOperation(containerEClass, CONTAINER___ALL_TYPES__CONTAINER_ELIST);
		createEOperation(containerEClass, CONTAINER___ALL_TYPES);

		containedElementEClass = createEClass(CONTAINED_ELEMENT);
		createEReference(containedElementEClass, CONTAINED_ELEMENT__HOLDER);
		createEReference(containedElementEClass, CONTAINED_ELEMENT__COMMENTS);
		createEOperation(containedElementEClass, CONTAINED_ELEMENT___GET_MODEL__CONTAINER);
		createEOperation(containedElementEClass, CONTAINED_ELEMENT___GET_MODEL);

		commentEClass = createEClass(COMMENT);
		createEAttribute(commentEClass, COMMENT__CONTENT);
		createEReference(commentEClass, COMMENT__OWNER);

		modelEClass = createEClass(MODEL);

		packageEClass = createEClass(PACKAGE);

		classifierEClass = createEClass(CLASSIFIER);
		createEAttribute(classifierEClass, CLASSIFIER__DEFINITIONS);
		createEAttribute(classifierEClass, CLASSIFIER__SYNONYMS);
		createEAttribute(classifierEClass, CLASSIFIER__TEXT);
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

		typeEClass = createEClass(TYPE);
		createEReference(typeEClass, TYPE__ATTRIBUTES);
		createEOperation(typeEClass, TYPE___RELATED_TYPES);
		createEOperation(typeEClass, TYPE___ALL_RELATED_TYPES);

		propertyEClass = createEClass(PROPERTY);
		createEAttribute(propertyEClass, PROPERTY__IS_ORDERED);
		createEAttribute(propertyEClass, PROPERTY__IS_DERIVED);
		createEAttribute(propertyEClass, PROPERTY__LOWER_BOUND);
		createEAttribute(propertyEClass, PROPERTY__UPPER_BOUND);
		createEAttribute(propertyEClass, PROPERTY__IS_DEPENDENCY);

		attributeEClass = createEClass(ATTRIBUTE);
		createEAttribute(attributeEClass, ATTRIBUTE__DEFINITIONS);
		createEAttribute(attributeEClass, ATTRIBUTE__SYNONYMS);
		createEAttribute(attributeEClass, ATTRIBUTE__TEXT);
		createEAttribute(attributeEClass, ATTRIBUTE__STEREOTYPE);
		createEReference(attributeEClass, ATTRIBUTE__OWNER);

		generalizationSetEClass = createEClass(GENERALIZATION_SET);
		createEAttribute(generalizationSetEClass, GENERALIZATION_SET__IS_COVERING);
		createEReference(generalizationSetEClass, GENERALIZATION_SET__SPECIALIZED_CLASSIFIER);
		createEReference(generalizationSetEClass, GENERALIZATION_SET__SPECIALIZING_CLASSIFIER);
		createEReference(generalizationSetEClass, GENERALIZATION_SET__HIGH_ORDER);

		literalEClass = createEClass(LITERAL);
		createEAttribute(literalEClass, LITERAL__VALUE);
		createEReference(literalEClass, LITERAL__OWNER);
		createEAttribute(literalEClass, LITERAL__UPPER_BOUND_REGION);
		createEAttribute(literalEClass, LITERAL__LOWER_BOUND_REGION);

		dataTypeEClass = createEClass(DATA_TYPE);
		createEAttribute(dataTypeEClass, DATA_TYPE__STEREOTYPE);
		createEReference(dataTypeEClass, DATA_TYPE__DIMENSIONS);
		createEAttribute(dataTypeEClass, DATA_TYPE__SCALE);
		createEAttribute(dataTypeEClass, DATA_TYPE__MEASUREMENT);
		createEAttribute(dataTypeEClass, DATA_TYPE__UNIT_OF_MEASURE);
		createEAttribute(dataTypeEClass, DATA_TYPE__LOWER_BOUND_REGION);
		createEAttribute(dataTypeEClass, DATA_TYPE__UPPER_BOUND_REGION);
		createEReference(dataTypeEClass, DATA_TYPE__OWNER_DOMAIN);
		createEReference(dataTypeEClass, DATA_TYPE__LITERALS);
		createEReference(dataTypeEClass, DATA_TYPE__STRUCTURE);
		createEOperation(dataTypeEClass, DATA_TYPE___IS_ENUMERATION);
		createEOperation(dataTypeEClass, DATA_TYPE___IS_DOMAIN);
		createEOperation(dataTypeEClass, DATA_TYPE___IS_DIMENSION);
		createEOperation(dataTypeEClass, DATA_TYPE___IS_DATA_TYPE);
		createEOperation(dataTypeEClass, DATA_TYPE___IS_NOMINAL);
		createEOperation(dataTypeEClass, DATA_TYPE___IS_INTERVAL);
		createEOperation(dataTypeEClass, DATA_TYPE___IS_ORDINAL);
		createEOperation(dataTypeEClass, DATA_TYPE___IS_RATIONAL);
		createEOperation(dataTypeEClass, DATA_TYPE___IS_STRING);
		createEOperation(dataTypeEClass, DATA_TYPE___IS_INTEGER);
		createEOperation(dataTypeEClass, DATA_TYPE___IS_DECIMAL);
		createEOperation(dataTypeEClass, DATA_TYPE___IS_REAL);
		createEOperation(dataTypeEClass, DATA_TYPE___IS_NOMINAL_STRING);
		createEOperation(dataTypeEClass, DATA_TYPE___IS_INTERVAL_INTEGER);
		createEOperation(dataTypeEClass, DATA_TYPE___IS_INTERVAL_DECIMAL);
		createEOperation(dataTypeEClass, DATA_TYPE___IS_ORDINAL_INTEGER);
		createEOperation(dataTypeEClass, DATA_TYPE___IS_ORDINAL_DECIMAL);
		createEOperation(dataTypeEClass, DATA_TYPE___IS_RATIONAL_INTEGER);
		createEOperation(dataTypeEClass, DATA_TYPE___IS_RATIONAL_DECIMAL);
		createEOperation(dataTypeEClass, DATA_TYPE___IS_INTERVAL_REAL);
		createEOperation(dataTypeEClass, DATA_TYPE___IS_ORDINAL_REAL);
		createEOperation(dataTypeEClass, DATA_TYPE___IS_RATIONAL_REAL);

		classEClass = createEClass(CLASS);
		createEAttribute(classEClass, CLASS__STEREOTYPE);
		createEAttribute(classEClass, CLASS__IS_ABSTRACT);
		createEAttribute(classEClass, CLASS__IS_DERIVED);
		createEAttribute(classEClass, CLASS__IS_EXTENSIONAL);
		createEAttribute(classEClass, CLASS__QUALITY_NATURE);
		createEAttribute(classEClass, CLASS__EXISTENCE);
		createEAttribute(classEClass, CLASS__CLASSIFICATION);
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
		createEOperation(classEClass, CLASS___IS_RIGID);
		createEOperation(classEClass, CLASS___IS_NON_RIGID);
		createEOperation(classEClass, CLASS___IS_ANTI_RIGID);
		createEOperation(classEClass, CLASS___IS_SEMI_RIGID);
		createEOperation(classEClass, CLASS___IS_SUBSTANCE_SORTAL_CLASS);
		createEOperation(classEClass, CLASS___IS_MOMENT_CLASS);
		createEOperation(classEClass, CLASS___IS_IDENTITY_PROVIDER_CLASS);
		createEOperation(classEClass, CLASS___IS_MIXIN_CLASS);
		createEOperation(classEClass, CLASS___IS_ANTI_RIGID_MIXIN_CLASS);
		createEOperation(classEClass, CLASS___IS_AMOUNT_OF_MATTER);
		createEOperation(classEClass, CLASS___IS_FUNCTIONAL_COMPLEX);
		createEOperation(classEClass, CLASS___IS_COLLECTION);
		createEOperation(classEClass, CLASS___IS_MOMENT);
		createEOperation(classEClass, CLASS___IS_TRUTH_MAKER);
		createEOperation(classEClass, CLASS___IDENTITY_PROVIDERS_AT_ALL_PARENTS);
		createEOperation(classEClass, CLASS___IDENTITY_PROVIDERS_AT_ALL_CHILDREN);
		createEOperation(classEClass, CLASS___IDENTITY_PROVIDERS);

		endPointEClass = createEClass(END_POINT);
		createEReference(endPointEClass, END_POINT__OWNER);
		createEReference(endPointEClass, END_POINT__END_TYPE);
		createEReference(endPointEClass, END_POINT__SUBSETS);
		createEReference(endPointEClass, END_POINT__REDEFINES);
		createEReference(endPointEClass, END_POINT__IS_SUBSETTED_BY);
		createEReference(endPointEClass, END_POINT__IS_REDEFINED_BY);

		relationshipEClass = createEClass(RELATIONSHIP);
		createEAttribute(relationshipEClass, RELATIONSHIP__STEREOTYPE);
		createEAttribute(relationshipEClass, RELATIONSHIP__REFLEXIVITY);
		createEAttribute(relationshipEClass, RELATIONSHIP__SYMMETRY);
		createEAttribute(relationshipEClass, RELATIONSHIP__TRANSITIVITY);
		createEAttribute(relationshipEClass, RELATIONSHIP__CICLICITY);
		createEReference(relationshipEClass, RELATIONSHIP__END_POINTS);
		createEAttribute(relationshipEClass, RELATIONSHIP__TEMPORAL_NATURE);
		createEAttribute(relationshipEClass, RELATIONSHIP__PARTICIPATION_NATURE);
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
		createEOperation(relationshipEClass, RELATIONSHIP___IS_INSTANCE_OF);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_MERONYMIC);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_BINARY);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_TERNARY);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_STARTS);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_PRECEDES);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_EQUALS);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_MEETS);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_FINISHES);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_OVERLAPS);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_DURING);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_CREATION);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_DESTRUCTION);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_CHANGE);
		createEOperation(relationshipEClass, RELATIONSHIP___SOURCE_END);
		createEOperation(relationshipEClass, RELATIONSHIP___TARGET_END);
		createEOperation(relationshipEClass, RELATIONSHIP___SOURCE);
		createEOperation(relationshipEClass, RELATIONSHIP___TARGET);
		createEOperation(relationshipEClass, RELATIONSHIP___SOURCE_CLASS);
		createEOperation(relationshipEClass, RELATIONSHIP___TARGET_CLASS);
		createEOperation(relationshipEClass, RELATIONSHIP___SOURCE_DATA_TYPE);
		createEOperation(relationshipEClass, RELATIONSHIP___TARGET_DATA_TYPE);
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
		createEOperation(relationshipEClass, RELATIONSHIP___IS_PART_SHAREABLE);

		// Create enums
		primitiveStereotypeEEnum = createEEnum(PRIMITIVE_STEREOTYPE);
		classStereotypeEEnum = createEEnum(CLASS_STEREOTYPE);
		dataTypeStereotypeEEnum = createEEnum(DATA_TYPE_STEREOTYPE);
		scaleEEnum = createEEnum(SCALE);
		measurementEEnum = createEEnum(MEASUREMENT);
		qualityNatureEEnum = createEEnum(QUALITY_NATURE);
		classificationEEnum = createEEnum(CLASSIFICATION);
		existenceEEnum = createEEnum(EXISTENCE);
		relationshipStereotypeEEnum = createEEnum(RELATIONSHIP_STEREOTYPE);
		temporalNatureEEnum = createEEnum(TEMPORAL_NATURE);
		participationNatureEEnum = createEEnum(PARTICIPATION_NATURE);
		reflexivityEEnum = createEEnum(REFLEXIVITY);
		symmetryEEnum = createEEnum(SYMMETRY);
		transitivityEEnum = createEEnum(TRANSITIVITY);
		ciclicityEEnum = createEEnum(CICLICITY);
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
		containedElementEClass.getESuperTypes().add(this.getElement());
		commentEClass.getESuperTypes().add(this.getElement());
		modelEClass.getESuperTypes().add(this.getContainer());
		packageEClass.getESuperTypes().add(this.getContainer());
		packageEClass.getESuperTypes().add(this.getContainedElement());
		classifierEClass.getESuperTypes().add(this.getContainedElement());
		typeEClass.getESuperTypes().add(this.getClassifier());
		propertyEClass.getESuperTypes().add(this.getNamedElement());
		attributeEClass.getESuperTypes().add(this.getProperty());
		generalizationSetEClass.getESuperTypes().add(this.getNamedElement());
		generalizationSetEClass.getESuperTypes().add(this.getContainedElement());
		literalEClass.getESuperTypes().add(this.getElement());
		dataTypeEClass.getESuperTypes().add(this.getType());
		dataTypeEClass.getESuperTypes().add(this.getNamedElement());
		classEClass.getESuperTypes().add(this.getType());
		classEClass.getESuperTypes().add(this.getNamedElement());
		endPointEClass.getESuperTypes().add(this.getProperty());
		relationshipEClass.getESuperTypes().add(this.getClassifier());
		relationshipEClass.getESuperTypes().add(this.getNamedElement());

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

		initEOperation(getContainer__DataTypes(), this.getDataType(), "dataTypes", 0, -1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getContainer__AllDataTypes__Container_EList(), null, "allDataTypes", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getContainer(), "c", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDataType(), "result", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getContainer__AllDataTypes(), this.getDataType(), "allDataTypes", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getContainer__Types(), this.getType(), "types", 0, -1, !IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getContainer__AllTypes__Container_EList(), null, "allTypes", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getContainer(), "c", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getType(), "result", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getContainer__AllTypes(), this.getType(), "allTypes", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(containedElementEClass, ContainedElement.class, "ContainedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainedElement_Holder(), this.getContainer(), this.getContainer_Elements(), "holder", null, 1, 1, ContainedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContainedElement_Comments(), this.getComment(), this.getComment_Owner(), "comments", null, 0, -1, ContainedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getContainedElement__GetModel__Container(), this.getModel(), "getModel", 0, 1, !IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getContainer(), "c", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getContainedElement__GetModel(), this.getModel(), "getModel", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(commentEClass, Comment.class, "Comment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComment_Content(), theEcorePackage.getEString(), "content", null, 0, 1, Comment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComment_Owner(), this.getContainedElement(), this.getContainedElement_Comments(), "owner", null, 1, 1, Comment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(packageEClass, net.menthor.metamodel.ontouml.Package.class, "Package", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classifierEClass, Classifier.class, "Classifier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClassifier_Definitions(), theEcorePackage.getEString(), "definitions", null, 0, -1, Classifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassifier_Synonyms(), theEcorePackage.getEString(), "synonyms", null, 0, -1, Classifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassifier_Text(), theEcorePackage.getEString(), "text", null, 0, 1, Classifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
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

		initEClass(typeEClass, Type.class, "Type", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getType_Attributes(), this.getAttribute(), this.getAttribute_Owner(), "attributes", null, 0, -1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEOperation(getType__RelatedTypes(), this.getType(), "relatedTypes", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getType__AllRelatedTypes(), this.getType(), "allRelatedTypes", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(propertyEClass, Property.class, "Property", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProperty_IsOrdered(), theEcorePackage.getEBoolean(), "isOrdered", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_IsDerived(), theEcorePackage.getEBoolean(), "isDerived", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_LowerBound(), theEcorePackage.getEInt(), "lowerBound", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_UpperBound(), theEcorePackage.getEInt(), "upperBound", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_IsDependency(), theEcorePackage.getEBoolean(), "isDependency", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttribute_Definitions(), theEcorePackage.getEString(), "definitions", null, 0, -1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_Synonyms(), theEcorePackage.getEString(), "synonyms", null, 0, -1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_Text(), theEcorePackage.getEString(), "text", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_Stereotype(), this.getPrimitiveStereotype(), "stereotype", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttribute_Owner(), this.getType(), this.getType_Attributes(), "owner", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(generalizationSetEClass, GeneralizationSet.class, "GeneralizationSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGeneralizationSet_IsCovering(), theEcorePackage.getEBoolean(), "isCovering", null, 0, 1, GeneralizationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGeneralizationSet_SpecializedClassifier(), this.getClassifier(), this.getClassifier_IsSpecializedVia(), "specializedClassifier", null, 1, 1, GeneralizationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGeneralizationSet_SpecializingClassifier(), this.getClassifier(), this.getClassifier_SpecializesVia(), "specializingClassifier", null, 1, -1, GeneralizationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGeneralizationSet_HighOrder(), this.getClass_(), null, "highOrder", null, 0, 1, GeneralizationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalEClass, Literal.class, "Literal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLiteral_Value(), theEcorePackage.getEString(), "value", null, 0, 1, Literal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLiteral_Owner(), this.getDataType(), this.getDataType_Literals(), "owner", null, 1, 1, Literal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLiteral_UpperBoundRegion(), theEcorePackage.getEFloat(), "upperBoundRegion", null, 0, 1, Literal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLiteral_LowerBoundRegion(), theEcorePackage.getEFloat(), "lowerBoundRegion", null, 0, 1, Literal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataTypeEClass, DataType.class, "DataType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataType_Stereotype(), this.getDataTypeStereotype(), "stereotype", null, 0, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataType_Dimensions(), this.getDataType(), this.getDataType_OwnerDomain(), "dimensions", null, 0, -1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataType_Scale(), this.getScale(), "scale", null, 0, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataType_Measurement(), this.getMeasurement(), "measurement", null, 0, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataType_UnitOfMeasure(), theEcorePackage.getEString(), "unitOfMeasure", null, 0, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataType_LowerBoundRegion(), theEcorePackage.getEFloat(), "lowerBoundRegion", null, 0, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataType_UpperBoundRegion(), theEcorePackage.getEFloat(), "upperBoundRegion", null, 0, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataType_OwnerDomain(), this.getDataType(), this.getDataType_Dimensions(), "ownerDomain", null, 0, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataType_Literals(), this.getLiteral(), this.getLiteral_Owner(), "literals", null, 0, -1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataType_Structure(), this.getDataType(), null, "structure", null, 0, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getDataType__IsEnumeration(), theEcorePackage.getEBoolean(), "isEnumeration", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataType__IsDomain(), theEcorePackage.getEBoolean(), "isDomain", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataType__IsDimension(), theEcorePackage.getEBoolean(), "isDimension", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataType__IsDataType(), theEcorePackage.getEBoolean(), "isDataType", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataType__IsNominal(), theEcorePackage.getEBoolean(), "isNominal", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataType__IsInterval(), theEcorePackage.getEBoolean(), "isInterval", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataType__IsOrdinal(), theEcorePackage.getEBoolean(), "isOrdinal", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataType__IsRational(), theEcorePackage.getEBoolean(), "isRational", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataType__IsString(), theEcorePackage.getEBoolean(), "isString", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataType__IsInteger(), theEcorePackage.getEBoolean(), "isInteger", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataType__IsDecimal(), theEcorePackage.getEBoolean(), "isDecimal", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataType__IsReal(), theEcorePackage.getEBoolean(), "isReal", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataType__IsNominalString(), theEcorePackage.getEBoolean(), "isNominalString", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataType__IsIntervalInteger(), theEcorePackage.getEBoolean(), "isIntervalInteger", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataType__IsIntervalDecimal(), theEcorePackage.getEBoolean(), "isIntervalDecimal", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataType__IsOrdinalInteger(), theEcorePackage.getEBoolean(), "isOrdinalInteger", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataType__IsOrdinalDecimal(), theEcorePackage.getEBoolean(), "isOrdinalDecimal", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataType__IsRationalInteger(), theEcorePackage.getEBoolean(), "isRationalInteger", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataType__IsRationalDecimal(), theEcorePackage.getEBoolean(), "isRationalDecimal", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataType__IsIntervalReal(), theEcorePackage.getEBoolean(), "isIntervalReal", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataType__IsOrdinalReal(), theEcorePackage.getEBoolean(), "isOrdinalReal", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDataType__IsRationalReal(), theEcorePackage.getEBoolean(), "isRationalReal", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(classEClass, net.menthor.metamodel.ontouml.Class.class, "Class", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClass_Stereotype(), this.getClassStereotype(), "stereotype", null, 0, 1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClass_IsAbstract(), theEcorePackage.getEBoolean(), "isAbstract", null, 0, 1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClass_IsDerived(), theEcorePackage.getEBoolean(), "isDerived", null, 0, 1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClass_IsExtensional(), theEcorePackage.getEBoolean(), "isExtensional", null, 0, 1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClass_QualityNature(), this.getQualityNature(), "qualityNature", null, 0, 1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClass_Existence(), this.getExistence(), "existence", null, 0, 1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClass_Classification(), this.getClassification(), "classification", null, 0, 1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

		initEOperation(getClass__IsRigid(), theEcorePackage.getEBoolean(), "isRigid", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsNonRigid(), theEcorePackage.getEBoolean(), "isNonRigid", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsAntiRigid(), theEcorePackage.getEBoolean(), "isAntiRigid", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsSemiRigid(), theEcorePackage.getEBoolean(), "isSemiRigid", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsSubstanceSortalClass(), theEcorePackage.getEBoolean(), "isSubstanceSortalClass", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsMomentClass(), theEcorePackage.getEBoolean(), "isMomentClass", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsIdentityProviderClass(), theEcorePackage.getEBoolean(), "isIdentityProviderClass", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsMixinClass(), theEcorePackage.getEBoolean(), "isMixinClass", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsAntiRigidMixinClass(), theEcorePackage.getEBoolean(), "isAntiRigidMixinClass", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsAmountOfMatter(), theEcorePackage.getEBoolean(), "isAmountOfMatter", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsFunctionalComplex(), theEcorePackage.getEBoolean(), "isFunctionalComplex", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsCollection(), theEcorePackage.getEBoolean(), "isCollection", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsMoment(), theEcorePackage.getEBoolean(), "isMoment", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsTruthMaker(), theEcorePackage.getEBoolean(), "isTruthMaker", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IdentityProvidersAtAllParents(), this.getClass_(), "identityProvidersAtAllParents", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IdentityProvidersAtAllChildren(), this.getClass_(), "identityProvidersAtAllChildren", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IdentityProviders(), this.getClass_(), "identityProviders", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEClass(endPointEClass, EndPoint.class, "EndPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEndPoint_Owner(), this.getRelationship(), this.getRelationship_EndPoints(), "owner", null, 1, 1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEndPoint_EndType(), this.getClassifier(), null, "endType", null, 1, 1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEndPoint_Subsets(), this.getEndPoint(), this.getEndPoint_IsSubsettedBy(), "subsets", null, 0, -1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEndPoint_Redefines(), this.getEndPoint(), this.getEndPoint_IsRedefinedBy(), "redefines", null, 0, -1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEndPoint_IsSubsettedBy(), this.getEndPoint(), this.getEndPoint_Subsets(), "isSubsettedBy", null, 0, -1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEndPoint_IsRedefinedBy(), this.getEndPoint(), this.getEndPoint_Redefines(), "isRedefinedBy", null, 0, -1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(relationshipEClass, Relationship.class, "Relationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelationship_Stereotype(), this.getRelationshipStereotype(), "stereotype", null, 0, 1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationship_Reflexivity(), this.getReflexivity(), "reflexivity", null, 0, 1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationship_Symmetry(), this.getSymmetry(), "symmetry", null, 0, 1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationship_Transitivity(), this.getTransitivity(), "transitivity", null, 0, 1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationship_Ciclicity(), this.getCiclicity(), "ciclicity", null, 0, 1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationship_EndPoints(), this.getEndPoint(), this.getEndPoint_Owner(), "endPoints", null, 0, -1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationship_TemporalNature(), this.getTemporalNature(), "temporalNature", null, 0, 1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationship_ParticipationNature(), this.getParticipationNature(), "participationNature", null, 0, 1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

		initEOperation(getRelationship__IsInstanceOf(), theEcorePackage.getEBoolean(), "isInstanceOf", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsMeronymic(), theEcorePackage.getEBoolean(), "isMeronymic", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsBinary(), theEcorePackage.getEBoolean(), "isBinary", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsTernary(), theEcorePackage.getEBoolean(), "isTernary", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsStarts(), theEcorePackage.getEBoolean(), "isStarts", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsPrecedes(), theEcorePackage.getEBoolean(), "isPrecedes", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsEquals(), theEcorePackage.getEBoolean(), "isEquals", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsMeets(), theEcorePackage.getEBoolean(), "isMeets", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsFinishes(), theEcorePackage.getEBoolean(), "isFinishes", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsOverlaps(), theEcorePackage.getEBoolean(), "isOverlaps", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsDuring(), theEcorePackage.getEBoolean(), "isDuring", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsCreation(), theEcorePackage.getEBoolean(), "isCreation", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsDestruction(), theEcorePackage.getEBoolean(), "isDestruction", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsChange(), theEcorePackage.getEBoolean(), "isChange", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__SourceEnd(), this.getEndPoint(), "sourceEnd", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__TargetEnd(), this.getEndPoint(), "targetEnd", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__Source(), this.getClassifier(), "source", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__Target(), this.getClassifier(), "target", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__SourceClass(), this.getClass_(), "sourceClass", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__TargetClass(), this.getClass_(), "targetClass", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__SourceDataType(), this.getDataType(), "sourceDataType", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__TargetDataType(), this.getDataType(), "targetDataType", 0, 1, !IS_UNIQUE, IS_ORDERED);

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

		initEOperation(getRelationship__IsPartShareable(), theEcorePackage.getEBoolean(), "isPartShareable", 0, 1, !IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(primitiveStereotypeEEnum, PrimitiveStereotype.class, "PrimitiveStereotype");
		addEEnumLiteral(primitiveStereotypeEEnum, PrimitiveStereotype.BOOLEAN);
		addEEnumLiteral(primitiveStereotypeEEnum, PrimitiveStereotype.STRING);
		addEEnumLiteral(primitiveStereotypeEEnum, PrimitiveStereotype.REAL);
		addEEnumLiteral(primitiveStereotypeEEnum, PrimitiveStereotype.INTEGER);
		addEEnumLiteral(primitiveStereotypeEEnum, PrimitiveStereotype.DATE);
		addEEnumLiteral(primitiveStereotypeEEnum, PrimitiveStereotype.DATE_TIME);

		initEEnum(classStereotypeEEnum, ClassStereotype.class, "ClassStereotype");
		addEEnumLiteral(classStereotypeEEnum, ClassStereotype.KIND);
		addEEnumLiteral(classStereotypeEEnum, ClassStereotype.COLLECTIVE);
		addEEnumLiteral(classStereotypeEEnum, ClassStereotype.QUANTITY);
		addEEnumLiteral(classStereotypeEEnum, ClassStereotype.RELATOR);
		addEEnumLiteral(classStereotypeEEnum, ClassStereotype.MODE);
		addEEnumLiteral(classStereotypeEEnum, ClassStereotype.QUALITY);
		addEEnumLiteral(classStereotypeEEnum, ClassStereotype.ROLE);
		addEEnumLiteral(classStereotypeEEnum, ClassStereotype.PHASE);
		addEEnumLiteral(classStereotypeEEnum, ClassStereotype.SUB_KIND);
		addEEnumLiteral(classStereotypeEEnum, ClassStereotype.CATEGORY);
		addEEnumLiteral(classStereotypeEEnum, ClassStereotype.MIXIN);
		addEEnumLiteral(classStereotypeEEnum, ClassStereotype.ROLE_MIXIN);
		addEEnumLiteral(classStereotypeEEnum, ClassStereotype.PHASE_MIXIN);
		addEEnumLiteral(classStereotypeEEnum, ClassStereotype.EVENT);
		addEEnumLiteral(classStereotypeEEnum, ClassStereotype.HIGH_ORDER);

		initEEnum(dataTypeStereotypeEEnum, DataTypeStereotype.class, "DataTypeStereotype");
		addEEnumLiteral(dataTypeStereotypeEEnum, DataTypeStereotype.DOMAIN);
		addEEnumLiteral(dataTypeStereotypeEEnum, DataTypeStereotype.DIMENSION);
		addEEnumLiteral(dataTypeStereotypeEEnum, DataTypeStereotype.ENUMERATION);
		addEEnumLiteral(dataTypeStereotypeEEnum, DataTypeStereotype.DATA_TYPE);

		initEEnum(scaleEEnum, Scale.class, "Scale");
		addEEnumLiteral(scaleEEnum, Scale.INTERVAL);
		addEEnumLiteral(scaleEEnum, Scale.RATIONAL);
		addEEnumLiteral(scaleEEnum, Scale.ORDINAL);
		addEEnumLiteral(scaleEEnum, Scale.NOMINAL);

		initEEnum(measurementEEnum, Measurement.class, "Measurement");
		addEEnumLiteral(measurementEEnum, Measurement.INTEGER);
		addEEnumLiteral(measurementEEnum, Measurement.REAL);
		addEEnumLiteral(measurementEEnum, Measurement.DECIMAL);
		addEEnumLiteral(measurementEEnum, Measurement.STRING);

		initEEnum(qualityNatureEEnum, QualityNature.class, "QualityNature");
		addEEnumLiteral(qualityNatureEEnum, QualityNature.NOMINAL);
		addEEnumLiteral(qualityNatureEEnum, QualityNature.PERCEIVABLE);
		addEEnumLiteral(qualityNatureEEnum, QualityNature.NON_PERCEIVABLE);

		initEEnum(classificationEEnum, Classification.class, "Classification");
		addEEnumLiteral(classificationEEnum, Classification.INITIAL);
		addEEnumLiteral(classificationEEnum, Classification.FINAL);

		initEEnum(existenceEEnum, Existence.class, "Existence");
		addEEnumLiteral(existenceEEnum, Existence.PERMANENT);
		addEEnumLiteral(existenceEEnum, Existence.TRANSIENT);
		addEEnumLiteral(existenceEEnum, Existence.ETERNAL);

		initEEnum(relationshipStereotypeEEnum, RelationshipStereotype.class, "RelationshipStereotype");
		addEEnumLiteral(relationshipStereotypeEEnum, RelationshipStereotype.COMPONENT_OF);
		addEEnumLiteral(relationshipStereotypeEEnum, RelationshipStereotype.MEMBER_OF);
		addEEnumLiteral(relationshipStereotypeEEnum, RelationshipStereotype.SUB_COLLECTION_OF);
		addEEnumLiteral(relationshipStereotypeEEnum, RelationshipStereotype.SUB_QUANTITY_OF);
		addEEnumLiteral(relationshipStereotypeEEnum, RelationshipStereotype.CONSTITUTION);
		addEEnumLiteral(relationshipStereotypeEEnum, RelationshipStereotype.CHARACTERIZATION);
		addEEnumLiteral(relationshipStereotypeEEnum, RelationshipStereotype.MEDIATION);
		addEEnumLiteral(relationshipStereotypeEEnum, RelationshipStereotype.MATERIAL);
		addEEnumLiteral(relationshipStereotypeEEnum, RelationshipStereotype.FORMAL);
		addEEnumLiteral(relationshipStereotypeEEnum, RelationshipStereotype.DERIVATION);
		addEEnumLiteral(relationshipStereotypeEEnum, RelationshipStereotype.STRUCTURATION);
		addEEnumLiteral(relationshipStereotypeEEnum, RelationshipStereotype.PARTICIPATION);
		addEEnumLiteral(relationshipStereotypeEEnum, RelationshipStereotype.SUB_EVENT_OF);
		addEEnumLiteral(relationshipStereotypeEEnum, RelationshipStereotype.CAUSATION);
		addEEnumLiteral(relationshipStereotypeEEnum, RelationshipStereotype.TEMPORAL);
		addEEnumLiteral(relationshipStereotypeEEnum, RelationshipStereotype.INSTANCE_OF);

		initEEnum(temporalNatureEEnum, TemporalNature.class, "TemporalNature");
		addEEnumLiteral(temporalNatureEEnum, TemporalNature.STARTS);
		addEEnumLiteral(temporalNatureEEnum, TemporalNature.PRECEDES);
		addEEnumLiteral(temporalNatureEEnum, TemporalNature.EQUALS);
		addEEnumLiteral(temporalNatureEEnum, TemporalNature.MEETS);
		addEEnumLiteral(temporalNatureEEnum, TemporalNature.FINISHES);
		addEEnumLiteral(temporalNatureEEnum, TemporalNature.OVERLAPS);
		addEEnumLiteral(temporalNatureEEnum, TemporalNature.DURING);

		initEEnum(participationNatureEEnum, ParticipationNature.class, "ParticipationNature");
		addEEnumLiteral(participationNatureEEnum, ParticipationNature.CREATION);
		addEEnumLiteral(participationNatureEEnum, ParticipationNature.CHANGE);
		addEEnumLiteral(participationNatureEEnum, ParticipationNature.DESTRUCTION);

		initEEnum(reflexivityEEnum, Reflexivity.class, "Reflexivity");
		addEEnumLiteral(reflexivityEEnum, Reflexivity.REFLEXIVE);
		addEEnumLiteral(reflexivityEEnum, Reflexivity.IRREFLEXIVE);
		addEEnumLiteral(reflexivityEEnum, Reflexivity.NON_REFLEXIVE);

		initEEnum(symmetryEEnum, Symmetry.class, "Symmetry");
		addEEnumLiteral(symmetryEEnum, Symmetry.SYMMETRIC);
		addEEnumLiteral(symmetryEEnum, Symmetry.ASSYMETRIC);
		addEEnumLiteral(symmetryEEnum, Symmetry.ANTI_SYMMETRIC);
		addEEnumLiteral(symmetryEEnum, Symmetry.NON_SYMMETRIC);

		initEEnum(transitivityEEnum, Transitivity.class, "Transitivity");
		addEEnumLiteral(transitivityEEnum, Transitivity.TRANSITIVE);
		addEEnumLiteral(transitivityEEnum, Transitivity.INTRANSITIVE);
		addEEnumLiteral(transitivityEEnum, Transitivity.NON_TRANSITIVE);

		initEEnum(ciclicityEEnum, Ciclicity.class, "Ciclicity");
		addEEnumLiteral(ciclicityEEnum, Ciclicity.CYCLIC);
		addEEnumLiteral(ciclicityEEnum, Ciclicity.ACYCLIC);
		addEEnumLiteral(ciclicityEEnum, Ciclicity.NON_CYCLIC);

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
