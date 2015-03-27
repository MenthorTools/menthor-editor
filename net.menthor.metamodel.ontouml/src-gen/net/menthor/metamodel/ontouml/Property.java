/**
 */
package net.menthor.metamodel.ontouml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.Property#isIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Property#isIsDerived <em>Is Derived</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Property#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Property#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Property#isIsDependee <em>Is Dependee</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getProperty()
 * @model abstract="true"
 * @generated
 */
public interface Property extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Is Ordered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Ordered</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Ordered</em>' attribute.
	 * @see #setIsOrdered(boolean)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getProperty_IsOrdered()
	 * @model unique="false"
	 * @generated
	 */
	boolean isIsOrdered();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Property#isIsOrdered <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Ordered</em>' attribute.
	 * @see #isIsOrdered()
	 * @generated
	 */
	void setIsOrdered(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Derived</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Derived</em>' attribute.
	 * @see #setIsDerived(boolean)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getProperty_IsDerived()
	 * @model unique="false"
	 * @generated
	 */
	boolean isIsDerived();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Property#isIsDerived <em>Is Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Derived</em>' attribute.
	 * @see #isIsDerived()
	 * @generated
	 */
	void setIsDerived(boolean value);

	/**
	 * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Bound</em>' attribute.
	 * @see #setLowerBound(int)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getProperty_LowerBound()
	 * @model unique="false" required="true"
	 * @generated
	 */
	int getLowerBound();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Property#getLowerBound <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound</em>' attribute.
	 * @see #getLowerBound()
	 * @generated
	 */
	void setLowerBound(int value);

	/**
	 * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Bound</em>' attribute.
	 * @see #setUpperBound(int)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getProperty_UpperBound()
	 * @model unique="false" required="true"
	 * @generated
	 */
	int getUpperBound();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Property#getUpperBound <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound</em>' attribute.
	 * @see #getUpperBound()
	 * @generated
	 */
	void setUpperBound(int value);

	/**
	 * Returns the value of the '<em><b>Is Dependee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Dependee</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Dependee</em>' attribute.
	 * @see #setIsDependee(boolean)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getProperty_IsDependee()
	 * @model unique="false"
	 * @generated
	 */
	boolean isIsDependee();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Property#isIsDependee <em>Is Dependee</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Dependee</em>' attribute.
	 * @see #isIsDependee()
	 * @generated
	 */
	void setIsDependee(boolean value);

} // Property
