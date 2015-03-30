/**
 */
package net.menthor.metamodel.ontouml.util;

import net.menthor.metamodel.ontouml.Attribute;
import net.menthor.metamodel.ontouml.BinaryClassRelationship;
import net.menthor.metamodel.ontouml.BinaryRelationship;
import net.menthor.metamodel.ontouml.ClassifierElement;
import net.menthor.metamodel.ontouml.Comment;
import net.menthor.metamodel.ontouml.ContainedElement;
import net.menthor.metamodel.ontouml.Container;
import net.menthor.metamodel.ontouml.DerivationRelationship;
import net.menthor.metamodel.ontouml.Element;
import net.menthor.metamodel.ontouml.EndPoint;
import net.menthor.metamodel.ontouml.GeneralizationSet;
import net.menthor.metamodel.ontouml.MeasurementDimension;
import net.menthor.metamodel.ontouml.MeasurementDomain;
import net.menthor.metamodel.ontouml.MeasurementEnumeration;
import net.menthor.metamodel.ontouml.MeasurementRegion;
import net.menthor.metamodel.ontouml.Model;
import net.menthor.metamodel.ontouml.NAryClassRelationship;
import net.menthor.metamodel.ontouml.NamedElement;
import net.menthor.metamodel.ontouml.NominalDimension;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.PrimitiveType;
import net.menthor.metamodel.ontouml.Property;
import net.menthor.metamodel.ontouml.Relationship;
import net.menthor.metamodel.ontouml.StringNominalRegion;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see net.menthor.metamodel.ontouml.OntoumlPackage
 * @generated
 */
public class OntoumlSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OntoumlPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OntoumlSwitch() {
		if (modelPackage == null) {
			modelPackage = OntoumlPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case OntoumlPackage.ELEMENT: {
				Element element = (Element)theEObject;
				T result = caseElement(element);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OntoumlPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = caseElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OntoumlPackage.CONTAINER: {
				Container container = (Container)theEObject;
				T result = caseContainer(container);
				if (result == null) result = caseNamedElement(container);
				if (result == null) result = caseElement(container);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OntoumlPackage.CONTAINED_ELEMENT: {
				ContainedElement containedElement = (ContainedElement)theEObject;
				T result = caseContainedElement(containedElement);
				if (result == null) result = caseElement(containedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OntoumlPackage.COMMENT: {
				Comment comment = (Comment)theEObject;
				T result = caseComment(comment);
				if (result == null) result = caseElement(comment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OntoumlPackage.MODEL: {
				Model model = (Model)theEObject;
				T result = caseModel(model);
				if (result == null) result = caseContainer(model);
				if (result == null) result = caseNamedElement(model);
				if (result == null) result = caseElement(model);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OntoumlPackage.PACKAGE: {
				net.menthor.metamodel.ontouml.Package package_ = (net.menthor.metamodel.ontouml.Package)theEObject;
				T result = casePackage(package_);
				if (result == null) result = caseContainer(package_);
				if (result == null) result = caseContainedElement(package_);
				if (result == null) result = caseNamedElement(package_);
				if (result == null) result = caseElement(package_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OntoumlPackage.CLASSIFIER_ELEMENT: {
				ClassifierElement classifierElement = (ClassifierElement)theEObject;
				T result = caseClassifierElement(classifierElement);
				if (result == null) result = caseContainedElement(classifierElement);
				if (result == null) result = caseElement(classifierElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OntoumlPackage.CLASS: {
				net.menthor.metamodel.ontouml.Class class_ = (net.menthor.metamodel.ontouml.Class)theEObject;
				T result = caseClass(class_);
				if (result == null) result = caseNamedElement(class_);
				if (result == null) result = caseClassifierElement(class_);
				if (result == null) result = caseContainedElement(class_);
				if (result == null) result = caseElement(class_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OntoumlPackage.GENERALIZATION_SET: {
				GeneralizationSet generalizationSet = (GeneralizationSet)theEObject;
				T result = caseGeneralizationSet(generalizationSet);
				if (result == null) result = caseNamedElement(generalizationSet);
				if (result == null) result = caseContainedElement(generalizationSet);
				if (result == null) result = caseElement(generalizationSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OntoumlPackage.PROPERTY: {
				Property property = (Property)theEObject;
				T result = caseProperty(property);
				if (result == null) result = caseNamedElement(property);
				if (result == null) result = caseElement(property);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OntoumlPackage.END_POINT: {
				EndPoint endPoint = (EndPoint)theEObject;
				T result = caseEndPoint(endPoint);
				if (result == null) result = caseProperty(endPoint);
				if (result == null) result = caseNamedElement(endPoint);
				if (result == null) result = caseElement(endPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OntoumlPackage.ATTRIBUTE: {
				Attribute attribute = (Attribute)theEObject;
				T result = caseAttribute(attribute);
				if (result == null) result = caseProperty(attribute);
				if (result == null) result = caseNamedElement(attribute);
				if (result == null) result = caseElement(attribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OntoumlPackage.PRIMITIVE_TYPE: {
				PrimitiveType primitiveType = (PrimitiveType)theEObject;
				T result = casePrimitiveType(primitiveType);
				if (result == null) result = caseContainedElement(primitiveType);
				if (result == null) result = caseElement(primitiveType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OntoumlPackage.RELATIONSHIP: {
				Relationship relationship = (Relationship)theEObject;
				T result = caseRelationship(relationship);
				if (result == null) result = caseClassifierElement(relationship);
				if (result == null) result = caseContainedElement(relationship);
				if (result == null) result = caseElement(relationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OntoumlPackage.BINARY_RELATIONSHIP: {
				BinaryRelationship binaryRelationship = (BinaryRelationship)theEObject;
				T result = caseBinaryRelationship(binaryRelationship);
				if (result == null) result = caseRelationship(binaryRelationship);
				if (result == null) result = caseClassifierElement(binaryRelationship);
				if (result == null) result = caseContainedElement(binaryRelationship);
				if (result == null) result = caseElement(binaryRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP: {
				BinaryClassRelationship binaryClassRelationship = (BinaryClassRelationship)theEObject;
				T result = caseBinaryClassRelationship(binaryClassRelationship);
				if (result == null) result = caseNamedElement(binaryClassRelationship);
				if (result == null) result = caseBinaryRelationship(binaryClassRelationship);
				if (result == null) result = caseRelationship(binaryClassRelationship);
				if (result == null) result = caseClassifierElement(binaryClassRelationship);
				if (result == null) result = caseContainedElement(binaryClassRelationship);
				if (result == null) result = caseElement(binaryClassRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OntoumlPackage.DERIVATION_RELATIONSHIP: {
				DerivationRelationship derivationRelationship = (DerivationRelationship)theEObject;
				T result = caseDerivationRelationship(derivationRelationship);
				if (result == null) result = caseBinaryRelationship(derivationRelationship);
				if (result == null) result = caseRelationship(derivationRelationship);
				if (result == null) result = caseClassifierElement(derivationRelationship);
				if (result == null) result = caseContainedElement(derivationRelationship);
				if (result == null) result = caseElement(derivationRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OntoumlPackage.NARY_CLASS_RELATIONSHIP: {
				NAryClassRelationship nAryClassRelationship = (NAryClassRelationship)theEObject;
				T result = caseNAryClassRelationship(nAryClassRelationship);
				if (result == null) result = caseNamedElement(nAryClassRelationship);
				if (result == null) result = caseRelationship(nAryClassRelationship);
				if (result == null) result = caseClassifierElement(nAryClassRelationship);
				if (result == null) result = caseContainedElement(nAryClassRelationship);
				if (result == null) result = caseElement(nAryClassRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OntoumlPackage.MEASUREMENT_DOMAIN: {
				MeasurementDomain measurementDomain = (MeasurementDomain)theEObject;
				T result = caseMeasurementDomain(measurementDomain);
				if (result == null) result = caseNamedElement(measurementDomain);
				if (result == null) result = caseContainedElement(measurementDomain);
				if (result == null) result = caseElement(measurementDomain);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OntoumlPackage.MEASUREMENT_DIMENSION: {
				MeasurementDimension measurementDimension = (MeasurementDimension)theEObject;
				T result = caseMeasurementDimension(measurementDimension);
				if (result == null) result = caseNamedElement(measurementDimension);
				if (result == null) result = caseContainedElement(measurementDimension);
				if (result == null) result = caseElement(measurementDimension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OntoumlPackage.NOMINAL_DIMENSION: {
				NominalDimension nominalDimension = (NominalDimension)theEObject;
				T result = caseNominalDimension(nominalDimension);
				if (result == null) result = caseNamedElement(nominalDimension);
				if (result == null) result = caseContainedElement(nominalDimension);
				if (result == null) result = caseElement(nominalDimension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OntoumlPackage.MEASUREMENT_REGION: {
				MeasurementRegion measurementRegion = (MeasurementRegion)theEObject;
				T result = caseMeasurementRegion(measurementRegion);
				if (result == null) result = caseNamedElement(measurementRegion);
				if (result == null) result = caseContainedElement(measurementRegion);
				if (result == null) result = caseElement(measurementRegion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OntoumlPackage.STRING_NOMINAL_REGION: {
				StringNominalRegion stringNominalRegion = (StringNominalRegion)theEObject;
				T result = caseStringNominalRegion(stringNominalRegion);
				if (result == null) result = caseNamedElement(stringNominalRegion);
				if (result == null) result = caseContainedElement(stringNominalRegion);
				if (result == null) result = caseElement(stringNominalRegion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case OntoumlPackage.MEASUREMENT_ENUMERATION: {
				MeasurementEnumeration measurementEnumeration = (MeasurementEnumeration)theEObject;
				T result = caseMeasurementEnumeration(measurementEnumeration);
				if (result == null) result = caseNamedElement(measurementEnumeration);
				if (result == null) result = caseContainedElement(measurementEnumeration);
				if (result == null) result = caseElement(measurementEnumeration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElement(Element object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainer(Container object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contained Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contained Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainedElement(ContainedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Comment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Comment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComment(Comment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModel(Model object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackage(net.menthor.metamodel.ontouml.Package object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassifierElement(ClassifierElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClass(net.menthor.metamodel.ontouml.Class object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generalization Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generalization Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGeneralizationSet(GeneralizationSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProperty(Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>End Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEndPoint(EndPoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttribute(Attribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveType(PrimitiveType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationship(Relationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryRelationship(BinaryRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Class Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Class Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryClassRelationship(BinaryClassRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Derivation Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Derivation Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDerivationRelationship(DerivationRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>NAry Class Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>NAry Class Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNAryClassRelationship(NAryClassRelationship object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Measurement Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measurement Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasurementDomain(MeasurementDomain object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Measurement Dimension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measurement Dimension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasurementDimension(MeasurementDimension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nominal Dimension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nominal Dimension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNominalDimension(NominalDimension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Measurement Region</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measurement Region</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasurementRegion(MeasurementRegion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Nominal Region</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Nominal Region</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringNominalRegion(StringNominalRegion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Measurement Enumeration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measurement Enumeration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasurementEnumeration(MeasurementEnumeration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //OntoumlSwitch
