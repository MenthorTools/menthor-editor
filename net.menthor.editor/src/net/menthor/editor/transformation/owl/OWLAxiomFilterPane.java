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
	private JCheckBox irreflexiveCheck;
	private JCheckBox classCheck;
	private JCheckBox relationshipCheck;
	private JCheckBox cardinalityCheck;
	private JCheckBox functionalCheck;
	private JCheckBox inverseFuncCheck;
	private JCheckBox assymetricCheck;
	private JPanel panel_1;
	private JCheckBox rulesCheck;
	private JCheckBox ufoStructure;
	
	public OWLAxiomFilterPane()
	{	
		setPreferredSize(new Dimension(538, 290));
				
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Class", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.setBorder(new TitledBorder(null, "SWRL", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Structure", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		ufoStructure = new JCheckBox("UFO Structure");
		ufoStructure.setSelected(true);
		panel_2.add(ufoStructure);
		
		GroupLayout gl_axiomsPane = new GroupLayout(this);
		gl_axiomsPane.setHorizontalGroup(
			gl_axiomsPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_axiomsPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_axiomsPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_axiomsPane.createSequentialGroup()
							.addGroup(gl_axiomsPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(binPane, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_axiomsPane.createSequentialGroup()
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(relCheckList, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_axiomsPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(disjPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		gl_axiomsPane.setVerticalGroup(
			gl_axiomsPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_axiomsPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_axiomsPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(relCheckList, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(disjPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_axiomsPane.createParallelGroup(Alignment.LEADING)
						.addComponent(binPane, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(77, Short.MAX_VALUE))
		);
		
		rulesCheck = new JCheckBox("Rules");
		rulesCheck.setSelected(true);
		panel_1.add(rulesCheck);
		
		cardinalityCheck = new JCheckBox("Cardinality");
		cardinalityCheck.setSelected(true);
		panel.add(cardinalityCheck);
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
		
		irreflexiveCheck = new JCheckBox("Irreflexive");
		irreflexiveCheck.setSelected(true);
		binPane.add(irreflexiveCheck);
		
		symmetryCheck = new JCheckBox("Symmetry");
		symmetryCheck.setSelected(true);
		binPane.add(symmetryCheck);
		
		assymetricCheck = new JCheckBox("Asymmetric");
		assymetricCheck.setSelected(true);
		binPane.add(assymetricCheck);
		
		transitivityCheck = new JCheckBox("Transitivity");
		transitivityCheck.setSelected(true);
		binPane.add(transitivityCheck);
		
		functionalCheck = new JCheckBox("Functional");
		functionalCheck.setSelected(true);
		binPane.add(functionalCheck);
		
		inverseFuncCheck = new JCheckBox("Inverse Functional");
		inverseFuncCheck.setSelected(true);
		binPane.add(inverseFuncCheck);
		
		classCheck = new JCheckBox("Class");
		classCheck.setSelected(true);
		disjPane.add(classCheck);
		
		relationshipCheck = new JCheckBox("Association");
		relationshipCheck.setSelected(true);
		disjPane.add(relationshipCheck);		
	}
	
	public boolean isTransitivity() { return transitivityCheck.isSelected(); }
	public boolean isSymmetry() { return symmetryCheck.isSelected(); }
	public boolean isAsymmetric() { return irreflexiveCheck.isSelected(); }
	public boolean isReflexivity() { return reflexivityCheck.isSelected(); }
	public boolean isIrreflexive() { return irreflexiveCheck.isSelected(); }
	public boolean isFunctional() { return functionalCheck.isSelected(); }
	public boolean isInverseFunctional() { return inverseFuncCheck.isSelected(); }
	
	public boolean isClassDisjointness() { return classCheck.isSelected(); }
	public boolean isAssociatoinDisjointness() { return relationshipCheck.isSelected(); }
	public boolean isDomain() { return domainCheck.isSelected(); }
	public boolean isRange() { return rangeCheck.isSelected(); }
	public boolean isInverse() { return inverseCheck.isSelected(); }	
	public boolean isCardinality() { return cardinalityCheck.isSelected(); }
	
	public boolean isRules() { return rulesCheck.isSelected(); }
	public boolean isUfoStructure() { return ufoStructure.isSelected(); }
}
