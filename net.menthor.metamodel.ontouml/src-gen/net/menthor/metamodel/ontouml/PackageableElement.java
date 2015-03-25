/**
 */
package net.menthor.metamodel.ontouml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Packageable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.PackageableElement#getContainer_ <em>Container </em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getPackageableElement()
 * @model abstract="true"
 * @generated
 */
public interface PackageableElement extends Element {
	/**
	 * Returns the value of the '<em><b>Container </b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Container#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container </em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Container </em>' container reference.
	 * @see #setContainer_(Container)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getPackageableElement_Container_()
	 * @see net.menthor.metamodel.ontouml.Container#getElements
	 * @model opposite="elements" required="true" transient="false"
	 * @generated
	 */
	Container getContainer_();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.PackageableElement#getContainer_ <em>Container </em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Container </em>' container reference.
	 * @see #getContainer_()
	 * @generated
	 */
	void setContainer_(Container value);

} // PackageableElement
