/**
 */
package net.menthor.metamodel.ontouml.impl;

import net.menthor.metamodel.ontouml.DataType;
import net.menthor.metamodel.ontouml.Literal;
import net.menthor.metamodel.ontouml.OntoumlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.LiteralImpl#getValue <em>Value</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.LiteralImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.LiteralImpl#getUpperBoundRegion <em>Upper Bound Region</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.LiteralImpl#getLowerBoundRegion <em>Lower Bound Region</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LiteralImpl extends ElementImpl implements Literal {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUpperBoundRegion() <em>Upper Bound Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperBoundRegion()
	 * @generated
	 * @ordered
	 */
	protected static final float UPPER_BOUND_REGION_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getUpperBoundRegion() <em>Upper Bound Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperBoundRegion()
	 * @generated
	 * @ordered
	 */
	protected float upperBoundRegion = UPPER_BOUND_REGION_EDEFAULT;

	/**
	 * The default value of the '{@link #getLowerBoundRegion() <em>Lower Bound Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerBoundRegion()
	 * @generated
	 * @ordered
	 */
	protected static final float LOWER_BOUND_REGION_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getLowerBoundRegion() <em>Lower Bound Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerBoundRegion()
	 * @generated
	 * @ordered
	 */
	protected float lowerBoundRegion = LOWER_BOUND_REGION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OntoumlPackage.Literals.LITERAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.LITERAL__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getOwner() {
		if (eContainerFeatureID() != OntoumlPackage.LITERAL__OWNER) return null;
		return (DataType)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetOwner() {
		if (eContainerFeatureID() != OntoumlPackage.LITERAL__OWNER) return null;
		return (DataType)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(DataType newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, OntoumlPackage.LITERAL__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(DataType newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != OntoumlPackage.LITERAL__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, OntoumlPackage.DATA_TYPE__LITERALS, DataType.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.LITERAL__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getUpperBoundRegion() {
		return upperBoundRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperBoundRegion(float newUpperBoundRegion) {
		float oldUpperBoundRegion = upperBoundRegion;
		upperBoundRegion = newUpperBoundRegion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.LITERAL__UPPER_BOUND_REGION, oldUpperBoundRegion, upperBoundRegion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLowerBoundRegion() {
		return lowerBoundRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerBoundRegion(float newLowerBoundRegion) {
		float oldLowerBoundRegion = lowerBoundRegion;
		lowerBoundRegion = newLowerBoundRegion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.LITERAL__LOWER_BOUND_REGION, oldLowerBoundRegion, lowerBoundRegion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OntoumlPackage.LITERAL__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((DataType)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OntoumlPackage.LITERAL__OWNER:
				return basicSetOwner(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case OntoumlPackage.LITERAL__OWNER:
				return eInternalContainer().eInverseRemove(this, OntoumlPackage.DATA_TYPE__LITERALS, DataType.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OntoumlPackage.LITERAL__VALUE:
				return getValue();
			case OntoumlPackage.LITERAL__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case OntoumlPackage.LITERAL__UPPER_BOUND_REGION:
				return getUpperBoundRegion();
			case OntoumlPackage.LITERAL__LOWER_BOUND_REGION:
				return getLowerBoundRegion();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OntoumlPackage.LITERAL__VALUE:
				setValue((String)newValue);
				return;
			case OntoumlPackage.LITERAL__OWNER:
				setOwner((DataType)newValue);
				return;
			case OntoumlPackage.LITERAL__UPPER_BOUND_REGION:
				setUpperBoundRegion((Float)newValue);
				return;
			case OntoumlPackage.LITERAL__LOWER_BOUND_REGION:
				setLowerBoundRegion((Float)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case OntoumlPackage.LITERAL__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case OntoumlPackage.LITERAL__OWNER:
				setOwner((DataType)null);
				return;
			case OntoumlPackage.LITERAL__UPPER_BOUND_REGION:
				setUpperBoundRegion(UPPER_BOUND_REGION_EDEFAULT);
				return;
			case OntoumlPackage.LITERAL__LOWER_BOUND_REGION:
				setLowerBoundRegion(LOWER_BOUND_REGION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case OntoumlPackage.LITERAL__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case OntoumlPackage.LITERAL__OWNER:
				return basicGetOwner() != null;
			case OntoumlPackage.LITERAL__UPPER_BOUND_REGION:
				return upperBoundRegion != UPPER_BOUND_REGION_EDEFAULT;
			case OntoumlPackage.LITERAL__LOWER_BOUND_REGION:
				return lowerBoundRegion != LOWER_BOUND_REGION_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (value: ");
		result.append(value);
		result.append(", upperBoundRegion: ");
		result.append(upperBoundRegion);
		result.append(", lowerBoundRegion: ");
		result.append(lowerBoundRegion);
		result.append(')');
		return result.toString();
	}

} //LiteralImpl
