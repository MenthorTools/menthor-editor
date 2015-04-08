package net.menthor.editor.model;

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

import java.io.File;
import java.io.IOException;

import net.menthor.alloy.AlloyModule;
import net.menthor.common.file.FileUtil;
import net.menthor.ontouml2alloy.OntoUML2Alloy;
import net.menthor.ontouml2alloy.OntoUML2AlloyOptions;
import net.menthor.tocl.parser.TOCLParser;
import net.menthor.tocl.tocl2alloy.TOCL2Alloy;
import net.menthor.tocl.tocl2alloy.TOCL2AlloyOption;
import RefOntoUML.parser.OntoUMLParser;

/**
 * This class represents an Alloy Model.
 * 
 * @author John Guerson
 */

public class AlloySpecification {

	/** Absolute directory path of alloy specification. */
	public String alsOutDirectory;	
	
	/** File name of alloy specification. */
	private String alsmodelName;	
	
	/** Absolute path of alloy specification. */
	private String alsPath;	
	
	/** Alloy Module */
	private AlloyModule alsModule;
	private OntoUML2Alloy ontouml2alloy;
	
	/** Additional content of alloy specification. */	
	private String additionalContent = new String();
	
	/** Log details for operations made. */
	private String logDetails = new String();

	/**
	 * This constructor basically initialize the path of alloy model, i.e. without any content.
	 */
	public AlloySpecification(String alloyPath)
	{
		this();
		
		setAlloyModel(alloyPath);
	}
	
	public AlloySpecification(String alloyPath,OntoUMLParser refparser, OntoUML2AlloyOptions optmodel) throws Exception
	{
		this();
		
		setAlloyModel(alloyPath,refparser,optmodel);
	}
	
	public AlloySpecification() { }	

	/**
	 * Private methods
	 */
	private void setAlloyModel(String alloyPath, OntoUMLParser refparser, OntoUML2AlloyOptions optmodel) throws Exception
	{
		setAlloyModel(alloyPath);				
		setDomainModel(refparser,optmodel);	
	}
	
	private void setAlloyModel(String alloyPath)
	{			
		this.alsPath = alloyPath;
		File file = new File(alsPath);
		file.deleteOnExit();
		
		alsOutDirectory = alsPath.substring(0, alsPath.lastIndexOf(File.separator)+1);		
		alsmodelName = alsPath.substring(alsPath.lastIndexOf(File.separator)+1,alsPath.length()).replace(".als","");	
	}
	
	public void setDomainModel(OntoUMLParser refparser, OntoUML2AlloyOptions ontoOptions)
	{
		ontouml2alloy = new OntoUML2Alloy(refparser, alsPath, ontoOptions);
		alsModule = ontouml2alloy.transformer.module;
	}
	
	public void appendContent(String content) throws IOException
	{ 
		additionalContent = additionalContent+content; 
		FileUtil.writeToFile(alsModule.toString()+"\n"+additionalContent, alsPath); 
	}	
		
	/**
	 * Transformations
	 */
	public void transformDomainModel() throws Exception
	{
		ontouml2alloy.transform();
		FileUtil.writeToFile(alsModule.toString()+"\n"+additionalContent, alsPath);
	}
	
	public String transformConstraints(OntoUMLParser refparser, TOCLParser toclparser, TOCL2AlloyOption oclOptions) throws IOException
	{	
		additionalContent += "\n"+TOCL2Alloy.convertHistoricalRelationships(ontouml2alloy.transformer.factory, ontouml2alloy.transformer.sigObject, toclparser);
		additionalContent += "\n"+TOCL2Alloy.convertTemporalConstraints(toclparser, oclOptions);
		
		FileUtil.writeToFile(alsModule.toString()+"\n"+additionalContent, alsPath);
		
		return TOCL2Alloy.log;		
	}
		
	/** Get Log details for made operations. */
	public String getDetails() { return logDetails; }
	
	/**  Get absolute path of alloy specification. */
	public String getAlloyPath() { return alsPath; }
	
	/** Get file name of alloy specification. */
	public String getAlloyModelName() {	return alsmodelName; }
	
	/** Get content of alloy specification. */
	public String getContent() { return alsModule.toString()+"\n"+additionalContent; }
	
	/** Get the Destination Directory of this model. */
	public String getDirectory() { return alsOutDirectory; }
	
}
