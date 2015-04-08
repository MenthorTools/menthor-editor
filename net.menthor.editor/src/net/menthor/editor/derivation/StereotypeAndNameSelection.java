package net.menthor.editor.derivation;

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
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class StereotypeAndNameSelection {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JPanel selectStereotype(Object[] stereo) {

		JPanel p = new JPanel(new BorderLayout(5, 5));

		JPanel labels = new JPanel(new GridLayout(0, 1, 2, 2));
		labels.add(new JLabel("Name", SwingConstants.RIGHT));
		labels.add(new JLabel("Stereotype", SwingConstants.RIGHT));
		p.add(labels, BorderLayout.WEST);

		JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
		JTextField name = new JTextField("");
		controls.add(name);
		JComboBox combo_stereotype = new JComboBox();
		DefaultComboBoxModel model2 = new DefaultComboBoxModel();
		for (Object string : stereo) {
			model2.addElement(string);
		}
		combo_stereotype.setModel(model2);
		combo_stereotype.getModel().setSelectedItem(model2.getElementAt(0));
		controls.add(combo_stereotype);
		p.add(controls, BorderLayout.CENTER);
		ArrayList<String> values = new ArrayList<String>();
		values.add("OK");
		values.add("Cancel");

		int value = JOptionPane.showOptionDialog(null, p,
				"Name and Stereotype", JOptionPane.OK_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, values.toArray(),
				values.toArray()[0]);
		if (value == -1 || value == 1) {
			return null;
		}
		return controls;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JPanel selectStereotype(Object[] stereo, String message) {

		JPanel p = new JPanel(new BorderLayout(5, 5));

		JPanel labels = new JPanel(new GridLayout(0, 1, 2, 2));
		labels.add(new JLabel("Name", SwingConstants.RIGHT));
		labels.add(new JLabel("Stereotype", SwingConstants.RIGHT));
		p.add(labels, BorderLayout.WEST);

		JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
		JTextField name = new JTextField("");
		controls.add(name);
		JComboBox combo_stereotype = new JComboBox();
		DefaultComboBoxModel model2 = new DefaultComboBoxModel();
		for (Object string : stereo) {
			model2.addElement(string);
		}
		combo_stereotype.setModel(model2);
		combo_stereotype.getModel().setSelectedItem(model2.getElementAt(0));
		controls.add(combo_stereotype);
		p.add(controls, BorderLayout.CENTER);
		ArrayList<String> values = new ArrayList<String>();
		values.add("OK");
		values.add("Cancel");

		int value = JOptionPane.showOptionDialog(null, p, message,
				JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				values.toArray(), values.toArray()[0]);
		if (value == -1 || value == 1) {
			return null;
		}
		return controls;
	}
	
	public static void wrongSelection(String message) {
		JFrame frame = new JFrame("");
		JOptionPane.showMessageDialog(frame, message);

	}
	
	@SuppressWarnings("unused")
	public static String defineNameDerivedType() {

		String name = "";
		while (name == "") {
			name = JOptionPane.showInputDialog(null,
					"What's the Name of the New Type", "Name Type", 1);
		}
		return name;
	}
	
	@SuppressWarnings("unused")
	public static String defineNameDerivedType(String message) {

		String name = "";
		while (name == "") {
			name = JOptionPane.showInputDialog(null,
					message, "Name Type", 1);
		}
		return name;
	}
	
}
