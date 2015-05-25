/**
 */
package net.menthor.metamodel.ontouml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generalization Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * * =========================================
 *  Generalization Set: is a specialization/generalization between two Classifiers.
 *                      A former UML generalization is now a Generalization Set with
 *                      only one specializing classifier.
 *  ========================================
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.GeneralizationSet#isIsCovering <em>Is Covering</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.GeneralizationSet#getSpecializedClassifier <em>Specialized Classifier</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.GeneralizationSet#getSpecializingClassifier <em>Specializing Classifier</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.GeneralizationSet#getHighOrder <em>High Order</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getGeneralizationSet()
 * @model
 * @generated
 */
public interface GeneralizationSet extends NamedElement, ContainedElement {
	/**
	 * Returns the value of the '<em><b>Is Covering</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Covering</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Covering</em>' attribute.
	 * @see #setIsCovering(boolean)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getGeneralizationSet_IsCovering()
	 * @model unique="false"
	 * @generated
	 */
	boolean isIsCovering();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.GeneralizationSet#isIsCovering <em>Is Covering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Covering</em>' attribute.
	 * @see #isIsCovering()
	 * @generated
	 */
	void setIsCovering(boolean value);

	/**
	 * Returns the value of the '<em><b>Specialized Classifier</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Classifier#getIsSpecializedVia <em>Is Specialized Via</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specialized Classifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specialized Classifier</em>' reference.
	 * @see #setSpecializedClassifier(Classifier)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getGeneralizationSet_SpecializedClassifier()
	 * @see net.menthor.metamodel.ontouml.Classifier#getIsSpecializedVia
	 * @model opposite="isSpecializedVia" required="true"
	 * @generated
	 */
	Classifier getSpecializedClassifier();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.GeneralizationSet#getSpecializedClassifier <em>Specialized Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specialized Classifier</em>' reference.
	 * @see #getSpecializedClassifier()
	 * @generated
	 */
	void setSpecializedClassifier(Classifier value);

	/**
	 * Returns the value of the '<em><b>Specializing Classifier</b></em>' reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.Classifier}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Classifier#getSpecializesVia <em>Specializes Via</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specializing Classifier</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specializing Classifier</em>' reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getGeneralizationSet_SpecializingClassifier()
	 * @see net.menthor.metamodel.ontouml.Classifier#getSpecializesVia
	 * @model opposite="specializesVia" required="true" ordered="false"
	 * @generated
	 */
	EList<Classifier> getSpecializingClassifier();

	/**
	 * Returns the value of the '<em><b>High Order</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>High Order</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>High Order</em>' reference.
	 * @see #setHighOrder(net.menthor.metamodel.ontouml.Class)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getGeneralizationSet_HighOrder()
	 * @model
	 * @generated
	 */
	net.menthor.metamodel.ontouml.Class getHighOrder();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.GeneralizationSet#getHighOrder <em>High Order</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>High Order</em>' reference.
	 * @see #getHighOrder()
	 * @generated
	 */
	void setHighOrder(net.menthor.metamodel.ontouml.Class value);

} // GeneralizationSet
