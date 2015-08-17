package net.menthor.editor.v2.tables;


@SuppressWarnings("unchecked")
public class ProblemTableModel extends BaseTableModel {

	protected Object[][] data = {};
	
	public ProblemTableModel(String[] columnNames, Object[][] data) {
		super(columnNames);
		this.data=data;
	}

	private static final long serialVersionUID = 2591826891550137150L;

	   public int getRowCount(){
	        if(data!=null) return data.length; else return 0;
	    }

	    
	    public Object getValueAt(int row, int col){
	        return data[row][col];
	    }
	    
	    public void setValueAt(Object value, int row, int col){ 
	        data[row][col] = value;
	        fireTableCellUpdated(row, col); 
	    }
	    
	    public String getData(){
	        int numRows = getRowCount();
	        int numCols = getColumnCount();
	        String result = new String();
	        for (int i=0; i < numRows; i++) {            	
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
	    
	@Override
	public void addEntry(Object entry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEmptyEntry() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getEntries() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void moveUpEntry(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveDownEntry(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEntryAt(int index) {
		// TODO Auto-generated method stub
		
	}

}
