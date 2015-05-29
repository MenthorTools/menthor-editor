/**
 */
package net.menthor.metamodel.ontouml.impl;

import com.google.common.base.Objects;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import net.menthor.metamodel.ontouml.DataType;
import net.menthor.metamodel.ontouml.DataTypeStereotype;
import net.menthor.metamodel.ontouml.Literal;
import net.menthor.metamodel.ontouml.Measurement;
import net.menthor.metamodel.ontouml.NamedElement;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.Scale;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.DataTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.DataTypeImpl#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.DataTypeImpl#getDimensions <em>Dimensions</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.DataTypeImpl#getScale <em>Scale</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.DataTypeImpl#getMeasurement <em>Measurement</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.DataTypeImpl#getUnitOfMeasure <em>Unit Of Measure</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.DataTypeImpl#getLowerBoundRegion <em>Lower Bound Region</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.DataTypeImpl#getUpperBoundRegion <em>Upper Bound Region</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.DataTypeImpl#getOwnerDomain <em>Owner Domain</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.DataTypeImpl#getLiterals <em>Literals</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.impl.DataTypeImpl#getStructure <em>Structure</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataTypeImpl extends TypeImpl implements DataType {
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
	protected static final DataTypeStereotype STEREOTYPE_EDEFAULT = DataTypeStereotype.DOMAIN;

	/**
	 * The cached value of the '{@link #getStereotype() <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotype()
	 * @generated
	 * @ordered
	 */
	protected DataTypeStereotype stereotype = STEREOTYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDimensions() <em>Dimensions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDimensions()
	 * @generated
	 * @ordered
	 */
	protected EList<DataType> dimensions;

	/**
	 * The default value of the '{@link #getScale() <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScale()
	 * @generated
	 * @ordered
	 */
	protected static final Scale SCALE_EDEFAULT = Scale.INTERVAL;

	/**
	 * The cached value of the '{@link #getScale() <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScale()
	 * @generated
	 * @ordered
	 */
	protected Scale scale = SCALE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMeasurement() <em>Measurement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasurement()
	 * @generated
	 * @ordered
	 */
	protected static final Measurement MEASUREMENT_EDEFAULT = Measurement.INTEGER;

	/**
	 * The cached value of the '{@link #getMeasurement() <em>Measurement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeasurement()
	 * @generated
	 * @ordered
	 */
	protected Measurement measurement = MEASUREMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnitOfMeasure() <em>Unit Of Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitOfMeasure()
	 * @generated
	 * @ordered
	 */
	protected static final String UNIT_OF_MEASURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnitOfMeasure() <em>Unit Of Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitOfMeasure()
	 * @generated
	 * @ordered
	 */
	protected String unitOfMeasure = UNIT_OF_MEASURE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLowerBoundRegion() <em>Lower Bound Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerBoundRegion()
	 * @generated
	 * @ordered
	 */
	protected static final float LOWER_BOUND_REGION_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getLowerBoundRegion() <em>Lower Bound Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLowerBoundRegion()
	 * @generated
	 * @ordered
	 */
	protected float lowerBoundRegion = LOWER_BOUND_REGION_EDEFAULT;

	/**
	 * The default value of the '{@link #getUpperBoundRegion() <em>Upper Bound Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperBoundRegion()
	 * @generated
	 * @ordered
	 */
	protected static final float UPPER_BOUND_REGION_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getUpperBoundRegion() <em>Upper Bound Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpperBoundRegion()
	 * @generated
	 * @ordered
	 */
	protected float upperBoundRegion = UPPER_BOUND_REGION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnerDomain() <em>Owner Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnerDomain()
	 * @generated
	 * @ordered
	 */
	protected DataType ownerDomain;

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
	 * The cached value of the '{@link #getStructure() <em>Structure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStructure()
	 * @generated
	 * @ordered
	 */
	protected DataType structure;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OntoumlPackage.Literals.DATA_TYPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.DATA_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeStereotype getStereotype() {
		return stereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotype(DataTypeStereotype newStereotype) {
		DataTypeStereotype oldStereotype = stereotype;
		stereotype = newStereotype == null ? STEREOTYPE_EDEFAULT : newStereotype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.DATA_TYPE__STEREOTYPE, oldStereotype, stereotype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataType> getDimensions() {
		if (dimensions == null) {
			dimensions = new EObjectWithInverseResolvingEList<DataType>(DataType.class, this, OntoumlPackage.DATA_TYPE__DIMENSIONS, OntoumlPackage.DATA_TYPE__OWNER_DOMAIN);
		}
		return dimensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scale getScale() {
		return scale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScale(Scale newScale) {
		Scale oldScale = scale;
		scale = newScale == null ? SCALE_EDEFAULT : newScale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.DATA_TYPE__SCALE, oldScale, scale));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measurement getMeasurement() {
		return measurement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeasurement(Measurement newMeasurement) {
		Measurement oldMeasurement = measurement;
		measurement = newMeasurement == null ? MEASUREMENT_EDEFAULT : newMeasurement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.DATA_TYPE__MEASUREMENT, oldMeasurement, measurement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitOfMeasure(String newUnitOfMeasure) {
		String oldUnitOfMeasure = unitOfMeasure;
		unitOfMeasure = newUnitOfMeasure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.DATA_TYPE__UNIT_OF_MEASURE, oldUnitOfMeasure, unitOfMeasure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLowerBoundRegion() {
		return lowerBoundRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLowerBoundRegion(float newLowerBoundRegion) {
		float oldLowerBoundRegion = lowerBoundRegion;
		lowerBoundRegion = newLowerBoundRegion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.DATA_TYPE__LOWER_BOUND_REGION, oldLowerBoundRegion, lowerBoundRegion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getUpperBoundRegion() {
		return upperBoundRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpperBoundRegion(float newUpperBoundRegion) {
		float oldUpperBoundRegion = upperBoundRegion;
		upperBoundRegion = newUpperBoundRegion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.DATA_TYPE__UPPER_BOUND_REGION, oldUpperBoundRegion, upperBoundRegion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getOwnerDomain() {
		if (ownerDomain != null && ownerDomain.eIsProxy()) {
			InternalEObject oldOwnerDomain = (InternalEObject)ownerDomain;
			ownerDomain = (DataType)eResolveProxy(oldOwnerDomain);
			if (ownerDomain != oldOwnerDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.DATA_TYPE__OWNER_DOMAIN, oldOwnerDomain, ownerDomain));
			}
		}
		return ownerDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetOwnerDomain() {
		return ownerDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnerDomain(DataType newOwnerDomain, NotificationChain msgs) {
		DataType oldOwnerDomain = ownerDomain;
		ownerDomain = newOwnerDomain;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OntoumlPackage.DATA_TYPE__OWNER_DOMAIN, oldOwnerDomain, newOwnerDomain);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnerDomain(DataType newOwnerDomain) {
		if (newOwnerDomain != ownerDomain) {
			NotificationChain msgs = null;
			if (ownerDomain != null)
				msgs = ((InternalEObject)ownerDomain).eInverseRemove(this, OntoumlPackage.DATA_TYPE__DIMENSIONS, DataType.class, msgs);
			if (newOwnerDomain != null)
				msgs = ((InternalEObject)newOwnerDomain).eInverseAdd(this, OntoumlPackage.DATA_TYPE__DIMENSIONS, DataType.class, msgs);
			msgs = basicSetOwnerDomain(newOwnerDomain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.DATA_TYPE__OWNER_DOMAIN, newOwnerDomain, newOwnerDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Literal> getLiterals() {
		if (literals == null) {
			literals = new EObjectContainmentWithInverseEList<Literal>(Literal.class, this, OntoumlPackage.DATA_TYPE__LITERALS, OntoumlPackage.LITERAL__OWNER);
		}
		return literals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getStructure() {
		if (structure != null && structure.eIsProxy()) {
			InternalEObject oldStructure = (InternalEObject)structure;
			structure = (DataType)eResolveProxy(oldStructure);
			if (structure != oldStructure) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OntoumlPackage.DATA_TYPE__STRUCTURE, oldStructure, structure));
			}
		}
		return structure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetStructure() {
		return structure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStructure(DataType newStructure) {
		DataType oldStructure = structure;
		structure = newStructure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OntoumlPackage.DATA_TYPE__STRUCTURE, oldStructure, structure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnumeration() {
		DataTypeStereotype _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, DataTypeStereotype.ENUMERATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDomain() {
		DataTypeStereotype _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, DataTypeStereotype.DOMAIN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDimension() {
		DataTypeStereotype _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, DataTypeStereotype.DIMENSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDataType() {
		DataTypeStereotype _stereotype = this.getStereotype();
		return Objects.equal(_stereotype, DataTypeStereotype.DATA_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNominal() {
		boolean _and = false;
		Scale _scale = this.getScale();
		boolean _notEquals = (!Objects.equal(_scale, null));
		if (!_notEquals) {
			_and = false;
		} else {
			Scale _scale_1 = this.getScale();
			boolean _equals = Objects.equal(_scale_1, Scale.NOMINAL);
			_and = _equals;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInterval() {
		boolean _and = false;
		Scale _scale = this.getScale();
		boolean _notEquals = (!Objects.equal(_scale, null));
		if (!_notEquals) {
			_and = false;
		} else {
			Scale _scale_1 = this.getScale();
			boolean _equals = Objects.equal(_scale_1, Scale.INTERVAL);
			_and = _equals;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOrdinal() {
		boolean _and = false;
		Scale _scale = this.getScale();
		boolean _notEquals = (!Objects.equal(_scale, null));
		if (!_notEquals) {
			_and = false;
		} else {
			Scale _scale_1 = this.getScale();
			boolean _equals = Objects.equal(_scale_1, Scale.ORDINAL);
			_and = _equals;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRational() {
		boolean _and = false;
		Scale _scale = this.getScale();
		boolean _notEquals = (!Objects.equal(_scale, null));
		if (!_notEquals) {
			_and = false;
		} else {
			Scale _scale_1 = this.getScale();
			boolean _equals = Objects.equal(_scale_1, Scale.RATIONAL);
			_and = _equals;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isString() {
		boolean _and = false;
		Measurement _measurement = this.getMeasurement();
		boolean _notEquals = (!Objects.equal(_measurement, null));
		if (!_notEquals) {
			_and = false;
		} else {
			Measurement _measurement_1 = this.getMeasurement();
			boolean _equals = Objects.equal(_measurement_1, Measurement.STRING);
			_and = _equals;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInteger() {
		boolean _and = false;
		Measurement _measurement = this.getMeasurement();
		boolean _notEquals = (!Objects.equal(_measurement, null));
		if (!_notEquals) {
			_and = false;
		} else {
			Measurement _measurement_1 = this.getMeasurement();
			boolean _equals = Objects.equal(_measurement_1, Measurement.INTEGER);
			_and = _equals;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDecimal() {
		boolean _and = false;
		Measurement _measurement = this.getMeasurement();
		boolean _notEquals = (!Objects.equal(_measurement, null));
		if (!_notEquals) {
			_and = false;
		} else {
			Measurement _measurement_1 = this.getMeasurement();
			boolean _equals = Objects.equal(_measurement_1, Measurement.DECIMAL);
			_and = _equals;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReal() {
		boolean _and = false;
		Measurement _measurement = this.getMeasurement();
		boolean _notEquals = (!Objects.equal(_measurement, null));
		if (!_notEquals) {
			_and = false;
		} else {
			Measurement _measurement_1 = this.getMeasurement();
			boolean _equals = Objects.equal(_measurement_1, Measurement.REAL);
			_and = _equals;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNominalString() {
		boolean _and = false;
		boolean _isNominal = this.isNominal();
		if (!_isNominal) {
			_and = false;
		} else {
			boolean _isString = this.isString();
			_and = _isString;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIntervalInteger() {
		boolean _and = false;
		boolean _isInterval = this.isInterval();
		if (!_isInterval) {
			_and = false;
		} else {
			boolean _isInteger = this.isInteger();
			_and = _isInteger;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIntervalDecimal() {
		boolean _and = false;
		boolean _isInterval = this.isInterval();
		if (!_isInterval) {
			_and = false;
		} else {
			boolean _isDecimal = this.isDecimal();
			_and = _isDecimal;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOrdinalInteger() {
		boolean _and = false;
		boolean _isOrdinal = this.isOrdinal();
		if (!_isOrdinal) {
			_and = false;
		} else {
			boolean _isInteger = this.isInteger();
			_and = _isInteger;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOrdinalDecimal() {
		boolean _and = false;
		boolean _isOrdinal = this.isOrdinal();
		if (!_isOrdinal) {
			_and = false;
		} else {
			boolean _isDecimal = this.isDecimal();
			_and = _isDecimal;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRationalInteger() {
		boolean _and = false;
		boolean _isRational = this.isRational();
		if (!_isRational) {
			_and = false;
		} else {
			boolean _isInteger = this.isInteger();
			_and = _isInteger;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRationalDecimal() {
		boolean _and = false;
		boolean _isRational = this.isRational();
		if (!_isRational) {
			_and = false;
		} else {
			boolean _isDecimal = this.isDecimal();
			_and = _isDecimal;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIntervalReal() {
		boolean _and = false;
		boolean _isInterval = this.isInterval();
		if (!_isInterval) {
			_and = false;
		} else {
			boolean _isReal = this.isReal();
			_and = _isReal;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOrdinalReal() {
		boolean _and = false;
		boolean _isOrdinal = this.isOrdinal();
		if (!_isOrdinal) {
			_and = false;
		} else {
			boolean _isReal = this.isReal();
			_and = _isReal;
		}
		return _and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRationalReal() {
		boolean _and = false;
		boolean _isRational = this.isRational();
		if (!_isRational) {
			_and = false;
		} else {
			boolean _isReal = this.isReal();
			_and = _isReal;
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
			case OntoumlPackage.DATA_TYPE__DIMENSIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDimensions()).basicAdd(otherEnd, msgs);
			case OntoumlPackage.DATA_TYPE__OWNER_DOMAIN:
				if (ownerDomain != null)
					msgs = ((InternalEObject)ownerDomain).eInverseRemove(this, OntoumlPackage.DATA_TYPE__DIMENSIONS, DataType.class, msgs);
				return basicSetOwnerDomain((DataType)otherEnd, msgs);
			case OntoumlPackage.DATA_TYPE__LITERALS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLiterals()).basicAdd(otherEnd, msgs);
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
			case OntoumlPackage.DATA_TYPE__DIMENSIONS:
				return ((InternalEList<?>)getDimensions()).basicRemove(otherEnd, msgs);
			case OntoumlPackage.DATA_TYPE__OWNER_DOMAIN:
				return basicSetOwnerDomain(null, msgs);
			case OntoumlPackage.DATA_TYPE__LITERALS:
				return ((InternalEList<?>)getLiterals()).basicRemove(otherEnd, msgs);
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
			case OntoumlPackage.DATA_TYPE__NAME:
				return getName();
			case OntoumlPackage.DATA_TYPE__STEREOTYPE:
				return getStereotype();
			case OntoumlPackage.DATA_TYPE__DIMENSIONS:
				return getDimensions();
			case OntoumlPackage.DATA_TYPE__SCALE:
				return getScale();
			case OntoumlPackage.DATA_TYPE__MEASUREMENT:
				return getMeasurement();
			case OntoumlPackage.DATA_TYPE__UNIT_OF_MEASURE:
				return getUnitOfMeasure();
			case OntoumlPackage.DATA_TYPE__LOWER_BOUND_REGION:
				return getLowerBoundRegion();
			case OntoumlPackage.DATA_TYPE__UPPER_BOUND_REGION:
				return getUpperBoundRegion();
			case OntoumlPackage.DATA_TYPE__OWNER_DOMAIN:
				if (resolve) return getOwnerDomain();
				return basicGetOwnerDomain();
			case OntoumlPackage.DATA_TYPE__LITERALS:
				return getLiterals();
			case OntoumlPackage.DATA_TYPE__STRUCTURE:
				if (resolve) return getStructure();
				return basicGetStructure();
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
			case OntoumlPackage.DATA_TYPE__NAME:
				setName((String)newValue);
				return;
			case OntoumlPackage.DATA_TYPE__STEREOTYPE:
				setStereotype((DataTypeStereotype)newValue);
				return;
			case OntoumlPackage.DATA_TYPE__DIMENSIONS:
				getDimensions().clear();
				getDimensions().addAll((Collection<? extends DataType>)newValue);
				return;
			case OntoumlPackage.DATA_TYPE__SCALE:
				setScale((Scale)newValue);
				return;
			case OntoumlPackage.DATA_TYPE__MEASUREMENT:
				setMeasurement((Measurement)newValue);
				return;
			case OntoumlPackage.DATA_TYPE__UNIT_OF_MEASURE:
				setUnitOfMeasure((String)newValue);
				return;
			case OntoumlPackage.DATA_TYPE__LOWER_BOUND_REGION:
				setLowerBoundRegion((Float)newValue);
				return;
			case OntoumlPackage.DATA_TYPE__UPPER_BOUND_REGION:
				setUpperBoundRegion((Float)newValue);
				return;
			case OntoumlPackage.DATA_TYPE__OWNER_DOMAIN:
				setOwnerDomain((DataType)newValue);
				return;
			case OntoumlPackage.DATA_TYPE__LITERALS:
				getLiterals().clear();
				getLiterals().addAll((Collection<? extends Literal>)newValue);
				return;
			case OntoumlPackage.DATA_TYPE__STRUCTURE:
				setStructure((DataType)newValue);
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
			case OntoumlPackage.DATA_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case OntoumlPackage.DATA_TYPE__STEREOTYPE:
				setStereotype(STEREOTYPE_EDEFAULT);
				return;
			case OntoumlPackage.DATA_TYPE__DIMENSIONS:
				getDimensions().clear();
				return;
			case OntoumlPackage.DATA_TYPE__SCALE:
				setScale(SCALE_EDEFAULT);
				return;
			case OntoumlPackage.DATA_TYPE__MEASUREMENT:
				setMeasurement(MEASUREMENT_EDEFAULT);
				return;
			case OntoumlPackage.DATA_TYPE__UNIT_OF_MEASURE:
				setUnitOfMeasure(UNIT_OF_MEASURE_EDEFAULT);
				return;
			case OntoumlPackage.DATA_TYPE__LOWER_BOUND_REGION:
				setLowerBoundRegion(LOWER_BOUND_REGION_EDEFAULT);
				return;
			case OntoumlPackage.DATA_TYPE__UPPER_BOUND_REGION:
				setUpperBoundRegion(UPPER_BOUND_REGION_EDEFAULT);
				return;
			case OntoumlPackage.DATA_TYPE__OWNER_DOMAIN:
				setOwnerDomain((DataType)null);
				return;
			case OntoumlPackage.DATA_TYPE__LITERALS:
				getLiterals().clear();
				return;
			case OntoumlPackage.DATA_TYPE__STRUCTURE:
				setStructure((DataType)null);
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
			case OntoumlPackage.DATA_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case OntoumlPackage.DATA_TYPE__STEREOTYPE:
				return stereotype != STEREOTYPE_EDEFAULT;
			case OntoumlPackage.DATA_TYPE__DIMENSIONS:
				return dimensions != null && !dimensions.isEmpty();
			case OntoumlPackage.DATA_TYPE__SCALE:
				return scale != SCALE_EDEFAULT;
			case OntoumlPackage.DATA_TYPE__MEASUREMENT:
				return measurement != MEASUREMENT_EDEFAULT;
			case OntoumlPackage.DATA_TYPE__UNIT_OF_MEASURE:
				return UNIT_OF_MEASURE_EDEFAULT == null ? unitOfMeasure != null : !UNIT_OF_MEASURE_EDEFAULT.equals(unitOfMeasure);
			case OntoumlPackage.DATA_TYPE__LOWER_BOUND_REGION:
				return lowerBoundRegion != LOWER_BOUND_REGION_EDEFAULT;
			case OntoumlPackage.DATA_TYPE__UPPER_BOUND_REGION:
				return upperBoundRegion != UPPER_BOUND_REGION_EDEFAULT;
			case OntoumlPackage.DATA_TYPE__OWNER_DOMAIN:
				return ownerDomain != null;
			case OntoumlPackage.DATA_TYPE__LITERALS:
				return literals != null && !literals.isEmpty();
			case OntoumlPackage.DATA_TYPE__STRUCTURE:
				return structure != null;
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
				case OntoumlPackage.DATA_TYPE__NAME: return OntoumlPackage.NAMED_ELEMENT__NAME;
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
				case OntoumlPackage.NAMED_ELEMENT__NAME: return OntoumlPackage.DATA_TYPE__NAME;
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
			case OntoumlPackage.DATA_TYPE___IS_ENUMERATION:
				return isEnumeration();
			case OntoumlPackage.DATA_TYPE___IS_DOMAIN:
				return isDomain();
			case OntoumlPackage.DATA_TYPE___IS_DIMENSION:
				return isDimension();
			case OntoumlPackage.DATA_TYPE___IS_DATA_TYPE:
				return isDataType();
			case OntoumlPackage.DATA_TYPE___IS_NOMINAL:
				return isNominal();
			case OntoumlPackage.DATA_TYPE___IS_INTERVAL:
				return isInterval();
			case OntoumlPackage.DATA_TYPE___IS_ORDINAL:
				return isOrdinal();
			case OntoumlPackage.DATA_TYPE___IS_RATIONAL:
				return isRational();
			case OntoumlPackage.DATA_TYPE___IS_STRING:
				return isString();
			case OntoumlPackage.DATA_TYPE___IS_INTEGER:
				return isInteger();
			case OntoumlPackage.DATA_TYPE___IS_DECIMAL:
				return isDecimal();
			case OntoumlPackage.DATA_TYPE___IS_REAL:
				return isReal();
			case OntoumlPackage.DATA_TYPE___IS_NOMINAL_STRING:
				return isNominalString();
			case OntoumlPackage.DATA_TYPE___IS_INTERVAL_INTEGER:
				return isIntervalInteger();
			case OntoumlPackage.DATA_TYPE___IS_INTERVAL_DECIMAL:
				return isIntervalDecimal();
			case OntoumlPackage.DATA_TYPE___IS_ORDINAL_INTEGER:
				return isOrdinalInteger();
			case OntoumlPackage.DATA_TYPE___IS_ORDINAL_DECIMAL:
				return isOrdinalDecimal();
			case OntoumlPackage.DATA_TYPE___IS_RATIONAL_INTEGER:
				return isRationalInteger();
			case OntoumlPackage.DATA_TYPE___IS_RATIONAL_DECIMAL:
				return isRationalDecimal();
			case OntoumlPackage.DATA_TYPE___IS_INTERVAL_REAL:
				return isIntervalReal();
			case OntoumlPackage.DATA_TYPE___IS_ORDINAL_REAL:
				return isOrdinalReal();
			case OntoumlPackage.DATA_TYPE___IS_RATIONAL_REAL:
				return isRationalReal();
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
		result.append(", scale: ");
		result.append(scale);
		result.append(", measurement: ");
		result.append(measurement);
		result.append(", unitOfMeasure: ");
		result.append(unitOfMeasure);
		result.append(", lowerBoundRegion: ");
		result.append(lowerBoundRegion);
		result.append(", upperBoundRegion: ");
		result.append(upperBoundRegion);
		result.append(')');
		return result.toString();
	}

} //DataTypeImpl
