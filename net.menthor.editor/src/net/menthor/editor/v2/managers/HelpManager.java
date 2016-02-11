package net.menthor.editor.v2.managers;

import net.menthor.editor.v2.MenthorEditor;
import net.menthor.editor.v2.ui.dialog.help.AboutDialog;
import net.menthor.editor.v2.ui.dialog.help.LicensesDialog;
import net.menthor.editor.v2.ui.manager.GenericUIManager;

public class HelpManager extends GenericUIManager {

	// -------- Lazy Initialization

	private static class HelpLoader {
        private static final HelpManager INSTANCE = new HelpManager();
    }	
	public static HelpManager get() { 
		return HelpLoader.INSTANCE; 
	}	
    private HelpManager() {
        if (HelpLoader.INSTANCE != null) throw new IllegalStateException("HelpManager already instantiated");
    }		
    
    // ----------------------------
	
	public void about(){
		AboutDialog.open(
			listener(),
			MenthorEditor.MENTHOR_COMPILATION_DATE,
			MenthorEditor.MENTHOR_VERSION
		);
	}
	
	public void licenses(){
		LicensesDialog.open(frame());
	}

}
