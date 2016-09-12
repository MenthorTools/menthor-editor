package net.menthor.editor.v2.ui.controller;

import java.awt.Point;
import java.awt.image.BufferedImage;

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

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.tinyuml.ui.diagram.OntoumlEditor;

import net.menthor.ontouml2ecore.OntoUML2Ecore;
import net.menthor.ontouml2ecore.OntoUML2EcoreOption;
import net.menthor.ontouml2uml.OntoUML2UML;
import net.menthor.ontouml2uml.OntoUML2UMLOption;
import net.menthor.editor.v2.MenthorDomain;
import net.menthor.editor.v2.ui.FrameUI;
import net.menthor.editor.v2.util.Util;

public class ExportUIController {

	FrameUI frame = FrameUI.get();
	
	// -------- Lazy Initialization

	private static class ExportLoader {
        private static final ExportUIController INSTANCE = new ExportUIController();
    }	
	public static ExportUIController get() { 
		return ExportLoader.INSTANCE; 
	}	
    private ExportUIController() {
        if (ExportLoader.INSTANCE != null) throw new IllegalStateException(this.getClass().getName()+" already instantiated");
    }		
    
    // ----------------------------
	
	public String lastRefOntoPath = new String();
	public String lastUmlPath = new String();
	public String lastEcorePath = new String();
	public String lastPngPath = new String();
	
	public File chooseRefOntoumlFile() throws IOException{
		return Util.chooseFile(frame, lastRefOntoPath, "Export - RefOntouml", "Reference OntoUML (*.refontouml)", "refontouml",true);
	}
	
	public File chooseEcoreFile() throws IOException{
		return Util.chooseFile(frame, lastEcorePath, "Export - Ecore", "Ecore (*.ecore)", "ecore",true);
	}
	
	public File chooseUMLFile() throws IOException{
		return Util.chooseFile(frame, lastUmlPath, "Export - UML", "UML2 (*.uml)", "uml",true);
	}
	
	public File choosePNGFile() throws IOException{
		return Util.chooseFile(frame, lastPngPath, "Export - PNG", "Portable Network Graphics (*.png)", "png",true);
	}
	
	public void exportToReferenceOntouml(){				
		try {
			File file = chooseRefOntoumlFile();
			if(file==null) return;
			CursorUIController.get().waitCursor();
			RefOntoUML.Package model = ProjectUIController.get().getProject().getModel();
			//save to an external resource
			ResourceSet rset = MenthorDomain.get().getResourceSet();
			Resource r = rset.createResource(URI.createFileURI(file.getAbsolutePath()));
			r.getContents().add(ProjectUIController.get().getProject().getModel());
			try{
		    	r.save(Collections.emptyMap());
		    }catch(IOException e){
		    	e.printStackTrace();
		    }
			//bring back reference in memory to the menthor resource
			ProjectUIController.get().getProject().getResource().getContents().add(model);					
			lastRefOntoPath = file.getAbsolutePath();			
			MessageUIController.get().showSuccess("Export - RefOntouml", "Project successfully exported to Reference OntoUML.\nLocation: "+lastRefOntoPath);
		} catch (Exception ex) {
			MessageUIController.get().showError(ex,"Export - RefOntouml","Current project could not be exported to Reference OntoUML.");
		}		
		CursorUIController.get().defaultCursor();
	}	
		
	public void exportToEcore(){
		try {
			File file = chooseEcoreFile();
			if(file==null) return;
			CursorUIController.get().waitCursor();				
			OntoUML2EcoreOption opt = new OntoUML2EcoreOption(false,false);
			OntoUML2Ecore.convertToEcore(ProjectUIController.get().getProject().getRefParser(), file.getAbsolutePath(), opt);
			lastEcorePath = file.getAbsolutePath();				
			MessageUIController.get().showSuccess("Export - Ecore", "Project successfully exported to Ecore.\nLocation: "+lastEcorePath);										
		} catch (Exception ex) {
			MessageUIController.get().showError(ex, "Export - Ecore", "Current project could not be exported to Ecore");									
		}		
		CursorUIController.get().defaultCursor();		
	}
	
	public void exportToProfileUML(){		
		try {
			File file = chooseUMLFile();
			if(file==null) return;
			CursorUIController.get().waitCursor();				
			OntoUML2UMLOption opt = new OntoUML2UMLOption(false,false);
			OntoUML2UML.convertToUMLProfile(ProjectUIController.get().getProject().getRefParser(),file.getAbsolutePath(),opt);							
			lastUmlPath = file.getAbsolutePath();				
			MessageUIController.get().showSuccess("Export - UML Profile", "Project successfully exported to Profile UML.\nLocation: "+lastUmlPath);										
		} catch (Exception ex) {
			MessageUIController.get().showError(ex,"Export - UML Profile", "Current project could not be exported to UML Profile");
		}		
		CursorUIController.get().defaultCursor();
	}	
	
	public void exportToUML(){
		try {
			File file = chooseUMLFile();
			if(file==null) return;
			CursorUIController.get().waitCursor();			
			OntoUML2UMLOption opt = new OntoUML2UMLOption(false,false);
			OntoUML2UML.convertToUML(ProjectUIController.get().getProject().getRefParser(),file.getAbsolutePath(),opt);			
			lastUmlPath = file.getAbsolutePath();				
			MessageUIController.get().showSuccess("Export - UML", "Project successfully exported to UML.\nLocation: "+lastUmlPath);																			
		} catch (Exception ex) {					
			MessageUIController.get().showError(ex, "Export - UML", "Current project could not be exported to UML.");			
		}		
		CursorUIController.get().defaultCursor();		
	}
	
	public void exportToPng(){		
		try {
			File file = choosePNGFile();
			if(file==null) return;			
			OntoumlEditor editor = TabbedAreaUIController.get().getSelectedTopOntoumlEditor();
			List<Point> points = editor.getUsedCanvasSize();
			Point origin = points.get(0);
			Point end = points.get(1);			
			BufferedImage image = new BufferedImage((int) end.x+20, (int) end.y+20, BufferedImage.TYPE_INT_RGB);
			editor.paintComponentNonScreen(image.getGraphics());
			BufferedImage croped = image.getSubimage(origin.x - 20, origin.y - 20, (end.x + 40 - origin.x), (end.y + 40 - origin.y));
			ImageIO.write(croped, "png", file);
		} catch (IOException ex) {
			MessageUIController.get().showError(ex, "Export - PNG", "Could not export current diagram into a PNG image.");
		}		
	}
}
