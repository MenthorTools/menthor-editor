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
 *   <li>{@link net.menthor.metamodel.ontouml.Class#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#isIsDerived <em>Is Derived</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#isIsExtensional <em>Is Extensional</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getEnumerationLiterals <em>Enumeration Literals</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getInstanceOf <em>Instance Of</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getIstruthMakerOf <em>Istruth Maker Of</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getIsSpecializedVia <em>Is Specialized Via</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getSpecializesVia <em>Specializes Via</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends NamedElement, ContainingElement {
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
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.ClassBinaryRelationship}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getTruthMaker <em>Truth Maker</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Istruth Maker Of</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Istruth Maker Of</em>' reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_IstruthMakerOf()
	 * @see net.menthor.metamodel.ontouml.ClassBinaryRelationship#getTruthMaker
	 * @model opposite="truthMaker" ordered="false"
	 * @generated
	 */
	EList<ClassBinaryRelationship> getIstruthMakerOf();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.Attribute}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Attribute#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_Attributes()
	 * @see net.menthor.metamodel.ontouml.Attribute#getOwner
	 * @model opposite="owner" ordered="false"
	 * @generated
	 */
	EList<Attribute> getAttributes();

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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _or = false;\nboolean _or_1 = false;\nboolean _or_2 = false;\nboolean _or_3 = false;\nboolean _or_4 = false;\nboolean _or_5 = false;\nboolean _or_6 = false;\nboolean _or_7 = false;\nboolean _or_8 = false;\n<%net.menthor.metamodel.ontouml.Universal%> _stereotype = this.getStereotype();\nboolean _equals = <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Universal%>.KIND);\nif (_equals)\n{\n\t_or_8 = true;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Universal%> _stereotype_1 = this.getStereotype();\n\tboolean _equals_1 = <%com.google.common.base.Objects%>.equal(_stereotype_1, <%net.menthor.metamodel.ontouml.Universal%>.COLLECTIVE);\n\t_or_8 = _equals_1;\n}\nif (_or_8)\n{\n\t_or_7 = true;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Universal%> _stereotype_2 = this.getStereotype();\n\tboolean _equals_2 = <%com.google.common.base.Objects%>.equal(_stereotype_2, <%net.menthor.metamodel.ontouml.Universal%>.QUANTITY);\n\t_or_7 = _equals_2;\n}\nif (_or_7)\n{\n\t_or_6 = true;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Universal%> _stereotype_3 = this.getStereotype();\n\tboolean _equals_3 = <%com.google.common.base.Objects%>.equal(_stereotype_3, <%net.menthor.metamodel.ontouml.Universal%>.RELATOR);\n\t_or_6 = _equals_3;\n}\nif (_or_6)\n{\n\t_or_5 = true;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Universal%> _stereotype_4 = this.getStereotype();\n\tboolean _equals_4 = <%com.google.common.base.Objects%>.equal(_stereotype_4, <%net.menthor.metamodel.ontouml.Universal%>.MODE);\n\t_or_5 = _equals_4;\n}\nif (_or_5)\n{\n\t_or_4 = true;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Universal%> _stereotype_5 = this.getStereotype();\n\tboolean _equals_5 = <%com.google.common.base.Objects%>.equal(_stereotype_5, <%net.menthor.metamodel.ontouml.Universal%>.NOMINAL_QUALITY);\n\t_or_4 = _equals_5;\n}\nif (_or_4)\n{\n\t_or_3 = true;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Universal%> _stereotype_6 = this.getStereotype();\n\tboolean _equals_6 = <%com.google.common.base.Objects%>.equal(_stereotype_6, <%net.menthor.metamodel.ontouml.Universal%>.PERCEIVABLE_QUALITY);\n\t_or_3 = _equals_6;\n}\nif (_or_3)\n{\n\t_or_2 = true;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Universal%> _stereotype_7 = this.getStereotype();\n\tboolean _equals_7 = <%com.google.common.base.Objects%>.equal(_stereotype_7, <%net.menthor.metamodel.ontouml.Universal%>.NON_PERCEIVABLE_QUALITY);\n\t_or_2 = _equals_7;\n}\nif (_or_2)\n{\n\t_or_1 = true;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Universal%> _stereotype_8 = this.getStereotype();\n\tboolean _equals_8 = <%com.google.common.base.Objects%>.equal(_stereotype_8, <%net.menthor.metamodel.ontouml.Universal%>.SUB_KIND);\n\t_or_1 = _equals_8;\n}\nif (_or_1)\n{\n\t_or = true;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Universal%> _stereotype_9 = this.getStereotype();\n\tboolean _equals_9 = <%com.google.common.base.Objects%>.equal(_stereotype_9, <%net.menthor.metamodel.ontouml.Universal%>.CATEGORY);\n\t_or = _equals_9;\n}\nreturn _or;'"
	 * @generated
	 */
	boolean isRigid();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _or = false;\nboolean _or_1 = false;\nboolean _or_2 = false;\n<%net.menthor.metamodel.ontouml.Universal%> _stereotype = this.getStereotype();\nboolean _equals = <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Universal%>.ROLE);\nif (_equals)\n{\n\t_or_2 = true;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Universal%> _stereotype_1 = this.getStereotype();\n\tboolean _equals_1 = <%com.google.common.base.Objects%>.equal(_stereotype_1, <%net.menthor.metamodel.ontouml.Universal%>.PHASE);\n\t_or_2 = _equals_1;\n}\nif (_or_2)\n{\n\t_or_1 = true;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Universal%> _stereotype_2 = this.getStereotype();\n\tboolean _equals_2 = <%com.google.common.base.Objects%>.equal(_stereotype_2, <%net.menthor.metamodel.ontouml.Universal%>.ROLE_MIXIN);\n\t_or_1 = _equals_2;\n}\nif (_or_1)\n{\n\t_or = true;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Universal%> _stereotype_3 = this.getStereotype();\n\tboolean _equals_3 = <%com.google.common.base.Objects%>.equal(_stereotype_3, <%net.menthor.metamodel.ontouml.Universal%>.MIXIN);\n\t_or = _equals_3;\n}\nreturn _or;'"
	 * @generated
	 */
	boolean isNonRigid();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _or = false;\nboolean _or_1 = false;\n<%net.menthor.metamodel.ontouml.Universal%> _stereotype = this.getStereotype();\nboolean _equals = <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Universal%>.ROLE);\nif (_equals)\n{\n\t_or_1 = true;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Universal%> _stereotype_1 = this.getStereotype();\n\tboolean _equals_1 = <%com.google.common.base.Objects%>.equal(_stereotype_1, <%net.menthor.metamodel.ontouml.Universal%>.PHASE);\n\t_or_1 = _equals_1;\n}\nif (_or_1)\n{\n\t_or = true;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Universal%> _stereotype_2 = this.getStereotype();\n\tboolean _equals_2 = <%com.google.common.base.Objects%>.equal(_stereotype_2, <%net.menthor.metamodel.ontouml.Universal%>.ROLE_MIXIN);\n\t_or = _equals_2;\n}\nreturn _or;'"
	 * @generated
	 */
	boolean isAntiRigid();

} // Class
