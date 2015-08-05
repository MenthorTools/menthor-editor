package net.menthor.editor.v2.icon;

/*
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
		urlMap.put(IconType.MENTHOR_DOC, "net/menthor/editor/v2/icon/novos_icones-01.png");
		urlMap.put(IconType.MENTHOR_FOLDER, "net/menthor/editor/v2/icon/novos_icones-02.png");
		urlMap.put(IconType.MENTHOR_SAVE, "net/menthor/editor/v2/icon/novos_icones-03.png");
		urlMap.put(IconType.MENTHOR_STATS, "net/menthor/editor/v2/icon/novos_icones-04.png");
		urlMap.put(IconType.MENTHOR_DELETE, "net/menthor/editor/v2/icon/novos_icones-05.png");
		urlMap.put(IconType.MENTHOR_ADD_GREEN, "net/menthor/editor/v2/icon/novos_icones-06.png");//???????????
		urlMap.put(IconType.MENTHOR_ADD, "net/menthor/editor/v2/icon/novos_icones-07.png");
		urlMap.put(IconType.MENTHOR_EDIT, "net/menthor/editor/v2/icon/novos_icones-08.png");
		urlMap.put(IconType.MENTHOR_ERASE, "net/menthor/editor/v2/icon/novos_icones-09.png");
		urlMap.put(IconType.MENTHOR_SETTINGS, "net/menthor/editor/v2/icon/novos_icones-10.png");
		urlMap.put(IconType.MENTHOR_EXPORT, "net/menthor/editor/v2/icon/novos_icones-11.png");
		urlMap.put(IconType.MENTHOR_IMPORT, "net/menthor/editor/v2/icon/novos_icones-12.png");
		urlMap.put(IconType.MENTHOR_ZOOM_EXPORT, "net/menthor/editor/v2/icon/novos_icones-13.png"); //????????
		urlMap.put(IconType.MENTHOR_ZOOM_IN, "net/menthor/editor/v2/icon/novos_icones-14.png");
		urlMap.put(IconType.MENTHOR_ZOOM_OUT, "net/menthor/editor/v2/icon/novos_icones-15.png");
		urlMap.put(IconType.MENTHOR_REDO, "net/menthor/editor/v2/icon/novos_icones-16.png");
		urlMap.put(IconType.MENTHOR_UNDO, "net/menthor/editor/v2/icon/novos_icones-17.png");
		urlMap.put(IconType.MENTHOR_SEARCH, "net/menthor/editor/v2/icon/novos_icones-18.png");
		urlMap.put(IconType.MENTHOR_WARNING, "net/menthor/editor/v2/icon/novos_icones-19.png");
		urlMap.put(IconType.MENTHOR_ERROR, "net/menthor/editor/v2/icon/novos_icones-20.png");
		urlMap.put(IconType.MENTHOR_GRID, "net/menthor/editor/v2/icon/novos_icones-21.png");
		urlMap.put(IconType.MENTHOR_CHECK, "net/menthor/editor/v2/icon/novos_icones-22.png");
		urlMap.put(IconType.MENTHOR_RECTILINEAR, "net/menthor/editor/v2/icon/novos_icones-23.png");
		urlMap.put(IconType.MENTHOR_DIRECT, "net/menthor/editor/v2/icon/novos_icones-24.png");
		urlMap.put(IconType.MENTHOR_TO_BACK, "net/menthor/editor/v2/icon/novos_icones-25.png");
		urlMap.put(IconType.MENTHOR_TO_FRONT, "net/menthor/editor/v2/icon/novos_icones-26.png");
		urlMap.put(IconType.MENTHOR_PLAY, "net/menthor/editor/v2/icon/novos_icones-27.png");
		urlMap.put(IconType.MENTHOR_CLOSED, "net/menthor/editor/v2/icon/novos_icones-28.png");
		urlMap.put(IconType.MENTHOR_OPEN, "net/menthor/editor/v2/icon/novos_icones-29.png");
		urlMap.put(IconType.MENTHOR_EDIT_ROUND, "net/menthor/editor/v2/icon/novos_icones-30.png");//???????????
		urlMap.put(IconType.MENTHOR_FIT, "net/menthor/editor/v2/icon/novos_icones-31.png");
		urlMap.put(IconType.MENTHOR_PATTERN, "net/menthor/editor/v2/icon/novos_icones-32.png");//?????????????
		urlMap.put(IconType.MENTHOR_PICKER, "net/menthor/editor/v2/icon/novos_icones-33.png");
		urlMap.put(IconType.MENTHOR_COLOR_CHOOSER, "net/menthor/editor/v2/icon/novos_icones-34.png");
		urlMap.put(IconType.MENTHOR_ALIGN_LEFT, "net/menthor/editor/v2/icon/novos_icones-35.png");
		urlMap.put(IconType.MENTHOR_ALIGN_RIGHT, "net/menthor/editor/v2/icon/novos_icones-36.png");
		urlMap.put(IconType.MENTHOR_ALIGN_BOTTOM, "net/menthor/editor/v2/icon/novos_icones-37.png");
		urlMap.put(IconType.MENTHOR_ALIGN_TOP, "net/menthor/editor/v2/icon/novos_icones-38.png");
		urlMap.put(IconType.MENTHOR_ALIGN_HORIZONTAL, "net/menthor/editor/v2/icon/novos_icones-39.png");
		urlMap.put(IconType.MENTHOR_ALIGN_VERTICAL, "net/menthor/editor/v2/icon/novos_icones-40.png");
		urlMap.put(IconType.MENTHOR_DIAGRAM_TAB, "net/menthor/editor/v2/icon/novos_icones-41.png");
		urlMap.put(IconType.MENTHOR_ADD_TAB, "net/menthor/editor/v2/icon/novos_icones-42.png");
		urlMap.put(IconType.MENTHOR_ADD_FOLDER, "net/menthor/editor/v2/icon/novos_icones-43.png");
		urlMap.put(IconType.MENTHOR_TREE, "net/menthor/editor/v2/icon/novos_icones-44.png");
		urlMap.put(IconType.MENTHOR_GEN_SET, "net/menthor/editor/v2/icon/novos_icones-45.png");
		urlMap.put(IconType.MENTHOR_DOWNLOAD, "net/menthor/editor/v2/icon/novos_icones-46.png");
		urlMap.put(IconType.MENTHOR_UPLOAD, "net/menthor/editor/v2/icon/novos_icones-47.png");
		urlMap.put(IconType.MENTHOR_LINE, "net/menthor/editor/v2/icon/novos_icones-48.png");
		urlMap.put(IconType.MENTHOR_LINE2, "net/menthor/editor/v2/icon/novos_icones-49.png");
		urlMap.put(IconType.MENTHOR_GEN_BLACK, "net/menthor/editor/v2/icon/novos_icones-50.png");		
		urlMap.put(IconType.MENTHOR_COMMENT, "net/menthor/editor/v2/icon/novos_icones-51.png");
		urlMap.put(IconType.MENTHOR_PARTHOOD_BLACK, "net/menthor/editor/v2/icon/novos_icones-52.png");
		urlMap.put(IconType.MENTHOR_DERIVATION, "net/menthor/editor/v2/icon/novos_icones-53.png");
		urlMap.put(IconType.MENTHOR_GRAPH, "net/menthor/editor/v2/icon/novos_icones-54.png");
		urlMap.put(IconType.MENTHOR_GEN_WHITE, "net/menthor/editor/v2/icon/novos_icones-55.png");
		urlMap.put(IconType.MENTHOR_PARTHOOD_M, "net/menthor/editor/v2/icon/novos_icones-56.png");
		urlMap.put(IconType.MENTHOR_DASHED_LINE, "net/menthor/editor/v2/icon/novos_icones-57.png");
		urlMap.put(IconType.MENTHOR_NOTE, "net/menthor/editor/v2/icon/novos_icones-58.png");
		urlMap.put(IconType.MENTHOR_DOC_OCL, "net/menthor/editor/v2/icon/novos_icones-59.png");
		urlMap.put(IconType.MENTHOR_RED_BOX, "net/menthor/editor/v2/icon/novos_icones-60.png");//?????????????
		urlMap.put(IconType.MENTHOR_PARTHOOD_C, "net/menthor/editor/v2/icon/novos_icones-61.png");
		urlMap.put(IconType.MENTHOR_PARTHOOD_Q, "net/menthor/editor/v2/icon/novos_icones-62.png");
		urlMap.put(IconType.MENTHOR_BLACK_BOXES, "net/menthor/editor/v2/icon/novos_icones-63.png");//????????????
		urlMap.put(IconType.MENTHOR_CLASS, "net/menthor/editor/v2/icon/novos_icones-64.png");
		urlMap.put(IconType.MENTHOR_PARTHOOD_E, "net/menthor/editor/v2/icon/novos_icones-65.png");
		urlMap.put(IconType.MENTHOR_DIAGRAM, "net/menthor/editor/v2/icon/novos_icones-66.png");
		urlMap.put(IconType.MENTHOR_W3C, "net/menthor/editor/v2/icon/novos_icones-67.png");
		urlMap.put(IconType.MENTHOR_SEMANTIC_WEB, "net/menthor/editor/v2/icon/novos_icones-68.png");
		urlMap.put(IconType.MENTHOR_UML, "net/menthor/editor/v2/icon/novos_icones-69.png");
		urlMap.put(IconType.MENTHOR_MOUSE_POINTER, "net/menthor/editor/v2/icon/novos_icones-70.png");		
		urlMap.put(IconType.MENTHOR_WELCOME_SLOGAN, "net/menthor/editor/v2/icon/slogan.png");		
		urlMap.put(IconType.MENTHOR_WELCOME_LOGO, "net/menthor/editor/v2/icon/logo.png");
		urlMap.put(IconType.MENTHOR_WELCOME_BACKGROUND, "net/menthor/editor/v2/icon/mountain.png");
		urlMap.put(IconType.MENTHOR_WELCOME_LEARN,"net/menthor/editor/v2/icon/learning.png");
		urlMap.put(IconType.MENTHOR_WELCOME_FAQ,"net/menthor/editor/v2/icon/faq.png");
		urlMap.put(IconType.MENTHOR_WELCOME_FORUM,"net/menthor/editor/v2/icon/forum.png");
		urlMap.put(IconType.MENTHOR_WELCOME_STUDYGUIDE,"net/menthor/editor/v2/icon/studyguide.png");
		
		//OLED
		urlMap.put(IconType.MOUSE_POINTER, "resources/icons/x16/mousepointer.png");		
		urlMap.put(IconType.CLASS, "resources/icons/x16/tree/class.png");
		urlMap.put(IconType.PATTERN, "resources/icons/x16/sitemap.png");
		urlMap.put(IconType.ASSOCIATION, "resources/icons/x16/tree/association.png");
		urlMap.put(IconType.ASSOCIATION_ARROW, "resources/icons/x16/tree/association-arrow.png");		
		urlMap.put(IconType.AGGREGATION, "resources/icons/x16/tree/componentof.png");
		urlMap.put(IconType.AGGREGATION_C, "resources/icons/x16/tree/subcollectionof.png");
		urlMap.put(IconType.AGGREGATION_M, "resources/icons/x16/tree/memberof.png");
		urlMap.put(IconType.AGGREGATION_Q, "resources/icons/x16/tree/subquantityof.png");
		urlMap.put(IconType.ANNOTATION, "resources/icons/x16/tree/annotation.png");				
		urlMap.put(IconType.INHERITANCE, "resources/icons/x16/tree/generalization.png");
		urlMap.put(IconType.DERIVATION, "resources/icons/x16/tree/derivation.png");		
		urlMap.put(IconType.RULE, "resources/icons/x16/tree/rule.png");
		urlMap.put(IconType.NOTE, "resources/icons/x16/tree/note.png");
		urlMap.put(IconType.NOTE_CONNECTOR, "resources/icons/x16/tree/note-connector.png");		
		urlMap.put(IconType.FIND, "resources/icons/x16/find.png");
		urlMap.put(IconType.STATISTICS, "resources/icons/x16/diagnostic.png");		
		urlMap.put(IconType.OUTPUT, "resources/icons/x16/monitor.png");
		urlMap.put(IconType.ERROR, "resources/icons/x16/cross_octagon.png");
		urlMap.put(IconType.WARNING, "resources/icons/x16/exclamation_octagon_fram.png");
		urlMap.put(IconType.OCLEDITOR, "resources/icons/x16/text-editor.png");				
		urlMap.put(IconType.VERIFY, "resources/icons/x16/spellcheck.png");
		urlMap.put(IconType.PARSE, "resources/icons/x16/accept.png");
		urlMap.put(IconType.WINDOW, "resources/icons/menthor-32x32.png");
		urlMap.put(IconType.MENTHOR, "resources/icons/menthor-16x16.png");
		urlMap.put(IconType.NEMO, "resources/icons/window16.png");
		urlMap.put(IconType.PALETTE_OPEN, "net/menthor/resources/images/palette-open.png");
		urlMap.put(IconType.PALETTE_CLOSED, "net/menthor/resources/images/palette-closed.png");		
		urlMap.put(IconType.EA, "resources/icons/x16/ea.jpg");		
		urlMap.put(IconType.UML, "resources/icons/x16/eclipse.gif");
		urlMap.put(IconType.RECTILINEAR, "resources/icons/x16/rectilinear.png");
		urlMap.put(IconType.STRAIGHT, "resources/icons/x16/straight.png");				
		urlMap.put(IconType.ANTIPATTERN, "resources/icons/antipattern16.png");
		urlMap.put(IconType.PART_WHOLE_VALIDATION, "resources/icons/x16/wall_break.png");		
		urlMap.put(IconType.GENERATE_ALLOY, "resources/icons/x16/alloy/alloy.png");				
		urlMap.put(IconType.GENERATE_OWL, "resources/icons/x16/sw-cube.png");
		urlMap.put(IconType.GENERATE_OWL_SETTINGS, "resources/icons/x16/sw-cube.png");		
		urlMap.put(IconType.GENERATE_SBVR, "resources/icons/x16/world.png");		
		urlMap.put(IconType.GENERATE_TEXT, "resources/icons/x16/glossary.png");	
		urlMap.put(IconType.NEW, "resources/icons/x16/page_2.png");
		urlMap.put(IconType.OPEN, "resources/icons/x16/folder.png");
		urlMap.put(IconType.SAVE, "resources/icons/x16/disk.png");
		urlMap.put(IconType.CUT, "resources/icons/x16/cut.png");
		urlMap.put(IconType.COPY, "resources/icons/x16/page_2_copy.png");
		urlMap.put(IconType.PASTE, "resources/icons/x16/page_paste.png");		
		urlMap.put(IconType.DELETE, "resources/icons/x16/cross.png");
		urlMap.put(IconType.EXCLUDE, "resources/icons/x16/bin_closed.png");		
		urlMap.put(IconType.UNDO, "resources/icons/x16/arrow_undo.png");
		urlMap.put(IconType.REDO, "resources/icons/x16/arrow_redo.png");		
		urlMap.put(IconType.ABOUT, "resources/icons/x16/exclamation.png");
		urlMap.put(IconType.TOOLBOX, "resources/icons/x16/hammer_screwdriver.png");		
		urlMap.put(IconType.EXPORT, "resources/icons/x16/page_white_get.png");
		urlMap.put(IconType.IMPORT, "resources/icons/x16/page_white_put.png");		
		urlMap.put(IconType.PICTURE, "resources/icons/x16/image_1.png");
		urlMap.put(IconType.ARROW_UP, "resources/icons/x16/arrow_up.png");
		urlMap.put(IconType.ARROW_DOWN, "resources/icons/x16/arrow_down.png");
		urlMap.put(IconType.GREEN_LIGHT, "resources/icons/x16/greenlight.png");
		urlMap.put(IconType.RED_LIGHT, "resources/icons/x16/redlight.png");
		urlMap.put(IconType.GREY_LIGHT, "resources/icons/x16/greylight.png");		
		urlMap.put(IconType.BACKGROUND_WELCOME, "resources/icons/menthor-background.jpg");
		urlMap.put(IconType.HEAD_WELCOME, "resources/icons/menthor-header.jpg");				
		urlMap.put(IconType.ISSUE_REPORT, "resources/icons/x16/link.png");		
		urlMap.put(IconType.NEXT, "resources/icons/x16/next.png");		
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
	
	public Image getImage(String typeName) {
		try {
			IconType type = iconTypeMap.get(typeName);
			return new ImageIcon(getClass().getClassLoader().getResource(urlMap.get(type))).getImage();
		} catch (Exception e) {
			return null;
		}
	}
}
