/**
 */
package net.menthor.metamodel.ontouml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * * =========================================
 *  Enumeration Literal
 *  ========================================
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.Literal#getValue <em>Value</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Literal#getOwner <em>Owner</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Literal#getUpperBoundRegion <em>Upper Bound Region</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Literal#getLowerBoundRegion <em>Lower Bound Region</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getLiteral()
 * @model
 * @generated
 */
public interface Literal extends Element {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getLiteral_Value()
	 * @model unique="false"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Literal#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.DataType#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(DataType)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getLiteral_Owner()
	 * @see net.menthor.metamodel.ontouml.DataType#getLiterals
	 * @model opposite="literals" required="true" transient="false"
	 * @generated
	 */
	DataType getOwner();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Literal#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(DataType value);

	/**
	 * Returns the value of the '<em><b>Upper Bound Region</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Bound Region</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Bound Region</em>' attribute.
	 * @see #setUpperBoundRegion(float)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getLiteral_UpperBoundRegion()
	 * @model unique="false"
	 * @generated
	 */
	float getUpperBoundRegion();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Literal#getUpperBoundRegion <em>Upper Bound Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound Region</em>' attribute.
	 * @see #getUpperBoundRegion()
	 * @generated
	 */
	void setUpperBoundRegion(float value);

	/**
	 * Returns the value of the '<em><b>Lower Bound Region</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Bound Region</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Bound Region</em>' attribute.
	 * @see #setLowerBoundRegion(float)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getLiteral_LowerBoundRegion()
	 * @model unique="false"
	 * @generated
	 */
	float getLowerBoundRegion();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Literal#getLowerBoundRegion <em>Lower Bound Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound Region</em>' attribute.
	 * @see #getLowerBoundRegion()
	 * @generated
	 */
	void setLowerBoundRegion(float value);

} // Literal
