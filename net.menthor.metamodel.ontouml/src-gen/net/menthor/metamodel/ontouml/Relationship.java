/**
 */
package net.menthor.metamodel.ontouml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * * =========================================
 *  - relationship
 * 
 *  A relationship is a classifier (not named) which may have a stereotype.
 *  In the case where the stereotype is temporal (allen's relation), the relationship must define a temporal type (constraint C12).
 *  A relationship has also a set of end-points.
 *  A relationship can be derived from a truth maker only iff it is a material relationship (constraint C13).
 * 
 *  A derivation relationship:
 *  (i) must be binary (Constraint 14)
 *  (ii) must have as its source a material relationship (Constraint 15)
 *  (iii) must have as its target a truth maker class e.g. a relator (Constraint 16)
 * 
 *  ========================================
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.Relationship#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Relationship#getAllenRelation <em>Allen Relation</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Relationship#getEndPoints <em>End Points</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Relationship#getDerivedFromTruthMaker <em>Derived From Truth Maker</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getRelationship()
 * @model
 * @generated
 */
public interface Relationship extends NamedElement, Classifier {
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
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getRelationship_Stereotype()
	 * @model unique="false"
	 * @generated
	 */
	Relation getStereotype();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Relationship#getStereotype <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotype</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Relation
	 * @see #getStereotype()
	 * @generated
	 */
	void setStereotype(Relation value);

	/**
	 * Returns the value of the '<em><b>Allen Relation</b></em>' attribute.
	 * The literals are from the enumeration {@link net.menthor.metamodel.ontouml.Temporal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allen Relation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allen Relation</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Temporal
	 * @see #setAllenRelation(Temporal)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getRelationship_AllenRelation()
	 * @model unique="false"
	 * @generated
	 */
	Temporal getAllenRelation();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Relationship#getAllenRelation <em>Allen Relation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allen Relation</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Temporal
	 * @see #getAllenRelation()
	 * @generated
	 */
	void setAllenRelation(Temporal value);

	/**
	 * Returns the value of the '<em><b>End Points</b></em>' containment reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.EndPoint}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.EndPoint#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Points</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Points</em>' containment reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getRelationship_EndPoints()
	 * @see net.menthor.metamodel.ontouml.EndPoint#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<EndPoint> getEndPoints();

	/**
	 * Returns the value of the '<em><b>Derived From Truth Maker</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Class#getIstruthMakerOf <em>Istruth Maker Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived From Truth Maker</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived From Truth Maker</em>' reference.
	 * @see #setDerivedFromTruthMaker(net.menthor.metamodel.ontouml.Class)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getRelationship_DerivedFromTruthMaker()
	 * @see net.menthor.metamodel.ontouml.Class#getIstruthMakerOf
	 * @model opposite="istruthMakerOf"
	 * @generated
	 */
	net.menthor.metamodel.ontouml.Class getDerivedFromTruthMaker();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Relationship#getDerivedFromTruthMaker <em>Derived From Truth Maker</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Derived From Truth Maker</em>' reference.
	 * @see #getDerivedFromTruthMaker()
	 * @generated
	 */
	void setDerivedFromTruthMaker(net.menthor.metamodel.ontouml.Class value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body=''"
	 * @generated
	 */
	void isShareable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Relation%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Relation%>.COMPONENT_OF);'"
	 * @generated
	 */
	boolean isComponentOf();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Relation%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Relation%>.MEMBER_OF);'"
	 * @generated
	 */
	boolean isMemberOf();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Relation%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Relation%>.SUB_COLLECTION_OF);'"
	 * @generated
	 */
	boolean isSubCollectionOf();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Relation%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Relation%>.SUB_QUANTITY_OF);'"
	 * @generated
	 */
	boolean isSubQuantityOf();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Relation%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Relation%>.CONSTITUTION);'"
	 * @generated
	 */
	boolean isConstitution();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Relation%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Relation%>.CHARACTERIZATION);'"
	 * @generated
	 */
	boolean isCharacterization();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Relation%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Relation%>.MEDIATION);'"
	 * @generated
	 */
	boolean isMediation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Relation%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Relation%>.MATERIAL);'"
	 * @generated
	 */
	boolean isMaterial();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Relation%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Relation%>.FORMAL);'"
	 * @generated
	 */
	boolean isFormal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Relation%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Relation%>.STRUCTURATION);'"
	 * @generated
	 */
	boolean isStructuration();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Relation%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Relation%>.PARTICIPATION);'"
	 * @generated
	 */
	boolean isParticipation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Relation%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Relation%>.SUB_EVENT_OF);'"
	 * @generated
	 */
	boolean isSubEventOf();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Relation%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Relation%>.CAUSATION);'"
	 * @generated
	 */
	boolean isCausation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Relation%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Relation%>.TEMPORAL);'"
	 * @generated
	 */
	boolean isTemporal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Relation%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.Relation%>.DERIVATION);'"
	 * @generated
	 */
	boolean isDerivation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.Temporal%> _allenRelation = this.getAllenRelation();\nboolean _equals = <%com.google.common.base.Objects%>.equal(_allenRelation, <%net.menthor.metamodel.ontouml.Temporal%>.STARTS);\nif (!_equals)\n{\n\t_and = false;\n} else\n{\n\tboolean _isTemporal = this.isTemporal();\n\t_and = _isTemporal;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isStarts();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.Temporal%> _allenRelation = this.getAllenRelation();\nboolean _equals = <%com.google.common.base.Objects%>.equal(_allenRelation, <%net.menthor.metamodel.ontouml.Temporal%>.PRECEDES);\nif (!_equals)\n{\n\t_and = false;\n} else\n{\n\tboolean _isTemporal = this.isTemporal();\n\t_and = _isTemporal;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isPrecedes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.Temporal%> _allenRelation = this.getAllenRelation();\nboolean _equals = <%com.google.common.base.Objects%>.equal(_allenRelation, <%net.menthor.metamodel.ontouml.Temporal%>.EQUALS);\nif (!_equals)\n{\n\t_and = false;\n} else\n{\n\tboolean _isTemporal = this.isTemporal();\n\t_and = _isTemporal;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isEquals();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.Temporal%> _allenRelation = this.getAllenRelation();\nboolean _equals = <%com.google.common.base.Objects%>.equal(_allenRelation, <%net.menthor.metamodel.ontouml.Temporal%>.MEETS);\nif (!_equals)\n{\n\t_and = false;\n} else\n{\n\tboolean _isTemporal = this.isTemporal();\n\t_and = _isTemporal;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isMeets();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.Temporal%> _allenRelation = this.getAllenRelation();\nboolean _equals = <%com.google.common.base.Objects%>.equal(_allenRelation, <%net.menthor.metamodel.ontouml.Temporal%>.FINISHES);\nif (!_equals)\n{\n\t_and = false;\n} else\n{\n\tboolean _isTemporal = this.isTemporal();\n\t_and = _isTemporal;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isFinishes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.Temporal%> _allenRelation = this.getAllenRelation();\nboolean _equals = <%com.google.common.base.Objects%>.equal(_allenRelation, <%net.menthor.metamodel.ontouml.Temporal%>.OVERLAPS);\nif (!_equals)\n{\n\t_and = false;\n} else\n{\n\tboolean _isTemporal = this.isTemporal();\n\t_and = _isTemporal;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isOverlaps();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.Temporal%> _allenRelation = this.getAllenRelation();\nboolean _equals = <%com.google.common.base.Objects%>.equal(_allenRelation, <%net.menthor.metamodel.ontouml.Temporal%>.DURING);\nif (!_equals)\n{\n\t_and = false;\n} else\n{\n\tboolean _isTemporal = this.isTemporal();\n\t_and = _isTemporal;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isDuring();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _or = false;\nboolean _or_1 = false;\nboolean _or_2 = false;\nboolean _isComponentOf = this.isComponentOf();\nif (_isComponentOf)\n{\n\t_or_2 = true;\n} else\n{\n\tboolean _isMemberOf = this.isMemberOf();\n\t_or_2 = _isMemberOf;\n}\nif (_or_2)\n{\n\t_or_1 = true;\n} else\n{\n\tboolean _isSubQuantityOf = this.isSubQuantityOf();\n\t_or_1 = _isSubQuantityOf;\n}\nif (_or_1)\n{\n\t_or = true;\n} else\n{\n\tboolean _isSubCollectionOf = this.isSubCollectionOf();\n\t_or = _isSubCollectionOf;\n}\nreturn _or;'"
	 * @generated
	 */
	boolean isMeronymic();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.EndPoint%>> _endPoints = this.getEndPoints();\nint _size = _endPoints.size();\nreturn (_size == 2);'"
	 * @generated
	 */
	boolean isBinary();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.EndPoint%>> _endPoints = this.getEndPoints();\nint _size = _endPoints.size();\nreturn (_size == 3);'"
	 * @generated
	 */
	boolean isTernary();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.EndPoint%>> _endPoints = this.getEndPoints();\nint _size = _endPoints.size();\nboolean _greaterThan = (_size > 0);\nif (_greaterThan)\n{\n\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.EndPoint%>> _endPoints_1 = this.getEndPoints();\n\treturn _endPoints_1.get(0);\n}\nreturn null;'"
	 * @generated
	 */
	EndPoint sourceEnd();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.EndPoint%>> _endPoints = this.getEndPoints();\nint _size = _endPoints.size();\nboolean _greaterThan = (_size > 1);\nif (_greaterThan)\n{\n\t<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.EndPoint%>> _endPoints_1 = this.getEndPoints();\n\treturn _endPoints_1.get(1);\n}\nreturn null;'"
	 * @generated
	 */
	EndPoint targetEnd();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.EndPoint%> _sourceEnd = this.sourceEnd();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_sourceEnd, null));\nif (_notEquals)\n{\n\t<%net.menthor.metamodel.ontouml.EndPoint%> _sourceEnd_1 = this.sourceEnd();\n\treturn _sourceEnd_1.getEndType();\n}\nreturn null;'"
	 * @generated
	 */
	Classifier source();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.EndPoint%> _targetEnd = this.targetEnd();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_targetEnd, null));\nif (_notEquals)\n{\n\t<%net.menthor.metamodel.ontouml.EndPoint%> _targetEnd_1 = this.targetEnd();\n\treturn _targetEnd_1.getEndType();\n}\nreturn null;'"
	 * @generated
	 */
	Classifier target();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Classifier%> _source = this.source();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_source, null));\nif (_notEquals)\n{\n\t<%net.menthor.metamodel.ontouml.Classifier%> _source_1 = this.source();\n\treturn ((<%net.menthor.metamodel.ontouml.Class%>) _source_1);\n}\nreturn null;'"
	 * @generated
	 */
	net.menthor.metamodel.ontouml.Class sourceClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Classifier%> _target = this.target();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_target, null));\nif (_notEquals)\n{\n\t<%net.menthor.metamodel.ontouml.Classifier%> _target_1 = this.target();\n\treturn ((<%net.menthor.metamodel.ontouml.Class%>) _target_1);\n}\nreturn null;'"
	 * @generated
	 */
	net.menthor.metamodel.ontouml.Class targetClass();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Classifier%> _source = this.source();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_source, null));\nif (_notEquals)\n{\n\t<%net.menthor.metamodel.ontouml.Classifier%> _source_1 = this.source();\n\treturn ((<%net.menthor.metamodel.ontouml.Relationship%>) _source_1);\n}\nreturn null;'"
	 * @generated
	 */
	Relationship sourceRelationship();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.Classifier%> _target = this.target();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_target, null));\nif (_notEquals)\n{\n\t<%net.menthor.metamodel.ontouml.Classifier%> _target_1 = this.target();\n\treturn ((<%net.menthor.metamodel.ontouml.Relationship%>) _target_1);\n}\nreturn null;'"
	 * @generated
	 */
	Relationship targetRelationship();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%net.menthor.metamodel.ontouml.EndPoint%>> _endPoints = this.getEndPoints();\nfor (final <%net.menthor.metamodel.ontouml.EndPoint%> ep : _endPoints)\n{\n\tboolean _isIsDerived = ep.isIsDerived();\n\tif (_isIsDerived)\n\t{\n\t\treturn true;\n\t}\n}\nreturn false;'"
	 * @generated
	 */
	boolean isDerived();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\nboolean _and_1 = false;\n<%net.menthor.metamodel.ontouml.EndPoint%> _targetEnd = this.targetEnd();\nboolean _isIsDependency = _targetEnd.isIsDependency();\nif (!_isIsDependency)\n{\n\t_and_1 = false;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Class%> _sourceClass = this.sourceClass();\n\tboolean _isRigid = _sourceClass.isRigid();\n\t_and_1 = _isRigid;\n}\nif (!_and_1)\n{\n\t_and = false;\n} else\n{\n\tboolean _isMeronymic = this.isMeronymic();\n\t_and = _isMeronymic;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isPartEssential();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\nboolean _and_1 = false;\n<%net.menthor.metamodel.ontouml.EndPoint%> _sourceEnd = this.sourceEnd();\nboolean _isIsDependency = _sourceEnd.isIsDependency();\nif (!_isIsDependency)\n{\n\t_and_1 = false;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Class%> _targetClass = this.targetClass();\n\tboolean _isRigid = _targetClass.isRigid();\n\t_and_1 = _isRigid;\n}\nif (!_and_1)\n{\n\t_and = false;\n} else\n{\n\tboolean _isMeronymic = this.isMeronymic();\n\t_and = _isMeronymic;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isPartInseparable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\nboolean _and_1 = false;\n<%net.menthor.metamodel.ontouml.EndPoint%> _sourceEnd = this.sourceEnd();\nboolean _isIsDependency = _sourceEnd.isIsDependency();\nif (!_isIsDependency)\n{\n\t_and_1 = false;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Class%> _targetClass = this.targetClass();\n\tboolean _isAntiRigid = _targetClass.isAntiRigid();\n\t_and_1 = _isAntiRigid;\n}\nif (!_and_1)\n{\n\t_and = false;\n} else\n{\n\tboolean _isMeronymic = this.isMeronymic();\n\t_and = _isMeronymic;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isPartImmutable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\nboolean _and_1 = false;\n<%net.menthor.metamodel.ontouml.EndPoint%> _targetEnd = this.targetEnd();\nboolean _isIsDependency = _targetEnd.isIsDependency();\nif (!_isIsDependency)\n{\n\t_and_1 = false;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Class%> _sourceClass = this.sourceClass();\n\tboolean _isAntiRigid = _sourceClass.isAntiRigid();\n\t_and_1 = _isAntiRigid;\n}\nif (!_and_1)\n{\n\t_and = false;\n} else\n{\n\tboolean _isMeronymic = this.isMeronymic();\n\t_and = _isMeronymic;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isWholeImmutable();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.EndPoint%> _targetEnd = this.targetEnd();\nint _lowerBound = _targetEnd.getLowerBound();\nboolean _greaterEqualsThan = (_lowerBound >= 1);\nif (!_greaterEqualsThan)\n{\n\t_and = false;\n} else\n{\n\tboolean _isMeronymic = this.isMeronymic();\n\t_and = _isMeronymic;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isPartMandatory();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.EndPoint%> _sourceEnd = this.sourceEnd();\nint _lowerBound = _sourceEnd.getLowerBound();\nboolean _greaterEqualsThan = (_lowerBound >= 1);\nif (!_greaterEqualsThan)\n{\n\t_and = false;\n} else\n{\n\tboolean _isMeronymic = this.isMeronymic();\n\t_and = _isMeronymic;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isWholeMandatory();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return null;'"
	 * @generated
	 */
	Relationship material();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return null;'"
	 * @generated
	 */
	net.menthor.metamodel.ontouml.Class relator();

} // Relationship
