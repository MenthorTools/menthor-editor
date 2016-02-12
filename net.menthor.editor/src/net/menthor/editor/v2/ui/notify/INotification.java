package net.menthor.editor.v2.ui.notify;

import java.util.List;

import org.tinyuml.draw.DiagramElement;

/** Defines an interface to handle notifications. */
public interface INotification {

	/** notify there was a change in the diagram, in the given elements, of a certain notification/action type */
	String notify(IDiagramCommand command, List<DiagramElement> elements, NotificationType changeType, ActionType notificationType);
	
	/** notify there was a change in the model, in the given element, of a certain notification/action type */
	String notify(ModelCommand command, RefOntoUML.Element element, NotificationType changeType, ActionType actionType);
}
