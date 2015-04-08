/**
 * Copyright(C) 2011-2014 by John Guerson, Tiago Prince, Antognoni Albuquerque
 *
 * This file is part of OLED (OntoUML Lightweight BaseEditor).
 * OLED is based on TinyUML and so is distributed under the same
 * license terms.
 *
 * OLED is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * OLED is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with OLED; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package net.menthor.editor.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import org.tinyuml.draw.Diagram;
import org.tinyuml.ui.commands.AppCommandListener;
import org.tinyuml.ui.diagram.Editor;

import net.menthor.editor.AppFrame;
import net.menthor.editor.model.UmlProject;
import net.menthor.editor.util.ConfigurationHelper;
import net.menthor.editor.util.IconLoader;
import net.menthor.editor.util.IconLoader.IconType;

/**
 * @author John Guerson
 */
public class StartPanel extends JPanel implements Editor {
	
	private static final long serialVersionUID = 1851067745174024251L;
	private BackgroundPanel backgroundPanel;
	private JPanel recentPanel;
	@SuppressWarnings("rawtypes")
	private JList recentList;
	private JScrollPane recentScroll;
	private JLabel lblOpenRecent;
	private AppCommandListener commandListener;
	private JLabel lblTitle;
	private JHyperLinkLabel btnImportFromEa;
	private JHyperLinkLabel btnNewProject;
	private JHyperLinkLabel btnOpenProject;
	private Component rigidArea_3;
	private Component rigidArea_4;
	private JLabel eaInstallLink;
	private JHyperLinkLabel faqLink;
	
	public StartPanel(AppCommandListener commandDispatcher) {
		super();
		this.commandListener = commandDispatcher;
		initGUI();
		populateRecentProjects();
	}
	
	@SuppressWarnings("rawtypes")
	public void initGUI() 
	{
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		add(mainPanel,BorderLayout.CENTER);
		recentPanel = new JPanel();
		recentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		recentPanel.setBackground(new java.awt.Color(255,255,255));
		recentScroll = new JScrollPane();
		recentScroll.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		recentList = new JList();
		//recentList.setBackground(new Color(0xF2FCAC));
		recentScroll.setViewportView(recentList);		
		lblOpenRecent = new JLabel(" Open Recent Projects:");		
		lblTitle = new JLabel("");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setIcon(new ImageIcon(StartPanel.class.getResource("/resources/icons/menthor-header.jpg")));		
		
		JPanel middlePanel = new JPanel();
		middlePanel.setBackground(Color.WHITE);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Color.WHITE);
		
		GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
		gl_mainPanel.setHorizontalGroup(
			gl_mainPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addGap(182)
					.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(middlePanel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(leftPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
						.addComponent(lblOpenRecent, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
						.addComponent(lblTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
						.addComponent(recentPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
					.addGap(134))
		);
		gl_mainPanel.setVerticalGroup(
			gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblOpenRecent)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(recentPanel, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(leftPanel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(middlePanel, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(72, Short.MAX_VALUE))
		);
		GroupLayout gl_recentPanel = new GroupLayout(recentPanel);
		gl_recentPanel.setHorizontalGroup(
			gl_recentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(recentScroll, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)
		);
		gl_recentPanel.setVerticalGroup(
			gl_recentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(recentScroll, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
		);
		recentPanel.setLayout(gl_recentPanel);
						
		eaInstallLink = new JHyperLinkLabel("");
		eaInstallLink.setIcon(new ImageIcon(StartPanel.class.getResource("/resources/icons/menthor-16x16.png")));	
		eaInstallLink.setText("[Tutorial] Learn how to install and use OntoUML within the EA Tool");
		
		faqLink = new JHyperLinkLabel("");		
		faqLink.setText("[FAQ] Frequently Asked Questions");
		faqLink.setIcon(new ImageIcon(StartPanel.class.getResource("/resources/icons/menthor-16x16.png")));
		
		JHyperLinkLabel userLink = new JHyperLinkLabel("");
		userLink.setText("[Forum] User Community");
		userLink.setIcon(new ImageIcon(StartPanel.class.getResource("/resources/icons/menthor-16x16.png")));
		
		JHyperLinkLabel guideLink = new JHyperLinkLabel("");
		guideLink.setText("[Study] OntoUML Study Guide");
		guideLink.setIcon(new ImageIcon(StartPanel.class.getResource("/resources/icons/menthor-16x16.png")));
		GroupLayout gl_middlePanel = new GroupLayout(middlePanel);
		gl_middlePanel.setHorizontalGroup(
			gl_middlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_middlePanel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_middlePanel.createParallelGroup(Alignment.LEADING)
						.addComponent(eaInstallLink, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(faqLink, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(userLink, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(guideLink, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		gl_middlePanel.setVerticalGroup(
			gl_middlePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_middlePanel.createSequentialGroup()
					.addGap(5)
					.addComponent(eaInstallLink, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(faqLink, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(userLink, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(guideLink, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(2))
		);
		middlePanel.setLayout(gl_middlePanel);
		
		eaInstallLink.addMouseListener(new MouseAdapter() {			
			 @Override
			    public void mouseClicked(MouseEvent e) {			     
				 if(commandListener instanceof AppFrame){
					 AppFrame frame = (AppFrame)commandListener;
					 frame.getDiagramManager().openLinkWithBrowser("http://www.menthor.net/tutorial-how-to-use-ontouml-in-enterprise-architect.html");
				 }
			 }
		});
		
		faqLink.addMouseListener(new MouseAdapter() {			
			 @Override
			    public void mouseClicked(MouseEvent e) {			     
				 if(commandListener instanceof AppFrame){
					 AppFrame frame = (AppFrame)commandListener;
					 frame.getDiagramManager().openLinkWithBrowser("http://www.menthor.net/faq.html");
				 }
			 }
		});
		
		userLink.addMouseListener(new MouseAdapter() {			
			 @Override
			    public void mouseClicked(MouseEvent e) {			     
				 if(commandListener instanceof AppFrame){
					 AppFrame frame = (AppFrame)commandListener;
					 frame.getDiagramManager().openLinkWithBrowser("http://www.menthor.net/user-community.html");
				 }
			 }
		});
		
		guideLink.addMouseListener(new MouseAdapter() {			
			 @Override
			    public void mouseClicked(MouseEvent e) {			     
				 if(commandListener instanceof AppFrame){
					 AppFrame frame = (AppFrame)commandListener;
					 frame.getDiagramManager().openLinkWithBrowser("http://www.menthor.net/ontouml-study-guide.html");
				 }
			 }
		});
		
		btnNewProject = new JHyperLinkLabel("New Project");
		leftPanel.add(btnNewProject);
		btnNewProject.setIconTextGap(10);
		btnNewProject.setToolTipText("Create a new Menthor project");
		btnNewProject.setFocusable(false);
		btnNewProject.setIcon(new ImageIcon(StartPanel.class.getResource("/resources/icons/x16/page_2.png")));
		
		rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		leftPanel.add(rigidArea_3);
		btnOpenProject = new JHyperLinkLabel("Open Project");
		btnOpenProject.setSize(new Dimension(105, 23));
		leftPanel.add(btnOpenProject);
		btnOpenProject.setIconTextGap(10);
		btnOpenProject.setToolTipText("Open an existing Menthor project");
		btnOpenProject.setFocusable(false);
		btnOpenProject.setIcon(new ImageIcon(StartPanel.class.getResource("/resources/icons/x16/folder.png")));
		
		rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		leftPanel.add(rigidArea_4);
		btnImportFromEa = new JHyperLinkLabel("Import from EA");
		btnImportFromEa.setToolTipText("<html>Bring your models from Enterprise Architect (version 10) into Menthor <br>and benefit of all the editor capabilities.</html>");
		leftPanel.add(btnImportFromEa);		
		btnImportFromEa.setIcon(new ImageIcon(StartPanel.class.getResource("/resources/icons/x16/ea.jpg")));
		btnImportFromEa.addMouseListener(new MouseAdapter() {			
			 @Override
			    public void mouseClicked(MouseEvent e) {				
				 commandListener.handleCommand("IMPORT_XMI");				
			}
		});
		btnOpenProject.addMouseListener(new MouseAdapter() {			
			 @Override
			    public void mouseClicked(MouseEvent e) {	
				commandListener.handleCommand("OPEN_PROJECT");				
			}
		});
		btnNewProject.addMouseListener(new MouseAdapter() {			
			 @Override
			    public void mouseClicked(MouseEvent e) {	
				commandListener.handleCommand("NEW_PROJECT");				
			}
		});
		mainPanel.setLayout(gl_mainPanel);		
		backgroundPanel = new BackgroundPanel();
		backgroundPanel.setPreferredSize(new Dimension(400, 150));
		add(backgroundPanel, BorderLayout.SOUTH);				
	}

	@SuppressWarnings({ "rawtypes", "unchecked"})
	private void populateRecentProjects(){
		recentList.setModel(new DefaultComboBoxModel(ConfigurationHelper.getRecentProjects()));
		recentList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
		        if (evt.getClickCount() >= 2) 
		        {
		        	commandListener.handleCommand("OPEN_RECENT_PROJECT");
		        }
		    }
		});
	}

	public String getSelectedRecentFile()
	{
		return (String) recentList.getSelectedValue();
	}
	
	private class BackgroundPanel extends JPanel
	{
		private static final long serialVersionUID = 2336092539913014948L;		
	    Image image;
	    public BackgroundPanel()
	    {
	        image = IconLoader.getInstance().getImage(IconType.BACKGROUND_WELCOME.name());
	    }
	    public void paint(Graphics g)
	    {
	        // Draws the image to the BackgroundPanel.	        
			int posx = 0, posy = 0, hvar = 0;
			int width = image.getWidth(this);
			//int height = image.getHeight(this);			
			Rectangle clip = g.getClipBounds();			
			hvar = (int) (clip.getWidth() / width);			
			for(int i = 0; i <= hvar; i++)
			{
				posx = width * i;
				g.drawImage(image, posx, posy, this);
			}
	    }
	}
	
	@Override
	public boolean isSaveNeeded() {
		return false;
	}

	@Override
	public EditorNature getEditorNature() {
		return EditorNature.READ_ONLY;
	}

	@Override
	public Diagram getDiagram() {
		return null;
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public UmlProject getProject() {
		return null;
	}
}
