package org.miketar.exercises.business;

/**
 * Utils class for markup calculator 
 * 
 * @author mickaeltardy
 *
 */
public class Utils {

	/**
	 * Checking if the string is not null nor empty 
	 * @param value string to check
	 * @return true is not empty, false otherwise
	 */
	public boolean isNotEmpty(String value){
		return value != null && value.compareTo("") != 0;
	}
	
}
