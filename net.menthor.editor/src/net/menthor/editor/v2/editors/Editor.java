package net.menthor.editor.v2.editors;

import net.menthor.editor.v2.types.EditorType;

import org.eclipse.emf.edit.provider.IDisposable;

public interface Editor extends IDisposable {
	
	public boolean isSaveNeeded();
	
	abstract EditorType getEditorType();
}
