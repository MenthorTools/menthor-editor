package net.menthor.editor.v2.ui.manager;

public class SplitPaneUIManager extends GenericUIManager {

	// -------- Lazy Initialization
	
	private static class SplitLoader {
        private static final SplitPaneUIManager INSTANCE = new SplitPaneUIManager();
    }	
	public static SplitPaneUIManager get() { 
		return SplitLoader.INSTANCE; 
	}	
    private SplitPaneUIManager() {
        if (SplitLoader.INSTANCE != null) throw new IllegalStateException("SplitManager already instantiated");
    }		
    
    // ----------------------------
    
    public boolean isShowProjectBrowser() { 
    	return splitPane().isShowProjectBrowser(); 
    }
    
    public boolean isShowPalette() { 
    	return splitPane().isShowPalette(); 
    }
    
    public void forceShowInfo(){
    	splitPane().forceShowInfoTabbedPane();
    }
    
}
