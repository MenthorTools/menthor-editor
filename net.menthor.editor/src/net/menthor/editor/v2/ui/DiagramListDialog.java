package net.menthor.editor.v2.ui;

/*
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
 * 
 * @author John Guerson
 */

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconMap;
import net.menthor.editor.v2.icon.IconType;

public class DiagramListDialog extends JDialog {
	
	private static final long serialVersionUID = -251319551154959770L;
	
	private CommandListener listener;
	private List<OntoumlDiagram> diagrams = new ArrayList<OntoumlDiagram>();	
	
	private JList<OntoumlDiagram> diagramList;	
	@SuppressWarnings("rawtypes")
	private DefaultListModel diagramListModel;
	private final JPanel contentPanel = new JPanel();
	private JButton btnOk;	
	private JButton btnCancel;	
	private JScrollPane scroll;		
	private JLabel lblText;
			
	public static void open(CommandListener listener, List<OntoumlDiagram> diagrams){
		try {			
			DiagramListDialog dialog = new DiagramListDialog(listener,diagrams);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo((Component)listener);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public DiagramListDialog(CommandListener listener, List<OntoumlDiagram> diagrams){
		super((Frame) listener);		
		this.listener = listener;
		this.diagrams = diagrams;		
		setIconImage(IconMap.getInstance().getImage(IconType.MENTHOR_DIAGRAM.toString()));
		initGUI();
	}
	
	public DiagramListDialog(){
		setIconImage(IconMap.getInstance().getImage(IconType.MENTHOR_DIAGRAM.toString()));
		initGUI();
	}
	
	public void callOpenTab(OntoumlDiagram de){
		listener.handleCommand(CommandType.OPEN_TAB.toString(),de);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void initGUI(){
		setTitle("Diagrams");
		setBounds(100, 100, 397, 328);		
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setPreferredSize(new Dimension(100, 170));		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(contentPanel, BorderLayout.CENTER);		
		diagramListModel = new DefaultListModel();  
		for(OntoumlDiagram de: diagrams){
			diagramListModel.addElement(de);
		}
		diagramList = new JList<OntoumlDiagram>(diagramListModel);		
		diagramList.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		            int index = list.locationToIndex(evt.getPoint());
		            OntoumlDiagram de = diagrams.get(index);
		            callOpenTab(de);
		        } else if (evt.getClickCount() == 3) { // Triple-click
		            int index = list.locationToIndex(evt.getPoint());
		            OntoumlDiagram de = diagrams.get(index);
		            callOpenTab(de);
		        }
		    }
		});
		
		scroll = new JScrollPane();
		scroll.setViewportView(diagramList);		
		lblText = new JLabel("");
		lblText.setText("The element appear in the following diagrams:");		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(scroll, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
						.addComponent(lblText, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE))
					.addGap(8))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(20)
					.addComponent(lblText)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scroll, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
					.addGap(8))
		);
		contentPanel.setLayout(gl_contentPanel);		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(50, 50));
		getContentPane().add(panel, BorderLayout.SOUTH);		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener(){
       		public void actionPerformed(ActionEvent event){       			
       			callOpenTab(diagramList.getSelectedValue());
       			dispose();
       		}
		});		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event){
       			dispose();
       		}
		});		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(200, Short.MAX_VALUE)
					.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnOk))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
}


