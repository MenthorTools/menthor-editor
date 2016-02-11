package net.menthor.editor.v2;

import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.ui.app.AppFrame;
import net.menthor.editor.v2.ui.manager.MessageManager;
import net.menthor.editor.v2.ui.manager.TabManager;
import net.menthor.editor.v2.ui.settings.owl.OwlSettingsMap;
import net.menthor.editor.v2.ui.util.SplashScreen;
import net.menthor.editor.v2.util.DirectoryUtil;
import net.menthor.editor.v2.util.SystemUtil;
import net.menthor.editor.v2.util.UIFontUtil;
import net.menthor.editor.v2.util.Util;
import net.menthor.swt.SWTConfigurer;

public final class MenthorEditor {
	
	/**
	 * This variable MUST be composed as "A.B.C". Increment when is built a:
	 * 	A: new version of this application
	 * 	B: compilation with new features
	 * 	C: compilation with bug fixes
	 */	
	public static String MENTHOR_VERSION = "1.1.4";	
	public static String MENTHOR_COMPILATION_DATE = Util.getCompilationDateMessage();	
	
	public static SplashScreen splashScreen = new SplashScreen(MENTHOR_VERSION, MENTHOR_COMPILATION_DATE);
		
	/** start menthor */
	public static void start(String[] args){
		try {			
			SystemUtil.set();					
			UIFontUtil.set();					
			SWTConfigurer.execute(DirectoryUtil.getBinDir());		
			OwlSettingsMap.getInstance();														
			
			//create application frame
			AppFrame.get();	
			
			//these must be called after AppFrame is constructed...
			TabManager.get().addStartEditor(false);								
			ProjectManager.get().openProjectFromArgs(args);		
			
			AppFrame.get().setLocationByPlatform(true);
			AppFrame.get().setVisible(true);
			AppFrame.get().toFront();
			
		}catch(Exception ex){
			MessageManager.get().showError(ex, 
			"Menthor Editor", "Could not start application due to an internal error.");
		}	
		splashScreen.close();
	}
	
	public static void main(final String[] args){	
		start(args);
	}	
}
