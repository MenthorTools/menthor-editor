package net.menthor.ontouml2infouml.plugin;

import net.menthor.ontouml2infouml.OntoUML2InfoUML;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public class Handler extends AbstractHandler
{
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException
	{
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event);
		Object firstElement = selection.getFirstElement();
		
		if (firstElement instanceof IFile)
		{
			IFile f = (IFile) firstElement;

			// Check ".refontouml" file extension
			if (f.getFileExtension().compareTo("refontouml") == 0)
			{
				OntoUML2InfoUML.project = f.getProject();
				OntoUML2InfoUML.transformation(f.getLocation().toString());
			}
			else
			{
				MessageDialog.openError(HandlerUtil.getActiveShell(event), "Wrong Input", "The file extension must be .refontouml");
				return null;
			}
		}
		else
		{
			MessageDialog.openError(HandlerUtil.getActiveShell(event), "Wrong Input", "The input must be a file with .refontouml extension");
			return null;
		}
		
		return null;
	}

}
