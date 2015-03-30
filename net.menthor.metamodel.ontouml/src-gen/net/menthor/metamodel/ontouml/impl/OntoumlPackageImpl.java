/**
 */
package net.menthor.metamodel.ontouml.impl;

import net.menthor.metamodel.ontouml.AllenRelation;
import net.menthor.metamodel.ontouml.Attribute;
import net.menthor.metamodel.ontouml.BinaryClassRelationship;
import net.menthor.metamodel.ontouml.BinaryRelationship;
import net.menthor.metamodel.ontouml.ClassifierElement;
import net.menthor.metamodel.ontouml.Comment;
import net.menthor.metamodel.ontouml.ContainedElement;
import net.menthor.metamodel.ontouml.DerivationRelationship;
import net.menthor.metamodel.ontouml.DimensionType;
import net.menthor.metamodel.ontouml.Element;
import net.menthor.metamodel.ontouml.EndPoint;
import net.menthor.metamodel.ontouml.GeneralizationSet;
import net.menthor.metamodel.ontouml.MeasurementDimension;
import net.menthor.metamodel.ontouml.MeasurementDomain;
import net.menthor.metamodel.ontouml.MeasurementEnumeration;
import net.menthor.metamodel.ontouml.MeasurementRegion;
import net.menthor.metamodel.ontouml.MeasurementType;
import net.menthor.metamodel.ontouml.Model;
import net.menthor.metamodel.ontouml.NAryClassRelationship;
import net.menthor.metamodel.ontouml.NamedElement;
import net.menthor.metamodel.ontouml.NominalDimension;
import net.menthor.metamodel.ontouml.OntoumlFactory;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.Primitive;
import net.menthor.metamodel.ontouml.PrimitiveType;
import net.menthor.metamodel.ontouml.Property;
import net.menthor.metamodel.ontouml.Quality;
import net.menthor.metamodel.ontouml.Region;
import net.menthor.metamodel.ontouml.Relation;
import net.menthor.metamodel.ontouml.Relationship;
import net.menthor.metamodel.ontouml.StringNominalRegion;
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
	private EClass classifierElementEClass = null;

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
	private EClass endPointEClass = null;

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
	private EClass primitiveTypeEClass = null;

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
	private EClass binaryRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryClassRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass derivationRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nAryClassRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measurementDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measurementDimensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nominalDimensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measurementRegionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringNominalRegionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measurementEnumerationEClass = null;

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
	private EEnum relationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum allenRelationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dimensionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum measurementTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum regionEEnum = null;

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
	public EClass getClassifierElement() {
		return classifierElementEClass;
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
	public EAttribute getClass_QualityType() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClass_EnumerationLiterals() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClass_IsAbstract() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClass_IsDerived() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClass_IsExtensional() {
		return (EAttribute)classEClass.getEStructuralFeatures().get(5);
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
	public EReference getClass_IstruthMakerOf() {
		return (EReference)classEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_InstanceOf() {
		return (EReference)classEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_IsSpecializedVia() {
		return (EReference)classEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_SpecializesVia() {
		return (EReference)classEClass.getEStructuralFeatures().get(10);
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
	public EOperation getClass__Children() {
		return classEClass.getEOperations().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__Parents() {
		return classEClass.getEOperations().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IdentidyProvider() {
		return classEClass.getEOperations().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsFunctionalComplex() {
		return classEClass.getEOperations().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsCollection() {
		return classEClass.getEOperations().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsAmountOfMatter() {
		return classEClass.getEOperations().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsIntrinsic() {
		return classEClass.getEOperations().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__IsTruthMaker() {
		return classEClass.getEOperations().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getClass__SetIsExtensional() {
		return classEClass.getEOperations().get(28);
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
	public EAttribute getProperty_IsDependee() {
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
	public EReference getAttribute_PrimitiveType() {
		return (EReference)attributeEClass.getEStructuralFeatures().get(1);
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
	public EAttribute getPrimitiveType_Primitive() {
		return (EAttribute)primitiveTypeEClass.getEStructuralFeatures().get(0);
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
	public EReference getRelationship_TruthMaker() {
		return (EReference)relationshipEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsShareable() {
		return relationshipEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsComponentOf() {
		return relationshipEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsMemberOf() {
		return relationshipEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsSubCollectionOf() {
		return relationshipEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsSubQuantityOf() {
		return relationshipEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsConstitution() {
		return relationshipEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsCharacterization() {
		return relationshipEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsMediation() {
		return relationshipEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsMaterial() {
		return relationshipEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsFormal() {
		return relationshipEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsStructuration() {
		return relationshipEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsParticipation() {
		return relationshipEClass.getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsSubEventOf() {
		return relationshipEClass.getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsCausation() {
		return relationshipEClass.getEOperations().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getRelationship__IsTemporal() {
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
	public EClass getBinaryRelationship() {
		return binaryRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryRelationship__SourceEndPoint() {
		return binaryRelationshipEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryRelationship__TargetEndPoint() {
		return binaryRelationshipEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryRelationship__IsDerived() {
		return binaryRelationshipEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryClassRelationship() {
		return binaryClassRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryClassRelationship__SourceClass() {
		return binaryClassRelationshipEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryClassRelationship__TargetClass() {
		return binaryClassRelationshipEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryClassRelationship__IsPartEssential() {
		return binaryClassRelationshipEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryClassRelationship__IsPartInseparable() {
		return binaryClassRelationshipEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryClassRelationship__IsPartImmutable() {
		return binaryClassRelationshipEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryClassRelationship__IsWholeImmutable() {
		return binaryClassRelationshipEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryClassRelationship__IsPartMandatory() {
		return binaryClassRelationshipEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryClassRelationship__IsWholeMandatory() {
		return binaryClassRelationshipEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDerivationRelationship() {
		return derivationRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDerivationRelationship__SourceRelationship() {
		return derivationRelationshipEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDerivationRelationship__TargetClass() {
		return derivationRelationshipEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNAryClassRelationship() {
		return nAryClassRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeasurementDomain() {
		return measurementDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasurementDomain_Dimensions() {
		return (EReference)measurementDomainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeasurementDimension() {
		return measurementDimensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasurementDimension_LowerBound() {
		return (EAttribute)measurementDimensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasurementDimension_UpperBound() {
		return (EAttribute)measurementDimensionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasurementDimension_UnitOfMeasure() {
		return (EAttribute)measurementDimensionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasurementDimension_Dimension() {
		return (EAttribute)measurementDimensionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasurementDimension_Measurement() {
		return (EAttribute)measurementDimensionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasurementDimension_Owner() {
		return (EReference)measurementDimensionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNominalDimension() {
		return nominalDimensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeasurementRegion() {
		return measurementRegionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasurementRegion_Region() {
		return (EAttribute)measurementRegionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringNominalRegion() {
		return stringNominalRegionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeasurementEnumeration() {
		return measurementEnumerationEClass;
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
	public EEnum getRelation() {
		return relationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAllenRelation() {
		return allenRelationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDimensionType() {
		return dimensionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMeasurementType() {
		return measurementTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRegion() {
		return regionEEnum;
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

		containedElementEClass = createEClass(CONTAINED_ELEMENT);
		createEReference(containedElementEClass, CONTAINED_ELEMENT__HOLDER);
		createEReference(containedElementEClass, CONTAINED_ELEMENT__COMMENTS);

		commentEClass = createEClass(COMMENT);
		createEAttribute(commentEClass, COMMENT__CONTENT);
		createEReference(commentEClass, COMMENT__OWNER);

		modelEClass = createEClass(MODEL);

		packageEClass = createEClass(PACKAGE);

		classifierElementEClass = createEClass(CLASSIFIER_ELEMENT);

		classEClass = createEClass(CLASS);
		createEAttribute(classEClass, CLASS__STEREOTYPE);
		createEAttribute(classEClass, CLASS__QUALITY_TYPE);
		createEAttribute(classEClass, CLASS__ENUMERATION_LITERALS);
		createEAttribute(classEClass, CLASS__IS_ABSTRACT);
		createEAttribute(classEClass, CLASS__IS_DERIVED);
		createEAttribute(classEClass, CLASS__IS_EXTENSIONAL);
		createEReference(classEClass, CLASS__ATTRIBUTES);
		createEReference(classEClass, CLASS__ISTRUTH_MAKER_OF);
		createEReference(classEClass, CLASS__INSTANCE_OF);
		createEReference(classEClass, CLASS__IS_SPECIALIZED_VIA);
		createEReference(classEClass, CLASS__SPECIALIZES_VIA);
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
		createEOperation(classEClass, CLASS___CHILDREN);
		createEOperation(classEClass, CLASS___PARENTS);
		createEOperation(classEClass, CLASS___IDENTIDY_PROVIDER);
		createEOperation(classEClass, CLASS___IS_FUNCTIONAL_COMPLEX);
		createEOperation(classEClass, CLASS___IS_COLLECTION);
		createEOperation(classEClass, CLASS___IS_AMOUNT_OF_MATTER);
		createEOperation(classEClass, CLASS___IS_INTRINSIC);
		createEOperation(classEClass, CLASS___IS_TRUTH_MAKER);
		createEOperation(classEClass, CLASS___SET_IS_EXTENSIONAL);

		generalizationSetEClass = createEClass(GENERALIZATION_SET);
		createEAttribute(generalizationSetEClass, GENERALIZATION_SET__IS_COVERING);
		createEReference(generalizationSetEClass, GENERALIZATION_SET__SPECIALIZED_CLASS);
		createEReference(generalizationSetEClass, GENERALIZATION_SET__SPECIALIZING_CLASSES);
		createEReference(generalizationSetEClass, GENERALIZATION_SET__HOU);

		propertyEClass = createEClass(PROPERTY);
		createEAttribute(propertyEClass, PROPERTY__IS_ORDERED);
		createEAttribute(propertyEClass, PROPERTY__IS_DERIVED);
		createEAttribute(propertyEClass, PROPERTY__LOWER_BOUND);
		createEAttribute(propertyEClass, PROPERTY__UPPER_BOUND);
		createEAttribute(propertyEClass, PROPERTY__IS_DEPENDEE);

		endPointEClass = createEClass(END_POINT);
		createEReference(endPointEClass, END_POINT__OWNER);
		createEReference(endPointEClass, END_POINT__END_TYPE);
		createEReference(endPointEClass, END_POINT__SUBSETS);
		createEReference(endPointEClass, END_POINT__REDEFINES);
		createEReference(endPointEClass, END_POINT__IS_SUBSETTED_BY);
		createEReference(endPointEClass, END_POINT__IS_REDEFINED_BY);

		attributeEClass = createEClass(ATTRIBUTE);
		createEReference(attributeEClass, ATTRIBUTE__OWNER);
		createEReference(attributeEClass, ATTRIBUTE__PRIMITIVE_TYPE);

		primitiveTypeEClass = createEClass(PRIMITIVE_TYPE);
		createEAttribute(primitiveTypeEClass, PRIMITIVE_TYPE__PRIMITIVE);

		relationshipEClass = createEClass(RELATIONSHIP);
		createEAttribute(relationshipEClass, RELATIONSHIP__STEREOTYPE);
		createEAttribute(relationshipEClass, RELATIONSHIP__ALLEN_RELATION);
		createEReference(relationshipEClass, RELATIONSHIP__END_POINTS);
		createEReference(relationshipEClass, RELATIONSHIP__TRUTH_MAKER);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_SHAREABLE);
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
		createEOperation(relationshipEClass, RELATIONSHIP___IS_STARTS);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_PRECEDES);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_EQUALS);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_MEETS);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_FINISHES);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_OVERLAPS);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_DURING);
		createEOperation(relationshipEClass, RELATIONSHIP___IS_MERONYMIC);

		binaryRelationshipEClass = createEClass(BINARY_RELATIONSHIP);
		createEOperation(binaryRelationshipEClass, BINARY_RELATIONSHIP___SOURCE_END_POINT);
		createEOperation(binaryRelationshipEClass, BINARY_RELATIONSHIP___TARGET_END_POINT);
		createEOperation(binaryRelationshipEClass, BINARY_RELATIONSHIP___IS_DERIVED);

		binaryClassRelationshipEClass = createEClass(BINARY_CLASS_RELATIONSHIP);
		createEOperation(binaryClassRelationshipEClass, BINARY_CLASS_RELATIONSHIP___SOURCE_CLASS);
		createEOperation(binaryClassRelationshipEClass, BINARY_CLASS_RELATIONSHIP___TARGET_CLASS);
		createEOperation(binaryClassRelationshipEClass, BINARY_CLASS_RELATIONSHIP___IS_PART_ESSENTIAL);
		createEOperation(binaryClassRelationshipEClass, BINARY_CLASS_RELATIONSHIP___IS_PART_INSEPARABLE);
		createEOperation(binaryClassRelationshipEClass, BINARY_CLASS_RELATIONSHIP___IS_PART_IMMUTABLE);
		createEOperation(binaryClassRelationshipEClass, BINARY_CLASS_RELATIONSHIP___IS_WHOLE_IMMUTABLE);
		createEOperation(binaryClassRelationshipEClass, BINARY_CLASS_RELATIONSHIP___IS_PART_MANDATORY);
		createEOperation(binaryClassRelationshipEClass, BINARY_CLASS_RELATIONSHIP___IS_WHOLE_MANDATORY);

		derivationRelationshipEClass = createEClass(DERIVATION_RELATIONSHIP);
		createEOperation(derivationRelationshipEClass, DERIVATION_RELATIONSHIP___SOURCE_RELATIONSHIP);
		createEOperation(derivationRelationshipEClass, DERIVATION_RELATIONSHIP___TARGET_CLASS);

		nAryClassRelationshipEClass = createEClass(NARY_CLASS_RELATIONSHIP);

		measurementDomainEClass = createEClass(MEASUREMENT_DOMAIN);
		createEReference(measurementDomainEClass, MEASUREMENT_DOMAIN__DIMENSIONS);

		measurementDimensionEClass = createEClass(MEASUREMENT_DIMENSION);
		createEAttribute(measurementDimensionEClass, MEASUREMENT_DIMENSION__LOWER_BOUND);
		createEAttribute(measurementDimensionEClass, MEASUREMENT_DIMENSION__UPPER_BOUND);
		createEAttribute(measurementDimensionEClass, MEASUREMENT_DIMENSION__UNIT_OF_MEASURE);
		createEAttribute(measurementDimensionEClass, MEASUREMENT_DIMENSION__DIMENSION);
		createEAttribute(measurementDimensionEClass, MEASUREMENT_DIMENSION__MEASUREMENT);
		createEReference(measurementDimensionEClass, MEASUREMENT_DIMENSION__OWNER);

		nominalDimensionEClass = createEClass(NOMINAL_DIMENSION);

		measurementRegionEClass = createEClass(MEASUREMENT_REGION);
		createEAttribute(measurementRegionEClass, MEASUREMENT_REGION__REGION);

		stringNominalRegionEClass = createEClass(STRING_NOMINAL_REGION);

		measurementEnumerationEClass = createEClass(MEASUREMENT_ENUMERATION);

		// Create enums
		universalEEnum = createEEnum(UNIVERSAL);
		qualityEEnum = createEEnum(QUALITY);
		primitiveEEnum = createEEnum(PRIMITIVE);
		relationEEnum = createEEnum(RELATION);
		allenRelationEEnum = createEEnum(ALLEN_RELATION);
		dimensionTypeEEnum = createEEnum(DIMENSION_TYPE);
		measurementTypeEEnum = createEEnum(MEASUREMENT_TYPE);
		regionEEnum = createEEnum(REGION);
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
		classifierElementEClass.getESuperTypes().add(this.getContainedElement());
		classEClass.getESuperTypes().add(this.getNamedElement());
		classEClass.getESuperTypes().add(this.getClassifierElement());
		generalizationSetEClass.getESuperTypes().add(this.getNamedElement());
		generalizationSetEClass.getESuperTypes().add(this.getContainedElement());
		propertyEClass.getESuperTypes().add(this.getNamedElement());
		endPointEClass.getESuperTypes().add(this.getProperty());
		attributeEClass.getESuperTypes().add(this.getProperty());
		primitiveTypeEClass.getESuperTypes().add(this.getContainedElement());
		relationshipEClass.getESuperTypes().add(this.getClassifierElement());
		binaryRelationshipEClass.getESuperTypes().add(this.getRelationship());
		binaryClassRelationshipEClass.getESuperTypes().add(this.getNamedElement());
		binaryClassRelationshipEClass.getESuperTypes().add(this.getBinaryRelationship());
		derivationRelationshipEClass.getESuperTypes().add(this.getBinaryRelationship());
		nAryClassRelationshipEClass.getESuperTypes().add(this.getNamedElement());
		nAryClassRelationshipEClass.getESuperTypes().add(this.getRelationship());
		measurementDomainEClass.getESuperTypes().add(this.getNamedElement());
		measurementDomainEClass.getESuperTypes().add(this.getContainedElement());
		measurementDimensionEClass.getESuperTypes().add(this.getNamedElement());
		measurementDimensionEClass.getESuperTypes().add(this.getContainedElement());
		nominalDimensionEClass.getESuperTypes().add(this.getNamedElement());
		nominalDimensionEClass.getESuperTypes().add(this.getContainedElement());
		measurementRegionEClass.getESuperTypes().add(this.getNamedElement());
		measurementRegionEClass.getESuperTypes().add(this.getContainedElement());
		stringNominalRegionEClass.getESuperTypes().add(this.getNamedElement());
		stringNominalRegionEClass.getESuperTypes().add(this.getContainedElement());
		measurementEnumerationEClass.getESuperTypes().add(this.getNamedElement());
		measurementEnumerationEClass.getESuperTypes().add(this.getContainedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(elementEClass, Element.class, "Element", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), theEcorePackage.getEString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(containerEClass, net.menthor.metamodel.ontouml.Container.class, "Container", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainer_Elements(), this.getContainedElement(), this.getContainedElement_Holder(), "elements", null, 0, -1, net.menthor.metamodel.ontouml.Container.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(containedElementEClass, ContainedElement.class, "ContainedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainedElement_Holder(), this.getContainer(), this.getContainer_Elements(), "holder", null, 1, 1, ContainedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContainedElement_Comments(), this.getComment(), this.getComment_Owner(), "comments", null, 0, -1, ContainedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(commentEClass, Comment.class, "Comment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComment_Content(), theEcorePackage.getEString(), "content", null, 0, 1, Comment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComment_Owner(), this.getContainedElement(), this.getContainedElement_Comments(), "owner", null, 1, 1, Comment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(packageEClass, net.menthor.metamodel.ontouml.Package.class, "Package", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classifierElementEClass, ClassifierElement.class, "ClassifierElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classEClass, net.menthor.metamodel.ontouml.Class.class, "Class", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClass_Stereotype(), this.getUniversal(), "stereotype", null, 0, 1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClass_QualityType(), this.getQuality(), "qualityType", null, 0, 1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClass_EnumerationLiterals(), theEcorePackage.getEString(), "enumerationLiterals", null, 0, -1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClass_IsAbstract(), theEcorePackage.getEBoolean(), "isAbstract", null, 0, 1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClass_IsDerived(), theEcorePackage.getEBoolean(), "isDerived", null, 0, 1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClass_IsExtensional(), theEcorePackage.getEBoolean(), "isExtensional", null, 0, 1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getClass_Attributes(), this.getAttribute(), this.getAttribute_Owner(), "attributes", null, 0, -1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClass_IstruthMakerOf(), this.getRelationship(), this.getRelationship_TruthMaker(), "istruthMakerOf", null, 0, -1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClass_InstanceOf(), this.getClass_(), null, "instanceOf", null, 0, -1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClass_IsSpecializedVia(), this.getGeneralizationSet(), this.getGeneralizationSet_SpecializedClass(), "isSpecializedVia", null, 0, -1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClass_SpecializesVia(), this.getGeneralizationSet(), this.getGeneralizationSet_SpecializingClasses(), "specializesVia", null, 0, -1, net.menthor.metamodel.ontouml.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

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

		initEOperation(getClass__Children(), this.getClass_(), "children", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__Parents(), this.getClass_(), "parents", 0, -1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IdentidyProvider(), null, "identidyProvider", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsFunctionalComplex(), null, "isFunctionalComplex", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsCollection(), null, "isCollection", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsAmountOfMatter(), null, "isAmountOfMatter", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsIntrinsic(), null, "isIntrinsic", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__IsTruthMaker(), theEcorePackage.getEBoolean(), "isTruthMaker", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getClass__SetIsExtensional(), null, "setIsExtensional", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(generalizationSetEClass, GeneralizationSet.class, "GeneralizationSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGeneralizationSet_IsCovering(), theEcorePackage.getEBoolean(), "isCovering", null, 0, 1, GeneralizationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGeneralizationSet_SpecializedClass(), this.getClass_(), this.getClass_IsSpecializedVia(), "specializedClass", null, 1, 1, GeneralizationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGeneralizationSet_SpecializingClasses(), this.getClass_(), this.getClass_SpecializesVia(), "specializingClasses", null, 1, -1, GeneralizationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGeneralizationSet_Hou(), this.getClass_(), null, "hou", null, 0, 1, GeneralizationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyEClass, Property.class, "Property", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProperty_IsOrdered(), theEcorePackage.getEBoolean(), "isOrdered", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_IsDerived(), theEcorePackage.getEBoolean(), "isDerived", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_LowerBound(), theEcorePackage.getEInt(), "lowerBound", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_UpperBound(), theEcorePackage.getEInt(), "upperBound", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_IsDependee(), theEcorePackage.getEBoolean(), "isDependee", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(endPointEClass, EndPoint.class, "EndPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEndPoint_Owner(), this.getRelationship(), this.getRelationship_EndPoints(), "owner", null, 1, 1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEndPoint_EndType(), this.getClassifierElement(), null, "endType", null, 1, 1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEndPoint_Subsets(), this.getEndPoint(), this.getEndPoint_IsSubsettedBy(), "subsets", null, 0, -1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEndPoint_Redefines(), this.getEndPoint(), this.getEndPoint_IsRedefinedBy(), "redefines", null, 0, -1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEndPoint_IsSubsettedBy(), this.getEndPoint(), this.getEndPoint_Subsets(), "isSubsettedBy", null, 0, -1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEndPoint_IsRedefinedBy(), this.getEndPoint(), this.getEndPoint_Redefines(), "isRedefinedBy", null, 0, -1, EndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttribute_Owner(), this.getClass_(), this.getClass_Attributes(), "owner", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttribute_PrimitiveType(), this.getPrimitiveType(), null, "primitiveType", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveTypeEClass, PrimitiveType.class, "PrimitiveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimitiveType_Primitive(), this.getPrimitive(), "primitive", null, 1, 1, PrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationshipEClass, Relationship.class, "Relationship", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelationship_Stereotype(), this.getRelation(), "stereotype", null, 0, 1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationship_AllenRelation(), this.getAllenRelation(), "allenRelation", null, 0, 1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationship_EndPoints(), this.getEndPoint(), this.getEndPoint_Owner(), "endPoints", null, 0, -1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationship_TruthMaker(), this.getClass_(), this.getClass_IstruthMakerOf(), "truthMaker", null, 0, 1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getRelationship__IsShareable(), null, "isShareable", 0, 1, !IS_UNIQUE, IS_ORDERED);

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

		initEOperation(getRelationship__IsStarts(), theEcorePackage.getEBoolean(), "isStarts", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsPrecedes(), theEcorePackage.getEBoolean(), "isPrecedes", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsEquals(), theEcorePackage.getEBoolean(), "isEquals", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsMeets(), theEcorePackage.getEBoolean(), "isMeets", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsFinishes(), theEcorePackage.getEBoolean(), "isFinishes", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsOverlaps(), theEcorePackage.getEBoolean(), "isOverlaps", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsDuring(), theEcorePackage.getEBoolean(), "isDuring", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getRelationship__IsMeronymic(), theEcorePackage.getEBoolean(), "isMeronymic", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(binaryRelationshipEClass, BinaryRelationship.class, "BinaryRelationship", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getBinaryRelationship__SourceEndPoint(), this.getEndPoint(), "sourceEndPoint", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getBinaryRelationship__TargetEndPoint(), this.getEndPoint(), "targetEndPoint", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getBinaryRelationship__IsDerived(), theEcorePackage.getEBoolean(), "isDerived", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(binaryClassRelationshipEClass, BinaryClassRelationship.class, "BinaryClassRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getBinaryClassRelationship__SourceClass(), this.getClass_(), "sourceClass", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getBinaryClassRelationship__TargetClass(), this.getClass_(), "targetClass", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getBinaryClassRelationship__IsPartEssential(), theEcorePackage.getEBoolean(), "isPartEssential", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getBinaryClassRelationship__IsPartInseparable(), theEcorePackage.getEBoolean(), "isPartInseparable", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getBinaryClassRelationship__IsPartImmutable(), theEcorePackage.getEBoolean(), "isPartImmutable", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getBinaryClassRelationship__IsWholeImmutable(), theEcorePackage.getEBoolean(), "isWholeImmutable", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getBinaryClassRelationship__IsPartMandatory(), theEcorePackage.getEBoolean(), "isPartMandatory", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getBinaryClassRelationship__IsWholeMandatory(), theEcorePackage.getEBoolean(), "isWholeMandatory", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(derivationRelationshipEClass, DerivationRelationship.class, "DerivationRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getDerivationRelationship__SourceRelationship(), this.getBinaryClassRelationship(), "sourceRelationship", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEOperation(getDerivationRelationship__TargetClass(), this.getClass_(), "targetClass", 0, 1, !IS_UNIQUE, IS_ORDERED);

		initEClass(nAryClassRelationshipEClass, NAryClassRelationship.class, "NAryClassRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(measurementDomainEClass, MeasurementDomain.class, "MeasurementDomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMeasurementDomain_Dimensions(), this.getMeasurementDimension(), this.getMeasurementDimension_Owner(), "dimensions", null, 2, -1, MeasurementDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(measurementDimensionEClass, MeasurementDimension.class, "MeasurementDimension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMeasurementDimension_LowerBound(), theEcorePackage.getEInt(), "lowerBound", null, 1, 1, MeasurementDimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasurementDimension_UpperBound(), theEcorePackage.getEInt(), "upperBound", null, 1, 1, MeasurementDimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasurementDimension_UnitOfMeasure(), theEcorePackage.getEString(), "unitOfMeasure", null, 0, 1, MeasurementDimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasurementDimension_Dimension(), this.getDimensionType(), "dimension", null, 1, 1, MeasurementDimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMeasurementDimension_Measurement(), this.getMeasurementType(), "measurement", null, 1, 1, MeasurementDimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMeasurementDimension_Owner(), this.getMeasurementDomain(), this.getMeasurementDomain_Dimensions(), "owner", null, 0, 1, MeasurementDimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nominalDimensionEClass, NominalDimension.class, "NominalDimension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(measurementRegionEClass, MeasurementRegion.class, "MeasurementRegion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMeasurementRegion_Region(), this.getRegion(), "region", null, 1, 1, MeasurementRegion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringNominalRegionEClass, StringNominalRegion.class, "StringNominalRegion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(measurementEnumerationEClass, MeasurementEnumeration.class, "MeasurementEnumeration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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
		addEEnumLiteral(universalEEnum, Universal.EVENT);
		addEEnumLiteral(universalEEnum, Universal.HOU);
		addEEnumLiteral(universalEEnum, Universal.DATA_TYPE);
		addEEnumLiteral(universalEEnum, Universal.ENUMERATION);

		initEEnum(qualityEEnum, Quality.class, "Quality");
		addEEnumLiteral(qualityEEnum, Quality.NOMINAL);
		addEEnumLiteral(qualityEEnum, Quality.PERCEIVABLE);
		addEEnumLiteral(qualityEEnum, Quality.NON_PERCEIVABLE);

		initEEnum(primitiveEEnum, Primitive.class, "Primitive");
		addEEnumLiteral(primitiveEEnum, Primitive.BOOLEAN);
		addEEnumLiteral(primitiveEEnum, Primitive.STRING);
		addEEnumLiteral(primitiveEEnum, Primitive.REAL);
		addEEnumLiteral(primitiveEEnum, Primitive.INTEGER);
		addEEnumLiteral(primitiveEEnum, Primitive.UNLIMITED_NATURAL);

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

		initEEnum(allenRelationEEnum, AllenRelation.class, "AllenRelation");
		addEEnumLiteral(allenRelationEEnum, AllenRelation.STARTS);
		addEEnumLiteral(allenRelationEEnum, AllenRelation.PRECEDES);
		addEEnumLiteral(allenRelationEEnum, AllenRelation.EQUALS);
		addEEnumLiteral(allenRelationEEnum, AllenRelation.MEETS);
		addEEnumLiteral(allenRelationEEnum, AllenRelation.FINISHES);
		addEEnumLiteral(allenRelationEEnum, AllenRelation.OVERLAPS);
		addEEnumLiteral(allenRelationEEnum, AllenRelation.DURING);

		initEEnum(dimensionTypeEEnum, DimensionType.class, "DimensionType");
		addEEnumLiteral(dimensionTypeEEnum, DimensionType.INTERVAL);
		addEEnumLiteral(dimensionTypeEEnum, DimensionType.RATIONAL);
		addEEnumLiteral(dimensionTypeEEnum, DimensionType.ORDINAL);

		initEEnum(measurementTypeEEnum, MeasurementType.class, "MeasurementType");
		addEEnumLiteral(measurementTypeEEnum, MeasurementType.INTEGER);
		addEEnumLiteral(measurementTypeEEnum, MeasurementType.DECIMAL);

		initEEnum(regionEEnum, Region.class, "Region");
		addEEnumLiteral(regionEEnum, Region.INTEGER);
		addEEnumLiteral(regionEEnum, Region.DECIMAL);
		addEEnumLiteral(regionEEnum, Region.COMPOSED);

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
