CREATE TABLE IF NOT EXISTS youtuber(
	id SERIAL,
	channel VARCHAR(100) NOT NULL,
	all_videos INT NOT NULL,
	monetize BOOLEAN DEFAULT FALSE,
	PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS video(
	id SERIAL,
	youtuber_id INT NOT NULL,
	title VARCHAR (100) NOT NULL,
	duration INT NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (youtuber_id) REFERENCES youtuber(id)
);