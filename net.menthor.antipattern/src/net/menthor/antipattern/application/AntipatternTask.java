package net.menthor.antipattern.application;

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

import java.awt.Font;
import java.util.concurrent.CountDownLatch;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

import net.menthor.antipattern.AntipatternInfo;

public class AntipatternTask extends SwingWorker<Void, Void>{
	private Antipattern<?> antipattern;
	private AntipatternInfo info;
	private JLabel label;
	private JLabel progressBarDescr;
	private JCheckBox checkBox;
	private JProgressBar progressBar;
	private int percentage;
	
	private CountDownLatch latch;
	private CountDownLatch preLatch;
	
	public AntipatternTask(Antipattern<?> antipattern, AntipatternInfo info, JLabel label, JCheckBox checkBox, 
			JProgressBar progressBar, JLabel progressBarDescr, int percentage, CountDownLatch latch, CountDownLatch preLatch) {
		this.antipattern = antipattern;
		this.label = label;
		this.checkBox = checkBox;
		this.progressBar = progressBar;
		this.percentage = percentage;
		this.progressBarDescr = progressBarDescr;
		this.info = info;
		this.latch = latch;
		this.preLatch = preLatch;
	}

	@Override
	protected Void doInBackground() throws Exception {	
		
		preLatch.await();
		
		updateStatus(info.getAcronym()+": Identifying...");
		antipattern.identify();
		
		return null;	
	}
	
	@Override
	protected void done() {
		label.setText("("+antipattern.getOccurrences().size()+")");						
		
		if(antipattern.getOccurrences().size()>0){
			checkBox.setFont(new Font(checkBox.getFont().getFontName(), Font.BOLD,checkBox.getFont().getSize()));
			label.setFont(new Font(label.getFont().getFontName(), Font.BOLD,label.getFont().getSize()));
			progressBar.setValue(progressBar.getValue()+percentage);
			updateStatus(info.getAcronym()+": "+antipattern.getOccurrences().size()+" occurrence(s) found!");
		}
		
		latch.countDown();
	}
	
	private void updateStatus(String s) {
		progressBarDescr.setText(s);
		System.out.println(s);
		
	}

	
	

}
