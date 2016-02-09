package net.menthor.editor.v2.managers;

import net.menthor.editor.v2.ui.antipattern.AntiPatternSearchDialog;

public class AntiPatternManager extends BaseManager {

	// -------- Lazy Initialization

	private static class AntiPatternLoader {
        private static final AntiPatternManager INSTANCE = new AntiPatternManager();
    }	
	public static AntiPatternManager get() { 
		return AntiPatternLoader.INSTANCE; 
	}	
    private AntiPatternManager() {
        if (AntiPatternLoader.INSTANCE != null) throw new IllegalStateException("AntiPatternManager already instantiated");
    }		
    
    // ----------------------------
	
	public void detectAntiPatterns(){					
		AntiPatternSearchDialog.open(frame(), ProjectManager.get().getProject().getRefParser());		
	}	
	
	
}
