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

import java.io.File;
import java.io.IOException;

import net.menthor.editor.ui.Models;
import net.menthor.editor.ui.PngWriter;
import net.menthor.editor.v2.util.EcoreWriter;
import net.menthor.editor.v2.util.UMLWriter;
import net.menthor.editor.v2.util.Util;
import net.menthor.editor.v2.util.XMIWriter;

public class ExportManager extends BaseManager {

	private static ExportManager instance = new ExportManager();
	public static ExportManager get() { return instance; }
	
	public String lastRefOntoPath = new String();
	public String lastUmlPath = new String();
	public String lastEcorePath = new String();
	public String lastPngPath = new String();
	
	public File chooseRefOntoumlFile() throws IOException{
		return Util.chooseFile(diagramManager, lastRefOntoPath, "Export Manager - RefOntouml", "Reference OntoUML (*.refontouml)", "refontouml");
	}
	
	public File chooseEcoreFile() throws IOException{
		return Util.chooseFile(diagramManager, lastEcorePath, "Export Manager - Ecore", "Ecore (*.ecore)", "ecore");
	}
	
	public File chooseUMLFile() throws IOException{
		return Util.chooseFile(diagramManager, lastUmlPath, "Export Manager - UML", "UML2 (*.uml)", "uml");
	}
	
	public File choosePNGFile() throws IOException{
		return Util.chooseFile(diagramManager, lastPngPath, "Export Manager - PNG", "Portable Network Graphics (*.png)", "png");
	}
	
	public void exportToReferenceOntouml(){				
		try {
			File file = chooseRefOntoumlFile();
			if(file==null) return;
			CursorManager.get().waitCursor();			
			XMIWriter exporter = new XMIWriter();
			exporter.toRefontouml(diagramManager.getFrame(),Models.getRefparser(), file);			
			lastRefOntoPath = file.getAbsolutePath();			
			MessageManager.get().showSuccess("Export Manager", "Project successfully exported to Reference OntoUML.\nLocation: "+lastRefOntoPath);
		} catch (Exception ex) {
			MessageManager.get().showError(ex,"Export Manager","Current project could not be exported to Reference OntoUML.");
		}		
		CursorManager.get().defaultCursor();
	}	
		
	public void exportToEcore(){
		try {
			File file = chooseEcoreFile();
			if(file==null) return;
			CursorManager.get().waitCursor();				
			EcoreWriter exporter = new EcoreWriter();
			exporter.toEcore(diagramManager.getFrame(),Models.getRefparser(), file);				
			lastEcorePath = file.getAbsolutePath();				
			MessageManager.get().showSuccess("Export Manager", "Project successfully exported to Ecore.\nLocation: "+lastEcorePath);										
		} catch (Exception ex) {
			MessageManager.get().showError(ex, "Export Manager", "Current project could not be exported to Ecore");									
		}		
		CursorManager.get().defaultCursor();		
	}
	
	public void exportToProfileUML(){		
		try {
			File file = chooseUMLFile();
			if(file==null) return;
			CursorManager.get().waitCursor();				
			UMLWriter exporter = new UMLWriter();
			exporter.toProfileUML(diagramManager.getFrame(),Models.getRefparser(), file);				
			lastUmlPath = file.getAbsolutePath();				
			MessageManager.get().showSuccess("Export Manager", "Project successfully exported to Profile UML.\nLocation: "+lastUmlPath);										
		} catch (Exception ex) {
			MessageManager.get().showError(ex,"Export Manager", "Current project could not be exported to UML Profile");
		}		
		CursorManager.get().defaultCursor();
	}	
	
	public void exportToUML(){
		try {
			File file = chooseUMLFile();
			if(file==null) return;
			CursorManager.get().waitCursor();			
			UMLWriter exporter = new UMLWriter();
			exporter.toUML(diagramManager.getFrame(),Models.getRefparser(), file);				
			lastUmlPath = file.getAbsolutePath();				
			MessageManager.get().showSuccess("Export Manager", "Project successfully exported to UML.\nLocation: "+lastUmlPath);																			
		} catch (Exception ex) {					
			MessageManager.get().showError(ex, "Export Manager", "Current project could not be exported to UML.");			
		}		
		CursorManager.get().defaultCursor();		
	}
	
	public void exportToPng(){		
		try {
			File file = choosePNGFile();
			if(file==null) return;
			PngWriter exporter = new PngWriter();
			exporter.writePNG(diagramManager.getCurrentDiagramEditor(), file);
		} catch (IOException ex) {
			MessageManager.get().showError(ex, "Export Image", "Could not export image.");
		}		
	}
}
