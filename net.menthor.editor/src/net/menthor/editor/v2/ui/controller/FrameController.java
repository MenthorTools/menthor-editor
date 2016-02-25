package net.menthor.editor.v2.ui.controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JRootPane;

import net.menthor.editor.v2.ui.Frame;

public class FrameController {

	Frame frame = Frame.get();
	
	// -------- Lazy Initialization

	private static class FrameLoader {
        private static final FrameController INSTANCE = new FrameController();
    }	
	public static FrameController get() { 
		return FrameLoader.INSTANCE; 
	}	
    private FrameController() {
    	registerQuit();
        if (FrameLoader.INSTANCE != null) throw new IllegalStateException(this.getClass().getName()+" already instantiated");
    }		
    
    // ----------------------------

    public void initializeFrame(File projectFile){
		initializeFrame(projectFile,true);
	}
	
	public void initializeFrame(File projectFile, boolean forceDefaultUI){
		JRootPane root = frame.getRootPane( );
		root.putClientProperty("Window.documentFile", projectFile);
		frame.setTitle(projectFile.getName().replace(".menthor","")+" - Menthor Editor");
		if(forceDefaultUI){
			SplitPaneController.get().forceDefaultState();
		}
	}
	
    public void resetFrame(){    	
    	frame.setTitle("Menthor Editor");		
    	SplitPaneController.get().forceInitialState();	
    }
    
    private void registerQuit(){
    	frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					quitApplication();
				} catch (IOException e1) { e1.printStackTrace(); }				
			}
		});
    }
    
    public boolean quitApplication()throws IOException {    	
		if (canQuit()) {					
			//editorsPane().dispose();
			frame.dispose();
			Thread.currentThread().interrupt();			
			System.gc();
			Runtime.getRuntime().exit(0);
			return true;
		}else{
			return false;
		}    	
    }
    
    private boolean canQuit() throws IOException {				
		int response = JOptionPane.showOptionDialog(
			frame, "Do you really want to quit?", "Quit application?", 
			JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
			new String[]{"Save and Exit", "Exit without saving", "Cancel"},
			"default"
		);		
		if(response==JOptionPane.YES_OPTION){			
			ProjectController.get().saveProject();
			return true;
		}
		if(response==JOptionPane.NO_OPTION){
			return true;
		}
		if(response==JOptionPane.CANCEL_OPTION){
			return false;
		}
		return true;
	}
	
}
