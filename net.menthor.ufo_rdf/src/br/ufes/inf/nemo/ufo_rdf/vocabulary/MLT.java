package br.ufes.inf.nemo.ufo_rdf.vocabulary;

import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;

public class MLT {
	public final static String NS = "http://www.nemo.inf.ufes.br/mlt" + "#";
	public final static String prefix = "mlt";

    public static String getURI(){ 
    	return NS; 
    }
    
    public static String getPrefix() {
		return prefix;
	}
    
    protected final static Resource resource( String local ){ 
    	return ResourceFactory.createResource( NS + local ); 
    }
    
    protected final static Property property( String local ){ 
    	return ResourceFactory.createProperty( NS + local ); 
    }

    public final static Resource Individual = resource( "Individual" );
    
    public final static Resource _1stOT = resource( "1stOT" );
    
    public final static Resource _2ndOT = resource( "2ndOT" );

    public final static Property powertypeOf = property( "powertypeOf" );
    
}
