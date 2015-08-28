package net.menthor.editor.OSXMenu;

import com.apple.eawt.AppEvent.QuitEvent;
import com.apple.eawt.QuitHandler;
import com.apple.eawt.QuitResponse;

import net.menthor.editor.ui.MenthorEditor;;

public class MenthorEditorQuitHandler implements QuitHandler {

	@Override
	public void handleQuitRequestWith(QuitEvent arg0, QuitResponse resp) {
		if(!MenthorEditor.frame.quitApplication()){
			resp.cancelQuit();
		}
	}

}
