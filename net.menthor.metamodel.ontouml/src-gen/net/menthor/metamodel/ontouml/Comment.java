/**
 */
package net.menthor.metamodel.ontouml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Comment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * * =========================================
 *  Comment: is a text which has an owner
 *  ========================================
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.Comment#getContent <em>Content</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Comment#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getComment()
 * @model
 * @generated
 */
public interface Comment extends Element {
	/**
	 * Returns the value of the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' attribute.
	 * @see #setContent(String)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getComment_Content()
	 * @model unique="false"
	 * @generated
	 */
	String getContent();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Comment#getContent <em>Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' attribute.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(String value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.ContainedElement#getComments <em>Comments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(ContainedElement)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getComment_Owner()
	 * @see net.menthor.metamodel.ontouml.ContainedElement#getComments
	 * @model opposite="comments" required="true" transient="false"
	 * @generated
	 */
	ContainedElement getOwner();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Comment#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(ContainedElement value);

} // Comment
