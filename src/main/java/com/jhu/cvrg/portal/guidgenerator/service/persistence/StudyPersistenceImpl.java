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

import com.jhu.cvrg.portal.guidgenerator.NoSuchStudyException;
import com.jhu.cvrg.portal.guidgenerator.model.Study;
import com.jhu.cvrg.portal.guidgenerator.model.impl.StudyImpl;
import com.jhu.cvrg.portal.guidgenerator.model.impl.StudyModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the study service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link StudyUtil} to access the study persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Chris Jurado
 * @see StudyPersistence
 * @see StudyUtil
 * @generated
 */
public class StudyPersistenceImpl extends BasePersistenceImpl<Study>
	implements StudyPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = StudyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_STUDYNAME = new FinderPath(StudyModelImpl.ENTITY_CACHE_ENABLED,
			StudyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByStudyName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_STUDYNAME = new FinderPath(StudyModelImpl.ENTITY_CACHE_ENABLED,
			StudyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByStudyName", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_STUDYACRONYM = new FinderPath(StudyModelImpl.ENTITY_CACHE_ENABLED,
			StudyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByStudyAcronym",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_STUDYACRONYM = new FinderPath(StudyModelImpl.ENTITY_CACHE_ENABLED,
			StudyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByStudyAcronym", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(StudyModelImpl.ENTITY_CACHE_ENABLED,
			StudyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StudyModelImpl.ENTITY_CACHE_ENABLED,
			StudyModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the study in the entity cache if it is enabled.
	 *
	 * @param study the study to cache
	 */
	public void cacheResult(Study study) {
		EntityCacheUtil.putResult(StudyModelImpl.ENTITY_CACHE_ENABLED,
			StudyImpl.class, study.getPrimaryKey(), study);
	}

	/**
	 * Caches the studies in the entity cache if it is enabled.
	 *
	 * @param studies the studies to cache
	 */
	public void cacheResult(List<Study> studies) {
		for (Study study : studies) {
			if (EntityCacheUtil.getResult(StudyModelImpl.ENTITY_CACHE_ENABLED,
						StudyImpl.class, study.getPrimaryKey(), this) == null) {
				cacheResult(study);
			}
		}
	}

	/**
	 * Clears the cache for all studies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(StudyImpl.class.getName());
		EntityCacheUtil.clearCache(StudyImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the study.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(Study study) {
		EntityCacheUtil.removeResult(StudyModelImpl.ENTITY_CACHE_ENABLED,
			StudyImpl.class, study.getPrimaryKey());
	}

	/**
	 * Creates a new study with the primary key. Does not add the study to the database.
	 *
	 * @param studyId the primary key for the new study
	 * @return the new study
	 */
	public Study create(long studyId) {
		Study study = new StudyImpl();

		study.setNew(true);
		study.setPrimaryKey(studyId);

		return study;
	}

	/**
	 * Removes the study with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the study to remove
	 * @return the study that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a study with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Study remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the study with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studyId the primary key of the study to remove
	 * @return the study that was removed
	 * @throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudyException if a study with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Study remove(long studyId)
		throws NoSuchStudyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Study study = (Study)session.get(StudyImpl.class, new Long(studyId));

			if (study == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + studyId);
				}

				throw new NoSuchStudyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					studyId);
			}

			return remove(study);
		}
		catch (NoSuchStudyException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Study removeImpl(Study study) throws SystemException {
		study = toUnwrappedModel(study);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, study);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(StudyModelImpl.ENTITY_CACHE_ENABLED,
			StudyImpl.class, study.getPrimaryKey());

		return study;
	}

	public Study updateImpl(
		com.jhu.cvrg.portal.guidgenerator.model.Study study, boolean merge)
		throws SystemException {
		study = toUnwrappedModel(study);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, study, merge);

			study.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(StudyModelImpl.ENTITY_CACHE_ENABLED,
			StudyImpl.class, study.getPrimaryKey(), study);

		return study;
	}

	protected Study toUnwrappedModel(Study study) {
		if (study instanceof StudyImpl) {
			return study;
		}

		StudyImpl studyImpl = new StudyImpl();

		studyImpl.setNew(study.isNew());
		studyImpl.setPrimaryKey(study.getPrimaryKey());

		studyImpl.setStudyId(study.getStudyId());
		studyImpl.setStudyAcronym(study.getStudyAcronym());
		studyImpl.setStudyName(study.getStudyName());

		return studyImpl;
	}

	/**
	 * Finds the study with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the study to find
	 * @return the study
	 * @throws com.liferay.portal.NoSuchModelException if a study with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Study findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the study with the primary key or throws a {@link com.jhu.cvrg.portal.guidgenerator.NoSuchStudyException} if it could not be found.
	 *
	 * @param studyId the primary key of the study to find
	 * @return the study
	 * @throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudyException if a study with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Study findByPrimaryKey(long studyId)
		throws NoSuchStudyException, SystemException {
		Study study = fetchByPrimaryKey(studyId);

		if (study == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + studyId);
			}

			throw new NoSuchStudyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				studyId);
		}

		return study;
	}

	/**
	 * Finds the study with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the study to find
	 * @return the study, or <code>null</code> if a study with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Study fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the study with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param studyId the primary key of the study to find
	 * @return the study, or <code>null</code> if a study with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Study fetchByPrimaryKey(long studyId) throws SystemException {
		Study study = (Study)EntityCacheUtil.getResult(StudyModelImpl.ENTITY_CACHE_ENABLED,
				StudyImpl.class, studyId, this);

		if (study == null) {
			Session session = null;

			try {
				session = openSession();

				study = (Study)session.get(StudyImpl.class, new Long(studyId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (study != null) {
					cacheResult(study);
				}

				closeSession(session);
			}
		}

		return study;
	}

	/**
	 * Finds all the studies where studyName = &#63;.
	 *
	 * @param studyName the study name to search with
	 * @return the matching studies
	 * @throws SystemException if a system exception occurred
	 */
	public List<Study> findByStudyName(String studyName)
		throws SystemException {
		return findByStudyName(studyName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	public List<Study> findByStudyName(String studyName, int start, int end)
		throws SystemException {
		return findByStudyName(studyName, start, end, null);
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
	public List<Study> findByStudyName(String studyName, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				studyName,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Study> list = (List<Study>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STUDYNAME,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_STUDY_WHERE);

			if (studyName == null) {
				query.append(_FINDER_COLUMN_STUDYNAME_STUDYNAME_1);
			}
			else {
				if (studyName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_STUDYNAME_STUDYNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_STUDYNAME_STUDYNAME_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (studyName != null) {
					qPos.add(studyName);
				}

				list = (List<Study>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_STUDYNAME,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_STUDYNAME,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public Study findByStudyName_First(String studyName,
		OrderByComparator orderByComparator)
		throws NoSuchStudyException, SystemException {
		List<Study> list = findByStudyName(studyName, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("studyName=");
			msg.append(studyName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchStudyException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public Study findByStudyName_Last(String studyName,
		OrderByComparator orderByComparator)
		throws NoSuchStudyException, SystemException {
		int count = countByStudyName(studyName);

		List<Study> list = findByStudyName(studyName, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("studyName=");
			msg.append(studyName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchStudyException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public Study[] findByStudyName_PrevAndNext(long studyId, String studyName,
		OrderByComparator orderByComparator)
		throws NoSuchStudyException, SystemException {
		Study study = findByPrimaryKey(studyId);

		Session session = null;

		try {
			session = openSession();

			Study[] array = new StudyImpl[3];

			array[0] = getByStudyName_PrevAndNext(session, study, studyName,
					orderByComparator, true);

			array[1] = study;

			array[2] = getByStudyName_PrevAndNext(session, study, studyName,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Study getByStudyName_PrevAndNext(Session session, Study study,
		String studyName, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STUDY_WHERE);

		if (studyName == null) {
			query.append(_FINDER_COLUMN_STUDYNAME_STUDYNAME_1);
		}
		else {
			if (studyName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STUDYNAME_STUDYNAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_STUDYNAME_STUDYNAME_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (studyName != null) {
			qPos.add(studyName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(study);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Study> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the studies where studyAcronym = &#63;.
	 *
	 * @param studyAcronym the study acronym to search with
	 * @return the matching studies
	 * @throws SystemException if a system exception occurred
	 */
	public List<Study> findByStudyAcronym(String studyAcronym)
		throws SystemException {
		return findByStudyAcronym(studyAcronym, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<Study> findByStudyAcronym(String studyAcronym, int start,
		int end) throws SystemException {
		return findByStudyAcronym(studyAcronym, start, end, null);
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
	public List<Study> findByStudyAcronym(String studyAcronym, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				studyAcronym,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Study> list = (List<Study>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STUDYACRONYM,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_STUDY_WHERE);

			if (studyAcronym == null) {
				query.append(_FINDER_COLUMN_STUDYACRONYM_STUDYACRONYM_1);
			}
			else {
				if (studyAcronym.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_STUDYACRONYM_STUDYACRONYM_3);
				}
				else {
					query.append(_FINDER_COLUMN_STUDYACRONYM_STUDYACRONYM_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (studyAcronym != null) {
					qPos.add(studyAcronym);
				}

				list = (List<Study>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_STUDYACRONYM,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_STUDYACRONYM,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public Study findByStudyAcronym_First(String studyAcronym,
		OrderByComparator orderByComparator)
		throws NoSuchStudyException, SystemException {
		List<Study> list = findByStudyAcronym(studyAcronym, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("studyAcronym=");
			msg.append(studyAcronym);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchStudyException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public Study findByStudyAcronym_Last(String studyAcronym,
		OrderByComparator orderByComparator)
		throws NoSuchStudyException, SystemException {
		int count = countByStudyAcronym(studyAcronym);

		List<Study> list = findByStudyAcronym(studyAcronym, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("studyAcronym=");
			msg.append(studyAcronym);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchStudyException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public Study[] findByStudyAcronym_PrevAndNext(long studyId,
		String studyAcronym, OrderByComparator orderByComparator)
		throws NoSuchStudyException, SystemException {
		Study study = findByPrimaryKey(studyId);

		Session session = null;

		try {
			session = openSession();

			Study[] array = new StudyImpl[3];

			array[0] = getByStudyAcronym_PrevAndNext(session, study,
					studyAcronym, orderByComparator, true);

			array[1] = study;

			array[2] = getByStudyAcronym_PrevAndNext(session, study,
					studyAcronym, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Study getByStudyAcronym_PrevAndNext(Session session, Study study,
		String studyAcronym, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STUDY_WHERE);

		if (studyAcronym == null) {
			query.append(_FINDER_COLUMN_STUDYACRONYM_STUDYACRONYM_1);
		}
		else {
			if (studyAcronym.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STUDYACRONYM_STUDYACRONYM_3);
			}
			else {
				query.append(_FINDER_COLUMN_STUDYACRONYM_STUDYACRONYM_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (studyAcronym != null) {
			qPos.add(studyAcronym);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(study);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Study> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the studies.
	 *
	 * @return the studies
	 * @throws SystemException if a system exception occurred
	 */
	public List<Study> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Study> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<Study> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Study> list = (List<Study>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STUDY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STUDY;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Study>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Study>)QueryUtil.list(q, getDialect(), start,
							end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_ALL,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs,
						list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the studies where studyName = &#63; from the database.
	 *
	 * @param studyName the study name to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStudyName(String studyName) throws SystemException {
		for (Study study : findByStudyName(studyName)) {
			remove(study);
		}
	}

	/**
	 * Removes all the studies where studyAcronym = &#63; from the database.
	 *
	 * @param studyAcronym the study acronym to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStudyAcronym(String studyAcronym)
		throws SystemException {
		for (Study study : findByStudyAcronym(studyAcronym)) {
			remove(study);
		}
	}

	/**
	 * Removes all the studies from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Study study : findAll()) {
			remove(study);
		}
	}

	/**
	 * Counts all the studies where studyName = &#63;.
	 *
	 * @param studyName the study name to search with
	 * @return the number of matching studies
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStudyName(String studyName) throws SystemException {
		Object[] finderArgs = new Object[] { studyName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STUDYNAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STUDY_WHERE);

			if (studyName == null) {
				query.append(_FINDER_COLUMN_STUDYNAME_STUDYNAME_1);
			}
			else {
				if (studyName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_STUDYNAME_STUDYNAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_STUDYNAME_STUDYNAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (studyName != null) {
					qPos.add(studyName);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STUDYNAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the studies where studyAcronym = &#63;.
	 *
	 * @param studyAcronym the study acronym to search with
	 * @return the number of matching studies
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStudyAcronym(String studyAcronym)
		throws SystemException {
		Object[] finderArgs = new Object[] { studyAcronym };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STUDYACRONYM,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STUDY_WHERE);

			if (studyAcronym == null) {
				query.append(_FINDER_COLUMN_STUDYACRONYM_STUDYACRONYM_1);
			}
			else {
				if (studyAcronym.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_STUDYACRONYM_STUDYACRONYM_3);
				}
				else {
					query.append(_FINDER_COLUMN_STUDYACRONYM_STUDYACRONYM_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (studyAcronym != null) {
					qPos.add(studyAcronym);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STUDYACRONYM,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the studies.
	 *
	 * @return the number of studies
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STUDY);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the study persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.jhu.cvrg.portal.guidgenerator.model.Study")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Study>> listenersList = new ArrayList<ModelListener<Study>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Study>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(StudyImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST);
	}

	@BeanReference(type = StudyPersistence.class)
	protected StudyPersistence studyPersistence;
	@BeanReference(type = SitePersistence.class)
	protected SitePersistence sitePersistence;
	@BeanReference(type = StudySitePersistence.class)
	protected StudySitePersistence studySitePersistence;
	@BeanReference(type = SubjectHashPersistence.class)
	protected SubjectHashPersistence subjectHashPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_STUDY = "SELECT study FROM Study study";
	private static final String _SQL_SELECT_STUDY_WHERE = "SELECT study FROM Study study WHERE ";
	private static final String _SQL_COUNT_STUDY = "SELECT COUNT(study) FROM Study study";
	private static final String _SQL_COUNT_STUDY_WHERE = "SELECT COUNT(study) FROM Study study WHERE ";
	private static final String _FINDER_COLUMN_STUDYNAME_STUDYNAME_1 = "study.studyName IS NULL";
	private static final String _FINDER_COLUMN_STUDYNAME_STUDYNAME_2 = "study.studyName = ?";
	private static final String _FINDER_COLUMN_STUDYNAME_STUDYNAME_3 = "(study.studyName IS NULL OR study.studyName = ?)";
	private static final String _FINDER_COLUMN_STUDYACRONYM_STUDYACRONYM_1 = "study.studyAcronym IS NULL";
	private static final String _FINDER_COLUMN_STUDYACRONYM_STUDYACRONYM_2 = "study.studyAcronym = ?";
	private static final String _FINDER_COLUMN_STUDYACRONYM_STUDYACRONYM_3 = "(study.studyAcronym IS NULL OR study.studyAcronym = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "study.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Study exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Study exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(StudyPersistenceImpl.class);
}