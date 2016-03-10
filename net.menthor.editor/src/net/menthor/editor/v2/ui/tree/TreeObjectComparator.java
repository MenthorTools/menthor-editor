package net.menthor.editor.v2.ui.tree;

import java.util.Comparator;

import javax.swing.tree.DefaultMutableTreeNode;

import net.menthor.editor.v2.OclDocument;
import net.menthor.editor.v2.OntoumlDiagram;

@SuppressWarnings("rawtypes")
public class TreeObjectComparator implements Comparator {
	
	private int ensureOrder(Object uo1, Object uo2, java.lang.Class class_){
		if(class_.isInstance(uo1)){
	    	if(!class_.isInstance(uo2)) return -1; //uo1 comes first	    	
	    }
	    if(class_.isInstance(uo2)){
	    	if(!class_.isInstance(uo1)) return +1;	//uo1 comes after    	
	    }
	    return 0;
	}
	
	public int compare(Object o1, Object o2) {
	    if (!(o1 instanceof DefaultMutableTreeNode && o2 instanceof DefaultMutableTreeNode)) {
	      throw new IllegalArgumentException("Can only compare DefaultMutableTreeNode objects");
	    }
	    Object uo1 = ((DefaultMutableTreeNode) o1).getUserObject();
	    Object uo2 = ((DefaultMutableTreeNode) o2).getUserObject();
	    
	    //First: packages
	    int value = ensureOrder(uo1, uo2, RefOntoUML.Package.class);
	    if(value!=0) return value;
	    
	    //Second: diagrams
	    value = ensureOrder(uo1, uo2, OntoumlDiagram.class);
	    if(value!=0) return value;
	    
	    //Third: ocl documents
	    value = ensureOrder(uo1, uo2, OclDocument.class);
	    if(value!=0) return value;
	    
	    //Third: classes
	    value = ensureOrder(uo1, uo2, RefOntoUML.Class.class);
	    if(value!=0) return value;
	    
	    //Third: dataTypes
	    value = ensureOrder(uo1, uo2, RefOntoUML.DataType.class);
	    if(value!=0) return value;
	    
	    //Third: relationships
	    value = ensureOrder(uo1, uo2, RefOntoUML.Relationship.class);
	    if(value!=0) return value;
	    
	    //Third: generalization sets
	    value = ensureOrder(uo1, uo2, RefOntoUML.GeneralizationSet.class);
	    if(value!=0) return value;
	    
	    return uo1.toString().compareToIgnoreCase(uo2.toString());
	}
}
