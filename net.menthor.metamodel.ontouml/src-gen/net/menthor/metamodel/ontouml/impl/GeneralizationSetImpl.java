/**
 */
package net.menthor.metamodel.ontouml.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import net.menthor.metamodel.ontouml.Classifier;
import net.menthor.metamodel.ontouml.Comment;
import net.menthor.metamodel.ontouml.ContainedElement;
import net.menthor.metamodel.ontouml.GeneralizationSet;
import net.menthor.metamodel.ontouml.Model;
import net.menthor.metamodel.ontouml.OntoumlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
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
 *   <li>{@link net.menthor.metamodel.ontouml.impl.GeneralizationSetImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.GeneralizationSetImpl#isIsCovering <em>Is Covering</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.GeneralizationSetImpl#getSpecializedClassifier <em>Specialized Classifier</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.GeneralizationSetImpl#getSpecializingClassifier <em>Specializing Classifier</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.GeneralizationSetImpl#getHighOrder <em>High Order</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GeneralizationSetImpl extends NamedElementImpl implements GeneralizationSet {
	/**
	 * The cached value of the '{@link #getComments() <em>Comments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComments()
	 * @generated
	 * @ordered
	 */
	protected EList<Comment> comments;

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
	 * The cached value of the '{@link #getSpecializedClassifier() <em>Specialized Classifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecializedClassifier()
	 * @generated
	 * @ordered
	 */
	protected Classifier specializedClassifier;

	/**
	 * The cached value of the '{@link #getSpecializingClassifier() <em>Specializing Classifier</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecializingClassifier()
	 * @generated
	 * @ordered
	 */
	protected EList<Classifier> specializingClassifier;

	/**
	 * The cached value of the '{@link #getHighOrder() <em>High Order</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHighOrder()
	 * @generated
	 * @ordered
	 */
	protected net.menthor.metamodel.ontouml.Class highOrder;

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
	public EList<Comment> getComments() {
		if (comments == null) {
			comments = new EObjectContainmentWithInverseEList<Comment>(Comment.class, this, OntoumlPackage.GENERALIZATION_SET__COMMENTS, OntoumlPackage.COMMENT__OWNER);
		}
		return comments;
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
	public Classifier getSpecializedClassifier() {
		if (specializedClassifier != null && specializedClassifier.eIsProxy()) {
			InternalEObject oldSpecializedClassifier = (InternalEObject)specializedClassifier;
			specializedClassifier = (Classifier)eResolveProxy(oldSpecializedClassifier);
			if (specializedClassifier != oldSpecializedClassifier) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASSIFIER, oldSpecializedClassifier, specializedClassifier));
			}
		}
		return specializedClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier basicGetSpecializedClassifier() {
		return specializedClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSpecializedClassifier(Classifier newSpecializedClassifier, NotificationChain msgs) {
		Classifier oldSpecializedClassifier = specializedClassifier;
		specializedClassifier = newSpecializedClassifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASSIFIER, oldSpecializedClassifier, newSpecializedClassifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecializedClassifier(Classifier newSpecializedClassifier) {
		if (newSpecializedClassifier != specializedClassifier) {
			NotificationChain msgs = null;
			if (specializedClassifier != null)
				msgs = ((InternalEObject)specializedClassifier).eInverseRemove(this, OntoumlPackage.CLASSIFIER__IS_SPECIALIZED_VIA, Classifier.class, msgs);
			if (newSpecializedClassifier != null)
				msgs = ((InternalEObject)newSpecializedClassifier).eInverseAdd(this, OntoumlPackage.CLASSIFIER__IS_SPECIALIZED_VIA, Classifier.class, msgs);
			msgs = basicSetSpecializedClassifier(newSpecializedClassifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASSIFIER, newSpecializedClassifier, newSpecializedClassifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Classifier> getSpecializingClassifier() {
		if (specializingClassifier == null) {
			specializingClassifier = new EObjectWithInverseResolvingEList.ManyInverse<Classifier>(Classifier.class, this, OntoumlPackage.GENERALIZATION_SET__SPECIALIZING_CLASSIFIER, OntoumlPackage.CLASSIFIER__SPECIALIZES_VIA);
		}
		return specializingClassifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class getHighOrder() {
		if (highOrder != null && highOrder.eIsProxy()) {
			InternalEObject oldHighOrder = (InternalEObject)highOrder;
			highOrder = (net.menthor.metamodel.ontouml.Class)eResolveProxy(oldHighOrder);
			if (highOrder != oldHighOrder) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.GENERALIZATION_SET__HIGH_ORDER, oldHighOrder, highOrder));
			}
		}
		return highOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class basicGetHighOrder() {
		return highOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHighOrder(net.menthor.metamodel.ontouml.Class newHighOrder) {
		net.menthor.metamodel.ontouml.Class oldHighOrder = highOrder;
		highOrder = newHighOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.GENERALIZATION_SET__HIGH_ORDER, oldHighOrder, highOrder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getModel(final net.menthor.metamodel.ontouml.Container c) {
		if ((c instanceof Model)) {
			return ((Model)c);
		}
		else {
			if ((c instanceof ContainedElement)) {
				net.menthor.metamodel.ontouml.Container _holder = ((ContainedElement)c).getHolder();
				return this.getModel(_holder);
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getModel() {
		net.menthor.metamodel.ontouml.Container _holder = this.getHolder();
		return this.getModel(_holder);
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
			case OntoumlPackage.GENERALIZATION_SET__COMMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComments()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASSIFIER:
				if (specializedClassifier != null)
					msgs = ((InternalEObject)specializedClassifier).eInverseRemove(this, OntoumlPackage.CLASSIFIER__IS_SPECIALIZED_VIA, Classifier.class, msgs);
				return basicSetSpecializedClassifier((Classifier)otherEnd, msgs);
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZING_CLASSIFIER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpecializingClassifier()).basicAdd(otherEnd, msgs);
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
			case OntoumlPackage.GENERALIZATION_SET__COMMENTS:
				return ((InternalEList<?>)getComments()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASSIFIER:
				return basicSetSpecializedClassifier(null, msgs);
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZING_CLASSIFIER:
				return ((InternalEList<?>)getSpecializingClassifier()).basicRemove(otherEnd, msgs);
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
			case OntoumlPackage.GENERALIZATION_SET__COMMENTS:
				return getComments();
			case OntoumlPackage.GENERALIZATION_SET__IS_COVERING:
				return isIsCovering();
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASSIFIER:
				if (resolve) return getSpecializedClassifier();
				return basicGetSpecializedClassifier();
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZING_CLASSIFIER:
				return getSpecializingClassifier();
			case OntoumlPackage.GENERALIZATION_SET__HIGH_ORDER:
				if (resolve) return getHighOrder();
				return basicGetHighOrder();
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
			case OntoumlPackage.GENERALIZATION_SET__COMMENTS:
				getComments().clear();
				getComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case OntoumlPackage.GENERALIZATION_SET__IS_COVERING:
				setIsCovering((Boolean)newValue);
				return;
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASSIFIER:
				setSpecializedClassifier((Classifier)newValue);
				return;
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZING_CLASSIFIER:
				getSpecializingClassifier().clear();
				getSpecializingClassifier().addAll((Collection<? extends Classifier>)newValue);
				return;
			case OntoumlPackage.GENERALIZATION_SET__HIGH_ORDER:
				setHighOrder((net.menthor.metamodel.ontouml.Class)newValue);
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
			case OntoumlPackage.GENERALIZATION_SET__COMMENTS:
				getComments().clear();
				return;
			case OntoumlPackage.GENERALIZATION_SET__IS_COVERING:
				setIsCovering(IS_COVERING_EDEFAULT);
				return;
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASSIFIER:
				setSpecializedClassifier((Classifier)null);
				return;
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZING_CLASSIFIER:
				getSpecializingClassifier().clear();
				return;
			case OntoumlPackage.GENERALIZATION_SET__HIGH_ORDER:
				setHighOrder((net.menthor.metamodel.ontouml.Class)null);
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
			case OntoumlPackage.GENERALIZATION_SET__COMMENTS:
				return comments != null && !comments.isEmpty();
			case OntoumlPackage.GENERALIZATION_SET__IS_COVERING:
				return isCovering != IS_COVERING_EDEFAULT;
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASSIFIER:
				return specializedClassifier != null;
			case OntoumlPackage.GENERALIZATION_SET__SPECIALIZING_CLASSIFIER:
				return specializingClassifier != null && !specializingClassifier.isEmpty();
			case OntoumlPackage.GENERALIZATION_SET__HIGH_ORDER:
				return highOrder != null;
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
		if (baseClass == ContainedElement.class) {
			switch (derivedFeatureID) {
				case OntoumlPackage.GENERALIZATION_SET__HOLDER: return OntoumlPackage.CONTAINED_ELEMENT__HOLDER;
				case OntoumlPackage.GENERALIZATION_SET__COMMENTS: return OntoumlPackage.CONTAINED_ELEMENT__COMMENTS;
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
		if (baseClass == ContainedElement.class) {
			switch (baseFeatureID) {
				case OntoumlPackage.CONTAINED_ELEMENT__HOLDER: return OntoumlPackage.GENERALIZATION_SET__HOLDER;
				case OntoumlPackage.CONTAINED_ELEMENT__COMMENTS: return OntoumlPackage.GENERALIZATION_SET__COMMENTS;
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
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == ContainedElement.class) {
			switch (baseOperationID) {
				case OntoumlPackage.CONTAINED_ELEMENT___GET_MODEL__CONTAINER: return OntoumlPackage.GENERALIZATION_SET___GET_MODEL__CONTAINER;
				case OntoumlPackage.CONTAINED_ELEMENT___GET_MODEL: return OntoumlPackage.GENERALIZATION_SET___GET_MODEL;
				default: return -1;
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case OntoumlPackage.GENERALIZATION_SET___GET_MODEL__CONTAINER:
				return getModel((net.menthor.metamodel.ontouml.Container)arguments.get(0));
			case OntoumlPackage.GENERALIZATION_SET___GET_MODEL:
				return getModel();
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
		result.append(" (isCovering: ");
		result.append(isCovering);
		result.append(')');
		return result.toString();
	}

} //GeneralizationSetImpl
