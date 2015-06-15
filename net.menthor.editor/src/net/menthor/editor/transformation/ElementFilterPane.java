package net.menthor.editor.transformation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.Association;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.Property;
import RefOntoUML.Quality;
import RefOntoUML.ReferenceRegion;
import RefOntoUML.ReferenceStructure;
import RefOntoUML.Structuration;
import RefOntoUML.parser.OntoUMLParser;

public class ElementFilterPane extends JPanel {
	
	private static final long serialVersionUID = 1603594735794477309L;
	private JScrollPane scrollTreePane = new JScrollPane();
	private ElementFilterTree filterTree;	
	private JPanel treeWrapper = new JPanel();	
	private JPanel optPane = new JPanel();
	private JCheckBox genSetCheck;
	private JCheckBox attrCheck;
	private JCheckBox relCheck;
	private JCheckBox sourceCheck;
	private JCheckBox targetCheck;
	private JCheckBox quaCheck;
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
		
		JPanel selectionPanel = new JPanel();
		FlowLayout fl_selectionPanel = (FlowLayout) selectionPanel.getLayout();
		fl_selectionPanel.setAlignment(FlowLayout.LEFT);
		selectionPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Select/Unselect All", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		genSetCheck = new JCheckBox("Generalization sets");
		genSetCheck.setPreferredSize(new Dimension(155, 23));
		genSetCheck.setSelected(true);
		genSetCheck.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectAllGeneralizationSets(e);
			}
		});		
		selectionPanel.add(genSetCheck);
		
		attrCheck = new JCheckBox("Attributes");		
		attrCheck.setPreferredSize(new Dimension(140, 23));
		attrCheck.setSelected(true);
		attrCheck.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectAllAttributes(e);
			}
		});
		selectionPanel.add(attrCheck);
		
		quaCheck = new JCheckBox("Qualities & Structures");
		quaCheck.setPreferredSize(new Dimension(140, 23));
		quaCheck.setSelected(true);
		quaCheck.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectAllQualities(e);
			}
		});
		selectionPanel.add(quaCheck);		
				
		relCheck = new JCheckBox("Associations (with all ends)");
		relCheck.setSelected(true);
		relCheck.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectAllAssociations(e);
			}
		});
		selectionPanel.add(relCheck);
		
		targetCheck = new JCheckBox("Association Target Ends");		
		targetCheck.setSelected(true);
		targetCheck.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectAllTargets(e);
			}
		});
		optPane.setLayout(new BorderLayout(0, 0));
		selectionPanel.add(targetCheck);
		
		sourceCheck = new JCheckBox("Association Source Ends");		
		sourceCheck.setSelected(true);
		sourceCheck.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectAllSources(e);
			}
		});
		selectionPanel.add(sourceCheck);
		
		optPane.add(selectionPanel);
		
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
			else { currentIndex=0; filterTree.select(lastFoundNodes.get(currentIndex)); }			
		}else{			
			lastTextFound = findText.getText();
			currentIndex=0; 
			lastFoundNodes = filterTree.findName(lastTextFound);
			filterTree.select(lastFoundNodes.get(currentIndex));
		}
	}
		
	public void selectAllQualities(ActionEvent e)
	{
		List<EObject> result = new ArrayList<EObject>();
		result.addAll(getParser().getAllInstances(RefOntoUML.Quality.class));
		for(Quality q: getParser().getAllInstances(RefOntoUML.Quality.class)){
			result.addAll(getParser().getDirectRelationships(q));
			result.addAll(getParser().getGeneralizationSets(q));
		}		
		result.addAll(getParser().getAllInstances(RefOntoUML.Structuration.class));
		for(Structuration q: getParser().getAllInstances(RefOntoUML.Structuration.class)){
			result.addAll(getParser().getDirectRelationships(q));
			result.addAll(getParser().getGeneralizationSets(q));
		}
		result.addAll(getParser().getAllInstances(RefOntoUML.ReferenceStructure.class));
		for(ReferenceStructure q: getParser().getAllInstances(RefOntoUML.ReferenceStructure.class)){
			result.addAll(getParser().getDirectRelationships(q));
			result.addAll(getParser().getGeneralizationSets(q));
		}		
		result.addAll(getParser().getAllInstances(RefOntoUML.ReferenceRegion.class));
		for(ReferenceRegion q: getParser().getAllInstances(RefOntoUML.ReferenceRegion.class)){
			result.addAll(getParser().getDirectRelationships(q));			
		}
		if(quaCheck.isSelected()){			
			filterTree.check(result);
		}
		if(!quaCheck.isSelected()){
			filterTree.uncheck(result);
		}
	}
		
	public void selectAllTargets(ActionEvent e)
	{
		List<EObject> targets = new ArrayList<EObject>();
		for(Association a: getParser().getAllInstances(RefOntoUML.Association.class)){
			targets.add(a.getMemberEnd().get(1));
		}
		if(targetCheck.isSelected()){			
			filterTree.check(targets);
		}
		if(!targetCheck.isSelected()){
			filterTree.uncheck(targets);
		}
	}
		
	public void selectAllSources(ActionEvent e)
	{
		List<EObject> sources = new ArrayList<EObject>();
		for(Association a: getParser().getAllInstances(RefOntoUML.Association.class)){
			sources.add(a.getMemberEnd().get(0));
		}
		if(sourceCheck.isSelected()){			
			filterTree.check(sources);
		}
		if(!sourceCheck.isSelected()){
			filterTree.uncheck(sources);
		}
	}
	
	public void selectAllAssociations(ActionEvent e)
	{
		List<EObject> associations = new ArrayList<EObject>();
		associations.addAll(getParser().getAllInstances(RefOntoUML.Association.class));		
		if(relCheck.isSelected()){			
			filterTree.check(associations);
		}
		if(!relCheck.isSelected()){
			filterTree.uncheck(associations);
		}
	}
	
	public void selectAllAttributes(ActionEvent e)
	{
		List<EObject> attributes = new ArrayList<EObject>();
		for(Property p: getParser().getAllInstances(RefOntoUML.Property.class)){
			if(p.getAssociation()==null){
				attributes.add(p);
			}
		}
		if(attrCheck.isSelected()){			
			filterTree.check(attributes);
		}
		if(!attrCheck.isSelected()){
			filterTree.uncheck(attributes);
		}
	}

	public void selectAllGeneralizationSets(ActionEvent e)
	{
		List<EObject> genSets = new ArrayList<EObject>();
		genSets.addAll(getParser().getAllInstances(RefOntoUML.GeneralizationSet.class));
		if(genSetCheck.isSelected()){			
			for(EObject gs: getParser().getAllInstances(RefOntoUML.GeneralizationSet.class)){
				for(Generalization g: ((GeneralizationSet)gs).getGeneralization()){
					genSets.add(g.getGeneral());
					genSets.add(g.getSpecific());
					genSets.add(g);				
				}
			}			
			filterTree.check(genSets);
		}
		if(!genSetCheck.isSelected()){
			filterTree.uncheck(genSets);
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
	
	public OntoUMLParser getParser() { return filterTree.refparser; }
	
	public OntoUMLParser getFilteredParser()
	{					
		getParser().select(getChecked(),true);		
		return getParser();	
	}
	
	public ElementFilterTree getFilter() { return filterTree; }
	
	public void fillContent(OntoUMLParser refparser)
	{
		filterTree = ElementFilterTree.createFilter(refparser);
		filterTree.setBorder(new EmptyBorder(2,2,2,2));				
		scrollTreePane.setViewportView(filterTree);				
		updateUI();		
	}	
	
	public List<EObject> getChecked()
	{
		return filterTree.getCheckedElements();
	}
}
