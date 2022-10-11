USE `hoteldb`;
DROP procedure IF EXISTS `getAllEmployees`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `getAllEmployees` ()
BEGIN
	SELECT * FROM hoteldb.employees  WHERE hoteldb.employees.is_deleted = 0;
END$$

DELIMITER ;

USE `hoteldb`;
DROP procedure IF EXISTS `getEmployeeById`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `getEmployeeById` (
IN id INT
)
BEGIN
	SELECT * FROM hoteldb.employees WHERE hoteldb.employees.emp_id = id AND hoteldb.employees.is_deleted = 0;
END$$

DELIMITER ;

USE `hoteldb`;
DROP procedure IF EXISTS `deleteEmployeeById`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `deleteEmployeeById` (
IN id INT
)
BEGIN
	UPDATE `hoteldb`.`employees` SET `is_deleted` = '1' WHERE (`emp_id` = id);
END$$

DELIMITER


USE `hoteldb`;
DROP procedure IF EXISTS `updateEmployeeById`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `updateEmployeeById` (
IN id INTEGER,
IN name varchar(50),
IN phone char(12),
IN email varchar(50),
IN type varchar(20),
IN password varchar(50),
IN profile varchar(20)
)
BEGIN
	UPDATE `employees` SET `emp_name` = name, `phone` = phone, `email` = email, `type` = type, `password` = password, `profile_pic` = profile WHERE `employees`.`emp_id` = id;
END$$

DELIMITER ;

USE `hoteldb`;
DROP procedure IF EXISTS `addEmployee`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `addEmployee` (
IN name varchar(50),
IN phone char(12),
IN email varchar(50),
IN type varchar(20),
IN password varchar(50),
IN profile varchar(20)
)
BEGIN
	INSERT INTO `employees` (`emp_name`, `phone`, `email`, `type`, `password`, `profile_pic`)
	VALUES (name, phone, email, type, password, profile);
END$$

DELIMITER ;

CREATE
    ALGORITHM = UNDEFINED
    DEFINER = `root`@`localhost`
    SQL SECURITY DEFINER
VIEW `hoteldb`.`foodCategoryTotalSoldPrice` AS
    SELECT
        `hoteldb`.`food_category`.`fc_name` AS `Food Category`,
        SUM(`hoteldb`.`foods`.`price`) AS `Total Price`
    FROM
        (`hoteldb`.`foods`
        JOIN `hoteldb`.`food_category`)
    WHERE
        ((`hoteldb`.`foods`.`food_category` = `hoteldb`.`food_category`.`fc_id`)
            AND (`hoteldb`.`foods`.`is_deleted` = 0))
    GROUP BY `hoteldb`.`foods`.`food_category`



    CREATE DEFINER=`webuser`@`%` PROCEDURE `searchMessageByKeyword`(
    IN keyword VARCHAR(50)
    )
    BEGIN
    SELECT * FROM messages
    	WHERE title LIKE CONCAT('%', keyword , '%')OR message LIKE CONCAT('%',keyword , '%');
    END