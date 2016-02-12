package net.menthor.editor.v2.ui.notify;

import org.tinyuml.ui.diagram.OntoumlEditor;

public abstract class DiagramCommand extends GenericCommand {
	
	private static final long serialVersionUID = 6382309607858531755L;
	
	protected OntoumlEditor ontoumlEditor;
	
	public OntoumlEditor getOntoumlEditor(){
		return ontoumlEditor;
	}
}
