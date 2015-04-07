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
import net.menthor.metamodel.ontouml.EndPoint;
import net.menthor.metamodel.ontouml.GeneralizationSet;
import net.menthor.metamodel.ontouml.Model;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.Relationship;
import net.menthor.metamodel.ontouml.Type;

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
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.TypeImpl#getHolder <em>Holder</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.TypeImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.TypeImpl#getIsSpecializedVia <em>Is Specialized Via</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.TypeImpl#getSpecializesVia <em>Specializes Via</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TypeImpl extends NamedElementImpl implements Type {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OntoumlPackage.Literals.TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Container getHolder() {
		if (eContainerFeatureID() != OntoumlPackage.TYPE__HOLDER) return null;
		return (net.menthor.metamodel.ontouml.Container)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Container basicGetHolder() {
		if (eContainerFeatureID() != OntoumlPackage.TYPE__HOLDER) return null;
		return (net.menthor.metamodel.ontouml.Container)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHolder(net.menthor.metamodel.ontouml.Container newHolder, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newHolder, OntoumlPackage.TYPE__HOLDER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHolder(net.menthor.metamodel.ontouml.Container newHolder) {
		if (newHolder != eInternalContainer() || (eContainerFeatureID() != OntoumlPackage.TYPE__HOLDER && newHolder != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.TYPE__HOLDER, newHolder, newHolder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Comment> getComments() {
		if (comments == null) {
			comments = new EObjectContainmentWithInverseEList<Comment>(Comment.class, this, OntoumlPackage.TYPE__COMMENTS, OntoumlPackage.COMMENT__OWNER);
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
			isSpecializedVia = new EObjectWithInverseResolvingEList<GeneralizationSet>(GeneralizationSet.class, this, OntoumlPackage.TYPE__IS_SPECIALIZED_VIA, OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASSIFIER);
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
			specializesVia = new EObjectWithInverseResolvingEList.ManyInverse<GeneralizationSet>(GeneralizationSet.class, this, OntoumlPackage.TYPE__SPECIALIZES_VIA, OntoumlPackage.GENERALIZATION_SET__SPECIALIZING_CLASSIFIER);
		}
		return specializesVia;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> relatedTypes() {
		Type[] result = null;
		EList<EndPoint> _ends = this.ends();
		for (final EndPoint ep : _ends) {
			final Type[] _converted_result = (Type[])result;
			Classifier _endType = ep.getEndType();
			((List<Type>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)).add(((Type) _endType));
		}
		final Type[] _converted_result_1 = (Type[])result;
		return ECollections.<Type>toEList(((Iterable<? extends Type>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> allRelatedTypes() {
		Type[] result = null;
		EList<EndPoint> _allEnds = this.allEnds();
		for (final EndPoint ep : _allEnds) {
			final Type[] _converted_result = (Type[])result;
			Classifier _endType = ep.getEndType();
			((List<Type>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)).add(((Type) _endType));
		}
		final Type[] _converted_result_1 = (Type[])result;
		return ECollections.<Type>toEList(((Iterable<? extends Type>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)));
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
	public EList<Classifier> siblings() {
		Classifier[] result = null;
		EList<Classifier> _parents = this.parents();
		for (final Classifier p : _parents) {
			EList<Classifier> _children = p.children();
			for (final Classifier sibling : _children) {
				boolean _equals = sibling.equals(this);
				boolean _not = (!_equals);
				if (_not) {
					final Classifier[] _converted_result = (Classifier[])result;
					((List<Classifier>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)).add(sibling);
				}
			}
		}
		final Classifier[] _converted_result_1 = (Classifier[])result;
		return ECollections.<Classifier>toEList(((Iterable<? extends Classifier>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EndPoint> ends() {
		EndPoint[] result = null;
		Model _model = this.getModel();
		EList<Relationship> _allRelationships = _model.allRelationships();
		for (final Relationship rel : _allRelationships) {
			boolean _isEnd = rel.isEnd(this);
			if (_isEnd) {
				EList<EndPoint> _endPoints = rel.getEndPoints();
				for (final EndPoint ep : _endPoints) {
					Classifier _endType = ep.getEndType();
					boolean _equals = _endType.equals(this);
					boolean _not = (!_equals);
					if (_not) {
						final EndPoint[] _converted_result = (EndPoint[])result;
						((List<EndPoint>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)).add(ep);
					}
				}
			}
		}
		final EndPoint[] _converted_result_1 = (EndPoint[])result;
		return ECollections.<EndPoint>toEList(((Iterable<? extends EndPoint>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EndPoint> allEnds() {
		EndPoint[] result = null;
		final EndPoint[] _converted_result = (EndPoint[])result;
		EList<EndPoint> _ends = this.ends();
		((List<EndPoint>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)).addAll(_ends);
		EList<Classifier> _allParents = this.allParents();
		for (final Classifier p : _allParents) {
			if ((p instanceof net.menthor.metamodel.ontouml.Class)) {
				final EndPoint[] _converted_result_1 = (EndPoint[])result;
				EList<EndPoint> _ends_1 = ((net.menthor.metamodel.ontouml.Class)p).ends();
				((List<EndPoint>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)).addAll(_ends_1);
			}
		}
		final EndPoint[] _converted_result_2 = (EndPoint[])result;
		return ECollections.<EndPoint>toEList(((Iterable<? extends EndPoint>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_2)));
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
			case OntoumlPackage.TYPE__HOLDER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetHolder((net.menthor.metamodel.ontouml.Container)otherEnd, msgs);
			case OntoumlPackage.TYPE__COMMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComments()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.TYPE__IS_SPECIALIZED_VIA:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIsSpecializedVia()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.TYPE__SPECIALIZES_VIA:
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
			case OntoumlPackage.TYPE__HOLDER:
				return basicSetHolder(null, msgs);
			case OntoumlPackage.TYPE__COMMENTS:
				return ((InternalEList<?>)getComments()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.TYPE__IS_SPECIALIZED_VIA:
				return ((InternalEList<?>)getIsSpecializedVia()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.TYPE__SPECIALIZES_VIA:
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
			case OntoumlPackage.TYPE__HOLDER:
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
			case OntoumlPackage.TYPE__HOLDER:
				if (resolve) return getHolder();
				return basicGetHolder();
			case OntoumlPackage.TYPE__COMMENTS:
				return getComments();
			case OntoumlPackage.TYPE__IS_SPECIALIZED_VIA:
				return getIsSpecializedVia();
			case OntoumlPackage.TYPE__SPECIALIZES_VIA:
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
			case OntoumlPackage.TYPE__HOLDER:
				setHolder((net.menthor.metamodel.ontouml.Container)newValue);
				return;
			case OntoumlPackage.TYPE__COMMENTS:
				getComments().clear();
				getComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case OntoumlPackage.TYPE__IS_SPECIALIZED_VIA:
				getIsSpecializedVia().clear();
				getIsSpecializedVia().addAll((Collection<? extends GeneralizationSet>)newValue);
				return;
			case OntoumlPackage.TYPE__SPECIALIZES_VIA:
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
			case OntoumlPackage.TYPE__HOLDER:
				setHolder((net.menthor.metamodel.ontouml.Container)null);
				return;
			case OntoumlPackage.TYPE__COMMENTS:
				getComments().clear();
				return;
			case OntoumlPackage.TYPE__IS_SPECIALIZED_VIA:
				getIsSpecializedVia().clear();
				return;
			case OntoumlPackage.TYPE__SPECIALIZES_VIA:
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
			case OntoumlPackage.TYPE__HOLDER:
				return basicGetHolder() != null;
			case OntoumlPackage.TYPE__COMMENTS:
				return comments != null && !comments.isEmpty();
			case OntoumlPackage.TYPE__IS_SPECIALIZED_VIA:
				return isSpecializedVia != null && !isSpecializedVia.isEmpty();
			case OntoumlPackage.TYPE__SPECIALIZES_VIA:
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
		if (baseClass == ContainedElement.class) {
			switch (derivedFeatureID) {
				case OntoumlPackage.TYPE__HOLDER: return OntoumlPackage.CONTAINED_ELEMENT__HOLDER;
				case OntoumlPackage.TYPE__COMMENTS: return OntoumlPackage.CONTAINED_ELEMENT__COMMENTS;
				default: return -1;
			}
		}
		if (baseClass == Classifier.class) {
			switch (derivedFeatureID) {
				case OntoumlPackage.TYPE__IS_SPECIALIZED_VIA: return OntoumlPackage.CLASSIFIER__IS_SPECIALIZED_VIA;
				case OntoumlPackage.TYPE__SPECIALIZES_VIA: return OntoumlPackage.CLASSIFIER__SPECIALIZES_VIA;
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
				case OntoumlPackage.CONTAINED_ELEMENT__HOLDER: return OntoumlPackage.TYPE__HOLDER;
				case OntoumlPackage.CONTAINED_ELEMENT__COMMENTS: return OntoumlPackage.TYPE__COMMENTS;
				default: return -1;
			}
		}
		if (baseClass == Classifier.class) {
			switch (baseFeatureID) {
				case OntoumlPackage.CLASSIFIER__IS_SPECIALIZED_VIA: return OntoumlPackage.TYPE__IS_SPECIALIZED_VIA;
				case OntoumlPackage.CLASSIFIER__SPECIALIZES_VIA: return OntoumlPackage.TYPE__SPECIALIZES_VIA;
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
				case OntoumlPackage.CONTAINED_ELEMENT___GET_MODEL__CONTAINER: return OntoumlPackage.TYPE___GET_MODEL__CONTAINER;
				case OntoumlPackage.CONTAINED_ELEMENT___GET_MODEL: return OntoumlPackage.TYPE___GET_MODEL;
				default: return -1;
			}
		}
		if (baseClass == Classifier.class) {
			switch (baseOperationID) {
				case OntoumlPackage.CLASSIFIER___CHILDREN: return OntoumlPackage.TYPE___CHILDREN;
				case OntoumlPackage.CLASSIFIER___PARENTS: return OntoumlPackage.TYPE___PARENTS;
				case OntoumlPackage.CLASSIFIER___ALL_PARENTS__CLASSIFIER_ELIST: return OntoumlPackage.TYPE___ALL_PARENTS__CLASSIFIER_ELIST;
				case OntoumlPackage.CLASSIFIER___ALL_PARENTS: return OntoumlPackage.TYPE___ALL_PARENTS;
				case OntoumlPackage.CLASSIFIER___ALL_CHILDREN__CLASSIFIER_ELIST: return OntoumlPackage.TYPE___ALL_CHILDREN__CLASSIFIER_ELIST;
				case OntoumlPackage.CLASSIFIER___ALL_CHILDREN: return OntoumlPackage.TYPE___ALL_CHILDREN;
				case OntoumlPackage.CLASSIFIER___SIBLINGS: return OntoumlPackage.TYPE___SIBLINGS;
				case OntoumlPackage.CLASSIFIER___ENDS: return OntoumlPackage.TYPE___ENDS;
				case OntoumlPackage.CLASSIFIER___ALL_ENDS: return OntoumlPackage.TYPE___ALL_ENDS;
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
			case OntoumlPackage.TYPE___RELATED_TYPES:
				return relatedTypes();
			case OntoumlPackage.TYPE___ALL_RELATED_TYPES:
				return allRelatedTypes();
			case OntoumlPackage.TYPE___CHILDREN:
				return children();
			case OntoumlPackage.TYPE___PARENTS:
				return parents();
			case OntoumlPackage.TYPE___ALL_PARENTS__CLASSIFIER_ELIST:
				allParents((Classifier)arguments.get(0), (EList<Classifier>)arguments.get(1));
				return null;
			case OntoumlPackage.TYPE___ALL_PARENTS:
				return allParents();
			case OntoumlPackage.TYPE___ALL_CHILDREN__CLASSIFIER_ELIST:
				allChildren((Classifier)arguments.get(0), (EList<Classifier>)arguments.get(1));
				return null;
			case OntoumlPackage.TYPE___ALL_CHILDREN:
				return allChildren();
			case OntoumlPackage.TYPE___SIBLINGS:
				return siblings();
			case OntoumlPackage.TYPE___ENDS:
				return ends();
			case OntoumlPackage.TYPE___ALL_ENDS:
				return allEnds();
			case OntoumlPackage.TYPE___GET_MODEL__CONTAINER:
				return getModel((net.menthor.metamodel.ontouml.Container)arguments.get(0));
			case OntoumlPackage.TYPE___GET_MODEL:
				return getModel();
		}
		return super.eInvoke(operationID, arguments);
	}

} //TypeImpl
