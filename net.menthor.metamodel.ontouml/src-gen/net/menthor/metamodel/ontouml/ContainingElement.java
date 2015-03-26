/**
 */
package net.menthor.metamodel.ontouml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Containing Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.ContainingElement#getHolder <em>Holder</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getContainingElement()
 * @model abstract="true"
 * @generated
 */
public interface ContainingElement extends Element {
	/**
	 * Returns the value of the '<em><b>Holder</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Container#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Holder</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Holder</em>' container reference.
	 * @see #setHolder(Container)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getContainingElement_Holder()
	 * @see net.menthor.metamodel.ontouml.Container#getElements
	 * @model opposite="elements" required="true" transient="false"
	 * @generated
	 */
	Container getHolder();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.ContainingElement#getHolder <em>Holder</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Holder</em>' container reference.
	 * @see #getHolder()
	 * @generated
	 */
	void setHolder(Container value);

} // ContainingElement
