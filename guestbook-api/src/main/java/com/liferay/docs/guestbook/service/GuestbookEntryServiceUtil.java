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

package com.liferay.docs.guestbook.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for GuestbookEntry. This utility wraps
 * <code>com.liferay.docs.guestbook.service.impl.GuestbookEntryServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author liferay
 * @see GuestbookEntryService
 * @generated
 */
public class GuestbookEntryServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.docs.guestbook.service.impl.GuestbookEntryServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.docs.guestbook.model.GuestbookEntry
			addGuestbookEntry(
				String id, long userId, long guestbookId, long groupId,
				String name, String email, String message,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addGuestbookEntry(
			id, userId, guestbookId, groupId, name, email, message,
			serviceContext);
	}

	public static com.liferay.docs.guestbook.model.GuestbookEntry
		deleteGuestbookEntry(
			com.liferay.docs.guestbook.model.GuestbookEntry entry) {

		return getService().deleteGuestbookEntry(entry);
	}

	public static com.liferay.docs.guestbook.model.GuestbookEntry
		deleteGuestbookEntry(long entryId) {

		return getService().deleteGuestbookEntry(entryId);
	}

	public static void deleteGuestbookEntry(String surrogateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteGuestbookEntry(surrogateId);
	}

	public static com.liferay.docs.guestbook.model.GuestbookEntry
			getGuestbookEntry(String surrogateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getGuestbookEntry(surrogateId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static GuestbookEntryService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GuestbookEntryService, GuestbookEntryService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(GuestbookEntryService.class);

		ServiceTracker<GuestbookEntryService, GuestbookEntryService>
			serviceTracker =
				new ServiceTracker
					<GuestbookEntryService, GuestbookEntryService>(
						bundle.getBundleContext(), GuestbookEntryService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}