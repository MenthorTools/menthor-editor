/**
 */
package net.menthor.metamodel.ontouml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * * =========================================
 *  Attribute: has a primitive type and an owner (a class or a dataType)
 *  ========================================
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.Attribute#getDefinitions <em>Definitions</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Attribute#getSynonyms <em>Synonyms</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Attribute#getText <em>Text</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Attribute#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Attribute#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends Property {
	/**
	 * Returns the value of the '<em><b>Definitions</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definitions</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definitions</em>' attribute list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getAttribute_Definitions()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getDefinitions();

	/**
	 * Returns the value of the '<em><b>Synonyms</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Synonyms</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Synonyms</em>' attribute list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getAttribute_Synonyms()
	 * @model unique="false"
	 * @generated
	 */
	EList<String> getSynonyms();

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getAttribute_Text()
	 * @model unique="false"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Attribute#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Stereotype</b></em>' attribute.
	 * The literals are from the enumeration {@link net.menthor.metamodel.ontouml.PrimitiveStereotype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotype</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.PrimitiveStereotype
	 * @see #setStereotype(PrimitiveStereotype)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getAttribute_Stereotype()
	 * @model unique="false"
	 * @generated
	 */
	PrimitiveStereotype getStereotype();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Attribute#getStereotype <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotype</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.PrimitiveStereotype
	 * @see #getStereotype()
	 * @generated
	 */
	void setStereotype(PrimitiveStereotype value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Type#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Type)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getAttribute_Owner()
	 * @see net.menthor.metamodel.ontouml.Type#getAttributes
	 * @model opposite="attributes" required="true" transient="false"
	 * @generated
	 */
	Type getOwner();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Attribute#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Type value);

} // Attribute
