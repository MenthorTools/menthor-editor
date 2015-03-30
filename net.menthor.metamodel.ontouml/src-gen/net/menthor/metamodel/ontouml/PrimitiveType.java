/**
 */
package net.menthor.metamodel.ontouml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * * =========================================
 *  primitive class
 *  ========================================
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.PrimitiveType#getPrimitive <em>Primitive</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getPrimitiveType()
 * @model
 * @generated
 */
public interface PrimitiveType extends ContainedElement {
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
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getPrimitiveType_Primitive()
	 * @model unique="false" required="true"
	 * @generated
	 */
	Primitive getPrimitive();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.PrimitiveType#getPrimitive <em>Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Primitive
	 * @see #getPrimitive()
	 * @generated
	 */
	void setPrimitive(Primitive value);

} // PrimitiveType
