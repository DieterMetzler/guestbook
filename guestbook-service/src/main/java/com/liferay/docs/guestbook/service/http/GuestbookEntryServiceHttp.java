/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.docs.guestbook.service.http;

import com.liferay.docs.guestbook.service.GuestbookEntryServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>GuestbookEntryServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author liferay
 * @see GuestbookEntryServiceSoap
 * @generated
 */
public class GuestbookEntryServiceHttp {

	public static com.liferay.docs.guestbook.model.GuestbookEntry
			addGuestbookEntry(
				HttpPrincipal httpPrincipal, String id, long userId,
				long guestbookId, long groupId, String name, String email,
				String message,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				GuestbookEntryServiceUtil.class, "addGuestbookEntry",
				_addGuestbookEntryParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, id, userId, guestbookId, groupId, name, email,
				message, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.docs.guestbook.model.GuestbookEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.docs.guestbook.model.GuestbookEntry
		deleteGuestbookEntry(
			HttpPrincipal httpPrincipal,
			com.liferay.docs.guestbook.model.GuestbookEntry entry) {

		try {
			MethodKey methodKey = new MethodKey(
				GuestbookEntryServiceUtil.class, "deleteGuestbookEntry",
				_deleteGuestbookEntryParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, entry);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.docs.guestbook.model.GuestbookEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.docs.guestbook.model.GuestbookEntry
		deleteGuestbookEntry(HttpPrincipal httpPrincipal, long entryId) {

		try {
			MethodKey methodKey = new MethodKey(
				GuestbookEntryServiceUtil.class, "deleteGuestbookEntry",
				_deleteGuestbookEntryParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, entryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.docs.guestbook.model.GuestbookEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void deleteGuestbookEntry(
			HttpPrincipal httpPrincipal, String surrogateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				GuestbookEntryServiceUtil.class, "deleteGuestbookEntry",
				_deleteGuestbookEntryParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, surrogateId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.docs.guestbook.model.GuestbookEntry
			getGuestbookEntry(HttpPrincipal httpPrincipal, String surrogateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				GuestbookEntryServiceUtil.class, "getGuestbookEntry",
				_getGuestbookEntryParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, surrogateId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.docs.guestbook.model.GuestbookEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		GuestbookEntryServiceHttp.class);

	private static final Class<?>[] _addGuestbookEntryParameterTypes0 =
		new Class[] {
			String.class, long.class, long.class, long.class, String.class,
			String.class, String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteGuestbookEntryParameterTypes1 =
		new Class[] {com.liferay.docs.guestbook.model.GuestbookEntry.class};
	private static final Class<?>[] _deleteGuestbookEntryParameterTypes2 =
		new Class[] {long.class};
	private static final Class<?>[] _deleteGuestbookEntryParameterTypes3 =
		new Class[] {String.class};
	private static final Class<?>[] _getGuestbookEntryParameterTypes4 =
		new Class[] {String.class};

}