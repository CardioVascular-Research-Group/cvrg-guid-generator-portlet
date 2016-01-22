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

import com.jhu.cvrg.portal.guidgenerator.model.SubjectHash;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the subject hash service. This utility wraps {@link SubjectHashPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
 * @see SubjectHashPersistence
 * @see SubjectHashPersistenceImpl
 * @generated
 */
public class SubjectHashUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(SubjectHash subjectHash) {
		getPersistence().clearCache(subjectHash);
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
	public static List<SubjectHash> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SubjectHash> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SubjectHash> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static SubjectHash remove(SubjectHash subjectHash)
		throws SystemException {
		return getPersistence().remove(subjectHash);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static SubjectHash update(SubjectHash subjectHash, boolean merge)
		throws SystemException {
		return getPersistence().update(subjectHash, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static SubjectHash update(SubjectHash subjectHash, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(subjectHash, merge, serviceContext);
	}

	/**
	* Caches the subject hash in the entity cache if it is enabled.
	*
	* @param subjectHash the subject hash to cache
	*/
	public static void cacheResult(
		com.jhu.cvrg.portal.guidgenerator.model.SubjectHash subjectHash) {
		getPersistence().cacheResult(subjectHash);
	}

	/**
	* Caches the subject hashs in the entity cache if it is enabled.
	*
	* @param subjectHashs the subject hashs to cache
	*/
	public static void cacheResult(
		java.util.List<com.jhu.cvrg.portal.guidgenerator.model.SubjectHash> subjectHashs) {
		getPersistence().cacheResult(subjectHashs);
	}

	/**
	* Creates a new subject hash with the primary key. Does not add the subject hash to the database.
	*
	* @param subjectHashId the primary key for the new subject hash
	* @return the new subject hash
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.SubjectHash create(
		long subjectHashId) {
		return getPersistence().create(subjectHashId);
	}

	/**
	* Removes the subject hash with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param subjectHashId the primary key of the subject hash to remove
	* @return the subject hash that was removed
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchSubjectHashException if a subject hash with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.SubjectHash remove(
		long subjectHashId)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchSubjectHashException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(subjectHashId);
	}

	public static com.jhu.cvrg.portal.guidgenerator.model.SubjectHash updateImpl(
		com.jhu.cvrg.portal.guidgenerator.model.SubjectHash subjectHash,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(subjectHash, merge);
	}

	/**
	* Finds the subject hash with the primary key or throws a {@link com.jhu.cvrg.portal.guidgenerator.NoSuchSubjectHashException} if it could not be found.
	*
	* @param subjectHashId the primary key of the subject hash to find
	* @return the subject hash
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchSubjectHashException if a subject hash with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.SubjectHash findByPrimaryKey(
		long subjectHashId)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchSubjectHashException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(subjectHashId);
	}

	/**
	* Finds the subject hash with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param subjectHashId the primary key of the subject hash to find
	* @return the subject hash, or <code>null</code> if a subject hash with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.SubjectHash fetchByPrimaryKey(
		long subjectHashId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(subjectHashId);
	}

	/**
	* Finds all the subject hashs where subjectHashValue = &#63;.
	*
	* @param subjectHashValue the subject hash value to search with
	* @return the matching subject hashs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.SubjectHash> findBySubjectHashValue(
		java.lang.String subjectHashValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySubjectHashValue(subjectHashValue);
	}

	/**
	* Finds a range of all the subject hashs where subjectHashValue = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param subjectHashValue the subject hash value to search with
	* @param start the lower bound of the range of subject hashs to return
	* @param end the upper bound of the range of subject hashs to return (not inclusive)
	* @return the range of matching subject hashs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.SubjectHash> findBySubjectHashValue(
		java.lang.String subjectHashValue, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySubjectHashValue(subjectHashValue, start, end);
	}

	/**
	* Finds an ordered range of all the subject hashs where subjectHashValue = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param subjectHashValue the subject hash value to search with
	* @param start the lower bound of the range of subject hashs to return
	* @param end the upper bound of the range of subject hashs to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching subject hashs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.SubjectHash> findBySubjectHashValue(
		java.lang.String subjectHashValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySubjectHashValue(subjectHashValue, start, end,
			orderByComparator);
	}

	/**
	* Finds the first subject hash in the ordered set where subjectHashValue = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param subjectHashValue the subject hash value to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching subject hash
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchSubjectHashException if a matching subject hash could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.SubjectHash findBySubjectHashValue_First(
		java.lang.String subjectHashValue,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchSubjectHashException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySubjectHashValue_First(subjectHashValue,
			orderByComparator);
	}

	/**
	* Finds the last subject hash in the ordered set where subjectHashValue = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param subjectHashValue the subject hash value to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching subject hash
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchSubjectHashException if a matching subject hash could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.SubjectHash findBySubjectHashValue_Last(
		java.lang.String subjectHashValue,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchSubjectHashException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySubjectHashValue_Last(subjectHashValue,
			orderByComparator);
	}

	/**
	* Finds the subject hashs before and after the current subject hash in the ordered set where subjectHashValue = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param subjectHashId the primary key of the current subject hash
	* @param subjectHashValue the subject hash value to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next subject hash
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchSubjectHashException if a subject hash with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.SubjectHash[] findBySubjectHashValue_PrevAndNext(
		long subjectHashId, java.lang.String subjectHashValue,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchSubjectHashException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySubjectHashValue_PrevAndNext(subjectHashId,
			subjectHashValue, orderByComparator);
	}

	/**
	* Finds all the subject hashs.
	*
	* @return the subject hashs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.SubjectHash> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Finds a range of all the subject hashs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of subject hashs to return
	* @param end the upper bound of the range of subject hashs to return (not inclusive)
	* @return the range of subject hashs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.SubjectHash> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Finds an ordered range of all the subject hashs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of subject hashs to return
	* @param end the upper bound of the range of subject hashs to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of subject hashs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.SubjectHash> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the subject hashs where subjectHashValue = &#63; from the database.
	*
	* @param subjectHashValue the subject hash value to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySubjectHashValue(
		java.lang.String subjectHashValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySubjectHashValue(subjectHashValue);
	}

	/**
	* Removes all the subject hashs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the subject hashs where subjectHashValue = &#63;.
	*
	* @param subjectHashValue the subject hash value to search with
	* @return the number of matching subject hashs
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySubjectHashValue(java.lang.String subjectHashValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySubjectHashValue(subjectHashValue);
	}

	/**
	* Counts all the subject hashs.
	*
	* @return the number of subject hashs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SubjectHashPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SubjectHashPersistence)PortletBeanLocatorUtil.locate(com.jhu.cvrg.portal.guidgenerator.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					SubjectHashPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(SubjectHashPersistence persistence) {
		_persistence = persistence;
	}

	private static SubjectHashPersistence _persistence;
}