-- ADD MESSAGE

USE `hoteldb`;
DROP procedure IF EXISTS `addMessage`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `addMessage` (
IN name VARCHAR(50),
IN email VARCHAR(50),
IN phone CHAR(12),
IN title VARCHAR(50),
IN message VARCHAR(200)
)
BEGIN
	INSERT INTO `hoteldb`.`messages` (`name`, `email`, `phone`, `title`, `message`) VALUES (name, email, phone, title, message);
END$$

DELIMITER ;

-- GET ALL MESSAGES

USE `hoteldb`;
DROP procedure IF EXISTS `getAllMessages`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `getAllMessages` ()
BEGIN
	SELECT * FROM hoteldb.messages;
END$$

DELIMITER ;

-- DELETE MESSAGE BY ID

USE `hoteldb`;
DROP procedure IF EXISTS `deleteMessageById`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `deleteMessageById` (
IN id INT
)
BEGIN
	DELETE FROM `hoteldb`.`messages` WHERE (`msg_id` = id);
END$$

DELIMITER ;

