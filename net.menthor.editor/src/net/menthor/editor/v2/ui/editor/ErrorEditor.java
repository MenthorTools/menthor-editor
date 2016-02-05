package net.menthor.editor.v2.ui.editor;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.types.EditorType;

public class ErrorEditor extends ProblemEditor {

	public ErrorEditor(CommandListener listener) {
		super(listener);
	}

	@Override
	public EditorType getEditorType() { return EditorType.ERRORS_EDITOR; }
	
	private static final long serialVersionUID = 6224415978635971593L;
	
}
