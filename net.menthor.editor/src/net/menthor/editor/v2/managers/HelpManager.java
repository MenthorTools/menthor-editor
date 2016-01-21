package net.menthor.editor.v2.managers;

import net.menthor.editor.ui.LicensesDialog;
import net.menthor.editor.ui.MenthorEditor;
import net.menthor.editor.v2.ui.AboutDialog;

public class HelpManager extends BaseManager {

	private static HelpManager instance = new HelpManager();
	public static HelpManager get() { return instance; }
	
	public void about(){
		AboutDialog.open(
			diagramManager.getCommandListener(),
			MenthorEditor.MENTHOR_COMPILATION_DATE,
			MenthorEditor.MENTHOR_VERSION
		);
	}
	
	public void licenses(){
		LicensesDialog.open(diagramManager);
	}

}
