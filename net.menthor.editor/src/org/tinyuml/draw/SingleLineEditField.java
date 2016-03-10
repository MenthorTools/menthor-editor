package org.tinyuml.draw;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


/** This class acts as an in-editor text input element. */
public class SingleLineEditField extends JTextField implements DocumentListener, IEditField {

	private static final long serialVersionUID = 4249755381822809715L;
	
	protected Label currentLabel;
	protected Color backgroundColor = Color.WHITE;
	protected Color lineBorderColor = Color.BLACK;
	
	public SingleLineEditField() {
		super();		
		setBackground(backgroundColor);
		Border border = new CompoundBorder(new LineBorder(lineBorderColor, 1), new EmptyBorder(1, 3, 1, 1));	
		setBorder(border);
		hideField();
		getDocument().addDocumentListener(this);		
	}

	public Label getLabel() { return currentLabel; }

	public void hideField() {
		setEditable(false);
		setEnabled(false);
		setVisible(false);
	}

	public void showField(Label aLabel, Graphics g) {
		currentLabel = aLabel;
		String text = currentLabel.getNameLabelText();
		int width = g.getFontMetrics().stringWidth(text);
		width += (int) (width * 0.3) + 10;
		int height = g.getFontMetrics().getHeight() + 4;	
		setText(text);
		setSize(width, height);
		setLocation((int) aLabel.getAbsoluteX1(), (int) aLabel.getAbsoluteY1());
		setEditable(true);
		setEnabled(true);
		setVisible(true);
		requestFocusInWindow();
		selectAll();
	}

	public void removeUpdate(DocumentEvent e) { }
	public void changedUpdate(DocumentEvent e) { }
	
	public void insertUpdate(DocumentEvent e) {
		String text = getText();
		FontMetrics fm = getGraphics().getFontMetrics();
		int width = fm.stringWidth(text);		
		if(width>getWidth()) setSize(width + 5, getHeight());
	}
}
