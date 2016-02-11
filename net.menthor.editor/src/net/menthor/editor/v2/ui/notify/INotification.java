package net.menthor.editor.v2.ui.notify;

import java.util.List;

import org.tinyuml.draw.DiagramElement;

/** Defines an interface to the diagram that handles change notifications. */
public interface INotification {

	/** This method is called when there is a change done by a Command. */
	String notifyChange(GenericCommand command, List<DiagramElement> elements, NotificationType changeType, ActionType notificationType);

}
