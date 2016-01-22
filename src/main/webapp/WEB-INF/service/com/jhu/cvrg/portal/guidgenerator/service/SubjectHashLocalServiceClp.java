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

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author Chris Jurado
 */
public class SubjectHashLocalServiceClp implements SubjectHashLocalService {
	public SubjectHashLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;
	}

	public com.jhu.cvrg.portal.guidgenerator.model.SubjectHash addSubjectHash(
		com.jhu.cvrg.portal.guidgenerator.model.SubjectHash subjectHash)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addSubjectHashMethodKey0,
				subjectHash);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.jhu.cvrg.portal.guidgenerator.model.SubjectHash)ClpSerializer.translateOutput(returnObj);
	}

	public com.jhu.cvrg.portal.guidgenerator.model.SubjectHash createSubjectHash(
		long subjectHashId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createSubjectHashMethodKey1,
				subjectHashId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.jhu.cvrg.portal.guidgenerator.model.SubjectHash)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteSubjectHash(long subjectHashId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteSubjectHashMethodKey2,
				subjectHashId);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteSubjectHash(
		com.jhu.cvrg.portal.guidgenerator.model.SubjectHash subjectHash)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteSubjectHashMethodKey3,
				subjectHash);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey4,
				dynamicQuery);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey5,
				dynamicQuery, start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey6,
				dynamicQuery, start, end, orderByComparator);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryCountMethodKey7,
				dynamicQuery);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	public com.jhu.cvrg.portal.guidgenerator.model.SubjectHash getSubjectHash(
		long subjectHashId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getSubjectHashMethodKey8,
				subjectHashId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.jhu.cvrg.portal.guidgenerator.model.SubjectHash)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.jhu.cvrg.portal.guidgenerator.model.SubjectHash> getSubjectHashs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getSubjectHashsMethodKey9,
				start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.jhu.cvrg.portal.guidgenerator.model.SubjectHash>)ClpSerializer.translateOutput(returnObj);
	}

	public int getSubjectHashsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getSubjectHashsCountMethodKey10);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public com.jhu.cvrg.portal.guidgenerator.model.SubjectHash updateSubjectHash(
		com.jhu.cvrg.portal.guidgenerator.model.SubjectHash subjectHash)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateSubjectHashMethodKey11,
				subjectHash);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.jhu.cvrg.portal.guidgenerator.model.SubjectHash)ClpSerializer.translateOutput(returnObj);
	}

	public com.jhu.cvrg.portal.guidgenerator.model.SubjectHash updateSubjectHash(
		com.jhu.cvrg.portal.guidgenerator.model.SubjectHash subjectHash,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateSubjectHashMethodKey12,
				subjectHash, merge);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.jhu.cvrg.portal.guidgenerator.model.SubjectHash)ClpSerializer.translateOutput(returnObj);
	}

	public com.jhu.cvrg.portal.guidgenerator.model.SubjectHash addsubjectHash(
		java.lang.String subjectHashValue)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addsubjectHashMethodKey13,
				subjectHashValue);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.jhu.cvrg.portal.guidgenerator.model.SubjectHash)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.jhu.cvrg.portal.guidgenerator.model.SubjectHash> findSubjectHashByValue(
		java.lang.String subjectHashValue) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_findSubjectHashByValueMethodKey14,
				subjectHashValue);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.jhu.cvrg.portal.guidgenerator.model.SubjectHash>)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addSubjectHashMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
			"addSubjectHash",
			com.jhu.cvrg.portal.guidgenerator.model.SubjectHash.class);
	private MethodKey _createSubjectHashMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
			"createSubjectHash", long.class);
	private MethodKey _deleteSubjectHashMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
			"deleteSubjectHash", long.class);
	private MethodKey _deleteSubjectHashMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
			"deleteSubjectHash",
			com.jhu.cvrg.portal.guidgenerator.model.SubjectHash.class);
	private MethodKey _dynamicQueryMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
			"dynamicQuery", com.liferay.portal.kernel.dao.orm.DynamicQuery.class);
	private MethodKey _dynamicQueryMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
			"dynamicQuery",
			com.liferay.portal.kernel.dao.orm.DynamicQuery.class, int.class,
			int.class);
	private MethodKey _dynamicQueryMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
			"dynamicQuery",
			com.liferay.portal.kernel.dao.orm.DynamicQuery.class, int.class,
			int.class, com.liferay.portal.kernel.util.OrderByComparator.class);
	private MethodKey _dynamicQueryCountMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
			"dynamicQueryCount",
			com.liferay.portal.kernel.dao.orm.DynamicQuery.class);
	private MethodKey _getSubjectHashMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
			"getSubjectHash", long.class);
	private MethodKey _getSubjectHashsMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
			"getSubjectHashs", int.class, int.class);
	private MethodKey _getSubjectHashsCountMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
			"getSubjectHashsCount");
	private MethodKey _updateSubjectHashMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
			"updateSubjectHash",
			com.jhu.cvrg.portal.guidgenerator.model.SubjectHash.class);
	private MethodKey _updateSubjectHashMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
			"updateSubjectHash",
			com.jhu.cvrg.portal.guidgenerator.model.SubjectHash.class,
			boolean.class);
	private MethodKey _addsubjectHashMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
			"addsubjectHash", java.lang.String.class);
	private MethodKey _findSubjectHashByValueMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
			"findSubjectHashByValue", java.lang.String.class);
}