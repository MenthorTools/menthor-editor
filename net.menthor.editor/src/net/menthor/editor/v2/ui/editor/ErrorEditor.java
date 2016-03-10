package net.menthor.editor.v2.ui.editor;

import net.menthor.editor.v2.commands.ICommandListener;

public class ErrorEditor extends ProblemEditor {

	public ErrorEditor(ICommandListener listener) {
		super(listener);
	}

	@Override
	public EditorType getEditorType() { return EditorType.ERRORS_EDITOR; }
	
	private static final long serialVersionUID = 6224415978635971593L;
	
}
