package net.menthor.tocl.editor.completion;

import net.menthor.ocl.editor.completion.OCLTemplateCompletion;

import org.fife.ui.autocomplete.CompletionProvider;

/**
 * @author John Guerson
 */

public class TOCLTemplateCompletion extends OCLTemplateCompletion {
	
	public TOCLTemplateCompletion(CompletionProvider provider, String inputText,
			String definitionString, String template, String shortDescription, String summary) 
	{
		super(provider, inputText, definitionString, template, shortDescription,summary);		
		
	}
	
	public TOCLTemplateCompletion(CompletionProvider provider, String inputText,
			String definitionString, String template) 
	{
		super(provider, inputText, definitionString, template);
	}
}