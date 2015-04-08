package net.menthor.editor.validator.antipattern;

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

import net.menthor.antipattern.AntipatternOccurrence;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

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
