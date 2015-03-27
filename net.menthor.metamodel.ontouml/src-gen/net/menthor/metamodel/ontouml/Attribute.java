/**
 */
package net.menthor.metamodel.ontouml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.Attribute#getOwner <em>Owner</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Attribute#getPrimitiveType <em>Primitive Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends Property {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Class#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see #setOwner(net.menthor.metamodel.ontouml.Class)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getAttribute_Owner()
	 * @see net.menthor.metamodel.ontouml.Class#getAttributes
	 * @model opposite="attributes" required="true"
	 * @generated
	 */
	net.menthor.metamodel.ontouml.Class getOwner();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Attribute#getOwner <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(net.menthor.metamodel.ontouml.Class value);

	/**
	 * Returns the value of the '<em><b>Primitive Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primitive Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive Type</em>' reference.
	 * @see #setPrimitiveType(PrimitiveType)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getAttribute_PrimitiveType()
	 * @model required="true"
	 * @generated
	 */
	PrimitiveType getPrimitiveType();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Attribute#getPrimitiveType <em>Primitive Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive Type</em>' reference.
	 * @see #getPrimitiveType()
	 * @generated
	 */
	void setPrimitiveType(PrimitiveType value);

} // Attribute
