/**
 */
package net.menthor.metamodel.ontouml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * * =========================================
 *  - class (type)
 * 
 *  A class is named classifier that may have a stereotype.
 *  In the case where the stereotype is an enumeration, the class must have 2 or more enumeration literals (constraint C1).
 *  In the case where the stereotype is a quality, the class must define a quality type (constraint C4).
 *  A class may also be abstract or derived, and contain a set of attributes.
 *  Data-Types and Enumeration cannot be derived (Constraint C6).
 *  Enumerations may be a ground for a quality reference structure (Constraint C17).
 *  In the case where the stereotype is not a hou, data-type or enumeration, the class may be an instance of one or more high order classes (constraint C2, C3).
 *  In the case where the class is a truth maker (relator's descendant or relator), that class may be a truth maker for one or more material relationships (constraint C5).
 *  A class may be in a set of generalization sets as super-class or sub-class.
 *  ========================================
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#isIsDerived <em>Is Derived</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#isIsExtensional <em>Is Extensional</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getQualityType <em>Quality Type</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getLiterals <em>Literals</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getGroundingStructure <em>Grounding Structure</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getInstanceOf <em>Instance Of</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getIstruthMakerOf <em>Istruth Maker Of</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends Type {
	/**
	 * Returns the value of the '<em><b>Stereotype</b></em>' attribute.
	 * The literals are from the enumeration {@link net.menthor.metamodel.ontouml.ClassStereotype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotype</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.ClassStereotype
	 * @see #setStereotype(ClassStereotype)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_Stereotype()
	 * @model unique="false"
	 * @generated
	 */
	ClassStereotype getStereotype();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Class#getStereotype <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotype</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.ClassStereotype
	 * @see #getStereotype()
	 * @generated
	 */
	void setStereotype(ClassStereotype value);

	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #setIsAbstract(boolean)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_IsAbstract()
	 * @model unique="false"
	 * @generated
	 */
	boolean isIsAbstract();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Class#isIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #isIsAbstract()
	 * @generated
	 */
	void setIsAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Derived</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Derived</em>' attribute.
	 * @see #setIsDerived(boolean)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_IsDerived()
	 * @model unique="false"
	 * @generated
	 */
	boolean isIsDerived();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Class#isIsDerived <em>Is Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Derived</em>' attribute.
	 * @see #isIsDerived()
	 * @generated
	 */
	void setIsDerived(boolean value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.Attribute}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Attribute#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_Attributes()
	 * @see net.menthor.metamodel.ontouml.Attribute#getOwner
	 * @model opposite="owner" containment="true" ordered="false"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Is Extensional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Extensional</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Extensional</em>' attribute.
	 * @see #setIsExtensional(boolean)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_IsExtensional()
	 * @model unique="false"
	 * @generated
	 */
	boolean isIsExtensional();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Class#isIsExtensional <em>Is Extensional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Extensional</em>' attribute.
	 * @see #isIsExtensional()
	 * @generated
	 */
	void setIsExtensional(boolean value);

	/**
	 * Returns the value of the '<em><b>Quality Type</b></em>' attribute.
	 * The literals are from the enumeration {@link net.menthor.metamodel.ontouml.QualityNature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quality Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quality Type</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.QualityNature
	 * @see #setQualityType(QualityNature)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_QualityType()
	 * @model unique="false"
	 * @generated
	 */
	QualityNature getQualityType();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Class#getQualityType <em>Quality Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quality Type</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.QualityNature
	 * @see #getQualityType()
	 * @generated
	 */
	void setQualityType(QualityNature value);

	/**
	 * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.Literal}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Literal#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literals</em>' containment reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_Literals()
	 * @see net.menthor.metamodel.ontouml.Literal#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Literal> getLiterals();

	/**
	 * Returns the value of the '<em><b>Grounding Structure</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Structure#getGroundedEnumeration <em>Grounded Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grounding Structure</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grounding Structure</em>' reference.
	 * @see #setGroundingStructure(Structure)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_GroundingStructure()
	 * @see net.menthor.metamodel.ontouml.Structure#getGroundedEnumeration
	 * @model opposite="groundedEnumeration"
	 * @generated
	 */
	Structure getGroundingStructure();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Class#getGroundingStructure <em>Grounding Structure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grounding Structure</em>' reference.
	 * @see #getGroundingStructure()
	 * @generated
	 */
	void setGroundingStructure(Structure value);

	/**
	 * Returns the value of the '<em><b>Instance Of</b></em>' reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Of</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Of</em>' reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_InstanceOf()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Class> getInstanceOf();

	/**
	 * Returns the value of the '<em><b>Istruth Maker Of</b></em>' reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.Relationship}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Relationship#getDerivedFromTruthMaker <em>Derived From Truth Maker</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Istruth Maker Of</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Istruth Maker Of</em>' reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_IstruthMakerOf()
	 * @see net.menthor.metamodel.ontouml.Relationship#getDerivedFromTruthMaker
	 * @model opposite="derivedFromTruthMaker" ordered="false"
	 * @generated
	 */
	EList<Relationship> getIstruthMakerOf();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.ClassStereotype%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.ClassStereotype%>.KIND);'"
	 * @generated
	 */
	boolean isKind();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.ClassStereotype%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.ClassStereotype%>.SUB_KIND);'"
	 * @generated
	 */
	boolean isSubKind();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.ClassStereotype%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.ClassStereotype%>.COLLECTIVE);'"
	 * @generated
	 */
	boolean isCollective();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.ClassStereotype%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.ClassStereotype%>.QUANTITY);'"
	 * @generated
	 */
	boolean isQuantity();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.ClassStereotype%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.ClassStereotype%>.RELATOR);'"
	 * @generated
	 */
	boolean isRelator();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.ClassStereotype%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.ClassStereotype%>.MODE);'"
	 * @generated
	 */
	boolean isMode();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.ClassStereotype%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.ClassStereotype%>.QUALITY);'"
	 * @generated
	 */
	boolean isQuality();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.ClassStereotype%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.ClassStereotype%>.ROLE);'"
	 * @generated
	 */
	boolean isRole();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.ClassStereotype%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.ClassStereotype%>.ROLE_MIXIN);'"
	 * @generated
	 */
	boolean isRoleMixin();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.ClassStereotype%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.ClassStereotype%>.PHASE_MIXIN);'"
	 * @generated
	 */
	boolean isPhaseMixin();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.ClassStereotype%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.ClassStereotype%>.PHASE);'"
	 * @generated
	 */
	boolean isPhase();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.ClassStereotype%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.ClassStereotype%>.CATEGORY);'"
	 * @generated
	 */
	boolean isCategory();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.ClassStereotype%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.ClassStereotype%>.MIXIN);'"
	 * @generated
	 */
	boolean isMixin();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.ClassStereotype%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.ClassStereotype%>.EVENT);'"
	 * @generated
	 */
	boolean isEvent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.ClassStereotype%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.ClassStereotype%>.HIGH_ORDER);'"
	 * @generated
	 */
	boolean isHighOrder();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.ClassStereotype%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.ClassStereotype%>.DATA_TYPE);'"
	 * @generated
	 */
	boolean isDataType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.ClassStereotype%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.ClassStereotype%>.ENUMERATION);'"
	 * @generated
	 */
	boolean isEnumeration();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _or = false;\nboolean _or_1 = false;\nboolean _or_2 = false;\nboolean _or_3 = false;\nboolean _or_4 = false;\nboolean _or_5 = false;\nboolean _or_6 = false;\nboolean _isKind = this.isKind();\nif (_isKind)\n{\n\t_or_6 = true;\n} else\n{\n\tboolean _isCollective = this.isCollective();\n\t_or_6 = _isCollective;\n}\nif (_or_6)\n{\n\t_or_5 = true;\n} else\n{\n\tboolean _isQuantity = this.isQuantity();\n\t_or_5 = _isQuantity;\n}\nif (_or_5)\n{\n\t_or_4 = true;\n} else\n{\n\tboolean _isRelator = this.isRelator();\n\t_or_4 = _isRelator;\n}\nif (_or_4)\n{\n\t_or_3 = true;\n} else\n{\n\tboolean _isMode = this.isMode();\n\t_or_3 = _isMode;\n}\nif (_or_3)\n{\n\t_or_2 = true;\n} else\n{\n\tboolean _isQuality = this.isQuality();\n\t_or_2 = _isQuality;\n}\nif (_or_2)\n{\n\t_or_1 = true;\n} else\n{\n\tboolean _isSubKind = this.isSubKind();\n\t_or_1 = _isSubKind;\n}\nif (_or_1)\n{\n\t_or = true;\n} else\n{\n\tboolean _isCategory = this.isCategory();\n\t_or = _isCategory;\n}\nreturn _or;'"
	 * @generated
	 */
	boolean isRigid();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _or = false;\nboolean _or_1 = false;\nboolean _or_2 = false;\nboolean _isRole = this.isRole();\nif (_isRole)\n{\n\t_or_2 = true;\n} else\n{\n\tboolean _isPhase = this.isPhase();\n\t_or_2 = _isPhase;\n}\nif (_or_2)\n{\n\t_or_1 = true;\n} else\n{\n\tboolean _isRoleMixin = this.isRoleMixin();\n\t_or_1 = _isRoleMixin;\n}\nif (_or_1)\n{\n\t_or = true;\n} else\n{\n\tboolean _isMixin = this.isMixin();\n\t_or = _isMixin;\n}\nreturn _or;'"
	 * @generated
	 */
	boolean isNonRigid();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _or = false;\nboolean _or_1 = false;\nboolean _isRole = this.isRole();\nif (_isRole)\n{\n\t_or_1 = true;\n} else\n{\n\tboolean _isPhase = this.isPhase();\n\t_or_1 = _isPhase;\n}\nif (_or_1)\n{\n\t_or = true;\n} else\n{\n\tboolean _isRoleMixin = this.isRoleMixin();\n\t_or = _isRoleMixin;\n}\nreturn _or;'"
	 * @generated
	 */
	boolean isAntiRigid();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _or = false;\nboolean _or_1 = false;\nboolean _isRoleMixin = this.isRoleMixin();\nif (_isRoleMixin)\n{\n\t_or_1 = true;\n} else\n{\n\tboolean _isPhaseMixin = this.isPhaseMixin();\n\t_or_1 = _isPhaseMixin;\n}\nif (_or_1)\n{\n\t_or = true;\n} else\n{\n\tboolean _isMixin = this.isMixin();\n\t_or = _isMixin;\n}\nreturn _or;'"
	 * @generated
	 */
	boolean isSemiRigid();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _or = false;\nboolean _or_1 = false;\nboolean _isTruthMaker = this.isTruthMaker();\nif (_isTruthMaker)\n{\n\t_or_1 = true;\n} else\n{\n\tboolean _isMode = this.isMode();\n\t_or_1 = _isMode;\n}\nif (_or_1)\n{\n\t_or = true;\n} else\n{\n\tboolean _isQuality = this.isQuality();\n\t_or = _isQuality;\n}\nreturn _or;'"
	 * @generated
	 */
	boolean isMoment();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * * Checks if this class is a direct identity provider
	 *  i.e. it does not inherit his identity from other classes.
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _or = false;\nboolean _or_1 = false;\nboolean _or_2 = false;\nboolean _or_3 = false;\nboolean _isKind = this.isKind();\nif (_isKind)\n{\n\t_or_3 = true;\n} else\n{\n\tboolean _isQuantity = this.isQuantity();\n\t_or_3 = _isQuantity;\n}\nif (_or_3)\n{\n\t_or_2 = true;\n} else\n{\n\tboolean _isCollective = this.isCollective();\n\t_or_2 = _isCollective;\n}\nif (_or_2)\n{\n\t_or_1 = true;\n} else\n{\n\tboolean _isRelator = this.isRelator();\n\t_or_1 = _isRelator;\n}\nif (_or_1)\n{\n\t_or = true;\n} else\n{\n\tboolean _isMode = this.isMode();\n\t_or = _isMode;\n}\nreturn _or;'"
	 * @generated
	 */
	boolean isIdentityProvider();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * * Checks if this class is a relator (or descendant of a relator)
	 *  and is related to one or more material relationships
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _isRelator = this.isRelator();\nif (_isRelator)\n{\n\treturn true;\n}\n<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Classifier%>> _allParents = this.allParents();\nfor (final <%net.menthor.metamodel.ontouml.Classifier%> c : _allParents)\n{\n\tif ((c instanceof <%net.menthor.metamodel.ontouml.Class%>))\n\t{\n\t\tboolean _isRelator_1 = ((<%net.menthor.metamodel.ontouml.Class%>)c).isRelator();\n\t\tif (_isRelator_1)\n\t\t{\n\t\t\treturn true;\n\t\t}\n\t}\n}\nreturn false;'"
	 * @generated
	 */
	boolean isTruthMaker();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * * Checks if this class is a Mixin, Category, RoleMixin or PhaseMixin
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _or = false;\nboolean _or_1 = false;\nboolean _or_2 = false;\nboolean _isMixin = this.isMixin();\nif (_isMixin)\n{\n\t_or_2 = true;\n} else\n{\n\tboolean _isRoleMixin = this.isRoleMixin();\n\t_or_2 = _isRoleMixin;\n}\nif (_or_2)\n{\n\t_or_1 = true;\n} else\n{\n\tboolean _isPhaseMixin = this.isPhaseMixin();\n\t_or_1 = _isPhaseMixin;\n}\nif (_or_1)\n{\n\t_or = true;\n} else\n{\n\tboolean _isCategory = this.isCategory();\n\t_or = _isCategory;\n}\nif (_or)\n{\n\treturn true;\n}\nelse\n{\n\treturn false;\n}'"
	 * @generated
	 */
	boolean isMixinClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * * Returns the identity providers amongst all parents of a class (more than one may be found)
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Class%>[] result = null;\n<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Classifier%>> _allParents = this.allParents();\nfor (final <%net.menthor.metamodel.ontouml.Classifier%> p : _allParents)\n{\n\tif ((p instanceof <%net.menthor.metamodel.ontouml.Class%>))\n\t{\n\t\tboolean _isIdentityProvider = ((<%net.menthor.metamodel.ontouml.Class%>)p).isIdentityProvider();\n\t\tif (_isIdentityProvider)\n\t\t{\n\t\t\tfinal <%net.menthor.metamodel.ontouml.Class%>[] _converted_result = (<%net.menthor.metamodel.ontouml.Class%>[])result;\n\t\t\t((<%java.util.List%><<%net.menthor.metamodel.ontouml.Class%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)).add(((<%net.menthor.metamodel.ontouml.Class%>)p));\n\t\t}\n\t}\n}\nfinal <%net.menthor.metamodel.ontouml.Class%>[] _converted_result_1 = (<%net.menthor.metamodel.ontouml.Class%>[])result;\nreturn <%org.eclipse.emf.common.util.ECollections%>.<<%net.menthor.metamodel.ontouml.Class%>>toEList(((<%java.lang.Iterable%><? extends <%net.menthor.metamodel.ontouml.Class%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)));'"
	 * @generated
	 */
	EList<Class> identityProvidersAtAllParents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * * Returns the identity providers amongst all children of a class (more than one may be found)
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Class%>[] result = null;\n<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Classifier%>> _allChildren = this.allChildren();\nfor (final <%net.menthor.metamodel.ontouml.Classifier%> p : _allChildren)\n{\n\tif ((p instanceof <%net.menthor.metamodel.ontouml.Class%>))\n\t{\n\t\tboolean _isIdentityProvider = ((<%net.menthor.metamodel.ontouml.Class%>)p).isIdentityProvider();\n\t\tif (_isIdentityProvider)\n\t\t{\n\t\t\tfinal <%net.menthor.metamodel.ontouml.Class%>[] _converted_result = (<%net.menthor.metamodel.ontouml.Class%>[])result;\n\t\t\t((<%java.util.List%><<%net.menthor.metamodel.ontouml.Class%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)).add(((<%net.menthor.metamodel.ontouml.Class%>)p));\n\t\t}\n\t\tboolean _or = false;\n\t\tboolean _isAntiRigid = ((<%net.menthor.metamodel.ontouml.Class%>)p).isAntiRigid();\n\t\tif (_isAntiRigid)\n\t\t{\n\t\t\t_or = true;\n\t\t} else\n\t\t{\n\t\t\tboolean _isSubKind = ((<%net.menthor.metamodel.ontouml.Class%>)p).isSubKind();\n\t\t\t_or = _isSubKind;\n\t\t}\n\t\tif (_or)\n\t\t{\n\t\t\tfinal <%net.menthor.metamodel.ontouml.Class%>[] _converted_result_1 = (<%net.menthor.metamodel.ontouml.Class%>[])result;\n\t\t\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Class%>> _identityProvidersAtAllParents = ((<%net.menthor.metamodel.ontouml.Class%>)p).identityProvidersAtAllParents();\n\t\t\t((<%java.util.List%><<%net.menthor.metamodel.ontouml.Class%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)).addAll(_identityProvidersAtAllParents);\n\t\t}\n\t}\n}\nfinal <%net.menthor.metamodel.ontouml.Class%>[] _converted_result_2 = (<%net.menthor.metamodel.ontouml.Class%>[])result;\nreturn <%org.eclipse.emf.common.util.ECollections%>.<<%net.menthor.metamodel.ontouml.Class%>>toEList(((<%java.lang.Iterable%><? extends <%net.menthor.metamodel.ontouml.Class%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_2)));'"
	 * @generated
	 */
	EList<Class> identityProvidersAtAllChildren();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * * Returns the identity providers of a class (more than one may be found)
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Class%>[] result = null;\nboolean _isIdentityProvider = this.isIdentityProvider();\nif (_isIdentityProvider)\n{\n\tfinal <%net.menthor.metamodel.ontouml.Class%>[] _converted_result = (<%net.menthor.metamodel.ontouml.Class%>[])result;\n\t((<%java.util.List%><<%net.menthor.metamodel.ontouml.Class%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)).add(this);\n}\nboolean _or = false;\nboolean _isAntiRigid = this.isAntiRigid();\nif (_isAntiRigid)\n{\n\t_or = true;\n} else\n{\n\tboolean _isSubKind = this.isSubKind();\n\t_or = _isSubKind;\n}\nif (_or)\n{\n\tfinal <%net.menthor.metamodel.ontouml.Class%>[] _converted_result_1 = (<%net.menthor.metamodel.ontouml.Class%>[])result;\n\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Class%>> _identityProvidersAtAllParents = this.identityProvidersAtAllParents();\n\t((<%java.util.List%><<%net.menthor.metamodel.ontouml.Class%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)).addAll(_identityProvidersAtAllParents);\n}\nboolean _isMixinClass = this.isMixinClass();\nif (_isMixinClass)\n{\n\tfinal <%net.menthor.metamodel.ontouml.Class%>[] _converted_result_2 = (<%net.menthor.metamodel.ontouml.Class%>[])result;\n\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Class%>> _identityProvidersAtAllChildren = this.identityProvidersAtAllChildren();\n\t((<%java.util.List%><<%net.menthor.metamodel.ontouml.Class%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_2)).addAll(_identityProvidersAtAllChildren);\n\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Classifier%>> _allParents = this.allParents();\n\tfor (final <%net.menthor.metamodel.ontouml.Classifier%> p : _allParents)\n\t{\n\t\tif ((p instanceof <%net.menthor.metamodel.ontouml.Class%>))\n\t\t{\n\t\t\tfinal <%net.menthor.metamodel.ontouml.Class%>[] _converted_result_3 = (<%net.menthor.metamodel.ontouml.Class%>[])result;\n\t\t\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Class%>> _identityProvidersAtAllChildren_1 = ((<%net.menthor.metamodel.ontouml.Class%>)p).identityProvidersAtAllChildren();\n\t\t\t((<%java.util.List%><<%net.menthor.metamodel.ontouml.Class%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_3)).addAll(_identityProvidersAtAllChildren_1);\n\t\t}\n\t}\n}\nfinal <%net.menthor.metamodel.ontouml.Class%>[] _converted_result_4 = (<%net.menthor.metamodel.ontouml.Class%>[])result;\nreturn <%org.eclipse.emf.common.util.ECollections%>.<<%net.menthor.metamodel.ontouml.Class%>>toEList(((<%java.lang.Iterable%><? extends <%net.menthor.metamodel.ontouml.Class%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_4)));'"
	 * @generated
	 */
	EList<Class> identityProviders();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Checks if this class is an amount of matter i.e.
	 * 1) if it is a quantity element, or,
	 * 2) if it is a sub-kind or anti-rigid with exactly one identity provider of the type Quantity, or,
	 * 3) if it is a mixin class in which all their children are quantities.
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _isQuantity = this.isQuantity();\nif (_isQuantity)\n{\n\treturn true;\n}\nboolean _or = false;\nboolean _isAntiRigid = this.isAntiRigid();\nif (_isAntiRigid)\n{\n\t_or = true;\n} else\n{\n\tboolean _isSubKind = this.isSubKind();\n\t_or = _isSubKind;\n}\nif (_or)\n{\n\t<%net.menthor.metamodel.ontouml.Class%>[] providers = null;\n\tfinal <%net.menthor.metamodel.ontouml.Class%>[] _converted_providers = (<%net.menthor.metamodel.ontouml.Class%>[])providers;\n\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Class%>> _identityProviders = this.identityProviders();\n\t((<%java.util.List%><<%net.menthor.metamodel.ontouml.Class%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_providers)).addAll(_identityProviders);\n\tfor (final <%net.menthor.metamodel.ontouml.Class%> c : providers)\n\t{\n\t\tboolean _isQuantity_1 = c.isQuantity();\n\t\tif (_isQuantity_1)\n\t\t{\n\t\t\treturn true;\n\t\t}\n\t}\n}\nboolean _isMixinClass = this.isMixinClass();\nif (_isMixinClass)\n{\n\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Classifier%>> _children = this.children();\n\tint _size = _children.size();\n\tboolean _equals = (_size == 0);\n\tif (_equals)\n\t{\n\t\treturn false;\n\t}\n\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Classifier%>> _children_1 = this.children();\n\tfor (final <%net.menthor.metamodel.ontouml.Classifier%> child : _children_1)\n\t{\n\t\tif ((child instanceof <%net.menthor.metamodel.ontouml.Class%>))\n\t\t{\n\t\t\tboolean _isQuantity_2 = ((<%net.menthor.metamodel.ontouml.Class%>)child).isQuantity();\n\t\t\tboolean _not = (!_isQuantity_2);\n\t\t\tif (_not)\n\t\t\t{\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t}\n\treturn true;\n}\nreturn false;'"
	 * @generated
	 */
	boolean isAmountOfMatter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Checks if this element is a functional complex i.e.
	 * 1) If it is a kind, or
	 * 2) if it is a sub-kind or anti-rigid with exactly one identity provider of the type kind, or,
	 * 3) if it is a mixin class in which all their children are functional complexes.
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _isKind = this.isKind();\nif (_isKind)\n{\n\treturn true;\n}\nboolean _or = false;\nboolean _isAntiRigid = this.isAntiRigid();\nif (_isAntiRigid)\n{\n\t_or = true;\n} else\n{\n\tboolean _isSubKind = this.isSubKind();\n\t_or = _isSubKind;\n}\nif (_or)\n{\n\t<%net.menthor.metamodel.ontouml.Class%>[] providers = null;\n\tfinal <%net.menthor.metamodel.ontouml.Class%>[] _converted_providers = (<%net.menthor.metamodel.ontouml.Class%>[])providers;\n\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Class%>> _identityProviders = this.identityProviders();\n\t((<%java.util.List%><<%net.menthor.metamodel.ontouml.Class%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_providers)).addAll(_identityProviders);\n\tfor (final <%net.menthor.metamodel.ontouml.Class%> c : providers)\n\t{\n\t\tboolean _isKind_1 = c.isKind();\n\t\tif (_isKind_1)\n\t\t{\n\t\t\treturn true;\n\t\t}\n\t}\n}\nboolean _isMixinClass = this.isMixinClass();\nif (_isMixinClass)\n{\n\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Classifier%>> _children = this.children();\n\tint _size = _children.size();\n\tboolean _equals = (_size == 0);\n\tif (_equals)\n\t{\n\t\treturn false;\n\t}\n\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Classifier%>> _children_1 = this.children();\n\tfor (final <%net.menthor.metamodel.ontouml.Classifier%> child : _children_1)\n\t{\n\t\tif ((child instanceof <%net.menthor.metamodel.ontouml.Class%>))\n\t\t{\n\t\t\tboolean _isKind_2 = ((<%net.menthor.metamodel.ontouml.Class%>)child).isKind();\n\t\t\tboolean _not = (!_isKind_2);\n\t\t\tif (_not)\n\t\t\t{\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t}\n\treturn true;\n}\nreturn false;'"
	 * @generated
	 */
	boolean isFunctionalComplex();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Checks if a particular element is a collective i.e.
	 * 1) if it is a collective element, or,
	 * 2) if it is a sub-kind or anti-rigid with exactly one identity provider of the type Collective, or,
	 * 3) if it is a mixin class in which all their children are collectives.
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _isCollective = this.isCollective();\nif (_isCollective)\n{\n\treturn true;\n}\nboolean _or = false;\nboolean _isAntiRigid = this.isAntiRigid();\nif (_isAntiRigid)\n{\n\t_or = true;\n} else\n{\n\tboolean _isSubKind = this.isSubKind();\n\t_or = _isSubKind;\n}\nif (_or)\n{\n\t<%net.menthor.metamodel.ontouml.Class%>[] providers = null;\n\tfinal <%net.menthor.metamodel.ontouml.Class%>[] _converted_providers = (<%net.menthor.metamodel.ontouml.Class%>[])providers;\n\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Class%>> _identityProviders = this.identityProviders();\n\t((<%java.util.List%><<%net.menthor.metamodel.ontouml.Class%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_providers)).addAll(_identityProviders);\n\tfor (final <%net.menthor.metamodel.ontouml.Class%> c : providers)\n\t{\n\t\tboolean _isCollective_1 = c.isCollective();\n\t\tif (_isCollective_1)\n\t\t{\n\t\t\treturn true;\n\t\t}\n\t}\n}\nboolean _isMixinClass = this.isMixinClass();\nif (_isMixinClass)\n{\n\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Classifier%>> _children = this.children();\n\tint _size = _children.size();\n\tboolean _equals = (_size == 0);\n\tif (_equals)\n\t{\n\t\treturn false;\n\t}\n\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Classifier%>> _children_1 = this.children();\n\tfor (final <%net.menthor.metamodel.ontouml.Classifier%> child : _children_1)\n\t{\n\t\tif ((child instanceof <%net.menthor.metamodel.ontouml.Class%>))\n\t\t{\n\t\t\tboolean _isCollective_2 = ((<%net.menthor.metamodel.ontouml.Class%>)child).isCollective();\n\t\t\tboolean _not = (!_isCollective_2);\n\t\t\tif (_not)\n\t\t\t{\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t}\n\treturn true;\n}\nreturn false;'"
	 * @generated
	 */
	boolean isCollection();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Checks if a particular element is a moment  i.e.
	 * 1) if it is a truth maker, mode or quality element, or,
	 * 2) if it is a sub-kind or anti-rigid with exactly one identity provider being a truth maker, mode or quality, or,
	 * 3) if it is a mixin class in which all their children are truth makers, qualities or modes.
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _isMoment = this.isMoment();\nif (_isMoment)\n{\n\treturn true;\n}\nboolean _or = false;\nboolean _isAntiRigid = this.isAntiRigid();\nif (_isAntiRigid)\n{\n\t_or = true;\n} else\n{\n\tboolean _isSubKind = this.isSubKind();\n\t_or = _isSubKind;\n}\nif (_or)\n{\n\t<%net.menthor.metamodel.ontouml.Class%>[] providers = null;\n\tfinal <%net.menthor.metamodel.ontouml.Class%>[] _converted_providers = (<%net.menthor.metamodel.ontouml.Class%>[])providers;\n\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Class%>> _identityProviders = this.identityProviders();\n\t((<%java.util.List%><<%net.menthor.metamodel.ontouml.Class%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_providers)).addAll(_identityProviders);\n\tfor (final <%net.menthor.metamodel.ontouml.Class%> c : providers)\n\t{\n\t\tboolean _isMoment_1 = c.isMoment();\n\t\tif (_isMoment_1)\n\t\t{\n\t\t\treturn true;\n\t\t}\n\t}\n}\nboolean _isMixinClass = this.isMixinClass();\nif (_isMixinClass)\n{\n\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Classifier%>> _children = this.children();\n\tint _size = _children.size();\n\tboolean _equals = (_size == 0);\n\tif (_equals)\n\t{\n\t\treturn false;\n\t}\n\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Classifier%>> _children_1 = this.children();\n\tfor (final <%net.menthor.metamodel.ontouml.Classifier%> child : _children_1)\n\t{\n\t\tif ((child instanceof <%net.menthor.metamodel.ontouml.Class%>))\n\t\t{\n\t\t\tboolean _isMoment_2 = ((<%net.menthor.metamodel.ontouml.Class%>)child).isMoment();\n\t\t\tboolean _not = (!_isMoment_2);\n\t\t\tif (_not)\n\t\t\t{\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t}\n\treturn true;\n}\nreturn false;'"
	 * @generated
	 */
	boolean isIntrinsic();

} // Class
