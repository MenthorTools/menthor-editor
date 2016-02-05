package net.menthor.editor.v2.managers;

import java.util.ArrayList;
import java.util.Collections;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.ui.diagram.commands.AlignElementsCommand;
import org.tinyuml.ui.diagram.commands.AlignElementsCommand.Alignment;
import org.tinyuml.umldraw.ClassElement;

public class AlignManager extends BaseManager {

	// -------- Lazy Initialization

	private static class DuplicateLoader {
        private static final AlignManager INSTANCE = new AlignManager();
    }	
	public static AlignManager get() { 
		return DuplicateLoader.INSTANCE; 
	}	
    private AlignManager() {
        if (DuplicateLoader.INSTANCE != null) throw new IllegalStateException("AlignManager already instantiated");
    }		
    
    // ----------------------------
	
    private void executeAlign(ArrayList<DiagramElement> diagramElements, Alignment mode ) {
		AlignElementsCommand command = new AlignElementsCommand(TabManager.get().getCurrentDiagramEditor(), diagramElements, mode);
		command.run();
		editorTabbedPane().updateUI();
	}
    
    public void executeAlignCenterVertically(ArrayList<DiagramElement> diagramElements){
    	executeAlign(diagramElements, Alignment.CENTER_VERTICAL);
	}
	
	public void executeAlignCenterHorizontally(ArrayList<DiagramElement> diagramElements){
		executeAlign(diagramElements, Alignment.CENTER_HORIZONTAL);
	}
	
	public void executeAlignBottom(ArrayList<DiagramElement> diagramElements){
		executeAlign(diagramElements, Alignment.BOTTOM);
	}
		
	public void executeAlignTop(ArrayList<DiagramElement> diagramElements){
		executeAlign(diagramElements, Alignment.TOP);
	}
	
	public void executeAlignRight(ArrayList<DiagramElement> diagramElements){
		executeAlign(diagramElements, Alignment.RIGHT);
	}
	
	public void executeAlignLeft(ArrayList<DiagramElement> diagramElements){
		executeAlign(diagramElements, Alignment.LEFT);
	}
	
    /** Align Bottom */
	public void alignBottom()
	{
		DiagramEditor de = TabManager.get().getCurrentDiagramEditor();
		ArrayList<ClassElement> classElements = new ArrayList<ClassElement>(de.getSelectedClassElements());
		
		ClassElement atbottom = de.getClassElementAtBottom(classElements);				
		
		if(atbottom!=null){
			double atbottomY2 = atbottom.getAbsoluteY2();
			for(ClassElement element: classElements)
			{					
				ClassElement ce = element;	
				double ceHeight = ce.getAbsoluteBounds().getHeight();
				if(!ce.equals(atbottom)){
					ce.setAbsolutePos(ce.getAbsoluteX1(),atbottomY2-ceHeight);
				}
			}			
		}		
	}
	
	/** Align Top */
	public void alignTop()
	{
		DiagramEditor de = TabManager.get().getCurrentDiagramEditor();
		ArrayList<ClassElement> classElements = new ArrayList<ClassElement>(de.getSelectedClassElements());
		
		ClassElement attop = de.getClassElementAtTop(classElements);				
		
		if(attop!=null){
			double attopY1 = attop.getAbsoluteY1();
			for(ClassElement element: classElements)
			{					
				ClassElement ce = element;				
				if(!ce.equals(attop)){
					ce.setAbsolutePos(ce.getAbsoluteX1(),attopY1);
				}
			}			
		}
	}	
	
	/** Align Left */
	public void alignLeft()
	{
		DiagramEditor de = TabManager.get().getCurrentDiagramEditor();
		ArrayList<ClassElement> classElements = new ArrayList<ClassElement>(de.getSelectedClassElements());
		
		ClassElement atleft = de.getClassElementAtLeft(classElements);				
		if(atleft!=null){
			double atrightX1 = atleft.getAbsoluteX1();
			for(ClassElement element: classElements)
			{					
				ClassElement ce = element;				
				if(!ce.equals(atleft)){
					ce.setAbsolutePos(atrightX1,ce.getAbsoluteY1());
				}
			}			
		}		
	}
	
	/** Align Right */
	public void alignRight()
	{		
		DiagramEditor de = TabManager.get().getCurrentDiagramEditor();
		ArrayList<ClassElement> classElements = new ArrayList<ClassElement>(de.getSelectedClassElements());
		
		ClassElement atright = de.getClassElementAtRight(classElements);				
		if(atright!=null){
			double atrightX2 = atright.getAbsoluteX2();
			for(ClassElement element: classElements)
			{					
				ClassElement ce = element;	
				double ceWidth = ce.getAbsoluteBounds().getWidth();
				if(!ce.equals(atright)){
					ce.setAbsolutePos(atrightX2-ceWidth,ce.getAbsoluteY1());
				}
			}			
		}		
	}
		
	/** Align Center Vertically */
	public void alignCenterVertically()
	{
		DiagramEditor de = TabManager.get().getCurrentDiagramEditor();
		ArrayList<ClassElement> classElements = new ArrayList<ClassElement>(de.getSelectedClassElements());
		
		if (classElements.size() > 0) 
		{
			ArrayList<Double> coordList = new ArrayList<Double>();
			
			for(DiagramElement elements: classElements)
			{				
				ClassElement ce = (ClassElement)elements;				
				coordList.add(ce.getAbsCenterX());	
			}
			double finalpos = calculateCenterAlignPosition(coordList);
			ClassElement larger = getClassElementLargestWidth(classElements);			
			if(finalpos!=-1 && larger !=null)
			{		
				double largerWidth = larger.getAbsoluteBounds().getWidth();
				((ClassElement)larger).setAbsolutePos(finalpos-(largerWidth/2),larger.getAbsoluteY1());
				for(ClassElement element: classElements)
				{					
					ClassElement ce = element;	
					double ceWidth = ce.getAbsoluteBounds().getWidth();
					if(!ce.equals(larger)){
						ce.setAbsolutePos(finalpos-(ceWidth/2),ce.getAbsoluteY1());
					}
				}
			}			
		}
	}

	/** Align Center Horizontally */
	public void alignCenterHorizontally ()
	{
		DiagramEditor de = TabManager.get().getCurrentDiagramEditor();
		ArrayList<ClassElement> classElements = new ArrayList<ClassElement>(de.getSelectedClassElements());
		
		if (classElements.size() > 0) 
		{
			ArrayList<Double> coordList = new ArrayList<Double>();
			
			for(ClassElement element: classElements)
			{				
				ClassElement ce = element;				
				coordList.add(ce.getAbsCenterY());	
			}
			double finalpos = calculateCenterAlignPosition(coordList);
			ClassElement larger = getClassElementLargestHeight(classElements);			
			if(finalpos!=-1 && larger !=null)
			{		
				double largerHeight= larger.getAbsoluteBounds().getHeight();
				((ClassElement)larger).setAbsolutePos(larger.getAbsoluteX1(),finalpos-(largerHeight/2));
				for(ClassElement element: classElements)
				{					
					ClassElement ce = element;	
					double ceHeight = ce.getAbsoluteBounds().getHeight();
					if(!ce.equals(larger)){
						ce.setAbsolutePos(ce.getAbsoluteX1(),finalpos-(ceHeight/2));
					}
				}
			}			
		}			
	}
	
	/** Algorithm to calculate the center alignment position */
	public double calculateCenterAlignPosition(ArrayList<Double> coordList)
	{
		Collections.sort(coordList);
		int size = coordList.size();
		double offset = 1000;
		double finalpos = -1;			
		if(coordList.size()>0 && coordList.get(0)==coordList.get(size-1)) return finalpos;			
		for(int i =size-1; i>=0;i--){
			for(int j=i-1; j>=0;j--){
				double diff = coordList.get(i)-coordList.get(j);
				if(diff<offset) { finalpos = coordList.get(j)+(diff/2); offset = diff; }
			}
		}
		return finalpos;
	}
	
	/** Returns the class element with the largest width */
	public ClassElement getClassElementLargestWidth(ArrayList<ClassElement> list)
	{
		double maxwidth = 0;
		ClassElement largerWidthElement = null;
		for(DiagramElement de: list){
			if(de.getAbsoluteBounds().getWidth()>maxwidth) {
				maxwidth = de.getAbsoluteBounds().getWidth();
				largerWidthElement = (ClassElement)de;				
			}
		}
		return largerWidthElement;		
	}
	
	/** Returns the class element with the largest height */
	public ClassElement getClassElementLargestHeight(ArrayList<ClassElement> list)
	{
		double maxheight = 0;
		ClassElement largerHeightElement = null;
		for(DiagramElement de: list){
			if(de.getAbsoluteBounds().getHeight()>maxheight) {
				maxheight = de.getAbsoluteBounds().getHeight();
				largerHeightElement = (ClassElement)de;				
			}
		}		
		return largerHeightElement;		
	}
}
