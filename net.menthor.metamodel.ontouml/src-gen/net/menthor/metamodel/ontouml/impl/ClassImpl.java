/**
 */
package net.menthor.metamodel.ontouml.impl;

import com.google.common.base.Objects;

import java.lang.Iterable;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;
import java.util.List;

import net.menthor.metamodel.ontouml.Attribute;
import net.menthor.metamodel.ontouml.ClassifierElement;
import net.menthor.metamodel.ontouml.Comment;
import net.menthor.metamodel.ontouml.ContainedElement;
import net.menthor.metamodel.ontouml.GeneralizationSet;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.Quality;
import net.menthor.metamodel.ontouml.Relationship;
import net.menthor.metamodel.ontouml.Universal;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
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
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getComments <em>Comments</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getQualityType <em>Quality Type</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getEnumerationLiterals <em>Enumeration Literals</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#isIsDerived <em>Is Derived</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#isIsExtensional <em>Is Extensional</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getIstruthMakerOf <em>Istruth Maker Of</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getInstanceOf <em>Instance Of</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getIsSpecializedVia <em>Is Specialized Via</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassImpl#getSpecializesVia <em>Specializes Via</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassImpl extends NamedElementImpl implements net.menthor.metamodel.ontouml.Class {
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
	 * The cached value of the '{@link #getEnumerationLiterals() <em>Enumeration Literals</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumerationLiterals()
	 * @generated
	 * @ordered
	 */
	protected EList<String> enumerationLiterals;

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
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attributes;

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
	 * The cached value of the '{@link #getInstanceOf() <em>Instance Of</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceOf()
	 * @generated
	 * @ordered
	 */
	protected EList<net.menthor.metamodel.ontouml.Class> instanceOf;

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
	public EList<Comment> getComments() {
		if (comments == null) {
			comments = new EObjectContainmentWithInverseEList<Comment>(Comment.class, this, OntoumlPackage.CLASS__COMMENTS, OntoumlPackage.COMMENT__OWNER);
		}
		return comments;
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
	public EList<Relationship> getIstruthMakerOf() {
		if (istruthMakerOf == null) {
			istruthMakerOf = new EObjectWithInverseResolvingEList<Relationship>(Relationship.class, this, OntoumlPackage.CLASS__ISTRUTH_MAKER_OF, OntoumlPackage.RELATIONSHIP__TRUTH_MAKER);
		}
		return istruthMakerOf;
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
	public EList<net.menthor.metamodel.ontouml.Class> children() {
		net.menthor.metamodel.ontouml.Class[] list = null;
		EList<GeneralizationSet> _isSpecializedVia = this.getIsSpecializedVia();
		for (final GeneralizationSet gs : _isSpecializedVia) {
			final net.menthor.metamodel.ontouml.Class[] _converted_list = (net.menthor.metamodel.ontouml.Class[])list;
			EList<net.menthor.metamodel.ontouml.Class> _specializingClasses = gs.getSpecializingClasses();
			((List<net.menthor.metamodel.ontouml.Class>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list)).addAll(_specializingClasses);
		}
		final net.menthor.metamodel.ontouml.Class[] _converted_list_1 = (net.menthor.metamodel.ontouml.Class[])list;
		return ECollections.<net.menthor.metamodel.ontouml.Class>toEList(((Iterable<? extends net.menthor.metamodel.ontouml.Class>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list_1)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<net.menthor.metamodel.ontouml.Class> parents() {
		net.menthor.metamodel.ontouml.Class[] list = null;
		EList<GeneralizationSet> _specializesVia = this.getSpecializesVia();
		for (final GeneralizationSet gs : _specializesVia) {
			final net.menthor.metamodel.ontouml.Class[] _converted_list = (net.menthor.metamodel.ontouml.Class[])list;
			net.menthor.metamodel.ontouml.Class _specializedClass = gs.getSpecializedClass();
			((List<net.menthor.metamodel.ontouml.Class>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list)).add(_specializedClass);
		}
		final net.menthor.metamodel.ontouml.Class[] _converted_list_1 = (net.menthor.metamodel.ontouml.Class[])list;
		return ECollections.<net.menthor.metamodel.ontouml.Class>toEList(((Iterable<? extends net.menthor.metamodel.ontouml.Class>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(_converted_list_1)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void identidyProvider() {
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void isFunctionalComplex() {
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void isCollection() {
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void isAmountOfMatter() {
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void isIntrinsic() {
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTruthMaker() {
		boolean _and = false;
		boolean _isRelator = this.isRelator();
		if (!_isRelator) {
			_and = false;
		} else {
			EList<Relationship> _istruthMakerOf = this.getIstruthMakerOf();
			int _size = _istruthMakerOf.size();
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
	public void setIsExtensional() {
		
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
			case OntoumlPackage.CLASS__COMMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getComments()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.CLASS__ATTRIBUTES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAttributes()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.CLASS__ISTRUTH_MAKER_OF:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIstruthMakerOf()).basicAdd(otherEnd, msgs);
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
			case OntoumlPackage.CLASS__COMMENTS:
				return ((InternalEList<?>)getComments()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.CLASS__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.CLASS__ISTRUTH_MAKER_OF:
				return ((InternalEList<?>)getIstruthMakerOf()).basicRemove(otherEnd, msgs);
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
			case OntoumlPackage.CLASS__COMMENTS:
				return getComments();
			case OntoumlPackage.CLASS__STEREOTYPE:
				return getStereotype();
			case OntoumlPackage.CLASS__QUALITY_TYPE:
				return getQualityType();
			case OntoumlPackage.CLASS__ENUMERATION_LITERALS:
				return getEnumerationLiterals();
			case OntoumlPackage.CLASS__IS_ABSTRACT:
				return isIsAbstract();
			case OntoumlPackage.CLASS__IS_DERIVED:
				return isIsDerived();
			case OntoumlPackage.CLASS__IS_EXTENSIONAL:
				return isIsExtensional();
			case OntoumlPackage.CLASS__ATTRIBUTES:
				return getAttributes();
			case OntoumlPackage.CLASS__ISTRUTH_MAKER_OF:
				return getIstruthMakerOf();
			case OntoumlPackage.CLASS__INSTANCE_OF:
				return getInstanceOf();
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
			case OntoumlPackage.CLASS__COMMENTS:
				getComments().clear();
				getComments().addAll((Collection<? extends Comment>)newValue);
				return;
			case OntoumlPackage.CLASS__STEREOTYPE:
				setStereotype((Universal)newValue);
				return;
			case OntoumlPackage.CLASS__QUALITY_TYPE:
				setQualityType((Quality)newValue);
				return;
			case OntoumlPackage.CLASS__ENUMERATION_LITERALS:
				getEnumerationLiterals().clear();
				getEnumerationLiterals().addAll((Collection<? extends String>)newValue);
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
			case OntoumlPackage.CLASS__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case OntoumlPackage.CLASS__ISTRUTH_MAKER_OF:
				getIstruthMakerOf().clear();
				getIstruthMakerOf().addAll((Collection<? extends Relationship>)newValue);
				return;
			case OntoumlPackage.CLASS__INSTANCE_OF:
				getInstanceOf().clear();
				getInstanceOf().addAll((Collection<? extends net.menthor.metamodel.ontouml.Class>)newValue);
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
			case OntoumlPackage.CLASS__COMMENTS:
				getComments().clear();
				return;
			case OntoumlPackage.CLASS__STEREOTYPE:
				setStereotype(STEREOTYPE_EDEFAULT);
				return;
			case OntoumlPackage.CLASS__QUALITY_TYPE:
				setQualityType(QUALITY_TYPE_EDEFAULT);
				return;
			case OntoumlPackage.CLASS__ENUMERATION_LITERALS:
				getEnumerationLiterals().clear();
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
			case OntoumlPackage.CLASS__ATTRIBUTES:
				getAttributes().clear();
				return;
			case OntoumlPackage.CLASS__ISTRUTH_MAKER_OF:
				getIstruthMakerOf().clear();
				return;
			case OntoumlPackage.CLASS__INSTANCE_OF:
				getInstanceOf().clear();
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
			case OntoumlPackage.CLASS__COMMENTS:
				return comments != null && !comments.isEmpty();
			case OntoumlPackage.CLASS__STEREOTYPE:
				return stereotype != STEREOTYPE_EDEFAULT;
			case OntoumlPackage.CLASS__QUALITY_TYPE:
				return qualityType != QUALITY_TYPE_EDEFAULT;
			case OntoumlPackage.CLASS__ENUMERATION_LITERALS:
				return enumerationLiterals != null && !enumerationLiterals.isEmpty();
			case OntoumlPackage.CLASS__IS_ABSTRACT:
				return isAbstract != IS_ABSTRACT_EDEFAULT;
			case OntoumlPackage.CLASS__IS_DERIVED:
				return isDerived != IS_DERIVED_EDEFAULT;
			case OntoumlPackage.CLASS__IS_EXTENSIONAL:
				return isExtensional != IS_EXTENSIONAL_EDEFAULT;
			case OntoumlPackage.CLASS__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case OntoumlPackage.CLASS__ISTRUTH_MAKER_OF:
				return istruthMakerOf != null && !istruthMakerOf.isEmpty();
			case OntoumlPackage.CLASS__INSTANCE_OF:
				return instanceOf != null && !instanceOf.isEmpty();
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
		if (baseClass == ContainedElement.class) {
			switch (derivedFeatureID) {
				case OntoumlPackage.CLASS__HOLDER: return OntoumlPackage.CONTAINED_ELEMENT__HOLDER;
				case OntoumlPackage.CLASS__COMMENTS: return OntoumlPackage.CONTAINED_ELEMENT__COMMENTS;
				default: return -1;
			}
		}
		if (baseClass == ClassifierElement.class) {
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
				case OntoumlPackage.CONTAINED_ELEMENT__HOLDER: return OntoumlPackage.CLASS__HOLDER;
				case OntoumlPackage.CONTAINED_ELEMENT__COMMENTS: return OntoumlPackage.CLASS__COMMENTS;
				default: return -1;
			}
		}
		if (baseClass == ClassifierElement.class) {
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
			case OntoumlPackage.CLASS___CHILDREN:
				return children();
			case OntoumlPackage.CLASS___PARENTS:
				return parents();
			case OntoumlPackage.CLASS___IDENTIDY_PROVIDER:
				identidyProvider();
				return null;
			case OntoumlPackage.CLASS___IS_FUNCTIONAL_COMPLEX:
				isFunctionalComplex();
				return null;
			case OntoumlPackage.CLASS___IS_COLLECTION:
				isCollection();
				return null;
			case OntoumlPackage.CLASS___IS_AMOUNT_OF_MATTER:
				isAmountOfMatter();
				return null;
			case OntoumlPackage.CLASS___IS_INTRINSIC:
				isIntrinsic();
				return null;
			case OntoumlPackage.CLASS___IS_TRUTH_MAKER:
				return isTruthMaker();
			case OntoumlPackage.CLASS___SET_IS_EXTENSIONAL:
				setIsExtensional();
				return null;
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
		result.append(", qualityType: ");
		result.append(qualityType);
		result.append(", enumerationLiterals: ");
		result.append(enumerationLiterals);
		result.append(", isAbstract: ");
		result.append(isAbstract);
		result.append(", isDerived: ");
		result.append(isDerived);
		result.append(", isExtensional: ");
		result.append(isExtensional);
		result.append(')');
		return result.toString();
	}

} //ClassImpl
