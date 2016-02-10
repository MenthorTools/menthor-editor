package net.menthor.editor.v2.ui.manager;

import javax.swing.tree.DefaultMutableTreeNode;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.EnumerationLiteral;
import RefOntoUML.Generalization;
import net.menthor.editor.v2.managers.ProjectManager;
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
    
    public DefaultMutableTreeNode selected(){
    	return browser().getTree().getSelectedNode();
    }
    
    public DefaultMutableTreeNode root(){
    	return browser().getTree().getRootNode();
    }
    
    public void updateUI(){
    	browser().getTree().updateUI();
    }
    
    public void remove(RefOntoUML.Element o){
    	browser().getTree().remove(o);
    }
    
    public void remove(){
    	browser().getTree().removeCurrentNode();
    }
    
    public void moveDown(){
    	browser().getTree().moveDown();
    }
    
    public void moveUp(){
    	browser().getTree().moveUp();
    }
    
    public void add(EObject addedElement){
    	boolean found = browser().getTree().checkObject(addedElement);
		if(!found) {
			if(addedElement.eContainer()!=null) browser().getTree().checkObject(addedElement.eContainer());
			else if(addedElement instanceof EnumerationLiteral) browser().getTree().checkObject(((EnumerationLiteral)addedElement).getEnumeration());
			else browser().getTree().checkObject(ProjectManager.get().getProject().getModel());					
			browser().getTree().addChild(addedElement);					
		} else {
			if(addedElement instanceof Generalization){
				browser().getTree().checkObject(addedElement);
				browser().getTree().removeCurrentNode();
				browser().getTree().checkObject(addedElement.eContainer());
				browser().getTree().addChild(addedElement);
			}
		}
		browser().getTree().updateUI();		
    }
}
