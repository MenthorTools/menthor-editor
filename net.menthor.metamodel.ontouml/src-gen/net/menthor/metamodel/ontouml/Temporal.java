/**
 */
package net.menthor.metamodel.ontouml;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Temporal</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getTemporal()
 * @model
 * @generated
 */
public enum Temporal implements Enumerator {
	/**
	 * The '<em><b>Starts</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STARTS_VALUE
	 * @generated
	 * @ordered
	 */
	STARTS(0, "Starts", "Starts"),

	/**
	 * The '<em><b>Precedes</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRECEDES_VALUE
	 * @generated
	 * @ordered
	 */
	PRECEDES(0, "Precedes", "Precedes"),

	/**
	 * The '<em><b>Equals</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EQUALS_VALUE
	 * @generated
	 * @ordered
	 */
	EQUALS(0, "Equals", "Equals"),

	/**
	 * The '<em><b>Meets</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEETS_VALUE
	 * @generated
	 * @ordered
	 */
	MEETS(0, "Meets", "Meets"),

	/**
	 * The '<em><b>Finishes</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FINISHES_VALUE
	 * @generated
	 * @ordered
	 */
	FINISHES(0, "Finishes", "Finishes"),

	/**
	 * The '<em><b>Overlaps</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERLAPS_VALUE
	 * @generated
	 * @ordered
	 */
	OVERLAPS(0, "Overlaps", "Overlaps"),

	/**
	 * The '<em><b>During</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DURING_VALUE
	 * @generated
	 * @ordered
	 */
	DURING(0, "During", "During");

	/**
	 * The '<em><b>Starts</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Starts</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STARTS
	 * @model name="Starts"
	 * @generated
	 * @ordered
	 */
	public static final int STARTS_VALUE = 0;

	/**
	 * The '<em><b>Precedes</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Precedes</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRECEDES
	 * @model name="Precedes"
	 * @generated
	 * @ordered
	 */
	public static final int PRECEDES_VALUE = 0;

	/**
	 * The '<em><b>Equals</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Equals</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EQUALS
	 * @model name="Equals"
	 * @generated
	 * @ordered
	 */
	public static final int EQUALS_VALUE = 0;

	/**
	 * The '<em><b>Meets</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Meets</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEETS
	 * @model name="Meets"
	 * @generated
	 * @ordered
	 */
	public static final int MEETS_VALUE = 0;

	/**
	 * The '<em><b>Finishes</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Finishes</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FINISHES
	 * @model name="Finishes"
	 * @generated
	 * @ordered
	 */
	public static final int FINISHES_VALUE = 0;

	/**
	 * The '<em><b>Overlaps</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Overlaps</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OVERLAPS
	 * @model name="Overlaps"
	 * @generated
	 * @ordered
	 */
	public static final int OVERLAPS_VALUE = 0;

	/**
	 * The '<em><b>During</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>During</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DURING
	 * @model name="During"
	 * @generated
	 * @ordered
	 */
	public static final int DURING_VALUE = 0;

	/**
	 * An array of all the '<em><b>Temporal</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Temporal[] VALUES_ARRAY =
		new Temporal[] {
			STARTS,
			PRECEDES,
			EQUALS,
			MEETS,
			FINISHES,
			OVERLAPS,
			DURING,
		};

	/**
	 * A public read-only list of all the '<em><b>Temporal</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Temporal> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Temporal</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Temporal get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Temporal result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Temporal</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Temporal getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Temporal result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Temporal</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Temporal get(int value) {
		switch (value) {
			case STARTS_VALUE: return STARTS;
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
	private Temporal(int value, String name, String literal) {
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
	
} //Temporal
