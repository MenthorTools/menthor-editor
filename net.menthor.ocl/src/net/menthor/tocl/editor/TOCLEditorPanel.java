package net.menthor.tocl.editor;

import java.awt.Component;

import net.menthor.ocl.editor.OCLEditorPanel;
import net.menthor.tocl.editor.completion.TModelCompletionProvider;
import net.menthor.tocl.editor.completion.TOCLCompletionProvider;

import org.eclipse.emf.ecore.EObject;
import org.fife.ui.rsyntaxtextarea.RSyntaxDocument;

import RefOntoUML.parser.OntoUMLParser;

public class TOCLEditorPanel extends OCLEditorPanel {

	private static final long serialVersionUID = -3101364874784679416L;

	public TOCLCompletionProvider toclProvider;
	public TModelCompletionProvider tmodelProvider;
	
	public TOCLSyntaxHighlight toclSyntaxHighlight;
	
	public TOCLEditorPanel(Component parent)
	{
		super(parent);
		
		tmodelProvider = new TModelCompletionProvider(mainProvider);
		toclProvider = new TOCLCompletionProvider(mainProvider);		
		toclProvider.addCompletions();
		
		toclSyntaxHighlight = new TOCLSyntaxHighlight();
		((RSyntaxDocument)textArea.getDocument()).setSyntaxStyle(toclSyntaxHighlight);
		
		ac.setListCellRenderer(new TOCLCellRenderer());	 
	}
	
	// Completions ======================
	
	@Override
	public void addCompletions(OntoUMLParser refparser)
	{   
		super.addCompletions(refparser);
		tmodelProvider.addCompletions(refparser);	   
	}

	@Override
	public void removeCompletion(EObject elem)
	{
		super.removeCompletion(elem);
		tmodelProvider.removeCompletion(elem);		
	}
    
	@Override
	public void removeAllModelCompletions()
	{
		super.removeAllModelCompletions();
		tmodelProvider.removeAllCompletions();		
	}
	
	@Override
	public void updateCompletion(EObject elem)
	{
		super.updateCompletion(elem);
		tmodelProvider.updateCompletion(elem);
	}
}
