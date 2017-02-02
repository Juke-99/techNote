SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS tagtodo;
DROP TABLE IF EXISTS tag;
DROP TABLE IF EXISTS todo;




/* Create Tables */

CREATE TABLE tag
(
	tagID int(21) unsigned NOT NULL AUTO_INCREMENT,
	tagname varchar(30) CHARACTER SET utf8 NOT NULL,
	PRIMARY KEY (tagID),
	UNIQUE (tagID),
	UNIQUE (tagname)
);


CREATE TABLE tagtodo
(
	tagID int(21) unsigned NOT NULL,
	title varchar(50) CHARACTER SET utf8 NOT NULL,
	PRIMARY KEY (tagID, title)
);


CREATE TABLE todo
(
	title varchar(50) CHARACTER SET utf8 NOT NULL,
	description text CHARACTER SET utf8 NOT NULL,
	timestamp timestamp DEFAULT now() NOT NULL,
	PRIMARY KEY (title)
);



/* Create Foreign Keys */

ALTER TABLE tagtodo
	ADD FOREIGN KEY (tagID)
	REFERENCES tag (tagID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE tagtodo
	ADD FOREIGN KEY (title)
	REFERENCES todo (title)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



