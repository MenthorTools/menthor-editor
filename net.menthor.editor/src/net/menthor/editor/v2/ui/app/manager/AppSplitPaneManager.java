package net.menthor.editor.v2.ui.app.manager;

public class AppSplitPaneManager extends AppGenericManager {

	// -------- Lazy Initialization
	
	private static class SplitLoader {
        private static final AppSplitPaneManager INSTANCE = new AppSplitPaneManager();
    }	
	public static AppSplitPaneManager get() { 
		return SplitLoader.INSTANCE; 
	}	
    private AppSplitPaneManager() {
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
