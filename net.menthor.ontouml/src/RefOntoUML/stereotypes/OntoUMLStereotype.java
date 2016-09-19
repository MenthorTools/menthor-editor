package RefOntoUML.stereotypes;

import org.eclipse.emf.ecore.EObject;

public interface OntoUMLStereotype{

	public Class<? extends EObject> getMetaclass();	
	public String getName();	
	public OntoUMLStereotype getMetatype(EObject element);
	
	public boolean isAssociation();
	public boolean isMeronymic();
	public boolean isGeneralization();
	public boolean isClass();
	public boolean isGeneralizationSet();
	public boolean isPackage();
	public boolean isDataType();
}
