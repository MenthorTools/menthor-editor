package net.menthor.editor.transformation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;

import org.eclipse.emf.ecore.EObject;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.parser.OntoUMLParser;

public class FilterPane extends JPanel {
	
	private static final long serialVersionUID = 1603594735794477309L;
		
	//tree
	private ElementTree elemTree;
	private DiagramTree diagramTree;
	private JScrollPane scrollTreePane = new JScrollPane();
	private JPanel treeWrapper = new JPanel();
	private TreeType activeTree = TreeType.BY_ELEMENT;
	
	//options
	private ElementTreeCheckingPane optPane = new ElementTreeCheckingPane();
	
	//find
	private JTextField findText;
	private JPanel findPanel;
	private JButton findButton;	
	private String lastTextFound = new String();
	private List<DefaultMutableTreeNode> lastFoundNodes = new ArrayList<DefaultMutableTreeNode>();
	private int currentIndex = 0;
	private JPanel textPanel;
	private Component horizontalStrut;
	private JButton btnExpandAll;
	private JPanel btnPanel;
	@SuppressWarnings("rawtypes")
	private JComboBox treeTypeCombo;
	private Component horizontalStrut_1;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public FilterPane()
	{
		setLayout(new BorderLayout(0,0));				
		setPreferredSize(new Dimension(529, 400));
		optPane.setBorder(new EmptyBorder(4, 4, 4, 4));
		
		optPane.setPreferredSize(new Dimension(100, 125));
		add(optPane, BorderLayout.NORTH);
		
		findPanel = new JPanel();
		optPane.add(findPanel, BorderLayout.SOUTH);
		findPanel.setLayout(new BorderLayout(0, 0));
		
		textPanel = new JPanel();
		findPanel.add(textPanel);
		textPanel.setLayout(new BorderLayout(0, 0));
		
		findText = new JTextField();
		textPanel.add(findText);
		findText.setMargin(new Insets(2, 6, 2, 2));
		findText.setColumns(10);
		
		horizontalStrut = Box.createHorizontalStrut(37);
		horizontalStrut.setPreferredSize(new Dimension(5, 0));
		textPanel.add(horizontalStrut, BorderLayout.EAST);
		
		btnPanel = new JPanel();
		textPanel.add(btnPanel, BorderLayout.WEST);
		btnPanel.setLayout(new BorderLayout(3, 3));
		
		btnExpandAll = new JButton("Expand All");
		btnPanel.add(btnExpandAll, BorderLayout.CENTER);
		
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
				tree.expandAll();
				updateUI();
			}
		});
		
		btnPanel.add(treeTypeCombo, BorderLayout.WEST);
		
		horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setPreferredSize(new Dimension(5, 0));
		btnPanel.add(horizontalStrut_1, BorderLayout.EAST);
		btnExpandAll.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				if(activeTree==TreeType.BY_ELEMENT) elemTree.expandAll();
				if(activeTree==TreeType.BY_DIAGRAM) diagramTree.expandAll();
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));				
			}
		});
		
		findButton = new JButton("");
		findButton.setContentAreaFilled(false);
		findButton.setOpaque(false);
		findButton.setFocusPainted(false);
		findButton.setFocusable(false);
		findButton.setBorderPainted(false);
		findPanel.add(findButton, BorderLayout.EAST);
		findButton.setPreferredSize(new Dimension(30, 28));
		findButton.setIcon(new ImageIcon(FilterPane.class.getResource("/net/menthor/resources/images/find-24.png")));
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
				
		treeWrapper.setBackground(Color.WHITE);
		treeWrapper.setBorder(new EmptyBorder(0,0, 0, 0));
		treeWrapper.setPreferredSize(new Dimension(200,250));
		
		scrollTreePane.setViewportView(treeWrapper);				
		scrollTreePane.setPreferredSize(new Dimension(200,250));
		
		add(scrollTreePane,BorderLayout.CENTER);		
	}

	public enum TreeType{
		BY_ELEMENT("By Element"), BY_DIAGRAM("By Diagram");
		private String value;
		TreeType(String value){
			this.value=value;
		}
		public String value() { return value; }
	}
	
	public void fillContent(OntoUMLParser refparser, List<StructureDiagram> diagrams)
	{
		diagramTree = DiagramTree.createFilter(refparser, diagrams, new ElementVisibilityOption());
		elemTree = ElementTree.createFilter(refparser, new ElementVisibilityOption());
		ElementTree tree = getActiveTree();		
		tree.setBorder(new EmptyBorder(2,2,2,2));				
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
		return getActiveTree().getCheckedElements();
	}
}
