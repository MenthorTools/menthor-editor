package net.menthor.story.ui.menu;

import net.menthor.story.ui.StoryElementTimeline;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class ActionAddState extends Action {
	final private StoryElementTimeline setml;
	final private Tree tree;
	public ActionAddState(StoryElementTimeline storyElementTimeline){
		super("Add State");
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
        	  //Node or link selected. Add as child
        	  
        		  setml.createNode_state(selected[0], 0);
            	  selected[0].setExpanded(true);            	    
        	  //should check for many selected
        	  
        
          }else{
        	  //State selected. Add as sibling
	          int index = parent.indexOf(selected[0]);
	          setml.createNode_state(parent, index+1);
	          
          }
          
        }
		
	}
}
