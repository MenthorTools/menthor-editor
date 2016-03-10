package net.menthor.editor.v2.ui.settings.als;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;

import net.menthor.common.settings.als.ALS4Approach;
import net.menthor.editor.v2.ui.generic.GenericApproachPane;

public class AlsApproachPane extends GenericApproachPane {

	private static final long serialVersionUID = -4968883469407719592L;
	
	public AlsApproachPane(){
		super();
		buildUI();
	}
		
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void buildUI(){		
		approachesCombo.setModel(new DefaultComboBoxModel(ALS4Approach.values()));
		approachesCombo.setSelectedItem(ALS4Approach.BRANCHING);		
		approachesCombo.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ALS4Approach mt = (ALS4Approach) approachesCombo.getSelectedItem();
				descriptionTextPane.setText(mt.getDescription());
			}
		});
		
		descriptionTextPane.setText(ALS4Approach.BRANCHING.getDescription());
	}	
	
	//====================================================
	//Getters & Setters
	//====================================================
	
	public ALS4Approach getApproach(){
		return (ALS4Approach) approachesCombo.getSelectedItem();
	}
	
	//====================================================
	//Serializing methods
	//====================================================
	
	public void loadFromXML(){
				
	}
	
	public void storeToXML(){		
		
	}
}