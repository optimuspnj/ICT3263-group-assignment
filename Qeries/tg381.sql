-- FOOD module
-- GET ALL FOODS

USE `hoteldb`;
DROP procedure IF EXISTS `getAllFoods`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `getAllFoods` ()
BEGIN
	SELECT * FROM hoteldb.foods WHERE hoteldb.foods.is_deleted = 0;
END$$

DELIMITER ;

-- ADD FOOD

USE `hoteldb`;
DROP procedure IF EXISTS `addFood`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `addFood` (
IN fname varchar(50),
IN descr varchar(2000),
IN fprice decimal(10,0),
IN fimage varchar(50),
IN fcategory INT
)
BEGIN
	INSERT INTO `foods` (`food_name`, `description`, `price`, `image`, `food_category`) 
	VALUES (fname, descr, fprice, fimage, fcategory);
END$$

DELIMITER ; 

-- GET FOOD BY ID

USE `hoteldb`;
DROP procedure IF EXISTS `getFoodById`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `getFoodById` (IN id INT)
BEGIN
	SELECT * FROM hoteldb.foods WHERE hoteldb.foods.food_id = id AND hoteldb.foods.is_deleted = 0;
END$$

DELIMITER ;

-- DELETE FOOD BY ID

USE `hoteldb`;
DROP procedure IF EXISTS `deleteFoodById`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `deleteFoodById` (IN id INT)
BEGIN
	UPDATE `hoteldb`.`foods` SET `is_deleted` = '1' WHERE (`food_id` = id);
END$$

DELIMITER ;

-- UPDATE FOOD BY ID

USE `hoteldb`;
DROP procedure IF EXISTS `updateFoodById`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `updateFoodById` (
IN id INT,
IN fname varchar(50),
IN descr varchar(2000),
IN fprice decimal(10,0),
IN fimage varchar(50),
IN fcategory INT
)
BEGIN
	UPDATE `hoteldb`.`foods` SET `food_name` = fname, `description` = descr, `price` = fprice, `image` = fimage, `food_category` = fcategory WHERE (`food_id` = id);
END$$

DELIMITER ;