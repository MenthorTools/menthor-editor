package net.menthor.editor.v2.managers;

import java.util.ArrayList;
import java.util.List;

import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.ui.diagram.commands.AddNodeCommand;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.StructureDiagram;

public class DuplicateManager extends BaseManager {

	private static DuplicateManager instance = new DuplicateManager();
	public static DuplicateManager get() { return instance; }
	
	@SuppressWarnings("unchecked")
	public void duplicate(Object obj){
		if(obj instanceof List<?>) duplicate((List<ClassElement>)obj);
		if(obj instanceof ClassElement) duplicate((ClassElement)obj);
	}
	
	public List<ClassElement> duplicate(List<ClassElement> classElements){		
		List<ClassElement> newOnes = new ArrayList<ClassElement>();
		for(ClassElement ce: classElements){
			newOnes.add(duplicate(ce));
		}
		
		return newOnes;
	}
	
	public ClassElement duplicate(ClassElement classElement){		
		ClassElement newClass = (ClassElement)classElement.clone();
		OccurenceManager.get().add(newClass.getClassifier(),newClass);
		DiagramEditor editor = diagramManager.getDiagramEditor((StructureDiagram)classElement.getDiagram());
		double x = classElement.getAbsoluteX2()+15;
		double y = classElement.getAbsoluteY2()+15;
		AddNodeCommand cmd = new AddNodeCommand(editor,editor.getDiagram(),newClass.getClassifier(), 
		x, y, (RefOntoUML.Element)newClass.getClassifier().eContainer());		
		cmd.run();		
		return newClass;
	}
}
