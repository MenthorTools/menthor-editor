package net.menthor.editor.v2.commands;

import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.ui.diagram.ScalingComponent;
import org.tinyuml.umldraw.MenthorFactory;
import org.tinyuml.umldraw.OccurenceMap;

import net.menthor.editor.v2.commanders.AddCommander;
import net.menthor.editor.v2.commanders.AddToDiagramCommander;
import net.menthor.editor.v2.commanders.AlignCommander;
import net.menthor.editor.v2.commanders.ChangeCommander;
import net.menthor.editor.v2.commanders.ClipboardCommanderMode;
import net.menthor.editor.v2.commanders.ColorCommander;
import net.menthor.editor.v2.commanders.ConnectCommanderMode;
import net.menthor.editor.v2.commanders.DeleteCommander;
import net.menthor.editor.v2.commanders.DuplicateCommander;
import net.menthor.editor.v2.commanders.LineCommander;
import net.menthor.editor.v2.commanders.RemakeCommander;
import net.menthor.editor.v2.commanders.RenameCommander;
import net.menthor.editor.v2.commanders.SelectCommanderMode;
import net.menthor.editor.v2.commanders.TransferCommander;
import net.menthor.editor.v2.commanders.UpdateCommander;
import net.menthor.editor.v2.commanders.VisibilityCommander;
import net.menthor.editor.v2.evaluator.ErrorEvaluator;
import net.menthor.editor.v2.evaluator.SyntaxEvaluator;
import net.menthor.editor.v2.evaluator.WarningEvaluator;
import net.menthor.editor.v2.managers.AlloyFeature;
import net.menthor.editor.v2.managers.AntiPatternManager;
import net.menthor.editor.v2.managers.FindManager;
import net.menthor.editor.v2.managers.GlossaryManager;
import net.menthor.editor.v2.managers.HelpManager;
import net.menthor.editor.v2.managers.OwlFeature;
import net.menthor.editor.v2.managers.ParthoodFeature;
import net.menthor.editor.v2.managers.SbvrFeature;
import net.menthor.editor.v2.managers.StatisticsManager;
import net.menthor.editor.v2.ui.controller.CursorUIController;
import net.menthor.editor.v2.ui.controller.DialogUIController;
import net.menthor.editor.v2.ui.controller.ExportUIController;
import net.menthor.editor.v2.ui.controller.FrameUIController;
import net.menthor.editor.v2.ui.controller.ImportUIController;
import net.menthor.editor.v2.ui.controller.MenuBarUIController;
import net.menthor.editor.v2.ui.controller.MessageUIController;
import net.menthor.editor.v2.ui.controller.ProjectUIController;
import net.menthor.editor.v2.ui.controller.SplitPaneUIController;
import net.menthor.editor.v2.ui.controller.TabbedAreaUIController;
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
			if(methodcall.getMethod().getDeclaringClass() == SplitPaneUIController.class){
				return methodcall.call(SplitPaneUIController.get());
			}else if(methodcall.getMethod().getDeclaringClass() == CursorUIController.class){
				return methodcall.call(CursorUIController.get());				
			}else if(methodcall.getMethod().getDeclaringClass() == MenuBarUIController.class){
				return methodcall.call(MenuBarUIController.get());
			}else if(methodcall.getMethod().getDeclaringClass() == MessageUIController.class){
				return methodcall.call(MessageUIController.get());
			}else if(methodcall.getMethod().getDeclaringClass() == TabbedAreaUIController.class){
				return methodcall.call(TabbedAreaUIController.get());	
			}else if(methodcall.getMethod().getDeclaringClass() == FrameUIController.class){
				return methodcall.call(FrameUIController.get());
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
				return methodcall.call(TabbedAreaUIController.get().getSelectedTopOntoumlEditor());
			} else if(methodcall.getMethod().getDeclaringClass() == ScalingComponent.class){
				return methodcall.call(TabbedAreaUIController.get().getSelectedTopOntoumlEditor().getScalingComponent());
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
			}else if(methodcall.getMethod().getDeclaringClass() == ClipboardCommanderMode.class){
				return methodcall.call(ClipboardCommanderMode.get());
			}else if(methodcall.getMethod().getDeclaringClass() == ConnectCommanderMode.class){
				return methodcall.call(ConnectCommanderMode.get());
			}else if(methodcall.getMethod().getDeclaringClass() == SelectCommanderMode.class){
				return methodcall.call(SelectCommanderMode.get());
			}else if(methodcall.getMethod().getDeclaringClass() == ColorCommander.class){
				return methodcall.call(ColorCommander.get());
			
			
				
			}else if(methodcall.getMethod().getDeclaringClass() == DeleteCommander.class){
				return methodcall.call(DeleteCommander.get());
			}else if(methodcall.getMethod().getDeclaringClass() == DeserializationUtil.class){
				return methodcall.call(DeserializationUtil.get());
			}else if(methodcall.getMethod().getDeclaringClass() == DuplicateCommander.class){
				return methodcall.call(DuplicateCommander.get());				
			}else if(methodcall.getMethod().getDeclaringClass() == DialogUIController.class){
				return methodcall.call(DialogUIController.get());
			}else if(methodcall.getMethod().getDeclaringClass() == ErrorEvaluator.class){
				return methodcall.call(ErrorEvaluator.get());
			}else if(methodcall.getMethod().getDeclaringClass() == ExportUIController.class){
				return methodcall.call(ExportUIController.get());
			}else if(methodcall.getMethod().getDeclaringClass() == MenthorFactory.class){
				return methodcall.call(MenthorFactory.get());				
			}else if(methodcall.getMethod().getDeclaringClass() == FindManager.class){
				return methodcall.call(FindManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == GlossaryManager.class){
				return methodcall.call(GlossaryManager.get());				
			}else if(methodcall.getMethod().getDeclaringClass() == HelpManager.class){
				return methodcall.call(HelpManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == ImportUIController.class){
				return methodcall.call(ImportUIController.get());
			
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
			}else if(methodcall.getMethod().getDeclaringClass() == ProjectUIController.class){
				return methodcall.call(ProjectUIController.get());
			}else if(methodcall.getMethod().getDeclaringClass() == ActionStack.class){
				return methodcall.call(ActionStack.get());
			}else if(methodcall.getMethod().getDeclaringClass() == RemakeCommander.class){
				return methodcall.call(RemakeCommander.get());
			}else if(methodcall.getMethod().getDeclaringClass() == RenameCommander.class){
				return methodcall.call(RenameCommander.get());
			}else if(methodcall.getMethod().getDeclaringClass() == SbvrFeature.class){
				return methodcall.call(SbvrFeature.get());	
			}else if(methodcall.getMethod().getDeclaringClass() == SerializationUtil.class){
				return methodcall.call(SerializationUtil.get());	
			}else if(methodcall.getMethod().getDeclaringClass() == StatisticsManager.class){
				return methodcall.call(StatisticsManager.get());	
			}else if(methodcall.getMethod().getDeclaringClass() == SyntaxEvaluator.class){
				return methodcall.call(SyntaxEvaluator.get());
						
			}else if(methodcall.getMethod().getDeclaringClass() == TransferCommander.class){
				return methodcall.call(TransferCommander.get());		
			}else if(methodcall.getMethod().getDeclaringClass() == UpdateCommander.class){
				return methodcall.call(UpdateCommander.get());		
			}else if(methodcall.getMethod().getDeclaringClass() == WarningEvaluator.class){
				return methodcall.call(WarningEvaluator.get());	
			}
		}catch(java.lang.IllegalArgumentException e){
			System.err.println("Method not called. Reason: "+e.getLocalizedMessage());
			System.err.println(methodcall);			
		}
		return null;
	}

}
