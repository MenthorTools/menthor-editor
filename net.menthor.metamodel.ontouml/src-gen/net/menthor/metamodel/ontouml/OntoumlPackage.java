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
	 * The operation id for the '<em>Packages</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER___PACKAGES = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>All Packages</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER___ALL_PACKAGES__CONTAINER_ELIST = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>All Packages</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER___ALL_PACKAGES = NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Relationships</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER___RELATIONSHIPS = NAMED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>All Relationships</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER___ALL_RELATIONSHIPS__CONTAINER_ELIST = NAMED_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>All Relationships</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER___ALL_RELATIONSHIPS = NAMED_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Generalization Sets</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER___GENERALIZATION_SETS = NAMED_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>All Generalization Sets</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER___ALL_GENERALIZATION_SETS__CONTAINER_ELIST = NAMED_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>All Generalization Sets</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER___ALL_GENERALIZATION_SETS = NAMED_ELEMENT_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Classes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER___CLASSES = NAMED_ELEMENT_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>All Classes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER___ALL_CLASSES__CONTAINER_ELIST = NAMED_ELEMENT_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>All Classes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER___ALL_CLASSES = NAMED_ELEMENT_OPERATION_COUNT + 11;

	/**
	 * The number of operations of the '<em>Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 12;

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
	 * The operation id for the '<em>Get Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINED_ELEMENT___GET_MODEL__CONTAINER = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINED_ELEMENT___GET_MODEL = ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Contained Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINED_ELEMENT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 2;

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
	 * The operation id for the '<em>Packages</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___PACKAGES = CONTAINER___PACKAGES;

	/**
	 * The operation id for the '<em>All Packages</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___ALL_PACKAGES__CONTAINER_ELIST = CONTAINER___ALL_PACKAGES__CONTAINER_ELIST;

	/**
	 * The operation id for the '<em>All Packages</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___ALL_PACKAGES = CONTAINER___ALL_PACKAGES;

	/**
	 * The operation id for the '<em>Relationships</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___RELATIONSHIPS = CONTAINER___RELATIONSHIPS;

	/**
	 * The operation id for the '<em>All Relationships</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___ALL_RELATIONSHIPS__CONTAINER_ELIST = CONTAINER___ALL_RELATIONSHIPS__CONTAINER_ELIST;

	/**
	 * The operation id for the '<em>All Relationships</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___ALL_RELATIONSHIPS = CONTAINER___ALL_RELATIONSHIPS;

	/**
	 * The operation id for the '<em>Generalization Sets</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___GENERALIZATION_SETS = CONTAINER___GENERALIZATION_SETS;

	/**
	 * The operation id for the '<em>All Generalization Sets</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___ALL_GENERALIZATION_SETS__CONTAINER_ELIST = CONTAINER___ALL_GENERALIZATION_SETS__CONTAINER_ELIST;

	/**
	 * The operation id for the '<em>All Generalization Sets</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___ALL_GENERALIZATION_SETS = CONTAINER___ALL_GENERALIZATION_SETS;

	/**
	 * The operation id for the '<em>Classes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___CLASSES = CONTAINER___CLASSES;

	/**
	 * The operation id for the '<em>All Classes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___ALL_CLASSES__CONTAINER_ELIST = CONTAINER___ALL_CLASSES__CONTAINER_ELIST;

	/**
	 * The operation id for the '<em>All Classes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL___ALL_CLASSES = CONTAINER___ALL_CLASSES;

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
	 * The operation id for the '<em>Packages</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE___PACKAGES = CONTAINER___PACKAGES;

	/**
	 * The operation id for the '<em>All Packages</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE___ALL_PACKAGES__CONTAINER_ELIST = CONTAINER___ALL_PACKAGES__CONTAINER_ELIST;

	/**
	 * The operation id for the '<em>All Packages</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE___ALL_PACKAGES = CONTAINER___ALL_PACKAGES;

	/**
	 * The operation id for the '<em>Relationships</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE___RELATIONSHIPS = CONTAINER___RELATIONSHIPS;

	/**
	 * The operation id for the '<em>All Relationships</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE___ALL_RELATIONSHIPS__CONTAINER_ELIST = CONTAINER___ALL_RELATIONSHIPS__CONTAINER_ELIST;

	/**
	 * The operation id for the '<em>All Relationships</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE___ALL_RELATIONSHIPS = CONTAINER___ALL_RELATIONSHIPS;

	/**
	 * The operation id for the '<em>Generalization Sets</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE___GENERALIZATION_SETS = CONTAINER___GENERALIZATION_SETS;

	/**
	 * The operation id for the '<em>All Generalization Sets</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE___ALL_GENERALIZATION_SETS__CONTAINER_ELIST = CONTAINER___ALL_GENERALIZATION_SETS__CONTAINER_ELIST;

	/**
	 * The operation id for the '<em>All Generalization Sets</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE___ALL_GENERALIZATION_SETS = CONTAINER___ALL_GENERALIZATION_SETS;

	/**
	 * The operation id for the '<em>Classes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE___CLASSES = CONTAINER___CLASSES;

	/**
	 * The operation id for the '<em>All Classes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE___ALL_CLASSES__CONTAINER_ELIST = CONTAINER___ALL_CLASSES__CONTAINER_ELIST;

	/**
	 * The operation id for the '<em>All Classes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE___ALL_CLASSES = CONTAINER___ALL_CLASSES;

	/**
	 * The operation id for the '<em>Get Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE___GET_MODEL__CONTAINER = CONTAINER_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE___GET_MODEL = CONTAINER_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_OPERATION_COUNT = CONTAINER_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.ClassifierImpl <em>Classifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.ClassifierImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getClassifier()
	 * @generated
	 */
	int CLASSIFIER = 7;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__HOLDER = CONTAINED_ELEMENT__HOLDER;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__COMMENTS = CONTAINED_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Is Specialized Via</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__IS_SPECIALIZED_VIA = CONTAINED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Specializes Via</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__SPECIALIZES_VIA = CONTAINED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_FEATURE_COUNT = CONTAINED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER___GET_MODEL__CONTAINER = CONTAINED_ELEMENT___GET_MODEL__CONTAINER;

	/**
	 * The operation id for the '<em>Get Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER___GET_MODEL = CONTAINED_ELEMENT___GET_MODEL;

	/**
	 * The operation id for the '<em>Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER___CHILDREN = CONTAINED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Parents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER___PARENTS = CONTAINED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>All Parents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER___ALL_PARENTS__CLASSIFIER_ELIST = CONTAINED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>All Parents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER___ALL_PARENTS = CONTAINED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>All Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER___ALL_CHILDREN__CLASSIFIER_ELIST = CONTAINED_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>All Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER___ALL_CHILDREN = CONTAINED_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Siblings</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER___SIBLINGS = CONTAINED_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Ends</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER___ENDS = CONTAINED_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>All Ends</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER___ALL_ENDS = CONTAINED_ELEMENT_OPERATION_COUNT + 8;

	/**
	 * The number of operations of the '<em>Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_OPERATION_COUNT = CONTAINED_ELEMENT_OPERATION_COUNT + 9;

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
	 * The feature id for the '<em><b>Specialized Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SET__SPECIALIZED_CLASSIFIER = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Specializing Classifier</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SET__SPECIALIZING_CLASSIFIER = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>High Order</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SET__HIGH_ORDER = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Generalization Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SET_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Get Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SET___GET_MODEL__CONTAINER = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SET___GET_MODEL = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Generalization Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_SET_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.TypeImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__HOLDER = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__COMMENTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Specialized Via</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__IS_SPECIALIZED_VIA = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Specializes Via</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__SPECIALIZES_VIA = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___GET_MODEL__CONTAINER = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___GET_MODEL = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___CHILDREN = NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Parents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___PARENTS = NAMED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>All Parents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___ALL_PARENTS__CLASSIFIER_ELIST = NAMED_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>All Parents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___ALL_PARENTS = NAMED_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>All Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___ALL_CHILDREN__CLASSIFIER_ELIST = NAMED_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>All Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___ALL_CHILDREN = NAMED_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Siblings</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___SIBLINGS = NAMED_ELEMENT_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Ends</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___ENDS = NAMED_ELEMENT_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>All Ends</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___ALL_ENDS = NAMED_ELEMENT_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Related Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___RELATED_TYPES = NAMED_ELEMENT_OPERATION_COUNT + 11;

	/**
	 * The operation id for the '<em>All Related Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE___ALL_RELATED_TYPES = NAMED_ELEMENT_OPERATION_COUNT + 12;

	/**
	 * The number of operations of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 13;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.ClassImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__HOLDER = TYPE__HOLDER;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__COMMENTS = TYPE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Is Specialized Via</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__IS_SPECIALIZED_VIA = TYPE__IS_SPECIALIZED_VIA;

	/**
	 * The feature id for the '<em><b>Specializes Via</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__SPECIALIZES_VIA = TYPE__SPECIALIZES_VIA;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__STEREOTYPE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__IS_ABSTRACT = TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__IS_DERIVED = TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ATTRIBUTES = TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Extensional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__IS_EXTENSIONAL = TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Quality Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__QUALITY_TYPE = TYPE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__LITERALS = TYPE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Grounding Structure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__GROUNDING_STRUCTURE = TYPE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Instance Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__INSTANCE_OF = TYPE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Istruth Maker Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ISTRUTH_MAKER_OF = TYPE_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = TYPE_FEATURE_COUNT + 10;

	/**
	 * The operation id for the '<em>Get Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___GET_MODEL__CONTAINER = TYPE___GET_MODEL__CONTAINER;

	/**
	 * The operation id for the '<em>Get Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___GET_MODEL = TYPE___GET_MODEL;

	/**
	 * The operation id for the '<em>Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___CHILDREN = TYPE___CHILDREN;

	/**
	 * The operation id for the '<em>Parents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___PARENTS = TYPE___PARENTS;

	/**
	 * The operation id for the '<em>All Parents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___ALL_PARENTS__CLASSIFIER_ELIST = TYPE___ALL_PARENTS__CLASSIFIER_ELIST;

	/**
	 * The operation id for the '<em>All Parents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___ALL_PARENTS = TYPE___ALL_PARENTS;

	/**
	 * The operation id for the '<em>All Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___ALL_CHILDREN__CLASSIFIER_ELIST = TYPE___ALL_CHILDREN__CLASSIFIER_ELIST;

	/**
	 * The operation id for the '<em>All Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___ALL_CHILDREN = TYPE___ALL_CHILDREN;

	/**
	 * The operation id for the '<em>Siblings</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___SIBLINGS = TYPE___SIBLINGS;

	/**
	 * The operation id for the '<em>Ends</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___ENDS = TYPE___ENDS;

	/**
	 * The operation id for the '<em>All Ends</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___ALL_ENDS = TYPE___ALL_ENDS;

	/**
	 * The operation id for the '<em>Related Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___RELATED_TYPES = TYPE___RELATED_TYPES;

	/**
	 * The operation id for the '<em>All Related Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___ALL_RELATED_TYPES = TYPE___ALL_RELATED_TYPES;

	/**
	 * The operation id for the '<em>Is Kind</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_KIND = TYPE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Sub Kind</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_SUB_KIND = TYPE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Collective</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_COLLECTIVE = TYPE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Quantity</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_QUANTITY = TYPE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Relator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_RELATOR = TYPE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Mode</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_MODE = TYPE_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Is Quality</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_QUALITY = TYPE_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Is Role</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_ROLE = TYPE_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Is Role Mixin</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_ROLE_MIXIN = TYPE_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Is Phase Mixin</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_PHASE_MIXIN = TYPE_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Is Phase</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_PHASE = TYPE_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Is Category</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_CATEGORY = TYPE_OPERATION_COUNT + 11;

	/**
	 * The operation id for the '<em>Is Mixin</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_MIXIN = TYPE_OPERATION_COUNT + 12;

	/**
	 * The operation id for the '<em>Is Event</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_EVENT = TYPE_OPERATION_COUNT + 13;

	/**
	 * The operation id for the '<em>Is High Order</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_HIGH_ORDER = TYPE_OPERATION_COUNT + 14;

	/**
	 * The operation id for the '<em>Is Data Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_DATA_TYPE = TYPE_OPERATION_COUNT + 15;

	/**
	 * The operation id for the '<em>Is Enumeration</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_ENUMERATION = TYPE_OPERATION_COUNT + 16;

	/**
	 * The operation id for the '<em>Is Rigid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_RIGID = TYPE_OPERATION_COUNT + 17;

	/**
	 * The operation id for the '<em>Is Non Rigid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_NON_RIGID = TYPE_OPERATION_COUNT + 18;

	/**
	 * The operation id for the '<em>Is Anti Rigid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_ANTI_RIGID = TYPE_OPERATION_COUNT + 19;

	/**
	 * The operation id for the '<em>Is Semi Rigid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_SEMI_RIGID = TYPE_OPERATION_COUNT + 20;

	/**
	 * The operation id for the '<em>Is Moment</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_MOMENT = TYPE_OPERATION_COUNT + 21;

	/**
	 * The operation id for the '<em>Is Identity Provider</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_IDENTITY_PROVIDER = TYPE_OPERATION_COUNT + 22;

	/**
	 * The operation id for the '<em>Is Truth Maker</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_TRUTH_MAKER = TYPE_OPERATION_COUNT + 23;

	/**
	 * The operation id for the '<em>Is Mixin Class</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_MIXIN_CLASS = TYPE_OPERATION_COUNT + 24;

	/**
	 * The operation id for the '<em>Identity Providers At All Parents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IDENTITY_PROVIDERS_AT_ALL_PARENTS = TYPE_OPERATION_COUNT + 25;

	/**
	 * The operation id for the '<em>Identity Providers At All Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IDENTITY_PROVIDERS_AT_ALL_CHILDREN = TYPE_OPERATION_COUNT + 26;

	/**
	 * The operation id for the '<em>Identity Providers</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IDENTITY_PROVIDERS = TYPE_OPERATION_COUNT + 27;

	/**
	 * The operation id for the '<em>Is Amount Of Matter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_AMOUNT_OF_MATTER = TYPE_OPERATION_COUNT + 28;

	/**
	 * The operation id for the '<em>Is Functional Complex</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_FUNCTIONAL_COMPLEX = TYPE_OPERATION_COUNT + 29;

	/**
	 * The operation id for the '<em>Is Collection</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_COLLECTION = TYPE_OPERATION_COUNT + 30;

	/**
	 * The operation id for the '<em>Is Intrinsic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___IS_INTRINSIC = TYPE_OPERATION_COUNT + 31;

	/**
	 * The number of operations of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPERATION_COUNT = TYPE_OPERATION_COUNT + 32;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.LiteralImpl <em>Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.LiteralImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getLiteral()
	 * @generated
	 */
	int LITERAL = 11;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL__OWNER = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Grounding Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL__GROUNDING_REGION = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL__VALUE = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.PropertyImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 17;

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
	 * The feature id for the '<em><b>Is Dependency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__IS_DEPENDENCY = NAMED_ELEMENT_FEATURE_COUNT + 4;

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
	 * The feature id for the '<em><b>Is Dependency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__IS_DEPENDENCY = PROPERTY__IS_DEPENDENCY;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__OWNER = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Primitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__PRIMITIVE = PROPERTY_FEATURE_COUNT + 1;

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
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.StructureImpl <em>Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.StructureImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getStructure()
	 * @generated
	 */
	int STRUCTURE = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__HOLDER = TYPE__HOLDER;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__COMMENTS = TYPE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Is Specialized Via</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__IS_SPECIALIZED_VIA = TYPE__IS_SPECIALIZED_VIA;

	/**
	 * The feature id for the '<em><b>Specializes Via</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__SPECIALIZES_VIA = TYPE__SPECIALIZES_VIA;

	/**
	 * The feature id for the '<em><b>Regions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__REGIONS = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Grounded Enumeration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE__GROUNDED_ENUMERATION = TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE___GET_MODEL__CONTAINER = TYPE___GET_MODEL__CONTAINER;

	/**
	 * The operation id for the '<em>Get Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE___GET_MODEL = TYPE___GET_MODEL;

	/**
	 * The operation id for the '<em>Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE___CHILDREN = TYPE___CHILDREN;

	/**
	 * The operation id for the '<em>Parents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE___PARENTS = TYPE___PARENTS;

	/**
	 * The operation id for the '<em>All Parents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE___ALL_PARENTS__CLASSIFIER_ELIST = TYPE___ALL_PARENTS__CLASSIFIER_ELIST;

	/**
	 * The operation id for the '<em>All Parents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE___ALL_PARENTS = TYPE___ALL_PARENTS;

	/**
	 * The operation id for the '<em>All Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE___ALL_CHILDREN__CLASSIFIER_ELIST = TYPE___ALL_CHILDREN__CLASSIFIER_ELIST;

	/**
	 * The operation id for the '<em>All Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE___ALL_CHILDREN = TYPE___ALL_CHILDREN;

	/**
	 * The operation id for the '<em>Siblings</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE___SIBLINGS = TYPE___SIBLINGS;

	/**
	 * The operation id for the '<em>Ends</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE___ENDS = TYPE___ENDS;

	/**
	 * The operation id for the '<em>All Ends</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE___ALL_ENDS = TYPE___ALL_ENDS;

	/**
	 * The operation id for the '<em>Related Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE___RELATED_TYPES = TYPE___RELATED_TYPES;

	/**
	 * The operation id for the '<em>All Related Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE___ALL_RELATED_TYPES = TYPE___ALL_RELATED_TYPES;

	/**
	 * The number of operations of the '<em>Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_OPERATION_COUNT = TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.RegionImpl <em>Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.RegionImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getRegion()
	 * @generated
	 */
	int REGION = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__HOLDER = TYPE__HOLDER;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__COMMENTS = TYPE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Is Specialized Via</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__IS_SPECIALIZED_VIA = TYPE__IS_SPECIALIZED_VIA;

	/**
	 * The feature id for the '<em><b>Specializes Via</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__SPECIALIZES_VIA = TYPE__SPECIALIZES_VIA;

	/**
	 * The feature id for the '<em><b>Owner Structure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__OWNER_STRUCTURE = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Grounded Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__GROUNDED_LITERAL = TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Composed By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__COMPOSED_BY = TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Basic Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__BASIC_TYPE = TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION_FEATURE_COUNT = TYPE_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>Get Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION___GET_MODEL__CONTAINER = TYPE___GET_MODEL__CONTAINER;

	/**
	 * The operation id for the '<em>Get Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION___GET_MODEL = TYPE___GET_MODEL;

	/**
	 * The operation id for the '<em>Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION___CHILDREN = TYPE___CHILDREN;

	/**
	 * The operation id for the '<em>Parents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION___PARENTS = TYPE___PARENTS;

	/**
	 * The operation id for the '<em>All Parents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION___ALL_PARENTS__CLASSIFIER_ELIST = TYPE___ALL_PARENTS__CLASSIFIER_ELIST;

	/**
	 * The operation id for the '<em>All Parents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION___ALL_PARENTS = TYPE___ALL_PARENTS;

	/**
	 * The operation id for the '<em>All Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION___ALL_CHILDREN__CLASSIFIER_ELIST = TYPE___ALL_CHILDREN__CLASSIFIER_ELIST;

	/**
	 * The operation id for the '<em>All Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION___ALL_CHILDREN = TYPE___ALL_CHILDREN;

	/**
	 * The operation id for the '<em>Siblings</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION___SIBLINGS = TYPE___SIBLINGS;

	/**
	 * The operation id for the '<em>Ends</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION___ENDS = TYPE___ENDS;

	/**
	 * The operation id for the '<em>All Ends</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION___ALL_ENDS = TYPE___ALL_ENDS;

	/**
	 * The operation id for the '<em>Related Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION___RELATED_TYPES = TYPE___RELATED_TYPES;

	/**
	 * The operation id for the '<em>All Related Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION___ALL_RELATED_TYPES = TYPE___ALL_RELATED_TYPES;

	/**
	 * The operation id for the '<em>Is Basic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION___IS_BASIC = TYPE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Composed</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION___IS_COMPOSED = TYPE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Nominal</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION___IS_NOMINAL = TYPE_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION_OPERATION_COUNT = TYPE_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.DomainImpl <em>Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.DomainImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getDomain()
	 * @generated
	 */
	int DOMAIN = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__NAME = STRUCTURE__NAME;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__HOLDER = STRUCTURE__HOLDER;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__COMMENTS = STRUCTURE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Is Specialized Via</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__IS_SPECIALIZED_VIA = STRUCTURE__IS_SPECIALIZED_VIA;

	/**
	 * The feature id for the '<em><b>Specializes Via</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__SPECIALIZES_VIA = STRUCTURE__SPECIALIZES_VIA;

	/**
	 * The feature id for the '<em><b>Regions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__REGIONS = STRUCTURE__REGIONS;

	/**
	 * The feature id for the '<em><b>Grounded Enumeration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__GROUNDED_ENUMERATION = STRUCTURE__GROUNDED_ENUMERATION;

	/**
	 * The feature id for the '<em><b>Dimensions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__DIMENSIONS = STRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_FEATURE_COUNT = STRUCTURE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Get Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___GET_MODEL__CONTAINER = STRUCTURE___GET_MODEL__CONTAINER;

	/**
	 * The operation id for the '<em>Get Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___GET_MODEL = STRUCTURE___GET_MODEL;

	/**
	 * The operation id for the '<em>Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___CHILDREN = STRUCTURE___CHILDREN;

	/**
	 * The operation id for the '<em>Parents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___PARENTS = STRUCTURE___PARENTS;

	/**
	 * The operation id for the '<em>All Parents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___ALL_PARENTS__CLASSIFIER_ELIST = STRUCTURE___ALL_PARENTS__CLASSIFIER_ELIST;

	/**
	 * The operation id for the '<em>All Parents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___ALL_PARENTS = STRUCTURE___ALL_PARENTS;

	/**
	 * The operation id for the '<em>All Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___ALL_CHILDREN__CLASSIFIER_ELIST = STRUCTURE___ALL_CHILDREN__CLASSIFIER_ELIST;

	/**
	 * The operation id for the '<em>All Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___ALL_CHILDREN = STRUCTURE___ALL_CHILDREN;

	/**
	 * The operation id for the '<em>Siblings</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___SIBLINGS = STRUCTURE___SIBLINGS;

	/**
	 * The operation id for the '<em>Ends</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___ENDS = STRUCTURE___ENDS;

	/**
	 * The operation id for the '<em>All Ends</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___ALL_ENDS = STRUCTURE___ALL_ENDS;

	/**
	 * The operation id for the '<em>Related Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___RELATED_TYPES = STRUCTURE___RELATED_TYPES;

	/**
	 * The operation id for the '<em>All Related Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___ALL_RELATED_TYPES = STRUCTURE___ALL_RELATED_TYPES;

	/**
	 * The number of operations of the '<em>Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_OPERATION_COUNT = STRUCTURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.DimensionImpl <em>Dimension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.DimensionImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getDimension()
	 * @generated
	 */
	int DIMENSION = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__NAME = STRUCTURE__NAME;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__HOLDER = STRUCTURE__HOLDER;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__COMMENTS = STRUCTURE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Is Specialized Via</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__IS_SPECIALIZED_VIA = STRUCTURE__IS_SPECIALIZED_VIA;

	/**
	 * The feature id for the '<em><b>Specializes Via</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__SPECIALIZES_VIA = STRUCTURE__SPECIALIZES_VIA;

	/**
	 * The feature id for the '<em><b>Regions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__REGIONS = STRUCTURE__REGIONS;

	/**
	 * The feature id for the '<em><b>Grounded Enumeration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__GROUNDED_ENUMERATION = STRUCTURE__GROUNDED_ENUMERATION;

	/**
	 * The feature id for the '<em><b>Owner Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__OWNER_DOMAIN = STRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__LOWER_BOUND = STRUCTURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__UPPER_BOUND = STRUCTURE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Unit Of Measure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__UNIT_OF_MEASURE = STRUCTURE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__SCALE = STRUCTURE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Measure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__MEASURE = STRUCTURE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_FEATURE_COUNT = STRUCTURE_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>Get Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___GET_MODEL__CONTAINER = STRUCTURE___GET_MODEL__CONTAINER;

	/**
	 * The operation id for the '<em>Get Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___GET_MODEL = STRUCTURE___GET_MODEL;

	/**
	 * The operation id for the '<em>Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___CHILDREN = STRUCTURE___CHILDREN;

	/**
	 * The operation id for the '<em>Parents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___PARENTS = STRUCTURE___PARENTS;

	/**
	 * The operation id for the '<em>All Parents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___ALL_PARENTS__CLASSIFIER_ELIST = STRUCTURE___ALL_PARENTS__CLASSIFIER_ELIST;

	/**
	 * The operation id for the '<em>All Parents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___ALL_PARENTS = STRUCTURE___ALL_PARENTS;

	/**
	 * The operation id for the '<em>All Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___ALL_CHILDREN__CLASSIFIER_ELIST = STRUCTURE___ALL_CHILDREN__CLASSIFIER_ELIST;

	/**
	 * The operation id for the '<em>All Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___ALL_CHILDREN = STRUCTURE___ALL_CHILDREN;

	/**
	 * The operation id for the '<em>Siblings</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___SIBLINGS = STRUCTURE___SIBLINGS;

	/**
	 * The operation id for the '<em>Ends</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___ENDS = STRUCTURE___ENDS;

	/**
	 * The operation id for the '<em>All Ends</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___ALL_ENDS = STRUCTURE___ALL_ENDS;

	/**
	 * The operation id for the '<em>Related Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___RELATED_TYPES = STRUCTURE___RELATED_TYPES;

	/**
	 * The operation id for the '<em>All Related Types</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___ALL_RELATED_TYPES = STRUCTURE___ALL_RELATED_TYPES;

	/**
	 * The operation id for the '<em>Is Nominal</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___IS_NOMINAL = STRUCTURE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Is Interval</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___IS_INTERVAL = STRUCTURE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Ordinal</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___IS_ORDINAL = STRUCTURE_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Is Rational</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___IS_RATIONAL = STRUCTURE_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Is String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___IS_STRING = STRUCTURE_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Is Integer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___IS_INTEGER = STRUCTURE_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Is Decimal</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___IS_DECIMAL = STRUCTURE_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Is Nominal String</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___IS_NOMINAL_STRING = STRUCTURE_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Is Interval Integer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___IS_INTERVAL_INTEGER = STRUCTURE_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Is Interval Decimal</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___IS_INTERVAL_DECIMAL = STRUCTURE_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>Is Ordinal Integer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___IS_ORDINAL_INTEGER = STRUCTURE_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Is Ordinal Decimal</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___IS_ORDINAL_DECIMAL = STRUCTURE_OPERATION_COUNT + 11;

	/**
	 * The operation id for the '<em>Is Rational Integer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___IS_RATIONAL_INTEGER = STRUCTURE_OPERATION_COUNT + 12;

	/**
	 * The operation id for the '<em>Is Rational Decimal</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION___IS_RATIONAL_DECIMAL = STRUCTURE_OPERATION_COUNT + 13;

	/**
	 * The number of operations of the '<em>Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_OPERATION_COUNT = STRUCTURE_OPERATION_COUNT + 14;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.EndPointImpl <em>End Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.EndPointImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getEndPoint()
	 * @generated
	 */
	int END_POINT = 18;

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
	 * The feature id for the '<em><b>Is Dependency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_POINT__IS_DEPENDENCY = PROPERTY__IS_DEPENDENCY;

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
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.impl.RelationshipImpl <em>Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.impl.RelationshipImpl
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getRelationship()
	 * @generated
	 */
	int RELATIONSHIP = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Holder</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__HOLDER = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__COMMENTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Specialized Via</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__IS_SPECIALIZED_VIA = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Specializes Via</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__SPECIALIZES_VIA = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__STEREOTYPE = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Allen Relation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__ALLEN_RELATION = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>End Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__END_POINTS = NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Derived From Truth Maker</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__DERIVED_FROM_TRUTH_MAKER = NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The operation id for the '<em>Get Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___GET_MODEL__CONTAINER = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Model</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___GET_MODEL = NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___CHILDREN = NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Parents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___PARENTS = NAMED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>All Parents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___ALL_PARENTS__CLASSIFIER_ELIST = NAMED_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>All Parents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___ALL_PARENTS = NAMED_ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>All Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___ALL_CHILDREN__CLASSIFIER_ELIST = NAMED_ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>All Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___ALL_CHILDREN = NAMED_ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The operation id for the '<em>Siblings</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___SIBLINGS = NAMED_ELEMENT_OPERATION_COUNT + 8;

	/**
	 * The operation id for the '<em>Ends</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___ENDS = NAMED_ELEMENT_OPERATION_COUNT + 9;

	/**
	 * The operation id for the '<em>All Ends</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___ALL_ENDS = NAMED_ELEMENT_OPERATION_COUNT + 10;

	/**
	 * The operation id for the '<em>Is Component Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_COMPONENT_OF = NAMED_ELEMENT_OPERATION_COUNT + 11;

	/**
	 * The operation id for the '<em>Is Member Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_MEMBER_OF = NAMED_ELEMENT_OPERATION_COUNT + 12;

	/**
	 * The operation id for the '<em>Is Sub Collection Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_SUB_COLLECTION_OF = NAMED_ELEMENT_OPERATION_COUNT + 13;

	/**
	 * The operation id for the '<em>Is Sub Quantity Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_SUB_QUANTITY_OF = NAMED_ELEMENT_OPERATION_COUNT + 14;

	/**
	 * The operation id for the '<em>Is Constitution</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_CONSTITUTION = NAMED_ELEMENT_OPERATION_COUNT + 15;

	/**
	 * The operation id for the '<em>Is Characterization</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_CHARACTERIZATION = NAMED_ELEMENT_OPERATION_COUNT + 16;

	/**
	 * The operation id for the '<em>Is Mediation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_MEDIATION = NAMED_ELEMENT_OPERATION_COUNT + 17;

	/**
	 * The operation id for the '<em>Is Material</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_MATERIAL = NAMED_ELEMENT_OPERATION_COUNT + 18;

	/**
	 * The operation id for the '<em>Is Formal</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_FORMAL = NAMED_ELEMENT_OPERATION_COUNT + 19;

	/**
	 * The operation id for the '<em>Is Structuration</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_STRUCTURATION = NAMED_ELEMENT_OPERATION_COUNT + 20;

	/**
	 * The operation id for the '<em>Is Participation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_PARTICIPATION = NAMED_ELEMENT_OPERATION_COUNT + 21;

	/**
	 * The operation id for the '<em>Is Sub Event Of</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_SUB_EVENT_OF = NAMED_ELEMENT_OPERATION_COUNT + 22;

	/**
	 * The operation id for the '<em>Is Causation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_CAUSATION = NAMED_ELEMENT_OPERATION_COUNT + 23;

	/**
	 * The operation id for the '<em>Is Temporal</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_TEMPORAL = NAMED_ELEMENT_OPERATION_COUNT + 24;

	/**
	 * The operation id for the '<em>Is Derivation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_DERIVATION = NAMED_ELEMENT_OPERATION_COUNT + 25;

	/**
	 * The operation id for the '<em>Is Starts</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_STARTS = NAMED_ELEMENT_OPERATION_COUNT + 26;

	/**
	 * The operation id for the '<em>Is Precedes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_PRECEDES = NAMED_ELEMENT_OPERATION_COUNT + 27;

	/**
	 * The operation id for the '<em>Is Equals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_EQUALS = NAMED_ELEMENT_OPERATION_COUNT + 28;

	/**
	 * The operation id for the '<em>Is Meets</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_MEETS = NAMED_ELEMENT_OPERATION_COUNT + 29;

	/**
	 * The operation id for the '<em>Is Finishes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_FINISHES = NAMED_ELEMENT_OPERATION_COUNT + 30;

	/**
	 * The operation id for the '<em>Is Overlaps</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_OVERLAPS = NAMED_ELEMENT_OPERATION_COUNT + 31;

	/**
	 * The operation id for the '<em>Is During</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_DURING = NAMED_ELEMENT_OPERATION_COUNT + 32;

	/**
	 * The operation id for the '<em>Is Meronymic</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_MERONYMIC = NAMED_ELEMENT_OPERATION_COUNT + 33;

	/**
	 * The operation id for the '<em>Is Binary</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_BINARY = NAMED_ELEMENT_OPERATION_COUNT + 34;

	/**
	 * The operation id for the '<em>Is Ternary</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_TERNARY = NAMED_ELEMENT_OPERATION_COUNT + 35;

	/**
	 * The operation id for the '<em>Source End</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___SOURCE_END = NAMED_ELEMENT_OPERATION_COUNT + 36;

	/**
	 * The operation id for the '<em>Target End</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___TARGET_END = NAMED_ELEMENT_OPERATION_COUNT + 37;

	/**
	 * The operation id for the '<em>Source</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___SOURCE = NAMED_ELEMENT_OPERATION_COUNT + 38;

	/**
	 * The operation id for the '<em>Target</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___TARGET = NAMED_ELEMENT_OPERATION_COUNT + 39;

	/**
	 * The operation id for the '<em>Source Class</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___SOURCE_CLASS = NAMED_ELEMENT_OPERATION_COUNT + 40;

	/**
	 * The operation id for the '<em>Target Class</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___TARGET_CLASS = NAMED_ELEMENT_OPERATION_COUNT + 41;

	/**
	 * The operation id for the '<em>Source Relationship</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___SOURCE_RELATIONSHIP = NAMED_ELEMENT_OPERATION_COUNT + 42;

	/**
	 * The operation id for the '<em>Target Relationship</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___TARGET_RELATIONSHIP = NAMED_ELEMENT_OPERATION_COUNT + 43;

	/**
	 * The operation id for the '<em>Is Derived</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_DERIVED = NAMED_ELEMENT_OPERATION_COUNT + 44;

	/**
	 * The operation id for the '<em>Is End</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_END__CLASSIFIER = NAMED_ELEMENT_OPERATION_COUNT + 45;

	/**
	 * The operation id for the '<em>Is Part Essential</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_PART_ESSENTIAL = NAMED_ELEMENT_OPERATION_COUNT + 46;

	/**
	 * The operation id for the '<em>Is Part Inseparable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_PART_INSEPARABLE = NAMED_ELEMENT_OPERATION_COUNT + 47;

	/**
	 * The operation id for the '<em>Is Part Immutable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_PART_IMMUTABLE = NAMED_ELEMENT_OPERATION_COUNT + 48;

	/**
	 * The operation id for the '<em>Is Whole Immutable</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_WHOLE_IMMUTABLE = NAMED_ELEMENT_OPERATION_COUNT + 49;

	/**
	 * The operation id for the '<em>Is Part Mandatory</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_PART_MANDATORY = NAMED_ELEMENT_OPERATION_COUNT + 50;

	/**
	 * The operation id for the '<em>Is Whole Mandatory</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___IS_WHOLE_MANDATORY = NAMED_ELEMENT_OPERATION_COUNT + 51;

	/**
	 * The operation id for the '<em>Material</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___MATERIAL = NAMED_ELEMENT_OPERATION_COUNT + 52;

	/**
	 * The operation id for the '<em>Relator</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP___RELATOR = NAMED_ELEMENT_OPERATION_COUNT + 53;

	/**
	 * The number of operations of the '<em>Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 54;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.ClassStereotype <em>Class Stereotype</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.ClassStereotype
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getClassStereotype()
	 * @generated
	 */
	int CLASS_STEREOTYPE = 20;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.QualityNature <em>Quality Nature</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.QualityNature
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getQualityNature()
	 * @generated
	 */
	int QUALITY_NATURE = 21;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.Primitive <em>Primitive</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.Primitive
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getPrimitive()
	 * @generated
	 */
	int PRIMITIVE = 22;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.Scale <em>Scale</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.Scale
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getScale()
	 * @generated
	 */
	int SCALE = 23;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.Relation <em>Relation</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.Relation
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getRelation()
	 * @generated
	 */
	int RELATION = 24;

	/**
	 * The meta object id for the '{@link net.menthor.metamodel.ontouml.Temporal <em>Temporal</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see net.menthor.metamodel.ontouml.Temporal
	 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getTemporal()
	 * @generated
	 */
	int TEMPORAL = 25;


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
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Container#packages() <em>Packages</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Packages</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Container#packages()
	 * @generated
	 */
	EOperation getContainer__Packages();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Container#allPackages(net.menthor.metamodel.ontouml.Container, org.eclipse.emf.common.util.EList) <em>All Packages</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>All Packages</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Container#allPackages(net.menthor.metamodel.ontouml.Container, org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getContainer__AllPackages__Container_EList();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Container#allPackages() <em>All Packages</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>All Packages</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Container#allPackages()
	 * @generated
	 */
	EOperation getContainer__AllPackages();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Container#relationships() <em>Relationships</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Relationships</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Container#relationships()
	 * @generated
	 */
	EOperation getContainer__Relationships();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Container#allRelationships(net.menthor.metamodel.ontouml.Container, org.eclipse.emf.common.util.EList) <em>All Relationships</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>All Relationships</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Container#allRelationships(net.menthor.metamodel.ontouml.Container, org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getContainer__AllRelationships__Container_EList();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Container#allRelationships() <em>All Relationships</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>All Relationships</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Container#allRelationships()
	 * @generated
	 */
	EOperation getContainer__AllRelationships();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Container#generalizationSets() <em>Generalization Sets</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Generalization Sets</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Container#generalizationSets()
	 * @generated
	 */
	EOperation getContainer__GeneralizationSets();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Container#allGeneralizationSets(net.menthor.metamodel.ontouml.Container, org.eclipse.emf.common.util.EList) <em>All Generalization Sets</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>All Generalization Sets</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Container#allGeneralizationSets(net.menthor.metamodel.ontouml.Container, org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getContainer__AllGeneralizationSets__Container_EList();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Container#allGeneralizationSets() <em>All Generalization Sets</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>All Generalization Sets</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Container#allGeneralizationSets()
	 * @generated
	 */
	EOperation getContainer__AllGeneralizationSets();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Container#classes() <em>Classes</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Classes</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Container#classes()
	 * @generated
	 */
	EOperation getContainer__Classes();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Container#allClasses(net.menthor.metamodel.ontouml.Container, org.eclipse.emf.common.util.EList) <em>All Classes</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>All Classes</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Container#allClasses(net.menthor.metamodel.ontouml.Container, org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getContainer__AllClasses__Container_EList();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Container#allClasses() <em>All Classes</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>All Classes</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Container#allClasses()
	 * @generated
	 */
	EOperation getContainer__AllClasses();

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
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.ContainedElement#getModel(net.menthor.metamodel.ontouml.Container) <em>Get Model</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Model</em>' operation.
	 * @see net.menthor.metamodel.ontouml.ContainedElement#getModel(net.menthor.metamodel.ontouml.Container)
	 * @generated
	 */
	EOperation getContainedElement__GetModel__Container();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.ContainedElement#getModel() <em>Get Model</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Model</em>' operation.
	 * @see net.menthor.metamodel.ontouml.ContainedElement#getModel()
	 * @generated
	 */
	EOperation getContainedElement__GetModel();

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
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.Classifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier</em>'.
	 * @see net.menthor.metamodel.ontouml.Classifier
	 * @generated
	 */
	EClass getClassifier();

	/**
	 * Returns the meta object for the reference list '{@link net.menthor.metamodel.ontouml.Classifier#getIsSpecializedVia <em>Is Specialized Via</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Is Specialized Via</em>'.
	 * @see net.menthor.metamodel.ontouml.Classifier#getIsSpecializedVia()
	 * @see #getClassifier()
	 * @generated
	 */
	EReference getClassifier_IsSpecializedVia();

	/**
	 * Returns the meta object for the reference list '{@link net.menthor.metamodel.ontouml.Classifier#getSpecializesVia <em>Specializes Via</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Specializes Via</em>'.
	 * @see net.menthor.metamodel.ontouml.Classifier#getSpecializesVia()
	 * @see #getClassifier()
	 * @generated
	 */
	EReference getClassifier_SpecializesVia();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Classifier#children() <em>Children</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Children</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Classifier#children()
	 * @generated
	 */
	EOperation getClassifier__Children();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Classifier#parents() <em>Parents</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Parents</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Classifier#parents()
	 * @generated
	 */
	EOperation getClassifier__Parents();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Classifier#allParents(net.menthor.metamodel.ontouml.Classifier, org.eclipse.emf.common.util.EList) <em>All Parents</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>All Parents</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Classifier#allParents(net.menthor.metamodel.ontouml.Classifier, org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getClassifier__AllParents__Classifier_EList();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Classifier#allParents() <em>All Parents</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>All Parents</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Classifier#allParents()
	 * @generated
	 */
	EOperation getClassifier__AllParents();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Classifier#allChildren(net.menthor.metamodel.ontouml.Classifier, org.eclipse.emf.common.util.EList) <em>All Children</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>All Children</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Classifier#allChildren(net.menthor.metamodel.ontouml.Classifier, org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	EOperation getClassifier__AllChildren__Classifier_EList();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Classifier#allChildren() <em>All Children</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>All Children</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Classifier#allChildren()
	 * @generated
	 */
	EOperation getClassifier__AllChildren();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Classifier#siblings() <em>Siblings</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Siblings</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Classifier#siblings()
	 * @generated
	 */
	EOperation getClassifier__Siblings();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Classifier#ends() <em>Ends</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Ends</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Classifier#ends()
	 * @generated
	 */
	EOperation getClassifier__Ends();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Classifier#allEnds() <em>All Ends</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>All Ends</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Classifier#allEnds()
	 * @generated
	 */
	EOperation getClassifier__AllEnds();

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
	 * Returns the meta object for the reference '{@link net.menthor.metamodel.ontouml.GeneralizationSet#getSpecializedClassifier <em>Specialized Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Specialized Classifier</em>'.
	 * @see net.menthor.metamodel.ontouml.GeneralizationSet#getSpecializedClassifier()
	 * @see #getGeneralizationSet()
	 * @generated
	 */
	EReference getGeneralizationSet_SpecializedClassifier();

	/**
	 * Returns the meta object for the reference list '{@link net.menthor.metamodel.ontouml.GeneralizationSet#getSpecializingClassifier <em>Specializing Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Specializing Classifier</em>'.
	 * @see net.menthor.metamodel.ontouml.GeneralizationSet#getSpecializingClassifier()
	 * @see #getGeneralizationSet()
	 * @generated
	 */
	EReference getGeneralizationSet_SpecializingClassifier();

	/**
	 * Returns the meta object for the reference '{@link net.menthor.metamodel.ontouml.GeneralizationSet#getHighOrder <em>High Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>High Order</em>'.
	 * @see net.menthor.metamodel.ontouml.GeneralizationSet#getHighOrder()
	 * @see #getGeneralizationSet()
	 * @generated
	 */
	EReference getGeneralizationSet_HighOrder();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see net.menthor.metamodel.ontouml.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Type#relatedTypes() <em>Related Types</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Related Types</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Type#relatedTypes()
	 * @generated
	 */
	EOperation getType__RelatedTypes();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Type#allRelatedTypes() <em>All Related Types</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>All Related Types</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Type#allRelatedTypes()
	 * @generated
	 */
	EOperation getType__AllRelatedTypes();

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
	 * Returns the meta object for the containment reference list '{@link net.menthor.metamodel.ontouml.Class#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literals</em>'.
	 * @see net.menthor.metamodel.ontouml.Class#getLiterals()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Literals();

	/**
	 * Returns the meta object for the reference '{@link net.menthor.metamodel.ontouml.Class#getGroundingStructure <em>Grounding Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Grounding Structure</em>'.
	 * @see net.menthor.metamodel.ontouml.Class#getGroundingStructure()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_GroundingStructure();

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
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isSemiRigid() <em>Is Semi Rigid</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Semi Rigid</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isSemiRigid()
	 * @generated
	 */
	EOperation getClass__IsSemiRigid();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isMoment() <em>Is Moment</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Moment</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isMoment()
	 * @generated
	 */
	EOperation getClass__IsMoment();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isIdentityProvider() <em>Is Identity Provider</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Identity Provider</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isIdentityProvider()
	 * @generated
	 */
	EOperation getClass__IsIdentityProvider();

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
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isMixinClass() <em>Is Mixin Class</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Mixin Class</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isMixinClass()
	 * @generated
	 */
	EOperation getClass__IsMixinClass();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#identityProvidersAtAllParents() <em>Identity Providers At All Parents</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Identity Providers At All Parents</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#identityProvidersAtAllParents()
	 * @generated
	 */
	EOperation getClass__IdentityProvidersAtAllParents();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#identityProvidersAtAllChildren() <em>Identity Providers At All Children</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Identity Providers At All Children</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#identityProvidersAtAllChildren()
	 * @generated
	 */
	EOperation getClass__IdentityProvidersAtAllChildren();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#identityProviders() <em>Identity Providers</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Identity Providers</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#identityProviders()
	 * @generated
	 */
	EOperation getClass__IdentityProviders();

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
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Class#isIntrinsic() <em>Is Intrinsic</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Intrinsic</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Class#isIntrinsic()
	 * @generated
	 */
	EOperation getClass__IsIntrinsic();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal</em>'.
	 * @see net.menthor.metamodel.ontouml.Literal
	 * @generated
	 */
	EClass getLiteral();

	/**
	 * Returns the meta object for the container reference '{@link net.menthor.metamodel.ontouml.Literal#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see net.menthor.metamodel.ontouml.Literal#getOwner()
	 * @see #getLiteral()
	 * @generated
	 */
	EReference getLiteral_Owner();

	/**
	 * Returns the meta object for the reference '{@link net.menthor.metamodel.ontouml.Literal#getGroundingRegion <em>Grounding Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Grounding Region</em>'.
	 * @see net.menthor.metamodel.ontouml.Literal#getGroundingRegion()
	 * @see #getLiteral()
	 * @generated
	 */
	EReference getLiteral_GroundingRegion();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.Literal#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see net.menthor.metamodel.ontouml.Literal#getValue()
	 * @see #getLiteral()
	 * @generated
	 */
	EAttribute getLiteral_Value();

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
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.Attribute#getPrimitive <em>Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primitive</em>'.
	 * @see net.menthor.metamodel.ontouml.Attribute#getPrimitive()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Primitive();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.Structure <em>Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structure</em>'.
	 * @see net.menthor.metamodel.ontouml.Structure
	 * @generated
	 */
	EClass getStructure();

	/**
	 * Returns the meta object for the reference list '{@link net.menthor.metamodel.ontouml.Structure#getRegions <em>Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Regions</em>'.
	 * @see net.menthor.metamodel.ontouml.Structure#getRegions()
	 * @see #getStructure()
	 * @generated
	 */
	EReference getStructure_Regions();

	/**
	 * Returns the meta object for the reference '{@link net.menthor.metamodel.ontouml.Structure#getGroundedEnumeration <em>Grounded Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Grounded Enumeration</em>'.
	 * @see net.menthor.metamodel.ontouml.Structure#getGroundedEnumeration()
	 * @see #getStructure()
	 * @generated
	 */
	EReference getStructure_GroundedEnumeration();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.Region <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Region</em>'.
	 * @see net.menthor.metamodel.ontouml.Region
	 * @generated
	 */
	EClass getRegion();

	/**
	 * Returns the meta object for the reference '{@link net.menthor.metamodel.ontouml.Region#getOwnerStructure <em>Owner Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner Structure</em>'.
	 * @see net.menthor.metamodel.ontouml.Region#getOwnerStructure()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_OwnerStructure();

	/**
	 * Returns the meta object for the reference '{@link net.menthor.metamodel.ontouml.Region#getGroundedLiteral <em>Grounded Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Grounded Literal</em>'.
	 * @see net.menthor.metamodel.ontouml.Region#getGroundedLiteral()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_GroundedLiteral();

	/**
	 * Returns the meta object for the reference list '{@link net.menthor.metamodel.ontouml.Region#getComposedBy <em>Composed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Composed By</em>'.
	 * @see net.menthor.metamodel.ontouml.Region#getComposedBy()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_ComposedBy();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.Region#getBasicType <em>Basic Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Basic Type</em>'.
	 * @see net.menthor.metamodel.ontouml.Region#getBasicType()
	 * @see #getRegion()
	 * @generated
	 */
	EAttribute getRegion_BasicType();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Region#isBasic() <em>Is Basic</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Basic</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Region#isBasic()
	 * @generated
	 */
	EOperation getRegion__IsBasic();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Region#isComposed() <em>Is Composed</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Composed</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Region#isComposed()
	 * @generated
	 */
	EOperation getRegion__IsComposed();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Region#isNominal() <em>Is Nominal</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Nominal</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Region#isNominal()
	 * @generated
	 */
	EOperation getRegion__IsNominal();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.Domain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain</em>'.
	 * @see net.menthor.metamodel.ontouml.Domain
	 * @generated
	 */
	EClass getDomain();

	/**
	 * Returns the meta object for the reference list '{@link net.menthor.metamodel.ontouml.Domain#getDimensions <em>Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dimensions</em>'.
	 * @see net.menthor.metamodel.ontouml.Domain#getDimensions()
	 * @see #getDomain()
	 * @generated
	 */
	EReference getDomain_Dimensions();

	/**
	 * Returns the meta object for class '{@link net.menthor.metamodel.ontouml.Dimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dimension</em>'.
	 * @see net.menthor.metamodel.ontouml.Dimension
	 * @generated
	 */
	EClass getDimension();

	/**
	 * Returns the meta object for the reference '{@link net.menthor.metamodel.ontouml.Dimension#getOwnerDomain <em>Owner Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner Domain</em>'.
	 * @see net.menthor.metamodel.ontouml.Dimension#getOwnerDomain()
	 * @see #getDimension()
	 * @generated
	 */
	EReference getDimension_OwnerDomain();

	/**
	 * Returns the meta object for the reference '{@link net.menthor.metamodel.ontouml.Dimension#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Lower Bound</em>'.
	 * @see net.menthor.metamodel.ontouml.Dimension#getLowerBound()
	 * @see #getDimension()
	 * @generated
	 */
	EReference getDimension_LowerBound();

	/**
	 * Returns the meta object for the reference '{@link net.menthor.metamodel.ontouml.Dimension#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Upper Bound</em>'.
	 * @see net.menthor.metamodel.ontouml.Dimension#getUpperBound()
	 * @see #getDimension()
	 * @generated
	 */
	EReference getDimension_UpperBound();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.Dimension#getUnitOfMeasure <em>Unit Of Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit Of Measure</em>'.
	 * @see net.menthor.metamodel.ontouml.Dimension#getUnitOfMeasure()
	 * @see #getDimension()
	 * @generated
	 */
	EAttribute getDimension_UnitOfMeasure();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.Dimension#getScale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale</em>'.
	 * @see net.menthor.metamodel.ontouml.Dimension#getScale()
	 * @see #getDimension()
	 * @generated
	 */
	EAttribute getDimension_Scale();

	/**
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.Dimension#getMeasure <em>Measure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Measure</em>'.
	 * @see net.menthor.metamodel.ontouml.Dimension#getMeasure()
	 * @see #getDimension()
	 * @generated
	 */
	EAttribute getDimension_Measure();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Dimension#isNominal() <em>Is Nominal</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Nominal</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Dimension#isNominal()
	 * @generated
	 */
	EOperation getDimension__IsNominal();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Dimension#isInterval() <em>Is Interval</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Interval</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Dimension#isInterval()
	 * @generated
	 */
	EOperation getDimension__IsInterval();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Dimension#isOrdinal() <em>Is Ordinal</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Ordinal</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Dimension#isOrdinal()
	 * @generated
	 */
	EOperation getDimension__IsOrdinal();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Dimension#isRational() <em>Is Rational</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Rational</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Dimension#isRational()
	 * @generated
	 */
	EOperation getDimension__IsRational();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Dimension#isString() <em>Is String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is String</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Dimension#isString()
	 * @generated
	 */
	EOperation getDimension__IsString();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Dimension#isInteger() <em>Is Integer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Integer</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Dimension#isInteger()
	 * @generated
	 */
	EOperation getDimension__IsInteger();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Dimension#isDecimal() <em>Is Decimal</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Decimal</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Dimension#isDecimal()
	 * @generated
	 */
	EOperation getDimension__IsDecimal();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Dimension#isNominalString() <em>Is Nominal String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Nominal String</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Dimension#isNominalString()
	 * @generated
	 */
	EOperation getDimension__IsNominalString();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Dimension#isIntervalInteger() <em>Is Interval Integer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Interval Integer</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Dimension#isIntervalInteger()
	 * @generated
	 */
	EOperation getDimension__IsIntervalInteger();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Dimension#isIntervalDecimal() <em>Is Interval Decimal</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Interval Decimal</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Dimension#isIntervalDecimal()
	 * @generated
	 */
	EOperation getDimension__IsIntervalDecimal();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Dimension#isOrdinalInteger() <em>Is Ordinal Integer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Ordinal Integer</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Dimension#isOrdinalInteger()
	 * @generated
	 */
	EOperation getDimension__IsOrdinalInteger();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Dimension#isOrdinalDecimal() <em>Is Ordinal Decimal</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Ordinal Decimal</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Dimension#isOrdinalDecimal()
	 * @generated
	 */
	EOperation getDimension__IsOrdinalDecimal();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Dimension#isRationalInteger() <em>Is Rational Integer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Rational Integer</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Dimension#isRationalInteger()
	 * @generated
	 */
	EOperation getDimension__IsRationalInteger();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Dimension#isRationalDecimal() <em>Is Rational Decimal</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Rational Decimal</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Dimension#isRationalDecimal()
	 * @generated
	 */
	EOperation getDimension__IsRationalDecimal();

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
	 * Returns the meta object for the attribute '{@link net.menthor.metamodel.ontouml.Property#isIsDependency <em>Is Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Dependency</em>'.
	 * @see net.menthor.metamodel.ontouml.Property#isIsDependency()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_IsDependency();

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
	 * Returns the meta object for the reference '{@link net.menthor.metamodel.ontouml.Relationship#getDerivedFromTruthMaker <em>Derived From Truth Maker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Derived From Truth Maker</em>'.
	 * @see net.menthor.metamodel.ontouml.Relationship#getDerivedFromTruthMaker()
	 * @see #getRelationship()
	 * @generated
	 */
	EReference getRelationship_DerivedFromTruthMaker();

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
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isDerivation() <em>Is Derivation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Derivation</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isDerivation()
	 * @generated
	 */
	EOperation getRelationship__IsDerivation();

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
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isBinary() <em>Is Binary</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Binary</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isBinary()
	 * @generated
	 */
	EOperation getRelationship__IsBinary();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isTernary() <em>Is Ternary</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Ternary</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isTernary()
	 * @generated
	 */
	EOperation getRelationship__IsTernary();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#sourceEnd() <em>Source End</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Source End</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#sourceEnd()
	 * @generated
	 */
	EOperation getRelationship__SourceEnd();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#targetEnd() <em>Target End</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Target End</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#targetEnd()
	 * @generated
	 */
	EOperation getRelationship__TargetEnd();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#source() <em>Source</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Source</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#source()
	 * @generated
	 */
	EOperation getRelationship__Source();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#target() <em>Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Target</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#target()
	 * @generated
	 */
	EOperation getRelationship__Target();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#sourceClass() <em>Source Class</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Source Class</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#sourceClass()
	 * @generated
	 */
	EOperation getRelationship__SourceClass();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#targetClass() <em>Target Class</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Target Class</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#targetClass()
	 * @generated
	 */
	EOperation getRelationship__TargetClass();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#sourceRelationship() <em>Source Relationship</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Source Relationship</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#sourceRelationship()
	 * @generated
	 */
	EOperation getRelationship__SourceRelationship();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#targetRelationship() <em>Target Relationship</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Target Relationship</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#targetRelationship()
	 * @generated
	 */
	EOperation getRelationship__TargetRelationship();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isDerived() <em>Is Derived</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Derived</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isDerived()
	 * @generated
	 */
	EOperation getRelationship__IsDerived();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isEnd(net.menthor.metamodel.ontouml.Classifier) <em>Is End</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is End</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isEnd(net.menthor.metamodel.ontouml.Classifier)
	 * @generated
	 */
	EOperation getRelationship__IsEnd__Classifier();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isPartEssential() <em>Is Part Essential</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Part Essential</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isPartEssential()
	 * @generated
	 */
	EOperation getRelationship__IsPartEssential();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isPartInseparable() <em>Is Part Inseparable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Part Inseparable</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isPartInseparable()
	 * @generated
	 */
	EOperation getRelationship__IsPartInseparable();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isPartImmutable() <em>Is Part Immutable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Part Immutable</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isPartImmutable()
	 * @generated
	 */
	EOperation getRelationship__IsPartImmutable();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isWholeImmutable() <em>Is Whole Immutable</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Whole Immutable</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isWholeImmutable()
	 * @generated
	 */
	EOperation getRelationship__IsWholeImmutable();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isPartMandatory() <em>Is Part Mandatory</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Part Mandatory</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isPartMandatory()
	 * @generated
	 */
	EOperation getRelationship__IsPartMandatory();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#isWholeMandatory() <em>Is Whole Mandatory</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Whole Mandatory</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#isWholeMandatory()
	 * @generated
	 */
	EOperation getRelationship__IsWholeMandatory();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#material() <em>Material</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Material</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#material()
	 * @generated
	 */
	EOperation getRelationship__Material();

	/**
	 * Returns the meta object for the '{@link net.menthor.metamodel.ontouml.Relationship#relator() <em>Relator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Relator</em>' operation.
	 * @see net.menthor.metamodel.ontouml.Relationship#relator()
	 * @generated
	 */
	EOperation getRelationship__Relator();

	/**
	 * Returns the meta object for enum '{@link net.menthor.metamodel.ontouml.ClassStereotype <em>Class Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Class Stereotype</em>'.
	 * @see net.menthor.metamodel.ontouml.ClassStereotype
	 * @generated
	 */
	EEnum getClassStereotype();

	/**
	 * Returns the meta object for enum '{@link net.menthor.metamodel.ontouml.QualityNature <em>Quality Nature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Quality Nature</em>'.
	 * @see net.menthor.metamodel.ontouml.QualityNature
	 * @generated
	 */
	EEnum getQualityNature();

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
	 * Returns the meta object for enum '{@link net.menthor.metamodel.ontouml.Scale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Scale</em>'.
	 * @see net.menthor.metamodel.ontouml.Scale
	 * @generated
	 */
	EEnum getScale();

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
	 * Returns the meta object for enum '{@link net.menthor.metamodel.ontouml.Temporal <em>Temporal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Temporal</em>'.
	 * @see net.menthor.metamodel.ontouml.Temporal
	 * @generated
	 */
	EEnum getTemporal();

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
		 * The meta object literal for the '<em><b>Packages</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTAINER___PACKAGES = eINSTANCE.getContainer__Packages();

		/**
		 * The meta object literal for the '<em><b>All Packages</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTAINER___ALL_PACKAGES__CONTAINER_ELIST = eINSTANCE.getContainer__AllPackages__Container_EList();

		/**
		 * The meta object literal for the '<em><b>All Packages</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTAINER___ALL_PACKAGES = eINSTANCE.getContainer__AllPackages();

		/**
		 * The meta object literal for the '<em><b>Relationships</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTAINER___RELATIONSHIPS = eINSTANCE.getContainer__Relationships();

		/**
		 * The meta object literal for the '<em><b>All Relationships</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTAINER___ALL_RELATIONSHIPS__CONTAINER_ELIST = eINSTANCE.getContainer__AllRelationships__Container_EList();

		/**
		 * The meta object literal for the '<em><b>All Relationships</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTAINER___ALL_RELATIONSHIPS = eINSTANCE.getContainer__AllRelationships();

		/**
		 * The meta object literal for the '<em><b>Generalization Sets</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTAINER___GENERALIZATION_SETS = eINSTANCE.getContainer__GeneralizationSets();

		/**
		 * The meta object literal for the '<em><b>All Generalization Sets</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTAINER___ALL_GENERALIZATION_SETS__CONTAINER_ELIST = eINSTANCE.getContainer__AllGeneralizationSets__Container_EList();

		/**
		 * The meta object literal for the '<em><b>All Generalization Sets</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTAINER___ALL_GENERALIZATION_SETS = eINSTANCE.getContainer__AllGeneralizationSets();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTAINER___CLASSES = eINSTANCE.getContainer__Classes();

		/**
		 * The meta object literal for the '<em><b>All Classes</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTAINER___ALL_CLASSES__CONTAINER_ELIST = eINSTANCE.getContainer__AllClasses__Container_EList();

		/**
		 * The meta object literal for the '<em><b>All Classes</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTAINER___ALL_CLASSES = eINSTANCE.getContainer__AllClasses();

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
		 * The meta object literal for the '<em><b>Get Model</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTAINED_ELEMENT___GET_MODEL__CONTAINER = eINSTANCE.getContainedElement__GetModel__Container();

		/**
		 * The meta object literal for the '<em><b>Get Model</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CONTAINED_ELEMENT___GET_MODEL = eINSTANCE.getContainedElement__GetModel();

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
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.ClassifierImpl <em>Classifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.ClassifierImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getClassifier()
		 * @generated
		 */
		EClass CLASSIFIER = eINSTANCE.getClassifier();

		/**
		 * The meta object literal for the '<em><b>Is Specialized Via</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER__IS_SPECIALIZED_VIA = eINSTANCE.getClassifier_IsSpecializedVia();

		/**
		 * The meta object literal for the '<em><b>Specializes Via</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASSIFIER__SPECIALIZES_VIA = eINSTANCE.getClassifier_SpecializesVia();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASSIFIER___CHILDREN = eINSTANCE.getClassifier__Children();

		/**
		 * The meta object literal for the '<em><b>Parents</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASSIFIER___PARENTS = eINSTANCE.getClassifier__Parents();

		/**
		 * The meta object literal for the '<em><b>All Parents</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASSIFIER___ALL_PARENTS__CLASSIFIER_ELIST = eINSTANCE.getClassifier__AllParents__Classifier_EList();

		/**
		 * The meta object literal for the '<em><b>All Parents</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASSIFIER___ALL_PARENTS = eINSTANCE.getClassifier__AllParents();

		/**
		 * The meta object literal for the '<em><b>All Children</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASSIFIER___ALL_CHILDREN__CLASSIFIER_ELIST = eINSTANCE.getClassifier__AllChildren__Classifier_EList();

		/**
		 * The meta object literal for the '<em><b>All Children</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASSIFIER___ALL_CHILDREN = eINSTANCE.getClassifier__AllChildren();

		/**
		 * The meta object literal for the '<em><b>Siblings</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASSIFIER___SIBLINGS = eINSTANCE.getClassifier__Siblings();

		/**
		 * The meta object literal for the '<em><b>Ends</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASSIFIER___ENDS = eINSTANCE.getClassifier__Ends();

		/**
		 * The meta object literal for the '<em><b>All Ends</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASSIFIER___ALL_ENDS = eINSTANCE.getClassifier__AllEnds();

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
		 * The meta object literal for the '<em><b>Specialized Classifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERALIZATION_SET__SPECIALIZED_CLASSIFIER = eINSTANCE.getGeneralizationSet_SpecializedClassifier();

		/**
		 * The meta object literal for the '<em><b>Specializing Classifier</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERALIZATION_SET__SPECIALIZING_CLASSIFIER = eINSTANCE.getGeneralizationSet_SpecializingClassifier();

		/**
		 * The meta object literal for the '<em><b>High Order</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERALIZATION_SET__HIGH_ORDER = eINSTANCE.getGeneralizationSet_HighOrder();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.TypeImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '<em><b>Related Types</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE___RELATED_TYPES = eINSTANCE.getType__RelatedTypes();

		/**
		 * The meta object literal for the '<em><b>All Related Types</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPE___ALL_RELATED_TYPES = eINSTANCE.getType__AllRelatedTypes();

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
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__ATTRIBUTES = eINSTANCE.getClass_Attributes();

		/**
		 * The meta object literal for the '<em><b>Is Extensional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__IS_EXTENSIONAL = eINSTANCE.getClass_IsExtensional();

		/**
		 * The meta object literal for the '<em><b>Quality Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__QUALITY_TYPE = eINSTANCE.getClass_QualityType();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__LITERALS = eINSTANCE.getClass_Literals();

		/**
		 * The meta object literal for the '<em><b>Grounding Structure</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__GROUNDING_STRUCTURE = eINSTANCE.getClass_GroundingStructure();

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
		 * The meta object literal for the '<em><b>Is Semi Rigid</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_SEMI_RIGID = eINSTANCE.getClass__IsSemiRigid();

		/**
		 * The meta object literal for the '<em><b>Is Moment</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_MOMENT = eINSTANCE.getClass__IsMoment();

		/**
		 * The meta object literal for the '<em><b>Is Identity Provider</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_IDENTITY_PROVIDER = eINSTANCE.getClass__IsIdentityProvider();

		/**
		 * The meta object literal for the '<em><b>Is Truth Maker</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_TRUTH_MAKER = eINSTANCE.getClass__IsTruthMaker();

		/**
		 * The meta object literal for the '<em><b>Is Mixin Class</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_MIXIN_CLASS = eINSTANCE.getClass__IsMixinClass();

		/**
		 * The meta object literal for the '<em><b>Identity Providers At All Parents</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IDENTITY_PROVIDERS_AT_ALL_PARENTS = eINSTANCE.getClass__IdentityProvidersAtAllParents();

		/**
		 * The meta object literal for the '<em><b>Identity Providers At All Children</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IDENTITY_PROVIDERS_AT_ALL_CHILDREN = eINSTANCE.getClass__IdentityProvidersAtAllChildren();

		/**
		 * The meta object literal for the '<em><b>Identity Providers</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IDENTITY_PROVIDERS = eINSTANCE.getClass__IdentityProviders();

		/**
		 * The meta object literal for the '<em><b>Is Amount Of Matter</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_AMOUNT_OF_MATTER = eINSTANCE.getClass__IsAmountOfMatter();

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
		 * The meta object literal for the '<em><b>Is Intrinsic</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS___IS_INTRINSIC = eINSTANCE.getClass__IsIntrinsic();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.LiteralImpl <em>Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.LiteralImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getLiteral()
		 * @generated
		 */
		EClass LITERAL = eINSTANCE.getLiteral();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LITERAL__OWNER = eINSTANCE.getLiteral_Owner();

		/**
		 * The meta object literal for the '<em><b>Grounding Region</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LITERAL__GROUNDING_REGION = eINSTANCE.getLiteral_GroundingRegion();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LITERAL__VALUE = eINSTANCE.getLiteral_Value();

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
		 * The meta object literal for the '<em><b>Primitive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__PRIMITIVE = eINSTANCE.getAttribute_Primitive();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.StructureImpl <em>Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.StructureImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getStructure()
		 * @generated
		 */
		EClass STRUCTURE = eINSTANCE.getStructure();

		/**
		 * The meta object literal for the '<em><b>Regions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE__REGIONS = eINSTANCE.getStructure_Regions();

		/**
		 * The meta object literal for the '<em><b>Grounded Enumeration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURE__GROUNDED_ENUMERATION = eINSTANCE.getStructure_GroundedEnumeration();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.RegionImpl <em>Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.RegionImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getRegion()
		 * @generated
		 */
		EClass REGION = eINSTANCE.getRegion();

		/**
		 * The meta object literal for the '<em><b>Owner Structure</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__OWNER_STRUCTURE = eINSTANCE.getRegion_OwnerStructure();

		/**
		 * The meta object literal for the '<em><b>Grounded Literal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__GROUNDED_LITERAL = eINSTANCE.getRegion_GroundedLiteral();

		/**
		 * The meta object literal for the '<em><b>Composed By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__COMPOSED_BY = eINSTANCE.getRegion_ComposedBy();

		/**
		 * The meta object literal for the '<em><b>Basic Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REGION__BASIC_TYPE = eINSTANCE.getRegion_BasicType();

		/**
		 * The meta object literal for the '<em><b>Is Basic</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REGION___IS_BASIC = eINSTANCE.getRegion__IsBasic();

		/**
		 * The meta object literal for the '<em><b>Is Composed</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REGION___IS_COMPOSED = eINSTANCE.getRegion__IsComposed();

		/**
		 * The meta object literal for the '<em><b>Is Nominal</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REGION___IS_NOMINAL = eINSTANCE.getRegion__IsNominal();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.DomainImpl <em>Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.DomainImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getDomain()
		 * @generated
		 */
		EClass DOMAIN = eINSTANCE.getDomain();

		/**
		 * The meta object literal for the '<em><b>Dimensions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN__DIMENSIONS = eINSTANCE.getDomain_Dimensions();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.impl.DimensionImpl <em>Dimension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.impl.DimensionImpl
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getDimension()
		 * @generated
		 */
		EClass DIMENSION = eINSTANCE.getDimension();

		/**
		 * The meta object literal for the '<em><b>Owner Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIMENSION__OWNER_DOMAIN = eINSTANCE.getDimension_OwnerDomain();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIMENSION__LOWER_BOUND = eINSTANCE.getDimension_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIMENSION__UPPER_BOUND = eINSTANCE.getDimension_UpperBound();

		/**
		 * The meta object literal for the '<em><b>Unit Of Measure</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIMENSION__UNIT_OF_MEASURE = eINSTANCE.getDimension_UnitOfMeasure();

		/**
		 * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIMENSION__SCALE = eINSTANCE.getDimension_Scale();

		/**
		 * The meta object literal for the '<em><b>Measure</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIMENSION__MEASURE = eINSTANCE.getDimension_Measure();

		/**
		 * The meta object literal for the '<em><b>Is Nominal</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DIMENSION___IS_NOMINAL = eINSTANCE.getDimension__IsNominal();

		/**
		 * The meta object literal for the '<em><b>Is Interval</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DIMENSION___IS_INTERVAL = eINSTANCE.getDimension__IsInterval();

		/**
		 * The meta object literal for the '<em><b>Is Ordinal</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DIMENSION___IS_ORDINAL = eINSTANCE.getDimension__IsOrdinal();

		/**
		 * The meta object literal for the '<em><b>Is Rational</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DIMENSION___IS_RATIONAL = eINSTANCE.getDimension__IsRational();

		/**
		 * The meta object literal for the '<em><b>Is String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DIMENSION___IS_STRING = eINSTANCE.getDimension__IsString();

		/**
		 * The meta object literal for the '<em><b>Is Integer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DIMENSION___IS_INTEGER = eINSTANCE.getDimension__IsInteger();

		/**
		 * The meta object literal for the '<em><b>Is Decimal</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DIMENSION___IS_DECIMAL = eINSTANCE.getDimension__IsDecimal();

		/**
		 * The meta object literal for the '<em><b>Is Nominal String</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DIMENSION___IS_NOMINAL_STRING = eINSTANCE.getDimension__IsNominalString();

		/**
		 * The meta object literal for the '<em><b>Is Interval Integer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DIMENSION___IS_INTERVAL_INTEGER = eINSTANCE.getDimension__IsIntervalInteger();

		/**
		 * The meta object literal for the '<em><b>Is Interval Decimal</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DIMENSION___IS_INTERVAL_DECIMAL = eINSTANCE.getDimension__IsIntervalDecimal();

		/**
		 * The meta object literal for the '<em><b>Is Ordinal Integer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DIMENSION___IS_ORDINAL_INTEGER = eINSTANCE.getDimension__IsOrdinalInteger();

		/**
		 * The meta object literal for the '<em><b>Is Ordinal Decimal</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DIMENSION___IS_ORDINAL_DECIMAL = eINSTANCE.getDimension__IsOrdinalDecimal();

		/**
		 * The meta object literal for the '<em><b>Is Rational Integer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DIMENSION___IS_RATIONAL_INTEGER = eINSTANCE.getDimension__IsRationalInteger();

		/**
		 * The meta object literal for the '<em><b>Is Rational Decimal</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DIMENSION___IS_RATIONAL_DECIMAL = eINSTANCE.getDimension__IsRationalDecimal();

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
		 * The meta object literal for the '<em><b>Is Dependency</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__IS_DEPENDENCY = eINSTANCE.getProperty_IsDependency();

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
		 * The meta object literal for the '<em><b>Derived From Truth Maker</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONSHIP__DERIVED_FROM_TRUTH_MAKER = eINSTANCE.getRelationship_DerivedFromTruthMaker();

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
		 * The meta object literal for the '<em><b>Is Derivation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_DERIVATION = eINSTANCE.getRelationship__IsDerivation();

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
		 * The meta object literal for the '<em><b>Is Binary</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_BINARY = eINSTANCE.getRelationship__IsBinary();

		/**
		 * The meta object literal for the '<em><b>Is Ternary</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_TERNARY = eINSTANCE.getRelationship__IsTernary();

		/**
		 * The meta object literal for the '<em><b>Source End</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___SOURCE_END = eINSTANCE.getRelationship__SourceEnd();

		/**
		 * The meta object literal for the '<em><b>Target End</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___TARGET_END = eINSTANCE.getRelationship__TargetEnd();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___SOURCE = eINSTANCE.getRelationship__Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___TARGET = eINSTANCE.getRelationship__Target();

		/**
		 * The meta object literal for the '<em><b>Source Class</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___SOURCE_CLASS = eINSTANCE.getRelationship__SourceClass();

		/**
		 * The meta object literal for the '<em><b>Target Class</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___TARGET_CLASS = eINSTANCE.getRelationship__TargetClass();

		/**
		 * The meta object literal for the '<em><b>Source Relationship</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___SOURCE_RELATIONSHIP = eINSTANCE.getRelationship__SourceRelationship();

		/**
		 * The meta object literal for the '<em><b>Target Relationship</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___TARGET_RELATIONSHIP = eINSTANCE.getRelationship__TargetRelationship();

		/**
		 * The meta object literal for the '<em><b>Is Derived</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_DERIVED = eINSTANCE.getRelationship__IsDerived();

		/**
		 * The meta object literal for the '<em><b>Is End</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_END__CLASSIFIER = eINSTANCE.getRelationship__IsEnd__Classifier();

		/**
		 * The meta object literal for the '<em><b>Is Part Essential</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_PART_ESSENTIAL = eINSTANCE.getRelationship__IsPartEssential();

		/**
		 * The meta object literal for the '<em><b>Is Part Inseparable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_PART_INSEPARABLE = eINSTANCE.getRelationship__IsPartInseparable();

		/**
		 * The meta object literal for the '<em><b>Is Part Immutable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_PART_IMMUTABLE = eINSTANCE.getRelationship__IsPartImmutable();

		/**
		 * The meta object literal for the '<em><b>Is Whole Immutable</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_WHOLE_IMMUTABLE = eINSTANCE.getRelationship__IsWholeImmutable();

		/**
		 * The meta object literal for the '<em><b>Is Part Mandatory</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_PART_MANDATORY = eINSTANCE.getRelationship__IsPartMandatory();

		/**
		 * The meta object literal for the '<em><b>Is Whole Mandatory</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___IS_WHOLE_MANDATORY = eINSTANCE.getRelationship__IsWholeMandatory();

		/**
		 * The meta object literal for the '<em><b>Material</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___MATERIAL = eINSTANCE.getRelationship__Material();

		/**
		 * The meta object literal for the '<em><b>Relator</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONSHIP___RELATOR = eINSTANCE.getRelationship__Relator();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.ClassStereotype <em>Class Stereotype</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.ClassStereotype
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getClassStereotype()
		 * @generated
		 */
		EEnum CLASS_STEREOTYPE = eINSTANCE.getClassStereotype();

		/**
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.QualityNature <em>Quality Nature</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.QualityNature
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getQualityNature()
		 * @generated
		 */
		EEnum QUALITY_NATURE = eINSTANCE.getQualityNature();

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
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.Scale <em>Scale</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.Scale
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getScale()
		 * @generated
		 */
		EEnum SCALE = eINSTANCE.getScale();

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
		 * The meta object literal for the '{@link net.menthor.metamodel.ontouml.Temporal <em>Temporal</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see net.menthor.metamodel.ontouml.Temporal
		 * @see net.menthor.metamodel.ontouml.impl.OntoumlPackageImpl#getTemporal()
		 * @generated
		 */
		EEnum TEMPORAL = eINSTANCE.getTemporal();

	}

} //OntoumlPackage
