/**
 */
package net.menthor.metamodel.ontouml.impl;

import java.util.Collection;

import net.menthor.metamodel.ontouml.ClassBinaryRelationship;
import net.menthor.metamodel.ontouml.DataType;
import net.menthor.metamodel.ontouml.GeneralizationSet;
import net.menthor.metamodel.ontouml.HighOrderClass;
import net.menthor.metamodel.ontouml.MaterialRelationship;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.PackageableElement;
import net.menthor.metamodel.ontouml.Universal;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getContainer_ <em>Container </em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#isIsDerived <em>Is Derived</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#isIsExtensional <em>Is Extensional</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getInstanceOf <em>Instance Of</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getDatatypes <em>Datatypes</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getIsSpecializedVia <em>Is Specialized Via</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getSpecializesVia <em>Specializes Via</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getIsSourceOf <em>Is Source Of</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getIsTargetOf <em>Is Target Of</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getIsTruthMakerOf <em>Is Truth Maker Of</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassImpl extends NamedElementImpl implements net.menthor.metamodel.ontouml.Class {
	/**
	 * The default value of the '{@link #getStereotype() <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotype()
	 * @generated
	 * @ordered
	 */
	protected static final Universal STEREOTYPE_EDEFAULT = Universal.KIND;

	/**
	 * The cached value of the '{@link #getStereotype() <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotype()
	 * @generated
	 * @ordered
	 */
	protected Universal stereotype = STEREOTYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsDerived() <em>Is Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDerived()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DERIVED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsDerived() <em>Is Derived</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDerived()
	 * @generated
	 * @ordered
	 */
	protected boolean isDerived = IS_DERIVED_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsExtensional() <em>Is Extensional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsExtensional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_EXTENSIONAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsExtensional() <em>Is Extensional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsExtensional()
	 * @generated
	 * @ordered
	 */
	protected boolean isExtensional = IS_EXTENSIONAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInstanceOf() <em>Instance Of</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceOf()
	 * @generated
	 * @ordered
	 */
	protected EList<HighOrderClass> instanceOf;

	/**
	 * The cached value of the '{@link #getDatatypes() <em>Datatypes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatatypes()
	 * @generated
	 * @ordered
	 */
	protected EList<DataType> datatypes;

	/**
	 * The cached value of the '{@link #getIsSpecializedVia() <em>Is Specialized Via</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsSpecializedVia()
	 * @generated
	 * @ordered
	 */
	protected EList<GeneralizationSet> isSpecializedVia;

	/**
	 * The cached value of the '{@link #getSpecializesVia() <em>Specializes Via</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecializesVia()
	 * @generated
	 * @ordered
	 */
	protected EList<GeneralizationSet> specializesVia;

	/**
	 * The cached value of the '{@link #getIsSourceOf() <em>Is Source Of</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsSourceOf()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassBinaryRelationship> isSourceOf;

	/**
	 * The cached value of the '{@link #getIsTargetOf() <em>Is Target Of</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsTargetOf()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassBinaryRelationship> isTargetOf;

	/**
	 * The cached value of the '{@link #getIsTruthMakerOf() <em>Is Truth Maker Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsTruthMakerOf()
	 * @generated
	 * @ordered
	 */
	protected MaterialRelationship isTruthMakerOf;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OntoumlPackage.Literals.CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Container getContainer_() {
		if (eContainerFeatureID() != OntoumlPackage.CLASS__CONTAINER_) return null;
		return (net.menthor.metamodel.ontouml.Container)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Container basicGetContainer_() {
		if (eContainerFeatureID() != OntoumlPackage.CLASS__CONTAINER_) return null;
		return (net.menthor.metamodel.ontouml.Container)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainer_(net.menthor.metamodel.ontouml.Container newContainer_, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainer_, OntoumlPackage.CLASS__CONTAINER_, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer_(net.menthor.metamodel.ontouml.Container newContainer_) {
		if (newContainer_ != eInternalContainer() || (eContainerFeatureID() != OntoumlPackage.CLASS__CONTAINER_ && newContainer_ != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS__CONTAINER_, newContainer_, newContainer_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Universal getStereotype() {
		return stereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotype(Universal newStereotype) {
		Universal oldStereotype = stereotype;
		stereotype = newStereotype == null ? STEREOTYPE_EDEFAULT : newStereotype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS__STEREOTYPE, oldStereotype, stereotype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsDerived() {
		return isDerived;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDerived(boolean newIsDerived) {
		boolean oldIsDerived = isDerived;
		isDerived = newIsDerived;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS__IS_DERIVED, oldIsDerived, isDerived));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsExtensional() {
		return isExtensional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsExtensional(boolean newIsExtensional) {
		boolean oldIsExtensional = isExtensional;
		isExtensional = newIsExtensional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS__IS_EXTENSIONAL, oldIsExtensional, isExtensional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HighOrderClass> getInstanceOf() {
		if (instanceOf == null) {
			instanceOf = new EObjectResolvingEList<HighOrderClass>(HighOrderClass.class, this, OntoumlPackage.CLASS__INSTANCE_OF);
		}
		return instanceOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataType> getDatatypes() {
		if (datatypes == null) {
			datatypes = new EObjectResolvingEList<DataType>(DataType.class, this, OntoumlPackage.CLASS__DATATYPES);
		}
		return datatypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GeneralizationSet> getIsSpecializedVia() {
		if (isSpecializedVia == null) {
			isSpecializedVia = new EObjectWithInverseResolvingEList<GeneralizationSet>(GeneralizationSet.class, this, OntoumlPackage.CLASS__IS_SPECIALIZED_VIA, OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASS);
		}
		return isSpecializedVia;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GeneralizationSet> getSpecializesVia() {
		if (specializesVia == null) {
			specializesVia = new EObjectWithInverseResolvingEList.ManyInverse<GeneralizationSet>(GeneralizationSet.class, this, OntoumlPackage.CLASS__SPECIALIZES_VIA, OntoumlPackage.GENERALIZATION_SET__SPECIALIZING_CLASSES);
		}
		return specializesVia;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassBinaryRelationship> getIsSourceOf() {
		if (isSourceOf == null) {
			isSourceOf = new EObjectWithInverseResolvingEList<ClassBinaryRelationship>(ClassBinaryRelationship.class, this, OntoumlPackage.CLASS__IS_SOURCE_OF, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__SOURCE);
		}
		return isSourceOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassBinaryRelationship> getIsTargetOf() {
		if (isTargetOf == null) {
			isTargetOf = new EObjectWithInverseResolvingEList<ClassBinaryRelationship>(ClassBinaryRelationship.class, this, OntoumlPackage.CLASS__IS_TARGET_OF, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TARGET);
		}
		return isTargetOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MaterialRelationship getIsTruthMakerOf() {
		if (isTruthMakerOf != null && isTruthMakerOf.eIsProxy()) {
			InternalEObject oldIsTruthMakerOf = (InternalEObject)isTruthMakerOf;
			isTruthMakerOf = (MaterialRelationship)eResolveProxy(oldIsTruthMakerOf);
			if (isTruthMakerOf != oldIsTruthMakerOf) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.CLASS__IS_TRUTH_MAKER_OF, oldIsTruthMakerOf, isTruthMakerOf));
			}
		}
		return isTruthMakerOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MaterialRelationship basicGetIsTruthMakerOf() {
		return isTruthMakerOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIsTruthMakerOf(MaterialRelationship newIsTruthMakerOf, NotificationChain msgs) {
		MaterialRelationship oldIsTruthMakerOf = isTruthMakerOf;
		isTruthMakerOf = newIsTruthMakerOf;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS__IS_TRUTH_MAKER_OF, oldIsTruthMakerOf, newIsTruthMakerOf);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsTruthMakerOf(MaterialRelationship newIsTruthMakerOf) {
		if (newIsTruthMakerOf != isTruthMakerOf) {
			NotificationChain msgs = null;
			if (isTruthMakerOf != null)
				msgs = ((InternalEObject)isTruthMakerOf).eInverseRemove(this, OntoumlPackage.MATERIAL_RELATIONSHIP__IS_DERIVED_FROM, MaterialRelationship.class, msgs);
			if (newIsTruthMakerOf != null)
				msgs = ((InternalEObject)newIsTruthMakerOf).eInverseAdd(this, OntoumlPackage.MATERIAL_RELATIONSHIP__IS_DERIVED_FROM, MaterialRelationship.class, msgs);
			msgs = basicSetIsTruthMakerOf(newIsTruthMakerOf, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS__IS_TRUTH_MAKER_OF, newIsTruthMakerOf, newIsTruthMakerOf));
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
			case OntoumlPackage.CLASS__CONTAINER_:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainer_((net.menthor.metamodel.ontouml.Container)otherEnd, msgs);
			case OntoumlPackage.CLASS__IS_SPECIALIZED_VIA:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIsSpecializedVia()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.CLASS__SPECIALIZES_VIA:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpecializesVia()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.CLASS__IS_SOURCE_OF:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIsSourceOf()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.CLASS__IS_TARGET_OF:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIsTargetOf()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.CLASS__IS_TRUTH_MAKER_OF:
				if (isTruthMakerOf != null)
					msgs = ((InternalEObject)isTruthMakerOf).eInverseRemove(this, OntoumlPackage.MATERIAL_RELATIONSHIP__IS_DERIVED_FROM, MaterialRelationship.class, msgs);
				return basicSetIsTruthMakerOf((MaterialRelationship)otherEnd, msgs);
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
			case OntoumlPackage.CLASS__CONTAINER_:
				return basicSetContainer_(null, msgs);
			case OntoumlPackage.CLASS__IS_SPECIALIZED_VIA:
				return ((InternalEList<?>)getIsSpecializedVia()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.CLASS__SPECIALIZES_VIA:
				return ((InternalEList<?>)getSpecializesVia()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.CLASS__IS_SOURCE_OF:
				return ((InternalEList<?>)getIsSourceOf()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.CLASS__IS_TARGET_OF:
				return ((InternalEList<?>)getIsTargetOf()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.CLASS__IS_TRUTH_MAKER_OF:
				return basicSetIsTruthMakerOf(null, msgs);
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
			case OntoumlPackage.CLASS__CONTAINER_:
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
			case OntoumlPackage.CLASS__CONTAINER_:
				if (resolve) return getContainer_();
				return basicGetContainer_();
			case OntoumlPackage.CLASS__STEREOTYPE:
				return getStereotype();
			case OntoumlPackage.CLASS__IS_DERIVED:
				return isIsDerived();
			case OntoumlPackage.CLASS__IS_EXTENSIONAL:
				return isIsExtensional();
			case OntoumlPackage.CLASS__INSTANCE_OF:
				return getInstanceOf();
			case OntoumlPackage.CLASS__DATATYPES:
				return getDatatypes();
			case OntoumlPackage.CLASS__IS_SPECIALIZED_VIA:
				return getIsSpecializedVia();
			case OntoumlPackage.CLASS__SPECIALIZES_VIA:
				return getSpecializesVia();
			case OntoumlPackage.CLASS__IS_SOURCE_OF:
				return getIsSourceOf();
			case OntoumlPackage.CLASS__IS_TARGET_OF:
				return getIsTargetOf();
			case OntoumlPackage.CLASS__IS_TRUTH_MAKER_OF:
				if (resolve) return getIsTruthMakerOf();
				return basicGetIsTruthMakerOf();
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
			case OntoumlPackage.CLASS__CONTAINER_:
				setContainer_((net.menthor.metamodel.ontouml.Container)newValue);
				return;
			case OntoumlPackage.CLASS__STEREOTYPE:
				setStereotype((Universal)newValue);
				return;
			case OntoumlPackage.CLASS__IS_DERIVED:
				setIsDerived((Boolean)newValue);
				return;
			case OntoumlPackage.CLASS__IS_EXTENSIONAL:
				setIsExtensional((Boolean)newValue);
				return;
			case OntoumlPackage.CLASS__INSTANCE_OF:
				getInstanceOf().clear();
				getInstanceOf().addAll((Collection<? extends HighOrderClass>)newValue);
				return;
			case OntoumlPackage.CLASS__DATATYPES:
				getDatatypes().clear();
				getDatatypes().addAll((Collection<? extends DataType>)newValue);
				return;
			case OntoumlPackage.CLASS__IS_SPECIALIZED_VIA:
				getIsSpecializedVia().clear();
				getIsSpecializedVia().addAll((Collection<? extends GeneralizationSet>)newValue);
				return;
			case OntoumlPackage.CLASS__SPECIALIZES_VIA:
				getSpecializesVia().clear();
				getSpecializesVia().addAll((Collection<? extends GeneralizationSet>)newValue);
				return;
			case OntoumlPackage.CLASS__IS_SOURCE_OF:
				getIsSourceOf().clear();
				getIsSourceOf().addAll((Collection<? extends ClassBinaryRelationship>)newValue);
				return;
			case OntoumlPackage.CLASS__IS_TARGET_OF:
				getIsTargetOf().clear();
				getIsTargetOf().addAll((Collection<? extends ClassBinaryRelationship>)newValue);
				return;
			case OntoumlPackage.CLASS__IS_TRUTH_MAKER_OF:
				setIsTruthMakerOf((MaterialRelationship)newValue);
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
			case OntoumlPackage.CLASS__CONTAINER_:
				setContainer_((net.menthor.metamodel.ontouml.Container)null);
				return;
			case OntoumlPackage.CLASS__STEREOTYPE:
				setStereotype(STEREOTYPE_EDEFAULT);
				return;
			case OntoumlPackage.CLASS__IS_DERIVED:
				setIsDerived(IS_DERIVED_EDEFAULT);
				return;
			case OntoumlPackage.CLASS__IS_EXTENSIONAL:
				setIsExtensional(IS_EXTENSIONAL_EDEFAULT);
				return;
			case OntoumlPackage.CLASS__INSTANCE_OF:
				getInstanceOf().clear();
				return;
			case OntoumlPackage.CLASS__DATATYPES:
				getDatatypes().clear();
				return;
			case OntoumlPackage.CLASS__IS_SPECIALIZED_VIA:
				getIsSpecializedVia().clear();
				return;
			case OntoumlPackage.CLASS__SPECIALIZES_VIA:
				getSpecializesVia().clear();
				return;
			case OntoumlPackage.CLASS__IS_SOURCE_OF:
				getIsSourceOf().clear();
				return;
			case OntoumlPackage.CLASS__IS_TARGET_OF:
				getIsTargetOf().clear();
				return;
			case OntoumlPackage.CLASS__IS_TRUTH_MAKER_OF:
				setIsTruthMakerOf((MaterialRelationship)null);
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
			case OntoumlPackage.CLASS__CONTAINER_:
				return basicGetContainer_() != null;
			case OntoumlPackage.CLASS__STEREOTYPE:
				return stereotype != STEREOTYPE_EDEFAULT;
			case OntoumlPackage.CLASS__IS_DERIVED:
				return isDerived != IS_DERIVED_EDEFAULT;
			case OntoumlPackage.CLASS__IS_EXTENSIONAL:
				return isExtensional != IS_EXTENSIONAL_EDEFAULT;
			case OntoumlPackage.CLASS__INSTANCE_OF:
				return instanceOf != null && !instanceOf.isEmpty();
			case OntoumlPackage.CLASS__DATATYPES:
				return datatypes != null && !datatypes.isEmpty();
			case OntoumlPackage.CLASS__IS_SPECIALIZED_VIA:
				return isSpecializedVia != null && !isSpecializedVia.isEmpty();
			case OntoumlPackage.CLASS__SPECIALIZES_VIA:
				return specializesVia != null && !specializesVia.isEmpty();
			case OntoumlPackage.CLASS__IS_SOURCE_OF:
				return isSourceOf != null && !isSourceOf.isEmpty();
			case OntoumlPackage.CLASS__IS_TARGET_OF:
				return isTargetOf != null && !isTargetOf.isEmpty();
			case OntoumlPackage.CLASS__IS_TRUTH_MAKER_OF:
				return isTruthMakerOf != null;
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
				case OntoumlPackage.CLASS__CONTAINER_: return OntoumlPackage.PACKAGEABLE_ELEMENT__CONTAINER_;
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
				case OntoumlPackage.PACKAGEABLE_ELEMENT__CONTAINER_: return OntoumlPackage.CLASS__CONTAINER_;
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
		result.append(" (stereotype: ");
		result.append(stereotype);
		result.append(", isDerived: ");
		result.append(isDerived);
		result.append(", isExtensional: ");
		result.append(isExtensional);
		result.append(')');
		return result.toString();
	}

} //ClassImpl
