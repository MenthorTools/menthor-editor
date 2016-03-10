package org.tinyuml.draw;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

import org.tinyuml.draw.GeometryUtil.Orientation;

/**
 * This class implements a rectilinear connection method to connect UmlNodes.
 *
 * @author Wei-ju Wu
 */
public class RectilinearLineConnectMethod implements LineConnectMethod {

  private static RectilinearLineConnectMethod instance =
    new RectilinearLineConnectMethod();

  /**
   * Returns the singleton instance.
   * @return the singleton instance
   */
  public static RectilinearLineConnectMethod getInstance() { return instance; }

  /**
   * Private constructor.
   */
  protected RectilinearLineConnectMethod() { }

  //FIXME To enable associations like material to source
  //FIXME - problem in "conn.setPoints(linepoints)" method, return null...
  
  /**
   * {@inheritDoc} Draw Line Segments
   */
  public void drawLineSegments(DrawingContext drawingContext, Point2D source, Point2D dest) 
  {
    // draw in a right angle
	RectilinearLineBuilder linebuilder = RectilinearLineBuilder.getInstance();
	List<Point2D> points = linebuilder.calculateLineSegments(source, dest, Orientation.HORIZONTAL);
	   
    if (points.size() > 0) 
    {
      Point2D lastPoint = points.get(0);
      Point2D nextPoint;
      for (int i = 1; i < points.size(); i++) 
      {
        nextPoint = points.get(i);
        drawingContext.drawLine(lastPoint.getX(), lastPoint.getY(),  nextPoint.getX(), nextPoint.getY());
        lastPoint = nextPoint;
      }
    }
  }  

	public void setPoints(Connection conn){
		DiagramElement sourceElem = conn.getSourceDiagramElement();
		DiagramElement targetElem = conn.getTargetDiagramElement();
		Point2D sourcePoint = new Point2D.Double();
		Point2D targetPoint = new Point2D.Double();	  
		sourcePoint.setLocation(sourceElem.getAbsCenterX(),sourceElem.getAbsCenterY());
		targetPoint.setLocation(targetElem.getAbsCenterX(),targetElem.getAbsCenterY());
		RectilinearLineBuilder linebuilder = RectilinearLineBuilder.getInstance();
		List<Point2D> points = null;
		if (sourceElem.equals(targetElem)) points = linebuilder.calculateSelfLineSegments((Node)sourceElem, (Node)targetElem, sourcePoint, targetPoint);
	    else points = linebuilder.calculateLineSegments(sourcePoint, targetPoint, Orientation.HORIZONTAL);
	    List<Point2D> linepoints = new LinkedList<Point2D>();
	    for (Point2D point : points) linepoints.add(point); 
	    
	    // calculate intersections with the nodes
	    Line2D line = new Line2D.Double();
	    // first
	    // check if we could start at the second segment
	    if (points.size() > 2) line.setLine(points.get(1), points.get(2));
	    
	    // if not, start at the first segment
	    if (points.size() > 2 && sourceElem.intersects(line)) {
	      linepoints.remove(0);
	    } else {
	      line.setLine(points.get(0), points.get(1));
	    }
	    sourceElem.calculateIntersection(line, linepoints.get(0));
	
	    // last
	    // check if we could end at the segment before the last one if yes,
	    // remove the last control point
	    if (points.size() > 2) {
	      line.setLine(points.get(points.size() - 3), points.get(points.size() - 2));
	      if (targetElem.intersects(line)) {
	        linepoints.remove(linepoints.size() - 1);
	      } else {
	        line.setLine(points.get(points.size() - 2), points.get(points.size() - 1));
	      }
	    }	    
	    targetElem.calculateIntersection(line, linepoints.get(linepoints.size() - 1));
	    
	    conn.setPoints(linepoints);	    
	}
}
