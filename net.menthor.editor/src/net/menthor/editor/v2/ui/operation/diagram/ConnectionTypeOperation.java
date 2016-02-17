package net.menthor.editor.v2.ui.operation.diagram;

import org.tinyuml.draw.Connection;
import org.tinyuml.draw.RectilinearConnection;
import org.tinyuml.draw.SimpleConnection;
import org.tinyuml.draw.TreeConnection;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.shared.UmlConnection;

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
		notifier.notifyViewChange(this, connection);
	}

	protected void runWithoutNotifying(){
		oldconnection = connection.getConnection();
		newconnection.copyData(oldconnection);
		connection.setConnection(newconnection);
		//in case of a derivation connected to a material, reset derivation's points
		for(Connection c: connection.getConnections()){
			c.resetPoints();
		}	
		System.out.println(runMessage());
	}
	
	public String styleAsString(){
		if(connection.getConnection() instanceof RectilinearConnection) return "rectilinear style";
		if(connection.getConnection() instanceof TreeConnection) return "tree style";
		if(connection.getConnection() instanceof SimpleConnection) return "direct style";
		return "undefined style";
	}
	
	@Override
	public String undoMessage(){
		return super.undoMessage()+connection+" to "+styleAsString();
	}	
	
	@Override
	public String runMessage(){
		return super.runMessage()+connection+" to "+styleAsString();
	}
	
	protected void undoWithoutNotifying(){
		connection.setConnection(oldconnection);
		System.out.println(undoMessage());
	}
	
	@Override
	public void undo() {
		super.undo();
		undoWithoutNotifying();		
		notifier.notifyViewChange(this, connection);
	}
}
