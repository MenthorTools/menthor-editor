/**
 */
package net.menthor.metamodel.ontouml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Measurement Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * * =========================================
 *  quality domain
 *  ========================================
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.MeasurementDomain#getDimensions <em>Dimensions</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getMeasurementDomain()
 * @model
 * @generated
 */
public interface MeasurementDomain extends NamedElement, ContainedElement {
	/**
	 * Returns the value of the '<em><b>Dimensions</b></em>' reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.MeasurementDimension}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.MeasurementDimension#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimensions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimensions</em>' reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getMeasurementDomain_Dimensions()
	 * @see net.menthor.metamodel.ontouml.MeasurementDimension#getOwner
	 * @model opposite="owner" lower="2"
	 * @generated
	 */
	EList<MeasurementDimension> getDimensions();

} // MeasurementDomain
