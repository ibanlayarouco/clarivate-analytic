DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS highscore;

CREATE TABLE user (
	username	VARCHAR(30) NOT NULL,
	password	VARCHAR(30) NOT NULL
);

ALTER TABLE user ADD CONSTRAINT p_user PRIMARY KEY (username);

CREATE TABLE highscore (
	id			bigint auto_increment,
	username	VARCHAR(30) NOT NULL,
	level		INT NOT NULL,
	score		INT NOT NULL
);
ALTER TABLE highscore ADD CONSTRAINT p_highscore PRIMARY KEY (username, level);
ALTER TABLE highscore ADD CONSTRAINT f_highscore1 FOREIGN KEY (username) REFERENCES user (username);

INSERT INTO user VALUES('user1', 'password1');
INSERT INTO user VALUES('user2', 'password2');
INSERT INTO user VALUES('user3', 'password3');
INSERT INTO user VALUES('user4', 'password4');
