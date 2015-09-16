package net.menthor.ootos.ocl2owl_swrl.factory.ocl.uml.impl;

import net.menthor.common.settings.owl.OwlOptions;
import net.menthor.ootos.util.MappingElements;

import org.eclipse.uml2.uml.internal.impl.NamedElementImpl;

/**
 * @author Freddy Brasileiro Silva {freddybrasileiro@gmail.com}
 */
public class LoopExpImplFactory extends CallExpImplFactory {
	public OCLExpressionImplFactory bodyFactory;
	
	public LoopExpImplFactory(MappingElements mappingProperties, OwlOptions owlOptions, NamedElementImpl m_NamedElementImpl){
		super(mappingProperties, owlOptions, m_NamedElementImpl);
	}
}