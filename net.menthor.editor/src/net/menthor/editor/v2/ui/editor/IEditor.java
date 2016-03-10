
package net.menthor.editor.v2.ui.editor;

import org.eclipse.emf.edit.provider.IDisposable;

public interface IEditor extends IDisposable {
	
	public void propagateNewTitle(String title);
	
	public boolean isSaveNeeded();
	
	public void setSaveNeeded(boolean value);
	
	abstract EditorType getEditorType();
}
