package net.menthor.editor.v2.commands;

import net.menthor.editor.v2.ui.controller.CursorUIController;

public class AbstractCommandListener implements ICommandListener{

	public Object callMethod(MethodCall methodcall){ 
		return null; 
	}
			
	@Override
	public Object handleCommand(String command, Object[] parameters) {	
		CursorUIController.get().waitCursor();		
		MethodCall methodcall = getMethodCall(command,parameters);
		System.out.println(methodcall);
		Object result=null;
		if(methodcall!=null) result = callMethod(methodcall);
		CursorUIController.get().defaultCursor();
		return result;		
	}
	
	@Override	
	public Object handleCommand(String command) {	
		CursorUIController.get().waitCursor();
		MethodCall methodcall = getMethodCall(command,null);
		System.out.println(methodcall);
		Object result=null;
		
		if(methodcall!=null) {
			result = callMethod(methodcall);
		}
		
		CursorUIController.get().defaultCursor();
		return result;		
	}
	
	private MethodCall getMethodCall(String command, Object[] parameters){
		MethodCall methodcall=null;		
		CommandType cmdType = CommandType.valueOf(command);
		if(CommandType.isValueOf(command)){
			if(parameters!=null) {
				CommandMap.getInstance().addParameters(cmdType, parameters);			
			}
			methodcall = CommandMap.getInstance().getMethodCall(cmdType);
		}
		if(methodcall==null){
			System.err.println("A method call could not be found for command type: "+cmdType);
			return null;
		}
		return methodcall;
	}
}
