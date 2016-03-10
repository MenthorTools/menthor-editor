package net.menthor.editor.v2.ui.icon;

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

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public final class IconMap {

	private static IconMap instance = new IconMap();
	public static IconMap getInstance() { return instance; }
	
	private Map<IconType, String> urlMap = new HashMap<IconType, String>();
	private Map<IconType, Icon> iconMap = new HashMap<IconType, Icon>();
	private Map<String, IconType> iconTypeMap = new HashMap<String, IconType>();
	
	private IconMap() 
	{
		for (IconType iconType : IconType.values()) {
			iconTypeMap.put(iconType.toString(), iconType);
		}				
		
		//images
		urlMap.put(IconType.MENTHOR_WELCOME_SLOGAN, "resources/image/slogan.png");		
		urlMap.put(IconType.MENTHOR_WELCOME_LOGO, "resources/image/logo.png");
		urlMap.put(IconType.MENTHOR_WELCOME_BACKGROUND, "resources/image/mountain.png");
		urlMap.put(IconType.MENTHOR_WELCOME_LEARN,"resources/image/learning.png");
		urlMap.put(IconType.MENTHOR_WELCOME_FAQ,"resources/image/faq.png");
		urlMap.put(IconType.MENTHOR_WELCOME_FORUM,"resources/image/forum.png");
		urlMap.put(IconType.MENTHOR_WELCOME_STUDYGUIDE,"resources/image/studyguide.png");
		urlMap.put(IconType.MENTHOR_SPLASH_SCREEN, "resources/image/splashscreenB.png");		
		
		//uml		
		urlMap.put(IconType.MENTHOR_PACKAGE, "resources/icon/ontouml/package.png");
		urlMap.put(IconType.MENTHOR_CLASS, "resources/icon/ontouml/class.png");
		urlMap.put(IconType.MENTHOR_DERIVATION, "resources/icon/ontouml/derivation.png");
		urlMap.put(IconType.MENTHOR_GENERALIZATION, "resources/icon/ontouml/generalization.png");
		urlMap.put(IconType.MENTHOR_GENERALIZATIONSET, "resources/icon/ontouml/generalizationset.gif");
		urlMap.put(IconType.MENTHOR_COMMENT, "resources/icon/ontouml/comment.png");
		urlMap.put(IconType.MENTHOR_NOTE, "resources/icon/ontouml/note.png");
		urlMap.put(IconType.MENTHOR_ASSOCIATION, "resources/icon/ontouml/association.png");		
		urlMap.put(IconType.MENTHOR_COMPONENTOF, "resources/icon/ontouml/componentof.png");
		urlMap.put(IconType.MENTHOR_SUBCOLLECTIONOF, "resources/icon/ontouml/subcollectionof.png");
		urlMap.put(IconType.MENTHOR_SUBQUANTITYOF, "resources/icon/ontouml/subquantityof.png");
		urlMap.put(IconType.MENTHOR_MEMBEROF, "resources/icon/ontouml/memberof.png");						
				
		//app
		urlMap.put(IconType.MENTHOR_CONSTRAINTDOC, "resources/icon/constraintdoc.png");
		urlMap.put(IconType.MENTHOR_APP_ICON, "resources/icon/appmenthor.png");
		urlMap.put(IconType.MENTHOR_DIAGRAM, "resources/icon/diagram.png");
		urlMap.put(IconType.MENTHOR_PATTERN, "resources/icon/pattern.png");
		urlMap.put(IconType.MENTHOR_MOUSE_POINTER, "resources/icon/mousepointer.png");;
		urlMap.put(IconType.MENTHOR_UP, "resources/icon/arrowup.png");
		urlMap.put(IconType.MENTHOR_DOWN, "resources/icon/arrowdown.png");
		urlMap.put(IconType.MENTHOR_SEMANTIC_WEB, "resources/icon/semanticweb.png");
		urlMap.put(IconType.MENTHOR_COLOR_CHOOSER, "resources/icon/colorchooser.png");
		urlMap.put(IconType.MENTHOR_TREE, "resources/icon/browser.png");		
		urlMap.put(IconType.MENTHOR_DOC, "resources/icon/document.png");
		urlMap.put(IconType.MENTHOR_FOLDER, "resources/icon/folder.png");
		urlMap.put(IconType.MENTHOR_SAVE, "resources/icon/save.png");
		urlMap.put(IconType.MENTHOR_STATS, "resources/icon/statistics.png");
		urlMap.put(IconType.MENTHOR_HAND_CURSOR, "resources/icon/handcursor.png");		
		urlMap.put(IconType.MENTHOR_ZOOM_IN, "resources/icon/zoomin.png");
		urlMap.put(IconType.MENTHOR_ZOOM_OUT, "resources/icon/zoomout.png");		
		urlMap.put(IconType.MENTHOR_DELETE, "resources/icon/delete.png");
		urlMap.put(IconType.MENTHOR_ADD_GREEN, "resources/icon/addbox.png");
		urlMap.put(IconType.MENTHOR_ADD, "resources/icon/add.png");
		urlMap.put(IconType.MENTHOR_EDIT, "resources/icon/edit.png");
		urlMap.put(IconType.MENTHOR_ERASE, "resources/icon/erase.png");
		urlMap.put(IconType.MENTHOR_SETTINGS, "resources/icon/settings.png");
		urlMap.put(IconType.MENTHOR_EXPORT, "resources/icon/export.png");
		urlMap.put(IconType.MENTHOR_IMPORT, "resources/icon/import.png");	
		urlMap.put(IconType.MENTHOR_REDO, "resources/icon/redo.png");
		urlMap.put(IconType.MENTHOR_UNDO, "resources/icon/undo.png");
		urlMap.put(IconType.MENTHOR_SEARCH, "resources/icon/search.png");
		urlMap.put(IconType.MENTHOR_WARNING, "resources/icon/warning.png");
		urlMap.put(IconType.MENTHOR_ERROR, "resources/icon/error.png");		
		urlMap.put(IconType.MENTHOR_GRID, "resources/icon/grid.png");
		urlMap.put(IconType.MENTHOR_CHECK, "resources/icon/check.png");
		urlMap.put(IconType.MENTHOR_RECTILINEAR, "resources/icon/rectilinear.png");
		urlMap.put(IconType.MENTHOR_DIRECT, "resources/icon/direct.png");
		urlMap.put(IconType.MENTHOR_TO_BACK, "resources/icon/toback.png");
		urlMap.put(IconType.MENTHOR_TO_FRONT, "resources/icon/tofront.png");
		urlMap.put(IconType.MENTHOR_PLAY, "resources/icon/play.png");
		urlMap.put(IconType.MENTHOR_CLOSED, "resources/icon/closed.png");
		urlMap.put(IconType.MENTHOR_OPEN, "resources/icon/open.png");		
		urlMap.put(IconType.MENTHOR_FIT, "resources/icon/fit.png");		
		urlMap.put(IconType.MENTHOR_ALIGN_LEFT, "resources/icon/left.png");
		urlMap.put(IconType.MENTHOR_ALIGN_RIGHT, "resources/icon/right.png");
		urlMap.put(IconType.MENTHOR_ALIGN_BOTTOM, "resources/icon/bottom.png");
		urlMap.put(IconType.MENTHOR_ALIGN_TOP, "resources/icon/top.png");
		urlMap.put(IconType.MENTHOR_ALIGN_HORIZONTAL, "resources/icon/horizontal.png");
		urlMap.put(IconType.MENTHOR_ALIGN_VERTICAL, "resources/icon/vertical.png");
		urlMap.put(IconType.MENTHOR_HELP, "resources/icon/help.png");
		urlMap.put(IconType.MENTHOR_HELPROLLOVER, "resources/icon/helprollover.png");
	}

	public Icon getIcon(IconType type) {
		if (!iconMap.containsKey(type)){
			String urlstr = urlMap.get(type);
			if (urlstr != null){
				iconMap.put(type, new ImageIcon(getClass().getClassLoader().getResource(urlstr)));
			}
		}
		return iconMap.get(type);
	}

	public Icon getIcon(IconType icontype, int height, int width) {
		Icon icon = getIcon(icontype);
		Image img = ((ImageIcon)icon).getImage();  
		Image newimg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);  
		Icon newIcon = new ImageIcon(newimg);
		return newIcon;
	}

	public Icon getSmallIcon(IconType icontype){
		return getIcon(icontype,16,16);
	}
	
	public Icon getIcon(String typeName) {
		return getIcon(iconTypeMap.get(typeName));
	}
	
	public Image getImage(IconType icontype) {
		try {			
			return new ImageIcon(getClass().getClassLoader().getResource(urlMap.get(icontype))).getImage();
		} catch (Exception e) {
			return null;
		}
	}
	
	public Image getImage(String typeName) {
		try {
			IconType type = iconTypeMap.get(typeName);
			return new ImageIcon(getClass().getClassLoader().getResource(urlMap.get(type))).getImage();
		} catch (Exception e) {
			return null;
		}
	}
}
