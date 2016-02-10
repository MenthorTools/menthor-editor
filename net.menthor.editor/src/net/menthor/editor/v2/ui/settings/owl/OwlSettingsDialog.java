package net.menthor.editor.v2.ui.settings.owl;

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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingWorker;

import RefOntoUML.parser.OntoUMLParser;
import net.menthor.common.settings.owl.OwlOptions;
import net.menthor.editor.v2.OntoumlDiagram;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.ui.generic.GenericSettingsDialog;
import net.menthor.editor.v2.ui.icon.IconMap;
import net.menthor.editor.v2.ui.icon.IconType;

public class OwlSettingsDialog extends GenericSettingsDialog {
	
	private static final long serialVersionUID = -6094162448551064500L;
	
	private OwlMainPane mainPane;
	private OwlAxiomsPane axiomsPane;
	private OwlPrimitivePane primitivePane;
	private OwlQualityPane qualityPane;
	private OwlGenSetPane gsPane;	
	
	//==================================================
	//CONSTRUCTOR
	//==================================================
	
	public OwlSettingsDialog(JFrame frame, ICommandListener listener, OntoUMLParser refparser, List<OntoumlDiagram> diagrams){
		super(frame, listener, refparser, diagrams);		
		buildUI(refparser);
	}
	
	private void buildUI(OntoUMLParser refparser){
		mainPane = new OwlMainPane();
		primitivePane = new OwlPrimitivePane(refparser);
		qualityPane = new OwlQualityPane(refparser);
		gsPane = new OwlGenSetPane(refparser);
		axiomsPane = new OwlAxiomsPane();		
		addNonClosable("Main", mainPane);
		addNonClosable("Filter", getFilter());
		addNonClosable("Axioms", axiomsPane);
		addNonClosable("Data Types", primitivePane);
		addNonClosable("Qualities", qualityPane);
		addNonClosable("Generalization Sets", gsPane);		
		tabbedPane.setSelectedComponent(mainPane);				
		setTitle("OWL Settings");
		setIconImage(IconMap.getInstance().getImage(IconType.MENTHOR_SEMANTIC_WEB));
		setSize(500, 550);
		getProgressPane().getStartButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				OwlSettingsDialog.this.getProgressPane().enableUI();
				Task task = new Task();
		        task.addPropertyChangeListener(OwlSettingsDialog.this.getProgressPane());
		        task.execute();
			}
		});
	}

	//==================================================
	//TASK EXECUTION
	//==================================================
	
	public void storeToXML() throws Exception{
		OwlSettingsMap.getInstance().eraseMappings(refparser);
		axiomsPane.storeToXML();
		primitivePane.storeToXML();
		qualityPane.storeToXML();
		gsPane.storeToXML();
		mainPane.storeToXML();
	}
	
	class Task extends SwingWorker<Void, Void> {
        @Override
        public Void doInBackground() {        	
        	try {    			
        		OwlSettingsDialog.this.storeToXML();
    			List<Object> context = new ArrayList<Object>();
    			OntoUMLParser refparser = filterPane.getFilteredParser();
    			OwlOptions opt =  OwlSettingsMap.getInstance().getOwlOptions(refparser);		
				context.add(refparser);
				context.add(opt);
				/** Execution */
    			Object result = listener.handleCommand(CommandType.GENERATE_OWL.toString(), new Object[]{context});
    			/** String Result */
    			if(result instanceof String){
    				getProgressPane().writeLine((String)result);
    			}        		
    			setProgress(100);    			
        	}catch (Exception e1){
        		OwlSettingsDialog.this.getProgressPane().append("Something unsual happepend: "+e1.getLocalizedMessage());
    			e1.printStackTrace();
    		}        	        	
            return null;
        }      
        public void done() {
        	OwlSettingsDialog.this.getProgressPane().disableUI();
        }
    }	
}
