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
 *  - enumeration literals
 *  ========================================
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.Literal#getOwner <em>Owner</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Literal#getGroundingRegion <em>Grounding Region</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Literal#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getLiteral()
 * @model
 * @generated
 */
public interface Literal extends Property {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Class#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(net.menthor.metamodel.ontouml.Class)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getLiteral_Owner()
	 * @see net.menthor.metamodel.ontouml.Class#getLiterals
	 * @model opposite="literals" required="true" transient="false"
	 * @generated
	 */
	net.menthor.metamodel.ontouml.Class getOwner();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Literal#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(net.menthor.metamodel.ontouml.Class value);

	/**
	 * Returns the value of the '<em><b>Grounding Region</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Region#getGroundedLiteral <em>Grounded Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grounding Region</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grounding Region</em>' reference.
	 * @see #setGroundingRegion(Region)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getLiteral_GroundingRegion()
	 * @see net.menthor.metamodel.ontouml.Region#getGroundedLiteral
	 * @model opposite="groundedLiteral"
	 * @generated
	 */
	Region getGroundingRegion();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Literal#getGroundingRegion <em>Grounding Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grounding Region</em>' reference.
	 * @see #getGroundingRegion()
	 * @generated
	 */
	void setGroundingRegion(Region value);

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

} // Literal
