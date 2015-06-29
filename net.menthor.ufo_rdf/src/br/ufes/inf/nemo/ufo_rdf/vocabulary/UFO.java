package br.ufes.inf.nemo.ufo_rdf.vocabulary;

import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;

public class UFO {
	public final static String NS = "http://www.nemo.inf.ufes.br/ufo" + "#";
	public final static String prefix = "ufo";
	
    public static String getURI(){ 
    	return NS; 
    }
    
    public static String getPrefix() {
		return prefix;
	}
    
    public static Resource resource( String local ){ 
    	return ResourceFactory.createResource( NS + local ); 
    }
    
    public final static Property property( String local ){ 
    	return ResourceFactory.createProperty( NS + local ); 
    }

    public final static Resource AntiRigidMixin = resource( "AntiRigidMixin" );
    
    public final static Resource NonSortalUniversal = resource( "NonSortalUniversal" );
    
    public final static Resource AntiRigidSortal = resource( "AntiRigidSortal" );

    public final static Resource SortalUniversal = resource( "SortalUniversal" );

    public final static Resource Category = resource( "Category" );

    public final static Resource RigidMixin = resource( "RigidMixin" );

    public final static Resource Collective = resource( "Collective" );

    public final static Resource Substantial = resource( "Substantial" );

    public final static Resource CollectiveUniversal = resource( "CollectiveUniversal" );

    public final static Resource SubstanceSortal = resource( "SubstanceSortal" );

    public final static Resource Endurant = resource( "Endurant" );
	
    public final static Resource EndurantUniversal = resource( "EndurantUniversal" );
	
    public final static Resource FunctionalComplex = resource( "FunctionalComplex" );
	
    public final static Resource IntrinsicMoment = resource( "IntrinsicMoment" );
	
    public final static Resource Moment = resource( "Moment" );
	
    public final static Resource IntrinsicMomentUniversal = resource( "IntrinsicMomentUniversal" );
	
    public final static Resource MomentUniversal = resource( "MomentUniversal" );
	
    public final static Resource Kind = resource( "Kind" );
	
    public final static Resource Mixin = resource( "Mixin" );
	
    public final static Resource SemiRigidmixin = resource( "SemiRigidmixin" );
	
    public final static Resource SubstantialUniversal = resource( "SubstantialUniversal" );
	
    public final static Resource Phase = resource( "Phase" );
	
    public final static Resource Relator = resource( "Relator" );
	
    public final static Resource RelatorUniversal = resource( "RelatorUniversal" );
	
    public final static Resource RigidSortal = resource( "RigidSortal" );
	
    public final static Resource Role = resource( "Role" );
	
    public final static Resource RoleMixin = resource( "RoleMixin" );
	
    public final static Resource Subkind = resource( "Subkind" );
    
    public final static Property componentOf = property( "componentOf" );
}


