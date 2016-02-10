package net.menthor.editor.v2.ui.editor.info;

import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.ui.editor.EditorType;

public class WarningEditor extends ProblemEditor {

	private static final long serialVersionUID = -5494468412766505324L;
	
	public WarningEditor(ICommandListener listener) {
		super(listener);
	}	
	
	@Override
	public EditorType getEditorType() { return EditorType.WARNING_EDITOR; }
}
