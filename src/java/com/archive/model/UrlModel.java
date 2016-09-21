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

	public UrlModel(String itemId, String itemTitle) {
		_itemId = itemId;
		_itemTitle = itemTitle;
	}

	public String getItemId() {
		return _itemId;
	}

	public String getItemTitle() {
		return _itemTitle;
	}

	public void setItemId(String itemId) {
		_itemId = itemId;
	}

	public void setItemTitle(String itemTitle) {
		_itemTitle = itemTitle;
	}

	private String _itemId;
	private String _itemTitle;

}