package net.menthor.editor.popupmenu;

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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultMutableTreeNode;

import org.tinyuml.ui.diagram.DiagramEditor;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.Association;
import RefOntoUML.Element;
import RefOntoUML.EnumerationLiteral;
import RefOntoUML.Generalization;
import RefOntoUML.Property;
import RefOntoUML.Type;
import RefOntoUML.util.RefOntoUMLElement;
import net.menthor.editor.AppFrame;
import net.menthor.editor.dialog.DiagramListDialog;
import net.menthor.editor.explorer.ProjectBrowser;
import net.menthor.editor.ui.DiagramWrapper;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.menus.AddClassMenu;
import net.menthor.editor.v2.menus.AddDataTypeMenu;
import net.menthor.editor.v2.menus.AddRelationshipMenu;
import net.menthor.editor.v2.menus.ChangeClassMenu;
import net.menthor.editor.v2.menus.ChangeRelationshipMenu;
import net.menthor.editor.v2.trees.ProjectTree;
import net.menthor.editor.v2.types.RelationshipType;

/**
 * @author John Guerson
 */
public class TreePopupMenu extends JPopupMenu {
 
	private static final long serialVersionUID = 1L;
	public Object element;
	public AppFrame frame;
	public ProjectTree tree;
	public DefaultMutableTreeNode selectedNode;
	
	public void createRefreshItem()
	{    	
		JMenuItem refreshItem = new JMenuItem("Refresh");
		add(refreshItem);
		refreshItem.addActionListener(new ActionListener() {				
			@Override
			public void actionPerformed(ActionEvent e) {    				
				frame.getBrowserManager().getProjectBrowser().refreshTree();
			}
		});    	    	
	}
	
	public void createAddDiagramItem()
	{
		JMenuItem addDiagramItem = new JMenuItem("Add Diagram");
		add(addDiagramItem);
		addDiagramItem.addActionListener(new ActionListener() {				
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.getDiagramManager().newDiagram();    				
			}
		});
	}
	
	public void createAddOCLDocumentItem()
	{
		JMenuItem addOCLDocumentItem = new JMenuItem("Add Document");
		add(addOCLDocumentItem);
		addOCLDocumentItem.addActionListener(new ActionListener() {				
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.getDiagramManager().newOclDocument(true);    				
			}
		});
	}
	
	public void createRenameItem()
	{
		JMenuItem setNameItem = new JMenuItem("Rename");
		add(setNameItem);    		
		setNameItem.addActionListener(new ActionListener() {				
			@Override
			public void actionPerformed(ActionEvent e) {				
				Object elem = TreePopupMenu.this.element;
				if (elem instanceof StructureDiagram){
					ProjectBrowser.frame.getDiagramManager().renameDiagram((StructureDiagram)elem);					
				}
				else if (elem instanceof OclDocument){
					ProjectBrowser.frame.getDiagramManager().renameOclDocument((OclDocument)elem);					
				} 
				else if (elem instanceof RefOntoUML.Element){						    					
					ProjectBrowser.frame.getDiagramManager().renameElement((RefOntoUML.Element)element);
				}								 
			}
		});
	}
	
	public void createMoveToDiagramItem()
	{
		final Object ontoElement = selectedNode.getUserObject();  
		JMenuItem moveToDiagramItem = new JMenuItem("Move to Diagram");
		add(moveToDiagramItem);    			    			
		moveToDiagramItem.addActionListener(new ActionListener() {				
			@Override
			public void actionPerformed(ActionEvent e) {
				DiagramEditor d = frame.getDiagramManager().getCurrentDiagramEditor();
				frame.getDiagramManager().moveToDiagram((RefOntoUML.Element)ontoElement, d);        			
			};
		});    
	}
	
	public void createClassChangeItem()
	{
		final Object ontoElement = selectedNode.getUserObject();  
		final Type type = (Type)ontoElement;
		ChangeClassMenu changeMenu = new ChangeClassMenu(frame);		
		add(changeMenu);	
		changeMenu.setContext(type);
	}
	
	public void createRelationChangeItem()
	{
		final Object ontoElement = (selectedNode.getUserObject());  
		final Type type = (Type)ontoElement;
		ChangeRelationshipMenu changeMenu = new ChangeRelationshipMenu(frame);		
		add(changeMenu);
		changeMenu.setContext(type);
	}
	
	public void createAddElementItem()
	{
		Object ontoElement = (selectedNode.getUserObject());
		AddClassMenu addClassMenu = new AddClassMenu(frame);
		AddDataTypeMenu addDataTypeMenu = new AddDataTypeMenu(frame);
		add(addClassMenu);
		add(addDataTypeMenu);
		addClassMenu.setContext(ontoElement);
		addDataTypeMenu.setContext(ontoElement);
		//Add GeneralizationSet
		//AddPackage
	}
	
	public void createAddRelationItem()
	{
		Object ontoElement = (selectedNode.getUserObject());		
		AddRelationshipMenu addRelationMenu = new AddRelationshipMenu(frame);
		add(addRelationMenu);
		addRelationMenu.setContext(ontoElement);
	}
	
	public void createAddContainedItem()
	{
		Object ontoElement = (selectedNode.getUserObject());
		final RefOntoUML.Type eContainer = (RefOntoUML.Type)ontoElement;
		JMenu addItem = new JMenu("Add");
		JMenuItem addGenItem = new JMenuItem("Generalization");
		JMenuItem addCommentItem = new JMenuItem("Comment");
		JMenuItem addConstraintItem = new JMenuItem("Constraintx");
		addItem.add(addGenItem);    			
		addItem.add(addCommentItem);
		addItem.add(addConstraintItem);
		add(addItem);
		addGenItem.addActionListener(new ActionListener() {				
	        	@Override
	        	public void actionPerformed(ActionEvent e) {
	        		frame.getDiagramManager().addRelation(RelationshipType.GENERALIZATION,eContainer);
	        	}
	        });
		addCommentItem.addActionListener(new ActionListener() {				
	        	@Override
	        	public void actionPerformed(ActionEvent e) {
	        		frame.getDiagramManager().addComment(eContainer);
	        	}
	        });
		addConstraintItem.addActionListener(new ActionListener() {				
	        	@Override
	        	public void actionPerformed(ActionEvent e) {
	        		frame.getDiagramManager().addConstraintx("",eContainer);
	        	}
	        });
		addGenItem.setIcon(new ImageIcon(DiagramWrapper.class.getResource("/resources/icons/x16/tree/generalization.png")));
		addCommentItem.setIcon(new ImageIcon(DiagramWrapper.class.getResource("/resources/icons/x16/tree/comment.png")));
		addConstraintItem.setIcon(new ImageIcon(DiagramWrapper.class.getResource("/resources/icons/x16/tree/constraintx.png")));
	}
	
	public void createInvertItem()
	{
		Object ontoElement = (selectedNode.getUserObject());
		final Association association = (Association)ontoElement;
		
		JMenu invertMenu = new JMenu("Invert");
		add(invertMenu);
			
		JMenuItem invertEndPointsItem = new JMenuItem("End Points");
		invertMenu.add(invertEndPointsItem);    			
		invertEndPointsItem.addActionListener(new ActionListener() {				
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		frame.getDiagramManager().invertEndPoints(association);
        	}
        });
		
		JMenuItem invertEndNamesItem = new JMenuItem("End Names");
		invertMenu.add(invertEndNamesItem);    			
		invertEndNamesItem.addActionListener(new ActionListener() {				
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		frame.getDiagramManager().invertEndNames(association);
        	}
        });
		
		JMenuItem invertEndMultiplicitiesItem = new JMenuItem("End Multiplicities");
		invertMenu.add(invertEndMultiplicitiesItem);    			
		invertEndMultiplicitiesItem.addActionListener(new ActionListener() {				
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		frame.getDiagramManager().invertEndMultiplicities(association);
        	}
        });
		
		JMenuItem invertEndTypesItem = new JMenuItem("End Types");
		invertMenu.add(invertEndTypesItem);    			
		invertEndTypesItem.addActionListener(new ActionListener() {				
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		frame.getDiagramManager().invertEndTypes(association);
        	}
        });		
	}
	
	/** Returns true iff running on Mac OS X. **/
	public static boolean onMac() {
      return System.getProperty("mrj.version")!=null || System.getProperty("os.name").toLowerCase(Locale.US).startsWith("mac ");                                     
	}
	
	public void createDeleteItem()
	{
		JMenuItem deleteItem = new JMenuItem("Delete");		
		add(deleteItem);
		deleteItem.setIcon(new ImageIcon(TreePopupMenu.class.getResource("/resources/icons/x16/cross.png")));
		deleteItem.addActionListener(new ActionListener() {				
			@Override
			public void actionPerformed(ActionEvent e) {				
				frame.getDiagramManager().delete(TreePopupMenu.this.element);				
			}
		});
	}
	
	public void createFinInDiagramItem()
	{
		final Object ontoElement = (selectedNode.getUserObject());
		JMenuItem findDiagramItem = new JMenuItem("Find in Diagrams");
		add(findDiagramItem);		
		findDiagramItem.addActionListener(new ActionListener() {				
			@Override
			public void actionPerformed(ActionEvent e) {							
				ArrayList<DiagramEditor> diagrams = ProjectBrowser.frame.getDiagramManager().getDiagramEditors((Element)ontoElement);
				DiagramListDialog.open(ProjectBrowser.frame, diagrams,(Element)ontoElement);
			}
		});
	}
	
    public TreePopupMenu(final AppFrame frame, final ProjectTree tree, Object element)
    {       
    	this.element = element; 
    	this.frame = frame;
    	this.tree = tree;
    	
    	DefaultMutableTreeNode node = ((DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent());
    	this.selectedNode = node;
    	
    	// Root Node: Application Project
    	if (tree.getRootNode().equals(selectedNode)) {
    		createRefreshItem();  
    		return;
    	} 
    	
    	// Model Node: Model
    	if (tree.getRootNode().equals(selectedNode)) {
    		createAddElementItem();
			createAddRelationItem();
    		//createCompleteItem();
    		return;
    	} 
    	
    	// Diagram Node: Diagrams
    	if(tree.getRootNode().equals(selectedNode)) {
    		createAddDiagramItem();
    		return;
    	} 

    	if(tree.getRootNode().equals(selectedNode)){
    		createAddOCLDocumentItem();
    		return;
    	}
    	
    	// Diagrams...
    	if ((TreePopupMenu.this.element instanceof StructureDiagram)) {
    		createRenameItem();
    	}
    	
    	// OCL Documents...
    	if (TreePopupMenu.this.element instanceof OclDocument) {
    		createRenameItem(); 
    		createDeleteItem();
    	}
    	
    	// Model Elements...
    	
    	if ((!(TreePopupMenu.this.element instanceof StructureDiagram)) && (!(TreePopupMenu.this.element instanceof OclDocument)) && 
    		!((RefOntoUML.Element)TreePopupMenu.this.element instanceof Generalization)) {
    		createRenameItem();
    	}
    	
    	if(selectedNode.getUserObject() instanceof StructureDiagram)
    	{
    		createDeleteItem();
    	}
    	
		if (selectedNode.getUserObject() instanceof RefOntoUMLElement)
		{
    		final RefOntoUMLElement ontoElement = ((RefOntoUMLElement)selectedNode.getUserObject());    		
    		if(ontoElement.getElement() instanceof RefOntoUML.Type || ontoElement.getElement() instanceof RefOntoUML.Generalization)
    		{
    			createMoveToDiagramItem();
    			createFinInDiagramItem();
    		}		   		
    		if(ontoElement.getElement() instanceof RefOntoUML.Class)
    		{    			
    			createAddContainedItem();
    			createClassChangeItem();    			
    		}
    		if((ontoElement.getElement() instanceof RefOntoUML.DataType) && !(ontoElement.getElement() instanceof RefOntoUML.PrimitiveType) && !(ontoElement.getElement() instanceof RefOntoUML.Enumeration))
    		{
    			createAddContainedItem();
    			createClassChangeItem();    			 	
    		}
    		if(ontoElement.getElement() instanceof RefOntoUML.Enumeration)
    		{    			
    			createAddContainedItem();
    		}
    		if(ontoElement.getElement() instanceof RefOntoUML.PrimitiveType)
    		{    			
    			    			 	
    		}
    		if(ontoElement.getElement() instanceof RefOntoUML.Association)
    		{ 
    			createRelationChangeItem();
    			createInvertItem();
    		}
    		if(ontoElement.getElement() instanceof RefOntoUML.Package)
    		{
    			createAddElementItem();
    			createAddRelationItem();
    		}
    		if (!(ontoElement.getElement() instanceof Property) && !(ontoElement.getElement() instanceof EnumerationLiteral))
    		{
    			createDeleteItem();
    		} 
		}    	
    }
}
