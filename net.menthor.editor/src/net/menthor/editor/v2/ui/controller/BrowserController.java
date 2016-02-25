package net.menthor.editor.v2.ui.controller;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.Element;
import RefOntoUML.EnumerationLiteral;
import RefOntoUML.Generalization;
import net.menthor.editor.ui.UmlProject;
import net.menthor.editor.v2.ui.Browser;

public class BrowserController {

	Browser browser = Browser.get();
	
	// -------- Lazy Initialization
	
	private static class BrowserLoader {
        private static final BrowserController INSTANCE = new BrowserController();
    }	
	public static BrowserController get() { 
		return BrowserLoader.INSTANCE; 
	}	
    private BrowserController() {
        if (BrowserLoader.INSTANCE != null) throw new IllegalStateException(this.getClass().getName()+" already instantiated");
    }		
    
    // ----------------------------
    
    public void initialize(UmlProject project){
    	browser.initialize(project);
    }
    
    public DefaultMutableTreeNode add(DefaultMutableTreeNode node, Object child){
    	return browser.getTree().addChild((DefaultMutableTreeNode)node, child);
    }
    
    public DefaultMutableTreeNode selected(){
    	return browser.getTree().getSelectedNode();
    }
    
    public DefaultMutableTreeNode root(){
    	return browser.getTree().getRootNode();
    }
    
    public void updateUI(){
    	browser.getTree().updateUI();
    }
    
    public void remove(RefOntoUML.Element o){  
    	browser.getTree().remove(o);    	
    }
    
    public void removeAll(List<RefOntoUML.Element> list){  
    	for(Element e: list) browser.getTree().remove(e);    	
    }
    
    public void remove(){
    	browser.getTree().removeCurrentNode();
    }
    
    public void moveDown(){
    	browser.getTree().moveDown();
    }
    
    public void moveUp(){
    	browser.getTree().moveUp();
    }
    
    public void add(EObject addedElement, RefOntoUML.Package root){
    	boolean found = browser.getTree().checkObject(addedElement);
		if(!found) {
			if(addedElement.eContainer()!=null) browser.getTree().checkObject(addedElement.eContainer());
			else if(addedElement instanceof EnumerationLiteral) browser.getTree().checkObject(((EnumerationLiteral)addedElement).getEnumeration());
			else browser.getTree().checkObject(root);					
			browser.getTree().addChild(addedElement);					
		} else {
			if(addedElement instanceof Generalization){
				browser.getTree().checkObject(addedElement);
				browser.getTree().removeCurrentNode();
				browser.getTree().checkObject(addedElement.eContainer());
				browser.getTree().addChild(addedElement);
			}
		}
		browser.getTree().updateUI();		
    }
    
    public void select(EObject o){
    	browser.getTree().checkObject(o);
    }
    
    public void changeTo(EObject relationship, EObject source, EObject target){
    	browser.getTree().checkObject(source);
   		browser.getTree().removeCurrentNode();
   		browser.getTree().checkObject(target);
   		browser.getTree().removeCurrentNode();
   		browser.getTree().checkObject(relationship);
   		browser.getTree().addChild(source);  
   		browser.getTree().addChild(target);  
   		browser.getTree().updateUI();
    }
}
