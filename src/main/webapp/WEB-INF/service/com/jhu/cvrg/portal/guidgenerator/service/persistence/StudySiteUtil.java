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

package com.jhu.cvrg.portal.guidgenerator.service.persistence;

import com.jhu.cvrg.portal.guidgenerator.model.StudySite;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the study site service. This utility wraps {@link StudySitePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Chris Jurado
 * @see StudySitePersistence
 * @see StudySitePersistenceImpl
 * @generated
 */
public class StudySiteUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(StudySite studySite) {
		getPersistence().clearCache(studySite);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StudySite> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StudySite> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StudySite> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static StudySite remove(StudySite studySite)
		throws SystemException {
		return getPersistence().remove(studySite);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static StudySite update(StudySite studySite, boolean merge)
		throws SystemException {
		return getPersistence().update(studySite, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static StudySite update(StudySite studySite, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(studySite, merge, serviceContext);
	}

	/**
	* Caches the study site in the entity cache if it is enabled.
	*
	* @param studySite the study site to cache
	*/
	public static void cacheResult(
		com.jhu.cvrg.portal.guidgenerator.model.StudySite studySite) {
		getPersistence().cacheResult(studySite);
	}

	/**
	* Caches the study sites in the entity cache if it is enabled.
	*
	* @param studySites the study sites to cache
	*/
	public static void cacheResult(
		java.util.List<com.jhu.cvrg.portal.guidgenerator.model.StudySite> studySites) {
		getPersistence().cacheResult(studySites);
	}

	/**
	* Creates a new study site with the primary key. Does not add the study site to the database.
	*
	* @param studySiteId the primary key for the new study site
	* @return the new study site
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.StudySite create(
		long studySiteId) {
		return getPersistence().create(studySiteId);
	}

	/**
	* Removes the study site with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studySiteId the primary key of the study site to remove
	* @return the study site that was removed
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudySiteException if a study site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.StudySite remove(
		long studySiteId)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudySiteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(studySiteId);
	}

	public static com.jhu.cvrg.portal.guidgenerator.model.StudySite updateImpl(
		com.jhu.cvrg.portal.guidgenerator.model.StudySite studySite,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(studySite, merge);
	}

	/**
	* Finds the study site with the primary key or throws a {@link com.jhu.cvrg.portal.guidgenerator.NoSuchStudySiteException} if it could not be found.
	*
	* @param studySiteId the primary key of the study site to find
	* @return the study site
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudySiteException if a study site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.StudySite findByPrimaryKey(
		long studySiteId)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudySiteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(studySiteId);
	}

	/**
	* Finds the study site with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param studySiteId the primary key of the study site to find
	* @return the study site, or <code>null</code> if a study site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.StudySite fetchByPrimaryKey(
		long studySiteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(studySiteId);
	}

	/**
	* Finds all the study sites where siteId = &#63;.
	*
	* @param siteId the site id to search with
	* @return the matching study sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.StudySite> findBySiteId(
		long siteId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySiteId(siteId);
	}

	/**
	* Finds a range of all the study sites where siteId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param siteId the site id to search with
	* @param start the lower bound of the range of study sites to return
	* @param end the upper bound of the range of study sites to return (not inclusive)
	* @return the range of matching study sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.StudySite> findBySiteId(
		long siteId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySiteId(siteId, start, end);
	}

	/**
	* Finds an ordered range of all the study sites where siteId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param siteId the site id to search with
	* @param start the lower bound of the range of study sites to return
	* @param end the upper bound of the range of study sites to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching study sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.StudySite> findBySiteId(
		long siteId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySiteId(siteId, start, end, orderByComparator);
	}

	/**
	* Finds the first study site in the ordered set where siteId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param siteId the site id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching study site
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudySiteException if a matching study site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.StudySite findBySiteId_First(
		long siteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudySiteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySiteId_First(siteId, orderByComparator);
	}

	/**
	* Finds the last study site in the ordered set where siteId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param siteId the site id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching study site
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudySiteException if a matching study site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.StudySite findBySiteId_Last(
		long siteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudySiteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySiteId_Last(siteId, orderByComparator);
	}

	/**
	* Finds the study sites before and after the current study site in the ordered set where siteId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studySiteId the primary key of the current study site
	* @param siteId the site id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next study site
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudySiteException if a study site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.StudySite[] findBySiteId_PrevAndNext(
		long studySiteId, long siteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudySiteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySiteId_PrevAndNext(studySiteId, siteId,
			orderByComparator);
	}

	/**
	* Finds all the study sites where studyId = &#63;.
	*
	* @param studyId the study id to search with
	* @return the matching study sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.StudySite> findByStudyId(
		long studyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStudyId(studyId);
	}

	/**
	* Finds a range of all the study sites where studyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studyId the study id to search with
	* @param start the lower bound of the range of study sites to return
	* @param end the upper bound of the range of study sites to return (not inclusive)
	* @return the range of matching study sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.StudySite> findByStudyId(
		long studyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStudyId(studyId, start, end);
	}

	/**
	* Finds an ordered range of all the study sites where studyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studyId the study id to search with
	* @param start the lower bound of the range of study sites to return
	* @param end the upper bound of the range of study sites to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching study sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.StudySite> findByStudyId(
		long studyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStudyId(studyId, start, end, orderByComparator);
	}

	/**
	* Finds the first study site in the ordered set where studyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studyId the study id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching study site
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudySiteException if a matching study site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.StudySite findByStudyId_First(
		long studyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudySiteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStudyId_First(studyId, orderByComparator);
	}

	/**
	* Finds the last study site in the ordered set where studyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studyId the study id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching study site
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudySiteException if a matching study site could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.StudySite findByStudyId_Last(
		long studyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudySiteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStudyId_Last(studyId, orderByComparator);
	}

	/**
	* Finds the study sites before and after the current study site in the ordered set where studyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studySiteId the primary key of the current study site
	* @param studyId the study id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next study site
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudySiteException if a study site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.StudySite[] findByStudyId_PrevAndNext(
		long studySiteId, long studyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudySiteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStudyId_PrevAndNext(studySiteId, studyId,
			orderByComparator);
	}

	/**
	* Finds all the study sites.
	*
	* @return the study sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.StudySite> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the study sites.
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
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.StudySite> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the study sites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of study sites to return
	* @param end the upper bound of the range of study sites to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of study sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.StudySite> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the study sites where siteId = &#63; from the database.
	*
	* @param siteId the site id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySiteId(long siteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySiteId(siteId);
	}

	/**
	* Removes all the study sites where studyId = &#63; from the database.
	*
	* @param studyId the study id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStudyId(long studyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStudyId(studyId);
	}

	/**
	* Removes all the study sites from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the study sites where siteId = &#63;.
	*
	* @param siteId the site id to search with
	* @return the number of matching study sites
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySiteId(long siteId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySiteId(siteId);
	}

	/**
	* Counts all the study sites where studyId = &#63;.
	*
	* @param studyId the study id to search with
	* @return the number of matching study sites
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStudyId(long studyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStudyId(studyId);
	}

	/**
	* Counts all the study sites.
	*
	* @return the number of study sites
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StudySitePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StudySitePersistence)PortletBeanLocatorUtil.locate(com.jhu.cvrg.portal.guidgenerator.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					StudySitePersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(StudySitePersistence persistence) {
		_persistence = persistence;
	}

	private static StudySitePersistence _persistence;
}