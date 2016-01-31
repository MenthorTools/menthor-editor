package org.tinyuml.ui.diagram;

import org.tinyuml.ui.diagram.commands.DiagramNotification.ChangeType;

import net.menthor.editor.v2.editors.base.EditorMouseEvent;

/**
 * An interface to report state changes within the diagram editor.
 */
public interface EditorStateListener {

  /**
   * Reports the current mouse coordinates. The coordinates reported are
   * transformed in the diagram coordinate system.
   * @param event the mouse event
   */
  void mouseMoved(EditorMouseEvent event);

  /**
   * Some state changed in the editor.
   * @param editor the editor that changed
   * @param the type of the change made in the diagram
   */
  void stateChanged(DiagramEditor editor, ChangeType changeType);

}
