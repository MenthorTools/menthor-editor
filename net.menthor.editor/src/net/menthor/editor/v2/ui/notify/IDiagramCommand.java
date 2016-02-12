package net.menthor.editor.v2.ui.notify;

import org.tinyuml.ui.diagram.OntoumlEditor;

public interface IDiagramCommand extends IUndoableCommand {

	public OntoumlEditor getOntoumlEditor();
}
