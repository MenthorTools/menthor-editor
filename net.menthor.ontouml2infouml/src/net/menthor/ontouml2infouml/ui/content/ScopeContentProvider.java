package net.menthor.ontouml2infouml.ui.content;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;


public class ScopeContentProvider implements ITreeContentProvider
{
	@Override
	public Object[] getElements(Object inputElement)
	{
		return ((ScopeModel) inputElement).scopeModel.toArray();
	}
	
	@Override
	public Object[] getChildren(Object parentElement)
	{
		RefOntoUML.Class c = (RefOntoUML.Class) parentElement;
		
		// MixinClass Node
		if (parentElement instanceof RefOntoUML.MixinClass)
		{
			// Only the MixinClass children of MixinClass
			List<RefOntoUML.Classifier> children = new LinkedList<RefOntoUML.Classifier>();
			
			for (RefOntoUML.Classifier child : c.children())
			{
				if (child instanceof RefOntoUML.MixinClass)
					children.add(child);
			}
			
			return children.toArray();
		}
		
		// Non-MixinClass Node
		return c.children().toArray();
	}

	@Override
	public boolean hasChildren(Object element)
	{
		return getChildren(element).length > 0;
	}
	
	@Override
	public Object getParent(Object element)
	{
		RefOntoUML.Class c = (RefOntoUML.Class) element;
		
		if (c instanceof RefOntoUML.SubstanceSortal)
		{
			// Substance Sortals are root nodes in this tree
			// Does not return any potential MixinClass parent
			return null;
		}
		else if (c instanceof RefOntoUML.Role)
		{
			for (RefOntoUML.Classifier p : c.parents())
			{
				if (p instanceof RefOntoUML.RoleMixin)
				{
					// Role with RoleMixin parent
					RefOntoUML.Role r = (RefOntoUML.Role) c;
					// Returns the RigidParent as parent, not the RoleMixin
					return r.rigidParent();
				}
			}
		}

		// All Mixins, Relator, SubKind, and Roles without RoleMixin
		// The first parent
		if (c.parents().size() > 0)
			return c.parents().get(0);
		return null;
	}

	@Override
	public void dispose()
	{

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
	{

	}
}
