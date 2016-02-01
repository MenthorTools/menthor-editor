package net.menthor.editor.v2.types;

import org.eclipse.emf.ecore.EObject;

interface OntoumlType {

	public Class<? extends EObject> getMetaclass();	
	public String getName();	
}
