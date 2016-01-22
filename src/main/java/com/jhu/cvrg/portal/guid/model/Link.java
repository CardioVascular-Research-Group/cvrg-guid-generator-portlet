package com.jhu.cvrg.portal.guid.model;

public class Link {
	
	private long siteId, studyId;

	public Link(long siteId, long studyId) {
		this.setSiteId(siteId);
		this.setStudyId(studyId);
	}

	public void setStudyId(long studyId) {
		this.studyId = studyId;
	}

	public long getStudyId() {
		return studyId;
	}

	public void setSiteId(long siteId) {
		this.siteId = siteId;
	}

	public long getSiteId() {
		return siteId;
	}



}
