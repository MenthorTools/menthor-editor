package org.tinyuml.draw;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;

import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.tinyuml.draw.MultilineLayouter.MultilineLayout;

/** A text field editor component to edit multi-line labels. It is derived from JTextArea. */
public class MultilineEditField extends JTextArea implements DocumentListener, IEditField {

	private static final long serialVersionUID = 1L;
	
	protected Label currentLabel;
	protected static final int MAGIC_OFFSET = 7;

	public MultilineEditField() {
		setBorder(null);
		hideField();
		setWrapStyleWord(true);
		setLineWrap(true);
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
		int width = (int) currentLabel.getParent().getSize().getWidth()
		- (int) Defaults.getInstance().getMarginSide();
		int height = (int) currentLabel.getSize().getHeight() + MAGIC_OFFSET;
		// patch in a minimum size until something better is found
		height = Math.max(height, 20);
		setText(text);
		Dimension size = new Dimension(width, height);
		setPreferredSize(size);
		setSize(size);
		setMinimumSize(size);
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
		MultilineLayout layout = MultilineLayouter.getInstance().calculateLayout(
			((Graphics2D) getGraphics()).getFontRenderContext(), 
			getFont(),
			getText(), 
			getSize().getWidth()
		);
		Dimension2D size2D = layout.getSize();
		Dimension size = new Dimension(
			(int) size2D.getWidth(),
			(int) size2D.getHeight() + MAGIC_OFFSET
		);
		setSize(size);
	}
}
