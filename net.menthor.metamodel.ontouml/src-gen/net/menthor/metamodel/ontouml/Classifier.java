/**
 */
package net.menthor.metamodel.ontouml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * * =========================================
 *  - classifier (i.e. Class or Relationship)
 * 
 *  A classifier is a contained element defined to be a Class or a Relationship.
 *  ========================================
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.Classifier#getIsSpecializedVia <em>Is Specialized Via</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Classifier#getSpecializesVia <em>Specializes Via</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassifier()
 * @model abstract="true"
 * @generated
 */
public interface Classifier extends ContainedElement {
	/**
	 * Returns the value of the '<em><b>Is Specialized Via</b></em>' reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.GeneralizationSet}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.GeneralizationSet#getSpecializedClassifier <em>Specialized Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Specialized Via</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Specialized Via</em>' reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassifier_IsSpecializedVia()
	 * @see net.menthor.metamodel.ontouml.GeneralizationSet#getSpecializedClassifier
	 * @model opposite="specializedClassifier" ordered="false"
	 * @generated
	 */
	EList<GeneralizationSet> getIsSpecializedVia();

	/**
	 * Returns the value of the '<em><b>Specializes Via</b></em>' reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.GeneralizationSet}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.GeneralizationSet#getSpecializingClassifier <em>Specializing Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specializes Via</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specializes Via</em>' reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassifier_SpecializesVia()
	 * @see net.menthor.metamodel.ontouml.GeneralizationSet#getSpecializingClassifier
	 * @model opposite="specializingClassifier" ordered="false"
	 * @generated
	 */
	EList<GeneralizationSet> getSpecializesVia();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 *  Direct children
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Class%>[] list = null;\n<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.GeneralizationSet%>> _isSpecializedVia = this.getIsSpecializedVia();\nfor (final <%net.menthor.metamodel.ontouml.GeneralizationSet%> gs : _isSpecializedVia)\n{\n\tfinal <%net.menthor.metamodel.ontouml.Class%>[] _converted_list = (<%net.menthor.metamodel.ontouml.Class%>[])list;\n\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Classifier%>> _specializingClassifier = gs.getSpecializingClassifier();\n\t<%com.google.common.collect.Iterables%>.<<%net.menthor.metamodel.ontouml.Classifier%>>addAll(((<%java.util.Collection%><<%net.menthor.metamodel.ontouml.Classifier%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list)), _specializingClassifier);\n}\nfinal <%net.menthor.metamodel.ontouml.Class%>[] _converted_list_1 = (<%net.menthor.metamodel.ontouml.Class%>[])list;\nreturn <%org.eclipse.emf.common.util.ECollections%>.<<%net.menthor.metamodel.ontouml.Classifier%>>toEList(((<%java.lang.Iterable%><? extends <%net.menthor.metamodel.ontouml.Classifier%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list_1)));'"
	 * @generated
	 */
	EList<Classifier> children();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * * Direct parents
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Classifier%>[] list = null;\n<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.GeneralizationSet%>> _specializesVia = this.getSpecializesVia();\nfor (final <%net.menthor.metamodel.ontouml.GeneralizationSet%> gs : _specializesVia)\n{\n\tfinal <%net.menthor.metamodel.ontouml.Classifier%>[] _converted_list = (<%net.menthor.metamodel.ontouml.Classifier%>[])list;\n\t<%net.menthor.metamodel.ontouml.Classifier%> _specializedClassifier = gs.getSpecializedClassifier();\n\t((<%java.util.List%><<%net.menthor.metamodel.ontouml.Classifier%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list)).add(_specializedClassifier);\n}\nfinal <%net.menthor.metamodel.ontouml.Classifier%>[] _converted_list_1 = (<%net.menthor.metamodel.ontouml.Classifier%>[])list;\nreturn <%org.eclipse.emf.common.util.ECollections%>.<<%net.menthor.metamodel.ontouml.Classifier%>>toEList(((<%java.lang.Iterable%><? extends <%net.menthor.metamodel.ontouml.Classifier%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list_1)));'"
	 * @generated
	 */
	EList<Classifier> parents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * * All (direct and indirect) parents
	 * <!-- end-model-doc -->
	 * @model cUnique="false" resultUnique="false" resultMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.GeneralizationSet%>> _specializesVia = this.getSpecializesVia();\nfor (final <%net.menthor.metamodel.ontouml.GeneralizationSet%> gs : _specializesVia)\n{\n\t{\n\t\t<%net.menthor.metamodel.ontouml.Classifier%> _specializedClassifier = gs.getSpecializedClassifier();\n\t\tresult.add(_specializedClassifier);\n\t\t<%net.menthor.metamodel.ontouml.Classifier%> _specializedClassifier_1 = gs.getSpecializedClassifier();\n\t\tthis.allParents(_specializedClassifier_1, result);\n\t}\n}'"
	 * @generated
	 */
	void allParents(Classifier c, EList<Classifier> result);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * * All (direct and indirect) parents
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Classifier%>[] list = null;\nfinal <%net.menthor.metamodel.ontouml.Classifier%>[] _converted_list = (<%net.menthor.metamodel.ontouml.Classifier%>[])list;\n<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Classifier%>> _eList = <%org.eclipse.emf.common.util.ECollections%>.<<%net.menthor.metamodel.ontouml.Classifier%>>toEList(((<%java.lang.Iterable%><? extends <%net.menthor.metamodel.ontouml.Classifier%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list)));\nthis.allParents(this, _eList);\nfinal <%net.menthor.metamodel.ontouml.Classifier%>[] _converted_list_1 = (<%net.menthor.metamodel.ontouml.Classifier%>[])list;\nreturn <%org.eclipse.emf.common.util.ECollections%>.<<%net.menthor.metamodel.ontouml.Classifier%>>toEList(((<%java.lang.Iterable%><? extends <%net.menthor.metamodel.ontouml.Classifier%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list_1)));'"
	 * @generated
	 */
	EList<Classifier> allParents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 *  All (direct and indirect) children
	 * <!-- end-model-doc -->
	 * @model cUnique="false" resultUnique="false" resultMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.GeneralizationSet%>> _isSpecializedVia = this.getIsSpecializedVia();\nfor (final <%net.menthor.metamodel.ontouml.GeneralizationSet%> gs : _isSpecializedVia)\n{\n\t{\n\t\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Classifier%>> _specializingClassifier = gs.getSpecializingClassifier();\n\t\tresult.addAll(_specializingClassifier);\n\t\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Classifier%>> _specializingClassifier_1 = gs.getSpecializingClassifier();\n\t\tfor (final <%net.menthor.metamodel.ontouml.Classifier%> children : _specializingClassifier_1)\n\t\t{\n\t\t\tthis.allChildren(children, result);\n\t\t}\n\t}\n}'"
	 * @generated
	 */
	void allChildren(Classifier c, EList<Classifier> result);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 *  All (direct and indirect) children
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Classifier%>[] list = null;\nfinal <%net.menthor.metamodel.ontouml.Classifier%>[] _converted_list = (<%net.menthor.metamodel.ontouml.Classifier%>[])list;\n<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Classifier%>> _eList = <%org.eclipse.emf.common.util.ECollections%>.<<%net.menthor.metamodel.ontouml.Classifier%>>toEList(((<%java.lang.Iterable%><? extends <%net.menthor.metamodel.ontouml.Classifier%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list)));\nthis.allChildren(this, _eList);\nfinal <%net.menthor.metamodel.ontouml.Classifier%>[] _converted_list_1 = (<%net.menthor.metamodel.ontouml.Classifier%>[])list;\nreturn <%org.eclipse.emf.common.util.ECollections%>.<<%net.menthor.metamodel.ontouml.Classifier%>>toEList(((<%java.lang.Iterable%><? extends <%net.menthor.metamodel.ontouml.Classifier%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list_1)));'"
	 * @generated
	 */
	EList<Classifier> allChildren();

} // Classifier
