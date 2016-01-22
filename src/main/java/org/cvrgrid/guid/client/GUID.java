/* Copyright 2011 Cardiovascular Research Grid
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License. 
 * 
 *	All rights reserved
 * 	
 * 	@author Stephen J Granite (Email: sgranite@jhu.edu)
 */
package org.cvrgrid.guid.client;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import org.cvrgrid.guid.shared.GUIDData;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GUID{
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
		+ "attempting to contact the server. Please check your network "
		+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private HashMap<String,String> studies = new HashMap<String,String>();
	private HashMap<String,String> sites = new HashMap<String,String>();

	/**
	 * The byte[] returned by MessageDigest does not have a nice
	 * textual representation, so some form of encoding is usually performed.
	 *
	 * This implementation follows the example of David Flanagan's book
	 * "Java In A Nutshell", and converts a byte array into a String
	 * of hex characters.
	 *
	 * Another popular alternative is to use a "Base64" encoding.
	 **/
	static public String hexEncode( byte[] aInput){
		StringBuilder result = new StringBuilder();
		char[] digits = {'0', '1', '2', '3', '4','5','6','7','8','9','a','b','c','d','e','f'};
		for ( int idx = 0; idx < aInput.length; ++idx) {
			byte b = aInput[idx];
			result.append( digits[ (b&0xf0) >> 4 ] );
			result.append( digits[ b&0x0f] );
		}
		return result.toString();
	} 

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 **/

	public static String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	}


	/**
	 * @return the studies
	 */
	public HashMap<String,String> getStudies(GUIDData guidData) {
		return (HashMap<String,String>) guidData.getStudies();
	}

	/**
	 * @param GUIDData the studies to set
	 */
	public void setStudies(GUIDData guidData, HashMap<String,String> studies) {
		guidData.setStudies(studies);
	}

	/**
	 * @return the sites
	 */
	public HashMap<String,String> getSites(GUIDData guidData) {
		return (HashMap<String,String>) guidData.getSites();
	}

	/**
	 * @param GUIDData the studies to set
	 */
	public void setSites(GUIDData guidData, HashMap<String,String> sites) {
		guidData.setSites(sites);
	}



}
