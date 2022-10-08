USE `hoteldb`;
DROP procedure IF EXISTS `getAllFoodOrder`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `getAllFoodOrder` ()
BEGIN
SELECT * FROM hoteldb.food_orders WHERE hoteldb.food_orders.is_deleted = 0;
END$$

DELIMITER ;

USE `hoteldb`;
DROP procedure IF EXISTS `getFoodOrdersById`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `getFoodOrdersById` (IN id INT)
BEGIN
SELECT * FROM hoteldb.food_orders WHERE hoteldb.food_orders.fo_id = id AND hoteldb.food_orders.is_deleted = 0;
END$$

DELIMITER ;

USE `hoteldb`;
DROP procedure IF EXISTS `deleteFoodOrderById`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `deleteFoodOrderById` (IN id INT)
BEGIN
UPDATE `hoteldb`.`food_orders` SET `is_deleted` = '1' WHERE (`fo_id` = id);
END$$

DELIMITER ;


USE `hoteldb`;
DROP procedure IF EXISTS `updateFoodOrderById`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `updateFoodOrderById` (
IN id int,
IN pday date,
In pay DOUBLE

)
BEGIN
UPDATE `hoteldb`.`food_orders` SET `date` = pday, `total_payment` = pay  WHERE food_orders.fo_id = id;

END$$

DELIMITER ;

USE `hoteldb`;
DROP procedure IF EXISTS `addFoodOrder`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `addFoodOrder` (
IN pday date,
IN c_id int,
IN pay double
)
BEGIN
INSERT INTO `food_orders` (`date`, `cus_id`, `total_payment`) 
	VALUES (pday, c_id,pay);
END$$

DELIMITER ;


