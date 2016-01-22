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
public class SiteClp extends BaseModelImpl<Site> implements Site {
	public SiteClp() {
	}

	public long getPrimaryKey() {
		return _siteId;
	}

	public void setPrimaryKey(long pk) {
		setSiteId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_siteId);
	}

	public long getSiteId() {
		return _siteId;
	}

	public void setSiteId(long siteId) {
		_siteId = siteId;
	}

	public String getSiteAcronym() {
		return _siteAcronym;
	}

	public void setSiteAcronym(String siteAcronym) {
		_siteAcronym = siteAcronym;
	}

	public String getSiteName() {
		return _siteName;
	}

	public void setSiteName(String siteName) {
		_siteName = siteName;
	}

	public Site toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (Site)Proxy.newProxyInstance(Site.class.getClassLoader(),
				new Class[] { Site.class }, new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		SiteClp clone = new SiteClp();

		clone.setSiteId(getSiteId());
		clone.setSiteAcronym(getSiteAcronym());
		clone.setSiteName(getSiteName());

		return clone;
	}

	public int compareTo(Site site) {
		long pk = site.getPrimaryKey();

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

		SiteClp site = null;

		try {
			site = (SiteClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = site.getPrimaryKey();

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

		sb.append("{siteId=");
		sb.append(getSiteId());
		sb.append(", siteAcronym=");
		sb.append(getSiteAcronym());
		sb.append(", siteName=");
		sb.append(getSiteName());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.jhu.cvrg.portal.guidgenerator.model.Site");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>siteId</column-name><column-value><![CDATA[");
		sb.append(getSiteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>siteAcronym</column-name><column-value><![CDATA[");
		sb.append(getSiteAcronym());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>siteName</column-name><column-value><![CDATA[");
		sb.append(getSiteName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _siteId;
	private String _siteAcronym;
	private String _siteName;
}