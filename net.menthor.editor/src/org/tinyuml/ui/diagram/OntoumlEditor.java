
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.draw.Connection;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.DiagramOperations;
import org.tinyuml.draw.DrawingContext.FontType;
import org.tinyuml.draw.IEditField;
import org.tinyuml.draw.Label;
import org.tinyuml.draw.LineStyle;
import org.tinyuml.draw.MoveOperation;
import org.tinyuml.draw.MultiLineLabel;
import org.tinyuml.draw.MultilineEditField;
import org.tinyuml.draw.Node;
import org.tinyuml.draw.NodeChangeListener;
import org.tinyuml.draw.NullElement;
import org.tinyuml.draw.RectilinearConnection;
import org.tinyuml.draw.SimpleConnection;
import org.tinyuml.draw.SingleLineEditField;
import org.tinyuml.draw.TreeConnection;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.MenthorFactory;
import org.tinyuml.umldraw.OccurenceMap;
import org.tinyuml.umldraw.StructureDiagram;
import org.tinyuml.umldraw.shared.UmlConnection;

import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.stereotypes.ClassStereotype;
import RefOntoUML.stereotypes.DataTypeStereotype;
import RefOntoUML.stereotypes.RelationshipStereotype;
import net.menthor.editor.ui.UmlProject;
import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.commanders.ClipboardCommanderMode;
import net.menthor.editor.v2.commanders.ConnectCommanderMode;
import net.menthor.editor.v2.commanders.DeleteCommander;
import net.menthor.editor.v2.commanders.SelectCommanderMode;
import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.ui.MenuBarUI;
import net.menthor.editor.v2.ui.PaletteUI;
import net.menthor.editor.v2.ui.TopTabbedPaneUI;
import net.menthor.editor.v2.ui.color.ColorMap;
import net.menthor.editor.v2.ui.color.ColorType;
import net.menthor.editor.v2.ui.controller.DialogUIController;
import net.menthor.editor.v2.ui.editor.EditorMouseEvent;
import net.menthor.editor.v2.ui.editor.EditorType;
import net.menthor.editor.v2.ui.editor.IEditorMode;
import net.menthor.editor.v2.ui.generic.GenericEditor;
import net.menthor.editor.v2.ui.generic.GenericTabbedPane;
import net.menthor.editor.v2.ui.operation.ActionStack;
import net.menthor.editor.v2.ui.operation.IUndoableOperation;
import net.menthor.editor.v2.ui.operation.diagram.AddConnectionOperation;
import net.menthor.editor.v2.ui.operation.diagram.EditPointsOperation;
import net.menthor.editor.v2.ui.operation.diagram.LineStyleOperation;
import net.menthor.editor.v2.ui.operation.diagram.RenameLabelOperation;
import net.menthor.editor.v2.ui.operation.diagram.ResizeOperation;
import net.menthor.editor.v2.ui.operation.diagram.TranslateOperation;
import net.menthor.editor.v2.ui.popupmenu.PalettePopupMenu;
import net.menthor.editor.v2.util.DrawUtil;

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

	//public Frame frame;
	public ICommandListener listener;
	private GenericTabbedPane diagramManager;
	private OntoumlWrapper wrapper;
	private PalettePopupMenu popupmenu;
	
	private ActionStack actionStack = ActionStack.get();
	private transient IEditorMode editorMode;
	private transient ScalingComponent scalingComponent;
	//private transient SelectionMode selectionHandler;
	
	public IEditorMode getEditorMode(){ return editorMode; }
	//public SelectionMode getSelectionHandler(){ return selectionHandler; }
	
	protected static final double MARGIN_TOP=0, MARGIN_LEFT=0, MARGIN_RIGHT=0,//AppFrame.GetScreenWorkingWidth();
								  MARGIN_BOTTOM=0,//AppFrame.GetScreenWorkingHeight();
								  ADDSCROLL_HORIZONTAL=0,
								  ADDSCROLL_VERTICAL=0;
		
	
	// To edit the captions in the diagram. 
	private SingleLineEditField captionEditor = new SingleLineEditField();
	private MultilineEditField multilineEditor = new MultilineEditField();
	
	// This is the root of the shape hierarchy. 
	private StructureDiagram diagram;
	
	// MouseEvent wrapper
	private transient EditorMouseEvent mouseEvent = new EditorMouseEvent();

	// this might be null when the application is started and the pointer still did not move or had the focus of the editor
	private static MouseEvent currentPointerPosition;
	
	/** Empty constructor for testing. Do not use !  */
	public OntoumlEditor() { }

	/**
	 * Constructor. Basic setup of the layout area.
	 * @param frame the frame
	 * @param diagramManager 
	 * @param diagram the diagram
	 */
	public OntoumlEditor(ICommandListener listener, GenericTabbedPane diagramManager, OntoumlDiagram diagram) 
	{
		//this.frame = frame;
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
		captionEditor.getDocument().addUndoableEditListener(actionStack.getUndoManager());
		multilineEditor.getDocument().addUndoableEditListener(actionStack.getUndoManager());
		this.diagram.setOrigin(MARGIN_LEFT, MARGIN_TOP);

		installHandlers();
		
		double width = this.diagram.getSize().getWidth()+MARGIN_RIGHT + MARGIN_LEFT + ADDSCROLL_HORIZONTAL;
		double height = this.diagram.getSize().getHeight()+MARGIN_BOTTOM + MARGIN_TOP + ADDSCROLL_VERTICAL;		
		setPreferredSize(new Dimension((int)width,(int)height));		
		setSize(new Dimension((int)width,(int)height));		
	}

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
		editorMode = SelectCommanderMode.get();
		mouseEvent = new EditorMouseEvent();
		scalingComponent = new ScalingComponent(this);
	}
	
	public void setWrapper(OntoumlWrapper wrapper)
	{
		this.wrapper = wrapper;
	}
	
	public OntoumlWrapper getWrapper() { 
		return wrapper; 
	}
	
	

	public TopTabbedPaneUI getManager() { return  (TopTabbedPaneUI)diagramManager; }
	public TopTabbedPaneUI getDiagramManager() { return (TopTabbedPaneUI)diagramManager; }
	public UmlProject getProject() { return diagram.getProject(); }
		
	

	

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
		
//		addMouseListener(new MouseAdapter()
//	    {
//			@Override
//			public void mousePressed(MouseEvent e) {
//				if(e.isPopupTrigger()){
//					
//				}
//			}
//			
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				if(e.isPopupTrigger()){
//					
//				}
//			}
//			
////			@Override
////			public void mouseClicked(MouseEvent e) 
////			{			
////			    if (SwingUtilities.isLeftMouseButton(e))
////	            {	            	  
////			    	if(e.getClickCount()==2){
////			    		if(diagram.getChildAt(e.getX(), e.getY()).equals(NullElement.getInstance()))
////			    			openToolBoxPopupMenu();
////			    	}	
////	            }			    
////			}	       
//	    });					
				
		// install Space KeyBinding
		getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(' '),"openToolBoxMenu");
		getActionMap().put("openToolBoxMenu", new AbstractAction() {

			private static final long serialVersionUID = 4266982722845577768L;

			/** {@inheritDoc} */
			public void actionPerformed(ActionEvent e) { 
				openToolBoxPopupMenu(); 
			}
		});
		
		// install Escape (ESC) KeyBinding
		getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"),"cancelEditing");
		getActionMap().put("cancelEditing", new AbstractAction() {

			private static final long serialVersionUID = 4266982722845577768L;

			/** {@inheritDoc} */
			public void actionPerformed(ActionEvent e) { cancelEditing(); }
		});
		
		AbstractAction excludeAction = new AbstractAction() {
			private static final long serialVersionUID = -6375878624042384546L;
			/** {@inheritDoc} */
			public void actionPerformed(ActionEvent e) { 
				if(OntoumlEditor.this.isFocusable()){
					Collection<DiagramElement> diagramElementsList = SelectCommanderMode.get().getSelectedElements();
					DeleteCommander.get().deleteFromDiagram(OntoumlEditor.this,diagramElementsList);
				}
			}
		};
		
		AbstractAction deleteAction = new AbstractAction() {
			private static final long serialVersionUID = -6375878624042384546L;
			/** {@inheritDoc} */
			public void actionPerformed(ActionEvent e) { 
				if(OntoumlEditor.this.isFocusable()){
					Collection<DiagramElement> diagramElementsList = SelectCommanderMode.get().getSelectedElements();
					DeleteCommander.get().delete(diagramElementsList);
				}
			}
		};
		
		// install Erase KeyBinding
		if(onMac()){
			getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("BACK_SPACE"),"excludeSelection");
			getActionMap().put("excludeSelection", excludeAction);	
		}else{
			getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DELETE"),"excludeSelection");		
			getActionMap().put("excludeSelection", excludeAction);				
		}
				
		if(onMac()){
			getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, ActionEvent.META_MASK),"deleteSelection");
			getActionMap().put("deleteSelection", deleteAction);
		}else{
			// install Delete KeyBinding
			getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.CTRL_MASK),"deleteSelection");		
			getActionMap().put("deleteSelection", deleteAction);					
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
            		scalingComponent.zoomIn();
//            		centeredZoomIn(e.getPoint());
            	}
            }
            if (e.getWheelRotation() > 0)
            {
            	for (int i = 0; i< Math.abs(e.getWheelRotation());i++) {
            		scalingComponent.zoomOut();
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
			captionEditor.hideField();
		}
		editorMode.cancel();
//		SelectMode.get().deselectAll();
		PaletteUI.get().getClassPalette().selectMousePointer();
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));		
		redraw();
		requestFocusInEditor();
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
		if (scalingComponent.getScaleFactor() != 1.0) 
		{
			g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
		}
		//boolean gridVisible = diagram.isGridVisible();
		Color background = ColorMap.getInstance().getColor(ColorType.MENTHOR_BLUE_LIGHTEST);
		if (toScreen) {
			scalingComponent.scaleDiagram(g2d); // Scaling is only interesting if rendering to screen			
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
		return diagram.getSize().getWidth()*scalingComponent.getScaleFactor();
	}
	
	/** Get the height of the diagram considering the zoom */
	public double getDiagramHeight()
	{
		return diagram.getSize().getHeight()*scalingComponent.getScaleFactor();		
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
		IEditField currentEditor = null;
		if (captionEditor.isVisible()) currentEditor = captionEditor;		
		if (multilineEditor.isVisible()) currentEditor = multilineEditor;
				
		//O problema esta aqui, eh necessario veirificar o modo do editor
		if (currentEditor != null && currentEditor.isVisible()) 
		{			
			String text = currentEditor.getText();
			Label label = currentEditor.getLabel();
			RenameLabelOperation command = new RenameLabelOperation(this, label, text);
			execute(command);
			currentEditor.hideField();				
//			repaint();
			return true;
		}
		return false;
	}

	// ************************************************************************
	// ***** MouseListener
	// ************************************************************************

	/** {@inheritDoc} */
	public void mousePressed(MouseEvent e) {
		if (!stopEditing()) {
			editorMode.mousePressed(convertMouseEvent(e));		
		}
	}

	/** {@inheritDoc} */
	public void mouseReleased(MouseEvent e) {
		if (!stopEditing()){
			editorMode.mouseReleased(convertMouseEvent(e));
		}
	}

	/** {@inheritDoc} */
	public void mouseClicked(MouseEvent e) {
		if (!stopEditing()){
			editorMode.mouseClicked(convertMouseEvent(e));		
		}
	}
	
	// ************************************************************************
	// ***** MouseMotionListener
	// ************************************************************************

	/** {@inheritDoc} */
	public void mouseExited(MouseEvent e) { 
		EditorMouseEvent evt = convertMouseEvent(e);
		currentPointerPosition = evt.getMouseEvent();
	}

	/** {@inheritDoc} */
	public void mouseEntered(MouseEvent e) {
		EditorMouseEvent evt = convertMouseEvent(e);
		currentPointerPosition = evt.getMouseEvent();
	}

	/** {@inheritDoc} */
	public void mouseMoved(MouseEvent e) {
		EditorMouseEvent evt = convertMouseEvent(e);
		currentPointerPosition = evt.getMouseEvent();		
		editorMode.mouseMoved(evt);
	}
	
	/** {@inheritDoc} */
	public void mouseDragged(MouseEvent e) {
		EditorMouseEvent evt = convertMouseEvent(e);
		currentPointerPosition = evt.getMouseEvent();
		editorMode.mouseDragged(evt);
	}

	/**
	 * Converts the java.awt.MouseEvent into an EditorMouseEvent.
	 * @param e the MouseEvent
	 * @return the converted event
	 */
	private EditorMouseEvent convertMouseEvent(MouseEvent e) 
	{
		mouseEvent.setMouseEvent(e, scalingComponent.getScaling());
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

	
	
	/** Sets the editor into selection mode. */
	public void setSelectionMode(){		
		editorMode = SelectCommanderMode.get();		
	}

	/**
	 * Switches the editor into creation mode.
	 * @param elementType the ElementType that indicates what to create
	 */
	public void setCreationMode(ClassStereotype elementType) 
	{
		ClipboardCommanderMode.get().createAndPutToClipboard(elementType);
		editorMode = ClipboardCommanderMode.get();
	}
	
	public void setEditorMode(IEditorMode mode){		
		editorMode = mode;
	}
	
	/**
	 * Switches the editor into creation mode.
	 * @param elementType the ElementType that indicates what to create
	 */
	public void setCreationMode(DataTypeStereotype elementType) 
	{		
		ClipboardCommanderMode.get().createAndPutToClipboard(elementType);
		editorMode = ClipboardCommanderMode.get();
	}
	
	public void setDragElementMode(RefOntoUML.Type type)
	{		
		ClipboardCommanderMode.get().putToClipboard(type, true);
		editorMode = ClipboardCommanderMode.get();
	}
	
	/**
	 * Switches the editor into connection creation mode.
	 * @param relationType the RelationType to create
	 */
	public void setCreateConnectionMode(RelationshipStereotype relationType) 
	{	
		ConnectCommanderMode.get().setRelationshipType(relationType);
		editorMode = ConnectCommanderMode.get();
	}

	public UmlConnection dragRelation(RefOntoUML.Relationship relationship, EObject eContainer)
	{		
		RelationshipStereotype relationType = RelationshipStereotype.valueOf(OntoUMLParser.getStereotype(relationship).toUpperCase());
		ConnectCommanderMode.get().setRelationshipType(relationType);
		editorMode = ConnectCommanderMode.get();
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
		  
		DiagramElement src = OccurenceMap.get().getDiagramElement(source,getDiagram());
		DiagramElement tgt = OccurenceMap.get().getDiagramElement(target,getDiagram());		
		if(src==null || tgt==null) return null;
		
		UmlConnection conn = MenthorFactory.get().createVisualConnectionFromModelRelationship(relationship, src, tgt);
		AddConnectionOperation command = new AddConnectionOperation(this, conn);
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
			MenuBarUI.get().selectShowGrid(false);
		}else{
			showGrid(true);
			MenuBarUI.get().selectShowGrid(true);
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
	public void bringToFront(){
		if (SelectCommanderMode.get().getSelectedElements().size() > 0) 
		{
			for(DiagramElement de: SelectCommanderMode.get().getSelectedElements()){
				if(!(de instanceof StructureDiagram)) diagram.bringChildToFront(de);				
			}			
			redraw();
		}
	}

	/** Set the background color of the selected elements */
	public void setBackgroundInSelected(Color color)
	{
		for(DiagramElement de: SelectCommanderMode.get().getSelectedElements()){
			if(de instanceof ClassElement){
				ClassElement ce = (ClassElement)de;
				ce.setBackgroundColor(color);
			}
		}
		wrapper.getScrollPane().updateUI();
	}
	
	
	
	
	
	
		
	/** Puts the current selection to the back. */
	public void putToBack() 
	{
		if (SelectCommanderMode.get().getSelectedElements().size() > 0) 
		{
			for(DiagramElement de: SelectCommanderMode.get().getSelectedElements()){
				if(!(de instanceof StructureDiagram)) diagram.putChildToBack(de);				
			}
			redraw();
		}
	}
	
	public void setLineStyle(UmlConnection connection, LineStyle style)
	{
		if(style == LineStyle.RECTILINEAR){
			execute(new LineStyleOperation(this, connection, new RectilinearConnection(connection)));
		} else if (style == LineStyle.DIRECT) {
			execute(new LineStyleOperation(this, connection, new SimpleConnection(connection)));
		} else if (style == LineStyle.TREESTYLE_VERTICAL) {
			execute(new LineStyleOperation(this, connection, new TreeConnection(connection,true)));
		} else if (style == LineStyle.TREESTYLE_HORIZONTAL) {
			execute(new LineStyleOperation(this, connection, new TreeConnection(connection,false)));
		}
	}

		/**
	 * Runs the specified command by this editor's CommandProcessor, which makes
	 * the operation reversible.
	 * @param command the command to run
	 */
	public void execute(IUndoableOperation command) 
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
	

	/** Edits the current selection's properties. */
	public void editProperties(){
		if (SelectCommanderMode.get().getSelectedElements().size() > 0) {
			DialogUIController.get().edit(SelectCommanderMode.get().getSelectedElements().get(0));		
		}
	}
	
	//============================================================
	
	/** {@inheritDoc} */
	public void moveElements(MoveOperation[] moveOperations) 
	{		
		TranslateOperation cmd = new TranslateOperation(this, moveOperations);
		execute(cmd);		
	}

	/** {@inheritDoc} */
	public void setNewConnectionPoints(Connection conn, List<Point2D> points) 
	{
		execute(new EditPointsOperation(this, conn, points));
	}

	/** {@inheritDoc} */
	public void resizeElement(Node element, Point2D newpos, Dimension2D size) 
	{
		ResizeOperation cmd = new ResizeOperation(this, element, newpos, size);
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
				multilineEditor.showField(label, getGraphics());
			} else {
				captionEditor.showField(label, getGraphics());				
			}			
		}
		
	}

	
	/*** {@inheritDoc} */
	@Override
	public void nodeResized(Node node) { 
		scalingComponent.recalculateSize(); 
	}
	
	/** {@inheritDoc} */
	@Override
	public void nodeMoved(Node node) { }
	
	public void requestFocusInEditor() { diagramManager.requestFocus(); }

	/** {@inheritDoc} */
	public EditorType getEditorType() {	return EditorType.ONTOUML_EDITOR; }

	/** {@inheritDoc} */
	@Override
	public boolean isSaveNeeded() { 
		return diagram.isSaveNeeded(); 
	}
	
	@Override
	public void setSaveNeeded(boolean value) { 
		diagram.setSaveNeeded(value); 
	}
	
	@Override
	public void propagateNewTitle(String title) { diagram.setName(title); }
	
	@Override
	public void dispose() { }

	public ScalingComponent getScalingComponent() {
		return scalingComponent;
	}

}

