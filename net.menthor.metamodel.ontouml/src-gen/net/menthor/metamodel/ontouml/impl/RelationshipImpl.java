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
import net.menthor.metamodel.ontouml.EndPoint;
import net.menthor.metamodel.ontouml.GeneralizationSet;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.Relation;
import net.menthor.metamodel.ontouml.Relationship;
import net.menthor.metamodel.ontouml.Temporal;

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
 * An implementation of the model object '<em><b>Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RelationshipImpl#getHolder <em>Holder</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RelationshipImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RelationshipImpl#getIsSpecializedVia <em>Is Specialized Via</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RelationshipImpl#getSpecializesVia <em>Specializes Via</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RelationshipImpl#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RelationshipImpl#getAllenRelation <em>Allen Relation</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RelationshipImpl#getEndPoints <em>End Points</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RelationshipImpl#getDerivedFromTruthMaker <em>Derived From Truth Maker</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationshipImpl extends NamedElementImpl implements Relationship {
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
	 * The default value of the '{@link #getAllenRelation() <em>Allen Relation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllenRelation()
	 * @generated
	 * @ordered
	 */
	protected static final Temporal ALLEN_RELATION_EDEFAULT = Temporal.STARTS;

	/**
	 * The cached value of the '{@link #getAllenRelation() <em>Allen Relation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllenRelation()
	 * @generated
	 * @ordered
	 */
	protected Temporal allenRelation = ALLEN_RELATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEndPoints() <em>End Points</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndPoints()
	 * @generated
	 * @ordered
	 */
	protected EList<EndPoint> endPoints;

	/**
	 * The cached value of the '{@link #getDerivedFromTruthMaker() <em>Derived From Truth Maker</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivedFromTruthMaker()
	 * @generated
	 * @ordered
	 */
	protected net.menthor.metamodel.ontouml.Class derivedFromTruthMaker;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OntoumlPackage.Literals.RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Container getHolder() {
		if (eContainerFeatureID() != OntoumlPackage.RELATIONSHIP__HOLDER) return null;
		return (net.menthor.metamodel.ontouml.Container)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Container basicGetHolder() {
		if (eContainerFeatureID() != OntoumlPackage.RELATIONSHIP__HOLDER) return null;
		return (net.menthor.metamodel.ontouml.Container)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHolder(net.menthor.metamodel.ontouml.Container newHolder, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newHolder, OntoumlPackage.RELATIONSHIP__HOLDER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHolder(net.menthor.metamodel.ontouml.Container newHolder) {
		if (newHolder != eInternalContainer() || (eContainerFeatureID() != OntoumlPackage.RELATIONSHIP__HOLDER && newHolder != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.RELATIONSHIP__HOLDER, newHolder, newHolder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Comment> getComments() {
		if (comments == null) {
			comments = new EObjectContainmentWithInverseEList<Comment>(Comment.class, this, OntoumlPackage.RELATIONSHIP__COMMENTS, OntoumlPackage.COMMENT__OWNER);
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
			isSpecializedVia = new EObjectWithInverseResolvingEList<GeneralizationSet>(GeneralizationSet.class, this, OntoumlPackage.RELATIONSHIP__IS_SPECIALIZED_VIA, OntoumlPackage.GENERALIZATION_SET__SPECIALIZED_CLASSIFIER);
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
			specializesVia = new EObjectWithInverseResolvingEList.ManyInverse<GeneralizationSet>(GeneralizationSet.class, this, OntoumlPackage.RELATIONSHIP__SPECIALIZES_VIA, OntoumlPackage.GENERALIZATION_SET__SPECIALIZING_CLASSIFIER);
		}
		return specializesVia;
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
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.RELATIONSHIP__STEREOTYPE, oldStereotype, stereotype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Temporal getAllenRelation() {
		return allenRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllenRelation(Temporal newAllenRelation) {
		Temporal oldAllenRelation = allenRelation;
		allenRelation = newAllenRelation == null ? ALLEN_RELATION_EDEFAULT : newAllenRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.RELATIONSHIP__ALLEN_RELATION, oldAllenRelation, allenRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EndPoint> getEndPoints() {
		if (endPoints == null) {
			endPoints = new EObjectContainmentWithInverseEList<EndPoint>(EndPoint.class, this, OntoumlPackage.RELATIONSHIP__END_POINTS, OntoumlPackage.END_POINT__OWNER);
		}
		return endPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class getDerivedFromTruthMaker() {
		if (derivedFromTruthMaker != null && derivedFromTruthMaker.eIsProxy()) {
			InternalEObject oldDerivedFromTruthMaker = (InternalEObject)derivedFromTruthMaker;
			derivedFromTruthMaker = (net.menthor.metamodel.ontouml.Class)eResolveProxy(oldDerivedFromTruthMaker);
			if (derivedFromTruthMaker != oldDerivedFromTruthMaker) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.RELATIONSHIP__DERIVED_FROM_TRUTH_MAKER, oldDerivedFromTruthMaker, derivedFromTruthMaker));
			}
		}
		return derivedFromTruthMaker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class basicGetDerivedFromTruthMaker() {
		return derivedFromTruthMaker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDerivedFromTruthMaker(net.menthor.metamodel.ontouml.Class newDerivedFromTruthMaker, NotificationChain msgs) {
		net.menthor.metamodel.ontouml.Class oldDerivedFromTruthMaker = derivedFromTruthMaker;
		derivedFromTruthMaker = newDerivedFromTruthMaker;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OntoumlPackage.RELATIONSHIP__DERIVED_FROM_TRUTH_MAKER, oldDerivedFromTruthMaker, newDerivedFromTruthMaker);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDerivedFromTruthMaker(net.menthor.metamodel.ontouml.Class newDerivedFromTruthMaker) {
		if (newDerivedFromTruthMaker != derivedFromTruthMaker) {
			NotificationChain msgs = null;
			if (derivedFromTruthMaker != null)
				msgs = ((InternalEObject)derivedFromTruthMaker).eInverseRemove(this, OntoumlPackage.CLASS__ISTRUTH_MAKER_OF, net.menthor.metamodel.ontouml.Class.class, msgs);
			if (newDerivedFromTruthMaker != null)
				msgs = ((InternalEObject)newDerivedFromTruthMaker).eInverseAdd(this, OntoumlPackage.CLASS__ISTRUTH_MAKER_OF, net.menthor.metamodel.ontouml.Class.class, msgs);
			msgs = basicSetDerivedFromTruthMaker(newDerivedFromTruthMaker, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.RELATIONSHIP__DERIVED_FROM_TRUTH_MAKER, newDerivedFromTruthMaker, newDerivedFromTruthMaker));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void isShareable() {
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isComponentOf() {
		Relation _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Relation.COMPONENT_OF);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMemberOf() {
		Relation _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Relation.MEMBER_OF);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSubCollectionOf() {
		Relation _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Relation.SUB_COLLECTION_OF);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSubQuantityOf() {
		Relation _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Relation.SUB_QUANTITY_OF);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isConstitution() {
		Relation _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Relation.CONSTITUTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCharacterization() {
		Relation _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Relation.CHARACTERIZATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMediation() {
		Relation _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Relation.MEDIATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMaterial() {
		Relation _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Relation.MATERIAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFormal() {
		Relation _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Relation.FORMAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStructuration() {
		Relation _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Relation.STRUCTURATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isParticipation() {
		Relation _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Relation.PARTICIPATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSubEventOf() {
		Relation _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Relation.SUB_EVENT_OF);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCausation() {
		Relation _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Relation.CAUSATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTemporal() {
		Relation _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Relation.TEMPORAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDerivation() {
		Relation _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Relation.DERIVATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStarts() {
		boolean _and = false;
		Temporal _allenRelation = this.getAllenRelation();
		boolean _equals = Objects.equal(_allenRelation, Temporal.STARTS);
		if (!_equals) {
			_and = false;
		} else {
			boolean _isTemporal = this.isTemporal();
			_and = _isTemporal;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPrecedes() {
		boolean _and = false;
		Temporal _allenRelation = this.getAllenRelation();
		boolean _equals = Objects.equal(_allenRelation, Temporal.PRECEDES);
		if (!_equals) {
			_and = false;
		} else {
			boolean _isTemporal = this.isTemporal();
			_and = _isTemporal;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEquals() {
		boolean _and = false;
		Temporal _allenRelation = this.getAllenRelation();
		boolean _equals = Objects.equal(_allenRelation, Temporal.EQUALS);
		if (!_equals) {
			_and = false;
		} else {
			boolean _isTemporal = this.isTemporal();
			_and = _isTemporal;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMeets() {
		boolean _and = false;
		Temporal _allenRelation = this.getAllenRelation();
		boolean _equals = Objects.equal(_allenRelation, Temporal.MEETS);
		if (!_equals) {
			_and = false;
		} else {
			boolean _isTemporal = this.isTemporal();
			_and = _isTemporal;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFinishes() {
		boolean _and = false;
		Temporal _allenRelation = this.getAllenRelation();
		boolean _equals = Objects.equal(_allenRelation, Temporal.FINISHES);
		if (!_equals) {
			_and = false;
		} else {
			boolean _isTemporal = this.isTemporal();
			_and = _isTemporal;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOverlaps() {
		boolean _and = false;
		Temporal _allenRelation = this.getAllenRelation();
		boolean _equals = Objects.equal(_allenRelation, Temporal.OVERLAPS);
		if (!_equals) {
			_and = false;
		} else {
			boolean _isTemporal = this.isTemporal();
			_and = _isTemporal;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDuring() {
		boolean _and = false;
		Temporal _allenRelation = this.getAllenRelation();
		boolean _equals = Objects.equal(_allenRelation, Temporal.DURING);
		if (!_equals) {
			_and = false;
		} else {
			boolean _isTemporal = this.isTemporal();
			_and = _isTemporal;
		}
		return _and;
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
		boolean _isComponentOf = this.isComponentOf();
		if (_isComponentOf) {
			_or_2 = true;
		} else {
			boolean _isMemberOf = this.isMemberOf();
			_or_2 = _isMemberOf;
		}
		if (_or_2) {
			_or_1 = true;
		} else {
			boolean _isSubQuantityOf = this.isSubQuantityOf();
			_or_1 = _isSubQuantityOf;
		}
		if (_or_1) {
			_or = true;
		} else {
			boolean _isSubCollectionOf = this.isSubCollectionOf();
			_or = _isSubCollectionOf;
		}
		return _or;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBinary() {
		EList<EndPoint> _endPoints = this.getEndPoints();
		int _size = _endPoints.size();
		return (_size == 2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTernary() {
		EList<EndPoint> _endPoints = this.getEndPoints();
		int _size = _endPoints.size();
		return (_size == 3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndPoint sourceEnd() {
		EList<EndPoint> _endPoints = this.getEndPoints();
		int _size = _endPoints.size();
		boolean _greaterThan = (_size > 0);
		if (_greaterThan) {
			EList<EndPoint> _endPoints_1 = this.getEndPoints();
			return _endPoints_1.get(0);
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndPoint targetEnd() {
		EList<EndPoint> _endPoints = this.getEndPoints();
		int _size = _endPoints.size();
		boolean _greaterThan = (_size > 1);
		if (_greaterThan) {
			EList<EndPoint> _endPoints_1 = this.getEndPoints();
			return _endPoints_1.get(1);
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier source() {
		EndPoint _sourceEnd = this.sourceEnd();
		boolean _notEquals = (!Objects.equal(_sourceEnd, null));
		if (_notEquals) {
			EndPoint _sourceEnd_1 = this.sourceEnd();
			return _sourceEnd_1.getEndType();
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier target() {
		EndPoint _targetEnd = this.targetEnd();
		boolean _notEquals = (!Objects.equal(_targetEnd, null));
		if (_notEquals) {
			EndPoint _targetEnd_1 = this.targetEnd();
			return _targetEnd_1.getEndType();
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class sourceClass() {
		Classifier _source = this.source();
		boolean _notEquals = (!Objects.equal(_source, null));
		if (_notEquals) {
			Classifier _source_1 = this.source();
			return ((net.menthor.metamodel.ontouml.Class) _source_1);
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class targetClass() {
		Classifier _target = this.target();
		boolean _notEquals = (!Objects.equal(_target, null));
		if (_notEquals) {
			Classifier _target_1 = this.target();
			return ((net.menthor.metamodel.ontouml.Class) _target_1);
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relationship sourceRelationship() {
		Classifier _source = this.source();
		boolean _notEquals = (!Objects.equal(_source, null));
		if (_notEquals) {
			Classifier _source_1 = this.source();
			return ((Relationship) _source_1);
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relationship targetRelationship() {
		Classifier _target = this.target();
		boolean _notEquals = (!Objects.equal(_target, null));
		if (_notEquals) {
			Classifier _target_1 = this.target();
			return ((Relationship) _target_1);
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDerived() {
		EList<EndPoint> _endPoints = this.getEndPoints();
		for (final EndPoint ep : _endPoints) {
			boolean _isIsDerived = ep.isIsDerived();
			if (_isIsDerived) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPartEssential() {
		boolean _and = false;
		boolean _and_1 = false;
		EndPoint _targetEnd = this.targetEnd();
		boolean _isIsDependency = _targetEnd.isIsDependency();
		if (!_isIsDependency) {
			_and_1 = false;
		} else {
			net.menthor.metamodel.ontouml.Class _sourceClass = this.sourceClass();
			boolean _isRigid = _sourceClass.isRigid();
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
	public boolean isPartInseparable() {
		boolean _and = false;
		boolean _and_1 = false;
		EndPoint _sourceEnd = this.sourceEnd();
		boolean _isIsDependency = _sourceEnd.isIsDependency();
		if (!_isIsDependency) {
			_and_1 = false;
		} else {
			net.menthor.metamodel.ontouml.Class _targetClass = this.targetClass();
			boolean _isRigid = _targetClass.isRigid();
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
	public boolean isPartImmutable() {
		boolean _and = false;
		boolean _and_1 = false;
		EndPoint _sourceEnd = this.sourceEnd();
		boolean _isIsDependency = _sourceEnd.isIsDependency();
		if (!_isIsDependency) {
			_and_1 = false;
		} else {
			net.menthor.metamodel.ontouml.Class _targetClass = this.targetClass();
			boolean _isAntiRigid = _targetClass.isAntiRigid();
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
	public boolean isWholeImmutable() {
		boolean _and = false;
		boolean _and_1 = false;
		EndPoint _targetEnd = this.targetEnd();
		boolean _isIsDependency = _targetEnd.isIsDependency();
		if (!_isIsDependency) {
			_and_1 = false;
		} else {
			net.menthor.metamodel.ontouml.Class _sourceClass = this.sourceClass();
			boolean _isAntiRigid = _sourceClass.isAntiRigid();
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
	public boolean isPartMandatory() {
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
	public boolean isWholeMandatory() {
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
	public Relationship material() {
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class relator() {
		return null;
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
			case OntoumlPackage.RELATIONSHIP__HOLDER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetHolder((net.menthor.metamodel.ontouml.Container)otherEnd, msgs);
			case OntoumlPackage.RELATIONSHIP__COMMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComments()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.RELATIONSHIP__IS_SPECIALIZED_VIA:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIsSpecializedVia()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.RELATIONSHIP__SPECIALIZES_VIA:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpecializesVia()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.RELATIONSHIP__END_POINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEndPoints()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.RELATIONSHIP__DERIVED_FROM_TRUTH_MAKER:
				if (derivedFromTruthMaker != null)
					msgs = ((InternalEObject)derivedFromTruthMaker).eInverseRemove(this, OntoumlPackage.CLASS__ISTRUTH_MAKER_OF, net.menthor.metamodel.ontouml.Class.class, msgs);
				return basicSetDerivedFromTruthMaker((net.menthor.metamodel.ontouml.Class)otherEnd, msgs);
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
			case OntoumlPackage.RELATIONSHIP__HOLDER:
				return basicSetHolder(null, msgs);
			case OntoumlPackage.RELATIONSHIP__COMMENTS:
				return ((InternalEList<?>)getComments()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.RELATIONSHIP__IS_SPECIALIZED_VIA:
				return ((InternalEList<?>)getIsSpecializedVia()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.RELATIONSHIP__SPECIALIZES_VIA:
				return ((InternalEList<?>)getSpecializesVia()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.RELATIONSHIP__END_POINTS:
				return ((InternalEList<?>)getEndPoints()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.RELATIONSHIP__DERIVED_FROM_TRUTH_MAKER:
				return basicSetDerivedFromTruthMaker(null, msgs);
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
			case OntoumlPackage.RELATIONSHIP__HOLDER:
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
			case OntoumlPackage.RELATIONSHIP__HOLDER:
				if (resolve) return getHolder();
				return basicGetHolder();
			case OntoumlPackage.RELATIONSHIP__COMMENTS:
				return getComments();
			case OntoumlPackage.RELATIONSHIP__IS_SPECIALIZED_VIA:
				return getIsSpecializedVia();
			case OntoumlPackage.RELATIONSHIP__SPECIALIZES_VIA:
				return getSpecializesVia();
			case OntoumlPackage.RELATIONSHIP__STEREOTYPE:
				return getStereotype();
			case OntoumlPackage.RELATIONSHIP__ALLEN_RELATION:
				return getAllenRelation();
			case OntoumlPackage.RELATIONSHIP__END_POINTS:
				return getEndPoints();
			case OntoumlPackage.RELATIONSHIP__DERIVED_FROM_TRUTH_MAKER:
				if (resolve) return getDerivedFromTruthMaker();
				return basicGetDerivedFromTruthMaker();
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
			case OntoumlPackage.RELATIONSHIP__HOLDER:
				setHolder((net.menthor.metamodel.ontouml.Container)newValue);
				return;
			case OntoumlPackage.RELATIONSHIP__COMMENTS:
				getComments().clear();
				getComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case OntoumlPackage.RELATIONSHIP__IS_SPECIALIZED_VIA:
				getIsSpecializedVia().clear();
				getIsSpecializedVia().addAll((Collection<? extends GeneralizationSet>)newValue);
				return;
			case OntoumlPackage.RELATIONSHIP__SPECIALIZES_VIA:
				getSpecializesVia().clear();
				getSpecializesVia().addAll((Collection<? extends GeneralizationSet>)newValue);
				return;
			case OntoumlPackage.RELATIONSHIP__STEREOTYPE:
				setStereotype((Relation)newValue);
				return;
			case OntoumlPackage.RELATIONSHIP__ALLEN_RELATION:
				setAllenRelation((Temporal)newValue);
				return;
			case OntoumlPackage.RELATIONSHIP__END_POINTS:
				getEndPoints().clear();
				getEndPoints().addAll((Collection<? extends EndPoint>)newValue);
				return;
			case OntoumlPackage.RELATIONSHIP__DERIVED_FROM_TRUTH_MAKER:
				setDerivedFromTruthMaker((net.menthor.metamodel.ontouml.Class)newValue);
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
			case OntoumlPackage.RELATIONSHIP__HOLDER:
				setHolder((net.menthor.metamodel.ontouml.Container)null);
				return;
			case OntoumlPackage.RELATIONSHIP__COMMENTS:
				getComments().clear();
				return;
			case OntoumlPackage.RELATIONSHIP__IS_SPECIALIZED_VIA:
				getIsSpecializedVia().clear();
				return;
			case OntoumlPackage.RELATIONSHIP__SPECIALIZES_VIA:
				getSpecializesVia().clear();
				return;
			case OntoumlPackage.RELATIONSHIP__STEREOTYPE:
				setStereotype(STEREOTYPE_EDEFAULT);
				return;
			case OntoumlPackage.RELATIONSHIP__ALLEN_RELATION:
				setAllenRelation(ALLEN_RELATION_EDEFAULT);
				return;
			case OntoumlPackage.RELATIONSHIP__END_POINTS:
				getEndPoints().clear();
				return;
			case OntoumlPackage.RELATIONSHIP__DERIVED_FROM_TRUTH_MAKER:
				setDerivedFromTruthMaker((net.menthor.metamodel.ontouml.Class)null);
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
			case OntoumlPackage.RELATIONSHIP__HOLDER:
				return basicGetHolder() != null;
			case OntoumlPackage.RELATIONSHIP__COMMENTS:
				return comments != null && !comments.isEmpty();
			case OntoumlPackage.RELATIONSHIP__IS_SPECIALIZED_VIA:
				return isSpecializedVia != null && !isSpecializedVia.isEmpty();
			case OntoumlPackage.RELATIONSHIP__SPECIALIZES_VIA:
				return specializesVia != null && !specializesVia.isEmpty();
			case OntoumlPackage.RELATIONSHIP__STEREOTYPE:
				return stereotype != STEREOTYPE_EDEFAULT;
			case OntoumlPackage.RELATIONSHIP__ALLEN_RELATION:
				return allenRelation != ALLEN_RELATION_EDEFAULT;
			case OntoumlPackage.RELATIONSHIP__END_POINTS:
				return endPoints != null && !endPoints.isEmpty();
			case OntoumlPackage.RELATIONSHIP__DERIVED_FROM_TRUTH_MAKER:
				return derivedFromTruthMaker != null;
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
				case OntoumlPackage.RELATIONSHIP__HOLDER: return OntoumlPackage.CONTAINED_ELEMENT__HOLDER;
				case OntoumlPackage.RELATIONSHIP__COMMENTS: return OntoumlPackage.CONTAINED_ELEMENT__COMMENTS;
				default: return -1;
			}
		}
		if (baseClass == Classifier.class) {
			switch (derivedFeatureID) {
				case OntoumlPackage.RELATIONSHIP__IS_SPECIALIZED_VIA: return OntoumlPackage.CLASSIFIER__IS_SPECIALIZED_VIA;
				case OntoumlPackage.RELATIONSHIP__SPECIALIZES_VIA: return OntoumlPackage.CLASSIFIER__SPECIALIZES_VIA;
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
				case OntoumlPackage.CONTAINED_ELEMENT__HOLDER: return OntoumlPackage.RELATIONSHIP__HOLDER;
				case OntoumlPackage.CONTAINED_ELEMENT__COMMENTS: return OntoumlPackage.RELATIONSHIP__COMMENTS;
				default: return -1;
			}
		}
		if (baseClass == Classifier.class) {
			switch (baseFeatureID) {
				case OntoumlPackage.CLASSIFIER__IS_SPECIALIZED_VIA: return OntoumlPackage.RELATIONSHIP__IS_SPECIALIZED_VIA;
				case OntoumlPackage.CLASSIFIER__SPECIALIZES_VIA: return OntoumlPackage.RELATIONSHIP__SPECIALIZES_VIA;
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
				case OntoumlPackage.CLASSIFIER___CHILDREN: return OntoumlPackage.RELATIONSHIP___CHILDREN;
				case OntoumlPackage.CLASSIFIER___PARENTS: return OntoumlPackage.RELATIONSHIP___PARENTS;
				case OntoumlPackage.CLASSIFIER___ALL_PARENTS__CLASSIFIER_ELIST: return OntoumlPackage.RELATIONSHIP___ALL_PARENTS__CLASSIFIER_ELIST;
				case OntoumlPackage.CLASSIFIER___ALL_PARENTS: return OntoumlPackage.RELATIONSHIP___ALL_PARENTS;
				case OntoumlPackage.CLASSIFIER___ALL_CHILDREN__CLASSIFIER_ELIST: return OntoumlPackage.RELATIONSHIP___ALL_CHILDREN__CLASSIFIER_ELIST;
				case OntoumlPackage.CLASSIFIER___ALL_CHILDREN: return OntoumlPackage.RELATIONSHIP___ALL_CHILDREN;
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
			case OntoumlPackage.RELATIONSHIP___IS_SHAREABLE:
				isShareable();
				return null;
			case OntoumlPackage.RELATIONSHIP___IS_COMPONENT_OF:
				return isComponentOf();
			case OntoumlPackage.RELATIONSHIP___IS_MEMBER_OF:
				return isMemberOf();
			case OntoumlPackage.RELATIONSHIP___IS_SUB_COLLECTION_OF:
				return isSubCollectionOf();
			case OntoumlPackage.RELATIONSHIP___IS_SUB_QUANTITY_OF:
				return isSubQuantityOf();
			case OntoumlPackage.RELATIONSHIP___IS_CONSTITUTION:
				return isConstitution();
			case OntoumlPackage.RELATIONSHIP___IS_CHARACTERIZATION:
				return isCharacterization();
			case OntoumlPackage.RELATIONSHIP___IS_MEDIATION:
				return isMediation();
			case OntoumlPackage.RELATIONSHIP___IS_MATERIAL:
				return isMaterial();
			case OntoumlPackage.RELATIONSHIP___IS_FORMAL:
				return isFormal();
			case OntoumlPackage.RELATIONSHIP___IS_STRUCTURATION:
				return isStructuration();
			case OntoumlPackage.RELATIONSHIP___IS_PARTICIPATION:
				return isParticipation();
			case OntoumlPackage.RELATIONSHIP___IS_SUB_EVENT_OF:
				return isSubEventOf();
			case OntoumlPackage.RELATIONSHIP___IS_CAUSATION:
				return isCausation();
			case OntoumlPackage.RELATIONSHIP___IS_TEMPORAL:
				return isTemporal();
			case OntoumlPackage.RELATIONSHIP___IS_DERIVATION:
				return isDerivation();
			case OntoumlPackage.RELATIONSHIP___IS_STARTS:
				return isStarts();
			case OntoumlPackage.RELATIONSHIP___IS_PRECEDES:
				return isPrecedes();
			case OntoumlPackage.RELATIONSHIP___IS_EQUALS:
				return isEquals();
			case OntoumlPackage.RELATIONSHIP___IS_MEETS:
				return isMeets();
			case OntoumlPackage.RELATIONSHIP___IS_FINISHES:
				return isFinishes();
			case OntoumlPackage.RELATIONSHIP___IS_OVERLAPS:
				return isOverlaps();
			case OntoumlPackage.RELATIONSHIP___IS_DURING:
				return isDuring();
			case OntoumlPackage.RELATIONSHIP___IS_MERONYMIC:
				return isMeronymic();
			case OntoumlPackage.RELATIONSHIP___IS_BINARY:
				return isBinary();
			case OntoumlPackage.RELATIONSHIP___IS_TERNARY:
				return isTernary();
			case OntoumlPackage.RELATIONSHIP___SOURCE_END:
				return sourceEnd();
			case OntoumlPackage.RELATIONSHIP___TARGET_END:
				return targetEnd();
			case OntoumlPackage.RELATIONSHIP___SOURCE:
				return source();
			case OntoumlPackage.RELATIONSHIP___TARGET:
				return target();
			case OntoumlPackage.RELATIONSHIP___SOURCE_CLASS:
				return sourceClass();
			case OntoumlPackage.RELATIONSHIP___TARGET_CLASS:
				return targetClass();
			case OntoumlPackage.RELATIONSHIP___SOURCE_RELATIONSHIP:
				return sourceRelationship();
			case OntoumlPackage.RELATIONSHIP___TARGET_RELATIONSHIP:
				return targetRelationship();
			case OntoumlPackage.RELATIONSHIP___IS_DERIVED:
				return isDerived();
			case OntoumlPackage.RELATIONSHIP___IS_PART_ESSENTIAL:
				return isPartEssential();
			case OntoumlPackage.RELATIONSHIP___IS_PART_INSEPARABLE:
				return isPartInseparable();
			case OntoumlPackage.RELATIONSHIP___IS_PART_IMMUTABLE:
				return isPartImmutable();
			case OntoumlPackage.RELATIONSHIP___IS_WHOLE_IMMUTABLE:
				return isWholeImmutable();
			case OntoumlPackage.RELATIONSHIP___IS_PART_MANDATORY:
				return isPartMandatory();
			case OntoumlPackage.RELATIONSHIP___IS_WHOLE_MANDATORY:
				return isWholeMandatory();
			case OntoumlPackage.RELATIONSHIP___MATERIAL:
				return material();
			case OntoumlPackage.RELATIONSHIP___RELATOR:
				return relator();
			case OntoumlPackage.RELATIONSHIP___CHILDREN:
				return children();
			case OntoumlPackage.RELATIONSHIP___PARENTS:
				return parents();
			case OntoumlPackage.RELATIONSHIP___ALL_PARENTS__CLASSIFIER_ELIST:
				allParents((Classifier)arguments.get(0), (EList<Classifier>)arguments.get(1));
				return null;
			case OntoumlPackage.RELATIONSHIP___ALL_PARENTS:
				return allParents();
			case OntoumlPackage.RELATIONSHIP___ALL_CHILDREN__CLASSIFIER_ELIST:
				allChildren((Classifier)arguments.get(0), (EList<Classifier>)arguments.get(1));
				return null;
			case OntoumlPackage.RELATIONSHIP___ALL_CHILDREN:
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
		result.append(" (stereotype: ");
		result.append(stereotype);
		result.append(", allenRelation: ");
		result.append(allenRelation);
		result.append(')');
		return result.toString();
	}

} //RelationshipImpl
