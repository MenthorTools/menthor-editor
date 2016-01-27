package net.menthor.editor.v2.toolbar;

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

import java.awt.Color;

import javax.swing.JButton;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconType;

public class DiagramToolBar extends BaseToolBar {

	private static final long serialVersionUID = 1L;
	
	private static Color background = null; //Color.WHITE;
	private JButton btnZoomStatus;
	
	
	public DiagramToolBar (CommandListener listener, int orientation){
		this(listener);	
	}
	
	public DiagramToolBar (CommandListener listener){		
		super(listener, background);	
		setBackground(background);
		createButton(IconType.MENTHOR_GRID, CommandType.SHOW_GRID, background);
		createButton(IconType.MENTHOR_ALIGN_BOTTOM,CommandType.ALIGN_BOTTOM,background);
		createButton(IconType.MENTHOR_ALIGN_TOP, CommandType.ALIGN_TOP, background);
		createButton(IconType.MENTHOR_ALIGN_HORIZONTAL,CommandType.ALIGN_HORIZONTAL,background);
		createButton(IconType.MENTHOR_ALIGN_LEFT,CommandType.ALIGN_LEFT,background);
		createButton(IconType.MENTHOR_ALIGN_VERTICAL,CommandType.ALIGN_VERTICAL,background);
		createButton(IconType.MENTHOR_ALIGN_RIGHT,CommandType.ALIGN_RIGHT,background);
		createButton(IconType.MENTHOR_TO_FRONT,CommandType.BRING_TO_FRONT,background);
		createButton(IconType.MENTHOR_TO_BACK,CommandType.PUT_BACK,background);
		createButton(IconType.MENTHOR_UNDO,CommandType.UNDO,background);
		createButton(IconType.MENTHOR_REDO,CommandType.REDO,background);
		createButton(IconType.MENTHOR_COLOR_CHOOSER,CommandType.SET_BACKGROUND_COLOR,background);		
		createButton(IconType.MENTHOR_EXPORT,CommandType.EXPORT_TO_PNG,background);
		createButton(IconType.MENTHOR_ZOOM_IN,CommandType.ZOOM_IN,background);
		createButton(IconType.MENTHOR_ZOOM_OUT,CommandType.ZOOM_OUT,background);
		createButton(IconType.MENTHOR_FIT,CommandType.FIT_TO_WINDOW,background);	
		btnZoomStatus = new JButton("100%");
		btnZoomStatus.setContentAreaFilled(false);		
		btnZoomStatus.setFocusable(false);
		btnZoomStatus.setBorderPainted(false);
		add(btnZoomStatus);
	}
	
	public void update(String zoomPercentage){		
		btnZoomStatus.setText(zoomPercentage+"%");		
	}
}