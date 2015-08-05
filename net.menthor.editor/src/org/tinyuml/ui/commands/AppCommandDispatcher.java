package org.tinyuml.ui.commands;

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

import java.util.HashMap;
import java.util.Map;

import org.tinyuml.ui.diagram.DiagramEditor;

import net.menthor.editor.AppFrame;
import net.menthor.editor.DiagramManager;
import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.MethodCall;

/**
 * This class receives BaseEditor related AppCommands and dispatches them to
 * the right places. This offloads editor related commands from the
 * AppFrame object, while AppFrame handles commands on a global level,
 * DiagramEditorCommandDispatcher handles it on the level of the current editor.
 *
 * @author Wei-ju Wu, John Guerson 
 */
public class AppCommandDispatcher implements CommandListener {
	
	private Map<String, MethodCall> selectorMap = new HashMap<String, MethodCall>();

	public Map<String, MethodCall> getMap()
	{ return selectorMap; }
	
	/**
	 * Constructor.
	 * @param aFrame the application frame
	 */
	public AppCommandDispatcher(DiagramManager manager, AppFrame frame) {
	
		initSelectorMap();
	
	}

	/**
	 * Initializes the selector map.
	 */
	private void initSelectorMap() {
		try {

			selectorMap.put("EDIT_PROPERTIES", new MethodCall(
					DiagramEditor.class.getMethod("editProperties")));

			selectorMap.put("DELETE", new MethodCall(
					DiagramEditor.class.getMethod("deleteSelection")));

			selectorMap.put("EXCLUDE", new MethodCall(
					DiagramEditor.class.getMethod("excludeSelection")));

			selectorMap.put("RESET_POINTS", new MethodCall(
					DiagramEditor.class.getMethod("resetConnectionPoints")));

			selectorMap.put("RECT_TO_DIRECT", new MethodCall(
					DiagramEditor.class.getMethod("toDirect")));

			selectorMap.put("DIRECT_TO_RECT", new MethodCall(
					DiagramEditor.class.getMethod("toRectilinear")));

			selectorMap.put("TREE_STYLE_VERTICAL", new MethodCall(
					DiagramEditor.class.getMethod("toTreeStyleVertical")));
			
			selectorMap.put("TREE_STYLE_HORIZONTAL", new MethodCall(
					DiagramEditor.class.getMethod("toTreeStyleHorizontal")));
						
			selectorMap.put("CREATE_GEN_SET", new MethodCall(
					DiagramEditor.class.getMethod("addGeneralizationSet")));
			selectorMap.put("DELETE_GEN_SET", new MethodCall(
					DiagramEditor.class.getMethod("deleteGeneralizationSet")));
			
		} catch (NoSuchMethodException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void handleCommand(String command, Object parameter) {
		// TODO Auto-generated method stub
		
	}
}
