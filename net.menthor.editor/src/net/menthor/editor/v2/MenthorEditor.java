package net.menthor.editor.v2;

/**
 * ============================================================================================
 * Menthor Editor -- Copyright (c) 2015 
 *
 * This file is part of Menthor Editor. Menthor Editor is based on TinyUML and as so it is 
 * distributed under the same license terms.
 *
 * Menthor Editor is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 *
 * Menthor Editor is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Menthor Editor; 
 * if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, 
 * MA  02110-1301  USA
 * ============================================================================================
 */

import net.menthor.editor.v2.managers.MessageManager;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.managers.TabManager;
import net.menthor.editor.v2.settings.owl.OwlSettingsMap;
import net.menthor.editor.v2.ui.AppFrame;
import net.menthor.editor.v2.ui.startpage.SplashScreen;
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
	
	private static AppFrame frame; 
	public static AppFrame getFrame(){ return frame; }
	
	/** start menthor */
	public static void start(String[] args){
		try {			
			SystemUtil.set();					
			UIFontUtil.set();					
			SWTConfigurer.execute(DirectoryUtil.getBinDir());		
			OwlSettingsMap.getInstance();														
			frame = new AppFrame();			
			
			//these must be called after AppFrame is constructed...
			TabManager.get().addStartEditor(false);								
			ProjectManager.get().openProjectFromArgs(args);		
			
			frame.setLocationByPlatform(true);
			frame.setVisible(true);
			frame.toFront();
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
