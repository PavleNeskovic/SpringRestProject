USE masterproject;

CREATE TABLE user (
id INT UNSIGNED NOT NULL AUTO_INCREMENT,
firstname VARCHAR(60) NOT NULL,
lastname VARCHAR(60) NOT NULL,
age TINYINT NULL,
address VARCHAR(255) NULL,
city VARCHAR(60) NULL,
phonenumber VARCHAR(20) NOT NULL,
PRIMARY KEY (id)
)ENGINE = INNODB;