/**
 */
package net.menthor.metamodel.ontouml.impl;

import com.google.common.base.Objects;

import java.lang.reflect.InvocationTargetException;

import net.menthor.metamodel.ontouml.Dimension;
import net.menthor.metamodel.ontouml.Domain;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.Primitive;
import net.menthor.metamodel.ontouml.Region;
import net.menthor.metamodel.ontouml.Scale;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dimension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.DimensionImpl#getOwnerDomain <em>Owner Domain</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.DimensionImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.DimensionImpl#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.DimensionImpl#getUnitOfMeasure <em>Unit Of Measure</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.DimensionImpl#getScale <em>Scale</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.DimensionImpl#getMeasure <em>Measure</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DimensionImpl extends StructureImpl implements Dimension {
	/**
	 * The cached value of the '{@link #getOwnerDomain() <em>Owner Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnerDomain()
	 * @generated
	 * @ordered
	 */
	protected Domain ownerDomain;

	/**
	 * The cached value of the '{@link #getLowerBound() <em>Lower Bound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerBound()
	 * @generated
	 * @ordered
	 */
	protected Region lowerBound;

	/**
	 * The cached value of the '{@link #getUpperBound() <em>Upper Bound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperBound()
	 * @generated
	 * @ordered
	 */
	protected Region upperBound;

	/**
	 * The default value of the '{@link #getUnitOfMeasure() <em>Unit Of Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitOfMeasure()
	 * @generated
	 * @ordered
	 */
	protected static final String UNIT_OF_MEASURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnitOfMeasure() <em>Unit Of Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitOfMeasure()
	 * @generated
	 * @ordered
	 */
	protected String unitOfMeasure = UNIT_OF_MEASURE_EDEFAULT;

	/**
	 * The default value of the '{@link #getScale() <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScale()
	 * @generated
	 * @ordered
	 */
	protected static final Scale SCALE_EDEFAULT = Scale.INTERVAL;

	/**
	 * The cached value of the '{@link #getScale() <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScale()
	 * @generated
	 * @ordered
	 */
	protected Scale scale = SCALE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMeasure() <em>Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasure()
	 * @generated
	 * @ordered
	 */
	protected static final Primitive MEASURE_EDEFAULT = Primitive.BOOLEAN;

	/**
	 * The cached value of the '{@link #getMeasure() <em>Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasure()
	 * @generated
	 * @ordered
	 */
	protected Primitive measure = MEASURE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DimensionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OntoumlPackage.Literals.DIMENSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain getOwnerDomain() {
		if (ownerDomain != null && ownerDomain.eIsProxy()) {
			InternalEObject oldOwnerDomain = (InternalEObject)ownerDomain;
			ownerDomain = (Domain)eResolveProxy(oldOwnerDomain);
			if (ownerDomain != oldOwnerDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.DIMENSION__OWNER_DOMAIN, oldOwnerDomain, ownerDomain));
			}
		}
		return ownerDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain basicGetOwnerDomain() {
		return ownerDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnerDomain(Domain newOwnerDomain, NotificationChain msgs) {
		Domain oldOwnerDomain = ownerDomain;
		ownerDomain = newOwnerDomain;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OntoumlPackage.DIMENSION__OWNER_DOMAIN, oldOwnerDomain, newOwnerDomain);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnerDomain(Domain newOwnerDomain) {
		if (newOwnerDomain != ownerDomain) {
			NotificationChain msgs = null;
			if (ownerDomain != null)
				msgs = ((InternalEObject)ownerDomain).eInverseRemove(this, OntoumlPackage.DOMAIN__DIMENSIONS, Domain.class, msgs);
			if (newOwnerDomain != null)
				msgs = ((InternalEObject)newOwnerDomain).eInverseAdd(this, OntoumlPackage.DOMAIN__DIMENSIONS, Domain.class, msgs);
			msgs = basicSetOwnerDomain(newOwnerDomain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.DIMENSION__OWNER_DOMAIN, newOwnerDomain, newOwnerDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Region getLowerBound() {
		if (lowerBound != null && lowerBound.eIsProxy()) {
			InternalEObject oldLowerBound = (InternalEObject)lowerBound;
			lowerBound = (Region)eResolveProxy(oldLowerBound);
			if (lowerBound != oldLowerBound) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.DIMENSION__LOWER_BOUND, oldLowerBound, lowerBound));
			}
		}
		return lowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Region basicGetLowerBound() {
		return lowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerBound(Region newLowerBound) {
		Region oldLowerBound = lowerBound;
		lowerBound = newLowerBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.DIMENSION__LOWER_BOUND, oldLowerBound, lowerBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Region getUpperBound() {
		if (upperBound != null && upperBound.eIsProxy()) {
			InternalEObject oldUpperBound = (InternalEObject)upperBound;
			upperBound = (Region)eResolveProxy(oldUpperBound);
			if (upperBound != oldUpperBound) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.DIMENSION__UPPER_BOUND, oldUpperBound, upperBound));
			}
		}
		return upperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Region basicGetUpperBound() {
		return upperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperBound(Region newUpperBound) {
		Region oldUpperBound = upperBound;
		upperBound = newUpperBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.DIMENSION__UPPER_BOUND, oldUpperBound, upperBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitOfMeasure(String newUnitOfMeasure) {
		String oldUnitOfMeasure = unitOfMeasure;
		unitOfMeasure = newUnitOfMeasure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.DIMENSION__UNIT_OF_MEASURE, oldUnitOfMeasure, unitOfMeasure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scale getScale() {
		return scale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScale(Scale newScale) {
		Scale oldScale = scale;
		scale = newScale == null ? SCALE_EDEFAULT : newScale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.DIMENSION__SCALE, oldScale, scale));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Primitive getMeasure() {
		return measure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasure(Primitive newMeasure) {
		Primitive oldMeasure = measure;
		measure = newMeasure == null ? MEASURE_EDEFAULT : newMeasure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.DIMENSION__MEASURE, oldMeasure, measure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNominal() {
		boolean _and = false;
		Scale _scale = this.getScale();
		boolean _notEquals = (!Objects.equal(_scale, null));
		if (!_notEquals) {
			_and = false;
		} else {
			Scale _scale_1 = this.getScale();
			boolean _equals = Objects.equal(_scale_1, Scale.NOMINAL);
			_and = _equals;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInterval() {
		boolean _and = false;
		Scale _scale = this.getScale();
		boolean _notEquals = (!Objects.equal(_scale, null));
		if (!_notEquals) {
			_and = false;
		} else {
			Scale _scale_1 = this.getScale();
			boolean _equals = Objects.equal(_scale_1, Scale.INTERVAL);
			_and = _equals;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOrdinal() {
		boolean _and = false;
		Scale _scale = this.getScale();
		boolean _notEquals = (!Objects.equal(_scale, null));
		if (!_notEquals) {
			_and = false;
		} else {
			Scale _scale_1 = this.getScale();
			boolean _equals = Objects.equal(_scale_1, Scale.ORDINAL);
			_and = _equals;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRational() {
		boolean _and = false;
		Scale _scale = this.getScale();
		boolean _notEquals = (!Objects.equal(_scale, null));
		if (!_notEquals) {
			_and = false;
		} else {
			Scale _scale_1 = this.getScale();
			boolean _equals = Objects.equal(_scale_1, Scale.RATIONAL);
			_and = _equals;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isString() {
		boolean _and = false;
		Primitive _measure = this.getMeasure();
		boolean _notEquals = (!Objects.equal(_measure, null));
		if (!_notEquals) {
			_and = false;
		} else {
			Primitive _measure_1 = this.getMeasure();
			boolean _equals = Objects.equal(_measure_1, Primitive.STRING);
			_and = _equals;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInteger() {
		boolean _and = false;
		Primitive _measure = this.getMeasure();
		boolean _notEquals = (!Objects.equal(_measure, null));
		if (!_notEquals) {
			_and = false;
		} else {
			Primitive _measure_1 = this.getMeasure();
			boolean _equals = Objects.equal(_measure_1, Primitive.INTEGER);
			_and = _equals;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDecimal() {
		boolean _and = false;
		Primitive _measure = this.getMeasure();
		boolean _notEquals = (!Objects.equal(_measure, null));
		if (!_notEquals) {
			_and = false;
		} else {
			Primitive _measure_1 = this.getMeasure();
			boolean _equals = Objects.equal(_measure_1, Primitive.DECIMAL);
			_and = _equals;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNominalString() {
		boolean _and = false;
		boolean _isNominal = this.isNominal();
		if (!_isNominal) {
			_and = false;
		} else {
			boolean _isString = this.isString();
			_and = _isString;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIntervalInteger() {
		boolean _and = false;
		boolean _isInterval = this.isInterval();
		if (!_isInterval) {
			_and = false;
		} else {
			boolean _isInteger = this.isInteger();
			_and = _isInteger;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIntervalDecimal() {
		boolean _and = false;
		boolean _isInterval = this.isInterval();
		if (!_isInterval) {
			_and = false;
		} else {
			boolean _isDecimal = this.isDecimal();
			_and = _isDecimal;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOrdinalInteger() {
		boolean _and = false;
		boolean _isOrdinal = this.isOrdinal();
		if (!_isOrdinal) {
			_and = false;
		} else {
			boolean _isInteger = this.isInteger();
			_and = _isInteger;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOrdinalDecimal() {
		boolean _and = false;
		boolean _isOrdinal = this.isOrdinal();
		if (!_isOrdinal) {
			_and = false;
		} else {
			boolean _isDecimal = this.isDecimal();
			_and = _isDecimal;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRationalInteger() {
		boolean _and = false;
		boolean _isRational = this.isRational();
		if (!_isRational) {
			_and = false;
		} else {
			boolean _isInteger = this.isInteger();
			_and = _isInteger;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRationalDecimal() {
		boolean _and = false;
		boolean _isRational = this.isRational();
		if (!_isRational) {
			_and = false;
		} else {
			boolean _isDecimal = this.isDecimal();
			_and = _isDecimal;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OntoumlPackage.DIMENSION__OWNER_DOMAIN:
				if (ownerDomain != null)
					msgs = ((InternalEObject)ownerDomain).eInverseRemove(this, OntoumlPackage.DOMAIN__DIMENSIONS, Domain.class, msgs);
				return basicSetOwnerDomain((Domain)otherEnd, msgs);
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
			case OntoumlPackage.DIMENSION__OWNER_DOMAIN:
				return basicSetOwnerDomain(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OntoumlPackage.DIMENSION__OWNER_DOMAIN:
				if (resolve) return getOwnerDomain();
				return basicGetOwnerDomain();
			case OntoumlPackage.DIMENSION__LOWER_BOUND:
				if (resolve) return getLowerBound();
				return basicGetLowerBound();
			case OntoumlPackage.DIMENSION__UPPER_BOUND:
				if (resolve) return getUpperBound();
				return basicGetUpperBound();
			case OntoumlPackage.DIMENSION__UNIT_OF_MEASURE:
				return getUnitOfMeasure();
			case OntoumlPackage.DIMENSION__SCALE:
				return getScale();
			case OntoumlPackage.DIMENSION__MEASURE:
				return getMeasure();
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
			case OntoumlPackage.DIMENSION__OWNER_DOMAIN:
				setOwnerDomain((Domain)newValue);
				return;
			case OntoumlPackage.DIMENSION__LOWER_BOUND:
				setLowerBound((Region)newValue);
				return;
			case OntoumlPackage.DIMENSION__UPPER_BOUND:
				setUpperBound((Region)newValue);
				return;
			case OntoumlPackage.DIMENSION__UNIT_OF_MEASURE:
				setUnitOfMeasure((String)newValue);
				return;
			case OntoumlPackage.DIMENSION__SCALE:
				setScale((Scale)newValue);
				return;
			case OntoumlPackage.DIMENSION__MEASURE:
				setMeasure((Primitive)newValue);
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
			case OntoumlPackage.DIMENSION__OWNER_DOMAIN:
				setOwnerDomain((Domain)null);
				return;
			case OntoumlPackage.DIMENSION__LOWER_BOUND:
				setLowerBound((Region)null);
				return;
			case OntoumlPackage.DIMENSION__UPPER_BOUND:
				setUpperBound((Region)null);
				return;
			case OntoumlPackage.DIMENSION__UNIT_OF_MEASURE:
				setUnitOfMeasure(UNIT_OF_MEASURE_EDEFAULT);
				return;
			case OntoumlPackage.DIMENSION__SCALE:
				setScale(SCALE_EDEFAULT);
				return;
			case OntoumlPackage.DIMENSION__MEASURE:
				setMeasure(MEASURE_EDEFAULT);
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
			case OntoumlPackage.DIMENSION__OWNER_DOMAIN:
				return ownerDomain != null;
			case OntoumlPackage.DIMENSION__LOWER_BOUND:
				return lowerBound != null;
			case OntoumlPackage.DIMENSION__UPPER_BOUND:
				return upperBound != null;
			case OntoumlPackage.DIMENSION__UNIT_OF_MEASURE:
				return UNIT_OF_MEASURE_EDEFAULT == null ? unitOfMeasure != null : !UNIT_OF_MEASURE_EDEFAULT.equals(unitOfMeasure);
			case OntoumlPackage.DIMENSION__SCALE:
				return scale != SCALE_EDEFAULT;
			case OntoumlPackage.DIMENSION__MEASURE:
				return measure != MEASURE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case OntoumlPackage.DIMENSION___IS_NOMINAL:
				return isNominal();
			case OntoumlPackage.DIMENSION___IS_INTERVAL:
				return isInterval();
			case OntoumlPackage.DIMENSION___IS_ORDINAL:
				return isOrdinal();
			case OntoumlPackage.DIMENSION___IS_RATIONAL:
				return isRational();
			case OntoumlPackage.DIMENSION___IS_STRING:
				return isString();
			case OntoumlPackage.DIMENSION___IS_INTEGER:
				return isInteger();
			case OntoumlPackage.DIMENSION___IS_DECIMAL:
				return isDecimal();
			case OntoumlPackage.DIMENSION___IS_NOMINAL_STRING:
				return isNominalString();
			case OntoumlPackage.DIMENSION___IS_INTERVAL_INTEGER:
				return isIntervalInteger();
			case OntoumlPackage.DIMENSION___IS_INTERVAL_DECIMAL:
				return isIntervalDecimal();
			case OntoumlPackage.DIMENSION___IS_ORDINAL_INTEGER:
				return isOrdinalInteger();
			case OntoumlPackage.DIMENSION___IS_ORDINAL_DECIMAL:
				return isOrdinalDecimal();
			case OntoumlPackage.DIMENSION___IS_RATIONAL_INTEGER:
				return isRationalInteger();
			case OntoumlPackage.DIMENSION___IS_RATIONAL_DECIMAL:
				return isRationalDecimal();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(" (unitOfMeasure: ");
		result.append(unitOfMeasure);
		result.append(", scale: ");
		result.append(scale);
		result.append(", measure: ");
		result.append(measure);
		result.append(')');
		return result.toString();
	}

} //DimensionImpl
