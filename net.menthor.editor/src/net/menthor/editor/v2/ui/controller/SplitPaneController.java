package net.menthor.editor.v2.ui.controller;

import net.menthor.editor.v2.ui.SplitPane;

public class SplitPaneController  {

	SplitPane splitPane = SplitPane.get();
	
	// -------- Lazy Initialization
	
	private static class SplitLoader {
        private static final SplitPaneController INSTANCE = new SplitPaneController();
    }	
	public static SplitPaneController get() { 
		return SplitLoader.INSTANCE; 
	}	
    private SplitPaneController() {
        if (SplitLoader.INSTANCE != null) throw new IllegalStateException(this.getClass().getName()+" already instantiated");
    }		
    
    // ----------------------------
    
    public boolean isShowProjectBrowser() { 
    	return splitPane.isShowProjectBrowser(); 
    }
    
    public void forceDefaultState() { 
    	splitPane.forceDefaultState(); 
    }
    
    public void forceInitialState() { 
    	splitPane.forceInitialState(); 
    }
    
    public void showPalette() { 
    	splitPane.showPalette(); 
    }
    
    public void showProjectBrowser() { 
    	splitPane.showProjectBrowser(); 
    }
    
    public boolean isShowPalette() { 
    	return splitPane.isShowPalette(); 
    }
    
    public void forceShowInfo(){
    	splitPane.forceShowInfoTabbedPane();
    }
    
    public void showInfoTabbedPane(){
    	splitPane.showInfoTabbedPane();
    }
    
}
