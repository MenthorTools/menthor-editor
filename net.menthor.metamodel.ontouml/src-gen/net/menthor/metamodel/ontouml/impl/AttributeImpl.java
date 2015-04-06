/**
 */
package net.menthor.metamodel.ontouml.impl;

import net.menthor.metamodel.ontouml.Attribute;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.Primitive;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.AttributeImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.AttributeImpl#getPrimitive <em>Primitive</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeImpl extends PropertyImpl implements Attribute {
	/**
	 * The default value of the '{@link #getPrimitive() <em>Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive()
	 * @generated
	 * @ordered
	 */
	protected static final Primitive PRIMITIVE_EDEFAULT = Primitive.BOOLEAN;

	/**
	 * The cached value of the '{@link #getPrimitive() <em>Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive()
	 * @generated
	 * @ordered
	 */
	protected Primitive primitive = PRIMITIVE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OntoumlPackage.Literals.ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class getOwner() {
		if (eContainerFeatureID() != OntoumlPackage.ATTRIBUTE__OWNER) return null;
		return (net.menthor.metamodel.ontouml.Class)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class basicGetOwner() {
		if (eContainerFeatureID() != OntoumlPackage.ATTRIBUTE__OWNER) return null;
		return (net.menthor.metamodel.ontouml.Class)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(net.menthor.metamodel.ontouml.Class newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, OntoumlPackage.ATTRIBUTE__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(net.menthor.metamodel.ontouml.Class newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != OntoumlPackage.ATTRIBUTE__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, OntoumlPackage.CLASS__ATTRIBUTES, net.menthor.metamodel.ontouml.Class.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.ATTRIBUTE__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Primitive getPrimitive() {
		return primitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimitive(Primitive newPrimitive) {
		Primitive oldPrimitive = primitive;
		primitive = newPrimitive == null ? PRIMITIVE_EDEFAULT : newPrimitive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.ATTRIBUTE__PRIMITIVE, oldPrimitive, primitive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OntoumlPackage.ATTRIBUTE__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((net.menthor.metamodel.ontouml.Class)otherEnd, msgs);
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
			case OntoumlPackage.ATTRIBUTE__OWNER:
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
			case OntoumlPackage.ATTRIBUTE__OWNER:
				return eInternalContainer().eInverseRemove(this, OntoumlPackage.CLASS__ATTRIBUTES, net.menthor.metamodel.ontouml.Class.class, msgs);
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
			case OntoumlPackage.ATTRIBUTE__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case OntoumlPackage.ATTRIBUTE__PRIMITIVE:
				return getPrimitive();
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
			case OntoumlPackage.ATTRIBUTE__OWNER:
				setOwner((net.menthor.metamodel.ontouml.Class)newValue);
				return;
			case OntoumlPackage.ATTRIBUTE__PRIMITIVE:
				setPrimitive((Primitive)newValue);
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
			case OntoumlPackage.ATTRIBUTE__OWNER:
				setOwner((net.menthor.metamodel.ontouml.Class)null);
				return;
			case OntoumlPackage.ATTRIBUTE__PRIMITIVE:
				setPrimitive(PRIMITIVE_EDEFAULT);
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
			case OntoumlPackage.ATTRIBUTE__OWNER:
				return basicGetOwner() != null;
			case OntoumlPackage.ATTRIBUTE__PRIMITIVE:
				return primitive != PRIMITIVE_EDEFAULT;
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
		result.append(" (primitive: ");
		result.append(primitive);
		result.append(')');
		return result.toString();
	}

} //AttributeImpl
