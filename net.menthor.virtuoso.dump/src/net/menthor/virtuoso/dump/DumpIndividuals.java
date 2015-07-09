package net.menthor.virtuoso.dump;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.semanticweb.owlapi.vocab.OWL2Datatype;

import net.menthor.virtuoso.queries.SparqlQueries;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.reasoner.ValidityReport;
import com.hp.hpl.jena.vocabulary.OWL2;
import com.hp.hpl.jena.vocabulary.RDF;

public class DumpIndividuals {
	OntModel ontModel;
	SparqlQueries sparqlQueries;
	public DumpIndividuals(String owlPath) throws FileNotFoundException, ClassNotFoundException, SQLException {
		sparqlQueries = new SparqlQueries("http://www.atlantico.com.br/GI2S");
		
		ontModel = ModelFactory.createOntologyModel( OntModelSpec.OWL_DL_MEM_RDFS_INF);
		InputStream in = new FileInputStream(owlPath);
		ontModel.read(in, null);		
	}
	
	public void dumpIndividuals() throws SQLException{
		ResultSet allIndividuals = sparqlQueries.getAllIndividuals();
		while(allIndividuals.next()){
			String s = allIndividuals.getString("s");
			Resource sRsrc = ontModel.createResource(s);
			Property pRsrc = RDF.type;
			
			String c = allIndividuals.getString("class");
			Resource cRsrc = ontModel.createResource(c);
			Statement statement = ontModel.createStatement(sRsrc, pRsrc, cRsrc);
			ontModel.add(statement);
			
			Resource oRsrc = OWL2.NamedIndividual;
			statement = ontModel.createStatement(sRsrc, pRsrc, oRsrc);
			ontModel.add(statement);			
		}
	}
	
	public void dumpObjectProperties() throws SQLException{
		ResultSet allObjectPropertiesOfIndivididuals = sparqlQueries.getAllObjectPropertiesOfIndivididuals();
		while(allObjectPropertiesOfIndivididuals.next()){
			String s = allObjectPropertiesOfIndivididuals.getString("s");
			Resource sRsrc = ontModel.createResource(s);
			String p = allObjectPropertiesOfIndivididuals.getString("p");
			Property pRsrc = ontModel.createProperty(p);
			String o = allObjectPropertiesOfIndivididuals.getString("o");
			
			Resource oRsrc = ontModel.createResource(o);
			Statement statement = ontModel.createStatement(sRsrc, pRsrc, oRsrc);
			
			ontModel.add(statement);
		}
	}
	
	public void dumpDataProperties() throws SQLException{
		HashMap<String, String> rangeHash = new HashMap<String, String>();
		ResultSet ranges = sparqlQueries.getObjectPropertyRanges();
		while(ranges.next()){
			String op = ranges.getString("op");
			String range = ranges.getString("range");
			rangeHash.put(op, range);
		}
		
		ResultSet allDataPropertiesOfIndivididuals = sparqlQueries.getAllDataPropertiesOfIndivididuals();
		while(allDataPropertiesOfIndivididuals.next()){
			String s = allDataPropertiesOfIndivididuals.getString("s");
			Resource sRsrc = ontModel.createResource(s);
			String p = allDataPropertiesOfIndivididuals.getString("p");
			Property pRsrc = ontModel.createProperty(p);
			String o = allDataPropertiesOfIndivididuals.getString("o");
			
//			if(o.contains(" GALDINO DE SOUSA")){
//				System.out.println(o);
//			}
			
			if(p.contains("Elemento_CID.numero")){
				o = o.replace(",", ".");
				double numero = Double.valueOf(o);
				sRsrc.addLiteral(pRsrc, numero);
			}else if(p.contains("Idade.") || p.contains("Idade_Gestacional.") || p.contains("Peso.Gramas")){
				long idade = Long.valueOf(o);
				sRsrc.addLiteral(pRsrc, idade);				
			}else if(rangeHash.containsKey(p)){
				String type = rangeHash.get(p);
				if(type.contains("double")){
					double numero = Double.valueOf(o);
					sRsrc.addLiteral(pRsrc, numero);
				}else if(type.contains("long")){
					long numero = Long.valueOf(o);
					sRsrc.addLiteral(pRsrc, numero);
				}else if(type.contains("integer")){
					Integer numero = Integer.valueOf(o);
					sRsrc.addLiteral(pRsrc, numero);
				}else if(type.contains("datetime")){
					Date data = Date.valueOf(o);
					sRsrc.addLiteral(pRsrc, data);
				}
			}else{
				Literal literal = ontModel.createLiteral(o);
				sRsrc.addLiteral(pRsrc, literal);
			}
			
						
		}
	}
	
	public void dumpLabels() throws SQLException{
		ResultSet allLabelOfIndivididuals = sparqlQueries.getAllLabelOfIndivididuals();
		while(allLabelOfIndivididuals.next()){
			String s = allLabelOfIndivididuals.getString("s");
			Resource sRsrc = ontModel.createResource(s);
			Property pRsrc = ontModel.createProperty("http://www.w3.org/2000/01/rdf-schema#label");
			String o = allLabelOfIndivididuals.getString("o");
			
			Literal literal = ontModel.createLiteral(o);
			sRsrc.addLiteral(pRsrc, literal);
		}
	}
	
	public boolean validateModel(){
		ValidityReport validate = ontModel.validate();
		if(validate.isValid()){
			System.out.println("Modelo válido!");
		}else{
			System.out.println("Modelo INVÁLIDO!");
		}
		return validate.isValid();
	}
	
	public void dump() throws SQLException{
		dumpIndividuals();
		dumpObjectProperties();
		dumpDataProperties();
		dumpLabels();
		
		validateModel();
	}
	
	public OntModel getOntModel() {
		return ontModel;
	}
}
