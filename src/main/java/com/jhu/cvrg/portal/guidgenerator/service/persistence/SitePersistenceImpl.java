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

import com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException;
import com.jhu.cvrg.portal.guidgenerator.model.Site;
import com.jhu.cvrg.portal.guidgenerator.model.impl.SiteImpl;
import com.jhu.cvrg.portal.guidgenerator.model.impl.SiteModelImpl;

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
 * The persistence implementation for the site service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link SiteUtil} to access the site persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Chris Jurado
 * @see SitePersistence
 * @see SiteUtil
 * @generated
 */
public class SitePersistenceImpl extends BasePersistenceImpl<Site>
	implements SitePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = SiteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_SITENAME = new FinderPath(SiteModelImpl.ENTITY_CACHE_ENABLED,
			SiteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findBySiteName",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_SITENAME = new FinderPath(SiteModelImpl.ENTITY_CACHE_ENABLED,
			SiteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countBySiteName", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_SITEACRONYM = new FinderPath(SiteModelImpl.ENTITY_CACHE_ENABLED,
			SiteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findBySiteAcronym",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_SITEACRONYM = new FinderPath(SiteModelImpl.ENTITY_CACHE_ENABLED,
			SiteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countBySiteAcronym", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(SiteModelImpl.ENTITY_CACHE_ENABLED,
			SiteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SiteModelImpl.ENTITY_CACHE_ENABLED,
			SiteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the site in the entity cache if it is enabled.
	 *
	 * @param site the site to cache
	 */
	public void cacheResult(Site site) {
		EntityCacheUtil.putResult(SiteModelImpl.ENTITY_CACHE_ENABLED,
			SiteImpl.class, site.getPrimaryKey(), site);
	}

	/**
	 * Caches the sites in the entity cache if it is enabled.
	 *
	 * @param sites the sites to cache
	 */
	public void cacheResult(List<Site> sites) {
		for (Site site : sites) {
			if (EntityCacheUtil.getResult(SiteModelImpl.ENTITY_CACHE_ENABLED,
						SiteImpl.class, site.getPrimaryKey(), this) == null) {
				cacheResult(site);
			}
		}
	}

	/**
	 * Clears the cache for all sites.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(SiteImpl.class.getName());
		EntityCacheUtil.clearCache(SiteImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the site.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(Site site) {
		EntityCacheUtil.removeResult(SiteModelImpl.ENTITY_CACHE_ENABLED,
			SiteImpl.class, site.getPrimaryKey());
	}

	/**
	 * Creates a new site with the primary key. Does not add the site to the database.
	 *
	 * @param siteId the primary key for the new site
	 * @return the new site
	 */
	public Site create(long siteId) {
		Site site = new SiteImpl();

		site.setNew(true);
		site.setPrimaryKey(siteId);

		return site;
	}

	/**
	 * Removes the site with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the site to remove
	 * @return the site that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Site remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the site with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param siteId the primary key of the site to remove
	 * @return the site that was removed
	 * @throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException if a site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Site remove(long siteId) throws NoSuchSiteException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Site site = (Site)session.get(SiteImpl.class, new Long(siteId));

			if (site == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + siteId);
				}

				throw new NoSuchSiteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					siteId);
			}

			return remove(site);
		}
		catch (NoSuchSiteException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Site removeImpl(Site site) throws SystemException {
		site = toUnwrappedModel(site);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, site);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(SiteModelImpl.ENTITY_CACHE_ENABLED,
			SiteImpl.class, site.getPrimaryKey());

		return site;
	}

	public Site updateImpl(com.jhu.cvrg.portal.guidgenerator.model.Site site,
		boolean merge) throws SystemException {
		site = toUnwrappedModel(site);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, site, merge);

			site.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(SiteModelImpl.ENTITY_CACHE_ENABLED,
			SiteImpl.class, site.getPrimaryKey(), site);

		return site;
	}

	protected Site toUnwrappedModel(Site site) {
		if (site instanceof SiteImpl) {
			return site;
		}

		SiteImpl siteImpl = new SiteImpl();

		siteImpl.setNew(site.isNew());
		siteImpl.setPrimaryKey(site.getPrimaryKey());

		siteImpl.setSiteId(site.getSiteId());
		siteImpl.setSiteAcronym(site.getSiteAcronym());
		siteImpl.setSiteName(site.getSiteName());

		return siteImpl;
	}

	/**
	 * Finds the site with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the site to find
	 * @return the site
	 * @throws com.liferay.portal.NoSuchModelException if a site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Site findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the site with the primary key or throws a {@link com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException} if it could not be found.
	 *
	 * @param siteId the primary key of the site to find
	 * @return the site
	 * @throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException if a site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Site findByPrimaryKey(long siteId)
		throws NoSuchSiteException, SystemException {
		Site site = fetchByPrimaryKey(siteId);

		if (site == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + siteId);
			}

			throw new NoSuchSiteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				siteId);
		}

		return site;
	}

	/**
	 * Finds the site with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the site to find
	 * @return the site, or <code>null</code> if a site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Site fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the site with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param siteId the primary key of the site to find
	 * @return the site, or <code>null</code> if a site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Site fetchByPrimaryKey(long siteId) throws SystemException {
		Site site = (Site)EntityCacheUtil.getResult(SiteModelImpl.ENTITY_CACHE_ENABLED,
				SiteImpl.class, siteId, this);

		if (site == null) {
			Session session = null;

			try {
				session = openSession();

				site = (Site)session.get(SiteImpl.class, new Long(siteId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (site != null) {
					cacheResult(site);
				}

				closeSession(session);
			}
		}

		return site;
	}

	/**
	 * Finds all the sites where siteName = &#63;.
	 *
	 * @param siteName the site name to search with
	 * @return the matching sites
	 * @throws SystemException if a system exception occurred
	 */
	public List<Site> findBySiteName(String siteName) throws SystemException {
		return findBySiteName(siteName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Finds a range of all the sites where siteName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param siteName the site name to search with
	 * @param start the lower bound of the range of sites to return
	 * @param end the upper bound of the range of sites to return (not inclusive)
	 * @return the range of matching sites
	 * @throws SystemException if a system exception occurred
	 */
	public List<Site> findBySiteName(String siteName, int start, int end)
		throws SystemException {
		return findBySiteName(siteName, start, end, null);
	}

	/**
	 * Finds an ordered range of all the sites where siteName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param siteName the site name to search with
	 * @param start the lower bound of the range of sites to return
	 * @param end the upper bound of the range of sites to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching sites
	 * @throws SystemException if a system exception occurred
	 */
	public List<Site> findBySiteName(String siteName, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				siteName,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Site> list = (List<Site>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_SITENAME,
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

			query.append(_SQL_SELECT_SITE_WHERE);

			if (siteName == null) {
				query.append(_FINDER_COLUMN_SITENAME_SITENAME_1);
			}
			else {
				if (siteName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SITENAME_SITENAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_SITENAME_SITENAME_2);
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

				if (siteName != null) {
					qPos.add(siteName);
				}

				list = (List<Site>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_SITENAME,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_SITENAME,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first site in the ordered set where siteName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param siteName the site name to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching site
	 * @throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException if a matching site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Site findBySiteName_First(String siteName,
		OrderByComparator orderByComparator)
		throws NoSuchSiteException, SystemException {
		List<Site> list = findBySiteName(siteName, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("siteName=");
			msg.append(siteName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSiteException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last site in the ordered set where siteName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param siteName the site name to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching site
	 * @throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException if a matching site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Site findBySiteName_Last(String siteName,
		OrderByComparator orderByComparator)
		throws NoSuchSiteException, SystemException {
		int count = countBySiteName(siteName);

		List<Site> list = findBySiteName(siteName, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("siteName=");
			msg.append(siteName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSiteException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the sites before and after the current site in the ordered set where siteName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param siteId the primary key of the current site
	 * @param siteName the site name to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next site
	 * @throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException if a site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Site[] findBySiteName_PrevAndNext(long siteId, String siteName,
		OrderByComparator orderByComparator)
		throws NoSuchSiteException, SystemException {
		Site site = findByPrimaryKey(siteId);

		Session session = null;

		try {
			session = openSession();

			Site[] array = new SiteImpl[3];

			array[0] = getBySiteName_PrevAndNext(session, site, siteName,
					orderByComparator, true);

			array[1] = site;

			array[2] = getBySiteName_PrevAndNext(session, site, siteName,
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

	protected Site getBySiteName_PrevAndNext(Session session, Site site,
		String siteName, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SITE_WHERE);

		if (siteName == null) {
			query.append(_FINDER_COLUMN_SITENAME_SITENAME_1);
		}
		else {
			if (siteName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SITENAME_SITENAME_3);
			}
			else {
				query.append(_FINDER_COLUMN_SITENAME_SITENAME_2);
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

		if (siteName != null) {
			qPos.add(siteName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(site);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Site> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the sites where siteAcronym = &#63;.
	 *
	 * @param siteAcronym the site acronym to search with
	 * @return the matching sites
	 * @throws SystemException if a system exception occurred
	 */
	public List<Site> findBySiteAcronym(String siteAcronym)
		throws SystemException {
		return findBySiteAcronym(siteAcronym, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the sites where siteAcronym = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param siteAcronym the site acronym to search with
	 * @param start the lower bound of the range of sites to return
	 * @param end the upper bound of the range of sites to return (not inclusive)
	 * @return the range of matching sites
	 * @throws SystemException if a system exception occurred
	 */
	public List<Site> findBySiteAcronym(String siteAcronym, int start, int end)
		throws SystemException {
		return findBySiteAcronym(siteAcronym, start, end, null);
	}

	/**
	 * Finds an ordered range of all the sites where siteAcronym = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param siteAcronym the site acronym to search with
	 * @param start the lower bound of the range of sites to return
	 * @param end the upper bound of the range of sites to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching sites
	 * @throws SystemException if a system exception occurred
	 */
	public List<Site> findBySiteAcronym(String siteAcronym, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				siteAcronym,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Site> list = (List<Site>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_SITEACRONYM,
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

			query.append(_SQL_SELECT_SITE_WHERE);

			if (siteAcronym == null) {
				query.append(_FINDER_COLUMN_SITEACRONYM_SITEACRONYM_1);
			}
			else {
				if (siteAcronym.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SITEACRONYM_SITEACRONYM_3);
				}
				else {
					query.append(_FINDER_COLUMN_SITEACRONYM_SITEACRONYM_2);
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

				if (siteAcronym != null) {
					qPos.add(siteAcronym);
				}

				list = (List<Site>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FIND_BY_SITEACRONYM,
						finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_SITEACRONYM,
						finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first site in the ordered set where siteAcronym = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param siteAcronym the site acronym to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching site
	 * @throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException if a matching site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Site findBySiteAcronym_First(String siteAcronym,
		OrderByComparator orderByComparator)
		throws NoSuchSiteException, SystemException {
		List<Site> list = findBySiteAcronym(siteAcronym, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("siteAcronym=");
			msg.append(siteAcronym);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSiteException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last site in the ordered set where siteAcronym = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param siteAcronym the site acronym to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching site
	 * @throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException if a matching site could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Site findBySiteAcronym_Last(String siteAcronym,
		OrderByComparator orderByComparator)
		throws NoSuchSiteException, SystemException {
		int count = countBySiteAcronym(siteAcronym);

		List<Site> list = findBySiteAcronym(siteAcronym, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("siteAcronym=");
			msg.append(siteAcronym);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSiteException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the sites before and after the current site in the ordered set where siteAcronym = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param siteId the primary key of the current site
	 * @param siteAcronym the site acronym to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next site
	 * @throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException if a site with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Site[] findBySiteAcronym_PrevAndNext(long siteId,
		String siteAcronym, OrderByComparator orderByComparator)
		throws NoSuchSiteException, SystemException {
		Site site = findByPrimaryKey(siteId);

		Session session = null;

		try {
			session = openSession();

			Site[] array = new SiteImpl[3];

			array[0] = getBySiteAcronym_PrevAndNext(session, site, siteAcronym,
					orderByComparator, true);

			array[1] = site;

			array[2] = getBySiteAcronym_PrevAndNext(session, site, siteAcronym,
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

	protected Site getBySiteAcronym_PrevAndNext(Session session, Site site,
		String siteAcronym, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SITE_WHERE);

		if (siteAcronym == null) {
			query.append(_FINDER_COLUMN_SITEACRONYM_SITEACRONYM_1);
		}
		else {
			if (siteAcronym.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SITEACRONYM_SITEACRONYM_3);
			}
			else {
				query.append(_FINDER_COLUMN_SITEACRONYM_SITEACRONYM_2);
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

		if (siteAcronym != null) {
			qPos.add(siteAcronym);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(site);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Site> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the sites.
	 *
	 * @return the sites
	 * @throws SystemException if a system exception occurred
	 */
	public List<Site> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the sites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of sites to return
	 * @param end the upper bound of the range of sites to return (not inclusive)
	 * @return the range of sites
	 * @throws SystemException if a system exception occurred
	 */
	public List<Site> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the sites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of sites to return
	 * @param end the upper bound of the range of sites to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of sites
	 * @throws SystemException if a system exception occurred
	 */
	public List<Site> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Site> list = (List<Site>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SITE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SITE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Site>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Site>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the sites where siteName = &#63; from the database.
	 *
	 * @param siteName the site name to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBySiteName(String siteName) throws SystemException {
		for (Site site : findBySiteName(siteName)) {
			remove(site);
		}
	}

	/**
	 * Removes all the sites where siteAcronym = &#63; from the database.
	 *
	 * @param siteAcronym the site acronym to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBySiteAcronym(String siteAcronym)
		throws SystemException {
		for (Site site : findBySiteAcronym(siteAcronym)) {
			remove(site);
		}
	}

	/**
	 * Removes all the sites from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Site site : findAll()) {
			remove(site);
		}
	}

	/**
	 * Counts all the sites where siteName = &#63;.
	 *
	 * @param siteName the site name to search with
	 * @return the number of matching sites
	 * @throws SystemException if a system exception occurred
	 */
	public int countBySiteName(String siteName) throws SystemException {
		Object[] finderArgs = new Object[] { siteName };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SITENAME,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SITE_WHERE);

			if (siteName == null) {
				query.append(_FINDER_COLUMN_SITENAME_SITENAME_1);
			}
			else {
				if (siteName.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SITENAME_SITENAME_3);
				}
				else {
					query.append(_FINDER_COLUMN_SITENAME_SITENAME_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (siteName != null) {
					qPos.add(siteName);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SITENAME,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the sites where siteAcronym = &#63;.
	 *
	 * @param siteAcronym the site acronym to search with
	 * @return the number of matching sites
	 * @throws SystemException if a system exception occurred
	 */
	public int countBySiteAcronym(String siteAcronym) throws SystemException {
		Object[] finderArgs = new Object[] { siteAcronym };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SITEACRONYM,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SITE_WHERE);

			if (siteAcronym == null) {
				query.append(_FINDER_COLUMN_SITEACRONYM_SITEACRONYM_1);
			}
			else {
				if (siteAcronym.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SITEACRONYM_SITEACRONYM_3);
				}
				else {
					query.append(_FINDER_COLUMN_SITEACRONYM_SITEACRONYM_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (siteAcronym != null) {
					qPos.add(siteAcronym);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SITEACRONYM,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the sites.
	 *
	 * @return the number of sites
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

				Query q = session.createQuery(_SQL_COUNT_SITE);

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
	 * Initializes the site persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.jhu.cvrg.portal.guidgenerator.model.Site")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Site>> listenersList = new ArrayList<ModelListener<Site>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Site>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SiteImpl.class.getName());
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
	private static final String _SQL_SELECT_SITE = "SELECT site FROM Site site";
	private static final String _SQL_SELECT_SITE_WHERE = "SELECT site FROM Site site WHERE ";
	private static final String _SQL_COUNT_SITE = "SELECT COUNT(site) FROM Site site";
	private static final String _SQL_COUNT_SITE_WHERE = "SELECT COUNT(site) FROM Site site WHERE ";
	private static final String _FINDER_COLUMN_SITENAME_SITENAME_1 = "site.siteName IS NULL";
	private static final String _FINDER_COLUMN_SITENAME_SITENAME_2 = "site.siteName = ?";
	private static final String _FINDER_COLUMN_SITENAME_SITENAME_3 = "(site.siteName IS NULL OR site.siteName = ?)";
	private static final String _FINDER_COLUMN_SITEACRONYM_SITEACRONYM_1 = "site.siteAcronym IS NULL";
	private static final String _FINDER_COLUMN_SITEACRONYM_SITEACRONYM_2 = "site.siteAcronym = ?";
	private static final String _FINDER_COLUMN_SITEACRONYM_SITEACRONYM_3 = "(site.siteAcronym IS NULL OR site.siteAcronym = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "site.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Site exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Site exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(SitePersistenceImpl.class);
}