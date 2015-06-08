package net.menthor.editor.transformation.owl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class OWLAxiomFilterPane extends JPanel {

	private static final long serialVersionUID = 8425787008147140307L;
	private JPanel disjPane;
	private JPanel binPane;
	private JPanel relCheckList;
	private JCheckBox domainCheck;
	private JCheckBox rangeCheck;
	private JCheckBox inverseCheck;
	private JCheckBox reflexivityCheck;
	private JCheckBox symmetryCheck;
	private JCheckBox transitivityCheck;
	private JCheckBox ciclicityCheck;
	private JCheckBox classCheck;
	private JCheckBox relationshipCheck;

	public OWLAxiomFilterPane()
	{	
		setPreferredSize(new Dimension(468, 323));
				
		disjPane = new JPanel();
		FlowLayout fl_disjPane = (FlowLayout) disjPane.getLayout();
		fl_disjPane.setAlignment(FlowLayout.LEFT);
		disjPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Disjointness", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		binPane = new JPanel();
		FlowLayout fl_binPane = (FlowLayout) binPane.getLayout();
		fl_binPane.setAlignment(FlowLayout.LEFT);
		binPane.setBorder(new TitledBorder(null, "Association Binary Properties", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		relCheckList = new JPanel();
		FlowLayout fl_relCheckList = (FlowLayout) relCheckList.getLayout();
		fl_relCheckList.setAlignment(FlowLayout.LEFT);
		relCheckList.setBorder(new TitledBorder(null, "Association", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		GroupLayout gl_axiomsPane = new GroupLayout(this);
		gl_axiomsPane.setHorizontalGroup(
			gl_axiomsPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_axiomsPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_axiomsPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(binPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
						.addGroup(gl_axiomsPane.createSequentialGroup()
							.addComponent(disjPane, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(relCheckList, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_axiomsPane.setVerticalGroup(
			gl_axiomsPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_axiomsPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_axiomsPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(disjPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(relCheckList, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(binPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(194, Short.MAX_VALUE))
		);
		setLayout(gl_axiomsPane);
		
		domainCheck = new JCheckBox("Domain");
		domainCheck.setSelected(true);
		relCheckList.add(domainCheck);
		
		rangeCheck = new JCheckBox("Range");
		rangeCheck.setSelected(true);
		relCheckList.add(rangeCheck);
		
		inverseCheck = new JCheckBox("Inverse");
		inverseCheck.setSelected(true);
		relCheckList.add(inverseCheck);
		
		reflexivityCheck = new JCheckBox("Reflexivity");
		reflexivityCheck.setSelected(true);
		binPane.add(reflexivityCheck);
		
		symmetryCheck = new JCheckBox("Symmetry");
		symmetryCheck.setSelected(true);
		binPane.add(symmetryCheck);
		
		transitivityCheck = new JCheckBox("Transitivity");
		transitivityCheck.setSelected(true);
		binPane.add(transitivityCheck);
		
		ciclicityCheck = new JCheckBox("Ciclicity");
		ciclicityCheck.setSelected(true);
		binPane.add(ciclicityCheck);
		
		classCheck = new JCheckBox("Class");
		classCheck.setSelected(true);
		disjPane.add(classCheck);
		
		relationshipCheck = new JCheckBox("Association");
		relationshipCheck.setSelected(true);
		disjPane.add(relationshipCheck);		
	}
	
	public boolean isReflexivity() { return reflexivityCheck.isSelected(); }
	public boolean isTransitivity() { return transitivityCheck.isSelected(); }
	public boolean isSymmetry() { return symmetryCheck.isSelected(); }
	public boolean isCiclicity() { return ciclicityCheck.isSelected(); }
	public boolean isClassDisjointness() { return classCheck.isSelected(); }
	public boolean isAssociatoinDisjointness() { return relationshipCheck.isSelected(); }
	public boolean isDomain() { return domainCheck.isSelected(); }
	public boolean isRange() { return rangeCheck.isSelected(); }
	public boolean isInverse() { return inverseCheck.isSelected(); }	
}
