/**
 */
package net.menthor.metamodel.ontouml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Material Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.MaterialRelationship#getIsDerivedFrom <em>Is Derived From</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getMaterialRelationship()
 * @model
 * @generated
 */
public interface MaterialRelationship extends ClassBinaryRelationship {
	/**
	 * Returns the value of the '<em><b>Is Derived From</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Class#getIsTruthMakerOf <em>Is Truth Maker Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Derived From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Derived From</em>' reference.
	 * @see #setIsDerivedFrom(net.menthor.metamodel.ontouml.Class)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getMaterialRelationship_IsDerivedFrom()
	 * @see net.menthor.metamodel.ontouml.Class#getIsTruthMakerOf
	 * @model opposite="isTruthMakerOf"
	 * @generated
	 */
	net.menthor.metamodel.ontouml.Class getIsDerivedFrom();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.MaterialRelationship#getIsDerivedFrom <em>Is Derived From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Derived From</em>' reference.
	 * @see #getIsDerivedFrom()
	 * @generated
	 */
	void setIsDerivedFrom(net.menthor.metamodel.ontouml.Class value);

} // MaterialRelationship
