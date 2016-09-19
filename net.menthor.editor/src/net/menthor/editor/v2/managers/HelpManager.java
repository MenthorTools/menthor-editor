package net.menthor.editor.v2.managers;

import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.ui.MenthorEditor;
import net.menthor.editor.v2.ui.dialog.AboutDialog;
import net.menthor.editor.v2.ui.dialog.LicensesDialog;

public class HelpManager extends AbstractManager {

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
			frame(),listener(),
			MenthorEditor.MENTHOR_COMPILATION_DATE,
			MenthorEditor.MENTHOR_VERSION
		);
	}
	
	public void licenses(){
		LicensesDialog.open(frame());
	}

}
