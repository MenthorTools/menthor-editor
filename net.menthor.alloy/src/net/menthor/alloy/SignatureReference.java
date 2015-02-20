/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.menthor.alloy;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Signature Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.alloy.SignatureReference#getSignature <em>Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.alloy.AlloyPackage#getSignatureReference()
 * @model
 * @generated
 */
public interface SignatureReference extends Expression {
	/**
	 * Returns the value of the '<em><b>Signature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signature</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signature</em>' attribute.
	 * @see #setSignature(String)
	 * @see net.menthor.alloy.AlloyPackage#getSignatureReference_Signature()
	 * @model required="true"
	 * @generated
	 */
	String getSignature();

	/**
	 * Sets the value of the '{@link net.menthor.alloy.SignatureReference#getSignature <em>Signature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signature</em>' attribute.
	 * @see #getSignature()
	 * @generated
	 */
	void setSignature(String value);

} // SignatureReference
