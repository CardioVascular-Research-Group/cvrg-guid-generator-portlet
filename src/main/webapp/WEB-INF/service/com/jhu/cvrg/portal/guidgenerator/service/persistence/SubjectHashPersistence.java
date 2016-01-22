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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the subject hash service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link SubjectHashUtil} to access the subject hash persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Chris Jurado
 * @see SubjectHashPersistenceImpl
 * @see SubjectHashUtil
 * @generated
 */
public interface SubjectHashPersistence extends BasePersistence<SubjectHash> {
	/**
	* Caches the subject hash in the entity cache if it is enabled.
	*
	* @param subjectHash the subject hash to cache
	*/
	public void cacheResult(
		com.jhu.cvrg.portal.guidgenerator.model.SubjectHash subjectHash);

	/**
	* Caches the subject hashs in the entity cache if it is enabled.
	*
	* @param subjectHashs the subject hashs to cache
	*/
	public void cacheResult(
		java.util.List<com.jhu.cvrg.portal.guidgenerator.model.SubjectHash> subjectHashs);

	/**
	* Creates a new subject hash with the primary key. Does not add the subject hash to the database.
	*
	* @param subjectHashId the primary key for the new subject hash
	* @return the new subject hash
	*/
	public com.jhu.cvrg.portal.guidgenerator.model.SubjectHash create(
		long subjectHashId);

	/**
	* Removes the subject hash with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param subjectHashId the primary key of the subject hash to remove
	* @return the subject hash that was removed
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchSubjectHashException if a subject hash with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jhu.cvrg.portal.guidgenerator.model.SubjectHash remove(
		long subjectHashId)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchSubjectHashException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.jhu.cvrg.portal.guidgenerator.model.SubjectHash updateImpl(
		com.jhu.cvrg.portal.guidgenerator.model.SubjectHash subjectHash,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the subject hash with the primary key or throws a {@link com.jhu.cvrg.portal.guidgenerator.NoSuchSubjectHashException} if it could not be found.
	*
	* @param subjectHashId the primary key of the subject hash to find
	* @return the subject hash
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchSubjectHashException if a subject hash with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jhu.cvrg.portal.guidgenerator.model.SubjectHash findByPrimaryKey(
		long subjectHashId)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchSubjectHashException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the subject hash with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param subjectHashId the primary key of the subject hash to find
	* @return the subject hash, or <code>null</code> if a subject hash with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jhu.cvrg.portal.guidgenerator.model.SubjectHash fetchByPrimaryKey(
		long subjectHashId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the subject hashs where subjectHashValue = &#63;.
	*
	* @param subjectHashValue the subject hash value to search with
	* @return the matching subject hashs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jhu.cvrg.portal.guidgenerator.model.SubjectHash> findBySubjectHashValue(
		java.lang.String subjectHashValue)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.jhu.cvrg.portal.guidgenerator.model.SubjectHash> findBySubjectHashValue(
		java.lang.String subjectHashValue, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.jhu.cvrg.portal.guidgenerator.model.SubjectHash> findBySubjectHashValue(
		java.lang.String subjectHashValue, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.jhu.cvrg.portal.guidgenerator.model.SubjectHash findBySubjectHashValue_First(
		java.lang.String subjectHashValue,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchSubjectHashException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.jhu.cvrg.portal.guidgenerator.model.SubjectHash findBySubjectHashValue_Last(
		java.lang.String subjectHashValue,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchSubjectHashException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.jhu.cvrg.portal.guidgenerator.model.SubjectHash[] findBySubjectHashValue_PrevAndNext(
		long subjectHashId, java.lang.String subjectHashValue,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchSubjectHashException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the subject hashs.
	*
	* @return the subject hashs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jhu.cvrg.portal.guidgenerator.model.SubjectHash> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.jhu.cvrg.portal.guidgenerator.model.SubjectHash> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.jhu.cvrg.portal.guidgenerator.model.SubjectHash> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the subject hashs where subjectHashValue = &#63; from the database.
	*
	* @param subjectHashValue the subject hash value to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySubjectHashValue(java.lang.String subjectHashValue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the subject hashs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the subject hashs where subjectHashValue = &#63;.
	*
	* @param subjectHashValue the subject hash value to search with
	* @return the number of matching subject hashs
	* @throws SystemException if a system exception occurred
	*/
	public int countBySubjectHashValue(java.lang.String subjectHashValue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the subject hashs.
	*
	* @return the number of subject hashs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}