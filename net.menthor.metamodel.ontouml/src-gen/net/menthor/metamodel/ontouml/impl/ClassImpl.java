/**
 */
package net.menthor.metamodel.ontouml.impl;

import com.google.common.base.Objects;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import net.menthor.metamodel.ontouml.Attribute;
import net.menthor.metamodel.ontouml.ClassBinaryRelationship;
import net.menthor.metamodel.ontouml.ContainingElement;
import net.menthor.metamodel.ontouml.GeneralizationSet;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.Universal;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
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
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getHolder <em>Holder</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#isIsDerived <em>Is Derived</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#isIsExtensional <em>Is Extensional</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getEnumerationLiterals <em>Enumeration Literals</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getInstanceOf <em>Instance Of</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getIstruthMakerOf <em>Istruth Maker Of</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getIsSpecializedVia <em>Is Specialized Via</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getSpecializesVia <em>Specializes Via</em>}</li>
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
	 * The default value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean isAbstract = IS_ABSTRACT_EDEFAULT;

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
	 * The cached value of the '{@link #getEnumerationLiterals() <em>Enumeration Literals</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumerationLiterals()
	 * @generated
	 * @ordered
	 */
	protected EList<String> enumerationLiterals;

	/**
	 * The cached value of the '{@link #getInstanceOf() <em>Instance Of</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceOf()
	 * @generated
	 * @ordered
	 */
	protected EList<net.menthor.metamodel.ontouml.Class> instanceOf;

	/**
	 * The cached value of the '{@link #getIstruthMakerOf() <em>Istruth Maker Of</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIstruthMakerOf()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassBinaryRelationship> istruthMakerOf;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attributes;

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
	public net.menthor.metamodel.ontouml.Container getHolder() {
		if (eContainerFeatureID() != OntoumlPackage.CLASS__HOLDER) return null;
		return (net.menthor.metamodel.ontouml.Container)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Container basicGetHolder() {
		if (eContainerFeatureID() != OntoumlPackage.CLASS__HOLDER) return null;
		return (net.menthor.metamodel.ontouml.Container)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHolder(net.menthor.metamodel.ontouml.Container newHolder, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newHolder, OntoumlPackage.CLASS__HOLDER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHolder(net.menthor.metamodel.ontouml.Container newHolder) {
		if (newHolder != eInternalContainer() || (eContainerFeatureID() != OntoumlPackage.CLASS__HOLDER && newHolder != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS__HOLDER, newHolder, newHolder));
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
	public boolean isIsAbstract() {
		return isAbstract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsAbstract(boolean newIsAbstract) {
		boolean oldIsAbstract = isAbstract;
		isAbstract = newIsAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS__IS_ABSTRACT, oldIsAbstract, isAbstract));
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
	public EList<String> getEnumerationLiterals() {
		if (enumerationLiterals == null) {
			enumerationLiterals = new EDataTypeEList<String>(String.class, this, OntoumlPackage.CLASS__ENUMERATION_LITERALS);
		}
		return enumerationLiterals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<net.menthor.metamodel.ontouml.Class> getInstanceOf() {
		if (instanceOf == null) {
			instanceOf = new EObjectResolvingEList<net.menthor.metamodel.ontouml.Class>(net.menthor.metamodel.ontouml.Class.class, this, OntoumlPackage.CLASS__INSTANCE_OF);
		}
		return instanceOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassBinaryRelationship> getIstruthMakerOf() {
		if (istruthMakerOf == null) {
			istruthMakerOf = new EObjectWithInverseResolvingEList<ClassBinaryRelationship>(ClassBinaryRelationship.class, this, OntoumlPackage.CLASS__ISTRUTH_MAKER_OF, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TRUTH_MAKER);
		}
		return istruthMakerOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectWithInverseResolvingEList<Attribute>(Attribute.class, this, OntoumlPackage.CLASS__ATTRIBUTES, OntoumlPackage.ATTRIBUTE__OWNER);
		}
		return attributes;
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
	public boolean isRigid() {
		boolean _or = false;
		boolean _or_1 = false;
		boolean _or_2 = false;
		boolean _or_3 = false;
		boolean _or_4 = false;
		boolean _or_5 = false;
		boolean _or_6 = false;
		boolean _or_7 = false;
		boolean _or_8 = false;
		Universal _stereotype = this.getStereotype();
		boolean _equals = Objects.equal(_stereotype, Universal.KIND);
		if (_equals) {
			_or_8 = true;
		} else {
			Universal _stereotype_1 = this.getStereotype();
			boolean _equals_1 = Objects.equal(_stereotype_1, Universal.COLLECTIVE);
			_or_8 = _equals_1;
		}
		if (_or_8) {
			_or_7 = true;
		} else {
			Universal _stereotype_2 = this.getStereotype();
			boolean _equals_2 = Objects.equal(_stereotype_2, Universal.QUANTITY);
			_or_7 = _equals_2;
		}
		if (_or_7) {
			_or_6 = true;
		} else {
			Universal _stereotype_3 = this.getStereotype();
			boolean _equals_3 = Objects.equal(_stereotype_3, Universal.RELATOR);
			_or_6 = _equals_3;
		}
		if (_or_6) {
			_or_5 = true;
		} else {
			Universal _stereotype_4 = this.getStereotype();
			boolean _equals_4 = Objects.equal(_stereotype_4, Universal.MODE);
			_or_5 = _equals_4;
		}
		if (_or_5) {
			_or_4 = true;
		} else {
			Universal _stereotype_5 = this.getStereotype();
			boolean _equals_5 = Objects.equal(_stereotype_5, Universal.NOMINAL_QUALITY);
			_or_4 = _equals_5;
		}
		if (_or_4) {
			_or_3 = true;
		} else {
			Universal _stereotype_6 = this.getStereotype();
			boolean _equals_6 = Objects.equal(_stereotype_6, Universal.PERCEIVABLE_QUALITY);
			_or_3 = _equals_6;
		}
		if (_or_3) {
			_or_2 = true;
		} else {
			Universal _stereotype_7 = this.getStereotype();
			boolean _equals_7 = Objects.equal(_stereotype_7, Universal.NON_PERCEIVABLE_QUALITY);
			_or_2 = _equals_7;
		}
		if (_or_2) {
			_or_1 = true;
		} else {
			Universal _stereotype_8 = this.getStereotype();
			boolean _equals_8 = Objects.equal(_stereotype_8, Universal.SUB_KIND);
			_or_1 = _equals_8;
		}
		if (_or_1) {
			_or = true;
		} else {
			Universal _stereotype_9 = this.getStereotype();
			boolean _equals_9 = Objects.equal(_stereotype_9, Universal.CATEGORY);
			_or = _equals_9;
		}
		return _or;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNonRigid() {
		boolean _or = false;
		boolean _or_1 = false;
		boolean _or_2 = false;
		Universal _stereotype = this.getStereotype();
		boolean _equals = Objects.equal(_stereotype, Universal.ROLE);
		if (_equals) {
			_or_2 = true;
		} else {
			Universal _stereotype_1 = this.getStereotype();
			boolean _equals_1 = Objects.equal(_stereotype_1, Universal.PHASE);
			_or_2 = _equals_1;
		}
		if (_or_2) {
			_or_1 = true;
		} else {
			Universal _stereotype_2 = this.getStereotype();
			boolean _equals_2 = Objects.equal(_stereotype_2, Universal.ROLE_MIXIN);
			_or_1 = _equals_2;
		}
		if (_or_1) {
			_or = true;
		} else {
			Universal _stereotype_3 = this.getStereotype();
			boolean _equals_3 = Objects.equal(_stereotype_3, Universal.MIXIN);
			_or = _equals_3;
		}
		return _or;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAntiRigid() {
		boolean _or = false;
		boolean _or_1 = false;
		Universal _stereotype = this.getStereotype();
		boolean _equals = Objects.equal(_stereotype, Universal.ROLE);
		if (_equals) {
			_or_1 = true;
		} else {
			Universal _stereotype_1 = this.getStereotype();
			boolean _equals_1 = Objects.equal(_stereotype_1, Universal.PHASE);
			_or_1 = _equals_1;
		}
		if (_or_1) {
			_or = true;
		} else {
			Universal _stereotype_2 = this.getStereotype();
			boolean _equals_2 = Objects.equal(_stereotype_2, Universal.ROLE_MIXIN);
			_or = _equals_2;
		}
		return _or;
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
			case OntoumlPackage.CLASS__HOLDER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetHolder((net.menthor.metamodel.ontouml.Container)otherEnd, msgs);
			case OntoumlPackage.CLASS__ISTRUTH_MAKER_OF:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIstruthMakerOf()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.CLASS__ATTRIBUTES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAttributes()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.CLASS__IS_SPECIALIZED_VIA:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIsSpecializedVia()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.CLASS__SPECIALIZES_VIA:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpecializesVia()).basicAdd(otherEnd, msgs);
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
			case OntoumlPackage.CLASS__HOLDER:
				return basicSetHolder(null, msgs);
			case OntoumlPackage.CLASS__ISTRUTH_MAKER_OF:
				return ((InternalEList<?>)getIstruthMakerOf()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.CLASS__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.CLASS__IS_SPECIALIZED_VIA:
				return ((InternalEList<?>)getIsSpecializedVia()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.CLASS__SPECIALIZES_VIA:
				return ((InternalEList<?>)getSpecializesVia()).basicRemove(otherEnd, msgs);
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
			case OntoumlPackage.CLASS__HOLDER:
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
			case OntoumlPackage.CLASS__HOLDER:
				if (resolve) return getHolder();
				return basicGetHolder();
			case OntoumlPackage.CLASS__STEREOTYPE:
				return getStereotype();
			case OntoumlPackage.CLASS__IS_ABSTRACT:
				return isIsAbstract();
			case OntoumlPackage.CLASS__IS_DERIVED:
				return isIsDerived();
			case OntoumlPackage.CLASS__IS_EXTENSIONAL:
				return isIsExtensional();
			case OntoumlPackage.CLASS__ENUMERATION_LITERALS:
				return getEnumerationLiterals();
			case OntoumlPackage.CLASS__INSTANCE_OF:
				return getInstanceOf();
			case OntoumlPackage.CLASS__ISTRUTH_MAKER_OF:
				return getIstruthMakerOf();
			case OntoumlPackage.CLASS__ATTRIBUTES:
				return getAttributes();
			case OntoumlPackage.CLASS__IS_SPECIALIZED_VIA:
				return getIsSpecializedVia();
			case OntoumlPackage.CLASS__SPECIALIZES_VIA:
				return getSpecializesVia();
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
			case OntoumlPackage.CLASS__HOLDER:
				setHolder((net.menthor.metamodel.ontouml.Container)newValue);
				return;
			case OntoumlPackage.CLASS__STEREOTYPE:
				setStereotype((Universal)newValue);
				return;
			case OntoumlPackage.CLASS__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case OntoumlPackage.CLASS__IS_DERIVED:
				setIsDerived((Boolean)newValue);
				return;
			case OntoumlPackage.CLASS__IS_EXTENSIONAL:
				setIsExtensional((Boolean)newValue);
				return;
			case OntoumlPackage.CLASS__ENUMERATION_LITERALS:
				getEnumerationLiterals().clear();
				getEnumerationLiterals().addAll((Collection<? extends String>)newValue);
				return;
			case OntoumlPackage.CLASS__INSTANCE_OF:
				getInstanceOf().clear();
				getInstanceOf().addAll((Collection<? extends net.menthor.metamodel.ontouml.Class>)newValue);
				return;
			case OntoumlPackage.CLASS__ISTRUTH_MAKER_OF:
				getIstruthMakerOf().clear();
				getIstruthMakerOf().addAll((Collection<? extends ClassBinaryRelationship>)newValue);
				return;
			case OntoumlPackage.CLASS__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case OntoumlPackage.CLASS__IS_SPECIALIZED_VIA:
				getIsSpecializedVia().clear();
				getIsSpecializedVia().addAll((Collection<? extends GeneralizationSet>)newValue);
				return;
			case OntoumlPackage.CLASS__SPECIALIZES_VIA:
				getSpecializesVia().clear();
				getSpecializesVia().addAll((Collection<? extends GeneralizationSet>)newValue);
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
			case OntoumlPackage.CLASS__HOLDER:
				setHolder((net.menthor.metamodel.ontouml.Container)null);
				return;
			case OntoumlPackage.CLASS__STEREOTYPE:
				setStereotype(STEREOTYPE_EDEFAULT);
				return;
			case OntoumlPackage.CLASS__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case OntoumlPackage.CLASS__IS_DERIVED:
				setIsDerived(IS_DERIVED_EDEFAULT);
				return;
			case OntoumlPackage.CLASS__IS_EXTENSIONAL:
				setIsExtensional(IS_EXTENSIONAL_EDEFAULT);
				return;
			case OntoumlPackage.CLASS__ENUMERATION_LITERALS:
				getEnumerationLiterals().clear();
				return;
			case OntoumlPackage.CLASS__INSTANCE_OF:
				getInstanceOf().clear();
				return;
			case OntoumlPackage.CLASS__ISTRUTH_MAKER_OF:
				getIstruthMakerOf().clear();
				return;
			case OntoumlPackage.CLASS__ATTRIBUTES:
				getAttributes().clear();
				return;
			case OntoumlPackage.CLASS__IS_SPECIALIZED_VIA:
				getIsSpecializedVia().clear();
				return;
			case OntoumlPackage.CLASS__SPECIALIZES_VIA:
				getSpecializesVia().clear();
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
			case OntoumlPackage.CLASS__HOLDER:
				return basicGetHolder() != null;
			case OntoumlPackage.CLASS__STEREOTYPE:
				return stereotype != STEREOTYPE_EDEFAULT;
			case OntoumlPackage.CLASS__IS_ABSTRACT:
				return isAbstract != IS_ABSTRACT_EDEFAULT;
			case OntoumlPackage.CLASS__IS_DERIVED:
				return isDerived != IS_DERIVED_EDEFAULT;
			case OntoumlPackage.CLASS__IS_EXTENSIONAL:
				return isExtensional != IS_EXTENSIONAL_EDEFAULT;
			case OntoumlPackage.CLASS__ENUMERATION_LITERALS:
				return enumerationLiterals != null && !enumerationLiterals.isEmpty();
			case OntoumlPackage.CLASS__INSTANCE_OF:
				return instanceOf != null && !instanceOf.isEmpty();
			case OntoumlPackage.CLASS__ISTRUTH_MAKER_OF:
				return istruthMakerOf != null && !istruthMakerOf.isEmpty();
			case OntoumlPackage.CLASS__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case OntoumlPackage.CLASS__IS_SPECIALIZED_VIA:
				return isSpecializedVia != null && !isSpecializedVia.isEmpty();
			case OntoumlPackage.CLASS__SPECIALIZES_VIA:
				return specializesVia != null && !specializesVia.isEmpty();
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
				case OntoumlPackage.CLASS__HOLDER: return OntoumlPackage.CONTAINING_ELEMENT__HOLDER;
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
				case OntoumlPackage.CONTAINING_ELEMENT__HOLDER: return OntoumlPackage.CLASS__HOLDER;
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
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case OntoumlPackage.CLASS___IS_RIGID:
				return isRigid();
			case OntoumlPackage.CLASS___IS_NON_RIGID:
				return isNonRigid();
			case OntoumlPackage.CLASS___IS_ANTI_RIGID:
				return isAntiRigid();
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
		result.append(" (stereotype: ");
		result.append(stereotype);
		result.append(", isAbstract: ");
		result.append(isAbstract);
		result.append(", isDerived: ");
		result.append(isDerived);
		result.append(", isExtensional: ");
		result.append(isExtensional);
		result.append(", enumerationLiterals: ");
		result.append(enumerationLiterals);
		result.append(')');
		return result.toString();
	}

} //ClassImpl
