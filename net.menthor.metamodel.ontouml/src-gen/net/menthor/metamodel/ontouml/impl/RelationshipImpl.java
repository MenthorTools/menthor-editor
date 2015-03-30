/**
 */
package net.menthor.metamodel.ontouml.impl;

import com.google.common.base.Objects;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import net.menthor.metamodel.ontouml.AllenRelation;
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
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RelationshipImpl#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RelationshipImpl#getAllenRelation <em>Allen Relation</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RelationshipImpl#getEndPoints <em>End Points</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RelationshipImpl#getTruthMaker <em>Truth Maker</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RelationshipImpl extends ClassifierElementImpl implements Relationship {
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
	public net.menthor.metamodel.ontouml.Class getTruthMaker() {
		if (truthMaker != null && truthMaker.eIsProxy()) {
			InternalEObject oldTruthMaker = (InternalEObject)truthMaker;
			truthMaker = (net.menthor.metamodel.ontouml.Class)eResolveProxy(oldTruthMaker);
			if (truthMaker != oldTruthMaker) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.RELATIONSHIP__TRUTH_MAKER, oldTruthMaker, truthMaker));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OntoumlPackage.RELATIONSHIP__TRUTH_MAKER, oldTruthMaker, newTruthMaker);
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
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.RELATIONSHIP__TRUTH_MAKER, newTruthMaker, newTruthMaker));
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
			case OntoumlPackage.RELATIONSHIP__END_POINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEndPoints()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.RELATIONSHIP__TRUTH_MAKER:
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
			case OntoumlPackage.RELATIONSHIP__END_POINTS:
				return ((InternalEList<?>)getEndPoints()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.RELATIONSHIP__TRUTH_MAKER:
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OntoumlPackage.RELATIONSHIP__STEREOTYPE:
				return getStereotype();
			case OntoumlPackage.RELATIONSHIP__ALLEN_RELATION:
				return getAllenRelation();
			case OntoumlPackage.RELATIONSHIP__END_POINTS:
				return getEndPoints();
			case OntoumlPackage.RELATIONSHIP__TRUTH_MAKER:
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
			case OntoumlPackage.RELATIONSHIP__STEREOTYPE:
				setStereotype((Relation)newValue);
				return;
			case OntoumlPackage.RELATIONSHIP__ALLEN_RELATION:
				setAllenRelation((AllenRelation)newValue);
				return;
			case OntoumlPackage.RELATIONSHIP__END_POINTS:
				getEndPoints().clear();
				getEndPoints().addAll((Collection<? extends EndPoint>)newValue);
				return;
			case OntoumlPackage.RELATIONSHIP__TRUTH_MAKER:
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
			case OntoumlPackage.RELATIONSHIP__STEREOTYPE:
				setStereotype(STEREOTYPE_EDEFAULT);
				return;
			case OntoumlPackage.RELATIONSHIP__ALLEN_RELATION:
				setAllenRelation(ALLEN_RELATION_EDEFAULT);
				return;
			case OntoumlPackage.RELATIONSHIP__END_POINTS:
				getEndPoints().clear();
				return;
			case OntoumlPackage.RELATIONSHIP__TRUTH_MAKER:
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
			case OntoumlPackage.RELATIONSHIP__STEREOTYPE:
				return stereotype != STEREOTYPE_EDEFAULT;
			case OntoumlPackage.RELATIONSHIP__ALLEN_RELATION:
				return allenRelation != ALLEN_RELATION_EDEFAULT;
			case OntoumlPackage.RELATIONSHIP__END_POINTS:
				return endPoints != null && !endPoints.isEmpty();
			case OntoumlPackage.RELATIONSHIP__TRUTH_MAKER:
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
