package net.menthor.ontouml2infouml.ui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.menthor.ontouml2infouml.OntoUML2InfoUML;
import net.menthor.ontouml2infouml.decision.DecisionHandler;
import net.menthor.ontouml2infouml.impl.Transformation;
import net.menthor.ontouml2infouml.ui.tab.HistoryTrackingTab;
import net.menthor.ontouml2infouml.ui.tab.MeasurementTab;
import net.menthor.ontouml2infouml.ui.tab.ReferenceTab;
import net.menthor.ontouml2infouml.ui.tab.ScopeTab;
import net.menthor.ontouml2infouml.ui.tab.Tab;
import net.menthor.ontouml2infouml.ui.tab.TimeTrackingTab;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

import RefOntoUML.util.RefOntoUMLModelAbstraction;

// Tree with columns: Snippet 170, 193, 220, 226, 274, 312
public class Onto2InfoInterface
{
	Text text = null;
	Text log = null;
	IProject project = null;
	
	public Onto2InfoInterface ()
	{
		
	}
	
	public Display createDisplay()
	{
		try
		{
			// For Plugin
			return Display.getDefault();//PlatformUI.getWorkbench().getDisplay();
		}
		catch (Exception e)
		{
			// For Development
			return new Display();
		}
	}
	
	public void refreshWorkspace()
	{
		if (project != null)
		{
			try
			{
				project.refreshLocal(IResource.DEPTH_INFINITE, null);
			}
			catch (CoreException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void load (final RefOntoUMLModelAbstraction ma, final DecisionHandler dh, final Transformation t, IProject project)
	{
		this.project = project;
		
		Display display = createDisplay();		
		final Shell shell = new Shell(display);
		shell.setText("InfoUML Settings");
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		shell.setLayout(layout);
			
		DecisionTabFolder(shell, ma, dh);
		
		// Transform Button
		Button tbutton = new Button(shell, SWT.PUSH);
		tbutton.setText("Transform");
		tbutton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		LogTabFolder(shell);
	    		
	    // Transform Button Action
		tbutton.addSelectionListener(new SelectionAdapter()
		{
			public void widgetSelected(SelectionEvent e)
			{
				t.transform(dh);
			}
		});
		
		// Shell
		shell.pack();		
		shell.open();
		while (!shell.isDisposed())
		{
			if (!display.readAndDispatch()) display.sleep();
		}
		//display.dispose();
	}
	
	public void DecisionTabFolder (Composite parent, RefOntoUMLModelAbstraction ma, DecisionHandler dh)
	{
		// Tab Folder
		final TabFolder tabFolder = new TabFolder (parent, SWT.BORDER);
		Rectangle clientArea = parent.getClientArea();
		tabFolder.setLocation (clientArea.x, clientArea.y);
		
		Tab[] tabs = new Tab[5];
		tabs[0] = new ScopeTab();
		tabs[1] = new HistoryTrackingTab();
		tabs[2] = new TimeTrackingTab();
		tabs[3] = new ReferenceTab();
		tabs[4] = new MeasurementTab();
		
		for (int i=0; i<tabs.length; i++)
		{
			TabItem item = new TabItem (tabFolder, SWT.NONE);
			String text = tabs[i].getName();
			Control control = tabs[i].getControl(tabFolder, ma, dh);
									
			if (text != null && control != null)
			{
				item.setText(text);
				item.setControl(control);
			}
		}
		tabFolder.pack();
	}
	
	public void LogTabFolder (Composite parent)
	{
		// Tab Folder
		final TabFolder tabFolder = new TabFolder (parent, SWT.BORDER);		
	    tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
	    
	    // TabFolder (inside) Layout
	    GridLayout layout = new GridLayout();
	    layout.numColumns = 1;
	    tabFolder.setLayout(layout);
	    
	    // Text in "Details" Tab
	    text = new Text(tabFolder, SWT.READ_ONLY | SWT.H_SCROLL | SWT.V_SCROLL);
	    GridData textLayoutData = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
	    textLayoutData.heightHint = 100;
	    text.setLayoutData(textLayoutData);
	    
		// TabItem
		TabItem item = new TabItem (tabFolder, SWT.NONE);
		item.setText("Details");
		item.setControl(text);
	    
		// Text in "Log" Tab
		log = new Text(tabFolder, SWT.READ_ONLY | SWT.H_SCROLL | SWT.V_SCROLL);
		//GridData logLayoutData = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		//logLayoutData.heightHint = 100;
		//log.setLayoutData(logLayoutData);
		
		// TabItem
		item = new TabItem(tabFolder, SWT.NONE);
		item.setText("Log");
		item.setControl(log);

		OntoUML2InfoUML.initialCallback();
	}
	
	public String timestampHeader ()
	{
	    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public void writeText (String message)
	{
		text.append(timestampHeader() + "> " + message + "\n");
	}
	
	public void writeLog (String message)
	{
		log.append(timestampHeader() + "> " + message + "\n");
	}
}
