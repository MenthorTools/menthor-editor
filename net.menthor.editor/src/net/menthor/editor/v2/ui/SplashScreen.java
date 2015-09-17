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

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import net.menthor.editor.v2.icon.IconMap;
import net.menthor.editor.v2.icon.IconType;

public class SplashScreen extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel splash_img;
	private JLabel rightsLabel;
	
	public SplashScreen(String MENTHOR_VERSION, String MENTHOR_COMPILATION_DATE) {		
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setUndecorated(true);
		setResizable(false);		
		getContentPane().setLayout(new CardLayout(0, 0));		
		JLayeredPane layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane, "name_431739735183481");		
		splash_img = new JLabel("");
		splash_img.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_SPLASH_SCREEN));		
		int imgWidth = splash_img.getIcon().getIconWidth(); 
		int imgHeigth = splash_img.getIcon().getIconHeight();
		setSize(600, 316);
		splash_img.setBounds(SwingConstants.CENTER, SwingConstants.CENTER, imgWidth, imgHeigth);
		layeredPane.add(splash_img);
		rightsLabel = new JLabel("Copyright © 2015 Menthor. All rights reserved.");
		rightsLabel.setFont(new Font(rightsLabel.getFont().getFontName(), Font.BOLD, 11));
		rightsLabel.setForeground(Color.WHITE);
		rightsLabel.setBounds(10, 291, 446, 24);		
		layeredPane.setLayer(rightsLabel, 1);
		layeredPane.add(rightsLabel);
		setLocationRelativeTo(null);
		setVisible(true);				
	}

	public boolean isOptimizedDrawingEnabled() {
        return false;
    }
	
	private void runInEdt(final Runnable runnable) {
		if (SwingUtilities.isEventDispatchThread())
			runnable.run();
		else
			SwingUtilities.invokeLater(runnable);
	}

	public void close() {
		runInEdt(new Runnable() {
			public void run() {
				setVisible(false);
				dispose();
			}
		});
	}

	public void setStatusLabel(final String status){
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
				//statusLabel.setText(status);				
			}
		});		
	}
}