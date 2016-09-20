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

import com.archive.dao.UrlDAO;
import com.archive.exception.DatabaseConnectionException;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

/**
 * @author Jonathan McCann
 */
@Service
public class UrlUtil {

	public static void addUrl(String url)
		throws DatabaseConnectionException, SQLException {

		_urlDAO.addUrl(url);
	}

	private static UrlDAO _urlDAO = new UrlDAO();

}