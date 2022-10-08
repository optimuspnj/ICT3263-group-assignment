-- GET ALL BOOKINGS

USE `hoteldb`;
DROP procedure IF EXISTS `getAllBookings`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `getAllBookings` ()
BEGIN
	SELECT * FROM hoteldb.bookings WHERE hoteldb.bookings.is_deleted = 0;
END$$

DELIMITER ;

-- GET BOOKING BY ID

USE `hoteldb`;
DROP procedure IF EXISTS `getBookingById`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `getBookingById` (IN id INT)
BEGIN
	SELECT * FROM hoteldb.bookings WHERE hoteldb.bookings.booking_id = id AND hoteldb.bookings.is_deleted = 0;
END$$

DELIMITER ;

-- DELETE BOOKING BY ID

USE `hoteldb`;
DROP procedure IF EXISTS `deleteBookingById`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `deleteBookingById` (IN id INT)
BEGIN
	UPDATE `hoteldb`.`bookings` SET `is_deleted` = '1' WHERE (`booking_id` = id);
END$$

DELIMITER ;

-- ADD NEW BOOKING

USE `hoteldb`;
DROP procedure IF EXISTS `addBooking`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `addBooking` (
IN bdate DATE,
IN adate DATE,
IN ddate DATE,
IN amount DOUBLE,
IN cus INT
)
BEGIN
	INSERT INTO `bookings` (`booking_date`, `arrival_date`, `departure_date`, `booking_amount`, `cus_id`) 
	VALUES (bdate, adate, ddate, amount, cus);
END$$

DELIMITER ;

-- UPDATE BOOKING BY ID

USE `hoteldb`;
DROP procedure IF EXISTS `updateBookingById`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `updateBookingById` (
IN id INT,
IN bdate DATE,
IN adate DATE,
IN ddate DATE,
IN amount DOUBLE
)
BEGIN
	UPDATE `hoteldb`.`bookings` SET `booking_date` = bdate, `arrival_date` = adate, `departure_date` = ddate, `booking_amount` = amount WHERE (`booking_id` = id);
END$$

DELIMITER ;

