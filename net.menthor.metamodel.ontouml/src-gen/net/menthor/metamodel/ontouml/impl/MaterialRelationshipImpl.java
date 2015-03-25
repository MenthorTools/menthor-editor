/**
 */
package net.menthor.metamodel.ontouml.impl;

import net.menthor.metamodel.ontouml.MaterialRelationship;
import net.menthor.metamodel.ontouml.OntoumlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Material Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.MaterialRelationshipImpl#getIsDerivedFrom <em>Is Derived From</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MaterialRelationshipImpl extends ClassBinaryRelationshipImpl implements MaterialRelationship {
	/**
	 * The cached value of the '{@link #getIsDerivedFrom() <em>Is Derived From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsDerivedFrom()
	 * @generated
	 * @ordered
	 */
	protected net.menthor.metamodel.ontouml.Class isDerivedFrom;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MaterialRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OntoumlPackage.Literals.MATERIAL_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class getIsDerivedFrom() {
		if (isDerivedFrom != null && isDerivedFrom.eIsProxy()) {
			InternalEObject oldIsDerivedFrom = (InternalEObject)isDerivedFrom;
			isDerivedFrom = (net.menthor.metamodel.ontouml.Class)eResolveProxy(oldIsDerivedFrom);
			if (isDerivedFrom != oldIsDerivedFrom) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.MATERIAL_RELATIONSHIP__IS_DERIVED_FROM, oldIsDerivedFrom, isDerivedFrom));
			}
		}
		return isDerivedFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class basicGetIsDerivedFrom() {
		return isDerivedFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIsDerivedFrom(net.menthor.metamodel.ontouml.Class newIsDerivedFrom, NotificationChain msgs) {
		net.menthor.metamodel.ontouml.Class oldIsDerivedFrom = isDerivedFrom;
		isDerivedFrom = newIsDerivedFrom;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OntoumlPackage.MATERIAL_RELATIONSHIP__IS_DERIVED_FROM, oldIsDerivedFrom, newIsDerivedFrom);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDerivedFrom(net.menthor.metamodel.ontouml.Class newIsDerivedFrom) {
		if (newIsDerivedFrom != isDerivedFrom) {
			NotificationChain msgs = null;
			if (isDerivedFrom != null)
				msgs = ((InternalEObject)isDerivedFrom).eInverseRemove(this, OntoumlPackage.CLASS__IS_TRUTH_MAKER_OF, net.menthor.metamodel.ontouml.Class.class, msgs);
			if (newIsDerivedFrom != null)
				msgs = ((InternalEObject)newIsDerivedFrom).eInverseAdd(this, OntoumlPackage.CLASS__IS_TRUTH_MAKER_OF, net.menthor.metamodel.ontouml.Class.class, msgs);
			msgs = basicSetIsDerivedFrom(newIsDerivedFrom, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.MATERIAL_RELATIONSHIP__IS_DERIVED_FROM, newIsDerivedFrom, newIsDerivedFrom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OntoumlPackage.MATERIAL_RELATIONSHIP__IS_DERIVED_FROM:
				if (isDerivedFrom != null)
					msgs = ((InternalEObject)isDerivedFrom).eInverseRemove(this, OntoumlPackage.CLASS__IS_TRUTH_MAKER_OF, net.menthor.metamodel.ontouml.Class.class, msgs);
				return basicSetIsDerivedFrom((net.menthor.metamodel.ontouml.Class)otherEnd, msgs);
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
			case OntoumlPackage.MATERIAL_RELATIONSHIP__IS_DERIVED_FROM:
				return basicSetIsDerivedFrom(null, msgs);
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
			case OntoumlPackage.MATERIAL_RELATIONSHIP__IS_DERIVED_FROM:
				if (resolve) return getIsDerivedFrom();
				return basicGetIsDerivedFrom();
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
			case OntoumlPackage.MATERIAL_RELATIONSHIP__IS_DERIVED_FROM:
				setIsDerivedFrom((net.menthor.metamodel.ontouml.Class)newValue);
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
			case OntoumlPackage.MATERIAL_RELATIONSHIP__IS_DERIVED_FROM:
				setIsDerivedFrom((net.menthor.metamodel.ontouml.Class)null);
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
			case OntoumlPackage.MATERIAL_RELATIONSHIP__IS_DERIVED_FROM:
				return isDerivedFrom != null;
		}
		return super.eIsSet(featureID);
	}

} //MaterialRelationshipImpl
