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
 *  relationship
 *  ========================================
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.Relationship#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Relationship#getAllenRelation <em>Allen Relation</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Relationship#getEndPoints <em>End Points</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Relationship#getTruthMaker <em>Truth Maker</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getRelationship()
 * @model abstract="true"
 * @generated
 */
public interface Relationship extends ClassifierElement {
	/**
	 * Returns the value of the '<em><b>Stereotype</b></em>' attribute.
	 * The literals are from the enumeration {@link net.menthor.metamodel.ontouml.Relation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 *  JP: I assume there is no reason to distinguish ordered and non-ordered, as all should be non-ordered.
	 * We assume ordered end points...
	 * http://link.springer.com/chapter/10.1007%2F978-3-642-41924-9_40
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
	 * The literals are from the enumeration {@link net.menthor.metamodel.ontouml.AllenRelation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allen Relation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allen Relation</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.AllenRelation
	 * @see #setAllenRelation(AllenRelation)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getRelationship_AllenRelation()
	 * @model unique="false"
	 * @generated
	 */
	AllenRelation getAllenRelation();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Relationship#getAllenRelation <em>Allen Relation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allen Relation</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.AllenRelation
	 * @see #getAllenRelation()
	 * @generated
	 */
	void setAllenRelation(AllenRelation value);

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
	 * Returns the value of the '<em><b>Truth Maker</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Class#getIstruthMakerOf <em>Istruth Maker Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Truth Maker</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Truth Maker</em>' reference.
	 * @see #setTruthMaker(net.menthor.metamodel.ontouml.Class)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getRelationship_TruthMaker()
	 * @see net.menthor.metamodel.ontouml.Class#getIstruthMakerOf
	 * @model opposite="istruthMakerOf"
	 * @generated
	 */
	net.menthor.metamodel.ontouml.Class getTruthMaker();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Relationship#getTruthMaker <em>Truth Maker</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Truth Maker</em>' reference.
	 * @see #getTruthMaker()
	 * @generated
	 */
	void setTruthMaker(net.menthor.metamodel.ontouml.Class value);

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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.AllenRelation%> _allenRelation = this.getAllenRelation();\nboolean _equals = <%com.google.common.base.Objects%>.equal(_allenRelation, <%net.menthor.metamodel.ontouml.AllenRelation%>.STARTS);\nif (!_equals)\n{\n\t_and = false;\n} else\n{\n\tboolean _isTemporal = this.isTemporal();\n\t_and = _isTemporal;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isStarts();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.AllenRelation%> _allenRelation = this.getAllenRelation();\nboolean _equals = <%com.google.common.base.Objects%>.equal(_allenRelation, <%net.menthor.metamodel.ontouml.AllenRelation%>.PRECEDES);\nif (!_equals)\n{\n\t_and = false;\n} else\n{\n\tboolean _isTemporal = this.isTemporal();\n\t_and = _isTemporal;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isPrecedes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.AllenRelation%> _allenRelation = this.getAllenRelation();\nboolean _equals = <%com.google.common.base.Objects%>.equal(_allenRelation, <%net.menthor.metamodel.ontouml.AllenRelation%>.EQUALS);\nif (!_equals)\n{\n\t_and = false;\n} else\n{\n\tboolean _isTemporal = this.isTemporal();\n\t_and = _isTemporal;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isEquals();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.AllenRelation%> _allenRelation = this.getAllenRelation();\nboolean _equals = <%com.google.common.base.Objects%>.equal(_allenRelation, <%net.menthor.metamodel.ontouml.AllenRelation%>.MEETS);\nif (!_equals)\n{\n\t_and = false;\n} else\n{\n\tboolean _isTemporal = this.isTemporal();\n\t_and = _isTemporal;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isMeets();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.AllenRelation%> _allenRelation = this.getAllenRelation();\nboolean _equals = <%com.google.common.base.Objects%>.equal(_allenRelation, <%net.menthor.metamodel.ontouml.AllenRelation%>.FINISHES);\nif (!_equals)\n{\n\t_and = false;\n} else\n{\n\tboolean _isTemporal = this.isTemporal();\n\t_and = _isTemporal;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isFinishes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.AllenRelation%> _allenRelation = this.getAllenRelation();\nboolean _equals = <%com.google.common.base.Objects%>.equal(_allenRelation, <%net.menthor.metamodel.ontouml.AllenRelation%>.OVERLAPS);\nif (!_equals)\n{\n\t_and = false;\n} else\n{\n\tboolean _isTemporal = this.isTemporal();\n\t_and = _isTemporal;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isOverlaps();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.AllenRelation%> _allenRelation = this.getAllenRelation();\nboolean _equals = <%com.google.common.base.Objects%>.equal(_allenRelation, <%net.menthor.metamodel.ontouml.AllenRelation%>.DURING);\nif (!_equals)\n{\n\t_and = false;\n} else\n{\n\tboolean _isTemporal = this.isTemporal();\n\t_and = _isTemporal;\n}\nreturn _and;'"
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

} // Relationship
