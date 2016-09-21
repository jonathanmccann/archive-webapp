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

package com.archive.controller;

import com.archive.exception.DatabaseConnectionException;
import com.archive.util.ArchiveUtil;
import com.archive.util.EbayUtil;
import com.archive.util.UrlUtil;

import java.io.IOException;
import java.sql.SQLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Jonathan McCann
 */
@Controller
public class ArchiveController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/saveUrl", method = RequestMethod.POST)
	public String saveUrl(String url)
		throws DatabaseConnectionException, SQLException, IOException {

		ArchiveUtil.archiveUrl(url);

		Document document = Jsoup.connect(url).get();
		String itemTitle = EbayUtil.getItemTitle(document.title());

		String itemId = EbayUtil.getItemId(url);

		UrlUtil.addUrl(itemId, itemTitle);

		return "home";
	}

	private static final Logger _log = LoggerFactory.getLogger(
		ArchiveController.class);

}