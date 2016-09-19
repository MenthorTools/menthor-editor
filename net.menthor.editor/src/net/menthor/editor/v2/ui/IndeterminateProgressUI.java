package net.menthor.editor.v2.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

public class IndeterminateProgressUI extends JDialog{
	
	private static final long serialVersionUID = -197348588476747912L;
	
	private JProgressBar progressBar;	
	
	public static void main(String[] args) throws InterruptedException{
		IndeterminateProgressUI d = open();
		Thread.sleep(3000);
		d.dispose();
	}
	
	public static IndeterminateProgressUI open() throws InterruptedException{					
		IndeterminateProgressUI dialog = new IndeterminateProgressUI(FrameUI.get());
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		dialog.setLocationRelativeTo(FrameUI.get());	
		return dialog;
	}
	
	public JProgressBar getProgressBar(){ return progressBar; }
	
	private IndeterminateProgressUI(Component parent){	
		super((Frame) parent);	
		setTitle("Executing...");
	    Container content = getContentPane();
	    progressBar = new JProgressBar();
	    progressBar.setIndeterminate(true);
	    progressBar.setStringPainted(true);
	    Border border = BorderFactory.createTitledBorder("This might take just a few seconds");
	    progressBar.setBorder(border);
	    content.add(progressBar, BorderLayout.CENTER);	    
	    setPreferredSize(new Dimension(500, 100));	    
	    repaint();
		validate();
		pack();
	}
}
