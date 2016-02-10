package net.menthor.editor.v2.commands;

import org.tinyuml.ui.diagram.DiagramEditor;

import net.menthor.editor.v2.MenthorEditor;
import net.menthor.editor.v2.managers.AdditionManager;
import net.menthor.editor.v2.managers.AlignManager;
import net.menthor.editor.v2.managers.AlloyManager;
import net.menthor.editor.v2.managers.AntiPatternManager;
import net.menthor.editor.v2.managers.ChangeManager;
import net.menthor.editor.v2.managers.ClipboardManager;
import net.menthor.editor.v2.managers.ConnectManager;
import net.menthor.editor.v2.managers.CursorManager;
import net.menthor.editor.v2.managers.DeletionManager;
import net.menthor.editor.v2.managers.DeserializationManager;
import net.menthor.editor.v2.managers.DuplicateManager;
import net.menthor.editor.v2.managers.EditManager;
import net.menthor.editor.v2.managers.ErrorManager;
import net.menthor.editor.v2.managers.ExportManager;
import net.menthor.editor.v2.managers.FactoryManager;
import net.menthor.editor.v2.managers.FilterManager;
import net.menthor.editor.v2.managers.FindManager;
import net.menthor.editor.v2.managers.GlossaryManager;
import net.menthor.editor.v2.managers.HelpManager;
import net.menthor.editor.v2.managers.ImportManager;
import net.menthor.editor.v2.managers.MessageManager;
import net.menthor.editor.v2.managers.MetaPropertyManager;
import net.menthor.editor.v2.managers.MoveManager;
import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.managers.OwlManager;
import net.menthor.editor.v2.managers.ParthoodManager;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.managers.RedoManager;
import net.menthor.editor.v2.managers.RemakeManager;
import net.menthor.editor.v2.managers.RenameManager;
import net.menthor.editor.v2.managers.SbvrManager;
import net.menthor.editor.v2.managers.SerializationManager;
import net.menthor.editor.v2.managers.StatisticsManager;
import net.menthor.editor.v2.managers.SyntaxManager;
import net.menthor.editor.v2.managers.TabManager;
import net.menthor.editor.v2.managers.TransferManager;
import net.menthor.editor.v2.managers.UndoManager;
import net.menthor.editor.v2.managers.UpdateManager;
import net.menthor.editor.v2.managers.WarningManager;
import net.menthor.editor.v2.ui.AppFrame;

public class AppCommandListener implements ICommandListener {

	// -------- Lazy Initialization

	private static class CommandListenerLoader {
        private static final AppCommandListener INSTANCE = new AppCommandListener();
    }	
	public static AppCommandListener get() { 
		return CommandListenerLoader.INSTANCE; 
	}	
    private AppCommandListener() {
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
			if(methodcall.getMethod().getDeclaringClass() == DiagramEditor.class){
				return methodcall.call(TabManager.get().getCurrentDiagramEditor());
			//----------------
			}else if(methodcall.getMethod().getDeclaringClass() == AppFrame.class){
				return methodcall.call(MenthorEditor.getFrame());
			}else if(methodcall.getMethod().getDeclaringClass() == AdditionManager.class){
				return methodcall.call(AdditionManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == AlignManager.class){
				return methodcall.call(AlignManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == AlloyManager.class){
				return methodcall.call(AlloyManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == AntiPatternManager.class){
				return methodcall.call(AntiPatternManager.get());				
			}else if(methodcall.getMethod().getDeclaringClass() == ChangeManager.class){
				return methodcall.call(ChangeManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == ClipboardManager.class){
				return methodcall.call(ClipboardManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == ConnectManager.class){
				return methodcall.call(ConnectManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == CursorManager.class){
				return methodcall.call(CursorManager.get());				
			}else if(methodcall.getMethod().getDeclaringClass() == DeletionManager.class){
				return methodcall.call(DeletionManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == DeserializationManager.class){
				return methodcall.call(DeserializationManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == DuplicateManager.class){
				return methodcall.call(DuplicateManager.get());				
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
			}else if(methodcall.getMethod().getDeclaringClass() == MoveManager.class){
				return methodcall.call(MoveManager.get());				
			}else if(methodcall.getMethod().getDeclaringClass() == OccurenceManager.class){
				return methodcall.call(OccurenceManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == OwlManager.class){
				return methodcall.call(OwlManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == ParthoodManager.class){
				return methodcall.call(ParthoodManager.get());				
			}else if(methodcall.getMethod().getDeclaringClass() == ProjectManager.class){
				return methodcall.call(ProjectManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == RedoManager.class){
				return methodcall.call(RedoManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == RemakeManager.class){
				return methodcall.call(RemakeManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == RenameManager.class){
				return methodcall.call(RenameManager.get());
			}else if(methodcall.getMethod().getDeclaringClass() == SbvrManager.class){
				return methodcall.call(SbvrManager.get());	
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
			}else if(methodcall.getMethod().getDeclaringClass() == UpdateManager.class){
				return methodcall.call(UpdateManager.get());		
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
