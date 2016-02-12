package net.menthor.editor.v2.ui.notify;

import org.tinyuml.ui.diagram.OntoumlEditor;

public abstract class DiagramCommand extends ModelCommand implements IDiagramCommand {
	
	private static final long serialVersionUID = 6382309607858531755L;
	
	protected OntoumlEditor ontoumlEditor;
	
	public OntoumlEditor getOntoumlEditor(){
		return ontoumlEditor;
	}
	
	@Override
	public void undo(){
		super.undo();
	}
	
	@Override
	public void run(){
		super.run();
	}
}
