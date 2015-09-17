package net.menthor.ontouml2sbvr;

import java.util.Map;

import RefOntoUML.Package;
import RefOntoUML.Relator;
import RefOntoUML.DataType;
import RefOntoUML.Derivation;
import RefOntoUML.Classifier;
import RefOntoUML.Association;

/**
 * @author petrux
 * @since 29 July 2014
 */
public interface TreeNavigator {
	
	/**
	 * Build an inner representation for the given {@code roopPackage}
	 * allowing client classes to navigate it.
	 * 
	 * @param rootPackage
	 * @since 29 July 2014
 	 */
	void build(Package rootPackage);
	
	/**
	 * 
	 * @return
	 */
	Iterable<Classifier> getClasses();
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	boolean hasAssociations(Classifier c);
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	Iterable<Association> getAssociations(Classifier c);
	
	/**
	 *
	 * @param c
	 * @return
	 */
	boolean hasSolitaryChildren(Classifier c);
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	Iterable<Classifier> getSolitatyChildren(Classifier c);
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	boolean hasOwnedAssociations(Classifier c);
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	Iterable<Association> getOwnedAssociations(Classifier c);
	
	/**
	 * 
	 * @param r
	 * @return
	 */
	Iterable<Derivation> getDerivation(Relator r);
	
	/**
	 * 
	 * @return
	 */
	Iterable<DataType> getDataTypes();
	
	/**
	 * 
	 * @return
	 */
	Iterable<Map.Entry<String, Classifier>> getAssociationRoles();
}
