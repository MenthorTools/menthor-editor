package org.tinyuml.draw;

/**
 * Copyright 2007 Wei-ju Wu
 *
 * This file is part of TinyUML.
 *
 * TinyUML is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * TinyUML is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with TinyUML; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

import org.tinyuml.draw.GeometryUtil.Orientation;

public class TreeLineConnectMethod extends RectilinearLineConnectMethod {

	  private static TreeLineConnectMethod instance = new TreeLineConnectMethod();

	  /**
	   * Returns the singleton instance.
	   * @return the singleton instance
	   */
	  public static TreeLineConnectMethod getInstance() { return instance; }

	  /**
	   * Private constructor.
	   */
	  protected TreeLineConnectMethod() { }

	  //FIXME To enable associations like material to source
	  //FIXME - problem in "conn.setPoints(linepoints)" method, return null...
			  
	  /**
	   * {@inheritDoc} Draw Line Segments
	   */
	  @Override
	  public void drawLineSegments(DrawingContext drawingContext, Point2D source, Point2D dest) 
	  {
	    // draw in a right angle
	    TreeLineBuilder linebuilder = TreeLineBuilder.getInstance();
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
			  	  
		/** Connection to Connection */
	  	@Override
		public void setPoints(Connection conn) {
	  		DiagramElement sourceElem = conn.getSourceDiagramElement();
	  		DiagramElement targetElem = conn.getTargetDiagramElement();
			TreeLineBuilder linebuilder = TreeLineBuilder.getInstance();
			Point2D sourcePoint = new Point2D.Double();
			Point2D targetPoint = new Point2D.Double();	  
			sourcePoint.setLocation(sourceElem.getAbsCenterX(),sourceElem.getAbsCenterY());
			targetPoint.setLocation(targetElem.getAbsCenterX(),targetElem.getAbsCenterY());
		    List<Point2D> points = linebuilder.calculateLineSegments(sourcePoint, targetPoint, Orientation.HORIZONTAL);
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
