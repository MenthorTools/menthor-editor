package org.tinyuml.umldraw;

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
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.tinyuml.draw.AbstractCompositeNode;
import org.tinyuml.draw.CompositeNode;
import org.tinyuml.draw.Connection;
import org.tinyuml.draw.Diagram;
import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.DiagramOperations;
import org.tinyuml.draw.DrawingContext;
import org.tinyuml.draw.DrawingContext.FontType;
import org.tinyuml.draw.Label;
import org.tinyuml.draw.LabelChangeListener;
import org.tinyuml.draw.LabelSource;
import org.tinyuml.draw.Node;
import org.tinyuml.draw.NodeChangeListener;
import org.tinyuml.draw.Selection;
import org.tinyuml.draw.SimpleLabel;
import org.tinyuml.umldraw.shared.BaseConnection;
import org.tinyuml.umldraw.shared.DiagramSelection;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.Comment;
import RefOntoUML.Dependency;
import RefOntoUML.DirectedRelationship;
import RefOntoUML.Element;
import RefOntoUML.Generalization;
import RefOntoUML.NamedElement;
import RefOntoUML.Namespace;
import RefOntoUML.Package;
import RefOntoUML.Property;
import RefOntoUML.Relationship;
import RefOntoUML.StringExpression;
import RefOntoUML.VisibilityKind;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.ui.UmlProject;

/**
 * This class implements the effective layout area. It shows the boundaries of
 * the diagram and also the grid lines.
 * 
 * @author Wei-ju Wu, John Guerson
 */
public class StructureDiagram extends AbstractCompositeNode implements
		NodeChangeListener, LabelSource, Diagram {

	private static final long serialVersionUID = -874538211438595440L;
	private static final int ADDITIONAL_SPACE_RIGHT = 0;
	private static final int ADDITIONAL_SPACE_BOTTOM = 0;
	
	private transient boolean gridVisible = true, snapToGrid = true, saveNeeded = true;
	private transient Collection<LabelChangeListener> nameChangeListeners = new ArrayList<LabelChangeListener>();
	private transient Set<NodeChangeListener> nodeChangeListeners = new HashSet<NodeChangeListener>();
	private transient boolean generateTheme = true;
	private transient Object container;
	
	private int gridSize = 5;
	private String name;
	private List<Connection> connections = new ArrayList<Connection>();
	private Label nameLabel = new SimpleLabel();
	private UmlProject project;
	private String uuidContainer = new String();
	
	
	/**
	 * Writes the instance variables to the stream.
	 * 
	 * @param stream
	 *            an ObjectOutputStream
	 * @throws IOException
	 *             if I/O error occured
	 */
	private void writeObject(ObjectOutputStream stream) throws IOException {
		stream.writeInt(gridSize);
		stream.writeUTF(name);
		stream.writeObject(connections);
		stream.writeObject(nameLabel);
		stream.writeObject(project);			
		
		if(uuidContainer!=null) stream.writeUTF(uuidContainer);
	}

	/**
	 * Reads the instance variables from the specified stream.
	 * 
	 * @param stream
	 *            an ObjectInputStream
	 * @throws IOException
	 *             if I/O error occured
	 * @throws ClassNotFoundException
	 *             if class was not found
	 */
	@SuppressWarnings({ "unchecked" })
	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException, InvalidClassException {
		gridSize = stream.readInt();
		name = stream.readUTF();
		connections = (List<Connection>) stream.readObject();		
		nameLabel = (Label) stream.readObject();
		project = (UmlProject) stream.readObject();	
		
		try{
			uuidContainer = stream.readUTF();
		}catch(IOException e){
			System.err.println("Reading Serialized Diagram: No UUID container found at the diagram: "+name);
		}
		
		gridVisible = true;
		snapToGrid = true;
		saveNeeded = false;
		nameChangeListeners = new ArrayList<LabelChangeListener>();
		nodeChangeListeners = new HashSet<NodeChangeListener>();
		generateTheme = true;	
	}
	
	public List<GeneralizationElement> getGeneralizations(List<RefOntoUML.Element> gens){
		List<GeneralizationElement> result = new ArrayList<GeneralizationElement>();
		for(DiagramElement dElem: getChildren()){
			if(dElem instanceof GeneralizationElement){
				GeneralizationElement genElem = (GeneralizationElement)dElem;
				if(gens.contains(genElem.getRelationship())) result.add(genElem);
			}
		}
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	/** Delete connections that have a null relationship. This should not happen. */
	public void eliminateTrash(List<Connection> connections)
	{
		Iterator iter = connections.iterator();
		while(iter.hasNext())
		{
			Object obj = iter.next();
			if (obj instanceof AssociationElement){
				AssociationElement assocElem = (AssociationElement)obj;
				if (assocElem.getRelationship() ==null) {
					System.err.println("Draw Exception: Association Element "+assocElem+" cannot be drawed! Cause: null relationship. ");
					System.err.print("Fixing the problem... ");
					if(OccurenceMap.get().remove(assocElem)) System.err.print("Association Element "+assocElem+" removed. ");
					else System.err.print("Association Element "+assocElem+" ignored. ");
					iter.remove();
				} 
			}
			
			else if (obj instanceof GeneralizationElement) {
				GeneralizationElement genElem = (GeneralizationElement)obj;
				if (genElem.getRelationship() ==null) {
					System.err.println("Draw Exception: Generalization Element "+genElem+" cannot be drawed! Cause: null generalization. ");
					System.err.print("Fixing the problem... ");
					if(OccurenceMap.get().remove(genElem)) System.err.print("Generalization Element "+genElem+" removed. ");
					else System.err.print("Generalization Element "+genElem+" ignored. ");
					iter.remove();
				}
			}			
		}		
	}
	
	@Override
	public Object getContainer() {
		if(container!=null) return container;
		else if(uuidContainer!=null && !uuidContainer.isEmpty()) return OntoUMLParser.getElementByUUID(getModel(), uuidContainer);
		else return null;
	}
	
	public void setContainer(Object container){ 
		this.container = container;
		uuidContainer = OntoUMLParser.getUUIDFromElement((RefOntoUML.Element)container);
	}
	
	/**
	 * Constructor.
	 */
	public StructureDiagram(UmlProject project) {
		initializeNameLabel();		
		this.project = project;	
		this.container=project.getModel();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Selection getSelection(DiagramOperations operations) {
		return new DiagramSelection(operations, this);
	}

	/**
	 * Initializes the name label.
	 */
	private void initializeNameLabel() {
		nameLabel.setSource(this);
		nameLabel.setParent(this);
		nameLabel.setOrigin(5, 3);
		nameLabel.setSize(10, 10);
		nameLabel.setFontType(FontType.ELEMENT_NAME);
	}

	/**
	 * Returns this diagram's DiagramElementFactory.
	 * 
	 * @return the element factory
	 */
	// public DiagramElementFactory getElementFactory() {
	// return new DiagramElementFactoryImpl(this);
	// }

//	public DiagramElementFactory getElementFactory() {
//		if(elementFactory==null) elementFactory = new DiagramElementFactoryImpl(this);
//		elementFactory.setDiagram(this);
//		return elementFactory;
//	}
		
	public List<EObject> getPackageableElements()
	{	 
   		ArrayList<EObject> elements = new ArrayList<EObject>();   		
   		for(DiagramElement de: this.getChildren()){
   			if(de instanceof ClassElement) {
   				Classifier c = ((ClassElement)de).getClassifier();
   				elements.add(c);
   				if(c instanceof RefOntoUML.Class) {
					for(Property attr: ((RefOntoUML.Class)c).getOwnedAttribute()) {
						//elements.add(attr);
						if(!elements.contains(attr.getType())) elements.add(attr.getType());
					}
				}
				if(c instanceof RefOntoUML.DataType) {
					for(Property attr: ((RefOntoUML.DataType)c).getOwnedAttribute()) {
						//elements.add(attr);
						if(!elements.contains(attr.getType())) elements.add(attr.getType());
					}
				}
   			}
   			if(de instanceof AssociationElement) { 
   				Association r = (Association)((AssociationElement)de).getRelationship();
   				//elements.add(r.getMemberEnd().get(0));
   				//elements.add(r.getMemberEnd().get(1));
   				elements.add(r);								
   			}
   			if(de instanceof GeneralizationElement) {
   				Relationship rel = ((GeneralizationElement)de).getRelationship();
   				elements.add(rel);
   				elements.addAll(((Generalization)rel).getGeneralizationSet());				 
   			}
   		}	
   		return elements;	   	
	}
	
	@Override
	public String toString()
	{
		return getLabelText();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getName() {
		return name;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setName(String aName) {
		name = aName;
		for (LabelChangeListener l : nameChangeListeners) {
			l.labelTextChanged(nameLabel);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLabelText() {
		return getName();
	}

	/**
	 * {@inheritDoc}
	 */
	public void setLabelText(String aText) {
		setName(aText);
	}

	public boolean isSaveNeeded() {
		return saveNeeded;
	}
	
	public void setSaveNeeded(boolean saveNeeded) {
		this.saveNeeded = saveNeeded;
	}
	
	public void setGenerateTheme(boolean generateTheme) {
		this.generateTheme = generateTheme;
	}

	public boolean isGenerateTheme() {
		return generateTheme;
	}
	
	/**
	 * Sets the visibility flag of the grid.
	 * 
	 * @param flag
	 *            true if grid should be visible, false otherwise
	 */
	public void setGridVisible(boolean flag) {
		gridVisible = flag;
	}

	/**
	 * Returns the state of the gridVisible flag.
	 * 
	 * @return true if grid visible, false otherwise
	 */
	public boolean isGridVisible() {
		return gridVisible;
	}

	/**
	 * Returns the grid size.
	 * 
	 * @return the grid size
	 */
	public int getGridSize() {
		return gridSize;
	}

	/**
	 * Sets the grid size.
	 * 
	 * @param size
	 *            the new grid size
	 */
	public void setGridSize(int size) {
		gridSize = size;
	}

	/**
	 * Returns the status of the snapToGrid property.
	 * 
	 * @return the status of the snapToGrid property
	 */
	public boolean isSnapToGrid() {
		return snapToGrid;
	}

	/**
	 * Sets the snapping flag.
	 * 
	 * @param flag
	 *            true to snap, false to ignore snapping
	 */
	public void setSnapToGrid(boolean flag) {
		snapToGrid = flag;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CompositeNode getParent() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setParent(CompositeNode parent) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getAbsoluteX1() {
		return getOrigin().getX();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getAbsoluteY1() {
		return getOrigin().getY();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAbsolutePos(double xpos, double ypos) {
		setOrigin(xpos, ypos);
	}

	/**
	 * {@inheritDoc}
	 */

	public void draw(DrawingContext drawingContext, boolean toScreen) {
		Rectangle bounds = drawingContext.getClipBounds();
		drawBackground(drawingContext, bounds);
		if (gridVisible)
			drawGrid(drawingContext);

		if(toScreen)
			drawBorder(drawingContext);

		//drawNameLabel(drawingContext);

		// Draw container children
		super.draw(drawingContext);
		
		//eliminate problematic connections...
		eliminateTrash(connections);
		
		// Draw associations
		for (Connection assoc : connections) 
		{			
			assoc.draw(drawingContext);
		}					
	}

	/**
	 * Returns the drawing grid size.
	 * 
	 * @return the drawing grid size
	 */
	private double getDrawGridSize() {
		return gridSize * 5;
	}

	/**
	 * Draws the background of the diagram.
	 * 
	 * @param drawingContext
	 *            the DrawingContext
	 * @param bounds
	 *            the bounding Rectangle
	 */
	private void drawBackground(DrawingContext drawingContext, Rectangle bounds) {
		// System.out.println("drawBackground(), clipBounds: " + bounds);
		double x1 = Math.max(getAbsoluteX1(), bounds.getX());
		double y1 = Math.max(getAbsoluteY1(), bounds.getY());
		double x2 = Math.min(bounds.getX() + bounds.getWidth(), getAbsoluteX1()
				+ getSize().getWidth());
		double y2 = Math.min(bounds.getY() + bounds.getHeight(),
				getAbsoluteY1() + getSize().getHeight());
		drawingContext.fillRectangle(x1, y1, x2 - x1, y2 - y1, Color.WHITE);
	}

	/**
	 * Draws the diagram border.
	 * 
	 * @param drawingContext
	 *            the DrawingContext
	 */
	private void drawBorder(DrawingContext drawingContext) {
		drawingContext.drawRectangle(getOrigin().getX(), getOrigin().getY(),
				getSize().getWidth(), getSize().getHeight(), null);
	}

	/**
	 * Draws the grid lines.
	 * 
	 * @param drawingContext
	 *            the DrawingContext
	 */
	private void drawGrid(DrawingContext drawingContext) {
		double drawingGridSize = getDrawGridSize();

		// Draw vertical lines
		double x1 = getOrigin().getX();
		double x2 = x1 + getSize().getWidth();
		double y1 = getOrigin().getY();
		double y2 = y1 + getSize().getHeight();

		// Start at a visible portion
		double x = x1;
		while (x <= x2) {
			drawingContext.drawGridLine(x, y1, x, y2);
			x += drawingGridSize;
		}

		// Draw horizontal lines
		double y = y1;
		while (y <= y2) {
			drawingContext.drawGridLine(x1, y, x2, y);
			y += drawingGridSize;
		}
	}

	/**
	 * Draws the name label in the left upper corner.
	 * 
	 * @param drawingContext
	 *            the DrawingContext
	 */
	@SuppressWarnings("unused")
	private void drawNameLabel(DrawingContext drawingContext) {
		nameLabel.recalculateSize(drawingContext);
		double x = getAbsoluteX1();
		double y = getAbsoluteY1();
		double height = nameLabel.getSize().getHeight() + 6;
		double width = nameLabel.getSize().getWidth() + 10;

		GeneralPath mainShape = new GeneralPath();
		mainShape.moveTo(x, y);
		mainShape.lineTo(x, y + height);
		mainShape.lineTo(x + width, y + height);
		mainShape.lineTo(x + width + 5, y + height - 5);
		mainShape.lineTo(x + width + 5, y);
		mainShape.closePath();
		drawingContext.draw(mainShape, Color.WHITE);
		nameLabel.draw(drawingContext);
	}

	/**
	 * Returns the grid position which is nearest to the specified position.
	 * 
	 * @param pos
	 *            the position
	 * @return the nearest grid point
	 */
	private double getNearestGridPos(double pos) {
		return Math.round(pos / gridSize) * gridSize;
	}

	/**
	 * {@inheritDoc}
	 */
	public void snap(Point2D point) {
		if (snapToGrid) {
			point.setLocation(getNearestGridPos(point.getX()),
					getNearestGridPos(point.getY()));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void nodeMoved(Node node) {
		resizeToNode(node);
	}

	/**
	 * {@inheritDoc}
	 */
	public void nodeResized(Node node) {
		resizeToNode(node);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<DiagramElement> getChildren() {
		List<DiagramElement> result = new ArrayList<DiagramElement>();
		result.addAll(super.getChildren());
		result.addAll(connections);
		return result;
	}

	public boolean containsChild(DiagramElement elem)
	{
		List<DiagramElement> children = new ArrayList<DiagramElement>();
		children.addAll(super.getChildren());
		children.addAll(connections);
		for(DiagramElement element: children){
			if(element.equals(elem)) return true;
		}
		return false;
	}
		
	public boolean containsChild(RefOntoUML.Element element)
	{
		List<DiagramElement> children = new ArrayList<DiagramElement>();
		children.addAll(super.getChildren());
		children.addAll(connections);
		for(DiagramElement e: children){
			if (e instanceof ClassElement){
				ClassElement elem = (ClassElement)e;
				if(elem.getClassifier().equals(element)) return true; 
			}
			if (e instanceof AssociationElement){
				AssociationElement elem = ((AssociationElement)e);
				if(elem.getRelationship().equals(element)) return true;
			}
		}
		return false;
	}
	
	public Connection getConnectionForGeneralization(Relationship relationship) {
		for (Connection item : connections) {
			if (((BaseConnection) item).getRelationship() == relationship)
				return item;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addChild(DiagramElement child) {
		if (child instanceof Connection) {
			if(!connections.contains(child)){
				connections.add((Connection) child);
				child.setParent(this);
			}
		} else {
			super.addChild(child);
			resizeToNode((Node) child);
		}

		//Let the element know that now it is part of a diagram
		child.addedToDiagram(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeChild(DiagramElement child) {
		if (child instanceof Connection) {
			if(connections.contains(child))
				connections.remove((Connection) child);
		} else {
			super.removeChild(child);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DiagramElement getChildAt(double x, double y) {
		for (Connection conn : connections) {
			
			if (conn.contains(x, y)) return conn;
			
			if (conn instanceof AssociationElement){			
				if (((AssociationElement)conn).getMultiplicity1Label()!=null && ((AssociationElement)conn).getMultiplicity1Label().contains(x, y)) {					
					return ((AssociationElement)conn).getMultiplicity1Label().getLabelAt(x, y);
				}
				if (((AssociationElement)conn).getMultiplicity2Label()!=null && ((AssociationElement)conn).getMultiplicity2Label().contains(x, y)){					
					return ((AssociationElement)conn).getMultiplicity2Label().getLabelAt(x, y);
				}
				if (((AssociationElement)conn).getRole1Label()!=null && ((AssociationElement)conn).getRole1Label().contains(x, y)) {
					return ((AssociationElement)conn).getRole1Label().getLabelAt(x, y);
				}
				if (((AssociationElement)conn).getRole2Label()!=null && ((AssociationElement)conn).getRole2Label().contains(x, y)) {
					return ((AssociationElement)conn).getRole2Label().getLabelAt(x, y);				
				}
				if (((AssociationElement)conn).getMetaPropertyLabel()!=null && ((AssociationElement)conn).getMetaPropertyLabel().contains(x, y)) {					
					return ((AssociationElement)conn).getMetaPropertyLabel().getLabelAt(x, y);
				}
				if (((AssociationElement)conn).getTypeLabel()!=null && ((AssociationElement)conn).getTypeLabel().contains(x, y)) {					
					return ((AssociationElement)conn).getTypeLabel().getLabelAt(x, y);
				}
				if (((AssociationElement)conn).getLocalNameLabel()!=null && ((AssociationElement)conn).getLocalNameLabel().contains(x, y)) {					
					return ((AssociationElement)conn).getLocalNameLabel().getLabelAt(x, y);
				}
			}
		}
		
		return super.getChildAt(x, y);
	}

	/**
	 * Updates this element's bounds according to the specified node. This will
	 * happen if the node exceeds the diagram's bounds.
	 * 
	 * @param node
	 *            the Node to check against
	 */
	private void resizeToNode(Node node) {
		// see if the element needs to be resized
		double diffx = node.getAbsoluteX2() - getAbsoluteX2();
		double diffy = node.getAbsoluteY2() - getAbsoluteY2();
		if (diffx > 0 || diffy > 0) {
			setSize(getSize().getWidth()
					+ (diffx > 0 ? (diffx + ADDITIONAL_SPACE_RIGHT) : 0),
					getSize().getHeight()
							+ (diffy > 0 ? (diffy + ADDITIONAL_SPACE_BOTTOM)
									: 0));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Label getLabelAt(double mx, double my) {
		if (nameLabel.contains(mx, my))
			return nameLabel;
		return null;
	}

	/**
	 * Adds a label change listener that listens to changes to the name label.
	 * 
	 * @param l
	 *            the listener to add
	 */
	public void addNameLabelChangeListener(LabelChangeListener l) {
		nameChangeListeners.add(l);
	}

	/**
	 * Removes a label change listener from the name label.
	 * 
	 * @param l
	 *            the listener to remove
	 */
	public void removeNameLabelChangeListener(LabelChangeListener l) {
		nameChangeListeners.remove(l);
	}
	
	// *************************************************************************
	// ****** NodeChangeListeners of diagrams are usually user interface
	// ****** allElements. User interfaces are not part of the persistence project
	// ****** so the listeners are redefined as transient list.
	// **************************************************************************
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Collection<NodeChangeListener> getNodeChangeListeners() {
		return nodeChangeListeners;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addNodeChangeListener(NodeChangeListener l) {
		nodeChangeListeners.add(l);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeNodeChangeListener(NodeChangeListener l) {
		nodeChangeListeners.remove(l);
	}

	public UmlProject getProject() {
		return project;
	}
	
	@SuppressWarnings("unused")
	private Object getRandom(List<Object> possible, Set<Object> used)
	{
		Random generator = new Random();
		int tries = 0;
		
		while(tries < possible.size())
		{
			Object atr = possible.get(generator.nextInt(possible.size()));
			if(!used.contains(atr))
				return atr;
			else
				tries++;
		}
		
		//If all attributes are already used picks randomly one, repeating that one
		return possible.get(generator.nextInt(possible.size()));
	}
	
	
	@Override
	public void unsetName() { }

	@Override
	public boolean isSetName() {
		return false;
	}

	@Override
	public VisibilityKind getVisibility() {
		return null;
	}

	@Override
	public void setVisibility(VisibilityKind value) { }

	@Override
	public void unsetVisibility() {	}

	@Override
	public boolean isSetVisibility() {
		return false;
	}

	@Override
	public String getQualifiedName() {
		return null;
	}

	@Override
	public EList<Dependency> getClientDependency() {
		return null;
	}

	@Override
	public Namespace getNamespace() {
		return null;
	}

	@Override
	public StringExpression getNameExpression() {
		return null;
	}

	@Override
	public void setNameExpression(StringExpression value) { }

	@Override
	public boolean has_no_qualified_name(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return false;
	}

	@Override
	public boolean has_qualified_name(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return false;
	}

	@Override
	public boolean visibility_needs_ownership(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return false;
	}

	@Override
	public Dependency createDependency(NamedElement supplier) {
		return null;
	}

	@Override
	public String getLabel() {
		return null;
	}

	@Override
	public String getLabel(boolean localize) {
		return null;
	}

	@Override
	public void createUsage(NamedElement supplier) {
	}

	@Override
	public EList<Namespace> allNamespaces() {
		return null;
	}

	@Override
	public boolean isDistinguishableFrom(NamedElement n, Namespace ns) {
		return false;
	}

	@Override
	public String separator() {
		return null;
	}

	@Override
	public EList<Package> allOwningPackages() {
		return null;
	}

	@Override
	public EList<Element> getOwnedElement() {
		return null;
	}

	@Override
	public Element getOwner() {
		return null;
	}

	@Override
	public EList<Comment> getOwnedComment() {
		return null;
	}

	@Override
	public boolean not_own_self(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return false;
	}

	@Override
	public boolean has_owner(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return false;
	}

	@Override
	public void destroy() {
	}

	@Override
	public boolean hasKeyword(String keyword) {
		return false;
	}

	@Override
	public EList<String> getKeywords() {
		return null;
	}

	@Override
	public boolean addKeyword(String keyword) {
		return false;
	}

	@Override
	public boolean removeKeyword(String keyword) {
		return false;
	}

	@Override
	public Package getNearestPackage() {
		return null;
	}

	@Override
	public RefOntoUML.Model getModel() {
		if (project.getModel() instanceof RefOntoUML.Model) return (RefOntoUML.Model)project.getModel();
		else return null;
	}

	public RefOntoUML.Package getRootPackage(){
		return project.getModel();
	}
	
	@Override
	public void getApplicableStereotype(String qualifiedName) {
	}

	@Override
	public EList<EObject> getStereotypeApplications() {
		return null;
	}

	@Override
	public void getRequiredStereotype(String qualifiedName) {
	}

	@Override
	public void getAppliedStereotype(String qualifiedName) {
	}

	@Override
	public EAnnotation createEAnnotation(String source) {
		return null;
	}

	@Override
	public EList<Relationship> getRelationships() {
		return null;
	}

	@Override
	public EList<Relationship> getRelationships(EClass eClass) {
		return null;
	}

	@Override
	public EList<DirectedRelationship> getSourceDirectedRelationships() {
		return null;
	}

	@Override
	public EList<DirectedRelationship> getSourceDirectedRelationships(
			EClass eClass) {
		return null;
	}

	@Override
	public EList<DirectedRelationship> getTargetDirectedRelationships() {
		return null;
	}

	@Override
	public EList<DirectedRelationship> getTargetDirectedRelationships(
			EClass eClass) {
		return null;
	}

	@Override
	public EList<Element> allOwnedElements() {
		return null;
	}

	@Override
	public boolean mustBeOwned() {
		return false;
	}

	@Override
	public EAnnotation getEAnnotation(String arg0) {
		return null;
	}

	@Override
	public EList<EAnnotation> getEAnnotations() {
		return null;
	}

	@Override
	public TreeIterator<EObject> eAllContents() {
		return null;
	}

	@Override
	public EClass eClass() {
		return null;
	}

	@Override
	public EObject eContainer() {
		return null;
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		return null;
	}

	@Override
	public EReference eContainmentFeature() {
		return null;
	}

	@Override
	public EList<EObject> eContents() {
		return null;
	}

	@Override
	public EList<EObject> eCrossReferences() {
		return null;
	}

	@Override
	public Object eGet(EStructuralFeature arg0) {
		return null;
	}

	@Override
	public Object eGet(EStructuralFeature arg0, boolean arg1) {
		return null;
	}

	@Override
	public Object eInvoke(EOperation arg0, EList<?> arg1)
			throws InvocationTargetException {
		return null;
	}

	@Override
	public boolean eIsProxy() {
		return false;
	}

	@Override
	public boolean eIsSet(EStructuralFeature arg0) {
		return false;
	}

	@Override
	public Resource eResource() {
		return null;
	}

	@Override
	public void eSet(EStructuralFeature arg0, Object arg1) {
	}

	@Override
	public void eUnset(EStructuralFeature arg0) {
	}

	@Override
	public EList<Adapter> eAdapters() {
		return null;
	}

	@Override
	public boolean eDeliver() {
		return false;
	}

	@Override
	public void eNotify(Notification arg0) {
	}

	@Override
	public void eSetDeliver(boolean arg0) {
	}
	
	public ArrayList<Point> getUsedCanvasSize()
	{
		ArrayList<Point> result = new ArrayList<Point>();		
		double x1=10000,x2=0,y1=10000,y2=0;
		for(DiagramElement elem: this.getChildren())
		{
			if(elem instanceof ClassElement){
				ClassElement ce = (ClassElement)elem;
				if(ce.getAbsoluteX1()<x1) 
					x1 = ce.getAbsoluteX1();
				if(ce.getAbsoluteX2()>x2) 
					x2 = ce.getAbsoluteX2();
				if(ce.getAbsoluteY2()>y2) 
					y2 = ce.getAbsoluteY2();
				if(ce.getAbsoluteY1()<y1) 
					y1 = ce.getAbsoluteY1();				
			}
		}
		Point origin = new Point();
		Point end = new Point();
		origin.x=(int)x1;
		origin.y=(int)y1;		
		end.x = (int)(x2);
		end.y = (int)(y2);
		result.add(origin);
		result.add(end);
		return result;
	}

	@Override
	public int compareTo(Element arg0) {
		int value = ((StructureDiagram)arg0).getName().compareTo(this.getName());
		if(value!=0) return -value; else return value;
	}

	@Override
	public Object getModelObject() {
		return null;
	}
}
