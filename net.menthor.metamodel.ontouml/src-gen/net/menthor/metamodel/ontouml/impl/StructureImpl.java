/**
 */
package net.menthor.metamodel.ontouml.impl;

import com.google.common.collect.Iterables;

import java.lang.Iterable;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.List;

import net.menthor.metamodel.ontouml.Classifier;
import net.menthor.metamodel.ontouml.Comment;
import net.menthor.metamodel.ontouml.ContainedElement;
import net.menthor.metamodel.ontouml.GeneralizationSet;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.Region;
import net.menthor.metamodel.ontouml.Structure;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
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
 * An implementation of the model object '<em><b>Structure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.StructureImpl#getHolder <em>Holder</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.StructureImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.StructureImpl#getIsSpecializedVia <em>Is Specialized Via</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.StructureImpl#getSpecializesVia <em>Specializes Via</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.StructureImpl#getRegions <em>Regions</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.StructureImpl#getGroundedEnumeration <em>Grounded Enumeration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StructureImpl extends NamedElementImpl implements Structure {
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
	public net.menthor.metamodel.ontouml.Container getHolder() {
		if (eContainerFeatureID() != OntoumlPackage.STRUCTURE__HOLDER) return null;
		return (net.menthor.metamodel.ontouml.Container)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Container basicGetHolder() {
		if (eContainerFeatureID() != OntoumlPackage.STRUCTURE__HOLDER) return null;
		return (net.menthor.metamodel.ontouml.Container)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHolder(net.menthor.metamodel.ontouml.Container newHolder, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newHolder, OntoumlPackage.STRUCTURE__HOLDER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHolder(net.menthor.metamodel.ontouml.Container newHolder) {
		if (newHolder != eInternalContainer() || (eContainerFeatureID() != OntoumlPackage.STRUCTURE__HOLDER && newHolder != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.STRUCTURE__HOLDER, newHolder, newHolder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Comment> getComments() {
		if (comments == null) {
			comments = new EObjectContainmentWithInverseEList<Comment>(Comment.class, this, OntoumlPackage.STRUCTURE__COMMENTS, OntoumlPackage.COMMENT__OWNER);
		}
		return comments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GeneralizationSet> getIsSpecializedVia() {
		if (isSpecializedVia == null) {
			isSpecializedVia = new EObjectWithInverseResolvingEList<GeneralizationSet>(GeneralizationSet.class, this, OntoumlPackage.STRUCTURE__IS_SPECIALIZED_VIA, OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASSIFIER);
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
			specializesVia = new EObjectWithInverseResolvingEList.ManyInverse<GeneralizationSet>(GeneralizationSet.class, this, OntoumlPackage.STRUCTURE__SPECIALIZES_VIA, OntoumlPackage.GENERALIZATION_SET__SPECIALIZING_CLASSIFIER);
		}
		return specializesVia;
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
	public EList<Classifier> children() {
		net.menthor.metamodel.ontouml.Class[] list = null;
		EList<GeneralizationSet> _isSpecializedVia = this.getIsSpecializedVia();
		for (final GeneralizationSet gs : _isSpecializedVia) {
			final net.menthor.metamodel.ontouml.Class[] _converted_list = (net.menthor.metamodel.ontouml.Class[])list;
			EList<Classifier> _specializingClassifier = gs.getSpecializingClassifier();
			Iterables.<Classifier>addAll(((Collection<Classifier>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list)), _specializingClassifier);
		}
		final net.menthor.metamodel.ontouml.Class[] _converted_list_1 = (net.menthor.metamodel.ontouml.Class[])list;
		return ECollections.<Classifier>toEList(((Iterable<? extends Classifier>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list_1)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Classifier> parents() {
		Classifier[] list = null;
		EList<GeneralizationSet> _specializesVia = this.getSpecializesVia();
		for (final GeneralizationSet gs : _specializesVia) {
			final Classifier[] _converted_list = (Classifier[])list;
			Classifier _specializedClassifier = gs.getSpecializedClassifier();
			((List<Classifier>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list)).add(_specializedClassifier);
		}
		final Classifier[] _converted_list_1 = (Classifier[])list;
		return ECollections.<Classifier>toEList(((Iterable<? extends Classifier>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list_1)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void allParents(final Classifier c, final EList<Classifier> result) {
		EList<GeneralizationSet> _specializesVia = this.getSpecializesVia();
		for (final GeneralizationSet gs : _specializesVia) {
			{
				Classifier _specializedClassifier = gs.getSpecializedClassifier();
				result.add(_specializedClassifier);
				Classifier _specializedClassifier_1 = gs.getSpecializedClassifier();
				this.allParents(_specializedClassifier_1, result);
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Classifier> allParents() {
		Classifier[] list = null;
		final Classifier[] _converted_list = (Classifier[])list;
		EList<Classifier> _eList = ECollections.<Classifier>toEList(((Iterable<? extends Classifier>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list)));
		this.allParents(this, _eList);
		final Classifier[] _converted_list_1 = (Classifier[])list;
		return ECollections.<Classifier>toEList(((Iterable<? extends Classifier>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list_1)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void allChildren(final Classifier c, final EList<Classifier> result) {
		EList<GeneralizationSet> _isSpecializedVia = this.getIsSpecializedVia();
		for (final GeneralizationSet gs : _isSpecializedVia) {
			{
				EList<Classifier> _specializingClassifier = gs.getSpecializingClassifier();
				result.addAll(_specializingClassifier);
				EList<Classifier> _specializingClassifier_1 = gs.getSpecializingClassifier();
				for (final Classifier children : _specializingClassifier_1) {
					this.allChildren(children, result);
				}
			}
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Classifier> allChildren() {
		Classifier[] list = null;
		final Classifier[] _converted_list = (Classifier[])list;
		EList<Classifier> _eList = ECollections.<Classifier>toEList(((Iterable<? extends Classifier>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list)));
		this.allChildren(this, _eList);
		final Classifier[] _converted_list_1 = (Classifier[])list;
		return ECollections.<Classifier>toEList(((Iterable<? extends Classifier>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list_1)));
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
			case OntoumlPackage.STRUCTURE__HOLDER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetHolder((net.menthor.metamodel.ontouml.Container)otherEnd, msgs);
			case OntoumlPackage.STRUCTURE__COMMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComments()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.STRUCTURE__IS_SPECIALIZED_VIA:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIsSpecializedVia()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.STRUCTURE__SPECIALIZES_VIA:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpecializesVia()).basicAdd(otherEnd, msgs);
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
			case OntoumlPackage.STRUCTURE__HOLDER:
				return basicSetHolder(null, msgs);
			case OntoumlPackage.STRUCTURE__COMMENTS:
				return ((InternalEList<?>)getComments()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.STRUCTURE__IS_SPECIALIZED_VIA:
				return ((InternalEList<?>)getIsSpecializedVia()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.STRUCTURE__SPECIALIZES_VIA:
				return ((InternalEList<?>)getSpecializesVia()).basicRemove(otherEnd, msgs);
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case OntoumlPackage.STRUCTURE__HOLDER:
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
			case OntoumlPackage.STRUCTURE__HOLDER:
				if (resolve) return getHolder();
				return basicGetHolder();
			case OntoumlPackage.STRUCTURE__COMMENTS:
				return getComments();
			case OntoumlPackage.STRUCTURE__IS_SPECIALIZED_VIA:
				return getIsSpecializedVia();
			case OntoumlPackage.STRUCTURE__SPECIALIZES_VIA:
				return getSpecializesVia();
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
			case OntoumlPackage.STRUCTURE__HOLDER:
				setHolder((net.menthor.metamodel.ontouml.Container)newValue);
				return;
			case OntoumlPackage.STRUCTURE__COMMENTS:
				getComments().clear();
				getComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case OntoumlPackage.STRUCTURE__IS_SPECIALIZED_VIA:
				getIsSpecializedVia().clear();
				getIsSpecializedVia().addAll((Collection<? extends GeneralizationSet>)newValue);
				return;
			case OntoumlPackage.STRUCTURE__SPECIALIZES_VIA:
				getSpecializesVia().clear();
				getSpecializesVia().addAll((Collection<? extends GeneralizationSet>)newValue);
				return;
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
			case OntoumlPackage.STRUCTURE__HOLDER:
				setHolder((net.menthor.metamodel.ontouml.Container)null);
				return;
			case OntoumlPackage.STRUCTURE__COMMENTS:
				getComments().clear();
				return;
			case OntoumlPackage.STRUCTURE__IS_SPECIALIZED_VIA:
				getIsSpecializedVia().clear();
				return;
			case OntoumlPackage.STRUCTURE__SPECIALIZES_VIA:
				getSpecializesVia().clear();
				return;
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
			case OntoumlPackage.STRUCTURE__HOLDER:
				return basicGetHolder() != null;
			case OntoumlPackage.STRUCTURE__COMMENTS:
				return comments != null && !comments.isEmpty();
			case OntoumlPackage.STRUCTURE__IS_SPECIALIZED_VIA:
				return isSpecializedVia != null && !isSpecializedVia.isEmpty();
			case OntoumlPackage.STRUCTURE__SPECIALIZES_VIA:
				return specializesVia != null && !specializesVia.isEmpty();
			case OntoumlPackage.STRUCTURE__REGIONS:
				return regions != null && !regions.isEmpty();
			case OntoumlPackage.STRUCTURE__GROUNDED_ENUMERATION:
				return groundedEnumeration != null;
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
				case OntoumlPackage.STRUCTURE__HOLDER: return OntoumlPackage.CONTAINED_ELEMENT__HOLDER;
				case OntoumlPackage.STRUCTURE__COMMENTS: return OntoumlPackage.CONTAINED_ELEMENT__COMMENTS;
				default: return -1;
			}
		}
		if (baseClass == Classifier.class) {
			switch (derivedFeatureID) {
				case OntoumlPackage.STRUCTURE__IS_SPECIALIZED_VIA: return OntoumlPackage.CLASSIFIER__IS_SPECIALIZED_VIA;
				case OntoumlPackage.STRUCTURE__SPECIALIZES_VIA: return OntoumlPackage.CLASSIFIER__SPECIALIZES_VIA;
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
				case OntoumlPackage.CONTAINED_ELEMENT__HOLDER: return OntoumlPackage.STRUCTURE__HOLDER;
				case OntoumlPackage.CONTAINED_ELEMENT__COMMENTS: return OntoumlPackage.STRUCTURE__COMMENTS;
				default: return -1;
			}
		}
		if (baseClass == Classifier.class) {
			switch (baseFeatureID) {
				case OntoumlPackage.CLASSIFIER__IS_SPECIALIZED_VIA: return OntoumlPackage.STRUCTURE__IS_SPECIALIZED_VIA;
				case OntoumlPackage.CLASSIFIER__SPECIALIZES_VIA: return OntoumlPackage.STRUCTURE__SPECIALIZES_VIA;
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
				default: return -1;
			}
		}
		if (baseClass == Classifier.class) {
			switch (baseOperationID) {
				case OntoumlPackage.CLASSIFIER___CHILDREN: return OntoumlPackage.STRUCTURE___CHILDREN;
				case OntoumlPackage.CLASSIFIER___PARENTS: return OntoumlPackage.STRUCTURE___PARENTS;
				case OntoumlPackage.CLASSIFIER___ALL_PARENTS__CLASSIFIER_ELIST: return OntoumlPackage.STRUCTURE___ALL_PARENTS__CLASSIFIER_ELIST;
				case OntoumlPackage.CLASSIFIER___ALL_PARENTS: return OntoumlPackage.STRUCTURE___ALL_PARENTS;
				case OntoumlPackage.CLASSIFIER___ALL_CHILDREN__CLASSIFIER_ELIST: return OntoumlPackage.STRUCTURE___ALL_CHILDREN__CLASSIFIER_ELIST;
				case OntoumlPackage.CLASSIFIER___ALL_CHILDREN: return OntoumlPackage.STRUCTURE___ALL_CHILDREN;
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
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case OntoumlPackage.STRUCTURE___CHILDREN:
				return children();
			case OntoumlPackage.STRUCTURE___PARENTS:
				return parents();
			case OntoumlPackage.STRUCTURE___ALL_PARENTS__CLASSIFIER_ELIST:
				allParents((Classifier)arguments.get(0), (EList<Classifier>)arguments.get(1));
				return null;
			case OntoumlPackage.STRUCTURE___ALL_PARENTS:
				return allParents();
			case OntoumlPackage.STRUCTURE___ALL_CHILDREN__CLASSIFIER_ELIST:
				allChildren((Classifier)arguments.get(0), (EList<Classifier>)arguments.get(1));
				return null;
			case OntoumlPackage.STRUCTURE___ALL_CHILDREN:
				return allChildren();
		}
		return super.eInvoke(operationID, arguments);
	}

} //StructureImpl
