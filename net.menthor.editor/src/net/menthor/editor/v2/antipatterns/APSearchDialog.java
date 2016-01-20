package net.menthor.editor.v2.antipatterns;

import javax.swing.JFrame;

import RefOntoUML.parser.OntoUMLParser;
import net.menthor.antipattern.application.AntiPatternList;
import net.menthor.antipattern.application.AntiPatternSearchDialog;
import net.menthor.editor.ui.Models;

public class APSearchDialog extends AntiPatternSearchDialog {
	
	private static final long serialVersionUID = 4409086494848787626L;

	public APSearchDialog(JFrame frame, OntoUMLParser refparser) {
		super(frame, refparser);
	}
	
	public void transferSearchResult(AntiPatternList list){
		Models.setAntipatterns(list);
	}
}
