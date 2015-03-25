/**
 */
package net.menthor.metamodel.ontouml;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Relation</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getRelation()
 * @model
 * @generated
 */
public enum Relation implements Enumerator {
	/**
	 * The '<em><b>Component Of</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMPONENT_OF_VALUE
	 * @generated
	 * @ordered
	 */
	COMPONENT_OF(0, "ComponentOf", "componentOf"),

	/**
	 * The '<em><b>Membership</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEMBERSHIP_VALUE
	 * @generated
	 * @ordered
	 */
	MEMBERSHIP(0, "Membership", "memberOf"),

	/**
	 * The '<em><b>Sub Collection</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUB_COLLECTION_VALUE
	 * @generated
	 * @ordered
	 */
	SUB_COLLECTION(0, "SubCollection", "subCollectionOf"),

	/**
	 * The '<em><b>Sub Quantity</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUB_QUANTITY_VALUE
	 * @generated
	 * @ordered
	 */
	SUB_QUANTITY(0, "SubQuantity", "subQuantityOf"),

	/**
	 * The '<em><b>Characterization</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHARACTERIZATION_VALUE
	 * @generated
	 * @ordered
	 */
	CHARACTERIZATION(0, "Characterization", "characterization"),

	/**
	 * The '<em><b>Mediation</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEDIATION_VALUE
	 * @generated
	 * @ordered
	 */
	MEDIATION(0, "Mediation", "mediation"),

	/**
	 * The '<em><b>Material</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MATERIAL_VALUE
	 * @generated
	 * @ordered
	 */
	MATERIAL(0, "Material", "material"),

	/**
	 * The '<em><b>Formal</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FORMAL_VALUE
	 * @generated
	 * @ordered
	 */
	FORMAL(0, "Formal", "formal");

	/**
	 * The '<em><b>Component Of</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Component Of</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMPONENT_OF
	 * @model name="ComponentOf" literal="componentOf"
	 * @generated
	 * @ordered
	 */
	public static final int COMPONENT_OF_VALUE = 0;

	/**
	 * The '<em><b>Membership</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Membership</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEMBERSHIP
	 * @model name="Membership" literal="memberOf"
	 * @generated
	 * @ordered
	 */
	public static final int MEMBERSHIP_VALUE = 0;

	/**
	 * The '<em><b>Sub Collection</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sub Collection</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUB_COLLECTION
	 * @model name="SubCollection" literal="subCollectionOf"
	 * @generated
	 * @ordered
	 */
	public static final int SUB_COLLECTION_VALUE = 0;

	/**
	 * The '<em><b>Sub Quantity</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sub Quantity</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUB_QUANTITY
	 * @model name="SubQuantity" literal="subQuantityOf"
	 * @generated
	 * @ordered
	 */
	public static final int SUB_QUANTITY_VALUE = 0;

	/**
	 * The '<em><b>Characterization</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Characterization</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHARACTERIZATION
	 * @model name="Characterization" literal="characterization"
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
	 * @model name="Mediation" literal="mediation"
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
	 * @model name="Material" literal="material"
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
	 * @model name="Formal" literal="formal"
	 * @generated
	 * @ordered
	 */
	public static final int FORMAL_VALUE = 0;

	/**
	 * An array of all the '<em><b>Relation</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Relation[] VALUES_ARRAY =
		new Relation[] {
			COMPONENT_OF,
			MEMBERSHIP,
			SUB_COLLECTION,
			SUB_QUANTITY,
			CHARACTERIZATION,
			MEDIATION,
			MATERIAL,
			FORMAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Relation</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Relation> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Relation</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Relation get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Relation result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Relation</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Relation getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Relation result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Relation</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Relation get(int value) {
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
	private Relation(int value, String name, String literal) {
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
	
} //Relation
