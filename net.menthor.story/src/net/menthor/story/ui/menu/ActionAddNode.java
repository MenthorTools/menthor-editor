package net.menthor.story.ui.menu;

import net.menthor.story.ui.StoryElementTimeline;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class ActionAddNode extends Action {
	final private StoryElementTimeline setml;
	final private Tree tree;
	public ActionAddNode(StoryElementTimeline storyElementTimeline){
		super("Add Node");
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
	          setml.createStoryElement(tree, index+1);
	           
          }          
        }else{
          //nothing selected. Insert at beggining
          setml.createStoryElement(tree, 0);
          
      	}
		
	}
}
