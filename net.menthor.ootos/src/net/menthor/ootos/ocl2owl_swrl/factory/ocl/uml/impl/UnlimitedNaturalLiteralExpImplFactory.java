package net.menthor.ootos.ocl2owl_swrl.factory.ocl.uml.impl;

import net.menthor.common.transformation.TransformationOption;
import net.menthor.ootos.util.MappingProperties;

import org.eclipse.uml2.uml.internal.impl.NamedElementImpl;

/**
 * @author Freddy Brasileiro Silva {freddybrasileiro@gmail.com}
 */
public class UnlimitedNaturalLiteralExpImplFactory extends NumericLiteralExpImplFactory {

	public UnlimitedNaturalLiteralExpImplFactory(MappingProperties mappingProperties, TransformationOption owlOptions, NamedElementImpl m_NamedElementImpl){
		super(mappingProperties, owlOptions, m_NamedElementImpl);
	}
}