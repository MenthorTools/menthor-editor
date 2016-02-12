
package net.menthor.editor.v2.commanders;

import java.util.List;

import javax.swing.SwingUtilities;

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.StructureDiagram;
import org.tinyuml.umldraw.shared.UmlNode;

import RefOntoUML.Association;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import net.menthor.common.ontoumlfixer.Fix;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.managers.FactoryManager;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.managers.RemakeManager;
import net.menthor.editor.v2.ui.app.manager.AppBrowserManager;
import net.menthor.editor.v2.ui.app.manager.AppTabManager;
import net.menthor.editor.v2.ui.notify.diagram.AddGenSetDiagramCommand;
import net.menthor.editor.v2.ui.notify.diagram.AddNodeDiagramCommand;
import net.menthor.editor.v2.ui.notify.model.AddElementModelCommand;

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
					UmlNode node = FactoryManager.get().createNode((RefOntoUML.Type)obj,  (RefOntoUML.Element)((EObject)obj).eContainer());
					AddNodeDiagramCommand cmd = new AddNodeDiagramCommand(ed,node, fix.getAddedPosition(obj).x,fix.getAddedPosition(obj).y);		
					cmd.run();
				}else{
					AddElementModelCommand cmd = new AddElementModelCommand((RefOntoUML.Element)obj,(RefOntoUML.Element)((EObject)obj).eContainer());		
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
				AddGenSetDiagramCommand cmd = new AddGenSetDiagramCommand(ed,(RefOntoUML.Element)obj,
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
				if (element instanceof RefOntoUML.Association){
					if (remakeIt) RemakeManager.get().remakeRelationship((RefOntoUML.Element)element);					
				}
				if (element instanceof RefOntoUML.Property){
					Association assoc= ((RefOntoUML.Property)element).getAssociation();								
					if (assoc!=null){
						if(remakeIt) RemakeManager.get().remakeRelationship((RefOntoUML.Element)assoc);
						
					}
				}		
				if (element instanceof RefOntoUML.Generalization){
					if (remakeIt) RemakeManager.get().remakeRelationship((RefOntoUML.Element)element);
				}
				if(element instanceof RefOntoUML.GeneralizationSet){
					for(Generalization gen: ((RefOntoUML.GeneralizationSet) element).getGeneralization()) updateFromChange(gen,false);
				}
				if(element instanceof OclDocument || element instanceof StructureDiagram){					
					AppTabManager.get().refreshTabTitle((RefOntoUML.NamedElement)element);
				}
				AppBrowserManager.get().updateUI();
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
