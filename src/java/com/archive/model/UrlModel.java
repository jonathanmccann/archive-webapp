/**
 * Copyright (c) 2016-present Jonathan McCann
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 */

package com.archive.model;

/**
 * @author Jonathan McCann
 */
public class UrlModel {

	public UrlModel() {
	}

	public UrlModel(
		String itemId, String itemTitle, String waybackURL,	String archiveUrl) {

		_itemId = itemId;
		_itemTitle = itemTitle;
		_waybackUrl = waybackURL;
		_archiveUrl = archiveUrl;
	}

	public String getItemId() {
		return _itemId;
	}

	public String getItemTitle() {
		return _itemTitle;
	}

	public String getWaybackUrl() {
		return _waybackUrl;
	}

	public String getArchiveUrl() {
		return _archiveUrl;
	}

	public void setItemId(String itemId) {
		_itemId = itemId;
	}

	public void setItemTitle(String itemTitle) {
		_itemTitle = itemTitle;
	}

	public void setWaybackUrl(String waybackUrl) {
		_waybackUrl = waybackUrl;
	}

	public void setArchiveUrl(String archiveUrl) {
		_archiveUrl = archiveUrl;
	}

	private String _itemId;
	private String _itemTitle;
	private String _waybackUrl;
	private String _archiveUrl;

}