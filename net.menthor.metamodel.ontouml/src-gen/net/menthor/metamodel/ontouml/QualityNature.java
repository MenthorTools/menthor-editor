/**
 */
package net.menthor.metamodel.ontouml;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Quality Nature</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getQualityNature()
 * @model
 * @generated
 */
public enum QualityNature implements Enumerator {
	/**
	 * The '<em><b>Nominal</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOMINAL_VALUE
	 * @generated
	 * @ordered
	 */
	NOMINAL(0, "Nominal", "Nominal"),

	/**
	 * The '<em><b>Perceivable</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PERCEIVABLE_VALUE
	 * @generated
	 * @ordered
	 */
	PERCEIVABLE(0, "Perceivable", "Perceivable"),

	/**
	 * The '<em><b>Non Perceivable</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NON_PERCEIVABLE_VALUE
	 * @generated
	 * @ordered
	 */
	NON_PERCEIVABLE(0, "NonPerceivable", "NonPerceivable");

	/**
	 * The '<em><b>Nominal</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Nominal</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOMINAL
	 * @model name="Nominal"
	 * @generated
	 * @ordered
	 */
	public static final int NOMINAL_VALUE = 0;

	/**
	 * The '<em><b>Perceivable</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Perceivable</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PERCEIVABLE
	 * @model name="Perceivable"
	 * @generated
	 * @ordered
	 */
	public static final int PERCEIVABLE_VALUE = 0;

	/**
	 * The '<em><b>Non Perceivable</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Non Perceivable</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NON_PERCEIVABLE
	 * @model name="NonPerceivable"
	 * @generated
	 * @ordered
	 */
	public static final int NON_PERCEIVABLE_VALUE = 0;

	/**
	 * An array of all the '<em><b>Quality Nature</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final QualityNature[] VALUES_ARRAY =
		new QualityNature[] {
			NOMINAL,
			PERCEIVABLE,
			NON_PERCEIVABLE,
		};

	/**
	 * A public read-only list of all the '<em><b>Quality Nature</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<QualityNature> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Quality Nature</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QualityNature get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			QualityNature result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Quality Nature</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QualityNature getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			QualityNature result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Quality Nature</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QualityNature get(int value) {
		switch (value) {
			case NOMINAL_VALUE: return NOMINAL;
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
	private QualityNature(int value, String name, String literal) {
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
	
} //QualityNature
