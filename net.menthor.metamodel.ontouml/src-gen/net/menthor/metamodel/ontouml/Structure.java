/**
 */
package net.menthor.metamodel.ontouml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * * =========================================
 *  - structure (type)
 * 
 *  A Structure may have several Regions.
 *  A Structure if grounded, must be grounded in a Enumeration (Constraint C18).
 *  ========================================
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.Structure#getRegions <em>Regions</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Structure#getGroundedEnumeration <em>Grounded Enumeration</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getStructure()
 * @model
 * @generated
 */
public interface Structure extends Type {
	/**
	 * Returns the value of the '<em><b>Regions</b></em>' reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.Region}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Region#getOwnerStructure <em>Owner Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Regions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regions</em>' reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getStructure_Regions()
	 * @see net.menthor.metamodel.ontouml.Region#getOwnerStructure
	 * @model opposite="ownerStructure"
	 * @generated
	 */
	EList<Region> getRegions();

	/**
	 * Returns the value of the '<em><b>Grounded Enumeration</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Class#getGroundingStructure <em>Grounding Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grounded Enumeration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grounded Enumeration</em>' reference.
	 * @see #setGroundedEnumeration(net.menthor.metamodel.ontouml.Class)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getStructure_GroundedEnumeration()
	 * @see net.menthor.metamodel.ontouml.Class#getGroundingStructure
	 * @model opposite="groundingStructure"
	 * @generated
	 */
	net.menthor.metamodel.ontouml.Class getGroundedEnumeration();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Structure#getGroundedEnumeration <em>Grounded Enumeration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grounded Enumeration</em>' reference.
	 * @see #getGroundedEnumeration()
	 * @generated
	 */
	void setGroundedEnumeration(net.menthor.metamodel.ontouml.Class value);

} // Structure
