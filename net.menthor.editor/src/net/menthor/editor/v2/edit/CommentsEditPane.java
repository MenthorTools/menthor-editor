package net.menthor.editor.v2.edit;

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

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import RefOntoUML.Classifier;
import RefOntoUML.Comment;
import net.menthor.editor.ui.MenthorEditor;
import net.menthor.editor.v2.EditorTabbedPane;
import net.menthor.editor.v2.icon.IconMap;
import net.menthor.editor.v2.icon.IconType;
import net.menthor.editor.v2.managers.TransferManager;

/**
 * @author John Guerson
 */
public class CommentsEditPane extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Classifier element;
	
	private JTextArea descriptionText;
	private JScrollPane scrollPaneText;
	@SuppressWarnings("rawtypes")
	private JComboBox commentCombo;
	private JButton btnCreate;		
	private JButton btnDelete;
	private JButton btnSave;
	private JLabel lblComment;
	private JLabel lblNewLabel;
	
	public CommentsEditPane(EditorTabbedPane diagramManager, Classifier element){
		setBorder(new EmptyBorder(10, 10, 10, 10));
		this.element = element;
		initUI();
	}
	
	public void transferData(){
		TransferManager.get().transferComments(element, getComments());	
	}
	
	@SuppressWarnings("unchecked")
	public void setData(){		
		if (commentCombo.getItemCount()>0) commentCombo.removeAllItems();		
		for(Comment c: element.getOwnedComment()){			
			commentCombo.addItem(new CommentElement(c));			
		}		
		if (commentCombo.getItemCount()>0) {
			commentCombo.setSelectedIndex(0);
			descriptionText.setText(((CommentElement)commentCombo.getSelectedItem()).getComment().getBody()+"\n\n");			
		}else{
			enableCommentArea(false);
		}
	}

	private void enableCommentArea(boolean value){
		commentCombo.setEnabled(value);
		btnSave.setEnabled(value);
		btnDelete.setEnabled(value);
	}
	
	@SuppressWarnings("unchecked")
	public void createComment(){
		Comment c = MenthorEditor.getFrame().getElementFactory().createComment();
		c.setBody("This is an empty comment...");
		CommentElement ce = new CommentElement(c);		
		commentCombo.addItem(ce);
		descriptionText.setText(c.getBody());
		commentCombo.setSelectedIndex(commentCombo.getItemCount()-1);
		enableCommentArea(true);
	}

	public void saveComment(){
		Comment c = ((CommentElement)commentCombo.getSelectedItem()).getComment();
		c.setBody(descriptionText.getText());	
		commentCombo.repaint();
		commentCombo.validate();
	}

	public void deleteComment(){		
		commentCombo.removeItem(commentCombo.getSelectedItem());
		commentCombo.invalidate();	
		descriptionText.setText("");
		if (commentCombo.getItemCount()>0) enableCommentArea(true);
		else enableCommentArea(false);
	}

	public ArrayList<Comment> getComments(){
		ArrayList<Comment> result = new ArrayList<Comment>();
		for(int i=0; i<commentCombo.getItemCount();i++){
			CommentElement ce = (CommentElement)commentCombo.getItemAt(i);
			if (ce!=null) result.add(ce.getComment());
		}
		return result;
	}	
	
	@SuppressWarnings({ "rawtypes" })
	public void initUI(){
		setSize(new Dimension(400, 233));
		commentCombo = new JComboBox();
		commentCombo.setFocusable(false);						
		commentCombo.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {				
				CommentElement ce = (CommentElement) commentCombo.getSelectedItem();
				if(ce!=null) descriptionText.setText(ce.getComment().getBody());
			}
		});		
		btnCreate = new JButton("");
		btnCreate.setToolTipText("Add a new comment to this class");
		btnCreate.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_ADD));
		btnCreate.setFocusable(false);
		btnCreate.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				createComment();				
			}
		});		
		btnSave = new JButton("");
		btnSave.setFocusable(false);
		btnSave.setToolTipText("Save selected comment");
		btnSave.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_SAVE));
		btnSave.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				saveComment();
			}
		});		
		btnDelete = new JButton("");
		btnDelete.setFocusable(false);
		btnDelete.setToolTipText("Delete seletected comment");
		btnDelete.setIcon(IconMap.getInstance().getIcon(IconType.MENTHOR_DELETE));
		btnDelete.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				deleteComment();
			}
		});		
		lblComment = new JLabel("Comment:");		
		descriptionText = new JTextArea();	
		descriptionText.setToolTipText("Click here to start writing your comment");		
		scrollPaneText = new JScrollPane();
		scrollPaneText.setToolTipText("Click here to start writing your comment");
		scrollPaneText.setViewportView(descriptionText);		
		lblNewLabel = new JLabel("Description:");		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblComment, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(scrollPaneText, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
							.addComponent(commentCombo, 0, 301, Short.MAX_VALUE)))
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(commentCombo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblComment))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPaneText, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(165))))
		);
		this.setLayout(groupLayout);		
		
		setData();
	}
	
	private class CommentElement{
		RefOntoUML.Comment c;
		public CommentElement(RefOntoUML.Comment c){
			this.c = c;
		}
		@Override
		public String toString(){
			String result = new String();
			if(c.getBody().length()>30)
				result += c.getBody().substring(0,30) + " (...)";
			else 
				result += c.getBody();			
			return result;
		}
		public Comment getComment(){
			return c;
		}
	}
}
