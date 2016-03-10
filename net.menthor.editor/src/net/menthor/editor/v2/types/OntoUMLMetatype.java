package net.menthor.editor.v2.types;

import org.eclipse.emf.ecore.EObject;

public interface OntoUMLMetatype{

	public Class<? extends EObject> getMetaclass();	
	public String getName();	
	public OntoUMLMetatype getMetatype(EObject element);
	
	public boolean isAssociation();
	public boolean isMeronymic();
	public boolean isGeneralization();
	public boolean isClass();
	public boolean isGeneralizationSet();
	public boolean isPackage();
	public boolean isDataType();
}
