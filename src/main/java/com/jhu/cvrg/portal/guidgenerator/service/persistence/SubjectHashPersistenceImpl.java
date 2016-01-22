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

import com.jhu.cvrg.portal.guidgenerator.NoSuchSubjectHashException;
import com.jhu.cvrg.portal.guidgenerator.model.SubjectHash;
import com.jhu.cvrg.portal.guidgenerator.model.impl.SubjectHashImpl;
import com.jhu.cvrg.portal.guidgenerator.model.impl.SubjectHashModelImpl;

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
 * The persistence implementation for the subject hash service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link SubjectHashUtil} to access the subject hash persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Chris Jurado
 * @see SubjectHashPersistence
 * @see SubjectHashUtil
 * @generated
 */
public class SubjectHashPersistenceImpl extends BasePersistenceImpl<SubjectHash>
	implements SubjectHashPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = SubjectHashImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_SUBJECTHASHVALUE = new FinderPath(SubjectHashModelImpl.ENTITY_CACHE_ENABLED,
			SubjectHashModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findBySubjectHashValue",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_SUBJECTHASHVALUE = new FinderPath(SubjectHashModelImpl.ENTITY_CACHE_ENABLED,
			SubjectHashModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countBySubjectHashValue", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(SubjectHashModelImpl.ENTITY_CACHE_ENABLED,
			SubjectHashModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SubjectHashModelImpl.ENTITY_CACHE_ENABLED,
			SubjectHashModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the subject hash in the entity cache if it is enabled.
	 *
	 * @param subjectHash the subject hash to cache
	 */
	public void cacheResult(SubjectHash subjectHash) {
		EntityCacheUtil.putResult(SubjectHashModelImpl.ENTITY_CACHE_ENABLED,
			SubjectHashImpl.class, subjectHash.getPrimaryKey(), subjectHash);
	}

	/**
	 * Caches the subject hashs in the entity cache if it is enabled.
	 *
	 * @param subjectHashs the subject hashs to cache
	 */
	public void cacheResult(List<SubjectHash> subjectHashs) {
		for (SubjectHash subjectHash : subjectHashs) {
			if (EntityCacheUtil.getResult(
						SubjectHashModelImpl.ENTITY_CACHE_ENABLED,
						SubjectHashImpl.class, subjectHash.getPrimaryKey(), this) == null) {
				cacheResult(subjectHash);
			}
		}
	}

	/**
	 * Clears the cache for all subject hashs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(SubjectHashImpl.class.getName());
		EntityCacheUtil.clearCache(SubjectHashImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the subject hash.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(SubjectHash subjectHash) {
		EntityCacheUtil.removeResult(SubjectHashModelImpl.ENTITY_CACHE_ENABLED,
			SubjectHashImpl.class, subjectHash.getPrimaryKey());
	}

	/**
	 * Creates a new subject hash with the primary key. Does not add the subject hash to the database.
	 *
	 * @param subjectHashId the primary key for the new subject hash
	 * @return the new subject hash
	 */
	public SubjectHash create(long subjectHashId) {
		SubjectHash subjectHash = new SubjectHashImpl();

		subjectHash.setNew(true);
		subjectHash.setPrimaryKey(subjectHashId);

		return subjectHash;
	}

	/**
	 * Removes the subject hash with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the subject hash to remove
	 * @return the subject hash that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a subject hash with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SubjectHash remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the subject hash with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subjectHashId the primary key of the subject hash to remove
	 * @return the subject hash that was removed
	 * @throws com.jhu.cvrg.portal.guidgenerator.NoSuchSubjectHashException if a subject hash with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SubjectHash remove(long subjectHashId)
		throws NoSuchSubjectHashException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SubjectHash subjectHash = (SubjectHash)session.get(SubjectHashImpl.class,
					new Long(subjectHashId));

			if (subjectHash == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + subjectHashId);
				}

				throw new NoSuchSubjectHashException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					subjectHashId);
			}

			return remove(subjectHash);
		}
		catch (NoSuchSubjectHashException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SubjectHash removeImpl(SubjectHash subjectHash)
		throws SystemException {
		subjectHash = toUnwrappedModel(subjectHash);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, subjectHash);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(SubjectHashModelImpl.ENTITY_CACHE_ENABLED,
			SubjectHashImpl.class, subjectHash.getPrimaryKey());

		return subjectHash;
	}

	public SubjectHash updateImpl(
		com.jhu.cvrg.portal.guidgenerator.model.SubjectHash subjectHash,
		boolean merge) throws SystemException {
		subjectHash = toUnwrappedModel(subjectHash);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, subjectHash, merge);

			subjectHash.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(SubjectHashModelImpl.ENTITY_CACHE_ENABLED,
			SubjectHashImpl.class, subjectHash.getPrimaryKey(), subjectHash);

		return subjectHash;
	}

	protected SubjectHash toUnwrappedModel(SubjectHash subjectHash) {
		if (subjectHash instanceof SubjectHashImpl) {
			return subjectHash;
		}

		SubjectHashImpl subjectHashImpl = new SubjectHashImpl();

		subjectHashImpl.setNew(subjectHash.isNew());
		subjectHashImpl.setPrimaryKey(subjectHash.getPrimaryKey());

		subjectHashImpl.setSubjectHashId(subjectHash.getSubjectHashId());
		subjectHashImpl.setSubjectHashValue(subjectHash.getSubjectHashValue());

		return subjectHashImpl;
	}

	/**
	 * Finds the subject hash with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the subject hash to find
	 * @return the subject hash
	 * @throws com.liferay.portal.NoSuchModelException if a subject hash with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SubjectHash findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the subject hash with the primary key or throws a {@link com.jhu.cvrg.portal.guidgenerator.NoSuchSubjectHashException} if it could not be found.
	 *
	 * @param subjectHashId the primary key of the subject hash to find
	 * @return the subject hash
	 * @throws com.jhu.cvrg.portal.guidgenerator.NoSuchSubjectHashException if a subject hash with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SubjectHash findByPrimaryKey(long subjectHashId)
		throws NoSuchSubjectHashException, SystemException {
		SubjectHash subjectHash = fetchByPrimaryKey(subjectHashId);

		if (subjectHash == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + subjectHashId);
			}

			throw new NoSuchSubjectHashException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				subjectHashId);
		}

		return subjectHash;
	}

	/**
	 * Finds the subject hash with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the subject hash to find
	 * @return the subject hash, or <code>null</code> if a subject hash with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SubjectHash fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the subject hash with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subjectHashId the primary key of the subject hash to find
	 * @return the subject hash, or <code>null</code> if a subject hash with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SubjectHash fetchByPrimaryKey(long subjectHashId)
		throws SystemException {
		SubjectHash subjectHash = (SubjectHash)EntityCacheUtil.getResult(SubjectHashModelImpl.ENTITY_CACHE_ENABLED,
				SubjectHashImpl.class, subjectHashId, this);

		if (subjectHash == null) {
			Session session = null;

			try {
				session = openSession();

				subjectHash = (SubjectHash)session.get(SubjectHashImpl.class,
						new Long(subjectHashId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (subjectHash != null) {
					cacheResult(subjectHash);
				}

				closeSession(session);
			}
		}

		return subjectHash;
	}

	/**
	 * Finds all the subject hashs where subjectHashValue = &#63;.
	 *
	 * @param subjectHashValue the subject hash value to search with
	 * @return the matching subject hashs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SubjectHash> findBySubjectHashValue(String subjectHashValue)
		throws SystemException {
		return findBySubjectHashValue(subjectHashValue, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<SubjectHash> findBySubjectHashValue(String subjectHashValue,
		int start, int end) throws SystemException {
		return findBySubjectHashValue(subjectHashValue, start, end, null);
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
	public List<SubjectHash> findBySubjectHashValue(String subjectHashValue,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				subjectHashValue,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<SubjectHash> list = (List<SubjectHash>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_SUBJECTHASHVALUE,
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

			query.append(_SQL_SELECT_SUBJECTHASH_WHERE);

			if (subjectHashValue == null) {
				query.append(_FINDER_COLUMN_SUBJECTHASHVALUE_SUBJECTHASHVALUE_1);
			}
			else {
				if (subjectHashValue.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SUBJECTHASHVALUE_SUBJECTHASHVALUE_3);
				}
				else {
					query.append(_FINDER_COLUMN_SUBJECTHASHVALUE_SUBJECTHASHVALUE_2);
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

				if (subjectHashValue != null) {
					qPos.add(subjectHashValue);
				}

				list = (List<SubjectHash>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_SUBJECTHASHVALUE,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_SUBJECTHASHVALUE,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public SubjectHash findBySubjectHashValue_First(String subjectHashValue,
		OrderByComparator orderByComparator)
		throws NoSuchSubjectHashException, SystemException {
		List<SubjectHash> list = findBySubjectHashValue(subjectHashValue, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("subjectHashValue=");
			msg.append(subjectHashValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSubjectHashException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public SubjectHash findBySubjectHashValue_Last(String subjectHashValue,
		OrderByComparator orderByComparator)
		throws NoSuchSubjectHashException, SystemException {
		int count = countBySubjectHashValue(subjectHashValue);

		List<SubjectHash> list = findBySubjectHashValue(subjectHashValue,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("subjectHashValue=");
			msg.append(subjectHashValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSubjectHashException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public SubjectHash[] findBySubjectHashValue_PrevAndNext(
		long subjectHashId, String subjectHashValue,
		OrderByComparator orderByComparator)
		throws NoSuchSubjectHashException, SystemException {
		SubjectHash subjectHash = findByPrimaryKey(subjectHashId);

		Session session = null;

		try {
			session = openSession();

			SubjectHash[] array = new SubjectHashImpl[3];

			array[0] = getBySubjectHashValue_PrevAndNext(session, subjectHash,
					subjectHashValue, orderByComparator, true);

			array[1] = subjectHash;

			array[2] = getBySubjectHashValue_PrevAndNext(session, subjectHash,
					subjectHashValue, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SubjectHash getBySubjectHashValue_PrevAndNext(Session session,
		SubjectHash subjectHash, String subjectHashValue,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUBJECTHASH_WHERE);

		if (subjectHashValue == null) {
			query.append(_FINDER_COLUMN_SUBJECTHASHVALUE_SUBJECTHASHVALUE_1);
		}
		else {
			if (subjectHashValue.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SUBJECTHASHVALUE_SUBJECTHASHVALUE_3);
			}
			else {
				query.append(_FINDER_COLUMN_SUBJECTHASHVALUE_SUBJECTHASHVALUE_2);
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

		if (subjectHashValue != null) {
			qPos.add(subjectHashValue);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(subjectHash);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SubjectHash> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the subject hashs.
	 *
	 * @return the subject hashs
	 * @throws SystemException if a system exception occurred
	 */
	public List<SubjectHash> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<SubjectHash> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<SubjectHash> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<SubjectHash> list = (List<SubjectHash>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SUBJECTHASH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUBJECTHASH;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<SubjectHash>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<SubjectHash>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the subject hashs where subjectHashValue = &#63; from the database.
	 *
	 * @param subjectHashValue the subject hash value to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBySubjectHashValue(String subjectHashValue)
		throws SystemException {
		for (SubjectHash subjectHash : findBySubjectHashValue(subjectHashValue)) {
			remove(subjectHash);
		}
	}

	/**
	 * Removes all the subject hashs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (SubjectHash subjectHash : findAll()) {
			remove(subjectHash);
		}
	}

	/**
	 * Counts all the subject hashs where subjectHashValue = &#63;.
	 *
	 * @param subjectHashValue the subject hash value to search with
	 * @return the number of matching subject hashs
	 * @throws SystemException if a system exception occurred
	 */
	public int countBySubjectHashValue(String subjectHashValue)
		throws SystemException {
		Object[] finderArgs = new Object[] { subjectHashValue };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SUBJECTHASHVALUE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUBJECTHASH_WHERE);

			if (subjectHashValue == null) {
				query.append(_FINDER_COLUMN_SUBJECTHASHVALUE_SUBJECTHASHVALUE_1);
			}
			else {
				if (subjectHashValue.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SUBJECTHASHVALUE_SUBJECTHASHVALUE_3);
				}
				else {
					query.append(_FINDER_COLUMN_SUBJECTHASHVALUE_SUBJECTHASHVALUE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (subjectHashValue != null) {
					qPos.add(subjectHashValue);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SUBJECTHASHVALUE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the subject hashs.
	 *
	 * @return the number of subject hashs
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

				Query q = session.createQuery(_SQL_COUNT_SUBJECTHASH);

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
	 * Initializes the subject hash persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.jhu.cvrg.portal.guidgenerator.model.SubjectHash")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SubjectHash>> listenersList = new ArrayList<ModelListener<SubjectHash>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SubjectHash>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SubjectHashImpl.class.getName());
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
	private static final String _SQL_SELECT_SUBJECTHASH = "SELECT subjectHash FROM SubjectHash subjectHash";
	private static final String _SQL_SELECT_SUBJECTHASH_WHERE = "SELECT subjectHash FROM SubjectHash subjectHash WHERE ";
	private static final String _SQL_COUNT_SUBJECTHASH = "SELECT COUNT(subjectHash) FROM SubjectHash subjectHash";
	private static final String _SQL_COUNT_SUBJECTHASH_WHERE = "SELECT COUNT(subjectHash) FROM SubjectHash subjectHash WHERE ";
	private static final String _FINDER_COLUMN_SUBJECTHASHVALUE_SUBJECTHASHVALUE_1 =
		"subjectHash.subjectHashValue IS NULL";
	private static final String _FINDER_COLUMN_SUBJECTHASHVALUE_SUBJECTHASHVALUE_2 =
		"subjectHash.subjectHashValue = ?";
	private static final String _FINDER_COLUMN_SUBJECTHASHVALUE_SUBJECTHASHVALUE_3 =
		"(subjectHash.subjectHashValue IS NULL OR subjectHash.subjectHashValue = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "subjectHash.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SubjectHash exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SubjectHash exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(SubjectHashPersistenceImpl.class);
}