package net.menthor.editor.v2.feature;

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
import java.io.File;
import java.io.IOException;

import javax.swing.Timer;

import RefOntoUML.parser.OntoUMLParser;
import net.menthor.alloy.AlloyModule;
import net.menthor.common.file.FileUtil;
import net.menthor.common.settings.als.ALS4Destination;
import net.menthor.common.settings.als.ALS4TransformationOption;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.managers.SyntaxManager;
import net.menthor.editor.v2.ui.controller.MessageController;
import net.menthor.editor.v2.ui.controller.TabbedAreaController;
import net.menthor.editor.v2.ui.settings.als.AlsSettingsDialog;
import net.menthor.editor.v2.util.AlloyAnalyzer;
import net.menthor.ontouml2alloy.OntoUML2Alloy;
import net.menthor.ontouml2alloy.OntoUML2AlloyOptions;
import net.menthor.tocl.parser.TOCLParser;
import net.menthor.tocl.tocl2alloy.TOCL2Alloy;
import net.menthor.tocl.tocl2alloy.TOCL2AlloyOption;

public class AlloyFeature extends GenericFeature {
	
	// -------- Lazy Initialization

	private static class AlloyLoader {
        private static final AlloyFeature INSTANCE = new AlloyFeature();
    }	
	public static AlloyFeature get() { 
		return AlloyLoader.INSTANCE; 
	}	
    private AlloyFeature() {    	
        if (AlloyLoader.INSTANCE != null) throw new IllegalStateException("AlloyManager already instantiated");
    }		
    
    // ----------------------------
		
    public AlloySpec alloySpec;
    public OntoUML2AlloyOptions refOptions = new OntoUML2AlloyOptions();
	public TOCL2AlloyOption oclOptions = new TOCL2AlloyOption();
	
	/** open alloy settings dialog */
	public void openAlloySettings(){
		alloySpec = new AlloySpec(ProjectManager.get().getProject().getTempDir()+
			    	File.separator+ProjectManager.get().getProject().getName().toLowerCase()+".als");
		SyntaxManager.get().verifyConstraints(false);
		
		OntoUMLParser refparser = ProjectManager.get().getProject().getRefParser();
		refOptions.check(refparser);
		
		AlsSettingsDialog.open(parent(), listener(),
			ProjectManager.get().getProject().getRefParser(),
			ProjectManager.get().getProject().getDiagrams(),
			refOptions, 
			oclOptions
		);	
	}
	
	/** run the transformation to alloy */
	public void generateAlloy(OntoUMLParser refparser, ALS4TransformationOption to){			
		try{
			if(to.getDestination()==ALS4Destination.FILE){ //make sure a path is set
				if(to.getPath()!=null) alloySpec.setAlloyPath(to.getPath());
			}
			
			runOntouml(refparser);		
			runOcl(refparser);
			
			if(to.getDestination()==ALS4Destination.ANALYZER) { //open analyzer
				openAnalyzer(alloySpec,true, -1);			
			}
			if(to.getDestination()==ALS4Destination.TAB){ //open it in a tab		
				TabbedAreaController.get().addTextEditor(alloySpec.getContent());
			}
			if(to.getDestination()==ALS4Destination.FILE){ //print to a file
				MessageController.get().showInfo("Alloy Manager", "Project successfully transformed to Alloy file.");
			}
		}catch(Exception e){
			MessageController.get().showError(e, 
				"Alloy Manager", "Current project could not be transformed to Alloy."
			);				 
		}
	}

	public void runOntouml(OntoUMLParser refparser) throws Exception {		
		alloySpec.setDomainModel(refparser,refOptions);
		alloySpec.transformDomainModel();	
	}
	
	public void runOcl(OntoUMLParser refparser) {						
		try {						
			String logMessage = alloySpec.transformConstraints(refparser, oclOptions.getParser(),oclOptions);
			if (!logMessage.isEmpty() && logMessage!=null){				
				MessageController.get().showWarning("Alloy Manager", logMessage);
			}
		} catch (Exception e) {	
			MessageController.get().showError(e, "Alloy Manager", "Current OCL constraints could not be transformed to Alloy.");
		}		
	}
		
	/** open the alloy analyzer */
	public void openAnalyzer (final AlloySpec alloymodel, final boolean showAnalyzer, final int cmdIndexToExecute){
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
			MessageController.get().showError(e, "Alloy Manager", "Could not open the Alloy Analyzer tool.");				
		}
	}
	
	class AlloySpec {

		/** Absolute directory path of alloy specification. */
		public String alsOutDirectory;	
		
		/** File name of alloy specification. */
		private String alsmodelName;	
		
		/** Absolute path of alloy specification. */
		private String alsPath;	
		
		/** Alloy Module */
		private AlloyModule alsModule;
		private OntoUML2Alloy ontouml2alloy;
		
		/** Additional content of alloy specification. */	
		private String additionalContent = new String();
		
		/** Log details for operations made. */
		private String logDetails = new String();

		/**
		 * This constructor basically initialize the path of alloy model, i.e. without any content.
		 */
		public AlloySpec(String alloyPath)
		{
			this();
			
			setAlloyModel(alloyPath);
		}
		
		public AlloySpec(String alloyPath,OntoUMLParser refparser, OntoUML2AlloyOptions optmodel) throws Exception
		{
			this();
			
			setAlloyModel(alloyPath,refparser,optmodel);
		}
		
		public AlloySpec() { }	

		/**
		 * Private methods
		 */
		private void setAlloyModel(String alloyPath, OntoUMLParser refparser, OntoUML2AlloyOptions optmodel) throws Exception
		{
			setAlloyModel(alloyPath);				
			setDomainModel(refparser,optmodel);	
		}
		
		private void setAlloyModel(String alloyPath)
		{			
			this.alsPath = alloyPath;
			File file = new File(alsPath);
			file.deleteOnExit();
			
			alsOutDirectory = alsPath.substring(0, alsPath.lastIndexOf(File.separator)+1);		
			alsmodelName = alsPath.substring(alsPath.lastIndexOf(File.separator)+1,alsPath.length()).replace(".als","");	
		}
		
		public void setAlloyPath(String alloyPath)
		{
			this.alsPath = alloyPath;			
			alsOutDirectory = alsPath.substring(0, alsPath.lastIndexOf(File.separator)+1);		
			alsmodelName = alsPath.substring(alsPath.lastIndexOf(File.separator)+1,alsPath.length()).replace(".als","");
		}
		
		public void setDomainModel(OntoUMLParser refparser, OntoUML2AlloyOptions ontoOptions)
		{
			ontouml2alloy = new OntoUML2Alloy(refparser, alsPath, ontoOptions);
			alsModule = ontouml2alloy.transformer.module;
		}
		
		public void appendContent(String content) throws IOException
		{ 
			additionalContent = additionalContent+content; 
			FileUtil.writeToFile(alsModule.toString()+"\n"+additionalContent, alsPath); 
		}	
			
		/**
		 * Transformations
		 */
		public void transformDomainModel() throws Exception
		{
			ontouml2alloy.transform();
			FileUtil.writeToFile(alsModule.toString()+"\n"+additionalContent, alsPath);
		}
		
		public String transformConstraints(OntoUMLParser refparser, TOCLParser toclparser, TOCL2AlloyOption oclOptions) throws IOException
		{	
			additionalContent += "\n"+TOCL2Alloy.convertHistoricalRelationships(ontouml2alloy.transformer.factory, ontouml2alloy.transformer.sigObject, toclparser);
			additionalContent += "\n"+TOCL2Alloy.convertTemporalConstraints(toclparser, oclOptions);
			
			FileUtil.writeToFile(alsModule.toString()+"\n"+additionalContent, alsPath);
			
			return TOCL2Alloy.log;		
		}
			
		/** Get Log details for made operations. */
		public String getDetails() { return logDetails; }
		
		/**  Get absolute path of alloy specification. */
		public String getAlloyPath() { return alsPath; }
		
		/** Get file name of alloy specification. */
		public String getAlloyModelName() {	return alsmodelName; }
		
		/** Get content of alloy specification. */
		public String getContent() { return alsModule.toString()+"\n"+additionalContent; }
		
		/** Get the Destination Directory of this model. */
		public String getDirectory() { return alsOutDirectory; }
		
	}

}
