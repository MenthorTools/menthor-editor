/**
 */
package net.menthor.metamodel.ontouml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Measurement Dimension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * * =========================================
 *  quality dimension
 *  ========================================
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.MeasurementDimension#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.MeasurementDimension#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.MeasurementDimension#getUnitOfMeasure <em>Unit Of Measure</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.MeasurementDimension#getDimension <em>Dimension</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.MeasurementDimension#getMeasurement <em>Measurement</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.MeasurementDimension#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getMeasurementDimension()
 * @model
 * @generated
 */
public interface MeasurementDimension extends NamedElement, ContainedElement {
	/**
	 * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Bound</em>' attribute.
	 * @see #setLowerBound(int)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getMeasurementDimension_LowerBound()
	 * @model unique="false" required="true"
	 * @generated
	 */
	int getLowerBound();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.MeasurementDimension#getLowerBound <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound</em>' attribute.
	 * @see #getLowerBound()
	 * @generated
	 */
	void setLowerBound(int value);

	/**
	 * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Bound</em>' attribute.
	 * @see #setUpperBound(int)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getMeasurementDimension_UpperBound()
	 * @model unique="false" required="true"
	 * @generated
	 */
	int getUpperBound();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.MeasurementDimension#getUpperBound <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound</em>' attribute.
	 * @see #getUpperBound()
	 * @generated
	 */
	void setUpperBound(int value);

	/**
	 * Returns the value of the '<em><b>Unit Of Measure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Of Measure</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Of Measure</em>' attribute.
	 * @see #setUnitOfMeasure(String)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getMeasurementDimension_UnitOfMeasure()
	 * @model unique="false"
	 * @generated
	 */
	String getUnitOfMeasure();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.MeasurementDimension#getUnitOfMeasure <em>Unit Of Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Of Measure</em>' attribute.
	 * @see #getUnitOfMeasure()
	 * @generated
	 */
	void setUnitOfMeasure(String value);

	/**
	 * Returns the value of the '<em><b>Dimension</b></em>' attribute.
	 * The literals are from the enumeration {@link net.menthor.metamodel.ontouml.DimensionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimension</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimension</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.DimensionType
	 * @see #setDimension(DimensionType)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getMeasurementDimension_Dimension()
	 * @model unique="false" required="true"
	 * @generated
	 */
	DimensionType getDimension();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.MeasurementDimension#getDimension <em>Dimension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dimension</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.DimensionType
	 * @see #getDimension()
	 * @generated
	 */
	void setDimension(DimensionType value);

	/**
	 * Returns the value of the '<em><b>Measurement</b></em>' attribute.
	 * The literals are from the enumeration {@link net.menthor.metamodel.ontouml.MeasurementType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measurement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measurement</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.MeasurementType
	 * @see #setMeasurement(MeasurementType)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getMeasurementDimension_Measurement()
	 * @model unique="false" required="true"
	 * @generated
	 */
	MeasurementType getMeasurement();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.MeasurementDimension#getMeasurement <em>Measurement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measurement</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.MeasurementType
	 * @see #getMeasurement()
	 * @generated
	 */
	void setMeasurement(MeasurementType value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.MeasurementDomain#getDimensions <em>Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see #setOwner(MeasurementDomain)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getMeasurementDimension_Owner()
	 * @see net.menthor.metamodel.ontouml.MeasurementDomain#getDimensions
	 * @model opposite="dimensions"
	 * @generated
	 */
	MeasurementDomain getOwner();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.MeasurementDimension#getOwner <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(MeasurementDomain value);

} // MeasurementDimension
