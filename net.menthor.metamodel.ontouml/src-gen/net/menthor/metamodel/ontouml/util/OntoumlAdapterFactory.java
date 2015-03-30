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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see net.menthor.metamodel.ontouml.OntoumlPackage
 * @generated
 */
public class OntoumlAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static OntoumlPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OntoumlAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = OntoumlPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OntoumlSwitch<Adapter> modelSwitch =
		new OntoumlSwitch<Adapter>() {
			@Override
			public Adapter caseElement(Element object) {
				return createElementAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseContainer(Container object) {
				return createContainerAdapter();
			}
			@Override
			public Adapter caseContainedElement(ContainedElement object) {
				return createContainedElementAdapter();
			}
			@Override
			public Adapter caseComment(Comment object) {
				return createCommentAdapter();
			}
			@Override
			public Adapter caseModel(Model object) {
				return createModelAdapter();
			}
			@Override
			public Adapter casePackage(net.menthor.metamodel.ontouml.Package object) {
				return createPackageAdapter();
			}
			@Override
			public Adapter caseClassifierElement(ClassifierElement object) {
				return createClassifierElementAdapter();
			}
			@Override
			public Adapter caseClass(net.menthor.metamodel.ontouml.Class object) {
				return createClassAdapter();
			}
			@Override
			public Adapter caseGeneralizationSet(GeneralizationSet object) {
				return createGeneralizationSetAdapter();
			}
			@Override
			public Adapter caseProperty(Property object) {
				return createPropertyAdapter();
			}
			@Override
			public Adapter caseEndPoint(EndPoint object) {
				return createEndPointAdapter();
			}
			@Override
			public Adapter caseAttribute(Attribute object) {
				return createAttributeAdapter();
			}
			@Override
			public Adapter casePrimitiveType(PrimitiveType object) {
				return createPrimitiveTypeAdapter();
			}
			@Override
			public Adapter caseRelationship(Relationship object) {
				return createRelationshipAdapter();
			}
			@Override
			public Adapter caseBinaryRelationship(BinaryRelationship object) {
				return createBinaryRelationshipAdapter();
			}
			@Override
			public Adapter caseBinaryClassRelationship(BinaryClassRelationship object) {
				return createBinaryClassRelationshipAdapter();
			}
			@Override
			public Adapter caseDerivationRelationship(DerivationRelationship object) {
				return createDerivationRelationshipAdapter();
			}
			@Override
			public Adapter caseNAryClassRelationship(NAryClassRelationship object) {
				return createNAryClassRelationshipAdapter();
			}
			@Override
			public Adapter caseMeasurementDomain(MeasurementDomain object) {
				return createMeasurementDomainAdapter();
			}
			@Override
			public Adapter caseMeasurementDimension(MeasurementDimension object) {
				return createMeasurementDimensionAdapter();
			}
			@Override
			public Adapter caseNominalDimension(NominalDimension object) {
				return createNominalDimensionAdapter();
			}
			@Override
			public Adapter caseMeasurementRegion(MeasurementRegion object) {
				return createMeasurementRegionAdapter();
			}
			@Override
			public Adapter caseStringNominalRegion(StringNominalRegion object) {
				return createStringNominalRegionAdapter();
			}
			@Override
			public Adapter caseMeasurementEnumeration(MeasurementEnumeration object) {
				return createMeasurementEnumerationAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link net.menthor.metamodel.ontouml.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.menthor.metamodel.ontouml.Element
	 * @generated
	 */
	public Adapter createElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.menthor.metamodel.ontouml.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.menthor.metamodel.ontouml.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.menthor.metamodel.ontouml.Container <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.menthor.metamodel.ontouml.Container
	 * @generated
	 */
	public Adapter createContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.menthor.metamodel.ontouml.ContainedElement <em>Contained Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.menthor.metamodel.ontouml.ContainedElement
	 * @generated
	 */
	public Adapter createContainedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.menthor.metamodel.ontouml.Comment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.menthor.metamodel.ontouml.Comment
	 * @generated
	 */
	public Adapter createCommentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.menthor.metamodel.ontouml.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.menthor.metamodel.ontouml.Model
	 * @generated
	 */
	public Adapter createModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.menthor.metamodel.ontouml.Package <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.menthor.metamodel.ontouml.Package
	 * @generated
	 */
	public Adapter createPackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.menthor.metamodel.ontouml.ClassifierElement <em>Classifier Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.menthor.metamodel.ontouml.ClassifierElement
	 * @generated
	 */
	public Adapter createClassifierElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.menthor.metamodel.ontouml.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.menthor.metamodel.ontouml.Class
	 * @generated
	 */
	public Adapter createClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.menthor.metamodel.ontouml.GeneralizationSet <em>Generalization Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.menthor.metamodel.ontouml.GeneralizationSet
	 * @generated
	 */
	public Adapter createGeneralizationSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.menthor.metamodel.ontouml.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.menthor.metamodel.ontouml.Property
	 * @generated
	 */
	public Adapter createPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.menthor.metamodel.ontouml.EndPoint <em>End Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.menthor.metamodel.ontouml.EndPoint
	 * @generated
	 */
	public Adapter createEndPointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.menthor.metamodel.ontouml.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.menthor.metamodel.ontouml.Attribute
	 * @generated
	 */
	public Adapter createAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.menthor.metamodel.ontouml.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.menthor.metamodel.ontouml.PrimitiveType
	 * @generated
	 */
	public Adapter createPrimitiveTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.menthor.metamodel.ontouml.Relationship <em>Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.menthor.metamodel.ontouml.Relationship
	 * @generated
	 */
	public Adapter createRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.menthor.metamodel.ontouml.BinaryRelationship <em>Binary Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.menthor.metamodel.ontouml.BinaryRelationship
	 * @generated
	 */
	public Adapter createBinaryRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.menthor.metamodel.ontouml.BinaryClassRelationship <em>Binary Class Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.menthor.metamodel.ontouml.BinaryClassRelationship
	 * @generated
	 */
	public Adapter createBinaryClassRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.menthor.metamodel.ontouml.DerivationRelationship <em>Derivation Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.menthor.metamodel.ontouml.DerivationRelationship
	 * @generated
	 */
	public Adapter createDerivationRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.menthor.metamodel.ontouml.NAryClassRelationship <em>NAry Class Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.menthor.metamodel.ontouml.NAryClassRelationship
	 * @generated
	 */
	public Adapter createNAryClassRelationshipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.menthor.metamodel.ontouml.MeasurementDomain <em>Measurement Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.menthor.metamodel.ontouml.MeasurementDomain
	 * @generated
	 */
	public Adapter createMeasurementDomainAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.menthor.metamodel.ontouml.MeasurementDimension <em>Measurement Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.menthor.metamodel.ontouml.MeasurementDimension
	 * @generated
	 */
	public Adapter createMeasurementDimensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.menthor.metamodel.ontouml.NominalDimension <em>Nominal Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.menthor.metamodel.ontouml.NominalDimension
	 * @generated
	 */
	public Adapter createNominalDimensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.menthor.metamodel.ontouml.MeasurementRegion <em>Measurement Region</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.menthor.metamodel.ontouml.MeasurementRegion
	 * @generated
	 */
	public Adapter createMeasurementRegionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.menthor.metamodel.ontouml.StringNominalRegion <em>String Nominal Region</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.menthor.metamodel.ontouml.StringNominalRegion
	 * @generated
	 */
	public Adapter createStringNominalRegionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link net.menthor.metamodel.ontouml.MeasurementEnumeration <em>Measurement Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see net.menthor.metamodel.ontouml.MeasurementEnumeration
	 * @generated
	 */
	public Adapter createMeasurementEnumerationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //OntoumlAdapterFactory
