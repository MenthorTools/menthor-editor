package net.menthor.virtuoso.instances;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.menthor.virtuoso.queries.SparqlQueries;

public class IndividualInstance {
	private String ns;
	private String name;
	private String iri;
	private Map<String,String> classes;
	private Map<MyKey,ObjectPropertyInstance> objectPropertiesAsSource;
	private Map<MyKey,ObjectPropertyInstance> objectPropertiesAsTarget;
	private Map<MyKey,DataPropertyInstance> dataProperties;
	
	
	@SuppressWarnings("unused")
	private IndividualInstance() {
		
	}
	
	public IndividualInstance(String iriString) throws Exception {
		this.iri = iriString;
		
		String[] splittedIri = iriString.split("#");
		
		if(splittedIri.length < 2){
			throw new Exception();
		}
		
		this.ns = splittedIri[0];
		this.name = splittedIri[1];
	}

	public void searchForClasses(SparqlQueries kao) throws SQLException{
		ResultSet individualClassesResSet = kao.getAllIndividualInstanceClasses(this.iri);
		while(individualClassesResSet.next()){
			String individualClass = individualClassesResSet.getString("class");
			
			this.addListClasses(individualClass);
		}
	}
	
	public void searchForObjectPropertiesAsSource(SparqlQueries kao) throws Exception{
		ResultSet indInstObjPropAsSourceResSet = kao.getAllIndividualInstanceObjPropAsSource(this.iri);
		while(indInstObjPropAsSourceResSet.next()){
			String targetStr = indInstObjPropAsSourceResSet.getString("target");
			String opStr = indInstObjPropAsSourceResSet.getString("objProp");
			
			IndividualInstance target = new IndividualInstance(targetStr);
			
			this.addObjectPropertiesAsSource(kao, opStr, target, false);
		}
	}
	
	public void searchForObjectPropertiesAsTarget(SparqlQueries kao) throws Exception{
		ResultSet indInstObjPropAsTargetResSet = kao.getAllIndividualInstanceObjPropAsTarget(this.iri);
		while(indInstObjPropAsTargetResSet.next()){
			String sourceStr = indInstObjPropAsTargetResSet.getString("source");
			String opStr = indInstObjPropAsTargetResSet.getString("objProp");
			
			IndividualInstance source = new IndividualInstance(sourceStr);
			
			this.addObjectPropertiesAsTarget(kao, source, opStr);
		}
	}
	
	public void searchForDataProperties(SparqlQueries kao){
		
	}
	
	public String getNs() {
		return this.ns;
	}

	public void setNs(String ns) {
		this.ns = ns;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIri() {
		return iri;
	}

	public void setIri(String iri) {
		this.iri = iri;
	}

	public Map<String,String> getClasses(SparqlQueries kao) throws SQLException {
		if(this.classes == null){
			this.searchForClasses(kao);
		}
		return this.classes;
	}

	public void addListClasses(String classIriStr) {
		if(this.classes == null){
			this.classes = new HashMap<String,String>();
		}
		String[] splittedIri = classIriStr.split("#");
		if(splittedIri.length == 2){
			if(!this.classes.containsKey(splittedIri[1])){
				this.classes.put(splittedIri[1], splittedIri[1]);
			}			
		}		
	}

	public Map<MyKey,ObjectPropertyInstance> getObjectPropertiesAsTarget(SparqlQueries kao) throws Exception {
		if(this.objectPropertiesAsTarget == null){
			this.searchForObjectPropertiesAsTarget(kao);
		}
		return this.objectPropertiesAsTarget;
	}

	public Map<MyKey,ObjectPropertyInstance> getObjectPropertiesAsSource(SparqlQueries kao) throws Exception {
		if(this.objectPropertiesAsSource == null){
			this.searchForObjectPropertiesAsSource(kao);
		}
		return this.objectPropertiesAsSource;
	}
	
	public Map<MyKey,ObjectPropertyInstance> getObjectProperties(SparqlQueries kao) throws Exception{
		Map<MyKey,ObjectPropertyInstance> objectProperties = new HashMap<MyKey,ObjectPropertyInstance>();
		
		this.getObjectPropertiesAsSource(kao);
		this.getObjectPropertiesAsTarget(kao);
		
		if(this.objectPropertiesAsSource != null){
			objectProperties.putAll(this.objectPropertiesAsSource);
		}
		if(this.objectPropertiesAsTarget != null){
			objectProperties.putAll(this.objectPropertiesAsTarget);
		}
		return objectProperties;
	}

	public void addObjectPropertiesAsSource(SparqlQueries kao, String opIri, IndividualInstance target, Boolean getInverseOf) throws Exception {
		ObjectPropertyInstance op = new ObjectPropertyInstance(this, opIri, target);
		if(this.objectPropertiesAsSource == null){
			this.objectPropertiesAsSource = new HashMap<MyKey,ObjectPropertyInstance>();
		}		
		MyKey key = new MyKey(this.getIri(), opIri, target.getIri());
		if(!this.objectPropertiesAsSource.containsKey(key)){
			this.objectPropertiesAsSource.put(key, op);
		}
		
		if(getInverseOf){
			ArrayList<String> inverses = kao.getAllInverseOf(opIri);
			for (String invIri : inverses) {
				this.addObjectPropertiesAsTarget(kao, target, invIri);
			}
		}
	}

	public void addObjectPropertiesAsTarget(SparqlQueries kao, IndividualInstance source, String opIri) throws Exception {
		ObjectPropertyInstance op = new ObjectPropertyInstance(source, opIri, this);
		if(this.objectPropertiesAsTarget == null){
			this.objectPropertiesAsTarget = new HashMap<MyKey,ObjectPropertyInstance>();
		}		
		MyKey key = new MyKey(source.getIri(), opIri, this.getIri());
		if(!this.objectPropertiesAsTarget.containsKey(key)){
			this.objectPropertiesAsTarget.put(key, op);
		}		
	}
	
	public Map<MyKey,DataPropertyInstance> getDataProperties(SparqlQueries kao) {
		if(this.dataProperties == null){
			this.searchForDataProperties(kao);
		}
		return this.dataProperties;
	}

	@Override
	public String toString() {
		String out = "";
		out += "\n";
		out += 	this.name;
		out += "\n\tClasses: ";
		out += "\n\t\t";
		if(this.classes != null){
			for(Entry<String, String> className : this.classes.entrySet()) {
			//for (String className : this.classes) {
				out += className.getKey() + ", ";
			}
		}
		int i = out.lastIndexOf(",");
		if(i < 0){
			i = out.length();
		}
		out = out.substring(0, i);
		out += "\n\tObject Properties: ";
		if(this.objectPropertiesAsSource != null){
			for (Entry<MyKey, ObjectPropertyInstance> op : this.objectPropertiesAsSource.entrySet()) {
				out += "\n\t\t" + op.getValue();
			}
		}
		if(this.objectPropertiesAsTarget != null){
			for (Entry<MyKey, ObjectPropertyInstance> op : this.objectPropertiesAsTarget.entrySet()) {
				out += "\n\t\t" + op.getValue();
			}
		}
		out += "\n\tData Properties: ";
		if(this.dataProperties != null){
			for (Entry<MyKey, DataPropertyInstance> dp : this.dataProperties.entrySet()) {
				out += "\n\t\t" + dp.getValue();
			}
		}
		out += "\n";
		return out;
	}
}
