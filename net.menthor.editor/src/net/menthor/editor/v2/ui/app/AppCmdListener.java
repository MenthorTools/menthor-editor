package net.menthor.editor.v2.ui.app;

import org.tinyuml.ui.diagram.OntoumlEditor;

import net.menthor.editor.v2.commanders.AddCommander;
import net.menthor.editor.v2.commanders.AlignCommander;
import net.menthor.editor.v2.commanders.ChangeCommander;
import net.menthor.editor.v2.commanders.DeleteCommander;
import net.menthor.editor.v2.commanders.ColorCommander;
import net.menthor.editor.v2.commanders.DuplicateCommander;
import net.menthor.editor.v2.commanders.MoveCommander;
import net.menthor.editor.v2.commanders.RenameCommander;
import net.menthor.editor.v2.commanders.UpdateCommander;
import net.menthor.editor.v2.commanders.VisibilityCommander;
import net.menthor.editor.v2.commands.CommandMap;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.commands.MethodCall;
import net.menthor.editor.v2.feature.AlloyFeature;
import net.menthor.editor.v2.feature.OwlFeature;
import net.menthor.editor.v2.feature.ParthoodFeature;
import net.menthor.editor.v2.feature.SbvrFeature;
import net.menthor.editor.v2.managers.AntiPatternManager;
import net.menthor.editor.v2.managers.CursorManager;
import net.menthor.editor.v2.managers.DeserializationManager;
import net.menthor.editor.v2.managers.EditManager;
import net.menthor.editor.v2.managers.ErrorManager;
import net.menthor.editor.v2.managers.ExportManager;
import net.menthor.editor.v2.managers.FactoryManager;
import net.menthor.editor.v2.managers.FilterManager;
import net.menthor.editor.v2.managers.FindManager;
import net.menthor.editor.v2.managers.GlossaryManager;
import net.menthor.editor.v2.managers.HelpManager;
import net.menthor.editor.v2.managers.ImportManager;
import net.menthor.editor.v2.managers.MetaPropertyManager;
import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.managers.RedoManager;
import net.menthor.editor.v2.managers.RemakeManager;
import net.menthor.editor.v2.managers.SerializationManager;
import net.menthor.editor.v2.managers.StatisticsManager;
import net.menthor.editor.v2.managers.SyntaxManager;
import net.menthor.editor.v2.managers.TransferManager;
import net.menthor.editor.v2.managers.UndoManager;
import net.menthor.editor.v2.managers.WarningManager;
import net.menthor.editor.v2.ui.editor.mode.ClipboardMode;
import net.menthor.editor.v2.ui.editor.mode.ConnectMode;
import net.menthor.editor.v2.ui.manager.MessageManager;
import net.menthor.editor.v2.ui.manager.TabManager;

public class AppCmdListener implements ICommandListener {

	// -------- Lazy Initialization

	private static class CommandListenerLoader {
        private static final AppCmdListener INSTANCE = new AppCmdListener();
    }	
	public static AppCmdListener get() { 
		return CommandListenerLoader.INSTANCE; 
	}	
    private AppCmdListener() {
        if (CommandListenerLoader.INSTANCE != null) throw new IllegalStateException("AppCommandListener already instantiated");
    }		
    
    // ----------------------------
	    
	@Override
	public Object handleCommand(String command, Object[] parameters) {	
		CursorManager.get().waitCursor();		
		MethodCall methodcall = getMethodCall(command,parameters);
		System.out.println(methodcall);
		Object result=null;
		if(methodcall!=null) result = callMethod(methodcall);
		CursorManager.get().defaultCursor();
		return result;		
	}
	
	@Override
	
	public Object handleCommand(String command) {	
		CursorManager.get().waitCursor();
		MethodCall methodcall = getMethodCall(command,null);
		System.out.println(methodcall);
		Object result=null;
		if(methodcall!=null) result = callMethod(methodcall);
		CursorManager.get().defaultCursor();
		return result;		
	}
	
	private MethodCall getMethodCall(String command, Object[] parameters){
		MethodCall methodcall=null;		
		CommandType cmdType = CommandType.valueOf(command);
		if(CommandType.isValueOf(command)){
			if(parameters!=null) CommandMap.getInstance().addParameters(cmdType, parameters);			
			methodcall = CommandMap.getInstance().getMethodCall(cmdType);
		}
		if(methodcall==null){
			System.err.println("A method call could not be found for command type: "+cmdType);
			return null;
		}
		return methodcall;
	}
	
	private Object callMethod(MethodCall methodcall){
		try{
			//----------------
			if(methodcall.getMethod().getDeclaringClass() == OntoumlEditor.class){
				return methodcall.call(TabManager.get().getCurrentDiagramEditor());
			//----------------
			}else if(methodcall.getMethod().getDeclaringClass() == AppFrame.class){
				return methodcall.call(AppFrame.get());				
			}else if(methodcall.getMethod().getDeclaringClass() == AppSplitPane.class){
				return methodcall.call(AppSplitPane.get());
			}else if(methodcall.getMethod().getDeclaringClass() == AppMenuBar.class){
				return methodcall.call(AppMenuBar.get());
			//----------------				
			}else if(methodcall.getMethod().getDeclaringClass() == AddCommander.class){
				return methodcall.call(AddCommander.get());
			}else if(methodcall.getMethod().getDeclaringClass() == AlignCommander.class){
				return methodcall.call(AlignCommander.get());
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
			}else if(methodcall.getMethod().getDeclaringClass() == ColorCommander.class){
				return methodcall.call(ColorCommander.get());
			}else if(methodcall.getMethod().getDeclaringClass() == CursorManager.class){
				return methodcall.call(CursorManager.get());				
			}else if(methodcall.getMethod().getDeclaringClass() == DeleteCommander.class){
				return methodcall.call(DeleteCommander.get());
			}else if(methodcall.getMethod().getDeclaringClass() == DeserializationManager.class){
				return methodcall.call(DeserializationManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == DuplicateCommander.class){
				return methodcall.call(DuplicateCommander.get());				
			}else if(methodcall.getMethod().getDeclaringClass() == EditManager.class){
				return methodcall.call(EditManager.get());
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
			}else if(methodcall.getMethod().getDeclaringClass() == MessageManager.class){
				return methodcall.call(MessageManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == MetaPropertyManager.class){
				return methodcall.call(MetaPropertyManager.get());		
			}else if(methodcall.getMethod().getDeclaringClass() == VisibilityCommander.class){
				return methodcall.call(VisibilityCommander.get());	
			}else if(methodcall.getMethod().getDeclaringClass() == MoveCommander.class){
				return methodcall.call(MoveCommander.get());				
			}else if(methodcall.getMethod().getDeclaringClass() == OccurenceManager.class){
				return methodcall.call(OccurenceManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == OwlFeature.class){
				return methodcall.call(OwlFeature.get());
			}else if(methodcall.getMethod().getDeclaringClass() == ParthoodFeature.class){
				return methodcall.call(ParthoodFeature.get());				
			}else if(methodcall.getMethod().getDeclaringClass() == ProjectManager.class){
				return methodcall.call(ProjectManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == RedoManager.class){
				return methodcall.call(RedoManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == RemakeManager.class){
				return methodcall.call(RemakeManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == RenameCommander.class){
				return methodcall.call(RenameCommander.get());
			}else if(methodcall.getMethod().getDeclaringClass() == SbvrFeature.class){
				return methodcall.call(SbvrFeature.get());	
			}else if(methodcall.getMethod().getDeclaringClass() == SerializationManager.class){
				return methodcall.call(SerializationManager.get());	
			}else if(methodcall.getMethod().getDeclaringClass() == StatisticsManager.class){
				return methodcall.call(StatisticsManager.get());	
			}else if(methodcall.getMethod().getDeclaringClass() == SyntaxManager.class){
				return methodcall.call(SyntaxManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == TabManager.class){
				return methodcall.call(TabManager.get());				
			}else if(methodcall.getMethod().getDeclaringClass() == TransferManager.class){
				return methodcall.call(TransferManager.get());				
			}else if(methodcall.getMethod().getDeclaringClass() == UndoManager.class){
				return methodcall.call(UndoManager.get());	
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
