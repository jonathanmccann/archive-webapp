CREATE TABLE IF NOT EXISTS SearchResult(
	savedPageId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	itemId VARCHAR(25) NOT NULL,
	itemTitle VARCHAR(100),
	waybackURL VARCHAR(250),
	archiveURL VARCHAR(250)
);