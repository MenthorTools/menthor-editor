package net.menthor.story.ui.menu;

import net.menthor.story.ui.StoryElementTimeline;

import org.eclipse.jface.action.Action;

public class ActionAddWorld extends Action {
	final private StoryElementTimeline setml;
	private int selectedColumn = -1;
	public ActionAddWorld(StoryElementTimeline storyElementTimeline){
		super("Add World");
		setml = storyElementTimeline;
	}
	public void run(){
		setml.createWorld();		
	}
	public void setSelectedColumn(int selectedColumn) {
		this.selectedColumn = selectedColumn;
		
	}

}
