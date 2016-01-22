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

import com.jhu.cvrg.portal.guidgenerator.NoSuchStudySiteException;
import com.jhu.cvrg.portal.guidgenerator.model.StudySite;
import com.jhu.cvrg.portal.guidgenerator.model.impl.StudySiteImpl;
import com.jhu.cvrg.portal.guidgenerator.model.impl.StudySiteModelImpl;

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
 * The persistence implementation for the study site service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link StudySiteUtil} to access the study site persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Chris Jurado
 * @see StudySitePersistence
 * @see StudySiteUtil
 * @generated
 */
public class StudySitePersistenceImpl extends BasePersistenceImpl<StudySite>
	implements StudySitePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = StudySiteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_SITEID = new FinderPath(StudySiteModelImpl.ENTITY_CACHE_ENABLED,
			StudySiteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findBySiteId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_SITEID = new FinderPath(StudySiteModelImpl.ENTITY_CACHE_ENABLED,
			StudySiteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countBySiteId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_STUDYID = new FinderPath(StudySiteModelImpl.ENTITY_CACHE_ENABLED,
			StudySiteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByStudyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_STUDYID = new FinderPath(StudySiteModelImpl.ENTITY_CACHE_ENABLED,
			StudySiteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByStudyId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(StudySiteModelImpl.ENTITY_CACHE_ENABLED,
			StudySiteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StudySiteModelImpl.ENTITY_CACHE_ENABLED,
			StudySiteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the study site in the entity cache if it is enabled.
	 *
	 * @param studySite the study site to cache
	 */
	public void cacheResult(StudySite studySite) {
		EntityCacheUtil.putResult(StudySiteModelImpl.ENTITY_CACHE_ENABLED,
			StudySiteImpl.class, studySite.getPrimaryKey(), studySite);
	}

	/**
	 * Caches the study sites in the entity cache if it is enabled.
	 *
	 * @param studySites the study sites to cache
	 */
	public void cacheResult(List<StudySite> studySites) {
		for (StudySite studySite : studySites) {
			if (EntityCacheUtil.getResult(
						StudySiteModelImpl.ENTITY_CACHE_ENABLED,
						StudySiteImpl.class, studySite.getPrimaryKey(), this) == null) {
				cacheResult(studySite);
			}
		}
	}

	/**
	 * Clears the cache for all study sites.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(StudySiteImpl.class.getName());
		EntityCacheUtil.clearCache(StudySiteImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the study site.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(StudySite studySite) {
		EntityCacheUtil.removeResult(StudySiteModelImpl.ENTITY_CACHE_ENABLED,
			StudySiteImpl.class, studySite.getPrimaryKey());
	}

	/**
	 * Creates a new study site with the primary key. Does not add the study site to the database.
	 *
	 * @param studySiteId the primary key for the new study site
	 * @return the new study site
	 */
	public StudySite create(long studySiteId) {
		StudySite studySite = new StudySiteImpl();

		studySite.setNew(true);
		studySite.setPrimaryKey(studySiteId);

		return studySite;
	}

	/**
	 * Removes the study site with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the study site to remove
	 * @return the study site that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a study site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StudySite remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the study site with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studySiteId the primary key of the study site to remove
	 * @return the study site that was removed
	 * @throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudySiteException if a study site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StudySite remove(long studySiteId)
		throws NoSuchStudySiteException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StudySite studySite = (StudySite)session.get(StudySiteImpl.class,
					new Long(studySiteId));

			if (studySite == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + studySiteId);
				}

				throw new NoSuchStudySiteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					studySiteId);
			}

			return remove(studySite);
		}
		catch (NoSuchStudySiteException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StudySite removeImpl(StudySite studySite)
		throws SystemException {
		studySite = toUnwrappedModel(studySite);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, studySite);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(StudySiteModelImpl.ENTITY_CACHE_ENABLED,
			StudySiteImpl.class, studySite.getPrimaryKey());

		return studySite;
	}

	public StudySite updateImpl(
		com.jhu.cvrg.portal.guidgenerator.model.StudySite studySite,
		boolean merge) throws SystemException {
		studySite = toUnwrappedModel(studySite);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, studySite, merge);

			studySite.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(StudySiteModelImpl.ENTITY_CACHE_ENABLED,
			StudySiteImpl.class, studySite.getPrimaryKey(), studySite);

		return studySite;
	}

	protected StudySite toUnwrappedModel(StudySite studySite) {
		if (studySite instanceof StudySiteImpl) {
			return studySite;
		}

		StudySiteImpl studySiteImpl = new StudySiteImpl();

		studySiteImpl.setNew(studySite.isNew());
		studySiteImpl.setPrimaryKey(studySite.getPrimaryKey());

		studySiteImpl.setStudySiteId(studySite.getStudySiteId());
		studySiteImpl.setStudyId(studySite.getStudyId());
		studySiteImpl.setSiteId(studySite.getSiteId());
		studySiteImpl.setLinkingDirection(studySite.getLinkingDirection());

		return studySiteImpl;
	}

	/**
	 * Finds the study site with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the study site to find
	 * @return the study site
	 * @throws com.liferay.portal.NoSuchModelException if a study site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StudySite findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the study site with the primary key or throws a {@link com.jhu.cvrg.portal.guidgenerator.NoSuchStudySiteException} if it could not be found.
	 *
	 * @param studySiteId the primary key of the study site to find
	 * @return the study site
	 * @throws com.jhu.cvrg.portal.guidgenerator.NoSuchStudySiteException if a study site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StudySite findByPrimaryKey(long studySiteId)
		throws NoSuchStudySiteException, SystemException {
		StudySite studySite = fetchByPrimaryKey(studySiteId);

		if (studySite == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + studySiteId);
			}

			throw new NoSuchStudySiteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				studySiteId);
		}

		return studySite;
	}

	/**
	 * Finds the study site with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the study site to find
	 * @return the study site, or <code>null</code> if a study site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StudySite fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the study site with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param studySiteId the primary key of the study site to find
	 * @return the study site, or <code>null</code> if a study site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public StudySite fetchByPrimaryKey(long studySiteId)
		throws SystemException {
		StudySite studySite = (StudySite)EntityCacheUtil.getResult(StudySiteModelImpl.ENTITY_CACHE_ENABLED,
				StudySiteImpl.class, studySiteId, this);

		if (studySite == null) {
			Session session = null;

			try {
				session = openSession();

				studySite = (StudySite)session.get(StudySiteImpl.class,
						new Long(studySiteId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (studySite != null) {
					cacheResult(studySite);
				}

				closeSession(session);
			}
		}

		return studySite;
	}

	/**
	 * Finds all the study sites where siteId = &#63;.
	 *
	 * @param siteId the site id to search with
	 * @return the matching study sites
	 * @throws SystemException if a system exception occurred
	 */
	public List<StudySite> findBySiteId(long siteId) throws SystemException {
		return findBySiteId(siteId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<StudySite> findBySiteId(long siteId, int start, int end)
		throws SystemException {
		return findBySiteId(siteId, start, end, null);
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
	public List<StudySite> findBySiteId(long siteId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				siteId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<StudySite> list = (List<StudySite>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_SITEID,
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

			query.append(_SQL_SELECT_STUDYSITE_WHERE);

			query.append(_FINDER_COLUMN_SITEID_SITEID_2);

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

				qPos.add(siteId);

				list = (List<StudySite>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_SITEID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_SITEID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public StudySite findBySiteId_First(long siteId,
		OrderByComparator orderByComparator)
		throws NoSuchStudySiteException, SystemException {
		List<StudySite> list = findBySiteId(siteId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("siteId=");
			msg.append(siteId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchStudySiteException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public StudySite findBySiteId_Last(long siteId,
		OrderByComparator orderByComparator)
		throws NoSuchStudySiteException, SystemException {
		int count = countBySiteId(siteId);

		List<StudySite> list = findBySiteId(siteId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("siteId=");
			msg.append(siteId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchStudySiteException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public StudySite[] findBySiteId_PrevAndNext(long studySiteId, long siteId,
		OrderByComparator orderByComparator)
		throws NoSuchStudySiteException, SystemException {
		StudySite studySite = findByPrimaryKey(studySiteId);

		Session session = null;

		try {
			session = openSession();

			StudySite[] array = new StudySiteImpl[3];

			array[0] = getBySiteId_PrevAndNext(session, studySite, siteId,
					orderByComparator, true);

			array[1] = studySite;

			array[2] = getBySiteId_PrevAndNext(session, studySite, siteId,
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

	protected StudySite getBySiteId_PrevAndNext(Session session,
		StudySite studySite, long siteId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STUDYSITE_WHERE);

		query.append(_FINDER_COLUMN_SITEID_SITEID_2);

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

		qPos.add(siteId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(studySite);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StudySite> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the study sites where studyId = &#63;.
	 *
	 * @param studyId the study id to search with
	 * @return the matching study sites
	 * @throws SystemException if a system exception occurred
	 */
	public List<StudySite> findByStudyId(long studyId)
		throws SystemException {
		return findByStudyId(studyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<StudySite> findByStudyId(long studyId, int start, int end)
		throws SystemException {
		return findByStudyId(studyId, start, end, null);
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
	public List<StudySite> findByStudyId(long studyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				studyId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<StudySite> list = (List<StudySite>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STUDYID,
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

			query.append(_SQL_SELECT_STUDYSITE_WHERE);

			query.append(_FINDER_COLUMN_STUDYID_STUDYID_2);

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

				qPos.add(studyId);

				list = (List<StudySite>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_STUDYID,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_STUDYID,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public StudySite findByStudyId_First(long studyId,
		OrderByComparator orderByComparator)
		throws NoSuchStudySiteException, SystemException {
		List<StudySite> list = findByStudyId(studyId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("studyId=");
			msg.append(studyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchStudySiteException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public StudySite findByStudyId_Last(long studyId,
		OrderByComparator orderByComparator)
		throws NoSuchStudySiteException, SystemException {
		int count = countByStudyId(studyId);

		List<StudySite> list = findByStudyId(studyId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("studyId=");
			msg.append(studyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchStudySiteException(msg.toString());
		}
		else {
			return list.get(0);
		}
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
	public StudySite[] findByStudyId_PrevAndNext(long studySiteId,
		long studyId, OrderByComparator orderByComparator)
		throws NoSuchStudySiteException, SystemException {
		StudySite studySite = findByPrimaryKey(studySiteId);

		Session session = null;

		try {
			session = openSession();

			StudySite[] array = new StudySiteImpl[3];

			array[0] = getByStudyId_PrevAndNext(session, studySite, studyId,
					orderByComparator, true);

			array[1] = studySite;

			array[2] = getByStudyId_PrevAndNext(session, studySite, studyId,
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

	protected StudySite getByStudyId_PrevAndNext(Session session,
		StudySite studySite, long studyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STUDYSITE_WHERE);

		query.append(_FINDER_COLUMN_STUDYID_STUDYID_2);

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

		qPos.add(studyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(studySite);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StudySite> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the study sites.
	 *
	 * @return the study sites
	 * @throws SystemException if a system exception occurred
	 */
	public List<StudySite> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<StudySite> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<StudySite> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<StudySite> list = (List<StudySite>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STUDYSITE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STUDYSITE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<StudySite>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<StudySite>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the study sites where siteId = &#63; from the database.
	 *
	 * @param siteId the site id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBySiteId(long siteId) throws SystemException {
		for (StudySite studySite : findBySiteId(siteId)) {
			remove(studySite);
		}
	}

	/**
	 * Removes all the study sites where studyId = &#63; from the database.
	 *
	 * @param studyId the study id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByStudyId(long studyId) throws SystemException {
		for (StudySite studySite : findByStudyId(studyId)) {
			remove(studySite);
		}
	}

	/**
	 * Removes all the study sites from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (StudySite studySite : findAll()) {
			remove(studySite);
		}
	}

	/**
	 * Counts all the study sites where siteId = &#63;.
	 *
	 * @param siteId the site id to search with
	 * @return the number of matching study sites
	 * @throws SystemException if a system exception occurred
	 */
	public int countBySiteId(long siteId) throws SystemException {
		Object[] finderArgs = new Object[] { siteId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SITEID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STUDYSITE_WHERE);

			query.append(_FINDER_COLUMN_SITEID_SITEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(siteId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SITEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the study sites where studyId = &#63;.
	 *
	 * @param studyId the study id to search with
	 * @return the number of matching study sites
	 * @throws SystemException if a system exception occurred
	 */
	public int countByStudyId(long studyId) throws SystemException {
		Object[] finderArgs = new Object[] { studyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STUDYID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STUDYSITE_WHERE);

			query.append(_FINDER_COLUMN_STUDYID_STUDYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(studyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STUDYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the study sites.
	 *
	 * @return the number of study sites
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

				Query q = session.createQuery(_SQL_COUNT_STUDYSITE);

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
	 * Initializes the study site persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.jhu.cvrg.portal.guidgenerator.model.StudySite")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StudySite>> listenersList = new ArrayList<ModelListener<StudySite>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StudySite>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StudySiteImpl.class.getName());
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
	private static final String _SQL_SELECT_STUDYSITE = "SELECT studySite FROM StudySite studySite";
	private static final String _SQL_SELECT_STUDYSITE_WHERE = "SELECT studySite FROM StudySite studySite WHERE ";
	private static final String _SQL_COUNT_STUDYSITE = "SELECT COUNT(studySite) FROM StudySite studySite";
	private static final String _SQL_COUNT_STUDYSITE_WHERE = "SELECT COUNT(studySite) FROM StudySite studySite WHERE ";
	private static final String _FINDER_COLUMN_SITEID_SITEID_2 = "studySite.siteId = ?";
	private static final String _FINDER_COLUMN_STUDYID_STUDYID_2 = "studySite.studyId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "studySite.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StudySite exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StudySite exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(StudySitePersistenceImpl.class);
}