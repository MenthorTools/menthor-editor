package net.menthor.editor.v2.ui.notify;

/**
 * ============================================================================================
 * Menthor Editor -- Copyright (c) 2015 
 *
 * This file is part of Menthor Editor. Menthor Editor is based on TinyUML and as so it is 
 * distributed under the same license terms.
 *
 * Menthor Editor is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 *
 * Menthor Editor is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Menthor Editor; 
 * if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, 
 * MA  02110-1301  USA
 * ============================================================================================
 */

import java.util.List;

import org.tinyuml.draw.DiagramElement;

/** Defines an interface to handle notifications. */
public interface INotification {

	/** notify there was a change in the diagram, in the given elements, of a certain notification/action type */
	String notify(IDiagramCommand command, List<DiagramElement> elements, NotificationType changeType, ActionType notificationType);
	
	/** notify there was a change in the model, in the given element, of a certain notification/action type */
	String notify(ModelCommand command, RefOntoUML.Element element, NotificationType changeType, ActionType actionType);
}
