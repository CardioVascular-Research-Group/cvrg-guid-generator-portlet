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
package org.cvrgrid.guid.shared;

import java.util.HashMap;
import java.util.Map;

public class GUIDData{

	private Map<String,String> studies;
	private Map<String,String> sites;
	private Map<String,String> sitesForStudy;

	public GUIDData(){

		setStudies(new HashMap<String,String>());
		setSites(new HashMap<String,String>());
		setSitesForStudy(new HashMap<String,String>());

	}

	/**
	 * @return the studies
	 */
	public Map<String, String> getStudies() {
		return studies;
	}

	/**
	 * @param studies the studies to set
	 */
	public void setStudies(Map<String, String> studies) {
		this.studies = studies;
	}

	/**
	 * @return the sites
	 */
	public Map<String, String> getSites() {
		return sites;
	}

	/**
	 * @param sites the sites to set
	 */
	public void setSites(Map<String, String> sites) {
		this.sites = sites;
	}

	/**
	 * @return the sitesForStudy
	 */
	public Map<String, String> getSitesForStudy() {
		return sitesForStudy;
	}

	/**
	 * @param sitesForStudy the sitesForStudy to set
	 */
	public void setSitesForStudy(Map<String, String> sitesForStudy) {
		this.sitesForStudy = sitesForStudy;
	}

}