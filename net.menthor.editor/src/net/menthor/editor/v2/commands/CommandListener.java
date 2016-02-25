package net.menthor.editor.v2.commands;

import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.ui.diagram.ScalingComponent;
import org.tinyuml.umldraw.OccurenceMap;

import net.menthor.editor.v2.commanders.AddCommander;
import net.menthor.editor.v2.commanders.AddToDiagramCommander;
import net.menthor.editor.v2.commanders.AlignCommander;
import net.menthor.editor.v2.commanders.ChangeCommander;
import net.menthor.editor.v2.commanders.ColorCommander;
import net.menthor.editor.v2.commanders.DeleteCommander;
import net.menthor.editor.v2.commanders.DuplicateCommander;
import net.menthor.editor.v2.commanders.LineCommander;
import net.menthor.editor.v2.commanders.RenameCommander;
import net.menthor.editor.v2.commanders.UpdateCommander;
import net.menthor.editor.v2.commanders.VisibilityCommander;
import net.menthor.editor.v2.feature.AlloyFeature;
import net.menthor.editor.v2.feature.OwlFeature;
import net.menthor.editor.v2.feature.ParthoodFeature;
import net.menthor.editor.v2.feature.SbvrFeature;
import net.menthor.editor.v2.managers.AntiPatternManager;
import net.menthor.editor.v2.managers.ErrorManager;
import net.menthor.editor.v2.managers.ExportManager;
import net.menthor.editor.v2.managers.FactoryManager;
import net.menthor.editor.v2.managers.FilterManager;
import net.menthor.editor.v2.managers.FindManager;
import net.menthor.editor.v2.managers.GlossaryManager;
import net.menthor.editor.v2.managers.HelpManager;
import net.menthor.editor.v2.managers.ImportManager;
import net.menthor.editor.v2.managers.RemakeManager;
import net.menthor.editor.v2.managers.StatisticsManager;
import net.menthor.editor.v2.managers.SyntaxManager;
import net.menthor.editor.v2.managers.TransferManager;
import net.menthor.editor.v2.managers.WarningManager;
import net.menthor.editor.v2.ui.controller.CursorController;
import net.menthor.editor.v2.ui.controller.EditDialogController;
import net.menthor.editor.v2.ui.controller.FrameController;
import net.menthor.editor.v2.ui.controller.MenuBarController;
import net.menthor.editor.v2.ui.controller.MessageController;
import net.menthor.editor.v2.ui.controller.ProjectController;
import net.menthor.editor.v2.ui.controller.SplitPaneController;
import net.menthor.editor.v2.ui.controller.TabbedAreaController;
import net.menthor.editor.v2.ui.editor.mode.ClipboardMode;
import net.menthor.editor.v2.ui.editor.mode.ConnectMode;
import net.menthor.editor.v2.ui.editor.mode.SelectMode;
import net.menthor.editor.v2.ui.operation.ActionStack;
import net.menthor.editor.v2.util.DeserializationUtil;
import net.menthor.editor.v2.util.SerializationUtil;

public class CommandListener extends AbstractCommandListener {

	// -------- Lazy Initialization

	private static class CommandListenerLoader {
        private static final CommandListener INSTANCE = new CommandListener();
    }	
	public static CommandListener get() { 
		return CommandListenerLoader.INSTANCE; 
	}	
    private CommandListener() {
        if (CommandListenerLoader.INSTANCE != null) throw new IllegalStateException("AppCommandListener already instantiated");
    }		
    
    // ----------------------------
	    
    public Object callManagers(MethodCall methodcall){	
		try{
			if(methodcall.getMethod().getDeclaringClass() == SplitPaneController.class){
				return methodcall.call(SplitPaneController.get());
			}else if(methodcall.getMethod().getDeclaringClass() == CursorController.class){
				return methodcall.call(CursorController.get());				
			}else if(methodcall.getMethod().getDeclaringClass() == MenuBarController.class){
				return methodcall.call(MenuBarController.get());
			}else if(methodcall.getMethod().getDeclaringClass() == MessageController.class){
				return methodcall.call(MessageController.get());
			}else if(methodcall.getMethod().getDeclaringClass() == TabbedAreaController.class){
				return methodcall.call(TabbedAreaController.get());	
			}else if(methodcall.getMethod().getDeclaringClass() == FrameController.class){
				return methodcall.call(FrameController.get());
			}		
		}catch(java.lang.IllegalArgumentException e){
			System.err.println("Method not called. Reason: "+e.getLocalizedMessage());
			System.err.println(methodcall);			
		}
		return null;
	}
    
    @Override
	public Object callMethod(MethodCall methodcall){
    	callManagers(methodcall);
		try{
			//----------------
			if(methodcall.getMethod().getDeclaringClass() == OntoumlEditor.class){
				return methodcall.call(TabbedAreaController.get().getSelectedTopOntoumlEditor());
			} else if(methodcall.getMethod().getDeclaringClass() == ScalingComponent.class){
				return methodcall.call(TabbedAreaController.get().getSelectedTopOntoumlEditor().getScalingComponent());
			//-----=----------
				
			//----------------				
			}else if(methodcall.getMethod().getDeclaringClass() == AddCommander.class){
				return methodcall.call(AddCommander.get());
			}else if(methodcall.getMethod().getDeclaringClass() == AlignCommander.class){
				return methodcall.call(AlignCommander.get());
			}else if(methodcall.getMethod().getDeclaringClass() == LineCommander.class){
				return methodcall.call(LineCommander.get());	
			}else if(methodcall.getMethod().getDeclaringClass() == AlloyFeature.class){
				return methodcall.call(AlloyFeature.get());
			}else if(methodcall.getMethod().getDeclaringClass() == AntiPatternManager.class){
				return methodcall.call(AntiPatternManager.get());				
			}else if(methodcall.getMethod().getDeclaringClass() == ChangeCommander.class){
				return methodcall.call(ChangeCommander.get());
			}else if(methodcall.getMethod().getDeclaringClass() == ClipboardMode.class){
				return methodcall.call(ClipboardMode.get());
			}else if(methodcall.getMethod().getDeclaringClass() == ConnectMode.class){
				return methodcall.call(ConnectMode.get());
			}else if(methodcall.getMethod().getDeclaringClass() == SelectMode.class){
				return methodcall.call(SelectMode.get());
			}else if(methodcall.getMethod().getDeclaringClass() == ColorCommander.class){
				return methodcall.call(ColorCommander.get());
			
			
				
			}else if(methodcall.getMethod().getDeclaringClass() == DeleteCommander.class){
				return methodcall.call(DeleteCommander.get());
			}else if(methodcall.getMethod().getDeclaringClass() == DeserializationUtil.class){
				return methodcall.call(DeserializationUtil.get());
			}else if(methodcall.getMethod().getDeclaringClass() == DuplicateCommander.class){
				return methodcall.call(DuplicateCommander.get());				
			}else if(methodcall.getMethod().getDeclaringClass() == EditDialogController.class){
				return methodcall.call(EditDialogController.get());
			}else if(methodcall.getMethod().getDeclaringClass() == ErrorManager.class){
				return methodcall.call(ErrorManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == ExportManager.class){
				return methodcall.call(ExportManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == FactoryManager.class){
				return methodcall.call(FactoryManager.get());				
			}else if(methodcall.getMethod().getDeclaringClass() == FilterManager.class){
				return methodcall.call(FilterManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == FindManager.class){
				return methodcall.call(FindManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == GlossaryManager.class){
				return methodcall.call(GlossaryManager.get());				
			}else if(methodcall.getMethod().getDeclaringClass() == HelpManager.class){
				return methodcall.call(HelpManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == ImportManager.class){
				return methodcall.call(ImportManager.get());
			
			}else if(methodcall.getMethod().getDeclaringClass() == VisibilityCommander.class){
				return methodcall.call(VisibilityCommander.get());	
			}else if(methodcall.getMethod().getDeclaringClass() == AddToDiagramCommander.class){
				return methodcall.call(AddToDiagramCommander.get());				
			}else if(methodcall.getMethod().getDeclaringClass() == OccurenceMap.class){
				return methodcall.call(OccurenceMap.get());
			}else if(methodcall.getMethod().getDeclaringClass() == OwlFeature.class){
				return methodcall.call(OwlFeature.get());
			}else if(methodcall.getMethod().getDeclaringClass() == ParthoodFeature.class){
				return methodcall.call(ParthoodFeature.get());				
			}else if(methodcall.getMethod().getDeclaringClass() == ProjectController.class){
				return methodcall.call(ProjectController.get());
			}else if(methodcall.getMethod().getDeclaringClass() == ActionStack.class){
				return methodcall.call(ActionStack.get());
			}else if(methodcall.getMethod().getDeclaringClass() == RemakeManager.class){
				return methodcall.call(RemakeManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == RenameCommander.class){
				return methodcall.call(RenameCommander.get());
			}else if(methodcall.getMethod().getDeclaringClass() == SbvrFeature.class){
				return methodcall.call(SbvrFeature.get());	
			}else if(methodcall.getMethod().getDeclaringClass() == SerializationUtil.class){
				return methodcall.call(SerializationUtil.get());	
			}else if(methodcall.getMethod().getDeclaringClass() == StatisticsManager.class){
				return methodcall.call(StatisticsManager.get());	
			}else if(methodcall.getMethod().getDeclaringClass() == SyntaxManager.class){
				return methodcall.call(SyntaxManager.get());
						
			}else if(methodcall.getMethod().getDeclaringClass() == TransferManager.class){
				return methodcall.call(TransferManager.get());		
			}else if(methodcall.getMethod().getDeclaringClass() == UpdateCommander.class){
				return methodcall.call(UpdateCommander.get());		
			}else if(methodcall.getMethod().getDeclaringClass() == WarningManager.class){
				return methodcall.call(WarningManager.get());	
			}
		}catch(java.lang.IllegalArgumentException e){
			System.err.println("Method not called. Reason: "+e.getLocalizedMessage());
			System.err.println(methodcall);			
		}
		return null;
	}

}
