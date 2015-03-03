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
package net.menthor.editor.dialog.help;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import net.menthor.editor.AppFrame;
import net.menthor.editor.Main;
import net.menthor.editor.palette.ColorPalette;
import net.menthor.editor.palette.ColorPalette.ThemeColor;
import net.menthor.editor.ui.JHyperLinkLabel;

/**
 * @author John Guerson
 */
public class AboutDialog extends JDialog {

	private static final long serialVersionUID = -251319551154959770L;
	private JPanel CenterPanel;
	private JLabel label;
	private JLabel lblVersion;
	
	/**
	 * Launch the Dialog.
	 */
	public static void open(AppFrame frame) 
	{
		try {
			
			AboutDialog dialog = new AboutDialog(frame);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(frame);
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public AboutDialog(final AppFrame frame) 
	{
		super(frame);
		
		setTitle("About Menthor");
		setBounds(100, 100, 365, 182);
		
		CenterPanel = new JPanel();
		CenterPanel.setBackground(Color.WHITE);
		CenterPanel.setPreferredSize(new Dimension(150, 190));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(100, 100));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		
		JLabel lblOntoumlLightweightEditor = new JLabel("Menthor Editor");
		lblOntoumlLightweightEditor.setForeground(Color.BLACK);
		lblOntoumlLightweightEditor.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblVersion = new JLabel("Version: "+Main.MENTHOR_VERSION);
		lblVersion.setForeground(Color.BLACK);		
		lblVersion.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblDate = new JLabel("Build Date: Mar 02 2015");
		lblDate.setForeground(Color.BLACK);		
		lblDate.setHorizontalAlignment(SwingConstants.LEFT);
		
		JHyperLinkLabel lblNewLabel = new JHyperLinkLabel("");
		lblNewLabel.setText("menthor.net");
		lblNewLabel.addMouseListener(new MouseAdapter() {			
			 @Override
			    public void mouseClicked(MouseEvent e) {				 
					frame.getDiagramManager().openLinkWithBrowser("https://menthor.net");				 
			 }
		});
		panel.setLayout(new BorderLayout(0, 0));
		
		label = new JLabel("");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(label, BorderLayout.CENTER);
		panel.setBackground(ColorPalette.getInstance().getColor(ThemeColor.BLUE_LIGHTEST));
		label.setBackground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(AboutDialog.class.getResource("/resources/icons/menthor-64x64.png")));
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(CenterPanel, BorderLayout.CENTER);
		CenterPanel.setLayout(new BorderLayout(0, 0));
		CenterPanel.add(panel_1, BorderLayout.CENTER);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblVersion, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDate, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblOntoumlLightweightEditor, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
					.addGap(11))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblOntoumlLightweightEditor)
					.addGap(12)
					.addComponent(lblVersion)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDate)
					.addGap(18)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(149, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		CenterPanel.add(panel, BorderLayout.WEST);
	}
}
