/**
 */
package net.menthor.metamodel.ontouml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * * =========================================
 *  DataType: is a Domain, Dimension, Enumeration or DataType
 *  ========================================
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.DataType#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.DataType#getDimensions <em>Dimensions</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.DataType#getScale <em>Scale</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.DataType#getMeasurement <em>Measurement</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.DataType#getUnitOfMeasure <em>Unit Of Measure</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.DataType#getLowerBoundRegion <em>Lower Bound Region</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.DataType#getUpperBoundRegion <em>Upper Bound Region</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.DataType#getOwnerDomain <em>Owner Domain</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.DataType#getLiterals <em>Literals</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.DataType#getStructure <em>Structure</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getDataType()
 * @model
 * @generated
 */
public interface DataType extends Type, NamedElement {
	/**
	 * Returns the value of the '<em><b>Stereotype</b></em>' attribute.
	 * The literals are from the enumeration {@link net.menthor.metamodel.ontouml.DataTypeStereotype}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stereotype</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stereotype</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.DataTypeStereotype
	 * @see #setStereotype(DataTypeStereotype)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getDataType_Stereotype()
	 * @model unique="false"
	 * @generated
	 */
	DataTypeStereotype getStereotype();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.DataType#getStereotype <em>Stereotype</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stereotype</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.DataTypeStereotype
	 * @see #getStereotype()
	 * @generated
	 */
	void setStereotype(DataTypeStereotype value);

	/**
	 * Returns the value of the '<em><b>Dimensions</b></em>' reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.DataType}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.DataType#getOwnerDomain <em>Owner Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimensions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimensions</em>' reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getDataType_Dimensions()
	 * @see net.menthor.metamodel.ontouml.DataType#getOwnerDomain
	 * @model opposite="ownerDomain"
	 * @generated
	 */
	EList<DataType> getDimensions();

	/**
	 * Returns the value of the '<em><b>Scale</b></em>' attribute.
	 * The literals are from the enumeration {@link net.menthor.metamodel.ontouml.Scale}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Scale
	 * @see #setScale(Scale)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getDataType_Scale()
	 * @model unique="false"
	 * @generated
	 */
	Scale getScale();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.DataType#getScale <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Scale
	 * @see #getScale()
	 * @generated
	 */
	void setScale(Scale value);

	/**
	 * Returns the value of the '<em><b>Measurement</b></em>' attribute.
	 * The literals are from the enumeration {@link net.menthor.metamodel.ontouml.Measurement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measurement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measurement</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Measurement
	 * @see #setMeasurement(Measurement)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getDataType_Measurement()
	 * @model unique="false"
	 * @generated
	 */
	Measurement getMeasurement();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.DataType#getMeasurement <em>Measurement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measurement</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Measurement
	 * @see #getMeasurement()
	 * @generated
	 */
	void setMeasurement(Measurement value);

	/**
	 * Returns the value of the '<em><b>Unit Of Measure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Of Measure</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Of Measure</em>' attribute.
	 * @see #setUnitOfMeasure(String)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getDataType_UnitOfMeasure()
	 * @model unique="false"
	 * @generated
	 */
	String getUnitOfMeasure();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.DataType#getUnitOfMeasure <em>Unit Of Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Of Measure</em>' attribute.
	 * @see #getUnitOfMeasure()
	 * @generated
	 */
	void setUnitOfMeasure(String value);

	/**
	 * Returns the value of the '<em><b>Lower Bound Region</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Bound Region</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Bound Region</em>' attribute.
	 * @see #setLowerBoundRegion(float)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getDataType_LowerBoundRegion()
	 * @model unique="false"
	 * @generated
	 */
	float getLowerBoundRegion();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.DataType#getLowerBoundRegion <em>Lower Bound Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound Region</em>' attribute.
	 * @see #getLowerBoundRegion()
	 * @generated
	 */
	void setLowerBoundRegion(float value);

	/**
	 * Returns the value of the '<em><b>Upper Bound Region</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Bound Region</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Bound Region</em>' attribute.
	 * @see #setUpperBoundRegion(float)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getDataType_UpperBoundRegion()
	 * @model unique="false"
	 * @generated
	 */
	float getUpperBoundRegion();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.DataType#getUpperBoundRegion <em>Upper Bound Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound Region</em>' attribute.
	 * @see #getUpperBoundRegion()
	 * @generated
	 */
	void setUpperBoundRegion(float value);

	/**
	 * Returns the value of the '<em><b>Owner Domain</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.DataType#getDimensions <em>Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner Domain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner Domain</em>' reference.
	 * @see #setOwnerDomain(DataType)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getDataType_OwnerDomain()
	 * @see net.menthor.metamodel.ontouml.DataType#getDimensions
	 * @model opposite="dimensions"
	 * @generated
	 */
	DataType getOwnerDomain();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.DataType#getOwnerDomain <em>Owner Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner Domain</em>' reference.
	 * @see #getOwnerDomain()
	 * @generated
	 */
	void setOwnerDomain(DataType value);

	/**
	 * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
	 * The list contents are of type {@link net.menthor.metamodel.ontouml.Literal}.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Literal#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literals</em>' containment reference list.
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getDataType_Literals()
	 * @see net.menthor.metamodel.ontouml.Literal#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Literal> getLiterals();

	/**
	 * Returns the value of the '<em><b>Structure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Structure</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Structure</em>' reference.
	 * @see #setStructure(DataType)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getDataType_Structure()
	 * @model
	 * @generated
	 */
	DataType getStructure();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.DataType#getStructure <em>Structure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Structure</em>' reference.
	 * @see #getStructure()
	 * @generated
	 */
	void setStructure(DataType value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.DataTypeStereotype%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.DataTypeStereotype%>.ENUMERATION);'"
	 * @generated
	 */
	boolean isEnumeration();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.DataTypeStereotype%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.DataTypeStereotype%>.DOMAIN);'"
	 * @generated
	 */
	boolean isDomain();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.DataTypeStereotype%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.DataTypeStereotype%>.DIMENSION);'"
	 * @generated
	 */
	boolean isDimension();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%net.menthor.metamodel.ontouml.DataTypeStereotype%> _stereotype = this.getStereotype();\nreturn <%com.google.common.base.Objects%>.equal(_stereotype, <%net.menthor.metamodel.ontouml.DataTypeStereotype%>.DATA_TYPE);'"
	 * @generated
	 */
	boolean isDataType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.Scale%> _scale = this.getScale();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_scale, null));\nif (!_notEquals)\n{\n\t_and = false;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Scale%> _scale_1 = this.getScale();\n\tboolean _equals = <%com.google.common.base.Objects%>.equal(_scale_1, <%net.menthor.metamodel.ontouml.Scale%>.NOMINAL);\n\t_and = _equals;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isNominal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.Scale%> _scale = this.getScale();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_scale, null));\nif (!_notEquals)\n{\n\t_and = false;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Scale%> _scale_1 = this.getScale();\n\tboolean _equals = <%com.google.common.base.Objects%>.equal(_scale_1, <%net.menthor.metamodel.ontouml.Scale%>.INTERVAL);\n\t_and = _equals;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isInterval();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.Scale%> _scale = this.getScale();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_scale, null));\nif (!_notEquals)\n{\n\t_and = false;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Scale%> _scale_1 = this.getScale();\n\tboolean _equals = <%com.google.common.base.Objects%>.equal(_scale_1, <%net.menthor.metamodel.ontouml.Scale%>.ORDINAL);\n\t_and = _equals;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isOrdinal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.Scale%> _scale = this.getScale();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_scale, null));\nif (!_notEquals)\n{\n\t_and = false;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Scale%> _scale_1 = this.getScale();\n\tboolean _equals = <%com.google.common.base.Objects%>.equal(_scale_1, <%net.menthor.metamodel.ontouml.Scale%>.RATIONAL);\n\t_and = _equals;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isRational();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.Measurement%> _measurement = this.getMeasurement();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_measurement, null));\nif (!_notEquals)\n{\n\t_and = false;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Measurement%> _measurement_1 = this.getMeasurement();\n\tboolean _equals = <%com.google.common.base.Objects%>.equal(_measurement_1, <%net.menthor.metamodel.ontouml.Measurement%>.STRING);\n\t_and = _equals;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isString();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.Measurement%> _measurement = this.getMeasurement();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_measurement, null));\nif (!_notEquals)\n{\n\t_and = false;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Measurement%> _measurement_1 = this.getMeasurement();\n\tboolean _equals = <%com.google.common.base.Objects%>.equal(_measurement_1, <%net.menthor.metamodel.ontouml.Measurement%>.INTEGER);\n\t_and = _equals;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isInteger();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.Measurement%> _measurement = this.getMeasurement();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_measurement, null));\nif (!_notEquals)\n{\n\t_and = false;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Measurement%> _measurement_1 = this.getMeasurement();\n\tboolean _equals = <%com.google.common.base.Objects%>.equal(_measurement_1, <%net.menthor.metamodel.ontouml.Measurement%>.DECIMAL);\n\t_and = _equals;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isDecimal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.Measurement%> _measurement = this.getMeasurement();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_measurement, null));\nif (!_notEquals)\n{\n\t_and = false;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Measurement%> _measurement_1 = this.getMeasurement();\n\tboolean _equals = <%com.google.common.base.Objects%>.equal(_measurement_1, <%net.menthor.metamodel.ontouml.Measurement%>.REAL);\n\t_and = _equals;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isReal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\nboolean _isNominal = this.isNominal();\nif (!_isNominal)\n{\n\t_and = false;\n} else\n{\n\tboolean _isString = this.isString();\n\t_and = _isString;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isNominalString();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\nboolean _isInterval = this.isInterval();\nif (!_isInterval)\n{\n\t_and = false;\n} else\n{\n\tboolean _isInteger = this.isInteger();\n\t_and = _isInteger;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isIntervalInteger();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\nboolean _isInterval = this.isInterval();\nif (!_isInterval)\n{\n\t_and = false;\n} else\n{\n\tboolean _isDecimal = this.isDecimal();\n\t_and = _isDecimal;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isIntervalDecimal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\nboolean _isOrdinal = this.isOrdinal();\nif (!_isOrdinal)\n{\n\t_and = false;\n} else\n{\n\tboolean _isInteger = this.isInteger();\n\t_and = _isInteger;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isOrdinalInteger();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\nboolean _isOrdinal = this.isOrdinal();\nif (!_isOrdinal)\n{\n\t_and = false;\n} else\n{\n\tboolean _isDecimal = this.isDecimal();\n\t_and = _isDecimal;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isOrdinalDecimal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\nboolean _isRational = this.isRational();\nif (!_isRational)\n{\n\t_and = false;\n} else\n{\n\tboolean _isInteger = this.isInteger();\n\t_and = _isInteger;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isRationalInteger();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\nboolean _isRational = this.isRational();\nif (!_isRational)\n{\n\t_and = false;\n} else\n{\n\tboolean _isDecimal = this.isDecimal();\n\t_and = _isDecimal;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isRationalDecimal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\nboolean _isInterval = this.isInterval();\nif (!_isInterval)\n{\n\t_and = false;\n} else\n{\n\tboolean _isReal = this.isReal();\n\t_and = _isReal;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isIntervalReal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\nboolean _isOrdinal = this.isOrdinal();\nif (!_isOrdinal)\n{\n\t_and = false;\n} else\n{\n\tboolean _isReal = this.isReal();\n\t_and = _isReal;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isOrdinalReal();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\nboolean _isRational = this.isRational();\nif (!_isRational)\n{\n\t_and = false;\n} else\n{\n\tboolean _isReal = this.isReal();\n\t_and = _isReal;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isRationalReal();

} // DataType
