/**
 */
package net.menthor.metamodel.ontouml.impl;

import java.util.Collection;

import net.menthor.metamodel.ontouml.GeneralizationSet;
import net.menthor.metamodel.ontouml.HighOrderClass;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.PackageableElement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generalization Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.GeneralizationSetImpl#getContainer_ <em>Container </em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.GeneralizationSetImpl#isIsCovering <em>Is Covering</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.GeneralizationSetImpl#isIsDisjoint <em>Is Disjoint</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.GeneralizationSetImpl#getSpecializedClass <em>Specialized Class</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.GeneralizationSetImpl#getSpecializingClasses <em>Specializing Classes</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.GeneralizationSetImpl#getPowertype <em>Powertype</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GeneralizationSetImpl extends NamedElementImpl implements GeneralizationSet {
	/**
	 * The default value of the '{@link #isIsCovering() <em>Is Covering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCovering()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_COVERING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsCovering() <em>Is Covering</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCovering()
	 * @generated
	 * @ordered
	 */
	protected boolean isCovering = IS_COVERING_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsDisjoint() <em>Is Disjoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDisjoint()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DISJOINT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsDisjoint() <em>Is Disjoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDisjoint()
	 * @generated
	 * @ordered
	 */
	protected boolean isDisjoint = IS_DISJOINT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSpecializedClass() <em>Specialized Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecializedClass()
	 * @generated
	 * @ordered
	 */
	protected net.menthor.metamodel.ontouml.Class specializedClass;

	/**
	 * The cached value of the '{@link #getSpecializingClasses() <em>Specializing Classes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecializingClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<net.menthor.metamodel.ontouml.Class> specializingClasses;

	/**
	 * The cached value of the '{@link #getPowertype() <em>Powertype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPowertype()
	 * @generated
	 * @ordered
	 */
	protected HighOrderClass powertype;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeneralizationSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OntoumlPackage.Literals.GENERALIZATION_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Container getContainer_() {
		if (eContainerFeatureID() != OntoumlPackage.GENERALIZATION_SET__CONTAINER_) return null;
		return (net.menthor.metamodel.ontouml.Container)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Container basicGetContainer_() {
		if (eContainerFeatureID() != OntoumlPackage.GENERALIZATION_SET__CONTAINER_) return null;
		return (net.menthor.metamodel.ontouml.Container)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainer_(net.menthor.metamodel.ontouml.Container newContainer_, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainer_, OntoumlPackage.GENERALIZATION_SET__CONTAINER_, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer_(net.menthor.metamodel.ontouml.Container newContainer_) {
		if (newContainer_ != eInternalContainer() || (eContainerFeatureID() != OntoumlPackage.GENERALIZATION_SET__CONTAINER_ && newContainer_ != null)) {
			if (EcoreUtil.isAncestor(this, newContainer_))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainer_ != null)
				msgs = ((InternalEObject)newContainer_).eInverseAdd(this, OntoumlPackage.CONTAINER__ELEMENTS, net.menthor.metamodel.ontouml.Container.class, msgs);
			msgs = basicSetContainer_(newContainer_, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.GENERALIZATION_SET__CONTAINER_, newContainer_, newContainer_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsCovering() {
		return isCovering;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsCovering(boolean newIsCovering) {
		boolean oldIsCovering = isCovering;
		isCovering = newIsCovering;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.GENERALIZATION_SET__IS_COVERING, oldIsCovering, isCovering));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsDisjoint() {
		return isDisjoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDisjoint(boolean newIsDisjoint) {
		boolean oldIsDisjoint = isDisjoint;
		isDisjoint = newIsDisjoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.GENERALIZATION_SET__IS_DISJOINT, oldIsDisjoint, isDisjoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class getSpecializedClass() {
		return specializedClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecializedClass(net.menthor.metamodel.ontouml.Class newSpecializedClass, NotificationChain msgs) {
		net.menthor.metamodel.ontouml.Class oldSpecializedClass = specializedClass;
		specializedClass = newSpecializedClass;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASS, oldSpecializedClass, newSpecializedClass);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecializedClass(net.menthor.metamodel.ontouml.Class newSpecializedClass) {
		if (newSpecializedClass != specializedClass) {
			NotificationChain msgs = null;
			if (specializedClass != null)
				msgs = ((InternalEObject)specializedClass).eInverseRemove(this, OntoumlPackage.CLASS__IS_SPECIALIZED_VIA, net.menthor.metamodel.ontouml.Class.class, msgs);
			if (newSpecializedClass != null)
				msgs = ((InternalEObject)newSpecializedClass).eInverseAdd(this, OntoumlPackage.CLASS__IS_SPECIALIZED_VIA, net.menthor.metamodel.ontouml.Class.class, msgs);
			msgs = basicSetSpecializedClass(newSpecializedClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASS, newSpecializedClass, newSpecializedClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<net.menthor.metamodel.ontouml.Class> getSpecializingClasses() {
		if (specializingClasses == null) {
			specializingClasses = new EObjectWithInverseEList.ManyInverse<net.menthor.metamodel.ontouml.Class>(net.menthor.metamodel.ontouml.Class.class, this, OntoumlPackage.GENERALIZATION_SET__SPECIALIZING_CLASSES, OntoumlPackage.CLASS__SPECIALIZES_VIA);
		}
		return specializingClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HighOrderClass getPowertype() {
		if (powertype != null && powertype.eIsProxy()) {
			InternalEObject oldPowertype = (InternalEObject)powertype;
			powertype = (HighOrderClass)eResolveProxy(oldPowertype);
			if (powertype != oldPowertype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.GENERALIZATION_SET__POWERTYPE, oldPowertype, powertype));
			}
		}
		return powertype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HighOrderClass basicGetPowertype() {
		return powertype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPowertype(HighOrderClass newPowertype) {
		HighOrderClass oldPowertype = powertype;
		powertype = newPowertype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.GENERALIZATION_SET__POWERTYPE, oldPowertype, powertype));
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
			case OntoumlPackage.GENERALIZATION_SET__CONTAINER_:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainer_((net.menthor.metamodel.ontouml.Container)otherEnd, msgs);
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASS:
				if (specializedClass != null)
					msgs = ((InternalEObject)specializedClass).eInverseRemove(this, OntoumlPackage.CLASS__IS_SPECIALIZED_VIA, net.menthor.metamodel.ontouml.Class.class, msgs);
				return basicSetSpecializedClass((net.menthor.metamodel.ontouml.Class)otherEnd, msgs);
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZING_CLASSES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpecializingClasses()).basicAdd(otherEnd, msgs);
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
			case OntoumlPackage.GENERALIZATION_SET__CONTAINER_:
				return basicSetContainer_(null, msgs);
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASS:
				return basicSetSpecializedClass(null, msgs);
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZING_CLASSES:
				return ((InternalEList<?>)getSpecializingClasses()).basicRemove(otherEnd, msgs);
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
			case OntoumlPackage.GENERALIZATION_SET__CONTAINER_:
				return eInternalContainer().eInverseRemove(this, OntoumlPackage.CONTAINER__ELEMENTS, net.menthor.metamodel.ontouml.Container.class, msgs);
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
			case OntoumlPackage.GENERALIZATION_SET__CONTAINER_:
				if (resolve) return getContainer_();
				return basicGetContainer_();
			case OntoumlPackage.GENERALIZATION_SET__IS_COVERING:
				return isIsCovering();
			case OntoumlPackage.GENERALIZATION_SET__IS_DISJOINT:
				return isIsDisjoint();
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASS:
				return getSpecializedClass();
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZING_CLASSES:
				return getSpecializingClasses();
			case OntoumlPackage.GENERALIZATION_SET__POWERTYPE:
				if (resolve) return getPowertype();
				return basicGetPowertype();
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
			case OntoumlPackage.GENERALIZATION_SET__CONTAINER_:
				setContainer_((net.menthor.metamodel.ontouml.Container)newValue);
				return;
			case OntoumlPackage.GENERALIZATION_SET__IS_COVERING:
				setIsCovering((Boolean)newValue);
				return;
			case OntoumlPackage.GENERALIZATION_SET__IS_DISJOINT:
				setIsDisjoint((Boolean)newValue);
				return;
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASS:
				setSpecializedClass((net.menthor.metamodel.ontouml.Class)newValue);
				return;
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZING_CLASSES:
				getSpecializingClasses().clear();
				getSpecializingClasses().addAll((Collection<? extends net.menthor.metamodel.ontouml.Class>)newValue);
				return;
			case OntoumlPackage.GENERALIZATION_SET__POWERTYPE:
				setPowertype((HighOrderClass)newValue);
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
			case OntoumlPackage.GENERALIZATION_SET__CONTAINER_:
				setContainer_((net.menthor.metamodel.ontouml.Container)null);
				return;
			case OntoumlPackage.GENERALIZATION_SET__IS_COVERING:
				setIsCovering(IS_COVERING_EDEFAULT);
				return;
			case OntoumlPackage.GENERALIZATION_SET__IS_DISJOINT:
				setIsDisjoint(IS_DISJOINT_EDEFAULT);
				return;
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASS:
				setSpecializedClass((net.menthor.metamodel.ontouml.Class)null);
				return;
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZING_CLASSES:
				getSpecializingClasses().clear();
				return;
			case OntoumlPackage.GENERALIZATION_SET__POWERTYPE:
				setPowertype((HighOrderClass)null);
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
			case OntoumlPackage.GENERALIZATION_SET__CONTAINER_:
				return basicGetContainer_() != null;
			case OntoumlPackage.GENERALIZATION_SET__IS_COVERING:
				return isCovering != IS_COVERING_EDEFAULT;
			case OntoumlPackage.GENERALIZATION_SET__IS_DISJOINT:
				return isDisjoint != IS_DISJOINT_EDEFAULT;
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASS:
				return specializedClass != null;
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZING_CLASSES:
				return specializingClasses != null && !specializingClasses.isEmpty();
			case OntoumlPackage.GENERALIZATION_SET__POWERTYPE:
				return powertype != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == PackageableElement.class) {
			switch (derivedFeatureID) {
				case OntoumlPackage.GENERALIZATION_SET__CONTAINER_: return OntoumlPackage.PACKAGEABLE_ELEMENT__CONTAINER_;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == PackageableElement.class) {
			switch (baseFeatureID) {
				case OntoumlPackage.PACKAGEABLE_ELEMENT__CONTAINER_: return OntoumlPackage.GENERALIZATION_SET__CONTAINER_;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (isCovering: ");
		result.append(isCovering);
		result.append(", isDisjoint: ");
		result.append(isDisjoint);
		result.append(')');
		return result.toString();
	}

} //GeneralizationSetImpl
