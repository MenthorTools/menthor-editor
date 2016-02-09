package net.menthor.editor.v2.ui.antipattern;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import net.menthor.antipattern.AntipatternOccurrence;

/**
 * @author Tiago Sales
 * @author John Guerson
 *
 */

public class AntipatternResultFilter extends ViewerFilter {

	private String searchString;
	
	public void setSearchText(String s) 
	{     
		this.searchString = ".*" + s + ".*"; // ensure that the value can be used for matching
	}
	
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) 
	{
	  if (searchString == null || searchString.length() == 0) return true;
	  
	  AntipatternOccurrence occurrence = (AntipatternOccurrence) element;
	  
	  if (occurrence.getShortName().matches(searchString)) return true;
	  
//	  if (occurrence.getAntiPatternType().getAntipatternInfo().getAcronym().matches(searchString)) {
//	    return true;
//	  }
	  
	   return false;
	}
}
