/**
 */
package net.menthor.metamodel.ontouml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * * =========================================
 *  - region (type)
 * 
 *  A Region can be owned by a Structure and be grounded in an Enumeration Literal
 *  A "Composed" Region must have more than one Region.
 *  A "Basic" Region is defined by a Integer or a Decimal measure type.
 *  A "Nominal" Region is defined by a String measure type.
 *  ========================================
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.Region#getOwnerStructure <em>Owner Structure</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Region#getGroundedLiteral <em>Grounded Literal</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Region#getComposedBy <em>Composed By</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Region#getBasicType <em>Basic Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getRegion()
 * @model
 * @generated
 */
public interface Region extends Type {
	/**
	 * Returns the value of the '<em><b>Owner Structure</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Structure#getRegions <em>Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner Structure</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner Structure</em>' reference.
	 * @see #setOwnerStructure(Structure)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getRegion_OwnerStructure()
	 * @see net.menthor.metamodel.ontouml.Structure#getRegions
	 * @model opposite="regions"
	 * @generated
	 */
	Structure getOwnerStructure();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Region#getOwnerStructure <em>Owner Structure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner Structure</em>' reference.
	 * @see #getOwnerStructure()
	 * @generated
	 */
	void setOwnerStructure(Structure value);

	/**
	 * Returns the value of the '<em><b>Grounded Literal</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Literal#getGroundingRegion <em>Grounding Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Grounded Literal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grounded Literal</em>' reference.
	 * @see #setGroundedLiteral(Literal)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getRegion_GroundedLiteral()
	 * @see net.menthor.metamodel.ontouml.Literal#getGroundingRegion
	 * @model opposite="groundingRegion"
	 * @generated
	 */
	Literal getGroundedLiteral();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Region#getGroundedLiteral <em>Grounded Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grounded Literal</em>' reference.
	 * @see #getGroundedLiteral()
	 * @generated
	 */
	void setGroundedLiteral(Literal value);

	/**
	 * Returns the value of the '<em><b>Composed By</b></em>' reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.Region}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composed By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composed By</em>' reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getRegion_ComposedBy()
	 * @model
	 * @generated
	 */
	EList<Region> getComposedBy();

	/**
	 * Returns the value of the '<em><b>Basic Type</b></em>' attribute.
	 * The literals are from the enumeration {@link net.menthor.metamodel.ontouml.Primitive}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Basic Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Basic Type</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Primitive
	 * @see #setBasicType(Primitive)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getRegion_BasicType()
	 * @model unique="false"
	 * @generated
	 */
	Primitive getBasicType();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Region#getBasicType <em>Basic Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Basic Type</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Primitive
	 * @see #getBasicType()
	 * @generated
	 */
	void setBasicType(Primitive value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\nboolean _and_1 = false;\n<%net.menthor.metamodel.ontouml.Primitive%> _basicType = this.getBasicType();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_basicType, null));\nif (!_notEquals)\n{\n\t_and_1 = false;\n} else\n{\n\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Region%>> _composedBy = this.getComposedBy();\n\tint _size = _composedBy.size();\n\tboolean _equals = (_size == 0);\n\t_and_1 = _equals;\n}\nif (!_and_1)\n{\n\t_and = false;\n} else\n{\n\tboolean _or = false;\n\t<%net.menthor.metamodel.ontouml.Primitive%> _basicType_1 = this.getBasicType();\n\tboolean _equals_1 = <%com.google.common.base.Objects%>.equal(_basicType_1, <%net.menthor.metamodel.ontouml.Primitive%>.INTEGER);\n\tif (_equals_1)\n\t{\n\t\t_or = true;\n\t} else\n\t{\n\t\t<%net.menthor.metamodel.ontouml.Primitive%> _basicType_2 = this.getBasicType();\n\t\tboolean _equals_2 = <%com.google.common.base.Objects%>.equal(_basicType_2, <%net.menthor.metamodel.ontouml.Primitive%>.DECIMAL);\n\t\t_or = _equals_2;\n\t}\n\t_and = _or;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isBasic();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.Primitive%> _basicType = this.getBasicType();\nboolean _equals = <%com.google.common.base.Objects%>.equal(_basicType, null);\nif (!_equals)\n{\n\t_and = false;\n} else\n{\n\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.Region%>> _composedBy = this.getComposedBy();\n\tint _size = _composedBy.size();\n\tboolean _greaterThan = (_size > 0);\n\t_and = _greaterThan;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isComposed();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.Primitive%> _basicType = this.getBasicType();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_basicType, null));\nif (!_notEquals)\n{\n\t_and = false;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Primitive%> _basicType_1 = this.getBasicType();\n\tboolean _equals = <%com.google.common.base.Objects%>.equal(_basicType_1, <%net.menthor.metamodel.ontouml.Primitive%>.STRING);\n\t_and = _equals;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isNominal();

} // Region
