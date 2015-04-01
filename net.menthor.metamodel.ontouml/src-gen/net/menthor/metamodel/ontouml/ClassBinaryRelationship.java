/**
 */
package net.menthor.metamodel.ontouml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Binary Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * * =========================================
 *  - class binary relationship
 * 
 *  A class binary relationship is a relationship between classes (Constraint C9) which is not
 *  stereotyped as derivation (Constraint C10)
 *  ========================================
 * <!-- end-model-doc -->
 *
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassBinaryRelationship()
 * @model
 * @generated
 */
public interface ClassBinaryRelationship extends NamedElement, BinaryRelationship {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.EndPoint%>> _endPoints = this.getEndPoints();\n<%net.menthor.metamodel.ontouml.EndPoint%> _get = _endPoints.get(0);\n<%net.menthor.metamodel.ontouml.Classifier%> _endType = _get.getEndType();\nif ((_endType instanceof <%net.menthor.metamodel.ontouml.Class%>))\n{\n\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.EndPoint%>> _endPoints_1 = this.getEndPoints();\n\t<%net.menthor.metamodel.ontouml.EndPoint%> _get_1 = _endPoints_1.get(0);\n\t<%net.menthor.metamodel.ontouml.Classifier%> _endType_1 = _get_1.getEndType();\n\treturn ((<%net.menthor.metamodel.ontouml.Class%>) _endType_1);\n}\nelse\n{\n\treturn null;\n}'"
	 * @generated
	 */
	net.menthor.metamodel.ontouml.Class sourceClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.EndPoint%>> _endPoints = this.getEndPoints();\n<%net.menthor.metamodel.ontouml.EndPoint%> _get = _endPoints.get(1);\n<%net.menthor.metamodel.ontouml.Classifier%> _endType = _get.getEndType();\nif ((_endType instanceof <%net.menthor.metamodel.ontouml.Class%>))\n{\n\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.EndPoint%>> _endPoints_1 = this.getEndPoints();\n\t<%net.menthor.metamodel.ontouml.EndPoint%> _get_1 = _endPoints_1.get(1);\n\t<%net.menthor.metamodel.ontouml.Classifier%> _endType_1 = _get_1.getEndType();\n\treturn ((<%net.menthor.metamodel.ontouml.Class%>) _endType_1);\n}\nelse\n{\n\treturn null;\n}'"
	 * @generated
	 */
	net.menthor.metamodel.ontouml.Class targetClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\nboolean _and_1 = false;\n<%net.menthor.metamodel.ontouml.EndPoint%> _targetEndPoint = this.targetEndPoint();\nboolean _isIsDependee = _targetEndPoint.isIsDependee();\nif (!_isIsDependee)\n{\n\t_and_1 = false;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Class%> _sourceClass = this.sourceClass();\n\tboolean _isRigid = _sourceClass.isRigid();\n\t_and_1 = _isRigid;\n}\nif (!_and_1)\n{\n\t_and = false;\n} else\n{\n\tboolean _isMeronymic = this.isMeronymic();\n\t_and = _isMeronymic;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isPartEssential();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\nboolean _and_1 = false;\n<%net.menthor.metamodel.ontouml.EndPoint%> _sourceEndPoint = this.sourceEndPoint();\nboolean _isIsDependee = _sourceEndPoint.isIsDependee();\nif (!_isIsDependee)\n{\n\t_and_1 = false;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Class%> _targetClass = this.targetClass();\n\tboolean _isRigid = _targetClass.isRigid();\n\t_and_1 = _isRigid;\n}\nif (!_and_1)\n{\n\t_and = false;\n} else\n{\n\tboolean _isMeronymic = this.isMeronymic();\n\t_and = _isMeronymic;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isPartInseparable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\nboolean _and_1 = false;\n<%net.menthor.metamodel.ontouml.EndPoint%> _sourceEndPoint = this.sourceEndPoint();\nboolean _isIsDependee = _sourceEndPoint.isIsDependee();\nif (!_isIsDependee)\n{\n\t_and_1 = false;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Class%> _targetClass = this.targetClass();\n\tboolean _isAntiRigid = _targetClass.isAntiRigid();\n\t_and_1 = _isAntiRigid;\n}\nif (!_and_1)\n{\n\t_and = false;\n} else\n{\n\tboolean _isMeronymic = this.isMeronymic();\n\t_and = _isMeronymic;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isPartImmutable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\nboolean _and_1 = false;\n<%net.menthor.metamodel.ontouml.EndPoint%> _targetEndPoint = this.targetEndPoint();\nboolean _isIsDependee = _targetEndPoint.isIsDependee();\nif (!_isIsDependee)\n{\n\t_and_1 = false;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Class%> _sourceClass = this.sourceClass();\n\tboolean _isAntiRigid = _sourceClass.isAntiRigid();\n\t_and_1 = _isAntiRigid;\n}\nif (!_and_1)\n{\n\t_and = false;\n} else\n{\n\tboolean _isMeronymic = this.isMeronymic();\n\t_and = _isMeronymic;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isWholeImmutable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.EndPoint%> _targetEndPoint = this.targetEndPoint();\nint _lowerBound = _targetEndPoint.getLowerBound();\nboolean _greaterEqualsThan = (_lowerBound >= 1);\nif (!_greaterEqualsThan)\n{\n\t_and = false;\n} else\n{\n\tboolean _isMeronymic = this.isMeronymic();\n\t_and = _isMeronymic;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isPartMandatory();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.EndPoint%> _sourceEndPoint = this.sourceEndPoint();\nint _lowerBound = _sourceEndPoint.getLowerBound();\nboolean _greaterEqualsThan = (_lowerBound >= 1);\nif (!_greaterEqualsThan)\n{\n\t_and = false;\n} else\n{\n\tboolean _isMeronymic = this.isMeronymic();\n\t_and = _isMeronymic;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isWholeMandatory();

} // ClassBinaryRelationship
