

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
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

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
import org.tinyuml.draw.SimpleLabel;
import org.tinyuml.draw.TreeConnection;
import org.tinyuml.ui.diagram.commands.AddConnectionCommand;
import org.tinyuml.ui.diagram.commands.Command;
import org.tinyuml.ui.diagram.commands.ConvertConnectionTypeCommand;
import org.tinyuml.ui.diagram.commands.DeleteElementCommand;
import org.tinyuml.ui.diagram.commands.DiagramNotification;
import org.tinyuml.ui.diagram.commands.EditConnectionPointsCommand;
import org.tinyuml.ui.diagram.commands.MoveElementCommand;
import org.tinyuml.ui.diagram.commands.ResetConnectionPointsCommand;
import org.tinyuml.ui.diagram.commands.ResizeElementCommand;
import org.tinyuml.ui.diagram.commands.SetColorCommand;
import org.tinyuml.ui.diagram.commands.SetLabelTextCommand;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.AssociationElement.ReadingDesign;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.GeneralizationElement;
import org.tinyuml.umldraw.StructureDiagram;
import org.tinyuml.umldraw.shared.BaseConnection;
import org.tinyuml.umldraw.shared.UmlConnection;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.Relationship;
import RefOntoUML.Type;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.ui.UmlProject;
import net.menthor.editor.v2.MenthorEditor;
import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.managers.AdditionManager;
import net.menthor.editor.v2.managers.ClipboardManager;
import net.menthor.editor.v2.managers.ConnectManager;
import net.menthor.editor.v2.managers.DeletionManager;
import net.menthor.editor.v2.managers.EditManager;
import net.menthor.editor.v2.managers.FactoryManager;
import net.menthor.editor.v2.managers.MessageManager;
import net.menthor.editor.v2.managers.MoveManager;
import net.menthor.editor.v2.managers.OccurenceManager;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.types.ClassType;
import net.menthor.editor.v2.types.DataType;
import net.menthor.editor.v2.types.RelationshipType;
import net.menthor.editor.v2.ui.app.AppEditorTabbedPane;
import net.menthor.editor.v2.ui.app.AppFrame;
import net.menthor.editor.v2.ui.color.ColorMap;
import net.menthor.editor.v2.ui.color.ColorType;
import net.menthor.editor.v2.ui.editor.EditorMouseEvent;
import net.menthor.editor.v2.ui.editor.EditorType;
import net.menthor.editor.v2.ui.editor.IEditorMode;
import net.menthor.editor.v2.ui.generic.GenericEditor;
import net.menthor.editor.v2.ui.menu.PalettePopupMenu;
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

public class DiagramEditor extends GenericEditor implements ActionListener, MouseListener, MouseWheelListener, MouseMotionListener, DiagramNotification, DiagramOperations, NodeChangeListener {

	private static final long serialVersionUID = 4210158437374056534L;

	public AppFrame frame;
	public ICommandListener listener;
	private AppEditorTabbedPane diagramManager;
	private DiagramEditorWrapper wrapper;
		
	private transient IEditorMode editorMode;
	private transient SelectionHandler selectionHandler;
	public transient List<UndoableEditListener> editListeners = new ArrayList<UndoableEditListener>();
	private transient Scaling scaling = Scaling.SCALING_100;		
	private static final double MARGIN_TOP=0;
	private static final double MARGIN_LEFT=0;
	private static final double MARGIN_RIGHT=0;//AppFrame.GetScreenWorkingWidth();
	private static final double MARGIN_BOTTOM=0;//AppFrame.GetScreenWorkingHeight();
	private static final double ADDSCROLL_HORIZONTAL=0;
	private static final double ADDSCROLL_VERTICAL=0;
		
	private Color color;
	
	PalettePopupMenu popupmenu;
	
	// It is nice to report the mapped coordinates to listeners, so it can be used for debug output. 
	private List<EditorStateListener> editorListeners = new ArrayList<EditorStateListener>();
	
	// To edit the captions in the diagram. 
	private CaptionEditor captionEditor = new CaptionEditor(this);
	private MultilineEditor multilineEditor = new MultilineEditor();
	
	// This is the root of the shape hierarchy. 
	private StructureDiagram diagram;
	
	// MouseEvent wrapper
	private transient EditorMouseEvent mouseEvent = new EditorMouseEvent();
	
	// this might be null when the application is started and the pointer still did not move or had the focus of the editor
	private static MouseEvent currentPointerPosition;
	
	// The command processor to hold this diagram's operations.
	private UndoManager undoManager = new UndoManager();
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
	
	public void setWrapper(DiagramEditorWrapper wrapper)
	{
		this.wrapper = wrapper;
	}
	
	public DiagramEditorWrapper getWrapper() { return wrapper; }
	
	/** Empty constructor for testing. Do not use !  */
	public DiagramEditor() { }

	/**
	 * Constructor. Basic setup of the layout area.
	 * @param frame the frame
	 * @param diagramManager 
	 * @param diagram the diagram
	 */
	public DiagramEditor(AppFrame frame, ICommandListener listener, AppEditorTabbedPane diagramManager, OntoumlDiagram diagram) 
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
		editListeners.add(undoManager);
		captionEditor.getDocument().addUndoableEditListener(undoManager);
		multilineEditor.getDocument().addUndoableEditListener(undoManager);
		this.diagram.setOrigin(MARGIN_LEFT, MARGIN_TOP);

		installHandlers();
		
		double width = this.diagram.getSize().getWidth()+MARGIN_RIGHT + MARGIN_LEFT + ADDSCROLL_HORIZONTAL;
		double height = this.diagram.getSize().getHeight()+MARGIN_BOTTOM + MARGIN_TOP + ADDSCROLL_VERTICAL;		
		setPreferredSize(new Dimension((int)width,(int)height));		
		setSize(new Dimension((int)width,(int)height));		
	}

	public AppEditorTabbedPane getManager() { return diagramManager; }
	public AppEditorTabbedPane getDiagramManager() { return diagramManager; }
	public UmlProject getProject() { return diagram.getProject(); }
	public void addEditorStateListener(EditorStateListener l) { editorListeners.add(l); }	
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
		}else{	
			if (e.getWheelRotation() < 0)
            {
				wrapper.getScrollPane().getVerticalScrollBar().setValue(wrapper.getScrollPane().getVerticalScrollBar().getValue()-50);
            }
			if (e.getWheelRotation() > 0)
            {
				wrapper.getScrollPane().getVerticalScrollBar().setValue(wrapper.getScrollPane().getVerticalScrollBar().getValue()+50);
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
		frame.getPallete().getClassPalette().selectMousePointer();
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
			SetLabelTextCommand command = new SetLabelTextCommand(this, label, text);
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
		notifyCoordinateListeners();		
	}
	
	/** {@inheritDoc} */
	public void mouseDragged(MouseEvent e) 
	{		
		EditorMouseEvent evt = convertMouseEvent(e);
		currentPointerPosition = evt.getMouseEvent();
		editorMode.mouseDragged(evt);
		notifyCoordinateListeners();
	}

	/**
	 * Notifies the coordinate listeners.
	 * Precondition: Mouse coordinates have been previously transformed.
	 */
	private void notifyCoordinateListeners() 
	{
		for (EditorStateListener l : editorListeners) 
		{
			l.mouseMoved(mouseEvent);
		}
	}

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
	public boolean canUndo() { return undoManager.canUndo(); }

	/**
	 * Returns the canRedo status.
	 * @return true if can redo, false otherwise
	 */
	public boolean canRedo() { return undoManager.canRedo(); }

	/**
	 * Clears the undo diagramManager.
	 */
	public void clearUndoManager() { undoManager.discardAllEdits(); }

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

	/** Undoes the last operation. */
	public void undo() { 
		if (canUndo()) undoManager.undo(); else{
			MessageManager.get().showInfo(this, "Cannot Undo", "No other action to be undone.\n\n");
		}
	}

	/** Redoes the last operation. */
	public void redo() {
		if (canRedo()) undoManager.redo(); else {
			MessageManager.get().showInfo(this,"Cannot Redo", "No other action to be redone.\n\n");
		}
	}

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
		if(frame.getSplitPane().isShowProjectBrowser()) waste+=240;
		if(frame.getSplitPane().isShowPalette()) waste+=240;
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
		ClipboardManager.get().createAndPutToClipboard(elementType);
		editorMode = ClipboardManager.get();
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
		ClipboardManager.get().createAndPutToClipboard(elementType);
		editorMode = ClipboardManager.get();
	}
	
	public void setDragElementMode(RefOntoUML.Type type)
	{		
		ClipboardManager.get().putToClipboard(type, true);
		editorMode = ClipboardManager.get();
	}
	
	/**
	 * Switches the editor into connection creation mode.
	 * @param relationType the RelationType to create
	 */
	public void setCreateConnectionMode(RelationshipType relationType) 
	{	
		ConnectManager.get().setRelationshipType(relationType);
		editorMode = ConnectManager.get();
	}

	public UmlConnection dragRelation(RefOntoUML.Relationship relationship, EObject eContainer)
	{		
		RelationshipType relationType = RelationshipType.valueOf(OntoUMLParser.getStereotype(relationship).toUpperCase());
		ConnectManager.get().setRelationshipType(relationType);
		editorMode = ConnectManager.get();
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
		AddConnectionCommand command = new AddConnectionCommand(this, conn);
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
			frame.getMenu().selectShowGrid(false);
		}else{
			showGrid(true);
			frame.getMenu().selectShowGrid(true);
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
			execute(new ConvertConnectionTypeCommand(this, connection, new RectilinearConnection(connection)));
		} else if (style == LineStyle.DIRECT) {
			execute(new ConvertConnectionTypeCommand(this, connection, new SimpleConnection(connection)));
		} else if (style == LineStyle.TREESTYLE_VERTICAL) {
			execute(new ConvertConnectionTypeCommand(this, connection, new TreeConnection(connection,true)));
		} else if (style == LineStyle.TREESTYLE_HORIZONTAL) {
			execute(new ConvertConnectionTypeCommand(this, connection, new TreeConnection(connection,false)));
		}
	}

		/**
	 * Runs the specified command by this editor's CommandProcessor, which makes
	 * the operation reversible.
	 * @param command the command to run
	 */
	public void execute(Command command) 
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

	public void notifyChange(List<DiagramElement> elements, ChangeType changeType, NotificationType notificationType)
	{
		editorMode.stateChanged();
		for (EditorStateListener l : editorListeners) 
		{
			l.stateChanged(this, changeType);
		}
		
		if(wrapper!=null) wrapper.getScrollPane().updateUI();
		
		if(changeType == ChangeType.ELEMENTS_REMOVED || (changeType == ChangeType.ELEMENTS_ADDED && notificationType == NotificationType.UNDO))
		{
			selectionHandler.elementRemoved(elements);
		}
		//In case of the three commands  
		if(changeType == ChangeType.ELEMENTS_ADDED || changeType == ChangeType.ELEMENTS_REMOVED || changeType == ChangeType.LABEL_TEXT_SET || changeType == ChangeType.CONNECTION_NAVEGABILITY_SET 
		|| changeType == ChangeType.ELEMENTS_MOVED || changeType == ChangeType.ELEMENTS_DRAGGED || changeType == ChangeType.ELEMENTS_MODIFIED || changeType == ChangeType.ELEMENTS_ALIGNED
		|| changeType == ChangeType.ELEMENTS_COLORED || changeType == ChangeType.VISIBILITY_CHANGED)				 
		{
			ProjectManager.get().getProject().saveDiagramNeeded(this.getDiagram(),true);	
		}
		
		showStatus(elements, changeType, notificationType);
	}

	private void showStatus(List<DiagramElement> elements, ChangeType commandType, NotificationType notificationType)
	{
		StringBuilder sb = new StringBuilder();
		if(notificationType == NotificationType.UNDO) sb.append("undo");
		else if (notificationType == NotificationType.REDO) sb.append("redo");
		switch (commandType) {
			case ELEMENTS_ADDED: 
				if(notificationType == NotificationType.DO) sb.append("added"); else sb.append(" add");
				break;
			case ELEMENTS_REMOVED:
				if(notificationType == NotificationType.DO) sb.append("deleted"); else sb.append(" delete");
				break;
			case ELEMENTS_DRAGGED:
				if(notificationType == NotificationType.DO) sb.append("dragged"); else sb.append(" drag");
				break;
			case ELEMENTS_COLORED:
				if(notificationType == NotificationType.DO) sb.append("colored"); else sb.append(" color");
				break;
			case ELEMENTS_ALIGNED:
				if(notificationType == NotificationType.DO) sb.append("aligned"); else sb.append(" align");
				break;
			case VISIBILITY_CHANGED:
				if(notificationType == NotificationType.DO) sb.append("visibility changed"); else sb.append(" change visibility");
				break;
			case ELEMENTS_MOVED:
				if(notificationType == NotificationType.DO) sb.append("moved"); else sb.append(" move");
				break;
			case ELEMENTS_MODIFIED:
				if(notificationType == NotificationType.DO) sb.append("modified"); else sb.append(" modify");
				break;
			case ELEMENTS_RESIZED:
				if(notificationType == NotificationType.DO) sb.append("resized"); else sb.append(" resize");
				break;
			case CONNECTION_NAVEGABILITY_SET:
				if(notificationType == NotificationType.DO) sb.append("navegability set"); else sb.append(" set navegability");
				break;
			case CONNECTION_TYPE_CONVERTED:
				if(notificationType == NotificationType.DO) sb.append("connnection type converted"); else sb.append(" convert connnection type");
				break;
			case CONNECTION_POINT_EDITED:
				if(notificationType == NotificationType.DO) sb.append("connection point edited"); else sb.append(" edit connnection point");
				break;
			case CONNECTION_POINTS_RESET:
				if(notificationType == NotificationType.DO) sb.append("connection points reset"); else sb.append(" reset connection points");
				break;
			case LABEL_TEXT_SET:
				if(notificationType == NotificationType.DO) sb.append("label text set"); else sb.append(" set label text");
				break;
			default:
				break;	
		}
		if(elements.size()>0) sb.append(": "); else sb.append("...");
		for (int i = 0; i < elements.size(); i++) 
		{
			DiagramElement element = elements.get(i);			
			if(element instanceof ClassElement) sb.append(((ClassElement)element).getClassifier() + (i < elements.size()-1 ? ", " : ""));
			if(element instanceof BaseConnection) sb.append(((BaseConnection)element).getRelationship() + (i < elements.size()-1 ? ", " : ""));			
//			if(element instanceof RectilinearConnection) sb.append(ModelHelper.handleName(((RectilinearConnection)element).getOwnerConnection()) + (i < elements.size()-1 ? ", " : ""));
//			if(element instanceof SimpleConnection) sb.append(ModelHelper.handleName(((SimpleConnection)element).getOwnerConnection()) + (i < elements.size()-1 ? ", " : ""));
//			if(element instanceof TreeConnection) sb.append(ModelHelper.handleName(((TreeConnection)element).getOwnerConnection()) + (i < elements.size()-1 ? ", " : ""));
			if (element instanceof SimpleLabel) sb.append(((Label) element).getSource().getLabelText());			
		}
		getWrapper().getStatusBar().report(capitalize(sb.toString()));
	}

	@Override
	public String toString(){
		return " "+getDiagram().getName();
	}
	
	private String capitalize(String s) 
	{
		if (s.length() == 0) return s;
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}

	// *************************************************************************
	// ***** Diagram Editor Operations
	// *************************************************************************

	
	
	public void readingDesignToTarget(Object con){
		if (con instanceof AssociationElement) {	
			ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();
			((AssociationElement)con).setReadingDesign(ReadingDesign.DESTINATION);
			list.add((DiagramElement)con);
			notifyChange(list, ChangeType.ELEMENTS_MODIFIED, NotificationType.DO);
		}
	}
	
	public void readingDesignUnspecified(Object con){
		if (con instanceof AssociationElement) {	
			ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();
			((AssociationElement)con).setReadingDesign(ReadingDesign.UNDEFINED);
			list.add((DiagramElement)con);
			notifyChange(list, ChangeType.ELEMENTS_MODIFIED, NotificationType.DO);
		}
	}
		
	public void readingDesignToSource(Object con){
		if (con instanceof AssociationElement) {	
			ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();
			((AssociationElement)con).setReadingDesign(ReadingDesign.SOURCE);
			list.add((DiagramElement)con);
			notifyChange(list, ChangeType.ELEMENTS_MODIFIED, NotificationType.DO);
		}
	}
	
	/** Switches a direct connection into a rectilinear one. */
	public void toRectilinear() {
		for(DiagramElement dElem: getSelectedElements()){
			if(dElem instanceof UmlConnection){
				UmlConnection conn = (UmlConnection) dElem;
				execute(new ConvertConnectionTypeCommand(this, conn, new RectilinearConnection(conn)));
			}
		}		
		// we can only tell the selection handler to forget about the selection
		selectionHandler.deselectAll();		
	}
	public void toRectilinear(Object dElem) {		
		if(dElem instanceof UmlConnection){
			UmlConnection conn = (UmlConnection) dElem;
			execute(new ConvertConnectionTypeCommand(this, conn, new RectilinearConnection(conn)));
		}	
		if(dElem instanceof Collection<?>){
			for(Object obj: ((Collection<?>)dElem)){
				if(obj instanceof UmlConnection){
					UmlConnection conn = (UmlConnection) obj;
					execute(new ConvertConnectionTypeCommand(this, conn, new RectilinearConnection(conn)));
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
				execute(new ConvertConnectionTypeCommand(this, conn, new TreeConnection(conn,true)));
			}
		}		
		// we can only tell the selection handler to forget about the selection
		selectionHandler.deselectAll();
	}
	public void toTreeStyleVertical(Object dElem){		
		if(dElem instanceof UmlConnection){
			UmlConnection conn = (UmlConnection) dElem;
			execute(new ConvertConnectionTypeCommand(this, conn, new TreeConnection(conn,true)));
		}	
		if(dElem instanceof Collection<?>){
			for(Object obj: ((Collection<?>)dElem)){
				if(obj instanceof UmlConnection){
					UmlConnection conn = (UmlConnection) obj;
					execute(new ConvertConnectionTypeCommand(this, conn, new TreeConnection(conn,true)));
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
				execute(new ConvertConnectionTypeCommand(this, conn, new TreeConnection(conn,false)));
			}
		}		
		// we can only tell the selection handler to forget about the selection
		selectionHandler.deselectAll();		
	}
	public void toTreeStyleHorizontal(Object dElem){		
		if(dElem instanceof UmlConnection){
			UmlConnection conn = (UmlConnection) dElem;
			execute(new ConvertConnectionTypeCommand(this, conn, new TreeConnection(conn,false)));
		}		
		if(dElem instanceof Collection<?>){
			for(Object obj: ((Collection<?>)dElem)){
				if(obj instanceof UmlConnection){
					UmlConnection conn = (UmlConnection) obj;
					execute(new ConvertConnectionTypeCommand(this, conn, new TreeConnection(conn,false)));
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
			execute(new ConvertConnectionTypeCommand(this, conn, new SimpleConnection(conn)));
		}
		if(dElem instanceof List<?>){
			for(Object obj: ((List<Object>)dElem)){
				if(obj instanceof UmlConnection){
					UmlConnection conn = (UmlConnection) obj;
					execute(new ConvertConnectionTypeCommand(this, conn, new SimpleConnection(conn)));
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
				execute(new ConvertConnectionTypeCommand(this, conn, new SimpleConnection(conn)));
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
			execute(new ResetConnectionPointsCommand(this, (Connection) elem));
		}
	}

	public void resetConnectionPoints(Object elem){
		if (elem instanceof Connection) {
			execute(new ResetConnectionPointsCommand(this, (Connection) elem));
		}
		if(elem instanceof Collection<?>){
			for(Object obj: ((Collection<?>)elem)){
				if(obj instanceof UmlConnection){
					UmlConnection conn = (UmlConnection) obj;
					execute(new ResetConnectionPointsCommand(this, conn));
				}
			}
		}
	}
	
	private Color copiedColor=Color.WHITE;
	
	public void copyColor(Object obj){
		if(obj instanceof ClassElement){
			copiedColor = ((ClassElement)obj).getBackgroundColor();	
		}else if(obj instanceof Collection<?>){			
			for(Object o: ((Collection<?>)obj)){
				if(o instanceof ClassElement){
					copiedColor = ((ClassElement)o).getBackgroundColor();
					return;
				}
			}			
		}			
	}
	
	public void pasteColor(List<DiagramElement> classElements){
		if (copiedColor != null){
			execute(new SetColorCommand((DiagramNotification)this,classElements,copiedColor));        			
		}
	}
	
	public void pasteColor(Object obj){
		if(obj instanceof ClassElement){
			ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();
			list.add((DiagramElement)obj);		
			pasteColor(list);			
		}else if(obj instanceof Collection<?>){
			List<DiagramElement> list = new ArrayList<DiagramElement>();
			for(Object o: ((Collection<?>)obj)){
				if(o instanceof ClassElement){
					list.add((DiagramElement)o);
				}
			}
			pasteColor(list);
		}		
	}
	
	public void setupColorOnSelected()
	{
		if(color==null) color = JColorChooser.showDialog(MenthorEditor.getFrame(), "Select a Background Color", Color.LIGHT_GRAY);
		else color = JColorChooser.showDialog(MenthorEditor.getFrame(), "Select a Background Color", color);
		if (color != null){
			execute(new SetColorCommand((DiagramNotification)this,(ArrayList<DiagramElement>) getSelectedElements(),color));        			
		}        		   
	}
	
	
	
	public void setupColor(List<DiagramElement> classList){		
		if(color==null) color = JColorChooser.showDialog(MenthorEditor.getFrame(), "Select a background color", Color.LIGHT_GRAY);
		else color = JColorChooser.showDialog(MenthorEditor.getFrame(), "Select a background color", color);
		if (color != null){
			execute(new SetColorCommand((DiagramNotification)this,classList,color));        			
		}
	}
	
	public void setupColor(Object obj)
	{
		if(obj instanceof ClassElement){
			List<DiagramElement> list = new ArrayList<DiagramElement>();
			list.add((DiagramElement)obj);
			setupColor(list);
		}else if(obj instanceof Collection<?>){
			List<DiagramElement> list = new ArrayList<DiagramElement>();
			for(Object o: ((Collection<?>)obj)){
				if(o instanceof ClassElement){
					list.add((DiagramElement)o);
				}
			}
			setupColor(list);
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
						MoveManager.get().move(source,x+100*column,y+75*row,this,false); 
						row++; 						
						if(row>2) {
							row=0; column++;
						} 
						addedTypes.add(source);
					}						
					if(target!=null && !getDiagram().containsChild(target)) {  
						MoveManager.get().move(target,x+100*column,y+75*row,this,false); 
						row++;						
						if(row>2) {
							row=0; 
							column++;
						}
						addedTypes.add(target);
					}					
					if(getDiagram().containsChild(source) && getDiagram().containsChild(target)) 
						MoveManager.get().move(rel, -1, -1, this, false);					
				}catch(Exception e){					
					MessageManager.get().showError(e, "Related Elements", "Could not add all related elements.");
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
					MoveManager.get().move(a, -1, -1,this, false);
			}			
			for (Generalization g : refparser.getGeneralizationsBetween(typesInDiagram)) {
				RefOntoUML.Type specific = g.getSpecific();
				RefOntoUML.Type general = g.getGeneral();			
				if(!getDiagram().containsChild(g) && (addedTypes.contains(specific) || addedTypes.contains(general)))
					MoveManager.get().move(g,-1,-1,this, false);
			}			
		}
	}

	@SuppressWarnings("unchecked")
	public void deleteSelection(Object element){
		if(element instanceof DiagramElement){
			DiagramElement ce = ((DiagramElement)element);
			List<DiagramElement> list = new ArrayList<DiagramElement>();
			list.add(ce);
			DeletionManager.get().deleteElements(list,true);
		}else if (element instanceof Collection<?>){
			DeletionManager.get().deleteElements((List<DiagramElement>)element,true);
		}else{
			DeletionManager.get().delete(element);
		}
	}
	
	/**
	 * Removes the elements selected. From the diagram and the model.
	 */
	public void deleteSelection() {
				
		if(this.isFocusable()){
			Collection<DiagramElement> diagramElementsList = getSelectedElements();
			DeletionManager.get().deleteElements(diagramElementsList,true);
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
	public void excludeSelection(Collection<DiagramElement> diagramElementsList){
		//no diagram in the list...
		List<DiagramElement> diagrams=new ArrayList<DiagramElement>();
		for(DiagramElement de: diagramElementsList) if(de instanceof StructureDiagram) diagrams.add(de);
		diagramElementsList.removeAll(diagrams);
		if(diagramElementsList.size()>0){
			
			int response = JOptionPane.showConfirmDialog(frame, "WARNING: Are you sure you want to delete the element(s) from the diagram?\n If so, note that the element(s) will still exist in the project browser. \nYou can still move the element back to the diagram again.\n", "Delete from Diagram", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null);
			if(response==Window.OK)
			{
				execute(new DeleteElementCommand(this, OccurenceManager.get().getElements(diagramElementsList), false,true));
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
		GeneralizationSet genSet = AdditionManager.get().addGeneralizationSet(this,(List<DiagramElement>)genElems);		
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
			DeletionManager.get().deleteGeneralizationSet(this,(List<DiagramElement>)genElems);		
			deselectAll();
			cancelEditing();	
		}
	}
	
	
	//============================================================
	
	/** {@inheritDoc} */
	public void moveElements(MoveOperation[] moveOperations) 
	{		
		MoveElementCommand cmd = new MoveElementCommand(this, moveOperations);
		execute(cmd);		
	}

	/** {@inheritDoc} */
	public void setNewConnectionPoints(Connection conn, List<Point2D> points) 
	{
		execute(new EditConnectionPointsCommand(this, conn, points));
	}

	/** {@inheritDoc} */
	public void resizeElement(Node element, Point2D newpos, Dimension2D size) 
	{
		ResizeElementCommand cmd = new ResizeElementCommand(this, element, newpos, size);
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

