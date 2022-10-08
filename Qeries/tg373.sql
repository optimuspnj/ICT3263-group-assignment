

-- Get All Rooms By ID Procedure

use hoteldb;

SELECT * FROM hoteldb.rooms;

USE `hoteldb`;
DROP procedure IF EXISTS `getAllRooms`;

DELIMITER $$

USE `hoteldb`$$
CREATE PROCEDURE `getAllRooms` ()
BEGIN
	SELECT * FROM hoteldb.rooms WHERE hoteldb.rooms.is_deleted = 0;
END$$

DELIMITER ;


-- Add Room Procedure

USE `hoteldb`;
DROP procedure IF EXISTS `addRoom`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `addRoom`(
IN room_name VARCHAR(50),
IN room_description VARCHAR(2000),
IN room_status VARCHAR(50),
IN daily_rate DOUBLE,
IN room_qty INT,
IN max_guest INT,
IN room_image VARCHAR(50),
IN room_category INT

)
BEGIN
	INSERT INTO `rooms` (`room_name`, `room_description`, `room_status`, `daily_rate`, `room_qty`,`max_guest`,`room_image`,`room_category`) 
	VALUES (room_name, room_description, room_status, daily_rate, room_qty,max_guest,room_image,room_category);
END$$

DELIMITER ;




-- Get Room By ID Procedure

USE `hoteldb`;
DROP procedure IF EXISTS `getRoomById`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `getRoomById`(IN id INT)
BEGIN
	SELECT * FROM hoteldb.rooms WHERE hoteldb.rooms.room_id = id AND hoteldb.rooms.is_deleted = 0;
END$$

DELIMITER ;



-- Get Room By ID Procedure

USE `hoteldb`;
DROP procedure IF EXISTS `deleteRoomById`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `deleteRoomById`(IN id INT)
BEGIN
	UPDATE `hoteldb`.`rooms` SET `is_deleted` = '1' WHERE (`room_id` = id);
END$$

DELIMITER ;


-- Uddate Room By ID Procedure

USE `hoteldb`;
DROP procedure IF EXISTS `updateRoomById`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `updateRoomById`(
IN id INT,
IN room_name VARCHAR(50),
IN room_description VARCHAR(2000),
IN room_status VARCHAR(50),
IN daily_rate DOUBLE,
IN room_qty INT,
IN max_guest INT,
IN room_image VARCHAR(50),
IN room_category INT
)
BEGIN
	UPDATE `hoteldb`.`rooms` SET `room_name` = room_name, `room_description` = room_description, `room_status` = room_status, `daily_rate` = daily_rate, `room_qty` = room_qty, `max_guest` = max_guest, `room_image` = room_image, `room_category` = room_category WHERE (`booking_id` = id);
END$$

DELIMITER ;



-- Get All Room Categories Procedure


USE `hoteldb`;
DROP procedure IF EXISTS `getAllRoomCategories`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `getAllRoomCategories`()
BEGIN
	SELECT * FROM hoteldb.room_category;
END$$

DELIMITER ;





-- Add  Room Category Procedure

USE `hoteldb`;
DROP procedure IF EXISTS `addRoomCategory`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `addRoomCategory`(
IN cat_name VARCHAR(50),
IN cat_image VARCHAR(50)

)
BEGIN
	INSERT INTO `hoteldb`.`room_category` (`cat_name`, `cat_image`) VALUES (cat_name, cat_image);
END$$

DELIMITER ;




-- Delete Room Category By ID Procedure

USE `hoteldb`;
DROP procedure IF EXISTS `hoteldb`.`deleteRoomCategoryById`;
;

DELIMITER $$
USE `hoteldb`$$
CREATE DEFINER=`webuser`@`%` PROCEDURE `deleteRoomCategoryById`(
IN id INT
)
BEGIN
	DELETE FROM `hoteldb`.`room_category` WHERE (`cat_id` = id);
END$$

DELIMITER ;
;



-- Get All Room Facilities

USE `hoteldb`;
DROP procedure IF EXISTS `getAllRoomFacilities`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `getAllRoomFacilities`()
BEGIN
	SELECT * FROM hoteldb.facilities;
END$$

DELIMITER ;




-- Add Room Facility

USE `hoteldb`;
DROP procedure IF EXISTS `addRoomFacility`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `addRoomFacility`(
IN fac_name VARCHAR(50),
IN image VARCHAR(50)

)
BEGIN
	INSERT INTO `hoteldb`.`facilities` (`fac_name`, `image`) VALUES (fac_name, image);
END$$

DELIMITER ;




-- Delete Room Facility By ID

USE `hoteldb`;
DROP procedure IF EXISTS `deleteRoomFacilityById`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `deleteRoomFacilityById`(IN id INT)
BEGIN
	UPDATE `hoteldb`.`facilities` SET `is_deleted` = '1' WHERE (`fac_id` = id);
END$$

DELIMITER ;





