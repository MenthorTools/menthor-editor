package net.menthor.ontouml2infouml.ui.tab;

import net.menthor.ontouml2infouml.decision.AttributeType;
import net.menthor.ontouml2infouml.decision.DecisionHandler;
import net.menthor.ontouml2infouml.ui.content.MeasurementModel;
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
import net.menthor.ontouml2infouml.ui.util.BooleanCellEditor;
import net.menthor.ontouml2infouml.ui.util.EmulatedNativeCheckBoxLabelProvider;

public class MeasurementTab implements Tab
{
	@Override
	public String getName()
	{
		return "Measurement";
	}
	
	@Override
	public Control getControl(Composite parent, RefOntoUMLModelAbstraction ma, final DecisionHandler dh)
	{
		final CheckboxTreeViewer treeViewer = new CheckboxTreeViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		treeViewer.getTree().setLinesVisible(true);
		treeViewer.getTree().setHeaderVisible(true);
				
		final TextCellEditor textCellEditor = new TextCellEditor(treeViewer.getTree());
		// BooleanCellEditor is a custom class created by a guy in JFace Snippets
		final BooleanCellEditor booleanCellEditor = new BooleanCellEditor(treeViewer.getTree());
		booleanCellEditor.setChangeOnActivation(true);
		
		// Columns
		universalColumn(treeViewer);
		characterizedUniversalColumn(treeViewer, dh, textCellEditor);
		attributeTypeColumn(treeViewer, dh);
		typeNameColumn(treeViewer, dh, textCellEditor);
		historyTrackingColumn(treeViewer, dh, booleanCellEditor);
		timeTrackingColumn(treeViewer, dh, booleanCellEditor);
		
		// Content
		treeViewer.setContentProvider(new SimpleContentProvider());
		treeViewer.setInput((new MeasurementModel(ma)).model);
		treeViewer.expandAll();
				
		// Initialize the values of checkboxes according to previous Measurement Decisions
		// Passing the top nodes of the Tree as parameter
		initializeCheckboxes (treeViewer.getTree().getItems(), dh);
		
		// Checkbox Listener
		treeViewer.addCheckStateListener(new ICheckStateListener()
		{
			public void checkStateChanged(CheckStateChangedEvent event)
			{
				dh.setScopeDecision(event.getElement(), event.getChecked());
			}
		});
		
		return treeViewer.getTree();
	}

	public void universalColumn (TreeViewer treeViewer)
	{
		// Column 1
		TreeViewerColumn column = new TreeViewerColumn(treeViewer, SWT.LEFT);
		column.getColumn().setWidth(200);
		column.getColumn().setMoveable(true);
		column.getColumn().setText("Quality Universal");
		column.setLabelProvider(new ColumnLabelProvider()
		{
			public String getText(Object element)
			{
				RefOntoUML.Quality q = (RefOntoUML.Quality) element;
				//return (q.getName() + " (" + q.characterized().getName() + ")");
				return q.getName();
			}
		});
	}
	
	public void characterizedUniversalColumn (final TreeViewer treeViewer, final DecisionHandler dh, final TextCellEditor textCellEditor)
	{
		// Column 2
		TreeViewerColumn column = new TreeViewerColumn(treeViewer, SWT.NONE);
		column.getColumn().setWidth(150);
		column.getColumn().setMoveable(true);
		column.getColumn().setText("Characterized Universal");
		column.setLabelProvider(new ColumnLabelProvider()
		{
			public String getText(Object element)
			{
				return ((RefOntoUML.Quality)element).characterized().getName();
			}
		});
	}
	
	public void attributeTypeColumn (final TreeViewer treeViewer, final DecisionHandler dh)
	{
		// Column 3
		TreeViewerColumn column = new TreeViewerColumn(treeViewer, SWT.NONE);
		column.getColumn().setWidth(100);
		column.getColumn().setMoveable(true);
		column.getColumn().setText("Attribute Type");
		column.setLabelProvider(new ColumnLabelProvider()
		{
			public String getText(Object element)
			{
				return dh.getMeasurementAttributeType((RefOntoUML.Class)element).toString();
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
				return dh.getMeasurementAttributeType((RefOntoUML.Class)element).ordinal();
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
					dh.setMeasurementAttributeType(element, attributeType);
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
				if (dh.getMeasurementAttributeType(c) == AttributeType.CUSTOM)
					typeName = dh.getMeasurementTypeName((RefOntoUML.Class)element);
				
				return typeName;
			}
		});
		
		// Based on org.eclipse.jface.snippets.viewers.snippet026		
		column.setEditingSupport(new EditingSupport(treeViewer)
		{
			protected boolean canEdit(Object element)
			{
				// Attribute Type Name is only for CUSTOM types
				return (dh.getMeasurementAttributeType((RefOntoUML.Class)element) == AttributeType.CUSTOM);
			}

			protected CellEditor getCellEditor(Object element)
			{
				return textCellEditor;
			}

			protected Object getValue(Object element)
			{
				return dh.getMeasurementTypeName((RefOntoUML.Class)element);
			}

			protected void setValue(Object element, Object value)
			{
				dh.setMeasurementTypeName(element, value.toString());
				treeViewer.update(element, null);
			}
		});
	}
	
	public void historyTrackingColumn (final TreeViewer treeViewer, final DecisionHandler dh, final BooleanCellEditor booleanCellEditor)
	{
		TreeViewerColumn column = new TreeViewerColumn(treeViewer, SWT.CENTER);
		column.getColumn().setWidth(80);
		column.getColumn().setMoveable(true);
		column.getColumn().setText("History");
		column.setLabelProvider(new EmulatedNativeCheckBoxLabelProvider(treeViewer)
		{
			protected boolean isChecked(Object element)
			{
				//System.out.println(((RefOntoUML.Class)element).getName());
				return dh.getHTPastDecision((RefOntoUML.Class)element);
			}
		});
		column.setEditingSupport(new EditingSupport(treeViewer)
		{
			protected boolean canEdit(Object element)
			{
				return true;
			}

			protected CellEditor getCellEditor(Object element)
			{
				return booleanCellEditor;
			}

			protected Object getValue(Object element)
			{
				//System.out.println("getValue(" + ((RefOntoUML.Class)element).getName() + ")");
				return new Boolean(dh.getHTPastDecision((RefOntoUML.Class)element));
			}

			protected void setValue(Object element, Object value)
			{
				RefOntoUML.Class c = (RefOntoUML.Class)element;
				boolean bvalue = ((Boolean) value).booleanValue();
				
				// Sets HT value
				dh.setHTPastDecision(c, bvalue);
				
				// HT = false -> TT = false
				if (!bvalue)
				{
					// Sets TT value
					dh.setStartTimeDecision(c, bvalue);
				}

				treeViewer.update(element, null);
			}
		});
	}
	
	public void timeTrackingColumn (final TreeViewer treeViewer, final DecisionHandler dh, final BooleanCellEditor booleanCellEditor)
	{
		TreeViewerColumn column = new TreeViewerColumn(treeViewer, SWT.CENTER);
		column.getColumn().setWidth(80);
		column.getColumn().setMoveable(true);
		column.getColumn().setText("Time");
		column.setLabelProvider(new EmulatedNativeCheckBoxLabelProvider(treeViewer)
		{
			protected boolean isChecked(Object element)
			{
				//System.out.println(((RefOntoUML.Class)element).getName());
				return dh.getStartTimeDecision((RefOntoUML.Class)element);
			}
		});
		column.setEditingSupport(new EditingSupport(treeViewer)
		{
			protected boolean canEdit(Object element)
			{
				// Only if history tracking on past
				return dh.getHTPastDecision((RefOntoUML.Class)element);
			}

			protected CellEditor getCellEditor(Object element)
			{
				return booleanCellEditor;
			}

			protected Object getValue(Object element)
			{
				//System.out.println("getValue(" + ((RefOntoUML.Class)element).getName() + ")");
				return new Boolean(dh.getStartTimeDecision((RefOntoUML.Class)element));
			}

			protected void setValue(Object element, Object value)
			{
				//((File) element).read = ((Boolean) value).booleanValue();
				dh.setStartTimeDecision((RefOntoUML.Class)element, ((Boolean) value).booleanValue());
				treeViewer.update(element, null);
			}
		});
	}

	public void initializeCheckboxes (TreeItem[] items, DecisionHandler dh)
	{
		for (int i = 0; i < items.length; i++)
		{
			Object obj = items[i].getData();
			boolean value = dh.inScope((RefOntoUML.Classifier)obj);
			items[i].setChecked(value);
		}
	}
}
