package net.menthor.editor;

import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import org.tinyuml.ui.commands.AppCommandListener;

import net.menthor.resources.icons.CommandType;
import net.menthor.resources.icons.IconLoader;
import net.menthor.resources.icons.IconLoader.IconType;

public class NewAppToolbar extends JToolBar implements ActionListener {

	private static final long serialVersionUID = 8870790907921523710L;
	
	private List<AppCommandListener> listeners = new ArrayList<AppCommandListener>();
	private Map<CommandType, JButton> jbuttonMap = new HashMap<CommandType, JButton>();		
	
	/** buttons */
	private JButton btnNewProject;	
	private JButton btnOpenProject;
	private JButton btnSaveProject;
	private JButton btnSearchTerm;
	private JButton btnStatistics;
	private JButton btnCheckSyntax;
	
	/** height and width of buttons*/
	private int btnHeight = 32;
	private int btnWidth = 32;

	/** handle commands */
	public void actionPerformed(ActionEvent e) {
		for (AppCommandListener l : listeners) {
			l.handleCommand(e.getActionCommand());
		}
	}
	
	public void addCommandListener(AppCommandListener l) { listeners.add(l); }
	
	public void enableButton(CommandType cmdType, boolean flag) {
		jbuttonMap.get(cmdType).setEnabled(flag);
	}	
	
	/** enable/disable all buttons */
	public void enableAll(boolean value){
		//btnNewProject.setEnabled(value);
		//btnOpenProject.setEnabled(value);
		btnSaveProject.setEnabled(value);
		btnSearchTerm.setEnabled(value);
		btnStatistics.setEnabled(value);
		btnCheckSyntax.setEnabled(value);
	}
	
	/** constructor */
	public NewAppToolbar(final AppFrame frame){
		//setBackground(Color.WHITE);
		btnNewProject = createButton(
			null, 
			IconLoader.getInstance().getIcon(IconType.MENTHOR_DOC),
			CommandType.NEW_PROJECT.toString(),
			"Create new menthor project"
		);
		btnOpenProject = createButton(
			null, 
			IconLoader.getInstance().getIcon(IconType.MENTHOR_FOLDER),
			CommandType.OPEN_PROJECT.toString(),
			"Open existing menthor project"
		);	
		btnSaveProject = createButton(
			null, 
			IconLoader.getInstance().getIcon(IconType.MENTHOR_SAVE),
			CommandType.SAVE_PROJECT.toString(),
			"Save current menthor project"
		);
		btnSearchTerm = createButton(
			null,
			IconLoader.getInstance().getIcon(IconType.MENTHOR_SEARCH),
			CommandType.SEARCH_TERM.toString(),
			"Search a term in current project"
		);		
		btnCheckSyntax = createButton(
			null,
			IconLoader.getInstance().getIcon(IconType.MENTHOR_CHECK),
			CommandType.CHECK_SYNTAX.toString(),
			"Check syntax of current project"
		);
		btnStatistics = createButton(
			null,
			IconLoader.getInstance().getIcon(IconType.MENTHOR_STATS),
			CommandType.COLLECT_STATISTICS.toString(),
			"Collect statistics of current project"
		);
		setFloatable(false);
		setMargin(new Insets(5, 15, 5, 5));		
		enableAll(false);
	}
	
	/** create toolbar button */
	private JButton createButton(String name, Icon icon, String command, String tooltip){
		Image img = ((ImageIcon)icon).getImage();  
		Image newimg = img.getScaledInstance(btnWidth, btnHeight, java.awt.Image.SCALE_SMOOTH);  
		Icon newIcon = new ImageIcon(newimg);
		JButton button = new JButton(newIcon);
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
	    button.setHorizontalTextPosition(SwingConstants.CENTER);
		if(name!=null) {
			button.setText(name);
		}
		button.setMargin(new Insets(1, 1, 1, 1));		
		button.setActionCommand(command);
		button.addActionListener(this);
		//button.setOpaque(false);
		//button.setContentAreaFilled(false);		
		button.setBorderPainted(false);
	    button.setFocusable(false);
		jbuttonMap.put(CommandType.valueOf(command), button);
		add(button);
		button.setToolTipText(tooltip);
		return button;
	}	
}
