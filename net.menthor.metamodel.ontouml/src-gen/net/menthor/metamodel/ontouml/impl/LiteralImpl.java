/**
 */
package net.menthor.metamodel.ontouml.impl;

import net.menthor.metamodel.ontouml.Literal;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.Region;

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
 *   <li>{@link net.menthor.metamodel.ontouml.impl.LiteralImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.LiteralImpl#getGroundingRegion <em>Grounding Region</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.LiteralImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LiteralImpl extends PropertyImpl implements Literal {
	/**
	 * The cached value of the '{@link #getGroundingRegion() <em>Grounding Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroundingRegion()
	 * @generated
	 * @ordered
	 */
	protected Region groundingRegion;

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
	public net.menthor.metamodel.ontouml.Class getOwner() {
		if (eContainerFeatureID() != OntoumlPackage.LITERAL__OWNER) return null;
		return (net.menthor.metamodel.ontouml.Class)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class basicGetOwner() {
		if (eContainerFeatureID() != OntoumlPackage.LITERAL__OWNER) return null;
		return (net.menthor.metamodel.ontouml.Class)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(net.menthor.metamodel.ontouml.Class newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, OntoumlPackage.LITERAL__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(net.menthor.metamodel.ontouml.Class newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != OntoumlPackage.LITERAL__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, OntoumlPackage.CLASS__LITERALS, net.menthor.metamodel.ontouml.Class.class, msgs);
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
	public Region getGroundingRegion() {
		if (groundingRegion != null && groundingRegion.eIsProxy()) {
			InternalEObject oldGroundingRegion = (InternalEObject)groundingRegion;
			groundingRegion = (Region)eResolveProxy(oldGroundingRegion);
			if (groundingRegion != oldGroundingRegion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.LITERAL__GROUNDING_REGION, oldGroundingRegion, groundingRegion));
			}
		}
		return groundingRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Region basicGetGroundingRegion() {
		return groundingRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGroundingRegion(Region newGroundingRegion, NotificationChain msgs) {
		Region oldGroundingRegion = groundingRegion;
		groundingRegion = newGroundingRegion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OntoumlPackage.LITERAL__GROUNDING_REGION, oldGroundingRegion, newGroundingRegion);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroundingRegion(Region newGroundingRegion) {
		if (newGroundingRegion != groundingRegion) {
			NotificationChain msgs = null;
			if (groundingRegion != null)
				msgs = ((InternalEObject)groundingRegion).eInverseRemove(this, OntoumlPackage.REGION__GROUNDED_LITERAL, Region.class, msgs);
			if (newGroundingRegion != null)
				msgs = ((InternalEObject)newGroundingRegion).eInverseAdd(this, OntoumlPackage.REGION__GROUNDED_LITERAL, Region.class, msgs);
			msgs = basicSetGroundingRegion(newGroundingRegion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.LITERAL__GROUNDING_REGION, newGroundingRegion, newGroundingRegion));
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
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OntoumlPackage.LITERAL__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((net.menthor.metamodel.ontouml.Class)otherEnd, msgs);
			case OntoumlPackage.LITERAL__GROUNDING_REGION:
				if (groundingRegion != null)
					msgs = ((InternalEObject)groundingRegion).eInverseRemove(this, OntoumlPackage.REGION__GROUNDED_LITERAL, Region.class, msgs);
				return basicSetGroundingRegion((Region)otherEnd, msgs);
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
			case OntoumlPackage.LITERAL__GROUNDING_REGION:
				return basicSetGroundingRegion(null, msgs);
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
				return eInternalContainer().eInverseRemove(this, OntoumlPackage.CLASS__LITERALS, net.menthor.metamodel.ontouml.Class.class, msgs);
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
			case OntoumlPackage.LITERAL__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case OntoumlPackage.LITERAL__GROUNDING_REGION:
				if (resolve) return getGroundingRegion();
				return basicGetGroundingRegion();
			case OntoumlPackage.LITERAL__VALUE:
				return getValue();
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
			case OntoumlPackage.LITERAL__OWNER:
				setOwner((net.menthor.metamodel.ontouml.Class)newValue);
				return;
			case OntoumlPackage.LITERAL__GROUNDING_REGION:
				setGroundingRegion((Region)newValue);
				return;
			case OntoumlPackage.LITERAL__VALUE:
				setValue((String)newValue);
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
			case OntoumlPackage.LITERAL__OWNER:
				setOwner((net.menthor.metamodel.ontouml.Class)null);
				return;
			case OntoumlPackage.LITERAL__GROUNDING_REGION:
				setGroundingRegion((Region)null);
				return;
			case OntoumlPackage.LITERAL__VALUE:
				setValue(VALUE_EDEFAULT);
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
			case OntoumlPackage.LITERAL__OWNER:
				return basicGetOwner() != null;
			case OntoumlPackage.LITERAL__GROUNDING_REGION:
				return groundingRegion != null;
			case OntoumlPackage.LITERAL__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
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
		result.append(')');
		return result.toString();
	}

} //LiteralImpl
