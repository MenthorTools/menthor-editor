/**
 */
package net.menthor.metamodel.ontouml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dimension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * * =========================================
 *  - structure dimension
 * 
 *  A Dimension might be part of a Domain or connected to a Structuration.
 *  A Dimension might define basic Regions as lower and upper bound (Constraint C19 and C20)
 *  ========================================
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link net.menthor.metamodel.ontouml.Dimension#getOwnerDomain <em>Owner Domain</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Dimension#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Dimension#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Dimension#getUnitOfMeasure <em>Unit Of Measure</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Dimension#getScale <em>Scale</em>}</li>
 *   <li>{@link net.menthor.metamodel.ontouml.Dimension#getMeasure <em>Measure</em>}</li>
 * </ul>
 * </p>
 *
 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getDimension()
 * @model
 * @generated
 */
public interface Dimension extends Structure {
	/**
	 * Returns the value of the '<em><b>Owner Domain</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link net.menthor.metamodel.ontouml.Domain#getDimensions <em>Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner Domain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner Domain</em>' reference.
	 * @see #setOwnerDomain(Domain)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getDimension_OwnerDomain()
	 * @see net.menthor.metamodel.ontouml.Domain#getDimensions
	 * @model opposite="dimensions"
	 * @generated
	 */
	Domain getOwnerDomain();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Dimension#getOwnerDomain <em>Owner Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner Domain</em>' reference.
	 * @see #getOwnerDomain()
	 * @generated
	 */
	void setOwnerDomain(Domain value);

	/**
	 * Returns the value of the '<em><b>Lower Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Bound</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Bound</em>' reference.
	 * @see #setLowerBound(Region)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getDimension_LowerBound()
	 * @model
	 * @generated
	 */
	Region getLowerBound();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Dimension#getLowerBound <em>Lower Bound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound</em>' reference.
	 * @see #getLowerBound()
	 * @generated
	 */
	void setLowerBound(Region value);

	/**
	 * Returns the value of the '<em><b>Upper Bound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Bound</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Bound</em>' reference.
	 * @see #setUpperBound(Region)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getDimension_UpperBound()
	 * @model
	 * @generated
	 */
	Region getUpperBound();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Dimension#getUpperBound <em>Upper Bound</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound</em>' reference.
	 * @see #getUpperBound()
	 * @generated
	 */
	void setUpperBound(Region value);

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
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getDimension_UnitOfMeasure()
	 * @model unique="false"
	 * @generated
	 */
	String getUnitOfMeasure();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Dimension#getUnitOfMeasure <em>Unit Of Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Of Measure</em>' attribute.
	 * @see #getUnitOfMeasure()
	 * @generated
	 */
	void setUnitOfMeasure(String value);

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
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getDimension_Scale()
	 * @model unique="false"
	 * @generated
	 */
	Scale getScale();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Dimension#getScale <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Scale
	 * @see #getScale()
	 * @generated
	 */
	void setScale(Scale value);

	/**
	 * Returns the value of the '<em><b>Measure</b></em>' attribute.
	 * The literals are from the enumeration {@link net.menthor.metamodel.ontouml.Primitive}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Measure</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measure</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Primitive
	 * @see #setMeasure(Primitive)
	 * @see net.menthor.metamodel.ontouml.OntoumlPackage#getDimension_Measure()
	 * @model unique="false"
	 * @generated
	 */
	Primitive getMeasure();

	/**
	 * Sets the value of the '{@link net.menthor.metamodel.ontouml.Dimension#getMeasure <em>Measure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measure</em>' attribute.
	 * @see net.menthor.metamodel.ontouml.Primitive
	 * @see #getMeasure()
	 * @generated
	 */
	void setMeasure(Primitive value);

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
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.Primitive%> _measure = this.getMeasure();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_measure, null));\nif (!_notEquals)\n{\n\t_and = false;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Primitive%> _measure_1 = this.getMeasure();\n\tboolean _equals = <%com.google.common.base.Objects%>.equal(_measure_1, <%net.menthor.metamodel.ontouml.Primitive%>.STRING);\n\t_and = _equals;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isString();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.Primitive%> _measure = this.getMeasure();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_measure, null));\nif (!_notEquals)\n{\n\t_and = false;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Primitive%> _measure_1 = this.getMeasure();\n\tboolean _equals = <%com.google.common.base.Objects%>.equal(_measure_1, <%net.menthor.metamodel.ontouml.Primitive%>.INTEGER);\n\t_and = _equals;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isInteger();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _and = false;\n<%net.menthor.metamodel.ontouml.Primitive%> _measure = this.getMeasure();\nboolean _notEquals = (!<%com.google.common.base.Objects%>.equal(_measure, null));\nif (!_notEquals)\n{\n\t_and = false;\n} else\n{\n\t<%net.menthor.metamodel.ontouml.Primitive%> _measure_1 = this.getMeasure();\n\tboolean _equals = <%com.google.common.base.Objects%>.equal(_measure_1, <%net.menthor.metamodel.ontouml.Primitive%>.DECIMAL);\n\t_and = _equals;\n}\nreturn _and;'"
	 * @generated
	 */
	boolean isDecimal();

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

} // Dimension
