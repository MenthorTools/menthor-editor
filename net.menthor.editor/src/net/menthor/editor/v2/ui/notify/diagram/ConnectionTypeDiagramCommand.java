package net.menthor.editor.v2.ui.notify.diagram;

import org.tinyuml.draw.Connection;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.shared.UmlConnection;

import net.menthor.editor.v2.ui.notify.ActionType;
import net.menthor.editor.v2.ui.notify.DiagramCommand;
import net.menthor.editor.v2.ui.notify.NotificationType;

public class ConnectionTypeDiagramCommand extends DiagramCommand {

	private static final long serialVersionUID = -8661812094443443847L;
	
	protected UmlConnection connection;
	protected Connection newconnection;
	protected Connection oldconnection;

	public ConnectionTypeDiagramCommand(OntoumlEditor editor, UmlConnection umlconn, Connection theNewConnection) {
		super();
		this.ontoumlEditor = editor;
		this.connection = umlconn;		
		this.newconnection = theNewConnection;
		this.notificationType = NotificationType.CONNECTION_TYPE;
	}

	@Override
	public void run() {
		super.run();
		runWithoutNotifying();
		notifier.notifyChangeOnView(this, isRedo ? ActionType.REDO : ActionType.DO,connection);
	}

	protected void runWithoutNotifying(){
		oldconnection = connection.getConnection();
		newconnection.copyData(oldconnection);
		connection.setConnection(newconnection);
		//in case of a derivation connected to a material, reset derivation's points
		for(Connection c: connection.getConnections()){
			c.resetPoints();
		}		
	}
	
	protected void undoWithoutNotifying(){
		connection.setConnection(oldconnection);
	}
	
	@Override
	public void undo() {
		super.undo();
		undoWithoutNotifying();
		notifier.notifyChangeOnView(this, ActionType.UNDO, connection);
	}
}
