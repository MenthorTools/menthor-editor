/**
 */
package net.menthor.metamodel.ontouml.impl;

import java.lang.reflect.InvocationTargetException;

import net.menthor.metamodel.ontouml.BinaryClassRelationship;
import net.menthor.metamodel.ontouml.ClassifierElement;
import net.menthor.metamodel.ontouml.DerivationRelationship;
import net.menthor.metamodel.ontouml.EndPoint;
import net.menthor.metamodel.ontouml.OntoumlPackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Derivation Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DerivationRelationshipImpl extends BinaryRelationshipImpl implements DerivationRelationship {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DerivationRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OntoumlPackage.Literals.DERIVATION_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryClassRelationship sourceRelationship() {
		EList<EndPoint> _endPoints = this.getEndPoints();
		EndPoint _get = _endPoints.get(0);
		ClassifierElement _endType = _get.getEndType();
		if ((_endType instanceof BinaryClassRelationship)) {
			EList<EndPoint> _endPoints_1 = this.getEndPoints();
			EndPoint _get_1 = _endPoints_1.get(0);
			ClassifierElement _endType_1 = _get_1.getEndType();
			return ((BinaryClassRelationship) _endType_1);
		}
		else {
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class targetClass() {
		EList<EndPoint> _endPoints = this.getEndPoints();
		EndPoint _get = _endPoints.get(1);
		ClassifierElement _endType = _get.getEndType();
		if ((_endType instanceof net.menthor.metamodel.ontouml.Class)) {
			EList<EndPoint> _endPoints_1 = this.getEndPoints();
			EndPoint _get_1 = _endPoints_1.get(1);
			ClassifierElement _endType_1 = _get_1.getEndType();
			return ((net.menthor.metamodel.ontouml.Class) _endType_1);
		}
		else {
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case OntoumlPackage.DERIVATION_RELATIONSHIP___SOURCE_RELATIONSHIP:
				return sourceRelationship();
			case OntoumlPackage.DERIVATION_RELATIONSHIP___TARGET_CLASS:
				return targetClass();
		}
		return super.eInvoke(operationID, arguments);
	}

} //DerivationRelationshipImpl
