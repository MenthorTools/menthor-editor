package net.menthor.editor.transformation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

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

import net.menthor.editor.v2.trees.ElementTree;

public class FilterOptionPane extends JPanel{
	
	private static final long serialVersionUID = -6393962006647644434L;
	
	private JCheckBox genSetCheck;
	private JCheckBox attrCheck;
	private JCheckBox relCheck;
	private JCheckBox sourceCheck;
	private JCheckBox targetCheck;
	private JCheckBox quaCheck;
	
	private ElementTree elemTree;
	
	public void setFilter(ElementTree elemTree){
		this.elemTree=elemTree;
	}
	
	public FilterOptionPane()
	{
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Check/Uncheck All", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		JPanel selectionPanel = new JPanel();
		selectionPanel.setPreferredSize(new Dimension(10, 200));
		
		genSetCheck = new JCheckBox("Generalization sets");
		genSetCheck.setPreferredSize(new Dimension(155, 23));
		genSetCheck.setSelected(true);
		genSetCheck.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectAllGeneralizationSets(e);
			}
		});		
		selectionPanel.setLayout(new GridLayout(0, 1, 0, 0));
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
				
		relCheck = new JCheckBox("Associations");
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
		setLayout(new BorderLayout(0, 0));
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
		
		add(selectionPanel, BorderLayout.NORTH);
	}
	
	public void selectAllQualities(ActionEvent e)
	{
		OntoUMLParser refparser = elemTree.getParser();
		List<Object> result = new ArrayList<Object>();
		result.addAll(refparser.getAllInstances(RefOntoUML.Quality.class));
		for(Quality q: refparser.getAllInstances(RefOntoUML.Quality.class)){
			result.addAll(refparser.getDirectRelationships(q));
			result.addAll(refparser.getGeneralizationSets(q));
		}		
		result.addAll(refparser.getAllInstances(RefOntoUML.Structuration.class));
		for(Structuration q: refparser.getAllInstances(RefOntoUML.Structuration.class)){
			result.addAll(refparser.getDirectRelationships(q));
			result.addAll(refparser.getGeneralizationSets(q));
		}
		result.addAll(refparser.getAllInstances(RefOntoUML.ReferenceStructure.class));
		for(ReferenceStructure q: refparser.getAllInstances(RefOntoUML.ReferenceStructure.class)){
			result.addAll(refparser.getDirectRelationships(q));
			result.addAll(refparser.getGeneralizationSets(q));
		}		
		result.addAll(refparser.getAllInstances(RefOntoUML.ReferenceRegion.class));
		for(ReferenceRegion q: refparser.getAllInstances(RefOntoUML.ReferenceRegion.class)){
			result.addAll(refparser.getDirectRelationships(q));			
		}
		if(quaCheck.isSelected()){		
			elemTree.check(result);
		}
		if(!quaCheck.isSelected()){
			elemTree.uncheck(result);
		}
	}
		
	public void selectAllTargets(ActionEvent e)
	{
		List<Object> targets = new ArrayList<Object>();
		for(Association a: elemTree.getParser().getAllInstances(RefOntoUML.Association.class)){
			targets.add(a.getMemberEnd().get(1));
		}
		if(targetCheck.isSelected()){			
			elemTree.check(targets);
		}
		if(!targetCheck.isSelected()){
			elemTree.uncheck(targets);
		}
	}
		
	public void selectAllSources(ActionEvent e)
	{
		List<Object> sources = new ArrayList<Object>();
		for(Association a: elemTree.getParser().getAllInstances(RefOntoUML.Association.class)){
			sources.add(a.getMemberEnd().get(0));
		}
		if(sourceCheck.isSelected()){			
			elemTree.check(sources);
		}
		if(!sourceCheck.isSelected()){
			elemTree.uncheck(sources);
		}
	}
	
	public void selectAllAssociations(ActionEvent e)
	{
		List<Object> associations = new ArrayList<Object>();
		associations.addAll(elemTree.getParser().getAllInstances(RefOntoUML.Association.class));		
		if(relCheck.isSelected()){			
			elemTree.check(associations);
		}
		if(!relCheck.isSelected()){
			elemTree.uncheck(associations);
		}
	}
	
	public void selectAllAttributes(ActionEvent e)
	{
		List<Object> attributes = new ArrayList<Object>();
		for(Property p: elemTree.getParser().getAllInstances(RefOntoUML.Property.class)){
			if(p.getAssociation()==null){
				attributes.add(p);
			}
		}
		if(attrCheck.isSelected()){			
			elemTree.check(attributes);
		}
		if(!attrCheck.isSelected()){
			elemTree.uncheck(attributes);
		}
	}

	public void selectAllGeneralizationSets(ActionEvent e)
	{
		List<Object> genSets = new ArrayList<Object>();
		genSets.addAll(elemTree.getParser().getAllInstances(RefOntoUML.GeneralizationSet.class));
		if(genSetCheck.isSelected()){			
			for(EObject gs: elemTree.getParser().getAllInstances(RefOntoUML.GeneralizationSet.class)){
				for(Generalization g: ((GeneralizationSet)gs).getGeneralization()){
					genSets.add(g.getGeneral());
					genSets.add(g.getSpecific());
					genSets.add(g);				
				}
			}			
			elemTree.check(genSets);
		}
		if(!genSetCheck.isSelected()){
			elemTree.uncheck(genSets);
		}
	}

}
