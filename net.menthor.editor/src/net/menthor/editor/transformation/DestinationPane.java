package net.menthor.editor.transformation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.menthor.common.transformation.DestinationEnum;

public class DestinationPane extends JPanel {

	private static final long serialVersionUID = 5020467392354283714L;
	
	private JPanel radioPane;
	private JRadioButton radioFile;
	private JRadioButton radioTab;
	private JPanel comboPane;
	private JLabel pathLabel;
	private JButton browseButton;
	private JTextField pathText;
	private JRadioButton radioApp;
	private ButtonGroup group;
	
	private String fileDescription;
	private String fileExtension;
	
	public void selectTab() { radioTab.setSelected(true); }
	public void selectFile() { radioFile.setSelected(true); }
	public void selectApp() { radioApp.setSelected(true); }
	
	public DestinationPane(String fileDescription, String fileExtension) 
	{
		setBorder(new TitledBorder(null, "Destination", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(5, 5));
		this.fileDescription = fileDescription;
		this.fileExtension = fileExtension;
		
		radioPane = new JPanel();
		add(radioPane, BorderLayout.SOUTH);
		
		radioApp = new JRadioButton("Other Application");
		radioPane.add(radioApp);
		radioApp.addActionListener(new ActionListener () {
			@Override
		    public void actionPerformed(ActionEvent e) {					        
		        enableFileChooser(false);
		    }
		});
		group = new ButtonGroup();
		group.add(radioApp);
		
		radioFile = new JRadioButton("File");
		radioPane.add(radioFile);
		radioFile.addActionListener(new ActionListener () {
			@Override
		    public void actionPerformed(ActionEvent e) {					        
		        enableFileChooser(true);
		    }
		});
		group.add(radioFile);
		
		radioTab = new JRadioButton("New Tab");
		radioPane.add(radioTab);
		radioTab.addActionListener(new ActionListener () {
			@Override
		    public void actionPerformed(ActionEvent e) {					        
		        enableFileChooser(false);
		    }
		});
		group.add(radioTab);
		
		comboPane = new JPanel();
		add(comboPane, BorderLayout.NORTH);
		comboPane.setLayout(new BorderLayout(10, 10));
		
		pathLabel = new JLabel("File Path:");
		pathLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		comboPane.add(pathLabel, BorderLayout.WEST);
		
		pathText = new JTextField();
		pathText.setBackground(Color.WHITE);
		comboPane.add(pathText, BorderLayout.CENTER);
		pathText.setColumns(10);
		pathText.setEditable(false);
		
		browseButton = new JButton("...");
		browseButton.setPreferredSize(new Dimension(35, 23));
		comboPane.add(browseButton, BorderLayout.EAST);
		browseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getFilePath();
			}
		});
	}
	
	public DestinationEnum getDestination() { 
		if(radioFile.isSelected()){
			return DestinationEnum.FILE;
		}
		else if(radioApp.isSelected()){
			return DestinationEnum.APP;
		}else{
			return DestinationEnum.TAB;
		}
	}
	
	public String getPath() { return pathText.getText(); }
	
	public JRadioButton getAppButton() { return radioApp; }
	
	public void renameAppButton(String text)
	{
		radioApp.setText(text);
	}
	
	public void enableFileChooser(boolean flag) 
	{
		pathText.setEnabled(flag);
		pathText.setEditable(flag);
		browseButton.setEnabled(flag);
		pathLabel.setEnabled(flag);
	}
	
	protected void getFilePath()
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Destination");
		FileNameExtensionFilter filter = new FileNameExtensionFilter(fileDescription, fileExtension);
		fileChooser.addChoosableFileFilter(filter);		
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) 
		{
			File selectedFile = fileChooser.getSelectedFile();
			pathText.setText(selectedFile.getAbsolutePath());
		}
	}
}
