/**
 */
package stories;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node state</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link stories.Classification_statement#getHolds_in <em>Holds in</em>}</li>
 *   <li>{@link stories.Classification_statement#getNot_holds_in <em>Not holds in</em>}</li>
 *   <li>{@link stories.Classification_statement#getAntiRigidClasses <em>Anti Rigid Classes</em>}</li>
 *   <li>{@link stories.Classification_statement#getLabel <em>Label</em>}</li>
 * </ul>
 * </p>
 *
 * @see stories.StoriesPackage#getClassification_statement()
 * @model
 * @generated
 */
public interface Classification_statement extends EObject {
	/**
	 * Returns the value of the '<em><b>Holds in</b></em>' reference list.
	 * The list contents are of type {@link stories.World}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Holds in</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Holds in</em>' reference list.
	 * @see stories.StoriesPackage#getClassification_statement_Holds_in()
	 * @model
	 * @generated
	 */
	EList<World> getHolds_in();

	/**
	 * Returns the value of the '<em><b>Not holds in</b></em>' reference list.
	 * The list contents are of type {@link stories.World}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Not holds in</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Not holds in</em>' reference list.
	 * @see stories.StoriesPackage#getClassification_statement_Not_holds_in()
	 * @model
	 * @generated
	 */
	EList<World> getNot_holds_in();

	/**
	 * Returns the value of the '<em><b>Anti Rigid Classes</b></em>' reference list.
	 * The list contents are of type {@link RefOntoUML.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Anti Rigid Classes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Anti Rigid Classes</em>' reference list.
	 * @see stories.StoriesPackage#getClassification_statement_AntiRigidClasses()
	 * @model required="true"
	 * @generated
	 */
	EList<RefOntoUML.Class> getAntiRigidClasses();

	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see stories.StoriesPackage#getClassification_statement_Label()
	 * @model
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link stories.Classification_statement#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	String existance(Node target);

} // Classification_statement
