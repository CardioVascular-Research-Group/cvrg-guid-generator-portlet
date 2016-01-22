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

import com.jhu.cvrg.portal.guidgenerator.model.Site;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the site service. This utility wraps {@link SitePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
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
 * @see SitePersistence
 * @see SitePersistenceImpl
 * @generated
 */
public class SiteUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Site site) {
		getPersistence().clearCache(site);
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
	public static List<Site> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Site> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Site> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static Site remove(Site site) throws SystemException {
		return getPersistence().remove(site);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Site update(Site site, boolean merge)
		throws SystemException {
		return getPersistence().update(site, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Site update(Site site, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(site, merge, serviceContext);
	}

	/**
	* Caches the site in the entity cache if it is enabled.
	*
	* @param site the site to cache
	*/
	public static void cacheResult(
		com.jhu.cvrg.portal.guidgenerator.model.Site site) {
		getPersistence().cacheResult(site);
	}

	/**
	* Caches the sites in the entity cache if it is enabled.
	*
	* @param sites the sites to cache
	*/
	public static void cacheResult(
		java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Site> sites) {
		getPersistence().cacheResult(sites);
	}

	/**
	* Creates a new site with the primary key. Does not add the site to the database.
	*
	* @param siteId the primary key for the new site
	* @return the new site
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.Site create(
		long siteId) {
		return getPersistence().create(siteId);
	}

	/**
	* Removes the site with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param siteId the primary key of the site to remove
	* @return the site that was removed
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException if a site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.Site remove(
		long siteId)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(siteId);
	}

	public static com.jhu.cvrg.portal.guidgenerator.model.Site updateImpl(
		com.jhu.cvrg.portal.guidgenerator.model.Site site, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(site, merge);
	}

	/**
	* Finds the site with the primary key or throws a {@link com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException} if it could not be found.
	*
	* @param siteId the primary key of the site to find
	* @return the site
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException if a site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.Site findByPrimaryKey(
		long siteId)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(siteId);
	}

	/**
	* Finds the site with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param siteId the primary key of the site to find
	* @return the site, or <code>null</code> if a site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.jhu.cvrg.portal.guidgenerator.model.Site fetchByPrimaryKey(
		long siteId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(siteId);
	}

	/**
	* Finds all the sites where siteName = &#63;.
	*
	* @param siteName the site name to search with
	* @return the matching sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Site> findBySiteName(
		java.lang.String siteName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySiteName(siteName);
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
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Site> findBySiteName(
		java.lang.String siteName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySiteName(siteName, start, end);
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
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Site> findBySiteName(
		java.lang.String siteName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySiteName(siteName, start, end, orderByComparator);
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
	public static com.jhu.cvrg.portal.guidgenerator.model.Site findBySiteName_First(
		java.lang.String siteName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySiteName_First(siteName, orderByComparator);
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
	public static com.jhu.cvrg.portal.guidgenerator.model.Site findBySiteName_Last(
		java.lang.String siteName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySiteName_Last(siteName, orderByComparator);
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
	public static com.jhu.cvrg.portal.guidgenerator.model.Site[] findBySiteName_PrevAndNext(
		long siteId, java.lang.String siteName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySiteName_PrevAndNext(siteId, siteName,
			orderByComparator);
	}

	/**
	* Finds all the sites where siteAcronym = &#63;.
	*
	* @param siteAcronym the site acronym to search with
	* @return the matching sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Site> findBySiteAcronym(
		java.lang.String siteAcronym)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySiteAcronym(siteAcronym);
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
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Site> findBySiteAcronym(
		java.lang.String siteAcronym, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySiteAcronym(siteAcronym, start, end);
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
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Site> findBySiteAcronym(
		java.lang.String siteAcronym, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySiteAcronym(siteAcronym, start, end, orderByComparator);
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
	public static com.jhu.cvrg.portal.guidgenerator.model.Site findBySiteAcronym_First(
		java.lang.String siteAcronym,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySiteAcronym_First(siteAcronym, orderByComparator);
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
	public static com.jhu.cvrg.portal.guidgenerator.model.Site findBySiteAcronym_Last(
		java.lang.String siteAcronym,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySiteAcronym_Last(siteAcronym, orderByComparator);
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
	public static com.jhu.cvrg.portal.guidgenerator.model.Site[] findBySiteAcronym_PrevAndNext(
		long siteId, java.lang.String siteAcronym,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBySiteAcronym_PrevAndNext(siteId, siteAcronym,
			orderByComparator);
	}

	/**
	* Finds all the sites.
	*
	* @return the sites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Site> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Site> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Site> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the sites where siteName = &#63; from the database.
	*
	* @param siteName the site name to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySiteName(java.lang.String siteName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySiteName(siteName);
	}

	/**
	* Removes all the sites where siteAcronym = &#63; from the database.
	*
	* @param siteAcronym the site acronym to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySiteAcronym(java.lang.String siteAcronym)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBySiteAcronym(siteAcronym);
	}

	/**
	* Removes all the sites from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the sites where siteName = &#63;.
	*
	* @param siteName the site name to search with
	* @return the number of matching sites
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySiteName(java.lang.String siteName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySiteName(siteName);
	}

	/**
	* Counts all the sites where siteAcronym = &#63;.
	*
	* @param siteAcronym the site acronym to search with
	* @return the number of matching sites
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySiteAcronym(java.lang.String siteAcronym)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySiteAcronym(siteAcronym);
	}

	/**
	* Counts all the sites.
	*
	* @return the number of sites
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SitePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SitePersistence)PortletBeanLocatorUtil.locate(com.jhu.cvrg.portal.guidgenerator.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					SitePersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(SitePersistence persistence) {
		_persistence = persistence;
	}

	private static SitePersistence _persistence;
}