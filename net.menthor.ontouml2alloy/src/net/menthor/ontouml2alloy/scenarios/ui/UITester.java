package net.menthor.ontouml2alloy.scenarios.ui;

import java.util.ArrayList;

import javax.swing.JDialog;

import net.menthor.common.file.TimeHelper;
import net.menthor.ontouml2alloy.scenarios.StoryScenario;
import net.menthor.ontouml2alloy.scenarios.StoryType;
import net.menthor.ontouml2alloy.scenarios.StoryScenario.Limit;
import RefOntoUML.Association;
import RefOntoUML.parser.OntoUMLParser;

public class UITester {

	public UITester() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OntoUMLParser parser;
		String fileName = "model/OntoBio.refontouml";
		System.out.println(TimeHelper.getTime()+" - "+fileName+": Loading parser...");
		
		try {
			parser = new OntoUMLParser(fileName);
			
		}catch(Exception e){
			System.out.println(TimeHelper.getTime()+" - "+fileName+": Parser not loaded!");
			return;
		}
		
		System.out.println(TimeHelper.getTime()+" - "+fileName+": Parser loaded!");
		
		try {
			ScenarioDialog dialog = new ScenarioDialog(parser);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
