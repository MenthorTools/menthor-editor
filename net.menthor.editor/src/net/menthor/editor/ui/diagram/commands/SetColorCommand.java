package net.menthor.editor.ui.diagram.commands;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.ui.diagram.commands.BaseDiagramCommand;
import org.tinyuml.ui.diagram.commands.DiagramNotification;
import org.tinyuml.ui.diagram.commands.DiagramNotification.ChangeType;
import org.tinyuml.ui.diagram.commands.DiagramNotification.NotificationType;
import org.tinyuml.umldraw.ClassElement;

import net.menthor.editor.model.UmlProject;

/**
 * @author John Guerson
 */
public class SetColorCommand extends BaseDiagramCommand {

	private static final long serialVersionUID = 1L;
	
	public DiagramEditor editor;
	public UmlProject project;
	public ArrayList<DiagramElement> selected = new ArrayList<DiagramElement>();
	public ArrayList<Color> oldColorList = new ArrayList<Color>();
	public Color color;
	
	public SetColorCommand(DiagramNotification editorNotification, ArrayList<DiagramElement> selected, UmlProject project, Color color)
	{
		this.editor = (DiagramEditor)editorNotification;
		notification = editorNotification;
		this.project = project;		
		this.color = color;
		
		for(DiagramElement dElem: selected)
		{
			if(dElem instanceof ClassElement){
				ClassElement ce = (ClassElement)dElem;
				oldColorList.add(ce.getBackgroundColor());
				this.selected.add(ce);
			}
		}
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void undo() {
		super.undo();
						
		if(notification!=null){
			ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();
		
			int i =0;
			for(DiagramElement dElem: selected)
			{
				if(dElem instanceof ClassElement)
				{
					ClassElement ce = (ClassElement)dElem;
					ce.setBackgroundColor(oldColorList.get(i));
					list.add(ce);
					i++;
				}
			}
			
			notification.notifyChange((List<DiagramElement>) list, ChangeType.ELEMENTS_COLORED, NotificationType.UNDO);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void redo() {
		redo = true;
		super.redo();
		run();		
	}
	
	@Override
	public void run() {
		
		for(DiagramElement dElem: selected)
		{
			if(dElem instanceof ClassElement)
			{
				ClassElement ce = (ClassElement)dElem;
				ce.setBackgroundColor(color);				
			}
		}
	
		//notify
		if (notification!=null) {
			notification.notifyChange((List<DiagramElement>) selected, ChangeType.ELEMENTS_COLORED, redo ? NotificationType.REDO : NotificationType.DO);			
			UndoableEditEvent event = new UndoableEditEvent(((DiagramEditor)editor), this);
			for (UndoableEditListener l : ((DiagramEditor)editor).editListeners)  l.undoableEditHappened(event);			
		}	
	}
}
