package net.menthor.editor.v2.feature;

import java.awt.Component;

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

import RefOntoUML.parser.OntoUMLParser;
import net.menthor.common.ontoumlfixer.Fix;
import net.menthor.editor.v2.commanders.UpdateCommander;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.ui.app.AppFrame;
import net.menthor.validator.meronymic.application.ValidationDialog;

public class ParthoodFeature {

	private Component parent;
	
	// -------- Lazy Initialization

	private static class ParthoodLoader {
        private static final ParthoodFeature INSTANCE = new ParthoodFeature();
    }	
	public static ParthoodFeature get() { 
		return ParthoodLoader.INSTANCE; 
	}	
    private ParthoodFeature() {
    	parent = AppFrame.get();
        if (ParthoodLoader.INSTANCE != null) throw new IllegalStateException("ParthoodManager already instantiated");
    }		
    
    // ----------------------------
	
	public void evaluateParthoods() {
		ParthoodDialog.open(ProjectManager.get().getProject().getRefParser(), parent);
	}	
	
	class ParthoodDialog extends ValidationDialog {
		private static final long serialVersionUID = 8388636367160484461L;
		public ParthoodDialog(OntoUMLParser parser) { super(parser); }

		/** transfer modifications on the model to Menthor */
		@Override
		protected void transferFix(Fix fix){
			UpdateCommander.get().update(fix);
		}
	}
}
