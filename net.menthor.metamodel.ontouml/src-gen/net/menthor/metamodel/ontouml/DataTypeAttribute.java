/**
 */
package net.menthor.metamodel.ontouml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.DataTypeAttribute#getIsOfType <em>Is Of Type</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.DataTypeAttribute#getComplexDataType <em>Complex Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getDataTypeAttribute()
 * @model
 * @generated
 */
public interface DataTypeAttribute extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Is Of Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Of Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Of Type</em>' reference.
	 * @see #setIsOfType(DataType)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getDataTypeAttribute_IsOfType()
	 * @model required="true"
	 * @generated
	 */
	DataType getIsOfType();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.DataTypeAttribute#getIsOfType <em>Is Of Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Of Type</em>' reference.
	 * @see #getIsOfType()
	 * @generated
	 */
	void setIsOfType(DataType value);

	/**
	 * Returns the value of the '<em><b>Complex Data Type</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.ComplexDataType#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Complex Data Type</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Complex Data Type</em>' container reference.
	 * @see #setComplexDataType(ComplexDataType)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getDataTypeAttribute_ComplexDataType()
	 * @see net.menthor.metamodel.ontouml.ComplexDataType#getAttributes
	 * @model opposite="attributes" required="true" transient="false"
	 * @generated
	 */
	ComplexDataType getComplexDataType();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.DataTypeAttribute#getComplexDataType <em>Complex Data Type</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Complex Data Type</em>' container reference.
	 * @see #getComplexDataType()
	 * @generated
	 */
	void setComplexDataType(ComplexDataType value);

} // DataTypeAttribute
