/**
 */
package net.menthor.metamodel.ontouml;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Symmetry</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getSymmetry()
 * @model
 * @generated
 */
public enum Symmetry implements Enumerator {
	/**
	 * The '<em><b>Symmetric</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYMMETRIC_VALUE
	 * @generated
	 * @ordered
	 */
	SYMMETRIC(0, "Symmetric", "Symmetric"),

	/**
	 * The '<em><b>Assymetric</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ASSYMETRIC_VALUE
	 * @generated
	 * @ordered
	 */
	ASSYMETRIC(0, "Assymetric", "Assymetric"),

	/**
	 * The '<em><b>Anti Symmetric</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANTI_SYMMETRIC_VALUE
	 * @generated
	 * @ordered
	 */
	ANTI_SYMMETRIC(0, "AntiSymmetric", "AntiSymmetric"),

	/**
	 * The '<em><b>Non Symmetric</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NON_SYMMETRIC_VALUE
	 * @generated
	 * @ordered
	 */
	NON_SYMMETRIC(0, "NonSymmetric", "NonSymmetric");

	/**
	 * The '<em><b>Symmetric</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Symmetric</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SYMMETRIC
	 * @model name="Symmetric"
	 * @generated
	 * @ordered
	 */
	public static final int SYMMETRIC_VALUE = 0;

	/**
	 * The '<em><b>Assymetric</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Assymetric</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ASSYMETRIC
	 * @model name="Assymetric"
	 * @generated
	 * @ordered
	 */
	public static final int ASSYMETRIC_VALUE = 0;

	/**
	 * The '<em><b>Anti Symmetric</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Anti Symmetric</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANTI_SYMMETRIC
	 * @model name="AntiSymmetric"
	 * @generated
	 * @ordered
	 */
	public static final int ANTI_SYMMETRIC_VALUE = 0;

	/**
	 * The '<em><b>Non Symmetric</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Non Symmetric</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NON_SYMMETRIC
	 * @model name="NonSymmetric"
	 * @generated
	 * @ordered
	 */
	public static final int NON_SYMMETRIC_VALUE = 0;

	/**
	 * An array of all the '<em><b>Symmetry</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Symmetry[] VALUES_ARRAY =
		new Symmetry[] {
			SYMMETRIC,
			ASSYMETRIC,
			ANTI_SYMMETRIC,
			NON_SYMMETRIC,
		};

	/**
	 * A public read-only list of all the '<em><b>Symmetry</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Symmetry> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Symmetry</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Symmetry get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Symmetry result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Symmetry</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Symmetry getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Symmetry result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Symmetry</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Symmetry get(int value) {
		switch (value) {
			case SYMMETRIC_VALUE: return SYMMETRIC;
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
	private Symmetry(int value, String name, String literal) {
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
	
} //Symmetry
