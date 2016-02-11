package net.menthor.editor.v2.ui.app.manager;

import javax.swing.tree.DefaultMutableTreeNode;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.EnumerationLiteral;
import RefOntoUML.Generalization;

import net.menthor.editor.v2.managers.ProjectManager;

public class AppBrowserManager extends AppGenericManager {

	// -------- Lazy Initialization
	
	private static class BrowserLoader {
        private static final AppBrowserManager INSTANCE = new AppBrowserManager();
    }	
	public static AppBrowserManager get() { 
		return BrowserLoader.INSTANCE; 
	}	
    private AppBrowserManager() {
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
    
    public void select(EObject o){
    	browser().getTree().checkObject(o);
    }
    
    public void changeTo(EObject relationship, EObject source, EObject target){
    	browser().getTree().checkObject(source);
   		browser().getTree().removeCurrentNode();
   		browser().getTree().checkObject(target);
   		browser().getTree().removeCurrentNode();
   		browser().getTree().checkObject(relationship);
   		browser().getTree().addChild(source);  
   		browser().getTree().addChild(target);  
   		browser().getTree().updateUI();
    }
}
