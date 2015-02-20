/**
 * Copyright(C) 2011-2014 by John Guerson, Tiago Prince, Antognoni Albuquerque
 *
 * This file is part of OLED (OntoUML Lightweight BaseEditor).
 * OLED is based on TinyUML and so is distributed under the same
 * license terms.
 *
 * OLED is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * OLED is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with OLED; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package net.menthor.editor.model;

import java.util.ArrayList;

import RefOntoUML.Element;

/**
 * @author Tiago Prince
 */
public class InferenceList {

	private ArrayList<Element> inferredElement;
	
	public InferenceList(ArrayList<Element> inferredElements){
		this.inferredElement = inferredElements;
	}
	
	public InferenceList(){
		this.inferredElement = new ArrayList<>();
	}

	public ArrayList<Element> getInferredElements() {
		return inferredElement;
	}

	public void setInferredElements(ArrayList<Element> inferredElements) {
		this.inferredElement = inferredElements;
	}
	
	public void addAll (ArrayList<Element> inferredElements){
		this.inferredElement.addAll(inferredElements);
	}
}
