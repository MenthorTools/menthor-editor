
package net.menthor.editor.v2.ui.editor.base;

import org.eclipse.emf.edit.provider.IDisposable;

public interface IEditor extends IDisposable {
	
	public void propagateNewTitle(String title);
	
	public boolean isSaveNeeded();
	
	abstract EditorType getEditorType();
}
