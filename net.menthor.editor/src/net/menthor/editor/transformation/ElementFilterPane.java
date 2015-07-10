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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.parser.OntoUMLParser;

public class ElementFilterPane extends JPanel {
	
	private static final long serialVersionUID = 1603594735794477309L;
	private JScrollPane scrollTreePane = new JScrollPane();
	private ElementFilterTree filterTree;	
	private JPanel treeWrapper = new JPanel();	
	private FilterOptionsPane optPane = new FilterOptionsPane();
	private JTextField findText;
	private JPanel findPanel;
	private JButton findButton;
	
	private String lastTextFound = new String();
	private List<DefaultMutableTreeNode> lastFoundNodes = new ArrayList<DefaultMutableTreeNode>();
	private int currentIndex = 0;
	private JPanel textPanel;
	private Component horizontalStrut;
	private JButton btnExpandAll;
	
	public ElementFilterPane()
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
		
		btnExpandAll = new JButton("Expand All");
		btnExpandAll.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				filterTree.expandAll();
				setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));				
			}
		});
		textPanel.add(btnExpandAll, BorderLayout.WEST);
		
		findButton = new JButton("");
		findButton.setContentAreaFilled(false);
		findButton.setOpaque(false);
		findButton.setFocusPainted(false);
		findButton.setFocusable(false);
		findButton.setBorderPainted(false);
		findPanel.add(findButton, BorderLayout.EAST);
		findButton.setPreferredSize(new Dimension(30, 28));
		findButton.setIcon(new ImageIcon(ElementFilterPane.class.getResource("/net/menthor/resources/images/find-24.png")));
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
	
	protected void find() 
	{
		filterTree.resetSelection();
		if(findText.getText().equals(lastTextFound)) {						
			if(currentIndex < lastFoundNodes.size()) { filterTree.select(lastFoundNodes.get(currentIndex)); currentIndex++; } 
			else { if(lastFoundNodes.size()>0) currentIndex=0; filterTree.select(lastFoundNodes.get(currentIndex)); }			
		}else{			
			lastTextFound = findText.getText();
			currentIndex=0; 
			lastFoundNodes = filterTree.findName(lastTextFound);
			if(currentIndex < lastFoundNodes.size()) filterTree.select(lastFoundNodes.get(currentIndex));
		}
	}
		
	
	
	public void refresh()
	{				
		filterTree.updateUI();				
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
	
	public OntoUMLParser getParser() { return filterTree.getParser(); }
	
	public OntoUMLParser getFilteredParser()
	{					
		getParser().select(getChecked(),true);		
		return getParser();	
	}
	
	public ElementFilterTree getFilter() { return filterTree; }
	
	public void fillContent(OntoUMLParser refparser)
	{
		//create tree pane
		filterTree = ElementFilterTree.createFilter(refparser, new FilterOptions());
		filterTree.setBorder(new EmptyBorder(2,2,2,2));				
		scrollTreePane.setViewportView(filterTree);				
		optPane.setFilter(filterTree);
		updateUI();		
	}	
	
	public List<EObject> getChecked()
	{
		return filterTree.getCheckedElements();
	}
}
