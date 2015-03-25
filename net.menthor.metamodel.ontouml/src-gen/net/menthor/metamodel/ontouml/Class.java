/**
 */
package net.menthor.metamodel.ontouml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#isIsDerived <em>Is Derived</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#isIsExtensional <em>Is Extensional</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getInstanceOf <em>Instance Of</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getDatatypes <em>Datatypes</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getIsSpecializedVia <em>Is Specialized Via</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getSpecializesVia <em>Specializes Via</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getIsSourceOf <em>Is Source Of</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getIsTargetOf <em>Is Target Of</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Class#getIsTruthMakerOf <em>Is Truth Maker Of</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends NamedElement, PackageableElement {
	/**
	 * Returns the value of the '<em><b>Stereotype</b></em>' attribute.
	 * The literals are from the enumeration {@link net.menthor.metamodel.ontouml.Universal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotype</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Universal
	 * @see #setStereotype(Universal)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_Stereotype()
	 * @model unique="false"
	 * @generated
	 */
	Universal getStereotype();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Class#getStereotype <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotype</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Universal
	 * @see #getStereotype()
	 * @generated
	 */
	void setStereotype(Universal value);

	/**
	 * Returns the value of the '<em><b>Is Derived</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Derived</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Derived</em>' attribute.
	 * @see #setIsDerived(boolean)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_IsDerived()
	 * @model unique="false"
	 * @generated
	 */
	boolean isIsDerived();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Class#isIsDerived <em>Is Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Derived</em>' attribute.
	 * @see #isIsDerived()
	 * @generated
	 */
	void setIsDerived(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Extensional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Extensional</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Extensional</em>' attribute.
	 * @see #setIsExtensional(boolean)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_IsExtensional()
	 * @model unique="false"
	 * @generated
	 */
	boolean isIsExtensional();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Class#isIsExtensional <em>Is Extensional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Extensional</em>' attribute.
	 * @see #isIsExtensional()
	 * @generated
	 */
	void setIsExtensional(boolean value);

	/**
	 * Returns the value of the '<em><b>Instance Of</b></em>' reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.HighOrderClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Of</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Of</em>' reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_InstanceOf()
	 * @model ordered="false"
	 * @generated
	 */
	EList<HighOrderClass> getInstanceOf();

	/**
	 * Returns the value of the '<em><b>Datatypes</b></em>' reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.DataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Datatypes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Datatypes</em>' reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_Datatypes()
	 * @model ordered="false"
	 * @generated
	 */
	EList<DataType> getDatatypes();

	/**
	 * Returns the value of the '<em><b>Is Specialized Via</b></em>' reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.GeneralizationSet}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.GeneralizationSet#getSpecializedClass <em>Specialized Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Specialized Via</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Specialized Via</em>' reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_IsSpecializedVia()
	 * @see net.menthor.metamodel.ontouml.GeneralizationSet#getSpecializedClass
	 * @model opposite="specializedClass" transient="true" ordered="false"
	 * @generated
	 */
	EList<GeneralizationSet> getIsSpecializedVia();

	/**
	 * Returns the value of the '<em><b>Specializes Via</b></em>' reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.GeneralizationSet}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.GeneralizationSet#getSpecializingClasses <em>Specializing Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specializes Via</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specializes Via</em>' reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_SpecializesVia()
	 * @see net.menthor.metamodel.ontouml.GeneralizationSet#getSpecializingClasses
	 * @model opposite="specializingClasses" transient="true" ordered="false"
	 * @generated
	 */
	EList<GeneralizationSet> getSpecializesVia();

	/**
	 * Returns the value of the '<em><b>Is Source Of</b></em>' reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.ClassBinaryRelationship}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Source Of</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Source Of</em>' reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_IsSourceOf()
	 * @see net.menthor.metamodel.ontouml.ClassBinaryRelationship#getSource
	 * @model opposite="source" transient="true" ordered="false"
	 * @generated
	 */
	EList<ClassBinaryRelationship> getIsSourceOf();

	/**
	 * Returns the value of the '<em><b>Is Target Of</b></em>' reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.ClassBinaryRelationship}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.ClassBinaryRelationship#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Target Of</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Target Of</em>' reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_IsTargetOf()
	 * @see net.menthor.metamodel.ontouml.ClassBinaryRelationship#getTarget
	 * @model opposite="target" transient="true" ordered="false"
	 * @generated
	 */
	EList<ClassBinaryRelationship> getIsTargetOf();

	/**
	 * Returns the value of the '<em><b>Is Truth Maker Of</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.MaterialRelationship#getIsDerivedFrom <em>Is Derived From</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Truth Maker Of</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Truth Maker Of</em>' reference.
	 * @see #setIsTruthMakerOf(MaterialRelationship)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getClass_IsTruthMakerOf()
	 * @see net.menthor.metamodel.ontouml.MaterialRelationship#getIsDerivedFrom
	 * @model opposite="isDerivedFrom"
	 * @generated
	 */
	MaterialRelationship getIsTruthMakerOf();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Class#getIsTruthMakerOf <em>Is Truth Maker Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Truth Maker Of</em>' reference.
	 * @see #getIsTruthMakerOf()
	 * @generated
	 */
	void setIsTruthMakerOf(MaterialRelationship value);

} // Class
