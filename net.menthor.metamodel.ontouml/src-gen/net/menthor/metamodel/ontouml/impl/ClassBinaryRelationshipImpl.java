/**
 */
package net.menthor.metamodel.ontouml.impl;

import net.menthor.metamodel.ontouml.ClassBinaryRelationship;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.PackageableElement;
import net.menthor.metamodel.ontouml.Relation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Binary Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#getContainer_ <em>Container </em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#getSourceEndName <em>Source End Name</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#getSourceLowerBound <em>Source Lower Bound</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#getSourceUpperBound <em>Source Upper Bound</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#getTargetEndName <em>Target End Name</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#getTargetLowerBound <em>Target Lower Bound</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#getTargetUpperBound <em>Target Upper Bound</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#isPartIsEssential <em>Part Is Essential</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#isPartIsInseparable <em>Part Is Inseparable</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#isPartIsShareable <em>Part Is Shareable</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#isPartIsImmutable <em>Part Is Immutable</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#isPartIsMandatory <em>Part Is Mandatory</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#getSource <em>Source</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.ClassBinaryRelationshipImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassBinaryRelationshipImpl extends NamedElementImpl implements ClassBinaryRelationship {
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
	 * The default value of the '{@link #getSourceEndName() <em>Source End Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceEndName()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_END_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceEndName() <em>Source End Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceEndName()
	 * @generated
	 * @ordered
	 */
	protected String sourceEndName = SOURCE_END_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceLowerBound() <em>Source Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceLowerBound()
	 * @generated
	 * @ordered
	 */
	protected static final int SOURCE_LOWER_BOUND_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSourceLowerBound() <em>Source Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceLowerBound()
	 * @generated
	 * @ordered
	 */
	protected int sourceLowerBound = SOURCE_LOWER_BOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getSourceUpperBound() <em>Source Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceUpperBound()
	 * @generated
	 * @ordered
	 */
	protected static final int SOURCE_UPPER_BOUND_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSourceUpperBound() <em>Source Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceUpperBound()
	 * @generated
	 * @ordered
	 */
	protected int sourceUpperBound = SOURCE_UPPER_BOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetEndName() <em>Target End Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetEndName()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_END_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetEndName() <em>Target End Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetEndName()
	 * @generated
	 * @ordered
	 */
	protected String targetEndName = TARGET_END_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetLowerBound() <em>Target Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetLowerBound()
	 * @generated
	 * @ordered
	 */
	protected static final int TARGET_LOWER_BOUND_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTargetLowerBound() <em>Target Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetLowerBound()
	 * @generated
	 * @ordered
	 */
	protected int targetLowerBound = TARGET_LOWER_BOUND_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetUpperBound() <em>Target Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetUpperBound()
	 * @generated
	 * @ordered
	 */
	protected static final int TARGET_UPPER_BOUND_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTargetUpperBound() <em>Target Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetUpperBound()
	 * @generated
	 * @ordered
	 */
	protected int targetUpperBound = TARGET_UPPER_BOUND_EDEFAULT;

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
	 * The cached value of the '{@link #isPartIsEssential() <em>Part Is Essential</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPartIsEssential()
	 * @generated
	 * @ordered
	 */
	protected boolean partIsEssential = PART_IS_ESSENTIAL_EDEFAULT;

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
	 * The cached value of the '{@link #isPartIsInseparable() <em>Part Is Inseparable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPartIsInseparable()
	 * @generated
	 * @ordered
	 */
	protected boolean partIsInseparable = PART_IS_INSEPARABLE_EDEFAULT;

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
	 * The default value of the '{@link #isPartIsImmutable() <em>Part Is Immutable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPartIsImmutable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PART_IS_IMMUTABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPartIsImmutable() <em>Part Is Immutable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPartIsImmutable()
	 * @generated
	 * @ordered
	 */
	protected boolean partIsImmutable = PART_IS_IMMUTABLE_EDEFAULT;

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
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected net.menthor.metamodel.ontouml.Class source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected net.menthor.metamodel.ontouml.Class target;

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
	public net.menthor.metamodel.ontouml.Container getContainer_() {
		if (eContainerFeatureID() != OntoumlPackage.CLASS_BINARY_RELATIONSHIP__CONTAINER_) return null;
		return (net.menthor.metamodel.ontouml.Container)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Container basicGetContainer_() {
		if (eContainerFeatureID() != OntoumlPackage.CLASS_BINARY_RELATIONSHIP__CONTAINER_) return null;
		return (net.menthor.metamodel.ontouml.Container)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContainer_(net.menthor.metamodel.ontouml.Container newContainer_, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newContainer_, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__CONTAINER_, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainer_(net.menthor.metamodel.ontouml.Container newContainer_) {
		if (newContainer_ != eInternalContainer() || (eContainerFeatureID() != OntoumlPackage.CLASS_BINARY_RELATIONSHIP__CONTAINER_ && newContainer_ != null)) {
			if (EcoreUtil.isAncestor(this, newContainer_))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContainer_ != null)
				msgs = ((InternalEObject)newContainer_).eInverseAdd(this, OntoumlPackage.CONTAINER__ELEMENTS, net.menthor.metamodel.ontouml.Container.class, msgs);
			msgs = basicSetContainer_(newContainer_, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__CONTAINER_, newContainer_, newContainer_));
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
	public String getSourceEndName() {
		return sourceEndName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceEndName(String newSourceEndName) {
		String oldSourceEndName = sourceEndName;
		sourceEndName = newSourceEndName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__SOURCE_END_NAME, oldSourceEndName, sourceEndName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSourceLowerBound() {
		return sourceLowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceLowerBound(int newSourceLowerBound) {
		int oldSourceLowerBound = sourceLowerBound;
		sourceLowerBound = newSourceLowerBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__SOURCE_LOWER_BOUND, oldSourceLowerBound, sourceLowerBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSourceUpperBound() {
		return sourceUpperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceUpperBound(int newSourceUpperBound) {
		int oldSourceUpperBound = sourceUpperBound;
		sourceUpperBound = newSourceUpperBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__SOURCE_UPPER_BOUND, oldSourceUpperBound, sourceUpperBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetEndName() {
		return targetEndName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetEndName(String newTargetEndName) {
		String oldTargetEndName = targetEndName;
		targetEndName = newTargetEndName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TARGET_END_NAME, oldTargetEndName, targetEndName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTargetLowerBound() {
		return targetLowerBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetLowerBound(int newTargetLowerBound) {
		int oldTargetLowerBound = targetLowerBound;
		targetLowerBound = newTargetLowerBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TARGET_LOWER_BOUND, oldTargetLowerBound, targetLowerBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTargetUpperBound() {
		return targetUpperBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetUpperBound(int newTargetUpperBound) {
		int oldTargetUpperBound = targetUpperBound;
		targetUpperBound = newTargetUpperBound;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TARGET_UPPER_BOUND, oldTargetUpperBound, targetUpperBound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPartIsEssential() {
		return partIsEssential;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartIsEssential(boolean newPartIsEssential) {
		boolean oldPartIsEssential = partIsEssential;
		partIsEssential = newPartIsEssential;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_ESSENTIAL, oldPartIsEssential, partIsEssential));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPartIsInseparable() {
		return partIsInseparable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartIsInseparable(boolean newPartIsInseparable) {
		boolean oldPartIsInseparable = partIsInseparable;
		partIsInseparable = newPartIsInseparable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_INSEPARABLE, oldPartIsInseparable, partIsInseparable));
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
	public boolean isPartIsImmutable() {
		return partIsImmutable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartIsImmutable(boolean newPartIsImmutable) {
		boolean oldPartIsImmutable = partIsImmutable;
		partIsImmutable = newPartIsImmutable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_IMMUTABLE, oldPartIsImmutable, partIsImmutable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPartIsMandatory() {
		int _targetLowerBound = this.getTargetLowerBound();
		return (_targetLowerBound >= 1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(net.menthor.metamodel.ontouml.Class newSource, NotificationChain msgs) {
		net.menthor.metamodel.ontouml.Class oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(net.menthor.metamodel.ontouml.Class newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, OntoumlPackage.CLASS__IS_SOURCE_OF, net.menthor.metamodel.ontouml.Class.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, OntoumlPackage.CLASS__IS_SOURCE_OF, net.menthor.metamodel.ontouml.Class.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(net.menthor.metamodel.ontouml.Class newTarget, NotificationChain msgs) {
		net.menthor.metamodel.ontouml.Class oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(net.menthor.metamodel.ontouml.Class newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, OntoumlPackage.CLASS__IS_TARGET_OF, net.menthor.metamodel.ontouml.Class.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, OntoumlPackage.CLASS__IS_TARGET_OF, net.menthor.metamodel.ontouml.Class.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__CONTAINER_:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContainer_((net.menthor.metamodel.ontouml.Container)otherEnd, msgs);
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, OntoumlPackage.CLASS__IS_SOURCE_OF, net.menthor.metamodel.ontouml.Class.class, msgs);
				return basicSetSource((net.menthor.metamodel.ontouml.Class)otherEnd, msgs);
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, OntoumlPackage.CLASS__IS_TARGET_OF, net.menthor.metamodel.ontouml.Class.class, msgs);
				return basicSetTarget((net.menthor.metamodel.ontouml.Class)otherEnd, msgs);
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
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__CONTAINER_:
				return basicSetContainer_(null, msgs);
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__SOURCE:
				return basicSetSource(null, msgs);
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TARGET:
				return basicSetTarget(null, msgs);
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
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__CONTAINER_:
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
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__CONTAINER_:
				if (resolve) return getContainer_();
				return basicGetContainer_();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__STEREOTYPE:
				return getStereotype();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__SOURCE_END_NAME:
				return getSourceEndName();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__SOURCE_LOWER_BOUND:
				return getSourceLowerBound();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__SOURCE_UPPER_BOUND:
				return getSourceUpperBound();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TARGET_END_NAME:
				return getTargetEndName();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TARGET_LOWER_BOUND:
				return getTargetLowerBound();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TARGET_UPPER_BOUND:
				return getTargetUpperBound();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_ESSENTIAL:
				return isPartIsEssential();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_INSEPARABLE:
				return isPartIsInseparable();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_SHAREABLE:
				return isPartIsShareable();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_IMMUTABLE:
				return isPartIsImmutable();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_MANDATORY:
				return isPartIsMandatory();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__SOURCE:
				return getSource();
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TARGET:
				return getTarget();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__CONTAINER_:
				setContainer_((net.menthor.metamodel.ontouml.Container)newValue);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__STEREOTYPE:
				setStereotype((Relation)newValue);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__SOURCE_END_NAME:
				setSourceEndName((String)newValue);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__SOURCE_LOWER_BOUND:
				setSourceLowerBound((Integer)newValue);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__SOURCE_UPPER_BOUND:
				setSourceUpperBound((Integer)newValue);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TARGET_END_NAME:
				setTargetEndName((String)newValue);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TARGET_LOWER_BOUND:
				setTargetLowerBound((Integer)newValue);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TARGET_UPPER_BOUND:
				setTargetUpperBound((Integer)newValue);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_ESSENTIAL:
				setPartIsEssential((Boolean)newValue);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_INSEPARABLE:
				setPartIsInseparable((Boolean)newValue);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_SHAREABLE:
				setPartIsShareable((Boolean)newValue);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_IMMUTABLE:
				setPartIsImmutable((Boolean)newValue);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__SOURCE:
				setSource((net.menthor.metamodel.ontouml.Class)newValue);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TARGET:
				setTarget((net.menthor.metamodel.ontouml.Class)newValue);
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
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__CONTAINER_:
				setContainer_((net.menthor.metamodel.ontouml.Container)null);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__STEREOTYPE:
				setStereotype(STEREOTYPE_EDEFAULT);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__SOURCE_END_NAME:
				setSourceEndName(SOURCE_END_NAME_EDEFAULT);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__SOURCE_LOWER_BOUND:
				setSourceLowerBound(SOURCE_LOWER_BOUND_EDEFAULT);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__SOURCE_UPPER_BOUND:
				setSourceUpperBound(SOURCE_UPPER_BOUND_EDEFAULT);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TARGET_END_NAME:
				setTargetEndName(TARGET_END_NAME_EDEFAULT);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TARGET_LOWER_BOUND:
				setTargetLowerBound(TARGET_LOWER_BOUND_EDEFAULT);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TARGET_UPPER_BOUND:
				setTargetUpperBound(TARGET_UPPER_BOUND_EDEFAULT);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_ESSENTIAL:
				setPartIsEssential(PART_IS_ESSENTIAL_EDEFAULT);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_INSEPARABLE:
				setPartIsInseparable(PART_IS_INSEPARABLE_EDEFAULT);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_SHAREABLE:
				setPartIsShareable(PART_IS_SHAREABLE_EDEFAULT);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_IMMUTABLE:
				setPartIsImmutable(PART_IS_IMMUTABLE_EDEFAULT);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__SOURCE:
				setSource((net.menthor.metamodel.ontouml.Class)null);
				return;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TARGET:
				setTarget((net.menthor.metamodel.ontouml.Class)null);
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
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__CONTAINER_:
				return basicGetContainer_() != null;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__STEREOTYPE:
				return stereotype != STEREOTYPE_EDEFAULT;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__SOURCE_END_NAME:
				return SOURCE_END_NAME_EDEFAULT == null ? sourceEndName != null : !SOURCE_END_NAME_EDEFAULT.equals(sourceEndName);
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__SOURCE_LOWER_BOUND:
				return sourceLowerBound != SOURCE_LOWER_BOUND_EDEFAULT;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__SOURCE_UPPER_BOUND:
				return sourceUpperBound != SOURCE_UPPER_BOUND_EDEFAULT;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TARGET_END_NAME:
				return TARGET_END_NAME_EDEFAULT == null ? targetEndName != null : !TARGET_END_NAME_EDEFAULT.equals(targetEndName);
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TARGET_LOWER_BOUND:
				return targetLowerBound != TARGET_LOWER_BOUND_EDEFAULT;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TARGET_UPPER_BOUND:
				return targetUpperBound != TARGET_UPPER_BOUND_EDEFAULT;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_ESSENTIAL:
				return partIsEssential != PART_IS_ESSENTIAL_EDEFAULT;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_INSEPARABLE:
				return partIsInseparable != PART_IS_INSEPARABLE_EDEFAULT;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_SHAREABLE:
				return partIsShareable != PART_IS_SHAREABLE_EDEFAULT;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_IMMUTABLE:
				return partIsImmutable != PART_IS_IMMUTABLE_EDEFAULT;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__PART_IS_MANDATORY:
				return isPartIsMandatory() != PART_IS_MANDATORY_EDEFAULT;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__SOURCE:
				return source != null;
			case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__TARGET:
				return target != null;
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
		if (baseClass == PackageableElement.class) {
			switch (derivedFeatureID) {
				case OntoumlPackage.CLASS_BINARY_RELATIONSHIP__CONTAINER_: return OntoumlPackage.PACKAGEABLE_ELEMENT__CONTAINER_;
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
		if (baseClass == PackageableElement.class) {
			switch (baseFeatureID) {
				case OntoumlPackage.PACKAGEABLE_ELEMENT__CONTAINER_: return OntoumlPackage.CLASS_BINARY_RELATIONSHIP__CONTAINER_;
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
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (stereotype: ");
		result.append(stereotype);
		result.append(", sourceEndName: ");
		result.append(sourceEndName);
		result.append(", sourceLowerBound: ");
		result.append(sourceLowerBound);
		result.append(", sourceUpperBound: ");
		result.append(sourceUpperBound);
		result.append(", targetEndName: ");
		result.append(targetEndName);
		result.append(", targetLowerBound: ");
		result.append(targetLowerBound);
		result.append(", targetUpperBound: ");
		result.append(targetUpperBound);
		result.append(", partIsEssential: ");
		result.append(partIsEssential);
		result.append(", partIsInseparable: ");
		result.append(partIsInseparable);
		result.append(", partIsShareable: ");
		result.append(partIsShareable);
		result.append(", partIsImmutable: ");
		result.append(partIsImmutable);
		result.append(')');
		return result.toString();
	}

} //ClassBinaryRelationshipImpl
