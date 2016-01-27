package net.menthor.editor.v2.managers;

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

	private static AntiPatternManager instance = new AntiPatternManager();
	public static AntiPatternManager get() { return instance; }
	
	public void detectAntiPatterns(){					
		APSearchDialog.open(diagramManager.getFrame(), Models.getRefparser());		
	}	
	
	class APSearchDialog extends AntiPatternSearchDialog {
		
		private static final long serialVersionUID = 4409086494848787626L;
		
		/** constructor */
		public APSearchDialog(JFrame frame, OntoUMLParser refparser){ super(frame, refparser); }		
		
		@Override /** open the result */
		public void openResult(AntiPatternList list){ 
			APResultDialog.openDialog(list,diagramManager.getFrame()); 
		}
		
		@Override /** transfer the result to Menthor */
		public void transferResult(AntiPatternList list){ Models.setAntipatterns(list); }
	}
	
	class APResultDialog extends AntiPatternResultDialog {
		
		/** constructor */
		public APResultDialog(Shell parent, List<AntipatternOccurrence> result, JFrame frame) { super(parent, result, frame); }		
		
		/** transfer the modifications to Menthor */
		public void transferFix(Fix fix){ UpdateManager.get().update(fix); }		
	}

}
