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
 * This class is a wrapper for {@link SubjectHashLocalService}.
 * </p>
 *
 * @author    Chris Jurado
 * @see       SubjectHashLocalService
 * @generated
 */
public class SubjectHashLocalServiceWrapper implements SubjectHashLocalService {
	public SubjectHashLocalServiceWrapper(
		SubjectHashLocalService subjectHashLocalService) {
		_subjectHashLocalService = subjectHashLocalService;
	}

	/**
	* Adds the subject hash to the database. Also notifies the appropriate model listeners.
	*
	* @param subjectHash the subject hash to add
	* @return the subject hash that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.jhu.cvrg.portal.guidgenerator.model.SubjectHash addSubjectHash(
		com.jhu.cvrg.portal.guidgenerator.model.SubjectHash subjectHash)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectHashLocalService.addSubjectHash(subjectHash);
	}

	/**
	* Creates a new subject hash with the primary key. Does not add the subject hash to the database.
	*
	* @param subjectHashId the primary key for the new subject hash
	* @return the new subject hash
	*/
	public com.jhu.cvrg.portal.guidgenerator.model.SubjectHash createSubjectHash(
		long subjectHashId) {
		return _subjectHashLocalService.createSubjectHash(subjectHashId);
	}

	/**
	* Deletes the subject hash with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param subjectHashId the primary key of the subject hash to delete
	* @throws PortalException if a subject hash with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteSubjectHash(long subjectHashId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_subjectHashLocalService.deleteSubjectHash(subjectHashId);
	}

	/**
	* Deletes the subject hash from the database. Also notifies the appropriate model listeners.
	*
	* @param subjectHash the subject hash to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteSubjectHash(
		com.jhu.cvrg.portal.guidgenerator.model.SubjectHash subjectHash)
		throws com.liferay.portal.kernel.exception.SystemException {
		_subjectHashLocalService.deleteSubjectHash(subjectHash);
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
		return _subjectHashLocalService.dynamicQuery(dynamicQuery);
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
		return _subjectHashLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _subjectHashLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _subjectHashLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the subject hash with the primary key.
	*
	* @param subjectHashId the primary key of the subject hash to get
	* @return the subject hash
	* @throws PortalException if a subject hash with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jhu.cvrg.portal.guidgenerator.model.SubjectHash getSubjectHash(
		long subjectHashId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subjectHashLocalService.getSubjectHash(subjectHashId);
	}

	/**
	* Gets a range of all the subject hashs.
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
	public java.util.List<com.jhu.cvrg.portal.guidgenerator.model.SubjectHash> getSubjectHashs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectHashLocalService.getSubjectHashs(start, end);
	}

	/**
	* Gets the number of subject hashs.
	*
	* @return the number of subject hashs
	* @throws SystemException if a system exception occurred
	*/
	public int getSubjectHashsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectHashLocalService.getSubjectHashsCount();
	}

	/**
	* Updates the subject hash in the database. Also notifies the appropriate model listeners.
	*
	* @param subjectHash the subject hash to update
	* @return the subject hash that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.jhu.cvrg.portal.guidgenerator.model.SubjectHash updateSubjectHash(
		com.jhu.cvrg.portal.guidgenerator.model.SubjectHash subjectHash)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectHashLocalService.updateSubjectHash(subjectHash);
	}

	/**
	* Updates the subject hash in the database. Also notifies the appropriate model listeners.
	*
	* @param subjectHash the subject hash to update
	* @param merge whether to merge the subject hash with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the subject hash that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.jhu.cvrg.portal.guidgenerator.model.SubjectHash updateSubjectHash(
		com.jhu.cvrg.portal.guidgenerator.model.SubjectHash subjectHash,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _subjectHashLocalService.updateSubjectHash(subjectHash, merge);
	}

	public com.jhu.cvrg.portal.guidgenerator.model.SubjectHash addsubjectHash(
		java.lang.String subjectHashValue)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _subjectHashLocalService.addsubjectHash(subjectHashValue);
	}

	public java.util.List<com.jhu.cvrg.portal.guidgenerator.model.SubjectHash> findSubjectHashByValue(
		java.lang.String subjectHashValue) {
		return _subjectHashLocalService.findSubjectHashByValue(subjectHashValue);
	}

	public SubjectHashLocalService getWrappedSubjectHashLocalService() {
		return _subjectHashLocalService;
	}

	private SubjectHashLocalService _subjectHashLocalService;
}