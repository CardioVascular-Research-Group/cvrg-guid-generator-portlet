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

import com.jhu.cvrg.portal.guidgenerator.model.SiteClp;
import com.jhu.cvrg.portal.guidgenerator.model.StudyClp;
import com.jhu.cvrg.portal.guidgenerator.model.StudySiteClp;
import com.jhu.cvrg.portal.guidgenerator.model.SubjectHashClp;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static final String SERVLET_CONTEXT_NAME = "ice2-guid-generator-portlet";

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(StudyClp.class.getName())) {
			StudyClp oldCplModel = (StudyClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.jhu.cvrg.portal.guidgenerator.model.impl.StudyImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setStudyId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getStudyId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setStudyAcronym",
							new Class[] { String.class });

					String value1 = oldCplModel.getStudyAcronym();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setStudyName",
							new Class[] { String.class });

					String value2 = oldCplModel.getStudyName();

					method2.invoke(newModel, value2);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(SiteClp.class.getName())) {
			SiteClp oldCplModel = (SiteClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.jhu.cvrg.portal.guidgenerator.model.impl.SiteImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setSiteId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getSiteId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setSiteAcronym",
							new Class[] { String.class });

					String value1 = oldCplModel.getSiteAcronym();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setSiteName",
							new Class[] { String.class });

					String value2 = oldCplModel.getSiteName();

					method2.invoke(newModel, value2);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(StudySiteClp.class.getName())) {
			StudySiteClp oldCplModel = (StudySiteClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.jhu.cvrg.portal.guidgenerator.model.impl.StudySiteImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setStudySiteId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getStudySiteId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setStudyId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getStudyId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setSiteId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getSiteId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setLinkingDirection",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getLinkingDirection());

					method3.invoke(newModel, value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(SubjectHashClp.class.getName())) {
			SubjectHashClp oldCplModel = (SubjectHashClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.jhu.cvrg.portal.guidgenerator.model.impl.SubjectHashImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setSubjectHashId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getSubjectHashId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setSubjectHashValue",
							new Class[] { String.class });

					String value1 = oldCplModel.getSubjectHashValue();

					method1.invoke(newModel, value1);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.jhu.cvrg.portal.guidgenerator.model.impl.StudyImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					StudyClp newModel = new StudyClp();

					Method method0 = oldModelClass.getMethod("getStudyId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setStudyId(value0);

					Method method1 = oldModelClass.getMethod("getStudyAcronym");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setStudyAcronym(value1);

					Method method2 = oldModelClass.getMethod("getStudyName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setStudyName(value2);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"com.jhu.cvrg.portal.guidgenerator.model.impl.SiteImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					SiteClp newModel = new SiteClp();

					Method method0 = oldModelClass.getMethod("getSiteId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setSiteId(value0);

					Method method1 = oldModelClass.getMethod("getSiteAcronym");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setSiteAcronym(value1);

					Method method2 = oldModelClass.getMethod("getSiteName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setSiteName(value2);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"com.jhu.cvrg.portal.guidgenerator.model.impl.StudySiteImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					StudySiteClp newModel = new StudySiteClp();

					Method method0 = oldModelClass.getMethod("getStudySiteId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setStudySiteId(value0);

					Method method1 = oldModelClass.getMethod("getStudyId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setStudyId(value1);

					Method method2 = oldModelClass.getMethod("getSiteId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setSiteId(value2);

					Method method3 = oldModelClass.getMethod(
							"getLinkingDirection");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setLinkingDirection(value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"com.jhu.cvrg.portal.guidgenerator.model.impl.SubjectHashImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					SubjectHashClp newModel = new SubjectHashClp();

					Method method0 = oldModelClass.getMethod("getSubjectHashId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setSubjectHashId(value0);

					Method method1 = oldModelClass.getMethod(
							"getSubjectHashValue");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setSubjectHashValue(value1);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
}