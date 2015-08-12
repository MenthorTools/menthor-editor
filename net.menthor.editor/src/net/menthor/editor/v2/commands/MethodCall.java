package net.menthor.editor.v2.commands;

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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements a method call by reflection. It is used to implement
 * pluggable selectors.
 */
public class MethodCall {

  private Method method;
  private List<Object> earlyParameters = new ArrayList<Object>();
  private List<Object> lateParameters = new ArrayList<Object>();
  
  public MethodCall(final Method theMethod, final Object... parameters){
    method = theMethod;
    earlyParameters.clear();
    for (int i = 0; i < parameters.length; i++) {
    	earlyParameters.add(parameters[i]);
    }
  }

  public String toString(){
	  String result = new String();
	  result+=""+getMethod()+"";			
	  if(earlyParameters.size()>0||lateParameters.size()>0) result+="\n"+parametersAsString()+"";
	  return result;
  }
  
  public String parametersAsString() {
      String result = new String();
      for(Object obj: earlyParameters){
    	  result += "Parameter:'"+obj+"';";
      }
      for(Object obj: lateParameters){
    	  result += "Parameter:'"+obj+"';";
      }
      return result;
  }
  
  public Method getMethod() { return method; }
 
  public void set(final Object parameter){  
	  lateParameters.clear();
	  lateParameters.add(parameter);	  
  }
  
  public void call(Object target){
	  List<Object> parameters = new ArrayList<Object>();
	  parameters.addAll(earlyParameters);
	  parameters.addAll(lateParameters);
    try {
      method.invoke(target, parameters.toArray());
    } catch (InvocationTargetException ex) {
      ex.printStackTrace();
    } catch (IllegalAccessException ex) {
      ex.printStackTrace();
    }
  }
}
