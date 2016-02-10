package net.menthor.editor.v2.managers;

import javax.swing.tree.DefaultMutableTreeNode;

import net.menthor.editor.v2.ui.app.AppManager;

public class BrowserManager extends AppManager {

	// -------- Lazy Initialization
	
	private static class BrowserLoader {
        private static final BrowserManager INSTANCE = new BrowserManager();
    }	
	public static BrowserManager get() { 
		return BrowserLoader.INSTANCE; 
	}	
    private BrowserManager() {
        if (BrowserLoader.INSTANCE != null) throw new IllegalStateException("BrowserManager already instantiated");
    }		
    
    // ----------------------------
    
    public DefaultMutableTreeNode add(DefaultMutableTreeNode node, Object child){
    	return browser().getTree().addChild((DefaultMutableTreeNode)node, child);
    }
    
    public DefaultMutableTreeNode root(){
    	return browser().getTree().getRootNode();
    }
    
    public void updateUI(){
    	browser().getTree().updateUI();
    }
    
    public void remove(){
    	browser().getTree().removeCurrentNode();
    }
}
