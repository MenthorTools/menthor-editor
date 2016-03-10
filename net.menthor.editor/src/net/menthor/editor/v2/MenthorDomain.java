package net.menthor.editor.v2;

/**
 * ============================================================================================
 * Menthor Editor -- Copyright (c) 2015 
 *
 * This file is part of Menthor Editor. Menthor Editor is based on TinyUML and as so it is 
 * distributed under the same license terms.
 *
 * Menthor Editor is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 *
 * Menthor Editor is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Menthor Editor; 
 * if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, 
 * MA  02110-1301  USA
 * ============================================================================================
 */

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

public final class MenthorDomain {

	private static MenthorDomain refEditDomain = new MenthorDomain();
	public static MenthorDomain get() { return refEditDomain; }
	
	private ResourceSet resourceSet;
	private MenthorResourceFactoryImpl refFactory;
	private ComposedAdapterFactory adapterFactory; 
	private AdapterFactoryEditingDomain editingDomain;
	private boolean initialized = false;
	
	public MenthorResourceFactoryImpl getFactory(){ return refFactory; }
	public boolean isInitialized() { return initialized; }
	
	private MenthorDomain(){
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
			refFactory = new MenthorResourceFactoryImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, refFactory );	
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
