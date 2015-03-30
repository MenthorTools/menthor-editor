/**
 */
package net.menthor.metamodel.ontouml.impl;

import java.lang.reflect.InvocationTargetException;

import net.menthor.metamodel.ontouml.BinaryRelationship;
import net.menthor.metamodel.ontouml.EndPoint;
import net.menthor.metamodel.ontouml.OntoumlPackage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class BinaryRelationshipImpl extends RelationshipImpl implements BinaryRelationship {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OntoumlPackage.Literals.BINARY_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndPoint sourceEndPoint() {
		EList<EndPoint> _endPoints = this.getEndPoints();
		return _endPoints.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndPoint targetEndPoint() {
		EList<EndPoint> _endPoints = this.getEndPoints();
		return _endPoints.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDerived() {
		boolean _or = false;
		EndPoint _sourceEndPoint = this.sourceEndPoint();
		boolean _isIsDerived = _sourceEndPoint.isIsDerived();
		if (_isIsDerived) {
			_or = true;
		} else {
			EndPoint _targetEndPoint = this.targetEndPoint();
			boolean _isIsDerived_1 = _targetEndPoint.isIsDerived();
			_or = _isIsDerived_1;
		}
		return _or;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case OntoumlPackage.BINARY_RELATIONSHIP___SOURCE_END_POINT:
				return sourceEndPoint();
			case OntoumlPackage.BINARY_RELATIONSHIP___TARGET_END_POINT:
				return targetEndPoint();
			case OntoumlPackage.BINARY_RELATIONSHIP___IS_DERIVED:
				return isDerived();
		}
		return super.eInvoke(operationID, arguments);
	}

} //BinaryRelationshipImpl
