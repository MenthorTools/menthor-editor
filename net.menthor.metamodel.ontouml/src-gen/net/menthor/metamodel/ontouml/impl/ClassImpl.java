/**
 */
package net.menthor.metamodel.ontouml.impl;

import com.google.common.base.Objects;

import java.lang.Iterable;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.List;

import net.menthor.metamodel.ontouml.Attribute;
import net.menthor.metamodel.ontouml.Classifier;
import net.menthor.metamodel.ontouml.Literal;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.Quality;
import net.menthor.metamodel.ontouml.Relationship;
import net.menthor.metamodel.ontouml.Structure;
import net.menthor.metamodel.ontouml.Universal;

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
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#isIsDerived <em>Is Derived</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getQualityType <em>Quality Type</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getLiterals <em>Literals</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getGroundingStructure <em>Grounding Structure</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getInstanceOf <em>Instance Of</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getIstruthMakerOf <em>Istruth Maker Of</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#isIsExtensional <em>Is Extensional</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassImpl extends TypeImpl implements net.menthor.metamodel.ontouml.Class {
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
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attributes;

	/**
	 * The default value of the '{@link #getQualityType() <em>Quality Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualityType()
	 * @generated
	 * @ordered
	 */
	protected static final Quality QUALITY_TYPE_EDEFAULT = Quality.NOMINAL;

	/**
	 * The cached value of the '{@link #getQualityType() <em>Quality Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualityType()
	 * @generated
	 * @ordered
	 */
	protected Quality qualityType = QUALITY_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLiterals() <em>Literals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiterals()
	 * @generated
	 * @ordered
	 */
	protected EList<Literal> literals;

	/**
	 * The cached value of the '{@link #getGroundingStructure() <em>Grounding Structure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroundingStructure()
	 * @generated
	 * @ordered
	 */
	protected Structure groundingStructure;

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
	protected EList<Relationship> istruthMakerOf;

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
	public EList<Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentWithInverseEList<Attribute>(Attribute.class, this, OntoumlPackage.CLASS__ATTRIBUTES, OntoumlPackage.ATTRIBUTE__OWNER);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Quality getQualityType() {
		return qualityType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualityType(Quality newQualityType) {
		Quality oldQualityType = qualityType;
		qualityType = newQualityType == null ? QUALITY_TYPE_EDEFAULT : newQualityType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS__QUALITY_TYPE, oldQualityType, qualityType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Literal> getLiterals() {
		if (literals == null) {
			literals = new EObjectContainmentWithInverseEList<Literal>(Literal.class, this, OntoumlPackage.CLASS__LITERALS, OntoumlPackage.LITERAL__OWNER);
		}
		return literals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Structure getGroundingStructure() {
		if (groundingStructure != null && groundingStructure.eIsProxy()) {
			InternalEObject oldGroundingStructure = (InternalEObject)groundingStructure;
			groundingStructure = (Structure)eResolveProxy(oldGroundingStructure);
			if (groundingStructure != oldGroundingStructure) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.CLASS__GROUNDING_STRUCTURE, oldGroundingStructure, groundingStructure));
			}
		}
		return groundingStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Structure basicGetGroundingStructure() {
		return groundingStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGroundingStructure(Structure newGroundingStructure, NotificationChain msgs) {
		Structure oldGroundingStructure = groundingStructure;
		groundingStructure = newGroundingStructure;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS__GROUNDING_STRUCTURE, oldGroundingStructure, newGroundingStructure);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroundingStructure(Structure newGroundingStructure) {
		if (newGroundingStructure != groundingStructure) {
			NotificationChain msgs = null;
			if (groundingStructure != null)
				msgs = ((InternalEObject)groundingStructure).eInverseRemove(this, OntoumlPackage.STRUCTURE__GROUNDED_ENUMERATION, Structure.class, msgs);
			if (newGroundingStructure != null)
				msgs = ((InternalEObject)newGroundingStructure).eInverseAdd(this, OntoumlPackage.STRUCTURE__GROUNDED_ENUMERATION, Structure.class, msgs);
			msgs = basicSetGroundingStructure(newGroundingStructure, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS__GROUNDING_STRUCTURE, newGroundingStructure, newGroundingStructure));
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
	public EList<Relationship> getIstruthMakerOf() {
		if (istruthMakerOf == null) {
			istruthMakerOf = new EObjectWithInverseResolvingEList<Relationship>(Relationship.class, this, OntoumlPackage.CLASS__ISTRUTH_MAKER_OF, OntoumlPackage.RELATIONSHIP__DERIVED_FROM_TRUTH_MAKER);
		}
		return istruthMakerOf;
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
	public boolean isKind() {
		Universal _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Universal.KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSubKind() {
		Universal _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Universal.SUB_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCollective() {
		Universal _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Universal.COLLECTIVE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isQuantity() {
		Universal _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Universal.QUANTITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRelator() {
		Universal _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Universal.RELATOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMode() {
		Universal _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Universal.MODE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isQuality() {
		Universal _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Universal.QUALITY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRole() {
		Universal _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Universal.ROLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRoleMixin() {
		Universal _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Universal.ROLE_MIXIN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPhaseMixin() {
		Universal _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Universal.PHASE_MIXIN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPhase() {
		Universal _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Universal.PHASE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCategory() {
		Universal _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Universal.CATEGORY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMixin() {
		Universal _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Universal.MIXIN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEvent() {
		Universal _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Universal.EVENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHighOrder() {
		Universal _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Universal.HOU);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDataType() {
		Universal _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Universal.DATA_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnumeration() {
		Universal _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, Universal.ENUMERATION);
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
		boolean _isKind = this.isKind();
		if (_isKind) {
			_or_6 = true;
		} else {
			boolean _isCollective = this.isCollective();
			_or_6 = _isCollective;
		}
		if (_or_6) {
			_or_5 = true;
		} else {
			boolean _isQuantity = this.isQuantity();
			_or_5 = _isQuantity;
		}
		if (_or_5) {
			_or_4 = true;
		} else {
			boolean _isRelator = this.isRelator();
			_or_4 = _isRelator;
		}
		if (_or_4) {
			_or_3 = true;
		} else {
			boolean _isMode = this.isMode();
			_or_3 = _isMode;
		}
		if (_or_3) {
			_or_2 = true;
		} else {
			boolean _isQuality = this.isQuality();
			_or_2 = _isQuality;
		}
		if (_or_2) {
			_or_1 = true;
		} else {
			boolean _isSubKind = this.isSubKind();
			_or_1 = _isSubKind;
		}
		if (_or_1) {
			_or = true;
		} else {
			boolean _isCategory = this.isCategory();
			_or = _isCategory;
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
		boolean _isRole = this.isRole();
		if (_isRole) {
			_or_2 = true;
		} else {
			boolean _isPhase = this.isPhase();
			_or_2 = _isPhase;
		}
		if (_or_2) {
			_or_1 = true;
		} else {
			boolean _isRoleMixin = this.isRoleMixin();
			_or_1 = _isRoleMixin;
		}
		if (_or_1) {
			_or = true;
		} else {
			boolean _isMixin = this.isMixin();
			_or = _isMixin;
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
		boolean _isRole = this.isRole();
		if (_isRole) {
			_or_1 = true;
		} else {
			boolean _isPhase = this.isPhase();
			_or_1 = _isPhase;
		}
		if (_or_1) {
			_or = true;
		} else {
			boolean _isRoleMixin = this.isRoleMixin();
			_or = _isRoleMixin;
		}
		return _or;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSemiRigid() {
		boolean _or = false;
		boolean _or_1 = false;
		boolean _isRoleMixin = this.isRoleMixin();
		if (_isRoleMixin) {
			_or_1 = true;
		} else {
			boolean _isPhaseMixin = this.isPhaseMixin();
			_or_1 = _isPhaseMixin;
		}
		if (_or_1) {
			_or = true;
		} else {
			boolean _isMixin = this.isMixin();
			_or = _isMixin;
		}
		return _or;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMoment() {
		boolean _or = false;
		boolean _or_1 = false;
		boolean _isTruthMaker = this.isTruthMaker();
		if (_isTruthMaker) {
			_or_1 = true;
		} else {
			boolean _isMode = this.isMode();
			_or_1 = _isMode;
		}
		if (_or_1) {
			_or = true;
		} else {
			boolean _isQuality = this.isQuality();
			_or = _isQuality;
		}
		return _or;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIdentityProvider() {
		boolean _or = false;
		boolean _or_1 = false;
		boolean _or_2 = false;
		boolean _or_3 = false;
		boolean _isKind = this.isKind();
		if (_isKind) {
			_or_3 = true;
		} else {
			boolean _isQuantity = this.isQuantity();
			_or_3 = _isQuantity;
		}
		if (_or_3) {
			_or_2 = true;
		} else {
			boolean _isCollective = this.isCollective();
			_or_2 = _isCollective;
		}
		if (_or_2) {
			_or_1 = true;
		} else {
			boolean _isRelator = this.isRelator();
			_or_1 = _isRelator;
		}
		if (_or_1) {
			_or = true;
		} else {
			boolean _isMode = this.isMode();
			_or = _isMode;
		}
		return _or;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTruthMaker() {
		boolean _isRelator = this.isRelator();
		if (_isRelator) {
			return true;
		}
		EList<Classifier> _allParents = this.allParents();
		for (final Classifier c : _allParents) {
			if ((c instanceof net.menthor.metamodel.ontouml.Class)) {
				boolean _isRelator_1 = ((net.menthor.metamodel.ontouml.Class)c).isRelator();
				if (_isRelator_1) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMixinClass() {
		boolean _or = false;
		boolean _or_1 = false;
		boolean _or_2 = false;
		boolean _isMixin = this.isMixin();
		if (_isMixin) {
			_or_2 = true;
		} else {
			boolean _isRoleMixin = this.isRoleMixin();
			_or_2 = _isRoleMixin;
		}
		if (_or_2) {
			_or_1 = true;
		} else {
			boolean _isPhaseMixin = this.isPhaseMixin();
			_or_1 = _isPhaseMixin;
		}
		if (_or_1) {
			_or = true;
		} else {
			boolean _isCategory = this.isCategory();
			_or = _isCategory;
		}
		if (_or) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<net.menthor.metamodel.ontouml.Class> identityProvidersAtAllParents() {
		net.menthor.metamodel.ontouml.Class[] result = null;
		EList<Classifier> _allParents = this.allParents();
		for (final Classifier p : _allParents) {
			if ((p instanceof net.menthor.metamodel.ontouml.Class)) {
				boolean _isIdentityProvider = ((net.menthor.metamodel.ontouml.Class)p).isIdentityProvider();
				if (_isIdentityProvider) {
					final net.menthor.metamodel.ontouml.Class[] _converted_result = (net.menthor.metamodel.ontouml.Class[])result;
					((List<net.menthor.metamodel.ontouml.Class>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)).add(((net.menthor.metamodel.ontouml.Class)p));
				}
			}
		}
		final net.menthor.metamodel.ontouml.Class[] _converted_result_1 = (net.menthor.metamodel.ontouml.Class[])result;
		return ECollections.<net.menthor.metamodel.ontouml.Class>toEList(((Iterable<? extends net.menthor.metamodel.ontouml.Class>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<net.menthor.metamodel.ontouml.Class> identityProvidersAtAllChildren() {
		net.menthor.metamodel.ontouml.Class[] result = null;
		EList<Classifier> _allChildren = this.allChildren();
		for (final Classifier p : _allChildren) {
			if ((p instanceof net.menthor.metamodel.ontouml.Class)) {
				boolean _isIdentityProvider = ((net.menthor.metamodel.ontouml.Class)p).isIdentityProvider();
				if (_isIdentityProvider) {
					final net.menthor.metamodel.ontouml.Class[] _converted_result = (net.menthor.metamodel.ontouml.Class[])result;
					((List<net.menthor.metamodel.ontouml.Class>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)).add(((net.menthor.metamodel.ontouml.Class)p));
				}
				boolean _or = false;
				boolean _isAntiRigid = ((net.menthor.metamodel.ontouml.Class)p).isAntiRigid();
				if (_isAntiRigid) {
					_or = true;
				} else {
					boolean _isSubKind = ((net.menthor.metamodel.ontouml.Class)p).isSubKind();
					_or = _isSubKind;
				}
				if (_or) {
					final net.menthor.metamodel.ontouml.Class[] _converted_result_1 = (net.menthor.metamodel.ontouml.Class[])result;
					EList<net.menthor.metamodel.ontouml.Class> _identityProvidersAtAllParents = ((net.menthor.metamodel.ontouml.Class)p).identityProvidersAtAllParents();
					((List<net.menthor.metamodel.ontouml.Class>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)).addAll(_identityProvidersAtAllParents);
				}
			}
		}
		final net.menthor.metamodel.ontouml.Class[] _converted_result_2 = (net.menthor.metamodel.ontouml.Class[])result;
		return ECollections.<net.menthor.metamodel.ontouml.Class>toEList(((Iterable<? extends net.menthor.metamodel.ontouml.Class>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_2)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<net.menthor.metamodel.ontouml.Class> identityProviders() {
		net.menthor.metamodel.ontouml.Class[] result = null;
		boolean _isIdentityProvider = this.isIdentityProvider();
		if (_isIdentityProvider) {
			final net.menthor.metamodel.ontouml.Class[] _converted_result = (net.menthor.metamodel.ontouml.Class[])result;
			((List<net.menthor.metamodel.ontouml.Class>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result)).add(this);
		}
		boolean _or = false;
		boolean _isAntiRigid = this.isAntiRigid();
		if (_isAntiRigid) {
			_or = true;
		} else {
			boolean _isSubKind = this.isSubKind();
			_or = _isSubKind;
		}
		if (_or) {
			final net.menthor.metamodel.ontouml.Class[] _converted_result_1 = (net.menthor.metamodel.ontouml.Class[])result;
			EList<net.menthor.metamodel.ontouml.Class> _identityProvidersAtAllParents = this.identityProvidersAtAllParents();
			((List<net.menthor.metamodel.ontouml.Class>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_1)).addAll(_identityProvidersAtAllParents);
		}
		boolean _isMixinClass = this.isMixinClass();
		if (_isMixinClass) {
			final net.menthor.metamodel.ontouml.Class[] _converted_result_2 = (net.menthor.metamodel.ontouml.Class[])result;
			EList<net.menthor.metamodel.ontouml.Class> _identityProvidersAtAllChildren = this.identityProvidersAtAllChildren();
			((List<net.menthor.metamodel.ontouml.Class>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_2)).addAll(_identityProvidersAtAllChildren);
			EList<Classifier> _allParents = this.allParents();
			for (final Classifier p : _allParents) {
				if ((p instanceof net.menthor.metamodel.ontouml.Class)) {
					final net.menthor.metamodel.ontouml.Class[] _converted_result_3 = (net.menthor.metamodel.ontouml.Class[])result;
					EList<net.menthor.metamodel.ontouml.Class> _identityProvidersAtAllChildren_1 = ((net.menthor.metamodel.ontouml.Class)p).identityProvidersAtAllChildren();
					((List<net.menthor.metamodel.ontouml.Class>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_3)).addAll(_identityProvidersAtAllChildren_1);
				}
			}
		}
		final net.menthor.metamodel.ontouml.Class[] _converted_result_4 = (net.menthor.metamodel.ontouml.Class[])result;
		return ECollections.<net.menthor.metamodel.ontouml.Class>toEList(((Iterable<? extends net.menthor.metamodel.ontouml.Class>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_result_4)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAmountOfMatter() {
		boolean _isQuantity = this.isQuantity();
		if (_isQuantity) {
			return true;
		}
		boolean _or = false;
		boolean _isAntiRigid = this.isAntiRigid();
		if (_isAntiRigid) {
			_or = true;
		} else {
			boolean _isSubKind = this.isSubKind();
			_or = _isSubKind;
		}
		if (_or) {
			net.menthor.metamodel.ontouml.Class[] providers = null;
			final net.menthor.metamodel.ontouml.Class[] _converted_providers = (net.menthor.metamodel.ontouml.Class[])providers;
			EList<net.menthor.metamodel.ontouml.Class> _identityProviders = this.identityProviders();
			((List<net.menthor.metamodel.ontouml.Class>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_providers)).addAll(_identityProviders);
			for (final net.menthor.metamodel.ontouml.Class c : providers) {
				boolean _isQuantity_1 = c.isQuantity();
				if (_isQuantity_1) {
					return true;
				}
			}
		}
		boolean _isMixinClass = this.isMixinClass();
		if (_isMixinClass) {
			EList<Classifier> _children = this.children();
			int _size = _children.size();
			boolean _equals = (_size == 0);
			if (_equals) {
				return false;
			}
			EList<Classifier> _children_1 = this.children();
			for (final Classifier child : _children_1) {
				if ((child instanceof net.menthor.metamodel.ontouml.Class)) {
					boolean _isQuantity_2 = ((net.menthor.metamodel.ontouml.Class)child).isQuantity();
					boolean _not = (!_isQuantity_2);
					if (_not) {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFunctionalComplex() {
		boolean _isKind = this.isKind();
		if (_isKind) {
			return true;
		}
		boolean _or = false;
		boolean _isAntiRigid = this.isAntiRigid();
		if (_isAntiRigid) {
			_or = true;
		} else {
			boolean _isSubKind = this.isSubKind();
			_or = _isSubKind;
		}
		if (_or) {
			net.menthor.metamodel.ontouml.Class[] providers = null;
			final net.menthor.metamodel.ontouml.Class[] _converted_providers = (net.menthor.metamodel.ontouml.Class[])providers;
			EList<net.menthor.metamodel.ontouml.Class> _identityProviders = this.identityProviders();
			((List<net.menthor.metamodel.ontouml.Class>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_providers)).addAll(_identityProviders);
			for (final net.menthor.metamodel.ontouml.Class c : providers) {
				boolean _isKind_1 = c.isKind();
				if (_isKind_1) {
					return true;
				}
			}
		}
		boolean _isMixinClass = this.isMixinClass();
		if (_isMixinClass) {
			EList<Classifier> _children = this.children();
			int _size = _children.size();
			boolean _equals = (_size == 0);
			if (_equals) {
				return false;
			}
			EList<Classifier> _children_1 = this.children();
			for (final Classifier child : _children_1) {
				if ((child instanceof net.menthor.metamodel.ontouml.Class)) {
					boolean _isKind_2 = ((net.menthor.metamodel.ontouml.Class)child).isKind();
					boolean _not = (!_isKind_2);
					if (_not) {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCollection() {
		boolean _isCollective = this.isCollective();
		if (_isCollective) {
			return true;
		}
		boolean _or = false;
		boolean _isAntiRigid = this.isAntiRigid();
		if (_isAntiRigid) {
			_or = true;
		} else {
			boolean _isSubKind = this.isSubKind();
			_or = _isSubKind;
		}
		if (_or) {
			net.menthor.metamodel.ontouml.Class[] providers = null;
			final net.menthor.metamodel.ontouml.Class[] _converted_providers = (net.menthor.metamodel.ontouml.Class[])providers;
			EList<net.menthor.metamodel.ontouml.Class> _identityProviders = this.identityProviders();
			((List<net.menthor.metamodel.ontouml.Class>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_providers)).addAll(_identityProviders);
			for (final net.menthor.metamodel.ontouml.Class c : providers) {
				boolean _isCollective_1 = c.isCollective();
				if (_isCollective_1) {
					return true;
				}
			}
		}
		boolean _isMixinClass = this.isMixinClass();
		if (_isMixinClass) {
			EList<Classifier> _children = this.children();
			int _size = _children.size();
			boolean _equals = (_size == 0);
			if (_equals) {
				return false;
			}
			EList<Classifier> _children_1 = this.children();
			for (final Classifier child : _children_1) {
				if ((child instanceof net.menthor.metamodel.ontouml.Class)) {
					boolean _isCollective_2 = ((net.menthor.metamodel.ontouml.Class)child).isCollective();
					boolean _not = (!_isCollective_2);
					if (_not) {
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIntrinsic() {
		boolean _isMoment = this.isMoment();
		if (_isMoment) {
			return true;
		}
		boolean _or = false;
		boolean _isAntiRigid = this.isAntiRigid();
		if (_isAntiRigid) {
			_or = true;
		} else {
			boolean _isSubKind = this.isSubKind();
			_or = _isSubKind;
		}
		if (_or) {
			net.menthor.metamodel.ontouml.Class[] providers = null;
			final net.menthor.metamodel.ontouml.Class[] _converted_providers = (net.menthor.metamodel.ontouml.Class[])providers;
			EList<net.menthor.metamodel.ontouml.Class> _identityProviders = this.identityProviders();
			((List<net.menthor.metamodel.ontouml.Class>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_providers)).addAll(_identityProviders);
			for (final net.menthor.metamodel.ontouml.Class c : providers) {
				boolean _isMoment_1 = c.isMoment();
				if (_isMoment_1) {
					return true;
				}
			}
		}
		boolean _isMixinClass = this.isMixinClass();
		if (_isMixinClass) {
			EList<Classifier> _children = this.children();
			int _size = _children.size();
			boolean _equals = (_size == 0);
			if (_equals) {
				return false;
			}
			EList<Classifier> _children_1 = this.children();
			for (final Classifier child : _children_1) {
				if ((child instanceof net.menthor.metamodel.ontouml.Class)) {
					boolean _isMoment_2 = ((net.menthor.metamodel.ontouml.Class)child).isMoment();
					boolean _not = (!_isMoment_2);
					if (_not) {
						return false;
					}
				}
			}
			return true;
		}
		return false;
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
			case OntoumlPackage.CLASS__ATTRIBUTES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAttributes()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.CLASS__LITERALS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLiterals()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.CLASS__GROUNDING_STRUCTURE:
				if (groundingStructure != null)
					msgs = ((InternalEObject)groundingStructure).eInverseRemove(this, OntoumlPackage.STRUCTURE__GROUNDED_ENUMERATION, Structure.class, msgs);
				return basicSetGroundingStructure((Structure)otherEnd, msgs);
			case OntoumlPackage.CLASS__ISTRUTH_MAKER_OF:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIstruthMakerOf()).basicAdd(otherEnd, msgs);
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
			case OntoumlPackage.CLASS__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.CLASS__LITERALS:
				return ((InternalEList<?>)getLiterals()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.CLASS__GROUNDING_STRUCTURE:
				return basicSetGroundingStructure(null, msgs);
			case OntoumlPackage.CLASS__ISTRUTH_MAKER_OF:
				return ((InternalEList<?>)getIstruthMakerOf()).basicRemove(otherEnd, msgs);
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
			case OntoumlPackage.CLASS__STEREOTYPE:
				return getStereotype();
			case OntoumlPackage.CLASS__IS_ABSTRACT:
				return isIsAbstract();
			case OntoumlPackage.CLASS__IS_DERIVED:
				return isIsDerived();
			case OntoumlPackage.CLASS__ATTRIBUTES:
				return getAttributes();
			case OntoumlPackage.CLASS__QUALITY_TYPE:
				return getQualityType();
			case OntoumlPackage.CLASS__LITERALS:
				return getLiterals();
			case OntoumlPackage.CLASS__GROUNDING_STRUCTURE:
				if (resolve) return getGroundingStructure();
				return basicGetGroundingStructure();
			case OntoumlPackage.CLASS__INSTANCE_OF:
				return getInstanceOf();
			case OntoumlPackage.CLASS__ISTRUTH_MAKER_OF:
				return getIstruthMakerOf();
			case OntoumlPackage.CLASS__IS_EXTENSIONAL:
				return isIsExtensional();
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
			case OntoumlPackage.CLASS__STEREOTYPE:
				setStereotype((Universal)newValue);
				return;
			case OntoumlPackage.CLASS__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case OntoumlPackage.CLASS__IS_DERIVED:
				setIsDerived((Boolean)newValue);
				return;
			case OntoumlPackage.CLASS__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case OntoumlPackage.CLASS__QUALITY_TYPE:
				setQualityType((Quality)newValue);
				return;
			case OntoumlPackage.CLASS__LITERALS:
				getLiterals().clear();
				getLiterals().addAll((Collection<? extends Literal>)newValue);
				return;
			case OntoumlPackage.CLASS__GROUNDING_STRUCTURE:
				setGroundingStructure((Structure)newValue);
				return;
			case OntoumlPackage.CLASS__INSTANCE_OF:
				getInstanceOf().clear();
				getInstanceOf().addAll((Collection<? extends net.menthor.metamodel.ontouml.Class>)newValue);
				return;
			case OntoumlPackage.CLASS__ISTRUTH_MAKER_OF:
				getIstruthMakerOf().clear();
				getIstruthMakerOf().addAll((Collection<? extends Relationship>)newValue);
				return;
			case OntoumlPackage.CLASS__IS_EXTENSIONAL:
				setIsExtensional((Boolean)newValue);
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
			case OntoumlPackage.CLASS__STEREOTYPE:
				setStereotype(STEREOTYPE_EDEFAULT);
				return;
			case OntoumlPackage.CLASS__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case OntoumlPackage.CLASS__IS_DERIVED:
				setIsDerived(IS_DERIVED_EDEFAULT);
				return;
			case OntoumlPackage.CLASS__ATTRIBUTES:
				getAttributes().clear();
				return;
			case OntoumlPackage.CLASS__QUALITY_TYPE:
				setQualityType(QUALITY_TYPE_EDEFAULT);
				return;
			case OntoumlPackage.CLASS__LITERALS:
				getLiterals().clear();
				return;
			case OntoumlPackage.CLASS__GROUNDING_STRUCTURE:
				setGroundingStructure((Structure)null);
				return;
			case OntoumlPackage.CLASS__INSTANCE_OF:
				getInstanceOf().clear();
				return;
			case OntoumlPackage.CLASS__ISTRUTH_MAKER_OF:
				getIstruthMakerOf().clear();
				return;
			case OntoumlPackage.CLASS__IS_EXTENSIONAL:
				setIsExtensional(IS_EXTENSIONAL_EDEFAULT);
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
			case OntoumlPackage.CLASS__STEREOTYPE:
				return stereotype != STEREOTYPE_EDEFAULT;
			case OntoumlPackage.CLASS__IS_ABSTRACT:
				return isAbstract != IS_ABSTRACT_EDEFAULT;
			case OntoumlPackage.CLASS__IS_DERIVED:
				return isDerived != IS_DERIVED_EDEFAULT;
			case OntoumlPackage.CLASS__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case OntoumlPackage.CLASS__QUALITY_TYPE:
				return qualityType != QUALITY_TYPE_EDEFAULT;
			case OntoumlPackage.CLASS__LITERALS:
				return literals != null && !literals.isEmpty();
			case OntoumlPackage.CLASS__GROUNDING_STRUCTURE:
				return groundingStructure != null;
			case OntoumlPackage.CLASS__INSTANCE_OF:
				return instanceOf != null && !instanceOf.isEmpty();
			case OntoumlPackage.CLASS__ISTRUTH_MAKER_OF:
				return istruthMakerOf != null && !istruthMakerOf.isEmpty();
			case OntoumlPackage.CLASS__IS_EXTENSIONAL:
				return isExtensional != IS_EXTENSIONAL_EDEFAULT;
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
			case OntoumlPackage.CLASS___IS_KIND:
				return isKind();
			case OntoumlPackage.CLASS___IS_SUB_KIND:
				return isSubKind();
			case OntoumlPackage.CLASS___IS_COLLECTIVE:
				return isCollective();
			case OntoumlPackage.CLASS___IS_QUANTITY:
				return isQuantity();
			case OntoumlPackage.CLASS___IS_RELATOR:
				return isRelator();
			case OntoumlPackage.CLASS___IS_MODE:
				return isMode();
			case OntoumlPackage.CLASS___IS_QUALITY:
				return isQuality();
			case OntoumlPackage.CLASS___IS_ROLE:
				return isRole();
			case OntoumlPackage.CLASS___IS_ROLE_MIXIN:
				return isRoleMixin();
			case OntoumlPackage.CLASS___IS_PHASE_MIXIN:
				return isPhaseMixin();
			case OntoumlPackage.CLASS___IS_PHASE:
				return isPhase();
			case OntoumlPackage.CLASS___IS_CATEGORY:
				return isCategory();
			case OntoumlPackage.CLASS___IS_MIXIN:
				return isMixin();
			case OntoumlPackage.CLASS___IS_EVENT:
				return isEvent();
			case OntoumlPackage.CLASS___IS_HIGH_ORDER:
				return isHighOrder();
			case OntoumlPackage.CLASS___IS_DATA_TYPE:
				return isDataType();
			case OntoumlPackage.CLASS___IS_ENUMERATION:
				return isEnumeration();
			case OntoumlPackage.CLASS___IS_RIGID:
				return isRigid();
			case OntoumlPackage.CLASS___IS_NON_RIGID:
				return isNonRigid();
			case OntoumlPackage.CLASS___IS_ANTI_RIGID:
				return isAntiRigid();
			case OntoumlPackage.CLASS___IS_SEMI_RIGID:
				return isSemiRigid();
			case OntoumlPackage.CLASS___IS_MOMENT:
				return isMoment();
			case OntoumlPackage.CLASS___IS_IDENTITY_PROVIDER:
				return isIdentityProvider();
			case OntoumlPackage.CLASS___IS_TRUTH_MAKER:
				return isTruthMaker();
			case OntoumlPackage.CLASS___IS_MIXIN_CLASS:
				return isMixinClass();
			case OntoumlPackage.CLASS___IDENTITY_PROVIDERS_AT_ALL_PARENTS:
				return identityProvidersAtAllParents();
			case OntoumlPackage.CLASS___IDENTITY_PROVIDERS_AT_ALL_CHILDREN:
				return identityProvidersAtAllChildren();
			case OntoumlPackage.CLASS___IDENTITY_PROVIDERS:
				return identityProviders();
			case OntoumlPackage.CLASS___IS_AMOUNT_OF_MATTER:
				return isAmountOfMatter();
			case OntoumlPackage.CLASS___IS_FUNCTIONAL_COMPLEX:
				return isFunctionalComplex();
			case OntoumlPackage.CLASS___IS_COLLECTION:
				return isCollection();
			case OntoumlPackage.CLASS___IS_INTRINSIC:
				return isIntrinsic();
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
		result.append(", qualityType: ");
		result.append(qualityType);
		result.append(", isExtensional: ");
		result.append(isExtensional);
		result.append(')');
		return result.toString();
	}

} //ClassImpl
