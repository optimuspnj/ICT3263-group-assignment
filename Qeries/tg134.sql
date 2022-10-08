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

