/**
 */
package net.menthor.metamodel.ontouml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Derivation Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getDerivationRelationship()
 * @model
 * @generated
 */
public interface DerivationRelationship extends BinaryRelationship {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.EndPoint%>> _endPoints = this.getEndPoints();\n<%net.menthor.metamodel.ontouml.EndPoint%> _get = _endPoints.get(0);\n<%net.menthor.metamodel.ontouml.ClassifierElement%> _endType = _get.getEndType();\nif ((_endType instanceof <%net.menthor.metamodel.ontouml.BinaryClassRelationship%>))\n{\n\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.EndPoint%>> _endPoints_1 = this.getEndPoints();\n\t<%net.menthor.metamodel.ontouml.EndPoint%> _get_1 = _endPoints_1.get(0);\n\t<%net.menthor.metamodel.ontouml.ClassifierElement%> _endType_1 = _get_1.getEndType();\n\treturn ((<%net.menthor.metamodel.ontouml.BinaryClassRelationship%>) _endType_1);\n}\nelse\n{\n\treturn null;\n}'"
	 * @generated
	 */
	BinaryClassRelationship sourceRelationship();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.EndPoint%>> _endPoints = this.getEndPoints();\n<%net.menthor.metamodel.ontouml.EndPoint%> _get = _endPoints.get(1);\n<%net.menthor.metamodel.ontouml.ClassifierElement%> _endType = _get.getEndType();\nif ((_endType instanceof <%net.menthor.metamodel.ontouml.Class%>))\n{\n\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.EndPoint%>> _endPoints_1 = this.getEndPoints();\n\t<%net.menthor.metamodel.ontouml.EndPoint%> _get_1 = _endPoints_1.get(1);\n\t<%net.menthor.metamodel.ontouml.ClassifierElement%> _endType_1 = _get_1.getEndType();\n\treturn ((<%net.menthor.metamodel.ontouml.Class%>) _endType_1);\n}\nelse\n{\n\treturn null;\n}'"
	 * @generated
	 */
	net.menthor.metamodel.ontouml.Class targetClass();

} // DerivationRelationship
