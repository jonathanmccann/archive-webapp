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

package com.archive.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

/**
 * @author Jonathan McCann
 */
@Service
public class EbayUtil {

	public static String getItemId(String url) {
		Matcher matcher = _ITEM_ID_PATTERN.matcher(url);

		if (matcher.find()) {
			return matcher.group();
		}
		else {
			return "";
		}
	}

	public static String getItemTitle(String url) {
		Matcher matcher = _ITEM_TITLE_PATTERN.matcher(url);

		if (matcher.find()) {
			return matcher.group(1).trim();
		}
		else {
			return "";
		}
	}

	private static final Pattern _ITEM_ID_PATTERN = Pattern.compile("\\/(\\d+)");
	private static final Pattern _ITEM_TITLE_PATTERN = Pattern.compile("(.*)\\|");

}