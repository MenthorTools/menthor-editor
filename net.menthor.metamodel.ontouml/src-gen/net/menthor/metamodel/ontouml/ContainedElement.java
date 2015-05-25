/**
 */
package net.menthor.metamodel.ontouml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contained Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * * =========================================
 *  Contained Element: is an Element that has a a container and possibly a set of comments.
 *  =========================================
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.ContainedElement#getHolder <em>Holder</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.ContainedElement#getComments <em>Comments</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getContainedElement()
 * @model abstract="true"
 * @generated
 */
public interface ContainedElement extends Element {
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
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getContainedElement_Holder()
	 * @see net.menthor.metamodel.ontouml.Container#getElements
	 * @model opposite="elements" required="true" transient="false"
	 * @generated
	 */
	Container getHolder();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.ContainedElement#getHolder <em>Holder</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Holder</em>' container reference.
	 * @see #getHolder()
	 * @generated
	 */
	void setHolder(Container value);

	/**
	 * Returns the value of the '<em><b>Comments</b></em>' containment reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.Comment}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Comment#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comments</em>' containment reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getContainedElement_Comments()
	 * @see net.menthor.metamodel.ontouml.Comment#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Comment> getComments();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * * Returns the root from a given container
	 * <!-- end-model-doc -->
	 * @model unique="false" cUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='if ((c instanceof <%net.menthor.metamodel.ontouml.Model%>))\n{\n\treturn ((<%net.menthor.metamodel.ontouml.Model%>)c);\n}\nelse\n{\n\tif ((c instanceof <%net.menthor.metamodel.ontouml.ContainedElement%>))\n\t{\n\t\t<%net.menthor.metamodel.ontouml.Container%> _holder = ((<%net.menthor.metamodel.ontouml.ContainedElement%>)c).getHolder();\n\t\treturn this.getModel(_holder);\n\t}\n}\nreturn null;'"
	 * @generated
	 */
	Model getModel(Container c);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * * Returns the root container
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Container%> _holder = this.getHolder();\nreturn this.getModel(_holder);'"
	 * @generated
	 */
	Model getModel();

} // ContainedElement
