/**
 */
package net.menthor.metamodel.ontouml.impl;

import com.google.common.base.Objects;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import net.menthor.metamodel.ontouml.Literal;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.Primitive;
import net.menthor.metamodel.ontouml.Region;
import net.menthor.metamodel.ontouml.Structure;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Region</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RegionImpl#getOwnerStructure <em>Owner Structure</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RegionImpl#getGroundedLiteral <em>Grounded Literal</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RegionImpl#getComposedBy <em>Composed By</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RegionImpl#getBasicType <em>Basic Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegionImpl extends TypeImpl implements Region {
	/**
	 * The cached value of the '{@link #getOwnerStructure() <em>Owner Structure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnerStructure()
	 * @generated
	 * @ordered
	 */
	protected Structure ownerStructure;

	/**
	 * The cached value of the '{@link #getGroundedLiteral() <em>Grounded Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroundedLiteral()
	 * @generated
	 * @ordered
	 */
	protected Literal groundedLiteral;

	/**
	 * The cached value of the '{@link #getComposedBy() <em>Composed By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComposedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<Region> composedBy;

	/**
	 * The default value of the '{@link #getBasicType() <em>Basic Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasicType()
	 * @generated
	 * @ordered
	 */
	protected static final Primitive BASIC_TYPE_EDEFAULT = Primitive.BOOLEAN;

	/**
	 * The cached value of the '{@link #getBasicType() <em>Basic Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasicType()
	 * @generated
	 * @ordered
	 */
	protected Primitive basicType = BASIC_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OntoumlPackage.Literals.REGION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Structure getOwnerStructure() {
		if (ownerStructure != null && ownerStructure.eIsProxy()) {
			InternalEObject oldOwnerStructure = (InternalEObject)ownerStructure;
			ownerStructure = (Structure)eResolveProxy(oldOwnerStructure);
			if (ownerStructure != oldOwnerStructure) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.REGION__OWNER_STRUCTURE, oldOwnerStructure, ownerStructure));
			}
		}
		return ownerStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Structure basicGetOwnerStructure() {
		return ownerStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnerStructure(Structure newOwnerStructure, NotificationChain msgs) {
		Structure oldOwnerStructure = ownerStructure;
		ownerStructure = newOwnerStructure;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OntoumlPackage.REGION__OWNER_STRUCTURE, oldOwnerStructure, newOwnerStructure);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnerStructure(Structure newOwnerStructure) {
		if (newOwnerStructure != ownerStructure) {
			NotificationChain msgs = null;
			if (ownerStructure != null)
				msgs = ((InternalEObject)ownerStructure).eInverseRemove(this, OntoumlPackage.STRUCTURE__REGIONS, Structure.class, msgs);
			if (newOwnerStructure != null)
				msgs = ((InternalEObject)newOwnerStructure).eInverseAdd(this, OntoumlPackage.STRUCTURE__REGIONS, Structure.class, msgs);
			msgs = basicSetOwnerStructure(newOwnerStructure, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.REGION__OWNER_STRUCTURE, newOwnerStructure, newOwnerStructure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Literal getGroundedLiteral() {
		if (groundedLiteral != null && groundedLiteral.eIsProxy()) {
			InternalEObject oldGroundedLiteral = (InternalEObject)groundedLiteral;
			groundedLiteral = (Literal)eResolveProxy(oldGroundedLiteral);
			if (groundedLiteral != oldGroundedLiteral) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.REGION__GROUNDED_LITERAL, oldGroundedLiteral, groundedLiteral));
			}
		}
		return groundedLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Literal basicGetGroundedLiteral() {
		return groundedLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGroundedLiteral(Literal newGroundedLiteral, NotificationChain msgs) {
		Literal oldGroundedLiteral = groundedLiteral;
		groundedLiteral = newGroundedLiteral;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OntoumlPackage.REGION__GROUNDED_LITERAL, oldGroundedLiteral, newGroundedLiteral);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroundedLiteral(Literal newGroundedLiteral) {
		if (newGroundedLiteral != groundedLiteral) {
			NotificationChain msgs = null;
			if (groundedLiteral != null)
				msgs = ((InternalEObject)groundedLiteral).eInverseRemove(this, OntoumlPackage.LITERAL__GROUNDING_REGION, Literal.class, msgs);
			if (newGroundedLiteral != null)
				msgs = ((InternalEObject)newGroundedLiteral).eInverseAdd(this, OntoumlPackage.LITERAL__GROUNDING_REGION, Literal.class, msgs);
			msgs = basicSetGroundedLiteral(newGroundedLiteral, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.REGION__GROUNDED_LITERAL, newGroundedLiteral, newGroundedLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Region> getComposedBy() {
		if (composedBy == null) {
			composedBy = new EObjectResolvingEList<Region>(Region.class, this, OntoumlPackage.REGION__COMPOSED_BY);
		}
		return composedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Primitive getBasicType() {
		return basicType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasicType(Primitive newBasicType) {
		Primitive oldBasicType = basicType;
		basicType = newBasicType == null ? BASIC_TYPE_EDEFAULT : newBasicType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.REGION__BASIC_TYPE, oldBasicType, basicType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBasic() {
		boolean _and = false;
		boolean _and_1 = false;
		Primitive _basicType = this.getBasicType();
		boolean _notEquals = (!Objects.equal(_basicType, null));
		if (!_notEquals) {
			_and_1 = false;
		} else {
			EList<Region> _composedBy = this.getComposedBy();
			int _size = _composedBy.size();
			boolean _equals = (_size == 0);
			_and_1 = _equals;
		}
		if (!_and_1) {
			_and = false;
		} else {
			boolean _or = false;
			Primitive _basicType_1 = this.getBasicType();
			boolean _equals_1 = Objects.equal(_basicType_1, Primitive.INTEGER);
			if (_equals_1) {
				_or = true;
			} else {
				Primitive _basicType_2 = this.getBasicType();
				boolean _equals_2 = Objects.equal(_basicType_2, Primitive.DECIMAL);
				_or = _equals_2;
			}
			_and = _or;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isComposed() {
		boolean _and = false;
		Primitive _basicType = this.getBasicType();
		boolean _equals = Objects.equal(_basicType, null);
		if (!_equals) {
			_and = false;
		} else {
			EList<Region> _composedBy = this.getComposedBy();
			int _size = _composedBy.size();
			boolean _greaterThan = (_size > 0);
			_and = _greaterThan;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNominal() {
		boolean _and = false;
		Primitive _basicType = this.getBasicType();
		boolean _notEquals = (!Objects.equal(_basicType, null));
		if (!_notEquals) {
			_and = false;
		} else {
			Primitive _basicType_1 = this.getBasicType();
			boolean _equals = Objects.equal(_basicType_1, Primitive.STRING);
			_and = _equals;
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
			case OntoumlPackage.REGION__OWNER_STRUCTURE:
				if (ownerStructure != null)
					msgs = ((InternalEObject)ownerStructure).eInverseRemove(this, OntoumlPackage.STRUCTURE__REGIONS, Structure.class, msgs);
				return basicSetOwnerStructure((Structure)otherEnd, msgs);
			case OntoumlPackage.REGION__GROUNDED_LITERAL:
				if (groundedLiteral != null)
					msgs = ((InternalEObject)groundedLiteral).eInverseRemove(this, OntoumlPackage.LITERAL__GROUNDING_REGION, Literal.class, msgs);
				return basicSetGroundedLiteral((Literal)otherEnd, msgs);
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
			case OntoumlPackage.REGION__OWNER_STRUCTURE:
				return basicSetOwnerStructure(null, msgs);
			case OntoumlPackage.REGION__GROUNDED_LITERAL:
				return basicSetGroundedLiteral(null, msgs);
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
			case OntoumlPackage.REGION__OWNER_STRUCTURE:
				if (resolve) return getOwnerStructure();
				return basicGetOwnerStructure();
			case OntoumlPackage.REGION__GROUNDED_LITERAL:
				if (resolve) return getGroundedLiteral();
				return basicGetGroundedLiteral();
			case OntoumlPackage.REGION__COMPOSED_BY:
				return getComposedBy();
			case OntoumlPackage.REGION__BASIC_TYPE:
				return getBasicType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OntoumlPackage.REGION__OWNER_STRUCTURE:
				setOwnerStructure((Structure)newValue);
				return;
			case OntoumlPackage.REGION__GROUNDED_LITERAL:
				setGroundedLiteral((Literal)newValue);
				return;
			case OntoumlPackage.REGION__COMPOSED_BY:
				getComposedBy().clear();
				getComposedBy().addAll((Collection<? extends Region>)newValue);
				return;
			case OntoumlPackage.REGION__BASIC_TYPE:
				setBasicType((Primitive)newValue);
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
			case OntoumlPackage.REGION__OWNER_STRUCTURE:
				setOwnerStructure((Structure)null);
				return;
			case OntoumlPackage.REGION__GROUNDED_LITERAL:
				setGroundedLiteral((Literal)null);
				return;
			case OntoumlPackage.REGION__COMPOSED_BY:
				getComposedBy().clear();
				return;
			case OntoumlPackage.REGION__BASIC_TYPE:
				setBasicType(BASIC_TYPE_EDEFAULT);
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
			case OntoumlPackage.REGION__OWNER_STRUCTURE:
				return ownerStructure != null;
			case OntoumlPackage.REGION__GROUNDED_LITERAL:
				return groundedLiteral != null;
			case OntoumlPackage.REGION__COMPOSED_BY:
				return composedBy != null && !composedBy.isEmpty();
			case OntoumlPackage.REGION__BASIC_TYPE:
				return basicType != BASIC_TYPE_EDEFAULT;
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
			case OntoumlPackage.REGION___IS_BASIC:
				return isBasic();
			case OntoumlPackage.REGION___IS_COMPOSED:
				return isComposed();
			case OntoumlPackage.REGION___IS_NOMINAL:
				return isNominal();
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
		result.append(" (basicType: ");
		result.append(basicType);
		result.append(')');
		return result.toString();
	}

} //RegionImpl
