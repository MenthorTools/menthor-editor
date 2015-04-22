package net.menthor.editor;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.eclipse.swt.custom.StackLayout;
import java.awt.CardLayout;
import java.awt.Color;

public class SplashScreen extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel statusLabel;
	private JLabel versionLabel;
	private JLabel splash_img;

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
		int left = 10;
		int bottom = imgHeigth - 14 - 8;
		
		
		versionLabel = new JLabel("Version "+MENTHOR_VERSION+" ("+MENTHOR_COMPILATION_DATE+")");
		layeredPane.setLayer(versionLabel, 1);
		versionLabel.setForeground(Color.WHITE);
		versionLabel.setBackground(Color.WHITE);
		versionLabel.setFont(new Font(versionLabel.getFont().getFontName(), Font.BOLD, 11));
		versionLabel.setBounds(left, bottom, 430, 14);
		layeredPane.add(versionLabel);
		
		statusLabel = new JLabel("Loading");
		statusLabel.setForeground(Color.WHITE);
		layeredPane.setLayer(statusLabel, 1);
		statusLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		statusLabel.setBounds(left, bottom - 14 - 8, 430, 14);
		layeredPane.add(statusLabel);
//		splash_img = new JLabel("");
//		splash_img.setIcon(new ImageIcon(SplashScreen.class.getResource("/resources/icons/menthor-splash-screen.png")));
//		add(splash_img);
//		
		
//		splash_img.setHorizontalAlignment(SwingConstants.CENTER);
//		splash_img.setVerticalAlignment(SwingConstants.CENTER);
//		
//		statusLabel = new JLabel("Loading");
//		statusLabel.setFont(new Font(Font.SERIF, Font.BOLD, 11));
//		statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
//		statusLabel.setVerticalAlignment(SwingConstants.BOTTOM);
//		add(statusLabel);
//		
//		versionLabel = new JLabel("Version "+MENTHOR_VERSION+" ("+MENTHOR_COMPILATION_DATE+")");
//		versionLabel.setFont(new Font(Font.SERIF, Font.BOLD, 11));
//		versionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
//		versionLabel.setVerticalAlignment(SwingConstants.TOP);
//		add(versionLabel);
//		
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