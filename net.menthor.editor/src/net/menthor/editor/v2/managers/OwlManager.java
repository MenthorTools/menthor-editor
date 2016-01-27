package net.menthor.editor.v2.managers;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import RefOntoUML.parser.OntoUMLParser;
import net.menthor.common.settings.owl.OWL2Destination;
import net.menthor.common.settings.owl.OwlOptions;
import net.menthor.editor.ui.Models;
import net.menthor.editor.ui.OWLHelper;
import net.menthor.editor.v2.settings.owl.OwlSettingsDialog;
import net.menthor.editor.v2.types.ResultType;
import net.menthor.editor.v2.types.ResultType.Result;

public class OwlManager extends BaseManager {

	private static OwlManager instance = new OwlManager();
	public static OwlManager get() { return instance; }
	
	public void callOwlSettings(){		
		OwlSettingsDialog dialog = new OwlSettingsDialog(diagramManager.getFrame(), 
			Models.getRefparser(),
			browser.getAllDiagrams()
		);
		dialog.setLocationRelativeTo(diagramManager.getFrame());
		dialog.setVisible(true);
	}
	
	@SuppressWarnings("unchecked")
	public String generateOwl(Object context){
		if(context instanceof List<?>){
			List<Object> list = (List<Object>)context;
			OntoUMLParser filteredParser = null;
			OwlOptions opt = null;
			if(list.size()>0) filteredParser = (OntoUMLParser)list.get(0);
			if(list.size()>1) opt = (OwlOptions) list.get(1);
			if(filteredParser!=null && opt!=null) return generateOwl(filteredParser, opt);			
		}
		return "No parameter passed as argument to the transformation. Method could not be called";
	}
	
	private String generateOwl(OntoUMLParser filteredParser, OwlOptions trOpt){
		RefOntoUML.Package model = filteredParser.createModelFromSelections(new Copier());
		ResultType result = OWLHelper.generateOwl(filteredParser, model, diagramManager.getWorkingConstraints(), trOpt);
		if(result.getResultType() != Result.ERROR){	
			if(trOpt.getDestination()==OWL2Destination.TAB)
			{
				infoManager.showOutputText(result.toString(), true, false);
				diagramManager.showInTextEditor((String)result.getData()[0]);
			}else{
				infoManager.showOutputText(result.toString(), true, true);
			}			
			return "SUCCESS. Project successfully transformed.";
		}else{
			infoManager.showOutputText(result.toString(), true, true);			
			return "FAILURE. Project could not be transformed.";
		}
	}
}
