/**
 */
package net.menthor.metamodel.ontouml.impl;

import java.util.Collection;

import net.menthor.metamodel.ontouml.Classifier;
import net.menthor.metamodel.ontouml.EndPoint;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.Relationship;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>End Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.EndPointImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.EndPointImpl#getEndType <em>End Type</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.EndPointImpl#getSubsets <em>Subsets</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.EndPointImpl#getRedefines <em>Redefines</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.EndPointImpl#getIsSubsettedBy <em>Is Subsetted By</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.EndPointImpl#getIsRedefinedBy <em>Is Redefined By</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EndPointImpl extends PropertyImpl implements EndPoint {
	/**
	 * The cached value of the '{@link #getEndType() <em>End Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndType()
	 * @generated
	 * @ordered
	 */
	protected Classifier endType;

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
	 * The cached value of the '{@link #getIsRedefinedBy() <em>Is Redefined By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsRedefinedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<EndPoint> isRedefinedBy;

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
	public Relationship getOwner() {
		if (eContainerFeatureID() != OntoumlPackage.END_POINT__OWNER) return null;
		return (Relationship)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relationship basicGetOwner() {
		if (eContainerFeatureID() != OntoumlPackage.END_POINT__OWNER) return null;
		return (Relationship)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(Relationship newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, OntoumlPackage.END_POINT__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(Relationship newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != OntoumlPackage.END_POINT__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, OntoumlPackage.RELATIONSHIP__END_POINTS, Relationship.class, msgs);
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
	public Classifier getEndType() {
		if (endType != null && endType.eIsProxy()) {
			InternalEObject oldEndType = (InternalEObject)endType;
			endType = (Classifier)eResolveProxy(oldEndType);
			if (endType != oldEndType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.END_POINT__END_TYPE, oldEndType, endType));
			}
		}
		return endType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier basicGetEndType() {
		return endType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndType(Classifier newEndType) {
		Classifier oldEndType = endType;
		endType = newEndType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.END_POINT__END_TYPE, oldEndType, endType));
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
			redefines = new EObjectWithInverseResolvingEList.ManyInverse<EndPoint>(EndPoint.class, this, OntoumlPackage.END_POINT__REDEFINES, OntoumlPackage.END_POINT__IS_REDEFINED_BY);
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
	public EList<EndPoint> getIsRedefinedBy() {
		if (isRedefinedBy == null) {
			isRedefinedBy = new EObjectWithInverseResolvingEList.ManyInverse<EndPoint>(EndPoint.class, this, OntoumlPackage.END_POINT__IS_REDEFINED_BY, OntoumlPackage.END_POINT__REDEFINES);
		}
		return isRedefinedBy;
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
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((Relationship)otherEnd, msgs);
			case OntoumlPackage.END_POINT__SUBSETS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubsets()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.END_POINT__REDEFINES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRedefines()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.END_POINT__IS_SUBSETTED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIsSubsettedBy()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.END_POINT__IS_REDEFINED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIsRedefinedBy()).basicAdd(otherEnd, msgs);
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
			case OntoumlPackage.END_POINT__IS_REDEFINED_BY:
				return ((InternalEList<?>)getIsRedefinedBy()).basicRemove(otherEnd, msgs);
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
			case OntoumlPackage.END_POINT__OWNER:
				return eInternalContainer().eInverseRemove(this, OntoumlPackage.RELATIONSHIP__END_POINTS, Relationship.class, msgs);
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
			case OntoumlPackage.END_POINT__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case OntoumlPackage.END_POINT__END_TYPE:
				if (resolve) return getEndType();
				return basicGetEndType();
			case OntoumlPackage.END_POINT__SUBSETS:
				return getSubsets();
			case OntoumlPackage.END_POINT__REDEFINES:
				return getRedefines();
			case OntoumlPackage.END_POINT__IS_SUBSETTED_BY:
				return getIsSubsettedBy();
			case OntoumlPackage.END_POINT__IS_REDEFINED_BY:
				return getIsRedefinedBy();
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
				setOwner((Relationship)newValue);
				return;
			case OntoumlPackage.END_POINT__END_TYPE:
				setEndType((Classifier)newValue);
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
			case OntoumlPackage.END_POINT__IS_REDEFINED_BY:
				getIsRedefinedBy().clear();
				getIsRedefinedBy().addAll((Collection<? extends EndPoint>)newValue);
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
				setOwner((Relationship)null);
				return;
			case OntoumlPackage.END_POINT__END_TYPE:
				setEndType((Classifier)null);
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
			case OntoumlPackage.END_POINT__IS_REDEFINED_BY:
				getIsRedefinedBy().clear();
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
				return basicGetOwner() != null;
			case OntoumlPackage.END_POINT__END_TYPE:
				return endType != null;
			case OntoumlPackage.END_POINT__SUBSETS:
				return subsets != null && !subsets.isEmpty();
			case OntoumlPackage.END_POINT__REDEFINES:
				return redefines != null && !redefines.isEmpty();
			case OntoumlPackage.END_POINT__IS_SUBSETTED_BY:
				return isSubsettedBy != null && !isSubsettedBy.isEmpty();
			case OntoumlPackage.END_POINT__IS_REDEFINED_BY:
				return isRedefinedBy != null && !isRedefinedBy.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EndPointImpl
