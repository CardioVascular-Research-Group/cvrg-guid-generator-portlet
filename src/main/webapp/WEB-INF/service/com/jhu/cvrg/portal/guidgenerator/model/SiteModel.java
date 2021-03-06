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

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Site service. Represents a row in the &quot;JHU_Site&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.jhu.cvrg.portal.guidgenerator.model.impl.SiteModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.jhu.cvrg.portal.guidgenerator.model.impl.SiteImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a site model instance should use the {@link Site} interface instead.
 * </p>
 *
 * @author Chris Jurado
 * @see Site
 * @see com.jhu.cvrg.portal.guidgenerator.model.impl.SiteImpl
 * @see com.jhu.cvrg.portal.guidgenerator.model.impl.SiteModelImpl
 * @generated
 */
public interface SiteModel extends BaseModel<Site> {
	/**
	 * Gets the primary key of this site.
	 *
	 * @return the primary key of this site
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this site
	 *
	 * @param pk the primary key of this site
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the site id of this site.
	 *
	 * @return the site id of this site
	 */
	public long getSiteId();

	/**
	 * Sets the site id of this site.
	 *
	 * @param siteId the site id of this site
	 */
	public void setSiteId(long siteId);

	/**
	 * Gets the site acronym of this site.
	 *
	 * @return the site acronym of this site
	 */
	@AutoEscape
	public String getSiteAcronym();

	/**
	 * Sets the site acronym of this site.
	 *
	 * @param siteAcronym the site acronym of this site
	 */
	public void setSiteAcronym(String siteAcronym);

	/**
	 * Gets the site name of this site.
	 *
	 * @return the site name of this site
	 */
	@AutoEscape
	public String getSiteName();

	/**
	 * Sets the site name of this site.
	 *
	 * @param siteName the site name of this site
	 */
	public void setSiteName(String siteName);

	/**
	 * Gets a copy of this site as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public Site toEscapedModel();

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Site site);

	public int hashCode();

	public String toString();

	public String toXmlString();
}