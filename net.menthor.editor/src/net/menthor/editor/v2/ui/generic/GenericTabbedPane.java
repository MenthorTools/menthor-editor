package net.menthor.editor.v2.ui.generic;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.eclipse.emf.edit.provider.IDisposable;

import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.ui.icon.IconMap;
import net.menthor.editor.v2.ui.icon.IconType;
import net.menthor.editor.v2.ui.util.ClosableTab;

public abstract class GenericTabbedPane extends JTabbedPane  implements IDisposable {

	private static final long serialVersionUID = -6379810578124259281L;

	private List<ICommandListener> listeners = new ArrayList<ICommandListener>();
	public void addCommandListener(ICommandListener l) { listeners.add(l); }
	public List<ICommandListener> getListeners(){ return listeners; }
	public ICommandListener getListener(){ if (listeners.size()>0) return listeners.get(0); else return null; }
	
	public void executeCommand(String command){
		for (ICommandListener l : listeners) {
			l.handleCommand(command);
		}
	}
	
	public GenericTabbedPane(ICommandListener listener){
		addCommandListener(listener);
		setBorder(new EmptyBorder(0,0,0,0));		
		setBackground(Color.white);
		setMinimumSize(new Dimension(0,0));
		setTabPlacement(JTabbedPane.TOP);
	}
	
	@Override
	public void dispose() {
		int totalTabs = getTabCount();
		for(int i = 0; i < totalTabs; i++) {
			IDisposable disposable = (IDisposable) getComponentAt(i);
			if(disposable != null) disposable.dispose();			
		}
	}	
	
	public Component addClosableTab(String text, IconType icontype, Component component){
		if (component==null) component = new JPanel();
		addTab(text, component);		
		ClosableTab tab = null; Icon icon = null;		
		tab = new ClosableTab(this, getListener());
		icon = IconMap.getInstance().getIcon(icontype);
		if(tab!=null){
			tab.getLabel().setIcon(icon);
			tab.getLabel().setIconTextGap(5);
			tab.getLabel().setHorizontalTextPosition(SwingConstants.RIGHT);
			setTabComponentAt(indexOfComponent(component),tab);
			setSelectedComponent(component);
		}
		return component;
	}
	
	public Component addNonClosableTab(String text, IconType incontype, Component component){
		if (component==null) component = new JPanel();
		addTab(text, component);
		setIconAt(indexOfComponent(component), IconMap.getInstance().getIcon(incontype));
		setSelectedComponent(component);
		return component;
	}
	
	public void closeAll(){
		 int tabCount = getTabCount();         
        for (int i = 1; i < tabCount; i++) {
            closeThis(1);
        }
	}
	
	public void closeThis(int i){		
		if (i != -1) {
			IDisposable disposable = (IDisposable) getComponentAt(i);
			if(disposable != null) disposable.dispose();			
			remove(i);
		}
	}
	
	public void closeOthers(Component component)	{	
		int selectedTabIndex = indexOfComponent(component);		
		 // First remove higher indexes 
       int tabCount = getTabCount();         
       if (selectedTabIndex < tabCount - 1) {
           for (int i = selectedTabIndex + 1; i < tabCount; i++) {
               closeThis(selectedTabIndex + 1);
           }
       }         
       if (selectedTabIndex > 0) {
           for (int i = 1; i < selectedTabIndex; i++) {
               closeThis(1);
           }
       }
	}
}
