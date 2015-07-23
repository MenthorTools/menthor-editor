package net.menthor.ontouml2infouml.ui.content;

import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class SimpleContentProvider implements ITreeContentProvider
{

	@Override
	public Object[] getChildren(Object parentElement)
	{
		return null;
	}

	@Override
	public Object getParent(Object element)
	{
		return null;
	}

	@Override
	public boolean hasChildren(Object element)
	{
		return false;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object[] getElements(Object inputElement)
	{
		return ((List)inputElement).toArray();
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
