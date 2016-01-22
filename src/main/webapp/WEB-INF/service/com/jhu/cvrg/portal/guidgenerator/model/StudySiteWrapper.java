/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.jhu.cvrg.portal.guidgenerator.model;

/**
 * <p>
 * This class is a wrapper for {@link StudySite}.
 * </p>
 *
 * @author    Chris Jurado
 * @see       StudySite
 * @generated
 */
public class StudySiteWrapper implements StudySite {
	public StudySiteWrapper(StudySite studySite) {
		_studySite = studySite;
	}

	public long getPrimaryKey() {
		return _studySite.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_studySite.setPrimaryKey(pk);
	}

	public long getStudySiteId() {
		return _studySite.getStudySiteId();
	}

	public void setStudySiteId(long studySiteId) {
		_studySite.setStudySiteId(studySiteId);
	}

	public long getStudyId() {
		return _studySite.getStudyId();
	}

	public void setStudyId(long studyId) {
		_studySite.setStudyId(studyId);
	}

	public long getSiteId() {
		return _studySite.getSiteId();
	}

	public void setSiteId(long siteId) {
		_studySite.setSiteId(siteId);
	}

	public int getLinkingDirection() {
		return _studySite.getLinkingDirection();
	}

	public void setLinkingDirection(int linkingDirection) {
		_studySite.setLinkingDirection(linkingDirection);
	}

	public com.jhu.cvrg.portal.guidgenerator.model.StudySite toEscapedModel() {
		return _studySite.toEscapedModel();
	}

	public boolean isNew() {
		return _studySite.isNew();
	}

	public void setNew(boolean n) {
		_studySite.setNew(n);
	}

	public boolean isCachedModel() {
		return _studySite.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_studySite.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _studySite.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_studySite.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _studySite.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _studySite.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_studySite.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _studySite.clone();
	}

	public int compareTo(
		com.jhu.cvrg.portal.guidgenerator.model.StudySite studySite) {
		return _studySite.compareTo(studySite);
	}

	public int hashCode() {
		return _studySite.hashCode();
	}

	public java.lang.String toString() {
		return _studySite.toString();
	}

	public java.lang.String toXmlString() {
		return _studySite.toXmlString();
	}

	public StudySite getWrappedStudySite() {
		return _studySite;
	}

	private StudySite _studySite;
}