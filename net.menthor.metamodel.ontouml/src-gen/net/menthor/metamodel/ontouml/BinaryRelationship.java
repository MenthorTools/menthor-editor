/**
 */
package net.menthor.metamodel.ontouml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * * =========================================
 *  binary relationship
 *  ========================================
 * <!-- end-model-doc -->
 *
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getBinaryRelationship()
 * @model abstract="true"
 * @generated
 */
public interface BinaryRelationship extends Relationship {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.EndPoint%>> _endPoints = this.getEndPoints();\nreturn _endPoints.get(0);'"
	 * @generated
	 */
	EndPoint sourceEndPoint();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.EndPoint%>> _endPoints = this.getEndPoints();\nreturn _endPoints.get(1);'"
	 * @generated
	 */
	EndPoint targetEndPoint();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _or = false;\n<%net.menthor.metamodel.ontouml.EndPoint%> _sourceEndPoint = this.sourceEndPoint();\nboolean _isIsDerived = _sourceEndPoint.isIsDerived();\nif (_isIsDerived)\n{\n\t_or = true;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.EndPoint%> _targetEndPoint = this.targetEndPoint();\n\tboolean _isIsDerived_1 = _targetEndPoint.isIsDerived();\n\t_or = _isIsDerived_1;\n}\nreturn _or;'"
	 * @generated
	 */
	boolean isDerived();

} // BinaryRelationship
