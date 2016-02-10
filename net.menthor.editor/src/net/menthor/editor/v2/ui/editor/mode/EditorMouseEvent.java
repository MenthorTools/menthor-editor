package net.menthor.editor.v2.ui.editor.mode;

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

import java.awt.event.MouseEvent;

import org.tinyuml.draw.Scaling;

/**
 * This class encapsulates a mouse event. The properties of the
 * original MouseEvent are preserved by wrapping and delegating most
 * functionality to it.
 */

public class EditorMouseEvent {
	
	private MouseEvent event;
	private Scaling scaling;
  
	public void setMouseEvent(MouseEvent anEvent, Scaling aScaling) {
		this.event = anEvent;
		this.scaling = aScaling;
	}

	public MouseEvent getMouseEvent() { return event; }
	public boolean isScaling100(){ return scaling == Scaling.SCALING_100; }
	public int getClickCount() { return event.getClickCount(); }
	public boolean isPopupTrigger() { return event.isPopupTrigger(); }
	public boolean isMainButton() { return event.getButton() == MouseEvent.BUTTON1; }
	
	public double getX() {
		return scaling ==  Scaling.SCALING_100 ? event.getX() : event.getX()/scaling.getScaleFactor();
	}
	public double getY() {
		return scaling ==  Scaling.SCALING_100 ? event.getY() : event.getY()/scaling.getScaleFactor();
	}
}
