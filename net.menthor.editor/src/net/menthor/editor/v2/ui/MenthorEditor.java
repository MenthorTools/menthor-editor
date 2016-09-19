package net.menthor.editor.v2.ui;

import net.menthor.editor.v2.ui.controller.MessageUIController;
import net.menthor.editor.v2.ui.controller.ProjectUIController;
import net.menthor.editor.v2.ui.controller.TabbedAreaUIController;
import net.menthor.editor.v2.ui.settings.owl.OwlSettingsMap;
import net.menthor.editor.v2.ui.utilities.SplashScreen;
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
	public static String MENTHOR_VERSION = "1.1.7";	
	public static String MENTHOR_COMPILATION_DATE = Util.getCompilationDateMessage();	
	
	public static SplashScreen splashScreen = new SplashScreen(MENTHOR_VERSION, MENTHOR_COMPILATION_DATE);
		
	/** start menthor */
	public static void start(String[] args){
		try {			
			SystemUtil.set();					
			UIFontUtil.set();					
			SWTConfigurer.execute(MENTHOR_VERSION);		
			OwlSettingsMap.getInstance();														
			
			//create application frame
			FrameUI.get();	
			
			//these must be called after AppFrame is constructed...
			TabbedAreaUIController.get().addWelcome(false);		
			ProjectUIController.get().openProjectFromArgs(args);		
			
			FrameUI.get().setLocationByPlatform(true);
			FrameUI.get().setVisible(true);
			FrameUI.get().toFront();
			
		}catch(Exception ex){
			MessageUIController.get().showError(ex, 
			"Menthor Editor", "Could not start application due to an internal error.");
		}	
		splashScreen.close();
	}
	
	public static void main(final String[] args){	
		start(args);
	}	
}
