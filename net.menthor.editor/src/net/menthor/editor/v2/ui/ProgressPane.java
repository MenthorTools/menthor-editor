package net.menthor.editor.v2.ui;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import net.menthor.editor.v2.types.ColorMap;
import net.menthor.editor.v2.types.ColorType;
 
public class ProgressPane extends JPanel implements PropertyChangeListener {
	
	private static final long serialVersionUID = 6088063042723702685L;
	
	protected JProgressBar progressBar;
    protected JButton startButton;
    protected JTextArea taskOutput;
     
    public JButton getStartButton() { return startButton; }
    
    public void disableUI(){
    	Toolkit.getDefaultToolkit().beep();
    	startButton.setEnabled(true);
        taskOutput.append("Done!\n");
    }
    
    public void append(String text){
    	taskOutput.append(text);
    }
    
    public void writeLine(String text){
    	taskOutput.append(text+"\n");
    }
    
    public void enableUI(){
    	 progressBar.setIndeterminate(true);
	     startButton.setEnabled(false);
    }
    
    public ProgressPane() {                
        super(new BorderLayout(5,5)); 
        startButton = new JButton("Start");
        startButton.setActionCommand("start"); 
        progressBar = new JProgressBar(0, 100);
        progressBar.setForeground(ColorMap.getInstance().getColor(ColorType.MENTHOR_BLUE_DARK));
        progressBar.setValue(0);
        taskOutput = new JTextArea(5, 20);
        taskOutput.setMargin(new Insets(5,5,5,5));
        taskOutput.setEditable(false); 
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(5, 5));
        panel.add(startButton, BorderLayout.WEST);
        panel.add(progressBar); 
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(taskOutput), BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
   
    public void propertyChange(PropertyChangeEvent evt){
        if ("progress" == evt.getPropertyName()) {
            int progress = (Integer) evt.getNewValue();
            progressBar.setIndeterminate(false);
            progressBar.setValue(progress);
            taskOutput.append(String.format("Completed %d%% of task.\n", progress));
        }
    }   
}