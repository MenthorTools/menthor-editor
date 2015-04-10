package net.menthor.editor.explorer.dnd;

import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceContext;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;

public class TreeDragSourceListener implements DragSourceListener {
	
	public void dragEnter(DragSourceDragEvent dsde) 
	{
		DragSourceContext context = dsde.getDragSourceContext();
		int dropAction = dsde.getDropAction();
		if ((dropAction & DnDConstants.ACTION_COPY) != 0) context.setCursor(DragSource.DefaultCopyDrop);
		else if ((dropAction & DnDConstants.ACTION_MOVE) != 0) context.setCursor(DragSource.DefaultMoveDrop);
		else context.setCursor(DragSource.DefaultCopyNoDrop);			
	}

	public void dragExit(DragSourceEvent dse) {}

	public void dragOver(DragSourceDragEvent dsde) {}

	public void dropActionChanged(DragSourceDragEvent dsde) { }

	public void dragDropEnd(DragSourceDropEvent dsde) 
	{
		if (dsde.getDropSuccess()) 
		{
			int dropAction = dsde.getDropAction();
			if (dropAction == DnDConstants.ACTION_MOVE) {}
		}
	}		
}
