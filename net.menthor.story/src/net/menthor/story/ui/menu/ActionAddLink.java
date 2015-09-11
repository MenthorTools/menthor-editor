package net.menthor.story.ui.menu;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import net.menthor.story.ui.StoryElementTimeline;

public class ActionAddLink extends Action {
	final private StoryElementTimeline setml;
	final private Tree tree;
	public ActionAddLink(StoryElementTimeline storyElementTimeline){
		super("Add Link");
		tree = storyElementTimeline.getTree();
		setml = storyElementTimeline;
	}
	public void run(){
		TreeItem [] selected = tree.getSelection();
        
        if (selected.length > 0)
        {
          TreeItem parent = selected[0].getParentItem();
          if (parent == null)
          {	        	  
	          int index = tree.indexOf(tree.getSelection()[0]);
	          setml.createLink(tree, index+1);
	           
          }          
        }else{
          //nothing selected. Insert at beggining
          setml.createLink(tree, 0);
          
      	}
		
	}
}
