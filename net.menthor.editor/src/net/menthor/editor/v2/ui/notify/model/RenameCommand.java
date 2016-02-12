package net.menthor.editor.v2.ui.notify.model;

import javax.swing.SwingUtilities;

import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.NamedElement;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.ui.app.manager.AppBrowserManager;
import net.menthor.editor.v2.ui.app.manager.AppTabManager;
import net.menthor.editor.v2.ui.notify.ModelCommand;
import net.menthor.editor.v2.ui.notify.Notifier;
import net.menthor.editor.v2.ui.notify.NotificationType;

/**
 * @author Tiago Prince
 */
public class RenameCommand extends ModelCommand {

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
		isRedo = true;
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
					AppTabManager.get().refreshTabTitle(namedElement);										        
				}
			});
		}
		else{
			Notifier.get().notifyDo(this, namedElement, NotificationType.MODIFY);				
		}
		AppBrowserManager.get().updateUI();
	}	
	
}
