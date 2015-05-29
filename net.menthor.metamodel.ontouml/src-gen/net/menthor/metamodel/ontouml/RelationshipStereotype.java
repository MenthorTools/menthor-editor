/**
 */
package net.menthor.metamodel.ontouml;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Relationship Stereotype</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * * =========================================
 *  Relationship Stereotype
 *  ========================================
 * <!-- end-model-doc -->
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getRelationshipStereotype()
 * @model
 * @generated
 */
public enum RelationshipStereotype implements Enumerator {
	/**
	 * The '<em><b>Component Of</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPONENT_OF_VALUE
	 * @generated
	 * @ordered
	 */
	COMPONENT_OF(0, "ComponentOf", "ComponentOf"),

	/**
	 * The '<em><b>Member Of</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEMBER_OF_VALUE
	 * @generated
	 * @ordered
	 */
	MEMBER_OF(0, "MemberOf", "MemberOf"),

	/**
	 * The '<em><b>Sub Collection Of</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUB_COLLECTION_OF_VALUE
	 * @generated
	 * @ordered
	 */
	SUB_COLLECTION_OF(0, "SubCollectionOf", "SubCollectionOf"),

	/**
	 * The '<em><b>Sub Quantity Of</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUB_QUANTITY_OF_VALUE
	 * @generated
	 * @ordered
	 */
	SUB_QUANTITY_OF(0, "SubQuantityOf", "SubQuantityOf"),

	/**
	 * The '<em><b>Constitution</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONSTITUTION_VALUE
	 * @generated
	 * @ordered
	 */
	CONSTITUTION(0, "Constitution", "Constitution"),

	/**
	 * The '<em><b>Characterization</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHARACTERIZATION_VALUE
	 * @generated
	 * @ordered
	 */
	CHARACTERIZATION(0, "Characterization", "Characterization"),

	/**
	 * The '<em><b>Mediation</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEDIATION_VALUE
	 * @generated
	 * @ordered
	 */
	MEDIATION(0, "Mediation", "Mediation"),

	/**
	 * The '<em><b>Material</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MATERIAL_VALUE
	 * @generated
	 * @ordered
	 */
	MATERIAL(0, "Material", "Material"),

	/**
	 * The '<em><b>Formal</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FORMAL_VALUE
	 * @generated
	 * @ordered
	 */
	FORMAL(0, "Formal", "Formal"),

	/**
	 * The '<em><b>Derivation</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DERIVATION_VALUE
	 * @generated
	 * @ordered
	 */
	DERIVATION(0, "Derivation", "Derivation"),

	/**
	 * The '<em><b>Structuration</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRUCTURATION_VALUE
	 * @generated
	 * @ordered
	 */
	STRUCTURATION(0, "Structuration", "Structuration"),

	/**
	 * The '<em><b>Participation</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PARTICIPATION_VALUE
	 * @generated
	 * @ordered
	 */
	PARTICIPATION(0, "Participation", "Participation"),

	/**
	 * The '<em><b>Sub Event Of</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUB_EVENT_OF_VALUE
	 * @generated
	 * @ordered
	 */
	SUB_EVENT_OF(0, "SubEventOf", "SubEventOf"),

	/**
	 * The '<em><b>Causation</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CAUSATION_VALUE
	 * @generated
	 * @ordered
	 */
	CAUSATION(0, "Causation", "Causation"),

	/**
	 * The '<em><b>Temporal</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEMPORAL_VALUE
	 * @generated
	 * @ordered
	 */
	TEMPORAL(0, "Temporal", "Temporal"),

	/**
	 * The '<em><b>Instance Of</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INSTANCE_OF_VALUE
	 * @generated
	 * @ordered
	 */
	INSTANCE_OF(0, "InstanceOf", "InstanceOf");

	/**
	 * The '<em><b>Component Of</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Component Of</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMPONENT_OF
	 * @model name="ComponentOf"
	 * @generated
	 * @ordered
	 */
	public static final int COMPONENT_OF_VALUE = 0;

	/**
	 * The '<em><b>Member Of</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Member Of</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEMBER_OF
	 * @model name="MemberOf"
	 * @generated
	 * @ordered
	 */
	public static final int MEMBER_OF_VALUE = 0;

	/**
	 * The '<em><b>Sub Collection Of</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sub Collection Of</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUB_COLLECTION_OF
	 * @model name="SubCollectionOf"
	 * @generated
	 * @ordered
	 */
	public static final int SUB_COLLECTION_OF_VALUE = 0;

	/**
	 * The '<em><b>Sub Quantity Of</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sub Quantity Of</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUB_QUANTITY_OF
	 * @model name="SubQuantityOf"
	 * @generated
	 * @ordered
	 */
	public static final int SUB_QUANTITY_OF_VALUE = 0;

	/**
	 * The '<em><b>Constitution</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Constitution</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONSTITUTION
	 * @model name="Constitution"
	 * @generated
	 * @ordered
	 */
	public static final int CONSTITUTION_VALUE = 0;

	/**
	 * The '<em><b>Characterization</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Characterization</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHARACTERIZATION
	 * @model name="Characterization"
	 * @generated
	 * @ordered
	 */
	public static final int CHARACTERIZATION_VALUE = 0;

	/**
	 * The '<em><b>Mediation</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mediation</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEDIATION
	 * @model name="Mediation"
	 * @generated
	 * @ordered
	 */
	public static final int MEDIATION_VALUE = 0;

	/**
	 * The '<em><b>Material</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Material</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MATERIAL
	 * @model name="Material"
	 * @generated
	 * @ordered
	 */
	public static final int MATERIAL_VALUE = 0;

	/**
	 * The '<em><b>Formal</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Formal</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FORMAL
	 * @model name="Formal"
	 * @generated
	 * @ordered
	 */
	public static final int FORMAL_VALUE = 0;

	/**
	 * The '<em><b>Derivation</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Derivation</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DERIVATION
	 * @model name="Derivation"
	 * @generated
	 * @ordered
	 */
	public static final int DERIVATION_VALUE = 0;

	/**
	 * The '<em><b>Structuration</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Structuration</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STRUCTURATION
	 * @model name="Structuration"
	 * @generated
	 * @ordered
	 */
	public static final int STRUCTURATION_VALUE = 0;

	/**
	 * The '<em><b>Participation</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Participation</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PARTICIPATION
	 * @model name="Participation"
	 * @generated
	 * @ordered
	 */
	public static final int PARTICIPATION_VALUE = 0;

	/**
	 * The '<em><b>Sub Event Of</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sub Event Of</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUB_EVENT_OF
	 * @model name="SubEventOf"
	 * @generated
	 * @ordered
	 */
	public static final int SUB_EVENT_OF_VALUE = 0;

	/**
	 * The '<em><b>Causation</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Causation</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CAUSATION
	 * @model name="Causation"
	 * @generated
	 * @ordered
	 */
	public static final int CAUSATION_VALUE = 0;

	/**
	 * The '<em><b>Temporal</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Temporal</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TEMPORAL
	 * @model name="Temporal"
	 * @generated
	 * @ordered
	 */
	public static final int TEMPORAL_VALUE = 0;

	/**
	 * The '<em><b>Instance Of</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Instance Of</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INSTANCE_OF
	 * @model name="InstanceOf"
	 * @generated
	 * @ordered
	 */
	public static final int INSTANCE_OF_VALUE = 0;

	/**
	 * An array of all the '<em><b>Relationship Stereotype</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final RelationshipStereotype[] VALUES_ARRAY =
		new RelationshipStereotype[] {
			COMPONENT_OF,
			MEMBER_OF,
			SUB_COLLECTION_OF,
			SUB_QUANTITY_OF,
			CONSTITUTION,
			CHARACTERIZATION,
			MEDIATION,
			MATERIAL,
			FORMAL,
			DERIVATION,
			STRUCTURATION,
			PARTICIPATION,
			SUB_EVENT_OF,
			CAUSATION,
			TEMPORAL,
			INSTANCE_OF,
		};

	/**
	 * A public read-only list of all the '<em><b>Relationship Stereotype</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<RelationshipStereotype> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Relationship Stereotype</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RelationshipStereotype get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RelationshipStereotype result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Relationship Stereotype</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RelationshipStereotype getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RelationshipStereotype result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Relationship Stereotype</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RelationshipStereotype get(int value) {
		switch (value) {
			case COMPONENT_OF_VALUE: return COMPONENT_OF;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private RelationshipStereotype(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //RelationshipStereotype
