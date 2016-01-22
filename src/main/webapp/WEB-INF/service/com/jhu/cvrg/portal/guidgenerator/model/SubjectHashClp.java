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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author Chris Jurado
 */
public class SubjectHashClp extends BaseModelImpl<SubjectHash>
	implements SubjectHash {
	public SubjectHashClp() {
	}

	public long getPrimaryKey() {
		return _subjectHashId;
	}

	public void setPrimaryKey(long pk) {
		setSubjectHashId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_subjectHashId);
	}

	public long getSubjectHashId() {
		return _subjectHashId;
	}

	public void setSubjectHashId(long subjectHashId) {
		_subjectHashId = subjectHashId;
	}

	public String getSubjectHashValue() {
		return _subjectHashValue;
	}

	public void setSubjectHashValue(String subjectHashValue) {
		_subjectHashValue = subjectHashValue;
	}

	public SubjectHash toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (SubjectHash)Proxy.newProxyInstance(SubjectHash.class.getClassLoader(),
				new Class[] { SubjectHash.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		SubjectHashClp clone = new SubjectHashClp();

		clone.setSubjectHashId(getSubjectHashId());
		clone.setSubjectHashValue(getSubjectHashValue());

		return clone;
	}

	public int compareTo(SubjectHash subjectHash) {
		long pk = subjectHash.getPrimaryKey();

		if (getPrimaryKey() < pk) {
			return -1;
		}
		else if (getPrimaryKey() > pk) {
			return 1;
		}
		else {
			return 0;
		}
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		SubjectHashClp subjectHash = null;

		try {
			subjectHash = (SubjectHashClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = subjectHash.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{subjectHashId=");
		sb.append(getSubjectHashId());
		sb.append(", subjectHashValue=");
		sb.append(getSubjectHashValue());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.jhu.cvrg.portal.guidgenerator.model.SubjectHash");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>subjectHashId</column-name><column-value><![CDATA[");
		sb.append(getSubjectHashId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subjectHashValue</column-name><column-value><![CDATA[");
		sb.append(getSubjectHashValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _subjectHashId;
	private String _subjectHashValue;
}