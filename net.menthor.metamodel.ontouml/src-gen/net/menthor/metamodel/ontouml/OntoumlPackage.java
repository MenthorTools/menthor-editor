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
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.ContainedElementImpl <em>Contained Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.ContainedElementImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getContainedElement()
	 * @generated
	 */
	int CONTAINED_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINED_ELEMENT__HOLDER = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINED_ELEMENT__COMMENTS = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Contained Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINED_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Contained Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINED_ELEMENT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.CommentImpl <em>Comment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.CommentImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getComment()
	 * @generated
	 */
	int COMMENT = 4;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__CONTENT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__OWNER = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.ModelImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getModel()
	 * @generated
	 */
	int MODEL = 5;

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
	int PACKAGE = 6;

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
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__COMMENTS = CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FEATURE_COUNT = CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_OPERATION_COUNT = CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.ClassifierElementImpl <em>Classifier Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.ClassifierElementImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getClassifierElement()
	 * @generated
	 */
	int CLASSIFIER_ELEMENT = 7;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_ELEMENT__HOLDER = CONTAINED_ELEMENT__HOLDER;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_ELEMENT__COMMENTS = CONTAINED_ELEMENT__COMMENTS;

	/**
	 * The number of structural features of the '<em>Classifier Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_ELEMENT_FEATURE_COUNT = CONTAINED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Classifier Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_ELEMENT_OPERATION_COUNT = CONTAINED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.ClassImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 8;

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
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__COMMENTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__STEREOTYPE = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Quality Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__QUALITY_TYPE = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Enumeration Literals</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ENUMERATION_LITERALS = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__IS_ABSTRACT = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Is Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__IS_DERIVED = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Is Extensional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__IS_EXTENSIONAL = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ATTRIBUTES = NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Istruth Maker Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ISTRUTH_MAKER_OF = NAMED_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Instance Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__INSTANCE_OF = NAMED_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Is Specialized Via</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__IS_SPECIALIZED_VIA = NAMED_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Specializes Via</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__SPECIALIZES_VIA = NAMED_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 13;

	/**
	 * The operation id for the '<em>Is Kind</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_KIND = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Sub Kind</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_SUB_KIND = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Collective</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_COLLECTIVE = NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Quantity</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_QUANTITY = NAMED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Relator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_RELATOR = NAMED_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Mode</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_MODE = NAMED_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Is Quality</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_QUALITY = NAMED_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Is Role</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_ROLE = NAMED_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Is Role Mixin</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_ROLE_MIXIN = NAMED_ELEMENT_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Is Phase Mixin</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_PHASE_MIXIN = NAMED_ELEMENT_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Is Phase</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_PHASE = NAMED_ELEMENT_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Is Category</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_CATEGORY = NAMED_ELEMENT_OPERATION_COUNT + 11;

	/**
	 * The operation id for the '<em>Is Mixin</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_MIXIN = NAMED_ELEMENT_OPERATION_COUNT + 12;

	/**
	 * The operation id for the '<em>Is Event</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_EVENT = NAMED_ELEMENT_OPERATION_COUNT + 13;

	/**
	 * The operation id for the '<em>Is High Order</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_HIGH_ORDER = NAMED_ELEMENT_OPERATION_COUNT + 14;

	/**
	 * The operation id for the '<em>Is Data Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_DATA_TYPE = NAMED_ELEMENT_OPERATION_COUNT + 15;

	/**
	 * The operation id for the '<em>Is Enumeration</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_ENUMERATION = NAMED_ELEMENT_OPERATION_COUNT + 16;

	/**
	 * The operation id for the '<em>Is Rigid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_RIGID = NAMED_ELEMENT_OPERATION_COUNT + 17;

	/**
	 * The operation id for the '<em>Is Non Rigid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_NON_RIGID = NAMED_ELEMENT_OPERATION_COUNT + 18;

	/**
	 * The operation id for the '<em>Is Anti Rigid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_ANTI_RIGID = NAMED_ELEMENT_OPERATION_COUNT + 19;

	/**
	 * The operation id for the '<em>Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___CHILDREN = NAMED_ELEMENT_OPERATION_COUNT + 20;

	/**
	 * The operation id for the '<em>Parents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___PARENTS = NAMED_ELEMENT_OPERATION_COUNT + 21;

	/**
	 * The operation id for the '<em>Identidy Provider</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IDENTIDY_PROVIDER = NAMED_ELEMENT_OPERATION_COUNT + 22;

	/**
	 * The operation id for the '<em>Is Functional Complex</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_FUNCTIONAL_COMPLEX = NAMED_ELEMENT_OPERATION_COUNT + 23;

	/**
	 * The operation id for the '<em>Is Collection</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_COLLECTION = NAMED_ELEMENT_OPERATION_COUNT + 24;

	/**
	 * The operation id for the '<em>Is Amount Of Matter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_AMOUNT_OF_MATTER = NAMED_ELEMENT_OPERATION_COUNT + 25;

	/**
	 * The operation id for the '<em>Is Intrinsic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_INTRINSIC = NAMED_ELEMENT_OPERATION_COUNT + 26;

	/**
	 * The operation id for the '<em>Is Truth Maker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_TRUTH_MAKER = NAMED_ELEMENT_OPERATION_COUNT + 27;

	/**
	 * The operation id for the '<em>Set Is Extensional</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___SET_IS_EXTENSIONAL = NAMED_ELEMENT_OPERATION_COUNT + 28;

	/**
	 * The number of operations of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 29;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.GeneralizationSetImpl <em>Generalization Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.GeneralizationSetImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getGeneralizationSet()
	 * @generated
	 */
	int GENERALIZATION_SET = 9;

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
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SET__COMMENTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Covering</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SET__IS_COVERING = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Specialized Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SET__SPECIALIZED_CLASS = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Specializing Classes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SET__SPECIALIZING_CLASSES = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Hou</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SET__HOU = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Generalization Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SET_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 6;

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
	int PROPERTY = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_ORDERED = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_DERIVED = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__LOWER_BOUND = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__UPPER_BOUND = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Dependee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_DEPENDEE = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_POINT__IS_ORDERED = PROPERTY__IS_ORDERED;

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
	 * The feature id for the '<em><b>Is Dependee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_POINT__IS_DEPENDEE = PROPERTY__IS_DEPENDEE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_POINT__OWNER = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_POINT__END_TYPE = PROPERTY_FEATURE_COUNT + 1;

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
	 * The feature id for the '<em><b>Is Redefined By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_POINT__IS_REDEFINED_BY = PROPERTY_FEATURE_COUNT + 5;

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
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.AttributeImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__IS_ORDERED = PROPERTY__IS_ORDERED;

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
	 * The feature id for the '<em><b>Is Dependee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__IS_DEPENDEE = PROPERTY__IS_DEPENDEE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__OWNER = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Primitive Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__PRIMITIVE_TYPE = PROPERTY_FEATURE_COUNT + 1;

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
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.PrimitiveTypeImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__HOLDER = CONTAINED_ELEMENT__HOLDER;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__COMMENTS = CONTAINED_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Primitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__PRIMITIVE = CONTAINED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_FEATURE_COUNT = CONTAINED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_OPERATION_COUNT = CONTAINED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.RelationshipImpl <em>Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.RelationshipImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getRelationship()
	 * @generated
	 */
	int RELATIONSHIP = 14;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__HOLDER = CLASSIFIER_ELEMENT__HOLDER;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__COMMENTS = CLASSIFIER_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__STEREOTYPE = CLASSIFIER_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Allen Relation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__ALLEN_RELATION = CLASSIFIER_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>End Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__END_POINTS = CLASSIFIER_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Truth Maker</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__TRUTH_MAKER = CLASSIFIER_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP_FEATURE_COUNT = CLASSIFIER_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Shareable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_SHAREABLE = CLASSIFIER_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Component Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_COMPONENT_OF = CLASSIFIER_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Member Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_MEMBER_OF = CLASSIFIER_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Sub Collection Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_SUB_COLLECTION_OF = CLASSIFIER_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Sub Quantity Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_SUB_QUANTITY_OF = CLASSIFIER_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Constitution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_CONSTITUTION = CLASSIFIER_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Is Characterization</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_CHARACTERIZATION = CLASSIFIER_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Is Mediation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_MEDIATION = CLASSIFIER_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Is Material</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_MATERIAL = CLASSIFIER_ELEMENT_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Is Formal</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_FORMAL = CLASSIFIER_ELEMENT_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Is Structuration</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_STRUCTURATION = CLASSIFIER_ELEMENT_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Is Participation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_PARTICIPATION = CLASSIFIER_ELEMENT_OPERATION_COUNT + 11;

	/**
	 * The operation id for the '<em>Is Sub Event Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_SUB_EVENT_OF = CLASSIFIER_ELEMENT_OPERATION_COUNT + 12;

	/**
	 * The operation id for the '<em>Is Causation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_CAUSATION = CLASSIFIER_ELEMENT_OPERATION_COUNT + 13;

	/**
	 * The operation id for the '<em>Is Temporal</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_TEMPORAL = CLASSIFIER_ELEMENT_OPERATION_COUNT + 14;

	/**
	 * The operation id for the '<em>Is Starts</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_STARTS = CLASSIFIER_ELEMENT_OPERATION_COUNT + 15;

	/**
	 * The operation id for the '<em>Is Precedes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_PRECEDES = CLASSIFIER_ELEMENT_OPERATION_COUNT + 16;

	/**
	 * The operation id for the '<em>Is Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_EQUALS = CLASSIFIER_ELEMENT_OPERATION_COUNT + 17;

	/**
	 * The operation id for the '<em>Is Meets</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_MEETS = CLASSIFIER_ELEMENT_OPERATION_COUNT + 18;

	/**
	 * The operation id for the '<em>Is Finishes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_FINISHES = CLASSIFIER_ELEMENT_OPERATION_COUNT + 19;

	/**
	 * The operation id for the '<em>Is Overlaps</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_OVERLAPS = CLASSIFIER_ELEMENT_OPERATION_COUNT + 20;

	/**
	 * The operation id for the '<em>Is During</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_DURING = CLASSIFIER_ELEMENT_OPERATION_COUNT + 21;

	/**
	 * The operation id for the '<em>Is Meronymic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_MERONYMIC = CLASSIFIER_ELEMENT_OPERATION_COUNT + 22;

	/**
	 * The number of operations of the '<em>Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP_OPERATION_COUNT = CLASSIFIER_ELEMENT_OPERATION_COUNT + 23;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.BinaryRelationshipImpl <em>Binary Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.BinaryRelationshipImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getBinaryRelationship()
	 * @generated
	 */
	int BINARY_RELATIONSHIP = 15;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP__HOLDER = RELATIONSHIP__HOLDER;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP__COMMENTS = RELATIONSHIP__COMMENTS;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP__STEREOTYPE = RELATIONSHIP__STEREOTYPE;

	/**
	 * The feature id for the '<em><b>Allen Relation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP__ALLEN_RELATION = RELATIONSHIP__ALLEN_RELATION;

	/**
	 * The feature id for the '<em><b>End Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP__END_POINTS = RELATIONSHIP__END_POINTS;

	/**
	 * The feature id for the '<em><b>Truth Maker</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP__TRUTH_MAKER = RELATIONSHIP__TRUTH_MAKER;

	/**
	 * The number of structural features of the '<em>Binary Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP_FEATURE_COUNT = RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Shareable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP___IS_SHAREABLE = RELATIONSHIP___IS_SHAREABLE;

	/**
	 * The operation id for the '<em>Is Component Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP___IS_COMPONENT_OF = RELATIONSHIP___IS_COMPONENT_OF;

	/**
	 * The operation id for the '<em>Is Member Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP___IS_MEMBER_OF = RELATIONSHIP___IS_MEMBER_OF;

	/**
	 * The operation id for the '<em>Is Sub Collection Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP___IS_SUB_COLLECTION_OF = RELATIONSHIP___IS_SUB_COLLECTION_OF;

	/**
	 * The operation id for the '<em>Is Sub Quantity Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP___IS_SUB_QUANTITY_OF = RELATIONSHIP___IS_SUB_QUANTITY_OF;

	/**
	 * The operation id for the '<em>Is Constitution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP___IS_CONSTITUTION = RELATIONSHIP___IS_CONSTITUTION;

	/**
	 * The operation id for the '<em>Is Characterization</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP___IS_CHARACTERIZATION = RELATIONSHIP___IS_CHARACTERIZATION;

	/**
	 * The operation id for the '<em>Is Mediation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP___IS_MEDIATION = RELATIONSHIP___IS_MEDIATION;

	/**
	 * The operation id for the '<em>Is Material</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP___IS_MATERIAL = RELATIONSHIP___IS_MATERIAL;

	/**
	 * The operation id for the '<em>Is Formal</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP___IS_FORMAL = RELATIONSHIP___IS_FORMAL;

	/**
	 * The operation id for the '<em>Is Structuration</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP___IS_STRUCTURATION = RELATIONSHIP___IS_STRUCTURATION;

	/**
	 * The operation id for the '<em>Is Participation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP___IS_PARTICIPATION = RELATIONSHIP___IS_PARTICIPATION;

	/**
	 * The operation id for the '<em>Is Sub Event Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP___IS_SUB_EVENT_OF = RELATIONSHIP___IS_SUB_EVENT_OF;

	/**
	 * The operation id for the '<em>Is Causation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP___IS_CAUSATION = RELATIONSHIP___IS_CAUSATION;

	/**
	 * The operation id for the '<em>Is Temporal</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP___IS_TEMPORAL = RELATIONSHIP___IS_TEMPORAL;

	/**
	 * The operation id for the '<em>Is Starts</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP___IS_STARTS = RELATIONSHIP___IS_STARTS;

	/**
	 * The operation id for the '<em>Is Precedes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP___IS_PRECEDES = RELATIONSHIP___IS_PRECEDES;

	/**
	 * The operation id for the '<em>Is Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP___IS_EQUALS = RELATIONSHIP___IS_EQUALS;

	/**
	 * The operation id for the '<em>Is Meets</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP___IS_MEETS = RELATIONSHIP___IS_MEETS;

	/**
	 * The operation id for the '<em>Is Finishes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP___IS_FINISHES = RELATIONSHIP___IS_FINISHES;

	/**
	 * The operation id for the '<em>Is Overlaps</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP___IS_OVERLAPS = RELATIONSHIP___IS_OVERLAPS;

	/**
	 * The operation id for the '<em>Is During</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP___IS_DURING = RELATIONSHIP___IS_DURING;

	/**
	 * The operation id for the '<em>Is Meronymic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP___IS_MERONYMIC = RELATIONSHIP___IS_MERONYMIC;

	/**
	 * The operation id for the '<em>Source End Point</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP___SOURCE_END_POINT = RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Target End Point</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP___TARGET_END_POINT = RELATIONSHIP_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Derived</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP___IS_DERIVED = RELATIONSHIP_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Binary Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_RELATIONSHIP_OPERATION_COUNT = RELATIONSHIP_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.BinaryClassRelationshipImpl <em>Binary Class Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.BinaryClassRelationshipImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getBinaryClassRelationship()
	 * @generated
	 */
	int BINARY_CLASS_RELATIONSHIP = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP__HOLDER = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP__COMMENTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP__STEREOTYPE = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Allen Relation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP__ALLEN_RELATION = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>End Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP__END_POINTS = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Truth Maker</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP__TRUTH_MAKER = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Binary Class Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Is Shareable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_SHAREABLE = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Component Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_COMPONENT_OF = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Member Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_MEMBER_OF = NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Sub Collection Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_SUB_COLLECTION_OF = NAMED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Sub Quantity Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_SUB_QUANTITY_OF = NAMED_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Constitution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_CONSTITUTION = NAMED_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Is Characterization</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_CHARACTERIZATION = NAMED_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Is Mediation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_MEDIATION = NAMED_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Is Material</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_MATERIAL = NAMED_ELEMENT_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Is Formal</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_FORMAL = NAMED_ELEMENT_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Is Structuration</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_STRUCTURATION = NAMED_ELEMENT_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Is Participation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_PARTICIPATION = NAMED_ELEMENT_OPERATION_COUNT + 11;

	/**
	 * The operation id for the '<em>Is Sub Event Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_SUB_EVENT_OF = NAMED_ELEMENT_OPERATION_COUNT + 12;

	/**
	 * The operation id for the '<em>Is Causation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_CAUSATION = NAMED_ELEMENT_OPERATION_COUNT + 13;

	/**
	 * The operation id for the '<em>Is Temporal</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_TEMPORAL = NAMED_ELEMENT_OPERATION_COUNT + 14;

	/**
	 * The operation id for the '<em>Is Starts</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_STARTS = NAMED_ELEMENT_OPERATION_COUNT + 15;

	/**
	 * The operation id for the '<em>Is Precedes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_PRECEDES = NAMED_ELEMENT_OPERATION_COUNT + 16;

	/**
	 * The operation id for the '<em>Is Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_EQUALS = NAMED_ELEMENT_OPERATION_COUNT + 17;

	/**
	 * The operation id for the '<em>Is Meets</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_MEETS = NAMED_ELEMENT_OPERATION_COUNT + 18;

	/**
	 * The operation id for the '<em>Is Finishes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_FINISHES = NAMED_ELEMENT_OPERATION_COUNT + 19;

	/**
	 * The operation id for the '<em>Is Overlaps</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_OVERLAPS = NAMED_ELEMENT_OPERATION_COUNT + 20;

	/**
	 * The operation id for the '<em>Is During</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_DURING = NAMED_ELEMENT_OPERATION_COUNT + 21;

	/**
	 * The operation id for the '<em>Is Meronymic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_MERONYMIC = NAMED_ELEMENT_OPERATION_COUNT + 22;

	/**
	 * The operation id for the '<em>Source End Point</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___SOURCE_END_POINT = NAMED_ELEMENT_OPERATION_COUNT + 23;

	/**
	 * The operation id for the '<em>Target End Point</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___TARGET_END_POINT = NAMED_ELEMENT_OPERATION_COUNT + 24;

	/**
	 * The operation id for the '<em>Is Derived</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_DERIVED = NAMED_ELEMENT_OPERATION_COUNT + 25;

	/**
	 * The operation id for the '<em>Source Class</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___SOURCE_CLASS = NAMED_ELEMENT_OPERATION_COUNT + 26;

	/**
	 * The operation id for the '<em>Target Class</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___TARGET_CLASS = NAMED_ELEMENT_OPERATION_COUNT + 27;

	/**
	 * The operation id for the '<em>Is Part Essential</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_PART_ESSENTIAL = NAMED_ELEMENT_OPERATION_COUNT + 28;

	/**
	 * The operation id for the '<em>Is Part Inseparable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_PART_INSEPARABLE = NAMED_ELEMENT_OPERATION_COUNT + 29;

	/**
	 * The operation id for the '<em>Is Part Immutable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_PART_IMMUTABLE = NAMED_ELEMENT_OPERATION_COUNT + 30;

	/**
	 * The operation id for the '<em>Is Whole Immutable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_WHOLE_IMMUTABLE = NAMED_ELEMENT_OPERATION_COUNT + 31;

	/**
	 * The operation id for the '<em>Is Part Mandatory</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_PART_MANDATORY = NAMED_ELEMENT_OPERATION_COUNT + 32;

	/**
	 * The operation id for the '<em>Is Whole Mandatory</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP___IS_WHOLE_MANDATORY = NAMED_ELEMENT_OPERATION_COUNT + 33;

	/**
	 * The number of operations of the '<em>Binary Class Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINARY_CLASS_RELATIONSHIP_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 34;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.DerivationRelationshipImpl <em>Derivation Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.DerivationRelationshipImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getDerivationRelationship()
	 * @generated
	 */
	int DERIVATION_RELATIONSHIP = 17;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP__HOLDER = BINARY_RELATIONSHIP__HOLDER;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP__COMMENTS = BINARY_RELATIONSHIP__COMMENTS;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP__STEREOTYPE = BINARY_RELATIONSHIP__STEREOTYPE;

	/**
	 * The feature id for the '<em><b>Allen Relation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP__ALLEN_RELATION = BINARY_RELATIONSHIP__ALLEN_RELATION;

	/**
	 * The feature id for the '<em><b>End Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP__END_POINTS = BINARY_RELATIONSHIP__END_POINTS;

	/**
	 * The feature id for the '<em><b>Truth Maker</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP__TRUTH_MAKER = BINARY_RELATIONSHIP__TRUTH_MAKER;

	/**
	 * The number of structural features of the '<em>Derivation Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP_FEATURE_COUNT = BINARY_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Shareable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___IS_SHAREABLE = BINARY_RELATIONSHIP___IS_SHAREABLE;

	/**
	 * The operation id for the '<em>Is Component Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___IS_COMPONENT_OF = BINARY_RELATIONSHIP___IS_COMPONENT_OF;

	/**
	 * The operation id for the '<em>Is Member Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___IS_MEMBER_OF = BINARY_RELATIONSHIP___IS_MEMBER_OF;

	/**
	 * The operation id for the '<em>Is Sub Collection Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___IS_SUB_COLLECTION_OF = BINARY_RELATIONSHIP___IS_SUB_COLLECTION_OF;

	/**
	 * The operation id for the '<em>Is Sub Quantity Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___IS_SUB_QUANTITY_OF = BINARY_RELATIONSHIP___IS_SUB_QUANTITY_OF;

	/**
	 * The operation id for the '<em>Is Constitution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___IS_CONSTITUTION = BINARY_RELATIONSHIP___IS_CONSTITUTION;

	/**
	 * The operation id for the '<em>Is Characterization</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___IS_CHARACTERIZATION = BINARY_RELATIONSHIP___IS_CHARACTERIZATION;

	/**
	 * The operation id for the '<em>Is Mediation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___IS_MEDIATION = BINARY_RELATIONSHIP___IS_MEDIATION;

	/**
	 * The operation id for the '<em>Is Material</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___IS_MATERIAL = BINARY_RELATIONSHIP___IS_MATERIAL;

	/**
	 * The operation id for the '<em>Is Formal</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___IS_FORMAL = BINARY_RELATIONSHIP___IS_FORMAL;

	/**
	 * The operation id for the '<em>Is Structuration</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___IS_STRUCTURATION = BINARY_RELATIONSHIP___IS_STRUCTURATION;

	/**
	 * The operation id for the '<em>Is Participation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___IS_PARTICIPATION = BINARY_RELATIONSHIP___IS_PARTICIPATION;

	/**
	 * The operation id for the '<em>Is Sub Event Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___IS_SUB_EVENT_OF = BINARY_RELATIONSHIP___IS_SUB_EVENT_OF;

	/**
	 * The operation id for the '<em>Is Causation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___IS_CAUSATION = BINARY_RELATIONSHIP___IS_CAUSATION;

	/**
	 * The operation id for the '<em>Is Temporal</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___IS_TEMPORAL = BINARY_RELATIONSHIP___IS_TEMPORAL;

	/**
	 * The operation id for the '<em>Is Starts</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___IS_STARTS = BINARY_RELATIONSHIP___IS_STARTS;

	/**
	 * The operation id for the '<em>Is Precedes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___IS_PRECEDES = BINARY_RELATIONSHIP___IS_PRECEDES;

	/**
	 * The operation id for the '<em>Is Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___IS_EQUALS = BINARY_RELATIONSHIP___IS_EQUALS;

	/**
	 * The operation id for the '<em>Is Meets</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___IS_MEETS = BINARY_RELATIONSHIP___IS_MEETS;

	/**
	 * The operation id for the '<em>Is Finishes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___IS_FINISHES = BINARY_RELATIONSHIP___IS_FINISHES;

	/**
	 * The operation id for the '<em>Is Overlaps</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___IS_OVERLAPS = BINARY_RELATIONSHIP___IS_OVERLAPS;

	/**
	 * The operation id for the '<em>Is During</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___IS_DURING = BINARY_RELATIONSHIP___IS_DURING;

	/**
	 * The operation id for the '<em>Is Meronymic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___IS_MERONYMIC = BINARY_RELATIONSHIP___IS_MERONYMIC;

	/**
	 * The operation id for the '<em>Source End Point</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___SOURCE_END_POINT = BINARY_RELATIONSHIP___SOURCE_END_POINT;

	/**
	 * The operation id for the '<em>Target End Point</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___TARGET_END_POINT = BINARY_RELATIONSHIP___TARGET_END_POINT;

	/**
	 * The operation id for the '<em>Is Derived</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___IS_DERIVED = BINARY_RELATIONSHIP___IS_DERIVED;

	/**
	 * The operation id for the '<em>Source Relationship</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___SOURCE_RELATIONSHIP = BINARY_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Target Class</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP___TARGET_CLASS = BINARY_RELATIONSHIP_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Derivation Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATION_RELATIONSHIP_OPERATION_COUNT = BINARY_RELATIONSHIP_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.NAryClassRelationshipImpl <em>NAry Class Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.NAryClassRelationshipImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getNAryClassRelationship()
	 * @generated
	 */
	int NARY_CLASS_RELATIONSHIP = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP__HOLDER = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP__COMMENTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP__STEREOTYPE = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Allen Relation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP__ALLEN_RELATION = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>End Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP__END_POINTS = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Truth Maker</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP__TRUTH_MAKER = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>NAry Class Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Is Shareable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP___IS_SHAREABLE = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Component Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP___IS_COMPONENT_OF = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Member Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP___IS_MEMBER_OF = NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Sub Collection Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP___IS_SUB_COLLECTION_OF = NAMED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Sub Quantity Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP___IS_SUB_QUANTITY_OF = NAMED_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Constitution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP___IS_CONSTITUTION = NAMED_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Is Characterization</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP___IS_CHARACTERIZATION = NAMED_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Is Mediation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP___IS_MEDIATION = NAMED_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Is Material</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP___IS_MATERIAL = NAMED_ELEMENT_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Is Formal</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP___IS_FORMAL = NAMED_ELEMENT_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Is Structuration</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP___IS_STRUCTURATION = NAMED_ELEMENT_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Is Participation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP___IS_PARTICIPATION = NAMED_ELEMENT_OPERATION_COUNT + 11;

	/**
	 * The operation id for the '<em>Is Sub Event Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP___IS_SUB_EVENT_OF = NAMED_ELEMENT_OPERATION_COUNT + 12;

	/**
	 * The operation id for the '<em>Is Causation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP___IS_CAUSATION = NAMED_ELEMENT_OPERATION_COUNT + 13;

	/**
	 * The operation id for the '<em>Is Temporal</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP___IS_TEMPORAL = NAMED_ELEMENT_OPERATION_COUNT + 14;

	/**
	 * The operation id for the '<em>Is Starts</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP___IS_STARTS = NAMED_ELEMENT_OPERATION_COUNT + 15;

	/**
	 * The operation id for the '<em>Is Precedes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP___IS_PRECEDES = NAMED_ELEMENT_OPERATION_COUNT + 16;

	/**
	 * The operation id for the '<em>Is Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP___IS_EQUALS = NAMED_ELEMENT_OPERATION_COUNT + 17;

	/**
	 * The operation id for the '<em>Is Meets</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP___IS_MEETS = NAMED_ELEMENT_OPERATION_COUNT + 18;

	/**
	 * The operation id for the '<em>Is Finishes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP___IS_FINISHES = NAMED_ELEMENT_OPERATION_COUNT + 19;

	/**
	 * The operation id for the '<em>Is Overlaps</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP___IS_OVERLAPS = NAMED_ELEMENT_OPERATION_COUNT + 20;

	/**
	 * The operation id for the '<em>Is During</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP___IS_DURING = NAMED_ELEMENT_OPERATION_COUNT + 21;

	/**
	 * The operation id for the '<em>Is Meronymic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP___IS_MERONYMIC = NAMED_ELEMENT_OPERATION_COUNT + 22;

	/**
	 * The number of operations of the '<em>NAry Class Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NARY_CLASS_RELATIONSHIP_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 23;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.MeasurementDomainImpl <em>Measurement Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.MeasurementDomainImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getMeasurementDomain()
	 * @generated
	 */
	int MEASUREMENT_DOMAIN = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_DOMAIN__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_DOMAIN__HOLDER = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_DOMAIN__COMMENTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dimensions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_DOMAIN__DIMENSIONS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Measurement Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_DOMAIN_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Measurement Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_DOMAIN_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.MeasurementDimensionImpl <em>Measurement Dimension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.MeasurementDimensionImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getMeasurementDimension()
	 * @generated
	 */
	int MEASUREMENT_DIMENSION = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_DIMENSION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_DIMENSION__HOLDER = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_DIMENSION__COMMENTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_DIMENSION__LOWER_BOUND = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_DIMENSION__UPPER_BOUND = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Unit Of Measure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_DIMENSION__UNIT_OF_MEASURE = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Dimension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_DIMENSION__DIMENSION = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Measurement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_DIMENSION__MEASUREMENT = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_DIMENSION__OWNER = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Measurement Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_DIMENSION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>Measurement Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_DIMENSION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.NominalDimensionImpl <em>Nominal Dimension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.NominalDimensionImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getNominalDimension()
	 * @generated
	 */
	int NOMINAL_DIMENSION = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMINAL_DIMENSION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMINAL_DIMENSION__HOLDER = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMINAL_DIMENSION__COMMENTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Nominal Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMINAL_DIMENSION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Nominal Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOMINAL_DIMENSION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.MeasurementRegionImpl <em>Measurement Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.MeasurementRegionImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getMeasurementRegion()
	 * @generated
	 */
	int MEASUREMENT_REGION = 22;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_REGION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_REGION__HOLDER = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_REGION__COMMENTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Region</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_REGION__REGION = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Measurement Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_REGION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Measurement Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_REGION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.StringNominalRegionImpl <em>String Nominal Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.StringNominalRegionImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getStringNominalRegion()
	 * @generated
	 */
	int STRING_NOMINAL_REGION = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_NOMINAL_REGION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_NOMINAL_REGION__HOLDER = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_NOMINAL_REGION__COMMENTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>String Nominal Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_NOMINAL_REGION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>String Nominal Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_NOMINAL_REGION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.MeasurementEnumerationImpl <em>Measurement Enumeration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.MeasurementEnumerationImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getMeasurementEnumeration()
	 * @generated
	 */
	int MEASUREMENT_ENUMERATION = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_ENUMERATION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_ENUMERATION__HOLDER = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_ENUMERATION__COMMENTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Measurement Enumeration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_ENUMERATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Measurement Enumeration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEASUREMENT_ENUMERATION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.Universal <em>Universal</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.Universal
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getUniversal()
	 * @generated
	 */
	int UNIVERSAL = 25;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.Quality <em>Quality</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.Quality
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getQuality()
	 * @generated
	 */
	int QUALITY = 26;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.Primitive <em>Primitive</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.Primitive
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getPrimitive()
	 * @generated
	 */
	int PRIMITIVE = 27;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.Relation <em>Relation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.Relation
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getRelation()
	 * @generated
	 */
	int RELATION = 28;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.AllenRelation <em>Allen Relation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.AllenRelation
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getAllenRelation()
	 * @generated
	 */
	int ALLEN_RELATION = 29;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.DimensionType <em>Dimension Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.DimensionType
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getDimensionType()
	 * @generated
	 */
	int DIMENSION_TYPE = 30;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.MeasurementType <em>Measurement Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.MeasurementType
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getMeasurementType()
	 * @generated
	 */
	int MEASUREMENT_TYPE = 31;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.Region <em>Region</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.Region
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getRegion()
	 * @generated
	 */
	int REGION = 32;


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
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.ContainedElement <em>Contained Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contained Element</em>'.
	 * @see net.menthor.metamodel.ontouml.ContainedElement
	 * @generated
	 */
	EClass getContainedElement();

	/**
	 * Returns the meta object for the container reference '{@link net.menthor.metamodel.ontouml.ContainedElement#getHolder <em>Holder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Holder</em>'.
	 * @see net.menthor.metamodel.ontouml.ContainedElement#getHolder()
	 * @see #getContainedElement()
	 * @generated
	 */
	EReference getContainedElement_Holder();

	/**
	 * Returns the meta object for the containment reference list '{@link net.menthor.metamodel.ontouml.ContainedElement#getComments <em>Comments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Comments</em>'.
	 * @see net.menthor.metamodel.ontouml.ContainedElement#getComments()
	 * @see #getContainedElement()
	 * @generated
	 */
	EReference getContainedElement_Comments();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.Comment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comment</em>'.
	 * @see net.menthor.metamodel.ontouml.Comment
	 * @generated
	 */
	EClass getComment();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.Comment#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see net.menthor.metamodel.ontouml.Comment#getContent()
	 * @see #getComment()
	 * @generated
	 */
	EAttribute getComment_Content();

	/**
	 * Returns the meta object for the container reference '{@link net.menthor.metamodel.ontouml.Comment#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see net.menthor.metamodel.ontouml.Comment#getOwner()
	 * @see #getComment()
	 * @generated
	 */
	EReference getComment_Owner();

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
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.ClassifierElement <em>Classifier Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier Element</em>'.
	 * @see net.menthor.metamodel.ontouml.ClassifierElement
	 * @generated
	 */
	EClass getClassifierElement();

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
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.Class#getQualityType <em>Quality Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Quality Type</em>'.
	 * @see net.menthor.metamodel.ontouml.Class#getQualityType()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_QualityType();

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
	 * Returns the meta object for the containment reference list '{@link net.menthor.metamodel.ontouml.Class#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see net.menthor.metamodel.ontouml.Class#getAttributes()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Attributes();

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
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isKind() <em>Is Kind</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Kind</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isKind()
	 * @generated
	 */
	EOperation getClass__IsKind();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isSubKind() <em>Is Sub Kind</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Sub Kind</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isSubKind()
	 * @generated
	 */
	EOperation getClass__IsSubKind();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isCollective() <em>Is Collective</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Collective</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isCollective()
	 * @generated
	 */
	EOperation getClass__IsCollective();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isQuantity() <em>Is Quantity</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Quantity</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isQuantity()
	 * @generated
	 */
	EOperation getClass__IsQuantity();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isRelator() <em>Is Relator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Relator</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isRelator()
	 * @generated
	 */
	EOperation getClass__IsRelator();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isMode() <em>Is Mode</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Mode</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isMode()
	 * @generated
	 */
	EOperation getClass__IsMode();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isQuality() <em>Is Quality</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Quality</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isQuality()
	 * @generated
	 */
	EOperation getClass__IsQuality();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isRole() <em>Is Role</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Role</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isRole()
	 * @generated
	 */
	EOperation getClass__IsRole();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isRoleMixin() <em>Is Role Mixin</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Role Mixin</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isRoleMixin()
	 * @generated
	 */
	EOperation getClass__IsRoleMixin();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isPhaseMixin() <em>Is Phase Mixin</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Phase Mixin</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isPhaseMixin()
	 * @generated
	 */
	EOperation getClass__IsPhaseMixin();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isPhase() <em>Is Phase</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Phase</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isPhase()
	 * @generated
	 */
	EOperation getClass__IsPhase();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isCategory() <em>Is Category</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Category</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isCategory()
	 * @generated
	 */
	EOperation getClass__IsCategory();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isMixin() <em>Is Mixin</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Mixin</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isMixin()
	 * @generated
	 */
	EOperation getClass__IsMixin();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isEvent() <em>Is Event</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Event</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isEvent()
	 * @generated
	 */
	EOperation getClass__IsEvent();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isHighOrder() <em>Is High Order</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is High Order</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isHighOrder()
	 * @generated
	 */
	EOperation getClass__IsHighOrder();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isDataType() <em>Is Data Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Data Type</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isDataType()
	 * @generated
	 */
	EOperation getClass__IsDataType();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isEnumeration() <em>Is Enumeration</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Enumeration</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isEnumeration()
	 * @generated
	 */
	EOperation getClass__IsEnumeration();

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
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#children() <em>Children</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Children</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#children()
	 * @generated
	 */
	EOperation getClass__Children();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#parents() <em>Parents</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Parents</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#parents()
	 * @generated
	 */
	EOperation getClass__Parents();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#identidyProvider() <em>Identidy Provider</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Identidy Provider</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#identidyProvider()
	 * @generated
	 */
	EOperation getClass__IdentidyProvider();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isFunctionalComplex() <em>Is Functional Complex</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Functional Complex</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isFunctionalComplex()
	 * @generated
	 */
	EOperation getClass__IsFunctionalComplex();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isCollection() <em>Is Collection</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Collection</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isCollection()
	 * @generated
	 */
	EOperation getClass__IsCollection();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isAmountOfMatter() <em>Is Amount Of Matter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Amount Of Matter</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isAmountOfMatter()
	 * @generated
	 */
	EOperation getClass__IsAmountOfMatter();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isIntrinsic() <em>Is Intrinsic</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Intrinsic</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isIntrinsic()
	 * @generated
	 */
	EOperation getClass__IsIntrinsic();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isTruthMaker() <em>Is Truth Maker</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Truth Maker</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isTruthMaker()
	 * @generated
	 */
	EOperation getClass__IsTruthMaker();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#setIsExtensional() <em>Set Is Extensional</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Set Is Extensional</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#setIsExtensional()
	 * @generated
	 */
	EOperation getClass__SetIsExtensional();

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
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.Property#isIsOrdered <em>Is Ordered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Ordered</em>'.
	 * @see net.menthor.metamodel.ontouml.Property#isIsOrdered()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsOrdered();

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
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.Property#isIsDependee <em>Is Dependee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Dependee</em>'.
	 * @see net.menthor.metamodel.ontouml.Property#isIsDependee()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsDependee();

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
	 * Returns the meta object for the container reference '{@link net.menthor.metamodel.ontouml.EndPoint#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see net.menthor.metamodel.ontouml.EndPoint#getOwner()
	 * @see #getEndPoint()
	 * @generated
	 */
	EReference getEndPoint_Owner();

	/**
	 * Returns the meta object for the reference '{@link net.menthor.metamodel.ontouml.EndPoint#getEndType <em>End Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End Type</em>'.
	 * @see net.menthor.metamodel.ontouml.EndPoint#getEndType()
	 * @see #getEndPoint()
	 * @generated
	 */
	EReference getEndPoint_EndType();

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
	 * Returns the meta object for the reference list '{@link net.menthor.metamodel.ontouml.EndPoint#getIsRedefinedBy <em>Is Redefined By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Is Redefined By</em>'.
	 * @see net.menthor.metamodel.ontouml.EndPoint#getIsRedefinedBy()
	 * @see #getEndPoint()
	 * @generated
	 */
	EReference getEndPoint_IsRedefinedBy();

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
	 * Returns the meta object for the container reference '{@link net.menthor.metamodel.ontouml.Attribute#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see net.menthor.metamodel.ontouml.Attribute#getOwner()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_Owner();

	/**
	 * Returns the meta object for the reference '{@link net.menthor.metamodel.ontouml.Attribute#getPrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Primitive Type</em>'.
	 * @see net.menthor.metamodel.ontouml.Attribute#getPrimitiveType()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_PrimitiveType();

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
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.PrimitiveType#getPrimitive <em>Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primitive</em>'.
	 * @see net.menthor.metamodel.ontouml.PrimitiveType#getPrimitive()
	 * @see #getPrimitiveType()
	 * @generated
	 */
	EAttribute getPrimitiveType_Primitive();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.Relationship <em>Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relationship</em>'.
	 * @see net.menthor.metamodel.ontouml.Relationship
	 * @generated
	 */
	EClass getRelationship();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.Relationship#getStereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stereotype</em>'.
	 * @see net.menthor.metamodel.ontouml.Relationship#getStereotype()
	 * @see #getRelationship()
	 * @generated
	 */
	EAttribute getRelationship_Stereotype();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.Relationship#getAllenRelation <em>Allen Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allen Relation</em>'.
	 * @see net.menthor.metamodel.ontouml.Relationship#getAllenRelation()
	 * @see #getRelationship()
	 * @generated
	 */
	EAttribute getRelationship_AllenRelation();

	/**
	 * Returns the meta object for the containment reference list '{@link net.menthor.metamodel.ontouml.Relationship#getEndPoints <em>End Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>End Points</em>'.
	 * @see net.menthor.metamodel.ontouml.Relationship#getEndPoints()
	 * @see #getRelationship()
	 * @generated
	 */
	EReference getRelationship_EndPoints();

	/**
	 * Returns the meta object for the reference '{@link net.menthor.metamodel.ontouml.Relationship#getTruthMaker <em>Truth Maker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Truth Maker</em>'.
	 * @see net.menthor.metamodel.ontouml.Relationship#getTruthMaker()
	 * @see #getRelationship()
	 * @generated
	 */
	EReference getRelationship_TruthMaker();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isShareable() <em>Is Shareable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Shareable</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isShareable()
	 * @generated
	 */
	EOperation getRelationship__IsShareable();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isComponentOf() <em>Is Component Of</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Component Of</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isComponentOf()
	 * @generated
	 */
	EOperation getRelationship__IsComponentOf();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isMemberOf() <em>Is Member Of</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Member Of</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isMemberOf()
	 * @generated
	 */
	EOperation getRelationship__IsMemberOf();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isSubCollectionOf() <em>Is Sub Collection Of</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Sub Collection Of</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isSubCollectionOf()
	 * @generated
	 */
	EOperation getRelationship__IsSubCollectionOf();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isSubQuantityOf() <em>Is Sub Quantity Of</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Sub Quantity Of</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isSubQuantityOf()
	 * @generated
	 */
	EOperation getRelationship__IsSubQuantityOf();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isConstitution() <em>Is Constitution</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Constitution</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isConstitution()
	 * @generated
	 */
	EOperation getRelationship__IsConstitution();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isCharacterization() <em>Is Characterization</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Characterization</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isCharacterization()
	 * @generated
	 */
	EOperation getRelationship__IsCharacterization();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isMediation() <em>Is Mediation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Mediation</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isMediation()
	 * @generated
	 */
	EOperation getRelationship__IsMediation();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isMaterial() <em>Is Material</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Material</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isMaterial()
	 * @generated
	 */
	EOperation getRelationship__IsMaterial();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isFormal() <em>Is Formal</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Formal</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isFormal()
	 * @generated
	 */
	EOperation getRelationship__IsFormal();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isStructuration() <em>Is Structuration</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Structuration</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isStructuration()
	 * @generated
	 */
	EOperation getRelationship__IsStructuration();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isParticipation() <em>Is Participation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Participation</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isParticipation()
	 * @generated
	 */
	EOperation getRelationship__IsParticipation();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isSubEventOf() <em>Is Sub Event Of</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Sub Event Of</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isSubEventOf()
	 * @generated
	 */
	EOperation getRelationship__IsSubEventOf();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isCausation() <em>Is Causation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Causation</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isCausation()
	 * @generated
	 */
	EOperation getRelationship__IsCausation();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isTemporal() <em>Is Temporal</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Temporal</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isTemporal()
	 * @generated
	 */
	EOperation getRelationship__IsTemporal();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isStarts() <em>Is Starts</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Starts</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isStarts()
	 * @generated
	 */
	EOperation getRelationship__IsStarts();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isPrecedes() <em>Is Precedes</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Precedes</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isPrecedes()
	 * @generated
	 */
	EOperation getRelationship__IsPrecedes();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isEquals() <em>Is Equals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Equals</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isEquals()
	 * @generated
	 */
	EOperation getRelationship__IsEquals();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isMeets() <em>Is Meets</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Meets</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isMeets()
	 * @generated
	 */
	EOperation getRelationship__IsMeets();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isFinishes() <em>Is Finishes</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Finishes</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isFinishes()
	 * @generated
	 */
	EOperation getRelationship__IsFinishes();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isOverlaps() <em>Is Overlaps</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Overlaps</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isOverlaps()
	 * @generated
	 */
	EOperation getRelationship__IsOverlaps();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isDuring() <em>Is During</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is During</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isDuring()
	 * @generated
	 */
	EOperation getRelationship__IsDuring();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isMeronymic() <em>Is Meronymic</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Meronymic</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isMeronymic()
	 * @generated
	 */
	EOperation getRelationship__IsMeronymic();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.BinaryRelationship <em>Binary Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Relationship</em>'.
	 * @see net.menthor.metamodel.ontouml.BinaryRelationship
	 * @generated
	 */
	EClass getBinaryRelationship();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.BinaryRelationship#sourceEndPoint() <em>Source End Point</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Source End Point</em>' operation.
	 * @see net.menthor.metamodel.ontouml.BinaryRelationship#sourceEndPoint()
	 * @generated
	 */
	EOperation getBinaryRelationship__SourceEndPoint();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.BinaryRelationship#targetEndPoint() <em>Target End Point</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Target End Point</em>' operation.
	 * @see net.menthor.metamodel.ontouml.BinaryRelationship#targetEndPoint()
	 * @generated
	 */
	EOperation getBinaryRelationship__TargetEndPoint();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.BinaryRelationship#isDerived() <em>Is Derived</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Derived</em>' operation.
	 * @see net.menthor.metamodel.ontouml.BinaryRelationship#isDerived()
	 * @generated
	 */
	EOperation getBinaryRelationship__IsDerived();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.BinaryClassRelationship <em>Binary Class Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binary Class Relationship</em>'.
	 * @see net.menthor.metamodel.ontouml.BinaryClassRelationship
	 * @generated
	 */
	EClass getBinaryClassRelationship();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.BinaryClassRelationship#sourceClass() <em>Source Class</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Source Class</em>' operation.
	 * @see net.menthor.metamodel.ontouml.BinaryClassRelationship#sourceClass()
	 * @generated
	 */
	EOperation getBinaryClassRelationship__SourceClass();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.BinaryClassRelationship#targetClass() <em>Target Class</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Target Class</em>' operation.
	 * @see net.menthor.metamodel.ontouml.BinaryClassRelationship#targetClass()
	 * @generated
	 */
	EOperation getBinaryClassRelationship__TargetClass();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.BinaryClassRelationship#isPartEssential() <em>Is Part Essential</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Part Essential</em>' operation.
	 * @see net.menthor.metamodel.ontouml.BinaryClassRelationship#isPartEssential()
	 * @generated
	 */
	EOperation getBinaryClassRelationship__IsPartEssential();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.BinaryClassRelationship#isPartInseparable() <em>Is Part Inseparable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Part Inseparable</em>' operation.
	 * @see net.menthor.metamodel.ontouml.BinaryClassRelationship#isPartInseparable()
	 * @generated
	 */
	EOperation getBinaryClassRelationship__IsPartInseparable();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.BinaryClassRelationship#isPartImmutable() <em>Is Part Immutable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Part Immutable</em>' operation.
	 * @see net.menthor.metamodel.ontouml.BinaryClassRelationship#isPartImmutable()
	 * @generated
	 */
	EOperation getBinaryClassRelationship__IsPartImmutable();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.BinaryClassRelationship#isWholeImmutable() <em>Is Whole Immutable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Whole Immutable</em>' operation.
	 * @see net.menthor.metamodel.ontouml.BinaryClassRelationship#isWholeImmutable()
	 * @generated
	 */
	EOperation getBinaryClassRelationship__IsWholeImmutable();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.BinaryClassRelationship#isPartMandatory() <em>Is Part Mandatory</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Part Mandatory</em>' operation.
	 * @see net.menthor.metamodel.ontouml.BinaryClassRelationship#isPartMandatory()
	 * @generated
	 */
	EOperation getBinaryClassRelationship__IsPartMandatory();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.BinaryClassRelationship#isWholeMandatory() <em>Is Whole Mandatory</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Whole Mandatory</em>' operation.
	 * @see net.menthor.metamodel.ontouml.BinaryClassRelationship#isWholeMandatory()
	 * @generated
	 */
	EOperation getBinaryClassRelationship__IsWholeMandatory();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.DerivationRelationship <em>Derivation Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Derivation Relationship</em>'.
	 * @see net.menthor.metamodel.ontouml.DerivationRelationship
	 * @generated
	 */
	EClass getDerivationRelationship();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.DerivationRelationship#sourceRelationship() <em>Source Relationship</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Source Relationship</em>' operation.
	 * @see net.menthor.metamodel.ontouml.DerivationRelationship#sourceRelationship()
	 * @generated
	 */
	EOperation getDerivationRelationship__SourceRelationship();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.DerivationRelationship#targetClass() <em>Target Class</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Target Class</em>' operation.
	 * @see net.menthor.metamodel.ontouml.DerivationRelationship#targetClass()
	 * @generated
	 */
	EOperation getDerivationRelationship__TargetClass();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.NAryClassRelationship <em>NAry Class Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>NAry Class Relationship</em>'.
	 * @see net.menthor.metamodel.ontouml.NAryClassRelationship
	 * @generated
	 */
	EClass getNAryClassRelationship();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.MeasurementDomain <em>Measurement Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measurement Domain</em>'.
	 * @see net.menthor.metamodel.ontouml.MeasurementDomain
	 * @generated
	 */
	EClass getMeasurementDomain();

	/**
	 * Returns the meta object for the reference list '{@link net.menthor.metamodel.ontouml.MeasurementDomain#getDimensions <em>Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dimensions</em>'.
	 * @see net.menthor.metamodel.ontouml.MeasurementDomain#getDimensions()
	 * @see #getMeasurementDomain()
	 * @generated
	 */
	EReference getMeasurementDomain_Dimensions();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.MeasurementDimension <em>Measurement Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measurement Dimension</em>'.
	 * @see net.menthor.metamodel.ontouml.MeasurementDimension
	 * @generated
	 */
	EClass getMeasurementDimension();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.MeasurementDimension#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see net.menthor.metamodel.ontouml.MeasurementDimension#getLowerBound()
	 * @see #getMeasurementDimension()
	 * @generated
	 */
	EAttribute getMeasurementDimension_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.MeasurementDimension#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see net.menthor.metamodel.ontouml.MeasurementDimension#getUpperBound()
	 * @see #getMeasurementDimension()
	 * @generated
	 */
	EAttribute getMeasurementDimension_UpperBound();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.MeasurementDimension#getUnitOfMeasure <em>Unit Of Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit Of Measure</em>'.
	 * @see net.menthor.metamodel.ontouml.MeasurementDimension#getUnitOfMeasure()
	 * @see #getMeasurementDimension()
	 * @generated
	 */
	EAttribute getMeasurementDimension_UnitOfMeasure();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.MeasurementDimension#getDimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dimension</em>'.
	 * @see net.menthor.metamodel.ontouml.MeasurementDimension#getDimension()
	 * @see #getMeasurementDimension()
	 * @generated
	 */
	EAttribute getMeasurementDimension_Dimension();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.MeasurementDimension#getMeasurement <em>Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Measurement</em>'.
	 * @see net.menthor.metamodel.ontouml.MeasurementDimension#getMeasurement()
	 * @see #getMeasurementDimension()
	 * @generated
	 */
	EAttribute getMeasurementDimension_Measurement();

	/**
	 * Returns the meta object for the reference '{@link net.menthor.metamodel.ontouml.MeasurementDimension#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see net.menthor.metamodel.ontouml.MeasurementDimension#getOwner()
	 * @see #getMeasurementDimension()
	 * @generated
	 */
	EReference getMeasurementDimension_Owner();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.NominalDimension <em>Nominal Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nominal Dimension</em>'.
	 * @see net.menthor.metamodel.ontouml.NominalDimension
	 * @generated
	 */
	EClass getNominalDimension();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.MeasurementRegion <em>Measurement Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measurement Region</em>'.
	 * @see net.menthor.metamodel.ontouml.MeasurementRegion
	 * @generated
	 */
	EClass getMeasurementRegion();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.MeasurementRegion#getRegion <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Region</em>'.
	 * @see net.menthor.metamodel.ontouml.MeasurementRegion#getRegion()
	 * @see #getMeasurementRegion()
	 * @generated
	 */
	EAttribute getMeasurementRegion_Region();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.StringNominalRegion <em>String Nominal Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Nominal Region</em>'.
	 * @see net.menthor.metamodel.ontouml.StringNominalRegion
	 * @generated
	 */
	EClass getStringNominalRegion();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.MeasurementEnumeration <em>Measurement Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Measurement Enumeration</em>'.
	 * @see net.menthor.metamodel.ontouml.MeasurementEnumeration
	 * @generated
	 */
	EClass getMeasurementEnumeration();

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
	 * Returns the meta object for enum '{@link net.menthor.metamodel.ontouml.Quality <em>Quality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Quality</em>'.
	 * @see net.menthor.metamodel.ontouml.Quality
	 * @generated
	 */
	EEnum getQuality();

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
	 * Returns the meta object for enum '{@link net.menthor.metamodel.ontouml.AllenRelation <em>Allen Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Allen Relation</em>'.
	 * @see net.menthor.metamodel.ontouml.AllenRelation
	 * @generated
	 */
	EEnum getAllenRelation();

	/**
	 * Returns the meta object for enum '{@link net.menthor.metamodel.ontouml.DimensionType <em>Dimension Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Dimension Type</em>'.
	 * @see net.menthor.metamodel.ontouml.DimensionType
	 * @generated
	 */
	EEnum getDimensionType();

	/**
	 * Returns the meta object for enum '{@link net.menthor.metamodel.ontouml.MeasurementType <em>Measurement Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Measurement Type</em>'.
	 * @see net.menthor.metamodel.ontouml.MeasurementType
	 * @generated
	 */
	EEnum getMeasurementType();

	/**
	 * Returns the meta object for enum '{@link net.menthor.metamodel.ontouml.Region <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Region</em>'.
	 * @see net.menthor.metamodel.ontouml.Region
	 * @generated
	 */
	EEnum getRegion();

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
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.ContainedElementImpl <em>Contained Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.ContainedElementImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getContainedElement()
		 * @generated
		 */
		EClass CONTAINED_ELEMENT = eINSTANCE.getContainedElement();

		/**
		 * The meta object literal for the '<em><b>Holder</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINED_ELEMENT__HOLDER = eINSTANCE.getContainedElement_Holder();

		/**
		 * The meta object literal for the '<em><b>Comments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINED_ELEMENT__COMMENTS = eINSTANCE.getContainedElement_Comments();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.CommentImpl <em>Comment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.CommentImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getComment()
		 * @generated
		 */
		EClass COMMENT = eINSTANCE.getComment();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMENT__CONTENT = eINSTANCE.getComment_Content();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMENT__OWNER = eINSTANCE.getComment_Owner();

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
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.ClassifierElementImpl <em>Classifier Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.ClassifierElementImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getClassifierElement()
		 * @generated
		 */
		EClass CLASSIFIER_ELEMENT = eINSTANCE.getClassifierElement();

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
		 * The meta object literal for the '<em><b>Quality Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__QUALITY_TYPE = eINSTANCE.getClass_QualityType();

		/**
		 * The meta object literal for the '<em><b>Enumeration Literals</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__ENUMERATION_LITERALS = eINSTANCE.getClass_EnumerationLiterals();

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
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__ATTRIBUTES = eINSTANCE.getClass_Attributes();

		/**
		 * The meta object literal for the '<em><b>Istruth Maker Of</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__ISTRUTH_MAKER_OF = eINSTANCE.getClass_IstruthMakerOf();

		/**
		 * The meta object literal for the '<em><b>Instance Of</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__INSTANCE_OF = eINSTANCE.getClass_InstanceOf();

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
		 * The meta object literal for the '<em><b>Is Kind</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_KIND = eINSTANCE.getClass__IsKind();

		/**
		 * The meta object literal for the '<em><b>Is Sub Kind</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_SUB_KIND = eINSTANCE.getClass__IsSubKind();

		/**
		 * The meta object literal for the '<em><b>Is Collective</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_COLLECTIVE = eINSTANCE.getClass__IsCollective();

		/**
		 * The meta object literal for the '<em><b>Is Quantity</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_QUANTITY = eINSTANCE.getClass__IsQuantity();

		/**
		 * The meta object literal for the '<em><b>Is Relator</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_RELATOR = eINSTANCE.getClass__IsRelator();

		/**
		 * The meta object literal for the '<em><b>Is Mode</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_MODE = eINSTANCE.getClass__IsMode();

		/**
		 * The meta object literal for the '<em><b>Is Quality</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_QUALITY = eINSTANCE.getClass__IsQuality();

		/**
		 * The meta object literal for the '<em><b>Is Role</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_ROLE = eINSTANCE.getClass__IsRole();

		/**
		 * The meta object literal for the '<em><b>Is Role Mixin</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_ROLE_MIXIN = eINSTANCE.getClass__IsRoleMixin();

		/**
		 * The meta object literal for the '<em><b>Is Phase Mixin</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_PHASE_MIXIN = eINSTANCE.getClass__IsPhaseMixin();

		/**
		 * The meta object literal for the '<em><b>Is Phase</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_PHASE = eINSTANCE.getClass__IsPhase();

		/**
		 * The meta object literal for the '<em><b>Is Category</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_CATEGORY = eINSTANCE.getClass__IsCategory();

		/**
		 * The meta object literal for the '<em><b>Is Mixin</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_MIXIN = eINSTANCE.getClass__IsMixin();

		/**
		 * The meta object literal for the '<em><b>Is Event</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_EVENT = eINSTANCE.getClass__IsEvent();

		/**
		 * The meta object literal for the '<em><b>Is High Order</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_HIGH_ORDER = eINSTANCE.getClass__IsHighOrder();

		/**
		 * The meta object literal for the '<em><b>Is Data Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_DATA_TYPE = eINSTANCE.getClass__IsDataType();

		/**
		 * The meta object literal for the '<em><b>Is Enumeration</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_ENUMERATION = eINSTANCE.getClass__IsEnumeration();

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
		 * The meta object literal for the '<em><b>Children</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___CHILDREN = eINSTANCE.getClass__Children();

		/**
		 * The meta object literal for the '<em><b>Parents</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___PARENTS = eINSTANCE.getClass__Parents();

		/**
		 * The meta object literal for the '<em><b>Identidy Provider</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IDENTIDY_PROVIDER = eINSTANCE.getClass__IdentidyProvider();

		/**
		 * The meta object literal for the '<em><b>Is Functional Complex</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_FUNCTIONAL_COMPLEX = eINSTANCE.getClass__IsFunctionalComplex();

		/**
		 * The meta object literal for the '<em><b>Is Collection</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_COLLECTION = eINSTANCE.getClass__IsCollection();

		/**
		 * The meta object literal for the '<em><b>Is Amount Of Matter</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_AMOUNT_OF_MATTER = eINSTANCE.getClass__IsAmountOfMatter();

		/**
		 * The meta object literal for the '<em><b>Is Intrinsic</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_INTRINSIC = eINSTANCE.getClass__IsIntrinsic();

		/**
		 * The meta object literal for the '<em><b>Is Truth Maker</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_TRUTH_MAKER = eINSTANCE.getClass__IsTruthMaker();

		/**
		 * The meta object literal for the '<em><b>Set Is Extensional</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___SET_IS_EXTENSIONAL = eINSTANCE.getClass__SetIsExtensional();

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
		 * The meta object literal for the '<em><b>Is Ordered</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_ORDERED = eINSTANCE.getProperty_IsOrdered();

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
		 * The meta object literal for the '<em><b>Is Dependee</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_DEPENDEE = eINSTANCE.getProperty_IsDependee();

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
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference END_POINT__OWNER = eINSTANCE.getEndPoint_Owner();

		/**
		 * The meta object literal for the '<em><b>End Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference END_POINT__END_TYPE = eINSTANCE.getEndPoint_EndType();

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
		 * The meta object literal for the '<em><b>Is Redefined By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference END_POINT__IS_REDEFINED_BY = eINSTANCE.getEndPoint_IsRedefinedBy();

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
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__OWNER = eINSTANCE.getAttribute_Owner();

		/**
		 * The meta object literal for the '<em><b>Primitive Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__PRIMITIVE_TYPE = eINSTANCE.getAttribute_PrimitiveType();

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
		 * The meta object literal for the '<em><b>Primitive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_TYPE__PRIMITIVE = eINSTANCE.getPrimitiveType_Primitive();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.RelationshipImpl <em>Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.RelationshipImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getRelationship()
		 * @generated
		 */
		EClass RELATIONSHIP = eINSTANCE.getRelationship();

		/**
		 * The meta object literal for the '<em><b>Stereotype</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATIONSHIP__STEREOTYPE = eINSTANCE.getRelationship_Stereotype();

		/**
		 * The meta object literal for the '<em><b>Allen Relation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATIONSHIP__ALLEN_RELATION = eINSTANCE.getRelationship_AllenRelation();

		/**
		 * The meta object literal for the '<em><b>End Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONSHIP__END_POINTS = eINSTANCE.getRelationship_EndPoints();

		/**
		 * The meta object literal for the '<em><b>Truth Maker</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONSHIP__TRUTH_MAKER = eINSTANCE.getRelationship_TruthMaker();

		/**
		 * The meta object literal for the '<em><b>Is Shareable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_SHAREABLE = eINSTANCE.getRelationship__IsShareable();

		/**
		 * The meta object literal for the '<em><b>Is Component Of</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_COMPONENT_OF = eINSTANCE.getRelationship__IsComponentOf();

		/**
		 * The meta object literal for the '<em><b>Is Member Of</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_MEMBER_OF = eINSTANCE.getRelationship__IsMemberOf();

		/**
		 * The meta object literal for the '<em><b>Is Sub Collection Of</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_SUB_COLLECTION_OF = eINSTANCE.getRelationship__IsSubCollectionOf();

		/**
		 * The meta object literal for the '<em><b>Is Sub Quantity Of</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_SUB_QUANTITY_OF = eINSTANCE.getRelationship__IsSubQuantityOf();

		/**
		 * The meta object literal for the '<em><b>Is Constitution</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_CONSTITUTION = eINSTANCE.getRelationship__IsConstitution();

		/**
		 * The meta object literal for the '<em><b>Is Characterization</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_CHARACTERIZATION = eINSTANCE.getRelationship__IsCharacterization();

		/**
		 * The meta object literal for the '<em><b>Is Mediation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_MEDIATION = eINSTANCE.getRelationship__IsMediation();

		/**
		 * The meta object literal for the '<em><b>Is Material</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_MATERIAL = eINSTANCE.getRelationship__IsMaterial();

		/**
		 * The meta object literal for the '<em><b>Is Formal</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_FORMAL = eINSTANCE.getRelationship__IsFormal();

		/**
		 * The meta object literal for the '<em><b>Is Structuration</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_STRUCTURATION = eINSTANCE.getRelationship__IsStructuration();

		/**
		 * The meta object literal for the '<em><b>Is Participation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_PARTICIPATION = eINSTANCE.getRelationship__IsParticipation();

		/**
		 * The meta object literal for the '<em><b>Is Sub Event Of</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_SUB_EVENT_OF = eINSTANCE.getRelationship__IsSubEventOf();

		/**
		 * The meta object literal for the '<em><b>Is Causation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_CAUSATION = eINSTANCE.getRelationship__IsCausation();

		/**
		 * The meta object literal for the '<em><b>Is Temporal</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_TEMPORAL = eINSTANCE.getRelationship__IsTemporal();

		/**
		 * The meta object literal for the '<em><b>Is Starts</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_STARTS = eINSTANCE.getRelationship__IsStarts();

		/**
		 * The meta object literal for the '<em><b>Is Precedes</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_PRECEDES = eINSTANCE.getRelationship__IsPrecedes();

		/**
		 * The meta object literal for the '<em><b>Is Equals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_EQUALS = eINSTANCE.getRelationship__IsEquals();

		/**
		 * The meta object literal for the '<em><b>Is Meets</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_MEETS = eINSTANCE.getRelationship__IsMeets();

		/**
		 * The meta object literal for the '<em><b>Is Finishes</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_FINISHES = eINSTANCE.getRelationship__IsFinishes();

		/**
		 * The meta object literal for the '<em><b>Is Overlaps</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_OVERLAPS = eINSTANCE.getRelationship__IsOverlaps();

		/**
		 * The meta object literal for the '<em><b>Is During</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_DURING = eINSTANCE.getRelationship__IsDuring();

		/**
		 * The meta object literal for the '<em><b>Is Meronymic</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_MERONYMIC = eINSTANCE.getRelationship__IsMeronymic();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.BinaryRelationshipImpl <em>Binary Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.BinaryRelationshipImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getBinaryRelationship()
		 * @generated
		 */
		EClass BINARY_RELATIONSHIP = eINSTANCE.getBinaryRelationship();

		/**
		 * The meta object literal for the '<em><b>Source End Point</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BINARY_RELATIONSHIP___SOURCE_END_POINT = eINSTANCE.getBinaryRelationship__SourceEndPoint();

		/**
		 * The meta object literal for the '<em><b>Target End Point</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BINARY_RELATIONSHIP___TARGET_END_POINT = eINSTANCE.getBinaryRelationship__TargetEndPoint();

		/**
		 * The meta object literal for the '<em><b>Is Derived</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BINARY_RELATIONSHIP___IS_DERIVED = eINSTANCE.getBinaryRelationship__IsDerived();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.BinaryClassRelationshipImpl <em>Binary Class Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.BinaryClassRelationshipImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getBinaryClassRelationship()
		 * @generated
		 */
		EClass BINARY_CLASS_RELATIONSHIP = eINSTANCE.getBinaryClassRelationship();

		/**
		 * The meta object literal for the '<em><b>Source Class</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BINARY_CLASS_RELATIONSHIP___SOURCE_CLASS = eINSTANCE.getBinaryClassRelationship__SourceClass();

		/**
		 * The meta object literal for the '<em><b>Target Class</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BINARY_CLASS_RELATIONSHIP___TARGET_CLASS = eINSTANCE.getBinaryClassRelationship__TargetClass();

		/**
		 * The meta object literal for the '<em><b>Is Part Essential</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BINARY_CLASS_RELATIONSHIP___IS_PART_ESSENTIAL = eINSTANCE.getBinaryClassRelationship__IsPartEssential();

		/**
		 * The meta object literal for the '<em><b>Is Part Inseparable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BINARY_CLASS_RELATIONSHIP___IS_PART_INSEPARABLE = eINSTANCE.getBinaryClassRelationship__IsPartInseparable();

		/**
		 * The meta object literal for the '<em><b>Is Part Immutable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BINARY_CLASS_RELATIONSHIP___IS_PART_IMMUTABLE = eINSTANCE.getBinaryClassRelationship__IsPartImmutable();

		/**
		 * The meta object literal for the '<em><b>Is Whole Immutable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BINARY_CLASS_RELATIONSHIP___IS_WHOLE_IMMUTABLE = eINSTANCE.getBinaryClassRelationship__IsWholeImmutable();

		/**
		 * The meta object literal for the '<em><b>Is Part Mandatory</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BINARY_CLASS_RELATIONSHIP___IS_PART_MANDATORY = eINSTANCE.getBinaryClassRelationship__IsPartMandatory();

		/**
		 * The meta object literal for the '<em><b>Is Whole Mandatory</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BINARY_CLASS_RELATIONSHIP___IS_WHOLE_MANDATORY = eINSTANCE.getBinaryClassRelationship__IsWholeMandatory();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.DerivationRelationshipImpl <em>Derivation Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.DerivationRelationshipImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getDerivationRelationship()
		 * @generated
		 */
		EClass DERIVATION_RELATIONSHIP = eINSTANCE.getDerivationRelationship();

		/**
		 * The meta object literal for the '<em><b>Source Relationship</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DERIVATION_RELATIONSHIP___SOURCE_RELATIONSHIP = eINSTANCE.getDerivationRelationship__SourceRelationship();

		/**
		 * The meta object literal for the '<em><b>Target Class</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DERIVATION_RELATIONSHIP___TARGET_CLASS = eINSTANCE.getDerivationRelationship__TargetClass();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.NAryClassRelationshipImpl <em>NAry Class Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.NAryClassRelationshipImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getNAryClassRelationship()
		 * @generated
		 */
		EClass NARY_CLASS_RELATIONSHIP = eINSTANCE.getNAryClassRelationship();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.MeasurementDomainImpl <em>Measurement Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.MeasurementDomainImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getMeasurementDomain()
		 * @generated
		 */
		EClass MEASUREMENT_DOMAIN = eINSTANCE.getMeasurementDomain();

		/**
		 * The meta object literal for the '<em><b>Dimensions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASUREMENT_DOMAIN__DIMENSIONS = eINSTANCE.getMeasurementDomain_Dimensions();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.MeasurementDimensionImpl <em>Measurement Dimension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.MeasurementDimensionImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getMeasurementDimension()
		 * @generated
		 */
		EClass MEASUREMENT_DIMENSION = eINSTANCE.getMeasurementDimension();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASUREMENT_DIMENSION__LOWER_BOUND = eINSTANCE.getMeasurementDimension_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASUREMENT_DIMENSION__UPPER_BOUND = eINSTANCE.getMeasurementDimension_UpperBound();

		/**
		 * The meta object literal for the '<em><b>Unit Of Measure</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASUREMENT_DIMENSION__UNIT_OF_MEASURE = eINSTANCE.getMeasurementDimension_UnitOfMeasure();

		/**
		 * The meta object literal for the '<em><b>Dimension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASUREMENT_DIMENSION__DIMENSION = eINSTANCE.getMeasurementDimension_Dimension();

		/**
		 * The meta object literal for the '<em><b>Measurement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASUREMENT_DIMENSION__MEASUREMENT = eINSTANCE.getMeasurementDimension_Measurement();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEASUREMENT_DIMENSION__OWNER = eINSTANCE.getMeasurementDimension_Owner();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.NominalDimensionImpl <em>Nominal Dimension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.NominalDimensionImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getNominalDimension()
		 * @generated
		 */
		EClass NOMINAL_DIMENSION = eINSTANCE.getNominalDimension();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.MeasurementRegionImpl <em>Measurement Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.MeasurementRegionImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getMeasurementRegion()
		 * @generated
		 */
		EClass MEASUREMENT_REGION = eINSTANCE.getMeasurementRegion();

		/**
		 * The meta object literal for the '<em><b>Region</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEASUREMENT_REGION__REGION = eINSTANCE.getMeasurementRegion_Region();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.StringNominalRegionImpl <em>String Nominal Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.StringNominalRegionImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getStringNominalRegion()
		 * @generated
		 */
		EClass STRING_NOMINAL_REGION = eINSTANCE.getStringNominalRegion();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.MeasurementEnumerationImpl <em>Measurement Enumeration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.MeasurementEnumerationImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getMeasurementEnumeration()
		 * @generated
		 */
		EClass MEASUREMENT_ENUMERATION = eINSTANCE.getMeasurementEnumeration();

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
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.Quality <em>Quality</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.Quality
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getQuality()
		 * @generated
		 */
		EEnum QUALITY = eINSTANCE.getQuality();

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

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.AllenRelation <em>Allen Relation</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.AllenRelation
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getAllenRelation()
		 * @generated
		 */
		EEnum ALLEN_RELATION = eINSTANCE.getAllenRelation();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.DimensionType <em>Dimension Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.DimensionType
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getDimensionType()
		 * @generated
		 */
		EEnum DIMENSION_TYPE = eINSTANCE.getDimensionType();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.MeasurementType <em>Measurement Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.MeasurementType
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getMeasurementType()
		 * @generated
		 */
		EEnum MEASUREMENT_TYPE = eINSTANCE.getMeasurementType();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.Region <em>Region</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.Region
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getRegion()
		 * @generated
		 */
		EEnum REGION = eINSTANCE.getRegion();

	}

} //OntoumlPackage
