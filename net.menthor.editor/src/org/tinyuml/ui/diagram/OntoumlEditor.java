package org.tinyuml.ui.diagram;

/**
 * Copyright 2007 Wei-ju Wu
 *
 * This file is part of TinyUML.
 *
 * TinyUML is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * TinyUML is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with TinyUML; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.window.Window;
import org.tinyuml.draw.Connection;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.DiagramOperations;
import org.tinyuml.draw.DrawingContext.FontType;
import org.tinyuml.draw.Label;
import org.tinyuml.draw.LineStyle;
import org.tinyuml.draw.MoveOperation;
import org.tinyuml.draw.MultiLineLabel;
import org.tinyuml.draw.Node;
import org.tinyuml.draw.NodeChangeListener;
import org.tinyuml.draw.NullElement;
import org.tinyuml.draw.RectilinearConnection;
import org.tinyuml.draw.Scaling;
import org.tinyuml.draw.SimpleConnection;
import org.tinyuml.draw.TreeConnection;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.AssociationElement.ReadingDesign;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.GeneralizationElement;
import org.tinyuml.umldraw.StructureDiagram;
import org.tinyuml.umldraw.shared.UmlConnection;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.Relationship;
import RefOntoUML.Type;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.ui.UmlProject;
import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.commanders.AddCommander;
import net.menthor.editor.v2.commanders.DeleteCommander;
import net.menthor.editor.v2.commanders.MoveCommander;
import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.managers.EditManager;
import net.menthor.editor.v2.managers.FactoryManager;
import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.types.DataType;
import net.menthor.editor.v2.types.RelationshipType;
import net.menthor.editor.v2.ui.app.AppEditorsPane;
import net.menthor.editor.v2.ui.app.AppFrame;
import net.menthor.editor.v2.ui.app.AppMenuBar;
import net.menthor.editor.v2.ui.app.AppPalette;
import net.menthor.editor.v2.ui.app.AppSplitPane;
import net.menthor.editor.v2.ui.app.manager.AppMessageManager;
import net.menthor.editor.v2.ui.color.ColorMap;
import net.menthor.editor.v2.ui.color.ColorType;
import net.menthor.editor.v2.ui.editor.EditorType;
import net.menthor.editor.v2.ui.editor.mode.ClipboardMode;
import net.menthor.editor.v2.ui.editor.mode.ConnectMode;
import net.menthor.editor.v2.ui.editor.mode.EditorMouseEvent;
import net.menthor.editor.v2.ui.editor.mode.IEditorMode;
import net.menthor.editor.v2.ui.generic.GenericEditor;
import net.menthor.editor.v2.ui.menu.PalettePopupMenu;
import net.menthor.editor.v2.ui.notify.ActionType;
import net.menthor.editor.v2.ui.notify.IUndoableCommand;
import net.menthor.editor.v2.ui.notify.Notifier;
import net.menthor.editor.v2.ui.notify.diagram.AddConnectionDiagramCommand;
import net.menthor.editor.v2.ui.notify.diagram.ConnectionTypeDiagramCommand;
import net.menthor.editor.v2.ui.notify.diagram.DeleteElementDiagramCommand;
import net.menthor.editor.v2.ui.notify.diagram.EditPointsDiagramCommand;
import net.menthor.editor.v2.ui.notify.diagram.MoveDiagramCommand;
import net.menthor.editor.v2.ui.notify.diagram.ResetPointsDiagramCommand;
import net.menthor.editor.v2.ui.notify.diagram.ResizeDiagramCommand;
import net.menthor.editor.v2.ui.notify.diagram.RenameLabelDiagramCommand;
import net.menthor.editor.v2.util.DrawUtil;
import net.menthor.editor.v2.util.Util;

/**
 * This class represents the diagram editor. It mainly acts as the
 * component to draw the diagram and to handle the events from the input
 * system. The actual drawing is handled by the UmlDiagram class and its sub
 * allElements.
 *
 * @author Wei-ju Wu, John Guerson
 */

public class OntoumlEditor extends GenericEditor implements ActionListener, MouseListener, MouseWheelListener, MouseMotionListener, DiagramOperations, NodeChangeListener {

	private static final long serialVersionUID = 4210158437374056534L;

	public AppFrame frame;
	public ICommandListener listener;
	private AppEditorsPane diagramManager;
	private OntoumlWrapper wrapper;
	
	private Notifier notificator = Notifier.get();
	private transient IEditorMode editorMode;
	private transient SelectionHandler selectionHandler;
	
	//public Notifier getNotificator(){ return notificator; }
	public IEditorMode getEditorMode(){ return editorMode; }
	public SelectionHandler getSelectionHandler(){ return selectionHandler; }
	
	private transient Scaling scaling = Scaling.SCALING_100;		
	private static final double MARGIN_TOP=0;
	private static final double MARGIN_LEFT=0;
	private static final double MARGIN_RIGHT=0;//AppFrame.GetScreenWorkingWidth();
	private static final double MARGIN_BOTTOM=0;//AppFrame.GetScreenWorkingHeight();
	private static final double ADDSCROLL_HORIZONTAL=0;
	private static final double ADDSCROLL_VERTICAL=0;
		
	
	PalettePopupMenu popupmenu;
	
	// It is nice to report the mapped coordinates to listeners, so it can be used for debug output. 
	
	
	// To edit the captions in the diagram. 
	private CaptionEditor captionEditor = new CaptionEditor(this);
	private MultilineEditor multilineEditor = new MultilineEditor();
	
	// This is the root of the shape hierarchy. 
	private StructureDiagram diagram;
	
	// MouseEvent wrapper
	private transient EditorMouseEvent mouseEvent = new EditorMouseEvent();
	
	// this might be null when the application is started and the pointer still did not move or had the focus of the editor
	private static MouseEvent currentPointerPosition;
	

	public ICommandListener getListener() { return listener; }
	//public DrawingContext getDrawingContext() { return MenthorEditor.getFrame().getDrawingContext(); }
	
	/**
	 * Reset the transient values for serialization.
	 * 
	 * @param stream an ObjectInputStream
	 * @throws IOException if I/O error occured
	 * @throws ClassNotFoundException if class was not found
	 */
	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException 
	{
		initEditorMembers();
	}

	/**
	 * Initializes the transient editor members.
	 */
	private void initEditorMembers() 
	{		
		selectionHandler = new SelectionHandler(this);
		editorMode = selectionHandler;
		mouseEvent = new EditorMouseEvent();
		scaling = Scaling.SCALING_100;
	}
	
	public void setWrapper(OntoumlWrapper wrapper)
	{
		this.wrapper = wrapper;
	}
	
	public OntoumlWrapper getWrapper() { return wrapper; }
	
	/** Empty constructor for testing. Do not use !  */
	public OntoumlEditor() { }

	/**
	 * Constructor. Basic setup of the layout area.
	 * @param frame the frame
	 * @param diagramManager 
	 * @param diagram the diagram
	 */
	public OntoumlEditor(AppFrame frame, ICommandListener listener, AppEditorsPane diagramManager, OntoumlDiagram diagram) 
	{
		this.frame = frame;
		this.listener = listener;
		this.diagramManager = diagramManager;
		this.diagram = (StructureDiagram)diagram;
		this.diagram.addNodeChangeListener(this);
		initEditorMembers();
		
		popupmenu = new PalettePopupMenu(listener);
		
		setToolTipText("Press SPACE to see the elements you may draw");
		
		// Make sure the this component has no layout diagramManager, is opaque and has
		// no double buffer
		setLayout(null);
		setOpaque(true);
		setDoubleBuffered(true);
		
		add(captionEditor);
		add(multilineEditor);		
		captionEditor.getDocument().addUndoableEditListener(notificator.getUndoManager());
		multilineEditor.getDocument().addUndoableEditListener(notificator.getUndoManager());
		this.diagram.setOrigin(MARGIN_LEFT, MARGIN_TOP);

		installHandlers();
		
		double width = this.diagram.getSize().getWidth()+MARGIN_RIGHT + MARGIN_LEFT + ADDSCROLL_HORIZONTAL;
		double height = this.diagram.getSize().getHeight()+MARGIN_BOTTOM + MARGIN_TOP + ADDSCROLL_VERTICAL;		
		setPreferredSize(new Dimension((int)width,(int)height));		
		setSize(new Dimension((int)width,(int)height));		
	}

	public AppEditorsPane getManager() { return diagramManager; }
	public AppEditorsPane getDiagramManager() { return diagramManager; }
	public UmlProject getProject() { return diagram.getProject(); }
		
	public int getScalingPercentual() { return (int)((scaling.getScaleFactor()*100)/100); }

	/**
	 * Adjusts this component's preferredSize attribute to the diagram's size.
	 * This also influences the scroll pane which the component is contained in.
	 */
	private void recalculateSize() 
	{
		double diagramWidth = diagram.getSize().getWidth()*scaling.getScaleFactor();		
		double diagramHeight = diagram.getSize().getHeight()*scaling.getScaleFactor();
		double width = (diagramWidth+MARGIN_RIGHT + MARGIN_LEFT + ADDSCROLL_HORIZONTAL);
		double height = (diagramHeight+MARGIN_BOTTOM + MARGIN_TOP + ADDSCROLL_VERTICAL);
		setPreferredSize(new Dimension((int)width,(int)height));		
		setSize(new Dimension((int)width,(int)height));		
		if(wrapper!=null){
			if(scaling == Scaling.SCALING_50) {
				wrapper.getScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				wrapper.getScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
			}else{
				wrapper.getScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				wrapper.getScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			}
			wrapper.getScrollPane().updateUI();								
		}		
	}

	/** Returns true iff running on Mac OS X. **/
	public static boolean onMac() {
      return System.getProperty("mrj.version")!=null || System.getProperty("os.name").toLowerCase(Locale.US).startsWith("mac ");                                     
	}	
	
	/** Adds the event handlers. */
	private void installHandlers() 
	{
		addMouseListener(this);
		addMouseMotionListener(this);
		addMouseWheelListener(this);
		
		// BaseEditor listeners
		captionEditor.addActionListener(this);
		
		addMouseListener(new MouseAdapter()
	    {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.isPopupTrigger()){
					
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.isPopupTrigger()){
					
				}
			}
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{			
			    if (SwingUtilities.isLeftMouseButton(e))
	            {	            	  
			    	if(e.getClickCount()==2){
			    		if(diagram.getChildAt(e.getX(), e.getY()).equals(NullElement.getInstance()))
			    			openToolBoxPopupMenu();
			    	}	
	            }			    
			}	       
	    });					
				
		// install Space KeyBinding
		getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(' '),"openToolBoxMenu");
		getActionMap().put("openToolBoxMenu", new AbstractAction() {

			private static final long serialVersionUID = 4266982722845577768L;

			/** {@inheritDoc} */
			public void actionPerformed(ActionEvent e) { openToolBoxPopupMenu(); }
		});
		
		// install Escape (ESC) KeyBinding
		getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"),"cancelEditing");
		getActionMap().put("cancelEditing", new AbstractAction() {

			private static final long serialVersionUID = 4266982722845577768L;

			/** {@inheritDoc} */
			public void actionPerformed(ActionEvent e) { cancelEditing(); }
		});

		// install Erase KeyBinding
		if(onMac()){
			getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("BACK_SPACE"),"excludeSelection");
			getActionMap().put("excludeSelection", new AbstractAction() {
						
				private static final long serialVersionUID = -6375878624042384546L;
			
				/** {@inheritDoc} */
				public void actionPerformed(ActionEvent e) { excludeSelection(); }
			});	
		}else{
			getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DELETE"),"excludeSelection");		
			getActionMap().put("excludeSelection", new AbstractAction() {

				private static final long serialVersionUID = -6375878624042384546L;
				
				/** {@inheritDoc} */
				public void actionPerformed(ActionEvent e) { excludeSelection(); }
			});				
		}
				
		if(onMac()){
			getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, ActionEvent.META_MASK),"deleteSelection");
			getActionMap().put("deleteSelection", new AbstractAction() {
						
				private static final long serialVersionUID = -6375878624042384546L;
			
				/** {@inheritDoc} */
				public void actionPerformed(ActionEvent e) { deleteSelection(); }
			});
		}else{
			// install Delete KeyBinding
			getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.CTRL_MASK),"deleteSelection");		
			getActionMap().put("deleteSelection", new AbstractAction() {

				private static final long serialVersionUID = -6375878624042384546L;
				
				/** {@inheritDoc} */
				public void actionPerformed(ActionEvent e) { deleteSelection(); }
			});					
		}
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) 
	{
		if (e.isControlDown())
		{
            if (e.getWheelRotation() < 0)
            {
            	for (int i = 0; i< Math.abs(e.getWheelRotation());i++) {
            		zoomIn();
//            		centeredZoomIn(e.getPoint());
            	}
            }
            if (e.getWheelRotation() > 0)
            {
            	for (int i = 0; i< Math.abs(e.getWheelRotation());i++) {
            		zoomOut();
//            		centeredZoomOut(e.getPoint());
            	}
            }
		}
		else{
			if(e.isShiftDown()){
				if (e.getWheelRotation() < 0) {
					wrapper.getScrollPane().getHorizontalScrollBar().setValue(wrapper.getScrollPane().getHorizontalScrollBar().getValue()-50);
	            }
				else if (e.getWheelRotation() > 0) {
					wrapper.getScrollPane().getHorizontalScrollBar().setValue(wrapper.getScrollPane().getHorizontalScrollBar().getValue()+50);
	            }
			}
			else {
				if (e.getWheelRotation() < 0) {
					wrapper.getScrollPane().getVerticalScrollBar().setValue(wrapper.getScrollPane().getVerticalScrollBar().getValue()-50);
	            }
				else if (e.getWheelRotation() > 0) {
					wrapper.getScrollPane().getVerticalScrollBar().setValue(wrapper.getScrollPane().getVerticalScrollBar().getValue()+50);
	            }
			}
			
		}
	}
	
	/** Cancels the current edit action. */
	public void cancelEditing() 
	{				
		if (captionEditor.isVisible()) 
		{
			captionEditor.hideEditor();
		}
		editorMode.cancel();
		selectionHandler.deselectAll();
		AppPalette.get().getClassPalette().selectMousePointer();
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));		
		redraw();
		requestFocusInEditor();
	}
	
	public List<Generalization> getGeneralizations(List<DiagramElement> diagramElements){
		List<Generalization> gens = new ArrayList<Generalization>();		
		for(DiagramElement dElem: diagramElements){
			if (dElem instanceof GeneralizationElement){
				Generalization gen = ((GeneralizationElement)dElem).getGeneralization();				
				if(gen!=null) gens.add(gen);
			}
		}
		return gens;
	}

	public List<GeneralizationSet> getGeneralizationSets(List<DiagramElement> diagramElements){
		// retain only generalization sets from selected
		List<GeneralizationSet> genSets = new ArrayList<GeneralizationSet>();		
		for(DiagramElement dElem: diagramElements){
			if (dElem instanceof GeneralizationElement){
				Generalization gen = ((GeneralizationElement)dElem).getGeneralization();
				if (gen.getGeneralizationSet()!=null && !gen.getGeneralizationSet().isEmpty()) {
					for(GeneralizationSet gs: gen.getGeneralizationSet()) {
						if (!genSets.contains(gs)) genSets.add(gs);				
					}
				}
			}
		}
		return genSets;
	}
	
	public void select(List<DiagramElement> elements)
	{
		selectionHandler.deselectAll();
		selectionHandler.select(elements);
	}
	
	public void select(DiagramElement element)
	{
		selectionHandler.deselectAll();
		selectionHandler.select(element);
	}
		
	/** Open ToolBox Menu. */
	public void openToolBoxPopupMenu()
	{
		if (currentPointerPosition==null) return;
		int xp = currentPointerPosition.getX();
		int yp = currentPointerPosition.getY();
		if (xp <= diagram.getAbsoluteX1() || xp >= diagram.getAbsoluteX2()) return;
		if (yp < diagram.getAbsoluteY1() || yp > diagram.getAbsoluteY2()) return;				
		DiagramElement elem = diagram.getChildAt(currentPointerPosition.getX(), currentPointerPosition.getY());		
		if (elem instanceof NullElement)
		{
			popupmenu.show(this, (int)currentPointerPosition.getX(), (int) currentPointerPosition.getY());				
		}
	}

	// *************************************************************************
	// ***** Drawing the component
	// *************************************************************************

	/** {@inheritDoc} */
	@Override
	public void paintComponent(Graphics g) 
	{
		Rectangle clipBounds = new Rectangle();
		g.getClipBounds(clipBounds);
		paintComponent(g, clipBounds, true);
	}

	/**
	 * Paints the component into a non-screen Graphics object.
	 * @param g the Graphics object
	 * @param origin 
	 * @param end 
	 */
	public void paintComponentNonScreen(Graphics g) 
	{
		Dimension canvasSize = getTotalCanvasSize();
		Rectangle clipBounds = new Rectangle(0, 0, canvasSize.width,canvasSize.height);
		g.setClip(clipBounds);
		paintComponent(g, clipBounds, false);
	}
	
	/**
	 * Paints this component with a specified bounds object.
	 * @param g the graphics context
	 * @param bounds the bounding rectangle to repaint
	 * @param toScreen true if rendered to screen, false otherwise 
	 */
	private void paintComponent(Graphics g, Rectangle bounds, boolean toScreen) 
	{
		Graphics2D g2d = (Graphics2D) g;
		setRenderingHints(g2d);
		if (scaling.getScaleFactor() != 1.0) 
		{
			g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
		}
		//boolean gridVisible = diagram.isGridVisible();
		Color background = ColorMap.getInstance().getColor(ColorType.MENTHOR_BLUE_LIGHTEST);
		if (toScreen) {
			scaleDiagram(g2d); // Scaling is only interesting if rendering to screen			
		} 
//		else {
//			diagram.setGridVisible(gridVisible);
//			background = Color.WHITE;
//		}
		int width = (int)(diagram.getSize().getWidth()+ MARGIN_RIGHT + MARGIN_RIGHT + ADDSCROLL_HORIZONTAL);
		int height = (int)(diagram.getSize().getHeight() + MARGIN_BOTTOM + MARGIN_TOP + ADDSCROLL_VERTICAL);		
		bounds = new Rectangle((int)width,(int)height);
		clearScreen(g, bounds, background);
		DrawUtil.getDrawingContext().setGraphics2D(g2d, bounds);				
		diagram.draw(DrawUtil.getDrawingContext(), toScreen);
		// Draw user interface specific allElements (e.g. selections)
		if (toScreen) {
			editorMode.draw(DrawUtil.getDrawingContext());
		}
		restoreRenderingHints(g2d);
		//diagram.setGridVisible(gridVisible);
	}

	/** Get the width of the diagram considering the zoom */
	public double getDiagramWidth()
	{
		return diagram.getSize().getWidth()*scaling.getScaleFactor();
	}
	
	/** Get the height of the diagram considering the zoom */
	public double getDiagramHeight()
	{
		return diagram.getSize().getHeight()*scaling.getScaleFactor();		
	}
	
	/**
	 * Sets the rendering hints used in the editor.
	 * @param g2d the Graphics2D object
	 */
	private void setRenderingHints(Graphics2D g2d) 
	{
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}

	/**
	 * Resets the rendering hints used in the editor.
	 * @param g2d the Graphics2D object
	 */
	private void restoreRenderingHints(Graphics2D g2d) 
	{
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_DEFAULT);
		/*
    	if (scaling.getScaleFactor() != 1.0) 
      		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
    	*/
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_DEFAULT);
	}

	/**
	 * Fills the screen with the background color.
	 * @param g the Graphics object
	 * @param bounds the bounds to draw within
	 * @param color the background color
	 */
	private void clearScreen(Graphics g, Rectangle bounds, Color color) 
	{
		g.setColor(color);
		g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
	}

	/**
	 * Scales the diagram.
	 * @param g2d the Graphics2D object
	 */
	private void scaleDiagram(Graphics2D g2d) 
	{
		double scaleFactor = scaling.getScaleFactor();
		g2d.scale(scaleFactor, scaleFactor);		
	}

	// ************************************************************************
	// ***** ActionListener
	// ************************************************************************

	/**
	 * {@inheritDoc}
	 */
	public void actionPerformed(ActionEvent e) 
	{
		stopEditing();
	}

	/**
	 * Stops the editing process if one was active.
	 * @return true if editor was closed, false if nothing happened
	 */
	private boolean stopEditing() 
	{
		BaseTextEditor currentEditor = null;
		if (captionEditor.isVisible()) currentEditor = captionEditor;		
		if (multilineEditor.isVisible()) currentEditor = multilineEditor;
				
		//O problema esta aqui, eh necessario veirificar o modo do editor
		if (currentEditor != null && currentEditor.isVisible()) 
		{			
			String text = currentEditor.getText();
			Label label = currentEditor.getLabel();
			RenameLabelDiagramCommand command = new RenameLabelDiagramCommand(this, label, text);
			execute(command);
			currentEditor.hideEditor();				
//			repaint();
			return true;
		}
		return false;
	}

	// ************************************************************************
	// ***** MouseListener
	// ************************************************************************

	/** {@inheritDoc} */
	public void mousePressed(MouseEvent e) 
	{
		if (!stopEditing()) editorMode.mousePressed(convertMouseEvent(e));		
	}

	/** {@inheritDoc} */
	public void mouseReleased(MouseEvent e) 
	{
		if (!stopEditing()) editorMode.mouseReleased(convertMouseEvent(e));
	}

	/** {@inheritDoc} */
	public void mouseClicked(MouseEvent e) 
	{
		if (!stopEditing()) editorMode.mouseClicked(convertMouseEvent(e));		
	}
	
	// ************************************************************************
	// ***** MouseMotionListener
	// ************************************************************************

	/** {@inheritDoc} */
	public void mouseExited(MouseEvent e) 
	{ 
		EditorMouseEvent evt = convertMouseEvent(e);
		currentPointerPosition = evt.getMouseEvent();
	}

	/** {@inheritDoc} */
	public void mouseEntered(MouseEvent e) 
	{
		EditorMouseEvent evt = convertMouseEvent(e);
		currentPointerPosition = evt.getMouseEvent();
	}

	/** {@inheritDoc} */
	public void mouseMoved(MouseEvent e) 
	{
		EditorMouseEvent evt = convertMouseEvent(e);
		currentPointerPosition = evt.getMouseEvent();		
		editorMode.mouseMoved(evt);
		//notifyCoordinateListeners();		
	}
	
	/** {@inheritDoc} */
	public void mouseDragged(MouseEvent e) 
	{		
		EditorMouseEvent evt = convertMouseEvent(e);
		currentPointerPosition = evt.getMouseEvent();
		editorMode.mouseDragged(evt);
		//notifyCoordinateListeners();
	}

	/**
	 * Notifies the coordinate listeners.
	 * Precondition: Mouse coordinates have been previously transformed.
	 */
//	private void notifyCoordinateListeners() 
//	{
//		for (EditorStateListener l : notificator.getEditorStateListeners()) 
//		{
//			l.mouseMoved(mouseEvent);
//		}
//	}

	/**
	 * Converts the java.awt.MouseEvent into an EditorMouseEvent.
	 * @param e the MouseEvent
	 * @return the converted event
	 */
	private EditorMouseEvent convertMouseEvent(MouseEvent e) 
	{
		mouseEvent.setMouseEvent(e, scaling);
		return mouseEvent;
	}

	// ************************************************************************
	// ***** BaseEditor information
	// ************************************************************************

	/**
	 * Returns the diagram.
	 * @return the diagram
	 */
	public StructureDiagram getDiagram() { return diagram; }

	/**
	 * Returns the canUndo status.
	 * @return true if can undo, false otherwise
	 */
	public boolean canUndo() { return notificator.getUndoManager().canUndo(); }

	/**
	 * Returns the canRedo status.
	 * @return true if can redo, false otherwise
	 */
	public boolean canRedo() { return notificator.getUndoManager().canRedo(); }

	/**
	 * Clears the undo diagramManager.
	 */
	public void clearUndoManager() { notificator.getUndoManager().discardAllEdits(); }

	/**
	 * Returns the current selection.
	 * @return the selected element
	 */
	public List<DiagramElement> getSelectedElements() { return selectionHandler.getSelectedElements(); }

	/**
	 * Returns the total canvas size for export functions. The total size
	 * includes the margins
	 * @return the total canvas size
	 */
	public Dimension getTotalCanvasSize() 
	{		
		Dimension result = new Dimension();	
		result.width = (int) (diagram.getSize().getWidth() + MARGIN_LEFT + MARGIN_RIGHT);
		result.height = (int) (diagram.getSize().getHeight() + MARGIN_TOP + MARGIN_BOTTOM);
		return result;
	}

	public ArrayList<Point> getUsedCanvasSize()
	{
		return getDiagram().getUsedCanvasSize();
	}
	
	// ************************************************************************
	// ***** BaseEditor commands. These are invoked by external clients, the main
	// ***** purpose is to provide the external interface for menu commands
	// ***** and sorts.
	// ************************************************************************

	/**
	 * Rescales the view.
	 * @param aScaling a Scaling object
	 */
	public void setScaling(Scaling aScaling) 
	{
		scaling = aScaling;
		recalculateSize();				
	}
		
	public void fitToWindow()
	{		
		double waste = 20;
		if(AppSplitPane.get().isShowProjectBrowser()) waste+=240;
		if(AppSplitPane.get().isShowPalette()) waste+=240;
		double offx = (Util.getScreenWorkingWidth()-waste)/getUsedCanvasSize().get(1).getX();
		double offy = (Util.getScreenWorkingHeight()-200)/getUsedCanvasSize().get(1).getY();
		double diffx = (getUsedCanvasSize().get(1).getX()-(Util.getScreenWorkingWidth()-waste));
		double diffy = (getUsedCanvasSize().get(1).getY()-(Util.getScreenWorkingHeight()-200));
		if(diffx < 0)diffx=0;
		if(diffy < 0)diffy=0;
		if(diffx > diffy){	
			setScaling(getScaling(offx));			
			wrapper.getToolBar().update(getZoomPercentualValue());
		}else if (diffx < diffy){
			setScaling(getScaling(offy));			
			wrapper.getToolBar().update(getZoomPercentualValue());
		}
	}
	
	public String getZoomPercentualValue()
	{
		return scaling.toString().replace(".0","");
	}
	
	public void zoom100()
	{
		setScaling(Scaling.SCALING_100);	
		wrapper.getToolBar().update(getZoomPercentualValue());
	}
	
	public Scaling getScaling(double value)
	{
		if (value >= 1.50) return Scaling.SCALING_150; 
		else if (value < 1.50 && value >= 1.45) return Scaling.SCALING_145;
		else if (value < 1.45 && value >= 1.40) return Scaling.SCALING_140;
		else if (value < 1.40 && value >= 1.35) return Scaling.SCALING_135;
		else if (value < 1.35 && value >= 1.30) return Scaling.SCALING_130;
		else if (value < 1.30 && value >= 1.25) return Scaling.SCALING_125;
		else if (value < 1.25 && value >= 1.20) return Scaling.SCALING_120;
		else if (value < 1.20 && value >= 1.15) return Scaling.SCALING_115;
		else if (value < 1.15 && value >= 1.10) return Scaling.SCALING_110;
		else if (value < 1.10 && value >= 1.05) return Scaling.SCALING_105;
		else if (value < 1.05 && value >= 1.00) return Scaling.SCALING_100;
		else if (value < 1.00 && value >= 0.95) return Scaling.SCALING_95;
		else if (value < 0.95 && value >= 0.90) return Scaling.SCALING_90;
		else if (value < 0.90 && value >= 0.85) return Scaling.SCALING_85;
		else if (value < 0.85 && value >= 0.80) return Scaling.SCALING_80;
		else if (value < 0.80 && value >= 0.75) return Scaling.SCALING_75;
		else if (value < 0.75 && value >= 0.70) return Scaling.SCALING_70;
		else if (value < 0.70 && value >= 0.65) return Scaling.SCALING_65;
		else if (value < 0.65 && value >= 0.60) return Scaling.SCALING_60;
		else if (value < 0.60 && value >= 0.55) return Scaling.SCALING_55;
		else if (value < 0.55) return Scaling.SCALING_50;
		return Scaling.SCALING_100;
	}
	
	public void zoomOut()
	{			
		if (scaling.equals(Scaling.SCALING_150)) setScaling(Scaling.SCALING_145); 
		else if (scaling.equals(Scaling.SCALING_145)) setScaling(Scaling.SCALING_140);
		else if (scaling.equals(Scaling.SCALING_140)) setScaling(Scaling.SCALING_135);
		else if (scaling.equals(Scaling.SCALING_135)) setScaling(Scaling.SCALING_130);
		else if (scaling.equals(Scaling.SCALING_130)) setScaling(Scaling.SCALING_125);
		else if (scaling.equals(Scaling.SCALING_125)) setScaling(Scaling.SCALING_120);
		else if (scaling.equals(Scaling.SCALING_120)) setScaling(Scaling.SCALING_115);
		else if (scaling.equals(Scaling.SCALING_115)) setScaling(Scaling.SCALING_110);
		else if (scaling.equals(Scaling.SCALING_110)) setScaling(Scaling.SCALING_105);
		else if (scaling.equals(Scaling.SCALING_105)) setScaling(Scaling.SCALING_100);		
		else if (scaling.equals(Scaling.SCALING_100)) setScaling(Scaling.SCALING_95);
		else if (scaling.equals(Scaling.SCALING_95)) setScaling(Scaling.SCALING_90);
		else if (scaling.equals(Scaling.SCALING_90)) setScaling(Scaling.SCALING_85);
		else if (scaling.equals(Scaling.SCALING_85)) setScaling(Scaling.SCALING_80);
		else if (scaling.equals(Scaling.SCALING_80)) setScaling(Scaling.SCALING_75);
		else if (scaling.equals(Scaling.SCALING_75)) setScaling(Scaling.SCALING_70);
		else if (scaling.equals(Scaling.SCALING_70)) setScaling(Scaling.SCALING_65);
		else if (scaling.equals(Scaling.SCALING_65)) setScaling(Scaling.SCALING_60);
		else if (scaling.equals(Scaling.SCALING_60)) setScaling(Scaling.SCALING_55);
		else if (scaling.equals(Scaling.SCALING_55)) setScaling(Scaling.SCALING_50);
		wrapper.getToolBar().update(getZoomPercentualValue());
	}

//	public void centeredZoomOut(Point point) {
//	    zoomOut();
//	    Point pos = wrapper.getScrollPane().getViewport().getViewPosition();
//	    double diff = (scaling.getScaleFactor()-1f);	    
//	    double rest = 1f - diff;
//	    int newX = (int)((point.x*diff)+(rest*pos.x));
//	    int newY = (int)((point.y*diff)+(rest*pos.y));
//	    wrapper.getScrollPane().getViewport().setViewPosition(new Point(newX, newY));
//	    revalidate();
//	    repaint();
//	}
//
//	public void centeredZoomIn(Point point) {
//	    zoomIn();
//	    Point pos = wrapper.getScrollPane().getViewport().getViewPosition();
//	    double diff = (scaling.getScaleFactor()-1f);	    	    
//	    int newX = (int)((point.x*diff)+(scaling.getScaleFactor()*pos.x));
//	    int newY = (int)((point.y*diff)+(scaling.getScaleFactor()*pos.y));
//	    wrapper.getScrollPane().getViewport().setViewPosition(new Point(newX, newY));
//	    revalidate();
//	    repaint();
//	}
	
	public void zoomIn()
	{	
		if (scaling.equals(Scaling.SCALING_50)) setScaling(Scaling.SCALING_55);
		else if (scaling.equals(Scaling.SCALING_55)) setScaling(Scaling.SCALING_60);
		else if (scaling.equals(Scaling.SCALING_60)) setScaling(Scaling.SCALING_65);
		else if (scaling.equals(Scaling.SCALING_65)) setScaling(Scaling.SCALING_70);
		else if (scaling.equals(Scaling.SCALING_70)) setScaling(Scaling.SCALING_75);
		else if (scaling.equals(Scaling.SCALING_75)) setScaling(Scaling.SCALING_80);
		else if (scaling.equals(Scaling.SCALING_80)) setScaling(Scaling.SCALING_85);
		else if (scaling.equals(Scaling.SCALING_85)) setScaling(Scaling.SCALING_90);
		else if (scaling.equals(Scaling.SCALING_90)) setScaling(Scaling.SCALING_95);
		else if (scaling.equals(Scaling.SCALING_95)) setScaling(Scaling.SCALING_100);
		else if (scaling.equals(Scaling.SCALING_100)) setScaling(Scaling.SCALING_105);
		else if (scaling.equals(Scaling.SCALING_105)) setScaling(Scaling.SCALING_110);
		else if (scaling.equals(Scaling.SCALING_110)) setScaling(Scaling.SCALING_115);
		else if (scaling.equals(Scaling.SCALING_115)) setScaling(Scaling.SCALING_120);		
		else if (scaling.equals(Scaling.SCALING_120)) setScaling(Scaling.SCALING_125);
		else if (scaling.equals(Scaling.SCALING_125)) setScaling(Scaling.SCALING_130);
		else if (scaling.equals(Scaling.SCALING_130)) setScaling(Scaling.SCALING_135);
		else if (scaling.equals(Scaling.SCALING_135)) setScaling(Scaling.SCALING_140);
		else if (scaling.equals(Scaling.SCALING_140)) setScaling(Scaling.SCALING_145);
		else if (scaling.equals(Scaling.SCALING_145)) setScaling(Scaling.SCALING_150);	
		wrapper.getToolBar().update(getZoomPercentualValue());
	}
	
	/** Sets the editor into selection mode. */
	public void setSelectionMode() 
	{		
		editorMode = selectionHandler;		
	}

	/**
	 * Switches the editor into creation mode.
	 * @param elementType the ElementType that indicates what to create
	 */
	public void setCreationMode(ClassType elementType) 
	{
		ClipboardMode.get().createAndPutToClipboard(elementType);
		editorMode = ClipboardMode.get();
	}
	
	public void setEditorMode(IEditorMode mode){		
		editorMode = mode;
	}
	
	/**
	 * Switches the editor into creation mode.
	 * @param elementType the ElementType that indicates what to create
	 */
	public void setCreationMode(DataType elementType) 
	{		
		ClipboardMode.get().createAndPutToClipboard(elementType);
		editorMode = ClipboardMode.get();
	}
	
	public void setDragElementMode(RefOntoUML.Type type)
	{		
		ClipboardMode.get().putToClipboard(type, true);
		editorMode = ClipboardMode.get();
	}
	
	/**
	 * Switches the editor into connection creation mode.
	 * @param relationType the RelationType to create
	 */
	public void setCreateConnectionMode(RelationshipType relationType) 
	{	
		ConnectMode.get().setRelationshipType(relationType);
		editorMode = ConnectMode.get();
	}

	public UmlConnection dragRelation(RefOntoUML.Relationship relationship, EObject eContainer)
	{		
		RelationshipType relationType = RelationshipType.valueOf(OntoUMLParser.getStereotype(relationship).toUpperCase());
		ConnectMode.get().setRelationshipType(relationType);
		editorMode = ConnectMode.get();
		RefOntoUML.Type source = null;
		RefOntoUML.Type target = null;
		if(relationship instanceof RefOntoUML.Association){
			RefOntoUML.Association assoc = (RefOntoUML.Association)relationship;
			source = assoc.getMemberEnd().get(0).getType();
			target = assoc.getMemberEnd().get(1).getType();
			if(source==null || target==null) return null; 
		}
		if(relationship instanceof RefOntoUML.Generalization){
			RefOntoUML.Generalization gen = (RefOntoUML.Generalization)relationship;
			target = gen.getGeneral();
			source = gen.getSpecific();
			if(source==null || target==null) return null;		  
		}
		  
		DiagramElement src = OccurenceManager.get().getDiagramElement(source,getDiagram());
		DiagramElement tgt = OccurenceManager.get().getDiagramElement(target,getDiagram());		
		if(src==null || tgt==null) return null;
		
		UmlConnection conn = FactoryManager.get().createVisualConnectionFromModelRelationship(relationship, src, tgt);
		AddConnectionDiagramCommand command = new AddConnectionDiagramCommand(this, conn);
	  	command.run();	    	 
		this.cancelEditing();
		this.redraw();
		return conn;
	}
		  	
	/** Immediate redraw of the view. */
	public void redraw() 
	{
		//paintImmediately(0, 0, getWidth(), getHeight());
		repaint(0, 0, getWidth(), getHeight());
	}
	
	public void showGrid()
	{
		if(isShownGrid()){
			showGrid(false);
			AppMenuBar.get().selectShowGrid(false);
		}else{
			showGrid(true);
			AppMenuBar.get().selectShowGrid(true);
		}
	}

	/**
	 * Sets the grid to visible.
	 * @param flag true for visible grid, false otherwise
	 */
	public void showGrid(Boolean flag) 
	{
		diagram.setGridVisible(flag);		
		updateUI();
		if(wrapper!=null)wrapper.getScrollPane().updateUI();
	}
	
	public boolean isShownGrid()
	{
		return diagram.isGridVisible();
	}
	
	/**
	 * Activates grid snapping.
	 * @param flag true if snapping should be supported, false otherwise
	 */
	public void snapToGrid(boolean flag) 
	{
		diagram.setSnapToGrid(flag);
	}
		
	/** Brings the current selection to the front. */
	public void bringToFront() 
	{
		if (selectionHandler.getSelectedElements().size() > 0) 
		{
			for(DiagramElement de: getSelectedElements()){
				if(!(de instanceof StructureDiagram)) diagram.bringChildToFront(de);				
			}			
			redraw();
		}
	}

	
	
	
	/** Set the background color of the selected elements */
	public void setBackgroundInSelected(Color color)
	{
		for(DiagramElement de: getSelectedElements()){
			if(de instanceof ClassElement){
				ClassElement ce = (ClassElement)de;
				ce.setBackgroundColor(color);
			}
		}
		wrapper.getScrollPane().updateUI();
	}
	
	/** Returns all selected association elements */
	public List<AssociationElement> getSelectedAssociationElements()
	{
		List<AssociationElement> result = new ArrayList<AssociationElement>();
		for(DiagramElement de: selectionHandler.getSelectedElements())
		{
			if(de instanceof AssociationElement){
				result.add((AssociationElement)de);
			}
		}	
		return result;
	}
	
	/** Returns all selected class elements */
	public List<ClassElement>getSelectedClassElements()
	{
		List<ClassElement> result = new ArrayList<ClassElement>();
		for(DiagramElement de: selectionHandler.getSelectedElements())
		{
			if(de instanceof ClassElement){
				result.add((ClassElement)de);
			}
		}	
		return result;
	}
	
	/** Return the center point of these selected elements */
	public Point2D.Double getCenterPointOnSelected(){
		double y = 0; double x = 0;
		List<ClassElement> list = getSelectedClassElements();
		Point2D.Double centerPoint = new Point2D.Double();
		if(list.size()==1) {
			centerPoint.x = list.get(0).getAbsCenterX();
			centerPoint.y = list.get(0).getAbsCenterY();
			return centerPoint;
		}				
		ClassElement top = getClassElementAtTop(list);
		ClassElement right = getClassElementAtRight(list);
		ClassElement left = getClassElementAtLeft(list);
		ClassElement bottom = getClassElementAtBottom(list);
		if(top!=null && bottom !=null) y = top.getAbsCenterY()+((bottom.getAbsCenterY()-top.getAbsCenterY())/2);
		if(left!=null && right !=null) x = right.getAbsCenterX()-((right.getAbsCenterX()-left.getAbsCenterX())/2);
		centerPoint.x = x; 
		centerPoint.y = y;
		return centerPoint;
	}
	
	/** Return the center point of these selected elements */
	public Rectangle2D getSelectedBounds(){
		List<ClassElement> list = getSelectedClassElements();		
		ClassElement top = getClassElementAtTop(list);
		ClassElement right = getClassElementAtRight(list);
		ClassElement left = getClassElementAtLeft(list);
		ClassElement bottom = getClassElementAtBottom(list);
		Rectangle2D bounds = top.getAbsoluteBounds();
		bounds.setRect(left.getAbsoluteX1(), top.getAbsoluteY1(),
			right.getAbsoluteX2() - left.getAbsoluteX1(), 
			bottom.getAbsoluteY2() - top.getAbsoluteY1()
		);		
		return bounds;
	}
	
	/** Return the class element most located at the bottom of the diagram */
	public ClassElement getClassElementAtBottom(List<ClassElement> list){
		double maxY2 = 0;
		ClassElement atBottomElement = null;
		for(DiagramElement de: list){
			if(((ClassElement)de).getAbsoluteY2()>maxY2) {
				maxY2 = ((ClassElement)de).getAbsoluteY2();
				atBottomElement = (ClassElement)de;				
			}
		}
		return atBottomElement;
	}
	
	/** Return the class element most located at the top of the diagram */
	public ClassElement getClassElementAtTop(List<ClassElement> list){
		double maxY1 = getSize().getWidth();
		ClassElement atTopElement = null;
		for(DiagramElement de: list){
			if(((ClassElement)de).getAbsoluteY1()<maxY1) {
				maxY1 = ((ClassElement)de).getAbsoluteY1();
				atTopElement = (ClassElement)de;				
			}
		}
		return atTopElement;
	}
	
	/** Return the class element most located at the left of the diagram */
	public ClassElement getClassElementAtLeft(List<ClassElement> list){
		double maxX1 = getSize().getWidth();
		ClassElement atLeftElement = null;
		for(ClassElement de: list){
			if(((ClassElement)de).getAbsoluteX1()<maxX1) {
				maxX1 = ((ClassElement)de).getAbsoluteX1();
				atLeftElement = (ClassElement)de;				
			}
		}
		return atLeftElement;
	}
	
	/** Return the class element most located at the right of the diagram */
	public ClassElement getClassElementAtRight(List<ClassElement> list){
		double maxX2 = 0;
		ClassElement atRightElement = null;
		for(DiagramElement de: list){
			if(((ClassElement)de).getAbsoluteX2()>maxX2) {
				maxX2 = ((ClassElement)de).getAbsoluteX2();
				atRightElement = (ClassElement)de;				
			}
		}
		return atRightElement;
	}
	
	
	
	
	
	
		
	/** Puts the current selection to the back. */
	public void putToBack() 
	{
		if (getSelectedElements().size() > 0) 
		{
			for(DiagramElement de: getSelectedElements()){
				if(!(de instanceof StructureDiagram)) diagram.putChildToBack(de);				
			}
			redraw();
		}
	}

	public void deselectAll()
	{
		selectionHandler.deselectAll();
	}
	
	public void selectAll()
	{		
		selectionHandler.selectAll();
	}
	
	public void setLineStyle(UmlConnection connection, LineStyle style)
	{
		if(style == LineStyle.RECTILINEAR){
			execute(new ConnectionTypeDiagramCommand(this, connection, new RectilinearConnection(connection)));
		} else if (style == LineStyle.DIRECT) {
			execute(new ConnectionTypeDiagramCommand(this, connection, new SimpleConnection(connection)));
		} else if (style == LineStyle.TREESTYLE_VERTICAL) {
			execute(new ConnectionTypeDiagramCommand(this, connection, new TreeConnection(connection,true)));
		} else if (style == LineStyle.TREESTYLE_HORIZONTAL) {
			execute(new ConnectionTypeDiagramCommand(this, connection, new TreeConnection(connection,false)));
		}
	}

		/**
	 * Runs the specified command by this editor's CommandProcessor, which makes
	 * the operation reversible.
	 * @param command the command to run
	 */
	public void execute(IUndoableCommand command) 
	{		
		// We need to run() after notifying the UndoManager in order to ensure correct menu behaviour
		command.run();
		diagramManager.updateUI();
	}

//	//Notifies the listeners about a state change. 
//	private void notifyStateChanged() 
//	{
//		for (EditorStateListener l : editorListeners) {
//			l.stateChanged(this);
//		}
//	}

	// *************************************************************************
	// ***** BaseEditor callback
	// *********************************

	/**
	 * Adds the specified SelectionListener.
	 * @param l the SelectionListener to add
	 */
	public void addSelectionListener(SelectionListener l) 
	{
		selectionHandler.addSelectionListener(l);
	}

	/**
	 * Adds the specified AppCommandListener.
	 * @param l the AppCommandListener to add
	 */
	public void addAppCommandListener(ICommandListener l) 
	{
		selectionHandler.addAppCommandListener(l);
	}

	// *************************************************************************
	// ***** ModelNotification
	// *************************************************************************
	
	
	
	@Override
	public String toString(){
		return " "+getDiagram().getName();
	}
	
	

	// *************************************************************************
	// ***** Diagram Editor Operations
	// *************************************************************************

	
	
	public void readingDesignToTarget(Object con){
		if (con instanceof AssociationElement) {	
			ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();
			((AssociationElement)con).setReadingDesign(ReadingDesign.DESTINATION);
			list.add((DiagramElement)con);
			notificator.notifyChangeOnView(null, ActionType.DO,list);
		}
	}
	
	public void readingDesignUnspecified(Object con){
		if (con instanceof AssociationElement) {	
			ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();
			((AssociationElement)con).setReadingDesign(ReadingDesign.UNDEFINED);
			list.add((DiagramElement)con);
			notificator.notifyChangeOnView(null,ActionType.DO,list);
		}
	}
		
	public void readingDesignToSource(Object con){
		if (con instanceof AssociationElement) {	
			ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();
			((AssociationElement)con).setReadingDesign(ReadingDesign.SOURCE);
			list.add((DiagramElement)con);
			notificator.notifyChangeOnView(null, ActionType.DO,list);
		}
	}
	
	/** Switches a direct connection into a rectilinear one. */
	public void toRectilinear() {
		for(DiagramElement dElem: getSelectedElements()){
			if(dElem instanceof UmlConnection){
				UmlConnection conn = (UmlConnection) dElem;
				execute(new ConnectionTypeDiagramCommand(this, conn, new RectilinearConnection(conn)));
			}
		}		
		// we can only tell the selection handler to forget about the selection
		selectionHandler.deselectAll();		
	}
	public void toRectilinear(Object dElem) {		
		if(dElem instanceof UmlConnection){
			UmlConnection conn = (UmlConnection) dElem;
			execute(new ConnectionTypeDiagramCommand(this, conn, new RectilinearConnection(conn)));
		}	
		if(dElem instanceof Collection<?>){
			for(Object obj: ((Collection<?>)dElem)){
				if(obj instanceof UmlConnection){
					UmlConnection conn = (UmlConnection) obj;
					execute(new ConnectionTypeDiagramCommand(this, conn, new RectilinearConnection(conn)));
				}
			}
		}
		// we can only tell the selection handler to forget about the selection
		selectionHandler.deselectAll();		
	}

	
	/** Switches a direct connection into a tree vertical one. */
	public void toTreeStyleVertical(){
		for(DiagramElement dElem: getSelectedElements()){
			if(dElem instanceof UmlConnection){
				UmlConnection conn = (UmlConnection) dElem;
				execute(new ConnectionTypeDiagramCommand(this, conn, new TreeConnection(conn,true)));
			}
		}		
		// we can only tell the selection handler to forget about the selection
		selectionHandler.deselectAll();
	}
	public void toTreeStyleVertical(Object dElem){		
		if(dElem instanceof UmlConnection){
			UmlConnection conn = (UmlConnection) dElem;
			execute(new ConnectionTypeDiagramCommand(this, conn, new TreeConnection(conn,true)));
		}	
		if(dElem instanceof Collection<?>){
			for(Object obj: ((Collection<?>)dElem)){
				if(obj instanceof UmlConnection){
					UmlConnection conn = (UmlConnection) obj;
					execute(new ConnectionTypeDiagramCommand(this, conn, new TreeConnection(conn,true)));
				}
			}
		}
		// we can only tell the selection handler to forget about the selection
		selectionHandler.deselectAll();
	}
	
	/** Switches a direct connection into a tree horizontal one. */
	public void toTreeStyleHorizontal(){
		for(DiagramElement dElem: getSelectedElements()){
			if(dElem instanceof UmlConnection){
				UmlConnection conn = (UmlConnection) dElem;
				execute(new ConnectionTypeDiagramCommand(this, conn, new TreeConnection(conn,false)));
			}
		}		
		// we can only tell the selection handler to forget about the selection
		selectionHandler.deselectAll();		
	}
	public void toTreeStyleHorizontal(Object dElem){		
		if(dElem instanceof UmlConnection){
			UmlConnection conn = (UmlConnection) dElem;
			execute(new ConnectionTypeDiagramCommand(this, conn, new TreeConnection(conn,false)));
		}		
		if(dElem instanceof Collection<?>){
			for(Object obj: ((Collection<?>)dElem)){
				if(obj instanceof UmlConnection){
					UmlConnection conn = (UmlConnection) obj;
					execute(new ConnectionTypeDiagramCommand(this, conn, new TreeConnection(conn,false)));
				}
			}
		}
		// we can only tell the selection handler to forget about the selection
		selectionHandler.deselectAll();		
	}
	
	@SuppressWarnings("unchecked")
	public void toDirect(Object dElem){
		if(dElem instanceof UmlConnection){
			UmlConnection conn = (UmlConnection) dElem;
			execute(new ConnectionTypeDiagramCommand(this, conn, new SimpleConnection(conn)));
		}
		if(dElem instanceof List<?>){
			for(Object obj: ((List<Object>)dElem)){
				if(obj instanceof UmlConnection){
					UmlConnection conn = (UmlConnection) obj;
					execute(new ConnectionTypeDiagramCommand(this, conn, new SimpleConnection(conn)));
				}
			}
		}
		selectionHandler.deselectAll();
	}
	
	/** Switches a rectilinear connection to a direct one. */
	public void toDirect(){
		for(DiagramElement dElem: getSelectedElements()){
			if(dElem instanceof UmlConnection){
				UmlConnection conn = (UmlConnection) dElem;
				execute(new ConnectionTypeDiagramCommand(this, conn, new SimpleConnection(conn)));
			}
		}		
		// we can only tell the selection handler to forget about the selection
		selectionHandler.deselectAll();		
	}
	
	/**
	 * Resets the current connection's points.
	 */
	public void resetConnectionPoints(){
		DiagramElement elem = selectionHandler.getSelectedElements().get(0);
		if (elem instanceof Connection) {
			execute(new ResetPointsDiagramCommand(this, (Connection) elem));
		}
	}

	public void resetConnectionPoints(Object elem){
		if (elem instanceof Connection) {
			execute(new ResetPointsDiagramCommand(this, (Connection) elem));
		}
		if(elem instanceof Collection<?>){
			for(Object obj: ((Collection<?>)elem)){
				if(obj instanceof UmlConnection){
					UmlConnection conn = (UmlConnection) obj;
					execute(new ResetPointsDiagramCommand(this, conn));
				}
			}
		}
	}
	
	
	
	/** Bring related elements to diagram */
	public void addAllRelatedElements(Object diagramElement)
	{
		if(diagramElement instanceof Node){
			ClassElement ce = (ClassElement)diagramElement;
			Classifier element = ce.getClassifier();
			double x = ce.getAbsoluteX2()+30;
			double y = ce.getAbsoluteY1()-30;
			int row = 0;
			int column = 0;
			OntoUMLParser refparser = ProjectManager.get().getProject().getRefParser();			
			HashSet<Type> addedTypes = new HashSet<Type>();			
			ArrayList<Relationship> relatedAssociations = new ArrayList<Relationship>();
			relatedAssociations.addAll(refparser.getDirectAssociations(element));
			relatedAssociations.addAll(refparser.getDirectGeneralizations(element));		
			for(Relationship rel: relatedAssociations){
				try{
					if(getDiagram().containsChild(rel)) continue;					
					Classifier source = null, target = null;					
					if(rel instanceof Association){
						source = (Classifier)((Association)rel).getMemberEnd().get(0).getType();
						target = (Classifier)((Association)rel).getMemberEnd().get(1).getType();
						addedTypes.add((Association)rel);
					}					
					if(rel instanceof Generalization){
						source = (Classifier)((Generalization)rel).getGeneral();
						target = (Classifier)((Generalization)rel).getSpecific();
					}					
					if(source!=null && !getDiagram().containsChild(source)) { 
						MoveCommander.get().move(source,x+100*column,y+75*row,this,false); 
						row++; 						
						if(row>2) {
							row=0; column++;
						} 
						addedTypes.add(source);
					}						
					if(target!=null && !getDiagram().containsChild(target)) {  
						MoveCommander.get().move(target,x+100*column,y+75*row,this,false); 
						row++;						
						if(row>2) {
							row=0; 
							column++;
						}
						addedTypes.add(target);
					}					
					if(getDiagram().containsChild(source) && getDiagram().containsChild(target)) 
						MoveCommander.get().move(rel, -1, -1, this, false);					
				}catch(Exception e){					
					AppMessageManager.get().showError(e, "Related Elements", "Could not add all related elements.");
				}
			}			
			HashSet<Type> typesInDiagram = new HashSet<Type>();
			for (DiagramElement de : getDiagram().getChildren()) {
				if(de instanceof ClassElement)
					typesInDiagram.add(((ClassElement) de).getClassifier());
			}			
			for (Association a : refparser.getAssociationsBetween(typesInDiagram)) {
				Type source = a.getMemberEnd().get(0).getType();
				Type target = a.getMemberEnd().get(1).getType();				
				if(!getDiagram().containsChild(a) && (addedTypes.contains(source) || addedTypes.contains(target)))
					MoveCommander.get().move(a, -1, -1,this, false);
			}			
			for (Generalization g : refparser.getGeneralizationsBetween(typesInDiagram)) {
				RefOntoUML.Type specific = g.getSpecific();
				RefOntoUML.Type general = g.getGeneral();			
				if(!getDiagram().containsChild(g) && (addedTypes.contains(specific) || addedTypes.contains(general)))
					MoveCommander.get().move(g,-1,-1,this, false);
			}			
		}
	}

	@SuppressWarnings("unchecked")
	public void deleteSelection(Object element){
		if(element instanceof DiagramElement){
			DiagramElement ce = ((DiagramElement)element);
			List<DiagramElement> list = new ArrayList<DiagramElement>();
			list.add(ce);
			DeleteCommander.get().deleteElements(list,true);
		}else if (element instanceof Collection<?>){
			DeleteCommander.get().deleteElements((List<DiagramElement>)element,true);
		}else{
			DeleteCommander.get().delete(element);
		}
	}
	
	/**
	 * Removes the elements selected. From the diagram and the model.
	 */
	public void deleteSelection() {
				
		if(this.isFocusable()){
			List<DiagramElement> diagramElementsList = getSelectedElements();
			DeleteCommander.get().deleteElements(diagramElementsList,true);
		}
	}
	
	/** Removes the elements selected only from the diagram  */
	@SuppressWarnings("unchecked")
	public void excludeSelection(Object element){
		if(element instanceof DiagramElement){
			DiagramElement ce = ((DiagramElement)element);
			List<DiagramElement> list = new ArrayList<DiagramElement>();
			list.add(ce);
			excludeSelection(list);
		}else if (element instanceof Collection<?>){			
			excludeSelection((List<DiagramElement>)element);			
		}
	}
	
	/** Removes the elements selected only from the diagram  */
	public void excludeSelection(List<DiagramElement> diagramElementsList){
		//no diagram in the list...
		List<DiagramElement> diagrams=new ArrayList<DiagramElement>();
		for(DiagramElement de: diagramElementsList) if(de instanceof StructureDiagram) diagrams.add(de);
		diagramElementsList.removeAll(diagrams);
		if(diagramElementsList.size()>0){
			
			int response = JOptionPane.showConfirmDialog(frame, "WARNING: Are you sure you want to delete the element(s) from the diagram?\n If so, note that the element(s) will still exist in the project browser. \nYou can still move the element back to the diagram again.\n", "Delete from Diagram", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null);
			if(response==Window.OK)
			{
				execute(new DeleteElementDiagramCommand(this, OccurenceManager.get().getElements(diagramElementsList), true));
			}
		}
	}
	
	/** Removes the elements selected only from the diagram  */
	public void excludeSelection() 
	{
		if(this.isFocusable()){
			Collection<DiagramElement> diagramElementsList = getSelectedElements();
			excludeSelection(diagramElementsList);
		}
	}

	/** Edits the current selection's properties. */
	public void editProperties(){
		if (getSelectedElements().size() > 0) EditManager.get().edit(getSelectedElements().get(0));		
	}
	
	
	

	/** Create a generalizations from selected elements in the diagram */
	public void addGeneralizationSet(ArrayList<DiagramElement> genElems){
		GeneralizationSet genSet = AddCommander.get().addGeneralizationSet(this,(List<DiagramElement>)genElems);		
		if(genSet!=null){		
			deselectAll();
			cancelEditing();
			EditManager.get().callGeneralizationSetDialog(genSet,true);
			deselectAll();
			cancelEditing();
		}	
	}
			
	/** Delete generalization Set from selected elements in the diagram */
	public void deleteGeneralizationSet(){
		Collection<DiagramElement> diagramElementsList = getSelectedElements();
		deleteGeneralizationSet(diagramElementsList);
	}
	
	@SuppressWarnings("unchecked")
	public void deleteGeneralizationSet(Object genElems){
		if(genElems instanceof Collection<?>){
			DeleteCommander.get().deleteGeneralizationSet(this,(List<DiagramElement>)genElems);		
			deselectAll();
			cancelEditing();	
		}
	}
	
	
	//============================================================
	
	/** {@inheritDoc} */
	public void moveElements(MoveOperation[] moveOperations) 
	{		
		MoveDiagramCommand cmd = new MoveDiagramCommand(this, moveOperations);
		execute(cmd);		
	}

	/** {@inheritDoc} */
	public void setNewConnectionPoints(Connection conn, List<Point2D> points) 
	{
		execute(new EditPointsDiagramCommand(this, conn, points));
	}

	/** {@inheritDoc} */
	public void resizeElement(Node element, Point2D newpos, Dimension2D size) 
	{
		ResizeDiagramCommand cmd = new ResizeDiagramCommand(this, element, newpos, size);
		execute(cmd);
	}

	/**
	 * Open an editor for the specified Label object.
	 * @param label the Label object
	 */
	public void editLabel(Label label) 
	{
		if (label != null) 
		{
			if (label instanceof MultiLineLabel) 
			{
				multilineEditor.setFont(DrawUtil.getDrawingContext().getFont(FontType.DEFAULT));
				multilineEditor.showEditor(label, getGraphics());
			} else {
				captionEditor.showEditor(label, getGraphics());				
			}			
		}
		
	}

	/*** {@inheritDoc} */
	public void nodeResized(Node node) { recalculateSize(); }
	/** {@inheritDoc} */
	public void nodeMoved(Node node) { }
	
	public void requestFocusInEditor() { diagramManager.requestFocus(); }

	/** {@inheritDoc} */
	public EditorType getEditorType() {	return EditorType.ONTOUML_EDITOR; }

	/** {@inheritDoc} */
	@Override
	public boolean isSaveNeeded() { return diagram.isSaveNeeded(); }

	@Override
	public void propagateNewTitle(String title) { diagram.setName(title); }
	
	@Override
	public void dispose() { }

}

