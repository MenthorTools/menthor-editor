/**
 */
package net.menthor.metamodel.ontouml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Binary Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getSourceEndName <em>Source End Name</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getSourceLowerBound <em>Source Lower Bound</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getSourceUpperBound <em>Source Upper Bound</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getTargetEndName <em>Target End Name</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getTargetLowerBound <em>Target Lower Bound</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getTargetUpperBound <em>Target Upper Bound</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#isPartIsEssential <em>Part Is Essential</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#isPartIsInseparable <em>Part Is Inseparable</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#isPartIsShareable <em>Part Is Shareable</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#isPartIsImmutable <em>Part Is Immutable</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#isPartIsMandatory <em>Part Is Mandatory</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getSource <em>Source</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassBinaryRelationship()
 * @model
 * @generated
 */
public interface ClassBinaryRelationship extends NamedElement, PackageableElement {
	/**
	 * Returns the value of the '<em><b>Stereotype</b></em>' attribute.
	 * The literals are from the enumeration {@link net.menthor.metamodel.ontouml.Relation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
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
	 * Returns the value of the '<em><b>Source End Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source End Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source End Name</em>' attribute.
	 * @see #setSourceEndName(String)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassBinaryRelationship_SourceEndName()
	 * @model unique="false"
	 * @generated
	 */
	String getSourceEndName();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getSourceEndName <em>Source End Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source End Name</em>' attribute.
	 * @see #getSourceEndName()
	 * @generated
	 */
	void setSourceEndName(String value);

	/**
	 * Returns the value of the '<em><b>Source Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Lower Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Lower Bound</em>' attribute.
	 * @see #setSourceLowerBound(int)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassBinaryRelationship_SourceLowerBound()
	 * @model unique="false" required="true"
	 * @generated
	 */
	int getSourceLowerBound();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getSourceLowerBound <em>Source Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Lower Bound</em>' attribute.
	 * @see #getSourceLowerBound()
	 * @generated
	 */
	void setSourceLowerBound(int value);

	/**
	 * Returns the value of the '<em><b>Source Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Upper Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Upper Bound</em>' attribute.
	 * @see #setSourceUpperBound(int)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassBinaryRelationship_SourceUpperBound()
	 * @model unique="false" required="true"
	 * @generated
	 */
	int getSourceUpperBound();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getSourceUpperBound <em>Source Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Upper Bound</em>' attribute.
	 * @see #getSourceUpperBound()
	 * @generated
	 */
	void setSourceUpperBound(int value);

	/**
	 * Returns the value of the '<em><b>Target End Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target End Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target End Name</em>' attribute.
	 * @see #setTargetEndName(String)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassBinaryRelationship_TargetEndName()
	 * @model unique="false"
	 * @generated
	 */
	String getTargetEndName();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getTargetEndName <em>Target End Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target End Name</em>' attribute.
	 * @see #getTargetEndName()
	 * @generated
	 */
	void setTargetEndName(String value);

	/**
	 * Returns the value of the '<em><b>Target Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Lower Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Lower Bound</em>' attribute.
	 * @see #setTargetLowerBound(int)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassBinaryRelationship_TargetLowerBound()
	 * @model unique="false" required="true"
	 * @generated
	 */
	int getTargetLowerBound();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getTargetLowerBound <em>Target Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Lower Bound</em>' attribute.
	 * @see #getTargetLowerBound()
	 * @generated
	 */
	void setTargetLowerBound(int value);

	/**
	 * Returns the value of the '<em><b>Target Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Upper Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Upper Bound</em>' attribute.
	 * @see #setTargetUpperBound(int)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassBinaryRelationship_TargetUpperBound()
	 * @model unique="false" required="true"
	 * @generated
	 */
	int getTargetUpperBound();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getTargetUpperBound <em>Target Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Upper Bound</em>' attribute.
	 * @see #getTargetUpperBound()
	 * @generated
	 */
	void setTargetUpperBound(int value);

	/**
	 * Returns the value of the '<em><b>Part Is Essential</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Is Essential</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Is Essential</em>' attribute.
	 * @see #setPartIsEssential(boolean)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassBinaryRelationship_PartIsEssential()
	 * @model unique="false"
	 * @generated
	 */
	boolean isPartIsEssential();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#isPartIsEssential <em>Part Is Essential</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part Is Essential</em>' attribute.
	 * @see #isPartIsEssential()
	 * @generated
	 */
	void setPartIsEssential(boolean value);

	/**
	 * Returns the value of the '<em><b>Part Is Inseparable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Is Inseparable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Is Inseparable</em>' attribute.
	 * @see #setPartIsInseparable(boolean)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassBinaryRelationship_PartIsInseparable()
	 * @model unique="false"
	 * @generated
	 */
	boolean isPartIsInseparable();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#isPartIsInseparable <em>Part Is Inseparable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part Is Inseparable</em>' attribute.
	 * @see #isPartIsInseparable()
	 * @generated
	 */
	void setPartIsInseparable(boolean value);

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
	 * Returns the value of the '<em><b>Part Is Immutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part Is Immutable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part Is Immutable</em>' attribute.
	 * @see #setPartIsImmutable(boolean)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassBinaryRelationship_PartIsImmutable()
	 * @model unique="false"
	 * @generated
	 */
	boolean isPartIsImmutable();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#isPartIsImmutable <em>Part Is Immutable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part Is Immutable</em>' attribute.
	 * @see #isPartIsImmutable()
	 * @generated
	 */
	void setPartIsImmutable(boolean value);

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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='int _targetLowerBound = this.getTargetLowerBound();\nreturn (_targetLowerBound >= 1);'"
	 * @generated
	 */
	boolean isPartIsMandatory();

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Class#getIsSourceOf <em>Is Source Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(net.menthor.metamodel.ontouml.Class)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassBinaryRelationship_Source()
	 * @see net.menthor.metamodel.ontouml.Class#getIsSourceOf
	 * @model opposite="isSourceOf" resolveProxies="false" required="true"
	 * @generated
	 */
	net.menthor.metamodel.ontouml.Class getSource();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(net.menthor.metamodel.ontouml.Class value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Class#getIsTargetOf <em>Is Target Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(net.menthor.metamodel.ontouml.Class)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClassBinaryRelationship_Target()
	 * @see net.menthor.metamodel.ontouml.Class#getIsTargetOf
	 * @model opposite="isTargetOf" resolveProxies="false" required="true"
	 * @generated
	 */
	net.menthor.metamodel.ontouml.Class getTarget();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(net.menthor.metamodel.ontouml.Class value);

} // ClassBinaryRelationship
