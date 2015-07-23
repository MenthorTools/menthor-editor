package RefOntoUML.util;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class RefOntoUMLModelAbstraction
{
	// Ecore Resource
	public Resource resource;
	// OntoUML Model
	public RefOntoUML.Package model;
	
	// All Classes
	public List<RefOntoUML.Class> classes;
	
	// Any non-moment
	public List<RefOntoUML.ObjectClass> objects;
	
	// Kind + Quantity + Collective + SubKind
	public List<RefOntoUML.RigidSortalClass> rigidSortals;
	// Kind + Quantity + Collective
	public List<RefOntoUML.SubstanceSortal> substanceSortals;
	public List<RefOntoUML.Kind> kinds;
	public List<RefOntoUML.Quantity> quantities;
	public List<RefOntoUML.Collective> collectives;
	public List<RefOntoUML.SubKind> subKinds;

	// Phases + Roles
	public List<RefOntoUML.AntiRigidSortalClass> antiRigidSortals;
	public List<RefOntoUML.Role> roles;
	public List<RefOntoUML.Phase> phases;
		
	// Category + SemiMixin + RoleMixin
	public List<RefOntoUML.MixinClass> allMixins;
	public List<RefOntoUML.Category> categories;
	public List<RefOntoUML.Mixin> semiMixins;
	public List<RefOntoUML.RoleMixin> roleMixins;
	
	// Relators
	public List<RefOntoUML.Relator> relators;
	// Qualities
	public List<RefOntoUML.Quality> qualities;
	
	public List<RefOntoUML.GeneralizationSet> generalizationSets;
	// TODO: perhaps, a list of generalizations

	public RefOntoUMLModelAbstraction ()
	{
		classes = new LinkedList<RefOntoUML.Class>();
		
		objects = new LinkedList<RefOntoUML.ObjectClass>();
		
		rigidSortals = new LinkedList<RefOntoUML.RigidSortalClass>();
		substanceSortals = new LinkedList<RefOntoUML.SubstanceSortal>();
		kinds = new LinkedList<RefOntoUML.Kind>();
		quantities = new LinkedList<RefOntoUML.Quantity>();
		collectives = new LinkedList<RefOntoUML.Collective>();
		subKinds = new LinkedList<RefOntoUML.SubKind>();
		
		antiRigidSortals = new LinkedList<RefOntoUML.AntiRigidSortalClass>();
		roles = new LinkedList<RefOntoUML.Role>();
		phases = new LinkedList<RefOntoUML.Phase>();
		
		allMixins = new LinkedList<RefOntoUML.MixinClass>();
		categories = new LinkedList<RefOntoUML.Category>();
		semiMixins = new LinkedList<RefOntoUML.Mixin>();
		roleMixins = new LinkedList<RefOntoUML.RoleMixin>();
		
		relators = new LinkedList<RefOntoUML.Relator>();
		qualities = new LinkedList<RefOntoUML.Quality>();
		
		generalizationSets = new LinkedList<RefOntoUML.GeneralizationSet>();
	}
	
	public boolean load (RefOntoUML.Package model)
	{
		this.model = model; 
		return true;
	}
	
	public boolean load (String fileAbsolutePath)
	{
		// Configure ResourceSet
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(RefOntoUML.RefOntoUMLPackage.eNS_URI,RefOntoUML.RefOntoUMLPackage.eINSTANCE);
	
		// Open the model
		File sourceFile = new File(fileAbsolutePath);
		if (!sourceFile.isFile())
		{
			System.out.println("Error accessing: " + sourceFile.getAbsolutePath());
		}
		else
		{
			URI uri = URI.createFileURI(sourceFile.getAbsolutePath());
	
			this.resource = resourceSet.getResource(uri, true);
			EObject root = this.resource.getContents().get(0);
			
			if (root instanceof RefOntoUML.Model)
			{
				model = (RefOntoUML.Model) root;
				return true;
			}
			else
			{
				System.out.println("The root element is not a RefOntoUML.Model");
			}
		}
		
		model = null;
		return false;
	}
	
	public boolean process ()
	{
		if (model == null)
			return false;
		
		for (RefOntoUML.PackageableElement pe : model.getPackagedElement())
		{
			if (pe instanceof RefOntoUML.Class)
			{
				classes.add((RefOntoUML.Class)pe);
				
				if (pe instanceof RefOntoUML.ObjectClass)
				{
					objects.add((RefOntoUML.ObjectClass)pe);
					
					if (pe instanceof RefOntoUML.SortalClass)
					{
						if (pe instanceof RefOntoUML.RigidSortalClass)
						{
							rigidSortals.add((RefOntoUML.RigidSortalClass)pe);
							
							if (pe instanceof RefOntoUML.SubstanceSortal)
							{
								substanceSortals.add((RefOntoUML.SubstanceSortal)pe);
								
								if (pe instanceof RefOntoUML.Kind)
								{
									kinds.add((RefOntoUML.Kind)pe);
								}
								else if (pe instanceof RefOntoUML.Quantity)
								{
									quantities.add((RefOntoUML.Quantity)pe);
								}
								else if (pe instanceof RefOntoUML.Collective)
								{
									collectives.add((RefOntoUML.Collective)pe);
								}
							}
							else if (pe instanceof RefOntoUML.SubKind)
							{
								subKinds.add((RefOntoUML.SubKind)pe);
							}
						}
						else if (pe instanceof RefOntoUML.AntiRigidSortalClass)
						{
							antiRigidSortals.add((RefOntoUML.AntiRigidSortalClass)pe);
							
							if (pe instanceof RefOntoUML.Role)
							{
								roles.add((RefOntoUML.Role)pe);
							}
							else if (pe instanceof RefOntoUML.Phase)
							{
								phases.add((RefOntoUML.Phase)pe);
							}
						}
					}
					else if (pe instanceof RefOntoUML.MixinClass)
					{
						allMixins.add((RefOntoUML.MixinClass)pe);
						
						if (pe instanceof RefOntoUML.Category)
						{
							categories.add((RefOntoUML.Category)pe);
						}
						else if (pe instanceof RefOntoUML.RoleMixin)
						{
							roleMixins.add((RefOntoUML.RoleMixin)pe);
						}
						else if (pe instanceof RefOntoUML.Mixin)
						{
							semiMixins.add((RefOntoUML.Mixin)pe);
						}
					}
				}
				else if (pe instanceof RefOntoUML.MomentClass)
				{
					if (pe instanceof RefOntoUML.Relator)
					{
						relators.add((RefOntoUML.Relator)pe);
					}
					else if (pe instanceof RefOntoUML.Quality)
					{
						qualities.add((RefOntoUML.Quality)pe);
					}
					// TODO: Mode
				}
			}
			else if (pe instanceof RefOntoUML.GeneralizationSet)
			{
				generalizationSets.add((RefOntoUML.GeneralizationSet)pe);
			}
			// TODO: Associations
		}
		
		return true;
	}
}
