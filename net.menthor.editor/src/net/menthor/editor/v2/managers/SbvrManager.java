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

import java.awt.Desktop;
import java.io.File;

import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.util.RefOntoUMLResourceUtil;
import net.menthor.editor.v2.types.ResultType;
import net.menthor.editor.v2.types.ResultType.Result;
import net.menthor.editor.v2.ui.app.AppManager;
import net.menthor.editor.v2.util.DirectoryUtil;
import net.menthor.editor.v2.util.Util;
import net.menthor.ontouml2sbvr.OntoUML2SBVR;

public class SbvrManager extends AppManager {

	// -------- Lazy Initialization

	private static class SbvrLoader {
        private static final SbvrManager INSTANCE = new SbvrManager();
    }	
	public static SbvrManager get() { 
		return SbvrLoader.INSTANCE; 
	}	
    private SbvrManager() {
        if (SbvrLoader.INSTANCE != null) throw new IllegalStateException("SbvrManager already instantiated");
    }		
    
    // ----------------------------
	
	/**  Generate SBVR documentation.
	 *   In order to use the plug-in, we need to store the model into a file before. */
	public void generateSbvr(){
		OntoUMLParser refparser = ProjectManager.get().getProject().getRefParser();		
		generateSbvr(refparser.getModel());
	}
	
	/**  Generate SBVR documentation. 
	 *   In order to use the plug-in, we need to store the model into a file before. */
	public void generateSbvr(RefOntoUML.Package refpackage){
		ResultType result;
		String name = new String();
		if(refpackage.getName()==null || refpackage.getName().isEmpty()) name = "model";
		else name = refpackage.getName();
		String modelFileName = Util.getCanonPath(DirectoryUtil.getTempDir(), name+".refontouml");
		File modelFile = new File(modelFileName);  	
    	modelFile.deleteOnExit();    	
		try {
			RefOntoUMLResourceUtil.saveModel(modelFileName, refpackage);
			OntoUML2SBVR.Transformation(modelFileName);			
			String docPage = modelFile.getPath().replace(".refontouml", ".html");			
			infoPane().showOutput("SBVR generated successfully", true, true); 
			result = new ResultType(Result.SUCESS, "SBVR generated successfully", new Object[] { docPage });			
		} catch (Exception ex) {
			ex.printStackTrace();
			result = new ResultType(Result.ERROR, "Error while generating the SBVR representaion. Details: " + ex.getMessage(), null);
		}		
		if(result.getResultType() != Result.ERROR)
		{
			infoPane().showOutput(result.toString(), true, true);			
			String htmlFilePath = (String) result.getData()[0];
			File file = new File(htmlFilePath);
			openLinkWithBrowser(file.toURI().toString());
		}else{
			infoPane().showOutput(result.toString(), true, true); 
		}
	}
	
	public void openLinkWithBrowser(String link){
		Desktop desktop = Desktop.getDesktop();
		if( !desktop.isSupported(Desktop.Action.BROWSE)){
			System.err.println( "Desktop doesn't support the browse action (fatal)" );
			return;
		}
		try {
			java.net.URI uri = new java.net.URI(link);
			desktop.browse(uri);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
