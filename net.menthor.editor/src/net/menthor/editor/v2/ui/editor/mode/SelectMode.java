package net.menthor.editor.v2.ui.editor.mode;

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

import java.awt.Cursor;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.draw.DrawingContext;
import org.tinyuml.draw.Label;
import org.tinyuml.draw.MultiSelection;
import org.tinyuml.draw.NodeSelection;
import org.tinyuml.draw.NullElement;
import org.tinyuml.draw.NullSelection;
import org.tinyuml.draw.RubberbandSelector;
import org.tinyuml.draw.Selection;
import org.tinyuml.ui.diagram.OntoumlEditor;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.StructureDiagram;
import org.tinyuml.umldraw.shared.UmlConnectionSelection;
import org.tinyuml.umldraw.shared.UmlDiagramElement;

import net.menthor.editor.v2.managers.EditManager;
import net.menthor.editor.v2.ui.app.AppCmdListener;
import net.menthor.editor.v2.ui.app.manager.AppTabManager;
import net.menthor.editor.v2.ui.popupmenu.MultiElementPopupMenu;
import net.menthor.editor.v2.ui.popupmenu.SingleElementPopupMenu;

public class SelectMode implements IEditorMode {

	// -------- Lazy Initialization

	private static class SelectionModeLoader {
        private static final SelectMode INSTANCE = new SelectMode();
    }	
	public static SelectMode get() { 
		return SelectionModeLoader.INSTANCE; 
	}	
    private SelectMode() {
        if (SelectionModeLoader.INSTANCE != null) throw new IllegalStateException("SelectionMode already instantiated");
    }
    
    // ----------------------------
    
    public OntoumlEditor currentEditor(){
    	OntoumlEditor currentEditor = AppTabManager.get().getCurrentDiagramEditor();
    	if(currentEditor!=null) rubberSelector.setDiagram(currentEditor.getDiagram());
    	return currentEditor;
    }
    
	protected Selection selection = NullSelection.getInstance();	
	protected Point2D startPoint = new Point2D.Double();	
	protected RubberbandSelector rubberSelector = new RubberbandSelector();

	/** select all elements using implicitly the rubber-band selector */
	public void selectAll(){
		selection = rubberSelector;
		selection.updatePosition(0,0);
		selection.startDragging(0,0);
		selection.updatePosition(currentEditor().getDiagramWidth(), currentEditor().getDiagramHeight());
		selection.stopDragging(currentEditor().getDiagramWidth(),  currentEditor().getDiagramHeight());
		if (selection instanceof RubberbandSelector) {
			select((RubberbandSelector) selection);
		}
		
		currentEditor().redraw();
		currentEditor().requestFocusInEditor();
	}
	 
	private void select(RubberbandSelector rubberband) {
		if (rubberband.getSelectedElements().size() == 1) { 
			selection = rubberband.getSelectedElements().get(0).getSelection(currentEditor());
		} else if (rubberband.getSelectedElements().size() > 1) {
			selection = new MultiSelection(currentEditor(), rubberband.getSelectedElements());
		} else {
			selection = currentEditor().getDiagram().getSelection(currentEditor());
		}
	}	
		
	private Selection select(double mx, double my) {
		if (!isNothingSelected() && selection.contains(mx, my)) {
			return selection;
		}
		DiagramElement element = currentEditor().getDiagram().getChildAt(mx, my);			
		if (element != NullElement.getInstance()) {
			return element.getSelection(currentEditor());
		}
		return currentEditor().getDiagram().getSelection(currentEditor());
	}

	public void select(List<DiagramElement> elements){
		deselectAll();
		selection = new MultiSelection(currentEditor(), elements);
	}
	
	public void select(DiagramElement element)	{
		deselectAll();
		selection = element.getSelection(currentEditor());
	}

	public void draw(DrawingContext drawingContext) {
		List<DiagramElement> list = getSelectedElements();
		if(list.size()>0) {
			//only draw the selection cubes if the diagram on the tab open 
			//is the same diagram of the selected elements
			Object diagramWithSelection = list.get(0).getDiagram();
			if(currentEditor().getDiagram().equals(diagramWithSelection)){
				selection.draw(drawingContext);						
			}				
		}		
		rubberSelector.draw(drawingContext);
	}
	
	public void stateChanged() { 
		selection.updateDimensions(); 
	}
	
	public void cancel() { 
		selection.cancelDragging(); 
	}
	
	public List<DiagramElement> getSelectedElements() { 
		return selection.getElements(); 
	}
	
	public Selection getSelection() { 
		return selection; 
	}
	
	public void deselectAll() { 
		selection = NullSelection.getInstance(); 
	}
	
	public boolean isNothingSelected() {
		return selection == NullSelection.getInstance() || selection.getElement() == currentEditor().getDiagram();
	}

	public void remove(List<DiagramElement> elements) {
		for (DiagramElement element : elements) {
			if (selection.getElements().contains(element)) {
				selection = NullSelection.getInstance();
			}
		}
	}
	
	//---- Editor mouse events ---
	
	public void mouseMoved(EditorMouseEvent e) {
		double mx = e.getX();
		double my = e.getY();
		if(currentEditor()==null) return;
		if (selection.contains(mx, my)) {
			currentEditor().setCursor(selection.getCursorForPosition(mx, my));
		} else {
			currentEditor().setCursor(Cursor.getDefaultCursor());
		}
	}

	public void mouseDragged(EditorMouseEvent e) {
		double mx = e.getX();
		double my = e.getY();
		if(currentEditor()==null) return;
		if (selection.isDragging()) {
			selection.updatePosition(mx, my);
			currentEditor().repaint();
		}
	}
	
	public void mouseReleased(EditorMouseEvent e) {						
		double mx = e.getX(), my = e.getY();				
		if (selection.isDragging()) {	
			selection.updatePosition(mx, my);
			selection.stopDragging(mx, my);			
			if (selection instanceof RubberbandSelector) {				
				select((RubberbandSelector) selection);
			}	
			currentEditor().redraw();
		}		
	}
	
	public void mousePressed(EditorMouseEvent e) {		
		pressed(e);
	}
		
	public void mouseClicked(EditorMouseEvent e) {		
		if (e.isMainButton()) {
			clicked(e);
		}
		if (SwingUtilities.isRightMouseButton(e.getMouseEvent())){
			showSelectionPopupMenu(e);
        }
	}
	
	public void clicked(EditorMouseEvent e){
		if(currentEditor()==null) return; 
		if(e.getMouseEvent().isControlDown()) return;
		DiagramElement elemClicked = currentEditor().getDiagram().getChildAt(e.getX(), e.getY());		
		if(!getSelectedElements().contains(elemClicked)) return;		 
		if(currentEditor()==null) return;
		if (elemClicked instanceof UmlDiagramElement){						
			Label label = elemClicked.getLabelAt(e.getX(),e.getY());
			if (label != null && label.isEditable()) {
				currentEditor().editLabel(label); 		
			} else if (e.getClickCount() >= 2) {
				EditManager.get().edit(elemClicked);
			}			
		}
		if(elemClicked instanceof NullElement) {
			selection = currentEditor().getDiagram().getSelection(currentEditor()); 			
		}
		currentEditor().redraw();
		currentEditor().requestFocusInEditor();
	}

	public void pressed(EditorMouseEvent e) {
		double mx = e.getX(), my = e.getY();		
		Selection newSelection = select(mx, my);		
		if(e.getMouseEvent().isControlDown()){			
			if (newSelection instanceof NodeSelection || newSelection instanceof UmlConnectionSelection || newSelection instanceof MultiSelection || newSelection instanceof RubberbandSelector ) {
				ArrayList<DiagramElement> allElement = new ArrayList<DiagramElement>();				
				List<DiagramElement> selectedElement = selection.getElements();	
				allElement.addAll(selectedElement);
				List<DiagramElement> newSelectedElement = newSelection.getElements();				
				// select new elements...
				for(DiagramElement elem: newSelectedElement){
					if (!selectedElement.contains(elem)) allElement.add(elem);						
				}
				// in case of clicking in an already selected element: deselect it.					
				if(selectedElement.containsAll(newSelectedElement)){
					DiagramElement deselection = currentEditor().getDiagram().getChildAt(mx, my);						
					allElement.remove(deselection);
				}										
				selection = new MultiSelection(currentEditor(), allElement);			
			}else{
				selection = newSelection;
			}
		}else{
			selection = newSelection;
		}		
		// Dragging only if left mouse button was pressed
		if (e.isMainButton()){			
			if (isNothingSelected() && currentEditor().getDiagram().contains(mx, my)) {
				selection = rubberSelector;
				selection.updatePosition(mx, my);
			}			
			startPoint.setLocation(mx,my);
			selection.startDragging(mx, my);
		}
	}

	//---- selection mode utilities ---
	
	public List<AssociationElement> getSelectedAssociationElements(){
		List<AssociationElement> result = new ArrayList<AssociationElement>();
		for(DiagramElement de: getSelectedElements()){
			if(de instanceof AssociationElement){
				result.add((AssociationElement)de);
			}
		}	
		return result;
	}
	
	public List<ClassElement>getSelectedClassElements(){
		List<ClassElement> result = new ArrayList<ClassElement>();
		for(DiagramElement de: getSelectedElements()){
			if(de instanceof ClassElement){
				result.add((ClassElement)de);
			}
		}	
		return result;
	}
	
	public Point2D.Double getCenterPointOnSelected(){
		double y = 0; double x = 0;
		List<ClassElement> list = getSelectedClassElements();
		Point2D.Double centerPoint = new Point2D.Double();
		if(list.size()==1) {
			centerPoint.x = list.get(0).getAbsCenterX();
			centerPoint.y = list.get(0).getAbsCenterY();
			return centerPoint;
		}				
		ClassElement top = getNodeAtTop(list);
		ClassElement right = getNodeAtRight(list);
		ClassElement left = getNodeAtLeft(list);
		ClassElement bottom = getNodeAtBottom(list);
		if(top!=null && bottom !=null) y = top.getAbsCenterY()+((bottom.getAbsCenterY()-top.getAbsCenterY())/2);
		if(left!=null && right !=null) x = right.getAbsCenterX()-((right.getAbsCenterX()-left.getAbsCenterX())/2);
		centerPoint.x = x; 
		centerPoint.y = y;
		return centerPoint;
	}
	
	public Rectangle2D getSelectedBounds(){
		List<ClassElement> list = getSelectedClassElements();		
		ClassElement top = getNodeAtTop(list);
		ClassElement right = getNodeAtRight(list);
		ClassElement left = getNodeAtLeft(list);
		ClassElement bottom = getNodeAtBottom(list);
		Rectangle2D bounds = top.getAbsoluteBounds();
		bounds.setRect(left.getAbsoluteX1(), top.getAbsoluteY1(),
			right.getAbsoluteX2() - left.getAbsoluteX1(), 
			bottom.getAbsoluteY2() - top.getAbsoluteY1()
		);		
		return bounds;
	}
	
	public ClassElement getNodeAtBottom(List<ClassElement> list){
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
	
	public ClassElement getNodeAtTop(List<ClassElement> list){
		StructureDiagram diagram = AppTabManager.get().getCurrentDiagramEditor().getDiagram();
		double maxY1 = diagram.getSize().getWidth();
		ClassElement atTopElement = null;
		for(DiagramElement de: list){
			if(((ClassElement)de).getAbsoluteY1()<maxY1) {
				maxY1 = ((ClassElement)de).getAbsoluteY1();
				atTopElement = (ClassElement)de;				
			}
		}
		return atTopElement;
	}

	public ClassElement getNodeAtLeft(List<ClassElement> list){
		StructureDiagram diagram = AppTabManager.get().getCurrentDiagramEditor().getDiagram();
		double maxX1 = diagram.getSize().getWidth();
		ClassElement atLeftElement = null;
		for(ClassElement de: list){
			if(((ClassElement)de).getAbsoluteX1()<maxX1) {
				maxX1 = ((ClassElement)de).getAbsoluteX1();
				atLeftElement = (ClassElement)de;				
			}
		}
		return atLeftElement;
	}
	
	public ClassElement getNodeAtRight(List<ClassElement> list){
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
		
	private void showSelectionPopupMenu(EditorMouseEvent e) {
		double mx = e.getX(), my = e.getY();
		Selection selection = select(mx, my);		
		if (isNothingSelected()) return;
		if(selection.getElement() instanceof StructureDiagram) return;			
		final JPopupMenu menu = createSelectionPopupMenu(selection,mx,my);
		menu.show(e.getMouseEvent().getComponent(), e.getMouseEvent().getX(), e.getMouseEvent().getY());
	}
	
	private JPopupMenu createSelectionPopupMenu(Selection selection, double x, double y) {		
		List<UmlDiagramElement> filteredSelection = retainOnly(selection.getElements(), UmlDiagramElement.class);		
		if(filteredSelection.size()==1) {
			return new SingleElementPopupMenu(AppCmdListener.get(), filteredSelection.get(0));		
		}
		if (selection.getElements().size() > 1){ 			
			return new MultiElementPopupMenu(AppCmdListener.get(), filteredSelection);
		}
		return new JPopupMenu("No Action Available");
	}
	
	@SuppressWarnings("unchecked")
	private <T> List<T> retainOnly(List<?> objectList, Class<T> type_){
		List<T> filteredList = new ArrayList<>();		
		for (Object diagramElement : objectList) {
			if(type_.isInstance(diagramElement)){
				filteredList.add((T) diagramElement);
			}
		}		
		return filteredList;
	}	
}
