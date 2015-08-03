package net.menthor.ootos.ocl2owl_swrl.factory.uml2.uml;

import net.menthor.ootos.ocl2owl_swrl.factory.Factory;
import net.menthor.ootos.util.MappingProperties;

import org.eclipse.uml2.uml.Property;

public class PropertyFactory extends Factory{
	Property property;
	
	public PropertyFactory(MappingProperties mappingProperties, Property property) {
		super(mappingProperties);
		this.property = property;
	}
}
