package net.menthor.pattern.ui.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import net.menthor.pattern.dynamic.ui.ActiveCheckListener;
import net.menthor.pattern.dynamic.ui.AddLineButtonListener;
import net.menthor.pattern.dynamic.ui.DynamicWindow;
import net.menthor.pattern.dynamic.ui.PartitionGeneralizationSetCheckListener;
import net.menthor.pattern.dynamic.ui.ReuseCheckListener;
import net.menthor.pattern.dynamic.ui.ReuseGeneralizationSetCheckListener;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import RefOntoUML.GeneralizationSet;

public class DynamicManagerWindow {

	private DynamicWindow window; 
	private HashMap<String, String[]> hashTree;
	private HashMap<String, ArrayList<String>> hashGS;

	public DynamicManagerWindow(DynamicWindow dynwin) {
		window = dynwin;
		addTableHeaders();
	}

	public void addHashTree(HashMap<String, String[]> hash){
		hashTree = hash;
	}

	public TableItem addTableLine(String dataValue, String className, String[] stereotypes){
		Table table = window.getTable();

		//add dataValue to dataValue to future using
		window.addDataField(dataValue);

		TableItem tableItem = new TableItem(table, SWT.NONE);
		ArrayList<TableEditor> editors = new ArrayList<>();

		//Check
		TableEditor	editor = new TableEditor (table);
		Button btnActive = new Button (table, SWT.CHECK);
		btnActive.pack ();
		editor.minimumWidth = btnActive.getSize ().x;
		editor.horizontalAlignment = SWT.CENTER;
		editor.setEditor (btnActive, tableItem, 0);
		tableItem.setData("active_"+dataValue, btnActive);
		editors.add(editor);

		//Text
		editor = new TableEditor (table);
		Text text = new Text (table, SWT.NONE);
		text.setText(className);
		editor.grabHorizontal = true;
		editor.horizontalAlignment = SWT.CENTER;
		editor.setEditor(text, tableItem, 1);
		tableItem.setData("text_"+dataValue, text);
		editors.add(editor);

		//Combo
		CCombo combo = new CCombo(table, SWT.NONE);
		combo.setItems(stereotypes);
		combo.select(0);
		combo.setEditable(false);
		combo.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
		editor = new TableEditor (table);
		editor.grabHorizontal = true;
		editor.horizontalAlignment = SWT.CENTER;
		editor.setEditor(combo, tableItem, 2);
		tableItem.setData("stereotype_"+dataValue, combo);
		editors.add(editor);

		//Check
		editor = new TableEditor (table);
		Button btnReuse = new Button (table, SWT.CHECK);
		btnReuse.pack ();
		editor.minimumWidth = btnReuse.getSize ().x;
		editor.horizontalAlignment = SWT.CENTER;
		editor.setEditor (btnReuse, tableItem, 3);
		tableItem.setData("reuse_"+dataValue, btnReuse);
		editors.add(editor);


		window.addTableEditor(tableItem, editors);
		window.addUsedStereotypes(stereotypes);

		//Add to reuse checkButton listener 
		btnReuse.addSelectionListener(new ReuseCheckListener(statusList,hashTree, null, text, combo));
		btnActive.addSelectionListener(new ActiveCheckListener(statusList, tableItem, text, combo,btnReuse));

		return tableItem;
	}

	public TableItem addTableRigidLine(String dataValue, String className, String[] stereotypes){
		Table table = window.getTable();

		//add dataValue to dataValue to future using
		window.addDataField(dataValue);

		TableItem tableItem = new TableItem(table, SWT.NONE);
		ArrayList<TableEditor> editors = new ArrayList<>();

		//Check
		TableEditor	editor = new TableEditor (table);
		Button btnActive = new Button (table, SWT.CHECK);
		btnActive.pack ();
		btnActive.setSelection(false);
		btnActive.setEnabled(false);
		editor.minimumWidth = btnActive.getSize ().x;
		editor.horizontalAlignment = SWT.CENTER;
		editor.setEditor (btnActive, tableItem, 0);
		tableItem.setData("active_"+dataValue, btnActive);
		editors.add(editor);

		//Text
		editor = new TableEditor (table);
		Text text = new Text (table, SWT.NONE);
		text.setText(className);
		text.setEnabled(false);
		editor.grabHorizontal = true;
		editor.horizontalAlignment = SWT.CENTER;
		editor.setEditor(text, tableItem, 1);
		tableItem.setData("text_"+dataValue, text);
		editors.add(editor);

		//Combo
		CCombo combo = new CCombo(table, SWT.NONE);
		combo.setItems(stereotypes);
		combo.select(0);
		combo.setEditable(false);
		combo.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
		combo.setEnabled(false);
		editor = new TableEditor (table);
		editor.grabHorizontal = true;
		editor.horizontalAlignment = SWT.CENTER;
		editor.setEditor(combo, tableItem, 2);
		tableItem.setData("stereotype_"+dataValue, combo);
		editors.add(editor);

		//Check
		editor = new TableEditor (table);
		Button btnReuse = new Button (table, SWT.CHECK);
		btnReuse.pack ();
		btnReuse.setSelection(true);
		btnReuse.setEnabled(false);
		editor.minimumWidth = btnReuse.getSize ().x;
		editor.horizontalAlignment = SWT.CENTER;
		editor.setEditor (btnReuse, tableItem, 3);
		tableItem.setData("reuse_"+dataValue, btnReuse);
		editors.add(editor);

		window.addTableEditor(tableItem, editors);

		return tableItem;
	}
	/**
	 * The initial value of the grid
	 * */
	public void setInitialItemCount(int initialValue){
		window.setInitialItemCount(initialValue);
	}

	private void addTableHeaders() {
		Table table = window.getTable();

		//Defining columns
		TableColumn	column = new TableColumn(table, SWT.CENTER);
		column.setWidth(90);
		column.setText("Disable class?");

		column = new TableColumn(table, SWT.CENTER);
		column.setWidth(150);
		column.setText("Class Name");

		column = new TableColumn(table, SWT.CENTER);
		column.setWidth(90);
		column.setText("Stereotype");

		column = new TableColumn(table, SWT.CENTER);
		column.setWidth(133);
		column.setText("Pick up from model?");

	}

	public void setAddLineButtonAction(String dataValue, String className, String[] stereotypes){
		Button btn = window.getBtnAddNewLine();
		btn.addSelectionListener(new AddLineButtonListener(this, dataValue, className, stereotypes));
		btn.setVisible(true);

		btn = window.getBtnDeleteLine();
		btn.setVisible(true);
	}

	public boolean wasPerformed(){
		//If table isn't null something was created
		return !(window.getHashTable() == null);
	}

	public ArrayList<Object[]> getRowsOf(String field){
		if(window.getHashTable() == null)
			return null;
		return  window.getHashTable().get(field);
	}

	public String getGeneralizationSetName(){
		return window.getGeneralizationSetName();
	}

	public void addHashGS(HashMap<String, ArrayList<String>> hash) {
		hashGS = hash;
	}

	public void reuseGeneralizationSetPattern(Set<GeneralizationSet> gs) {
		window.isPartitionPattern(true);
		if(hashGS.isEmpty()){
			window.getBtnReuseGS().setVisible(false);
		}else{
			window.getBtnReuseGS().setVisible(true);
			window.addReuseGSListener(new ReuseGeneralizationSetCheckListener(this,hashGS,window.getEditors(), window.getTxGSNaming(), gs));
		}
	}
	
	public void isPartitionPattern(Set<GeneralizationSet> gs) {
		window.isPartitionPattern(true);
		if(hashGS.isEmpty()){
			window.getBtnReuseGS().setVisible(false);
		}else{
			window.getBtnReuseGS().setVisible(true);
			window.addReuseGSListener(new PartitionGeneralizationSetCheckListener(this,hashGS,window.getEditors(), window.getTxGSNaming(), gs));
		}
	}
	
	private boolean GSReuse = false;
	public void setGSReuse(boolean bool){
		GSReuse = bool;
	}
	
	public boolean isGSReuse() {
		return GSReuse;
	}
	
	private ArrayList<String> statusList = new ArrayList<>();
	public ArrayList<String> getStatus() {
		return statusList;
	}
}
