package net.menthor.editor.v2.ui.tree;

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

public class TreeVisibility {

	private boolean hideClasses=false;
	private boolean hideDataTypes=false;
	private boolean hideAssociations=false;
	private boolean hideGeneralizationSets=false;
	
	private boolean hideComments=false;
	private boolean hideConstraints=false;
	private boolean hideAttributes=false;
	private boolean hideEnds=false;
	private boolean hideProperties=false;
	private boolean hideGeneralizations=false;
	private boolean hideLiteral=false;
	
	public void showOnlyPackageable(){			
		hideClasses=false;
		hideDataTypes=false;
		hideAssociations=false;
		hideGeneralizationSets=false;
		hideComments=true;
		hideConstraints=true;
		hideAttributes=true;
		hideEnds=true;
		hideProperties=true;
		hideGeneralizations=true;
		hideLiteral=true;
	}
	
	public void hideAll(){ 
		hideClasses=true;
		hideDataTypes=true;
		hideAssociations=true;
		hideGeneralizationSets=true;
		hideComments=true;
		hideConstraints=true;
		hideAttributes=true;
		hideEnds=true;
		hideProperties=true;
		hideGeneralizations=true;
		hideLiteral=true;
	}
	
	public void showAll(){ 
		hideClasses=false;
		hideDataTypes=false;
		hideAssociations=false;
		hideGeneralizationSets=false;
		hideComments=false;
		hideConstraints=false;
		hideAttributes=false;
		hideEnds=false;
		hideProperties=false;
		hideGeneralizations=false;
		hideLiteral=false;
	}
	
	public boolean isHiddenGeneralizations() { return hideGeneralizations; }
	public boolean isHiddenGeneralizationSets() { return hideGeneralizationSets; }
	public boolean isHiddenComments() { return hideComments; }
	public boolean isHiddenConstraints() { return hideConstraints; }
	public boolean isHiddenProperties() { return hideProperties; }
	public boolean isHiddenEnds() { return hideEnds; }
	public boolean isHiddenAttributes() { return hideAttributes; }
	public boolean isHiddenAssociations() { return hideAssociations; }
	public boolean isHiddenDataTypes() { return hideDataTypes; }
	public boolean isHiddenClasses() { return hideClasses; }
	public boolean isHiddenLiterals() { return hideLiteral; }
	
	public void hideGeneralizationSets() { hideGeneralizationSets=true; }
	public void hideComments() { hideComments=true; }
	public void hideConstraints() { hideConstraints=true; }
	public void hideClasses() { hideClasses=true; }
	public void hideDataTypes() { hideDataTypes=true; }
	public void hideAssociations() { hideAssociations=true; }
	public void hideAttributes() { hideAttributes=true; }
	public void hideEnds() { hideEnds=true; }
	public void hideProperties() { hideProperties=true; }
	public void hideGeneralizations() { hideGeneralizations=true; }
	public void hideLiterals() { hideLiteral=true; }
	
	public void showGeneralizationSets() { hideGeneralizationSets=false; }
	public void showComments() { hideComments=false; }
	public void showConstraints() { hideConstraints=false; }
	public void showClasses() { hideClasses=false; }
	public void showDataTypes() { hideDataTypes=false; }
	public void showAssociations() { hideAssociations=false; }
	public void showAttributes() { hideAttributes=false; }
	public void showEnds() { hideEnds=false; }
	public void showProperties() { hideProperties=false; }
	public void showGeneralizations() { hideGeneralizations=false; }
	public void showLiteral() { hideLiteral=false; }
	
}
