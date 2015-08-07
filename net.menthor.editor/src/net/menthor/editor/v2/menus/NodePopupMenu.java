package net.menthor.editor.v2.menus;

import javax.swing.JCheckBoxMenuItem;

import org.tinyuml.umldraw.ClassElement;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;

public class NodePopupMenu extends BasePopupMenu {

	private static final long serialVersionUID = 6677159632748840951L;

	ChangeClassMenu changeMenu;
	BaseMenu color;
	BaseMenu visibility;
	JCheckBoxMenuItem attrItem;
	
	public NodePopupMenu(CommandListener listener) {
		super(listener);
		createMenuItem("Edit Properties", CommandType.EDIT);
		addSeparator();
		attrItem = createCheckBoxMenuItem("Show Attributes", CommandType.SHOW_ATTRIBUTES);
		addSeparator();
		createMenuItem("Find in Project Browser", CommandType.FIND_IN_PROJECT_BROWSER);
		createMenuItem("Add All Related Elements", CommandType.ADD_ALL_RELATED_ELEMENTS);
		addSeparator();
		color = new BaseMenu(listener,"Background Color");
		add(color);
		color.createMenuItem("Set", CommandType.SETUP_BACKGROUND_COLOR);
		color.createMenuItem("Copy", CommandType.COPY_BACKGROUND_COLOR);
		color.createMenuItem("Paste", CommandType.PASTE_BACKGROUND_COLOR);
		addSeparator();
		changeMenu = new ChangeClassMenu(listener);
		add(changeMenu);		
	}
	
	@Override
	public void setContext(Object object){
		if(object instanceof ClassElement){
			changeMenu.setContext(((ClassElement)object).getClassifier());
			attrItem.setSelected(((ClassElement)object).showAttributes());
		}
		color.setContext(object);
		super.setContext(object);
	}}
