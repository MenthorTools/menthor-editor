package net.menthor.editor.v2.managers;

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
import java.util.List;

import javax.imageio.ImageIO;

import org.tinyuml.ui.diagram.OntoumlEditor;

import RefOntoUML.util.RefOntoUMLResourceUtil;
import net.menthor.editor.v2.ui.controller.CursorController;
import net.menthor.editor.v2.ui.controller.MessageController;
import net.menthor.editor.v2.ui.controller.TabbedAreaController;
import net.menthor.editor.v2.util.Util;
import net.menthor.ontouml2ecore.OntoUML2Ecore;
import net.menthor.ontouml2ecore.OntoUML2EcoreOption;
import net.menthor.ontouml2uml.OntoUML2UML;
import net.menthor.ontouml2uml.OntoUML2UMLOption;

public class ExportManager extends AbstractManager {

	// -------- Lazy Initialization

	private static class ExportLoader {
        private static final ExportManager INSTANCE = new ExportManager();
    }	
	public static ExportManager get() { 
		return ExportLoader.INSTANCE; 
	}	
    private ExportManager() {
        if (ExportLoader.INSTANCE != null) throw new IllegalStateException("ExportManager already instantiated");
    }		
    
    // ----------------------------
	
	public String lastRefOntoPath = new String();
	public String lastUmlPath = new String();
	public String lastEcorePath = new String();
	public String lastPngPath = new String();
	
	public File chooseRefOntoumlFile() throws IOException{
		return Util.chooseFile(frame(), lastRefOntoPath, "Export - RefOntouml", "Reference OntoUML (*.refontouml)", "refontouml",true);
	}
	
	public File chooseEcoreFile() throws IOException{
		return Util.chooseFile(frame(), lastEcorePath, "Export - Ecore", "Ecore (*.ecore)", "ecore",true);
	}
	
	public File chooseUMLFile() throws IOException{
		return Util.chooseFile(frame(), lastUmlPath, "Export - UML", "UML2 (*.uml)", "uml",true);
	}
	
	public File choosePNGFile() throws IOException{
		return Util.chooseFile(frame(), lastPngPath, "Export - PNG", "Portable Network Graphics (*.png)", "png",true);
	}
	
	public void exportToReferenceOntouml(){				
		try {
			File file = chooseRefOntoumlFile();
			if(file==null) return;
			CursorController.get().waitCursor();			
			RefOntoUMLResourceUtil.saveModel(file.getAbsolutePath(), ProjectManager.get().getProject().getModel());		
			lastRefOntoPath = file.getAbsolutePath();			
			MessageController.get().showSuccess("Export - RefOntouml", "Project successfully exported to Reference OntoUML.\nLocation: "+lastRefOntoPath);
		} catch (Exception ex) {
			MessageController.get().showError(ex,"Export - RefOntouml","Current project could not be exported to Reference OntoUML.");
		}		
		CursorController.get().defaultCursor();
	}	
		
	public void exportToEcore(){
		try {
			File file = chooseEcoreFile();
			if(file==null) return;
			CursorController.get().waitCursor();				
			OntoUML2EcoreOption opt = new OntoUML2EcoreOption(false,false);
			OntoUML2Ecore.convertToEcore(ProjectManager.get().getProject().getRefParser(), file.getAbsolutePath(), opt);
			lastEcorePath = file.getAbsolutePath();				
			MessageController.get().showSuccess("Export - Ecore", "Project successfully exported to Ecore.\nLocation: "+lastEcorePath);										
		} catch (Exception ex) {
			MessageController.get().showError(ex, "Export - Ecore", "Current project could not be exported to Ecore");									
		}		
		CursorController.get().defaultCursor();		
	}
	
	public void exportToProfileUML(){		
		try {
			File file = chooseUMLFile();
			if(file==null) return;
			CursorController.get().waitCursor();				
			OntoUML2UMLOption opt = new OntoUML2UMLOption(false,false);
			OntoUML2UML.convertToUMLProfile(ProjectManager.get().getProject().getRefParser(),file.getAbsolutePath(),opt);							
			lastUmlPath = file.getAbsolutePath();				
			MessageController.get().showSuccess("Export - UML Profile", "Project successfully exported to Profile UML.\nLocation: "+lastUmlPath);										
		} catch (Exception ex) {
			MessageController.get().showError(ex,"Export - UML Profile", "Current project could not be exported to UML Profile");
		}		
		CursorController.get().defaultCursor();
	}	
	
	public void exportToUML(){
		try {
			File file = chooseUMLFile();
			if(file==null) return;
			CursorController.get().waitCursor();			
			OntoUML2UMLOption opt = new OntoUML2UMLOption(false,false);
			OntoUML2UML.convertToUML(ProjectManager.get().getProject().getRefParser(),file.getAbsolutePath(),opt);			
			lastUmlPath = file.getAbsolutePath();				
			MessageController.get().showSuccess("Export - UML", "Project successfully exported to UML.\nLocation: "+lastUmlPath);																			
		} catch (Exception ex) {					
			MessageController.get().showError(ex, "Export - UML", "Current project could not be exported to UML.");			
		}		
		CursorController.get().defaultCursor();		
	}
	
	public void exportToPng(){		
		try {
			File file = choosePNGFile();
			if(file==null) return;			
			OntoumlEditor editor = TabbedAreaController.get().selectedTopOntoumlEditor();
			List<Point> points = editor.getUsedCanvasSize();
			Point origin = points.get(0);
			Point end = points.get(1);			
			BufferedImage image = new BufferedImage((int) end.x+20, (int) end.y+20, BufferedImage.TYPE_INT_RGB);
			editor.paintComponentNonScreen(image.getGraphics());
			BufferedImage croped = image.getSubimage(origin.x - 20, origin.y - 20, (end.x + 40 - origin.x), (end.y + 40 - origin.y));
			ImageIO.write(croped, "png", file);
		} catch (IOException ex) {
			MessageController.get().showError(ex, "Export - PNG", "Could not export current diagram into a PNG image.");
		}		
	}
}
