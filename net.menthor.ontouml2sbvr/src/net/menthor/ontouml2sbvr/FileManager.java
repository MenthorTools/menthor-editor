package net.menthor.ontouml2sbvr;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import RefOntoUML.AntiRigidMixinClass;
import RefOntoUML.AntiRigidSortalClass;
import RefOntoUML.Association;
import RefOntoUML.Characterization;
import RefOntoUML.Class;
import RefOntoUML.Classifier;
import RefOntoUML.DataType;
import RefOntoUML.DependencyRelationship;
import RefOntoUML.Derivation;
import RefOntoUML.FormalAssociation;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.MaterialAssociation;
import RefOntoUML.Mediation;
import RefOntoUML.Meronymic;
import RefOntoUML.MultiplicityElement;
import RefOntoUML.Property;
import RefOntoUML.Relator;
import RefOntoUML.SemiRigidMixinClass;
import RefOntoUML.SubstanceSortal;
import RefOntoUML.componentOf;
import RefOntoUML.memberOf;
import RefOntoUML.subCollectionOf;
import RefOntoUML.subQuantityOf;

public class FileManager
{
	Writer output;
	HtmlHelper myhelper;
	
	boolean serial;
	Collection<Classifier> done;
	
	public FileManager (File sourceFile)
	{
		myhelper = new HtmlHelper();
		
		try
		{
			String name = sourceFile.getName().replace(".refontouml", "");
			
			File f1 = new File(sourceFile.getAbsolutePath());
												
			// Create a folder
			File folder = new File(f1.getParent());
						
			// Create the html file
			File f2 = new File(folder.getAbsolutePath() + File.separatorChar + name + ".html");
			//f2.deleteOnExit();
			
			output = new BufferedWriter(new FileWriter(f2));
			output.write(myhelper.StartDocument("SBVR Documentation: " + name));
						
			// Copy the show and hide images
			try
			{
				CopyImage (folder.getAbsolutePath(), "show.png");
				CopyImage (folder.getAbsolutePath(), "hide.png");
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		serial = false;
		done = new HashSet<>();
	}
	
	private void CopyImage (String path, String imgname) throws IOException
	{

		File myimgcpy = new File(path + File.separatorChar + imgname);
		myimgcpy.deleteOnExit();
				
		InputStream in = getClass().getClassLoader().getResourceAsStream("net/menthor/resources/ontouml2sbvr/" + imgname);
		OutputStream out = new FileOutputStream(myimgcpy);
		
		byte[] buf = new byte[1024];
		int len;
		
		while ((len = in.read(buf)) > 0)
		{
			out.write(buf, 0, len);
		}
		
		in.close();
		out.close();
		
		in = null;
		out = null;
		
	}
	
	private LinkedList<String> getGeneralConcept(Classifier c)
	{
		LinkedList<String> parents = new LinkedList<String>();
		
		if (c.parents().size() > 0)
		{
			for (Iterator<Classifier> it = c.parents().iterator(); it.hasNext();)
			{
				parents.add(it.next().getName());
			}
			
			return parents;
		}
		
		return null;
	}
	
	private String getAssociationName(Association a)
	{
		if (a instanceof FormalAssociation || a instanceof MaterialAssociation)
		{
			return a.getName();
		}
		else if (a instanceof Mediation)
		{
			return "mediates";
		}
		else if (a instanceof Characterization)
		{
			return "characterizes";
		}
		else if (a instanceof Meronymic)
		{
			if (a instanceof componentOf)
			{
				return "is component of";
			}
			else if (a instanceof subCollectionOf)
			{
				return "is sub collection of";
			}
			else if (a instanceof subQuantityOf)
			{
				return "is sub quantity of";
			}
			else if (a instanceof memberOf)
			{
				return "is member of";	
			}
		}
		
		if (a.getName() == "" || a.getName() == null)
			return "has";
				
		return a.getName();
	}
	
	private String getRelataName(Property p)
	{		
		if ((p.getName() != null) && (p.getName().length() != 0))
		{
			return p.getName();
		}
		else
			return p.getType().getName();		
	}
	
	private String getAssociationConcept(Association a)
	{	
		if (a instanceof MaterialAssociation || a instanceof FormalAssociation || a instanceof Mediation)
		{
			return "associative fact type";
		}
		else if (a instanceof Characterization)
		{
			return "is-property-of fact type";
		}
		else if (a instanceof Meronymic)
		{
			return "partitive fact type";
		}

		return "is-property-of fact type";				
	}
	
	private boolean isAttributeAssociation(Association a)
	{
		return !(a instanceof MaterialAssociation || a instanceof FormalAssociation || a instanceof DependencyRelationship || a instanceof Meronymic);
	}
		
	private String getClassConcept(Classifier c)
	{
		if (c instanceof SubstanceSortal)
		{
			return "fundamental concept";
		}
		else if (c instanceof AntiRigidSortalClass ||
				 c instanceof AntiRigidMixinClass ||
				 c instanceof SemiRigidMixinClass)
		{
			return "role";
		}
		else
		{
			return "object type";
		}
	}
	
	private void DealChildPartition(GeneralizationSet gs, boolean hasNext)
	{
		// categorization scheme
		DealCategorization(gs);
		
		// Children
		Iterable<Classifier> specifics = gs.children();
		
		for (Iterator<Classifier> itc = specifics.iterator(); itc.hasNext();)
		{
			DealNode((Class)itc.next(), (itc.hasNext() || hasNext) && !serial);
		}
	}
	
	private void CollapsibleSection(Classifier c)
	{
		try
		{
			if (!serial)
			{
				output.write(myhelper.StartCollapsibleSection(c.getName()));
			
				// Partitions
				for (Iterator<GeneralizationSet> itp = c.partitions().iterator(); itp.hasNext();)
				{
					boolean hasNext = itp.hasNext() 
							|| treeNavigator.hasSolitaryChildren(c) //n.hasSChildren()
							|| treeNavigator.hasAssociations(c); //n.hasAssociations()  
					DealChildPartition(itp.next(), hasNext);
				}
				
				// Solitary Children
				for (Iterator<Classifier> it = treeNavigator.getSolitatyChildren(c).iterator(); it.hasNext();)
				{
					DealNode((Class)it.next(), it.hasNext() 
							|| treeNavigator.hasAssociations(c)) ;//n.hasAssociations());	
				}
				
				// Associations
				for (Iterator<Association> it = treeNavigator.getAssociations(c).iterator(); it.hasNext();)
				{
					DealAssociation(it.next(), it.hasNext());
				}
			
				output.write(myhelper.EndCollapsibleSection());
			}
			else
			{
				// Owned Associations
				for (Iterator<Association> it = treeNavigator.getOwnedAssociations(c).iterator(); it.hasNext();)
				{
					Association a = it.next();
					DealAssociation(a, true);
				}
				
				// Partitions
				for (Iterator<GeneralizationSet> itp = c.partitions().iterator(); itp.hasNext();)
				{
					DealChildPartition(itp.next(), false);
				}
				
				// Solitary Children
				for (Iterator<Classifier> it = treeNavigator.getSolitatyChildren(c).iterator(); it.hasNext();)
				{
					DealNode((Class)it.next(), false);	
				}			
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void DealNode(Classifier c, boolean sectionbreak)
	{
		if (serial)
		{
			if (done.contains(c))
				return;
			done.add(c);
		}
		
		try
		{
			boolean hasToggle = this.treeNavigator.hasAssociations(c) 
					|| c.children().size() > 0;
			
			if (!serial) output.write(myhelper.StartSection(c.getName()));
			
			DealClassBasic(c, hasToggle);
									
			if (hasToggle) 
				CollapsibleSection(c);
			
			if (!serial) output.write(myhelper.EndSection());
			
			if (sectionbreak) SectionBreaker();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
		
	private void DealClassBasic(Classifier c, boolean toggle)
	{
		try
		{			
			// Noun concept name
			output.write(myhelper.NounConcept(c.getName(), toggle && !serial, serial));
						
			// General Concept
			LinkedList<String> parents = getGeneralConcept(c);
			if (parents != null)
				output.write(myhelper.GeneralConcept(parents, serial));
			
			// Concept Type
			output.write(myhelper.ConceptType(getClassConcept(c)));
			
			createDescription(c);
			
			// Generalization Sets (as Specific)
			LinkedList<String> gsets = RefOntoUMLUtil.IncludedInCs(c);
			if (gsets != null)
			{
				output.write(myhelper.IncludedInCs(c.getName(), gsets));
			}
			
			if (serial) SectionBreaker();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private static final String AT_LEAST = "at least";
	private static final String AT_MOST = "at most";
	private static final String EXACTLY = "exactly";
	private static final String ANY_NUMBER = "any number";
	private static final String AND = "and";
	private static final String OF = "of";
	private static final String INSTANCE = "instance";
	private static final String INSTANCES = "instances";

	/**
	 * Given a {@link MultiplicityElement}, this methods returns a 
	 * verbalization according to the following rules:
	 * <ul>
	 * <li>{@code{0..*}} is translated into <i>any number of instances</i></li>
	 * <li>{@code{1..*}} is translated into <i>at least one instance</i></li>
	 * <li>{@code{n..*}} is translated into <i>at least n instances</i></li>
	 * <li>{@code{0..1}} is translated into <i>at most one instance</i></li>
	 * <li>{@code{0..n}} is translated into <i>at most n instances</i></li>
	 * <li>{@code{1..1}} is translated into <i>exactly one instance</i></li>
	 * <li>{@code{n..n}} is translated into <i>exactly n instances</i></li>
	 * <li>{@code{1..m}} is translated into <i>at least one and at most m instances</i></li>
	 * <li>{@code{n..m}} is translated into <i>at least n and at most m instances</i></li>
	 * </ul> 
	 * 
	 * @param c the {@link MultiplicityElement} representing a cardinality value
	 * @return the verbalization (i.e. a human readable textual representation) 
	 * of the cardinality boundaries.
	 * 
	 * @author petrux
	 * @since 25 July 2014
	 */
	private String verbalizeCardinality(MultiplicityElement c) {
		int hi = c.upperBound();
		int lo = c.lowerBound();
		if (lo == 0 && hi == -1) 
			return ANY_NUMBER + " " + OF + " " + INSTANCES;
		if (lo == 1 && hi == -1) 
			return AT_LEAST + " one " + INSTANCE;
		if (lo >= 2 && hi == -1) 
			return AT_LEAST + " " + Integer.toString(lo) + " " + INSTANCES;
		if (lo == 0 && hi == 1) 
			return AT_MOST + " one " + INSTANCE;
		if (lo == 0 && hi >= 2) 
			return AT_MOST + " " + Integer.toString(hi) + " " + INSTANCES;
		if (lo == 1 && hi == 1 && lo == hi) 
			return EXACTLY + " one " + INSTANCE;
		if (lo >= 2 && hi >= 2 && lo == hi) 
			return EXACTLY + " " + Integer.toString(lo) + " " + INSTANCES;
		if (lo == 1 && hi >= 2) 
			return AT_LEAST + " one " + AND + " " + AT_MOST + " " + Integer.toString(hi) + " " + INSTANCES;
		return AT_LEAST + " " + Integer.toString(lo) + " " + AND + " " + AT_MOST + " " + Integer.toString(hi) + " " + INSTANCES;
	}
	
	/**
	 * Creates an expressive description of a {@link Relator} in the following form:
	 * <em> 
	 * A <RELATOR> instance mediates between {a..b} <ROLE> instances [...]. 
	 * An instance of ROLE is involved in {a..b} RELATOR instances.
	 * From an instance of RELATOR, {a..b} instances of MATERIAL relations 
	 * can be derived, each one involving {c..d} instances of ROLE#1, [...] 
	 * and {e..f} instances of ROLE#N
	 * </em> 
	 * 
	 * @param relato the {@link Relator} instance to be described.
	 * 
	 * @return a {@link StringBuilder} representing the decription of the
	 * given {@link Relator} instance.
	 * 
	 * @author petrux
	 * @since 28 July 2014
	 */
	private StringBuilder describeAsRelator(Relator relator) {
		StringBuilder descriptionBuilder = new StringBuilder(); 
		EList<Mediation> mediations = relator.mediations();
		descriptionBuilder.append(myhelper.Text("An instance of "));
		descriptionBuilder.append(myhelper.Term(relator.getName()));
		descriptionBuilder.append(myhelper.Text(" mediates between "));
		for (int i = 0; i < mediations.size(); i++) {
			descriptionBuilder.append(myhelper.Text(verbalizeCardinality(mediations.get(i).mediatedEnd())));
			descriptionBuilder.append(myhelper.Text(" of "));
			descriptionBuilder.append(myhelper.Term(mediations.get(i).mediated().getName()));
			
			if (i < mediations.size() - 2)
				descriptionBuilder.append(myhelper.Text(", "));
			else if (i == mediations.size() - 2)
				descriptionBuilder.append(myhelper.Text(" and "));
			else ; //pass
		}
		descriptionBuilder.append(myhelper.Text("."));
		descriptionBuilder.append(myhelper.lineBreak());
		
		//"An instance of ROLE is involved in {a..b} RELATOR instances."
		for (Mediation mediation : mediations) {
			descriptionBuilder.append(myhelper.Text("Each instance of "));
			descriptionBuilder.append(myhelper.Term(mediation.mediated().getName()));
			descriptionBuilder.append(myhelper.Text(" is involved in "));
			descriptionBuilder.append(myhelper.Text(verbalizeCardinality(mediation.relatorEnd())));
			descriptionBuilder.append(myhelper.Term(" of "));
			descriptionBuilder.append(myhelper.Term(mediation.relator().getName()));
			descriptionBuilder.append(myhelper.Text("."));
			descriptionBuilder.append(myhelper.lineBreak());
		}
		
		/*
		 * "From an instance of RELATOR, {a..b} instances of MATERIAL relations 
		 * can be derived, each one involving {c..d} instances of ROLE#1 and 
		 * {e..f} instances of ROLE#2"
		 */
		for (Derivation derivation : this.treeNavigator.getDerivation(relator)) {
			descriptionBuilder.append(myhelper.Text("From an instance of "));
			descriptionBuilder.append(myhelper.Term(derivation.relator().getName()));
			descriptionBuilder.append(myhelper.Text(", "));
			descriptionBuilder.append(myhelper.Text(verbalizeCardinality(derivation.materialEnd())));
			descriptionBuilder.append(myhelper.Text(" of "));
			descriptionBuilder.append(myhelper.Term(derivation.material().getName()));
			descriptionBuilder.append(myhelper.Text(
					" relation can be derived, each one involving "));

			MaterialAssociation material = (MaterialAssociation)derivation.material();
			for (int i = 0; i < material.getMemberEnd().size(); i++) {
				Property p = material.getMemberEnd().get(i);
				Classifier c = (Classifier)p.getType();

				descriptionBuilder.append(myhelper.Text(" "));
				descriptionBuilder.append(myhelper.Text(verbalizeCardinality(p)));
				descriptionBuilder.append(myhelper.Text(" of "));
				descriptionBuilder.append(myhelper.Term(c.getName()));
				
				if (i < material.getMemberEnd().size() - 2)
					descriptionBuilder.append(myhelper.Text(", "));
				else if (i == material.getMemberEnd().size() - 2)
					descriptionBuilder.append(myhelper.Text(" and "));
				else ; //pass
			}
			
			descriptionBuilder.append(myhelper.Text("."));
			descriptionBuilder.append(myhelper.lineBreak());
		}
		return descriptionBuilder;
	}
	
	/**
	 * Create an expressive description for a given {@code Node} instance, 
	 * containing reference to its specializations and relations it is involved in, appending
	 * it to the final HTML file.
	 * 
	 * @param c the {@link Classifier} instance to be described.
	 * @throws IOException if file writing doesn't end successfully.
	 * 
	 * @author petrux 
	 * @since 10 July 2014
	 */
	//TODO: CREATE DESCRIPTION
	private void createDescription(Classifier c) throws IOException {
		String superClassName = c.getName();
		StringBuilder descriptionBuilder = new StringBuilder();
		
		//Relator description:
		if (c instanceof Relator)
			descriptionBuilder.append(
					describeAsRelator((Relator)c)
					.toString());
		
		//Child partitions
		for (GeneralizationSet gs : c.partitions()) {
			String gsName = RefOntoUMLUtil.getGSetName(gs);
			boolean isDisjoint = gs.isIsDisjoint();
			boolean isComplete = gs.isIsCovering();
			LinkedList<String> sNames = RefOntoUMLUtil.getGSetSpecificsName(gs);
			
			/*
			 * According to the 
			 * [categorization scheme|segmentation] CS, 
			 * a SUPERCLASS
			 * 1. {}: may be one of
			 * 2. {disjoint}: may be at most one of
			 * 3. {complete}: must be at least one of
			 * 4. {disjoint, complete}: must be exactly one of
			 * a SUBCLASS_1 or a SUBCLASS_2 or... a SUBCLASS_N
			 */
			
			/*
			 * check if we are dealing with a segmentation 
			 * (i.e. a {disjoint, complete} generalization
			 * set) or not.
			 */
			String categorizationType = (isDisjoint && isComplete) 
					? "segmentation" 
					: "categorization scheme"; 
			
			/*
			 * Verbalize the subclassing according to the (eventual)
			 * disjointness and/or completeness of the generalization set 
			 */
			String being = " may be one of ";
			if (isDisjoint && isComplete) being = " must be exactly one of ";
			if (isDisjoint && !isComplete) being = " may be at most one of ";
			if (isComplete && !isDisjoint) being = " must be at least one of ";
			
			/*
			 * Translate the list of subclass names into a list 
			 * of alternatives, according to the proper SBVR
			 * typographical conventions.
			 */
			boolean isFirst = true;
			StringBuilder subclassListBuilder = new StringBuilder();
			for (String subclassName : sNames) {
				if (isFirst) {
					subclassListBuilder.append(myhelper.Text("a "));
					isFirst = false;
				}
				else {
					subclassListBuilder.append(myhelper.Text(" or a "));
				}
				subclassListBuilder.append(myhelper.Term(subclassName));
			}
			
			descriptionBuilder.append(myhelper.Text("According to the "));
			descriptionBuilder.append(myhelper.Text(categorizationType));
			descriptionBuilder.append(myhelper.Text(" "));
			descriptionBuilder.append(myhelper.individual(gsName));
			descriptionBuilder.append(myhelper.Text(" a "));
			descriptionBuilder.append(myhelper.Term(superClassName));
			descriptionBuilder.append(myhelper.Text(being));
			descriptionBuilder.append(subclassListBuilder.toString());
			descriptionBuilder.append(myhelper.Text(".")); 
			descriptionBuilder.append(myhelper.lineBreak());
		}
	
		//Solitary children.
		for (Classifier child : treeNavigator.getSolitatyChildren(c)) {
			descriptionBuilder.append(myhelper.Text("A ")); 	
			descriptionBuilder.append(myhelper.Term(superClassName)); 
			descriptionBuilder.append(myhelper.Text(" may be a ")); 
			descriptionBuilder.append(myhelper.Term(child.getName())); 
			descriptionBuilder.append(myhelper.Text(".")); 
			descriptionBuilder.append(myhelper.lineBreak());
			
			if (child instanceof RefOntoUML.Role) {
				RefOntoUML.Relator relator = ((RefOntoUML.Role)child).relator();
				descriptionBuilder.append(myhelper.Text("A "));
				descriptionBuilder.append(myhelper.Term(superClassName));
				descriptionBuilder.append(myhelper.Text(" may partecipate in a relation of type "));
				descriptionBuilder.append(myhelper.Term(relator.getName()));
				descriptionBuilder.append(myhelper.Text(" in the role of a "));
				descriptionBuilder.append(myhelper.Term(child.getName()));
				descriptionBuilder.append(myhelper.lineBreak());
			}
		}
		
		String description = descriptionBuilder.toString();
		if (description.length() > 0)
			output.write(myhelper.Description(description));
	}
	
	public void DealAssociation (Association a, boolean sectionbreak)
	{
		Property p1 = a.getMemberEnd().get(0);
		Property p2 = a.getMemberEnd().get(1);
		String relata1 = getRelataName(p1);
		String relata2 = getRelataName(p2);
		String assocName = getAssociationName(a);
		String conceptType = getAssociationConcept(a);
		boolean datatypeAttribute = isAttributeAssociation(a);
		boolean reverse = a instanceof Meronymic;
		Property p;
						
		try
		{
			// Verb Concept
			output.write(myhelper.VerbConcept(relata1, assocName, relata2, reverse, serial));
			// Concept Type
			output.write(myhelper.ConceptType(conceptType));

			// Necessity 1
			p = reverse ? p1 : p2;
			output.write(myhelper.AssociationNecessity(relata1, assocName, relata2, p.getLower(), p.getUpper(), reverse));
			
			// Necessity 2
			if (!datatypeAttribute)
			{
				reverse = ! reverse;
				p = reverse ? p1 : p2;									
				output.write(myhelper.AssociationNecessity(relata1, "is related to ", relata2, p.getLower(), p.getUpper(), reverse));
			}

			// Section Breaker
			if (sectionbreak) SectionBreaker();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	// TODO: enum
	public void DealDataType (DataType dt)
	{
		try
		{
			// Noun concept name
			output.write(myhelper.NounConcept(dt.getName(), false, serial));
									
			// Concept Type
			output.write(myhelper.ConceptType(getClassConcept(dt)));
						
			// Section Breaker
			SectionBreaker();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void DealAssociationRole (String role, Classifier c)
	{
		try
		{
			// Noun concept (role name)
			output.write(myhelper.NounConcept(role, false, serial));
			
			// General Concept
			LinkedList<String> parents = new LinkedList<String>();
			parents.add(c.getName());
			output.write(myhelper.GeneralConcept(parents, serial));
			
			// Concept Type
			output.write(myhelper.ConceptType("role"));
									
			// Section Breaker
			SectionBreaker();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void DealCategorization (GeneralizationSet gs)
	{
		try
		{
			String gsname = RefOntoUMLUtil.getGSetName(gs);
			
			// Categorization Scheme Name
			output.write(myhelper.CategorizationScheme(gsname));
			
			// Definition
			String concept;
			if (gs.isIsDisjoint() && gs.isIsCovering())
			{
				concept = "segmentation";
			}
			else
			{
				concept = "categorization scheme";
			}
			output.write(myhelper.CSDefinition(concept, RefOntoUMLUtil.getGSetGeneral(gs).getName()));
			
			// Necessity
			output.write(myhelper.CSNecessity(gsname, RefOntoUMLUtil.getGSetSpecificsName(gs)));
			
			// Section Breaker
			SectionBreaker();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
		
	private void SectionBreaker()
	{
		try
		{
			output.write(myhelper.SectionBreaker());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}	
	}
	
	public void Done()
	{
		try
		{
			output.write(myhelper.EndDocument());
			output.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private TreeNavigator treeNavigator;
	public void addTreeNavigator(TreeNavigator treeNavigator) {
		this.treeNavigator = treeNavigator;
	}
}
