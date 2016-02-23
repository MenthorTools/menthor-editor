package net.menthor.editor.v2.managers;

import net.menthor.common.ontoumlfixer.Fix;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.commanders.UpdateCommander;
import net.menthor.editor.v2.ui.antipattern.AntiPatternSearchDialog;
import net.menthor.editor.v2.ui.controller.TabbedAreaController;

public class AntiPatternManager extends AbstractManager {

	// -------- Lazy Initialization

	private static class AntiPatternLoader {
        private static final AntiPatternManager INSTANCE = new AntiPatternManager();
    }	
	public static AntiPatternManager get() { 
		return AntiPatternLoader.INSTANCE; 
	}	
    private AntiPatternManager() {
        if (AntiPatternLoader.INSTANCE != null) throw new IllegalStateException("AntiPatternManager already instantiated");
    }		
    
    // ----------------------------
	
	public void detectAntiPatterns(){					
		AntiPatternSearchDialog.open(frame(), ProjectManager.get().getProject().getRefParser());		
	}	
	
	/** Transfer fixes made on the model to an application. 
	 *  Users must override this method to get the modifications made by the antipatterns */
	public void transferFix(Fix fix){
		UpdateCommander.get().update(fix);
		
		//if there are rules, the update action opens a tab to show the ocl document to the user;
		if(fix.getAddedRules().size()>0){
			OclDocument oclDoc = ProjectManager.get().getProject().getOclDocList().get(0);
			
			if(TabbedAreaController.get().isEditorOpen(oclDoc))
				TabbedAreaController.get().selectEditor(oclDoc);
			//TODO: open tab
//			else 
//				TabManager.get().addOclEditor(oclDoc);
			
			TabbedAreaController.get().selectedTopOclEditor().reloadText();
		}
	}
	
	
}
