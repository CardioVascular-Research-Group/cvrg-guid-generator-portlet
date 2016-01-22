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
public class StudySiteClp extends BaseModelImpl<StudySite> implements StudySite {
	public StudySiteClp() {
	}

	public long getPrimaryKey() {
		return _studySiteId;
	}

	public void setPrimaryKey(long pk) {
		setStudySiteId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_studySiteId);
	}

	public long getStudySiteId() {
		return _studySiteId;
	}

	public void setStudySiteId(long studySiteId) {
		_studySiteId = studySiteId;
	}

	public long getStudyId() {
		return _studyId;
	}

	public void setStudyId(long studyId) {
		_studyId = studyId;
	}

	public long getSiteId() {
		return _siteId;
	}

	public void setSiteId(long siteId) {
		_siteId = siteId;
	}

	public int getLinkingDirection() {
		return _linkingDirection;
	}

	public void setLinkingDirection(int linkingDirection) {
		_linkingDirection = linkingDirection;
	}

	public StudySite toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (StudySite)Proxy.newProxyInstance(StudySite.class.getClassLoader(),
				new Class[] { StudySite.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		StudySiteClp clone = new StudySiteClp();

		clone.setStudySiteId(getStudySiteId());
		clone.setStudyId(getStudyId());
		clone.setSiteId(getSiteId());
		clone.setLinkingDirection(getLinkingDirection());

		return clone;
	}

	public int compareTo(StudySite studySite) {
		long pk = studySite.getPrimaryKey();

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

		StudySiteClp studySite = null;

		try {
			studySite = (StudySiteClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = studySite.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{studySiteId=");
		sb.append(getStudySiteId());
		sb.append(", studyId=");
		sb.append(getStudyId());
		sb.append(", siteId=");
		sb.append(getSiteId());
		sb.append(", linkingDirection=");
		sb.append(getLinkingDirection());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.jhu.cvrg.portal.guidgenerator.model.StudySite");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>studySiteId</column-name><column-value><![CDATA[");
		sb.append(getStudySiteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>studyId</column-name><column-value><![CDATA[");
		sb.append(getStudyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>siteId</column-name><column-value><![CDATA[");
		sb.append(getSiteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>linkingDirection</column-name><column-value><![CDATA[");
		sb.append(getLinkingDirection());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _studySiteId;
	private long _studyId;
	private long _siteId;
	private int _linkingDirection;
}