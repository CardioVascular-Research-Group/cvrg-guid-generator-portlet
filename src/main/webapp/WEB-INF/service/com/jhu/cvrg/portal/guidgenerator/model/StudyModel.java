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
 * The base model interface for the Study service. Represents a row in the &quot;JHU_Study&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.jhu.cvrg.portal.guidgenerator.model.impl.StudyModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.jhu.cvrg.portal.guidgenerator.model.impl.StudyImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a study model instance should use the {@link Study} interface instead.
 * </p>
 *
 * @author Chris Jurado
 * @see Study
 * @see com.jhu.cvrg.portal.guidgenerator.model.impl.StudyImpl
 * @see com.jhu.cvrg.portal.guidgenerator.model.impl.StudyModelImpl
 * @generated
 */
public interface StudyModel extends BaseModel<Study> {
	/**
	 * Gets the primary key of this study.
	 *
	 * @return the primary key of this study
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this study
	 *
	 * @param pk the primary key of this study
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the study id of this study.
	 *
	 * @return the study id of this study
	 */
	public long getStudyId();

	/**
	 * Sets the study id of this study.
	 *
	 * @param studyId the study id of this study
	 */
	public void setStudyId(long studyId);

	/**
	 * Gets the study acronym of this study.
	 *
	 * @return the study acronym of this study
	 */
	@AutoEscape
	public String getStudyAcronym();

	/**
	 * Sets the study acronym of this study.
	 *
	 * @param studyAcronym the study acronym of this study
	 */
	public void setStudyAcronym(String studyAcronym);

	/**
	 * Gets the study name of this study.
	 *
	 * @return the study name of this study
	 */
	@AutoEscape
	public String getStudyName();

	/**
	 * Sets the study name of this study.
	 *
	 * @param studyName the study name of this study
	 */
	public void setStudyName(String studyName);

	/**
	 * Gets a copy of this study as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public Study toEscapedModel();

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

	public int compareTo(Study study);

	public int hashCode();

	public String toString();

	public String toXmlString();
}