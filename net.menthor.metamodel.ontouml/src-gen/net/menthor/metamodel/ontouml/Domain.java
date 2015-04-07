/**
 */
package net.menthor.metamodel.ontouml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * * =========================================
 * - structure domain
 * 
 *  A Domain should always be associated to an instance of measurable quality universal by a structuration relation.
 *  A Domain must have two or more owned dimensions.
 *  All owned dimensions must be instances of measurement dimensions (not nominal dimensions).
 *  ========================================
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.Domain#getDimensions <em>Dimensions</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getDomain()
 * @model
 * @generated
 */
public interface Domain extends Structure {
	/**
	 * Returns the value of the '<em><b>Dimensions</b></em>' reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.Dimension}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Dimension#getOwnerDomain <em>Owner Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimensions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimensions</em>' reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getDomain_Dimensions()
	 * @see net.menthor.metamodel.ontouml.Dimension#getOwnerDomain
	 * @model opposite="ownerDomain"
	 * @generated
	 */
	EList<Dimension> getDimensions();

} // Domain
