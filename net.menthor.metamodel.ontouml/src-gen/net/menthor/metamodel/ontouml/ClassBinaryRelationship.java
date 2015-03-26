/**
 */
package net.menthor.metamodel.ontouml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Binary Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getEndPoints <em>End Points</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#isPartIsShareable <em>Part Is Shareable</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getTruthMaker <em>Truth Maker</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#isIsDerived <em>Is Derived</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#isPartIsEssential <em>Part Is Essential</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#isPartIsInseparable <em>Part Is Inseparable</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#isPartIsImmutable <em>Part Is Immutable</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#isWholeIsImmutable <em>Whole Is Immutable</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#isPartIsMandatory <em>Part Is Mandatory</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#isWholeIsMandatory <em>Whole Is Mandatory</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassBinaryRelationship()
 * @model
 * @generated
 */
public interface ClassBinaryRelationship extends NamedElement, ContainingElement {
	/**
	 * Returns the value of the '<em><b>Stereotype</b></em>' attribute.
	 * The literals are from the enumeration {@link net.menthor.metamodel.ontouml.Relation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 *  JP: I assume there is no reason to distinguish ordered and non-ordered, as all should be non-ordered.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Stereotype</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Relation
	 * @see #setStereotype(Relation)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassBinaryRelationship_Stereotype()
	 * @model unique="false"
	 * @generated
	 */
	Relation getStereotype();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getStereotype <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotype</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Relation
	 * @see #getStereotype()
	 * @generated
	 */
	void setStereotype(Relation value);

	/**
	 * Returns the value of the '<em><b>End Points</b></em>' reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.EndPoint}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.EndPoint#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Points</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Points</em>' reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassBinaryRelationship_EndPoints()
	 * @see net.menthor.metamodel.ontouml.EndPoint#getOwner
	 * @model opposite="owner" lower="2" upper="2"
	 * @generated
	 */
	EList<EndPoint> getEndPoints();

	/**
	 * Returns the value of the '<em><b>Part Is Shareable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Is Shareable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Is Shareable</em>' attribute.
	 * @see #setPartIsShareable(boolean)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassBinaryRelationship_PartIsShareable()
	 * @model unique="false"
	 * @generated
	 */
	boolean isPartIsShareable();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#isPartIsShareable <em>Part Is Shareable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part Is Shareable</em>' attribute.
	 * @see #isPartIsShareable()
	 * @generated
	 */
	void setPartIsShareable(boolean value);

	/**
	 * Returns the value of the '<em><b>Truth Maker</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Class#getIstruthMakerOf <em>Istruth Maker Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 *  JP: If there are two relators relating the same entities, there should not be two material relations
	 * between the same entities... the tuples are identical e.g., you should not say that there are two "student at"
	 * relations between "Student" and "University" even if there are two "Enrollments".
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Truth Maker</em>' reference.
	 * @see #setTruthMaker(net.menthor.metamodel.ontouml.Class)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassBinaryRelationship_TruthMaker()
	 * @see net.menthor.metamodel.ontouml.Class#getIstruthMakerOf
	 * @model opposite="istruthMakerOf"
	 * @generated
	 */
	net.menthor.metamodel.ontouml.Class getTruthMaker();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getTruthMaker <em>Truth Maker</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Truth Maker</em>' reference.
	 * @see #getTruthMaker()
	 * @generated
	 */
	void setTruthMaker(net.menthor.metamodel.ontouml.Class value);

	/**
	 * Returns the value of the '<em><b>Is Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Derived</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Derived</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassBinaryRelationship_IsDerived()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='boolean _or = false;\n<%net.menthor.metamodel.ontouml.EndPoint%> _sourceEnd = this.sourceEnd();\nboolean _isIsDerived = _sourceEnd.isIsDerived();\nif (_isIsDerived)\n{\n\t_or = true;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.EndPoint%> _targetEnd = this.targetEnd();\n\tboolean _isIsDerived_1 = _targetEnd.isIsDerived();\n\t_or = _isIsDerived_1;\n}\nreturn _or;'"
	 * @generated
	 */
	boolean isIsDerived();

	/**
	 * Returns the value of the '<em><b>Part Is Essential</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Is Essential</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Is Essential</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassBinaryRelationship_PartIsEssential()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='boolean _and = false;\nboolean _and_1 = false;\n<%net.menthor.metamodel.ontouml.EndPoint%> _targetEnd = this.targetEnd();\nboolean _isIsSpecificDependent = _targetEnd.isIsSpecificDependent();\nif (!_isIsSpecificDependent)\n{\n\t_and_1 = false;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.EndPoint%> _sourceEnd = this.sourceEnd();\n\t<%net.menthor.metamodel.ontouml.Class%> _isOfType = _sourceEnd.getIsOfType();\n\tboolean _isRigid = _isOfType.isRigid();\n\t_and_1 = _isRigid;\n}\nif (!_and_1)\n{\n\t_and = false;\n} else\n{\n\tboolean _isMeronymic = this.isMeronymic();\n\t_and = _isMeronymic;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isPartIsEssential();

	/**
	 * Returns the value of the '<em><b>Part Is Inseparable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Is Inseparable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Is Inseparable</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassBinaryRelationship_PartIsInseparable()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='boolean _and = false;\nboolean _and_1 = false;\n<%net.menthor.metamodel.ontouml.EndPoint%> _sourceEnd = this.sourceEnd();\nboolean _isIsSpecificDependent = _sourceEnd.isIsSpecificDependent();\nif (!_isIsSpecificDependent)\n{\n\t_and_1 = false;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.EndPoint%> _targetEnd = this.targetEnd();\n\t<%net.menthor.metamodel.ontouml.Class%> _isOfType = _targetEnd.getIsOfType();\n\tboolean _isRigid = _isOfType.isRigid();\n\t_and_1 = _isRigid;\n}\nif (!_and_1)\n{\n\t_and = false;\n} else\n{\n\tboolean _isMeronymic = this.isMeronymic();\n\t_and = _isMeronymic;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isPartIsInseparable();

	/**
	 * Returns the value of the '<em><b>Part Is Immutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Is Immutable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Is Immutable</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassBinaryRelationship_PartIsImmutable()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='boolean _and = false;\nboolean _and_1 = false;\n<%net.menthor.metamodel.ontouml.EndPoint%> _sourceEnd = this.sourceEnd();\nboolean _isIsSpecificDependent = _sourceEnd.isIsSpecificDependent();\nif (!_isIsSpecificDependent)\n{\n\t_and_1 = false;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.EndPoint%> _targetEnd = this.targetEnd();\n\t<%net.menthor.metamodel.ontouml.Class%> _isOfType = _targetEnd.getIsOfType();\n\tboolean _isAntiRigid = _isOfType.isAntiRigid();\n\t_and_1 = _isAntiRigid;\n}\nif (!_and_1)\n{\n\t_and = false;\n} else\n{\n\tboolean _isMeronymic = this.isMeronymic();\n\t_and = _isMeronymic;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isPartIsImmutable();

	/**
	 * Returns the value of the '<em><b>Whole Is Immutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Whole Is Immutable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Whole Is Immutable</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassBinaryRelationship_WholeIsImmutable()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='boolean _and = false;\nboolean _and_1 = false;\n<%net.menthor.metamodel.ontouml.EndPoint%> _targetEnd = this.targetEnd();\nboolean _isIsSpecificDependent = _targetEnd.isIsSpecificDependent();\nif (!_isIsSpecificDependent)\n{\n\t_and_1 = false;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.EndPoint%> _sourceEnd = this.sourceEnd();\n\t<%net.menthor.metamodel.ontouml.Class%> _isOfType = _sourceEnd.getIsOfType();\n\tboolean _isAntiRigid = _isOfType.isAntiRigid();\n\t_and_1 = _isAntiRigid;\n}\nif (!_and_1)\n{\n\t_and = false;\n} else\n{\n\tboolean _isMeronymic = this.isMeronymic();\n\t_and = _isMeronymic;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isWholeIsImmutable();

	/**
	 * Returns the value of the '<em><b>Part Is Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Is Mandatory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Is Mandatory</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassBinaryRelationship_PartIsMandatory()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='boolean _and = false;\n<%net.menthor.metamodel.ontouml.EndPoint%> _targetEnd = this.targetEnd();\nint _lowerBound = _targetEnd.getLowerBound();\nboolean _greaterEqualsThan = (_lowerBound >= 1);\nif (!_greaterEqualsThan)\n{\n\t_and = false;\n} else\n{\n\tboolean _isMeronymic = this.isMeronymic();\n\t_and = _isMeronymic;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isPartIsMandatory();

	/**
	 * Returns the value of the '<em><b>Whole Is Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Whole Is Mandatory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Whole Is Mandatory</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassBinaryRelationship_WholeIsMandatory()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='boolean _and = false;\n<%net.menthor.metamodel.ontouml.EndPoint%> _sourceEnd = this.sourceEnd();\nint _lowerBound = _sourceEnd.getLowerBound();\nboolean _greaterEqualsThan = (_lowerBound >= 1);\nif (!_greaterEqualsThan)\n{\n\t_and = false;\n} else\n{\n\tboolean _isMeronymic = this.isMeronymic();\n\t_and = _isMeronymic;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isWholeIsMandatory();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.EndPoint%>> _endPoints = this.getEndPoints();\nreturn _endPoints.get(0);'"
	 * @generated
	 */
	EndPoint sourceEnd();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.EndPoint%>> _endPoints = this.getEndPoints();\nreturn _endPoints.get(1);'"
	 * @generated
	 */
	EndPoint targetEnd();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _or = false;\nboolean _or_1 = false;\nboolean _or_2 = false;\n<%net.menthor.metamodel.ontouml.Relation%> _stereotype = this.getStereotype();\nboolean _equals = <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Relation%>.COMPONENT_OF);\nif (_equals)\n{\n\t_or_2 = true;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Relation%> _stereotype_1 = this.getStereotype();\n\tboolean _equals_1 = <%com.google.common.base.Objects%>.equal(_stereotype_1, <%net.menthor.metamodel.ontouml.Relation%>.MEMBER_OF);\n\t_or_2 = _equals_1;\n}\nif (_or_2)\n{\n\t_or_1 = true;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Relation%> _stereotype_2 = this.getStereotype();\n\tboolean _equals_2 = <%com.google.common.base.Objects%>.equal(_stereotype_2, <%net.menthor.metamodel.ontouml.Relation%>.SUB_QUANTITY_OF);\n\t_or_1 = _equals_2;\n}\nif (_or_1)\n{\n\t_or = true;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Relation%> _stereotype_3 = this.getStereotype();\n\tboolean _equals_3 = <%com.google.common.base.Objects%>.equal(_stereotype_3, <%net.menthor.metamodel.ontouml.Relation%>.SUB_COLLECTION_OF);\n\t_or = _equals_3;\n}\nreturn _or;'"
	 * @generated
	 */
	boolean isMeronymic();

} // ClassBinaryRelationship
