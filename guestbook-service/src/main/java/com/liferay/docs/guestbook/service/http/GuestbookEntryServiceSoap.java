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

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>GuestbookEntryServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.docs.guestbook.model.GuestbookEntrySoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.docs.guestbook.model.GuestbookEntry</code>, that is translated to a
 * <code>com.liferay.docs.guestbook.model.GuestbookEntrySoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author liferay
 * @see GuestbookEntryServiceHttp
 * @generated
 */
public class GuestbookEntryServiceSoap {

	public static com.liferay.docs.guestbook.model.GuestbookEntrySoap
			addGuestbookEntry(
				String id, long userId, long guestbookId, long groupId,
				String name, String email, String message,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.docs.guestbook.model.GuestbookEntry returnValue =
				GuestbookEntryServiceUtil.addGuestbookEntry(
					id, userId, guestbookId, groupId, name, email, message,
					serviceContext);

			return com.liferay.docs.guestbook.model.GuestbookEntrySoap.
				toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.docs.guestbook.model.GuestbookEntrySoap
			patchGuestbookEntry(
				String oldId, String id, long userId, long guestbookId,
				long groupId, String name, String email, String message,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.docs.guestbook.model.GuestbookEntry returnValue =
				GuestbookEntryServiceUtil.patchGuestbookEntry(
					oldId, id, userId, guestbookId, groupId, name, email,
					message, serviceContext);

			return com.liferay.docs.guestbook.model.GuestbookEntrySoap.
				toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.docs.guestbook.model.GuestbookEntrySoap
			deleteGuestbookEntry(
				com.liferay.docs.guestbook.model.GuestbookEntrySoap entry)
		throws RemoteException {

		try {
			com.liferay.docs.guestbook.model.GuestbookEntry returnValue =
				GuestbookEntryServiceUtil.deleteGuestbookEntry(
					com.liferay.docs.guestbook.model.impl.
						GuestbookEntryModelImpl.toModel(entry));

			return com.liferay.docs.guestbook.model.GuestbookEntrySoap.
				toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.docs.guestbook.model.GuestbookEntrySoap
			deleteGuestbookEntry(long entryId)
		throws RemoteException {

		try {
			com.liferay.docs.guestbook.model.GuestbookEntry returnValue =
				GuestbookEntryServiceUtil.deleteGuestbookEntry(entryId);

			return com.liferay.docs.guestbook.model.GuestbookEntrySoap.
				toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void deleteGuestbookEntry(String surrogateId)
		throws RemoteException {

		try {
			GuestbookEntryServiceUtil.deleteGuestbookEntry(surrogateId);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.docs.guestbook.model.GuestbookEntrySoap
			getGuestbookEntry(String surrogateId)
		throws RemoteException {

		try {
			com.liferay.docs.guestbook.model.GuestbookEntry returnValue =
				GuestbookEntryServiceUtil.getGuestbookEntry(surrogateId);

			return com.liferay.docs.guestbook.model.GuestbookEntrySoap.
				toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		GuestbookEntryServiceSoap.class);

}