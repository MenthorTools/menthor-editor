package net.menthor.editor.v2.ui.manager;

import net.menthor.editor.v2.ui.app.AppManager;

public class SplitManager extends AppManager {

	// -------- Lazy Initialization
	
	private static class SplitLoader {
        private static final SplitManager INSTANCE = new SplitManager();
    }	
	public static SplitManager get() { 
		return SplitLoader.INSTANCE; 
	}	
    private SplitManager() {
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
