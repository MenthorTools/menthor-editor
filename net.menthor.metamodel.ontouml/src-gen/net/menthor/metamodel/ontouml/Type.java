/**
 */
package net.menthor.metamodel.ontouml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * * =========================================
 *  Type: is a Class or a DataType
 *  =========================================
 * <!-- end-model-doc -->
 *
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getType()
 * @model abstract="true"
 * @generated
 */
public interface Type extends NamedElement, Classifier {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * * Returns all types directly connected to this through a relationship.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Type%>[] result = null;\n<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.EndPoint%>> _ends = this.ends();\nfor (final <%net.menthor.metamodel.ontouml.EndPoint%> ep : _ends)\n{\n\tfinal <%net.menthor.metamodel.ontouml.Type%>[] _converted_result = (<%net.menthor.metamodel.ontouml.Type%>[])result;\n\t<%net.menthor.metamodel.ontouml.Classifier%> _endType = ep.getEndType();\n\t((<%java.util.List%><<%net.menthor.metamodel.ontouml.Type%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)).add(((<%net.menthor.metamodel.ontouml.Type%>) _endType));\n}\nfinal <%net.menthor.metamodel.ontouml.Type%>[] _converted_result_1 = (<%net.menthor.metamodel.ontouml.Type%>[])result;\nreturn <%org.eclipse.emf.common.util.ECollections%>.<<%net.menthor.metamodel.ontouml.Type%>>toEList(((<%java.lang.Iterable%><? extends <%net.menthor.metamodel.ontouml.Type%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)));'"
	 * @generated
	 */
	EList<Type> relatedTypes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *Returns all types directly and indirectly connected to this through a relationship.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Type%>[] result = null;\n<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.EndPoint%>> _allEnds = this.allEnds();\nfor (final <%net.menthor.metamodel.ontouml.EndPoint%> ep : _allEnds)\n{\n\tfinal <%net.menthor.metamodel.ontouml.Type%>[] _converted_result = (<%net.menthor.metamodel.ontouml.Type%>[])result;\n\t<%net.menthor.metamodel.ontouml.Classifier%> _endType = ep.getEndType();\n\t((<%java.util.List%><<%net.menthor.metamodel.ontouml.Type%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)).add(((<%net.menthor.metamodel.ontouml.Type%>) _endType));\n}\nfinal <%net.menthor.metamodel.ontouml.Type%>[] _converted_result_1 = (<%net.menthor.metamodel.ontouml.Type%>[])result;\nreturn <%org.eclipse.emf.common.util.ECollections%>.<<%net.menthor.metamodel.ontouml.Type%>>toEList(((<%java.lang.Iterable%><? extends <%net.menthor.metamodel.ontouml.Type%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)));'"
	 * @generated
	 */
	EList<Type> allRelatedTypes();

} // Type
