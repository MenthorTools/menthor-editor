/**
 */
package net.menthor.metamodel.ontouml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.Container#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getContainer()
 * @model abstract="true"
 * @generated
 */
public interface Container extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.PackageableElement}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.PackageableElement#getContainer_ <em>Container </em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getContainer_Elements()
	 * @see net.menthor.metamodel.ontouml.PackageableElement#getContainer_
	 * @model opposite="container_" containment="true" ordered="false"
	 * @generated
	 */
	EList<PackageableElement> getElements();

} // Container
