/**
 */
package net.menthor.metamodel.ontouml.impl;

import com.google.common.base.Objects;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import net.menthor.metamodel.ontouml.AllenRelation;
import net.menthor.metamodel.ontouml.ClassBinaryRelationship;
import net.menthor.metamodel.ontouml.Comment;
import net.menthor.metamodel.ontouml.ContainedElement;
import net.menthor.metamodel.ontouml.EndPoint;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.Relation;

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
 * An implementation of the model object '<em><b>Class Binary Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#getHolder <em>Holder</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#getEndPoints <em>End Points</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#isPartIsShareable <em>Part Is Shareable</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#getAllensRelation <em>Allens Relation</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#getTruthMaker <em>Truth Maker</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#isIsDerived <em>Is Derived</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#isPartIsEssential <em>Part Is Essential</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#isPartIsInseparable <em>Part Is Inseparable</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#isPartIsImmutable <em>Part Is Immutable</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#isWholeIsImmutable <em>Whole Is Immutable</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#isPartIsMandatory <em>Part Is Mandatory</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#isWholeIsMandatory <em>Whole Is Mandatory</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassBinaryRelationshipImpl extends NamedElementImpl implements ClassBinaryRelationship {
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
	 * The default value of the '{@link #getStereotype() <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotype()
	 * @generated
	 * @ordered
	 */
	protected static final Relation STEREOTYPE_EDEFAULT = Relation.COMPONENT_OF;

	/**
	 * The cached value of the '{@link #getStereotype() <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotype()
	 * @generated
	 * @ordered
	 */
	protected Relation stereotype = STEREOTYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEndPoints() <em>End Points</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndPoints()
	 * @generated
	 * @ordered
	 */
	protected EList<EndPoint> endPoints;

	/**
	 * The default value of the '{@link #isPartIsShareable() <em>Part Is Shareable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPartIsShareable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PART_IS_SHAREABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPartIsShareable() <em>Part Is Shareable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPartIsShareable()
	 * @generated
	 * @ordered
	 */
	protected boolean partIsShareable = PART_IS_SHAREABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getAllensRelation() <em>Allens Relation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllensRelation()
	 * @generated
	 * @ordered
	 */
	protected static final AllenRelation ALLENS_RELATION_EDEFAULT = AllenRelation.STARTS;

	/**
	 * The cached value of the '{@link #getAllensRelation() <em>Allens Relation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllensRelation()
	 * @generated
	 * @ordered
	 */
	protected AllenRelation allensRelation = ALLENS_RELATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTruthMaker() <em>Truth Maker</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTruthMaker()
	 * @generated
	 * @ordered
	 */
	protected net.menthor.metamodel.ontouml.Class truthMaker;

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
	 * The default value of the '{@link #isPartIsEssential() <em>Part Is Essential</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPartIsEssential()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PART_IS_ESSENTIAL_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isPartIsInseparable() <em>Part Is Inseparable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPartIsInseparable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PART_IS_INSEPARABLE_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isPartIsImmutable() <em>Part Is Immutable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPartIsImmutable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PART_IS_IMMUTABLE_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isWholeIsImmutable() <em>Whole Is Immutable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWholeIsImmutable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean WHOLE_IS_IMMUTABLE_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isPartIsMandatory() <em>Part Is Mandatory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPartIsMandatory()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PART_IS_MANDATORY_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isWholeIsMandatory() <em>Whole Is Mandatory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWholeIsMandatory()
	 * @generated
	 * @ordered
	 */
	protected static final boolean WHOLE_IS_MANDATORY_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassBinaryRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OntoumlPackage.Literals.CLASS_BINARY_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Container getHolder() {
		if (eContainerFeatureID() != OntoumlPackage.CLASS_BINARY_RELATIONSHIP__HOLDER) return null;
		return (net.menthor.metamodel.ontouml.Container)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Container basicGetHolder() {
		if (eContainerFeatureID() != OntoumlPackage.CLASS_BINARY_RELATIONSHIP__HOLDER) return null;
		return (net.menthor.metamodel.ontouml.Container)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHolder(net.menthor.metamodel.ontouml.Container newHolder, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newHolder, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__HOLDER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHolder(net.menthor.metamodel.ontouml.Container newHolder) {
		if (newHolder != eInternalContainer() || (eContainerFeatureID() != OntoumlPackage.CLASS_BINARY_RELATIONSHIP__HOLDER && newHolder != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__HOLDER, newHolder, newHolder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Comment> getComments() {
		if (comments == null) {
			comments = new EObjectContainmentWithInverseEList<Comment>(Comment.class, this, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__COMMENTS, OntoumlPackage.COMMENT__OWNER);
		}
		return comments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation getStereotype() {
		return stereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotype(Relation newStereotype) {
		Relation oldStereotype = stereotype;
		stereotype = newStereotype == null ? STEREOTYPE_EDEFAULT : newStereotype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__STEREOTYPE, oldStereotype, stereotype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EndPoint> getEndPoints() {
		if (endPoints == null) {
			endPoints = new EObjectWithInverseResolvingEList<EndPoint>(EndPoint.class, this, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__END_POINTS, OntoumlPackage.END_POINT__OWNER);
		}
		return endPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPartIsShareable() {
		return partIsShareable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartIsShareable(boolean newPartIsShareable) {
		boolean oldPartIsShareable = partIsShareable;
		partIsShareable = newPartIsShareable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_SHAREABLE, oldPartIsShareable, partIsShareable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllenRelation getAllensRelation() {
		return allensRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllensRelation(AllenRelation newAllensRelation) {
		AllenRelation oldAllensRelation = allensRelation;
		allensRelation = newAllensRelation == null ? ALLENS_RELATION_EDEFAULT : newAllensRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__ALLENS_RELATION, oldAllensRelation, allensRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class getTruthMaker() {
		if (truthMaker != null && truthMaker.eIsProxy()) {
			InternalEObject oldTruthMaker = (InternalEObject)truthMaker;
			truthMaker = (net.menthor.metamodel.ontouml.Class)eResolveProxy(oldTruthMaker);
			if (truthMaker != oldTruthMaker) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TRUTH_MAKER, oldTruthMaker, truthMaker));
			}
		}
		return truthMaker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class basicGetTruthMaker() {
		return truthMaker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTruthMaker(net.menthor.metamodel.ontouml.Class newTruthMaker, NotificationChain msgs) {
		net.menthor.metamodel.ontouml.Class oldTruthMaker = truthMaker;
		truthMaker = newTruthMaker;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TRUTH_MAKER, oldTruthMaker, newTruthMaker);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTruthMaker(net.menthor.metamodel.ontouml.Class newTruthMaker) {
		if (newTruthMaker != truthMaker) {
			NotificationChain msgs = null;
			if (truthMaker != null)
				msgs = ((InternalEObject)truthMaker).eInverseRemove(this, OntoumlPackage.CLASS__ISTRUTH_MAKER_OF, net.menthor.metamodel.ontouml.Class.class, msgs);
			if (newTruthMaker != null)
				msgs = ((InternalEObject)newTruthMaker).eInverseAdd(this, OntoumlPackage.CLASS__ISTRUTH_MAKER_OF, net.menthor.metamodel.ontouml.Class.class, msgs);
			msgs = basicSetTruthMaker(newTruthMaker, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TRUTH_MAKER, newTruthMaker, newTruthMaker));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsDerived() {
		boolean _or = false;
		EndPoint _sourceEnd = this.sourceEnd();
		boolean _isIsDerived = _sourceEnd.isIsDerived();
		if (_isIsDerived) {
			_or = true;
		} else {
			EndPoint _targetEnd = this.targetEnd();
			boolean _isIsDerived_1 = _targetEnd.isIsDerived();
			_or = _isIsDerived_1;
		}
		return _or;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPartIsEssential() {
		boolean _and = false;
		boolean _and_1 = false;
		EndPoint _targetEnd = this.targetEnd();
		boolean _isIsDependee = _targetEnd.isIsDependee();
		if (!_isIsDependee) {
			_and_1 = false;
		} else {
			EndPoint _sourceEnd = this.sourceEnd();
			net.menthor.metamodel.ontouml.Class _endType = _sourceEnd.getEndType();
			boolean _isRigid = _endType.isRigid();
			_and_1 = _isRigid;
		}
		if (!_and_1) {
			_and = false;
		} else {
			boolean _isMeronymic = this.isMeronymic();
			_and = _isMeronymic;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPartIsInseparable() {
		boolean _and = false;
		boolean _and_1 = false;
		EndPoint _sourceEnd = this.sourceEnd();
		boolean _isIsDependee = _sourceEnd.isIsDependee();
		if (!_isIsDependee) {
			_and_1 = false;
		} else {
			EndPoint _targetEnd = this.targetEnd();
			net.menthor.metamodel.ontouml.Class _endType = _targetEnd.getEndType();
			boolean _isRigid = _endType.isRigid();
			_and_1 = _isRigid;
		}
		if (!_and_1) {
			_and = false;
		} else {
			boolean _isMeronymic = this.isMeronymic();
			_and = _isMeronymic;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPartIsImmutable() {
		boolean _and = false;
		boolean _and_1 = false;
		EndPoint _sourceEnd = this.sourceEnd();
		boolean _isIsDependee = _sourceEnd.isIsDependee();
		if (!_isIsDependee) {
			_and_1 = false;
		} else {
			EndPoint _targetEnd = this.targetEnd();
			net.menthor.metamodel.ontouml.Class _endType = _targetEnd.getEndType();
			boolean _isAntiRigid = _endType.isAntiRigid();
			_and_1 = _isAntiRigid;
		}
		if (!_and_1) {
			_and = false;
		} else {
			boolean _isMeronymic = this.isMeronymic();
			_and = _isMeronymic;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isWholeIsImmutable() {
		boolean _and = false;
		boolean _and_1 = false;
		EndPoint _targetEnd = this.targetEnd();
		boolean _isIsDependee = _targetEnd.isIsDependee();
		if (!_isIsDependee) {
			_and_1 = false;
		} else {
			EndPoint _sourceEnd = this.sourceEnd();
			net.menthor.metamodel.ontouml.Class _endType = _sourceEnd.getEndType();
			boolean _isAntiRigid = _endType.isAntiRigid();
			_and_1 = _isAntiRigid;
		}
		if (!_and_1) {
			_and = false;
		} else {
			boolean _isMeronymic = this.isMeronymic();
			_and = _isMeronymic;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPartIsMandatory() {
		boolean _and = false;
		EndPoint _targetEnd = this.targetEnd();
		int _lowerBound = _targetEnd.getLowerBound();
		boolean _greaterEqualsThan = (_lowerBound >= 1);
		if (!_greaterEqualsThan) {
			_and = false;
		} else {
			boolean _isMeronymic = this.isMeronymic();
			_and = _isMeronymic;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isWholeIsMandatory() {
		boolean _and = false;
		EndPoint _sourceEnd = this.sourceEnd();
		int _lowerBound = _sourceEnd.getLowerBound();
		boolean _greaterEqualsThan = (_lowerBound >= 1);
		if (!_greaterEqualsThan) {
			_and = false;
		} else {
			boolean _isMeronymic = this.isMeronymic();
			_and = _isMeronymic;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndPoint sourceEnd() {
		EList<EndPoint> _endPoints = this.getEndPoints();
		return _endPoints.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndPoint targetEnd() {
		EList<EndPoint> _endPoints = this.getEndPoints();
		return _endPoints.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMeronymic() {
		boolean _or = false;
		boolean _or_1 = false;
		boolean _or_2 = false;
		Relation _stereotype = this.getStereotype();
		boolean _equals = Objects.equal(_stereotype, Relation.COMPONENT_OF);
		if (_equals) {
			_or_2 = true;
		} else {
			Relation _stereotype_1 = this.getStereotype();
			boolean _equals_1 = Objects.equal(_stereotype_1, Relation.MEMBER_OF);
			_or_2 = _equals_1;
		}
		if (_or_2) {
			_or_1 = true;
		} else {
			Relation _stereotype_2 = this.getStereotype();
			boolean _equals_2 = Objects.equal(_stereotype_2, Relation.SUB_QUANTITY_OF);
			_or_1 = _equals_2;
		}
		if (_or_1) {
			_or = true;
		} else {
			Relation _stereotype_3 = this.getStereotype();
			boolean _equals_3 = Objects.equal(_stereotype_3, Relation.SUB_COLLECTION_OF);
			_or = _equals_3;
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
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__HOLDER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetHolder((net.menthor.metamodel.ontouml.Container)otherEnd, msgs);
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__COMMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComments()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__END_POINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEndPoints()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TRUTH_MAKER:
				if (truthMaker != null)
					msgs = ((InternalEObject)truthMaker).eInverseRemove(this, OntoumlPackage.CLASS__ISTRUTH_MAKER_OF, net.menthor.metamodel.ontouml.Class.class, msgs);
				return basicSetTruthMaker((net.menthor.metamodel.ontouml.Class)otherEnd, msgs);
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
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__HOLDER:
				return basicSetHolder(null, msgs);
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__COMMENTS:
				return ((InternalEList<?>)getComments()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__END_POINTS:
				return ((InternalEList<?>)getEndPoints()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TRUTH_MAKER:
				return basicSetTruthMaker(null, msgs);
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
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__HOLDER:
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
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__HOLDER:
				if (resolve) return getHolder();
				return basicGetHolder();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__COMMENTS:
				return getComments();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__STEREOTYPE:
				return getStereotype();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__END_POINTS:
				return getEndPoints();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_SHAREABLE:
				return isPartIsShareable();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__ALLENS_RELATION:
				return getAllensRelation();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TRUTH_MAKER:
				if (resolve) return getTruthMaker();
				return basicGetTruthMaker();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__IS_DERIVED:
				return isIsDerived();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_ESSENTIAL:
				return isPartIsEssential();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_INSEPARABLE:
				return isPartIsInseparable();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_IMMUTABLE:
				return isPartIsImmutable();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__WHOLE_IS_IMMUTABLE:
				return isWholeIsImmutable();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_MANDATORY:
				return isPartIsMandatory();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__WHOLE_IS_MANDATORY:
				return isWholeIsMandatory();
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
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__HOLDER:
				setHolder((net.menthor.metamodel.ontouml.Container)newValue);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__COMMENTS:
				getComments().clear();
				getComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__STEREOTYPE:
				setStereotype((Relation)newValue);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__END_POINTS:
				getEndPoints().clear();
				getEndPoints().addAll((Collection<? extends EndPoint>)newValue);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_SHAREABLE:
				setPartIsShareable((Boolean)newValue);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__ALLENS_RELATION:
				setAllensRelation((AllenRelation)newValue);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TRUTH_MAKER:
				setTruthMaker((net.menthor.metamodel.ontouml.Class)newValue);
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
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__HOLDER:
				setHolder((net.menthor.metamodel.ontouml.Container)null);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__COMMENTS:
				getComments().clear();
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__STEREOTYPE:
				setStereotype(STEREOTYPE_EDEFAULT);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__END_POINTS:
				getEndPoints().clear();
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_SHAREABLE:
				setPartIsShareable(PART_IS_SHAREABLE_EDEFAULT);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__ALLENS_RELATION:
				setAllensRelation(ALLENS_RELATION_EDEFAULT);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TRUTH_MAKER:
				setTruthMaker((net.menthor.metamodel.ontouml.Class)null);
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
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__HOLDER:
				return basicGetHolder() != null;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__COMMENTS:
				return comments != null && !comments.isEmpty();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__STEREOTYPE:
				return stereotype != STEREOTYPE_EDEFAULT;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__END_POINTS:
				return endPoints != null && !endPoints.isEmpty();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_SHAREABLE:
				return partIsShareable != PART_IS_SHAREABLE_EDEFAULT;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__ALLENS_RELATION:
				return allensRelation != ALLENS_RELATION_EDEFAULT;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TRUTH_MAKER:
				return truthMaker != null;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__IS_DERIVED:
				return isIsDerived() != IS_DERIVED_EDEFAULT;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_ESSENTIAL:
				return isPartIsEssential() != PART_IS_ESSENTIAL_EDEFAULT;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_INSEPARABLE:
				return isPartIsInseparable() != PART_IS_INSEPARABLE_EDEFAULT;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_IMMUTABLE:
				return isPartIsImmutable() != PART_IS_IMMUTABLE_EDEFAULT;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__WHOLE_IS_IMMUTABLE:
				return isWholeIsImmutable() != WHOLE_IS_IMMUTABLE_EDEFAULT;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_MANDATORY:
				return isPartIsMandatory() != PART_IS_MANDATORY_EDEFAULT;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__WHOLE_IS_MANDATORY:
				return isWholeIsMandatory() != WHOLE_IS_MANDATORY_EDEFAULT;
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
				case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__HOLDER: return OntoumlPackage.CONTAINED_ELEMENT__HOLDER;
				case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__COMMENTS: return OntoumlPackage.CONTAINED_ELEMENT__COMMENTS;
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
				case OntoumlPackage.CONTAINED_ELEMENT__HOLDER: return OntoumlPackage.CLASS_BINARY_RELATIONSHIP__HOLDER;
				case OntoumlPackage.CONTAINED_ELEMENT__COMMENTS: return OntoumlPackage.CLASS_BINARY_RELATIONSHIP__COMMENTS;
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
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP___SOURCE_END:
				return sourceEnd();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP___TARGET_END:
				return targetEnd();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP___IS_MERONYMIC:
				return isMeronymic();
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
		result.append(", partIsShareable: ");
		result.append(partIsShareable);
		result.append(", allensRelation: ");
		result.append(allensRelation);
		result.append(')');
		return result.toString();
	}

} //ClassBinaryRelationshipImpl
