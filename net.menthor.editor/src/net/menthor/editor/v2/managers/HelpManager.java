package net.menthor.editor.v2.managers;

import net.menthor.editor.ui.MenthorEditor;
import net.menthor.editor.v2.ui.AboutDialog;
import net.menthor.editor.v2.ui.LicensesDialog;

public class HelpManager extends BaseManager {

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
