/**
 */
package net.menthor.metamodel.ontouml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * * =========================================
 *  - container & contained elements
 * 
 *  A container is a named element that contains a set of elements (i.e. model, packages).
 * 
 *  A contained element is an element that has a holder (a container) and possibly a set of comments.
 *  A contained element can be: a package, a classifier [class, relationship, structure, region, domain and dimension], or a generalization set.  *
 *  ========================================
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.Container#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getContainer()
 * @model abstract="true"
 * @generated
 */
public interface Container extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.ContainedElement}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.ContainedElement#getHolder <em>Holder</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getContainer_Elements()
	 * @see net.menthor.metamodel.ontouml.ContainedElement#getHolder
	 * @model opposite="holder" containment="true" ordered="false"
	 * @generated
	 */
	EList<ContainedElement> getElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 *  Returns the packages at this container. It only returns direct packages.
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Package%>[] result = null;\n<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.ContainedElement%>> _elements = this.getElements();\nfor (final <%net.menthor.metamodel.ontouml.ContainedElement%> e : _elements)\n{\n\tif ((e instanceof <%net.menthor.metamodel.ontouml.Package%>))\n\t{\n\t\tfinal <%net.menthor.metamodel.ontouml.Package%>[] _converted_result = (<%net.menthor.metamodel.ontouml.Package%>[])result;\n\t\t((<%java.util.List%><<%net.menthor.metamodel.ontouml.Package%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)).add(((<%net.menthor.metamodel.ontouml.Package%>)e));\n\t}\n}\nfinal <%net.menthor.metamodel.ontouml.Package%>[] _converted_result_1 = (<%net.menthor.metamodel.ontouml.Package%>[])result;\nreturn <%org.eclipse.emf.common.util.ECollections%>.<<%net.menthor.metamodel.ontouml.Package%>>toEList(((<%java.lang.Iterable%><? extends <%net.menthor.metamodel.ontouml.Package%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)));'"
	 * @generated
	 */
	EList<net.menthor.metamodel.ontouml.Package> packages();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * * Returns all packages at this container recursively. It returns both direct and indirect packages.
	 * <!-- end-model-doc -->
	 * @model cUnique="false" resultUnique="false" resultMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.ContainedElement%>> _elements = this.getElements();\nfor (final <%net.menthor.metamodel.ontouml.ContainedElement%> e : _elements)\n{\n\tif ((e instanceof <%net.menthor.metamodel.ontouml.Package%>))\n\t{\n\t\tresult.add(((<%net.menthor.metamodel.ontouml.Package%>)e));\n\t\tthis.allPackages(((<%net.menthor.metamodel.ontouml.Container%>)e), result);\n\t}\n}'"
	 * @generated
	 */
	void allPackages(Container c, EList<net.menthor.metamodel.ontouml.Package> result);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Package%>[] result = null;\nfinal <%net.menthor.metamodel.ontouml.Package%>[] _converted_result = (<%net.menthor.metamodel.ontouml.Package%>[])result;\n<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Package%>> _eList = <%org.eclipse.emf.common.util.ECollections%>.<<%net.menthor.metamodel.ontouml.Package%>>toEList(((<%java.lang.Iterable%><? extends <%net.menthor.metamodel.ontouml.Package%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)));\nthis.allPackages(this, _eList);\nfinal <%net.menthor.metamodel.ontouml.Package%>[] _converted_result_1 = (<%net.menthor.metamodel.ontouml.Package%>[])result;\nreturn <%org.eclipse.emf.common.util.ECollections%>.<<%net.menthor.metamodel.ontouml.Package%>>toEList(((<%java.lang.Iterable%><? extends <%net.menthor.metamodel.ontouml.Package%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)));'"
	 * @generated
	 */
	EList<net.menthor.metamodel.ontouml.Package> allPackages();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 *  Returns the relationships at this container
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Relationship%>[] result = null;\n<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.ContainedElement%>> _elements = this.getElements();\nfor (final <%net.menthor.metamodel.ontouml.ContainedElement%> e : _elements)\n{\n\tif ((e instanceof <%net.menthor.metamodel.ontouml.Relationship%>))\n\t{\n\t\tfinal <%net.menthor.metamodel.ontouml.Relationship%>[] _converted_result = (<%net.menthor.metamodel.ontouml.Relationship%>[])result;\n\t\t((<%java.util.List%><<%net.menthor.metamodel.ontouml.Relationship%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)).add(((<%net.menthor.metamodel.ontouml.Relationship%>)e));\n\t}\n}\nfinal <%net.menthor.metamodel.ontouml.Relationship%>[] _converted_result_1 = (<%net.menthor.metamodel.ontouml.Relationship%>[])result;\nreturn <%org.eclipse.emf.common.util.ECollections%>.<<%net.menthor.metamodel.ontouml.Relationship%>>toEList(((<%java.lang.Iterable%><? extends <%net.menthor.metamodel.ontouml.Relationship%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)));'"
	 * @generated
	 */
	EList<Relationship> relationships();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * * Returns all relationships at this container recursively. It returns both direct and indirect relationships.
	 * <!-- end-model-doc -->
	 * @model cUnique="false" resultUnique="false" resultMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.ContainedElement%>> _elements = this.getElements();\nfor (final <%net.menthor.metamodel.ontouml.ContainedElement%> e : _elements)\n{\n\t{\n\t\tif ((e instanceof <%net.menthor.metamodel.ontouml.Relationship%>))\n\t\t{\n\t\t\tresult.add(((<%net.menthor.metamodel.ontouml.Relationship%>)e));\n\t\t}\n\t\tif ((e instanceof <%net.menthor.metamodel.ontouml.Package%>))\n\t\t{\n\t\t\tthis.allRelationships(((<%net.menthor.metamodel.ontouml.Container%>)e), result);\n\t\t}\n\t}\n}'"
	 * @generated
	 */
	void allRelationships(Container c, EList<Relationship> result);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Relationship%>[] result = null;\nfinal <%net.menthor.metamodel.ontouml.Relationship%>[] _converted_result = (<%net.menthor.metamodel.ontouml.Relationship%>[])result;\n<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Relationship%>> _eList = <%org.eclipse.emf.common.util.ECollections%>.<<%net.menthor.metamodel.ontouml.Relationship%>>toEList(((<%java.lang.Iterable%><? extends <%net.menthor.metamodel.ontouml.Relationship%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)));\nthis.allRelationships(this, _eList);\nfinal <%net.menthor.metamodel.ontouml.Relationship%>[] _converted_result_1 = (<%net.menthor.metamodel.ontouml.Relationship%>[])result;\nreturn <%org.eclipse.emf.common.util.ECollections%>.<<%net.menthor.metamodel.ontouml.Relationship%>>toEList(((<%java.lang.Iterable%><? extends <%net.menthor.metamodel.ontouml.Relationship%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)));'"
	 * @generated
	 */
	EList<Relationship> allRelationships();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 *  Returns the generalization sets at this container
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.GeneralizationSet%>[] result = null;\n<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.ContainedElement%>> _elements = this.getElements();\nfor (final <%net.menthor.metamodel.ontouml.ContainedElement%> e : _elements)\n{\n\tif ((e instanceof <%net.menthor.metamodel.ontouml.GeneralizationSet%>))\n\t{\n\t\tfinal <%net.menthor.metamodel.ontouml.GeneralizationSet%>[] _converted_result = (<%net.menthor.metamodel.ontouml.GeneralizationSet%>[])result;\n\t\t((<%java.util.List%><<%net.menthor.metamodel.ontouml.GeneralizationSet%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)).add(((<%net.menthor.metamodel.ontouml.GeneralizationSet%>)e));\n\t}\n}\nfinal <%net.menthor.metamodel.ontouml.GeneralizationSet%>[] _converted_result_1 = (<%net.menthor.metamodel.ontouml.GeneralizationSet%>[])result;\nreturn <%org.eclipse.emf.common.util.ECollections%>.<<%net.menthor.metamodel.ontouml.GeneralizationSet%>>toEList(((<%java.lang.Iterable%><? extends <%net.menthor.metamodel.ontouml.GeneralizationSet%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)));'"
	 * @generated
	 */
	EList<GeneralizationSet> generalizationSets();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * * Returns all generalization sets at this container recursively. It returns both direct and indirect generalization sets.
	 * <!-- end-model-doc -->
	 * @model cUnique="false" resultUnique="false" resultMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.ContainedElement%>> _elements = this.getElements();\nfor (final <%net.menthor.metamodel.ontouml.ContainedElement%> e : _elements)\n{\n\t{\n\t\tif ((e instanceof <%net.menthor.metamodel.ontouml.GeneralizationSet%>))\n\t\t{\n\t\t\tresult.add(((<%net.menthor.metamodel.ontouml.GeneralizationSet%>)e));\n\t\t}\n\t\tif ((e instanceof <%net.menthor.metamodel.ontouml.Package%>))\n\t\t{\n\t\t\tthis.allGeneralizationSets(((<%net.menthor.metamodel.ontouml.Container%>)e), result);\n\t\t}\n\t}\n}'"
	 * @generated
	 */
	void allGeneralizationSets(Container c, EList<GeneralizationSet> result);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.GeneralizationSet%>[] result = null;\nfinal <%net.menthor.metamodel.ontouml.GeneralizationSet%>[] _converted_result = (<%net.menthor.metamodel.ontouml.GeneralizationSet%>[])result;\n<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.GeneralizationSet%>> _eList = <%org.eclipse.emf.common.util.ECollections%>.<<%net.menthor.metamodel.ontouml.GeneralizationSet%>>toEList(((<%java.lang.Iterable%><? extends <%net.menthor.metamodel.ontouml.GeneralizationSet%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)));\nthis.allGeneralizationSets(this, _eList);\nfinal <%net.menthor.metamodel.ontouml.GeneralizationSet%>[] _converted_result_1 = (<%net.menthor.metamodel.ontouml.GeneralizationSet%>[])result;\nreturn <%org.eclipse.emf.common.util.ECollections%>.<<%net.menthor.metamodel.ontouml.GeneralizationSet%>>toEList(((<%java.lang.Iterable%><? extends <%net.menthor.metamodel.ontouml.GeneralizationSet%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)));'"
	 * @generated
	 */
	EList<GeneralizationSet> allGeneralizationSets();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 *  Returns the classes at this container
	 * <!-- end-model-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Class%>[] result = null;\n<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.ContainedElement%>> _elements = this.getElements();\nfor (final <%net.menthor.metamodel.ontouml.ContainedElement%> e : _elements)\n{\n\tif ((e instanceof <%net.menthor.metamodel.ontouml.Class%>))\n\t{\n\t\tfinal <%net.menthor.metamodel.ontouml.Class%>[] _converted_result = (<%net.menthor.metamodel.ontouml.Class%>[])result;\n\t\t((<%java.util.List%><<%net.menthor.metamodel.ontouml.Class%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)).add(((<%net.menthor.metamodel.ontouml.Class%>)e));\n\t}\n}\nfinal <%net.menthor.metamodel.ontouml.Class%>[] _converted_result_1 = (<%net.menthor.metamodel.ontouml.Class%>[])result;\nreturn <%org.eclipse.emf.common.util.ECollections%>.<<%net.menthor.metamodel.ontouml.Class%>>toEList(((<%java.lang.Iterable%><? extends <%net.menthor.metamodel.ontouml.Class%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)));'"
	 * @generated
	 */
	EList<net.menthor.metamodel.ontouml.Class> classes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * * Returns all classes at this container recursively. It returns both direct and indirect classes.
	 * <!-- end-model-doc -->
	 * @model cUnique="false" resultUnique="false" resultMany="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.ContainedElement%>> _elements = this.getElements();\nfor (final <%net.menthor.metamodel.ontouml.ContainedElement%> e : _elements)\n{\n\t{\n\t\tif ((e instanceof <%net.menthor.metamodel.ontouml.Class%>))\n\t\t{\n\t\t\tresult.add(((<%net.menthor.metamodel.ontouml.Class%>)e));\n\t\t}\n\t\tif ((e instanceof <%net.menthor.metamodel.ontouml.Package%>))\n\t\t{\n\t\t\tthis.allClasses(((<%net.menthor.metamodel.ontouml.Container%>)e), result);\n\t\t}\n\t}\n}'"
	 * @generated
	 */
	void allClasses(Container c, EList<net.menthor.metamodel.ontouml.Class> result);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Class%>[] result = null;\nfinal <%net.menthor.metamodel.ontouml.Class%>[] _converted_result = (<%net.menthor.metamodel.ontouml.Class%>[])result;\n<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Class%>> _eList = <%org.eclipse.emf.common.util.ECollections%>.<<%net.menthor.metamodel.ontouml.Class%>>toEList(((<%java.lang.Iterable%><? extends <%net.menthor.metamodel.ontouml.Class%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)));\nthis.allClasses(this, _eList);\nfinal <%net.menthor.metamodel.ontouml.Class%>[] _converted_result_1 = (<%net.menthor.metamodel.ontouml.Class%>[])result;\nreturn <%org.eclipse.emf.common.util.ECollections%>.<<%net.menthor.metamodel.ontouml.Class%>>toEList(((<%java.lang.Iterable%><? extends <%net.menthor.metamodel.ontouml.Class%>>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)));'"
	 * @generated
	 */
	EList<net.menthor.metamodel.ontouml.Class> allClasses();

} // Container
