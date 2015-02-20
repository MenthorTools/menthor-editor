/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.menthor.alloy;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Detailed Scope</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.alloy.DetailedScope#getScopeable <em>Scopeable</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.alloy.AlloyPackage#getDetailedScope()
 * @model
 * @generated
 */
public interface DetailedScope extends ScopeSpecification {
	/**
	 * Returns the value of the '<em><b>Scopeable</b></em>' containment reference list.
	 * The list contents are of type {@link net.menthor.alloy.Scopeable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scopeable</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scopeable</em>' containment reference list.
	 * @see net.menthor.alloy.AlloyPackage#getDetailedScope_Scopeable()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Scopeable> getScopeable();

} // DetailedScope
