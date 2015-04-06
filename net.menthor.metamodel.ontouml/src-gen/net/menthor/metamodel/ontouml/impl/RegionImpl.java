/**
 */
package net.menthor.metamodel.ontouml.impl;

import com.google.common.base.Objects;

import com.google.common.collect.Iterables;

import java.lang.Iterable;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.List;

import net.menthor.metamodel.ontouml.Classifier;
import net.menthor.metamodel.ontouml.Comment;
import net.menthor.metamodel.ontouml.ContainedElement;
import net.menthor.metamodel.ontouml.GeneralizationSet;
import net.menthor.metamodel.ontouml.Literal;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.Primitive;
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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Region</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RegionImpl#getHolder <em>Holder</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RegionImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RegionImpl#getIsSpecializedVia <em>Is Specialized Via</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RegionImpl#getSpecializesVia <em>Specializes Via</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RegionImpl#getOwnerStructure <em>Owner Structure</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RegionImpl#getGroundedLiteral <em>Grounded Literal</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RegionImpl#getComposedBy <em>Composed By</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RegionImpl#getBasicType <em>Basic Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegionImpl extends NamedElementImpl implements Region {
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
	 * The cached value of the '{@link #getOwnerStructure() <em>Owner Structure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnerStructure()
	 * @generated
	 * @ordered
	 */
	protected Structure ownerStructure;

	/**
	 * The cached value of the '{@link #getGroundedLiteral() <em>Grounded Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroundedLiteral()
	 * @generated
	 * @ordered
	 */
	protected Literal groundedLiteral;

	/**
	 * The cached value of the '{@link #getComposedBy() <em>Composed By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComposedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<Region> composedBy;

	/**
	 * The default value of the '{@link #getBasicType() <em>Basic Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasicType()
	 * @generated
	 * @ordered
	 */
	protected static final Primitive BASIC_TYPE_EDEFAULT = Primitive.BOOLEAN;

	/**
	 * The cached value of the '{@link #getBasicType() <em>Basic Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBasicType()
	 * @generated
	 * @ordered
	 */
	protected Primitive basicType = BASIC_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RegionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OntoumlPackage.Literals.REGION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Container getHolder() {
		if (eContainerFeatureID() != OntoumlPackage.REGION__HOLDER) return null;
		return (net.menthor.metamodel.ontouml.Container)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Container basicGetHolder() {
		if (eContainerFeatureID() != OntoumlPackage.REGION__HOLDER) return null;
		return (net.menthor.metamodel.ontouml.Container)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHolder(net.menthor.metamodel.ontouml.Container newHolder, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newHolder, OntoumlPackage.REGION__HOLDER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHolder(net.menthor.metamodel.ontouml.Container newHolder) {
		if (newHolder != eInternalContainer() || (eContainerFeatureID() != OntoumlPackage.REGION__HOLDER && newHolder != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.REGION__HOLDER, newHolder, newHolder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Comment> getComments() {
		if (comments == null) {
			comments = new EObjectContainmentWithInverseEList<Comment>(Comment.class, this, OntoumlPackage.REGION__COMMENTS, OntoumlPackage.COMMENT__OWNER);
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
			isSpecializedVia = new EObjectWithInverseResolvingEList<GeneralizationSet>(GeneralizationSet.class, this, OntoumlPackage.REGION__IS_SPECIALIZED_VIA, OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASSIFIER);
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
			specializesVia = new EObjectWithInverseResolvingEList.ManyInverse<GeneralizationSet>(GeneralizationSet.class, this, OntoumlPackage.REGION__SPECIALIZES_VIA, OntoumlPackage.GENERALIZATION_SET__SPECIALIZING_CLASSIFIER);
		}
		return specializesVia;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Structure getOwnerStructure() {
		if (ownerStructure != null && ownerStructure.eIsProxy()) {
			InternalEObject oldOwnerStructure = (InternalEObject)ownerStructure;
			ownerStructure = (Structure)eResolveProxy(oldOwnerStructure);
			if (ownerStructure != oldOwnerStructure) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.REGION__OWNER_STRUCTURE, oldOwnerStructure, ownerStructure));
			}
		}
		return ownerStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Structure basicGetOwnerStructure() {
		return ownerStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnerStructure(Structure newOwnerStructure, NotificationChain msgs) {
		Structure oldOwnerStructure = ownerStructure;
		ownerStructure = newOwnerStructure;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OntoumlPackage.REGION__OWNER_STRUCTURE, oldOwnerStructure, newOwnerStructure);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnerStructure(Structure newOwnerStructure) {
		if (newOwnerStructure != ownerStructure) {
			NotificationChain msgs = null;
			if (ownerStructure != null)
				msgs = ((InternalEObject)ownerStructure).eInverseRemove(this, OntoumlPackage.STRUCTURE__REGIONS, Structure.class, msgs);
			if (newOwnerStructure != null)
				msgs = ((InternalEObject)newOwnerStructure).eInverseAdd(this, OntoumlPackage.STRUCTURE__REGIONS, Structure.class, msgs);
			msgs = basicSetOwnerStructure(newOwnerStructure, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.REGION__OWNER_STRUCTURE, newOwnerStructure, newOwnerStructure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Literal getGroundedLiteral() {
		if (groundedLiteral != null && groundedLiteral.eIsProxy()) {
			InternalEObject oldGroundedLiteral = (InternalEObject)groundedLiteral;
			groundedLiteral = (Literal)eResolveProxy(oldGroundedLiteral);
			if (groundedLiteral != oldGroundedLiteral) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.REGION__GROUNDED_LITERAL, oldGroundedLiteral, groundedLiteral));
			}
		}
		return groundedLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Literal basicGetGroundedLiteral() {
		return groundedLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGroundedLiteral(Literal newGroundedLiteral, NotificationChain msgs) {
		Literal oldGroundedLiteral = groundedLiteral;
		groundedLiteral = newGroundedLiteral;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OntoumlPackage.REGION__GROUNDED_LITERAL, oldGroundedLiteral, newGroundedLiteral);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroundedLiteral(Literal newGroundedLiteral) {
		if (newGroundedLiteral != groundedLiteral) {
			NotificationChain msgs = null;
			if (groundedLiteral != null)
				msgs = ((InternalEObject)groundedLiteral).eInverseRemove(this, OntoumlPackage.LITERAL__GROUNDING_REGION, Literal.class, msgs);
			if (newGroundedLiteral != null)
				msgs = ((InternalEObject)newGroundedLiteral).eInverseAdd(this, OntoumlPackage.LITERAL__GROUNDING_REGION, Literal.class, msgs);
			msgs = basicSetGroundedLiteral(newGroundedLiteral, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.REGION__GROUNDED_LITERAL, newGroundedLiteral, newGroundedLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Region> getComposedBy() {
		if (composedBy == null) {
			composedBy = new EObjectResolvingEList<Region>(Region.class, this, OntoumlPackage.REGION__COMPOSED_BY);
		}
		return composedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Primitive getBasicType() {
		return basicType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBasicType(Primitive newBasicType) {
		Primitive oldBasicType = basicType;
		basicType = newBasicType == null ? BASIC_TYPE_EDEFAULT : newBasicType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.REGION__BASIC_TYPE, oldBasicType, basicType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBasic() {
		boolean _and = false;
		boolean _and_1 = false;
		Primitive _basicType = this.getBasicType();
		boolean _notEquals = (!Objects.equal(_basicType, null));
		if (!_notEquals) {
			_and_1 = false;
		} else {
			EList<Region> _composedBy = this.getComposedBy();
			int _size = _composedBy.size();
			boolean _equals = (_size == 0);
			_and_1 = _equals;
		}
		if (!_and_1) {
			_and = false;
		} else {
			boolean _or = false;
			Primitive _basicType_1 = this.getBasicType();
			boolean _equals_1 = Objects.equal(_basicType_1, Primitive.INTEGER);
			if (_equals_1) {
				_or = true;
			} else {
				Primitive _basicType_2 = this.getBasicType();
				boolean _equals_2 = Objects.equal(_basicType_2, Primitive.DECIMAL);
				_or = _equals_2;
			}
			_and = _or;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isComposed() {
		boolean _and = false;
		Primitive _basicType = this.getBasicType();
		boolean _equals = Objects.equal(_basicType, null);
		if (!_equals) {
			_and = false;
		} else {
			EList<Region> _composedBy = this.getComposedBy();
			int _size = _composedBy.size();
			boolean _greaterThan = (_size > 0);
			_and = _greaterThan;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNominal() {
		boolean _and = false;
		Primitive _basicType = this.getBasicType();
		boolean _notEquals = (!Objects.equal(_basicType, null));
		if (!_notEquals) {
			_and = false;
		} else {
			Primitive _basicType_1 = this.getBasicType();
			boolean _equals = Objects.equal(_basicType_1, Primitive.STRING);
			_and = _equals;
		}
		return _and;
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
			case OntoumlPackage.REGION__HOLDER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetHolder((net.menthor.metamodel.ontouml.Container)otherEnd, msgs);
			case OntoumlPackage.REGION__COMMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComments()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.REGION__IS_SPECIALIZED_VIA:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIsSpecializedVia()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.REGION__SPECIALIZES_VIA:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpecializesVia()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.REGION__OWNER_STRUCTURE:
				if (ownerStructure != null)
					msgs = ((InternalEObject)ownerStructure).eInverseRemove(this, OntoumlPackage.STRUCTURE__REGIONS, Structure.class, msgs);
				return basicSetOwnerStructure((Structure)otherEnd, msgs);
			case OntoumlPackage.REGION__GROUNDED_LITERAL:
				if (groundedLiteral != null)
					msgs = ((InternalEObject)groundedLiteral).eInverseRemove(this, OntoumlPackage.LITERAL__GROUNDING_REGION, Literal.class, msgs);
				return basicSetGroundedLiteral((Literal)otherEnd, msgs);
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
			case OntoumlPackage.REGION__HOLDER:
				return basicSetHolder(null, msgs);
			case OntoumlPackage.REGION__COMMENTS:
				return ((InternalEList<?>)getComments()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.REGION__IS_SPECIALIZED_VIA:
				return ((InternalEList<?>)getIsSpecializedVia()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.REGION__SPECIALIZES_VIA:
				return ((InternalEList<?>)getSpecializesVia()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.REGION__OWNER_STRUCTURE:
				return basicSetOwnerStructure(null, msgs);
			case OntoumlPackage.REGION__GROUNDED_LITERAL:
				return basicSetGroundedLiteral(null, msgs);
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
			case OntoumlPackage.REGION__HOLDER:
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
			case OntoumlPackage.REGION__HOLDER:
				if (resolve) return getHolder();
				return basicGetHolder();
			case OntoumlPackage.REGION__COMMENTS:
				return getComments();
			case OntoumlPackage.REGION__IS_SPECIALIZED_VIA:
				return getIsSpecializedVia();
			case OntoumlPackage.REGION__SPECIALIZES_VIA:
				return getSpecializesVia();
			case OntoumlPackage.REGION__OWNER_STRUCTURE:
				if (resolve) return getOwnerStructure();
				return basicGetOwnerStructure();
			case OntoumlPackage.REGION__GROUNDED_LITERAL:
				if (resolve) return getGroundedLiteral();
				return basicGetGroundedLiteral();
			case OntoumlPackage.REGION__COMPOSED_BY:
				return getComposedBy();
			case OntoumlPackage.REGION__BASIC_TYPE:
				return getBasicType();
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
			case OntoumlPackage.REGION__HOLDER:
				setHolder((net.menthor.metamodel.ontouml.Container)newValue);
				return;
			case OntoumlPackage.REGION__COMMENTS:
				getComments().clear();
				getComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case OntoumlPackage.REGION__IS_SPECIALIZED_VIA:
				getIsSpecializedVia().clear();
				getIsSpecializedVia().addAll((Collection<? extends GeneralizationSet>)newValue);
				return;
			case OntoumlPackage.REGION__SPECIALIZES_VIA:
				getSpecializesVia().clear();
				getSpecializesVia().addAll((Collection<? extends GeneralizationSet>)newValue);
				return;
			case OntoumlPackage.REGION__OWNER_STRUCTURE:
				setOwnerStructure((Structure)newValue);
				return;
			case OntoumlPackage.REGION__GROUNDED_LITERAL:
				setGroundedLiteral((Literal)newValue);
				return;
			case OntoumlPackage.REGION__COMPOSED_BY:
				getComposedBy().clear();
				getComposedBy().addAll((Collection<? extends Region>)newValue);
				return;
			case OntoumlPackage.REGION__BASIC_TYPE:
				setBasicType((Primitive)newValue);
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
			case OntoumlPackage.REGION__HOLDER:
				setHolder((net.menthor.metamodel.ontouml.Container)null);
				return;
			case OntoumlPackage.REGION__COMMENTS:
				getComments().clear();
				return;
			case OntoumlPackage.REGION__IS_SPECIALIZED_VIA:
				getIsSpecializedVia().clear();
				return;
			case OntoumlPackage.REGION__SPECIALIZES_VIA:
				getSpecializesVia().clear();
				return;
			case OntoumlPackage.REGION__OWNER_STRUCTURE:
				setOwnerStructure((Structure)null);
				return;
			case OntoumlPackage.REGION__GROUNDED_LITERAL:
				setGroundedLiteral((Literal)null);
				return;
			case OntoumlPackage.REGION__COMPOSED_BY:
				getComposedBy().clear();
				return;
			case OntoumlPackage.REGION__BASIC_TYPE:
				setBasicType(BASIC_TYPE_EDEFAULT);
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
			case OntoumlPackage.REGION__HOLDER:
				return basicGetHolder() != null;
			case OntoumlPackage.REGION__COMMENTS:
				return comments != null && !comments.isEmpty();
			case OntoumlPackage.REGION__IS_SPECIALIZED_VIA:
				return isSpecializedVia != null && !isSpecializedVia.isEmpty();
			case OntoumlPackage.REGION__SPECIALIZES_VIA:
				return specializesVia != null && !specializesVia.isEmpty();
			case OntoumlPackage.REGION__OWNER_STRUCTURE:
				return ownerStructure != null;
			case OntoumlPackage.REGION__GROUNDED_LITERAL:
				return groundedLiteral != null;
			case OntoumlPackage.REGION__COMPOSED_BY:
				return composedBy != null && !composedBy.isEmpty();
			case OntoumlPackage.REGION__BASIC_TYPE:
				return basicType != BASIC_TYPE_EDEFAULT;
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
				case OntoumlPackage.REGION__HOLDER: return OntoumlPackage.CONTAINED_ELEMENT__HOLDER;
				case OntoumlPackage.REGION__COMMENTS: return OntoumlPackage.CONTAINED_ELEMENT__COMMENTS;
				default: return -1;
			}
		}
		if (baseClass == Classifier.class) {
			switch (derivedFeatureID) {
				case OntoumlPackage.REGION__IS_SPECIALIZED_VIA: return OntoumlPackage.CLASSIFIER__IS_SPECIALIZED_VIA;
				case OntoumlPackage.REGION__SPECIALIZES_VIA: return OntoumlPackage.CLASSIFIER__SPECIALIZES_VIA;
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
				case OntoumlPackage.CONTAINED_ELEMENT__HOLDER: return OntoumlPackage.REGION__HOLDER;
				case OntoumlPackage.CONTAINED_ELEMENT__COMMENTS: return OntoumlPackage.REGION__COMMENTS;
				default: return -1;
			}
		}
		if (baseClass == Classifier.class) {
			switch (baseFeatureID) {
				case OntoumlPackage.CLASSIFIER__IS_SPECIALIZED_VIA: return OntoumlPackage.REGION__IS_SPECIALIZED_VIA;
				case OntoumlPackage.CLASSIFIER__SPECIALIZES_VIA: return OntoumlPackage.REGION__SPECIALIZES_VIA;
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
				case OntoumlPackage.CLASSIFIER___CHILDREN: return OntoumlPackage.REGION___CHILDREN;
				case OntoumlPackage.CLASSIFIER___PARENTS: return OntoumlPackage.REGION___PARENTS;
				case OntoumlPackage.CLASSIFIER___ALL_PARENTS__CLASSIFIER_ELIST: return OntoumlPackage.REGION___ALL_PARENTS__CLASSIFIER_ELIST;
				case OntoumlPackage.CLASSIFIER___ALL_PARENTS: return OntoumlPackage.REGION___ALL_PARENTS;
				case OntoumlPackage.CLASSIFIER___ALL_CHILDREN__CLASSIFIER_ELIST: return OntoumlPackage.REGION___ALL_CHILDREN__CLASSIFIER_ELIST;
				case OntoumlPackage.CLASSIFIER___ALL_CHILDREN: return OntoumlPackage.REGION___ALL_CHILDREN;
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
			case OntoumlPackage.REGION___IS_BASIC:
				return isBasic();
			case OntoumlPackage.REGION___IS_COMPOSED:
				return isComposed();
			case OntoumlPackage.REGION___IS_NOMINAL:
				return isNominal();
			case OntoumlPackage.REGION___CHILDREN:
				return children();
			case OntoumlPackage.REGION___PARENTS:
				return parents();
			case OntoumlPackage.REGION___ALL_PARENTS__CLASSIFIER_ELIST:
				allParents((Classifier)arguments.get(0), (EList<Classifier>)arguments.get(1));
				return null;
			case OntoumlPackage.REGION___ALL_PARENTS:
				return allParents();
			case OntoumlPackage.REGION___ALL_CHILDREN__CLASSIFIER_ELIST:
				allChildren((Classifier)arguments.get(0), (EList<Classifier>)arguments.get(1));
				return null;
			case OntoumlPackage.REGION___ALL_CHILDREN:
				return allChildren();
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
		result.append(" (basicType: ");
		result.append(basicType);
		result.append(')');
		return result.toString();
	}

} //RegionImpl
