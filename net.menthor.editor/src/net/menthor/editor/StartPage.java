package net.menthor.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.menthor.editor.model.UmlProject;
import net.menthor.editor.palette.ColorPalette;
import net.menthor.editor.palette.ColorPalette.ThemeColor;
import net.menthor.editor.util.ConfigurationHelper;

import org.tinyuml.draw.Diagram;
import org.tinyuml.ui.commands.AppCommandListener;
import org.tinyuml.ui.diagram.Editor;

public class StartPage extends JPanel implements Editor {
		
	private static final long serialVersionUID = 2336092539913014948L;
		
	private JPanel recentPane;
	private JPanel buttonsPane;
	private JPanel pageBtnPane;
	@SuppressWarnings("rawtypes")
	private JList recentList = new JList();
	private JLabel menthorImg;	
	private JButton btnOpenProject;	
	private JButton btnNewProject;
	private JButton btnImportFromEA;
	private JButton btnEAButton;
	private JButton btnStudyButton;
	private JButton btnFAQButton;
	private JButton btnCommunityButton;
	private AppCommandListener commandListener;
	
	public StartPage(AppCommandListener commandListener)
	{
		this();
		this.commandListener = commandListener;			
	}
	
    public StartPage(){
    	setLayout(new BorderLayout(0, 0));
    	setBackground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY));    	
    	JPanel contentPane = createContentPane();
    	add(contentPane,BorderLayout.CENTER);
    	JPanel footerPane = createFooter();
    	add(footerPane,BorderLayout.SOUTH);
    	populateRecentProjects();
    }    
    
	private JPanel createRecentPane(){
		JScrollPane recentScrollPane = new JScrollPane();
		recentPane = new JPanel();    	
		recentPane.setBackground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY_DARK));		
		recentPane.setLayout(new BorderLayout(0, 0));
		JLabel recentLabel = createRecentLabel("OPEN RECENTS");		
		recentList.setFont(new Font(recentLabel.getFont().getName(),Font.BOLD,10));
		recentList.setBorder(new CompoundBorder(new EmptyBorder(7, 7, 7, 7), new LineBorder(new Color(227, 227, 227), 1, true)));
		recentPane.add(recentLabel, BorderLayout.NORTH);		
		recentScrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));		
		recentScrollPane.setViewportView(recentList);
		recentPane.add(recentScrollPane, BorderLayout.CENTER);
		return recentPane;				
    }

	public JLabel createRecentLabel(String name)
	{
		JLabel recentLabel = new JLabel(name);
		recentLabel.setBorder(new EmptyBorder(0, 8, 0, 0));
		recentLabel.setPreferredSize(new Dimension(75, 30));
		recentLabel.setForeground(Color.WHITE);
		recentLabel.setBackground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY_DARK));
		recentLabel.setFont(new Font(recentLabel.getFont().getName(),Font.BOLD,11));
		return recentLabel;
	}
	
	public String getSelectedRecentFile(){
		return (String) recentList.getSelectedValue();
	}

	@SuppressWarnings({ "rawtypes", "unchecked"})
	private void populateRecentProjects(){
		recentList.setModel(new DefaultComboBoxModel(ConfigurationHelper.getRecentProjects()));
		recentList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
		        if (evt.getClickCount() >= 2) 
		        {
		        	if(getSelectedRecentFile().contains(".menthor")){
		        		commandListener.handleCommand("OPEN_RECENT_PROJECT");
		        	}else if(getSelectedRecentFile().contains(".xml") || getSelectedRecentFile().contains(".xmi")){
		        		commandListener.handleCommand("IMPORT_XMI_FROM_FILE");
		        	}		        	
		        }
		    }
		});
	}
	
    private JLabel createLogo(){
    	menthorImg = new JLabel("");
		menthorImg.setVerticalAlignment(SwingConstants.TOP);
		menthorImg.setIcon(new ImageIcon(StartPage.class.getResource("/net/menthor/resources/images/logo-startpage_150.png")));
		return menthorImg;
    }
    
    public JButton createFileButton(String name)
    {
    	JButton btn = new JButton(name);
		btn.setPreferredSize(new Dimension(130, 25));
		btn.setForeground(Color.WHITE);
		btn.setContentAreaFilled(false);
		btn.setFont(new Font(btn.getFont().getName(),Font.BOLD,10));
		//btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn.setBackground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_ORANGE));
		btn.setBorder(new LineBorder(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_ORANGE),1,true));
		setRollOver(btn);
		btn.setOpaque(true);        
		return btn;
    }
    
    public JButton createPageLinkButton(String htmlName)
    {
    	JButton btn = new JButton(htmlName);    	
    	btn.setPreferredSize(new Dimension(200, 70));
    	btn.setForeground(Color.WHITE);
    	btn.setFont(new Font(btn.getFont().getName(),Font.BOLD,10));
    	btn.setContentAreaFilled(false);        
        //btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setOpaque(true);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setBackground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY_DARK));                        
    	return btn;
    }
    
    private JPanel createButtonsPane()
    {
		buttonsPane = new JPanel();
		buttonsPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		FlowLayout flowLayout = (FlowLayout) buttonsPane.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		buttonsPane.setBackground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY));
		btnNewProject = createFileButton("NEW PROJECT");
		btnNewProject.setToolTipText("Create new menthor project");
		attachNewProjectAction();
		btnOpenProject = createFileButton("OPEN PROJECT");	
		btnOpenProject.setToolTipText("Open menthor project");
		attachOpenProjectAction();
		btnImportFromEA = createFileButton("IMPORT FROM EA");
		btnImportFromEA.setToolTipText("Import EA project (as XMI/XML file)");
		attachImportFromEAAction();
		buttonsPane.add(btnNewProject);		
		buttonsPane.add(btnOpenProject);
		buttonsPane.add(btnImportFromEA);
		return buttonsPane;
    }
	
   private void attachNewProjectAction()
    {
    	btnNewProject.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Set click color
				btnNewProject.setBackground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_ORANGE_CLICK));            	
            	//Action
            	commandListener.handleCommand("NEW_PROJECT");            	
            	//Back to normal
            	btnNewProject.setBackground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_ORANGE));            	
			}
		});
    }
   
   private void attachOpenProjectAction()
   {
   		btnOpenProject.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Set click color
				btnOpenProject.setBackground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_ORANGE_CLICK));            	
		       	//Action
		       	commandListener.handleCommand("OPEN_PROJECT");            	
		       	//Back to normal
		       	btnOpenProject.setBackground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_ORANGE));            	
			}
		});
   }
   
   private void attachImportFromEAAction()
   {
   		btnImportFromEA.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Set click color
				btnImportFromEA.setBackground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_ORANGE_CLICK));            	
		       	//Action
		       	commandListener.handleCommand("IMPORT_XMI");            	
		       	//Back to normal
		       	btnImportFromEA.setBackground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_ORANGE));            	
			}
		});
   }
   
	public void setRollOver(final JButton btn)
	{	
		btn.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();
                if (model.isRollover()) {
                	btn.setBackground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_ORANGE_HOVER));                	
                } else{
                	btn.setBackground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_ORANGE));                	
                }
            }
        });
    }
    
	private JPanel createPageBtnPane()
	{
		pageBtnPane = new JPanel();		
		pageBtnPane.setBackground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY));		
		btnEAButton = createPageLinkButton("<html>INSTALL ONTOUML<br>WITHIN EA</html>");
		btnEAButton.setIcon(new ImageIcon(StartPage.class.getResource("/net/menthor/resources/images/learn_61.png")));
		btnEAButton.setToolTipText("<html>Learn how to install OntoUML <br>within the EA tool</html>");
		pageBtnPane.add(btnEAButton);
		attachEALink();
		btnFAQButton = createPageLinkButton("<html>FREQUENTLY ASKED<br>QUESTIONS</html>");
		btnFAQButton.setIcon(new ImageIcon(StartPage.class.getResource("/net/menthor/resources/images/faq_61.png")));
		btnFAQButton.setToolTipText("<html>See users' frequently asked questions</html>");
		pageBtnPane.add(btnFAQButton);
		attachFAQLink();
		btnCommunityButton = createPageLinkButton("<html>USER<br>COMMUNITY</html>");
		btnCommunityButton.setIcon(new ImageIcon(StartPage.class.getResource("/net/menthor/resources/images/forum_61.png")));
		btnCommunityButton.setToolTipText("<html>See our community of users</html>");
		pageBtnPane.add(btnCommunityButton);
		attachCommunityLink();
		btnStudyButton = createPageLinkButton("<html>ONTOUML STUDY<br>GUIDE</html>");
		btnStudyButton.setToolTipText("<html>See our study guide for the OntoUML <br>modeling language</html>");
		btnStudyButton.setIcon(new ImageIcon(StartPage.class.getResource("/net/menthor/resources/images/studyguide_61.png")));
		pageBtnPane.add(btnStudyButton);
		attachStudyLink();
		return pageBtnPane;
	}
	
	private void attachEALink()
	{
		btnEAButton.addMouseListener(new MouseAdapter() {			
			 @Override
			    public void mouseClicked(MouseEvent e) {			     
				 if(commandListener instanceof AppFrame){
					 AppFrame frame = (AppFrame)commandListener;
					 frame.getDiagramManager().openLinkWithBrowser("http://www.menthor.net/tutorial-how-to-use-ontouml-in-enterprise-architect.html");
				 }
			 }
		});	
	}	
	
	private void attachFAQLink()
	{
		btnFAQButton.addMouseListener(new MouseAdapter() {			
			 @Override
			    public void mouseClicked(MouseEvent e) {			     
				 if(commandListener instanceof AppFrame){
					 AppFrame frame = (AppFrame)commandListener;
					 frame.getDiagramManager().openLinkWithBrowser("http://www.menthor.net/faq.html");
				 }
			 }
		});
	}
	
	private void attachCommunityLink()
	{
		btnCommunityButton.addMouseListener(new MouseAdapter() {			
			 @Override
			    public void mouseClicked(MouseEvent e) {			     
				 if(commandListener instanceof AppFrame){
					 AppFrame frame = (AppFrame)commandListener;
					 frame.getDiagramManager().openLinkWithBrowser("http://www.menthor.net/user-community.html");
				 }
			 }
		});
	}
	
	private void attachStudyLink()
	{
		btnStudyButton.addMouseListener(new MouseAdapter() {			
			 @Override
			    public void mouseClicked(MouseEvent e) {			     
				 if(commandListener instanceof AppFrame){
					 AppFrame frame = (AppFrame)commandListener;
					 frame.getDiagramManager().openLinkWithBrowser("http://www.menthor.net/ontouml-study-guide.html");
				 }
			 }
		});
	}

	private void createContent(){
		createLogo();		
    	createRecentPane();
    	createButtonsPane();		    	
		createPageBtnPane();		
	}
	
    private JPanel createContentPane(){		
    	createContent();    	
		//===============================
		JPanel panel = new JPanel();
		panel.setBackground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(167)
					.addComponent(menthorImg)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(recentPane, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonsPane, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(182, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(recentPane, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(buttonsPane, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addComponent(menthorImg, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);		
		//===============================
		JPanel centerPane = new JPanel();
    	centerPane.setBackground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY));
		GroupLayout gl_centerPane = new GroupLayout(centerPane);
		gl_centerPane.setHorizontalGroup(
			gl_centerPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_centerPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 921, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_centerPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(pageBtnPane, GroupLayout.DEFAULT_SIZE, 921, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_centerPane.setVerticalGroup(
			gl_centerPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_centerPane.createSequentialGroup()
					.addGap(32)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(pageBtnPane, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		centerPane.setLayout(gl_centerPane);		
		//===============================		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY));
    	contentPane.add(centerPane);		
		return contentPane;
    }

    private JPanel createFooter(){
    	JPanel footerPane = new JPanel();
    	footerPane.setBackground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY));
    	footerPane.setPreferredSize(new Dimension(0, 70));    	    	
    	JLabel sloganImg = new JLabel("");
    	sloganImg.setIcon(new ImageIcon(StartPage.class.getResource("/net/menthor/resources/images/slogan_startpage.png")));    	
    	footerPane.add(sloganImg);    	
    	return footerPane;
    }
	
	@Override
	public void dispose() { }

	@Override
	public boolean isSaveNeeded() {
		return false;
	}

	@Override
	public EditorNature getEditorNature() {
		return null;
	}

	@Override
	public UmlProject getProject() {
		return null;
	}

	@Override
	public Diagram getDiagram() {	
		return null;
	}	
}
