package net.menthor.ootos.ocl2owl_swrl.factory.uml2.uml;

import net.menthor.common.settings.owl.OwlOptions;
import net.menthor.ootos.ocl2owl_swrl.factory.Factory;
import net.menthor.ootos.util.MappingElements;

import org.eclipse.uml2.uml.Property;

public class PropertyFactory extends Factory{
	Property property;
	
	public PropertyFactory(MappingElements mappingProperties, OwlOptions owlOptions, Property property) {
		super(mappingProperties, owlOptions);
		this.property = property;
	}
}
