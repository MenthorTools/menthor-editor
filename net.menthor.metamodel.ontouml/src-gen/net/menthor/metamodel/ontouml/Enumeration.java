/**
 */
package net.menthor.metamodel.ontouml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.Enumeration#getEnumerationLiterals <em>Enumeration Literals</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getEnumeration()
 * @model
 * @generated
 */
public interface Enumeration extends UserDefinedDataType {
	/**
	 * Returns the value of the '<em><b>Enumeration Literals</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumeration Literals</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumeration Literals</em>' attribute list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getEnumeration_EnumerationLiterals()
	 * @model unique="false" lower="2"
	 * @generated
	 */
	EList<String> getEnumerationLiterals();

} // Enumeration
