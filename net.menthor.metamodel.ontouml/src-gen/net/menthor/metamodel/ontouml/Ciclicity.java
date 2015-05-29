/**
 */
package net.menthor.metamodel.ontouml;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Ciclicity</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getCiclicity()
 * @model
 * @generated
 */
public enum Ciclicity implements Enumerator {
	/**
	 * The '<em><b>Cyclic</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CYCLIC_VALUE
	 * @generated
	 * @ordered
	 */
	CYCLIC(0, "Cyclic", "Cyclic"),

	/**
	 * The '<em><b>Acyclic</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACYCLIC_VALUE
	 * @generated
	 * @ordered
	 */
	ACYCLIC(0, "Acyclic", "Acyclic"),

	/**
	 * The '<em><b>Non Cyclic</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NON_CYCLIC_VALUE
	 * @generated
	 * @ordered
	 */
	NON_CYCLIC(0, "NonCyclic", "NonCyclic");

	/**
	 * The '<em><b>Cyclic</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Cyclic</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CYCLIC
	 * @model name="Cyclic"
	 * @generated
	 * @ordered
	 */
	public static final int CYCLIC_VALUE = 0;

	/**
	 * The '<em><b>Acyclic</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Acyclic</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACYCLIC
	 * @model name="Acyclic"
	 * @generated
	 * @ordered
	 */
	public static final int ACYCLIC_VALUE = 0;

	/**
	 * The '<em><b>Non Cyclic</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Non Cyclic</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NON_CYCLIC
	 * @model name="NonCyclic"
	 * @generated
	 * @ordered
	 */
	public static final int NON_CYCLIC_VALUE = 0;

	/**
	 * An array of all the '<em><b>Ciclicity</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Ciclicity[] VALUES_ARRAY =
		new Ciclicity[] {
			CYCLIC,
			ACYCLIC,
			NON_CYCLIC,
		};

	/**
	 * A public read-only list of all the '<em><b>Ciclicity</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Ciclicity> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Ciclicity</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Ciclicity get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Ciclicity result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ciclicity</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Ciclicity getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Ciclicity result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Ciclicity</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Ciclicity get(int value) {
		switch (value) {
			case CYCLIC_VALUE: return CYCLIC;
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
	private Ciclicity(int value, String name, String literal) {
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
	
} //Ciclicity
