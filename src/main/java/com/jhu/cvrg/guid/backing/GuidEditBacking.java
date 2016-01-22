package com.jhu.cvrg.guid.backing;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.jhu.cvrg.guid.utility.ResourceUtility;
import com.jhu.cvrg.portal.guid.model.Link;

@ManagedBean(name = "guidEditBacking")
@ViewScoped
public class GuidEditBacking {


	private String currentSite, currentStudy;
	private String selectedSite, selectedStudy;
	private String newname, newacronym;
	private boolean updatecomplete;
	private int siteorstudy;
	private ArrayList<SelectItem> currentLinks;
	private ArrayList<Link> newLinks;
	private String siteItemLink, studyItemLink;
	private ArrayList<SelectItem> siteList, studyList;
	
	private FacesContext facesContext;
	
	public GuidEditBacking(){
		currentLinks = ResourceUtility.getCurrentLinks();
		setSiteorstudy(1);
		setUpdatecomplete(false);
		refresh();
	}
	
	private void refresh(){
		siteList = ResourceUtility.getAllSitesItems();
		studyList = ResourceUtility.getAllStudyItems();
	}
		
	public void add(ActionEvent event){
		if(siteorstudy == 1){
			ResourceUtility.addStudy(newname, newacronym);	
		}
		else{
			ResourceUtility.addSite(newname, newacronym);
		}
		
		newname = "";
		newacronym = "";
		refresh();
	}
	
	private void addNewLink(){
		Link newLink = new Link(Long.valueOf(selectedSite), Long.valueOf(selectedStudy));
		if(newLinks == null){
			newLinks = new ArrayList<Link>();
		}
		
		newLinks.add(newLink);
	}
	
	public void link(ActionEvent event){

		int newIndex = currentLinks.size();
		String newLink = ResourceUtility.getSiteAcronym(selectedSite) + " --> " + ResourceUtility.getStudyAcronym(selectedStudy);
		SelectItem newLinkItem = new SelectItem(newIndex, newLink);

		currentLinks.add(newLinkItem);
		addNewLink();
	}
	
	public void commit(ActionEvent event){
		if(newLinks.size() == 0){
			return;
		}
		for(Link link : newLinks){
			ResourceUtility.addLink(link.getSiteId(), link.getStudyId());
		}
		setUpdatecomplete(true);
	}

	public void setSiteorstudy(int siteorstudy) {
		this.siteorstudy = siteorstudy;
	}

	public int getSiteorstudy() {
		return siteorstudy;
	}

	public void setNewname(String newname) {
		this.newname = newname;
	}

	public String getNewname() {
		return newname;
	}

	public void setNewacronym(String newacronym) {
		this.newacronym = newacronym;
	}

	public String getNewacronym() {
		return newacronym;
	}

	public ArrayList<SelectItem> getCurrentLinks() {
		return currentLinks;
	}

	public void setCurrentLinks(ArrayList<SelectItem> currentLinks) {
		this.currentLinks = currentLinks;
	}

	public String getSiteItemLink() {
		return siteItemLink;
	}

	public void setSiteItemLink(String siteItemLink) {
		this.siteItemLink = siteItemLink;
	}

	public String getStudyItemLink() {
		return studyItemLink;
	}

	public void setStudyItemLink(String studyItemLink) {
		this.studyItemLink = studyItemLink;
	}

	public void setUpdatecomplete(boolean updatecomplete) {
		this.updatecomplete = updatecomplete;
	}

	public boolean isUpdatecomplete() {
		return updatecomplete;
	}

	public FacesContext getFacesContext() {
		return facesContext;
	}

	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	public String getSelectedSite() {
		return selectedSite;
	}

	public void setSelectedSite(String selectedSite) {
		this.selectedSite = selectedSite;
	}

	public String getSelectedStudy() {
		return selectedStudy;
	}

	public void setSelectedStudy(String selectedStudy) {
		this.selectedStudy = selectedStudy;
	}

	public void setCurrentSite(String currentSite) {
		this.currentSite = currentSite;
	}

	public String getCurrentSite() {
		return currentSite;
	}

	public void setCurrentStudy(String currentStudy) {
		this.currentStudy = currentStudy;
	}

	public String getCurrentStudy() {
		return currentStudy;
	}

	public void setStudyList(ArrayList<SelectItem> studyList) {
		this.studyList = studyList;
	}

	public ArrayList<SelectItem> getStudyList() {
		return studyList;
	}

	public void setSiteList(ArrayList<SelectItem> siteList) {
		this.siteList = siteList;
	}

	public ArrayList<SelectItem> getSiteList() {
		return siteList;
	}


	
}
