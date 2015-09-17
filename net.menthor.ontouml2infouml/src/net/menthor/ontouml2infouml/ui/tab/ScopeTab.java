package net.menthor.ontouml2infouml.ui.tab;

import net.menthor.ontouml2infouml.decision.DecisionHandler;
import net.menthor.ontouml2infouml.ui.content.ScopeContentProvider;
import net.menthor.ontouml2infouml.ui.content.ScopeModel;

import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TreeItem;

import RefOntoUML.util.RefOntoUMLModelAbstraction;

public class ScopeTab implements Tab
{	
	public String getName()
	{
		return "Scope";
	}
	
	public Control getControl(Composite parent, RefOntoUMLModelAbstraction ma, final DecisionHandler dh)
	{
		return treeViewerScope(parent, ma, dh).getTree();
	}
	
	public TreeViewer treeViewerScope (Composite parent, RefOntoUMLModelAbstraction ma, final DecisionHandler dh)
	{
		final CheckboxTreeViewer treeViewer = new CheckboxTreeViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		treeViewer.getTree().setLinesVisible(true);
		treeViewer.getTree().setHeaderVisible(true);
		
		// Controlling checkbox states
		addCheckboxListener(treeViewer, dh);
		
		// Column 1
		TreeViewerColumn column = new TreeViewerColumn(treeViewer, SWT.LEFT);
		column.getColumn().setWidth(200);
		column.getColumn().setMoveable(true);
		column.getColumn().setText("Universal");
		column.setLabelProvider(new ColumnLabelProvider()
		{
			public String getText(Object element)
			{
				return ((RefOntoUML.Class) element).getName();
			}

		});
		
		treeViewer.setContentProvider(new ScopeContentProvider());
		treeViewer.setInput(new ScopeModel(ma));
		treeViewer.expandAll();
		
		// Initialize the values of checkboxes according to previous ScopeDecisions
		// Passing the top nodes of the Tree as parameter
		InitializeScopeCheckboxes (treeViewer.getTree().getItems(), dh);
				
		return treeViewer;
	}
	
	private void addCheckboxListener (final CheckboxTreeViewer treeViewer, final DecisionHandler dh)
	{
		// When user checks a checkbox in the tree, check all its children
		treeViewer.addCheckStateListener(new ICheckStateListener()
		{
			public void checkStateChanged(CheckStateChangedEvent event)
			{
				ITreeContentProvider cp = (ITreeContentProvider) treeViewer.getContentProvider();
				
				// if the item is checked, checks all children
				// if the item is unchecked, unchecks all children
				Object target = event.getElement();
				boolean value = event.getChecked();
				treeViewer.setSubtreeChecked(target, value);
									
				// Set Scope
				// The target element and all its (direct and indirect) children must change scope
				changeScope(target, value, cp);
				
				// If the target was checked
				if (value == true)
				{
					// Checks all parents and also set their scope to true
					checkParents(target, cp);
				}
			}
			
			public void checkParents(Object element, ITreeContentProvider cp)
			{
				// Set the scope of "element" to true
				dh.setScopeDecision(element, true);
				
				// Recursive call using "parent", if there is one
				Object parent = cp.getParent(element);
				if (parent != null)
				{
					treeViewer.setChecked(parent, true);
					checkParents(parent, cp);
				}
			}
			
			public void changeScope (Object element, boolean value, ITreeContentProvider cp)
			{
				// Change the scope of "element"
				dh.setScopeDecision(element, value);
				
				Object[] children = cp.getChildren(element);
				for (int i = 0; i < children.length; i++)
				{
					changeScope (children[i], value, cp);
				}
			}
		});
	}
	
	public void InitializeScopeCheckboxes (TreeItem[] items, DecisionHandler dh)
	{
		for (int i = 0; i < items.length; i++)
		{
			Object obj = items[i].getData();
			boolean scopeValue = dh.inScope((RefOntoUML.Classifier)obj);
			items[i].setChecked(scopeValue);
			
			TreeItem[] children = items[i].getItems();
			InitializeScopeCheckboxes(children, dh);
		}
	}
}
