package net.menthor.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.OverlayLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class SplashScreen extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel statusLabel;
	private JLabel versionLabel;
	private JLabel splash_img;

	public SplashScreen(String MENTHOR_VERSION, String MENTHOR_COMPILATION_DATE) {
		splash_img = new JLabel("");
		splash_img.setIcon(new ImageIcon(SplashScreen.class.getResource("/resources/icons/menthor-splash-screen.png")));
		add(splash_img);
		
		setSize(splash_img.getIcon().getIconWidth(), splash_img.getIcon().getIconHeight());
		splash_img.setHorizontalAlignment(SwingConstants.CENTER);
		splash_img.setVerticalAlignment(SwingConstants.CENTER);
		
		statusLabel = new JLabel("Loading");
		statusLabel.setFont(new Font(Font.SERIF, Font.BOLD, 11));
		statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		statusLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		statusLabel.setBackground(new Color(0, 0, 0, 0));
//		add(statusLabel);
		
		versionLabel = new JLabel("Version "+MENTHOR_VERSION+" ("+MENTHOR_COMPILATION_DATE+")");
		versionLabel.setFont(new Font(Font.SERIF, Font.BOLD, 11));
		versionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		versionLabel.setVerticalAlignment(SwingConstants.TOP);
//		add(versionLabel);
		
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
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

	public void setStatusLabel(String status) {
		this.statusLabel.setText(status);
	}
	
	public static void main(String[] args) {
		SplashScreen splashScreen = new SplashScreen(Main.MENTHOR_VERSION, Main.MENTHOR_COMPILATION_DATE);
		
	}
}