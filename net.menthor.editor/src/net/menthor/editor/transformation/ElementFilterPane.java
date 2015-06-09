package net.menthor.editor.transformation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
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

import javax.swing.UIManager;

public class ElementFilterPane extends JPanel {
	
	private static final long serialVersionUID = 1603594735794477309L;
	private JScrollPane scrollTreePane = new JScrollPane();
	private ElementFilterTree filter;	
	private JPanel treeWrapper = new JPanel();	
	private JPanel optPane = new JPanel();
	private JCheckBox genSetCheck;
	private JPanel relPane;
	private JCheckBox attrCheck;
	private JCheckBox relCheck;
	private JCheckBox sourceCheck;
	private JCheckBox targetCheck;
	private JCheckBox quaCheck;
	
	public ElementFilterPane()
	{
		setLayout(new BorderLayout(0,0));				
		setPreferredSize(new Dimension(529, 360));
		
		optPane.setPreferredSize(new Dimension(100, 100));
		add(optPane, BorderLayout.NORTH);
		
		relPane = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) relPane.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		relPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Associations", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBorder(new TitledBorder(null, "Select/Unselect all:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		GroupLayout gl_optPane = new GroupLayout(optPane);
		gl_optPane.setHorizontalGroup(
			gl_optPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_optPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(relPane, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(101, Short.MAX_VALUE))
		);
		gl_optPane.setVerticalGroup(
			gl_optPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_optPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_optPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addComponent(relPane, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(39, Short.MAX_VALUE))
		);
		optPane.setLayout(gl_optPane);
		
		sourceCheck = new JCheckBox("Source End");
		sourceCheck.setSelected(true);
		sourceCheck.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectAllSources(e);
			}
		});	
		relPane.add(sourceCheck);
		
		targetCheck = new JCheckBox("Target End");
		targetCheck.setSelected(true);
		targetCheck.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectAllTargets(e);
			}
		});	
		relPane.add(targetCheck);
		
		genSetCheck = new JCheckBox("Generalization sets");
		genSetCheck.setSelected(true);
		genSetCheck.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectAllGeneralizationSets(e);
			}
		});		
		panel.add(genSetCheck);
		
		attrCheck = new JCheckBox("Attributes");		
		attrCheck.setSelected(true);
		attrCheck.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectAllAttributes(e);
			}
		});
		panel.add(attrCheck);
		
		relCheck = new JCheckBox("Associations");
		relCheck.setSelected(true);
		relCheck.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectAllAssociations(e);
			}
		});
		panel.add(relCheck);
		
		quaCheck = new JCheckBox("Qualities, Structures and Regions");
		quaCheck.setSelected(true);
		quaCheck.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				selectAllQualities(e);
			}
		});
		panel.add(quaCheck);		
		
		treeWrapper.setBackground(Color.WHITE);
		treeWrapper.setBorder(new EmptyBorder(0,0, 0, 0));
		treeWrapper.setPreferredSize(new Dimension(200,250));
		
		scrollTreePane.setViewportView(treeWrapper);				
		scrollTreePane.setPreferredSize(new Dimension(200,250));
		
		add(scrollTreePane,BorderLayout.CENTER);		
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
			filter.check(result);
		}
		if(!quaCheck.isSelected()){
			filter.uncheck(result);
		}
	}
		
	public void selectAllTargets(ActionEvent e)
	{
		List<EObject> targets = new ArrayList<EObject>();
		for(Association a: getParser().getAllInstances(RefOntoUML.Association.class)){
			targets.add(a.getMemberEnd().get(1));
		}
		if(targetCheck.isSelected()){			
			filter.check(targets);
		}
		if(!targetCheck.isSelected()){
			filter.uncheck(targets);
		}
	}
		
	public void selectAllSources(ActionEvent e)
	{
		List<EObject> sources = new ArrayList<EObject>();
		for(Association a: getParser().getAllInstances(RefOntoUML.Association.class)){
			sources.add(a.getMemberEnd().get(0));
		}
		if(sourceCheck.isSelected()){			
			filter.check(sources);
		}
		if(!sourceCheck.isSelected()){
			filter.uncheck(sources);
		}
	}
	
	public void selectAllAssociations(ActionEvent e)
	{
		List<EObject> associations = new ArrayList<EObject>();
		associations.addAll(getParser().getAllInstances(RefOntoUML.Association.class));		
		if(relCheck.isSelected()){			
			filter.check(associations);
		}
		if(!relCheck.isSelected()){
			filter.uncheck(associations);
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
			filter.check(attributes);
		}
		if(!attrCheck.isSelected()){
			filter.uncheck(attributes);
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
			filter.check(genSets);
		}
		if(!genSetCheck.isSelected()){
			filter.uncheck(genSets);
		}
	}
	
	public void refresh()
	{				
		filter.updateUI();				
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
	
	public OntoUMLParser getParser() { return filter.refparser; }
	
	public OntoUMLParser getFilteredParser()
	{					
		getParser().select(getChecked(),true);		
		return getParser();	
	}
	
	public ElementFilterTree getFilter() { return filter; }
	
	public void fillContent(OntoUMLParser refparser)
	{
		filter = ElementFilterTree.createFilter(refparser);
		filter.setBorder(new EmptyBorder(2,2,2,2));				
		scrollTreePane.setViewportView(filter);				
		updateUI();		
	}	
	
	public List<EObject> getChecked()
	{
		return filter.getCheckedElements();
	}
}
