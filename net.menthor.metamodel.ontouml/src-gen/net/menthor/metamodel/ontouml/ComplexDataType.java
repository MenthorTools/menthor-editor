/**
 */
package net.menthor.metamodel.ontouml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.ComplexDataType#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getComplexDataType()
 * @model
 * @generated
 */
public interface ComplexDataType extends UserDefinedDataType {
	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.DataTypeAttribute}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.DataTypeAttribute#getComplexDataType <em>Complex Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getComplexDataType_Attributes()
	 * @see net.menthor.metamodel.ontouml.DataTypeAttribute#getComplexDataType
	 * @model opposite="complexDataType" containment="true" lower="2" ordered="false"
	 * @generated
	 */
	EList<DataTypeAttribute> getAttributes();

} // ComplexDataType
