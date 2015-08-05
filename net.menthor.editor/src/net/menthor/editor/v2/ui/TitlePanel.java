package net.menthor.editor.v2.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.JLabel;

public class TitlePanel extends RoundedPanel {
	
	private static final long serialVersionUID = -531131162599115843L;
	
	private JLabel titleLabel;
	
	public TitlePanel(String name, Icon icon){		
		setLayout(new BorderLayout());
		titleLabel = new JLabel(name, icon, JLabel.LEFT);		
		titleLabel.setFocusable(false);		
		add(titleLabel, BorderLayout.CENTER);
		setMaximumSize(new Dimension(32767, 24));
		Dimension size = new Dimension(200, 24);
		setSize(size);
		setPreferredSize(size);		
	}
	
	public void setIcon(Icon icon){
		titleLabel.setIcon(icon);
	}
}
