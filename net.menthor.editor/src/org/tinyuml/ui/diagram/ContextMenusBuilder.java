package org.tinyuml.ui.diagram;

/**
 * Copyright 2007 Wei-ju Wu
 *
 * This file is part of TinyUML.
 *
 * TinyUML is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * TinyUML is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with TinyUML; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

import java.util.ArrayList;

import javax.swing.JPopupMenu;

import org.tinyuml.draw.Connection;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.Selection;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.shared.UmlConnection;
import org.tinyuml.umldraw.shared.UmlDiagramElement;

import net.menthor.editor.ui.MultiSelectionPopupMenu;
import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.menus.ConnectionPopupMenu;
import net.menthor.editor.v2.menus.NodePopupMenu;

/**
 * This class creates context menus, depending on the specified parameters.
 * 
 * @author Wei-ju Wu, John Guerson
 */
public class ContextMenusBuilder {
	
	private DiagramEditor editor;
	
	private NodePopupMenu singleNodePopup;	
	private ConnectionPopupMenu singleConnectionPopup;	
	private MultiSelectionPopupMenu multiSelectinoPopup;
	
	public ContextMenusBuilder(DiagramEditor editor)
	{
		this.editor = editor;
		singleNodePopup = new NodePopupMenu(editor.getDiagramManager().getFrame());
		singleConnectionPopup = new ConnectionPopupMenu(editor.getDiagramManager().getFrame());		
		multiSelectinoPopup = new MultiSelectionPopupMenu();
	}
	
	/**
	 * Created a popup menu for the specified selection.
	 * 
	 * @param selection
	 *            the selection
	 * @return the popup menu
	 */
	public JPopupMenu setContext(Selection selection, double x, double y) {
		if (selection.getElements().size() > 1) {
			multiSelectinoPopup.setSelectedElements((ArrayList<DiagramElement>) selection.getElements(),editor);
			return multiSelectinoPopup;
		} else {
			UmlDiagramElement elem = (UmlDiagramElement) selection.getElement();
			if (elem instanceof Connection) {
				if(elem instanceof AssociationElement){
					// detects when the click is close to the edges...
					double cx1 = ((Connection)elem).getAbsoluteX1();
					double cx2 = ((Connection)elem).getAbsoluteX2();
					double cy1 = ((Connection)elem).getAbsoluteY1();
					double cy2 = ((Connection)elem).getAbsoluteY2();
					double diffx1 = (x-cx1); double diffy1 = (y-cy1);
					double diffx2 = (x-cx2); double diffy2 = (y-cy2);
					if (diffx1<0) diffx1 = diffx1*(-1); if (diffy1<0) diffy1 = diffy1*(-1);
					if (diffx2<0) diffx2 = diffx2*(-1); if (diffy2<0) diffy2 = diffy2*(-1);
					if(diffx1<30 && diffy1<30){	
						singleConnectionPopup.setContext((UmlConnection)elem);//true (isSourceEndPoint)
						return singleConnectionPopup;
					}else if(diffx2<30 && diffy2<30){
						singleConnectionPopup.setContext((UmlConnection)elem);//false (isSourceEndPoint)
						return singleConnectionPopup;
					}
				}				
				singleConnectionPopup.setContext((Connection)elem);
				return singleConnectionPopup;				
			}
			singleNodePopup.setContext(elem);
			return singleNodePopup;
		}
	}
	
	public JPopupMenu setContext(UmlDiagramElement diagramElement) {
		return null;
	}
	
	/**
	 * Adds the specified AppCommandListener.
	 * 
	 * @param l
	 *            the AppCommandListener to add
	 */
	public void addAppCommandListener(CommandListener l) {		
		multiSelectinoPopup.addAppCommandListener(l);
	}
}
