package net.menthor.editor.v2.toolbar;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconMap;
import net.menthor.editor.v2.icon.IconType;

public class BaseToolBarButton extends JButton {

	private static final long serialVersionUID = -3652181421191143651L;
	boolean useSelectionAsContext = false;
	
	/** create toolbar button */
	public BaseToolBarButton (String name, Icon icon, CommandType command, BaseToolBar baseToolBar){		
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
	
	public BaseToolBarButton (String name, Icon icon, CommandType command, Color background, BaseToolBar baseToolBar){
		this(name, icon, command, baseToolBar);
		setBackground(background);
	}
	
	public BaseToolBarButton (String name, IconType icontype, CommandType command, Color background, BaseToolBar baseToolBar){
		this(name, icontype, command, baseToolBar);
		setBackground(background);
	}
	
	public BaseToolBarButton (String name, IconType icontype, CommandType command, BaseToolBar baseToolBar){
		this(name,IconMap.getInstance().getIcon(icontype),command, baseToolBar);
	}	
	
	public BaseToolBarButton (IconType icontype, CommandType command, Color background, BaseToolBar baseToolBar){
		this(icontype, command, baseToolBar);
		setBackground(background);
	}
	
	public BaseToolBarButton (IconType icontype, CommandType command, Color background, boolean useSelectionAsContext, BaseToolBar baseToolBar){
		this(icontype, command, background, baseToolBar);
		this.useSelectionAsContext = useSelectionAsContext;
	}
	
	public BaseToolBarButton (IconType icontype, CommandType command, BaseToolBar baseToolBar){
		this(null,icontype, command, baseToolBar);
	}
	

}
