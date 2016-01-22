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

import com.jhu.cvrg.portal.guidgenerator.model.Study;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the study service. This utility wraps {@link StudyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
 * @see StudyPersistence
 * @see StudyPersistenceImpl
 * @generated
 */
public class StudyUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Study study) {
		getPersistence().clearCache(study);
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
	public static List<Study> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Study> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Study> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static Study remove(Study study) throws SystemException {
		return getPersistence().remove(study);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Study update(Study study, boolean merge)
		throws SystemException {
		return getPersistence().update(study, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Study update(Study study, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(study, merge, serviceContext);
	}

	/**
	* Caches the study in the entity cache if it is enabled.
	*
	* @param study the study to cache
	*/
	public static void cacheResult(
		com.jhu.cvrg.portal.guidgenerator.model.Study study) {
		getPersistence().cacheResult(study);
	}

	/**
	* Caches the studies in the entity cache if it is enabled.
	*
	* @param studies the studies to cache
	*/
	public static void cacheResult(
		java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Study> studies) {
		getPersistence().cacheResult(studies);
	}

	/**
	* Creates a new study with the primary key. Does not add the study to the database.
	*
	* @param studyId the primary key for the new study
	* @return the new study
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.Study create(
		long studyId) {
		return getPersistence().create(studyId);
	}

	/**
	* Removes the study with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studyId the primary key of the study to remove
	* @return the study that was removed
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudyException if a study with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.Study remove(
		long studyId)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(studyId);
	}

	public static com.jhu.cvrg.portal.guidgenerator.model.Study updateImpl(
		com.jhu.cvrg.portal.guidgenerator.model.Study study, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(study, merge);
	}

	/**
	* Finds the study with the primary key or throws a {@link com.jhu.cvrg.portal.guidgenerator.NoSuchStudyException} if it could not be found.
	*
	* @param studyId the primary key of the study to find
	* @return the study
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudyException if a study with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.Study findByPrimaryKey(
		long studyId)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(studyId);
	}

	/**
	* Finds the study with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param studyId the primary key of the study to find
	* @return the study, or <code>null</code> if a study with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.Study fetchByPrimaryKey(
		long studyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(studyId);
	}

	/**
	* Finds all the studies where studyName = &#63;.
	*
	* @param studyName the study name to search with
	* @return the matching studies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Study> findByStudyName(
		java.lang.String studyName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStudyName(studyName);
	}

	/**
	* Finds a range of all the studies where studyName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studyName the study name to search with
	* @param start the lower bound of the range of studies to return
	* @param end the upper bound of the range of studies to return (not inclusive)
	* @return the range of matching studies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Study> findByStudyName(
		java.lang.String studyName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStudyName(studyName, start, end);
	}

	/**
	* Finds an ordered range of all the studies where studyName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studyName the study name to search with
	* @param start the lower bound of the range of studies to return
	* @param end the upper bound of the range of studies to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching studies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Study> findByStudyName(
		java.lang.String studyName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStudyName(studyName, start, end, orderByComparator);
	}

	/**
	* Finds the first study in the ordered set where studyName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studyName the study name to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching study
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudyException if a matching study could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.Study findByStudyName_First(
		java.lang.String studyName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStudyName_First(studyName, orderByComparator);
	}

	/**
	* Finds the last study in the ordered set where studyName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studyName the study name to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching study
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudyException if a matching study could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.Study findByStudyName_Last(
		java.lang.String studyName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStudyName_Last(studyName, orderByComparator);
	}

	/**
	* Finds the studies before and after the current study in the ordered set where studyName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studyId the primary key of the current study
	* @param studyName the study name to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next study
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudyException if a study with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.Study[] findByStudyName_PrevAndNext(
		long studyId, java.lang.String studyName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStudyName_PrevAndNext(studyId, studyName,
			orderByComparator);
	}

	/**
	* Finds all the studies where studyAcronym = &#63;.
	*
	* @param studyAcronym the study acronym to search with
	* @return the matching studies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Study> findByStudyAcronym(
		java.lang.String studyAcronym)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStudyAcronym(studyAcronym);
	}

	/**
	* Finds a range of all the studies where studyAcronym = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studyAcronym the study acronym to search with
	* @param start the lower bound of the range of studies to return
	* @param end the upper bound of the range of studies to return (not inclusive)
	* @return the range of matching studies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Study> findByStudyAcronym(
		java.lang.String studyAcronym, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStudyAcronym(studyAcronym, start, end);
	}

	/**
	* Finds an ordered range of all the studies where studyAcronym = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studyAcronym the study acronym to search with
	* @param start the lower bound of the range of studies to return
	* @param end the upper bound of the range of studies to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching studies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Study> findByStudyAcronym(
		java.lang.String studyAcronym, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStudyAcronym(studyAcronym, start, end,
			orderByComparator);
	}

	/**
	* Finds the first study in the ordered set where studyAcronym = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studyAcronym the study acronym to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching study
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudyException if a matching study could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.Study findByStudyAcronym_First(
		java.lang.String studyAcronym,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStudyAcronym_First(studyAcronym, orderByComparator);
	}

	/**
	* Finds the last study in the ordered set where studyAcronym = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studyAcronym the study acronym to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching study
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudyException if a matching study could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.Study findByStudyAcronym_Last(
		java.lang.String studyAcronym,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStudyAcronym_Last(studyAcronym, orderByComparator);
	}

	/**
	* Finds the studies before and after the current study in the ordered set where studyAcronym = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param studyId the primary key of the current study
	* @param studyAcronym the study acronym to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next study
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudyException if a study with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.Study[] findByStudyAcronym_PrevAndNext(
		long studyId, java.lang.String studyAcronym,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudyException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStudyAcronym_PrevAndNext(studyId, studyAcronym,
			orderByComparator);
	}

	/**
	* Finds all the studies.
	*
	* @return the studies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Study> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the studies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of studies to return
	* @param end the upper bound of the range of studies to return (not inclusive)
	* @return the range of studies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Study> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the studies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of studies to return
	* @param end the upper bound of the range of studies to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of studies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Study> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the studies where studyName = &#63; from the database.
	*
	* @param studyName the study name to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStudyName(java.lang.String studyName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStudyName(studyName);
	}

	/**
	* Removes all the studies where studyAcronym = &#63; from the database.
	*
	* @param studyAcronym the study acronym to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStudyAcronym(java.lang.String studyAcronym)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStudyAcronym(studyAcronym);
	}

	/**
	* Removes all the studies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the studies where studyName = &#63;.
	*
	* @param studyName the study name to search with
	* @return the number of matching studies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStudyName(java.lang.String studyName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStudyName(studyName);
	}

	/**
	* Counts all the studies where studyAcronym = &#63;.
	*
	* @param studyAcronym the study acronym to search with
	* @return the number of matching studies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStudyAcronym(java.lang.String studyAcronym)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStudyAcronym(studyAcronym);
	}

	/**
	* Counts all the studies.
	*
	* @return the number of studies
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StudyPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StudyPersistence)PortletBeanLocatorUtil.locate(com.jhu.cvrg.portal.guidgenerator.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					StudyPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(StudyPersistence persistence) {
		_persistence = persistence;
	}

	private static StudyPersistence _persistence;
}