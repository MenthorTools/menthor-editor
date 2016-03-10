
package net.menthor.editor.v2.commanders;

import java.util.List;

import javax.swing.SwingUtilities;

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.MenthorFactory;
import org.tinyuml.umldraw.StructureDiagram;
import org.tinyuml.umldraw.shared.UmlNode;

import RefOntoUML.Association;
import RefOntoUML.Element;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import net.menthor.common.ontoumlfixer.Fix;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.ui.controller.BrowserUIController;
import net.menthor.editor.v2.ui.controller.ProjectUIController;
import net.menthor.editor.v2.ui.controller.TabbedAreaUIController;
import net.menthor.editor.v2.ui.operation.diagram.AddGeneralizationSetOperation;
import net.menthor.editor.v2.ui.operation.diagram.AddNodeOperation;
import net.menthor.editor.v2.ui.operation.model.AddModelOperation;

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
	
    public void updateFromAddition(final List<Element> addedElements){
		for(Element elem: addedElements){
			if(elem instanceof RefOntoUML.Class) updateFromAddition(elem);
			if(elem instanceof OntoumlDiagram) updateFromAddition(elem);
			if(elem instanceof OclDocument) updateFromAddition(elem);
			if(elem instanceof RefOntoUML.DataType) updateFromAddition(elem);			
		}
		for(Element elem: addedElements){
			if(elem instanceof RefOntoUML.Association && !(elem instanceof RefOntoUML.Derivation)) updateFromAddition(elem);
			if(elem instanceof RefOntoUML.Generalization) updateFromAddition(elem);
			if(elem instanceof RefOntoUML.Property) updateFromAddition(elem);			
		}
		for(Element elem: addedElements){
			if(elem instanceof RefOntoUML.Constraintx) updateFromAddition(elem);
			if(elem instanceof RefOntoUML.Comment) updateFromAddition(elem);
			if(elem instanceof RefOntoUML.GeneralizationSet) updateFromAddition(elem);
			if(elem instanceof RefOntoUML.Derivation) updateFromAddition(elem);
		}		
	}
    
    public void updateFromDeletion(final List<Element> deletedElements){
    	for(Element elem: deletedElements){
			if(elem instanceof RefOntoUML.Constraintx) updateFromDeletion(elem);
			if(elem instanceof RefOntoUML.Comment) updateFromDeletion(elem);
			if(elem instanceof RefOntoUML.GeneralizationSet) updateFromDeletion(elem);
			if(elem instanceof RefOntoUML.Derivation) updateFromDeletion(elem);
		}	
    	for(Element elem: deletedElements){
    		if(elem instanceof RefOntoUML.Association && !(elem instanceof RefOntoUML.Derivation))  updateFromDeletion(elem);
			if(elem instanceof RefOntoUML.Generalization) updateFromDeletion(elem);
			if(elem instanceof RefOntoUML.Property) updateFromDeletion(elem);			
		}
    	for(Element elem: deletedElements){
			if(elem instanceof RefOntoUML.Class) updateFromDeletion(elem);
			if(elem instanceof OntoumlDiagram) updateFromDeletion(elem);
			if(elem instanceof OclDocument) updateFromDeletion(elem);
			if(elem instanceof RefOntoUML.DataType) updateFromDeletion(elem);			
		}	
	}
    
    public void updateFromChange(final List<Element> changedElements, final boolean remakeIt){
    	for(Element elem: changedElements){
			if(elem instanceof RefOntoUML.Class) updateFromChange(elem, remakeIt);
			if(elem instanceof OntoumlDiagram) updateFromChange(elem, remakeIt);
			if(elem instanceof OclDocument) updateFromChange(elem, remakeIt);
			if(elem instanceof RefOntoUML.DataType) updateFromChange(elem, remakeIt);		
		}
    	for(Element elem: changedElements){
    		if(elem instanceof RefOntoUML.Association && !(elem instanceof RefOntoUML.Derivation))  updateFromChange(elem, remakeIt);
			if(elem instanceof RefOntoUML.Generalization) updateFromChange(elem, remakeIt);
			if(elem instanceof RefOntoUML.Property) updateFromChange(elem, remakeIt);
		}
    	for(Element elem: changedElements){
			if(elem instanceof RefOntoUML.Constraintx) updateFromChange(elem, remakeIt);
			if(elem instanceof RefOntoUML.Comment) updateFromChange(elem, remakeIt);
			if(elem instanceof RefOntoUML.GeneralizationSet) updateFromChange(elem, remakeIt);
			if(elem instanceof RefOntoUML.Derivation) updateFromChange(elem, remakeIt);
		}    	    	
    }
    
    public void updateFromAddition(final Element addedElement){	
		if(!(addedElement instanceof OntoumlDiagram || addedElement instanceof OclDocument)){			
			ProjectUIController.get().getProject().getRefParser().addElement(addedElement);
		}
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {								
				BrowserUIController.get().add(addedElement, ProjectUIController.get().getProject().getModel());				
			}
		});		
	}
    
    public void updateFromDeletion(final RefOntoUML.Element deletedElement){	
    	if(!(deletedElement instanceof OntoumlDiagram || deletedElement instanceof OclDocument)){
    		ProjectUIController.get().getProject().getRefParser().removeElement(deletedElement);
    	}
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {						
				BrowserUIController.get().remove(deletedElement);
			}
		});
	}
    
    public void updateFromChange(final RefOntoUML.Element element, final boolean remakeIt){
		updateFromAddition(element);				
		SwingUtilities.invokeLater(new Runnable(){			
			@Override
			public void run() {				
				if (element instanceof RefOntoUML.Relationship){
					if(remakeIt) RemakeCommander.get().remakeRelationship((RefOntoUML.Element)element);					
				}
				if(element instanceof RefOntoUML.GeneralizationSet){
					for(Generalization gen: ((RefOntoUML.GeneralizationSet) element).getGeneralization()) {
						updateFromChange(gen, remakeIt);
					}
				}
				if (element instanceof RefOntoUML.Property){
					Association assoc = ((RefOntoUML.Property)element).getAssociation();								
					if (assoc!=null && remakeIt){
						RemakeCommander.get().remakeRelationship((RefOntoUML.Element)assoc);						
					}
				}				
				if(element instanceof OclDocument || element instanceof StructureDiagram){					
					TabbedAreaUIController.get().refreshTabTitle((RefOntoUML.NamedElement)element);
				}
				BrowserUIController.get().updateUI();
			}
		});
	}
    
    //---- update application from a fix ----
    
	/** Update application from a set of fixes on the model */
	public void update(Fix fix){		
		
		if (fix==null) return;			
		updateFromAddition(fix);				
		updateFromChange(fix);		
		updateFromDeletion(fix);
		
		List<OclDocument> oclDocs = ProjectUIController.get().getProject().getOclDocList();
		
		if(fix.getAddedRules().size()>0 && oclDocs.size()==0){
			ProjectUIController.get().addOclDocument("", true);
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
		OntoumlEditor ed = TabbedAreaUIController.get().getSelectedTopOntoumlEditor();
		
		//classes and datatypes with position set need to be added
		for(Object obj: fix.getAdded()){			
			if (obj instanceof RefOntoUML.Class||obj instanceof RefOntoUML.DataType) {	
				if (fix.getAddedPosition(obj).x!=-1 && fix.getAddedPosition(obj).y!=-1){
					UmlNode node = MenthorFactory.get().createNode((RefOntoUML.Type)obj,  (RefOntoUML.Element)((EObject)obj).eContainer());
					AddNodeOperation cmd = new AddNodeOperation(ed,node, fix.getAddedPosition(obj).x,fix.getAddedPosition(obj).y);		
					cmd.run();
				}else{
					AddModelOperation cmd = new AddModelOperation((RefOntoUML.Element)obj,(RefOntoUML.Element)((EObject)obj).eContainer());		
					cmd.run();									
				}
			}			
		}
		
		//relationships and attributes
		for(Object obj: fix.getAdded()) { 
			if (obj instanceof RefOntoUML.Relationship) {
				updateFromAddition((RefOntoUML.Element)obj);
				AddToDiagramCommander.get().addToDiagram((RefOntoUML.Element)obj, -1, -1, ed,false);
			}
			if(obj instanceof RefOntoUML.Property){		
				updateFromAddition((RefOntoUML.Element)obj);
			}
		}	

		//generalization sets
		for(Object obj: fix.getAdded()) {
			if (obj instanceof RefOntoUML.GeneralizationSet){
				AddGeneralizationSetOperation cmd = new AddGeneralizationSetOperation(ed,(RefOntoUML.Element)obj,
				((GeneralizationSet)obj).getGeneralization(),(RefOntoUML.Element)((EObject)obj).eContainer());
				cmd.run(); 
			}
		}
	}	
	
	
	/** Decide whether we remake the element or not in the diagram (delete it and add it again) */
	private boolean shouldRemakeIt(Object obj){
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
	
	public void updateProjectTree(){
		BrowserUIController.get().updateUI();
	}
}
