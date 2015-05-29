/**
 */
package net.menthor.metamodel.ontouml.impl;

import com.google.common.base.Objects;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import net.menthor.metamodel.ontouml.Ciclicity;
import net.menthor.metamodel.ontouml.Classifier;
import net.menthor.metamodel.ontouml.DataType;
import net.menthor.metamodel.ontouml.EndPoint;
import net.menthor.metamodel.ontouml.NamedElement;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.ParticipationNature;
import net.menthor.metamodel.ontouml.Reflexivity;
import net.menthor.metamodel.ontouml.Relationship;
import net.menthor.metamodel.ontouml.RelationshipStereotype;
import net.menthor.metamodel.ontouml.Symmetry;
import net.menthor.metamodel.ontouml.TemporalNature;
import net.menthor.metamodel.ontouml.Transitivity;

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
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RelationshipImpl#getName <em>Name</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RelationshipImpl#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RelationshipImpl#getReflexivity <em>Reflexivity</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RelationshipImpl#getSymmetry <em>Symmetry</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RelationshipImpl#getTransitivity <em>Transitivity</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RelationshipImpl#getCiclicity <em>Ciclicity</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RelationshipImpl#getEndPoints <em>End Points</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RelationshipImpl#getTemporalNature <em>Temporal Nature</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.RelationshipImpl#getParticipationNature <em>Participation Nature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationshipImpl extends ClassifierImpl implements Relationship {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getStereotype() <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotype()
	 * @generated
	 * @ordered
	 */
	protected static final RelationshipStereotype STEREOTYPE_EDEFAULT = RelationshipStereotype.COMPONENT_OF;

	/**
	 * The cached value of the '{@link #getStereotype() <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotype()
	 * @generated
	 * @ordered
	 */
	protected RelationshipStereotype stereotype = STEREOTYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getReflexivity() <em>Reflexivity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReflexivity()
	 * @generated
	 * @ordered
	 */
	protected static final Reflexivity REFLEXIVITY_EDEFAULT = Reflexivity.REFLEXIVE;

	/**
	 * The cached value of the '{@link #getReflexivity() <em>Reflexivity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReflexivity()
	 * @generated
	 * @ordered
	 */
	protected Reflexivity reflexivity = REFLEXIVITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getSymmetry() <em>Symmetry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymmetry()
	 * @generated
	 * @ordered
	 */
	protected static final Symmetry SYMMETRY_EDEFAULT = Symmetry.SYMMETRIC;

	/**
	 * The cached value of the '{@link #getSymmetry() <em>Symmetry</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymmetry()
	 * @generated
	 * @ordered
	 */
	protected Symmetry symmetry = SYMMETRY_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransitivity() <em>Transitivity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitivity()
	 * @generated
	 * @ordered
	 */
	protected static final Transitivity TRANSITIVITY_EDEFAULT = Transitivity.TRANSITIVE;

	/**
	 * The cached value of the '{@link #getTransitivity() <em>Transitivity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitivity()
	 * @generated
	 * @ordered
	 */
	protected Transitivity transitivity = TRANSITIVITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getCiclicity() <em>Ciclicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCiclicity()
	 * @generated
	 * @ordered
	 */
	protected static final Ciclicity CICLICITY_EDEFAULT = Ciclicity.CYCLIC;

	/**
	 * The cached value of the '{@link #getCiclicity() <em>Ciclicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCiclicity()
	 * @generated
	 * @ordered
	 */
	protected Ciclicity ciclicity = CICLICITY_EDEFAULT;

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
	 * The default value of the '{@link #getTemporalNature() <em>Temporal Nature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemporalNature()
	 * @generated
	 * @ordered
	 */
	protected static final TemporalNature TEMPORAL_NATURE_EDEFAULT = TemporalNature.STARTS;

	/**
	 * The cached value of the '{@link #getTemporalNature() <em>Temporal Nature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemporalNature()
	 * @generated
	 * @ordered
	 */
	protected TemporalNature temporalNature = TEMPORAL_NATURE_EDEFAULT;

	/**
	 * The default value of the '{@link #getParticipationNature() <em>Participation Nature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParticipationNature()
	 * @generated
	 * @ordered
	 */
	protected static final ParticipationNature PARTICIPATION_NATURE_EDEFAULT = ParticipationNature.CREATION;

	/**
	 * The cached value of the '{@link #getParticipationNature() <em>Participation Nature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParticipationNature()
	 * @generated
	 * @ordered
	 */
	protected ParticipationNature participationNature = PARTICIPATION_NATURE_EDEFAULT;

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
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.RELATIONSHIP__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationshipStereotype getStereotype() {
		return stereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotype(RelationshipStereotype newStereotype) {
		RelationshipStereotype oldStereotype = stereotype;
		stereotype = newStereotype == null ? STEREOTYPE_EDEFAULT : newStereotype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.RELATIONSHIP__STEREOTYPE, oldStereotype, stereotype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reflexivity getReflexivity() {
		return reflexivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReflexivity(Reflexivity newReflexivity) {
		Reflexivity oldReflexivity = reflexivity;
		reflexivity = newReflexivity == null ? REFLEXIVITY_EDEFAULT : newReflexivity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.RELATIONSHIP__REFLEXIVITY, oldReflexivity, reflexivity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Symmetry getSymmetry() {
		return symmetry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSymmetry(Symmetry newSymmetry) {
		Symmetry oldSymmetry = symmetry;
		symmetry = newSymmetry == null ? SYMMETRY_EDEFAULT : newSymmetry;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.RELATIONSHIP__SYMMETRY, oldSymmetry, symmetry));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transitivity getTransitivity() {
		return transitivity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransitivity(Transitivity newTransitivity) {
		Transitivity oldTransitivity = transitivity;
		transitivity = newTransitivity == null ? TRANSITIVITY_EDEFAULT : newTransitivity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.RELATIONSHIP__TRANSITIVITY, oldTransitivity, transitivity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ciclicity getCiclicity() {
		return ciclicity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCiclicity(Ciclicity newCiclicity) {
		Ciclicity oldCiclicity = ciclicity;
		ciclicity = newCiclicity == null ? CICLICITY_EDEFAULT : newCiclicity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.RELATIONSHIP__CICLICITY, oldCiclicity, ciclicity));
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
	public TemporalNature getTemporalNature() {
		return temporalNature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemporalNature(TemporalNature newTemporalNature) {
		TemporalNature oldTemporalNature = temporalNature;
		temporalNature = newTemporalNature == null ? TEMPORAL_NATURE_EDEFAULT : newTemporalNature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.RELATIONSHIP__TEMPORAL_NATURE, oldTemporalNature, temporalNature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParticipationNature getParticipationNature() {
		return participationNature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParticipationNature(ParticipationNature newParticipationNature) {
		ParticipationNature oldParticipationNature = participationNature;
		participationNature = newParticipationNature == null ? PARTICIPATION_NATURE_EDEFAULT : newParticipationNature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.RELATIONSHIP__PARTICIPATION_NATURE, oldParticipationNature, participationNature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isComponentOf() {
		RelationshipStereotype _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, RelationshipStereotype.COMPONENT_OF);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMemberOf() {
		RelationshipStereotype _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, RelationshipStereotype.MEMBER_OF);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSubCollectionOf() {
		RelationshipStereotype _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, RelationshipStereotype.SUB_COLLECTION_OF);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSubQuantityOf() {
		RelationshipStereotype _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, RelationshipStereotype.SUB_QUANTITY_OF);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isConstitution() {
		RelationshipStereotype _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, RelationshipStereotype.CONSTITUTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCharacterization() {
		RelationshipStereotype _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, RelationshipStereotype.CHARACTERIZATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMediation() {
		RelationshipStereotype _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, RelationshipStereotype.MEDIATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMaterial() {
		RelationshipStereotype _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, RelationshipStereotype.MATERIAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFormal() {
		RelationshipStereotype _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, RelationshipStereotype.FORMAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStructuration() {
		RelationshipStereotype _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, RelationshipStereotype.STRUCTURATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isParticipation() {
		RelationshipStereotype _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, RelationshipStereotype.PARTICIPATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSubEventOf() {
		RelationshipStereotype _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, RelationshipStereotype.SUB_EVENT_OF);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCausation() {
		RelationshipStereotype _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, RelationshipStereotype.CAUSATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTemporal() {
		RelationshipStereotype _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, RelationshipStereotype.TEMPORAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInstanceOf() {
		RelationshipStereotype _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, RelationshipStereotype.INSTANCE_OF);
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
		boolean _or_3 = false;
		boolean _or_4 = false;
		boolean _isComponentOf = this.isComponentOf();
		if (_isComponentOf) {
			_or_4 = true;
		} else {
			boolean _isMemberOf = this.isMemberOf();
			_or_4 = _isMemberOf;
		}
		if (_or_4) {
			_or_3 = true;
		} else {
			boolean _isSubQuantityOf = this.isSubQuantityOf();
			_or_3 = _isSubQuantityOf;
		}
		if (_or_3) {
			_or_2 = true;
		} else {
			boolean _isSubCollectionOf = this.isSubCollectionOf();
			_or_2 = _isSubCollectionOf;
		}
		if (_or_2) {
			_or_1 = true;
		} else {
			boolean _isConstitution = this.isConstitution();
			_or_1 = _isConstitution;
		}
		if (_or_1) {
			_or = true;
		} else {
			boolean _isSubEventOf = this.isSubEventOf();
			_or = _isSubEventOf;
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
	public boolean isStarts() {
		boolean _and = false;
		boolean _isTemporal = this.isTemporal();
		if (!_isTemporal) {
			_and = false;
		} else {
			TemporalNature _temporalNature = this.getTemporalNature();
			boolean _equals = Objects.equal(_temporalNature, TemporalNature.STARTS);
			_and = _equals;
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
		boolean _isTemporal = this.isTemporal();
		if (!_isTemporal) {
			_and = false;
		} else {
			TemporalNature _temporalNature = this.getTemporalNature();
			boolean _equals = Objects.equal(_temporalNature, TemporalNature.PRECEDES);
			_and = _equals;
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
		boolean _isTemporal = this.isTemporal();
		if (!_isTemporal) {
			_and = false;
		} else {
			TemporalNature _temporalNature = this.getTemporalNature();
			boolean _equals = Objects.equal(_temporalNature, TemporalNature.EQUALS);
			_and = _equals;
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
		boolean _isTemporal = this.isTemporal();
		if (!_isTemporal) {
			_and = false;
		} else {
			TemporalNature _temporalNature = this.getTemporalNature();
			boolean _equals = Objects.equal(_temporalNature, TemporalNature.MEETS);
			_and = _equals;
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
		boolean _isTemporal = this.isTemporal();
		if (!_isTemporal) {
			_and = false;
		} else {
			TemporalNature _temporalNature = this.getTemporalNature();
			boolean _equals = Objects.equal(_temporalNature, TemporalNature.FINISHES);
			_and = _equals;
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
		boolean _isTemporal = this.isTemporal();
		if (!_isTemporal) {
			_and = false;
		} else {
			TemporalNature _temporalNature = this.getTemporalNature();
			boolean _equals = Objects.equal(_temporalNature, TemporalNature.OVERLAPS);
			_and = _equals;
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
		boolean _isTemporal = this.isTemporal();
		if (!_isTemporal) {
			_and = false;
		} else {
			TemporalNature _temporalNature = this.getTemporalNature();
			boolean _equals = Objects.equal(_temporalNature, TemporalNature.DURING);
			_and = _equals;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCreation() {
		boolean _and = false;
		boolean _isParticipation = this.isParticipation();
		if (!_isParticipation) {
			_and = false;
		} else {
			ParticipationNature _participationNature = this.getParticipationNature();
			boolean _equals = Objects.equal(_participationNature, ParticipationNature.CREATION);
			_and = _equals;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDestruction() {
		boolean _and = false;
		boolean _isParticipation = this.isParticipation();
		if (!_isParticipation) {
			_and = false;
		} else {
			ParticipationNature _participationNature = this.getParticipationNature();
			boolean _equals = Objects.equal(_participationNature, ParticipationNature.DESTRUCTION);
			_and = _equals;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isChange() {
		boolean _and = false;
		boolean _isParticipation = this.isParticipation();
		if (!_isParticipation) {
			_and = false;
		} else {
			ParticipationNature _participationNature = this.getParticipationNature();
			boolean _equals = Objects.equal(_participationNature, ParticipationNature.CHANGE);
			_and = _equals;
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
	public DataType sourceDataType() {
		Classifier _source = this.source();
		boolean _notEquals = (!Objects.equal(_source, null));
		if (_notEquals) {
			Classifier _source_1 = this.source();
			return ((DataType) _source_1);
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType targetDataType() {
		Classifier _target = this.target();
		boolean _notEquals = (!Objects.equal(_target, null));
		if (_notEquals) {
			Classifier _target_1 = this.target();
			return ((DataType) _target_1);
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
	public boolean isEnd(final Classifier c) {
		EList<EndPoint> _endPoints = this.getEndPoints();
		for (final EndPoint ep : _endPoints) {
			Classifier _endType = ep.getEndType();
			boolean _equals = _endType.equals(c);
			if (_equals) {
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
	public boolean isPartShareable() {
		boolean _and = false;
		EndPoint _sourceEnd = this.sourceEnd();
		int _upperBound = _sourceEnd.getUpperBound();
		boolean _greaterThan = (_upperBound > 1);
		if (!_greaterThan) {
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OntoumlPackage.RELATIONSHIP__END_POINTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEndPoints()).basicAdd(otherEnd, msgs);
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
			case OntoumlPackage.RELATIONSHIP__NAME:
				return getName();
			case OntoumlPackage.RELATIONSHIP__STEREOTYPE:
				return getStereotype();
			case OntoumlPackage.RELATIONSHIP__REFLEXIVITY:
				return getReflexivity();
			case OntoumlPackage.RELATIONSHIP__SYMMETRY:
				return getSymmetry();
			case OntoumlPackage.RELATIONSHIP__TRANSITIVITY:
				return getTransitivity();
			case OntoumlPackage.RELATIONSHIP__CICLICITY:
				return getCiclicity();
			case OntoumlPackage.RELATIONSHIP__END_POINTS:
				return getEndPoints();
			case OntoumlPackage.RELATIONSHIP__TEMPORAL_NATURE:
				return getTemporalNature();
			case OntoumlPackage.RELATIONSHIP__PARTICIPATION_NATURE:
				return getParticipationNature();
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
			case OntoumlPackage.RELATIONSHIP__NAME:
				setName((String)newValue);
				return;
			case OntoumlPackage.RELATIONSHIP__STEREOTYPE:
				setStereotype((RelationshipStereotype)newValue);
				return;
			case OntoumlPackage.RELATIONSHIP__REFLEXIVITY:
				setReflexivity((Reflexivity)newValue);
				return;
			case OntoumlPackage.RELATIONSHIP__SYMMETRY:
				setSymmetry((Symmetry)newValue);
				return;
			case OntoumlPackage.RELATIONSHIP__TRANSITIVITY:
				setTransitivity((Transitivity)newValue);
				return;
			case OntoumlPackage.RELATIONSHIP__CICLICITY:
				setCiclicity((Ciclicity)newValue);
				return;
			case OntoumlPackage.RELATIONSHIP__END_POINTS:
				getEndPoints().clear();
				getEndPoints().addAll((Collection<? extends EndPoint>)newValue);
				return;
			case OntoumlPackage.RELATIONSHIP__TEMPORAL_NATURE:
				setTemporalNature((TemporalNature)newValue);
				return;
			case OntoumlPackage.RELATIONSHIP__PARTICIPATION_NATURE:
				setParticipationNature((ParticipationNature)newValue);
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
			case OntoumlPackage.RELATIONSHIP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case OntoumlPackage.RELATIONSHIP__STEREOTYPE:
				setStereotype(STEREOTYPE_EDEFAULT);
				return;
			case OntoumlPackage.RELATIONSHIP__REFLEXIVITY:
				setReflexivity(REFLEXIVITY_EDEFAULT);
				return;
			case OntoumlPackage.RELATIONSHIP__SYMMETRY:
				setSymmetry(SYMMETRY_EDEFAULT);
				return;
			case OntoumlPackage.RELATIONSHIP__TRANSITIVITY:
				setTransitivity(TRANSITIVITY_EDEFAULT);
				return;
			case OntoumlPackage.RELATIONSHIP__CICLICITY:
				setCiclicity(CICLICITY_EDEFAULT);
				return;
			case OntoumlPackage.RELATIONSHIP__END_POINTS:
				getEndPoints().clear();
				return;
			case OntoumlPackage.RELATIONSHIP__TEMPORAL_NATURE:
				setTemporalNature(TEMPORAL_NATURE_EDEFAULT);
				return;
			case OntoumlPackage.RELATIONSHIP__PARTICIPATION_NATURE:
				setParticipationNature(PARTICIPATION_NATURE_EDEFAULT);
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
			case OntoumlPackage.RELATIONSHIP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case OntoumlPackage.RELATIONSHIP__STEREOTYPE:
				return stereotype != STEREOTYPE_EDEFAULT;
			case OntoumlPackage.RELATIONSHIP__REFLEXIVITY:
				return reflexivity != REFLEXIVITY_EDEFAULT;
			case OntoumlPackage.RELATIONSHIP__SYMMETRY:
				return symmetry != SYMMETRY_EDEFAULT;
			case OntoumlPackage.RELATIONSHIP__TRANSITIVITY:
				return transitivity != TRANSITIVITY_EDEFAULT;
			case OntoumlPackage.RELATIONSHIP__CICLICITY:
				return ciclicity != CICLICITY_EDEFAULT;
			case OntoumlPackage.RELATIONSHIP__END_POINTS:
				return endPoints != null && !endPoints.isEmpty();
			case OntoumlPackage.RELATIONSHIP__TEMPORAL_NATURE:
				return temporalNature != TEMPORAL_NATURE_EDEFAULT;
			case OntoumlPackage.RELATIONSHIP__PARTICIPATION_NATURE:
				return participationNature != PARTICIPATION_NATURE_EDEFAULT;
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
		if (baseClass == NamedElement.class) {
			switch (derivedFeatureID) {
				case OntoumlPackage.RELATIONSHIP__NAME: return OntoumlPackage.NAMED_ELEMENT__NAME;
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
		if (baseClass == NamedElement.class) {
			switch (baseFeatureID) {
				case OntoumlPackage.NAMED_ELEMENT__NAME: return OntoumlPackage.RELATIONSHIP__NAME;
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
			case OntoumlPackage.RELATIONSHIP___IS_INSTANCE_OF:
				return isInstanceOf();
			case OntoumlPackage.RELATIONSHIP___IS_MERONYMIC:
				return isMeronymic();
			case OntoumlPackage.RELATIONSHIP___IS_BINARY:
				return isBinary();
			case OntoumlPackage.RELATIONSHIP___IS_TERNARY:
				return isTernary();
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
			case OntoumlPackage.RELATIONSHIP___IS_CREATION:
				return isCreation();
			case OntoumlPackage.RELATIONSHIP___IS_DESTRUCTION:
				return isDestruction();
			case OntoumlPackage.RELATIONSHIP___IS_CHANGE:
				return isChange();
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
			case OntoumlPackage.RELATIONSHIP___SOURCE_DATA_TYPE:
				return sourceDataType();
			case OntoumlPackage.RELATIONSHIP___TARGET_DATA_TYPE:
				return targetDataType();
			case OntoumlPackage.RELATIONSHIP___SOURCE_RELATIONSHIP:
				return sourceRelationship();
			case OntoumlPackage.RELATIONSHIP___TARGET_RELATIONSHIP:
				return targetRelationship();
			case OntoumlPackage.RELATIONSHIP___IS_DERIVED:
				return isDerived();
			case OntoumlPackage.RELATIONSHIP___IS_END__CLASSIFIER:
				return isEnd((Classifier)arguments.get(0));
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
			case OntoumlPackage.RELATIONSHIP___IS_PART_SHAREABLE:
				return isPartShareable();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", stereotype: ");
		result.append(stereotype);
		result.append(", reflexivity: ");
		result.append(reflexivity);
		result.append(", symmetry: ");
		result.append(symmetry);
		result.append(", transitivity: ");
		result.append(transitivity);
		result.append(", ciclicity: ");
		result.append(ciclicity);
		result.append(", temporalNature: ");
		result.append(temporalNature);
		result.append(", participationNature: ");
		result.append(participationNature);
		result.append(')');
		return result.toString();
	}

} //RelationshipImpl
