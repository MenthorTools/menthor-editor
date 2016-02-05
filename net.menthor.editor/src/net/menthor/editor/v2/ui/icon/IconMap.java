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
		urlMap.put(IconType.MENTHOR_WELCOME_SLOGAN, "net/menthor/editor/v2/ui/icon/img/slogan.png");		
		urlMap.put(IconType.MENTHOR_WELCOME_LOGO, "net/menthor/editor/v2/ui/icon/img/logo.png");
		urlMap.put(IconType.MENTHOR_WELCOME_BACKGROUND, "net/menthor/editor/v2/ui/icon/img/mountain.png");
		urlMap.put(IconType.MENTHOR_WELCOME_LEARN,"net/menthor/editor/v2/ui/icon/img/learning.png");
		urlMap.put(IconType.MENTHOR_WELCOME_FAQ,"net/menthor/editor/v2/ui/icon/img/faq.png");
		urlMap.put(IconType.MENTHOR_WELCOME_FORUM,"net/menthor/editor/v2/ui/icon/img/forum.png");
		urlMap.put(IconType.MENTHOR_WELCOME_STUDYGUIDE,"net/menthor/editor/v2/ui/icon/img/studyguide.png");
		urlMap.put(IconType.MENTHOR_SPLASH_SCREEN, "net/menthor/editor/v2/ui/icon/img/splashscreenB.png");		
		
		//uml		
		urlMap.put(IconType.MENTHOR_PACKAGE, "net/menthor/editor/v2/ui/icon/uml/package.png");
		urlMap.put(IconType.MENTHOR_CLASS, "net/menthor/editor/v2/ui/icon/uml/class.png");
		urlMap.put(IconType.MENTHOR_DERIVATION, "net/menthor/editor/v2/ui/icon/uml/derivation.png");
		urlMap.put(IconType.MENTHOR_GENERALIZATION, "net/menthor/editor/v2/ui/icon/uml/generalization.png");
		urlMap.put(IconType.MENTHOR_GENERALIZATIONSET, "net/menthor/editor/v2/ui/icon/uml/generalizationset.gif");
		urlMap.put(IconType.MENTHOR_COMMENT, "net/menthor/editor/v2/ui/icon/uml/comment.png");
		urlMap.put(IconType.MENTHOR_NOTE, "net/menthor/editor/v2/ui/icon/uml/note.png");
		urlMap.put(IconType.MENTHOR_ASSOCIATION, "net/menthor/editor/v2/ui/icon/uml/association.png");		
		urlMap.put(IconType.MENTHOR_COMPONENTOF, "net/menthor/editor/v2/ui/icon/uml/componentof.png");
		urlMap.put(IconType.MENTHOR_SUBCOLLECTIONOF, "net/menthor/editor/v2/ui/icon/uml/subcollectionof.png");
		urlMap.put(IconType.MENTHOR_SUBQUANTITYOF, "net/menthor/editor/v2/ui/icon/uml/subquantityof.png");
		urlMap.put(IconType.MENTHOR_MEMBEROF, "net/menthor/editor/v2/ui/icon/uml/memberof.png");						
				
		//app
		urlMap.put(IconType.MENTHOR_CONSTRAINTDOC, "net/menthor/editor/v2/ui/icon/constraintdoc.png");
		urlMap.put(IconType.MENTHOR_APP_ICON, "net/menthor/editor/v2/ui/icon/appmenthor.png");
		urlMap.put(IconType.MENTHOR_DIAGRAM, "net/menthor/editor/v2/ui/icon/diagram.png");
		urlMap.put(IconType.MENTHOR_PATTERN, "net/menthor/editor/v2/ui/icon/pattern.png");
		urlMap.put(IconType.MENTHOR_MOUSE_POINTER, "net/menthor/editor/v2/ui/icon/mousepointer.png");;
		urlMap.put(IconType.MENTHOR_UP, "net/menthor/editor/v2/ui/icon/arrowup.png");
		urlMap.put(IconType.MENTHOR_DOWN, "net/menthor/editor/v2/ui/icon/arrowdown.png");
		urlMap.put(IconType.MENTHOR_SEMANTIC_WEB, "net/menthor/editor/v2/ui/icon/semanticweb.png");
		urlMap.put(IconType.MENTHOR_COLOR_CHOOSER, "net/menthor/editor/v2/ui/icon/colorchooser.png");
		urlMap.put(IconType.MENTHOR_TREE, "net/menthor/editor/v2/ui/icon/browser.png");		
		urlMap.put(IconType.MENTHOR_DOC, "net/menthor/editor/v2/ui/icon/document.png");
		urlMap.put(IconType.MENTHOR_FOLDER, "net/menthor/editor/v2/ui/icon/folder.png");
		urlMap.put(IconType.MENTHOR_SAVE, "net/menthor/editor/v2/ui/icon/save.png");
		urlMap.put(IconType.MENTHOR_STATS, "net/menthor/editor/v2/ui/icon/statistics.png");
		urlMap.put(IconType.MENTHOR_HAND_CURSOR, "net/menthor/editor/v2/ui/icon/handcursor.png");		
		urlMap.put(IconType.MENTHOR_ZOOM_IN, "net/menthor/editor/v2/ui/icon/zoomin.png");
		urlMap.put(IconType.MENTHOR_ZOOM_OUT, "net/menthor/editor/v2/ui/icon/zoomout.png");		
		urlMap.put(IconType.MENTHOR_DELETE, "net/menthor/editor/v2/ui/icon/delete.png");
		urlMap.put(IconType.MENTHOR_ADD_GREEN, "net/menthor/editor/v2/ui/icon/addbox.png");
		urlMap.put(IconType.MENTHOR_ADD, "net/menthor/editor/v2/ui/icon/add.png");
		urlMap.put(IconType.MENTHOR_EDIT, "net/menthor/editor/v2/ui/icon/edit.png");
		urlMap.put(IconType.MENTHOR_ERASE, "net/menthor/editor/v2/ui/icon/erase.png");
		urlMap.put(IconType.MENTHOR_SETTINGS, "net/menthor/editor/v2/ui/icon/settings.png");
		urlMap.put(IconType.MENTHOR_EXPORT, "net/menthor/editor/v2/ui/icon/export.png");
		urlMap.put(IconType.MENTHOR_IMPORT, "net/menthor/editor/v2/ui/icon/import.png");	
		urlMap.put(IconType.MENTHOR_REDO, "net/menthor/editor/v2/ui/icon/redo.png");
		urlMap.put(IconType.MENTHOR_UNDO, "net/menthor/editor/v2/ui/icon/undo.png");
		urlMap.put(IconType.MENTHOR_SEARCH, "net/menthor/editor/v2/ui/icon/search.png");
		urlMap.put(IconType.MENTHOR_WARNING, "net/menthor/editor/v2/ui/icon/warning.png");
		urlMap.put(IconType.MENTHOR_ERROR, "net/menthor/editor/v2/ui/icon/error.png");		
		urlMap.put(IconType.MENTHOR_GRID, "net/menthor/editor/v2/ui/icon/grid.png");
		urlMap.put(IconType.MENTHOR_CHECK, "net/menthor/editor/v2/ui/icon/check.png");
		urlMap.put(IconType.MENTHOR_RECTILINEAR, "net/menthor/editor/v2/ui/icon/rectilinear.png");
		urlMap.put(IconType.MENTHOR_DIRECT, "net/menthor/editor/v2/ui/icon/direct.png");
		urlMap.put(IconType.MENTHOR_TO_BACK, "net/menthor/editor/v2/ui/icon/toback.png");
		urlMap.put(IconType.MENTHOR_TO_FRONT, "net/menthor/editor/v2/ui/icon/tofront.png");
		urlMap.put(IconType.MENTHOR_PLAY, "net/menthor/editor/v2/ui/icon/play.png");
		urlMap.put(IconType.MENTHOR_CLOSED, "net/menthor/editor/v2/ui/icon/closed.png");
		urlMap.put(IconType.MENTHOR_OPEN, "net/menthor/editor/v2/ui/icon/open.png");		
		urlMap.put(IconType.MENTHOR_FIT, "net/menthor/editor/v2/ui/icon/fit.png");		
		urlMap.put(IconType.MENTHOR_ALIGN_LEFT, "net/menthor/editor/v2/ui/icon/left.png");
		urlMap.put(IconType.MENTHOR_ALIGN_RIGHT, "net/menthor/editor/v2/ui/icon/right.png");
		urlMap.put(IconType.MENTHOR_ALIGN_BOTTOM, "net/menthor/editor/v2/ui/icon/bottom.png");
		urlMap.put(IconType.MENTHOR_ALIGN_TOP, "net/menthor/editor/v2/ui/icon/top.png");
		urlMap.put(IconType.MENTHOR_ALIGN_HORIZONTAL, "net/menthor/editor/v2/ui/icon/horizontal.png");
		urlMap.put(IconType.MENTHOR_ALIGN_VERTICAL, "net/menthor/editor/v2/ui/icon/vertical.png");
		urlMap.put(IconType.MENTHOR_HELP, "net/menthor/editor/v2/ui/icon/help.png");
		urlMap.put(IconType.MENTHOR_HELPROLLOVER, "net/menthor/editor/v2/ui/icon/helprollover.png");
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
