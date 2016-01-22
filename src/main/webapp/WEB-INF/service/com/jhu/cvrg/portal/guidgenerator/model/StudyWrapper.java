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
 * This class is a wrapper for {@link Study}.
 * </p>
 *
 * @author    Chris Jurado
 * @see       Study
 * @generated
 */
public class StudyWrapper implements Study {
	public StudyWrapper(Study study) {
		_study = study;
	}

	public long getPrimaryKey() {
		return _study.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_study.setPrimaryKey(pk);
	}

	public long getStudyId() {
		return _study.getStudyId();
	}

	public void setStudyId(long studyId) {
		_study.setStudyId(studyId);
	}

	public java.lang.String getStudyAcronym() {
		return _study.getStudyAcronym();
	}

	public void setStudyAcronym(java.lang.String studyAcronym) {
		_study.setStudyAcronym(studyAcronym);
	}

	public java.lang.String getStudyName() {
		return _study.getStudyName();
	}

	public void setStudyName(java.lang.String studyName) {
		_study.setStudyName(studyName);
	}

	public com.jhu.cvrg.portal.guidgenerator.model.Study toEscapedModel() {
		return _study.toEscapedModel();
	}

	public boolean isNew() {
		return _study.isNew();
	}

	public void setNew(boolean n) {
		_study.setNew(n);
	}

	public boolean isCachedModel() {
		return _study.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_study.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _study.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_study.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _study.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _study.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_study.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _study.clone();
	}

	public int compareTo(com.jhu.cvrg.portal.guidgenerator.model.Study study) {
		return _study.compareTo(study);
	}

	public int hashCode() {
		return _study.hashCode();
	}

	public java.lang.String toString() {
		return _study.toString();
	}

	public java.lang.String toXmlString() {
		return _study.toXmlString();
	}

	public Study getWrappedStudy() {
		return _study;
	}

	private Study _study;
}