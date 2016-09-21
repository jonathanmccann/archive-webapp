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

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Jonathan McCann
 */
@Service
public class ArchiveUtil {

	public static void archiveUrl(String url) throws IOException {
		archiveUrlToArchive(url);
		archiveUrlToWayback(url);
	}

	private static void archiveUrlToArchive(String url) throws IOException {
		URL archiveUrl = new URL(_ARCHIVE_URL + url);

		URLConnection connection = archiveUrl.openConnection();

		connection.connect();
	}

	private static void archiveUrlToWayback(String url) throws IOException {
		URL archiveUrl = new URL(_WAYBACK_URL + url);

		URLConnection connection = archiveUrl.openConnection();

		connection.connect();
	}

	private static final String _ARCHIVE_URL = "https://archive.is/?run=1&url=";
	private static final String _WAYBACK_URL = "https://web.archive.org/save/";
}