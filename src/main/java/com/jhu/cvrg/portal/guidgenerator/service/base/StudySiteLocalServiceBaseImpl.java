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

package com.jhu.cvrg.portal.guidgenerator.service.base;

import com.jhu.cvrg.portal.guidgenerator.model.StudySite;
import com.jhu.cvrg.portal.guidgenerator.service.SiteLocalService;
import com.jhu.cvrg.portal.guidgenerator.service.StudyLocalService;
import com.jhu.cvrg.portal.guidgenerator.service.StudySiteLocalService;
import com.jhu.cvrg.portal.guidgenerator.service.SubjectHashLocalService;
import com.jhu.cvrg.portal.guidgenerator.service.persistence.SitePersistence;
import com.jhu.cvrg.portal.guidgenerator.service.persistence.StudyPersistence;
import com.jhu.cvrg.portal.guidgenerator.service.persistence.StudySitePersistence;
import com.jhu.cvrg.portal.guidgenerator.service.persistence.SubjectHashPersistence;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the study site local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.jhu.cvrg.portal.guidgenerator.service.impl.StudySiteLocalServiceImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link com.jhu.cvrg.portal.guidgenerator.service.StudySiteLocalServiceUtil} to access the study site local service.
 * </p>
 *
 * @author Chris Jurado
 * @see com.jhu.cvrg.portal.guidgenerator.service.impl.StudySiteLocalServiceImpl
 * @see com.jhu.cvrg.portal.guidgenerator.service.StudySiteLocalServiceUtil
 * @generated
 */
public abstract class StudySiteLocalServiceBaseImpl
	implements StudySiteLocalService {
	/**
	 * Adds the study site to the database. Also notifies the appropriate model listeners.
	 *
	 * @param studySite the study site to add
	 * @return the study site that was added
	 * @throws SystemException if a system exception occurred
	 */
	public StudySite addStudySite(StudySite studySite)
		throws SystemException {
		studySite.setNew(true);

		return studySitePersistence.update(studySite, false);
	}

	/**
	 * Creates a new study site with the primary key. Does not add the study site to the database.
	 *
	 * @param studySiteId the primary key for the new study site
	 * @return the new study site
	 */
	public StudySite createStudySite(long studySiteId) {
		return studySitePersistence.create(studySiteId);
	}

	/**
	 * Deletes the study site with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studySiteId the primary key of the study site to delete
	 * @throws PortalException if a study site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteStudySite(long studySiteId)
		throws PortalException, SystemException {
		studySitePersistence.remove(studySiteId);
	}

	/**
	 * Deletes the study site from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studySite the study site to delete
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteStudySite(StudySite studySite) throws SystemException {
		studySitePersistence.remove(studySite);
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return studySitePersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return studySitePersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return studySitePersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Counts the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return studySitePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Gets the study site with the primary key.
	 *
	 * @param studySiteId the primary key of the study site to get
	 * @return the study site
	 * @throws PortalException if a study site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StudySite getStudySite(long studySiteId)
		throws PortalException, SystemException {
		return studySitePersistence.findByPrimaryKey(studySiteId);
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
	public List<StudySite> getStudySites(int start, int end)
		throws SystemException {
		return studySitePersistence.findAll(start, end);
	}

	/**
	 * Gets the number of study sites.
	 *
	 * @return the number of study sites
	 * @throws SystemException if a system exception occurred
	 */
	public int getStudySitesCount() throws SystemException {
		return studySitePersistence.countAll();
	}

	/**
	 * Updates the study site in the database. Also notifies the appropriate model listeners.
	 *
	 * @param studySite the study site to update
	 * @return the study site that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public StudySite updateStudySite(StudySite studySite)
		throws SystemException {
		studySite.setNew(false);

		return studySitePersistence.update(studySite, true);
	}

	/**
	 * Updates the study site in the database. Also notifies the appropriate model listeners.
	 *
	 * @param studySite the study site to update
	 * @param merge whether to merge the study site with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the study site that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public StudySite updateStudySite(StudySite studySite, boolean merge)
		throws SystemException {
		studySite.setNew(false);

		return studySitePersistence.update(studySite, merge);
	}

	/**
	 * Gets the study local service.
	 *
	 * @return the study local service
	 */
	public StudyLocalService getStudyLocalService() {
		return studyLocalService;
	}

	/**
	 * Sets the study local service.
	 *
	 * @param studyLocalService the study local service
	 */
	public void setStudyLocalService(StudyLocalService studyLocalService) {
		this.studyLocalService = studyLocalService;
	}

	/**
	 * Gets the study persistence.
	 *
	 * @return the study persistence
	 */
	public StudyPersistence getStudyPersistence() {
		return studyPersistence;
	}

	/**
	 * Sets the study persistence.
	 *
	 * @param studyPersistence the study persistence
	 */
	public void setStudyPersistence(StudyPersistence studyPersistence) {
		this.studyPersistence = studyPersistence;
	}

	/**
	 * Gets the site local service.
	 *
	 * @return the site local service
	 */
	public SiteLocalService getSiteLocalService() {
		return siteLocalService;
	}

	/**
	 * Sets the site local service.
	 *
	 * @param siteLocalService the site local service
	 */
	public void setSiteLocalService(SiteLocalService siteLocalService) {
		this.siteLocalService = siteLocalService;
	}

	/**
	 * Gets the site persistence.
	 *
	 * @return the site persistence
	 */
	public SitePersistence getSitePersistence() {
		return sitePersistence;
	}

	/**
	 * Sets the site persistence.
	 *
	 * @param sitePersistence the site persistence
	 */
	public void setSitePersistence(SitePersistence sitePersistence) {
		this.sitePersistence = sitePersistence;
	}

	/**
	 * Gets the study site local service.
	 *
	 * @return the study site local service
	 */
	public StudySiteLocalService getStudySiteLocalService() {
		return studySiteLocalService;
	}

	/**
	 * Sets the study site local service.
	 *
	 * @param studySiteLocalService the study site local service
	 */
	public void setStudySiteLocalService(
		StudySiteLocalService studySiteLocalService) {
		this.studySiteLocalService = studySiteLocalService;
	}

	/**
	 * Gets the study site persistence.
	 *
	 * @return the study site persistence
	 */
	public StudySitePersistence getStudySitePersistence() {
		return studySitePersistence;
	}

	/**
	 * Sets the study site persistence.
	 *
	 * @param studySitePersistence the study site persistence
	 */
	public void setStudySitePersistence(
		StudySitePersistence studySitePersistence) {
		this.studySitePersistence = studySitePersistence;
	}

	/**
	 * Gets the subject hash local service.
	 *
	 * @return the subject hash local service
	 */
	public SubjectHashLocalService getSubjectHashLocalService() {
		return subjectHashLocalService;
	}

	/**
	 * Sets the subject hash local service.
	 *
	 * @param subjectHashLocalService the subject hash local service
	 */
	public void setSubjectHashLocalService(
		SubjectHashLocalService subjectHashLocalService) {
		this.subjectHashLocalService = subjectHashLocalService;
	}

	/**
	 * Gets the subject hash persistence.
	 *
	 * @return the subject hash persistence
	 */
	public SubjectHashPersistence getSubjectHashPersistence() {
		return subjectHashPersistence;
	}

	/**
	 * Sets the subject hash persistence.
	 *
	 * @param subjectHashPersistence the subject hash persistence
	 */
	public void setSubjectHashPersistence(
		SubjectHashPersistence subjectHashPersistence) {
		this.subjectHashPersistence = subjectHashPersistence;
	}

	/**
	 * Gets the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Gets the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Gets the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Gets the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Gets the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Gets the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Gets the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query to perform
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = studySitePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = StudyLocalService.class)
	protected StudyLocalService studyLocalService;
	@BeanReference(type = StudyPersistence.class)
	protected StudyPersistence studyPersistence;
	@BeanReference(type = SiteLocalService.class)
	protected SiteLocalService siteLocalService;
	@BeanReference(type = SitePersistence.class)
	protected SitePersistence sitePersistence;
	@BeanReference(type = StudySiteLocalService.class)
	protected StudySiteLocalService studySiteLocalService;
	@BeanReference(type = StudySitePersistence.class)
	protected StudySitePersistence studySitePersistence;
	@BeanReference(type = SubjectHashLocalService.class)
	protected SubjectHashLocalService subjectHashLocalService;
	@BeanReference(type = SubjectHashPersistence.class)
	protected SubjectHashPersistence subjectHashPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}