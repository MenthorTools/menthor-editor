package org.tinyuml.ui.diagram.commands;

import javax.swing.SwingUtilities;

import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.NamedElement;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.commanders.UpdateCommander;
import net.menthor.editor.v2.ui.app.AppBrowser;
import net.menthor.editor.v2.ui.app.AppEditorsPane;
import net.menthor.editor.v2.ui.manager.TabManager;

/**
 * @author Tiago Prince
 */
public class RenameCommand extends GenericModelCommand {

	private static final long serialVersionUID = 1L;
	
	NamedElement namedElement;
	String newName;
	String oldName;
	
	public RenameCommand(NamedElement namedElement, String newName) {
		super();
		
		this.namedElement = namedElement;
		
		if(newName!=null){
			this.newName = newName;
		}
		else{ 
			this.newName = "";
		}
		if(namedElement.getName()!=null){
			this.oldName = namedElement.getName();
		}
		else{
			this.oldName = "";
		}
	}

	@Override
	public void undo() {
		super.undo();
		namedElement.setName(oldName);
		updateUI();
	}

	@Override
	public void redo() {
		redo = true;
		super.redo();
		run();		
	}
	
	@Override
	public void run() {
		namedElement.setName(newName);
		updateUI();
	}
	
	/** Updates UI after renaming an element. */
	public void updateUI(){
		if(namedElement instanceof OclDocument || namedElement instanceof StructureDiagram){
			SwingUtilities.invokeLater(new Runnable() {				
				@Override
				public void run() {
					int index = TabManager.get().getEditorIndex(namedElement);	
					
					if(index>=0){ 
						AppEditorsPane.get().setTitleAt(index, namedElement.getName());			        
					}
					AppEditorsPane.get().updateUI();
					AppBrowser.get().getTree().updateUI();					        
				}
			});
		}
		else{
			UpdateCommander.get().notifyChange(namedElement);
			AppBrowser.get().getTree().updateUI();
		}
	}	
	
}
