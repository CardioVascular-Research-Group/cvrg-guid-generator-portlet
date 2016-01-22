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

package com.jhu.cvrg.portal.guidgenerator.service;

/**
 * <p>
 * This class is a wrapper for {@link StudySiteLocalService}.
 * </p>
 *
 * @author    Chris Jurado
 * @see       StudySiteLocalService
 * @generated
 */
public class StudySiteLocalServiceWrapper implements StudySiteLocalService {
	public StudySiteLocalServiceWrapper(
		StudySiteLocalService studySiteLocalService) {
		_studySiteLocalService = studySiteLocalService;
	}

	/**
	* Adds the study site to the database. Also notifies the appropriate model listeners.
	*
	* @param studySite the study site to add
	* @return the study site that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.jhu.cvrg.portal.guidgenerator.model.StudySite addStudySite(
		com.jhu.cvrg.portal.guidgenerator.model.StudySite studySite)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studySiteLocalService.addStudySite(studySite);
	}

	/**
	* Creates a new study site with the primary key. Does not add the study site to the database.
	*
	* @param studySiteId the primary key for the new study site
	* @return the new study site
	*/
	public com.jhu.cvrg.portal.guidgenerator.model.StudySite createStudySite(
		long studySiteId) {
		return _studySiteLocalService.createStudySite(studySiteId);
	}

	/**
	* Deletes the study site with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studySiteId the primary key of the study site to delete
	* @throws PortalException if a study site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteStudySite(long studySiteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_studySiteLocalService.deleteStudySite(studySiteId);
	}

	/**
	* Deletes the study site from the database. Also notifies the appropriate model listeners.
	*
	* @param studySite the study site to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteStudySite(
		com.jhu.cvrg.portal.guidgenerator.model.StudySite studySite)
		throws com.liferay.portal.kernel.exception.SystemException {
		_studySiteLocalService.deleteStudySite(studySite);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studySiteLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _studySiteLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studySiteLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studySiteLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the study site with the primary key.
	*
	* @param studySiteId the primary key of the study site to get
	* @return the study site
	* @throws PortalException if a study site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jhu.cvrg.portal.guidgenerator.model.StudySite getStudySite(
		long studySiteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _studySiteLocalService.getStudySite(studySiteId);
	}

	/**
	* Gets a range of all the study sites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of study sites to return
	* @param end the upper bound of the range of study sites to return (not inclusive)
	* @return the range of study sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jhu.cvrg.portal.guidgenerator.model.StudySite> getStudySites(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studySiteLocalService.getStudySites(start, end);
	}

	/**
	* Gets the number of study sites.
	*
	* @return the number of study sites
	* @throws SystemException if a system exception occurred
	*/
	public int getStudySitesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studySiteLocalService.getStudySitesCount();
	}

	/**
	* Updates the study site in the database. Also notifies the appropriate model listeners.
	*
	* @param studySite the study site to update
	* @return the study site that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.jhu.cvrg.portal.guidgenerator.model.StudySite updateStudySite(
		com.jhu.cvrg.portal.guidgenerator.model.StudySite studySite)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studySiteLocalService.updateStudySite(studySite);
	}

	/**
	* Updates the study site in the database. Also notifies the appropriate model listeners.
	*
	* @param studySite the study site to update
	* @param merge whether to merge the study site with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the study site that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.jhu.cvrg.portal.guidgenerator.model.StudySite updateStudySite(
		com.jhu.cvrg.portal.guidgenerator.model.StudySite studySite,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studySiteLocalService.updateStudySite(studySite, merge);
	}

	public com.jhu.cvrg.portal.guidgenerator.model.StudySite addStudySite(
		long studyId, long siteId, int linkingDirection)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _studySiteLocalService.addStudySite(studyId, siteId,
			linkingDirection);
	}

	public StudySiteLocalService getWrappedStudySiteLocalService() {
		return _studySiteLocalService;
	}

	private StudySiteLocalService _studySiteLocalService;
}