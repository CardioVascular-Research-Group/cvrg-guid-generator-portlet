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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * The utility for the subject hash local service. This utility wraps {@link com.jhu.cvrg.portal.guidgenerator.service.impl.SubjectHashLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.jhu.cvrg.portal.guidgenerator.service.impl.SubjectHashLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Chris Jurado
 * @see SubjectHashLocalService
 * @see com.jhu.cvrg.portal.guidgenerator.service.base.SubjectHashLocalServiceBaseImpl
 * @see com.jhu.cvrg.portal.guidgenerator.service.impl.SubjectHashLocalServiceImpl
 * @generated
 */
public class SubjectHashLocalServiceUtil {
	/**
	* Adds the subject hash to the database. Also notifies the appropriate model listeners.
	*
	* @param subjectHash the subject hash to add
	* @return the subject hash that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.SubjectHash addSubjectHash(
		com.jhu.cvrg.portal.guidgenerator.model.SubjectHash subjectHash)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSubjectHash(subjectHash);
	}

	/**
	* Creates a new subject hash with the primary key. Does not add the subject hash to the database.
	*
	* @param subjectHashId the primary key for the new subject hash
	* @return the new subject hash
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.SubjectHash createSubjectHash(
		long subjectHashId) {
		return getService().createSubjectHash(subjectHashId);
	}

	/**
	* Deletes the subject hash with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param subjectHashId the primary key of the subject hash to delete
	* @throws PortalException if a subject hash with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteSubjectHash(long subjectHashId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteSubjectHash(subjectHashId);
	}

	/**
	* Deletes the subject hash from the database. Also notifies the appropriate model listeners.
	*
	* @param subjectHash the subject hash to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteSubjectHash(
		com.jhu.cvrg.portal.guidgenerator.model.SubjectHash subjectHash)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteSubjectHash(subjectHash);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the subject hash with the primary key.
	*
	* @param subjectHashId the primary key of the subject hash to get
	* @return the subject hash
	* @throws PortalException if a subject hash with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.SubjectHash getSubjectHash(
		long subjectHashId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubjectHash(subjectHashId);
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
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.SubjectHash> getSubjectHashs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubjectHashs(start, end);
	}

	/**
	* Gets the number of subject hashs.
	*
	* @return the number of subject hashs
	* @throws SystemException if a system exception occurred
	*/
	public static int getSubjectHashsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSubjectHashsCount();
	}

	/**
	* Updates the subject hash in the database. Also notifies the appropriate model listeners.
	*
	* @param subjectHash the subject hash to update
	* @return the subject hash that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.SubjectHash updateSubjectHash(
		com.jhu.cvrg.portal.guidgenerator.model.SubjectHash subjectHash)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSubjectHash(subjectHash);
	}

	/**
	* Updates the subject hash in the database. Also notifies the appropriate model listeners.
	*
	* @param subjectHash the subject hash to update
	* @param merge whether to merge the subject hash with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the subject hash that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.SubjectHash updateSubjectHash(
		com.jhu.cvrg.portal.guidgenerator.model.SubjectHash subjectHash,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSubjectHash(subjectHash, merge);
	}

	public static com.jhu.cvrg.portal.guidgenerator.model.SubjectHash addsubjectHash(
		java.lang.String subjectHashValue)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addsubjectHash(subjectHashValue);
	}

	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.SubjectHash> findSubjectHashByValue(
		java.lang.String subjectHashValue) {
		return getService().findSubjectHashByValue(subjectHashValue);
	}

	public static void clearService() {
		_service = null;
	}

	public static SubjectHashLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					SubjectHashLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new SubjectHashLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(SubjectHashLocalService service) {
		_service = service;
	}

	private static SubjectHashLocalService _service;
}