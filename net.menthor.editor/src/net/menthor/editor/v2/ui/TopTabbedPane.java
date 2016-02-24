package net.menthor.editor.v2.ui;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.ui.generic.GenericTabbedPane;

public class TopTabbedPane extends GenericTabbedPane {

	private static final long serialVersionUID = 5019191384767258996L;
	
	// -------- Lazy Initialization

	private static class GUIEditorsPaneLoader {
        private static final TopTabbedPane INSTANCE = new TopTabbedPane();
    }	
	public static TopTabbedPane get() { 
		return GUIEditorsPaneLoader.INSTANCE; 
	}	
    private TopTabbedPane() {
    	super(CommandListener.get());
        if (GUIEditorsPaneLoader.INSTANCE != null) throw new IllegalStateException(this.getClass().getName()+" already instantiated");
    }	
    
    public void initialState(){
    	removeAll();		
		repaint();
		revalidate();
    }
}