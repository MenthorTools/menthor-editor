/**
 */
package net.menthor.metamodel.ontouml.impl;

import net.menthor.metamodel.ontouml.AllenRelation;
import net.menthor.metamodel.ontouml.Attribute;
import net.menthor.metamodel.ontouml.BinaryClassRelationship;
import net.menthor.metamodel.ontouml.Comment;
import net.menthor.metamodel.ontouml.DerivationRelationship;
import net.menthor.metamodel.ontouml.DimensionType;
import net.menthor.metamodel.ontouml.EndPoint;
import net.menthor.metamodel.ontouml.GeneralizationSet;
import net.menthor.metamodel.ontouml.MeasurementDimension;
import net.menthor.metamodel.ontouml.MeasurementDomain;
import net.menthor.metamodel.ontouml.MeasurementEnumeration;
import net.menthor.metamodel.ontouml.MeasurementRegion;
import net.menthor.metamodel.ontouml.MeasurementType;
import net.menthor.metamodel.ontouml.Model;
import net.menthor.metamodel.ontouml.NAryClassRelationship;
import net.menthor.metamodel.ontouml.NominalDimension;
import net.menthor.metamodel.ontouml.OntoumlFactory;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.Primitive;
import net.menthor.metamodel.ontouml.PrimitiveType;
import net.menthor.metamodel.ontouml.Quality;
import net.menthor.metamodel.ontouml.Region;
import net.menthor.metamodel.ontouml.Relation;
import net.menthor.metamodel.ontouml.StringNominalRegion;
import net.menthor.metamodel.ontouml.Universal;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OntoumlFactoryImpl extends EFactoryImpl implements OntoumlFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OntoumlFactory init() {
		try {
			OntoumlFactory theOntoumlFactory = (OntoumlFactory)EPackage.Registry.INSTANCE.getEFactory(OntoumlPackage.eNS_URI);
			if (theOntoumlFactory != null) {
				return theOntoumlFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OntoumlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OntoumlFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case OntoumlPackage.COMMENT: return createComment();
			case OntoumlPackage.MODEL: return createModel();
			case OntoumlPackage.PACKAGE: return createPackage();
			case OntoumlPackage.CLASS: return createClass();
			case OntoumlPackage.GENERALIZATION_SET: return createGeneralizationSet();
			case OntoumlPackage.END_POINT: return createEndPoint();
			case OntoumlPackage.ATTRIBUTE: return createAttribute();
			case OntoumlPackage.PRIMITIVE_TYPE: return createPrimitiveType();
			case OntoumlPackage.BINARY_CLASS_RELATIONSHIP: return createBinaryClassRelationship();
			case OntoumlPackage.DERIVATION_RELATIONSHIP: return createDerivationRelationship();
			case OntoumlPackage.NARY_CLASS_RELATIONSHIP: return createNAryClassRelationship();
			case OntoumlPackage.MEASUREMENT_DOMAIN: return createMeasurementDomain();
			case OntoumlPackage.MEASUREMENT_DIMENSION: return createMeasurementDimension();
			case OntoumlPackage.NOMINAL_DIMENSION: return createNominalDimension();
			case OntoumlPackage.MEASUREMENT_REGION: return createMeasurementRegion();
			case OntoumlPackage.STRING_NOMINAL_REGION: return createStringNominalRegion();
			case OntoumlPackage.MEASUREMENT_ENUMERATION: return createMeasurementEnumeration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case OntoumlPackage.UNIVERSAL:
				return createUniversalFromString(eDataType, initialValue);
			case OntoumlPackage.QUALITY:
				return createQualityFromString(eDataType, initialValue);
			case OntoumlPackage.PRIMITIVE:
				return createPrimitiveFromString(eDataType, initialValue);
			case OntoumlPackage.RELATION:
				return createRelationFromString(eDataType, initialValue);
			case OntoumlPackage.ALLEN_RELATION:
				return createAllenRelationFromString(eDataType, initialValue);
			case OntoumlPackage.DIMENSION_TYPE:
				return createDimensionTypeFromString(eDataType, initialValue);
			case OntoumlPackage.MEASUREMENT_TYPE:
				return createMeasurementTypeFromString(eDataType, initialValue);
			case OntoumlPackage.REGION:
				return createRegionFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case OntoumlPackage.UNIVERSAL:
				return convertUniversalToString(eDataType, instanceValue);
			case OntoumlPackage.QUALITY:
				return convertQualityToString(eDataType, instanceValue);
			case OntoumlPackage.PRIMITIVE:
				return convertPrimitiveToString(eDataType, instanceValue);
			case OntoumlPackage.RELATION:
				return convertRelationToString(eDataType, instanceValue);
			case OntoumlPackage.ALLEN_RELATION:
				return convertAllenRelationToString(eDataType, instanceValue);
			case OntoumlPackage.DIMENSION_TYPE:
				return convertDimensionTypeToString(eDataType, instanceValue);
			case OntoumlPackage.MEASUREMENT_TYPE:
				return convertMeasurementTypeToString(eDataType, instanceValue);
			case OntoumlPackage.REGION:
				return convertRegionToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Comment createComment() {
		CommentImpl comment = new CommentImpl();
		return comment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model createModel() {
		ModelImpl model = new ModelImpl();
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Package createPackage() {
		PackageImpl package_ = new PackageImpl();
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public net.menthor.metamodel.ontouml.Class createClass() {
		ClassImpl class_ = new ClassImpl();
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralizationSet createGeneralizationSet() {
		GeneralizationSetImpl generalizationSet = new GeneralizationSetImpl();
		return generalizationSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndPoint createEndPoint() {
		EndPointImpl endPoint = new EndPointImpl();
		return endPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveType createPrimitiveType() {
		PrimitiveTypeImpl primitiveType = new PrimitiveTypeImpl();
		return primitiveType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryClassRelationship createBinaryClassRelationship() {
		BinaryClassRelationshipImpl binaryClassRelationship = new BinaryClassRelationshipImpl();
		return binaryClassRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DerivationRelationship createDerivationRelationship() {
		DerivationRelationshipImpl derivationRelationship = new DerivationRelationshipImpl();
		return derivationRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NAryClassRelationship createNAryClassRelationship() {
		NAryClassRelationshipImpl nAryClassRelationship = new NAryClassRelationshipImpl();
		return nAryClassRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementDomain createMeasurementDomain() {
		MeasurementDomainImpl measurementDomain = new MeasurementDomainImpl();
		return measurementDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementDimension createMeasurementDimension() {
		MeasurementDimensionImpl measurementDimension = new MeasurementDimensionImpl();
		return measurementDimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NominalDimension createNominalDimension() {
		NominalDimensionImpl nominalDimension = new NominalDimensionImpl();
		return nominalDimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementRegion createMeasurementRegion() {
		MeasurementRegionImpl measurementRegion = new MeasurementRegionImpl();
		return measurementRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringNominalRegion createStringNominalRegion() {
		StringNominalRegionImpl stringNominalRegion = new StringNominalRegionImpl();
		return stringNominalRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementEnumeration createMeasurementEnumeration() {
		MeasurementEnumerationImpl measurementEnumeration = new MeasurementEnumerationImpl();
		return measurementEnumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Universal createUniversalFromString(EDataType eDataType, String initialValue) {
		Universal result = Universal.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUniversalToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Quality createQualityFromString(EDataType eDataType, String initialValue) {
		Quality result = Quality.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertQualityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Primitive createPrimitiveFromString(EDataType eDataType, String initialValue) {
		Primitive result = Primitive.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPrimitiveToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relation createRelationFromString(EDataType eDataType, String initialValue) {
		Relation result = Relation.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRelationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllenRelation createAllenRelationFromString(EDataType eDataType, String initialValue) {
		AllenRelation result = AllenRelation.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAllenRelationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DimensionType createDimensionTypeFromString(EDataType eDataType, String initialValue) {
		DimensionType result = DimensionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDimensionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementType createMeasurementTypeFromString(EDataType eDataType, String initialValue) {
		MeasurementType result = MeasurementType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMeasurementTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Region createRegionFromString(EDataType eDataType, String initialValue) {
		Region result = Region.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRegionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OntoumlPackage getOntoumlPackage() {
		return (OntoumlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OntoumlPackage getPackage() {
		return OntoumlPackage.eINSTANCE;
	}

} //OntoumlFactoryImpl
