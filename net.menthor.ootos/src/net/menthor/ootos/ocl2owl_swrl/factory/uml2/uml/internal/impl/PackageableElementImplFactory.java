package net.menthor.ootos.ocl2owl_swrl.factory.uml2.uml.internal.impl;

import net.menthor.common.transformation.TransformationOption;
import net.menthor.ootos.util.MappingProperties;

import org.eclipse.uml2.uml.internal.impl.NamedElementImpl;



/**
 * @author fredd_000
 * @version 1.0
 * @created 24-set-2013 09:16:13
 */
public class PackageableElementImplFactory extends NamedElementImplFactory {

	public PackageableElementImplFactory(MappingProperties mappingProperties, TransformationOption owlOptions, NamedElementImpl m_NamedElementImpl){
		super(mappingProperties, owlOptions, m_NamedElementImpl);
	}

}