package net.menthor.editor.v2.ui.notify.model;

import net.menthor.editor.v2.ui.notify.ModelCommand;
import net.menthor.editor.v2.ui.notify.NotificationType;

//TODO: refatorar o DeleteDiagramCommand. parte dele vem pra cá.
public class DeleteElementModelCommand extends ModelCommand {

	private static final long serialVersionUID = 3798222350326038273L;

	public DeleteElementModelCommand(){
		super();
		this.notificationType = NotificationType.DELETE;
	}
}
