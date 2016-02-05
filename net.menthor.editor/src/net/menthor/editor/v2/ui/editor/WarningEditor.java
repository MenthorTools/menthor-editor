package net.menthor.editor.v2.ui.editor;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.types.EditorType;

public class WarningEditor extends ProblemEditor {

	private static final long serialVersionUID = -5494468412766505324L;
	
	public WarningEditor(CommandListener listener) {
		super(listener);
	}	
	
	@Override
	public EditorType getEditorType() { return EditorType.WARNING_EDITOR; }
}
