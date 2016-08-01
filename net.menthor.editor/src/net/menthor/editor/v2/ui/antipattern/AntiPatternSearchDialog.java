package net.menthor.editor.v2.ui.antipattern;

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
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.eclipse.swt.widgets.Display;

import RefOntoUML.parser.OntoUMLParser;
import net.menthor.antipattern.AntiPatternList;
import net.menthor.antipattern.Antipattern;
import net.menthor.antipattern.AntipatternInfo;
import net.menthor.antipattern.GSRig.GSRigAntipattern;
import net.menthor.antipattern.asscyc.AssCycAntipattern;
import net.menthor.antipattern.binover.BinOverAntipattern;
import net.menthor.antipattern.decint.DecIntAntipattern;
import net.menthor.antipattern.depphase.DepPhaseAntipattern;
import net.menthor.antipattern.freerole.FreeRoleAntipattern;
import net.menthor.antipattern.hetcoll.HetCollAntipattern;
import net.menthor.antipattern.homofunc.HomoFuncAntipattern;
import net.menthor.antipattern.impabs.ImpAbsAntipattern;
import net.menthor.antipattern.mixiden.MixIdenAntipattern;
import net.menthor.antipattern.mixrig.MixRigAntipattern;
import net.menthor.antipattern.multidep.MultiDepAntipattern;
import net.menthor.antipattern.partover.PartOverAntipattern;
import net.menthor.antipattern.relcomp.RelCompAntipattern;
import net.menthor.antipattern.relover.RelOverAntipattern;
import net.menthor.antipattern.relrig.RelRigAntipattern;
import net.menthor.antipattern.relspec.RelSpecAntipattern;
import net.menthor.antipattern.reprel.RepRelAntipattern;
import net.menthor.antipattern.undefformal.UndefFormalAntipattern;
import net.menthor.antipattern.undefphase.UndefPhaseAntipattern;
import net.menthor.antipattern.wholeover.WholeOverAntipattern;
import net.menthor.editor.v2.ui.controller.ProjectUIController;
import net.menthor.swt.Util;

/**
 * @author Tiago Sales
 * @author John Guerson
 *
 */

public class AntiPatternSearchDialog extends JDialog {

	private static final long serialVersionUID = 1L;
		
	private JFrame frame;
	private OntoUMLParser parser; 
	
	private final JPanel contentPanel = new JPanel();
		
	private AntipatternTask assCycTask, binOverTask, depPhaseTask, freeRoleTask, gsRigTask,
							hetCollTask, homoFuncTask, impAbsTask, MixIdenTask, MixRigTask,
							MultiDepTask, RelCompTask, RelOverTask, RelRigTask, RelSpecTask,
							RepRelTask, UndefFormalTask, UndefPhaseTask, WholeOverTask, 
							PartOverTask, DecIntTask;
	
	private ArrayList<AntipatternTask> allTasks = new ArrayList<AntipatternTask>();
	
	private JCheckBox cbxAssCyc;	
	private JCheckBox cbxBinOver;	
	private JCheckBox cbxDepPhase;
	private JCheckBox cbxFreeRole;
	private JCheckBox cbxGSRig;
	private JCheckBox cbxHetColl;
	private JCheckBox cbxHomoFunc;
	private JCheckBox cbxImpAbs;
	private JCheckBox cbxMixIden;
	private JCheckBox cbxMixRig;
	private JCheckBox cbxMultiDep;
	private JCheckBox cbxRelComp;
	private JCheckBox cbxRelOver;
	private JCheckBox cbxRelRig;
	private JCheckBox cbxRelSpec;	
	private JCheckBox cbxRepRel;
	private JCheckBox cbxUndefFormal;
	private JCheckBox cbxUndefPhase;
	private JCheckBox cbxWholeOver;
	private JCheckBox cbxPartOver;
	private JCheckBox cbxDecInt;
	
	ArrayList<JCheckBox> cbxList = new ArrayList<JCheckBox>();
	
	private JButton lblAssCycIco;	
	private JButton lblBinOverIco;	
	private JButton lblDepPhaseIco;
	private JButton lblFreeRoleIco;
	private JButton lblGSRigIco;
	private JButton lblHetCollIco;
	private JButton lblHomoFuncIco;
	private JButton lblImpAbsIco;
	private JButton lblMixIdenIco;
	private JButton lblMixRigIco;
	private JButton lblMultiDepIco;
	private JButton lblRelCompIco;
	private JButton lblRelOverIco;
	private JButton lblRelRigIco;
	private JButton lblRelSpecIco;
	private JButton lblRepRelIco;
	private JButton lblUndefFormalIco;
	private JButton lblUndefPhaseIco;
	private JButton lblWholeOverIco;
	private JButton lblPartOverIco;
	private JButton lblDecIntIco;
	
	ArrayList<JButton> lblIcoList = new ArrayList<JButton>();
	
	private JProgressBar progressBar;
	private JLabel progressBarDescr;
		
	private JLabel lblAssCycRes;
	private JLabel lblBinOverRes;
	private JLabel lblDepPhaseRes;
	private JLabel lblFreeRoleRes;
	private JLabel lblGSRigRes;
	private JLabel lblHetCollRes;
	private JLabel lblHomoFuncRes;
	private JLabel lblImpAbsRes;
	private JLabel lblMixIdenRes;
	private JLabel lblMixRigRes;
	private JLabel lblMultiDepRes;
	private JLabel lblRelCompRes;
	private JLabel lblRelOverRes;
	private JLabel lblRelRigRes;
	private JLabel lblRelSpecRes;
	private JLabel lblRepRelRes;
	private JLabel lblUndefFormalRes;
	private JLabel lblUndefPhaseRes;
	private JLabel lblWholeOverRes;
	private JLabel lblPartOverRes;
	private JLabel lblDecIntRes;
	
	ArrayList<JLabel> lblResultList = new ArrayList<JLabel>();
	
	private JButton identifyButton;
	private JButton closeButton;
	private JButton showButton;
	private JButton stopButton;
	
	@SuppressWarnings("unused")
	private String result = new String();
	private JPanel panel_1;

	private int incrementalValue;

	private ExecutorService executor;

	private CountDownLatch latch;

	private AntiPatternList antipatternList;

	private SwingWorker<Void,Void> preTask;

	/** transfer result of search to an application */
	public void transferResult(AntiPatternList list){
		ProjectUIController.get().getProject().setAntipatterns(list);
	}
	
	/** open the result which in turn can call the wizards */
	public void openResult(AntiPatternList list, Display display){ 
		AntiPatternResultDialog.openDialog(list,frame, display); 
	}
	
	/** 
	 * Check if AntiPattern is selected.
	 */
	
	public Boolean AssCycisSelected() { return cbxAssCyc.isSelected(); }
	public Boolean BinOverisSelected() { return cbxBinOver.isSelected(); }
	public Boolean DecIntisSelected() { return cbxDecInt.isSelected(); }
	public Boolean DepPhaseisSelected() { return cbxDepPhase.isSelected(); }
	public Boolean freeRoleIsSelected() { return cbxFreeRole.isSelected(); }
	public Boolean gsRigIsSelected() { return cbxGSRig.isSelected(); }
	public Boolean HetCollisSelected() { return cbxHetColl.isSelected(); }
	public Boolean HomoFuncisSelected() { return cbxHomoFunc.isSelected(); }
	public Boolean ImpAbsisSelected() { return cbxImpAbs.isSelected(); }
	public Boolean MixIdenisSelected() { return cbxMixIden.isSelected(); }
	public Boolean MixRigisSelected() { return cbxMixRig.isSelected(); }
	public Boolean MultiDepisSelected() { return cbxMultiDep.isSelected(); }
	public Boolean PartOverisSelected() { return cbxPartOver.isSelected(); }
	public Boolean RelCompisSelected() { return cbxRelComp.isSelected(); }
	public Boolean RelOverisSelected() { return cbxRelOver.isSelected(); }
	public Boolean RelRigisSelected() { return cbxRelRig.isSelected(); }
	public Boolean RelSpecisSelected() { return cbxRelSpec.isSelected(); }
	public Boolean RepRelisSelected() { return cbxRepRel.isSelected(); }
	public Boolean UndefFormalisSelected() { return cbxUndefFormal.isSelected(); }
	public Boolean UndefPhaseisSelected() { return cbxUndefPhase.isSelected(); }
	public Boolean WholeOverisSelected() { return cbxWholeOver.isSelected(); }
	
	
	
	/**
	 * Create the dialog.
	 */
	public AntiPatternSearchDialog(JFrame parent, OntoUMLParser refparser) 
	{
		super(parent);
		
		this.frame = parent;
		this.parser = refparser;
		
		setTitle("Anti-Pattern Identification");
		setBounds(100, 100, 854, 511);
		 
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setPreferredSize(new Dimension(180, 410));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		
		JLabel lblChooseWhichAntipattern = new JLabel("    Choose which anti-pattern do you want to search:");;
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(BorderFactory.createTitledBorder(""));
		JPanel rightPanel = new JPanel();
		rightPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		rightPanel.setBorder(BorderFactory.createTitledBorder(""));
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBorder(BorderFactory.createTitledBorder(""));
		
		panel_1 = new JPanel();
		panel_1.setBorder(BorderFactory.createTitledBorder(""));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblChooseWhichAntipattern, GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
								.addComponent(leftPanel, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(rightPanel, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE))))
					.addGap(3))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblChooseWhichAntipattern)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(leftPanel, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
						.addComponent(rightPanel, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		identifyButton = new JButton("Search");
		panel_1.add(identifyButton);
		identifyButton.setIcon(null);
		
		closeButton = new JButton("Close");
		panel_1.add(closeButton);
		
		stopButton = new JButton("Stop");
		stopButton.setEnabled(false);
		panel_1.add(stopButton);
		
		showButton = new JButton("Show Result");
		panel_1.add(showButton);
		showButton.setEnabled(false);		
		showButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				//dispose();
				Thread t = new Thread(new Runnable() {					
					@Override
					public void run() {
						final Display display ;
						if(Util.onWindows()){
							display = new Display();
						}else{
							display = Display.getDefault();
						}
						showResult(antipatternList, display);						
					}
				});
				t.start();
			}
		});
		
		stopButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				updateStatus("Antipattern: analysis stopped by the user!");
				interruptAll();			
			}
		});
		
		closeButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				interruptAll();			
				dispose();
			}
		});
		
		identifyButton.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			IdentifyButtonActionPerformed(event);				
       		}
       	});
		
		JButton btnEnableall = new JButton("Enable All");
		panel.add(btnEnableall);
		
		btnEnableall.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			setSelectedCheckboxes(true);
       		}
       	});
		
		JButton btnDisableall = new JButton("Disable All");
		panel.add(btnDisableall);
		
		btnDisableall.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent event) {
       			setSelectedCheckboxes(false);       			
       		}
       	});
		
		cbxMultiDep = new JCheckBox(MultiDepAntipattern.getAntipatternInfo().getAcronym()+": "+MultiDepAntipattern.getAntipatternInfo().getName());
		cbxMultiDep.setPreferredSize(new Dimension(265, 20));
		cbxMultiDep.setBackground(UIManager.getColor("Panel.background"));
		lblMultiDepRes = new JLabel("");
		lblMultiDepRes.setPreferredSize(new Dimension(75, 20));
		lblMultiDepRes.setForeground(Color.BLUE);
		lblMultiDepIco = new JButton();
		lblMultiDepIco.setPreferredSize(new Dimension(20, 20));
		lblMultiDepIco.setOpaque(false);
		lblMultiDepIco.setContentAreaFilled(false);
		lblMultiDepIco.setBorderPainted(false);		
		rightPanel.add(lblMultiDepIco);
		rightPanel.add(cbxMultiDep);
		rightPanel.add(lblMultiDepRes);
		
		cbxRelComp = new JCheckBox(RelCompAntipattern.getAntipatternInfo().getAcronym()+": "+RelCompAntipattern.getAntipatternInfo().getName());
		cbxRelComp.setPreferredSize(new Dimension(225, 20));
		cbxRelComp.setBackground(UIManager.getColor("Panel.background"));
		lblRelCompRes = new JLabel("");
		lblRelCompRes.setPreferredSize(new Dimension(115, 20));
		lblRelCompRes.setForeground(Color.BLUE);
		lblPartOverIco = new JButton();
		lblPartOverIco.setPreferredSize(new Dimension(20, 20));
		lblPartOverIco.setOpaque(false);
		lblPartOverIco.setContentAreaFilled(false);
		lblPartOverIco.setBorderPainted(false);		
		rightPanel.add(lblPartOverIco);
		
		cbxPartOver = new JCheckBox(PartOverAntipattern.getAntipatternInfo().getAcronym()+": "+PartOverAntipattern.getAntipatternInfo().getName());
		cbxPartOver.setPreferredSize(new Dimension(320, 20));
		cbxPartOver.setBackground(UIManager.getColor("Panel.background"));
		rightPanel.add(cbxPartOver);
		lblPartOverRes = new JLabel("");
		lblPartOverRes.setPreferredSize(new Dimension(20, 20));		
		lblPartOverRes.setForeground(Color.BLUE);
		rightPanel.add(lblPartOverRes);
		lblRelCompIco = new JButton();
		lblRelCompIco.setPreferredSize(new Dimension(20, 20));
		lblRelCompIco.setOpaque(false);
		lblRelCompIco.setContentAreaFilled(false);
		lblRelCompIco.setBorderPainted(false);		
		rightPanel.add(lblRelCompIco);
		rightPanel.add(cbxRelComp);
		rightPanel.add(lblRelCompRes);
		
		cbxRelOver = new JCheckBox(RelOverAntipattern.getAntipatternInfo().getAcronym()+": "+RelOverAntipattern.getAntipatternInfo().getName());
		cbxRelOver.setPreferredSize(new Dimension(297, 20));
		cbxRelOver.setBackground(UIManager.getColor("Panel.background"));
		lblRelOverRes = new JLabel("");
		lblRelOverRes.setPreferredSize(new Dimension(43, 20));
		lblRelOverRes.setForeground(Color.BLUE);		
		lblRelOverIco  = new JButton();
		lblRelOverIco.setPreferredSize(new Dimension(20, 20));
		lblRelOverIco.setOpaque(false);
		lblRelOverIco.setContentAreaFilled(false);
		lblRelOverIco.setBorderPainted(false);		
		rightPanel.add(lblRelOverIco);
		rightPanel.add(cbxRelOver);
		rightPanel.add(lblRelOverRes);
		lblRelRigIco = new JButton();
		lblRelRigIco.setPreferredSize(new Dimension(20, 20));
		lblRelRigIco.setOpaque(false);
		lblRelRigIco.setContentAreaFilled(false);
		lblRelRigIco.setBorderPainted(false);		
		rightPanel.add(lblRelRigIco);
		
		cbxRelRig = new JCheckBox(RelRigAntipattern.getAntipatternInfo().getAcronym()+": "+RelRigAntipattern.getAntipatternInfo().getName());
		cbxRelRig.setPreferredSize(new Dimension(255, 20));
		cbxRelRig.setBackground(UIManager.getColor("Panel.background"));
		rightPanel.add(cbxRelRig);
		lblRelRigRes = new JLabel("");
		lblRelRigRes.setPreferredSize(new Dimension(85, 20));
		lblRelRigRes.setForeground(Color.BLUE);		
		rightPanel.add(lblRelRigRes);
		
		cbxRelSpec = new JCheckBox(RelSpecAntipattern.getAntipatternInfo().getAcronym()+": "+RelSpecAntipattern.getAntipatternInfo().getName());
		cbxRelSpec.setPreferredSize(new Dimension(225, 20));
		cbxRelSpec.setBackground(UIManager.getColor("Panel.background"));
		lblRelSpecRes = new JLabel("");
		lblRelSpecRes.setPreferredSize(new Dimension(115, 20));
		lblRelSpecRes.setForeground(Color.BLUE);
		lblRelSpecIco = new JButton();
		lblRelSpecIco.setPreferredSize(new Dimension(20, 20));
		lblRelSpecIco.setOpaque(false);
		lblRelSpecIco.setContentAreaFilled(false);
		lblRelSpecIco.setBorderPainted(false);		
		rightPanel.add(lblRelSpecIco);
		rightPanel.add(cbxRelSpec);
		rightPanel.add(lblRelSpecRes);
		
		cbxRepRel = new JCheckBox(RepRelAntipattern.getAntipatternInfo().getAcronym()+": "+RepRelAntipattern.getAntipatternInfo().getName());
		cbxRepRel.setPreferredSize(new Dimension(260, 20));
		cbxRepRel.setBackground(UIManager.getColor("Panel.background"));
		lblRepRelRes = new JLabel("");
		lblRepRelRes.setPreferredSize(new Dimension(80, 20));
		lblRepRelRes.setForeground(Color.BLUE);	
		lblRepRelIco = new JButton();
		lblRepRelIco.setPreferredSize(new Dimension(20, 20));
		lblRepRelIco.setOpaque(false);
		lblRepRelIco.setContentAreaFilled(false);
		lblRepRelIco.setBorderPainted(false);		
		rightPanel.add(lblRepRelIco);
		rightPanel.add(cbxRepRel);
		rightPanel.add(lblRepRelRes);
		
		cbxUndefFormal = new JCheckBox(UndefFormalAntipattern.getAntipatternInfo().getAcronym()+": "+UndefFormalAntipattern.getAntipatternInfo().getName());	
		cbxUndefFormal.setPreferredSize(new Dimension(320, 20));
		cbxUndefFormal.setBackground(UIManager.getColor("Panel.background"));
		lblUndefFormalRes = new JLabel("");
		lblUndefFormalRes.setPreferredSize(new Dimension(20, 20));		
		lblUndefFormalRes.setForeground(Color.BLUE);
		lblUndefFormalIco = new JButton();
		lblUndefFormalIco.setPreferredSize(new Dimension(20, 20));
		lblUndefFormalIco.setOpaque(false);
		lblUndefFormalIco.setContentAreaFilled(false);
		lblUndefFormalIco.setBorderPainted(false);
		rightPanel.add(lblUndefFormalIco);
		rightPanel.add(cbxUndefFormal);
		rightPanel.add(lblUndefFormalRes);
		
		cbxUndefPhase = new JCheckBox(UndefPhaseAntipattern.getAntipatternInfo().getAcronym()+": "+UndefPhaseAntipattern.getAntipatternInfo().getName());
		cbxUndefPhase.setPreferredSize(new Dimension(265, 20));
		cbxUndefPhase.setBackground(UIManager.getColor("Panel.background"));
		lblUndefPhaseRes = new JLabel("");
		lblUndefPhaseRes.setPreferredSize(new Dimension(75, 20));		
		lblUndefPhaseRes.setForeground(Color.BLUE);
		rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		lblUndefPhaseIco = new JButton();
		lblUndefPhaseIco.setPreferredSize(new Dimension(20, 20));
		lblUndefPhaseIco.setOpaque(false);
		lblUndefPhaseIco.setContentAreaFilled(false);
		lblUndefPhaseIco.setBorderPainted(false);
		rightPanel.add(lblUndefPhaseIco);
		rightPanel.add(cbxUndefPhase);
		rightPanel.add(lblUndefPhaseRes);
		lblWholeOverIco = new JButton();
		lblWholeOverIco.setPreferredSize(new Dimension(20, 20));
		lblWholeOverIco.setOpaque(false);
		lblWholeOverIco.setContentAreaFilled(false);
		lblWholeOverIco.setBorderPainted(false);
		rightPanel.add(lblWholeOverIco);
		
		cbxWholeOver = new JCheckBox(WholeOverAntipattern.getAntipatternInfo().getAcronym()+": "+WholeOverAntipattern.getAntipatternInfo().getName());
		cbxWholeOver.setPreferredSize(new Dimension(320, 20));
		cbxWholeOver.setBackground(UIManager.getColor("Panel.background"));
		rightPanel.add(cbxWholeOver);
		lblWholeOverRes = new JLabel("");
		lblWholeOverRes.setPreferredSize(new Dimension(20, 20));		
		lblWholeOverRes.setForeground(Color.BLUE);
		rightPanel.add(lblWholeOverRes);
		leftPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPanel.setLayout(gl_contentPanel);		
		lblAssCycIco = new JButton();
		lblAssCycIco.setPreferredSize(new Dimension(20, 20));
		lblAssCycIco.setOpaque(false);
		lblAssCycIco.setContentAreaFilled(false);
		lblAssCycIco.setBorderPainted(false);
		leftPanel.add(lblAssCycIco);
		
		cbxAssCyc = new JCheckBox(AssCycAntipattern.getAntipatternInfo().getAcronym()+": "+AssCycAntipattern.getAntipatternInfo().getName());
		cbxAssCyc.setPreferredSize(new Dimension(185, 20));
		cbxAssCyc.setBackground(UIManager.getColor("Panel.background"));
		leftPanel.add(cbxAssCyc);
		lblAssCycRes = new JLabel("");		
		lblAssCycRes.setPreferredSize(new Dimension(155, 20));		
		lblAssCycRes.setForeground(Color.BLUE);
		leftPanel.add(lblAssCycRes);
		lblBinOverIco = new JButton();
		lblBinOverIco.setPreferredSize(new Dimension(20, 20));
		lblBinOverIco.setOpaque(false);
		lblBinOverIco.setContentAreaFilled(false);
		lblBinOverIco.setBorderPainted(false);		
		leftPanel.add(lblBinOverIco);
		
		cbxBinOver = new JCheckBox(BinOverAntipattern.getAntipatternInfo().getAcronym()+": "+BinOverAntipattern.getAntipatternInfo().getName());	
		cbxBinOver.setPreferredSize(new Dimension(305, 20));
		cbxBinOver.setBackground(UIManager.getColor("Panel.background"));
		leftPanel.add(cbxBinOver);
		lblBinOverRes = new JLabel("");		
		lblBinOverRes.setPreferredSize(new Dimension(35, 20));		
		lblBinOverRes.setForeground(Color.BLUE);
		leftPanel.add(lblBinOverRes);
		
		lblDecIntIco = new JButton();
		lblDecIntIco.setPreferredSize(new Dimension(20, 20));
		lblDecIntIco.setOpaque(false);
		lblDecIntIco.setContentAreaFilled(false);
		lblDecIntIco.setBorderPainted(false);
		leftPanel.add(lblDecIntIco);
		
		cbxDecInt = new JCheckBox(DecIntAntipattern.getAntipatternInfo().getAcronym()+": "+DecIntAntipattern.getAntipatternInfo().getName());		
		cbxDecInt.setPreferredSize(new Dimension(250, 20));
		cbxDecInt.setBackground(UIManager.getColor("Panel.background"));
		leftPanel.add(cbxDecInt);
		lblDecIntRes = new JLabel("");
		lblDecIntRes.setPreferredSize(new Dimension(90, 20));		
		lblDecIntRes.setForeground(Color.BLUE);
		leftPanel.add(lblDecIntRes);
		
		lblDepPhaseIco = new JButton();
		lblDepPhaseIco.setPreferredSize(new Dimension(20, 20));
		lblDepPhaseIco.setOpaque(false);
		lblDepPhaseIco.setContentAreaFilled(false);
		lblDepPhaseIco.setBorderPainted(false);
		leftPanel.add(lblDepPhaseIco);
		
		cbxDepPhase = new JCheckBox(DepPhaseAntipattern.getAntipatternInfo().getAcronym()+": "+DepPhaseAntipattern.getAntipatternInfo().getName());
		cbxDepPhase.setPreferredSize(new Dimension(275, 20));
		cbxDepPhase.setBackground(UIManager.getColor("Panel.background"));
		leftPanel.add(cbxDepPhase);
		lblDepPhaseRes = new JLabel("");		
		lblDepPhaseRes.setPreferredSize(new Dimension(65, 20));		
		lblDepPhaseRes.setForeground(Color.BLUE);
		leftPanel.add(lblDepPhaseRes);
		lblFreeRoleIco = new JButton();
		lblFreeRoleIco.setPreferredSize(new Dimension(20, 20));
		lblFreeRoleIco.setOpaque(false);
		lblFreeRoleIco.setContentAreaFilled(false);
		lblFreeRoleIco.setBorderPainted(false);
		leftPanel.add(lblFreeRoleIco);
		
		cbxFreeRole = new JCheckBox(FreeRoleAntipattern.getAntipatternInfo().getAcronym()+": "+FreeRoleAntipattern.getAntipatternInfo().getName());	
		cbxFreeRole.setPreferredSize(new Dimension(230, 20));
		cbxFreeRole.setBackground(UIManager.getColor("Panel.background"));
		leftPanel.add(cbxFreeRole);
		lblFreeRoleRes = new JLabel("");		
		lblFreeRoleRes.setPreferredSize(new Dimension(110, 20));		
		lblFreeRoleRes.setForeground(Color.BLUE);
		leftPanel.add(lblFreeRoleRes);
		lblGSRigIco = new JButton();
		lblGSRigIco.setPreferredSize(new Dimension(20, 20));
		lblGSRigIco.setOpaque(false);
		lblGSRigIco.setContentAreaFilled(false);
		lblGSRigIco.setBorderPainted(false);
		leftPanel.add(lblGSRigIco);
		
		cbxGSRig = new JCheckBox("GSRig: Generalization Set with Mixed Rigidity");		
		cbxGSRig.setPreferredSize(new Dimension(300, 20));
		cbxGSRig.setBackground(UIManager.getColor("Panel.background"));
		leftPanel.add(cbxGSRig);
		lblGSRigRes = new JLabel("");
		lblGSRigRes.setPreferredSize(new Dimension(40, 20));		
		lblGSRigRes.setForeground(Color.BLUE);		
		leftPanel.add(lblGSRigRes);
		lblHetCollIco = new JButton();
		lblHetCollIco.setPreferredSize(new Dimension(20, 20));
		lblHetCollIco.setOpaque(false);
		lblHetCollIco.setContentAreaFilled(false);
		lblHetCollIco.setBorderPainted(false);		
		leftPanel.add(lblHetCollIco);
		
		cbxHetColl = new JCheckBox(HetCollAntipattern.getAntipatternInfo().getAcronym()+": "+HetCollAntipattern.getAntipatternInfo().getName());		
		cbxHetColl.setPreferredSize(new Dimension(230, 20));
		cbxHetColl.setBackground(UIManager.getColor("Panel.background"));
		leftPanel.add(cbxHetColl);
		lblHetCollRes = new JLabel("");
		lblHetCollRes.setPreferredSize(new Dimension(110, 20));		
		lblHetCollRes.setForeground(Color.BLUE);
		leftPanel.add(lblHetCollRes);
		lblHomoFuncIco = new JButton();
		lblHomoFuncIco.setPreferredSize(new Dimension(20, 20));
		lblHomoFuncIco.setOpaque(false);
		lblHomoFuncIco.setContentAreaFilled(false);
		lblHomoFuncIco.setBorderPainted(false);
		leftPanel.add(lblHomoFuncIco);
		
		cbxHomoFunc = new JCheckBox(HomoFuncAntipattern.getAntipatternInfo().getAcronym()+": "+HomoFuncAntipattern.getAntipatternInfo().getName());	
		cbxHomoFunc.setPreferredSize(new Dimension(300, 20));
		cbxHomoFunc.setBackground(UIManager.getColor("Panel.background"));
		leftPanel.add(cbxHomoFunc);
		lblHomoFuncRes = new JLabel("");
		lblHomoFuncRes.setPreferredSize(new Dimension(40, 20));		
		lblHomoFuncRes.setForeground(Color.BLUE);		
		leftPanel.add(lblHomoFuncRes);
		lblImpAbsIco  = new JButton();
		lblImpAbsIco.setPreferredSize(new Dimension(20, 20));		
		lblImpAbsIco.setOpaque(false);
		lblImpAbsIco.setContentAreaFilled(false);
		lblImpAbsIco.setBorderPainted(false);		
		leftPanel.add(lblImpAbsIco);
		
		cbxImpAbs = new JCheckBox(ImpAbsAntipattern.getAntipatternInfo().getAcronym()+": "+ImpAbsAntipattern.getAntipatternInfo().getName());		
		cbxImpAbs.setPreferredSize(new Dimension(220, 20));
		cbxImpAbs.setBackground(UIManager.getColor("Panel.background"));
		leftPanel.add(cbxImpAbs);
		lblImpAbsRes = new JLabel("");
		lblImpAbsRes.setPreferredSize(new Dimension(120, 20));		
		lblImpAbsRes.setForeground(Color.BLUE);		
		leftPanel.add(lblImpAbsRes);
		lblMixIdenIco = new JButton();
		lblMixIdenIco.setPreferredSize(new Dimension(20, 20));		
		lblMixIdenIco.setOpaque(false);
		lblMixIdenIco.setContentAreaFilled(false);
		lblMixIdenIco.setBorderPainted(false);		
		leftPanel.add(lblMixIdenIco);
		
		cbxMixIden = new JCheckBox(MixIdenAntipattern.getAntipatternInfo().getAcronym()+": "+MixIdenAntipattern.getAntipatternInfo().getName());	
		cbxMixIden.setPreferredSize(new Dimension(230, 20));
		cbxMixIden.setBackground(UIManager.getColor("Panel.background"));
		leftPanel.add(cbxMixIden);
		lblMixIdenRes = new JLabel("");
		lblMixIdenRes.setPreferredSize(new Dimension(110, 20));		
		lblMixIdenRes.setForeground(Color.BLUE);
		leftPanel.add(lblMixIdenRes);
		lblMixRigIco  = new JButton();
		leftPanel.add(lblMixRigIco);
		lblMixRigIco.setPreferredSize(new Dimension(20, 20));
		lblMixRigIco.setOpaque(false);
		lblMixRigIco.setContentAreaFilled(false);
		lblMixRigIco.setBorderPainted(false);
				
		cbxMixRig = new JCheckBox(MixRigAntipattern.getAntipatternInfo().getAcronym()+": "+MixRigAntipattern.getAntipatternInfo().getName());		
		leftPanel.add(cbxMixRig);
		cbxMixRig.setPreferredSize(new Dimension(220, 20));
		cbxMixRig.setBackground(UIManager.getColor("Panel.background"));
		lblMixRigRes = new JLabel("");
		leftPanel.add(lblMixRigRes);
		lblMixRigRes.setPreferredSize(new Dimension(120, 20));		
		lblMixRigRes.setForeground(Color.BLUE);
	
		JPanel buttonPane = new JPanel();
		getContentPane().add(buttonPane, BorderLayout.CENTER);
		buttonPane.setPreferredSize(new Dimension(60, 65));
		
		progressBarDescr = new JLabel("");		
		progressBarDescr.setForeground(Color.BLUE);		
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);	
		
		GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
		gl_buttonPane.setHorizontalGroup(
			gl_buttonPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_buttonPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_buttonPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(progressBarDescr, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(progressBar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_buttonPane.setVerticalGroup(
			gl_buttonPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_buttonPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(progressBarDescr)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		buttonPane.setLayout(gl_buttonPane);
		
		 cbxList.add(cbxAssCyc);
		 cbxList.add(cbxBinOver);	
		 cbxList.add(cbxDepPhase);
		 cbxList.add( cbxFreeRole);
		 cbxList.add(cbxGSRig);
		 cbxList.add(cbxHetColl);
		 cbxList.add(cbxHomoFunc);
		 cbxList.add(cbxImpAbs);
		 cbxList.add(cbxMixIden);
		 cbxList.add(cbxMixRig);
		 cbxList.add(cbxMultiDep);
		 cbxList.add(cbxRelComp);
		 cbxList.add(cbxRelOver);
		 cbxList.add(cbxRelRig);
		 cbxList.add(cbxRelSpec);	
		 cbxList.add(cbxRepRel);
		 cbxList.add(cbxUndefFormal);
		 cbxList.add(cbxUndefPhase);
		 cbxList.add(cbxWholeOver);
		 cbxList.add(cbxPartOver);
		 cbxList.add(cbxDecInt);
		 
		 lblIcoList.add(lblAssCycIco);	
		 lblIcoList.add(lblBinOverIco);	
		 lblIcoList.add(lblDepPhaseIco);
		 lblIcoList.add(lblFreeRoleIco);
		 lblIcoList.add(lblGSRigIco);
		 lblIcoList.add(lblHetCollIco);
		 lblIcoList.add(lblHomoFuncIco);
		 lblIcoList.add(lblImpAbsIco);
		 lblIcoList.add(lblMixIdenIco);
		 lblIcoList.add(lblMixRigIco);
		 lblIcoList.add(lblMultiDepIco);
		 lblIcoList.add(lblRelCompIco);
		 lblIcoList.add(lblRelOverIco);
		 lblIcoList.add(lblRelRigIco);
		 lblIcoList.add(lblRelSpecIco);
		 lblIcoList.add(lblRepRelIco);
		 lblIcoList.add(lblUndefFormalIco);
		 lblIcoList.add(lblUndefPhaseIco);
		 lblIcoList.add(lblWholeOverIco);
		 lblIcoList.add(lblPartOverIco);
		 lblIcoList.add(lblDecIntIco);
		
		 lblResultList.add(lblAssCycRes);
		 lblResultList.add(lblBinOverRes);
		 lblResultList.add(lblDepPhaseRes);
		 lblResultList.add(lblFreeRoleRes);
		 lblResultList.add(lblGSRigRes);
		 lblResultList.add(lblHetCollRes);
		 lblResultList.add(lblHomoFuncRes);
		 lblResultList.add(lblImpAbsRes);
		 lblResultList.add(lblMixIdenRes);
		 lblResultList.add(lblMixRigRes);
		 lblResultList.add(lblMultiDepRes);
		 lblResultList.add(lblRelCompRes);
		 lblResultList.add(lblRelOverRes);
		 lblResultList.add(lblRelRigRes);
		 lblResultList.add(lblRelSpecRes);
		 lblResultList.add(lblRepRelRes);
		 lblResultList.add(lblUndefFormalRes);
		 lblResultList.add(lblUndefPhaseRes);
		 lblResultList.add(lblWholeOverRes);
		 lblResultList.add(lblPartOverRes);
		 lblResultList.add(lblDecIntRes);
		
		setIcons();
		showAllAntiPatternIconLabels(true);	
	}
	
	public void setIcons(){
		//lblUndefFormalIco.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELP));
		//lblUndefFormalIco.setRolloverIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELPROLLOVER));
		//lblUndefPhaseIco.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELP));
		//lblUndefPhaseIco.setRolloverIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELPROLLOVER));
		//lblWholeOverIco.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELP));
		//lblWholeOverIco.setRolloverIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELPROLLOVER));
		//lblAssCycIco.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELP));
		//lblAssCycIco.setRolloverIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELPROLLOVER));
		//lblBinOverIco.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELP));
		//lblBinOverIco.setRolloverIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELPROLLOVER));
		//lblDecIntIco.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELP));
		//lblDecIntIco.setRolloverIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELPROLLOVER));
		//lblDepPhaseIco.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELP));
		//lblDepPhaseIco.setRolloverIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELPROLLOVER));
		//lblFreeRoleIco.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELP));
		//lblFreeRoleIco.setRolloverIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELPROLLOVER));
		//lblGSRigIco.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELP));
		//lblGSRigIco.setRolloverIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELPROLLOVER));
		//lblHetCollIco.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELP));
		//lblHetCollIco.setRolloverIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELPROLLOVER));
		//lblHomoFuncIco.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELP));
		//lblHomoFuncIco.setRolloverIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELPROLLOVER));
		//lblImpAbsIco.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELP));
		//lblImpAbsIco.setRolloverIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELPROLLOVER));
		//lblMixIdenIco.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELP));
		//lblMixIdenIco.setRolloverIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELPROLLOVER));
		//lblMixRigIco.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELP));
		//lblMixRigIco.setRolloverIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELPROLLOVER));
		//lblRepRelIco.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELP));
		//lblRepRelIco.setRolloverIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELPROLLOVER));
		//lblRelSpecIco.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELP));
		//lblRelSpecIco.setRolloverIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELPROLLOVER));
		//lblRelRigIco.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELP));
		//lblRelRigIco.setRolloverIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELPROLLOVER));
		//lblRelOverIco.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELP));
		//lblRelOverIco.setRolloverIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELPROLLOVER));
		//lblRelCompIco.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELP));
		//lblRelCompIco.setRolloverIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELPROLLOVER));
		//lblPartOverIco.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELP));
		//lblPartOverIco.setRolloverIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELPROLLOVER));
		//lblMultiDepIco.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELP));
		//lblMultiDepIco.setRolloverIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_HELPROLLOVER));
	}
	
	
	/**
	 * Open the Dialog.
	 */
	public static void  open (JFrame parent, OntoUMLParser refparser)
	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
			AntiPatternSearchDialog dialog = new AntiPatternSearchDialog(parent, refparser);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(parent);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean onMac() {
		return System.getProperty("mrj.version") != null || System.getProperty("os.name").toLowerCase(Locale.US).startsWith("mac ");
	}
	
	/**
	 * Show Result
	 */
	public void showResult(final AntiPatternList apList, final Display display)
	{
		if(onMac()){
			com.apple.concurrent.Dispatch.getInstance().getNonBlockingMainQueueExecutor().execute( new Runnable(){        	
				@Override
				public void run() {			    	
			    	openResult(apList,display);
				}
			});
		}else{
			openResult(apList, display);
		}
	}
	
	public void cleanResultlabels () {
		for (JLabel label : lblResultList) 
			label.setText("");
	}
		
	public void showAllAntiPatternIconLabels(boolean b){
		for (JButton ico : lblIcoList)
			ico.setVisible(b);
	}
	
	public void setPlainFontOnCheckboxes() {
		for (JCheckBox cbx : cbxList)
			cbx.setFont(new Font(cbx.getFont().getName(), Font.PLAIN, cbx.getFont().getSize()));	
	}
	
	private void setSelectedCheckboxes(boolean b) {
		for (JCheckBox cbx : cbxList)
			if(cbx.isSelected()!=b)
				cbx.setSelected(b);
	}
	
	public int getTotalSelected()
	{
		int totalItemsSelected = 0;	
		
		for (JCheckBox cbx : cbxList) {
			if(cbx.isSelected()) 
				totalItemsSelected++;
		}

		return totalItemsSelected;
	}
	
	public void interruptAll()
	{
		if(preTask!=null && !preTask.isDone())
			preTask.cancel(true);
		
		for (AntipatternTask task : allTasks) {
			if(task!=null && !task.isDone())
					task.cancel(true);
		}
		
		if(executor!=null && !executor.isShutdown()) 
			executor.shutdownNow();
	
	}
	
	public void activateShowResult()
	{
		showButton.setEnabled(true);
	}
	
	private void updateStatus(String s) {
		progressBarDescr.setText(s);
		System.out.println(s);
	}
	
	private void executeAntipattern(AntipatternTask task, Antipattern<?> antipattern, AntipatternInfo info, JLabel label, JCheckBox checkBox, 
			int incrementalValue, CountDownLatch latch, ExecutorService executor, CountDownLatch preLatch) {
		
		task = new AntipatternTask(antipattern, info, label, checkBox, progressBar, progressBarDescr, incrementalValue, latch, preLatch);
		allTasks.add(task);
		
		executor.execute(task);
	}
	
	private class Supervisor extends SwingWorker<Void, Void> {

        CountDownLatch latch;

        public Supervisor(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        protected Void doInBackground() throws Exception {
            latch.await();
            return null;
        }

        @Override
        protected void done() {
        	progressBar.setValue(100);
        	progressBar.setIndeterminate(false);
        	
        	identifyButton.setEnabled(true);
        	showButton.setEnabled(true);
        	stopButton.setEnabled(false);
        	
        	updateStatus("Antipatterns: Completed! "+antipatternList.getAll().size()+" occurrence(s) found");
    
        }
    }
	
	/**
	 * Identifying AntiPatterns...
	 * 
	 * @param event
	 */
	public void IdentifyButtonActionPerformed(ActionEvent event)
	{
		updateStatus("Antipatterns: Interrupting current tasks...");
		interruptAll();
		int selected = getTotalSelected();
		
		if(selected == 0){
			updateStatus("Antipatterns: No antipattern selected!");
			return;
		}
		else{
			updateStatus("Antipatterns: "+selected+" antipattern(s) selected.");
		}
		
		try{
		
        	identifyButton.setEnabled(false);
  			showButton.setEnabled(false);
  			stopButton.setEnabled(true);
  			cleanResultlabels();
			setPlainFontOnCheckboxes();		
			//frame.selectConsole();							
			progressBar.setValue(0);
			progressBar.setIndeterminate(true);
  			updateStatus("Antipatterns: Retrieving checked elements...");
			
  			final CountDownLatch preLatch = new CountDownLatch(1);
  			
			preTask = new SwingWorker<Void, Void>() {
				
				//private List<Object> checked;

				@Override
				protected Void doInBackground() throws Exception {
					//we dont work anymore with a check box on the application
//					checked = FilterManager.get().workingOnlyWithChecked();
					return null;
				}
				
				@Override
				protected void done() {
//					ProjectBrowser modeltree = frame.getProjectBrowser();	
//					modeltree.getTree().check(checked);			
//					modeltree.getTree().updateUI();
					preLatch.countDown();
				}
			};
			preTask.execute();
			
			if (parser.getElements() == null) 
				return;
									
			 AssCycAntipattern assCyc = new AssCycAntipattern(parser); 	
			 BinOverAntipattern binOver = new BinOverAntipattern(parser);		
			 DepPhaseAntipattern depPhase = new DepPhaseAntipattern(parser);
			 FreeRoleAntipattern freeRole = new FreeRoleAntipattern(parser);
			 GSRigAntipattern gsRig = new GSRigAntipattern(parser);
			 HetCollAntipattern hetColl = new HetCollAntipattern(parser);
			 HomoFuncAntipattern homoFunc = new HomoFuncAntipattern(parser);
			 ImpAbsAntipattern impAbs = new ImpAbsAntipattern(parser);
			 MixIdenAntipattern mixIden = new MixIdenAntipattern(parser);
			 MixRigAntipattern mixRig = new MixRigAntipattern(parser);
			 MultiDepAntipattern multiDep = new MultiDepAntipattern(parser);
			 RelCompAntipattern relComp = new RelCompAntipattern(parser);
			 RelOverAntipattern relOver = new RelOverAntipattern(parser);
			 RelRigAntipattern relRig = new RelRigAntipattern(parser);
			 RelSpecAntipattern relSpec = new RelSpecAntipattern(parser);
			 RepRelAntipattern repRel = new RepRelAntipattern(parser);
			 UndefFormalAntipattern undefFormal = new UndefFormalAntipattern(parser);
			 UndefPhaseAntipattern undefPhase = new UndefPhaseAntipattern(parser);
			 WholeOverAntipattern wholeOver = new WholeOverAntipattern(parser);
			 PartOverAntipattern partOver = new PartOverAntipattern(parser);
			 DecIntAntipattern decInt = new DecIntAntipattern(parser);		
			
			incrementalValue=100;
			
			if(selected>1) 
				incrementalValue=100/selected; 				
			
			allTasks.clear();
			
			 latch = new CountDownLatch(selected);
             executor = Executors.newFixedThreadPool(4);
			
             
			if (AssCycisSelected()) 
				executeAntipattern(assCycTask, assCyc, AssCycAntipattern.getAntipatternInfo(), lblAssCycRes, cbxAssCyc, incrementalValue, latch, executor, preLatch);
			
			if (BinOverisSelected())
				executeAntipattern(binOverTask, binOver, BinOverAntipattern.getAntipatternInfo(), lblBinOverRes, cbxBinOver, incrementalValue, latch, executor, preLatch);
			
			if (DepPhaseisSelected())
				executeAntipattern(depPhaseTask, depPhase, DepPhaseAntipattern.getAntipatternInfo(), lblDepPhaseRes, cbxDepPhase, incrementalValue, latch, executor, preLatch);

			if (freeRoleIsSelected())
				executeAntipattern(freeRoleTask, freeRole, FreeRoleAntipattern.getAntipatternInfo(), lblFreeRoleRes, cbxFreeRole, incrementalValue, latch, executor, preLatch);

			if (gsRigIsSelected())
				executeAntipattern(gsRigTask, gsRig, GSRigAntipattern.getAntipatternInfo(), lblGSRigRes, cbxGSRig, incrementalValue, latch, executor, preLatch);

			if (HetCollisSelected())
				executeAntipattern(hetCollTask, hetColl, HetCollAntipattern.getAntipatternInfo(), lblHetCollRes, cbxHetColl, incrementalValue, latch, executor, preLatch);

			if (HomoFuncisSelected())
				executeAntipattern(homoFuncTask, homoFunc, HomoFuncAntipattern.getAntipatternInfo(), lblHomoFuncRes, cbxHomoFunc, incrementalValue, latch, executor, preLatch);

			if (ImpAbsisSelected())
				executeAntipattern(impAbsTask, impAbs, ImpAbsAntipattern.getAntipatternInfo(), lblImpAbsRes, cbxImpAbs, incrementalValue, latch, executor, preLatch);

			if (MixIdenisSelected())
				executeAntipattern(MixIdenTask, mixIden, MixIdenAntipattern.getAntipatternInfo(), lblMixIdenRes, cbxMixIden, incrementalValue, latch, executor, preLatch);

			if (MixRigisSelected())
				executeAntipattern(MixRigTask, mixRig, MixRigAntipattern.getAntipatternInfo(), lblMixRigRes, cbxMixRig, incrementalValue, latch, executor, preLatch);

			if (MultiDepisSelected())
				executeAntipattern(MultiDepTask, multiDep, MultiDepAntipattern.getAntipatternInfo(), lblMultiDepRes, cbxMultiDep, incrementalValue, latch, executor, preLatch);

			if (RelCompisSelected())
				executeAntipattern(RelCompTask, relComp, RelCompAntipattern.getAntipatternInfo(), lblRelCompRes, cbxRelComp, incrementalValue, latch, executor, preLatch);

			if (RelOverisSelected())
				executeAntipattern(RelOverTask, relOver, RelOverAntipattern.getAntipatternInfo(), lblRelOverRes, cbxRelOver, incrementalValue, latch, executor, preLatch);

			if (RelRigisSelected())
				executeAntipattern(RelRigTask, relRig, RelRigAntipattern.getAntipatternInfo(), lblRelRigRes, cbxRelRig, incrementalValue, latch, executor, preLatch);

			if (RelSpecisSelected())
				executeAntipattern(RelSpecTask, relSpec, RelSpecAntipattern.getAntipatternInfo(), lblRelSpecRes, cbxRelSpec, incrementalValue, latch, executor, preLatch);

			if (RepRelisSelected())
				executeAntipattern(RepRelTask, repRel, RepRelAntipattern.getAntipatternInfo(), lblRepRelRes, cbxRepRel, incrementalValue, latch, executor, preLatch);

			if (UndefFormalisSelected())
				executeAntipattern(UndefFormalTask, undefFormal, UndefFormalAntipattern.getAntipatternInfo(), lblUndefFormalRes, cbxUndefFormal, incrementalValue, latch, executor, preLatch);

			if (UndefPhaseisSelected())
				executeAntipattern(UndefPhaseTask, undefPhase, UndefPhaseAntipattern.getAntipatternInfo(), lblUndefPhaseRes, cbxUndefPhase, incrementalValue, latch, executor, preLatch);

			if (WholeOverisSelected())
				executeAntipattern(WholeOverTask, wholeOver, WholeOverAntipattern.getAntipatternInfo(), lblWholeOverRes, cbxWholeOver, incrementalValue, latch, executor, preLatch);

			if (PartOverisSelected())
				executeAntipattern(PartOverTask, partOver, PartOverAntipattern.getAntipatternInfo(), lblPartOverRes, cbxPartOver, incrementalValue, latch, executor, preLatch);

			if (DecIntisSelected())
				executeAntipattern(DecIntTask, decInt, DecIntAntipattern.getAntipatternInfo(), lblDecIntRes, cbxDecInt, incrementalValue, latch, executor, preLatch);

			antipatternList = new AntiPatternList (assCyc, binOver, depPhase, freeRole, gsRig, hetColl, homoFunc, impAbs, mixIden,
					   mixRig, multiDep, relComp, relOver, relRig, relSpec, repRel, undefFormal, undefPhase, wholeOver, partOver, decInt);
			
			transferResult(antipatternList);
			
			new Supervisor(latch).execute();
				
		
		}catch(Exception e){
			JOptionPane.showMessageDialog(this,e.getMessage(),"Anti-Pattern Search",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	
	
}
