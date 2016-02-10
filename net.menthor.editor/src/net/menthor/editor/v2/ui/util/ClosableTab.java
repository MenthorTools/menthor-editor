package net.menthor.editor.v2.ui.util;

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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicButtonUI;

import org.eclipse.emf.edit.provider.IDisposable;

import net.menthor.editor.v2.commanders.UpdateCommander;
import net.menthor.editor.v2.commands.ICommandListener;
import net.menthor.editor.v2.managers.MessageManager;
import net.menthor.editor.v2.managers.ProjectManager;
import net.menthor.editor.v2.ui.color.ColorMap;
import net.menthor.editor.v2.ui.color.ColorType;
import net.menthor.editor.v2.ui.editor.IEditor;
import net.menthor.editor.v2.ui.menu.TabPopupMenu;

public class ClosableTab extends JPanel {

	public static final long serialVersionUID = -9007086475434456589L;
	public final JTabbedPane pane;
	public JLabel label;
	public TabButton button;
	public boolean isTitleEditable = true;
	private ICommandListener listener;
	
	public JLabel getLabel() { return label; }
	public JTabbedPane getTabbedPane() { return pane; }
	public ICommandListener getListener() { return listener; }
	
	public ClosableTab(final JTabbedPane pane, boolean isTitleEditable, ICommandListener listener) {
		this(pane);
		this.isTitleEditable = isTitleEditable;
		this.listener=listener;
	}
	
	public ClosableTab(final JTabbedPane pane,ICommandListener listener) {
		this(pane);
		this.listener=listener;
	}
	
	public ClosableTab(final JTabbedPane pane) {
		super(new FlowLayout(FlowLayout.LEFT, 0, 0));
		if (pane == null) throw new NullPointerException("TabbedPane is null");
		this.pane = pane;
		setOpaque(false);
		
		//make JLabel read titles from JTabbedPane
		label = new JLabel(){
			private static final long serialVersionUID = -5791363706451298026L;
			public String getText() {
				int i = pane.indexOfTabComponent(ClosableTab.this);
				if (i != -1) {													
					return ((IEditor) pane.getComponentAt(i)).isSaveNeeded() ? pane.getTitleAt(i).replace("*", "")+"*" : pane.getTitleAt(i);
				}
				return null;
			}
		};		
		
		//set label editable through JTextField component
		label.addMouseListener(new MouseAdapter(){ 
            public void mouseClicked(MouseEvent e){ 
                if (e.getClickCount() == 2){          
                	if(isTitleEditable){
                		int index = pane.indexOfTabComponent(ClosableTab.this);
                		JTextField editor = createEditingTabField(ClosableTab.this, index);  
                		pane.setTabComponentAt(index, editor);                                        
                		editor.requestFocus(); 
                		editor.selectAll();                     
                		if (editor.getPreferredSize().width < 100) editor.setPreferredSize(new Dimension(100, editor.getPreferredSize().height));
                	}
                } else if (SwingUtilities.isRightMouseButton(e)){                	             		
            		int index = pane.indexOfTabComponent(ClosableTab.this);
            		Component comp = pane.getComponentAt(index);            		
            		TabPopupMenu popup = new TabPopupMenu(listener,comp);
            		popup.show(e.getComponent(),e.getX(),e.getY());                	
                } else { 
                    if (pane.getSelectedIndex() != pane.indexOfTabComponent(ClosableTab.this)) pane.setSelectedIndex(pane.indexOfTabComponent(ClosableTab.this)); 
                    pane.requestFocus(); 
                }                
            } 
        }); 			
		
		add(label);
		label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
		button = new TabButton(pane);
		add(button);
		setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
	}
	
	public JTextField createEditingTabField(final ClosableTab closableTab, final int index){ 
        final JTextField textField = new JTextField(); 
        textField.setText(closableTab.getLabel().getText());
        textField.addKeyListener(new KeyAdapter(){ 
            public void keyReleased(KeyEvent e){ 
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_ESCAPE){                    
                	closableTab.getTabbedPane().setTitleAt(index, textField.getText());
                	closableTab.getTabbedPane().setTabComponentAt(index, closableTab);
                	IEditor editor = ((IEditor) closableTab.getTabbedPane().getComponentAt(index));
                	editor.propagateNewTitle(textField.getText());
                	UpdateCommander.get().updateProjectTree();
                } 
            } 
        }); 
        textField.addFocusListener(new FocusAdapter(){ 
            public void focusLost(FocusEvent e){  
            	closableTab.getTabbedPane().setTitleAt(index, textField.getText());
            	closableTab.getTabbedPane().setTabComponentAt(index, closableTab);
            	IEditor editor = ((IEditor) closableTab.getTabbedPane().getComponentAt(index));
            	editor.propagateNewTitle(textField.getText());
            	UpdateCommander.get().updateProjectTree();
            } 
        }); 
        return textField; 
    } 
		
	public void closeTab(JTabbedPane tabbedpane, int index){		
		String tabName = pane.getTitleAt(index);
		boolean isSaveNeeded = ((IEditor) pane.getComponentAt(index)).isSaveNeeded();
		if(isSaveNeeded){
			boolean response = MessageManager.get().confirm("Save", "'"+tabName+"' has been modified. Save changes?");
			if(response) { ProjectManager.get().saveProject(); }
			else { return; }
		}			
		if(index!= -1){
			IDisposable disposable = (IDisposable) pane.getComponentAt(index);
			if(disposable != null) disposable.dispose();
			pane.remove(index);
		}
	}
	
	/** Internal class representing the "X" button in the right side of the tab. */
	private class TabButton extends JButton implements ActionListener {

		private static final long serialVersionUID = -3362039507300806289L;
		
		private JTabbedPane tabbedpane;		
		
		public TabButton(JTabbedPane pane) {
			int size = 17;
			setPreferredSize(new Dimension(size, size));
			setToolTipText("Close this tab");
			this.tabbedpane = pane;
			setUI(new BasicButtonUI());
			setContentAreaFilled(false);
			setFocusable(false);
			setBorderPainted(false);
			addMouseListener(buttonMouseListener);
			setRolloverEnabled(true);
			addActionListener(this);
		}

		public void actionPerformed(ActionEvent e) {
			closeTab(tabbedpane, pane.indexOfTabComponent(ClosableTab.this));			
		}
		
		public void updateUI() { /*we don't want to update UI for this button*/ }

		/** Draws the cross */
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g.create();
			if (getModel().isPressed()) {
				g2.translate(1, 1);
			}
			g2.setStroke(new BasicStroke(1,BasicStroke.JOIN_ROUND,BasicStroke.CAP_ROUND));
			g2.setColor(Color.BLACK);
			if (getModel().isRollover()) {
				g2.setColor(ColorMap.getInstance().getColor(ColorType.MENTHOR_BLUE_DARK));
			}
			int delta = 5;
			g2.drawLine(delta, delta, getWidth() - delta - 1, getHeight() - delta - 1);
			g2.drawLine(getWidth() - delta - 1, delta, delta, getHeight() - delta - 1);
			g2.dispose();
		}
	}

	private static final MouseListener buttonMouseListener = new MouseAdapter() {
		public void mouseEntered(MouseEvent e) {
			Component component = e.getComponent();
			if (component instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) component;
				button.setBorderPainted(true);
			}
		}

		public void mouseExited(MouseEvent e) {
			Component component = e.getComponent();
			if (component instanceof AbstractButton) {
				AbstractButton button = (AbstractButton) component;
				button.setBorderPainted(false);
			}
		}
	};
}
