package net.menthor.editor.v2.managers;

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

import java.util.List;

import javax.swing.JFrame;

import org.eclipse.swt.widgets.Shell;

import RefOntoUML.parser.OntoUMLParser;
import net.menthor.antipattern.application.AntiPatternList;
import net.menthor.antipattern.application.AntiPatternResultDialog;
import net.menthor.antipattern.application.AntiPatternSearchDialog;
import net.menthor.antipattern.application.AntipatternOccurrence;
import net.menthor.common.ontoumlfixer.Fix;
import net.menthor.editor.ui.Models;
public class AntiPatternManager extends BaseManager {

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
		APSearchDialog.open(frame(), Models.getRefparser());		
	}	
	
	class APSearchDialog extends AntiPatternSearchDialog {
		private static final long serialVersionUID = 4409086494848787626L;
		public APSearchDialog(JFrame frame, OntoUMLParser refparser){ super(frame, refparser); }		
		
		/** open the result */
		@Override 
		public void openResult(AntiPatternList list){ 
			APResultDialog.openDialog(list,frame()); 
		}
		
		/** transfer the result to Menthor */
		@Override 
		public void transferResult(AntiPatternList list){ Models.setAntipatterns(list); }
	}
	
	class APResultDialog extends AntiPatternResultDialog {
		public APResultDialog(Shell parent, List<AntipatternOccurrence> result, JFrame frame) { super(parent, result, frame); }		
		
		/** transfer fix to Menthor */
		@Override
		public void transferFix(Fix fix){ UpdateManager.get().update(fix); }		
	}
}
