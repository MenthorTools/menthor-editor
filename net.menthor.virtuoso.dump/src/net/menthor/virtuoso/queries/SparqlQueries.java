package net.menthor.virtuoso.queries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map.Entry;

import net.menthor.virtuoso.connection.ConnectionFactory;
import net.menthor.virtuoso.instances.IndividualInstance;
import net.menthor.virtuoso.instances.MyKey;
import net.menthor.virtuoso.instances.ObjectPropertyInstance;
import virtuoso.jena.driver.VirtGraph;
import virtuoso.jena.driver.VirtuosoUpdateFactory;
import virtuoso.jena.driver.VirtuosoUpdateRequest;

public class SparqlQueries {
	Connection connection;
	Statement st;
	
	public String ontologyUri;
	public String ontologyUriHashTag;
	public final String defineInference;
	public final String prefixes;
	
	public final String rdfs = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
	public final String owl = "http://www.w3.org/2002/07/owl#";
	
	
	public SparqlQueries(String ontologyUri) throws ClassNotFoundException, SQLException {
		this.ontologyUri = ontologyUri;
		this.ontologyUriHashTag = this.ontologyUri + "#";
		
		this.defineInference = ""
//				+ "DEFINE input:inference <" + ontologyUri + ">"
				+ "\n";
		
		this.prefixes = 	""
				+ "PREFIX rdfs: <" + this.rdfs + ">"
				+ "\n"
				+ "PREFIX owl: <" + owl + ">"
				+ "\n"
				+ "PREFIX myOntology: <" + ontologyUriHashTag + ">"
				+ "\n";
		
		this.connection = new ConnectionFactory().getConnection();
		this.st = connection.createStatement();
	}
	
	public ResultSet getAllIndividualInstanceClasses(String individualUri) throws SQLException{
		String sparql = ""
					+ "sparql\n"
					+ defineInference
					+ prefixes
					+ "SELECT * \n"
					+ "WHERE \n"
					+ "{ \n" 
					+ "\t" + "<" + individualUri + ">" + " rdfs:type " + "?class \n"
					+ "}";
		
		ResultSet results = this.st.executeQuery(sparql);
		
		return results;
	}
	
	public ResultSet getAllIndividualInstanceObjPropAsSource(String individualUri) throws SQLException{
		String sparql = ""
					+ "sparql\n"
					+ defineInference
					+ prefixes
					+ "SELECT * \n"
					+ "WHERE \n"
					+ "{ \n"
					+ "\t" + "<" + individualUri + ">" + " ?objProp " + "?target .\n"
					+ "\t" + "?objProp rdfs:type owl:ObjectProperty \n"
					+ "}";
		
		ResultSet results = this.st.executeQuery(sparql);
		
		return results;
	}
	
	public ResultSet getAllIndividualInstanceObjPropAsTarget(String individualUri) throws SQLException{
		String sparql = ""
					+ "sparql\n"
					+ defineInference
					+ prefixes
					+ "SELECT * \n"
					+ "WHERE \n"
					+ "{ \n"
					+ "\t" + "?source ?objProp "  + "<" + individualUri + ">" + " .\n"
					+ "\t" + "?objProp rdfs:type owl:ObjectProperty \n"
					+ "}";
		
		ResultSet results = this.st.executeQuery(sparql);
		
		return results;
	}
	
	public ResultSet getAllIndividuals() throws SQLException{
		String sparql = ""
				+ "sparql\n"
				+ defineInference
				+ prefixes
				+ "SELECT * \n"
				+ "FROM <" + this.ontologyUri + ">"
				+ "WHERE \n"
				+ "{ \n"
				+ "	?s rdf:type ?class .\n"
				+ "	?class rdf:type owl:Class . "
				+ ""
				+ "}";
		
		ResultSet results = this.st.executeQuery(sparql);
		
		return results;
		
	}
	
	public ResultSet getAllObjectPropertiesOfIndivididuals() throws SQLException{
		String sparql = ""
				+ "sparql\n"
				+ defineInference
				+ prefixes
				+ "SELECT * \n"
				+ "FROM <" + this.ontologyUri + ">\n"
				+ "WHERE \n"
				+ "{ \n"
//				+ "	?s rdf:type ?class .\n"
//				+ "	?class rdf:type owl:Class . \n"
				+ "	?s ?p ?o . \n"
				+ "	?p rdf:type owl:ObjectProperty . \n"
				+ "}";
		
		ResultSet results = this.st.executeQuery(sparql);
		
		return results;
		
	}
	
	public ResultSet getAllDataPropertiesOfIndivididuals() throws SQLException{
		String sparql = ""
				+ "sparql\n"
				+ defineInference
				+ prefixes
				+ "SELECT * \n"
				+ "FROM <" + this.ontologyUri + ">\n"
				+ "WHERE \n"
				+ "{ \n"
//				+ "	?s rdf:type ?class .\n"
//				+ "	?class rdf:type owl:Class . \n"
				+ "	?s ?p ?o . \n"
				+ "	?p rdf:type owl:DatatypeProperty . \n"
				+ "}";
		
		ResultSet results = this.st.executeQuery(sparql);
		
		return results;
		
	}
	
	public ResultSet getAllLabelOfIndivididuals() throws SQLException{
		String sparql = ""
				+ "sparql\n"
				+ defineInference
				+ prefixes
				+ "SELECT * \n"
				+ "FROM <" + this.ontologyUri + ">\n"
				+ "WHERE \n"
				+ "{ \n"
				+ "	?s rdfs:label ?o . \n"
				+ "}";
		
		ResultSet results = this.st.executeQuery(sparql);
		
		return results;
		
	}
	
	public ResultSet getAllTriples() throws SQLException{
		String sparql = ""
				+ "sparql\n"
				+ defineInference
				+ prefixes
				+ "SELECT * \n"
				+ "FROM <" + this.ontologyUri + ">"
				+ "WHERE \n"
				+ "{ \n"
				+ "	?s ?p ?o .\n"
				+ ""
				+ "}";
		
		ResultSet results = this.st.executeQuery(sparql);
		
		return results;
		
	}
	
	public ArrayList<IndividualInstance> getAllIndividualInstances(boolean getClassesEagerly, boolean getObjectPropertiesEagerly, boolean getDataPropertiesEagerly) throws Exception {
		ArrayList<IndividualInstance> individualInstanceList = new ArrayList<IndividualInstance>();
		
		ResultSet resSetIndividuals = getAllIndividuals();
		
		while(resSetIndividuals.next()){
			String individualIri = resSetIndividuals.getString("individualIri");
			
			IndividualInstance individualInstance = new IndividualInstance(individualIri);
			
			individualInstanceList.add(individualInstance);
		}
		
		for (IndividualInstance individualInstance : individualInstanceList) {
			if(getClassesEagerly){
				individualInstance.searchForClasses(this);
			}
			
			if(getObjectPropertiesEagerly){
				individualInstance.searchForObjectPropertiesAsSource(this);
				individualInstance.searchForObjectPropertiesAsTarget(this);
			}
			
			if(getDataPropertiesEagerly){
				individualInstance.searchForDataProperties(this);
			}			
		}		
		
		return individualInstanceList;
		
	}
	
	public void insertInstance(IndividualInstance individual) throws Exception{
		/*			STEP 1			*/
		VirtGraph set = new VirtGraph (ConnectionFactory.getVirtuosourl(), "dba", "dba");
		
		String insertStr = "";
		insertStr += "INSERT INTO GRAPH <" + this.ontologyUri + ">\n";
		insertStr += "{ ";
		
		insertStr += "\n";
		insertStr += "<" + individual.getIri() + "> ";
		insertStr += "<" + this.rdfs + "type> <" + owl + "NamedIndividual> . ";
		
		for (Entry<String, String> classEntry : individual.getClasses(this).entrySet()) {
			insertStr += "\n";
			insertStr += "<" + individual.getIri() + "> ";
			insertStr += "<" + this.rdfs + "type> ";
			insertStr += "<" + this.ontologyUri + "#" + classEntry.getValue() + "> . ";			
		}
		
		for (Entry<MyKey, ObjectPropertyInstance> opEntry : individual.getObjectProperties(this).entrySet()) {
			insertStr += "\n";
			insertStr += "<" + opEntry.getValue().getSource().getIri() + "> ";
			insertStr += "<" + opEntry.getValue().getIri() + "> ";
			insertStr += "<" + opEntry.getValue().getTarget().getIri() + "> . ";
		}
		
//		for (DataPropertyInstance dp : individual.getDataProperties(this)) {
//			insertStr += "\n";
//			insertStr += "<" + individual.getIri() + "> ";
//			insertStr += "<" + dp.getIri() + "> ";
//			insertStr += "<" + dp.getTarget().getIri() + "> . ";
//		}
		
		insertStr += "\n";
		insertStr += "}";
		
		System.out.println("\n" + insertStr);
        
        VirtuosoUpdateRequest vur = VirtuosoUpdateFactory.create(insertStr, set);
        vur.exec();    
	}
	
	public ArrayList<String> getAllInverseOf(String opIri) throws SQLException {
		ArrayList<String> ioList = new ArrayList<String>();
		
		String sparql = ""
				+ "sparql\n"
				+ defineInference
				+ prefixes
				+ "SELECT * \n"
				+ "FROM <" + this.ontologyUri + ">\n"
				+ "WHERE \n"
				+ "{ \n"
				+ "\t{\n"
				+ "\t\t<" + opIri + "> <" + owl + "inverseOf> ?inverse\n"
				+ "\t}\n" 
				+ "\tUNION\n"
				+ "\t{\n"
				+ "\t\t?inverse <" + owl + "inverseOf> <" + opIri + ">\n"
				+ "\t}\n"
				+ "}";
		
		ResultSet results = this.st.executeQuery(sparql);
		
		while(results.next()){
			String inverseIri = results.getString("inverse");
			
			ioList.add(inverseIri);
		}
		
		return ioList; 
	}
	
}
