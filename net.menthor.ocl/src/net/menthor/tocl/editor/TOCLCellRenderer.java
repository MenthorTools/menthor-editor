package net.menthor.tocl.editor;

import javax.swing.ImageIcon;
import javax.swing.JList;

import net.menthor.ocl.editor.OCLCellRenderer;

import org.fife.ui.autocomplete.Completion;
import org.fife.ui.autocomplete.FunctionCompletion;
import org.fife.ui.autocomplete.MarkupTagCompletion;
import org.fife.ui.autocomplete.TemplateCompletion;
import org.fife.ui.autocomplete.VariableCompletion;

/**
 * @author John Guerson
 */

public class TOCLCellRenderer extends OCLCellRenderer {

	private static final long serialVersionUID = 1L;
	
	@Override
	@SuppressWarnings("rawtypes")
	protected void prepareForTemplateCompletion(JList list, TemplateCompletion tc, int index, boolean selected, boolean hasFocus) 
	{
		super.prepareForTemplateCompletion(list, tc, index, selected, hasFocus);
		
		if (tc.getDefinitionString().equals("oclIsTypeOf(w)")||
			tc.getDefinitionString().equals("oclIsKindOf(w)")||
			tc.getDefinitionString().equals("oclAsType(w)")||
			tc.getDefinitionString().equals("oclIsCreated")||
			tc.getDefinitionString().equals("oclIsDeleted")||
			tc.getDefinitionString().equals("oclBecomes")||
			tc.getDefinitionString().equals("oclCeasesToBe")||
			tc.getDefinitionString().equals("allInstances(w)")||
			tc.getDefinitionString().equals("existsIn")||
			tc.getDefinitionString().equals("next")||
			tc.getDefinitionString().equals("previous")||
			tc.getDefinitionString().equals("allPrevious")||
			tc.getDefinitionString().equals("allPrevious(w)")||
			tc.getDefinitionString().equals("allNext")||
			tc.getDefinitionString().equals("allNext(w)")||
			tc.getDefinitionString().equals("allNext(p)")||
			tc.getDefinitionString().equals("hasPrevious")||
			tc.getDefinitionString().equals("hasNext")||
			tc.getDefinitionString().equals("allIndividuals")||
			tc.getDefinitionString().equals("paths")||
			tc.getDefinitionString().equals("worlds")			
		   ){
			setIcon(new ImageIcon(TOCLCellRenderer.class.getResource("/net/menthor/tocl/editor/icons/operation.gif")));
			
		}else if (tc.getDefinitionString().contains("Property"))
		{
			setIcon(new ImageIcon(OCLCellRenderer.class.getResource("/net/menthor/tocl/editor/icons/property.gif")));
		}else if(tc.getDefinitionString().equals("temp") || tc.getDefinitionString().equals("hist")){
			setIcon(new ImageIcon(OCLCellRenderer.class.getResource("/net/menthor/ocl/editor/icons/constraint.gif")));
		}
	}

	@Override
	@SuppressWarnings("rawtypes")
	protected void prepareForMarkupTagCompletion(JList list,MarkupTagCompletion mc, int index, boolean selected,boolean hasFocus) 
	{
		super.prepareForMarkupTagCompletion(list, mc, index, selected, hasFocus);		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	@Override
	protected void prepareForOtherCompletion(JList list,Completion c, int index, boolean selected, boolean hasFocus) 
	{
		super.prepareForOtherCompletion(list, c, index, selected, hasFocus);		
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	protected void prepareForVariableCompletion(JList list, VariableCompletion vc, int index, boolean selected, boolean hasFocus) 
	{
		super.prepareForVariableCompletion(list, vc, index, selected, hasFocus);		
	}


	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	protected void prepareForFunctionCompletion(JList list, FunctionCompletion fc, int index, boolean selected, boolean hasFocus) 
	{
		super.prepareForFunctionCompletion(list, fc, index, selected, hasFocus);		
	}


}