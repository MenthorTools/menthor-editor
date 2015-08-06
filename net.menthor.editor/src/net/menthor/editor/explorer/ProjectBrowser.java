package net.menthor.editor.explorer;

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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.AppFrame;
import net.menthor.editor.explorer.dnd.TreeDragGestureListener;
import net.menthor.editor.explorer.dnd.TreeDropListener;
import net.menthor.editor.ui.AlloySpecification;
import net.menthor.editor.ui.AntiPatternList;
import net.menthor.editor.ui.UmlProject;
import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.UmlDiagram;
import net.menthor.editor.v2.ui.RoundedPanel;
import net.menthor.ontouml2alloy.OntoUML2AlloyOptions;
import net.menthor.tocl.tocl2alloy.TOCL2AlloyOption;

/**
 * @author John Guerson
 */
public class ProjectBrowser extends RoundedPanel{

	//Keeps track of the trees instantiated in order to not re-instantite them 
	private static Map<UmlProject, ProjectBrowser> treeMap = new HashMap<UmlProject, ProjectBrowser>();
	
	private static final long serialVersionUID = 5598591779372431118L;	
	public static AppFrame frame;
	private ProjectToolBar ptoolbar;
	private JScrollPane scroll;
	private ProjectTree tree;
	//======
		
			
	@SuppressWarnings("unchecked")
	public List<UmlDiagram> getAllDiagrams()
	{
		return (List<UmlDiagram>) Models.getProject().getDiagrams();
	}
	
	public void addTreeSelectionListener(TreeSelectionListener selectionListener) {
		tree.addTreeSelectionListener(selectionListener);
	}	
	
	public ProjectBrowser(AppFrame appframe, UmlProject project, OclDocument oclDoc)
	{
		super();
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		Models.setProject(project);
		frame = appframe;		
		scroll = new JScrollPane();		
		if (project!=null) setProject(project);
		add(scroll, BorderLayout.CENTER);			
		RoundedPanel emptyTempPanel = new RoundedPanel();
		emptyTempPanel.setBackground(Color.WHITE);
		emptyTempPanel.setBorder(new EmptyBorder(0,0, 0, 0));
		scroll.setViewportView(emptyTempPanel);		
		emptyTempPanel.setPreferredSize(new Dimension(200,250));
		scroll.setPreferredSize(new Dimension(200,250));
		setPreferredSize(new Dimension(216, 317));
	}
	
	public void refreshTree()
	{				
		tree.updateUI();				
		validate();
		repaint();		
	}
	
	public void clear()
	{
		Models.setProject(null);
		Models.setRefparser(null);
		Models.getOclDocList().clear();
		RoundedPanel emptyTempPanel = new RoundedPanel();
		emptyTempPanel.setBackground(Color.WHITE);
		emptyTempPanel.setBorder(new EmptyBorder(0,0, 0, 0));
		scroll.setViewportView(emptyTempPanel);		
		emptyTempPanel.setPreferredSize(new Dimension(200,250));		
		updateUI();
	}
	
	public ProjectTree getTree() { return tree; }
	
	@SuppressWarnings("unused")
	public void setProject(UmlProject project)
	{
		Models.setProject(project);		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(project);
		System.out.println("Creating OntoUML parser");
		Models.setRefparser(new OntoUMLParser(project.getModel()));				
		System.out.println("Creating project browser tree");		
		
		tree = new ProjectTree(frame, root,project,Models.getRefparser(),Models.getOclDocList());
		tree.setBorder(new EmptyBorder(2,2,2,2));
		tree.addTreeSelectionListener(new ProjectTreeSelectionListener());
		
		/**drag from the tree and drop at the same tree*/
		DragSource ds = DragSource.getDefaultDragSource();
	    ds.createDefaultDragGestureRecognizer(tree, DnDConstants.ACTION_MOVE, new TreeDragGestureListener());
	    DropTarget dt = new DropTarget(tree, new TreeDropListener(tree));
	    	    
		/** Delete Key Stroke */
		tree.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.CTRL_MASK), "delete");		
		tree.getActionMap().put("delete", new AbstractAction() {			
			private static final long serialVersionUID = -340479571291150368L;			
			@Override
		    public void actionPerformed(ActionEvent e) {
		       frame.getDiagramManager().delete(tree.getSelectedNode().getUserObject());
		    }
		});

		String name = ((RefOntoUML.Package)project.getResource().getContents().get(0)).getName();
		if (name==null || name.isEmpty()) name = "model";		
		Models.setAlloySpec(new AlloySpecification(project.getTempDir()+File.separator+name.toLowerCase()+".als"));				
		Models.setOclOptions(new TOCL2AlloyOption());		
		Models.setRefOptions(new OntoUML2AlloyOptions());		
		Models.setAntipatterns(new AntiPatternList());		
		System.out.println("Creating modeling assistant");
		ptoolbar = new ProjectToolBar(tree,frame.getDiagramManager());
		add(ptoolbar, BorderLayout.NORTH);		
		scroll.setViewportView(tree);		
		treeMap.put(project, this);		
		updateUI();		
	}

	public void setTree(ProjectTree tree)
	{
		remove(scroll);		
		this.tree = tree;
		this.tree.setBorder(new EmptyBorder(2,2,2,2));		
		this.addTreeSelectionListener(new ProjectTreeSelectionListener());	
		scroll = new JScrollPane();
		scroll.setViewportView(tree);
		add(scroll, BorderLayout.CENTER);				
		scroll.validate();
		scroll.repaint();
		this.validate();
		this.repaint();
	}
	
	class ProjectTreeSelectionListener implements TreeSelectionListener 
	{
		@Override
		public void valueChanged(TreeSelectionEvent e) 
		{
			tree.requestFocus();
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
			if(node!=null)
			{				
				if (node.getUserObject()!=null && node.getParent() != null && (node.getUserObject() instanceof StructureDiagram) && !(((DefaultMutableTreeNode)node.getParent()).getUserObject() instanceof UmlProject))
				{
					frame.getDiagramManager().select((StructureDiagram)node.getUserObject());
				}
				else if(node.getUserObject()!=null && node.getParent() != null && (node.getUserObject() instanceof OclDocument) && (((DefaultMutableTreeNode)node.getParent()).getUserObject() instanceof OclDocument))
				{					
					frame.getDiagramManager().select((OclDocument)node.getUserObject());
				}
			}
		}		
	}
}
