/**
 */
package net.menthor.metamodel.ontouml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getQualityType <em>Quality Type</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getEnumerationLiterals <em>Enumeration Literals</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#isIsDerived <em>Is Derived</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#isIsExtensional <em>Is Extensional</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getIstruthMakerOf <em>Istruth Maker Of</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getInstanceOf <em>Instance Of</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getIsSpecializedVia <em>Is Specialized Via</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getSpecializesVia <em>Specializes Via</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends NamedElement, ClassifierElement {
	/**
	 * Returns the value of the '<em><b>Stereotype</b></em>' attribute.
	 * The literals are from the enumeration {@link net.menthor.metamodel.ontouml.Universal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotype</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Universal
	 * @see #setStereotype(Universal)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_Stereotype()
	 * @model unique="false"
	 * @generated
	 */
	Universal getStereotype();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Class#getStereotype <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotype</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Universal
	 * @see #getStereotype()
	 * @generated
	 */
	void setStereotype(Universal value);

	/**
	 * Returns the value of the '<em><b>Quality Type</b></em>' attribute.
	 * The literals are from the enumeration {@link net.menthor.metamodel.ontouml.Quality}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Quality Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Quality Type</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Quality
	 * @see #setQualityType(Quality)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_QualityType()
	 * @model unique="false"
	 * @generated
	 */
	Quality getQualityType();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Class#getQualityType <em>Quality Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quality Type</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Quality
	 * @see #getQualityType()
	 * @generated
	 */
	void setQualityType(Quality value);

	/**
	 * Returns the value of the '<em><b>Enumeration Literals</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumeration Literals</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumeration Literals</em>' attribute list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_EnumerationLiterals()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getEnumerationLiterals();

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
	 * @model unique="false" derived="true"
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
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.Attribute}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Attribute#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 *  TODO
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_Attributes()
	 * @see net.menthor.metamodel.ontouml.Attribute#getOwner
	 * @model opposite="owner" containment="true" ordered="false"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Istruth Maker Of</b></em>' reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.Relationship}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Relationship#getTruthMaker <em>Truth Maker</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Istruth Maker Of</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Istruth Maker Of</em>' reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_IstruthMakerOf()
	 * @see net.menthor.metamodel.ontouml.Relationship#getTruthMaker
	 * @model opposite="truthMaker" ordered="false"
	 * @generated
	 */
	EList<Relationship> getIstruthMakerOf();

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
	 * Returns the value of the '<em><b>Is Specialized Via</b></em>' reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.GeneralizationSet}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.GeneralizationSet#getSpecializedClass <em>Specialized Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Specialized Via</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Specialized Via</em>' reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_IsSpecializedVia()
	 * @see net.menthor.metamodel.ontouml.GeneralizationSet#getSpecializedClass
	 * @model opposite="specializedClass" ordered="false"
	 * @generated
	 */
	EList<GeneralizationSet> getIsSpecializedVia();

	/**
	 * Returns the value of the '<em><b>Specializes Via</b></em>' reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.GeneralizationSet}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.GeneralizationSet#getSpecializingClasses <em>Specializing Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specializes Via</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specializes Via</em>' reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_SpecializesVia()
	 * @see net.menthor.metamodel.ontouml.GeneralizationSet#getSpecializingClasses
	 * @model opposite="specializingClasses" ordered="false"
	 * @generated
	 */
	EList<GeneralizationSet> getSpecializesVia();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Universal%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Universal%>.KIND);'"
	 * @generated
	 */
	boolean isKind();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Universal%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Universal%>.SUB_KIND);'"
	 * @generated
	 */
	boolean isSubKind();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Universal%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Universal%>.COLLECTIVE);'"
	 * @generated
	 */
	boolean isCollective();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Universal%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Universal%>.QUANTITY);'"
	 * @generated
	 */
	boolean isQuantity();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Universal%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Universal%>.RELATOR);'"
	 * @generated
	 */
	boolean isRelator();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Universal%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Universal%>.MODE);'"
	 * @generated
	 */
	boolean isMode();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Universal%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Universal%>.QUALITY);'"
	 * @generated
	 */
	boolean isQuality();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Universal%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Universal%>.ROLE);'"
	 * @generated
	 */
	boolean isRole();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Universal%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Universal%>.ROLE_MIXIN);'"
	 * @generated
	 */
	boolean isRoleMixin();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Universal%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Universal%>.PHASE_MIXIN);'"
	 * @generated
	 */
	boolean isPhaseMixin();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Universal%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Universal%>.PHASE);'"
	 * @generated
	 */
	boolean isPhase();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Universal%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Universal%>.CATEGORY);'"
	 * @generated
	 */
	boolean isCategory();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Universal%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Universal%>.MIXIN);'"
	 * @generated
	 */
	boolean isMixin();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Universal%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Universal%>.EVENT);'"
	 * @generated
	 */
	boolean isEvent();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Universal%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Universal%>.HOU);'"
	 * @generated
	 */
	boolean isHighOrder();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Universal%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Universal%>.DATA_TYPE);'"
	 * @generated
	 */
	boolean isDataType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Universal%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Universal%>.ENUMERATION);'"
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
	 * <!-- begin-model-doc -->
	 *  Direct children
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Class%>[] list = null;\n<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.GeneralizationSet%>> _isSpecializedVia = this.getIsSpecializedVia();\nfor (final <%net.menthor.metamodel.ontouml.GeneralizationSet%> gs : _isSpecializedVia)\n{\n\tfinal <%net.menthor.metamodel.ontouml.Class%>[] _converted_list = (<%net.menthor.metamodel.ontouml.Class%>[])list;\n\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Class%>> _specializingClasses = gs.getSpecializingClasses();\n\t((<%java.util.List%><<%net.menthor.metamodel.ontouml.Class%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list)).addAll(_specializingClasses);\n}\nfinal <%net.menthor.metamodel.ontouml.Class%>[] _converted_list_1 = (<%net.menthor.metamodel.ontouml.Class%>[])list;\nreturn <%org.eclipse.emf.common.util.ECollections%>.<<%net.menthor.metamodel.ontouml.Class%>>toEList(((<%java.lang.Iterable%><? extends <%net.menthor.metamodel.ontouml.Class%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list_1)));'"
	 * @generated
	 */
	EList<Class> children();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * * Direct parents
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Class%>[] list = null;\n<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.GeneralizationSet%>> _specializesVia = this.getSpecializesVia();\nfor (final <%net.menthor.metamodel.ontouml.GeneralizationSet%> gs : _specializesVia)\n{\n\tfinal <%net.menthor.metamodel.ontouml.Class%>[] _converted_list = (<%net.menthor.metamodel.ontouml.Class%>[])list;\n\t<%net.menthor.metamodel.ontouml.Class%> _specializedClass = gs.getSpecializedClass();\n\t((<%java.util.List%><<%net.menthor.metamodel.ontouml.Class%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list)).add(_specializedClass);\n}\nfinal <%net.menthor.metamodel.ontouml.Class%>[] _converted_list_1 = (<%net.menthor.metamodel.ontouml.Class%>[])list;\nreturn <%org.eclipse.emf.common.util.ECollections%>.<<%net.menthor.metamodel.ontouml.Class%>>toEList(((<%java.lang.Iterable%><? extends <%net.menthor.metamodel.ontouml.Class%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list_1)));'"
	 * @generated
	 */
	EList<Class> parents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body=''"
	 * @generated
	 */
	void identidyProvider();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body=''"
	 * @generated
	 */
	void isFunctionalComplex();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body=''"
	 * @generated
	 */
	void isCollection();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body=''"
	 * @generated
	 */
	void isAmountOfMatter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body=''"
	 * @generated
	 */
	void isIntrinsic();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\nboolean _isRelator = this.isRelator();\nif (!_isRelator)\n{\n\t_and = false;\n} else\n{\n\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Relationship%>> _istruthMakerOf = this.getIstruthMakerOf();\n\tint _size = _istruthMakerOf.size();\n\tboolean _greaterThan = (_size > 0);\n\t_and = _greaterThan;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isTruthMaker();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body=''"
	 * @generated
	 */
	void setIsExtensional();

} // Class
