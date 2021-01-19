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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GuestbookEntryService}.
 *
 * @author liferay
 * @see GuestbookEntryService
 * @generated
 */
public class GuestbookEntryServiceWrapper
	implements GuestbookEntryService, ServiceWrapper<GuestbookEntryService> {

	public GuestbookEntryServiceWrapper(
		GuestbookEntryService guestbookEntryService) {

		_guestbookEntryService = guestbookEntryService;
	}

	@Override
	public com.liferay.docs.guestbook.model.GuestbookEntry addGuestbookEntry(
		long userId, long guestbookId, String name, String email,
		String message,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _guestbookEntryService.addGuestbookEntry(
			userId, guestbookId, name, email, message, serviceContext);
	}

	@Override
	public com.liferay.docs.guestbook.model.GuestbookEntry deleteGuestbookEntry(
		com.liferay.docs.guestbook.model.GuestbookEntry entry) {

		return _guestbookEntryService.deleteGuestbookEntry(entry);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _guestbookEntryService.getOSGiServiceIdentifier();
	}

	@Override
	public GuestbookEntryService getWrappedService() {
		return _guestbookEntryService;
	}

	@Override
	public void setWrappedService(GuestbookEntryService guestbookEntryService) {
		_guestbookEntryService = guestbookEntryService;
	}

	private GuestbookEntryService _guestbookEntryService;

}