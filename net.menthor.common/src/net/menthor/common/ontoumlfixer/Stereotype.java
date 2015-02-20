package net.menthor.common.ontoumlfixer;

import org.eclipse.emf.ecore.EObject;

public interface Stereotype {
	public abstract Class<? extends EObject> getMetaclass();
}
