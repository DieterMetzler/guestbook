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

package com.liferay.docs.guestbook.service.impl;

import com.liferay.docs.guestbook.model.GuestbookEntry;
import com.liferay.docs.guestbook.service.base.GuestbookEntryServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ServiceContext;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the guestbook entry remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.docs.guestbook.service.GuestbookEntryService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author liferay
 * @see GuestbookEntryServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=gb",
		"json.web.service.context.path=GuestbookEntry"
	},
	service = AopService.class
)
public class GuestbookEntryServiceImpl extends GuestbookEntryServiceBaseImpl {
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.liferay.docs.guestbook.service.GuestbookEntryServiceUtil</code> to access the guestbook entry remote service.
	 */

	@Override
	public GuestbookEntry addGuestbookEntry(final String id, final long userId,
			final long guestbookId, final long groupId, final String name, final String email,
			final String message, final ServiceContext serviceContext) throws PortalException {
		
		// TODO Auto-generated method stub
		System.out.println("addGuestbookEntry in GuestbookEntryServiceImpl");
		
		return guestbookEntryLocalService.addGuestbookEntry(id, userId, guestbookId,
				groupId, name, email, message, serviceContext);
	}
	
	public GuestbookEntry patchGuestbookEntry(final String oldId, final String id,
			final long userId, final long guestbookId, final long groupId,
			final String name, final String email, final String message,
			final ServiceContext serviceContext) throws PortalException {



		return guestbookEntryLocalService.patchGuestbookEntry(oldId, id, userId,
				guestbookId, groupId, name, email, message, serviceContext);
	}
	
	
	
	public GuestbookEntry deleteGuestbookEntry(GuestbookEntry entry)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	public GuestbookEntry deleteGuestbookEntry(long entryId) {

		return null;
	}
	
	public void deleteGuestbookEntry(final String surrogateId) throws PortalException {
		
		guestbookEntryLocalService.deleteGuestbookEntry(surrogateId);
	
	
	}
	
	
	
	public GuestbookEntry getGuestbookEntry(final String surrogateId) throws PortalException{
		GuestbookEntry guestbookentry = guestbookEntryLocalService.getGuestbookEntry(surrogateId);
		System.out.println("getGuestbookEntry");
		return guestbookentry;
	
	}
	
	
}