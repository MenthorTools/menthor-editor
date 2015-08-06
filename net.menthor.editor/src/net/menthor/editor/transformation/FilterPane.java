package net.menthor.editor.transformation;

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
import net.menthor.editor.v2.trees.DiagramStrictTree;
import net.menthor.editor.v2.trees.ElementTree;
import net.menthor.editor.v2.trees.ElementTreeVisibility;

public class FilterPane extends JPanel {
	
	private static final long serialVersionUID = 1603594735794477309L;
		
	//tree
	private ElementTree elemTree;
	private DiagramStrictTree diagramTree;
	private JScrollPane scrollTreePane = new JScrollPane();
	private JPanel treeWrapper = new JPanel();
	private TreeType activeTree = TreeType.BY_ELEMENT;
	private boolean isExpanded = false;
	
	//options
	private FilterOptionPane optPane = new FilterOptionPane();
	
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
	public FilterPane()
	{
		setBorder(new EmptyBorder(10, 5, 5, 5));
		setLayout(new BorderLayout(7,7));				
		setPreferredSize(new Dimension(529, 400));
				
		optPane.setPreferredSize(new Dimension(162, 100));
		add(optPane, BorderLayout.EAST);
				
		treeWrapper.setBackground(Color.WHITE);
		treeWrapper.setBorder(new EmptyBorder(0,0, 0, 0));
		treeWrapper.setPreferredSize(new Dimension(210,250));
		
		scrollTreePane.setViewportView(treeWrapper);				
		scrollTreePane.setPreferredSize(new Dimension(210,250));
		
		add(scrollTreePane,BorderLayout.CENTER);		
		
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
					activeTree=TreeType.BY_ELEMENT;
				}
				if(treeTypeCombo.getSelectedIndex()==1){
					activeTree=TreeType.BY_DIAGRAM;
				}
				ElementTree tree = getActiveTree();		
				tree.setBorder(new EmptyBorder(2,2,2,2));				
				scrollTreePane.setViewportView(tree);		
				optPane.setFilter(tree);				
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
//		findButton.setContentAreaFilled(false);
//		findButton.setOpaque(false);
//		findButton.setFocusPainted(false);
		findButton.setFocusable(false);
//		findButton.setBorderPainted(false);
		findButton.setPreferredSize(new Dimension(60, 28));
		findButton.setText("Find");
		findButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				find();
			}
		});
		findText.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				find();
			}
		});
		btnExpandAll.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isExpanded) isExpanded=false; else isExpanded=true;
				setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				if(!isExpanded){
					if(activeTree==TreeType.BY_ELEMENT) elemTree.expandAll();
					if(activeTree==TreeType.BY_DIAGRAM) diagramTree.expandAll();
				}else{
					if(activeTree==TreeType.BY_ELEMENT) elemTree.colapseAll();
					if(activeTree==TreeType.BY_DIAGRAM) diagramTree.colapseAll();
				}
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));				
			}
		});
	}

	public enum TreeType{
		BY_ELEMENT("By Element"), BY_DIAGRAM("By Diagram");
		private String value;
		TreeType(String value){
			this.value=value;
		}
		public String value() { return value; }
	}
	
	public void fillContent(OntoUMLParser refparser, List<OntoumlDiagram> diagrams)
	{
		diagramTree = DiagramStrictTree.createDiagramTree(refparser, diagrams, new ElementTreeVisibility(),true);
		elemTree = ElementTree.createElementTree(refparser, null,null, new ElementTreeVisibility(),true);
		ElementTree tree = getActiveTree();		
		if(tree!=null) tree.setBorder(new EmptyBorder(2,2,2,2));				
		scrollTreePane.setViewportView(tree);		
		optPane.setFilter(tree);
		updateUI();						
	}	
	
	public void fillContent(OntoUMLParser refparser)
	{
		activeTree=TreeType.BY_ELEMENT;
		fillContent(refparser, null);		
	}	
	
	protected ElementTree getActiveTree()
	{
		ElementTree active;
		if(activeTree == TreeType.BY_DIAGRAM) active = diagramTree; else active = elemTree;
		return active;
	}
	
	protected void find() 
	{
		ElementTree tree = getActiveTree();		
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
	
	public void refresh()
	{				
		ElementTree tree = getActiveTree();
		if(tree!=null) tree.updateUI();		
		validate();
		repaint();		
	}
	
	public void clear()
	{
		JPanel emptyTempPanel = new JPanel();
		emptyTempPanel.setBackground(Color.WHITE);
		emptyTempPanel.setBorder(new EmptyBorder(0,0, 0, 0));
		scrollTreePane.setViewportView(emptyTempPanel);		
		emptyTempPanel.setPreferredSize(new Dimension(200,250));		
		updateUI();
	}
	
	public OntoUMLParser getParser() { return getActiveTree().getParser(); }
	
	public OntoUMLParser getFilteredParser()
	{					
		getParser().select(getCheckedElements(),true);		
		return getParser();	
	}
	
	public ElementTree getFilter() { return getActiveTree(); }
	
	public List<EObject> getCheckedElements()
	{
		List<EObject> result = new ArrayList<EObject>();
		for(Object c: getActiveTree().getCheckedElements()){
			if(c instanceof EObject)result.add((EObject)c);
		}
		return result;
	}
}
