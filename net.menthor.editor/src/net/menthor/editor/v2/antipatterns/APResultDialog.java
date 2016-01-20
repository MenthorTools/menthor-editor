package net.menthor.editor.v2.antipatterns;

import java.util.ArrayList;

import javax.swing.JFrame;

import org.eclipse.swt.widgets.Shell;

import net.menthor.antipattern.application.AntiPatternResultDialog;
import net.menthor.antipattern.application.AntipatternOccurrence;
import net.menthor.common.ontoumlfixer.Fix;

import net.menthor.editor.v2.managers.UpdateManager;

public class APResultDialog extends AntiPatternResultDialog {

	public APResultDialog(Shell parentShell, ArrayList<AntipatternOccurrence> result, JFrame frame) {
		super(parentShell, result, frame);
	}
	
	public void transferFix(Fix fix){
		UpdateManager.get().update(fix);
	}
	
}
