package net.menthor.editor.v2.types.settings;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class OwlAxiomsPane extends JPanel {

	private static final long serialVersionUID = 8425787008147140307L;
	
	private JPanel binPane;	
	private JPanel assocPane;
	private JCheckBox domainCheck;
	private JCheckBox rangeCheck;
	private JCheckBox inverseCheck;
	private JCheckBox reflexivityCheck;
	private JCheckBox symmetryCheck;
	private JCheckBox transitivityCheck;
	private JCheckBox irreflexiveCheck;
	private JCheckBox classDisjCheck;
	private JCheckBox assocDisjCheck;
	private JCheckBox cardinalityCheck;
	private JCheckBox functionalCheck;
	private JCheckBox inverseFuncCheck;
	private JCheckBox assymetricCheck;	
	private JCheckBox rulesCheck;
	private JCheckBox ufoStructure;
	private JCheckBox classCompleteCheck;
	private JCheckBox labelsCheck;
	private JCheckBox commentsCheck;
	private JComboBox<OwlReasonerType> owlReasonerBox;
	private JLabel iriLabel;
	private JTextField iriTextField;
	private JLabel lblClass;
	private JPanel midPane;
	private JLabel lblAssociation;
	private JLabel lblBinaryProperties;
	private JLabel lblDocumentation;
	private JLabel lblReasoner;
	private JCheckBox assocNameByEndsCheck;
	
	public OwlAxiomsPane(){	
		buildUI();		
		loadFromXML();
	}
	
	public void loadFromXML(){
		OwlSettingsMap.getInstance().load();
		assymetricCheck.setSelected(OwlSettingsMap.getInstance().getValue(OwlAxiomsType.ASYMMETRIC));
		cardinalityCheck.setSelected(OwlSettingsMap.getInstance().getValue(OwlAxiomsType.CARDINALITIES));
		commentsCheck.setSelected(OwlSettingsMap.getInstance().getValue(OwlAxiomsType.COMMENTS));
		classCompleteCheck.setSelected(OwlSettingsMap.getInstance().getValue(OwlAxiomsType.COMPLETENESS_OF_CLASSES));
		assocDisjCheck.setSelected(OwlSettingsMap.getInstance().getValue(OwlAxiomsType.DISJOINTNESS_OF_ASSOCIATIONS));
		classDisjCheck.setSelected(OwlSettingsMap.getInstance().getValue(OwlAxiomsType.DISJOINTNESS_OF_CLASSES));
		domainCheck.setSelected(OwlSettingsMap.getInstance().getValue(OwlAxiomsType.DOMAIN));
		functionalCheck.setSelected(OwlSettingsMap.getInstance().getValue(OwlAxiomsType.FUNCTIONAL));
		inverseCheck.setSelected(OwlSettingsMap.getInstance().getValue(OwlAxiomsType.INVERSE));
		inverseFuncCheck.setSelected(OwlSettingsMap.getInstance().getValue(OwlAxiomsType.INVERSE_FUNCTIONAL));
		irreflexiveCheck.setSelected(OwlSettingsMap.getInstance().getValue(OwlAxiomsType.IRREFLEXIVE));
		labelsCheck.setSelected(OwlSettingsMap.getInstance().getValue(OwlAxiomsType.LABELS));
		rangeCheck.setSelected(OwlSettingsMap.getInstance().getValue(OwlAxiomsType.RANGE));
		reflexivityCheck.setSelected(OwlSettingsMap.getInstance().getValue(OwlAxiomsType.REFLEXIVE));
		rulesCheck.setSelected(OwlSettingsMap.getInstance().getValue(OwlAxiomsType.SWRL_RULES));
		symmetryCheck.setSelected(OwlSettingsMap.getInstance().getValue(OwlAxiomsType.SYMMETRIC));
		transitivityCheck.setSelected(OwlSettingsMap.getInstance().getValue(OwlAxiomsType.TRANSITIVE));
		ufoStructure.setSelected(OwlSettingsMap.getInstance().getValue(OwlAxiomsType.UFO_STRUCTURE));
		ufoStructure.setSelected(OwlSettingsMap.getInstance().getValue(OwlAxiomsType.ASSOC_NAME_BY_ENDS));
		owlReasonerBox.setSelectedItem(OwlSettingsMap.getInstance().getReasoner());
		iriTextField.setText(OwlSettingsMap.getInstance().getIRI());
	}
	
	public void storeToXML(){
		OwlSettingsMap.getInstance().setValue(OwlAxiomsType.ASYMMETRIC,assymetricCheck.isSelected());
		OwlSettingsMap.getInstance().setValue(OwlAxiomsType.CARDINALITIES,cardinalityCheck.isSelected());
		OwlSettingsMap.getInstance().setValue(OwlAxiomsType.COMMENTS,commentsCheck.isSelected());
		OwlSettingsMap.getInstance().setValue(OwlAxiomsType.COMPLETENESS_OF_CLASSES,classCompleteCheck.isSelected());
		OwlSettingsMap.getInstance().setValue(OwlAxiomsType.DISJOINTNESS_OF_ASSOCIATIONS,assocDisjCheck.isSelected());
		OwlSettingsMap.getInstance().setValue(OwlAxiomsType.DISJOINTNESS_OF_CLASSES,classDisjCheck.isSelected());
		OwlSettingsMap.getInstance().setValue(OwlAxiomsType.DOMAIN,domainCheck.isSelected());
		OwlSettingsMap.getInstance().setValue(OwlAxiomsType.FUNCTIONAL,functionalCheck.isSelected());
		OwlSettingsMap.getInstance().setValue(OwlAxiomsType.INVERSE,inverseCheck.isSelected());		
		OwlSettingsMap.getInstance().setValue(OwlAxiomsType.INVERSE_FUNCTIONAL,inverseFuncCheck.isSelected());
		OwlSettingsMap.getInstance().setValue(OwlAxiomsType.IRREFLEXIVE,irreflexiveCheck.isSelected());
		OwlSettingsMap.getInstance().setValue(OwlAxiomsType.LABELS,labelsCheck.isSelected());
		OwlSettingsMap.getInstance().setValue(OwlAxiomsType.RANGE,rangeCheck.isSelected());
		OwlSettingsMap.getInstance().setValue(OwlAxiomsType.REFLEXIVE,reflexivityCheck.isSelected());
		OwlSettingsMap.getInstance().setValue(OwlAxiomsType.SWRL_RULES,rulesCheck.isSelected());
		OwlSettingsMap.getInstance().setValue(OwlAxiomsType.SYMMETRIC,symmetryCheck.isSelected());
		OwlSettingsMap.getInstance().setValue(OwlAxiomsType.TRANSITIVE,transitivityCheck.isSelected());
		OwlSettingsMap.getInstance().setValue(OwlAxiomsType.UFO_STRUCTURE,ufoStructure.isSelected());
		OwlSettingsMap.getInstance().setValue(OwlAxiomsType.ASSOC_NAME_BY_ENDS,assocNameByEndsCheck.isSelected());
		OwlSettingsMap.getInstance().setReasoner((OwlReasonerType)owlReasonerBox.getSelectedItem());
		OwlSettingsMap.getInstance().setIRI((String)iriTextField.getText());
		OwlSettingsMap.getInstance().store();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void buildUI(){
		setPreferredSize(new Dimension(604, 427));
		JPanel headerPane = new JPanel();		
		midPane = new JPanel();
		GroupLayout gl_axiomsPane = new GroupLayout(this);
		gl_axiomsPane.setHorizontalGroup(
			gl_axiomsPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_axiomsPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_axiomsPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(headerPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(midPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 466, Short.MAX_VALUE))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		gl_axiomsPane.setVerticalGroup(
			gl_axiomsPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_axiomsPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(headerPane, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(midPane, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
		);
		JPanel classPane = new JPanel();
		FlowLayout fl_classPane = (FlowLayout) classPane.getLayout();
		fl_classPane.setAlignment(FlowLayout.LEFT);
		classPane.setBorder(null);		
		lblClass = new JLabel("Class:");
		classPane.add(lblClass);
		cardinalityCheck = new JCheckBox("Cardinality");
		classPane.add(cardinalityCheck);		
		classDisjCheck = new JCheckBox("Disjoint");
		classPane.add(classDisjCheck);		
		classCompleteCheck = new JCheckBox("Complete");
		classPane.add(classCompleteCheck);
		assocPane = new JPanel();
		FlowLayout fl_assocPane = (FlowLayout) assocPane.getLayout();
		fl_assocPane.setAlignment(FlowLayout.LEFT);		
		lblAssociation = new JLabel("Association:");
		assocPane.add(lblAssociation);
		domainCheck = new JCheckBox("Domain");
		assocPane.add(domainCheck);		
		rangeCheck = new JCheckBox("Range");
		assocPane.add(rangeCheck);		
		inverseCheck = new JCheckBox("Inverse");
		assocPane.add(inverseCheck);		
		assocDisjCheck = new JCheckBox("Disjoint");
		assocPane.add(assocDisjCheck);		
		binPane = new JPanel();
		FlowLayout fl_binPane = (FlowLayout) binPane.getLayout();
		fl_binPane.setAlignment(FlowLayout.LEFT);
		binPane.setBorder(null);		
		lblBinaryProperties = new JLabel("Binary Properties:");
		binPane.add(lblBinaryProperties);
		reflexivityCheck = new JCheckBox("Reflexivity");
		binPane.add(reflexivityCheck);		
		irreflexiveCheck = new JCheckBox("Irreflexive");
		binPane.add(irreflexiveCheck);		
		symmetryCheck = new JCheckBox("Symmetry");
		binPane.add(symmetryCheck);		
		assymetricCheck = new JCheckBox("Asymmetric");
		binPane.add(assymetricCheck);		
		transitivityCheck = new JCheckBox("Transitivity");
		binPane.add(transitivityCheck);		
		functionalCheck = new JCheckBox("Functional");
		binPane.add(functionalCheck);		
		inverseFuncCheck = new JCheckBox("Inverse Functional");
		binPane.add(inverseFuncCheck);
		JPanel docPane = new JPanel();
		FlowLayout fl_docPane = (FlowLayout) docPane.getLayout();
		fl_docPane.setAlignment(FlowLayout.LEFT);
		docPane.setBorder(null);				
		lblDocumentation = new JLabel("Other:");
		docPane.add(lblDocumentation);
		ufoStructure = new JCheckBox("UFO Structure");
		docPane.add(ufoStructure);
		labelsCheck = new JCheckBox("Labels");
		docPane.add(labelsCheck);		
		commentsCheck = new JCheckBox("Comments");
		docPane.add(commentsCheck);
		GroupLayout gl_midPane = new GroupLayout(midPane);
		gl_midPane.setHorizontalGroup(
			gl_midPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_midPane.createSequentialGroup()
					.addGap(5)
					.addComponent(classPane, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(assocPane, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(binPane, GroupLayout.PREFERRED_SIZE, 126, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(docPane, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addGap(114))
		);
		gl_midPane.setVerticalGroup(
			gl_midPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_midPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_midPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(assocPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
						.addComponent(binPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
						.addComponent(docPane, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
						.addComponent(classPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		assocNameByEndsCheck = new JCheckBox("Named by Ends");
		assocNameByEndsCheck.setSelected(true);
		assocPane.add(assocNameByEndsCheck);
		rulesCheck = new JCheckBox("Rules");
		docPane.add(rulesCheck);
		lblReasoner = new JLabel("Reasoner:");
		docPane.add(lblReasoner);
		owlReasonerBox = new JComboBox<OwlReasonerType>();
		docPane.add(owlReasonerBox);
		owlReasonerBox.setModel(new DefaultComboBoxModel(OwlReasonerType.values()));
		midPane.setLayout(gl_midPane);
		headerPane.setLayout(new BorderLayout(5, 5));
		iriLabel = new JLabel("Ontology IRI:");
		iriLabel.setHorizontalAlignment(SwingConstants.LEFT);
		headerPane.add(iriLabel, BorderLayout.WEST);		
		iriTextField = new JTextField();
		headerPane.add(iriTextField);
		iriTextField.setFont(new Font(iriTextField.getFont().getName(),Font.PLAIN,iriTextField.getFont().getSize()));
		iriTextField.setColumns(10);
		setLayout(gl_axiomsPane);		
	}
}
