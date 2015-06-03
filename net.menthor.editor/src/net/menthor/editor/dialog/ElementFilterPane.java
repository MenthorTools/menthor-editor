package net.menthor.editor.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.eclipse.emf.ecore.EObject;

import RefOntoUML.parser.OntoUMLParser;

public class ElementFilterPane extends JPanel {
	
	private static final long serialVersionUID = 1603594735794477309L;
	private JScrollPane scrollTreePane;
	private ElementFilterTree filter;	
	private JPanel treeWrapper;	
	
	public ElementFilterPane()
	{
		setLayout(new BorderLayout(0, 0));
		scrollTreePane = new JScrollPane();		
		add(scrollTreePane);
		treeWrapper = new JPanel();
		treeWrapper.setBackground(Color.WHITE);
		treeWrapper.setBorder(new EmptyBorder(0,0, 0, 0));
		scrollTreePane.setViewportView(treeWrapper);		
		treeWrapper.setPreferredSize(new Dimension(200,250));
		scrollTreePane.setPreferredSize(new Dimension(200,250));
		setPreferredSize(new Dimension(364, 317));
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
