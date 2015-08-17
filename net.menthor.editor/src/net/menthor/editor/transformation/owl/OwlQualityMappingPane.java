package net.menthor.editor.transformation.owl;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JPanel;

import net.menthor.common.transformation.QualityMappingType;
import net.menthor.editor.v2.tables.ElementTableModel;
import net.menthor.editor.v2.tables.QualityTablePane;
import net.menthor.editor.v2.types.settings.OwlSettingsMap;
import RefOntoUML.Element;
import RefOntoUML.parser.OntoUMLParser;

public class OwlQualityMappingPane extends JPanel{

	private static final long serialVersionUID = -164010334881840365L;
	
	protected OntoUMLParser refparser;
	protected QualityTablePane qualityPane;
	
	public OwlQualityMappingPane(OntoUMLParser refparser){
		this.refparser = refparser;	
		buildUI();
		loadFromXML();
	}
	
	private void buildUI(){
		qualityPane = new QualityTablePane("Structured Qualities",refparser, "OWL/RDF");		
		qualityPane.setText("Hide the quality and map its structures as datatype properties owned by the bearer type or maintain the quality as a Class and map the structures as datatype properties owned by the quality");		
		setLayout(new BorderLayout(0,0));		
		add(qualityPane, BorderLayout.CENTER);
	}
	
	public void loadFromXML(){
		OwlSettingsMap.getInstance().load();
		if(refparser==null) return;
		Map<Element, QualityMappingType> map = OwlSettingsMap.getInstance().getOwlQualityMappingTypes(refparser);		
		for(HashMap.Entry<Element,QualityMappingType> entry: map.entrySet()){			
			addUIEntry(entry.getKey(), entry.getValue());
		}		
	}
	
	public void storeToXML() throws Exception{
		for(Entry<RefOntoUML.Element, Object> entry: getQualityMap().entrySet()){
			OwlSettingsMap.getInstance().setOwlQualityMappingType((RefOntoUML.Element)entry.getKey(),(QualityMappingType)entry.getValue());
		}
		OwlSettingsMap.getInstance().store();
	}
	
	public HashMap<RefOntoUML.Element,Object> getQualityMap() throws Exception {
		return ((ElementTableModel)qualityPane.getTableModel()).getEntries();
	}
	
	private void addUIEntry(RefOntoUML.Element elem, QualityMappingType owlDt){
		if(elem instanceof RefOntoUML.Quality){
			((ElementTableModel)qualityPane.getTableModel()).addEntry(elem, owlDt);
		}
	}
}
