/**
 */
package net.menthor.metamodel.ontouml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Measurement Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * * =========================================
 *  quality region
 *  ========================================
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.MeasurementRegion#getRegion <em>Region</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getMeasurementRegion()
 * @model
 * @generated
 */
public interface MeasurementRegion extends NamedElement, ContainedElement {
	/**
	 * Returns the value of the '<em><b>Region</b></em>' attribute.
	 * The literals are from the enumeration {@link net.menthor.metamodel.ontouml.Region}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Region</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Region</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Region
	 * @see #setRegion(Region)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getMeasurementRegion_Region()
	 * @model unique="false" required="true"
	 * @generated
	 */
	Region getRegion();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.MeasurementRegion#getRegion <em>Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Region</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Region
	 * @see #getRegion()
	 * @generated
	 */
	void setRegion(Region value);

} // MeasurementRegion
