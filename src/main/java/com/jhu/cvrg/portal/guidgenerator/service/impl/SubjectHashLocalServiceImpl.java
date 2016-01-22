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

package com.jhu.cvrg.portal.guidgenerator.service.impl;

import java.util.List;

import com.jhu.cvrg.portal.guidgenerator.model.SubjectHash;
import com.jhu.cvrg.portal.guidgenerator.service.base.SubjectHashLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the subject hash local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.jhu.cvrg.portal.guidgenerator.service.SubjectHashLocalService} interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. Always use {@link com.jhu.cvrg.portal.guidgenerator.service.SubjectHashLocalServiceUtil} to access the subject hash local service.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Chris Jurado
 * @see com.jhu.cvrg.portal.guidgenerator.service.base.SubjectHashLocalServiceBaseImpl
 * @see com.jhu.cvrg.portal.guidgenerator.service.SubjectHashLocalServiceUtil
 */
public class SubjectHashLocalServiceImpl extends SubjectHashLocalServiceBaseImpl {
	
	public SubjectHash addsubjectHash(String subjectHashValue) throws SystemException, PortalException {

		SubjectHash newHash = subjectHashPersistence.create(counterLocalService.increment(SubjectHash.class.getName()));
		newHash.setSubjectHashValue(subjectHashValue);

		return subjectHashPersistence.update(newHash, true);
	}
	
	public List<SubjectHash> findSubjectHashByValue(String subjectHashValue){
		List<SubjectHash> hashList = null;
		try {
			hashList = subjectHashPersistence.findBySubjectHashValue(subjectHashValue);
			return hashList;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hashList;
	}
}