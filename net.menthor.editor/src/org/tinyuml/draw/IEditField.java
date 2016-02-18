package org.tinyuml.draw;

import java.awt.Graphics;

public interface IEditField {

	/** Returns the currently edited Label. */
	Label getLabel();

	/** Makes the editor invisible. */
	void hideField();

	/** Displays the editor at the specified position. */
	void showField(Label aLabel, Graphics g);

	/** Returns the visibility state of this editor. */
	boolean isVisible();

  	/** Returns the text within the editor. */
  	String getText();
}
