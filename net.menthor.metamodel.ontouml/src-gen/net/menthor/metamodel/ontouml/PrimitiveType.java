/**
 */
package net.menthor.metamodel.ontouml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.PrimitiveType#getStereotype <em>Stereotype</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getPrimitiveType()
 * @model
 * @generated
 */
public interface PrimitiveType extends ContainedElement {
	/**
	 * Returns the value of the '<em><b>Stereotype</b></em>' attribute.
	 * The literals are from the enumeration {@link net.menthor.metamodel.ontouml.Primitive}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotype</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Primitive
	 * @see #setStereotype(Primitive)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getPrimitiveType_Stereotype()
	 * @model unique="false" required="true"
	 * @generated
	 */
	Primitive getStereotype();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.PrimitiveType#getStereotype <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotype</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Primitive
	 * @see #getStereotype()
	 * @generated
	 */
	void setStereotype(Primitive value);

} // PrimitiveType
