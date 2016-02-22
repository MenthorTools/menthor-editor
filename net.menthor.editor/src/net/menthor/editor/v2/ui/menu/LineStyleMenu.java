package net.menthor.editor.v2.ui.menu;

import java.util.List;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;

import org.tinyuml.draw.Connection;
import org.tinyuml.draw.RectilinearConnection;
import org.tinyuml.draw.SimpleConnection;
import org.tinyuml.draw.TreeConnection;
import org.tinyuml.umldraw.shared.BaseConnection;
import org.tinyuml.umldraw.shared.UmlDiagramElement;

import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.commands.ICommandListener;

public class LineStyleMenu extends MultiElementMenu {

	private static final long serialVersionUID = 3797953970276009760L;
	protected JCheckBoxMenuItem directMenuItem;
	protected JCheckBoxMenuItem rectilinearMenuItem;
	protected JCheckBoxMenuItem treeHorizontalMenuItem;
	protected JCheckBoxMenuItem treeVerticalMenuItem;
	
	public LineStyleMenu(ICommandListener listener, String text, List<UmlDiagramElement> elements, JPopupMenu parent){
		super(listener, text, elements);		
		directMenuItem = createCheckBoxMenuItem("Direct", CommandType.APPLY_DIRECT_STYLE);
		rectilinearMenuItem = createCheckBoxMenuItem("Rectilinear", CommandType.APPLY_RECTILINEAR_STYLE);
		treeHorizontalMenuItem = createCheckBoxMenuItem("Tree Style Horizontal", CommandType.APPLY_HORIZONTAL_STYLE);
		treeVerticalMenuItem = createCheckBoxMenuItem("Tree Style Vertical", CommandType.APPLY_VERTICAL_STYLE);
		updateCheckboxState();
		parent.add(this);
	}
	
	private void updateCheckboxState() {		
		if(helper.isSingleContext() && context.get(0) instanceof BaseConnection){
			Connection connection = ((BaseConnection) context.get(0)).getConnection();			
			if(connection instanceof SimpleConnection)
				directMenuItem.setSelected(true);
			else if(connection instanceof TreeConnection){
				treeVerticalMenuItem.setSelected(((TreeConnection)connection).isVertical());
				treeHorizontalMenuItem.setSelected(((TreeConnection)connection).isHorizontal());
			}
			else if (connection instanceof RectilinearConnection){
				rectilinearMenuItem.setSelected(true);
			}
		}		
	}

	public LineStyleMenu(ICommandListener listener, List<UmlDiagramElement> elements, JPopupMenu parent){
		this(listener, "Line Style", elements, parent);		
  	}
	
	public LineStyleMenu(ICommandListener listener, String text, BaseConnection connection, JPopupMenu parent){
		this(listener, text, setUpList(connection), parent);	
	}
	
	public LineStyleMenu(ICommandListener listener, BaseConnection connection, JPopupMenu parent){
		this(listener, setUpList(connection), parent);		
  	}
	
}
