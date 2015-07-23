package net.menthor.ontouml2infouml.ui.tab;

import net.menthor.ontouml2infouml.decision.AttributeType;
import net.menthor.ontouml2infouml.decision.DecisionHandler;
import net.menthor.ontouml2infouml.ui.content.ReferenceModel;
import net.menthor.ontouml2infouml.ui.content.SimpleContentProvider;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TreeItem;

import RefOntoUML.util.RefOntoUMLModelAbstraction;

public class ReferenceTab implements Tab
{
	@Override
	public String getName()
	{
		return "Reference";
	}
		
	@Override
	public Control getControl(Composite parent, RefOntoUMLModelAbstraction ma, final DecisionHandler dh)
	{
		final CheckboxTreeViewer treeViewer = new CheckboxTreeViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		treeViewer.getTree().setLinesVisible(true);
		treeViewer.getTree().setHeaderVisible(true);
		
		// Checkbox Listener
		treeViewer.addCheckStateListener(new ICheckStateListener()
		{
			public void checkStateChanged(CheckStateChangedEvent event)
			{
				dh.setReferenceDecision(event.getElement(), event.getChecked());
			}
		});
		
		// Actions when you focus (click, double click, etc.) the cell
		// Without this: one click = edit
		// With this: one click = select / double-click = edit
		/*TreeViewerFocusCellManager focusCellManager = new TreeViewerFocusCellManager(treeViewer, new FocusCellOwnerDrawHighlighter(treeViewer));
		ColumnViewerEditorActivationStrategy actSupport = new ColumnViewerEditorActivationStrategy(treeViewer)
		{
			protected boolean isEditorActivationEvent(ColumnViewerEditorActivationEvent event)
			{
				return event.eventType == ColumnViewerEditorActivationEvent.TRAVERSAL
						|| event.eventType == ColumnViewerEditorActivationEvent.MOUSE_DOUBLE_CLICK_SELECTION
						|| (event.eventType == ColumnViewerEditorActivationEvent.KEY_PRESSED && event.keyCode == SWT.CR)
						|| event.eventType == ColumnViewerEditorActivationEvent.PROGRAMMATIC;
			}
		};
		TreeViewerEditor.create(treeViewer, focusCellManager, actSupport,
				ColumnViewerEditor.TABBING_HORIZONTAL
						| ColumnViewerEditor.TABBING_MOVE_TO_ROW_NEIGHBOR
						| ColumnViewerEditor.TABBING_VERTICAL
						| ColumnViewerEditor.KEYBOARD_ACTIVATION);*/
		
		final TextCellEditor textCellEditor = new TextCellEditor(treeViewer.getTree());	
		
		// Columns
		universalColumn(treeViewer);
		attributeNameColumn(treeViewer, dh, textCellEditor);
		attributeTypeColumn(treeViewer, dh);
		typeNameColumn(treeViewer, dh, textCellEditor);			
		
		// Content
		treeViewer.setContentProvider(new SimpleContentProvider());
		treeViewer.setInput((new ReferenceModel(ma)).model);
		treeViewer.expandAll();
				
		// Initialize the values of checkboxes according to previous Reference Decisions
		// Passing the top nodes of the Tree as parameter
		initializeCheckboxes (treeViewer.getTree().getItems(), dh);
		
		return treeViewer.getTree();
	}
	
	public void universalColumn (TreeViewer treeViewer)
	{
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
	}
	
	public void attributeNameColumn (final TreeViewer treeViewer, final DecisionHandler dh, final TextCellEditor textCellEditor)
	{
		// Column 2
		TreeViewerColumn column = new TreeViewerColumn(treeViewer, SWT.NONE);
		column.getColumn().setWidth(200);
		column.getColumn().setMoveable(true);
		column.getColumn().setText("Attribute Name");
		column.setLabelProvider(new ColumnLabelProvider()
		{
			public String getText(Object element)
			{
				return dh.getReferenceAttributeName((RefOntoUML.Class)element);
			}
		});
		
		// Based on org.eclipse.jface.snippets.viewers.snippet026
		column.setEditingSupport(new EditingSupport(treeViewer)
		{
			protected boolean canEdit(Object element)
			{
				return true;
			}

			protected CellEditor getCellEditor(Object element)
			{
				return textCellEditor;
			}

			protected Object getValue(Object element)
			{
				return dh.getReferenceAttributeName((RefOntoUML.Class)element);
			}

			protected void setValue(Object element, Object value)
			{
				dh.setReferenceAttributeName(element, value.toString());
				treeViewer.update(element, null);
			}
		});
	}
	
	public void attributeTypeColumn (final TreeViewer treeViewer, final DecisionHandler dh)
	{
		// Column 3
		TreeViewerColumn column = new TreeViewerColumn(treeViewer, SWT.NONE);
		column.getColumn().setWidth(200);
		column.getColumn().setMoveable(true);
		column.getColumn().setText("Attribute Type");
		column.setLabelProvider(new ColumnLabelProvider()
		{
			public String getText(Object element)
			{
				return dh.getReferenceAttributeType((RefOntoUML.Class)element).toString();
			}
		});
		
		// Based on org.eclipse.jface.snippets.viewers.snippet027
		final ComboBoxCellEditor comboBoxCellEditor = new ComboBoxCellEditor(treeViewer.getTree(), 
					new String[] { AttributeType.INT.toString(), AttributeType.STRING.toString(), AttributeType.CUSTOM.toString()});
		
		column.setEditingSupport(new EditingSupport(treeViewer)
		{
			protected boolean canEdit(Object element)
			{
				return true;
			}

			protected CellEditor getCellEditor(Object element)
			{
				return comboBoxCellEditor;
			}

			protected Object getValue(Object element)
			{
				return dh.getReferenceAttributeType((RefOntoUML.Class)element).ordinal();
			}

			protected void setValue(Object element, Object value)
			{
				// 0 = int
				// 1 = string
				// 2 = custom
				// -1 = invalid (the user typed some invalid name)
				int attributeTypeCode = (Integer) value;
				
				if (attributeTypeCode >= 0)
				{
					AttributeType attributeType = AttributeType.values()[attributeTypeCode];
					dh.setReferenceAttributeType(element, attributeType);
					treeViewer.update(element, null);
				}
			}
		});
	}
	
	public void typeNameColumn (final TreeViewer treeViewer, final DecisionHandler dh, final TextCellEditor textCellEditor)
	{
		// Column 4
		TreeViewerColumn column = new TreeViewerColumn(treeViewer, SWT.NONE);
		column.getColumn().setWidth(200);
		column.getColumn().setMoveable(true);
		column.getColumn().setText("Type Name");
		column.setLabelProvider(new ColumnLabelProvider()
		{
			public String getText(Object element)
			{
				RefOntoUML.Class c = (RefOntoUML.Class)element;
				String typeName = "";
				
				// Attribute Type Name is only for CUSTOM types
				if (dh.getReferenceAttributeType(c) == AttributeType.CUSTOM)
					typeName = dh.getReferenceTypeName((RefOntoUML.Class)element);
				
				return typeName;
			}
		});
		
		// Based on org.eclipse.jface.snippets.viewers.snippet026		
		column.setEditingSupport(new EditingSupport(treeViewer)
		{
			protected boolean canEdit(Object element)
			{
				// Attribute Type Name is only for CUSTOM types
				return (dh.getReferenceAttributeType((RefOntoUML.Class)element) == AttributeType.CUSTOM);
			}

			protected CellEditor getCellEditor(Object element)
			{
				return textCellEditor;
			}

			protected Object getValue(Object element)
			{
				return dh.getReferenceTypeName((RefOntoUML.Class)element);
			}

			protected void setValue(Object element, Object value)
			{
				dh.setReferenceTypeName(element, value.toString());
				treeViewer.update(element, null);
			}
		});
	}

	public void initializeCheckboxes (TreeItem[] items, DecisionHandler dh)
	{
		for (int i = 0; i < items.length; i++)
		{
			Object obj = items[i].getData();
			boolean value = dh.getReferenceDecision((RefOntoUML.Class)obj);
			items[i].setChecked(value);
		}
	}
}
