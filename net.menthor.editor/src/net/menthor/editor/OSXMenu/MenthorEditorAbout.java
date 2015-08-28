package net.menthor.editor.OSXMenu;

import com.apple.eawt.AboutHandler;
import com.apple.eawt.AppEvent.AboutEvent;
import net.menthor.editor.ui.MenthorEditor;
import net.menthor.editor.v2.ui.AboutDialog;

public class MenthorEditorAbout implements AboutHandler {

	
	public MenthorEditorAbout() {
		
	}
	
	@Override public void handleAbout(AboutEvent evt){

		AboutDialog.open(MenthorEditor.frame,MenthorEditor.MENTHOR_COMPILATION_DATE,MenthorEditor.MENTHOR_VERSION);
		
	}
	

}
