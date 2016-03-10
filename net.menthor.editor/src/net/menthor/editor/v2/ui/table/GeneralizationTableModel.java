package net.menthor.editor.v2.ui.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import RefOntoUML.Generalization;
import RefOntoUML.parser.OntoUMLNameHelper;

public class GeneralizationTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	
	private String[] columnNames = { "Direct","Stereotype","Specific","General" };
    private List<Generalization> genList;
    private Object element;
    
    public GeneralizationTableModel(Object element, List<Generalization> genList){
    	this.genList = genList;
    	this.element = element;
    }

    @Override
    public int getColumnCount() { return columnNames.length; }

    @Override
    public int getRowCount() { return genList.size(); }

    @Override
    public String getColumnName(int col) { return columnNames[col]; }

    @Override
	public Class<?> getColumnClass(int c) { return String.class; }
    
    @Override
    public Object getValueAt(int row, int col) 
    {
    	Generalization gen = (Generalization)genList.get(row);
    	if (col==1){
    		return OntoUMLNameHelper.getTypeName(gen, true);
    	}	    	
    	else if(col==0){
    		if (gen.getGeneral().equals(element) || gen.getSpecific().equals(element))
    			return "Yes";
    		else
    			return "No";
    	}
    	else if(col==2){
    		return gen.getSpecific().getName();
    	}
    	else if(col==3){
    		return gen.getGeneral().getName();
    	}
    	else return new String("<empty entry>");
    }
}
