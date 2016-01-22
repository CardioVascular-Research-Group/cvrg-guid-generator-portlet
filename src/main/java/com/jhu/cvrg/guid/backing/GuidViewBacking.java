package com.jhu.cvrg.guid.backing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.cvrgrid.guid.client.GUID;

import com.jhu.cvrg.guid.utility.ResourceUtility;
import com.jhu.cvrg.portal.guidgenerator.model.SubjectHash;
import com.jhu.cvrg.portal.guidgenerator.service.SubjectHashLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean(name = "guidViewBacking")
@ViewScoped
public class GuidViewBacking {
	
	private boolean gotGuid;
	private String selectedStudy, selectedSite;
	private String lastname, firstname, middlename, gender, dob, maidenname;
	private String guid, acrostic;
	private ArrayList<SelectItem> siteList, studyList;
	
	public GuidViewBacking(){
		setDob("mm/dd/yyyy");
		setGotGuid(false);
		studyList = ResourceUtility.getAllStudyItems();
	}
	
	private void updateSiteList(){
		siteList = ResourceUtility.getSitesItemsByStudyId(Long.valueOf(selectedStudy));
	}
	
	public void generate(ActionEvent event){

		SubjectHash subjectHash = null;
		String input = firstname + middlename + lastname + dob + gender + maidenname;
		input = input.toUpperCase();
		String hash = null; 
		String acrosticValue = "";

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			byte[] result =  sha.digest(input.getBytes());
			System.out.println("Message digest: " + GUID.hexEncode(result));
			hash = GUID.hexEncode(result);
			hash = GUID.escapeHtml(hash);
		}
		catch ( NoSuchAlgorithmException ex ) {
			System.out.println(ex);
		}

		try{
			if(SubjectHashLocalServiceUtil.findSubjectHashByValue(hash) != null && 
					!SubjectHashLocalServiceUtil.findSubjectHashByValue(hash).isEmpty()){
					subjectHash = (SubjectHash)SubjectHashLocalServiceUtil.findSubjectHashByValue(hash).get(0);
			}else{
				subjectHash = SubjectHashLocalServiceUtil.addsubjectHash(hash);
				System.out.println("subjectHash is null:" + String.valueOf(subjectHash == null));
			}
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(subjectHash != null){
			acrosticValue = buildAcrostic(subjectHash);
			setAcrostic(acrosticValue);
		}
			
		setGuid(hash);
		gotGuid = true;
		
	}
	
	private String buildAcrostic(SubjectHash subjectHash){
		
		long subjectId = subjectHash.getSubjectHashId();
		String newAcrostic = "";
		String rawId = String.format("%09d", subjectId);

		newAcrostic = ResourceUtility.getStudyAcronym(selectedStudy) + " " + 
						ResourceUtility.getSiteAcronym(selectedSite) + " " + rawId;
		
		return newAcrostic;		
	}

	
	public void selectedStudyChanged(ValueChangeEvent event){
		if (event.getPhaseId().equals(PhaseId.ANY_PHASE)) {
			event.setPhaseId(PhaseId.UPDATE_MODEL_VALUES);
			event.queue();
        } else if (event.getPhaseId().equals(PhaseId.UPDATE_MODEL_VALUES)) {
            updateSiteList();
        }
	}
	
	
	public String getSelectedStudy() {
		return selectedStudy;
	}

	public void setSelectedStudy(String selectedStudy) {
		this.selectedStudy = selectedStudy;
	}

	public String getSelectedSite() {
		return selectedSite;
	}

	public void setSelectedSite(String selectedSite) {
		this.selectedSite = selectedSite;
	}
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMaidenname() {
		return maidenname;
	}

	public void setMaidenname(String maidenname) {
		this.maidenname = maidenname;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getGuid() {
		return guid;
	}

	public void setGotGuid(boolean gotGuid) {
		this.gotGuid = gotGuid;
	}

	public boolean isGotGuid() {
		return gotGuid;
	}

	public void setAcrostic(String acrostic) {
		this.acrostic = acrostic;
	}

	public String getAcrostic() {
		return acrostic;
	}

	public void setSiteList(ArrayList<SelectItem> siteList) {
		this.siteList = siteList;
	}

	public ArrayList<SelectItem> getSiteList() {
		return siteList;
	}

	public void setStudyList(ArrayList<SelectItem> studyList) {
		this.studyList = studyList;
	}

	public ArrayList<SelectItem> getStudyList() {
		return studyList;
	}

}
