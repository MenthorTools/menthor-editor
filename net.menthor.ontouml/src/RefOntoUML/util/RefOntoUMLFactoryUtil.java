package RefOntoUML.util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import RefOntoUML.AggregationKind;
import RefOntoUML.Association;
import RefOntoUML.Category;
import RefOntoUML.Characterization;
import RefOntoUML.Class;
import RefOntoUML.Classifier;
import RefOntoUML.Collective;
import RefOntoUML.Comment;
import RefOntoUML.Constraintx;
import RefOntoUML.DataType;
import RefOntoUML.DecimalIntervalDimension;
import RefOntoUML.DecimalOrdinalDimension;
import RefOntoUML.DecimalRationalDimension;
import RefOntoUML.Derivation;
import RefOntoUML.DirectedBinaryAssociation;
import RefOntoUML.Enumeration;
import RefOntoUML.EnumerationLiteral;
import RefOntoUML.FormalAssociation;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.IntegerIntervalDimension;
import RefOntoUML.IntegerOrdinalDimension;
import RefOntoUML.IntegerRationalDimension;
import RefOntoUML.Kind;
import RefOntoUML.LiteralInteger;
import RefOntoUML.LiteralUnlimitedNatural;
import RefOntoUML.MaterialAssociation;
import RefOntoUML.MeasurementDomain;
import RefOntoUML.Mediation;
import RefOntoUML.Meronymic;
import RefOntoUML.Mixin;
import RefOntoUML.Mode;
import RefOntoUML.NamedElement;
import RefOntoUML.NominalQuality;
import RefOntoUML.NonPerceivableQuality;
import RefOntoUML.PerceivableQuality;
import RefOntoUML.Phase;
import RefOntoUML.PrimitiveType;
import RefOntoUML.Property;
import RefOntoUML.Quantity;
import RefOntoUML.RefOntoUMLFactory;
import RefOntoUML.Relationship;
import RefOntoUML.Relator;
import RefOntoUML.Role;
import RefOntoUML.RoleMixin;
import RefOntoUML.StringExpression;
import RefOntoUML.StringNominalStructure;
import RefOntoUML.Structuration;
import RefOntoUML.SubKind;
import RefOntoUML.Type;
import RefOntoUML.componentOf;
import RefOntoUML.memberOf;
import RefOntoUML.subCollectionOf;
import RefOntoUML.subQuantityOf;
import RefOntoUML.impl.AssociationImpl;
import RefOntoUML.impl.CharacterizationImpl;
import RefOntoUML.impl.DataTypeImpl;
import RefOntoUML.impl.DerivationImpl;
import RefOntoUML.impl.DirectedBinaryAssociationImpl;
import RefOntoUML.impl.FormalAssociationImpl;
import RefOntoUML.impl.GeneralizationImpl;
import RefOntoUML.impl.MaterialAssociationImpl;
import RefOntoUML.impl.MediationImpl;
import RefOntoUML.impl.MeronymicImpl;
import RefOntoUML.impl.StructurationImpl;

public class RefOntoUMLFactoryUtil {

	public static RefOntoUMLFactory factory = RefOntoUMLFactory.eINSTANCE;

	public static RefOntoUML.Package createPackage(String name)
	{
		RefOntoUML.Package p = factory.createPackage();
		if(name!=null)p.setName(name);
		else p.setName("");
		return p;
	}
	
	public static GeneralizationSet createGeneralizationSet(boolean isDisjoint, boolean isCovering, RefOntoUML.Package container) 
	{
		GeneralizationSet gs = factory.createGeneralizationSet();
		gs.setIsCovering(isCovering);
		gs.setIsDisjoint(isDisjoint);
		gs.setName("");
		if(container!=null)container.getPackagedElement().add(gs);		
		return gs;
	}
	
	public static GeneralizationSet createGeneralizationSet(List<Generalization> generalizations, boolean isDisjoint, boolean isCovering, RefOntoUML.Package container) 
	{
		GeneralizationSet gs = factory.createGeneralizationSet();
		gs.setIsCovering(isCovering);
		gs.setIsDisjoint(isDisjoint);
		gs.setName("");
		if(generalizations!=null) gs.getGeneralization().addAll(generalizations);
		for(Generalization gen: generalizations) gen.getGeneralizationSet().add(gs);
		if(container!=null)container.getPackagedElement().add(gs);
		return gs;
	}
	
	public static GeneralizationSet createGeneralizationSet(List<Generalization> generalizations, String name, boolean isDisjoint, boolean isCovering, RefOntoUML.Package container) 
	{
		GeneralizationSet gs = factory.createGeneralizationSet();
		gs.setIsCovering(isCovering);
		gs.setIsDisjoint(isDisjoint);
		if(name!=null) gs.setName(name);
		else gs.setName("");
		if(generalizations!=null) gs.getGeneralization().addAll(generalizations);
		for(Generalization gen: generalizations) gen.getGeneralizationSet().add(gs);
		if(container!=null)container.getPackagedElement().add(gs);
		return gs;
	}
	
	/** Create a generalization between specific and general types */
	public static Generalization createGeneralization (Classifier specific, Classifier general)
	{		
		Generalization g = factory.createGeneralization();		
		g.setSpecific(specific);
		g.setGeneral(general);		
		return g;
	}
	
	/** Create an association between source and target types */
	public static Association createAssociation (Classifier source, Classifier target, RefOntoUML.Package container)
	{
		Association assoc = factory.createAssociation();
		createAssociationEnds(assoc, source, target);
		if(container!=null)container.getPackagedElement().add(assoc);
		return assoc;
	}
	
	/** Create an association between source and target types */
	public static Association createAssociation (Classifier source, int srcLower, int srcUpper, String name, Classifier target, int tgtLower, int tgtUpper, RefOntoUML.Package container)
	{
		Association assoc = factory.createAssociation();
		List<Property> ends = createAssociationEnds(assoc, source, target);
		setMultiplicity(ends.get(0), srcLower, srcUpper);
		setMultiplicity(ends.get(1), tgtLower, tgtUpper);
		if(name!=null) assoc.setName(name);
		else assoc.setName("");
		if(container!=null)container.getPackagedElement().add(assoc);
		return assoc;
	}
	
	/** Create a material association between source and target types */
	public static MaterialAssociation createMaterialAssociation (Classifier source, Classifier target, RefOntoUML.Package container){
		MaterialAssociation material = factory.createMaterialAssociation();
		createAssociationEnds(material, source, target);
		material.setIsDerived(true);
		if(container!=null)container.getPackagedElement().add(material);
		return material;
	}
	
	/** Create a material association between source and target types */
	public static MaterialAssociation createMaterialAssociation (Classifier source, int srcLower, int srcUpper, String name, Classifier target, int tgtLower, int tgtUpper, RefOntoUML.Package container)
	{
		MaterialAssociation material = factory.createMaterialAssociation();
		List<Property> ends = createAssociationEnds(material, source, target);
		setMultiplicity(ends.get(0), srcLower, srcUpper);
		setMultiplicity(ends.get(1), tgtLower, tgtUpper);
		if(name!=null) material.setName(name);
		else material.setName("");
		if(container!=null)container.getPackagedElement().add(material);
		return material;
	}
	
	/** Create a formal association between source and target types */
	public static FormalAssociation createFormalAssociation (Classifier source, Classifier target, RefOntoUML.Package container)
	{
		FormalAssociation formal = factory.createFormalAssociation();
		createAssociationEnds(formal, source, target);
		if(container!=null)container.getPackagedElement().add(formal);
		return formal;
	}

	/** Create a formal association between source and target types */
	public static FormalAssociation createFormalAssociation (Classifier source, int srcLower, int srcUpper, String name, Classifier target, int tgtLower, int tgtUpper, RefOntoUML.Package container)
	{
		FormalAssociation formal = factory.createFormalAssociation();
		List<Property> ends = createAssociationEnds(formal, source, target);
		setMultiplicity(ends.get(0), srcLower, srcUpper);
		setMultiplicity(ends.get(1), tgtLower, tgtUpper);
		if(name!=null) formal.setName(name);
		else formal.setName("");
		if(container!=null)container.getPackagedElement().add(formal);
		return formal;
	}
		
	/** Create a mediation between source and target types */
	public static Mediation createMediation (Classifier source, Classifier target, RefOntoUML.Package container)
	{
		Mediation mediation = factory.createMediation();		
		if(target instanceof Relator && !(source instanceof Relator)) createAssociationEnds(mediation, target, source);
		else createAssociationEnds(mediation, source, target);		
		if(container!=null)container.getPackagedElement().add(mediation);
		return mediation;
	}

	/** Create a mediation between source and target types */
	public static Mediation createMediation (Classifier source, int srcLower, int srcUpper, String name, Classifier target, int tgtLower, int tgtUpper, RefOntoUML.Package container)
	{
		Mediation mediation = factory.createMediation();
		List<Property> ends = null;		
		if(target instanceof Relator && !(source instanceof Relator)) ends = createAssociationEnds(mediation, target, source);
		else ends = createAssociationEnds(mediation, source, target);		
		setMultiplicity(ends.get(0), srcLower, srcUpper);		
		setMultiplicity(ends.get(1), tgtLower, tgtUpper);		
		if(name!=null) mediation.setName(name);
		else mediation.setName("");
		if(container!=null)container.getPackagedElement().add(mediation);
		return mediation;
	}
	
	public static Characterization createCharacterization (String name, RefOntoUML.Package container)
	{
		Characterization c = createCharacterization(null, null, container);
		c.setName(name);
		return c;
	}
	
	public static FormalAssociation createFormalAssociation (String name, RefOntoUML.Package container)
	{
		FormalAssociation c = createFormalAssociation(null, null, container);
		c.setName(name);
		return c;
	}
	
	public static MaterialAssociation createMaterialAssociation (String name, RefOntoUML.Package container)
	{
		MaterialAssociation c = createMaterialAssociation(null, null, container);
		c.setName(name);
		return c;
	}
	
	public static Mediation createMediation (String name, RefOntoUML.Package container)
	{
		Mediation c = createMediation(null, null, container);
		c.setName(name);
		return c;
	}
	
	public static memberOf createMemberOf (String name, RefOntoUML.Package container)
	{
		memberOf c = createMemberOf(null, null, container);
		c.setName(name);
		return c;
	}
	
	public static subQuantityOf createSubQuantityOf (String name, RefOntoUML.Package container)
	{
		subQuantityOf c = createSubQuantityOf(null, null, container);
		c.setName(name);
		return c;
	}
	
	public static subCollectionOf createSubCollectionOf (String name, RefOntoUML.Package container)
	{
		subCollectionOf c = createSubCollectionOf(null, null, container);
		c.setName(name);
		return c;
	}
	
	public static componentOf createComponentOf (String name, RefOntoUML.Package container)
	{
		componentOf c = createComponentOf(null, null, container);
		c.setName(name);
		return c;
	}
		
	public static Derivation createDerivation (String name, RefOntoUML.Package container)
	{
		Derivation c = createDerivation(null, null, container);
		c.setName(name);
		return c;
	}
	
	public static Structuration createStructuration (String name, RefOntoUML.Package container)
	{
		Structuration c = createStructuration(null, null, container);
		c.setName(name);
		return c;
	}
	
	public static Association createAssociation (String name, RefOntoUML.Package container)
	{
		Association c = createAssociation(null, null, container);
		c.setName(name);
		return c;
	}
	
	/** Create a characterization between source and target types */
	public static Characterization createCharacterization (Classifier source, Classifier target, RefOntoUML.Package container)
	{
		Characterization characterization = factory.createCharacterization();		
		if(target instanceof Mode && !(source instanceof Mode)) createAssociationEnds(characterization, target, source);
		else createAssociationEnds(characterization, source, target);	
		if(container!=null)container.getPackagedElement().add(characterization);
		return characterization;
	}
	
	/** Create a characterization between source and target types */
	public static Characterization createCharacterization (Classifier source, int srcLower, int srcUpper, String name, Classifier target, int tgtLower, int tgtUpper, RefOntoUML.Package container)
	{
		Characterization characterization = factory.createCharacterization();
		List<Property> ends = null;				
		if(target instanceof Mode && !(source instanceof Mode)) ends = createAssociationEnds(characterization, target, source);
		else ends = createAssociationEnds(characterization, source, target);
		setMultiplicity(ends.get(0), srcLower, srcUpper);
		setMultiplicity(ends.get(1), tgtLower, tgtUpper);	
		if(name!=null) characterization.setName(name);
		else characterization.setName("");
		if(container!=null)container.getPackagedElement().add(characterization);
		return characterization;
	}
	
	/** Create a componentOf between whole and part types */
	public static componentOf createComponentOf (Classifier whole, Classifier part, RefOntoUML.Package container)
	{
		componentOf compOf = factory.createcomponentOf();
		createAssociationEnds(compOf, whole, part);		
		compOf.setIsShareable(true);
		if(container!=null)container.getPackagedElement().add(compOf);
		return compOf;
	}
	
	/** Create a componentOf between whole and part types */
	public static componentOf createComponentOf (Classifier whole, int wholeLower, int wholeUpper, String name, Classifier part, int partLower, int partUpper, RefOntoUML.Package container)
	{
		componentOf compOf = factory.createcomponentOf();
		List<Property> ends = createAssociationEnds(compOf, whole, part);		
		setMultiplicity(ends.get(0), wholeLower, wholeUpper);
		setMultiplicity(ends.get(1), partLower, partUpper);
		if(name!=null) compOf.setName(name);
		else compOf.setName("");
		if(container!=null)container.getPackagedElement().add(compOf);
		return compOf;
	}
	
	/** Create a memberOf between whole and part types */
	public static memberOf createMemberOf (Classifier whole, Classifier part, RefOntoUML.Package container)
	{
		memberOf membOf = factory.creatememberOf();
		createAssociationEnds(membOf, whole, part);
		membOf.setIsShareable(true);
		if(container!=null)container.getPackagedElement().add(membOf);
		return membOf;
	}
	
	/** Create a memberOf between whole and part types */
	public static memberOf createMemberOf (Classifier whole, int wholeLower, int wholeUpper, String name, Classifier part, int partLower, int partUpper, RefOntoUML.Package container)
	{
		memberOf membOf = factory.creatememberOf();
		List<Property> ends = createAssociationEnds(membOf, whole, part);		
		setMultiplicity(ends.get(0), wholeLower, wholeUpper);
		setMultiplicity(ends.get(1), partLower, partUpper);	
		if(name!=null) membOf.setName(name);
		else membOf.setName("");
		if(container!=null)container.getPackagedElement().add(membOf);
		return membOf;
	}
	
	/** Create a subCollectionOf between whole and part types */
	public static subCollectionOf createSubCollectionOf (Classifier whole, Classifier part, RefOntoUML.Package container)
	{
		subCollectionOf subColl = factory.createsubCollectionOf();
		createAssociationEnds(subColl, whole, part);
		subColl.setIsShareable(true);
		if(container!=null)container.getPackagedElement().add(subColl);
		return subColl;
	}
			
	/** Create a subCollectionOf between whole and part types */
	public static subCollectionOf createSubCollectionOf (Classifier whole, int wholeLower, int wholeUpper, String name, Classifier part, int partLower, int partUpper, RefOntoUML.Package container)
	{
		subCollectionOf subColl = factory.createsubCollectionOf();
		List<Property> ends = createAssociationEnds(subColl, whole, part);		
		setMultiplicity(ends.get(0), wholeLower, wholeUpper);
		setMultiplicity(ends.get(1), partLower, partUpper);
		if(name!=null) subColl.setName(name);
		else subColl.setName("");
		if(container!=null)container.getPackagedElement().add(subColl);
		return subColl;
	}
	
	/** Create a subQuantityOf between whole and part types */
	public static subQuantityOf createSubQuantityOf (Classifier whole, Classifier part, RefOntoUML.Package container)
	{
		subQuantityOf subQuan = factory.createsubQuantityOf();
		createAssociationEnds(subQuan, whole, part);		
		if(part instanceof Role || part instanceof Phase || part instanceof RoleMixin) subQuan.setIsEssential(false);
		else subQuan.setIsEssential(true);		
		subQuan.setIsImmutablePart(true);
		subQuan.setIsInseparable(false);
		subQuan.setIsShareable(false);
		if(container!=null)container.getPackagedElement().add(subQuan);
		return subQuan;
	}
	
	/** Create a subQuantityOf between whole and part types */
	public static subQuantityOf createSubQuantityOf (Classifier whole, int wholeLower, int wholeUpper, String name, Classifier part, int partLower, int partUpper, RefOntoUML.Package container)
	{
		subQuantityOf subQuan = factory.createsubQuantityOf();
		List<Property> ends = createAssociationEnds(subQuan, whole, part);		
		if(part instanceof Role || part instanceof Phase || part instanceof RoleMixin) subQuan.setIsEssential(false);
		else subQuan.setIsEssential(true);		
		subQuan.setIsImmutablePart(true);
		subQuan.setIsInseparable(false);
		setMultiplicity(ends.get(0), wholeLower, wholeUpper);
		setMultiplicity(ends.get(1), partLower, partUpper);		
		if(name!=null) subQuan.setName(name);
		else subQuan.setName("");
		if(container!=null)container.getPackagedElement().add(subQuan);
		return subQuan;
	}
	
	/** Create a derivation relationship between source and target types */
	public static Derivation createDerivation (Association source, Classifier target, RefOntoUML.Package container)
	{
		Derivation derivation = factory.createDerivation();
		createAssociationEnds(derivation,source,target);
		if(container!=null)container.getPackagedElement().add(derivation);
		if(source!=null) source.setIsDerived(true);
		return derivation;
	}

	/** Create a derivation relationship between source and target types */
	public static Derivation createDerivation (Association source, int srcLower, int srcUpper, String name, Classifier target,int tgtLower, int tgtUpper, RefOntoUML.Package container)
	{
		Derivation derivation = factory.createDerivation();
		List<Property> ends = createAssociationEnds(derivation,source,target);
		setMultiplicity(ends.get(0), srcLower, srcUpper);
		setMultiplicity(ends.get(1), tgtLower, tgtUpper);	
		if(name!=null) derivation.setName(name);
		else derivation.setName("");
		if(container!=null)container.getPackagedElement().add(derivation);
		if(source!=null) source.setIsDerived(true);
		return derivation;
	}

	/** Create a structuration relationship between source and target types */
	public static Structuration createStructuration (Classifier source, Classifier target, RefOntoUML.Package container)
	{
		Structuration structuration = factory.createStructuration();
		createAssociationEnds(structuration,source,target);
		if(container!=null)container.getPackagedElement().add(structuration);
		return structuration;
	}
	
	/** Create a structuration relationship between source and target types */
	public static Structuration createStructuration (Classifier source, int srcLower, int srcUpper, String name, Classifier target,int tgtLower, int tgtUpper, RefOntoUML.Package container)
	{
		Structuration structuration = factory.createStructuration();
		List<Property> ends = createAssociationEnds(structuration,source,target);
		setMultiplicity(ends.get(0), srcLower, srcUpper);
		setMultiplicity(ends.get(1), tgtLower, tgtUpper);
		if(name!=null) structuration.setName(name);
		else structuration.setName("");
		if(container!=null)container.getPackagedElement().add(structuration);
		return structuration;
	}
	
	/** Create a class without stereotype  */
	public static Class createClass(String name, RefOntoUML.Package container)
	{
		Class _class = factory.createClass();
		setName(name, _class);
		if(container!=null)container.getPackagedElement().add(_class);
		return _class;
	}

	private static void setName(String name, NamedElement named) {
		if(name!=null) named.setName(name);
		else named.setName("");
	}
	
	/** Create a kind type  */
	public static Kind createKind(String name, RefOntoUML.Package container)
	{
		Kind kind = factory.createKind();
		setName(name, kind);
		if(container!=null)container.getPackagedElement().add(kind);
		return kind;
	}
	
	/** Create a subkind type  */
	public static SubKind createSubKind(String name, RefOntoUML.Package container)
	{
		SubKind subkind = factory.createSubKind();
		setName(name, subkind);
		if(container!=null)container.getPackagedElement().add(subkind);
		return subkind;
	}
	
	/** Create a collective type  */
	public static Collective createCollective(String name, RefOntoUML.Package container)
	{
		Collective collective = factory.createCollective();
		setName(name, collective);
		if(container!=null)container.getPackagedElement().add(collective);
		return collective;
	}
	
	/** Create a comment type  */
	public static Comment createComment(String text, RefOntoUML.Classifier container)
	{
		Comment comment = factory.createComment();
		if(text!=null) comment.setBody(text);
		if(container!=null)container.getOwnedComment().add(comment);
		return comment;
	}
	
	public static Constraintx createConstraint(String name, String expression, RefOntoUML.Package container){
		  Constraintx c = factory.createConstraintx();
		  c.setName(name);
		  StringExpression expr = RefOntoUMLFactoryUtil.factory.createStringExpression();
		  expr.setSymbol(expression);
		  c.setSpecification(expr);
		  if(container!=null)container.getPackagedElement().add(c);
		  return c;
	}
	
	/** Create a quantity type  */
	public static Quantity createQuantity(String name, RefOntoUML.Package container)
	{
		Quantity quantity = factory.createQuantity();
		setName(name,quantity);
		if(container!=null)container.getPackagedElement().add(quantity);
		return quantity;
	}
	
	/** Create a role type  */
	public static Role createRole(String name, RefOntoUML.Package container)
	{
		Role role = factory.createRole();
		setName(name,role);
		if(container!=null)container.getPackagedElement().add(role);
		return role;
	}
	
	/** Create a relator type  */
	public static Relator createRelator(String name, RefOntoUML.Package container)
	{
		Relator relator = factory.createRelator();
		setName(name,relator);
		if(container!=null)container.getPackagedElement().add(relator);
		return relator;
	}
	
	/** Create a partition. */
	public static GeneralizationSet createPartition(String name, List<Classifier> specifics, Classifier general, RefOntoUML.Package container)
	{
		List<Generalization> gens = new ArrayList<Generalization>();
		for(Classifier c: specifics) gens.add(createGeneralization(c, general));
		GeneralizationSet gs = createGeneralizationSet(gens,true,true,container);
		if(name!=null)gs.setName(name);
		else gs.setName("");
		return gs;
	}
	
	/** Create a mode type  */
	public static Mode createMode(String name, RefOntoUML.Package container)
	{
		Mode mode = factory.createMode();
		setName(name,mode);
		if(container!=null)container.getPackagedElement().add(mode);
		return mode;
	}
	
	/** Create a phase type  */
	public static Phase createPhase(String name, RefOntoUML.Package container)
	{
		Phase phase = factory.createPhase();
		setName(name,phase);
		if(container!=null)container.getPackagedElement().add(phase);
		return phase;
	}
	
	/** Create a category type  */
	public static Category createCategory(String name, RefOntoUML.Package container)
	{
		Category category = factory.createCategory();
		setName(name,category);
		category.setIsAbstract(true);
		if(container!=null)container.getPackagedElement().add(category);
		return category;
	}
	
	/** Create a mixin type  */
	public static Mixin createMixin(String name, RefOntoUML.Package container)
	{
		Mixin mixin = factory.createMixin();
		setName(name,mixin);
		mixin.setIsAbstract(true);
		if(container!=null)container.getPackagedElement().add(mixin);
		return mixin;
	}
	
	/** Create a role mixin type  */
	public static RoleMixin createRoleMixin(String name, RefOntoUML.Package container)
	{
		RoleMixin rolemixin = factory.createRoleMixin();
		setName(name,rolemixin);
		rolemixin.setIsAbstract(true);
		if(container!=null)container.getPackagedElement().add(rolemixin);
		return rolemixin;
	}
	
	/** Create a perceivable quality type  */
	public static PerceivableQuality createPerceivableQuality(String name, RefOntoUML.Package container)
	{
		PerceivableQuality quality = factory.createPerceivableQuality();
		setName(name,quality);	
		if(container!=null)container.getPackagedElement().add(quality);
		return quality;
	}
	
	/** Create a nonperceivable quality type  */
	public static NonPerceivableQuality createNonPerceivableQuality(String name, RefOntoUML.Package container)
	{
		NonPerceivableQuality quality = factory.createNonPerceivableQuality();
		setName(name,quality);		
		if(container!=null)container.getPackagedElement().add(quality);
		return quality;
	}
	
	/** Create a nominal quality type  */
	public static NominalQuality createNominalQuality(String name, RefOntoUML.Package container)
	{
		NominalQuality quality = factory.createNominalQuality();
		setName(name,quality);		
		if(container!=null)container.getPackagedElement().add(quality);
		return quality;
	}
	
	/** Create a primitive type  */
	public static PrimitiveType createPrimitiveType(String name, RefOntoUML.Package container)
	{
		PrimitiveType primitive = factory.createPrimitiveType();
		setName(name,primitive);		
		if(container!=null)container.getPackagedElement().add(primitive);
		return primitive;
	}
	
	public static StringNominalStructure createStringNominalStructure(String name, RefOntoUML.Package container)
	{
		StringNominalStructure primitive = factory.createStringNominalStructure();
		setName(name,primitive);	
		if(container!=null)container.getPackagedElement().add(primitive);
		return primitive;
	}
	
	public static DecimalIntervalDimension createDecimalIntervalDimension(String name, RefOntoUML.Package container)
	{
		DecimalIntervalDimension primitive = factory.createDecimalIntervalDimension();
		setName(name,primitive);		
		if(container!=null)container.getPackagedElement().add(primitive);
		return primitive;
	}
	
	public static DecimalOrdinalDimension createDecimalOrdinalDimension(String name, RefOntoUML.Package container)
	{
		DecimalOrdinalDimension primitive = factory.createDecimalOrdinalDimension();
		setName(name,primitive);	
		if(container!=null)container.getPackagedElement().add(primitive);
		return primitive;
	}
	
	public static DecimalRationalDimension createDecimalRationalDimension(String name, RefOntoUML.Package container)
	{
		DecimalRationalDimension primitive = factory.createDecimalRationalDimension();
		setName(name,primitive);
		if(container!=null)container.getPackagedElement().add(primitive);
		return primitive;
	}
	
	public static MeasurementDomain createMeasurementDomain(String name, RefOntoUML.Package container)
	{
		MeasurementDomain primitive = factory.createMeasurementDomain();
		setName(name,primitive);	
		if(container!=null)container.getPackagedElement().add(primitive);
		return primitive;
	}
	
	public static IntegerIntervalDimension createIntegerIntervalDimension(String name, RefOntoUML.Package container)
	{
		IntegerIntervalDimension primitive = factory.createIntegerIntervalDimension();
		setName(name,primitive);
		if(container!=null)container.getPackagedElement().add(primitive);
		return primitive;
	}
	
	public static IntegerOrdinalDimension createIntegerOrdinalDimension(String name, RefOntoUML.Package container)
	{
		IntegerOrdinalDimension primitive = factory.createIntegerOrdinalDimension();
		setName(name,primitive);
		if(container!=null)container.getPackagedElement().add(primitive);
		return primitive;
	}
	
	public static IntegerRationalDimension createIntegerRationalDimension(String name, RefOntoUML.Package container)
	{
		IntegerRationalDimension primitive = factory.createIntegerRationalDimension();
		setName(name,primitive);
		if(container!=null)container.getPackagedElement().add(primitive);
		return primitive;
	}
	
	/** Create a data type  */
	public static DataType createDataType(String name, RefOntoUML.Package container)
	{
		DataType datatype = factory.createDataType();
		setName(name,datatype);	
		if(container!=null)container.getPackagedElement().add(datatype);
		return datatype;
	}	
	
	/** Create a enumeration type  */
	public static Enumeration createEnumeration(String name, Collection<String> values, RefOntoUML.Package container)
	{
		Enumeration datatype = factory.createEnumeration();
		setName(name,datatype);
		for(String literalName: values)
		{
			EnumerationLiteral literal = factory.createEnumerationLiteral();
			literal.setName(literalName);
			datatype.getOwnedLiteral().add(literal);
		}		
		if(container!=null)container.getPackagedElement().add(datatype);
		return datatype;
	}	

	/**
	 * Create an attribute of this given type to this classifier.
	 * Multiplicities are by default 1..1. This is not a derived nor a read only attribute.
	 */
	public static void createAttribute (Classifier classifier, Type type)
	{
		Property attribute = createProperty((Classifier)type, 1, 1, null, false, false, AggregationKind.NONE);
		addAttribute(classifier,attribute);
	}
	
	/** Create this attribute to this association */
	public static void createAttribute (Classifier classifier, Type type, int lower, int upper)
	{
		Property attribute = createProperty((Classifier)type, lower, upper, null, false, false, AggregationKind.NONE);
		addAttribute(classifier,attribute);
	}
		
	/** Create an attribute to this classifier. */
	public static void createAttribute (Classifier classifier, Type type, int lower, int upper, String name, boolean isDerived, boolean isReadOnly, AggregationKind aggreggation)
	{		
		Property attribute = createProperty((Classifier)type, lower, upper, name, isDerived, isReadOnly, aggreggation);
		addAttribute(classifier, attribute);
	}

	/** Create an attribute to this classifier. */
	public static void createAttribute (Classifier classifier, Type type, int lower, int upper, String name, boolean isDerived)
	{		
		Property attribute = createProperty((Classifier)type, lower, upper, name, isDerived, false, AggregationKind.NONE);
		addAttribute(classifier, attribute);
	}
	
	/**
	 * Create a property i.e. an attribute or association end-point. 
	 * with a default name which is the classifier name in lower case 
	 */
	public static Property createProperty(Classifier classifier, int lower, int upper) 
	{
		Property property = factory.createProperty();
		property.setType(classifier);
		LiteralInteger lowerBound = factory.createLiteralInteger();
		lowerBound.setValue(lower);
		LiteralUnlimitedNatural upperBound = factory.createLiteralUnlimitedNatural();
		upperBound.setValue(upper);
		property.setLowerValue(lowerBound);
		property.setUpperValue(upperBound);
		if(classifier!=null && classifier.getName()!=null) property.setName(classifier.getName().trim().toLowerCase());
		else property.setName("");
		return property;
	}

	/** Create a property i.e. an attribute or association end-point. */
	public static Property createProperty(Classifier classifier, int lower, int upper, String name) 
	{
		Property p = createProperty(classifier, lower, upper);
		if(classifier !=null && classifier.getName()!=null && name==null) p.setName(classifier.getName().trim().toLowerCase());
		else if(name!=null) p.setName(name);
		return p;
	}
	
	/** Create a property i.e. an attribute or association end-point. */
	public static Property createProperty(Classifier classifier, int lower, int upper, String name, boolean isDerived, boolean isReadOnly, AggregationKind aggregation)
	{
		Property p = createProperty(classifier, lower, upper, name);
		p.setIsDerived(isDerived);
		p.setIsReadOnly(isReadOnly);        
		if(aggregation==null) aggregation = AggregationKind.NONE;		
		p.setAggregation(aggregation);
		return p;

	}
	
	/** Add this attribute to this classifier */
	private static void addAttribute(Classifier classifier, Property attribute)
	{	
		if (classifier instanceof Class) {
			Class c = (Class) classifier; 
			c.getOwnedAttribute().add(attribute);
		} else if (classifier instanceof DataType) {
			DataType dt = (DataType) classifier;
			dt.getOwnedAttribute().add(attribute);
		}
	}
	
	/** Add the association ends to this association */
	private static void addAssociationEnds(Association association, Property srcProperty, Property tgtProperty) 
	{
		association.getOwnedEnd().add(srcProperty);
		association.getOwnedEnd().add(tgtProperty);
		association.getMemberEnd().add(srcProperty);
		association.getMemberEnd().add(tgtProperty);
		if(association instanceof DirectedBinaryAssociation || association instanceof FormalAssociation || association instanceof MaterialAssociation){
			association.getNavigableOwnedEnd().add(srcProperty);
			association.getNavigableOwnedEnd().add(tgtProperty);
		}else{
			if (srcProperty.getType() instanceof DataType) association.getNavigableOwnedEnd().add(srcProperty);
			if (tgtProperty.getType() instanceof DataType) association.getNavigableOwnedEnd().add(tgtProperty);
		}
	}
	
	/**
	 * Add association end-points from and to these given types in this association.
	 * Multiplicites are 1..1 except for componentOfs which are created by default with 2..*.
	 * Characterization, mediations and derivations are read only at the target side.
	 * Meronymics aggregation kind are shared if they are shareable, otherwise they are composite.
	 */
	private static List<Property> createAssociationEnds(Association association, Classifier source, Classifier target)
	{
		List<Property> properties = addAssociationEnds(association);
		properties.get(0).setType(source);
		properties.get(1).setType(target);
		if(source!=null && source.getName()!=null) properties.get(0).setName(source.getName().trim().toLowerCase());
		if(target!=null && target.getName()!=null) properties.get(1).setName(target.getName().trim().toLowerCase());
		return properties;
	}
	
	/**
	 * Create default association end-points for this association.
	 * Multiplicites are 1..1 except for componentOfs which are created by default with 2..*.
	 * Characterization, mediations and derivations are read only at the target side.
	 * Meronymics aggregation kind are shared if they are shareable, otherwise they are composite. 
	 */
	private static List<Property> addAssociationEnds(Association association) 
	{
		List<Property> properties = new ArrayList<Property>();
		Property node1Property, node2Property;
		//multiplicity		
		node1Property = createProperty(null, 1, 1);
		if (association instanceof componentOf) node2Property = createProperty(null, 2, -1);
		else node2Property = createProperty(null, 1, 1);
		//readOnly
		if (association instanceof Mediation || association instanceof Structuration || association instanceof Characterization	|| association instanceof Derivation){
			node2Property.setIsReadOnly(true);
		}
		//aggregationKind
		if (association instanceof Meronymic){
			if (((Meronymic) association).isIsShareable()) node1Property.setAggregation(AggregationKind.SHARED);
			else node1Property.setAggregation(AggregationKind.COMPOSITE);
		}
		//name
		String node1Name = new String();
		if (node1Property.getType() != null){
			node1Name = node1Property.getType().getName();
			if (node1Name == null || node1Name.trim().isEmpty()) node1Name = "source";
			else node1Name = node1Name.trim().toLowerCase();
		}
		node1Property.setName(node1Name);
		String node2Name = new String();
		if (node2Property.getType() != null){
			node2Name = node2Property.getType().getName();
			if (node2Name == null || node2Name.trim().isEmpty()) node2Name = "target";
			else node2Name = node2Name.trim().toLowerCase();
		}		
		node2Property.setName(node2Name);
		//ends
		addAssociationEnds(association, node1Property, node2Property);
		properties.add(node1Property);
		properties.add(node2Property);
		return properties;
	}
	
	/** Set multiplicity of a association end-point or attribute */
	public static void setMultiplicity(Property property, int lower, int upper)
	{
		LiteralInteger lowerBound = factory.createLiteralInteger();
		lowerBound.setValue(lower);
		LiteralUnlimitedNatural upperBound = factory.createLiteralUnlimitedNatural();
		upperBound.setValue(upper);
		property.setLowerValue(lowerBound);
		property.setUpperValue(upperBound);	
	}
		
	
	/** Get multiplicity string representation from a property */
	public static String getMultiplicityAsString(Property property) 
	{
		int lowerBound = property.getLower(), upperBound = property.getUpper();
		if (upperBound == -1) return lowerBound == 0 ? "*" : lowerBound + "..*";
		if (lowerBound == upperBound) return String.valueOf(lowerBound);
		return lowerBound + ".." + upperBound;
	}
	
	public static void setMultiplicityFromString(Property property, String str) throws ParseException 
	{		
		LiteralInteger lowerBound = factory.createLiteralInteger();
		LiteralUnlimitedNatural upperBound = factory.createLiteralUnlimitedNatural();
		// 1..2, 1, N, *, 4..1, 1..1, 1..*, 0..*
		Pattern pattern = Pattern.compile("\\d+|\\*|\\d+\\.\\.(\\d+|\\*)");
		if (pattern.matcher(str).matches()) { 
			int lowerValue = 0, upperValue = 0;
			if (!str.contains("..")) {
				// Multiplicities: 1, N
				if(!str.contains("*")){
					lowerValue = Integer.valueOf(str);
					upperValue = lowerValue;
				}
				// Multiplicities: *
				else{
					lowerValue = 0;
					upperValue = -1;
				}
			}
			//1..2, 4..1, 1..1, 1..*, 0..*
			else{
				String[] comps = str.split("\\.\\.");
				 // Multiplicities: 1..3, 0..2, 3..1
				if(!str.contains("*")){
					if(comps[0] == comps[1]){
						lowerValue = Integer.valueOf(str);
						upperValue = lowerValue;
					}else{
						lowerValue = Integer.valueOf(comps[0]);
						upperValue = Integer.valueOf(comps[1]);						
						if(lowerValue > upperValue)
							throw new ParseException("could not parse '" + str + "'", 0);
					}
				}
				// Multiplicities: 1..*, 0..*
				else {
					lowerValue = Integer.valueOf(comps[0]);
					upperValue = -1;
				}
			}
			lowerBound.setValue(lowerValue);
			upperBound.setValue(upperValue);
		}else{
			throw new ParseException("could not parse multiplicity string: '" + str + "'", 0);
		}
		if (property != null) {
			property.setLowerValue(lowerBound);
			property.setUpperValue(upperBound);
		}
	}
	
	public static Classifier clone(Classifier c){
		Classifier cloned = (Classifier) factory.create(c.eClass());
		return clone(cloned, c);
	}
	
	public static Classifier clone(Classifier cloned, Classifier classifier) 
	{		
		cloned.setName(classifier.getName());
		cloned.setIsAbstract(classifier.isIsAbstract());
		cloned.setVisibility(classifier.getVisibility());		
		if(cloned instanceof RefOntoUML.Class){
			RefOntoUML.Class clonedClass = (RefOntoUML.Class)cloned;			
			RefOntoUML.Class classifierClass = (RefOntoUML.Class)classifier;			
			for(Property p: classifierClass.getOwnedAttribute()){
				RefOntoUML.Property clonedAttr = RefOntoUMLFactoryUtil.clone(p);
				clonedClass.getOwnedAttribute().add(clonedAttr);
			}
			return clonedClass;
		}
		if(cloned instanceof RefOntoUML.DataType){
			RefOntoUML.DataType clonedClass = (RefOntoUML.DataType)cloned;
			RefOntoUML.DataType classifierClass = (RefOntoUML.DataType)classifier;			
			for(Property p: classifierClass.getOwnedAttribute()){
				RefOntoUML.Property clonedAttr = RefOntoUMLFactoryUtil.clone(p);
				clonedClass.getOwnedAttribute().add(clonedAttr);
			}
			return clonedClass;
		}			
		return cloned;
	}
		
	public static Property clone(RefOntoUML.Property property)
	{
		RefOntoUML.Property cloned = (RefOntoUML.Property)factory.create(property.eClass());
		cloned.setAggregation(property.getAggregation());				
		cloned.setType(property.getType());
		LiteralInteger lower1Cloned = factory.createLiteralInteger();
		lower1Cloned.setValue(property.getLower());
		LiteralUnlimitedNatural upper1Cloned = factory.createLiteralUnlimitedNatural();
		upper1Cloned.setValue(property.getUpper());		
		cloned.setLowerValue(lower1Cloned);			
		cloned.setUpperValue(upper1Cloned);		
		String node1Name  = property.getName();		
		if(node1Name==null || node1Name.isEmpty()){
			if(property.getType()!=null){
				node1Name = property.getType().getName();	    		
				if(node1Name==null || node1Name.trim().isEmpty()) node1Name = "";
				else node1Name = node1Name.trim().toLowerCase();
			}
		}
		cloned.setName(node1Name);
		return cloned;
	}
	
	public static Relationship cloneRelationship(Relationship relationship){
		Relationship cloned = (Relationship) factory.create(relationship.eClass());
		return cloneRelationship(cloned, relationship);
	}
	
	public static Relationship cloneRelationship(Relationship cloned, Relationship relationship) 
	{			
		if(cloned instanceof GeneralizationImpl){
			Generalization generalization = (Generalization) relationship;			
			((Generalization)cloned).getGeneralizationSet().addAll(generalization.getGeneralizationSet());
			((Generalization)cloned).setGeneral(generalization.getGeneral());
			((Generalization)cloned).setSpecific(generalization.getSpecific());
		}		
		if(cloned instanceof AssociationImpl){
			Association association = (Association) relationship;
			Association associationCloned = (Association) cloned;			
			associationCloned.setName(association.getName());
			associationCloned.setIsAbstract(association.isIsAbstract());
			associationCloned.setVisibility(association.getVisibility());
			associationCloned.setIsDerived(association.isIsDerived());			
			if(cloned instanceof MeronymicImpl){
				Meronymic meronymic = (Meronymic) relationship; 
				Meronymic meronymicCloned = (Meronymic) cloned;				
				meronymicCloned.setIsShareable(meronymic.isIsShareable());
				meronymicCloned.setIsEssential(meronymic.isIsEssential());
				meronymicCloned.setIsInseparable(meronymic.isIsInseparable());
				meronymicCloned.setIsImmutableWhole(meronymic.isIsImmutableWhole());
				meronymicCloned.setIsImmutablePart(meronymic.isIsImmutablePart());				
			}			
			RefOntoUML.Property p1Cloned = RefOntoUMLFactoryUtil.clone(association.getMemberEnd().get(0));
			RefOntoUML.Property p2Cloned = RefOntoUMLFactoryUtil.clone(association.getMemberEnd().get(1));			
			associationCloned.getMemberEnd().add(p1Cloned);
			associationCloned.getMemberEnd().add(p2Cloned);
			associationCloned.getOwnedEnd().add(p1Cloned);
			associationCloned.getOwnedEnd().add(p2Cloned);			
			if(association instanceof DirectedBinaryAssociationImpl || association instanceof FormalAssociationImpl || association instanceof MaterialAssociationImpl){
				associationCloned.getNavigableOwnedEnd().add(p1Cloned);
				associationCloned.getNavigableOwnedEnd().add(p2Cloned);	    			
				if(association instanceof MediationImpl || association instanceof CharacterizationImpl || 
				association instanceof DerivationImpl || association instanceof StructurationImpl) p2Cloned.setIsReadOnly(true);
			} else {
				if(p1Cloned.getType() instanceof DataTypeImpl) associationCloned.getNavigableOwnedEnd().add(p1Cloned);	    		
				if(p2Cloned.getType() instanceof DataTypeImpl) associationCloned.getNavigableOwnedEnd().add(p2Cloned);
			}	
		}						
		return cloned;
	}

	public static LiteralUnlimitedNatural createLiteralUnlimitedNatural() {
		return factory.createLiteralUnlimitedNatural();	
	}

	public static LiteralInteger createLiteralInteger() {
		return factory.createLiteralInteger();
	}	  
}
