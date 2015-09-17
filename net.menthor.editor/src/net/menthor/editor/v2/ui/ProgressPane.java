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