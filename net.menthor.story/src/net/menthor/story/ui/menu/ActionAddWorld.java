package net.menthor.story.ui.menu;

import net.menthor.story.ui.StoryElementTimeline;

import org.eclipse.jface.action.Action;

public class ActionAddWorld extends Action {
	final private StoryElementTimeline setml;
	
	public ActionAddWorld(StoryElementTimeline storyElementTimeline){
		super("Add World");
		setml = storyElementTimeline;
	}
	public void run(){
		setml.createWorld();		
	}
	

}
