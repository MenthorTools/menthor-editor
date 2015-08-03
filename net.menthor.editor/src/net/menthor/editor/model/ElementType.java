package net.menthor.editor.model;

/**
 * ============================================================================================
 * Menthor Editor -- Copyright (c) 2015 
 *
 * This file is part of Menthor Editor. Menthor Editor is based on TinyUML and as so it is 
 * distributed under the same license terms.
 *
 * Menthor Editor is free software; you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation; either 
 * version 2 of the License, or (at your option) any later version.
 *
 * Menthor Editor is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Menthor Editor; 
 * if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, 
 * MA  02110-1301  USA
 * ============================================================================================
 */

public enum ElementType {

	/** classes */
	KIND, QUANTITY, COLLECTIVE, SUBKIND, PHASE, ROLE, 
	CATEGORY, ROLEMIXIN, MIXIN, MODE, RELATOR, DATATYPE, NOTE, PACKAGE, GENERALIZATIONSET, 
	COMMENT, CONSTRAINT, 
	
	/** datatypes */
	ENUMERATION, PRIMITIVETYPE, PERCEIVABLEQUALITY, NONPERCEIVABLEQUALITY, NOMINALQUALITY,
	
	/** derived patterns */
	UNION, EXCLUSION, INTERSECTION, SPECIALIZATION, PASTSPECIALIZATION, PARTICIPATION,
	
	/** patterns */
	GENERALIZATIONSPECIALIZATION, PARTITIONPATTERN, ADDSUPERTYPE, ADDSUBTYPE,
	PATTERN_MIXIN_PATTERN, PATTERN_MIXIN_PATTERN_WITH_SUBKIND,PATTERN_PHASE_PARTITION, PATTERN_SUBKIND_PARTITION, PATTERN_ROLE_PARTITION, 
	PATTERN_SUBSTANCE_SORTAL_PARTITION, PATTERN_ROLEMIXIN, PATTERN_RELATOR, PATTERN_COMPLETER, PATTERN_PRINCIPLE_IDENTITY,
	DEPENDENT_ROLEMIXIN, GENERIC_RELATOR,CHARACTERIZATION_PATTERN,RIGID_WEAK_SUPPLEMENTATION,ANTIRIGID_WEAK_SUPPLEMENTATION,KIND_PARTITION, 
	COLLECTIVE_PARTITION, QUANTITY_PARTITION, CATEGORY_PATTERN,
	
	/** domain patterns */
	DOMAIN_PATTERN
}
