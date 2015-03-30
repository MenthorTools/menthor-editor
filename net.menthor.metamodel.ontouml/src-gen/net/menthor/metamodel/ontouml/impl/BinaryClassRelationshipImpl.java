/**
 */
package net.menthor.metamodel.ontouml.impl;

import com.google.common.base.Objects;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import net.menthor.metamodel.ontouml.AllenRelation;
import net.menthor.metamodel.ontouml.BinaryClassRelationship;
import net.menthor.metamodel.ontouml.BinaryRelationship;
import net.menthor.metamodel.ontouml.ClassifierElement;
import net.menthor.metamodel.ontouml.Comment;
import net.menthor.metamodel.ontouml.ContainedElement;
import net.menthor.metamodel.ontouml.EndPoint;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.Relation;
import net.menthor.metamodel.ontouml.Relationship;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Class Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.BinaryClassRelationshipImpl#getHolder <em>Holder</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.BinaryClassRelationshipImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.BinaryClassRelationshipImpl#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.BinaryClassRelationshipImpl#getAllenRelation <em>Allen Relation</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.BinaryClassRelationshipImpl#getEndPoints <em>End Points</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.BinaryClassRelationshipImpl#getTruthMaker <em>Truth Maker</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BinaryClassRelationshipImpl extends NamedElementImpl implements BinaryClassRelationship {
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
	 * The default value of the '{@link #getAllenRelation() <em>Allen Relation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllenRelation()
	 * @generated
	 * @ordered
	 */
	protected static final AllenRelation ALLEN_RELATION_EDEFAULT = AllenRelation.STARTS;

	/**
	 * The cached value of the '{@link #getAllenRelation() <em>Allen Relation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllenRelation()
	 * @generated
	 * @ordered
	 */
	protected AllenRelation allenRelation = ALLEN_RELATION_EDEFAULT;

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
	 * The cached value of the '{@link #getTruthMaker() <em>Truth Maker</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTruthMaker()
	 * @generated
	 * @ordered
	 */
	protected net.menthor.metamodel.ontouml.Class truthMaker;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryClassRelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OntoumlPackage.Literals.BINARY_CLASS_RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Container getHolder() {
		if (eContainerFeatureID() != OntoumlPackage.BINARY_CLASS_RELATIONSHIP__HOLDER) return null;
		return (net.menthor.metamodel.ontouml.Container)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Container basicGetHolder() {
		if (eContainerFeatureID() != OntoumlPackage.BINARY_CLASS_RELATIONSHIP__HOLDER) return null;
		return (net.menthor.metamodel.ontouml.Container)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHolder(net.menthor.metamodel.ontouml.Container newHolder, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newHolder, OntoumlPackage.BINARY_CLASS_RELATIONSHIP__HOLDER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHolder(net.menthor.metamodel.ontouml.Container newHolder) {
		if (newHolder != eInternalContainer() || (eContainerFeatureID() != OntoumlPackage.BINARY_CLASS_RELATIONSHIP__HOLDER && newHolder != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.BINARY_CLASS_RELATIONSHIP__HOLDER, newHolder, newHolder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Comment> getComments() {
		if (comments == null) {
			comments = new EObjectContainmentWithInverseEList<Comment>(Comment.class, this, OntoumlPackage.BINARY_CLASS_RELATIONSHIP__COMMENTS, OntoumlPackage.COMMENT__OWNER);
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
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.BINARY_CLASS_RELATIONSHIP__STEREOTYPE, oldStereotype, stereotype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllenRelation getAllenRelation() {
		return allenRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllenRelation(AllenRelation newAllenRelation) {
		AllenRelation oldAllenRelation = allenRelation;
		allenRelation = newAllenRelation == null ? ALLEN_RELATION_EDEFAULT : newAllenRelation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.BINARY_CLASS_RELATIONSHIP__ALLEN_RELATION, oldAllenRelation, allenRelation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EndPoint> getEndPoints() {
		if (endPoints == null) {
			endPoints = new EObjectContainmentWithInverseEList<EndPoint>(EndPoint.class, this, OntoumlPackage.BINARY_CLASS_RELATIONSHIP__END_POINTS, OntoumlPackage.END_POINT__OWNER);
		}
		return endPoints;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.BINARY_CLASS_RELATIONSHIP__TRUTH_MAKER, oldTruthMaker, truthMaker));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OntoumlPackage.BINARY_CLASS_RELATIONSHIP__TRUTH_MAKER, oldTruthMaker, newTruthMaker);
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
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.BINARY_CLASS_RELATIONSHIP__TRUTH_MAKER, newTruthMaker, newTruthMaker));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class sourceClass() {
		EList<EndPoint> _endPoints = this.getEndPoints();
		EndPoint _get = _endPoints.get(0);
		ClassifierElement _endType = _get.getEndType();
		if ((_endType instanceof net.menthor.metamodel.ontouml.Class)) {
			EList<EndPoint> _endPoints_1 = this.getEndPoints();
			EndPoint _get_1 = _endPoints_1.get(0);
			ClassifierElement _endType_1 = _get_1.getEndType();
			return ((net.menthor.metamodel.ontouml.Class) _endType_1);
		}
		else {
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class targetClass() {
		EList<EndPoint> _endPoints = this.getEndPoints();
		EndPoint _get = _endPoints.get(1);
		ClassifierElement _endType = _get.getEndType();
		if ((_endType instanceof net.menthor.metamodel.ontouml.Class)) {
			EList<EndPoint> _endPoints_1 = this.getEndPoints();
			EndPoint _get_1 = _endPoints_1.get(1);
			ClassifierElement _endType_1 = _get_1.getEndType();
			return ((net.menthor.metamodel.ontouml.Class) _endType_1);
		}
		else {
			return null;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPartEssential() {
		boolean _and = false;
		boolean _and_1 = false;
		EndPoint _targetEndPoint = this.targetEndPoint();
		boolean _isIsDependee = _targetEndPoint.isIsDependee();
		if (!_isIsDependee) {
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
		EndPoint _sourceEndPoint = this.sourceEndPoint();
		boolean _isIsDependee = _sourceEndPoint.isIsDependee();
		if (!_isIsDependee) {
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
		EndPoint _sourceEndPoint = this.sourceEndPoint();
		boolean _isIsDependee = _sourceEndPoint.isIsDependee();
		if (!_isIsDependee) {
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
		EndPoint _targetEndPoint = this.targetEndPoint();
		boolean _isIsDependee = _targetEndPoint.isIsDependee();
		if (!_isIsDependee) {
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
		EndPoint _targetEndPoint = this.targetEndPoint();
		int _lowerBound = _targetEndPoint.getLowerBound();
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
		EndPoint _sourceEndPoint = this.sourceEndPoint();
		int _lowerBound = _sourceEndPoint.getLowerBound();
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
	public EndPoint sourceEndPoint() {
		EList<EndPoint> _endPoints = this.getEndPoints();
		return _endPoints.get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndPoint targetEndPoint() {
		EList<EndPoint> _endPoints = this.getEndPoints();
		return _endPoints.get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDerived() {
		boolean _or = false;
		EndPoint _sourceEndPoint = this.sourceEndPoint();
		boolean _isIsDerived = _sourceEndPoint.isIsDerived();
		if (_isIsDerived) {
			_or = true;
		} else {
			EndPoint _targetEndPoint = this.targetEndPoint();
			boolean _isIsDerived_1 = _targetEndPoint.isIsDerived();
			_or = _isIsDerived_1;
		}
		return _or;
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
	public boolean isStarts() {
		boolean _and = false;
		AllenRelation _allenRelation = this.getAllenRelation();
		boolean _equals = Objects.equal(_allenRelation, AllenRelation.STARTS);
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
		AllenRelation _allenRelation = this.getAllenRelation();
		boolean _equals = Objects.equal(_allenRelation, AllenRelation.PRECEDES);
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
		AllenRelation _allenRelation = this.getAllenRelation();
		boolean _equals = Objects.equal(_allenRelation, AllenRelation.EQUALS);
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
		AllenRelation _allenRelation = this.getAllenRelation();
		boolean _equals = Objects.equal(_allenRelation, AllenRelation.MEETS);
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
		AllenRelation _allenRelation = this.getAllenRelation();
		boolean _equals = Objects.equal(_allenRelation, AllenRelation.FINISHES);
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
		AllenRelation _allenRelation = this.getAllenRelation();
		boolean _equals = Objects.equal(_allenRelation, AllenRelation.OVERLAPS);
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
		AllenRelation _allenRelation = this.getAllenRelation();
		boolean _equals = Objects.equal(_allenRelation, AllenRelation.DURING);
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__HOLDER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetHolder((net.menthor.metamodel.ontouml.Container)otherEnd, msgs);
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__COMMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComments()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__END_POINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEndPoints()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__TRUTH_MAKER:
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
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__HOLDER:
				return basicSetHolder(null, msgs);
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__COMMENTS:
				return ((InternalEList<?>)getComments()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__END_POINTS:
				return ((InternalEList<?>)getEndPoints()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__TRUTH_MAKER:
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
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__HOLDER:
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
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__HOLDER:
				if (resolve) return getHolder();
				return basicGetHolder();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__COMMENTS:
				return getComments();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__STEREOTYPE:
				return getStereotype();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__ALLEN_RELATION:
				return getAllenRelation();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__END_POINTS:
				return getEndPoints();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__TRUTH_MAKER:
				if (resolve) return getTruthMaker();
				return basicGetTruthMaker();
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
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__HOLDER:
				setHolder((net.menthor.metamodel.ontouml.Container)newValue);
				return;
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__COMMENTS:
				getComments().clear();
				getComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__STEREOTYPE:
				setStereotype((Relation)newValue);
				return;
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__ALLEN_RELATION:
				setAllenRelation((AllenRelation)newValue);
				return;
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__END_POINTS:
				getEndPoints().clear();
				getEndPoints().addAll((Collection<? extends EndPoint>)newValue);
				return;
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__TRUTH_MAKER:
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
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__HOLDER:
				setHolder((net.menthor.metamodel.ontouml.Container)null);
				return;
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__COMMENTS:
				getComments().clear();
				return;
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__STEREOTYPE:
				setStereotype(STEREOTYPE_EDEFAULT);
				return;
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__ALLEN_RELATION:
				setAllenRelation(ALLEN_RELATION_EDEFAULT);
				return;
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__END_POINTS:
				getEndPoints().clear();
				return;
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__TRUTH_MAKER:
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
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__HOLDER:
				return basicGetHolder() != null;
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__COMMENTS:
				return comments != null && !comments.isEmpty();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__STEREOTYPE:
				return stereotype != STEREOTYPE_EDEFAULT;
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__ALLEN_RELATION:
				return allenRelation != ALLEN_RELATION_EDEFAULT;
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__END_POINTS:
				return endPoints != null && !endPoints.isEmpty();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__TRUTH_MAKER:
				return truthMaker != null;
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
				case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__HOLDER: return OntoumlPackage.CONTAINED_ELEMENT__HOLDER;
				case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__COMMENTS: return OntoumlPackage.CONTAINED_ELEMENT__COMMENTS;
				default: return -1;
			}
		}
		if (baseClass == ClassifierElement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Relationship.class) {
			switch (derivedFeatureID) {
				case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__STEREOTYPE: return OntoumlPackage.RELATIONSHIP__STEREOTYPE;
				case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__ALLEN_RELATION: return OntoumlPackage.RELATIONSHIP__ALLEN_RELATION;
				case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__END_POINTS: return OntoumlPackage.RELATIONSHIP__END_POINTS;
				case OntoumlPackage.BINARY_CLASS_RELATIONSHIP__TRUTH_MAKER: return OntoumlPackage.RELATIONSHIP__TRUTH_MAKER;
				default: return -1;
			}
		}
		if (baseClass == BinaryRelationship.class) {
			switch (derivedFeatureID) {
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
				case OntoumlPackage.CONTAINED_ELEMENT__HOLDER: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP__HOLDER;
				case OntoumlPackage.CONTAINED_ELEMENT__COMMENTS: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP__COMMENTS;
				default: return -1;
			}
		}
		if (baseClass == ClassifierElement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == Relationship.class) {
			switch (baseFeatureID) {
				case OntoumlPackage.RELATIONSHIP__STEREOTYPE: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP__STEREOTYPE;
				case OntoumlPackage.RELATIONSHIP__ALLEN_RELATION: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP__ALLEN_RELATION;
				case OntoumlPackage.RELATIONSHIP__END_POINTS: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP__END_POINTS;
				case OntoumlPackage.RELATIONSHIP__TRUTH_MAKER: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP__TRUTH_MAKER;
				default: return -1;
			}
		}
		if (baseClass == BinaryRelationship.class) {
			switch (baseFeatureID) {
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
		if (baseClass == ClassifierElement.class) {
			switch (baseOperationID) {
				default: return -1;
			}
		}
		if (baseClass == Relationship.class) {
			switch (baseOperationID) {
				case OntoumlPackage.RELATIONSHIP___IS_SHAREABLE: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_SHAREABLE;
				case OntoumlPackage.RELATIONSHIP___IS_COMPONENT_OF: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_COMPONENT_OF;
				case OntoumlPackage.RELATIONSHIP___IS_MEMBER_OF: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_MEMBER_OF;
				case OntoumlPackage.RELATIONSHIP___IS_SUB_COLLECTION_OF: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_SUB_COLLECTION_OF;
				case OntoumlPackage.RELATIONSHIP___IS_SUB_QUANTITY_OF: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_SUB_QUANTITY_OF;
				case OntoumlPackage.RELATIONSHIP___IS_CONSTITUTION: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_CONSTITUTION;
				case OntoumlPackage.RELATIONSHIP___IS_CHARACTERIZATION: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_CHARACTERIZATION;
				case OntoumlPackage.RELATIONSHIP___IS_MEDIATION: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_MEDIATION;
				case OntoumlPackage.RELATIONSHIP___IS_MATERIAL: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_MATERIAL;
				case OntoumlPackage.RELATIONSHIP___IS_FORMAL: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_FORMAL;
				case OntoumlPackage.RELATIONSHIP___IS_STRUCTURATION: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_STRUCTURATION;
				case OntoumlPackage.RELATIONSHIP___IS_PARTICIPATION: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_PARTICIPATION;
				case OntoumlPackage.RELATIONSHIP___IS_SUB_EVENT_OF: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_SUB_EVENT_OF;
				case OntoumlPackage.RELATIONSHIP___IS_CAUSATION: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_CAUSATION;
				case OntoumlPackage.RELATIONSHIP___IS_TEMPORAL: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_TEMPORAL;
				case OntoumlPackage.RELATIONSHIP___IS_STARTS: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_STARTS;
				case OntoumlPackage.RELATIONSHIP___IS_PRECEDES: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_PRECEDES;
				case OntoumlPackage.RELATIONSHIP___IS_EQUALS: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_EQUALS;
				case OntoumlPackage.RELATIONSHIP___IS_MEETS: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_MEETS;
				case OntoumlPackage.RELATIONSHIP___IS_FINISHES: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_FINISHES;
				case OntoumlPackage.RELATIONSHIP___IS_OVERLAPS: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_OVERLAPS;
				case OntoumlPackage.RELATIONSHIP___IS_DURING: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_DURING;
				case OntoumlPackage.RELATIONSHIP___IS_MERONYMIC: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_MERONYMIC;
				default: return -1;
			}
		}
		if (baseClass == BinaryRelationship.class) {
			switch (baseOperationID) {
				case OntoumlPackage.BINARY_RELATIONSHIP___SOURCE_END_POINT: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP___SOURCE_END_POINT;
				case OntoumlPackage.BINARY_RELATIONSHIP___TARGET_END_POINT: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP___TARGET_END_POINT;
				case OntoumlPackage.BINARY_RELATIONSHIP___IS_DERIVED: return OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_DERIVED;
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
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___SOURCE_CLASS:
				return sourceClass();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___TARGET_CLASS:
				return targetClass();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_PART_ESSENTIAL:
				return isPartEssential();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_PART_INSEPARABLE:
				return isPartInseparable();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_PART_IMMUTABLE:
				return isPartImmutable();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_WHOLE_IMMUTABLE:
				return isWholeImmutable();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_PART_MANDATORY:
				return isPartMandatory();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_WHOLE_MANDATORY:
				return isWholeMandatory();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___SOURCE_END_POINT:
				return sourceEndPoint();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___TARGET_END_POINT:
				return targetEndPoint();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_DERIVED:
				return isDerived();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_SHAREABLE:
				isShareable();
				return null;
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_COMPONENT_OF:
				return isComponentOf();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_MEMBER_OF:
				return isMemberOf();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_SUB_COLLECTION_OF:
				return isSubCollectionOf();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_SUB_QUANTITY_OF:
				return isSubQuantityOf();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_CONSTITUTION:
				return isConstitution();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_CHARACTERIZATION:
				return isCharacterization();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_MEDIATION:
				return isMediation();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_MATERIAL:
				return isMaterial();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_FORMAL:
				return isFormal();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_STRUCTURATION:
				return isStructuration();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_PARTICIPATION:
				return isParticipation();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_SUB_EVENT_OF:
				return isSubEventOf();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_CAUSATION:
				return isCausation();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_TEMPORAL:
				return isTemporal();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_STARTS:
				return isStarts();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_PRECEDES:
				return isPrecedes();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_EQUALS:
				return isEquals();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_MEETS:
				return isMeets();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_FINISHES:
				return isFinishes();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_OVERLAPS:
				return isOverlaps();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_DURING:
				return isDuring();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP___IS_MERONYMIC:
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
		result.append(", allenRelation: ");
		result.append(allenRelation);
		result.append(')');
		return result.toString();
	}

} //BinaryClassRelationshipImpl
