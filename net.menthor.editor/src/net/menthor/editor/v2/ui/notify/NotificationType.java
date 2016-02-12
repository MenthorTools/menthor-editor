package net.menthor.editor.v2.ui.notify;

public enum NotificationType {

	ADD("added","add"),	 
	DELETE("deleted","delete"), 
	MODIFY("modified","modify"), 
	MOVE("moved","move"), 
	RESIZE("resized", "resize"),	
	ALIGN("align","aligned"),
	MODIFY_VISIBILITY("visibility modified","modify visibility"),
	COLOR("colored","color"),
	MODIFY_LABEL_TEXT("label text modified","modify label text"),	
	RESET_CONNECTION_POINTS("connection points reseted","reset connection points"), 
	MODIFY_CONNECTION_POINTS("connection points modified","modify connection points"), 
	MODIFY_CONNECTION_TYPE("connection type modified","modify connection type");
	
	private String past;
	private String present;

	NotificationType(String past, String present)
	{
		this.past = past;
		this.present = present;
	}
	
	public String toString() { 
		return getPresent(); 
	}
	
	public String getPast() { 
		return past; 
	}
	
	public String getPresent() { 
		return present; 
	}
	
	public static void main (String args[])
	{
		for(NotificationType c: NotificationType.values()){
			System.out.println(c.past);
		}
	}
	
	
//}
}
