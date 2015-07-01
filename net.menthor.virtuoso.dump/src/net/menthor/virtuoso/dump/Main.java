package net.menthor.virtuoso.dump;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.Normalizer;

import javax.sql.DataSource;

import net.menthor.virtuoso.connection.ConnectionFactory;
import virtuoso.jena.driver.VirtGraph;
import virtuoso.jena.driver.VirtModel;
import virtuoso.jena.driver.VirtuosoUpdateFactory;
import virtuoso.jena.driver.VirtuosoUpdateRequest;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.shared.JenaException;

public class Main {

	public static void main(String[] args) throws Exception  {
		String owlPath = "C:\\Users\\fredd_000\\Google Drive\\GI2S\\GI2S - Freddy - John - Tiago - Bernardo\\Modelos\\OWL\\GI2S_ontologia-cortada.owl";
		
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter with .owl path:");
		System.out.println("E.g.: C:\\...\\your-file.owl");
//		owlPath = bufferRead.readLine();
		System.out.println("Arquivo escolhido:");
		System.out.println(owlPath);
		DumpIndividuals dump = new DumpIndividuals(owlPath);
		dump.dump();
		
		owlPath = owlPath.replace(".owl", "-populada.owl");
		saveRdf(dump.getOntModel(), owlPath);
        
        System.out.println("done");
	}
	
	public static void saveRdf(OntModel ontModel, String rdfName) throws UnsupportedEncodingException{
		System.out.println("Saving RDF");
		String syntax = "RDF/XML-ABBREV";
//		StringWriter out = new StringWriter();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
//		ByteArrayOutputStream out = new ByteArrayOutputStream();		
//		ontModel.write
		ontModel.write(out, syntax);
		String result = new String(out.toByteArray(), "UTF-8");
		result = Normalizer.normalize(result, Normalizer.Form.NFD);
		result = result.replaceAll("[^\\p{ASCII}]", "");
		File arquivo = new File(rdfName);  
		if(arquivo.exists()){
			arquivo.delete();
		}
		try{
			FileOutputStream fos = new FileOutputStream(arquivo);    
			fos.write(result.getBytes());    
			fos.close();   
		}catch(Exception e){
			e.printStackTrace();
		}		
		System.out.println("A new .owl file was generated.");
		System.out.println(rdfName);
	}
	
	public static VirtModel getNamedModel(VirtGraph vd, String name){
		try {
        	DataSource _ds = vd.getDataSource();
			if (_ds != null)
				return new VirtModel(new VirtGraph(name, _ds));
			else
				return new VirtModel(new VirtGraph(name, vd.getGraphUrl(),
						vd.getGraphUser(), vd.getGraphPassword()));
		} catch (Exception e) {
			throw new JenaException(e);
		}
	}
	
	public static void deleteRepository(String ontologyUri){
		/*			STEP 1			*/
		VirtGraph set = new VirtGraph (ConnectionFactory.getVirtuosourl(), "dba", "dba");

		/*			STEP 2			*/
		//System.out.println("\nexecute: CLEAR GRAPH <http://test1>");
        String str = "CLEAR GRAPH <" + ontologyUri + ">";
        VirtuosoUpdateRequest vur = VirtuosoUpdateFactory.create(str, set);
        vur.exec();     
	}	
}