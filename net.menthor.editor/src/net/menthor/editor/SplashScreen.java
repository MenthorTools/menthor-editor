package net.menthor.editor;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class SplashScreen extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel statusLabel;
	private JLabel versionLabel;
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
		splash_img.setIcon(new ImageIcon(SplashScreen.class.getResource("/resources/icons/menthor-splash-screen.png")));		
		int imgWidth = splash_img.getIcon().getIconWidth(); 
		int imgHeigth = splash_img.getIcon().getIconHeight();
		setSize(imgWidth, imgHeigth);
		splash_img.setBounds(SwingConstants.CENTER, SwingConstants.CENTER, imgWidth, imgHeigth);
		layeredPane.add(splash_img);
		versionLabel = new JLabel("Version "+MENTHOR_VERSION+" ("+MENTHOR_COMPILATION_DATE+")");
		versionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.setLayer(versionLabel, 1);
		versionLabel.setForeground(Color.WHITE);
		versionLabel.setBackground(Color.WHITE);
		versionLabel.setFont(new Font(versionLabel.getFont().getFontName(), Font.BOLD, 11));
		versionLabel.setBounds(10, 263, 580, 14);
		layeredPane.add(versionLabel);		
		statusLabel = new JLabel("Loading...");
		statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		statusLabel.setForeground(Color.WHITE);
		layeredPane.setLayer(statusLabel, 1);
		statusLabel.setFont(new Font(statusLabel.getFont().getFontName(), Font.ITALIC, 11));
		statusLabel.setBounds(10, 241, 580, 14);
		layeredPane.add(statusLabel);		
		rightsLabel = new JLabel("2015 Menthor. All rights reserved.");
		rightsLabel.setForeground(Color.WHITE);
		rightsLabel.setFont(new Font(statusLabel.getFont().getFontName(), Font.BOLD, 11));
		rightsLabel.setBounds(10, 288, 446, 14);		
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
				statusLabel.setText(status);				
			}
		});		
	}
}