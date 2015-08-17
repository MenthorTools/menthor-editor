package net.menthor.editor.v2.tables;

@SuppressWarnings("unchecked")
public class DataTableModel extends BaseTableModel {

	private static final long serialVersionUID = 2591826891550137150L;
	
	protected Object[][] data = {};
	
	//==========================================================
	//CONSTRUCTOR
	//==========================================================
	
	public DataTableModel(String[] columnNames, Object[][] data) {
		super(columnNames);
		this.data=data;
	}

	public DataTableModel(String[] columnNames) {
		super(columnNames);
	}
	
	//==========================================================
	//OVERRIDE: ENTRIES
	//==========================================================
	
	@Override
	public void addEmptyEntry() {}

	@Override
	public void removeEntryAt(int index) { }
	
	//==========================================================
	//OVERRIDE: COLUMNS & ROWS
	//==========================================================
	
	public int getRowCount(){
		if(data!=null) return data.length; else return 0;
	}
	
	//==========================================================
	//OVERRIDE: VALUES
	//==========================================================
	
	public Object getValueAt(int row, int col){
		if(data!=null) return data[row][col]; else return null;
	}
	    
	public void setValueAt(Object value, int row, int col){ 
		if(data!=null) {
			data[row][col] = value;
			fireTableCellUpdated(row, col);
		}
	}
	    
    public String getDataAsString(){
        int numRows = getRowCount();
        int numCols = getColumnCount();
        String result = new String();
        for (int i=0; i < numRows; i++){            	
            for (int j=0; j < numCols; j++){                	
            	if(j>0){                		
            		String elem = (String)data[i][j];
            		result += "  " + elem.trim()+"\n";                		
            	}else if (j==0){
            		String title = (String)data[i][j];                		
            		if(!title.trim().isEmpty()){
            			result += "  "+"\n"+title+"\n\n";
            		}else{
            			result += "\n";
            		}
            	}
            }                
        }
        return result;
    }
}
