package net.menthor.editor.v2.managers;

import javax.swing.JFrame;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.ui.FrameUI;

public abstract class GenericFeature {
	
	public JFrame parent(){ return FrameUI.get(); }
	public ICommandListener listener(){ return CommandListener.get(); }	
}
