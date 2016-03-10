package net.menthor.editor.v2.ui.controller;

import org.tinyuml.ui.diagram.OntoumlEditor;

import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.ui.MenuBarUI;

public class MenuBarUIController {

	MenuBarUI menubar = MenuBarUI.get();
	
	// -------- Lazy Initialization

	private static class MenuBarLoader {
        private static final MenuBarUIController INSTANCE = new MenuBarUIController();
    }	
	public static MenuBarUIController get() { 
		return MenuBarLoader.INSTANCE; 
	}	
    private MenuBarUIController() {
        if (MenuBarLoader.INSTANCE != null) throw new IllegalStateException(this.getClass().getName()+" already instantiated");
    }		
    
    // ----------------------------

    public void initializeShowGrid(){
		OntoumlEditor editor = TabbedAreaUIController.get().getSelectedTopOntoumlEditor();
		if(editor!=null){
			menubar.getMenuItem(CommandType.SHOW_GRID).setSelected(editor.isShownGrid());
		}		
	}
}
