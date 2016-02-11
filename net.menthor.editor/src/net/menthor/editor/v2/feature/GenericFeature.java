package net.menthor.editor.v2.feature;

import javax.swing.JFrame;

import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.ui.app.AppCmdListener;
import net.menthor.editor.v2.ui.app.AppFrame;

public abstract class GenericFeature {
	
	public JFrame parent(){ return AppFrame.get(); }
	public ICommandListener listener(){ return AppCmdListener.get(); }	
}
