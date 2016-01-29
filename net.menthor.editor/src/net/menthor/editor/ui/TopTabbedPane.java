package net.menthor.editor.ui;

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

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import org.eclipse.emf.edit.provider.IDisposable;
import org.tinyuml.draw.DrawingContext;
import org.tinyuml.draw.DrawingContextImpl;
import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.ui.diagram.EditorStateListener;
import org.tinyuml.ui.diagram.SelectionListener;
import org.tinyuml.ui.diagram.commands.DiagramNotification.ChangeType;
import org.tinyuml.umldraw.shared.DiagramElementFactoryImpl;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.editors.EditorMouseEvent;
import net.menthor.editor.v2.managers.TabManager;
import net.menthor.editor.v2.menubar.MainMenuBar;
import net.menthor.editor.v2.util.RefOntoUMLEditingDomain;

public class TopTabbedPane extends JTabbedPane implements SelectionListener, EditorStateListener, IDisposable {

	private static final long serialVersionUID = 5019191384767258996L;
	
	public final MainFrame frame;	
	private CommandListener listener;
	private DiagramElementFactoryImpl elementFactory;
	private DrawingContext drawingContext;		
	
	public TopTabbedPane(final MainFrame frame){
		this.frame = frame;		
		listener = frame;
		elementFactory = new DiagramElementFactoryImpl();
		drawingContext =  new DrawingContextImpl();
		RefOntoUMLEditingDomain.getInstance().initialize();		
		setBorder(new EmptyBorder(0,0,0,0));		
		setBackground(Color.white);
		setMinimumSize(new Dimension(0,0));
		setTabPlacement(JTabbedPane.TOP);
	}
	
	public MainFrame getFrame() { return frame; }
	public DiagramElementFactoryImpl getElementFactory() { return elementFactory; }
	public DrawingContext getDrawingContext() { return drawingContext; }
	public MainMenuBar getMainMenu() { return frame.getMainMenu(); }
	public void setCommandListener(CommandListener listener){ this.listener = listener; }
	public CommandListener getCommandListener(){ return listener; }
	
	public void empty(){
		removeAll();
		TabManager.get().addStartEditor(false);
		getFrame().setTitle("Menthor Editor");
		getFrame().showOnlyStartPage();
		getFrame().getMainMenu().disactivateSomeToBegin();			
		repaint();
		revalidate();
	}
	
	@Override
	public void dispose() {
		int totalTabs = getTabCount();
		for(int i = 0; i < totalTabs; i++) {
			IDisposable disposable = (IDisposable) getComponentAt(i);
			if(disposable != null) disposable.dispose();			
		}
	}
	
	@Override
	public void stateChanged(DiagramEditor editor, ChangeType changeType){
		if(changeType == ChangeType.ELEMENTS_ADDED) frame.selectPaletteDefaultElement();
	}
	
	@Override
	public void mouseMoved(EditorMouseEvent event){}
		
	@Override
	public void selectionStateChanged(){}
		
}