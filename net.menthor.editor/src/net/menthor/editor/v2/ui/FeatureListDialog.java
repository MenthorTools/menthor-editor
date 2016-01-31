package net.menthor.editor.v2.ui;

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
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.Classifier;
import RefOntoUML.DataType;
import RefOntoUML.Element;
import RefOntoUML.Generalization;
import RefOntoUML.NamedElement;
import RefOntoUML.Property;
import RefOntoUML.parser.OntoUMLParser;
import RefOntoUML.util.RefOntoUMLFactoryUtil;

import net.menthor.editor.v2.elements.PropertyElement;
import net.menthor.editor.v2.icon.IconMap;
import net.menthor.editor.v2.icon.IconType;

public class FeatureListDialog extends JDialog {

	private static final long serialVersionUID = 1805193414767775141L;

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollLeft;
	private JButton btnArrowRight;
	private JButton btnArrowLeft;
	private JScrollPane scrollRight;
	private JList<PropertyElement> leftList;
	private JList<PropertyElement> rightList;
	@SuppressWarnings("rawtypes")
	private DefaultListModel rightListModel;
	@SuppressWarnings("rawtypes")
	private DefaultListModel leftListModel;
		
	private OntoUMLParser refparser;
	private Component componentToUpdate;
	
	private Element element;
	private String attributeName;
	private ArrayList<Object> featureList = new ArrayList<Object>();
	private JButton okButton;
	private JButton cancelButton;
		
	private static String result = new String();	
	public static String getResult() { return result; }
	
	public static void open(JFrame parent, Component componentToUpdate, String featureName, Element element, OntoUMLParser refparser){
		try {			
			FeatureListDialog dialog = new FeatureListDialog(parent, componentToUpdate, element, refparser, featureName);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(parent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void open(JDialog parent, Component componentToUpdate, String featureName, Element element, OntoUMLParser refparser){
		try {			
			FeatureListDialog dialog = new FeatureListDialog(parent, componentToUpdate, element, refparser, featureName);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(parent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public FeatureListDialog(JFrame owner, Component componentToUpdate, Element element, OntoUMLParser refparser, String featureName){
		super(owner);
		initData(componentToUpdate, element,refparser,featureName);
		initGUI();		
	}
	
	public FeatureListDialog(JDialog owner, Component componentToUpdate, Element element, OntoUMLParser refparser, String featureName){		
		super(owner);
		initData(componentToUpdate, element,refparser,featureName);
		initGUI();		
	}
	
	public FeatureListDialog(){		
		initGUI();
	}
		
	public void initData(Component componentToUpdate, Element element, OntoUMLParser refparser, String featureName){
		this.refparser = refparser;
		this.componentToUpdate = componentToUpdate;
		this.element = element;
		this.attributeName = featureName;		
		if(element instanceof RefOntoUML.Property){
			if(attributeName.trim().compareToIgnoreCase("Redefined")==0){
				this.featureList.addAll(((RefOntoUML.Property)element).getRedefinedProperty());				
			}
			if(attributeName.trim().compareToIgnoreCase("Subsetted")==0){
				this.featureList.addAll(((RefOntoUML.Property)element).getSubsettedProperty());				
			}
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void initGUI() 
	{
		setIconImage(IconMap.getInstance().getImage(IconType.MENTHOR_EDIT));		
		if (element instanceof Property)
			setTitle(attributeName+" - "+OntoUMLParser.getStereotype(element)+" "+((NamedElement)element).getName()+": "+((Property)element).getType().getName());
		else if (element instanceof Generalization) 
			setTitle(attributeName+" - "+OntoUMLParser.getStereotype(element)+" "+((Generalization)element).getGeneral().getName()+" -> "+((Generalization)element).getSpecific().getName());			
		else
			setTitle(attributeName+" - "+OntoUMLParser.getStereotype(element)+" "+((NamedElement)element).getName());		
		setBounds(100, 100, 745, 292);		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);					
		leftListModel = new DefaultListModel();  
		rightListModel = new DefaultListModel();		 
		for(RefOntoUML.Property p : refparser.getAllInstances(RefOntoUML.Property.class)){
			if(!featureList.contains(p) && !p.equals(element)){
				Property baseProperty = (Property) element;
				Classifier baseType = (Classifier) baseProperty.getType();
				
				//base property is an attribute
				if(baseProperty.getAssociation()==null && p.getAssociation()==null &&
						(baseType.equals(p.getType()) || baseType.allParents().contains(p.getType())) ){
					
					if(baseProperty.eContainer() instanceof RefOntoUML.Class && p.eContainer() instanceof RefOntoUML.Class &&
							(baseProperty.getClass_().equals(p.getClass_()) || baseProperty.getClass_().allParents().contains(p.getClass_()))	){
						PropertyElement elem = new PropertyElement(p);
						leftListModel.addElement(elem);
					}

					else if(baseProperty.eContainer() instanceof DataType && p.eContainer() instanceof DataType &&
							(baseProperty.getDatatype().equals(p.getDatatype()) || baseProperty.getDatatype().allParents().contains(p.getDatatype()))		){
						PropertyElement elem = new PropertyElement(p);
						leftListModel.addElement(elem);
					}
					
				}
				else if (baseProperty.getAssociation()!=null && p.getAssociation()!=null &&
						(baseType.equals(p.getType()) || baseType.allParents().contains(p.getType())) &&
						(baseProperty.getOpposite().getType().equals(p.getOpposite().getType()) || ((Classifier) baseProperty.getOpposite().getType()).allParents().contains(p.getOpposite().getType()))){
					PropertyElement elem = new PropertyElement(p);
					leftListModel.addElement(elem);
				}
				
				
			}
		}
		leftList = new JList<PropertyElement>(leftListModel);
		
		for(Object obj: featureList){
			PropertyElement elem = new PropertyElement((Element)obj);
			rightListModel.addElement(elem);
		}
		rightList = new JList<PropertyElement>(rightListModel);
		
		scrollLeft = new JScrollPane();	
		scrollLeft.setViewportView(leftList);
		
		scrollRight = new JScrollPane();
		scrollRight.setViewportView(rightList);
		
		btnArrowRight = new JButton("->");	
		btnArrowRight.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{				
				for(PropertyElement n: leftList.getSelectedValuesList())
				{
					if(!rightListModel.contains(n)) {						
						rightListModel.addElement(n); 
						rightList.setSelectedIndex(rightListModel.indexOf(n)); 
					} 					
					if(leftList.getSelectedIndex()>=0) { 
						int prev = leftList.getSelectedIndex()-1;
						leftListModel.remove(leftList.getSelectedIndex());
						leftList.setSelectedIndex(prev); 
					}	
				}
			}
		});
	
		btnArrowLeft = new JButton("<-");		
		btnArrowLeft.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for(PropertyElement n: rightList.getSelectedValuesList()){
					if(!leftListModel.contains(n)) { 
						leftListModel.addElement(n); 
						leftList.setSelectedIndex(leftListModel.indexOf(n)); 
					} 					
					if(rightList.getSelectedIndex()>=0) { 
						int prev = rightList.getSelectedIndex()-1;
						rightListModel.remove(rightList.getSelectedIndex());
						rightList.setSelectedIndex(prev); 
					}	
				}
			}
		});
				
		JLabel lblChoices = new JLabel("Possible choices:");
		JLabel lblFeature = new JLabel();
		if(attributeName.trim().compareToIgnoreCase("Subsetted")==0)
		{
			lblFeature.setText("Subsetted properties:");
		}
		if(attributeName.trim().compareToIgnoreCase("Redefined")==0)
		{
			lblFeature.setText("Redefined properties:");
		}
				
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(scrollLeft, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnArrowRight)
								.addComponent(btnArrowLeft))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollRight, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblChoices, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
							.addComponent(lblFeature, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblChoices)
						.addComponent(lblFeature))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(46)
							.addComponent(btnArrowRight)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnArrowLeft))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(scrollLeft, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
								.addComponent(scrollRight, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))))
					.addGap(2))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Ok");
				okButton.addActionListener(new ActionListener() 
				{
		       		public void actionPerformed(ActionEvent event) 
		       		{
		       			okActionPerformed();
		       			dispose();
		       		}
				});
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() 
				{
		       		public void actionPerformed(ActionEvent event) 
		       		{
		       			dispose();
		       		}
				});
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addContainerGap(589, Short.MAX_VALUE)
						.addComponent(okButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cancelButton)
						.addGap(14))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(cancelButton)
							.addComponent(okButton))
						.addContainerGap(21, Short.MAX_VALUE))
			);
			buttonPane.setLayout(gl_buttonPane);
		}		
	}
	
	public ArrayList<Object> getFeatures()
	{
		ArrayList<Object> result = new ArrayList<Object>();
		for (int i=0;i<rightListModel.getSize();i++) {
			result.add(((PropertyElement)rightListModel.get(i)).getElement());
		}
		return result;
	}
	
	public static String getStereotype(EObject element)
	{
		String type = element.getClass().toString().replaceAll("class RefOntoUML.impl.","");
	    type = type.replaceAll("Impl","");
	    type = Normalizer.normalize(type, Normalizer.Form.NFD);
	    if (!type.equalsIgnoreCase("association")) type = type.replace("Association","");
	    return type;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void okActionPerformed()
	{
		result = new String();
		ArrayList<String> resultList = new ArrayList<String>();
		if(attributeName.trim().compareToIgnoreCase("Redefined")==0 || attributeName.trim().compareToIgnoreCase("Subsetted")==0)
		{
			if (attributeName.trim().compareToIgnoreCase("Redefined")==0) ((Property)element).getRedefinedProperty().clear();
			else if (attributeName.trim().compareToIgnoreCase("Subsetted")==0) ((Property)element).getSubsettedProperty().clear();
			
	    	int i=0;
	    	for(Object p: getFeatures())
	    	{
	    		if(p instanceof Property)
	    		{
	    			Property p2 = (Property)p;
	    			
	    			if (i==getFeatures().size()-1) { 
	    				String str = "<"+getStereotype(p2)+"> "+p2.getName()+": "+p2.getType().getName()+" ["+RefOntoUMLFactoryUtil.getMultiplicityAsString(p2)+"]";
	    				result += str;
	    				resultList.add(str);
	    			} else {
	    				String str ="<"+getStereotype(p2)+"> "+p2.getName()+": "+p2.getType().getName()+" ["+RefOntoUMLFactoryUtil.getMultiplicityAsString(p2)+"]"; 
	    				result += str+", ";
	    				resultList.add(str);
	    			}
	    			
	    			if (attributeName.trim().compareToIgnoreCase("Redefined")==0) ((Property)element).getRedefinedProperty().add(p2);
	    			else if (attributeName.trim().compareToIgnoreCase("Subsetted")==0) ((Property)element).getSubsettedProperty().add(p2);
	    		}
	    		i++;
	    	}	    	
		}			
		
		if (componentToUpdate instanceof JTextField){
			JTextField textField = (JTextField)componentToUpdate;
			textField.setText(result);
		}
		if (componentToUpdate instanceof JList){
			DefaultListModel model = new DefaultListModel();  
			JList list = (JList)componentToUpdate;
			list.setModel(model);
			for(String str: resultList){
				model.addElement(str);
			}
		}
	}
}
