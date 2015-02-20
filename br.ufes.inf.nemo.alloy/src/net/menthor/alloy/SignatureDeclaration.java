/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package net.menthor.alloy;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Signature Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.alloy.SignatureDeclaration#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link net.menthor.alloy.SignatureDeclaration#getMultiplicity <em>Multiplicity</em>}</li>
 *   <li>{@link net.menthor.alloy.SignatureDeclaration#getRelation <em>Relation</em>}</li>
 *   <li>{@link net.menthor.alloy.SignatureDeclaration#getBlock <em>Block</em>}</li>
 *   <li>{@link net.menthor.alloy.SignatureDeclaration#isExists <em>Exists</em>}</li>
 *   <li>{@link net.menthor.alloy.SignatureDeclaration#getInheritance <em>Inheritance</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.alloy.AlloyPackage#getSignatureDeclaration()
 * @model
 * @generated
 */
public interface SignatureDeclaration extends Paragraph {
	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #setIsAbstract(boolean)
	 * @see net.menthor.alloy.AlloyPackage#getSignatureDeclaration_IsAbstract()
	 * @model
	 * @generated
	 */
	boolean isIsAbstract();

	/**
	 * Sets the value of the '{@link net.menthor.alloy.SignatureDeclaration#isIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #isIsAbstract()
	 * @generated
	 */
	void setIsAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Multiplicity</b></em>' attribute.
	 * The literals are from the enumeration {@link net.menthor.alloy.Multiplicity}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiplicity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiplicity</em>' attribute.
	 * @see net.menthor.alloy.Multiplicity
	 * @see #setMultiplicity(Multiplicity)
	 * @see net.menthor.alloy.AlloyPackage#getSignatureDeclaration_Multiplicity()
	 * @model
	 * @generated
	 */
	Multiplicity getMultiplicity();

	/**
	 * Sets the value of the '{@link net.menthor.alloy.SignatureDeclaration#getMultiplicity <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplicity</em>' attribute.
	 * @see net.menthor.alloy.Multiplicity
	 * @see #getMultiplicity()
	 * @generated
	 */
	void setMultiplicity(Multiplicity value);

	/**
	 * Returns the value of the '<em><b>Relation</b></em>' containment reference list.
	 * The list contents are of type {@link net.menthor.alloy.Declaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relation</em>' containment reference list.
	 * @see net.menthor.alloy.AlloyPackage#getSignatureDeclaration_Relation()
	 * @model containment="true"
	 * @generated
	 */
	EList<Declaration> getRelation();

	/**
	 * Returns the value of the '<em><b>Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block</em>' containment reference.
	 * @see #setBlock(Block)
	 * @see net.menthor.alloy.AlloyPackage#getSignatureDeclaration_Block()
	 * @model containment="true"
	 * @generated
	 */
	Block getBlock();

	/**
	 * Sets the value of the '{@link net.menthor.alloy.SignatureDeclaration#getBlock <em>Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block</em>' containment reference.
	 * @see #getBlock()
	 * @generated
	 */
	void setBlock(Block value);

	/**
	 * Returns the value of the '<em><b>Exists</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exists</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exists</em>' attribute.
	 * @see #setExists(boolean)
	 * @see net.menthor.alloy.AlloyPackage#getSignatureDeclaration_Exists()
	 * @model required="true"
	 * @generated
	 */
	boolean isExists();

	/**
	 * Sets the value of the '{@link net.menthor.alloy.SignatureDeclaration#isExists <em>Exists</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exists</em>' attribute.
	 * @see #isExists()
	 * @generated
	 */
	void setExists(boolean value);

	/**
	 * Returns the value of the '<em><b>Inheritance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inheritance</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inheritance</em>' containment reference.
	 * @see #setInheritance(Inheritance)
	 * @see net.menthor.alloy.AlloyPackage#getSignatureDeclaration_Inheritance()
	 * @model containment="true"
	 * @generated
	 */
	Inheritance getInheritance();

	/**
	 * Sets the value of the '{@link net.menthor.alloy.SignatureDeclaration#getInheritance <em>Inheritance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inheritance</em>' containment reference.
	 * @see #getInheritance()
	 * @generated
	 */
	void setInheritance(Inheritance value);

} // SignatureDeclaration
