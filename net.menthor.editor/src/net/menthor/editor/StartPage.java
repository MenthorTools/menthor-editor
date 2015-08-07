package net.menthor.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
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

import net.menthor.editor.v2.commands.CommandListener;
import net.menthor.editor.v2.commands.CommandType;
import net.menthor.editor.v2.editors.Editor;
import net.menthor.editor.v2.icon.IconMap;
import net.menthor.editor.v2.icon.IconType;
import net.menthor.editor.v2.types.ColorMap;
import net.menthor.editor.v2.types.ColorType;
import net.menthor.editor.v2.types.EditorType;
import net.menthor.editor.v2.ui.BackgroundPanel;
import net.menthor.editor.v2.util.Settings;

public class StartPage extends BackgroundPanel implements Editor {
		
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
	private Component emptyHeaderArea;
	private CommandListener commandListener;
	private static Image img = IconMap.getInstance().getImage(IconType.MENTHOR_WELCOME_BACKGROUND.toString());
	
	public StartPage(CommandListener commandListener)
	{
		this();
		this.commandListener = commandListener;			
	}
	
    public StartPage(){    	
    	super(img, BackgroundPanel.SCALED, 1.0f, 1.0f);
    	//GradientPaint paint = new GradientPaint(0, 0, Color.BLUE, 600, 0, Color.RED);
    	//setPaint(paint);
    	setLayout(new BorderLayout(0, 0));
    	setBackground(Color.WHITE);
    	//setBackground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY));    	
    	JPanel contentPane = createContentPane();
    	add(contentPane,BorderLayout.CENTER);
    	JPanel footerPane = createFooter();
    	add(footerPane,BorderLayout.SOUTH);
    	populateRecentProjects();
    }    
    
	private JPanel createRecentPane(){
		JScrollPane recentScrollPane = new JScrollPane();
		recentPane = new JPanel();    	
		recentPane.setBackground(ColorMap.getInstance().getColor(ColorType.MENTHOR_GREY_DARK));		
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
		recentLabel.setBackground(ColorMap.getInstance().getColor(ColorType.MENTHOR_GREY_DARK));
		recentLabel.setFont(new Font(recentLabel.getFont().getName(),Font.BOLD,11));
		return recentLabel;
	}
	
	public String getSelectedRecentFile(){
		String result = (String)recentList.getSelectedValue();
		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked"})
	private void populateRecentProjects(){
		recentList.setModel(new DefaultComboBoxModel(Settings.getRecentProjects()));
		recentList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
		        if (evt.getClickCount() >= 2) 
		        {
		        	if(getSelectedRecentFile()!=null){
			        	if(getSelectedRecentFile().contains(".menthor")){
			        		commandListener.handleCommand(CommandType.OPEN_RECENT_PROJECT.toString(),null);
			        	}else if(getSelectedRecentFile().contains(".xml") || getSelectedRecentFile().contains(".xmi")){
			        		commandListener.handleCommand(CommandType.IMPORT_FROM_XMI_EA_FILE.toString(),null);
			        	}		        	
		        	}
		        }
		    }
		});
	}
	
    private JLabel createLogo(){
    	menthorImg = new JLabel("");
		menthorImg.setVerticalAlignment(SwingConstants.TOP);
		menthorImg.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_WELCOME_LOGO));
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
		btn.setBackground(ColorMap.getInstance().getColor(ColorType.MENTHOR_ORANGE));
		btn.setBorder(new LineBorder(ColorMap.getInstance().getColor(ColorType.MENTHOR_ORANGE),1,true));
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
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setBackground(ColorMap.getInstance().getColor(ColorType.MENTHOR_GREY_DARK));                        
        btn.setBorder(new LineBorder(ColorMap.getInstance().getColor(ColorType.MENTHOR_GREY_DARK),1,true));
        setRollOverLink(btn);
        btn.setOpaque(true);
        return btn;
    }
    
    private JPanel createButtonsPane()
    {
		buttonsPane = new JPanel();
		buttonsPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		FlowLayout flowLayout = (FlowLayout) buttonsPane.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		//buttonsPane.setBackground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY));
		buttonsPane.setBackground(new Color(0,0,0,0));
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
				btnNewProject.setBackground(ColorMap.getInstance().getColor(ColorType.MENTHOR_BROWN_DARK));            	
            	//Action
            	commandListener.handleCommand(CommandType.NEW_PROJECT.toString(),null);            	
            	//Back to normal
            	btnNewProject.setBackground(ColorMap.getInstance().getColor(ColorType.MENTHOR_ORANGE));            	
			}
		});
    }
   
   private void attachOpenProjectAction()
   {
   		btnOpenProject.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Set click color
				btnOpenProject.setBackground(ColorMap.getInstance().getColor(ColorType.MENTHOR_BROWN_DARK));            	
		       	//Action
		       	commandListener.handleCommand(CommandType.OPEN_PROJECT.toString(),null);            	
		       	//Back to normal
		       	btnOpenProject.setBackground(ColorMap.getInstance().getColor(ColorType.MENTHOR_ORANGE));            	
			}
		});
   }
   
   private void attachImportFromEAAction()
   {
   		btnImportFromEA.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Set click color
				btnImportFromEA.setBackground(ColorMap.getInstance().getColor(ColorType.MENTHOR_BROWN_DARK));            	
		       	//Action
		       	commandListener.handleCommand(CommandType.IMPORT_FROM_XMI_EA.toString(),null);            	
		       	//Back to normal
		       	btnImportFromEA.setBackground(ColorMap.getInstance().getColor(ColorType.MENTHOR_ORANGE));            	
			}
		});
   }
   
	public void setRollOver(final JButton btn)
	{	
		btn.setRolloverEnabled(true);
		btn.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();
                if (model.isRollover()) {
                	btn.setBackground(ColorMap.getInstance().getColor(ColorType.MENTHOR_BROWN)); 
                	btn.setBorder(new LineBorder(ColorMap.getInstance().getColor(ColorType.MENTHOR_ORANGE),1,true));
                	
                } else{
                	btn.setBackground(ColorMap.getInstance().getColor(ColorType.MENTHOR_ORANGE));
                	btn.setBorder(new LineBorder(ColorMap.getInstance().getColor(ColorType.MENTHOR_ORANGE),1,true));
            		
                }
            }
        });
    }
	
	public void setRollOverLink(final JButton btn)
	{	
		btn.setRolloverEnabled(true);
		btn.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();
                if (model.isRollover()) {
                	btn.setBackground(ColorMap.getInstance().getColor(ColorType.MENTHOR_GREY)); 
                	btn.setBorder(new LineBorder(ColorMap.getInstance().getColor(ColorType.MENTHOR_GREY_DARK),1,true));
                	
                } else{
                	btn.setBackground(ColorMap.getInstance().getColor(ColorType.MENTHOR_GREY_DARK));
                	btn.setBorder(new LineBorder(ColorMap.getInstance().getColor(ColorType.MENTHOR_GREY_DARK),1,true));
            		
                }
            }
        });
    }
	
	private JPanel createPageBtnPane()
	{
		pageBtnPane = new JPanel();		
		//pageBtnPane.setBackground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY));
		pageBtnPane.setBackground(new Color(0,0,0,0));
		btnEAButton = createPageLinkButton("<html>INSTALL ONTOUML<br>WITHIN EA</html>");
		btnEAButton.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_WELCOME_LEARN));
				
		btnEAButton.setToolTipText("<html>Learn how to install OntoUML <br>within the EA tool</html>");
		pageBtnPane.add(btnEAButton);
		attachEALink();
		btnFAQButton = createPageLinkButton("<html>FREQUENTLY ASKED<br>QUESTIONS</html>");
		btnFAQButton.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_WELCOME_FAQ));
		btnFAQButton.setToolTipText("<html>See users' frequently asked questions</html>");
		pageBtnPane.add(btnFAQButton);
		attachFAQLink();
		btnCommunityButton = createPageLinkButton("<html>USER<br>COMMUNITY</html>");
		btnCommunityButton.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_WELCOME_FORUM));
		btnCommunityButton.setToolTipText("<html>See our community of users</html>");
		pageBtnPane.add(btnCommunityButton);
		attachCommunityLink();
		btnStudyButton = createPageLinkButton("<html>ONTOUML STUDY<br>GUIDE</html>");
		btnStudyButton.setToolTipText("<html>See our study guide for the OntoUML <br>modeling language</html>");
		btnStudyButton.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_WELCOME_STUDYGUIDE));
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
		JPanel greyPane = new JPanel();
		//panel.setBackground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY));
		greyPane.setBackground(new Color(0,0,0,50));		
		GroupLayout gl_greyPane = new GroupLayout(greyPane);
		gl_greyPane.setHorizontalGroup(
			gl_greyPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_greyPane.createSequentialGroup()
					.addGap(66)
					.addGroup(gl_greyPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(pageBtnPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_greyPane.createSequentialGroup()
							.addComponent(menthorImg, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_greyPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(buttonsPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(recentPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE))))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		gl_greyPane.setVerticalGroup(
			gl_greyPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_greyPane.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_greyPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_greyPane.createSequentialGroup()
							.addComponent(recentPane, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(buttonsPane, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addComponent(menthorImg, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(pageBtnPane, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		greyPane.setLayout(gl_greyPane);		
		//===============================
		JPanel boxPane = new JPanel();
    	//centerPane.setBackground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY));
		boxPane.setBackground(new Color(0,0,0,0));
		//===============================		
		JPanel contentPane = new JPanel();
		//contentPane.setBackground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY));
		contentPane.setBackground(new Color(0,0,0,0));
    	contentPane.add(boxPane);		
    	boxPane.setLayout(new BorderLayout(0, 0));
    	boxPane.add(greyPane);
    	
    	emptyHeaderArea = Box.createRigidArea(new Dimension(20, (int)(0.08*getScreenWorkingHeight())));
    	boxPane.add(emptyHeaderArea, BorderLayout.NORTH);
		return contentPane;
    }

    public static int getScreenWorkingHeight() {
	    return java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
	}
    
    private JPanel createFooter(){
    	JPanel footerPane = new JPanel();
    	//footerPane.setBackground(ColorPalette.getInstance().getColor(ThemeColor.MENTHOR_GREY));
    	footerPane.setBackground(new Color(0,0,0,0));
    	footerPane.setPreferredSize(new Dimension(0, 70));    	
    	JPanel panel = new JPanel();
    	JLabel sloganImg = new JLabel("");
    	panel.add(sloganImg);
    	panel.setBackground(new Color(0,0,0,100));
    	sloganImg.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_WELCOME_SLOGAN));
    	GroupLayout gl_footerPane = new GroupLayout(footerPane);
    	gl_footerPane.setHorizontalGroup(
    		gl_footerPane.createParallelGroup(Alignment.LEADING)
    			.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
    	);
    	gl_footerPane.setVerticalGroup(
    		gl_footerPane.createParallelGroup(Alignment.LEADING)
    			.addGroup(gl_footerPane.createSequentialGroup()
    				.addGap(5)
    				.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    				.addContainerGap(27, Short.MAX_VALUE))
    	);
    	footerPane.setLayout(gl_footerPane);
    	return footerPane;
    }
	
	@Override
	public void dispose() { }
	
	@Override
	public boolean isSaveNeeded() { return false; }

	@Override
	public EditorType getEditorType() { return EditorType.WELCOME_EDITOR; } 
	
}
