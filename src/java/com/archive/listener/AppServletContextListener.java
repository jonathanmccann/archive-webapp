/**
 * Copyright (c) 2014-present Jonathan McCann
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

package com.archive.listener;

import com.archive.util.DatabaseUtil;
import com.archive.util.PropertiesUtil;
import com.archive.util.PropertiesValues;

import com.mysql.jdbc.AbandonedConnectionCleanupThread;

import java.sql.Driver;
import java.sql.DriverManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Jonathan McCann
 */
public class AppServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		_log.info("Destroying servlet context");

		try {
			AbandonedConnectionCleanupThread.shutdown();

			Driver driver = DriverManager.getDriver(
				PropertiesValues.JDBC_DEFAULT_URL);

			DriverManager.deregisterDriver(driver);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		_log.info("Initializing servlet context");

		try {
			_log.info("Loading configuration properties");

			PropertiesUtil.loadConfigurationProperties();

			_log.info("Loading database properties");

			Class.forName("com.mysql.jdbc.Driver");

			DatabaseUtil.loadDatabaseProperties();

			_log.info("Initializing database");

			DatabaseUtil.initializeDatabase();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static final Logger _log = LoggerFactory.getLogger(
		AppServletContextListener.class);

}