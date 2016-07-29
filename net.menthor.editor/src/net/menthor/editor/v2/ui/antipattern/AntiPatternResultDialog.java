package net.menthor.editor.v2.ui.antipattern;

/**
 * ============================================================================================
 * Menthor Editor -- Copyright (c) 2015 
 *
 * This file is part of Menthor Editor. Menthor Editor is based on TinyUML and as so it is 
 * distributed under the same license terms.
 *
 * Menthor Editor is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 *
 * Menthor Editor is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Menthor Editor; 
 * if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, 
 * MA  02110-1301  USA
 * ============================================================================================
 */

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.wb.swt.layout.grouplayout.GroupLayout;
import org.eclipse.wb.swt.layout.grouplayout.LayoutStyle;

import net.menthor.antipattern.AntiPatternList;
import net.menthor.antipattern.AntipatternOccurrence;
import net.menthor.antipattern.GSRig.GSRigAntipattern;
import net.menthor.antipattern.GSRig.GSRigOccurrence;
import net.menthor.antipattern.asscyc.AssCycAntipattern;
import net.menthor.antipattern.asscyc.AssCycOccurrence;
import net.menthor.antipattern.binover.BinOverAntipattern;
import net.menthor.antipattern.binover.BinOverOccurrence;
import net.menthor.antipattern.decint.DecIntAntipattern;
import net.menthor.antipattern.decint.DecIntOccurrence;
import net.menthor.antipattern.depphase.DepPhaseAntipattern;
import net.menthor.antipattern.depphase.DepPhaseOccurrence;
import net.menthor.antipattern.freerole.FreeRoleAntipattern;
import net.menthor.antipattern.freerole.FreeRoleOccurrence;
import net.menthor.antipattern.hetcoll.HetCollAntipattern;
import net.menthor.antipattern.hetcoll.HetCollOccurrence;
import net.menthor.antipattern.homofunc.HomoFuncAntipattern;
import net.menthor.antipattern.homofunc.HomoFuncOccurrence;
import net.menthor.antipattern.impabs.ImpAbsAntipattern;
import net.menthor.antipattern.impabs.ImpAbsOccurrence;
import net.menthor.antipattern.mixiden.MixIdenAntipattern;
import net.menthor.antipattern.mixiden.MixIdenOccurrence;
import net.menthor.antipattern.mixrig.MixRigAntipattern;
import net.menthor.antipattern.mixrig.MixRigOccurrence;
import net.menthor.antipattern.multidep.MultiDepAntipattern;
import net.menthor.antipattern.multidep.MultiDepOccurrence;
import net.menthor.antipattern.partover.PartOverAntipattern;
import net.menthor.antipattern.partover.PartOverOccurrence;
import net.menthor.antipattern.relcomp.RelCompAntipattern;
import net.menthor.antipattern.relcomp.RelCompOccurrence;
import net.menthor.antipattern.relover.RelOverAntipattern;
import net.menthor.antipattern.relover.RelOverOccurrence;
import net.menthor.antipattern.relrig.RelRigAntipattern;
import net.menthor.antipattern.relrig.RelRigOccurrence;
import net.menthor.antipattern.relspec.RelSpecAntipattern;
import net.menthor.antipattern.relspec.RelSpecOccurrence;
import net.menthor.antipattern.reprel.RepRelAntipattern;
import net.menthor.antipattern.reprel.RepRelOccurrence;
import net.menthor.antipattern.undefformal.UndefFormalAntipattern;
import net.menthor.antipattern.undefformal.UndefFormalOccurrence;
import net.menthor.antipattern.undefphase.UndefPhaseAntipattern;
import net.menthor.antipattern.undefphase.UndefPhaseOccurrence;
import net.menthor.antipattern.wholeover.WholeOverAntipattern;
import net.menthor.antipattern.wholeover.WholeOverOccurrence;
import net.menthor.antipattern.wizard.asscyc.AssCycWizard;
import net.menthor.antipattern.wizard.binover.BinOverWizard;
import net.menthor.antipattern.wizard.decint.DecIntWizard;
import net.menthor.antipattern.wizard.depphase.DepPhaseWizard;
import net.menthor.antipattern.wizard.freerole.FreeRoleWizard;
import net.menthor.antipattern.wizard.gsrig.GSRigWizard;
import net.menthor.antipattern.wizard.hetcoll.HetCollWizard;
import net.menthor.antipattern.wizard.homofunc.HomoFuncWizard;
import net.menthor.antipattern.wizard.impabs.ImpAbsWizard;
import net.menthor.antipattern.wizard.mixiden.MixIdenWizard;
import net.menthor.antipattern.wizard.mixrig.MixRigWizard;
import net.menthor.antipattern.wizard.multidep.MultiDepWizard;
import net.menthor.antipattern.wizard.overlapping.OverlappingWizard;
import net.menthor.antipattern.wizard.relcomp.RelCompWizard;
import net.menthor.antipattern.wizard.relrig.RelRigWizard;
import net.menthor.antipattern.wizard.relspec.RelSpecWizard;
import net.menthor.antipattern.wizard.reprel.RepRelWizard;
import net.menthor.antipattern.wizard.undefformal.UndefFormalWizard;
import net.menthor.antipattern.wizard.undefphase.UndefPhaseWizard;
import net.menthor.editor.v2.managers.AntiPatternManager;

/**
 * @author Tiago Sales
 * @author John Guerson
 *
 */
public class AntiPatternResultDialog extends Dialog {

	protected JFrame frame;
	protected Display display;
	
	protected ArrayList<AntipatternOccurrence> allOccurrences;
	protected ArrayList<AntipatternOccurrence> result;
	protected static TableViewer viewer;
	protected AntipatternResultFilter filter;
	protected Composite container;
	protected Label searchLabel;
	protected Text searchText;
	protected Button btnAnalyze;
	protected Button btnRemove;
	protected Table table;
	protected Button btnReset;
	protected Label feedBackLabel;
		
	public void showWizard(final AntipatternOccurrence apOccur, Display display){		
		WizardDialog wizardDialog = getWizardDialog(apOccur, display);		
		if(wizardDialog!=null && wizardDialog.open()==Window.OK){			
			if(!apOccur.getFix().isEmpty()){
				if(AntiPatternModifDialog.openDialog(apOccur.getFix(), frame)==Window.OK){					
					AntiPatternManager.get().transferFix(apOccur.getFix());
				}
			}
			refresh();
		}
	}	
	
	public AntiPatternResultDialog(Shell parentShell, List<AntipatternOccurrence> result, JFrame frame, Display display){
		super(parentShell);		
		this.result = new ArrayList<AntipatternOccurrence>(result);
		this.allOccurrences = new ArrayList<AntipatternOccurrence>(result);
		this.frame = frame;				
		this.display = display;
	}
	
	@Override
	public void create() {
	    super.create();
	    setShellStyle(SWT.TITLE);
	    bringToFront(getShell());
	    getShell().setText("Anti-Pattern Result");	    
	}

	public void bringToFront(final Shell shell) {
	    shell.getDisplay().asyncExec(new Runnable() {
	        public void run() {
	            shell.forceActive();
	        }
	    });
	}
	
	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) 
	{
		container = (Composite) super.createDialogArea(parent);		
		
		createPartControl(container);

		GroupLayout gl_container = new GroupLayout(container);
		gl_container.setHorizontalGroup(
			gl_container.createParallelGroup(GroupLayout.LEADING)
				.add(gl_container.createSequentialGroup()
					.addContainerGap()
					.add(gl_container.createParallelGroup(GroupLayout.LEADING)
						.add(gl_container.createSequentialGroup()
							.add(searchLabel)
							.addPreferredGap(LayoutStyle.RELATED)
							.add(searchText, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
							.add(66)
							.add(btnAnalyze, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.RELATED)
							.add(btnRemove, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.RELATED)
							.add(btnReset, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
						.add(table, GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
						.add(feedBackLabel, GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_container.setVerticalGroup(
			gl_container.createParallelGroup(GroupLayout.LEADING)
				.add(gl_container.createSequentialGroup()
					.addContainerGap()
					.add(gl_container.createParallelGroup(GroupLayout.LEADING, false)
						.add(searchLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.add(gl_container.createParallelGroup(GroupLayout.BASELINE)
							.add(searchText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.add(btnReset)
							.add(btnRemove, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.add(btnAnalyze, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addPreferredGap(LayoutStyle.UNRELATED)
					.add(table, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
					.addPreferredGap(LayoutStyle.RELATED)
					.add(feedBackLabel)
					.add(15))
		);
		container.setLayout(gl_container);
		
		return container;
	}

	public static void openDialog(final AntiPatternList apList, final JFrame frame, Display display)
	{	
    	if (apList!=null &&  !apList.getAll().isEmpty())
		{			
	    	Shell shell = new Shell(display);							
			AntiPatternResultDialog resultDIalog = new AntiPatternResultDialog(shell,apList.getAll(), frame, display);					
			resultDIalog.create();
			resultDIalog.open();				    										
		}
	}
	
	@Override
	protected void okPressed() {	
		super.okPressed();
	}
	
	@Override
	protected void cancelPressed() {	
		super.cancelPressed();
	}
	
	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) 
	{
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() 
	{
		return new Point(690, 518);
	}
	
	public void createPartControl(Composite parent) 
	{
	    
	    searchLabel = new Label(parent, SWT.NONE);
	    searchLabel.setText("Find: ");
	    
	    searchText = new Text(parent, SWT.BORDER | SWT.SEARCH);
	    
	    btnAnalyze = new Button(container, SWT.NONE);
    	btnAnalyze.setText("Analyze");
    	btnAnalyze.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				
				if(table.getSelectionIndices().length==0){
					feedBackLabel.setVisible(false);
					feedBackLabel.setText("Can't open Anti-pattern Wizard! Please select a line in the table above.");
					feedBackLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					feedBackLabel.setVisible(true);
				}
					
				else if(table.getSelectionIndices().length>1){
					feedBackLabel.setVisible(false);
					feedBackLabel.setText("Can't open Anti-pattern Wizard! Please select only ONE line in the table above.");
					feedBackLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					feedBackLabel.setVisible(true);
				}
				else if (((AntipatternOccurrence) viewer.getElementAt(table.getSelectionIndex())).isFixed()){
					feedBackLabel.setVisible(false);
					feedBackLabel.setText("Can't open Anti-pattern Wizard! Occurrence already analyzed.");
					feedBackLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					feedBackLabel.setVisible(true);
				}
				else {
					feedBackLabel.setVisible(false);
					feedBackLabel.setText("Anti-pattern Wizard Open!");
					feedBackLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
					feedBackLabel.setVisible(true);
					showWizard((AntipatternOccurrence) viewer.getElementAt(table.getSelectionIndex()), display);
				}
			}
		});   
    	btnRemove = new Button(container, SWT.NONE);
    	btnRemove.setText("Remove");
	    btnRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				
				if(table.getSelectionIndices().length==0){
					feedBackLabel.setVisible(false);
					feedBackLabel.setText("Can't remove anti-pattern occurrence from Table! Please select at least one line in the table above.");
					feedBackLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
					feedBackLabel.setVisible(true);
				}
				else {
					feedBackLabel.setVisible(false);
					feedBackLabel.setText(table.getSelectionIndices().length+" anti-pattern occurrence(s) successfully removed!");
					feedBackLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
					feedBackLabel.setVisible(true);
					
					for (int index : table.getSelectionIndices()) {
						result.remove(viewer.getElementAt(index));
					}
						
					viewer.refresh();
				}
			}
		});
	    
	    btnReset = new Button(container, SWT.NONE);
		btnReset.setText("Reset");
		btnReset.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent arg0) {
					result.clear();
					result.addAll(allOccurrences);
					viewer.refresh();
					feedBackLabel.setVisible(false);
					feedBackLabel.setText("Anti-pattern occurrence table restored!");
					feedBackLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
					feedBackLabel.setVisible(true);
				}
			});
	    
	    createViewer(parent);
	    	    
	    searchText.addKeyListener(new KeyAdapter() {
	    	public void keyReleased(KeyEvent ke) {
	    		filter.setSearchText(searchText.getText());
	    		viewer.refresh();
	    		feedBackLabel.setVisible(false);
	    		feedBackLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
	    		feedBackLabel.setText(table.getItemCount()+" results were found");
	    		feedBackLabel.setVisible(true);	    		
	    		}
	    });
	    
	    feedBackLabel = new Label(container, SWT.NONE);
		feedBackLabel.setAlignment(SWT.RIGHT);
		feedBackLabel.setVisible(false);
		
		
	    
		filter = new AntipatternResultFilter();
	    viewer.addFilter(filter);
	  }
	    
	/**
	 * Create Table Viewer
	 * @param parent
	 */
	  private void createViewer(Composite parent) 
	  {
	    
    	
    	viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
	    createColumns(parent, viewer);
	    
	    table = viewer.getTable();
	    table.setHeaderVisible(true);
	    table.setLinesVisible(true);

	    // Get the content for the viewer, setInput will call getElements in the contentProvider
	    viewer.setContentProvider(new ArrayContentProvider());
	    viewer.setInput(result);

	    // Define layout for the viewer
	    GridData gridData = new GridData();
	    gridData.verticalAlignment = GridData.FILL;
	    gridData.horizontalSpan = 2;
	    gridData.grabExcessHorizontalSpace = true;
	    gridData.grabExcessVerticalSpace = true;
	    gridData.horizontalAlignment = GridData.FILL;	    
	    viewer.getControl().setLayoutData(gridData);
	    
	  }
		
	  public TableViewer getViewer() { return viewer; }

	  /** 
	   * Create the columns for the table 
	   */
	  private void createColumns(final Composite parent, final TableViewer viewer) 
	  {
	    String[] titles = { "Name", "Type", "Status"};
	    int[] bounds = { 350, 140, 140 };

	    // First column is for a short description of the antipattern
	    TableViewerColumn col = createTableViewerColumn(titles[0], bounds[0], 0);
	    
	    col.setLabelProvider(new ColumnLabelProvider() {
	      @Override
	      public String getText(Object element) {
	    	return ((AntipatternOccurrence)element).getShortName();
	      }
	      @Override
	    	public Image getImage(Object element) {
	    	  	return super.getImage(element);
	    	}
	    });

	    // Sets the type of the antipattern
	    col = createTableViewerColumn(titles[1], bounds[1], 1);
	    
	    col.setLabelProvider(new ColumnLabelProvider() {
		@Override
	      public String getText(Object element) {	    	  
	    	  if  (element instanceof AssCycOccurrence) return AssCycAntipattern.getAntipatternInfo().getAcronym();
	    	  if  (element instanceof BinOverOccurrence) return BinOverAntipattern.getAntipatternInfo().getAcronym();
	    	  if  (element instanceof DepPhaseOccurrence) return DepPhaseAntipattern.getAntipatternInfo().getAcronym();
	    	  if  (element instanceof FreeRoleOccurrence) return FreeRoleAntipattern.getAntipatternInfo().getAcronym();
	    	  if  (element instanceof GSRigOccurrence) return GSRigAntipattern.getAntipatternInfo().getAcronym();
	    	  if  (element instanceof HetCollOccurrence) return HetCollAntipattern.getAntipatternInfo().getAcronym();
	    	  if  (element instanceof HomoFuncOccurrence) return HomoFuncAntipattern.getAntipatternInfo().getAcronym();
	    	  if  (element instanceof ImpAbsOccurrence) return ImpAbsAntipattern.getAntipatternInfo().getAcronym();
	    	  if  (element instanceof MixIdenOccurrence) return MixIdenAntipattern.getAntipatternInfo().getAcronym();
	    	  if  (element instanceof MixRigOccurrence) return MixRigAntipattern.getAntipatternInfo().getAcronym();
	    	  if  (element instanceof MultiDepOccurrence) return MultiDepAntipattern.getAntipatternInfo().getAcronym();
	    	  if  (element instanceof DecIntOccurrence) return DecIntAntipattern.getAntipatternInfo().getAcronym();
	    	  if  (element instanceof PartOverOccurrence) return PartOverAntipattern.getAntipatternInfo().getAcronym();
	    	  if  (element instanceof RelCompOccurrence) return RelCompAntipattern.getAntipatternInfo().getAcronym();
	    	  if  (element instanceof RelOverOccurrence) return RelOverAntipattern.getAntipatternInfo().getAcronym();
	    	  if  (element instanceof RelRigOccurrence) return RelRigAntipattern.getAntipatternInfo().getAcronym();
	    	  if  (element instanceof RelSpecOccurrence) return RelSpecAntipattern.getAntipatternInfo().getAcronym();
	    	  if  (element instanceof RepRelOccurrence) return RepRelAntipattern.getAntipatternInfo().getAcronym();
	    	  if  (element instanceof UndefFormalOccurrence) return UndefFormalAntipattern.getAntipatternInfo().getAcronym();
	    	  if  (element instanceof UndefPhaseOccurrence) return UndefPhaseAntipattern.getAntipatternInfo().getAcronym();
	    	  if  (element instanceof WholeOverOccurrence) return WholeOverAntipattern.getAntipatternInfo().getAcronym();
	    	  return "<error>";
	      }
	    });

	    // Set if the occurrence of the antipattern was fixed or not
	    col = createTableViewerColumn(titles[2], bounds[2], 2);
	    
	    col.setLabelProvider(new ColumnLabelProvider() {
	      @Override
	      public String getText(Object element) {
	        String value = new Boolean(((AntipatternOccurrence) element).isFixed()).toString();
	        if (value.equals("true")) return "Fixed";
	        else return "Open";
	      }
	      @Override
	    	public Color getForeground(Object element) {
	    	  String value = new Boolean(((AntipatternOccurrence) element).isFixed()).toString();
		      if (value.equals("true")) return display.getSystemColor(SWT.COLOR_DARK_GREEN);
		      else return display.getSystemColor(SWT.COLOR_DARK_RED);
	    	}
	    });
	    
//	    // Show the button to investigate the occurrence
//	    col = createTableViewerColumn(titles[3], bounds[3], 3);
//	    
//	    col.setLabelProvider(new ColumnLabelProvider() {
//	      @Override
//	      public String getText(Object element) {
//	        return "";
//	      }
//	    });
//	    
//	    // Show the button to remove the occurrence
//	    col = createTableViewerColumn(titles[4], bounds[4], 4);
//	    
//	    col.setLabelProvider(new ColumnLabelProvider() {
//	      @Override
//	      public String getText(Object element) {
//	        return "";
//	      }
//	    });
	  }

	@Override
	protected boolean isResizable() {	
		return true;
	}
	  
	private TableViewerColumn createTableViewerColumn(String title, int bound, final int colNumber) 
	{
	  final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
	  final TableColumn column = viewerColumn.getColumn();
	  column.setText(title);
	  column.setWidth(bound);
	  column.setResizable(true);
	  column.setMoveable(true);
	  return viewerColumn;
	}
	
	public void setFocus() {  viewer.getControl().setFocus();  }
	
	public static void refresh()
	{
    	viewer.refresh();
	}
	
	public WizardDialog getWizardDialog(final AntipatternOccurrence apOccur, Display d)
	{
    	WizardDialog wizardDialog = null;    	

    	if (apOccur instanceof RelRigOccurrence) 
    		wizardDialog = new WizardDialog(new Shell(d), new RelRigWizard((RelRigOccurrence)apOccur));
    	if (apOccur instanceof RelSpecOccurrence) 
    		wizardDialog = new WizardDialog(new Shell(d), new RelSpecWizard((RelSpecOccurrence)apOccur));	        		
    	if (apOccur instanceof WholeOverOccurrence) 
    		wizardDialog = new WizardDialog(new Shell(d), new OverlappingWizard((WholeOverOccurrence)apOccur,"WholeOverWizard",WholeOverAntipattern.getAntipatternInfo()));
    	if (apOccur instanceof PartOverOccurrence) 
    		wizardDialog = new WizardDialog(new Shell(d), new OverlappingWizard((PartOverOccurrence)apOccur,"PartOverWizard",PartOverAntipattern.getAntipatternInfo()));	
    	if (apOccur instanceof RelOverOccurrence) 
    		wizardDialog = new WizardDialog(new Shell(d), new OverlappingWizard((RelOverOccurrence)apOccur,"RelOverWizard",RelOverAntipattern.getAntipatternInfo()));	
    	if (apOccur instanceof RepRelOccurrence) 
    		wizardDialog = new WizardDialog(new Shell(d), new RepRelWizard((RepRelOccurrence)apOccur));
    	if (apOccur instanceof MultiDepOccurrence) 
    		wizardDialog = new WizardDialog(new Shell(d), new MultiDepWizard((MultiDepOccurrence)apOccur));
    	if (apOccur instanceof RelCompOccurrence) 
    		wizardDialog = new WizardDialog(new Shell(d), new RelCompWizard((RelCompOccurrence)apOccur));
    	if (apOccur instanceof ImpAbsOccurrence) 
    		wizardDialog = new WizardDialog(new Shell(d), new ImpAbsWizard((ImpAbsOccurrence)apOccur));
    	if (apOccur instanceof UndefFormalOccurrence) 
    		wizardDialog = new WizardDialog(new Shell(d), new UndefFormalWizard((UndefFormalOccurrence)apOccur));
    	if (apOccur instanceof HetCollOccurrence) 
    		wizardDialog = new WizardDialog(new Shell(d), new HetCollWizard((HetCollOccurrence)apOccur));
    	if (apOccur instanceof HomoFuncOccurrence) 
    		wizardDialog = new WizardDialog(new Shell(d), new HomoFuncWizard((HomoFuncOccurrence)apOccur));
    	if (apOccur instanceof AssCycOccurrence) 
    		wizardDialog = new WizardDialog(new Shell(d), new AssCycWizard((AssCycOccurrence)apOccur));
    	if (apOccur instanceof BinOverOccurrence) 
    		wizardDialog = new WizardDialog(new Shell(d), new BinOverWizard((BinOverOccurrence)apOccur));
    	if (apOccur instanceof DepPhaseOccurrence) 
    		wizardDialog = new WizardDialog(new Shell(d), new DepPhaseWizard((DepPhaseOccurrence)apOccur));
    	if (apOccur instanceof FreeRoleOccurrence) 
    		wizardDialog = new WizardDialog(new Shell(d), new FreeRoleWizard((FreeRoleOccurrence)apOccur));
    	if (apOccur instanceof GSRigOccurrence) 
    		wizardDialog = new WizardDialog(new Shell(d), new GSRigWizard((GSRigOccurrence)apOccur));
    	if (apOccur instanceof MixRigOccurrence) 
    		wizardDialog = new WizardDialog(new Shell(d), new MixRigWizard((MixRigOccurrence)apOccur));
    	if (apOccur instanceof MixIdenOccurrence) 
    		wizardDialog = new WizardDialog(new Shell(d), new MixIdenWizard((MixIdenOccurrence)apOccur));
    	if (apOccur instanceof UndefPhaseOccurrence) 
    		wizardDialog = new WizardDialog(new Shell(d), new UndefPhaseWizard((UndefPhaseOccurrence)apOccur));
    	if (apOccur instanceof DecIntOccurrence) 
    		wizardDialog = new WizardDialog(new Shell(d), new DecIntWizard((DecIntOccurrence)apOccur));
    	
    	return wizardDialog;
	}		
}
