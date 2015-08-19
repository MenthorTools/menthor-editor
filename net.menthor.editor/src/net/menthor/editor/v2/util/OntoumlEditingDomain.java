package net.menthor.editor.v2.util;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

public final class OntoumlEditingDomain {

	private static OntoumlEditingDomain refEditDomain = new OntoumlEditingDomain();
	public static OntoumlEditingDomain getInstance() { return refEditDomain; }
	
	private ResourceSet resourceSet;
	private ComposedAdapterFactory adapterFactory; 
	private AdapterFactoryEditingDomain editingDomain;
	private boolean initialized = false;
	
	public boolean isInitialized() { return initialized; }
	
	private OntoumlEditingDomain(){
		initialize();
	}
	
	public Resource createResource() {
		if(!initialized){
			initialize();
		}
		Resource resource = resourceSet.createResource(URI.createFileURI(""));		
		return resource;
	}
	
	public AdapterFactoryEditingDomain createDomain() {
		if (!initialized) {
			initialize();
		}		
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, new BasicCommandStack(), resourceSet);		
		return editingDomain;
	}	
	
	public void initialize() {
		try{
			resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new MenthorResourceFactoryImpl());	
			resourceSet.getPackageRegistry().put(RefOntoUML.RefOntoUMLPackage.eNS_URI, RefOntoUML.RefOntoUMLPackage.eINSTANCE);			
			adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new EcoreItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());			
			initialized = true;
		} catch(Exception e ){
			e.printStackTrace();
		}
	}	
}
