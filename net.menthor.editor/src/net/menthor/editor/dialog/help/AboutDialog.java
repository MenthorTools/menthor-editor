package net.menthor.editor.dialog.help;

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
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import net.menthor.editor.AppFrame;
import net.menthor.editor.Main;
import net.menthor.editor.ui.JHyperLinkLabel;
import net.menthor.resources.icons.ColorMap;
import net.menthor.resources.icons.ColorType;

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
		setBounds(100, 100, 369, 263);
		
		CenterPanel = new JPanel();
		CenterPanel.setBackground(Color.WHITE);
		CenterPanel.setPreferredSize(new Dimension(150, 190));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(100, 100));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		
		JLabel lblOntoumlLightweightEditor = new JLabel("Menthor Editor |");
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
		panel.setBackground(ColorMap.getInstance().getColor(ColorType.MENTHOR_BLUE_LIGHTEST));
		label.setBackground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(AboutDialog.class.getResource("/resources/icons/menthor-64x64.png")));
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(CenterPanel, BorderLayout.CENTER);
		CenterPanel.setLayout(new BorderLayout(0, 0));
		CenterPanel.add(panel_1, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(10))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblVersion, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
								.addComponent(lblDate, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
									.addComponent(lblOntoumlLightweightEditor, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))))
					.addGap(10))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOntoumlLightweightEditor)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addComponent(lblVersion)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDate)
					.addGap(18)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
		);
		
		JTextPane txtpnThisProductIncludes = new JTextPane();
		txtpnThisProductIncludes.setBackground(UIManager.getColor("Panel.background"));
		txtpnThisProductIncludes.setText("This product includes software developed by other open source projects including TinyUML, Alloy and Eclipse Foundation.");
		
		JHyperLinkLabel tinyUMLLink = new JHyperLinkLabel("");
		tinyUMLLink.setText("sourceforge.net/projects/tinyuml/");
		tinyUMLLink.addMouseListener(new MouseAdapter() {			
			 @Override
			    public void mouseClicked(MouseEvent e) {				 
					frame.getDiagramManager().openLinkWithBrowser("http://sourceforge.net/projects/tinyuml/");				 
			 }
		});
		JHyperLinkLabel alloyLink = new JHyperLinkLabel("");
		alloyLink.setText("alloy.mit.edu/alloy/");
		alloyLink.addMouseListener(new MouseAdapter() {			
			 @Override
			    public void mouseClicked(MouseEvent e) {				 
					frame.getDiagramManager().openLinkWithBrowser("http://alloy.mit.edu/alloy/");				 
			 }
		});
		
		JHyperLinkLabel eclipseLink = new JHyperLinkLabel("");
		eclipseLink.setText("https://eclipse.org/");
		eclipseLink.addMouseListener(new MouseAdapter() {			
			 @Override
			    public void mouseClicked(MouseEvent e) {				 
					frame.getDiagramManager().openLinkWithBrowser("https://eclipse.org/");				 
			 }
		});
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpnThisProductIncludes, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(alloyLink, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(tinyUMLLink, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
						.addComponent(eclipseLink, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtpnThisProductIncludes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tinyUMLLink, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(alloyLink, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(eclipseLink, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		panel_1.setLayout(gl_panel_1);
		CenterPanel.add(panel, BorderLayout.WEST);
	}
}
