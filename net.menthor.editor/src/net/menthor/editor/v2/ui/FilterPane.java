package net.menthor.editor.v2.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.parser.OntoUMLParser;
import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.ui.tree.ProjectTree;
import net.menthor.editor.v2.ui.tree.SimpleDiagramTree;
import net.menthor.editor.v2.ui.tree.TreeCheckPane;
import net.menthor.editor.v2.ui.tree.TreeVisibility;

public class FilterPane extends JPanel {
	
	private static final long serialVersionUID = 1603594735794477309L;
		
	//tree
	private ProjectTree elemTree;
	private SimpleDiagramTree diagramTree;
	private TreeType activeTreeType = TreeType.BY_ELEMENT;
	private boolean isExpanded = false;
	private TreeCheckPane optPane = new TreeCheckPane();
	private JScrollPane scrollPane = new JScrollPane();
	private JPanel wrapperPane = new JPanel();	
	
	//find
	private JTextField findText;
	private JPanel findPanel;
	private JButton findButton;	
	private String lastTextFound = new String();
	private List<DefaultMutableTreeNode> lastFoundNodes = new ArrayList<DefaultMutableTreeNode>();
	private int currentIndex = 0;
	private JPanel textPanel;
	private JButton btnExpandAll;
	private JPanel btnPanel;
	@SuppressWarnings("rawtypes")
	private JComboBox treeTypeCombo;
	private JPanel searchPane;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FilterPane(){
		setBorder(new EmptyBorder(10, 5, 5, 5));
		setLayout(new BorderLayout(7,7));				
		setPreferredSize(new Dimension(529, 400));				
		optPane.setPreferredSize(new Dimension(162, 100));
		add(optPane, BorderLayout.EAST);				
		wrapperPane.setBackground(Color.WHITE);
		wrapperPane.setBorder(new EmptyBorder(0,0, 0, 0));
		wrapperPane.setPreferredSize(new Dimension(210,250));		
		scrollPane.setViewportView(wrapperPane);				
		scrollPane.setPreferredSize(new Dimension(210,250));		
		add(scrollPane,BorderLayout.CENTER);				
		findPanel = new JPanel();
		add(findPanel, BorderLayout.NORTH);
		findPanel.setLayout(new BorderLayout(0, 0));		
		textPanel = new JPanel();
		findPanel.add(textPanel);
		textPanel.setLayout(new BorderLayout(3, 3));		
		btnPanel = new JPanel();
		textPanel.add(btnPanel, BorderLayout.EAST);
		btnPanel.setLayout(new BorderLayout(2, 2));		
		btnExpandAll = new JButton("Expand All");
		btnPanel.add(btnExpandAll, BorderLayout.WEST);		
		treeTypeCombo = new JComboBox();
		treeTypeCombo.setModel(new DefaultComboBoxModel(new String[] {"By Element", "By Diagram"}));
		treeTypeCombo.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(treeTypeCombo.getSelectedIndex()==0){
					activeTreeType=TreeType.BY_ELEMENT;
				}
				if(treeTypeCombo.getSelectedIndex()==1){
					activeTreeType=TreeType.BY_DIAGRAM;
				}
				ProjectTree tree = getActiveTree();		
				tree.setBorder(new EmptyBorder(2,2,2,2));				
				scrollPane.setViewportView(tree);		
				optPane.setTree(tree);				
				updateUI();
			}
		});		
		btnPanel.add(treeTypeCombo, BorderLayout.CENTER);		
		searchPane = new JPanel();
		textPanel.add(searchPane, BorderLayout.CENTER);
		searchPane.setLayout(new BorderLayout(0, 0));		
		findText = new JTextField();
		searchPane.add(findText);
		findText.setPreferredSize(new Dimension(100, 20));
		findText.setMargin(new Insets(2, 6, 2, 2));
		findText.setColumns(38);		
		findButton = new JButton("");
		searchPane.add(findButton, BorderLayout.EAST);
		findButton.setFocusable(false);
		findButton.setPreferredSize(new Dimension(60, 28));
		findButton.setText("Find");
		findButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				findOnTree();
			}
		});
		findText.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				findOnTree();
			}
		});
		btnExpandAll.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isExpanded) isExpanded=false; else isExpanded=true;
				setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				if(!isExpanded){
					if(activeTreeType==TreeType.BY_ELEMENT) elemTree.expandAll();
					if(activeTreeType==TreeType.BY_DIAGRAM) diagramTree.expandAll();
				}else{
					if(activeTreeType==TreeType.BY_ELEMENT) elemTree.colapseAll();
					if(activeTreeType==TreeType.BY_DIAGRAM) diagramTree.colapseAll();
				}
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));				
			}
		});
	}
	
	public OntoUMLParser getParser() { return getActiveTree().getParser(); }
	public ProjectTree getFilter() { return getActiveTree(); }
	
	public OntoUMLParser getFilteredParser(){					
		getParser().select(getCheckedElements(),true);		
		return getParser();	
	}
	
	public List<EObject> getCheckedElements(){
		List<EObject> result = new ArrayList<EObject>();
		for(Object c: getActiveTree().getCheckedObjects()){
			if(c instanceof EObject)result.add((EObject)c);
		}
		return result;
	}
	
	protected ProjectTree getActiveTree(){
		ProjectTree active;
		if(activeTreeType == TreeType.BY_DIAGRAM) active = diagramTree; else active = elemTree;
		return active;
	}

	public enum TreeType{
		BY_ELEMENT("By Element"), BY_DIAGRAM("By Diagram");
		private String value;
		TreeType(String value){
			this.value=value;
		}
		public String value() { return value; }
	}
	
	public void fillTree(OntoUMLParser refparser){
		activeTreeType=TreeType.BY_ELEMENT;
		fillTree(refparser, null);		
	}
	
	public void fillTree(OntoUMLParser refparser, List<OntoumlDiagram> diagrams){
		diagramTree = SimpleDiagramTree.createDiagramTree(refparser, diagrams, new TreeVisibility(),true);
		elemTree = ProjectTree.create(null, refparser, new TreeVisibility(),true);
		ProjectTree tree = getActiveTree();		
		if(tree!=null) tree.setBorder(new EmptyBorder(2,2,2,2));				
		scrollPane.setViewportView(tree);		
		optPane.setTree(tree);
		updateUI();						
	}	
	
	public void findOnTree() {
		ProjectTree tree = getActiveTree();		
		tree.resetSelection();
		if(findText.getText().equals(lastTextFound)) {						
			if(currentIndex < lastFoundNodes.size()) { tree.select(lastFoundNodes.get(currentIndex)); currentIndex++; } 
			else if(lastFoundNodes.size()>0) { currentIndex=0; tree.select(lastFoundNodes.get(currentIndex)); }			
		}else{			
			lastTextFound = findText.getText();
			currentIndex=0; 
			lastFoundNodes = tree.findName(lastTextFound);
			if(currentIndex < lastFoundNodes.size()) tree.select(lastFoundNodes.get(currentIndex));
		}
	}
	
	public void refresh(){				
		ProjectTree tree = getActiveTree();
		if(tree!=null) tree.updateUI();		
		validate();
		repaint();		
	}
	
	public void clear(){
		JPanel emptyTempPanel = new JPanel();
		emptyTempPanel.setBackground(Color.WHITE);
		emptyTempPanel.setBorder(new EmptyBorder(0,0, 0, 0));
		scrollPane.setViewportView(emptyTempPanel);		
		emptyTempPanel.setPreferredSize(new Dimension(200,250));		
		updateUI();
	}
}
