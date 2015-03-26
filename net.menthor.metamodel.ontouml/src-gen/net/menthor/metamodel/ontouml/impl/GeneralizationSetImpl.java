/**
 */
package net.menthor.metamodel.ontouml.impl;

import java.util.Collection;

import net.menthor.metamodel.ontouml.ContainingElement;
import net.menthor.metamodel.ontouml.GeneralizationSet;
import net.menthor.metamodel.ontouml.OntoumlPackage;

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
 * An implementation of the model object '<em><b>Generalization Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.GeneralizationSetImpl#getHolder <em>Holder</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.GeneralizationSetImpl#isIsCovering <em>Is Covering</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.GeneralizationSetImpl#getSpecializedClass <em>Specialized Class</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.GeneralizationSetImpl#getSpecializingClasses <em>Specializing Classes</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.GeneralizationSetImpl#getHou <em>Hou</em>}</li>
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
	 * The cached value of the '{@link #getHou() <em>Hou</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHou()
	 * @generated
	 * @ordered
	 */
	protected net.menthor.metamodel.ontouml.Class hou;

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
	public net.menthor.metamodel.ontouml.Container getHolder() {
		if (eContainerFeatureID() != OntoumlPackage.GENERALIZATION_SET__HOLDER) return null;
		return (net.menthor.metamodel.ontouml.Container)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Container basicGetHolder() {
		if (eContainerFeatureID() != OntoumlPackage.GENERALIZATION_SET__HOLDER) return null;
		return (net.menthor.metamodel.ontouml.Container)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHolder(net.menthor.metamodel.ontouml.Container newHolder, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newHolder, OntoumlPackage.GENERALIZATION_SET__HOLDER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHolder(net.menthor.metamodel.ontouml.Container newHolder) {
		if (newHolder != eInternalContainer() || (eContainerFeatureID() != OntoumlPackage.GENERALIZATION_SET__HOLDER && newHolder != null)) {
			if (EcoreUtil.isAncestor(this, newHolder))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newHolder != null)
				msgs = ((InternalEObject)newHolder).eInverseAdd(this, OntoumlPackage.CONTAINER__ELEMENTS, net.menthor.metamodel.ontouml.Container.class, msgs);
			msgs = basicSetHolder(newHolder, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.GENERALIZATION_SET__HOLDER, newHolder, newHolder));
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
	public net.menthor.metamodel.ontouml.Class getSpecializedClass() {
		if (specializedClass != null && specializedClass.eIsProxy()) {
			InternalEObject oldSpecializedClass = (InternalEObject)specializedClass;
			specializedClass = (net.menthor.metamodel.ontouml.Class)eResolveProxy(oldSpecializedClass);
			if (specializedClass != oldSpecializedClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASS, oldSpecializedClass, specializedClass));
			}
		}
		return specializedClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class basicGetSpecializedClass() {
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
			specializingClasses = new EObjectWithInverseResolvingEList.ManyInverse<net.menthor.metamodel.ontouml.Class>(net.menthor.metamodel.ontouml.Class.class, this, OntoumlPackage.GENERALIZATION_SET__SPECIALIZING_CLASSES, OntoumlPackage.CLASS__SPECIALIZES_VIA);
		}
		return specializingClasses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class getHou() {
		if (hou != null && hou.eIsProxy()) {
			InternalEObject oldHou = (InternalEObject)hou;
			hou = (net.menthor.metamodel.ontouml.Class)eResolveProxy(oldHou);
			if (hou != oldHou) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.GENERALIZATION_SET__HOU, oldHou, hou));
			}
		}
		return hou;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class basicGetHou() {
		return hou;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHou(net.menthor.metamodel.ontouml.Class newHou) {
		net.menthor.metamodel.ontouml.Class oldHou = hou;
		hou = newHou;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.GENERALIZATION_SET__HOU, oldHou, hou));
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
			case OntoumlPackage.GENERALIZATION_SET__HOLDER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetHolder((net.menthor.metamodel.ontouml.Container)otherEnd, msgs);
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
			case OntoumlPackage.GENERALIZATION_SET__HOLDER:
				return basicSetHolder(null, msgs);
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
			case OntoumlPackage.GENERALIZATION_SET__HOLDER:
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
			case OntoumlPackage.GENERALIZATION_SET__HOLDER:
				if (resolve) return getHolder();
				return basicGetHolder();
			case OntoumlPackage.GENERALIZATION_SET__IS_COVERING:
				return isIsCovering();
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASS:
				if (resolve) return getSpecializedClass();
				return basicGetSpecializedClass();
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZING_CLASSES:
				return getSpecializingClasses();
			case OntoumlPackage.GENERALIZATION_SET__HOU:
				if (resolve) return getHou();
				return basicGetHou();
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
			case OntoumlPackage.GENERALIZATION_SET__HOLDER:
				setHolder((net.menthor.metamodel.ontouml.Container)newValue);
				return;
			case OntoumlPackage.GENERALIZATION_SET__IS_COVERING:
				setIsCovering((Boolean)newValue);
				return;
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASS:
				setSpecializedClass((net.menthor.metamodel.ontouml.Class)newValue);
				return;
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZING_CLASSES:
				getSpecializingClasses().clear();
				getSpecializingClasses().addAll((Collection<? extends net.menthor.metamodel.ontouml.Class>)newValue);
				return;
			case OntoumlPackage.GENERALIZATION_SET__HOU:
				setHou((net.menthor.metamodel.ontouml.Class)newValue);
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
			case OntoumlPackage.GENERALIZATION_SET__HOLDER:
				setHolder((net.menthor.metamodel.ontouml.Container)null);
				return;
			case OntoumlPackage.GENERALIZATION_SET__IS_COVERING:
				setIsCovering(IS_COVERING_EDEFAULT);
				return;
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASS:
				setSpecializedClass((net.menthor.metamodel.ontouml.Class)null);
				return;
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZING_CLASSES:
				getSpecializingClasses().clear();
				return;
			case OntoumlPackage.GENERALIZATION_SET__HOU:
				setHou((net.menthor.metamodel.ontouml.Class)null);
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
			case OntoumlPackage.GENERALIZATION_SET__HOLDER:
				return basicGetHolder() != null;
			case OntoumlPackage.GENERALIZATION_SET__IS_COVERING:
				return isCovering != IS_COVERING_EDEFAULT;
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASS:
				return specializedClass != null;
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZING_CLASSES:
				return specializingClasses != null && !specializingClasses.isEmpty();
			case OntoumlPackage.GENERALIZATION_SET__HOU:
				return hou != null;
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
		if (baseClass == ContainingElement.class) {
			switch (derivedFeatureID) {
				case OntoumlPackage.GENERALIZATION_SET__HOLDER: return OntoumlPackage.CONTAINING_ELEMENT__HOLDER;
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
		if (baseClass == ContainingElement.class) {
			switch (baseFeatureID) {
				case OntoumlPackage.CONTAINING_ELEMENT__HOLDER: return OntoumlPackage.GENERALIZATION_SET__HOLDER;
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
		result.append(')');
		return result.toString();
	}

} //GeneralizationSetImpl
