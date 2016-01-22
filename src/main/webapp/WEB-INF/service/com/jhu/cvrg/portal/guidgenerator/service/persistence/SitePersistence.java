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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the site service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link SiteUtil} to access the site persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Chris Jurado
 * @see SitePersistenceImpl
 * @see SiteUtil
 * @generated
 */
public interface SitePersistence extends BasePersistence<Site> {
	/**
	* Caches the site in the entity cache if it is enabled.
	*
	* @param site the site to cache
	*/
	public void cacheResult(com.jhu.cvrg.portal.guidgenerator.model.Site site);

	/**
	* Caches the sites in the entity cache if it is enabled.
	*
	* @param sites the sites to cache
	*/
	public void cacheResult(
		java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Site> sites);

	/**
	* Creates a new site with the primary key. Does not add the site to the database.
	*
	* @param siteId the primary key for the new site
	* @return the new site
	*/
	public com.jhu.cvrg.portal.guidgenerator.model.Site create(long siteId);

	/**
	* Removes the site with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param siteId the primary key of the site to remove
	* @return the site that was removed
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException if a site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jhu.cvrg.portal.guidgenerator.model.Site remove(long siteId)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.jhu.cvrg.portal.guidgenerator.model.Site updateImpl(
		com.jhu.cvrg.portal.guidgenerator.model.Site site, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the site with the primary key or throws a {@link com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException} if it could not be found.
	*
	* @param siteId the primary key of the site to find
	* @return the site
	* @throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException if a site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jhu.cvrg.portal.guidgenerator.model.Site findByPrimaryKey(
		long siteId)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the site with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param siteId the primary key of the site to find
	* @return the site, or <code>null</code> if a site with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.jhu.cvrg.portal.guidgenerator.model.Site fetchByPrimaryKey(
		long siteId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the sites where siteName = &#63;.
	*
	* @param siteName the site name to search with
	* @return the matching sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Site> findBySiteName(
		java.lang.String siteName)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Site> findBySiteName(
		java.lang.String siteName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Site> findBySiteName(
		java.lang.String siteName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.jhu.cvrg.portal.guidgenerator.model.Site findBySiteName_First(
		java.lang.String siteName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.jhu.cvrg.portal.guidgenerator.model.Site findBySiteName_Last(
		java.lang.String siteName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.jhu.cvrg.portal.guidgenerator.model.Site[] findBySiteName_PrevAndNext(
		long siteId, java.lang.String siteName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the sites where siteAcronym = &#63;.
	*
	* @param siteAcronym the site acronym to search with
	* @return the matching sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Site> findBySiteAcronym(
		java.lang.String siteAcronym)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Site> findBySiteAcronym(
		java.lang.String siteAcronym, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Site> findBySiteAcronym(
		java.lang.String siteAcronym, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.jhu.cvrg.portal.guidgenerator.model.Site findBySiteAcronym_First(
		java.lang.String siteAcronym,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.jhu.cvrg.portal.guidgenerator.model.Site findBySiteAcronym_Last(
		java.lang.String siteAcronym,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.jhu.cvrg.portal.guidgenerator.model.Site[] findBySiteAcronym_PrevAndNext(
		long siteId, java.lang.String siteAcronym,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.jhu.cvrg.portal.guidgenerator.NoSuchSiteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the sites.
	*
	* @return the sites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Site> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Site> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.jhu.cvrg.portal.guidgenerator.model.Site> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the sites where siteName = &#63; from the database.
	*
	* @param siteName the site name to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySiteName(java.lang.String siteName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the sites where siteAcronym = &#63; from the database.
	*
	* @param siteAcronym the site acronym to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySiteAcronym(java.lang.String siteAcronym)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the sites from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the sites where siteName = &#63;.
	*
	* @param siteName the site name to search with
	* @return the number of matching sites
	* @throws SystemException if a system exception occurred
	*/
	public int countBySiteName(java.lang.String siteName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the sites where siteAcronym = &#63;.
	*
	* @param siteAcronym the site acronym to search with
	* @return the number of matching sites
	* @throws SystemException if a system exception occurred
	*/
	public int countBySiteAcronym(java.lang.String siteAcronym)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the sites.
	*
	* @return the number of sites
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}