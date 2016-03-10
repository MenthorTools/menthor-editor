package net.menthor.editor.v2.ui.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import RefOntoUML.Association;
import RefOntoUML.parser.OntoUMLNameHelper;

public class AssociationTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;		
	
	private String[] columnNames = { "Direct", "Stereotype","Name","Source","Target" };
    private List<Association> assocList;
    private Object element;
    
    public AssociationTableModel(Object element, List<Association> list)  { 
    	this.assocList = list; 
    	this.element = element;
    }
    
    @Override
    public int getColumnCount() { return columnNames.length; }
    
    @Override
    public int getRowCount() { return assocList.size(); }
    
    @Override
    public String getColumnName(int col) { return columnNames[col]; }
    
    @Override
	public Class<?> getColumnClass(int column) { return String.class; }
    
    @Override
    public Object getValueAt(int row, int col){
    	Association assoc = (Association)assocList.get(row);
    	if (col==1){
    		return OntoUMLNameHelper.getTypeName(assoc, true);
    	} else if(col==2){
    		return assoc.getName();
    	} else if(col==0){
    		if (assoc.getMemberEnd().get(0).getType().equals(element) || assoc.getMemberEnd().get(1).getType().equals(element))
    			return "Yes";
    		else
    			return "No";
    	} else if(col==3){
    		return assoc.getMemberEnd().get(0).getType().getName();
    	} else if(col==4){
    		return assoc.getMemberEnd().get(1).getType().getName();
    	} else return new String("<empty entry>");
    }    
}
