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

import net.menthor.common.transformation.DestinationEnum;
import net.menthor.common.transformation.OwlAxiomsEnforcement;
import net.menthor.common.transformation.TransformationOption;
import net.menthor.editor.util.OperationResult.ResultType;
import net.menthor.ontouml2simpleowl.OntoUML2SimpleOWL;
import net.menthor.ontouml2temporalowl.auxiliary.OWLMappingTypes;
import net.menthor.ontouml2temporalowl.auxiliary.OWLStructure;
import net.menthor.ontouml2temporalowl.tree.TreeProcessor;
import net.menthor.ontouml2temporalowl.verbose.FileManager;
import net.menthor.ootos.OntoUML2OWL;
import RefOntoUML.parser.OntoUMLParser;
import br.com.inf.nemo.ontouml2rdf.OntoUML2RDF;

public class OWLHelper {

	public static OperationResult generateOwl(OntoUMLParser filteredParser, RefOntoUML.Package model, String ontologyIRI, String oclRules, OwlAxiomsEnforcement owlOptions, TransformationOption trOpt)
	{
		String errors = new String();
		String owlOutput = new String();
    	try {    		
    		if(trOpt.getMappingType().getIdentifier().equals("SIMPLE")) 
    		{    			
    			owlOutput = OntoUML2SimpleOWL.Transformation(model, ontologyIRI);
    		}
    		if(trOpt.getMappingType().getIdentifier().equals("UFO_RDF")) 
    		{    			
    			OntoUML2RDF ontoUml2rdf = new OntoUML2RDF(owlOptions, model, ontologyIRI);
    			owlOutput = ontoUml2rdf.transform();
    		}
    		if(trOpt.getMappingType().getIdentifier().equals("OOTOS"))
    		{    			
    			OntoUML2OWL ontoUML2OWL = new OntoUML2OWL();
    			owlOutput = ontoUML2OWL.Transformation(filteredParser, ontologyIRI, oclRules, owlOptions);
    			errors = ontoUML2OWL.errors;
    		}
    		if(trOpt.getMappingType().getIdentifier().equals("REIFICATION") || trOpt.getMappingType().getIdentifier().equals("WORM_VIEW_A0") || trOpt.getMappingType().getIdentifier().equals("WORM_VIEW_A1") || trOpt.getMappingType().getIdentifier().equals("WORM_VIEW_A2"))
    		{
    			TreeProcessor tp = new TreeProcessor(model);
    			OWLMappingTypes mtypes = OWLMappingTypes.REIFICATION;
    			if(trOpt.getMappingType().getIdentifier().equals("WORM_VIEW_A0")) mtypes = OWLMappingTypes.WORM_VIEW_A0; 
    			if(trOpt.getMappingType().getIdentifier().equals("WORM_VIEW_A1")) mtypes = OWLMappingTypes.WORM_VIEW_A1;
    			if(trOpt.getMappingType().getIdentifier().equals("WORM_VIEW_A2")) mtypes = OWLMappingTypes.WORM_VIEW_A2;
    			OWLStructure owl = new OWLStructure(mtypes);
    			owl.map(tp);
    			owlOutput = owl.verbose(ontologyIRI);
    		}    		
    		if(owlOutput.length()>0)
    		{
				if(trOpt.getDestination()==DestinationEnum.FILE && trOpt.getPath()!=null && !trOpt.getPath().isEmpty())
				{
					String owlFileName = trOpt.getPath();							
					FileManager fileManager = new FileManager(owlFileName);
					fileManager.write(owlOutput);
					fileManager.done();					
					return new OperationResult(ResultType.SUCESS, errors + "OWL generated successfully", new Object[] { owlFileName });
				}else{
					return new OperationResult(ResultType.SUCESS, errors + "OWL generated successfully", new Object[] { owlOutput });
				}
    		}else{
    			return new OperationResult(ResultType.ERROR, errors + "No OWL generated", null);
    		}
    	}catch (Exception ex) {
    		ex.printStackTrace();
    		return new OperationResult(ResultType.ERROR, "Error while generating the OWL for the model. \nDetails: " + ex.getMessage() + errors, null);
    	}
	}
}
