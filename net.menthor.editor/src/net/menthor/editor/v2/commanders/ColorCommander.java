
package net.menthor.editor.v2.commanders;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JColorChooser;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.umldraw.ClassElement;

import net.menthor.editor.v2.ui.app.AppFrame;
import net.menthor.editor.v2.ui.operation.diagram.ColorOperation;

public class ColorCommander extends GenericCommander {
	
	private Color lastSelectedColor=Color.LIGHT_GRAY;
	private Color copiedColor=Color.WHITE;
	
	// -------- Lazy Initialization
	
	private static class ChangeLoader {
        private static final ColorCommander INSTANCE = new ColorCommander();
    }	
	public static ColorCommander get() { 
		return ChangeLoader.INSTANCE; 
	}	
    private ColorCommander() {
        if (ChangeLoader.INSTANCE != null) throw new IllegalStateException("ChangeManager already instantiated");
    }		
    
    // ----------------------------
	
    // Methods to prepare SetColorCommands
    
	public void copyBackgroundColor(Object obj){
		ArrayList<ClassElement> elements = setUpList(obj,ClassElement.class);
		if(elements.size()>0)
			copiedColor = elements.get(0).getBackgroundColor();
	}

	public void pasteBackgroundColor(Object obj){
		List<DiagramElement> classElements = setUpList(obj, DiagramElement.class);	
		if (copiedColor != null)
			createAndRunCommand(classElements, copiedColor);
	}
	
	public void setBackgroundColor(Object obj)
	{
		ArrayList<DiagramElement> elements = setUpList(obj,DiagramElement.class);
		setBackgroundColor(elements);
	}
	
	public void setBackgroundColor(List<DiagramElement> elements){		
		
		if(elements.size()==0)
			return;
		
		Color selectedColor = JColorChooser.showDialog(AppFrame.get(), "Select a Background Color", lastSelectedColor);
		
		if (selectedColor != null){
			lastSelectedColor = selectedColor;
			createAndRunCommand(elements, selectedColor);
		}        		   
	}
	
	
	//////////////////////////////////////////////////////////////////////////////
	// HELPERS																	// 
	//////////////////////////////////////////////////////////////////////////////
	

	private void createAndRunCommand(List<DiagramElement> elementList, Color color){
		execute(new ColorOperation(currentEditor(), elementList, color));
	}
	
}
