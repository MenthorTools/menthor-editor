/**
 */
package net.menthor.metamodel.ontouml.impl;

import net.menthor.metamodel.ontouml.Attribute;
import net.menthor.metamodel.ontouml.Ciclicity;
import net.menthor.metamodel.ontouml.ClassStereotype;
import net.menthor.metamodel.ontouml.Classification;
import net.menthor.metamodel.ontouml.Comment;
import net.menthor.metamodel.ontouml.DataType;
import net.menthor.metamodel.ontouml.DataTypeStereotype;
import net.menthor.metamodel.ontouml.EndPoint;
import net.menthor.metamodel.ontouml.Existence;
import net.menthor.metamodel.ontouml.GeneralizationSet;
import net.menthor.metamodel.ontouml.Literal;
import net.menthor.metamodel.ontouml.Measurement;
import net.menthor.metamodel.ontouml.Model;
import net.menthor.metamodel.ontouml.OntoumlFactory;
import net.menthor.metamodel.ontouml.OntoumlPackage;
import net.menthor.metamodel.ontouml.ParticipationNature;
import net.menthor.metamodel.ontouml.PrimitiveStereotype;
import net.menthor.metamodel.ontouml.QualityNature;
import net.menthor.metamodel.ontouml.Reflexivity;
import net.menthor.metamodel.ontouml.Relationship;
import net.menthor.metamodel.ontouml.RelationshipStereotype;
import net.menthor.metamodel.ontouml.Scale;
import net.menthor.metamodel.ontouml.Symmetry;
import net.menthor.metamodel.ontouml.TemporalNature;
import net.menthor.metamodel.ontouml.Transitivity;

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
			case OntoumlPackage.ATTRIBUTE: return createAttribute();
			case OntoumlPackage.GENERALIZATION_SET: return createGeneralizationSet();
			case OntoumlPackage.LITERAL: return createLiteral();
			case OntoumlPackage.DATA_TYPE: return createDataType();
			case OntoumlPackage.CLASS: return createClass();
			case OntoumlPackage.END_POINT: return createEndPoint();
			case OntoumlPackage.RELATIONSHIP: return createRelationship();
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
			case OntoumlPackage.PRIMITIVE_STEREOTYPE:
				return createPrimitiveStereotypeFromString(eDataType, initialValue);
			case OntoumlPackage.CLASS_STEREOTYPE:
				return createClassStereotypeFromString(eDataType, initialValue);
			case OntoumlPackage.DATA_TYPE_STEREOTYPE:
				return createDataTypeStereotypeFromString(eDataType, initialValue);
			case OntoumlPackage.SCALE:
				return createScaleFromString(eDataType, initialValue);
			case OntoumlPackage.MEASUREMENT:
				return createMeasurementFromString(eDataType, initialValue);
			case OntoumlPackage.QUALITY_NATURE:
				return createQualityNatureFromString(eDataType, initialValue);
			case OntoumlPackage.CLASSIFICATION:
				return createClassificationFromString(eDataType, initialValue);
			case OntoumlPackage.EXISTENCE:
				return createExistenceFromString(eDataType, initialValue);
			case OntoumlPackage.RELATIONSHIP_STEREOTYPE:
				return createRelationshipStereotypeFromString(eDataType, initialValue);
			case OntoumlPackage.TEMPORAL_NATURE:
				return createTemporalNatureFromString(eDataType, initialValue);
			case OntoumlPackage.PARTICIPATION_NATURE:
				return createParticipationNatureFromString(eDataType, initialValue);
			case OntoumlPackage.REFLEXIVITY:
				return createReflexivityFromString(eDataType, initialValue);
			case OntoumlPackage.SYMMETRY:
				return createSymmetryFromString(eDataType, initialValue);
			case OntoumlPackage.TRANSITIVITY:
				return createTransitivityFromString(eDataType, initialValue);
			case OntoumlPackage.CICLICITY:
				return createCiclicityFromString(eDataType, initialValue);
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
			case OntoumlPackage.PRIMITIVE_STEREOTYPE:
				return convertPrimitiveStereotypeToString(eDataType, instanceValue);
			case OntoumlPackage.CLASS_STEREOTYPE:
				return convertClassStereotypeToString(eDataType, instanceValue);
			case OntoumlPackage.DATA_TYPE_STEREOTYPE:
				return convertDataTypeStereotypeToString(eDataType, instanceValue);
			case OntoumlPackage.SCALE:
				return convertScaleToString(eDataType, instanceValue);
			case OntoumlPackage.MEASUREMENT:
				return convertMeasurementToString(eDataType, instanceValue);
			case OntoumlPackage.QUALITY_NATURE:
				return convertQualityNatureToString(eDataType, instanceValue);
			case OntoumlPackage.CLASSIFICATION:
				return convertClassificationToString(eDataType, instanceValue);
			case OntoumlPackage.EXISTENCE:
				return convertExistenceToString(eDataType, instanceValue);
			case OntoumlPackage.RELATIONSHIP_STEREOTYPE:
				return convertRelationshipStereotypeToString(eDataType, instanceValue);
			case OntoumlPackage.TEMPORAL_NATURE:
				return convertTemporalNatureToString(eDataType, instanceValue);
			case OntoumlPackage.PARTICIPATION_NATURE:
				return convertParticipationNatureToString(eDataType, instanceValue);
			case OntoumlPackage.REFLEXIVITY:
				return convertReflexivityToString(eDataType, instanceValue);
			case OntoumlPackage.SYMMETRY:
				return convertSymmetryToString(eDataType, instanceValue);
			case OntoumlPackage.TRANSITIVITY:
				return convertTransitivityToString(eDataType, instanceValue);
			case OntoumlPackage.CICLICITY:
				return convertCiclicityToString(eDataType, instanceValue);
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
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
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
	public Literal createLiteral() {
		LiteralImpl literal = new LiteralImpl();
		return literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType createDataType() {
		DataTypeImpl dataType = new DataTypeImpl();
		return dataType;
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
	public EndPoint createEndPoint() {
		EndPointImpl endPoint = new EndPointImpl();
		return endPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relationship createRelationship() {
		RelationshipImpl relationship = new RelationshipImpl();
		return relationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveStereotype createPrimitiveStereotypeFromString(EDataType eDataType, String initialValue) {
		PrimitiveStereotype result = PrimitiveStereotype.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPrimitiveStereotypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassStereotype createClassStereotypeFromString(EDataType eDataType, String initialValue) {
		ClassStereotype result = ClassStereotype.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertClassStereotypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeStereotype createDataTypeStereotypeFromString(EDataType eDataType, String initialValue) {
		DataTypeStereotype result = DataTypeStereotype.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDataTypeStereotypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scale createScaleFromString(EDataType eDataType, String initialValue) {
		Scale result = Scale.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertScaleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measurement createMeasurementFromString(EDataType eDataType, String initialValue) {
		Measurement result = Measurement.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMeasurementToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityNature createQualityNatureFromString(EDataType eDataType, String initialValue) {
		QualityNature result = QualityNature.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertQualityNatureToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classification createClassificationFromString(EDataType eDataType, String initialValue) {
		Classification result = Classification.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertClassificationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Existence createExistenceFromString(EDataType eDataType, String initialValue) {
		Existence result = Existence.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExistenceToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationshipStereotype createRelationshipStereotypeFromString(EDataType eDataType, String initialValue) {
		RelationshipStereotype result = RelationshipStereotype.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRelationshipStereotypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemporalNature createTemporalNatureFromString(EDataType eDataType, String initialValue) {
		TemporalNature result = TemporalNature.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTemporalNatureToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParticipationNature createParticipationNatureFromString(EDataType eDataType, String initialValue) {
		ParticipationNature result = ParticipationNature.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertParticipationNatureToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reflexivity createReflexivityFromString(EDataType eDataType, String initialValue) {
		Reflexivity result = Reflexivity.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertReflexivityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Symmetry createSymmetryFromString(EDataType eDataType, String initialValue) {
		Symmetry result = Symmetry.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSymmetryToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transitivity createTransitivityFromString(EDataType eDataType, String initialValue) {
		Transitivity result = Transitivity.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTransitivityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ciclicity createCiclicityFromString(EDataType eDataType, String initialValue) {
		Ciclicity result = Ciclicity.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCiclicityToString(EDataType eDataType, Object instanceValue) {
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
