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
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.icon.IconMap;
import net.menthor.editor.v2.icon.IconType;
import net.menthor.editor.v2.types.ColorMap;
import net.menthor.editor.v2.types.ColorType;

public class AboutDialog extends JDialog{

	private static final long serialVersionUID = -251319551154959770L;
	
	private CommandListener listener;
	
	private JLabel logoLabel;
	private JPanel logoPanel;
	private JPanel detailsPanel;
	private JHyperLinkLabel tinyUMLLink;
	private JHyperLinkLabel alloyLink;
	private JHyperLinkLabel eclipseLink;
	private JHyperLinkLabel nemoLink;
	private JTextPane detailsTextPane;
	
	public static void open(CommandListener listener, String buildDate, String version){
		try {
			AboutDialog dialog = new AboutDialog(listener, buildDate, version);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo((Component)listener);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public AboutDialog(final CommandListener frame, String buildDate, String version){
		super((Frame)frame);		
		setTitle("About");
		setBounds(100, 100, 521, 372);		
		createLogoPanel();
		createLicensesDetailsPanel(buildDate, version);	
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(detailsPanel, BorderLayout.CENTER);
		getContentPane().add(logoPanel, BorderLayout.WEST);
	}
	
	private JPanel createLogoPanel(){
		logoPanel = new JPanel();
		logoPanel.setPreferredSize(new Dimension(200, 100));		
		logoPanel.setLayout(new BorderLayout(0, 0));		
		logoLabel = new JLabel("");
		logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		logoPanel.add(logoLabel, BorderLayout.CENTER);
		logoPanel.setBackground(ColorMap.getInstance().getColor(ColorType.MENTHOR_GREY_DARK));
		logoLabel.setBackground(ColorMap.getInstance().getColor(ColorType.MENTHOR_GREY_DARK));
		logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logoLabel.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_WELCOME_LOGO));
		return logoPanel;
	}
	
	private JPanel createLicensesDetailsPanel(String buildDate, String version){	
		detailsPanel = new JPanel();
		detailsTextPane = new JTextPane();
		detailsTextPane.setBackground(UIManager.getColor("Panel.background"));
		detailsTextPane.setText("Menthor Editor \r\nCopyright © 2016 All rights reserved. \r\n\r\nVersion: "+version+"\r\nBuild Date: "+buildDate+"\r\n\r\nThis product includes software developed by other open source projects including TinyUML (GNU GPL license), Alloy (MIT license), Eclipse Foundation (EPL license), and NEMO Infrastructure (MIT license).");
		tinyUMLLink = new JHyperLinkLabel("");
		tinyUMLLink.setText("http://sourceforge.net/projects/tinyuml/");
		tinyUMLLink.addMouseListener(new MouseAdapter() {			
			 @Override
			    public void mouseClicked(MouseEvent e) {				 
				 listener.handleCommand(CommandType.OPEN_LINK_WITH_BROWSER.toString(),
				 	"http://sourceforge.net/projects/tinyuml/"
				 );
			 }
		});
		alloyLink = new JHyperLinkLabel("");
		alloyLink.setText("http://alloy.mit.edu/alloy/");
		alloyLink.addMouseListener(new MouseAdapter() {			
			 @Override
			    public void mouseClicked(MouseEvent e) {				 
				 listener.handleCommand(CommandType.OPEN_LINK_WITH_BROWSER.toString(),
					"http://alloy.mit.edu/alloy/"
				 );
			 }
		});		
		eclipseLink = new JHyperLinkLabel("");
		eclipseLink.setText("https://eclipse.org/");
		eclipseLink.addMouseListener(new MouseAdapter() {			
			 @Override
			    public void mouseClicked(MouseEvent e) {				 
				 listener.handleCommand(CommandType.OPEN_LINK_WITH_BROWSER.toString(),
					"https://eclipse.org/"
				 );
			 }
		});		
		nemoLink = new JHyperLinkLabel("http://nemo.inf.ufes.br/");
		GroupLayout gl_licensesDetailsPanel = new GroupLayout(detailsPanel);
		gl_licensesDetailsPanel.setHorizontalGroup(
			gl_licensesDetailsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_licensesDetailsPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_licensesDetailsPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(alloyLink, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
						.addComponent(tinyUMLLink, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
						.addComponent(detailsTextPane, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
						.addComponent(eclipseLink, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
						.addComponent(nemoLink, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_licensesDetailsPanel.setVerticalGroup(
			gl_licensesDetailsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_licensesDetailsPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(detailsTextPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(tinyUMLLink, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(alloyLink, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(eclipseLink, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nemoLink, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(71, Short.MAX_VALUE))
		);
		detailsPanel.setLayout(gl_licensesDetailsPanel);
		return detailsPanel;
	}

}
