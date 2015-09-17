package net.menthor.ontouml2infouml.ui.tab;

import net.menthor.ontouml2infouml.decision.DecisionHandler;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationStrategy;
import org.eclipse.jface.viewers.FocusCellOwnerDrawHighlighter;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.TreeViewerEditor;
import org.eclipse.jface.viewers.TreeViewerFocusCellManager;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;

import RefOntoUML.util.RefOntoUMLModelAbstraction;

public abstract class TrackingTab implements Tab
{
	public static TreeViewer treeViewerHistoryAndTime (final Composite parent, RefOntoUMLModelAbstraction ma, final DecisionHandler dh)
	{
		final TreeViewer viewer = new TreeViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		viewer.getTree().setLinesVisible(true);
		viewer.getTree().setHeaderVisible(true);
		viewer.getTree().setBackgroundMode(SWT.INHERIT_DEFAULT);
		
		// The focusing thing... To focus on a table cell, instead of a table row (and other things I don't know)
		FocusCellOwnerDrawHighlighter h = new FocusCellOwnerDrawHighlighter(viewer)
		{
			protected Color getSelectedCellBackgroundColorNoFocus(ViewerCell cell)
			{
				//return parent.getDisplay().getSystemColor(SWT.COLOR_WHITE);
				 return parent.getDisplay().getSystemColor(SWT.COLOR_LIST_SELECTION);
			}

			protected Color getSelectedCellForegroundColorNoFocus(ViewerCell cell)
			{
				// I'm not sure where this color appears
				//return parent.getDisplay().getSystemColor(SWT.COLOR_WHITE);
				return parent.getDisplay().getSystemColor(SWT.COLOR_WIDGET_FOREGROUND);
			}
		};

		TreeViewerFocusCellManager focusCellManager = new TreeViewerFocusCellManager(viewer, h);
		ColumnViewerEditorActivationStrategy actSupport = new ColumnViewerEditorActivationStrategy(viewer);

		TreeViewerEditor.create(viewer, focusCellManager, actSupport,
				ColumnViewerEditor.TABBING_HORIZONTAL |
				ColumnViewerEditor.TABBING_MOVE_TO_ROW_NEIGHBOR |
				ColumnViewerEditor.TABBING_VERTICAL |
				ColumnViewerEditor.KEYBOARD_ACTIVATION);
				
		// Column 1 (Universal)
		TreeViewerColumn column = new TreeViewerColumn(viewer, SWT.LEFT);
		column.getColumn().setText("Universal");
		column.getColumn().setWidth(200);
		column.setLabelProvider(new ColumnLabelProvider()
		{
			public String getText(Object element)
			{
				return ((RefOntoUML.Class)element).getName();
			}
		});		
		return viewer;
	}
}
