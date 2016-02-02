package org.tinyuml.ui.diagram;

import java.awt.geom.Point2D;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.DrawingContext;
import org.tinyuml.draw.LineConnectMethod;
import org.tinyuml.draw.NullElement;
import org.tinyuml.ui.diagram.commands.AddConnectionCommand;
import org.tinyuml.umldraw.shared.UmlConnection;
import org.tinyuml.umldraw.shared.UmlNode;

import net.menthor.editor.ui.FactoryManager;
import net.menthor.editor.v2.editors.base.EditorMode;
import net.menthor.editor.v2.editors.base.EditorMouseEvent;
import net.menthor.editor.v2.types.RelationshipType;

public class LineHandler implements EditorMode {

  private DiagramEditor editor;
  private Point2D anchor = new Point2D.Double();
  private Point2D tmpPos = new Point2D.Double();
  private DiagramElement source;
  private boolean isDrawingLine;
  private RelationshipType relationType;
  private LineConnectMethod connectMethod;

  public LineHandler(DiagramEditor anEditor) {
	  editor = anEditor;
  }

  public void setRelationType(RelationshipType anAssociationType,
	  LineConnectMethod aConnectMethod) {
	  connectMethod = aConnectMethod;
	  relationType = anAssociationType;   
  }

  public boolean isDragging() { return isDrawingLine; }
  public void stateChanged() { }
  public void cancel() { isDrawingLine = false; }
  
  public void mousePressed(EditorMouseEvent event) {
	  double mx = event.getX(), my = event.getY();
	  DiagramElement elem = editor.getDiagram().getChildAt(mx, my);
	  if (elem!=null && ! (elem instanceof NullElement)) {
		  anchor.setLocation(mx, my); //TODO Change the anchor to the edge of the Diagram Element
		  tmpPos.setLocation(mx, my);
		  isDrawingLine = true;
		  if (elem instanceof UmlNode) source = (UmlNode) elem;
		  else source = (UmlConnection) elem;
	  }
  }

  public void mouseReleased(EditorMouseEvent event) {
    double mx = event.getX(), my = event.getY();
    DiagramElement target = editor.getDiagram().getChildAt(mx, my);	
    tmpPos.setLocation(mx, my);
    if(source !=null && target !=null){
    	UmlConnection conn = FactoryManager.get().createConnection(relationType, source, target); 
    	AddConnectionCommand command = new AddConnectionCommand(editor, conn);
    	command.run();
    }
    isDrawingLine = false;
    editor.cancelEditing();
    editor.redraw();
  }
    
  /**
   * {@inheritDoc}
   */
  public void mouseClicked(EditorMouseEvent event) { }


  /**
   * {@inheritDoc}
   */
  public void mouseDragged(EditorMouseEvent event) {
    double mx = event.getX(), my = event.getY();
    tmpPos.setLocation(mx, my);
    editor.redraw();
  }

  /**
   * {@inheritDoc}
   */
  public void mouseMoved(EditorMouseEvent event) { }

  /**
   * {@inheritDoc}
   */
  public void draw(DrawingContext drawingContext) {
    if (isDrawingLine) {
      connectMethod.drawLineSegments(drawingContext, anchor, tmpPos);
    }
  }
}
