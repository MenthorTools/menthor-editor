package net.menthor.ontouml2infouml.ui.tab;

import net.menthor.ontouml2infouml.decision.DecisionHandler;
import net.menthor.ontouml2infouml.ui.content.HistoryTimeModel;
import net.menthor.ontouml2infouml.ui.content.SimpleContentProvider;
import net.menthor.ontouml2infouml.ui.util.BooleanCellEditor;
import net.menthor.ontouml2infouml.ui.util.EmulatedNativeCheckBoxLabelProvider;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import RefOntoUML.util.RefOntoUMLModelAbstraction;

public class TimeTrackingTab extends TrackingTab
{	
	public String getName()
	{
		return "Time";
	}
	
	public Control getControl(Composite parent, RefOntoUMLModelAbstraction ma, final DecisionHandler dh)
	{
		return treeViewerTime(parent, ma, dh).getTree();
	}
	
	public TreeViewer treeViewerTime (final Composite parent, RefOntoUMLModelAbstraction ma, final DecisionHandler dh)
	{
		final TreeViewer viewer = treeViewerHistoryAndTime (parent, ma, dh);
		
		// BooleanCellEditor is a custom class created by a guy in JFace Snippets
		final BooleanCellEditor booleanCellEditor = new BooleanCellEditor(viewer.getTree());
		booleanCellEditor.setChangeOnActivation(true);
		
		// Column 2 (Start Time)
		TreeViewerColumn column = new TreeViewerColumn(viewer, SWT.CENTER);
		column.getColumn().setWidth(200);
		column.getColumn().setMoveable(true);
		column.getColumn().setText("Start Time");
		column.setLabelProvider(new EmulatedNativeCheckBoxLabelProvider(viewer)
		{
			protected boolean isChecked(Object element)
			{
				//System.out.println(((RefOntoUML.Class)element).getName());
				return dh.getStartTimeDecision((RefOntoUML.Class)element);
			}
		});
		column.setEditingSupport(new EditingSupport(viewer)
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
				return new Boolean(dh.getStartTimeDecision((RefOntoUML.Class)element));
			}

			protected void setValue(Object element, Object value)
			{
				//((File) element).read = ((Boolean) value).booleanValue();
				dh.setStartTimeDecision((RefOntoUML.Class)element, ((Boolean) value).booleanValue());
				viewer.update(element, null);
			}
		});
		
		// Column 3 (End Time)
		column = new TreeViewerColumn(viewer, SWT.CENTER);
		column.getColumn().setWidth(200);
		column.getColumn().setMoveable(true);
		column.getColumn().setText("End Time");
		column.setLabelProvider(new EmulatedNativeCheckBoxLabelProvider(viewer)
		{
			protected boolean isChecked(Object element)
			{
				//System.out.println(((RefOntoUML.Class)element).getName());
				return dh.getEndTimeDecision((RefOntoUML.Class)element);
			}
		});
		column.setEditingSupport(new EditingSupport(viewer)
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
				return new Boolean(dh.getEndTimeDecision((RefOntoUML.Class)element));
			}

			protected void setValue(Object element, Object value)
			{
				dh.setEndTimeDecision((RefOntoUML.Class)element, ((Boolean) value).booleanValue());
				viewer.update(element, null);
			}
		});
		
		// Column 4 (Duration)
		column = new TreeViewerColumn(viewer, SWT.CENTER);
		column.getColumn().setWidth(200);
		column.getColumn().setMoveable(true);
		column.getColumn().setText("Duration");
		column.setLabelProvider(new EmulatedNativeCheckBoxLabelProvider(viewer)
		{
			protected boolean isChecked(Object element)
			{
				//System.out.println(((RefOntoUML.Class)element).getName());
				return dh.getDurationDecision((RefOntoUML.Class)element);
			}
		});
		column.setEditingSupport(new EditingSupport(viewer)
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
				return new Boolean(dh.getDurationDecision((RefOntoUML.Class)element));
			}

			protected void setValue(Object element, Object value)
			{
				dh.setDurationDecision((RefOntoUML.Class)element, ((Boolean) value).booleanValue());
				viewer.update(element, null);
			}
		});
		
		// ContentProvider and Input
		viewer.setContentProvider(new SimpleContentProvider());
		viewer.setInput((new HistoryTimeModel(ma)).model);
		
		return viewer;
	}
}
