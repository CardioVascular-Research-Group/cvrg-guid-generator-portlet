package com.jhu.cvrg.guid.utility;

/*
Copyright 2011 Johns Hopkins University Institute for Computational Medicine

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
/**
* @author Chris Jurado
* 
*/
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.portlet.PortletRequest;

import org.portletfaces.liferay.faces.context.LiferayFacesContext;
import org.portletfaces.liferay.faces.helper.LongHelper;

import com.jhu.cvrg.portal.guidgenerator.model.Site;
import com.jhu.cvrg.portal.guidgenerator.model.Study;
import com.jhu.cvrg.portal.guidgenerator.model.StudySite;
import com.jhu.cvrg.portal.guidgenerator.model.SubjectHash;
import com.jhu.cvrg.portal.guidgenerator.service.SiteLocalServiceUtil;
import com.jhu.cvrg.portal.guidgenerator.service.StudyLocalServiceUtil;
import com.jhu.cvrg.portal.guidgenerator.service.StudySiteLocalServiceUtil;
import com.jhu.cvrg.portal.guidgenerator.service.SubjectHashLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

public class ResourceUtility {

	private final static LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
	private final static int ALL = com.liferay.portal.kernel.dao.orm.QueryUtil.ALL_POS;
	
	public static void printErrorMessage(String source){
		System.err.println("*************************** Error in " + source + " ******************************");
	}
	
	public static ArrayList<SelectItem> getSitesItemsByStudyId(long studyId){
		ArrayList<SelectItem> siteList = new ArrayList<SelectItem>();
		for(Site site : getSitesByStudyId(studyId)){
			siteList.add(new SelectItem(site.getSiteId(), site.getSiteName()));
		}
		
		return siteList;
	}
	
	public static ArrayList<SelectItem> getAllSitesItems(){
		ArrayList<SelectItem> siteList = new ArrayList<SelectItem>();
		
		for(Site site : getSites()){
			siteList.add(new SelectItem(site.getSiteId(), site.getSiteName()));
		}
		
		return siteList;
	}
	
	public static ArrayList<SelectItem> getAllStudyItems(){
		
		ArrayList<SelectItem> studyList = new ArrayList<SelectItem>();
		
		for(Study study : getStudies()){
			studyList.add(new SelectItem(study.getStudyId(), study.getStudyName()));
		}
		
		return studyList;
	}
	
	public static ArrayList<SelectItem> getCurrentLinks(){
		ArrayList<SelectItem> links = new ArrayList<SelectItem>();
		List<StudySite> linksList = null;
		String studyText, siteText, linkText = "";
		int i = 0;
		
		try {
			linksList = StudySiteLocalServiceUtil.getStudySites(ALL, ALL);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(linksList == null){
			return null;
		}
		
		for(StudySite linkItem : linksList){
			studyText = getStudyAcronym(String.valueOf(linkItem.getStudyId()));
			siteText = getSiteAcronym(String.valueOf(linkItem.getSiteId()));
			linkText = siteText + " --> " + studyText;
			
			links.add(new SelectItem(i, linkText));
			i++;
		}
		
		return links;
	}
	
	public static String getSiteAcronym(String strSiteId){
		long siteId = Long.valueOf(strSiteId);
		Site site = null;
		try {
			site = SiteLocalServiceUtil.getSite(siteId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(site != null)
			return site.getSiteAcronym();
		else return "";
	}
	
	public static String getSiteAcronym(long siteId){
		Site site = null;
		try {
			site = SiteLocalServiceUtil.getSite(siteId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(site != null)
			return site.getSiteAcronym();
		else return "";
	}
	
	public static String getStudyAcronym(String strStudyId){
		long studyId = Long.valueOf(strStudyId);
		Study study = null;
		try {
			study = StudyLocalServiceUtil.getStudy(studyId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(study != null)
			return study.getStudyAcronym();
		else return "";
	}
	
	public static String getStudyAcronym(long studyId){
		Study study = null;
		try {
			study = StudyLocalServiceUtil.getStudy(studyId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(study != null)
			return study.getStudyAcronym();
		else return "";
	}
	
	public static long getSiteIdByAcronym(String siteAcronym){
		long siteId = 0L;
		try {
			for(Site site : SiteLocalServiceUtil.getSites(ALL, ALL)){
				if(site.getSiteAcronym().equals(siteAcronym)){
					siteId = site.getSiteId();
				}
			}
		} catch (SystemException e) {
			printErrorMessage("ResourceUtility.getSiteIdByAcronym");
			e.printStackTrace();
		}
		
		return siteId;
	}
	
	public static long getStudyIdByAcronym(String studyAcronym){
		long studyId = 0L;
		try {
			for(Study study : StudyLocalServiceUtil.getStudies(ALL, ALL)){
				if(study.getStudyAcronym().equals(studyAcronym)){
					studyId = study.getStudyId();
				}
			}
		} catch (SystemException e) {
			printErrorMessage("ResourceUtility.getStudyIdByAcronym");
			e.printStackTrace();
		}
		
		return studyId;
	}
	
	public static List<Site> getSites(){
		
		List<Site> sites = null;
		try {
			sites = SiteLocalServiceUtil.getSites(ALL, ALL);
		} catch (SystemException e) {
			printErrorMessage("ResourceUtility.getSites");
			e.printStackTrace();
		}
		
		return sites;
	}
	
	public static List<Site> getSitesByStudyId(long studyId){
		List<StudySite> links = null;
		List<Site> sites = new ArrayList<Site>();
		try {
			links = StudySiteLocalServiceUtil.getStudySites(ALL, ALL);
			for(StudySite link : links){
				if(link.getStudyId() == studyId){
					sites.add(SiteLocalServiceUtil.getSite(link.getSiteId()));
				}
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sites;
	}
	
	public static List<Study> getStudies(){

		List<Study> studies = null;
		try {
			studies = StudyLocalServiceUtil.getStudies(ALL, ALL);
		} catch (SystemException e) {
			printErrorMessage("ResourceUtility.getStudies");
			e.printStackTrace();
		}
		
		return studies;
	}
	
	public static void addLink(long siteId, long studyId){
		try {
			StudySiteLocalServiceUtil.addStudySite(studyId, siteId, 0);
		} catch (PortalException e) {
			printErrorMessage("ResourceUtility.addLink");
			e.printStackTrace();
		} catch (SystemException e) {
			printErrorMessage("ResourceUtility.addLink");
			e.printStackTrace();
		}
	}
	
	public static void addStudy(String name, String acronym){
		try {
			StudyLocalServiceUtil.addStudy(name, acronym);
		} catch (PortalException e) {
			printErrorMessage("ResourceUtility.addStudy");
			e.printStackTrace();
		} catch (SystemException e) {
			printErrorMessage("ResourceUtility.addStudy");
			e.printStackTrace();
		}
	}
	
	public static void addSite(String name, String acronym){
		try {
			SiteLocalServiceUtil.addSite(name, acronym);
		} catch (PortalException e) {
			printErrorMessage("ResourceUtility.addSite");
			e.printStackTrace();
		} catch (SystemException e) {
			printErrorMessage("ResourceUtility.addSite");
			e.printStackTrace();
		}
	}
	
	public static long getIdParameter(String param){
		return LongHelper.toLong(liferayFacesContext.getExternalContext().getRequestParameterMap().get(param), 0L);
	}
	
	public static User getUser(long userId){
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(userId);

		} catch (PortalException e) {
			printErrorMessage("Resource Utility");
			e.printStackTrace();
		} catch (SystemException e) {
			printErrorMessage("Resource Utility");
			e.printStackTrace();
		}
		return user;
	}
	
	public static long getCurrentGroupId(){
		
		PortletRequest request = (PortletRequest) liferayFacesContext.getExternalContext().getRequest();	
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		
		return themeDisplay.getLayout().getGroupId();	
	}
	
	public static User getCurrentUser(){
		
		User currentUser = null;
		try {
			currentUser = UserLocalServiceUtil.getUser(Long.parseLong(liferayFacesContext.getPortletRequest().getRemoteUser()));
		} catch (NumberFormatException e) {
			printErrorMessage("Resource Utility");
			e.printStackTrace();
		} catch (PortalException e) {
			printErrorMessage("Resource Utility");
			e.printStackTrace();
		} catch (SystemException e) {
			printErrorMessage("Resource Utility");
			e.printStackTrace();
		}
		return currentUser;
	}
	
	public static long getGroupId(String communityName){
		long groupId = 0L;
		List<Group> groupList;
		try {
			groupList = GroupLocalServiceUtil.getGroups(ALL, ALL);
			for(Group group : groupList){
				if(group.getName().equals(communityName)){
					groupId = group.getGroupId();
				}
			}
		} catch (SystemException e) {
			printErrorMessage("Resource Utility");
			e.printStackTrace();
		}

		return groupId;
	}
	
	public static String convertToUserName(long userId){
		String userFullName = "";
		
		try {
			User user = UserLocalServiceUtil.getUser(userId);
			userFullName = user.getFullName();
		} catch (PortalException e) {
			printErrorMessage("Resource Utility");
			e.printStackTrace();
		} catch (SystemException e) {
			printErrorMessage("Resource Utility");
			e.printStackTrace();
		}
		
		return userFullName;
	}


}
