package net.menthor.editor.v2.ui.notify;

public abstract class DiagramCommand extends GenericCommand {
	
	private static final long serialVersionUID = 6382309607858531755L;
	
	protected Notification notificator; //notify the diagram about the change
}
