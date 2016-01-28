package net.menthor.editor.v2.managers;

import RefOntoUML.parser.OntoUMLParser;
import net.menthor.common.ontoumlfixer.Fix;
import net.menthor.editor.ui.Models;
import net.menthor.validator.meronymic.application.ValidationDialog;

public class ParthoodManager extends BaseManager {

	private static ParthoodManager instance = new ParthoodManager();
	public static ParthoodManager get() { return instance; }
		
	public void evaluateParthoods() {
		ParthoodDialog.open(Models.getRefparser(), diagramManager.getFrame());
	}	
	
	class ParthoodDialog extends ValidationDialog {
		private static final long serialVersionUID = 8388636367160484461L;
		public ParthoodDialog(OntoUMLParser parser) { super(parser); }

		/** transfer modifications on the model to Menthor */
		@Override
		protected void transferFix(Fix fix){
			UpdateManager.get().update(fix);
		}
	}
}
