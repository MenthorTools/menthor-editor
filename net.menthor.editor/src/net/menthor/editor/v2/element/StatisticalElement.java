package net.menthor.editor.v2.element;

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

import net.menthor.common.ontoumlparser.OntoUMLModelStatistic.TypeDetail;

public class StatisticalElement {
	
	protected String measure;
	protected int count;	
	protected String typePercentage;
	protected String allPercentage;
	
	public StatisticalElement(String measure, int count, String typePercentage, String allPercentage){
		this.measure = measure;
		this.count = count;
		this.typePercentage = typePercentage;
		this.allPercentage = allPercentage;
	}
	
	public StatisticalElement(TypeDetail detail){
		this.measure = detail.getMeasure();
		this.count = detail.getCount();
		this.typePercentage = detail.getTypePercentage();
		this.allPercentage = detail.getAllPercentage();
	}
	
	public String getMeasure() { return measure; }
	public int getCount() { return count; }	
	public String getAllPercentage(){ return allPercentage; }
	public String getTypePercentage(){ return typePercentage; }	
	public double getAllPercentageValue(){ return Double.parseDouble(allPercentage.replace("%","").replace(",",".")); } 
	public double getTypePercentageValue(){ return Double.parseDouble(typePercentage.replace("%","").replace(",",".")); }
}
