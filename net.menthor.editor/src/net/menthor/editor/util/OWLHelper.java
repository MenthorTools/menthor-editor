package net.menthor.editor.util;

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

import net.menthor.common.transformation.MappingType;
import net.menthor.common.transformation.OWLTransformationOptions;
import net.menthor.editor.util.OperationResult.ResultType;
import net.menthor.ontouml2simpleowl.OntoUML2SimpleOWL;
import net.menthor.ontouml2temporalowl.auxiliary.OWLStructure;
import net.menthor.ontouml2temporalowl.tree.TreeProcessor;
import net.menthor.ontouml2temporalowl.verbose.FileManager;
import net.menthor.ootos.OntoUML2OWL;
import RefOntoUML.parser.OntoUMLParser;
import br.com.inf.nemo.ontouml2rdf.OntoUML2RDF;

public class OWLHelper {

	public static OperationResult generateOwl(OntoUMLParser filteredParser, RefOntoUML.Package model, String ontologyIRI, MappingType mappingType, boolean fileOutput, String filePath, String oclRules, OWLTransformationOptions owlOptions)
	{
		//System.out.println(ontologyIRI);
		net.menthor.ontouml2temporalowl.auxiliary.MappingType mp = null;
		String errors = "";
		if(mappingType != null && !mappingType.equals(MappingType.RULES) && !mappingType.equals(MappingType.UFO_RDF)){
			mp = net.menthor.ontouml2temporalowl.auxiliary.MappingType.valueOf(mappingType.toString());
		}
    	try
    	{
    		String owlOutput = "";
    		if(mappingType == null)
    		{
    			owlOutput = OntoUML2SimpleOWL.Transformation(model, ontologyIRI);
    		}else if(mappingType.equals(MappingType.UFO_RDF)){
    			OntoUML2RDF ontoUml2rdf = new OntoUML2RDF(owlOptions, model, ontologyIRI);
    			owlOutput = ontoUml2rdf.transform();
    		}else if(mappingType.equals(MappingType.RULES)){
    			OntoUML2OWL ontoUML2OWL = new OntoUML2OWL();
    			owlOutput = ontoUML2OWL.Transformation(filteredParser, ontologyIRI, oclRules, owlOptions);
    			errors = ontoUML2OWL.errors;
    		}else
    		{
    			TreeProcessor tp = new TreeProcessor(model);
        		
    			// mapping the OntoUML-based structure into an OWL-based structure
    			// according to a certain mapping type
    			OWLStructure owl = new OWLStructure(mp);
    			owl.map(tp);
    			owlOutput = owl.verbose(ontologyIRI);
    		}	
			
    		if(owlOutput != null && owlOutput.length() > 0)
    		{
				if(fileOutput && filePath != null)
				{
					String owlFileName = ConfigurationHelper.canon(filePath);
				    	
					// Writing transformed model into owl file
					FileManager fileManager = new FileManager(owlFileName);
					fileManager.write(owlOutput);
					fileManager.done();
					
					return new OperationResult(ResultType.SUCESS, errors + "OWL generated successfully", new Object[] { owlFileName });
				}
				else
				{
					return new OperationResult(ResultType.SUCESS, errors + "OWL generated successfully", new Object[] { owlOutput });
				}
    		}
    		else
    		{
    			return new OperationResult(ResultType.ERROR, errors + "No OWL generated", null);
    		}
    	}
    	catch (Exception ex)
    	{
    		ex.printStackTrace();
    		return new OperationResult(ResultType.ERROR, "Error while generating the OWL for the model. \nDetails: " + ex.getMessage() + errors, null);
    	}
	}
}
