/**
 */
package net.menthor.metamodel.ontouml.impl;

import java.util.Collection;

import net.menthor.metamodel.ontouml.ClassBinaryRelationship;
import net.menthor.metamodel.ontouml.EndPoint;
import net.menthor.metamodel.ontouml.OntoumlPackage;

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
 * An implementation of the model object '<em><b>End Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.EndPointImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.EndPointImpl#getIsOfType <em>Is Of Type</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.EndPointImpl#getSubsets <em>Subsets</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.EndPointImpl#getRedefines <em>Redefines</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.EndPointImpl#getIsSubsettedBy <em>Is Subsetted By</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.EndPointImpl#getIsRedefeinedBy <em>Is Redefeined By</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EndPointImpl extends PropertyImpl implements EndPoint {
	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected ClassBinaryRelationship owner;

	/**
	 * The cached value of the '{@link #getIsOfType() <em>Is Of Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsOfType()
	 * @generated
	 * @ordered
	 */
	protected net.menthor.metamodel.ontouml.Class isOfType;

	/**
	 * The cached value of the '{@link #getSubsets() <em>Subsets</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubsets()
	 * @generated
	 * @ordered
	 */
	protected EList<EndPoint> subsets;

	/**
	 * The cached value of the '{@link #getRedefines() <em>Redefines</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRedefines()
	 * @generated
	 * @ordered
	 */
	protected EList<EndPoint> redefines;

	/**
	 * The cached value of the '{@link #getIsSubsettedBy() <em>Is Subsetted By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsSubsettedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<EndPoint> isSubsettedBy;

	/**
	 * The cached value of the '{@link #getIsRedefeinedBy() <em>Is Redefeined By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsRedefeinedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<EndPoint> isRedefeinedBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EndPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OntoumlPackage.Literals.END_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassBinaryRelationship getOwner() {
		if (owner != null && owner.eIsProxy()) {
			InternalEObject oldOwner = (InternalEObject)owner;
			owner = (ClassBinaryRelationship)eResolveProxy(oldOwner);
			if (owner != oldOwner) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.END_POINT__OWNER, oldOwner, owner));
			}
		}
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassBinaryRelationship basicGetOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(ClassBinaryRelationship newOwner, NotificationChain msgs) {
		ClassBinaryRelationship oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OntoumlPackage.END_POINT__OWNER, oldOwner, newOwner);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(ClassBinaryRelationship newOwner) {
		if (newOwner != owner) {
			NotificationChain msgs = null;
			if (owner != null)
				msgs = ((InternalEObject)owner).eInverseRemove(this, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__END_POINTS, ClassBinaryRelationship.class, msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__END_POINTS, ClassBinaryRelationship.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.END_POINT__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class getIsOfType() {
		if (isOfType != null && isOfType.eIsProxy()) {
			InternalEObject oldIsOfType = (InternalEObject)isOfType;
			isOfType = (net.menthor.metamodel.ontouml.Class)eResolveProxy(oldIsOfType);
			if (isOfType != oldIsOfType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.END_POINT__IS_OF_TYPE, oldIsOfType, isOfType));
			}
		}
		return isOfType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class basicGetIsOfType() {
		return isOfType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsOfType(net.menthor.metamodel.ontouml.Class newIsOfType) {
		net.menthor.metamodel.ontouml.Class oldIsOfType = isOfType;
		isOfType = newIsOfType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.END_POINT__IS_OF_TYPE, oldIsOfType, isOfType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EndPoint> getSubsets() {
		if (subsets == null) {
			subsets = new EObjectWithInverseResolvingEList.ManyInverse<EndPoint>(EndPoint.class, this, OntoumlPackage.END_POINT__SUBSETS, OntoumlPackage.END_POINT__IS_SUBSETTED_BY);
		}
		return subsets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EndPoint> getRedefines() {
		if (redefines == null) {
			redefines = new EObjectWithInverseResolvingEList.ManyInverse<EndPoint>(EndPoint.class, this, OntoumlPackage.END_POINT__REDEFINES, OntoumlPackage.END_POINT__IS_REDEFEINED_BY);
		}
		return redefines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EndPoint> getIsSubsettedBy() {
		if (isSubsettedBy == null) {
			isSubsettedBy = new EObjectWithInverseResolvingEList.ManyInverse<EndPoint>(EndPoint.class, this, OntoumlPackage.END_POINT__IS_SUBSETTED_BY, OntoumlPackage.END_POINT__SUBSETS);
		}
		return isSubsettedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EndPoint> getIsRedefeinedBy() {
		if (isRedefeinedBy == null) {
			isRedefeinedBy = new EObjectWithInverseResolvingEList.ManyInverse<EndPoint>(EndPoint.class, this, OntoumlPackage.END_POINT__IS_REDEFEINED_BY, OntoumlPackage.END_POINT__REDEFINES);
		}
		return isRedefeinedBy;
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
			case OntoumlPackage.END_POINT__OWNER:
				if (owner != null)
					msgs = ((InternalEObject)owner).eInverseRemove(this, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__END_POINTS, ClassBinaryRelationship.class, msgs);
				return basicSetOwner((ClassBinaryRelationship)otherEnd, msgs);
			case OntoumlPackage.END_POINT__SUBSETS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubsets()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.END_POINT__REDEFINES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRedefines()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.END_POINT__IS_SUBSETTED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIsSubsettedBy()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.END_POINT__IS_REDEFEINED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIsRedefeinedBy()).basicAdd(otherEnd, msgs);
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
			case OntoumlPackage.END_POINT__OWNER:
				return basicSetOwner(null, msgs);
			case OntoumlPackage.END_POINT__SUBSETS:
				return ((InternalEList<?>)getSubsets()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.END_POINT__REDEFINES:
				return ((InternalEList<?>)getRedefines()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.END_POINT__IS_SUBSETTED_BY:
				return ((InternalEList<?>)getIsSubsettedBy()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.END_POINT__IS_REDEFEINED_BY:
				return ((InternalEList<?>)getIsRedefeinedBy()).basicRemove(otherEnd, msgs);
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
			case OntoumlPackage.END_POINT__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case OntoumlPackage.END_POINT__IS_OF_TYPE:
				if (resolve) return getIsOfType();
				return basicGetIsOfType();
			case OntoumlPackage.END_POINT__SUBSETS:
				return getSubsets();
			case OntoumlPackage.END_POINT__REDEFINES:
				return getRedefines();
			case OntoumlPackage.END_POINT__IS_SUBSETTED_BY:
				return getIsSubsettedBy();
			case OntoumlPackage.END_POINT__IS_REDEFEINED_BY:
				return getIsRedefeinedBy();
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
			case OntoumlPackage.END_POINT__OWNER:
				setOwner((ClassBinaryRelationship)newValue);
				return;
			case OntoumlPackage.END_POINT__IS_OF_TYPE:
				setIsOfType((net.menthor.metamodel.ontouml.Class)newValue);
				return;
			case OntoumlPackage.END_POINT__SUBSETS:
				getSubsets().clear();
				getSubsets().addAll((Collection<? extends EndPoint>)newValue);
				return;
			case OntoumlPackage.END_POINT__REDEFINES:
				getRedefines().clear();
				getRedefines().addAll((Collection<? extends EndPoint>)newValue);
				return;
			case OntoumlPackage.END_POINT__IS_SUBSETTED_BY:
				getIsSubsettedBy().clear();
				getIsSubsettedBy().addAll((Collection<? extends EndPoint>)newValue);
				return;
			case OntoumlPackage.END_POINT__IS_REDEFEINED_BY:
				getIsRedefeinedBy().clear();
				getIsRedefeinedBy().addAll((Collection<? extends EndPoint>)newValue);
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
			case OntoumlPackage.END_POINT__OWNER:
				setOwner((ClassBinaryRelationship)null);
				return;
			case OntoumlPackage.END_POINT__IS_OF_TYPE:
				setIsOfType((net.menthor.metamodel.ontouml.Class)null);
				return;
			case OntoumlPackage.END_POINT__SUBSETS:
				getSubsets().clear();
				return;
			case OntoumlPackage.END_POINT__REDEFINES:
				getRedefines().clear();
				return;
			case OntoumlPackage.END_POINT__IS_SUBSETTED_BY:
				getIsSubsettedBy().clear();
				return;
			case OntoumlPackage.END_POINT__IS_REDEFEINED_BY:
				getIsRedefeinedBy().clear();
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
			case OntoumlPackage.END_POINT__OWNER:
				return owner != null;
			case OntoumlPackage.END_POINT__IS_OF_TYPE:
				return isOfType != null;
			case OntoumlPackage.END_POINT__SUBSETS:
				return subsets != null && !subsets.isEmpty();
			case OntoumlPackage.END_POINT__REDEFINES:
				return redefines != null && !redefines.isEmpty();
			case OntoumlPackage.END_POINT__IS_SUBSETTED_BY:
				return isSubsettedBy != null && !isSubsettedBy.isEmpty();
			case OntoumlPackage.END_POINT__IS_REDEFEINED_BY:
				return isRedefeinedBy != null && !isRedefeinedBy.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EndPointImpl
