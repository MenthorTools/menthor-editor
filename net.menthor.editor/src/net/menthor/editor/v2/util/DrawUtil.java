package net.menthor.editor.v2.util;

import org.tinyuml.draw.DrawingContext;
import org.tinyuml.draw.DrawingContextImpl;

public class DrawUtil {

	private static DrawingContext drawingContext = new DrawingContextImpl();	
	public static DrawingContext getDrawingContext(){ return drawingContext; }
}
