package net.menthor.common.settings.owl;

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

public class OwlOptions {

	private OWL2Destination owlDestination;
	private OWL2Approach owlApproach;
	private String outputPath;	
	private OwlAxioms owlAxioms;
	private OwlMappings owlMappings;
	
	//====================================
	//CONSTRUCTOR
	//====================================
	
	public OwlOptions(OWL2Approach mapping, OWL2Destination dest, String outputAbsolutePath){
		this.owlDestination = dest;
		this.outputPath = outputAbsolutePath;
		this.owlApproach = mapping;
	}

	//====================================
	//GETTERS & SETTERS
	//====================================
	
	public OWL2Destination getDestination() { return owlDestination; }	
	public OWL2Approach getApproach() { return owlApproach; }
	public String getPath() { return outputPath; }
	
	public void setOwlAxioms(OwlAxioms ae) { this.owlAxioms = ae; }
	public OwlAxioms getOwlAxioms() { return owlAxioms; }
	
	public void setOwlMappings(OwlMappings me) { this.owlMappings = me; }
	public OwlMappings getOwlMappings() { return owlMappings; }
}
