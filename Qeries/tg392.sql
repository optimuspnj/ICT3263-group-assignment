-- GET ALL BOOKINGS

USE `hoteldb`;
DROP procedure IF EXISTS `getAllBookings`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `getAllBookings` ()
BEGIN
	SELECT booking_id,booking_date,arrival_date,departure_date,booking_amount,customers.cus_name FROM hoteldb.bookings LEFT JOIN hoteldb.customers ON hoteldb.bookings.cus_id = hoteldb.customers.cus_id WHERE hoteldb.bookings.is_deleted = 0;
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

-- 	GET LIST OF BOOKINGS FOR SPECIFIC DATE RANGE

USE `hoteldb`;
DROP procedure IF EXISTS `getBookingsByDateRange`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `getBookingsByDateRange` ()
BEGIN
SELECT * 
	FROM hoteldb.bookings
    WHERE booking_date > start_date AND  booking_date < end_date AND is_deleted = 0;
END$$

DELIMITER ;

-- http://localhost:8080/bookings/bookingRange/2022-10-04_2022-10-30

-- WHEN FOOD CATEGORY IS DELETED RELATED FOOD ITEMS TO DELETE

DELIMITER $$

CREATE TRIGGER deleteFoodOnFoodCatDelete
    BEFORE UPDATE
    ON food_category FOR EACH ROW
BEGIN
	IF NEW.is_deleted = 1 THEN
		UPDATE `hoteldb`.`foods` SET `is_deleted` = '1' WHERE (`food_category` = OLD.fc_id);
    END IF;
END$$    

DELIMITER ;
