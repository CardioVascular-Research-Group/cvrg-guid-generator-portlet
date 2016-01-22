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
public class StudyClp extends BaseModelImpl<Study> implements Study {
	public StudyClp() {
	}

	public long getPrimaryKey() {
		return _studyId;
	}

	public void setPrimaryKey(long pk) {
		setStudyId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_studyId);
	}

	public long getStudyId() {
		return _studyId;
	}

	public void setStudyId(long studyId) {
		_studyId = studyId;
	}

	public String getStudyAcronym() {
		return _studyAcronym;
	}

	public void setStudyAcronym(String studyAcronym) {
		_studyAcronym = studyAcronym;
	}

	public String getStudyName() {
		return _studyName;
	}

	public void setStudyName(String studyName) {
		_studyName = studyName;
	}

	public Study toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (Study)Proxy.newProxyInstance(Study.class.getClassLoader(),
				new Class[] { Study.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		StudyClp clone = new StudyClp();

		clone.setStudyId(getStudyId());
		clone.setStudyAcronym(getStudyAcronym());
		clone.setStudyName(getStudyName());

		return clone;
	}

	public int compareTo(Study study) {
		long pk = study.getPrimaryKey();

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

		StudyClp study = null;

		try {
			study = (StudyClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = study.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{studyId=");
		sb.append(getStudyId());
		sb.append(", studyAcronym=");
		sb.append(getStudyAcronym());
		sb.append(", studyName=");
		sb.append(getStudyName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.jhu.cvrg.portal.guidgenerator.model.Study");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>studyId</column-name><column-value><![CDATA[");
		sb.append(getStudyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>studyAcronym</column-name><column-value><![CDATA[");
		sb.append(getStudyAcronym());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>studyName</column-name><column-value><![CDATA[");
		sb.append(getStudyName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _studyId;
	private String _studyAcronym;
	private String _studyName;
}