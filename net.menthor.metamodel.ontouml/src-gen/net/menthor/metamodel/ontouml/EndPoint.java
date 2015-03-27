/**
 */
package net.menthor.metamodel.ontouml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>End Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.EndPoint#getOwner <em>Owner</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.EndPoint#getEndType <em>End Type</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.EndPoint#getSubsets <em>Subsets</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.EndPoint#getRedefines <em>Redefines</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.EndPoint#getIsSubsettedBy <em>Is Subsetted By</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.EndPoint#getIsRedefinedBy <em>Is Redefined By</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getEndPoint()
 * @model
 * @generated
 */
public interface EndPoint extends Property {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getEndPoints <em>End Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see #setOwner(ClassBinaryRelationship)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getEndPoint_Owner()
	 * @see net.menthor.metamodel.ontouml.ClassBinaryRelationship#getEndPoints
	 * @model opposite="endPoints" required="true"
	 * @generated
	 */
	ClassBinaryRelationship getOwner();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.EndPoint#getOwner <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(ClassBinaryRelationship value);

	/**
	 * Returns the value of the '<em><b>End Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Type</em>' reference.
	 * @see #setEndType(net.menthor.metamodel.ontouml.Class)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getEndPoint_EndType()
	 * @model required="true"
	 * @generated
	 */
	net.menthor.metamodel.ontouml.Class getEndType();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.EndPoint#getEndType <em>End Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Type</em>' reference.
	 * @see #getEndType()
	 * @generated
	 */
	void setEndType(net.menthor.metamodel.ontouml.Class value);

	/**
	 * Returns the value of the '<em><b>Subsets</b></em>' reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.EndPoint}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.EndPoint#getIsSubsettedBy <em>Is Subsetted By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subsets</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subsets</em>' reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getEndPoint_Subsets()
	 * @see net.menthor.metamodel.ontouml.EndPoint#getIsSubsettedBy
	 * @model opposite="isSubsettedBy" ordered="false"
	 * @generated
	 */
	EList<EndPoint> getSubsets();

	/**
	 * Returns the value of the '<em><b>Redefines</b></em>' reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.EndPoint}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.EndPoint#getIsRedefinedBy <em>Is Redefined By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Redefines</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Redefines</em>' reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getEndPoint_Redefines()
	 * @see net.menthor.metamodel.ontouml.EndPoint#getIsRedefinedBy
	 * @model opposite="isRedefinedBy" ordered="false"
	 * @generated
	 */
	EList<EndPoint> getRedefines();

	/**
	 * Returns the value of the '<em><b>Is Subsetted By</b></em>' reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.EndPoint}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.EndPoint#getSubsets <em>Subsets</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Subsetted By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Subsetted By</em>' reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getEndPoint_IsSubsettedBy()
	 * @see net.menthor.metamodel.ontouml.EndPoint#getSubsets
	 * @model opposite="subsets" ordered="false"
	 * @generated
	 */
	EList<EndPoint> getIsSubsettedBy();

	/**
	 * Returns the value of the '<em><b>Is Redefined By</b></em>' reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.EndPoint}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.EndPoint#getRedefines <em>Redefines</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Redefined By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Redefined By</em>' reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getEndPoint_IsRedefinedBy()
	 * @see net.menthor.metamodel.ontouml.EndPoint#getRedefines
	 * @model opposite="redefines" ordered="false"
	 * @generated
	 */
	EList<EndPoint> getIsRedefinedBy();

} // EndPoint
