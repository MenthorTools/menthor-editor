package net.menthor.xmi2ontouml;

import it.cnr.imaa.essi.lablib.gui.checkboxtree.CheckboxTree;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.TreeCheckingModel;

import java.io.File;
import java.util.Map.Entry;

import javax.swing.event.TreeSelectionListener;

import net.menthor.xmi2ontouml.framework.XMI2RefAssociation;
import net.menthor.xmi2ontouml.framework.XMI2RefClassifier;
import net.menthor.xmi2ontouml.framework.XMI2RefElement;
import net.menthor.xmi2ontouml.framework.XMI2RefModel;
import net.menthor.xmi2ontouml.framework.XMI2RefNamespace;
import net.menthor.xmi2ontouml.framework.XMI2RefProperty;
import net.menthor.xmi2ontouml.util.RefOntoUMLUtil;
import net.menthor.xmi2ontouml.xmiparser.XMIParser;
import net.menthor.xmi2ontouml.xmiparser.XMIParserFactory;
import RefOntoUML.Model;


public class Creator
{
	// Leitor de arquivo XMI que conhece as tags espec�ficas do programa que exportou o arquivo
	public XMIParser parser;

    public static String warningLog = "";
    
    public void initVariables(String Read_File_Address, boolean importComments, boolean importConstraints,
    		boolean ignoreUnknownStereotypes, 
    		boolean createDefaultElement, boolean ignoreErrorElem, boolean autoGenerateNamesAssoc, 
    		boolean autoGenerateNamesProp, boolean autoGenerateCard) throws Exception
    {
    	warningLog = "";
    	
    	XMI2RefElement.setIgnoreErrorElements(ignoreErrorElem);
    	XMI2RefElement.setImportComments(importComments);
    	XMI2RefNamespace.setImportConstraints(importConstraints);
    	
    	if (createDefaultElement)
    		XMI2RefClassifier.setUnknownStereotypeOpt(0);
    	
    	else if (ignoreUnknownStereotypes)
    		XMI2RefClassifier.setUnknownStereotypeOpt(1);
    	
    	else
    		XMI2RefClassifier.setUnknownStereotypeOpt(2);
    	
    	XMI2RefAssociation.setAutoGenerateNames(autoGenerateNamesAssoc);
    	XMI2RefProperty.setAutoGenerateNames(autoGenerateNamesProp);
    	XMI2RefProperty.setAutoGenerateCardinality(autoGenerateCard);
    	
    	//Call the factory to read the Document and decide which Parser
        //to create, depending on the program/exporter of the XMI
    	XMIParserFactory mapperFactory = new XMIParserFactory();
    	parser = mapperFactory.createMapper(new File(Read_File_Address));
    }
    
    public Model parse(String Read_File_Address, boolean importComments, boolean importConstraints,
    		boolean ignoreUnknownStereotypes, 
    		boolean createDefaultElement, boolean ignoreErrorElem, boolean autoGenerateNamesAssoc, 
    		boolean autoGenerateNamesProp, boolean autoGenerateCard) throws Exception
    {
    	initVariables(Read_File_Address, importComments, importConstraints,
    			ignoreUnknownStereotypes, createDefaultElement, ignoreErrorElem,
    			autoGenerateNamesAssoc, autoGenerateNamesProp, autoGenerateCard);
        
        //Creates the root (model) and all sub elements recursively
    	XMI2RefModel model = new XMI2RefModel(parser.getRoot(), parser);
    	
    	//Deal with the references to other objects
    	for (Entry<Object, XMI2RefElement> entry : XMI2RefElement.getElemMap().entrySet())
    	{
    		XMI2RefElement xmi2refelem = entry.getValue();
    		xmi2refelem.dealReferences();
    	}
    	
        return (Model) model.getRefOntoUMLElement();
    }
    
    public CheckboxTree[] generateModelTrees(Model model, TreeSelectionListener tsl) throws Exception
    {
    	CheckboxTree modelTree = RefOntoUMLUtil.createSelectionTreeFromModel(model);
    	modelTree.getCheckingModel().setCheckingMode(
    			TreeCheckingModel.CheckingMode.PROPAGATE_PRESERVING_UNCHECK);
    	modelTree.addTreeSelectionListener(tsl);
    	
    	CheckboxTree diagramTree = RefOntoUMLUtil.createSelectionTreeByDiagram(parser, model);
    	diagramTree.getCheckingModel().setCheckingMode(
    			TreeCheckingModel.CheckingMode.PROPAGATE_PRESERVING_UNCHECK);
    	diagramTree.addTreeSelectionListener(tsl);
    	
    	return new CheckboxTree[]{modelTree, diagramTree};
    }
}
