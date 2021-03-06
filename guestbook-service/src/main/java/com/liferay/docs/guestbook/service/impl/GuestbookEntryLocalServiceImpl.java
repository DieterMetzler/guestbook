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

import com.liferay.docs.guestbook.exception.GuestbookEntryEmailException;
import com.liferay.docs.guestbook.exception.GuestbookEntryMessageException;
import com.liferay.docs.guestbook.exception.GuestbookEntryNameException;
import com.liferay.docs.guestbook.exception.NoSuchGuestbookEntryException;
import com.liferay.docs.guestbook.model.GuestbookEntry;
import com.liferay.docs.guestbook.service.base.GuestbookEntryLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The implementation of the guestbook entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.docs.guestbook.service.GuestbookEntryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author liferay
 * @see GuestbookEntryLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.docs.guestbook.model.GuestbookEntry",
	service = AopService.class
)
public class GuestbookEntryLocalServiceImpl
	extends GuestbookEntryLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.docs.guestbook.service.GuestbookEntryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.docs.guestbook.service.GuestbookEntryLocalServiceUtil</code>.
	 */
	
	@Indexable(type = IndexableType.REINDEX)
	public GuestbookEntry addGuestbookEntry(final String id, long userId, long guestbookId,
			long groupId, String name, String email, String message, ServiceContext serviceContext)
		throws PortalException {

		if (groupId == 0) { 
			groupId = serviceContext.getScopeGroupId();
		}

		User user = userLocalService.getUserById(userId);

		Date now = new Date();
		
		String useId = null;

		if ((id == null) || (id.trim().length() < 1)) {
			useId = RandomStringUtils.random(10, true, true).toUpperCase();
		} else {
			useId = id.trim().toUpperCase();
		}

		validate(name, email, message);

		long entryId = counterLocalService.increment();

		GuestbookEntry entry = guestbookEntryPersistence.create(entryId);

		entry.setUuid(serviceContext.getUuid());
		entry.setUserId(userId);
		entry.setGroupId(groupId);
		entry.setCompanyId(user.getCompanyId());
		entry.setUserName(user.getFullName());
		entry.setCreateDate(serviceContext.getCreateDate(now));
		entry.setModifiedDate(serviceContext.getModifiedDate(now));
		entry.setExpandoBridgeAttributes(serviceContext);
		entry.setGuestbookId(guestbookId);
		entry.setSurrogateId(useId);
		entry.setName(name);
		entry.setEmail(email);
		entry.setMessage(message);

		guestbookEntryPersistence.update(entry);

		// Calls to other Liferay frameworks go here
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
			    GuestbookEntry.class.getName(), entryId, false, true, true);

		return entry;
	}
	
	@Indexable(type = IndexableType.REINDEX)
	public GuestbookEntry updateGuestbookEntry(long userId, long guestbookId,
			long entryId, String name, String email, String message,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		Date now = new Date();

		validate(name, email, message);

		GuestbookEntry entry =
			guestbookEntryPersistence.findByPrimaryKey(entryId);

		User user = userLocalService.getUserById(userId);

		entry.setUserId(userId);
		entry.setUserName(user.getFullName());
		entry.setModifiedDate(serviceContext.getModifiedDate(now));
		entry.setName(name);
		entry.setEmail(email);
		entry.setMessage(message);
		entry.setExpandoBridgeAttributes(serviceContext);

		guestbookEntryPersistence.update(entry);

		// Integrate with Liferay frameworks here.
		resourceLocalService.updateResources(
			      user.getCompanyId(), serviceContext.getScopeGroupId(), 
			      GuestbookEntry.class.getName(), entryId, 
			      serviceContext.getModelPermissions());

		return entry;
	}
	
	
	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public GuestbookEntry patchGuestbookEntry(final String oldId, final String id,
			final long userId, final long guestbookId, final long groupId,
			final String name, final String email, final String message,
			final ServiceContext serviceContext) throws PortalException {

		// find our instance using the old id
		GuestbookEntry entry = guestbookEntryPersistence.fetchBySurrogateId(oldId);
		boolean changed = false;

		if (entry == null) {
			_log.warn("Failed to find guestbookEntry using id [" + oldId + "].");
			throw new NoSuchGuestbookEntryException("Could not find guestbookEntry [" + oldId + "].");
		}

		if ((id != null) && (id.trim().length() > 0)) {
			// replace the id
			entry.setSurrogateId(id.trim().toUpperCase());
			changed = true;
		}

		// a patch means that only provided fields are going to change to match what we are given.

		if (name != null) {
			entry.setName(name);
			changed = true;
		}
		
		if (email != null) {
			entry.setEmail(email);
			changed = true;
		}
		
		if (message != null) {
			entry.setMessage(message);
			changed = true;
		}

		
		if (changed) {
			Date current = new Date();

			entry.setUserId(serviceContext.getUserId());
			entry.setModifiedDate(serviceContext.getModifiedDate(current));

			User user = userLocalService.fetchUser(serviceContext.getUserId());
			if (user != null) {
				entry.setUserName(user.getFullName());
				entry.setUserUuid(user.getUserUuid());
			}

			entry = updateGuestbookEntry(entry);
		}

		// good to go
		return entry;
	}


	@Indexable(type = IndexableType.DELETE)
	@Override
	public void deleteGuestbookEntry(final String surrogateId) throws PortalException {
		GuestbookEntry guestbookentry = getGuestbookEntry(surrogateId);

		if (guestbookentry != null) {
			deleteGuestbookEntry(guestbookentry);
		}
	}
	
	@Indexable(type = IndexableType.DELETE)
	public GuestbookEntry deleteGuestbookEntry(GuestbookEntry entry)
			throws PortalException
		{

			guestbookEntryPersistence.remove(entry);
			
			resourceLocalService.deleteResource(
					   entry.getCompanyId(), GuestbookEntry.class.getName(),
					   ResourceConstants.SCOPE_INDIVIDUAL, entry.getEntryId());


			return entry;
		}
	
	@Indexable(type = IndexableType.DELETE)
	public GuestbookEntry deleteGuestbookEntry(long entryId) throws PortalException {

		GuestbookEntry entry =
			guestbookEntryPersistence.findByPrimaryKey(entryId);

		return deleteGuestbookEntry(entry);
	}
	
	public List<GuestbookEntry> getGuestbookEntries(long groupId, long guestbookId) {
		return guestbookEntryPersistence.findByG_G(groupId, guestbookId);
	}

	public List<GuestbookEntry> getGuestbookEntries(long groupId, long guestbookId,
			int start, int end) throws SystemException {

		return guestbookEntryPersistence.findByG_G(groupId, guestbookId, start,
				end);
	}

	public List<GuestbookEntry> getGuestbookEntries(long groupId, long guestbookId,
			int start, int end, OrderByComparator<GuestbookEntry> obc) {

		return guestbookEntryPersistence.findByG_G(groupId, guestbookId, start,
				end, obc);
	}

	public GuestbookEntry getGuestbookEntry(final String surrogateId) throws PortalException {
		System.out.println("getGuestbookEntry - LocalService");
		return guestbookEntryPersistence.fetchBySurrogateId(surrogateId);
	}

	public int getGuestbookEntriesCount(long groupId, long guestbookId) {
		return guestbookEntryPersistence.countByG_G(groupId, guestbookId);
	}
	
	protected void validate(String name, String email, String entry)
			throws PortalException {

			if (Validator.isNull(name)) {
				throw new GuestbookEntryNameException();
			}

			if (!Validator.isEmailAddress(email)) {
				throw new GuestbookEntryEmailException();
			}

			if (Validator.isNull(entry)) {
				throw new GuestbookEntryMessageException();
			}
		}
	
	private static final Logger _log = LoggerFactory.getLogger(GuestbookEntryLocalServiceImpl.class);
		
}