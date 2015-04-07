/**
 */
package net.menthor.metamodel.ontouml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * * =========================================
 *  - attribute
 * 
 *  An attribute is a property that has an owner class and a primitive type.
 * 
 *  A primitive type is a contained element which does not have a name.
 *  A primitive type have a primitive stereotype such as Integer, String, Real, Boolean, UnlimitedNatural and Date
 *  ========================================
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.Attribute#getOwner <em>Owner</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Attribute#getPrimitive <em>Primitive</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends Property {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Class#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(net.menthor.metamodel.ontouml.Class)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getAttribute_Owner()
	 * @see net.menthor.metamodel.ontouml.Class#getAttributes
	 * @model opposite="attributes" required="true" transient="false"
	 * @generated
	 */
	net.menthor.metamodel.ontouml.Class getOwner();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Attribute#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(net.menthor.metamodel.ontouml.Class value);

	/**
	 * Returns the value of the '<em><b>Primitive</b></em>' attribute.
	 * The literals are from the enumeration {@link net.menthor.metamodel.ontouml.Primitive}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primitive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Primitive
	 * @see #setPrimitive(Primitive)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getAttribute_Primitive()
	 * @model unique="false" required="true"
	 * @generated
	 */
	Primitive getPrimitive();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Attribute#getPrimitive <em>Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Primitive
	 * @see #getPrimitive()
	 * @generated
	 */
	void setPrimitive(Primitive value);

} // Attribute
