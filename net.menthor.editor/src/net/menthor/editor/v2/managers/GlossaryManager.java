package net.menthor.editor.v2.managers;

import javax.swing.SwingUtilities;

import net.menthor.editor.ui.Models;
import net.menthor.ontouml2text.ontoUmlGlossary.ui.GlossaryGeneratorUI;

public class GlossaryManager extends BaseManager {

	private static GlossaryManager instance = new GlossaryManager();
	public static GlossaryManager get() { return instance; }
	
	public void openGlossarySettings(){
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {								
				GlossaryGeneratorUI settings = new GlossaryGeneratorUI(Models.getRefparser());
				settings.setVisible(true);
			}
		});
	}	
}
