/**
 */
package net.menthor.metamodel.ontouml;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see net.menthor.metamodel.ontouml.OntoumlFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel testsDirectory='/net.menthor.metamodel.ontouml.tests/src-gen' editDirectory='/net.menthor.metamodel.ontouml.edit/src-gen' editorDirectory='/net.menthor.metamodel.ontouml.editor/src-gen' fileExtensions='mouml' basePackage='net.menthor.metamodel'"
 * @generated
 */
public interface OntoumlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ontouml";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://menthor.net/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ontouml-menthor";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OntoumlPackage eINSTANCE = net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl.init();

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.ElementImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.NamedElementImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.ContainerImpl <em>Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.ContainerImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getContainer()
	 * @generated
	 */
	int CONTAINER = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER__ELEMENTS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.ContainingElementImpl <em>Containing Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.ContainingElementImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getContainingElement()
	 * @generated
	 */
	int CONTAINING_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINING_ELEMENT__HOLDER = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Containing Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINING_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Containing Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINING_ELEMENT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.ModelImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__NAME = CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL__ELEMENTS = CONTAINER__ELEMENTS;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FEATURE_COUNT = CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_OPERATION_COUNT = CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.PackageImpl <em>Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.PackageImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getPackage()
	 * @generated
	 */
	int PACKAGE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__NAME = CONTAINER__NAME;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__ELEMENTS = CONTAINER__ELEMENTS;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__HOLDER = CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FEATURE_COUNT = CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_OPERATION_COUNT = CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.ClassImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__HOLDER = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__STEREOTYPE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__IS_ABSTRACT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__IS_DERIVED = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Extensional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__IS_EXTENSIONAL = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Enumeration Literals</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ENUMERATION_LITERALS = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Instance Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__INSTANCE_OF = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Istruth Maker Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ISTRUTH_MAKER_OF = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ATTRIBUTES = NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Is Specialized Via</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__IS_SPECIALIZED_VIA = NAMED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Specializes Via</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__SPECIALIZES_VIA = NAMED_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The operation id for the '<em>Is Rigid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_RIGID = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Non Rigid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_NON_RIGID = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Anti Rigid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_ANTI_RIGID = NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.PrimitiveTypeImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__HOLDER = CONTAINING_ELEMENT__HOLDER;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__STEREOTYPE = CONTAINING_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_FEATURE_COUNT = CONTAINING_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_OPERATION_COUNT = CONTAINING_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.GeneralizationSetImpl <em>Generalization Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.GeneralizationSetImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getGeneralizationSet()
	 * @generated
	 */
	int GENERALIZATION_SET = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SET__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SET__HOLDER = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Covering</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SET__IS_COVERING = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Specialized Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SET__SPECIALIZED_CLASS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Specializing Classes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SET__SPECIALIZING_CLASSES = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Hou</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SET__HOU = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Generalization Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SET_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Generalization Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SET_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.PropertyImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Is Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_DERIVED = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__LOWER_BOUND = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__UPPER_BOUND = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Specific Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_SPECIFIC_DEPENDENT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.AttributeImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Is Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__IS_DERIVED = PROPERTY__IS_DERIVED;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__LOWER_BOUND = PROPERTY__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__UPPER_BOUND = PROPERTY__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Is Specific Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__IS_SPECIFIC_DEPENDENT = PROPERTY__IS_SPECIFIC_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__OWNER = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Of Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__IS_OF_TYPE = PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.EndPointImpl <em>End Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.EndPointImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getEndPoint()
	 * @generated
	 */
	int END_POINT = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_POINT__NAME = PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Is Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_POINT__IS_DERIVED = PROPERTY__IS_DERIVED;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_POINT__LOWER_BOUND = PROPERTY__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_POINT__UPPER_BOUND = PROPERTY__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Is Specific Dependent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_POINT__IS_SPECIFIC_DEPENDENT = PROPERTY__IS_SPECIFIC_DEPENDENT;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_POINT__OWNER = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Of Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_POINT__IS_OF_TYPE = PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Subsets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_POINT__SUBSETS = PROPERTY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Redefines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_POINT__REDEFINES = PROPERTY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Subsetted By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_POINT__IS_SUBSETTED_BY = PROPERTY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Is Redefeined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_POINT__IS_REDEFEINED_BY = PROPERTY_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>End Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_POINT_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>End Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_POINT_OPERATION_COUNT = PROPERTY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl <em>Class Binary Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getClassBinaryRelationship()
	 * @generated
	 */
	int CLASS_BINARY_RELATIONSHIP = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_BINARY_RELATIONSHIP__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_BINARY_RELATIONSHIP__HOLDER = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_BINARY_RELATIONSHIP__STEREOTYPE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>End Points</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_BINARY_RELATIONSHIP__END_POINTS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Part Is Shareable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_BINARY_RELATIONSHIP__PART_IS_SHAREABLE = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Truth Maker</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_BINARY_RELATIONSHIP__TRUTH_MAKER = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Is Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_BINARY_RELATIONSHIP__IS_DERIVED = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Part Is Essential</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_BINARY_RELATIONSHIP__PART_IS_ESSENTIAL = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Part Is Inseparable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_BINARY_RELATIONSHIP__PART_IS_INSEPARABLE = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Part Is Immutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_BINARY_RELATIONSHIP__PART_IS_IMMUTABLE = NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Whole Is Immutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_BINARY_RELATIONSHIP__WHOLE_IS_IMMUTABLE = NAMED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Part Is Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_BINARY_RELATIONSHIP__PART_IS_MANDATORY = NAMED_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Whole Is Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_BINARY_RELATIONSHIP__WHOLE_IS_MANDATORY = NAMED_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Class Binary Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_BINARY_RELATIONSHIP_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The operation id for the '<em>Source End</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_BINARY_RELATIONSHIP___SOURCE_END = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Target End</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_BINARY_RELATIONSHIP___TARGET_END = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Meronymic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_BINARY_RELATIONSHIP___IS_MERONYMIC = NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Class Binary Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_BINARY_RELATIONSHIP_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.Universal <em>Universal</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.Universal
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getUniversal()
	 * @generated
	 */
	int UNIVERSAL = 13;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.Primitive <em>Primitive</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.Primitive
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getPrimitive()
	 * @generated
	 */
	int PRIMITIVE = 14;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.Relation <em>Relation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.Relation
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getRelation()
	 * @generated
	 */
	int RELATION = 15;


	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see net.menthor.metamodel.ontouml.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see net.menthor.metamodel.ontouml.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see net.menthor.metamodel.ontouml.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.Container <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container</em>'.
	 * @see net.menthor.metamodel.ontouml.Container
	 * @generated
	 */
	EClass getContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link net.menthor.metamodel.ontouml.Container#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see net.menthor.metamodel.ontouml.Container#getElements()
	 * @see #getContainer()
	 * @generated
	 */
	EReference getContainer_Elements();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.ContainingElement <em>Containing Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Containing Element</em>'.
	 * @see net.menthor.metamodel.ontouml.ContainingElement
	 * @generated
	 */
	EClass getContainingElement();

	/**
	 * Returns the meta object for the container reference '{@link net.menthor.metamodel.ontouml.ContainingElement#getHolder <em>Holder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Holder</em>'.
	 * @see net.menthor.metamodel.ontouml.ContainingElement#getHolder()
	 * @see #getContainingElement()
	 * @generated
	 */
	EReference getContainingElement_Holder();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see net.menthor.metamodel.ontouml.Model
	 * @generated
	 */
	EClass getModel();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.Package <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package</em>'.
	 * @see net.menthor.metamodel.ontouml.Package
	 * @generated
	 */
	EClass getPackage();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see net.menthor.metamodel.ontouml.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.Class#getStereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stereotype</em>'.
	 * @see net.menthor.metamodel.ontouml.Class#getStereotype()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_Stereotype();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.Class#isIsAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see net.menthor.metamodel.ontouml.Class#isIsAbstract()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_IsAbstract();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.Class#isIsDerived <em>Is Derived</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Derived</em>'.
	 * @see net.menthor.metamodel.ontouml.Class#isIsDerived()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_IsDerived();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.Class#isIsExtensional <em>Is Extensional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Extensional</em>'.
	 * @see net.menthor.metamodel.ontouml.Class#isIsExtensional()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_IsExtensional();

	/**
	 * Returns the meta object for the attribute list '{@link net.menthor.metamodel.ontouml.Class#getEnumerationLiterals <em>Enumeration Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Enumeration Literals</em>'.
	 * @see net.menthor.metamodel.ontouml.Class#getEnumerationLiterals()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_EnumerationLiterals();

	/**
	 * Returns the meta object for the reference list '{@link net.menthor.metamodel.ontouml.Class#getInstanceOf <em>Instance Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Instance Of</em>'.
	 * @see net.menthor.metamodel.ontouml.Class#getInstanceOf()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_InstanceOf();

	/**
	 * Returns the meta object for the reference list '{@link net.menthor.metamodel.ontouml.Class#getIstruthMakerOf <em>Istruth Maker Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Istruth Maker Of</em>'.
	 * @see net.menthor.metamodel.ontouml.Class#getIstruthMakerOf()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_IstruthMakerOf();

	/**
	 * Returns the meta object for the reference list '{@link net.menthor.metamodel.ontouml.Class#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attributes</em>'.
	 * @see net.menthor.metamodel.ontouml.Class#getAttributes()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Attributes();

	/**
	 * Returns the meta object for the reference list '{@link net.menthor.metamodel.ontouml.Class#getIsSpecializedVia <em>Is Specialized Via</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Is Specialized Via</em>'.
	 * @see net.menthor.metamodel.ontouml.Class#getIsSpecializedVia()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_IsSpecializedVia();

	/**
	 * Returns the meta object for the reference list '{@link net.menthor.metamodel.ontouml.Class#getSpecializesVia <em>Specializes Via</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Specializes Via</em>'.
	 * @see net.menthor.metamodel.ontouml.Class#getSpecializesVia()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_SpecializesVia();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isRigid() <em>Is Rigid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Rigid</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isRigid()
	 * @generated
	 */
	EOperation getClass__IsRigid();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isNonRigid() <em>Is Non Rigid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Non Rigid</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isNonRigid()
	 * @generated
	 */
	EOperation getClass__IsNonRigid();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isAntiRigid() <em>Is Anti Rigid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Anti Rigid</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isAntiRigid()
	 * @generated
	 */
	EOperation getClass__IsAntiRigid();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see net.menthor.metamodel.ontouml.PrimitiveType
	 * @generated
	 */
	EClass getPrimitiveType();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.PrimitiveType#getStereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stereotype</em>'.
	 * @see net.menthor.metamodel.ontouml.PrimitiveType#getStereotype()
	 * @see #getPrimitiveType()
	 * @generated
	 */
	EAttribute getPrimitiveType_Stereotype();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.GeneralizationSet <em>Generalization Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generalization Set</em>'.
	 * @see net.menthor.metamodel.ontouml.GeneralizationSet
	 * @generated
	 */
	EClass getGeneralizationSet();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.GeneralizationSet#isIsCovering <em>Is Covering</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Covering</em>'.
	 * @see net.menthor.metamodel.ontouml.GeneralizationSet#isIsCovering()
	 * @see #getGeneralizationSet()
	 * @generated
	 */
	EAttribute getGeneralizationSet_IsCovering();

	/**
	 * Returns the meta object for the reference '{@link net.menthor.metamodel.ontouml.GeneralizationSet#getSpecializedClass <em>Specialized Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Specialized Class</em>'.
	 * @see net.menthor.metamodel.ontouml.GeneralizationSet#getSpecializedClass()
	 * @see #getGeneralizationSet()
	 * @generated
	 */
	EReference getGeneralizationSet_SpecializedClass();

	/**
	 * Returns the meta object for the reference list '{@link net.menthor.metamodel.ontouml.GeneralizationSet#getSpecializingClasses <em>Specializing Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Specializing Classes</em>'.
	 * @see net.menthor.metamodel.ontouml.GeneralizationSet#getSpecializingClasses()
	 * @see #getGeneralizationSet()
	 * @generated
	 */
	EReference getGeneralizationSet_SpecializingClasses();

	/**
	 * Returns the meta object for the reference '{@link net.menthor.metamodel.ontouml.GeneralizationSet#getHou <em>Hou</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Hou</em>'.
	 * @see net.menthor.metamodel.ontouml.GeneralizationSet#getHou()
	 * @see #getGeneralizationSet()
	 * @generated
	 */
	EReference getGeneralizationSet_Hou();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see net.menthor.metamodel.ontouml.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.Property#isIsDerived <em>Is Derived</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Derived</em>'.
	 * @see net.menthor.metamodel.ontouml.Property#isIsDerived()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsDerived();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.Property#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see net.menthor.metamodel.ontouml.Property#getLowerBound()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.Property#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see net.menthor.metamodel.ontouml.Property#getUpperBound()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_UpperBound();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.Property#isIsSpecificDependent <em>Is Specific Dependent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Specific Dependent</em>'.
	 * @see net.menthor.metamodel.ontouml.Property#isIsSpecificDependent()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsSpecificDependent();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see net.menthor.metamodel.ontouml.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the reference '{@link net.menthor.metamodel.ontouml.Attribute#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see net.menthor.metamodel.ontouml.Attribute#getOwner()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_Owner();

	/**
	 * Returns the meta object for the reference '{@link net.menthor.metamodel.ontouml.Attribute#getIsOfType <em>Is Of Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Is Of Type</em>'.
	 * @see net.menthor.metamodel.ontouml.Attribute#getIsOfType()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_IsOfType();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.EndPoint <em>End Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End Point</em>'.
	 * @see net.menthor.metamodel.ontouml.EndPoint
	 * @generated
	 */
	EClass getEndPoint();

	/**
	 * Returns the meta object for the reference '{@link net.menthor.metamodel.ontouml.EndPoint#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see net.menthor.metamodel.ontouml.EndPoint#getOwner()
	 * @see #getEndPoint()
	 * @generated
	 */
	EReference getEndPoint_Owner();

	/**
	 * Returns the meta object for the reference '{@link net.menthor.metamodel.ontouml.EndPoint#getIsOfType <em>Is Of Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Is Of Type</em>'.
	 * @see net.menthor.metamodel.ontouml.EndPoint#getIsOfType()
	 * @see #getEndPoint()
	 * @generated
	 */
	EReference getEndPoint_IsOfType();

	/**
	 * Returns the meta object for the reference list '{@link net.menthor.metamodel.ontouml.EndPoint#getSubsets <em>Subsets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subsets</em>'.
	 * @see net.menthor.metamodel.ontouml.EndPoint#getSubsets()
	 * @see #getEndPoint()
	 * @generated
	 */
	EReference getEndPoint_Subsets();

	/**
	 * Returns the meta object for the reference list '{@link net.menthor.metamodel.ontouml.EndPoint#getRedefines <em>Redefines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Redefines</em>'.
	 * @see net.menthor.metamodel.ontouml.EndPoint#getRedefines()
	 * @see #getEndPoint()
	 * @generated
	 */
	EReference getEndPoint_Redefines();

	/**
	 * Returns the meta object for the reference list '{@link net.menthor.metamodel.ontouml.EndPoint#getIsSubsettedBy <em>Is Subsetted By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Is Subsetted By</em>'.
	 * @see net.menthor.metamodel.ontouml.EndPoint#getIsSubsettedBy()
	 * @see #getEndPoint()
	 * @generated
	 */
	EReference getEndPoint_IsSubsettedBy();

	/**
	 * Returns the meta object for the reference list '{@link net.menthor.metamodel.ontouml.EndPoint#getIsRedefeinedBy <em>Is Redefeined By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Is Redefeined By</em>'.
	 * @see net.menthor.metamodel.ontouml.EndPoint#getIsRedefeinedBy()
	 * @see #getEndPoint()
	 * @generated
	 */
	EReference getEndPoint_IsRedefeinedBy();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship <em>Class Binary Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Binary Relationship</em>'.
	 * @see net.menthor.metamodel.ontouml.ClassBinaryRelationship
	 * @generated
	 */
	EClass getClassBinaryRelationship();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getStereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stereotype</em>'.
	 * @see net.menthor.metamodel.ontouml.ClassBinaryRelationship#getStereotype()
	 * @see #getClassBinaryRelationship()
	 * @generated
	 */
	EAttribute getClassBinaryRelationship_Stereotype();

	/**
	 * Returns the meta object for the reference list '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getEndPoints <em>End Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>End Points</em>'.
	 * @see net.menthor.metamodel.ontouml.ClassBinaryRelationship#getEndPoints()
	 * @see #getClassBinaryRelationship()
	 * @generated
	 */
	EReference getClassBinaryRelationship_EndPoints();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#isPartIsShareable <em>Part Is Shareable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Part Is Shareable</em>'.
	 * @see net.menthor.metamodel.ontouml.ClassBinaryRelationship#isPartIsShareable()
	 * @see #getClassBinaryRelationship()
	 * @generated
	 */
	EAttribute getClassBinaryRelationship_PartIsShareable();

	/**
	 * Returns the meta object for the reference '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getTruthMaker <em>Truth Maker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Truth Maker</em>'.
	 * @see net.menthor.metamodel.ontouml.ClassBinaryRelationship#getTruthMaker()
	 * @see #getClassBinaryRelationship()
	 * @generated
	 */
	EReference getClassBinaryRelationship_TruthMaker();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#isIsDerived <em>Is Derived</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Derived</em>'.
	 * @see net.menthor.metamodel.ontouml.ClassBinaryRelationship#isIsDerived()
	 * @see #getClassBinaryRelationship()
	 * @generated
	 */
	EAttribute getClassBinaryRelationship_IsDerived();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#isPartIsEssential <em>Part Is Essential</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Part Is Essential</em>'.
	 * @see net.menthor.metamodel.ontouml.ClassBinaryRelationship#isPartIsEssential()
	 * @see #getClassBinaryRelationship()
	 * @generated
	 */
	EAttribute getClassBinaryRelationship_PartIsEssential();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#isPartIsInseparable <em>Part Is Inseparable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Part Is Inseparable</em>'.
	 * @see net.menthor.metamodel.ontouml.ClassBinaryRelationship#isPartIsInseparable()
	 * @see #getClassBinaryRelationship()
	 * @generated
	 */
	EAttribute getClassBinaryRelationship_PartIsInseparable();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#isPartIsImmutable <em>Part Is Immutable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Part Is Immutable</em>'.
	 * @see net.menthor.metamodel.ontouml.ClassBinaryRelationship#isPartIsImmutable()
	 * @see #getClassBinaryRelationship()
	 * @generated
	 */
	EAttribute getClassBinaryRelationship_PartIsImmutable();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#isWholeIsImmutable <em>Whole Is Immutable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Whole Is Immutable</em>'.
	 * @see net.menthor.metamodel.ontouml.ClassBinaryRelationship#isWholeIsImmutable()
	 * @see #getClassBinaryRelationship()
	 * @generated
	 */
	EAttribute getClassBinaryRelationship_WholeIsImmutable();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#isPartIsMandatory <em>Part Is Mandatory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Part Is Mandatory</em>'.
	 * @see net.menthor.metamodel.ontouml.ClassBinaryRelationship#isPartIsMandatory()
	 * @see #getClassBinaryRelationship()
	 * @generated
	 */
	EAttribute getClassBinaryRelationship_PartIsMandatory();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#isWholeIsMandatory <em>Whole Is Mandatory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Whole Is Mandatory</em>'.
	 * @see net.menthor.metamodel.ontouml.ClassBinaryRelationship#isWholeIsMandatory()
	 * @see #getClassBinaryRelationship()
	 * @generated
	 */
	EAttribute getClassBinaryRelationship_WholeIsMandatory();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#sourceEnd() <em>Source End</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Source End</em>' operation.
	 * @see net.menthor.metamodel.ontouml.ClassBinaryRelationship#sourceEnd()
	 * @generated
	 */
	EOperation getClassBinaryRelationship__SourceEnd();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#targetEnd() <em>Target End</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Target End</em>' operation.
	 * @see net.menthor.metamodel.ontouml.ClassBinaryRelationship#targetEnd()
	 * @generated
	 */
	EOperation getClassBinaryRelationship__TargetEnd();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#isMeronymic() <em>Is Meronymic</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Meronymic</em>' operation.
	 * @see net.menthor.metamodel.ontouml.ClassBinaryRelationship#isMeronymic()
	 * @generated
	 */
	EOperation getClassBinaryRelationship__IsMeronymic();

	/**
	 * Returns the meta object for enum '{@link net.menthor.metamodel.ontouml.Universal <em>Universal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Universal</em>'.
	 * @see net.menthor.metamodel.ontouml.Universal
	 * @generated
	 */
	EEnum getUniversal();

	/**
	 * Returns the meta object for enum '{@link net.menthor.metamodel.ontouml.Primitive <em>Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Primitive</em>'.
	 * @see net.menthor.metamodel.ontouml.Primitive
	 * @generated
	 */
	EEnum getPrimitive();

	/**
	 * Returns the meta object for enum '{@link net.menthor.metamodel.ontouml.Relation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Relation</em>'.
	 * @see net.menthor.metamodel.ontouml.Relation
	 * @generated
	 */
	EEnum getRelation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OntoumlFactory getOntoumlFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.ElementImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.NamedElementImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.ContainerImpl <em>Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.ContainerImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getContainer()
		 * @generated
		 */
		EClass CONTAINER = eINSTANCE.getContainer();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER__ELEMENTS = eINSTANCE.getContainer_Elements();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.ContainingElementImpl <em>Containing Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.ContainingElementImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getContainingElement()
		 * @generated
		 */
		EClass CONTAINING_ELEMENT = eINSTANCE.getContainingElement();

		/**
		 * The meta object literal for the '<em><b>Holder</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINING_ELEMENT__HOLDER = eINSTANCE.getContainingElement_Holder();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.ModelImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.PackageImpl <em>Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.PackageImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getPackage()
		 * @generated
		 */
		EClass PACKAGE = eINSTANCE.getPackage();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.ClassImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>Stereotype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__STEREOTYPE = eINSTANCE.getClass_Stereotype();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__IS_ABSTRACT = eINSTANCE.getClass_IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Is Derived</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__IS_DERIVED = eINSTANCE.getClass_IsDerived();

		/**
		 * The meta object literal for the '<em><b>Is Extensional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__IS_EXTENSIONAL = eINSTANCE.getClass_IsExtensional();

		/**
		 * The meta object literal for the '<em><b>Enumeration Literals</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__ENUMERATION_LITERALS = eINSTANCE.getClass_EnumerationLiterals();

		/**
		 * The meta object literal for the '<em><b>Instance Of</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__INSTANCE_OF = eINSTANCE.getClass_InstanceOf();

		/**
		 * The meta object literal for the '<em><b>Istruth Maker Of</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__ISTRUTH_MAKER_OF = eINSTANCE.getClass_IstruthMakerOf();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__ATTRIBUTES = eINSTANCE.getClass_Attributes();

		/**
		 * The meta object literal for the '<em><b>Is Specialized Via</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__IS_SPECIALIZED_VIA = eINSTANCE.getClass_IsSpecializedVia();

		/**
		 * The meta object literal for the '<em><b>Specializes Via</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__SPECIALIZES_VIA = eINSTANCE.getClass_SpecializesVia();

		/**
		 * The meta object literal for the '<em><b>Is Rigid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_RIGID = eINSTANCE.getClass__IsRigid();

		/**
		 * The meta object literal for the '<em><b>Is Non Rigid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_NON_RIGID = eINSTANCE.getClass__IsNonRigid();

		/**
		 * The meta object literal for the '<em><b>Is Anti Rigid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_ANTI_RIGID = eINSTANCE.getClass__IsAntiRigid();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.PrimitiveTypeImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getPrimitiveType()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
		 * The meta object literal for the '<em><b>Stereotype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TYPE__STEREOTYPE = eINSTANCE.getPrimitiveType_Stereotype();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.GeneralizationSetImpl <em>Generalization Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.GeneralizationSetImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getGeneralizationSet()
		 * @generated
		 */
		EClass GENERALIZATION_SET = eINSTANCE.getGeneralizationSet();

		/**
		 * The meta object literal for the '<em><b>Is Covering</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERALIZATION_SET__IS_COVERING = eINSTANCE.getGeneralizationSet_IsCovering();

		/**
		 * The meta object literal for the '<em><b>Specialized Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERALIZATION_SET__SPECIALIZED_CLASS = eINSTANCE.getGeneralizationSet_SpecializedClass();

		/**
		 * The meta object literal for the '<em><b>Specializing Classes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERALIZATION_SET__SPECIALIZING_CLASSES = eINSTANCE.getGeneralizationSet_SpecializingClasses();

		/**
		 * The meta object literal for the '<em><b>Hou</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERALIZATION_SET__HOU = eINSTANCE.getGeneralizationSet_Hou();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.PropertyImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Is Derived</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_DERIVED = eINSTANCE.getProperty_IsDerived();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__LOWER_BOUND = eINSTANCE.getProperty_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__UPPER_BOUND = eINSTANCE.getProperty_UpperBound();

		/**
		 * The meta object literal for the '<em><b>Is Specific Dependent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_SPECIFIC_DEPENDENT = eINSTANCE.getProperty_IsSpecificDependent();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.AttributeImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__OWNER = eINSTANCE.getAttribute_Owner();

		/**
		 * The meta object literal for the '<em><b>Is Of Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__IS_OF_TYPE = eINSTANCE.getAttribute_IsOfType();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.EndPointImpl <em>End Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.EndPointImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getEndPoint()
		 * @generated
		 */
		EClass END_POINT = eINSTANCE.getEndPoint();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference END_POINT__OWNER = eINSTANCE.getEndPoint_Owner();

		/**
		 * The meta object literal for the '<em><b>Is Of Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference END_POINT__IS_OF_TYPE = eINSTANCE.getEndPoint_IsOfType();

		/**
		 * The meta object literal for the '<em><b>Subsets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference END_POINT__SUBSETS = eINSTANCE.getEndPoint_Subsets();

		/**
		 * The meta object literal for the '<em><b>Redefines</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference END_POINT__REDEFINES = eINSTANCE.getEndPoint_Redefines();

		/**
		 * The meta object literal for the '<em><b>Is Subsetted By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference END_POINT__IS_SUBSETTED_BY = eINSTANCE.getEndPoint_IsSubsettedBy();

		/**
		 * The meta object literal for the '<em><b>Is Redefeined By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference END_POINT__IS_REDEFEINED_BY = eINSTANCE.getEndPoint_IsRedefeinedBy();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl <em>Class Binary Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getClassBinaryRelationship()
		 * @generated
		 */
		EClass CLASS_BINARY_RELATIONSHIP = eINSTANCE.getClassBinaryRelationship();

		/**
		 * The meta object literal for the '<em><b>Stereotype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_BINARY_RELATIONSHIP__STEREOTYPE = eINSTANCE.getClassBinaryRelationship_Stereotype();

		/**
		 * The meta object literal for the '<em><b>End Points</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_BINARY_RELATIONSHIP__END_POINTS = eINSTANCE.getClassBinaryRelationship_EndPoints();

		/**
		 * The meta object literal for the '<em><b>Part Is Shareable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_BINARY_RELATIONSHIP__PART_IS_SHAREABLE = eINSTANCE.getClassBinaryRelationship_PartIsShareable();

		/**
		 * The meta object literal for the '<em><b>Truth Maker</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_BINARY_RELATIONSHIP__TRUTH_MAKER = eINSTANCE.getClassBinaryRelationship_TruthMaker();

		/**
		 * The meta object literal for the '<em><b>Is Derived</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_BINARY_RELATIONSHIP__IS_DERIVED = eINSTANCE.getClassBinaryRelationship_IsDerived();

		/**
		 * The meta object literal for the '<em><b>Part Is Essential</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_BINARY_RELATIONSHIP__PART_IS_ESSENTIAL = eINSTANCE.getClassBinaryRelationship_PartIsEssential();

		/**
		 * The meta object literal for the '<em><b>Part Is Inseparable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_BINARY_RELATIONSHIP__PART_IS_INSEPARABLE = eINSTANCE.getClassBinaryRelationship_PartIsInseparable();

		/**
		 * The meta object literal for the '<em><b>Part Is Immutable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_BINARY_RELATIONSHIP__PART_IS_IMMUTABLE = eINSTANCE.getClassBinaryRelationship_PartIsImmutable();

		/**
		 * The meta object literal for the '<em><b>Whole Is Immutable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_BINARY_RELATIONSHIP__WHOLE_IS_IMMUTABLE = eINSTANCE.getClassBinaryRelationship_WholeIsImmutable();

		/**
		 * The meta object literal for the '<em><b>Part Is Mandatory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_BINARY_RELATIONSHIP__PART_IS_MANDATORY = eINSTANCE.getClassBinaryRelationship_PartIsMandatory();

		/**
		 * The meta object literal for the '<em><b>Whole Is Mandatory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_BINARY_RELATIONSHIP__WHOLE_IS_MANDATORY = eINSTANCE.getClassBinaryRelationship_WholeIsMandatory();

		/**
		 * The meta object literal for the '<em><b>Source End</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS_BINARY_RELATIONSHIP___SOURCE_END = eINSTANCE.getClassBinaryRelationship__SourceEnd();

		/**
		 * The meta object literal for the '<em><b>Target End</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS_BINARY_RELATIONSHIP___TARGET_END = eINSTANCE.getClassBinaryRelationship__TargetEnd();

		/**
		 * The meta object literal for the '<em><b>Is Meronymic</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS_BINARY_RELATIONSHIP___IS_MERONYMIC = eINSTANCE.getClassBinaryRelationship__IsMeronymic();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.Universal <em>Universal</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.Universal
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getUniversal()
		 * @generated
		 */
		EEnum UNIVERSAL = eINSTANCE.getUniversal();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.Primitive <em>Primitive</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.Primitive
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getPrimitive()
		 * @generated
		 */
		EEnum PRIMITIVE = eINSTANCE.getPrimitive();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.Relation <em>Relation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.Relation
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getRelation()
		 * @generated
		 */
		EEnum RELATION = eINSTANCE.getRelation();

	}

} //OntoumlPackage
