package net.menthor.editor.popupmenu;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconType;
import net.menthor.editor.v2.menus.BaseMenu;
import net.menthor.editor.v2.menus.BasePopupMenu;

/**
 * @author John Guerson
 */
public class TreePopupMenu extends BasePopupMenu {
 
	private static final long serialVersionUID = 1L;
	
//	public void createAddContainedItem()
//	{
//		Object ontoElement = (selectedNode.getUserObject());
//		final RefOntoUML.Type eContainer = (RefOntoUML.Type)ontoElement;
//		JMenu addItem = new JMenu("Add");
//		JMenuItem addGenItem = new JMenuItem("Generalization");
//		JMenuItem addCommentItem = new JMenuItem("Comment");
//		JMenuItem addConstraintItem = new JMenuItem("Constraintx");
//		addItem.add(addGenItem);    			
//		addItem.add(addCommentItem);
//		addItem.add(addConstraintItem);
//		add(addItem);
//		addGenItem.addActionListener(new ActionListener() {				
//	        	@Override
//	        	public void actionPerformed(ActionEvent e) {
//	        		frame.getDiagramManager().addRelation(RelationshipType.GENERALIZATION,eContainer);
//	        	}
//	        });
//		addCommentItem.addActionListener(new ActionListener() {				
//	        	@Override
//	        	public void actionPerformed(ActionEvent e) {
//	        		frame.getDiagramManager().addComment(eContainer);
//	        	}
//	        });
//		addConstraintItem.addActionListener(new ActionListener() {				
//	        	@Override
//	        	public void actionPerformed(ActionEvent e) {
//	        		frame.getDiagramManager().addConstraintx("",eContainer);
//	        	}
//	        });
//		addGenItem.setIcon(new ImageIcon(DiagramWrapper.class.getResource("/resources/icons/x16/tree/generalization.png")));
//		addCommentItem.setIcon(new ImageIcon(DiagramWrapper.class.getResource("/resources/icons/x16/tree/comment.png")));
//		addConstraintItem.setIcon(new ImageIcon(DiagramWrapper.class.getResource("/resources/icons/x16/tree/constraintx.png")));
//	}
//	
//	public void createInvertItem()
//	{
//		Object ontoElement = (selectedNode.getUserObject());
//		final Association association = (Association)ontoElement;
//		
//		JMenu invertMenu = new JMenu("Invert");
//		add(invertMenu);
//			
//		JMenuItem invertEndPointsItem = new JMenuItem("End Points");
//		invertMenu.add(invertEndPointsItem);    			
//		invertEndPointsItem.addActionListener(new ActionListener() {				
//        	@Override
//        	public void actionPerformed(ActionEvent e) {
//        		frame.getDiagramManager().invertEndPoints(association);
//        	}
//        });
//		
//		JMenuItem invertEndNamesItem = new JMenuItem("End Names");
//		invertMenu.add(invertEndNamesItem);    			
//		invertEndNamesItem.addActionListener(new ActionListener() {				
//        	@Override
//        	public void actionPerformed(ActionEvent e) {
//        		frame.getDiagramManager().invertEndNames(association);
//        	}
//        });
//		
//		JMenuItem invertEndMultiplicitiesItem = new JMenuItem("End Multiplicities");
//		invertMenu.add(invertEndMultiplicitiesItem);    			
//		invertEndMultiplicitiesItem.addActionListener(new ActionListener() {				
//        	@Override
//        	public void actionPerformed(ActionEvent e) {
//        		frame.getDiagramManager().invertEndMultiplicities(association);
//        	}
//        });
//		
//		JMenuItem invertEndTypesItem = new JMenuItem("End Types");
//		invertMenu.add(invertEndTypesItem);    			
//		invertEndTypesItem.addActionListener(new ActionListener() {				
//        	@Override
//        	public void actionPerformed(ActionEvent e) {
//        		frame.getDiagramManager().invertEndTypes(association);
//        	}
//        });		
//	}
	
	BaseMenu addclass;
	BaseMenu addrel;
	BaseMenu adddata;
	BaseMenu changeclass;
	BaseMenu changerel;
	
	@Override
	public void setContext(Object context){
		addclass.setContext(context);
		addrel.setContext(context);
		adddata.setContext(context);
		changeclass.setContext(context);
		changerel.setContext(context);
		super.setContext(context);
	}
	
    public TreePopupMenu(final CommandListener listener)
    {
    	super(listener);    	
    	createMenuItem("Add Diagram", CommandType.ADD_DIAGRAM);
    	createMenuItem("Add Rules Document", CommandType.ADD_RULES_DOCUMENT);
    	addSeparator();
    	addclass = MenuBuilder.buildAddClass(listener,this);			    	
    	addrel = MenuBuilder.buildAddRelationship(listener,this);
    	adddata = MenuBuilder.buildAddDataType(listener,this);
    	addSeparator();
    	createMenuItem("Rename", CommandType.RENAME);
    	addSeparator();
    	createMenuItem("Drag, and Drop on Diagram", IconType.MENTHOR_HAND_CURSOR, CommandType.MOVE_TO_DIAGRAM);    	
    	createMenuItem("Find In Diagrams", IconType.MENTHOR_SEARCH, CommandType.FIND_IN_DIAGRAMS);
    	addSeparator();
    	changeclass = MenuBuilder.buildChangeClassTo(listener, this);
    	changerel = MenuBuilder.buildChangeRelationshipTo(listener, this);
    	addSeparator();
    	createMenuItem("Delete", IconType.DELETE, CommandType.DELETE);
    	
//    	createAddContainedItem();
//    	createInvertItem();
    }
}
