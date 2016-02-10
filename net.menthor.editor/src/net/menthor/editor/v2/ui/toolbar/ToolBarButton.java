package net.menthor.editor.v2.ui.toolbar;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.ui.generic.GenericToolBar;
import net.menthor.editor.v2.ui.icon.IconMap;
import net.menthor.editor.v2.ui.icon.IconType;

public class ToolBarButton extends JButton {

	private static final long serialVersionUID = -3652181421191143651L;
	boolean useSelectionAsContext = false;
	
	/** create toolbar button */
	public ToolBarButton (String name, Icon icon, CommandType command, GenericToolBar baseToolBar){		
		super(icon);
		
		if(name!=null) this.setText(name);
		setVerticalTextPosition(SwingConstants.BOTTOM);
	    setHorizontalTextPosition(SwingConstants.CENTER);
		
		setMargin(new Insets(1, 1, 1, 1));		
		setBorderPainted(false);
	    setFocusable(false);
		setToolTipText(command.getDescription());
		
		setActionCommand(command.toString());
		
		baseToolBar.jbuttonMap.put(command, this);
		addActionListener(baseToolBar);
		baseToolBar.add(this);
	}
	
	public ToolBarButton (String name, Icon icon, CommandType command, Color background, GenericToolBar baseToolBar){
		this(name, icon, command, baseToolBar);
		setBackground(background);
	}
	
	public ToolBarButton (String name, IconType icontype, CommandType command, Color background, GenericToolBar baseToolBar){
		this(name, icontype, command, baseToolBar);
		setBackground(background);
	}
	
	public ToolBarButton (String name, IconType icontype, CommandType command, GenericToolBar baseToolBar){
		this(name,IconMap.getInstance().getIcon(icontype),command, baseToolBar);
	}	
	
	public ToolBarButton (IconType icontype, CommandType command, Color background, GenericToolBar baseToolBar){
		this(icontype, command, baseToolBar);
		setBackground(background);
	}
	
	public ToolBarButton (IconType icontype, CommandType command, Color background, boolean useSelectionAsContext, GenericToolBar baseToolBar){
		this(icontype, command, background, baseToolBar);
		this.useSelectionAsContext = useSelectionAsContext;
	}
	
	public ToolBarButton (IconType icontype, CommandType command, GenericToolBar baseToolBar){
		this(null,icontype, command, baseToolBar);
	}
	

}
