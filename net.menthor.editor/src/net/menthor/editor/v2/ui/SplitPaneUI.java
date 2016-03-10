package net.menthor.editor.v2.ui;

import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.ui.generic.GenericMultiSplitPane;

public class SplitPaneUI extends GenericMultiSplitPane {

	private static final long serialVersionUID = -5413026364779814341L;

	private MenuBarUI appMenu;
	
	// -------- Lazy Initialization

	private static class GUISplitPaneLoader {
        private static final SplitPaneUI INSTANCE = new SplitPaneUI();
    }	
	public static SplitPaneUI get() { 
		return GUISplitPaneLoader.INSTANCE; 
	}	
    private SplitPaneUI() {
		super(PaletteUI.get(), TopTabbedPaneUI.get(), BottomTabbedPaneUI.get(), BrowserUI.get());
		this.appMenu = MenuBarUI.get();
        if (GUISplitPaneLoader.INSTANCE != null) throw new IllegalStateException(this.getClass().getName()+" already instantiated");
    }		
    
    // ----------------------------
		
	public boolean isShowPalette(){
		return isShowLeftPane();
	}
	
	public boolean isShowProjectBrowser(){
		return isShowRightPane();
	}
	
	public boolean isShowInfoTabbedPane(){
		return isShowBottomPane();
	}
	
	public void forceDefaultState(){
		forceShowProjectBrowser();
		forceShowPalette();
		appMenu.activateAll();
	}
	
	public void forceInitialState(){
		appMenu.disactivateSomeToBegin();
		appMenu.selectWindowMenu(false, false, false);
		forceShowOnlyTopPane();
	}
	
	public void forceShowProjectBrowser(){
		forceShowRightPane();		
		appMenu.select(CommandType.SHOW_PROJECT_BROWSER,true);
	}
	
	public void forceShowPalette(){
		forceShowLeftPane();
		appMenu.select(CommandType.SHOW_PALETTE,true);
	}
	
	public void forceShowInfoTabbedPane(){
		if(!isShowInfoTabbedPane()) { 
			appMenu.select(CommandType.SHOW_INFO_TABBED_PANE,true); 
		}
		showInfoTabbedPane();
	}
	
	public void showInfoTabbedPane(){		
		if(appMenu.isSelected(CommandType.SHOW_INFO_TABBED_PANE)){			
			showBottomPane();
			appMenu.select(CommandType.SHOW_INFO_TABBED_PANE,true);			
		}else{			
			hideBottomPane();
			appMenu.select(CommandType.SHOW_INFO_TABBED_PANE,false);			
		}		
	}
	
	public void showProjectBrowser(){		
		if(appMenu.isSelected(CommandType.SHOW_PROJECT_BROWSER)){
			showRightPane();			
			appMenu.select(CommandType.SHOW_PROJECT_BROWSER,true);
		}else{
			hideRightPane();
			appMenu.select(CommandType.SHOW_PROJECT_BROWSER,false);
		}		

	}
	
	public void showPalette() {		
		if(appMenu.isSelected(CommandType.SHOW_PALETTE)){
			showLeftPane();
			appMenu.select(CommandType.SHOW_PALETTE,true);
		}else{			
			hideLeftPane();
			appMenu.select(CommandType.SHOW_PALETTE,false);
		}		
	}
	
}
