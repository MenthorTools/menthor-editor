package net.menthor.editor.v2.ui.generic;

/**
 * ============================================================================================
 * Menthor Editor -- Copyright (c) 2015 
 *
 * This file is part of Menthor Editor. Menthor Editor is based on TinyUML and as so it is 
 * distributed under the same license terms.
 *
 * Menthor Editor is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 *
 * Menthor Editor is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Menthor Editor; 
 * if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, 
 * MA  02110-1301  USA
 * ============================================================================================
 */

import java.awt.Component;
import java.awt.Dimension;

import net.menthor.editor.v2.util.Util;

import org.jdesktop.swingx.MultiSplitLayout;
import org.jdesktop.swingx.MultiSplitPane;

public abstract class GenericMultiSplitPane extends MultiSplitPane{

	private static final long serialVersionUID = -6672916781936276309L;

	private int rightWidth=230;
	private int leftWidth=230;
	private int bottomHeight=200;
	
	private Component leftPane;
	private Component rightPane;
	private Component topPane;
	private Component bottomPane;
	
	public GenericMultiSplitPane(Component leftPane, Component topPane, Component bottomPane, Component rightPane){		
		String layoutDef = "(ROW weight=1.0 left (COLUMN middle.top middle.bottom) right)";
		MultiSplitLayout.Node modelRoot = MultiSplitLayout.parseModel(layoutDef);
		
		this.leftPane = leftPane;
		this.topPane = topPane;
		this.bottomPane = bottomPane;
		this.rightPane = rightPane;
		
		topPane.setPreferredSize(new Dimension(Util.getScreenWorkingWidth()-240-240,Util.getScreenWorkingHeight()));
		bottomPane.setPreferredSize(new Dimension(Util.getScreenWorkingWidth()-240-240,0));
		rightPane.setPreferredSize(new Dimension(rightWidth,250));		
		leftPane.setPreferredSize(new Dimension(leftWidth,250));
		
		getMultiSplitLayout().setModel(modelRoot);
		add(leftPane, "left");
		add(rightPane, "right");
		add(topPane, "middle.top");		
		add(bottomPane, "middle.bottom");
		setBorder(null);	
		
		forceShowOnlyTopPane();
	}
	
	//==========================================
	//TOP
	//==========================================
	
	public void forceShowOnlyTopPane(){		
		getMultiSplitLayout().setFloatingDividers(true);
		rightPane.setPreferredSize(new Dimension(0,250));			
		leftPane.setPreferredSize(new Dimension(0,250));		
		bottomPane.setPreferredSize(new Dimension(Util.getScreenWorkingWidth(),0));						
		topPane.setPreferredSize(new Dimension(Util.getScreenWorkingWidth(),Util.getScreenWorkingHeight()));
		revalidate();
	}
	
	//==========================================
	//BOTTOM
	//==========================================
	
	public void showBottomPane(){		
		getMultiSplitLayout().setFloatingDividers(true);
		int dividerSize = getMultiSplitLayout().getDividerSize();
		bottomPane.setPreferredSize(new Dimension(bottomPane.getSize().width, bottomHeight));
		rightPane.setPreferredSize(new Dimension(rightPane.getSize().width,250));
		leftPane.setPreferredSize(new Dimension(leftPane.getSize().width,250));
		topPane.setPreferredSize(new Dimension(topPane.getSize().width,Util.getScreenWorkingHeight()-bottomHeight-dividerSize-30));
		revalidate();
	}
	
	public void hideBottomPane(){	
		recordSplitSizes();
		getMultiSplitLayout().setFloatingDividers(true);
		int dividerSize = getMultiSplitLayout().getDividerSize();
		bottomPane.setPreferredSize(new Dimension(bottomPane.getSize().width,0));
		rightPane.setPreferredSize(new Dimension(rightPane.getSize().width,250));
		leftPane.setPreferredSize(new Dimension(leftPane.getSize().width,250));
		topPane.setPreferredSize(new Dimension(topPane.getSize().width,Util.getScreenWorkingHeight()-dividerSize-30));
		revalidate();
	}
	
	//==========================================
	//RIGHT
	//==========================================
			
	public void showRightPane(){		
		getMultiSplitLayout().setFloatingDividers(true);
		int dividerSize = getMultiSplitLayout().getDividerSize();
		rightPane.setPreferredSize(new Dimension(rightWidth,250));
		leftPane.setPreferredSize(new Dimension(leftPane.getSize().width,250));		
		bottomPane.setPreferredSize(new Dimension(Util.getScreenWorkingWidth()-rightWidth-leftPane.getSize().width-(2*dividerSize),bottomPane.getSize().height));
		topPane.setPreferredSize(new Dimension(Util.getScreenWorkingWidth()-rightWidth-leftPane.getSize().width-(2*dividerSize),topPane.getSize().height));
		revalidate();
	}
				
	public void hideRightPane(){	
		recordSplitSizes();
		getMultiSplitLayout().setFloatingDividers(true);
		int dividerSize = getMultiSplitLayout().getDividerSize();
		leftPane.setPreferredSize(new Dimension(leftPane.getSize().width,250));
		rightPane.setPreferredSize(new Dimension(0,250));
		bottomPane.setPreferredSize(new Dimension(Util.getScreenWorkingWidth()-leftPane.getSize().width-(2*dividerSize),bottomPane.getSize().height));						
		topPane.setPreferredSize(new Dimension(Util.getScreenWorkingWidth()-leftPane.getSize().width-(2*dividerSize),topPane.getSize().height));
		revalidate();
	}
	
	public void forceShowRightPane(){
		getMultiSplitLayout().setFloatingDividers(true);
		int dividerSize = getMultiSplitLayout().getDividerSize();
		rightPane.setPreferredSize(new Dimension(rightWidth,250));
		leftPane.setPreferredSize(new Dimension(leftWidth,250));		
		bottomPane.setPreferredSize(new Dimension(Util.getScreenWorkingWidth()-rightWidth-leftWidth-(2*dividerSize),bottomPane.getSize().height));		
		topPane.setPreferredSize(new Dimension(Util.getScreenWorkingWidth()-rightWidth-leftWidth-(2*dividerSize),topPane.getSize().height));
		revalidate();
	}
	
	//==========================================
	//LEFT
	//==========================================
	
	public void showLeftPane(){
		getMultiSplitLayout().setFloatingDividers(true);
		int dividerSize = getMultiSplitLayout().getDividerSize();
		leftPane.setPreferredSize(new Dimension(leftWidth,250));		
		rightPane.setPreferredSize(new Dimension(rightPane.getSize().width,250));
		bottomPane.setPreferredSize(new Dimension(Util.getScreenWorkingWidth()-leftWidth-rightPane.getSize().width-(2*dividerSize),bottomPane.getSize().height));
		topPane.setPreferredSize(new Dimension(Util.getScreenWorkingWidth()-leftWidth-rightPane.getSize().width-(2*dividerSize),topPane.getSize().height));
		revalidate();
	}
			
	public void hideLeftPane(){	
		recordSplitSizes();
		getMultiSplitLayout().setFloatingDividers(true);
		int dividerSize = getMultiSplitLayout().getDividerSize();
		rightPane.setPreferredSize(new Dimension(rightPane.getSize().width,250));			
		leftPane.setPreferredSize(new Dimension(0,250));
		bottomPane.setPreferredSize(new Dimension(Util.getScreenWorkingWidth()-rightPane.getSize().width-(2*dividerSize),bottomPane.getSize().height));						
		topPane.setPreferredSize(new Dimension(Util.getScreenWorkingWidth()-rightPane.getSize().width-(2*dividerSize),topPane.getSize().height));
		revalidate();
	}
	
	public void forceShowLeftPane(){
		getMultiSplitLayout().setFloatingDividers(true);
		int dividerSize = getMultiSplitLayout().getDividerSize();
		leftPane.setPreferredSize(new Dimension(leftWidth,250));		
		rightPane.setPreferredSize(new Dimension(rightWidth,250));
		bottomPane.setPreferredSize(new Dimension(Util.getScreenWorkingWidth()-leftWidth-rightWidth-(2*dividerSize),bottomPane.getSize().height));
		topPane.setPreferredSize(new Dimension(Util.getScreenWorkingWidth()-leftWidth-rightWidth-(2*dividerSize),topPane.getSize().height));
		revalidate();
	}
	
	//==========================================
	//RECORD
	//==========================================
	
	public void recordSplitSizes() {
		if(leftPane.getSize().width!=0) leftWidth = leftPane.getSize().width;
		if(rightPane.getSize().width!=0) rightWidth = rightPane.getSize().width;
		if(bottomPane.getSize().height!=0) bottomHeight = bottomPane.getSize().height;
	}
	
	public boolean isShowLeftPane(){
		return !(leftPane.getPreferredSize().width == 0);
	}
	
	public boolean isShowRightPane(){
		return !(rightPane.getPreferredSize().width==0);
	}
	
	public boolean isShowBottomPane(){
		return !(bottomPane.getPreferredSize().height == 0);
	}
}
