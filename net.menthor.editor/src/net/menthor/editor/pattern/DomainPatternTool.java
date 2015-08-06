package net.menthor.editor.pattern;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.tinyuml.draw.DiagramElement;
import org.tinyuml.ui.commands.AppCommandDispatcher;
import org.tinyuml.umldraw.AssociationElement;
import org.tinyuml.umldraw.ClassElement;
import org.tinyuml.umldraw.GeneralizationElement;
import org.tinyuml.umldraw.StructureDiagram;

import RefOntoUML.Association;
import RefOntoUML.Classifier;
import RefOntoUML.Generalization;
import RefOntoUML.GeneralizationSet;
import RefOntoUML.parser.OntoUMLParser;
import net.menthor.assistant.util.UtilAssistant;
import net.menthor.common.ontoumlfixer.Fix;
import net.menthor.editor.AppFrame;
import net.menthor.editor.DiagramManager;
import net.menthor.editor.Main;
import net.menthor.editor.explorer.Models;
import net.menthor.editor.ui.PngWriter;
import net.menthor.editor.ui.UmlProject;
import net.menthor.editor.v2.UmlDiagram;
import net.menthor.editor.v2.palette.PaletteAccordion;
import net.menthor.editor.v2.palette.PaletteGrouping;
import net.menthor.editor.v2.palette.PaletteItem;
import net.menthor.pattern.dynamic.ui.DynamicWindowForDomainPattern;
import net.menthor.pattern.ui.manager.DynamicManagerWindowForDomainPattern;

public class DomainPatternTool {

	private static StructureDiagram currentDiagram;
	private static PaletteGrouping domainPallete;
	private static AppFrame frame;
	private static OntoUMLParser parser;
	
	public static void initializeDomainPatternPalette(PaletteAccordion palleteAccordion, UmlProject patternProject, AppCommandDispatcher editorDispatcher, AppFrame appFrame) {
		
		List<String> names = new ArrayList<String>();
		for(UmlDiagram umlDiagram: patternProject.getDiagrams()){
			StructureDiagram diagram =  (StructureDiagram)umlDiagram;
			names.add(diagram.getName());
		}
			
		domainPallete = palleteAccordion.createDomainGrouping(names);
		
		frame = appFrame;
		parser = Models.getRefparser();
		
		HashMap<PaletteItem, StructureDiagram> hashDomainPalette = new HashMap<>();
		for(UmlDiagram umlDiagram: patternProject.getDiagrams()){
			StructureDiagram diagram =  (StructureDiagram)umlDiagram;
			PaletteItem item = domainPallete.getItemMap().get(diagram.getName());
			if(item!=null) hashDomainPalette.put(item, diagram);
		}
		
		DomainPatternTool.createDomainPalleteListener(domainPallete, hashDomainPalette,frame);
	}
	
	public static void createDomainPalleteListener(final PaletteGrouping domainPallete,final HashMap<PaletteItem, StructureDiagram> hashDomainPalette, AppFrame frame) {
//		domainPallete.addCommandListener(new AppCommandListener() {
//
//			@Override
//			public void handleCommand(String command) {
//				currentDiagram = hashDomainPalette.get(domainPallete.getSelected());
//			}
//
//		});
	}

	//Falta pegar os GeneralizationSets	
	public static void exportModelAsPattern(UmlProject currentProject) {
//		for(UmlDiagram umlDiagram: currentProject.getDiagrams()){
//			StructureDiagram diagram =  (StructureDiagram)umlDiagram;
//			System.out.println(diagram.getName()+"{ ");
//			for (DiagramElement dm : diagram.getChildren()) {
//				System.out.println(dm.getClass().toString()+" - "+dm.toString());
//			}
//
//			System.out.println("}");
//		}
	}


	private static Fix getFix(StructureDiagram diagram, OntoUMLParser parser, HashMap<String, ArrayList<Object[]>> hashMap, Point cliked){
		Fix fix = new Fix();
		ArrayList<Point> points = diagram.getUsedCanvasSize();
		Point mediana = new Point(points.get(1).x - points.get(0).x, points.get(1).y - points.get(0).y);
		for (DiagramElement de : diagram.getChildren()) {
			if(de instanceof ClassElement){
				Classifier c = ((ClassElement) de).getClassifier();
				c.setName((String)(hashMap.get(UtilAssistant.getStringRepresentationClass(c)).get(0)[1]));
				parser.getModel().getPackagedElement().add(c);
				Point clsPoint = new Point((int)((ClassElement) de).getAbsCenterX(), (int)((ClassElement) de).getAbsCenterY());
				Point clsRelMed = new Point(clsPoint.x - mediana.x, clsPoint.y - mediana.y); 
				
				fix.includeAdded(c, cliked.x+clsRelMed.x, cliked.y+clsRelMed.y);
			}
		}

		for (DiagramElement de : diagram.getChildren()) {
			if(de instanceof AssociationElement){
				Association a = ((AssociationElement) de).getAssociation();
				parser.getModel().getPackagedElement().add(a);
				fix.includeAdded(a);
			}else if(de instanceof GeneralizationElement){
				Generalization g = ((GeneralizationElement) de).getGeneralization();
				fix.includeAdded(g);
				for(GeneralizationSet gs : g.getGeneralizationSet()){
					if(!fix.getAdded().contains(gs))
						fix.includeAdded(gs);
				}
			}
		}


		return fix;
	}

	public static Fix run(double x, double y) {
		BufferedImage buffImage = PngWriter.getPNGImage(currentDiagram);
		DynamicWindowForDomainPattern dynwin = DynamicWindowForDomainPattern.createDialog(buffImage, "Domain Pattern: "+currentDiagram.toString());
		DynamicManagerWindowForDomainPattern dfdp = new DynamicManagerWindowForDomainPattern(dynwin);

		//Adding 
		for (DiagramElement de : currentDiagram.getChildren()) {
			if(de instanceof ClassElement){
				Classifier c = ((ClassElement) de).getClassifier();
				dfdp.addTableLine(UtilAssistant.getStringRepresentationClass(c), UtilAssistant.getStringRepresentationClass(c), new String[]{UtilAssistant.getStringRepresentationStereotype(c)});
			}
		}
		dynwin.open();
		domainPallete.getSelected().setSelected(false);
		HashMap<String, ArrayList<Object[]>> hash = dynwin.getHashTable();
		Fix fix = null;
		if(hash != null){
			fix = DomainPatternTool.getFix(currentDiagram, parser, dynwin.getHashTable(),new Point((int)x,(int)y));
		}
		
		return fix;
	}
	
	public static void runPattern(final DiagramManager diagramManager,final double x, final double y) {
		if(Main.onMac()){
			com.apple.concurrent.Dispatch.getInstance().getNonBlockingMainQueueExecutor().execute( new Runnable(){        	
				@Override
				public void run() {
					Fix fix = DomainPatternTool.run(x, y);
					diagramManager.updateMenthor(fix);
				}
			});
		}else{
			Fix fix = DomainPatternTool.run(x, y);
			diagramManager.updateMenthor(fix);
		}
	}

}
