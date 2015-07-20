package net.menthor.story.ui.menu;

import net.menthor.story.ui.StoryElementTimeline;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class ActionDeleteWorld extends Action {
	final private StoryElementTimeline setml;
	private int selectedColumn = -1;
	public ActionDeleteWorld(StoryElementTimeline storyElementTimeline){
		super("Delete World");
		setml = storyElementTimeline;
	}
	public void run(){
		setml.deleteWorldColumn(selectedColumn);		
	}
	public void setSelectedColumn(int selectedColumn) {
		this.selectedColumn = selectedColumn;
		
	}

}
