package org.tinyuml.ui.diagram;

import org.eclipse.emf.edit.provider.IDisposable;
import org.tinyuml.draw.Diagram;

import net.menthor.editor.ui.UmlProject;

public interface Editor extends IDisposable {

	public enum EditorNature
	{
		UML,
		ONTOUML,		
		TEXT,
		HTML,
		INSTANCE_VISUALIZER,
		READ_ONLY,
		FINDER,
		OCL,
		STATISTICS,
		PROBLEMS
	}
	
	public boolean isSaveNeeded();
	
	abstract EditorNature getEditorNature();
	
	abstract UmlProject getProject();
	
	abstract Diagram getDiagram();
	
}
