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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import RefOntoUML.parser.OntoUMLParser;
import net.menthor.common.settings.als.ALS4Destination;
import net.menthor.common.settings.als.ALS4TransformationOption;
import net.menthor.editor.transformation.alloy.AlsSettingsDialog;
import net.menthor.editor.ui.AlloySpecification;
import net.menthor.editor.ui.Models;
import net.menthor.editor.v2.util.AlloyAnalyzer;
import net.menthor.ontouml2alloy.OntoUML2AlloyOptions;
import net.menthor.tocl.tocl2alloy.TOCL2AlloyOption;

public class AlloyManager extends BaseManager {

	private static AlloyManager instance = new AlloyManager();
	public static AlloyManager get() { return instance; }
		
	/** open alloy settings dialog */
	public void openAlloySettings(){		
		SyntaxManager.get().verifyConstraints(false);

		OntoUML2AlloyOptions refOptions = Models.getRefOptions();
		OntoUMLParser refparser = Models.getRefparser();
		refOptions.check(refparser);
		
		AlsSettingsDialog.open(diagramManager.getFrame(),
			Models.getRefparser(),
			browser.getAllDiagrams(),
			refOptions, 
			Models.getOclOptions()
		);	
	}
	
	/** run the transformation to alloy */
	public void generateAlloy(OntoUMLParser refparser, ALS4TransformationOption to){			
		try{
			if(to.getDestination()==ALS4Destination.FILE){ //make sure a path is set
				if(to.getPath()!=null) Models.getAlloySpec().setAlloyPath(to.getPath());
			}
			
			runOntouml(refparser);		
			runOcl(refparser);
			
			if(to.getDestination()==ALS4Destination.ANALYZER) { //open analyzer
				openAnalyzer(Models.getAlloySpec(),true, -1);			
			}
			if(to.getDestination()==ALS4Destination.TAB){ //open it in a tab		
				diagramManager.showInTextEditor(Models.getAlloySpec().getContent());
			}
			if(to.getDestination()==ALS4Destination.FILE){ //print to a file
				MessageManager.get().showInfo("Alloy Manager", "Project successfully transformed to Alloy file.");
			}
		}catch(Exception e){
			MessageManager.get().showError(e, 
				"Alloy Manager", "Current project could not be transformed to Alloy."
			);				 
		}
	}

	public void runOntouml(OntoUMLParser refparser) throws Exception {		
		OntoUML2AlloyOptions refOptions = Models.getRefOptions();
		Models.getAlloySpec().setDomainModel(refparser,refOptions);
		Models.getAlloySpec().transformDomainModel();	
	}
	
	public void runOcl(OntoUMLParser refparser) {				
		TOCL2AlloyOption oclOptions = Models.getOclOptions();
		AlloySpecification alloySpec = Models.getAlloySpec();		
		try {						
			String logMessage = alloySpec.transformConstraints(refparser, oclOptions.getParser(),oclOptions);
			if (!logMessage.isEmpty() && logMessage!=null){				
				MessageManager.get().showWarning("Alloy Manager", logMessage);
			}
		} catch (Exception e) {	
			MessageManager.get().showError(e, "Alloy Manager", "Current OCL constraints could not be transformed to Alloy.");
		}		
	}
		
	/** open the alloy analyzer */
	public void openAnalyzer (final AlloySpecification alloymodel, final boolean showAnalyzer, final int cmdIndexToExecute){
		if (alloymodel.getAlloyPath().isEmpty() || alloymodel.getAlloyPath()==null) return;
		try{
			final Timer timer = new Timer(100, null);			
			ActionListener listener = new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if (AlloyAnalyzer.tool().isInitialized())
					{
						AlloyAnalyzer.tool().setTheme(alloymodel.getDirectory() + "standart_theme.thm");				
						AlloyAnalyzer.tool().doOpenFile(alloymodel.getAlloyPath());				
						if (cmdIndexToExecute>=0)AlloyAnalyzer.tool().doRun(cmdIndexToExecute);						
						timer.stop();
					}
				}
			};
			timer.addActionListener(listener);
			timer.start();
		}catch(Exception e){
			MessageManager.get().showError(e, "Alloy Manager", "Could not open the Alloy Analyzer tool.");				
		}
	}
	
}
