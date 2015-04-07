/**
 */
package net.menthor.metamodel.ontouml.impl;

import java.util.Collection;

import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.Region;
import net.menthor.metamodel.ontouml.Structure;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.StructureImpl#getRegions <em>Regions</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.StructureImpl#getGroundedEnumeration <em>Grounded Enumeration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StructureImpl extends TypeImpl implements Structure {
	/**
	 * The cached value of the '{@link #getRegions() <em>Regions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegions()
	 * @generated
	 * @ordered
	 */
	protected EList<Region> regions;

	/**
	 * The cached value of the '{@link #getGroundedEnumeration() <em>Grounded Enumeration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroundedEnumeration()
	 * @generated
	 * @ordered
	 */
	protected net.menthor.metamodel.ontouml.Class groundedEnumeration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OntoumlPackage.Literals.STRUCTURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Region> getRegions() {
		if (regions == null) {
			regions = new EObjectWithInverseResolvingEList<Region>(Region.class, this, OntoumlPackage.STRUCTURE__REGIONS, OntoumlPackage.REGION__OWNER_STRUCTURE);
		}
		return regions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class getGroundedEnumeration() {
		if (groundedEnumeration != null && groundedEnumeration.eIsProxy()) {
			InternalEObject oldGroundedEnumeration = (InternalEObject)groundedEnumeration;
			groundedEnumeration = (net.menthor.metamodel.ontouml.Class)eResolveProxy(oldGroundedEnumeration);
			if (groundedEnumeration != oldGroundedEnumeration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.STRUCTURE__GROUNDED_ENUMERATION, oldGroundedEnumeration, groundedEnumeration));
			}
		}
		return groundedEnumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class basicGetGroundedEnumeration() {
		return groundedEnumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGroundedEnumeration(net.menthor.metamodel.ontouml.Class newGroundedEnumeration, NotificationChain msgs) {
		net.menthor.metamodel.ontouml.Class oldGroundedEnumeration = groundedEnumeration;
		groundedEnumeration = newGroundedEnumeration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OntoumlPackage.STRUCTURE__GROUNDED_ENUMERATION, oldGroundedEnumeration, newGroundedEnumeration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroundedEnumeration(net.menthor.metamodel.ontouml.Class newGroundedEnumeration) {
		if (newGroundedEnumeration != groundedEnumeration) {
			NotificationChain msgs = null;
			if (groundedEnumeration != null)
				msgs = ((InternalEObject)groundedEnumeration).eInverseRemove(this, OntoumlPackage.CLASS__GROUNDING_STRUCTURE, net.menthor.metamodel.ontouml.Class.class, msgs);
			if (newGroundedEnumeration != null)
				msgs = ((InternalEObject)newGroundedEnumeration).eInverseAdd(this, OntoumlPackage.CLASS__GROUNDING_STRUCTURE, net.menthor.metamodel.ontouml.Class.class, msgs);
			msgs = basicSetGroundedEnumeration(newGroundedEnumeration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.STRUCTURE__GROUNDED_ENUMERATION, newGroundedEnumeration, newGroundedEnumeration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OntoumlPackage.STRUCTURE__REGIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRegions()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.STRUCTURE__GROUNDED_ENUMERATION:
				if (groundedEnumeration != null)
					msgs = ((InternalEObject)groundedEnumeration).eInverseRemove(this, OntoumlPackage.CLASS__GROUNDING_STRUCTURE, net.menthor.metamodel.ontouml.Class.class, msgs);
				return basicSetGroundedEnumeration((net.menthor.metamodel.ontouml.Class)otherEnd, msgs);
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
			case OntoumlPackage.STRUCTURE__REGIONS:
				return ((InternalEList<?>)getRegions()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.STRUCTURE__GROUNDED_ENUMERATION:
				return basicSetGroundedEnumeration(null, msgs);
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
			case OntoumlPackage.STRUCTURE__REGIONS:
				return getRegions();
			case OntoumlPackage.STRUCTURE__GROUNDED_ENUMERATION:
				if (resolve) return getGroundedEnumeration();
				return basicGetGroundedEnumeration();
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
			case OntoumlPackage.STRUCTURE__REGIONS:
				getRegions().clear();
				getRegions().addAll((Collection<? extends Region>)newValue);
				return;
			case OntoumlPackage.STRUCTURE__GROUNDED_ENUMERATION:
				setGroundedEnumeration((net.menthor.metamodel.ontouml.Class)newValue);
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
			case OntoumlPackage.STRUCTURE__REGIONS:
				getRegions().clear();
				return;
			case OntoumlPackage.STRUCTURE__GROUNDED_ENUMERATION:
				setGroundedEnumeration((net.menthor.metamodel.ontouml.Class)null);
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
			case OntoumlPackage.STRUCTURE__REGIONS:
				return regions != null && !regions.isEmpty();
			case OntoumlPackage.STRUCTURE__GROUNDED_ENUMERATION:
				return groundedEnumeration != null;
		}
		return super.eIsSet(featureID);
	}

} //StructureImpl
