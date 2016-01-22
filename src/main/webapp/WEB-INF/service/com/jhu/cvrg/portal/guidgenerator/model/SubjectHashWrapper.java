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
 * This class is a wrapper for {@link SubjectHash}.
 * </p>
 *
 * @author    Chris Jurado
 * @see       SubjectHash
 * @generated
 */
public class SubjectHashWrapper implements SubjectHash {
	public SubjectHashWrapper(SubjectHash subjectHash) {
		_subjectHash = subjectHash;
	}

	public long getPrimaryKey() {
		return _subjectHash.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_subjectHash.setPrimaryKey(pk);
	}

	public long getSubjectHashId() {
		return _subjectHash.getSubjectHashId();
	}

	public void setSubjectHashId(long subjectHashId) {
		_subjectHash.setSubjectHashId(subjectHashId);
	}

	public java.lang.String getSubjectHashValue() {
		return _subjectHash.getSubjectHashValue();
	}

	public void setSubjectHashValue(java.lang.String subjectHashValue) {
		_subjectHash.setSubjectHashValue(subjectHashValue);
	}

	public com.jhu.cvrg.portal.guidgenerator.model.SubjectHash toEscapedModel() {
		return _subjectHash.toEscapedModel();
	}

	public boolean isNew() {
		return _subjectHash.isNew();
	}

	public void setNew(boolean n) {
		_subjectHash.setNew(n);
	}

	public boolean isCachedModel() {
		return _subjectHash.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_subjectHash.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _subjectHash.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_subjectHash.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _subjectHash.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _subjectHash.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_subjectHash.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _subjectHash.clone();
	}

	public int compareTo(
		com.jhu.cvrg.portal.guidgenerator.model.SubjectHash subjectHash) {
		return _subjectHash.compareTo(subjectHash);
	}

	public int hashCode() {
		return _subjectHash.hashCode();
	}

	public java.lang.String toString() {
		return _subjectHash.toString();
	}

	public java.lang.String toXmlString() {
		return _subjectHash.toXmlString();
	}

	public SubjectHash getWrappedSubjectHash() {
		return _subjectHash;
	}

	private SubjectHash _subjectHash;
}