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

package com.archive.dao;

import com.archive.exception.DatabaseConnectionException;
import com.archive.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Jonathan McCann
 */
public class UrlDAO {

	public void addUrl(String url)
		throws DatabaseConnectionException, SQLException {

		_log.debug("Adding URL: {}", url);

		try (Connection connection = DatabaseUtil.getDatabaseConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
				_ADD_URL_SQL)) {

			preparedStatement.setString(1, "itemId");
			preparedStatement.setString(2, "itemTitle");
			preparedStatement.setString(3, url);
			preparedStatement.setString(4, "archiveUrl");

			preparedStatement.executeUpdate();
		}
	}

	private static final String _ADD_URL_SQL =
		"INSERT INTO Url(itemId, itemTitle, waybackURL, archiveUrl) " +
			"VALUES(?, ?, ?, ?)";

	private static final Logger _log = LoggerFactory.getLogger(
		UrlDAO.class);

}