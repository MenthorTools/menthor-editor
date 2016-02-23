package net.menthor.editor.v2.ui.controller;

import org.tinyuml.ui.diagram.OntoumlEditor;

import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.ui.MenuBar;

public class MenuBarController {

	MenuBar menubar = MenuBar.get();
	
	// -------- Lazy Initialization

	private static class MenuBarLoader {
        private static final MenuBarController INSTANCE = new MenuBarController();
    }	
	public static MenuBarController get() { 
		return MenuBarLoader.INSTANCE; 
	}	
    private MenuBarController() {
        if (MenuBarLoader.INSTANCE != null) throw new IllegalStateException(this.getClass().getName()+" already instantiated");
    }		
    
    // ----------------------------

    public void initializeShowGrid(){
		OntoumlEditor editor = TabbedAreaController.get().selectedTopOntoumlEditor();
		if(editor!=null){
			menubar.getMenuItem(CommandType.SHOW_GRID).setSelected(editor.isShownGrid());
		}		
	}
}
