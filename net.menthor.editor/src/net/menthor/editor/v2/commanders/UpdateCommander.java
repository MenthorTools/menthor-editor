
package net.menthor.editor.v2.commanders;

import java.util.List;

import javax.swing.SwingUtilities;

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.ui.diagram.OntoumlEditor;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import net.menthor.common.ontoumlfixer.Fix;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.managers.RemakeManager;
import net.menthor.editor.v2.ui.app.manager.AppBrowserManager;
import net.menthor.editor.v2.ui.app.manager.AppTabManager;
import net.menthor.editor.v2.ui.notify.Notifier;
import net.menthor.editor.v2.ui.notify.diagram.AddGeneralizationSetCommand;
import net.menthor.editor.v2.ui.notify.diagram.AddNodeCommand;
import net.menthor.editor.v2.ui.notify.NotificationType;

public class UpdateCommander {

	// -------- Lazy Initialization
	
	private static class UpdateLoader {
        private static final UpdateCommander INSTANCE = new UpdateCommander();
    }	
	public static UpdateCommander get() { 
		return UpdateLoader.INSTANCE; 
	}	
    private UpdateCommander() {
        if (UpdateLoader.INSTANCE != null) throw new IllegalStateException("UpdateManager already instantiated");
    }		
    
    // ----------------------------
	
	/** Decide whether we remake the element or not in the diagram (delete it and add it again) */
	public boolean shouldRemakeIt(Object obj){
		boolean remakeIt=false;						
		if (obj instanceof RefOntoUML.Property) {												
			if (((RefOntoUML.Property)obj).getAssociation()!=null) remakeIt=true;	
			else remakeIt=false;		
		}						
		else if (obj instanceof RefOntoUML.Association) remakeIt=true;			
		else if (obj instanceof Generalization) remakeIt=true;
		else remakeIt=false;
		return remakeIt;
	}
	
	/** Update application from a set of fixes on the model */
	public void update(Fix fix){		
		if (fix==null) return;			
		updateFromAddition(fix);				
		updateFromChange(fix);		
		updateFromDeletion(fix);
		
		List<OclDocument> oclDocs = ProjectManager.get().getProject().getOclDocList();
		
		if(fix.getAddedRules().size()>0 && oclDocs.size()==0){
			AddCommander.get().newOclDocument("", true);
		}
		
		for(String str: fix.getAddedRules()){
			oclDocs.get(0).addContentAsString(str);		
		}
		return ;	
	}
	
	/** Update application from a set of deletions (fix) on the model */
	public void updateFromDeletion(Fix fix){
		for(Object obj: fix.getDeleted()){
			DeleteCommander.get().deleteElement((RefOntoUML.Element)obj,false);				
		}
	}
	
	/** Update application from a set of changes (fix) on the model */
	public void updateFromChange(Fix fix){
		for(Object obj: fix.getModified()){
			boolean remakeIt= shouldRemakeIt(obj);
			updateFromChange((RefOntoUML.Element)obj, remakeIt);
		}
	}
	
	/** Update application from a set of additions (fix) on the model */
	public void updateFromAddition(Fix fix){
		OntoumlEditor ed = AppTabManager.get().getCurrentDiagramEditor();
		
		//classes and datatypes with position set need to be added
		for(Object obj: fix.getAdded()){			
			if (obj instanceof RefOntoUML.Class||obj instanceof RefOntoUML.DataType) {	
				if (fix.getAddedPosition(obj).x!=-1 && fix.getAddedPosition(obj).y!=-1){						
					AddNodeCommand cmd = new AddNodeCommand(ed,ed.getDiagram(),(RefOntoUML.Element)obj,
					fix.getAddedPosition(obj).x,fix.getAddedPosition(obj).y, (RefOntoUML.Element)((EObject)obj).eContainer());		
					cmd.run();
				}else{
					AddNodeCommand cmd = new AddNodeCommand(null,null,(RefOntoUML.Element)obj,0,0,(RefOntoUML.Element)((EObject)obj).eContainer());		
					cmd.run();									
				}
			}			
		}
		
		//relationships and attributes
		for(Object obj: fix.getAdded()) { 
			if (obj instanceof RefOntoUML.Relationship) {
				updateFromAddition((RefOntoUML.Element)obj);
				MoveCommander.get().move((RefOntoUML.Element)obj, -1, -1, ed,false);
			}
			if(obj instanceof RefOntoUML.Property){		
				updateFromAddition((RefOntoUML.Element)obj);
			}
		}	

		//generalization sets
		for(Object obj: fix.getAdded()) {
			if (obj instanceof RefOntoUML.GeneralizationSet){
				AddGeneralizationSetCommand cmd = new AddGeneralizationSetCommand(ed,ed.getDiagram(),(RefOntoUML.Element)obj,
				((GeneralizationSet)obj).getGeneralization(),(RefOntoUML.Element)((EObject)obj).eContainer());
				cmd.run(); 
			}
		}
	}	
	
	/** Update application from the addition of an element on the model */
	public void updateFromAddition(final RefOntoUML.Element addedElement){		
		//add to parser
		ProjectManager.get().getProject().getRefParser().addElement(addedElement);		
		//add to tree
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {								
				AppBrowserManager.get().add(addedElement);				
			}
		});		
	}
	
	/** Update application from the addition of an element on the model */
	public void updateFromChange(final RefOntoUML.Element element, final boolean remakeIt){
		updateFromAddition(element);		
		//notify the change or simply remake the element
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
				if (element instanceof RefOntoUML.Class || element instanceof RefOntoUML.DataType){
					Notifier.get().notifyDo(null,(Classifier)element, NotificationType.MODIFY);			
				}
				if (element instanceof RefOntoUML.Association){
					if (remakeIt) RemakeManager.get().remakeRelationship((RefOntoUML.Element)element);
					else Notifier.get().notifyDo(null,(RefOntoUML.Element)element, NotificationType.MODIFY);
				}
				if (element instanceof RefOntoUML.Property){
					Association assoc= ((RefOntoUML.Property)element).getAssociation();								
					if (assoc!=null){
						if(remakeIt) RemakeManager.get().remakeRelationship((RefOntoUML.Element)assoc);
						else  Notifier.get().notifyDo(null,(RefOntoUML.Element)assoc, NotificationType.MODIFY);
					}else{
						Notifier.get().notifyDo(null,(RefOntoUML.Element)(element).eContainer(), NotificationType.MODIFY);
					}
				}		
				if (element instanceof RefOntoUML.Generalization){
					if (remakeIt) RemakeManager.get().remakeRelationship((RefOntoUML.Element)element); 
					else Notifier.get().notifyDo(null,(RefOntoUML.Element)element, NotificationType.MODIFY);
				}
				if(element instanceof RefOntoUML.GeneralizationSet){
					for(Generalization gen: ((RefOntoUML.GeneralizationSet) element).getGeneralization()) updateFromChange(gen,false);
				}
			}
		});
	}
	
	/** Update application from the deletion of an element on the model */
	public void updateFromDeletion(final RefOntoUML.Element deletedElement){		
		// deleted from parser
		ProjectManager.get().getProject().getRefParser().removeElement(deletedElement);
		//delete from the tree
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {						
				AppBrowserManager.get().remove(deletedElement);
			}
		});
	}
	
	public void updateProjectTree(){
		AppBrowserManager.get().updateUI();
	}
}
