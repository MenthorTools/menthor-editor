/*******************************************************************************
 * Copyright (c) 2005, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package net.menthor.ontouml2infouml.ui.util;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorDeactivationEvent;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerRow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * @since 3.4
 * 
 */
public class BooleanCellEditor extends CellEditor
{
	private Button button;
	private ViewerRow row;
	private int index;
	private String restoredText;
	private Image restoredImage;
	
	@SuppressWarnings("unused")
	private KeyListener macSelectionListener = new KeyListener()
	{
		public void keyReleased(KeyEvent e)
		{

		}

		public void keyPressed(KeyEvent e)
		{
			if (e.character == ' ')
			{
				button.setSelection(!button.getSelection());
			}
		}
	};

	private boolean changeOnActivation;

	public BooleanCellEditor(Composite parent)
	{
		super(parent);
	}

	public BooleanCellEditor(Composite parent, int style)
	{
		super(parent, style);
	}

	public LayoutData getLayoutData()
	{
		LayoutData data = super.getLayoutData();
		data.horizontalAlignment = SWT.CENTER;
		data.grabHorizontal = false;
		return data;
	}

	protected Control createControl(Composite parent)
	{
		Font font = parent.getFont();
		Color bg = parent.getBackground();

		button = new Button(parent, getStyle() | SWT.CHECK);
		button.setFont(font);
		button.setBackground(bg);

		button.addKeyListener(new KeyAdapter()
		{
			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyReleased(org.eclipse.swt.events.KeyEvent)
			 */
			public void keyReleased(KeyEvent e)
			{
				if (e.character == SWT.ESC)
				{
					fireCancelEditor();
				}
			}

		});
		
		// rcarraretto
		button.addListener (SWT.Selection, new Listener()
		{
			public void handleEvent (Event e)
			{
				//System.out.println("%%%%%% fireApplyEditorValue() %%%%%%%%%");
				fireApplyEditorValue(); // this works
			}
		});

		return button;
	}

	protected Object doGetValue()
	{
		//System.out.println("doGetValue();");
		return new Boolean(button.getSelection());
	}

	protected void doSetValue(Object value)
	{
		//System.out.println("doSetValue(" + value + ");");
		boolean selection = Boolean.TRUE.equals(value);
		button.setSelection(selection);
	}

	protected void doSetFocus()
	{
		if (button != null)
		{
			button.setFocus();
		}
	}

	protected void deactivate(ColumnViewerEditorDeactivationEvent event)
	{
		//System.out.println("--> deactivate()");
		super.deactivate(event);
		if (event.eventType == ColumnViewerEditorDeactivationEvent.EDITOR_CANCELED)
		{
			row.setImage(index, restoredImage);
			row.setText(index, restoredText);
		}

		// TODO Add a way to enable key traversal when CheckBoxes don't get focus
		// if( Util.isMac() ) {
		// button.getParent().removeKeyListener(macSelectionListener);
		// }

		row = null;
		restoredImage = null;
		restoredText = null;
	}

	public void activate(ColumnViewerEditorActivationEvent activationEvent)
	{
		ViewerCell cell = (ViewerCell) activationEvent.getSource();
		index = cell.getColumnIndex();
		row = (ViewerRow) cell.getViewerRow().clone();
		restoredImage = row.getImage(index);
		restoredText = row.getText(index);
		row.setImage(index, null);
		row.setText(index, ""); //$NON-NLS-1$

		if (activationEvent.eventType != ColumnViewerEditorActivationEvent.TRAVERSAL && changeOnActivation)
		{
			//System.out.println("!!!!!!!! activate() !!!!!!!!\n");
			//button.setSelection(!button.getSelection()); // original code
						
			// rcarraretto (this almost works)
			/* The problem is: the class that calls [Boolean]CellEditor.activate() also calls, further on, other methods of CellEditor 
			 * So, since I programmed this SWT.Selection to fireApplyEditorValue()
			 * This will deactivate() this CellEditor and will generate a NullPointerException
			 * Perhaps, a way to solve this is to extend and override the class and the method that calls [Boolean]CellEditor.activate()
			 */
			//button.notifyListeners(SWT.Selection, new Event());
		}

		// TODO Add a way to enable key traversal when CheckBoxes don't get focus
		// if( Util.isMac() ) {
		// button.getParent().addKeyListener(macSelectionListener);
		// }

		super.activate(activationEvent);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.CellEditor#getDoubleClickTimeout()
	 */
	protected int getDoubleClickTimeout()
	{
		return 0;
	}

	public void setChangeOnActivation(boolean changeOnActivation)
	{
		this.changeOnActivation = changeOnActivation;
	}
}
