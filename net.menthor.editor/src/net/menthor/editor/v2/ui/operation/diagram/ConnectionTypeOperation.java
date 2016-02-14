package net.menthor.editor.v2.ui.operation.diagram;

import org.tinyuml.draw.Connection;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.shared.UmlConnection;

import net.menthor.editor.v2.ui.operation.ActionType;
import net.menthor.editor.v2.ui.operation.DiagramOperation;
import net.menthor.editor.v2.ui.operation.OperationType;

public class ConnectionTypeOperation extends DiagramOperation {

	private static final long serialVersionUID = -8661812094443443847L;
	
	protected UmlConnection connection;
	protected Connection newconnection;
	protected Connection oldconnection;

	public ConnectionTypeOperation(OntoumlEditor editor, UmlConnection umlconn, Connection theNewConnection) {
		super();
		this.ontoumlEditor = editor;
		this.connection = umlconn;		
		this.newconnection = theNewConnection;
		this.operationType = OperationType.CONNECTION_TYPE;
	}

	@Override
	public void run() {
		super.run();
		runWithoutNotifying();
		System.out.println(runStatus());
		notifier.notifyViewChange(this, isRedo ? ActionType.REDO : ActionType.DO,connection);
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
	
	public String undoStatus(){
		return "[undo "+operationType.presentTense()+"] "+ontoumlEditor.getDiagram()+": "+connection;
	}	
	public String runStatus(){
		return "["+operationType.pastTense()+"] "+ontoumlEditor.getDiagram()+": "+connection;
	}
	
	protected void undoWithoutNotifying(){
		connection.setConnection(oldconnection);
	}
	
	@Override
	public void undo() {
		super.undo();
		undoWithoutNotifying();
		System.out.println(undoStatus());
		notifier.notifyViewChange(this, ActionType.UNDO, connection);
	}
}
