USE `hoteldb`;
DROP procedure IF EXISTS `getAllCustomers`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `getAllCustomers` ()
BEGIN
SELECT * FROM hoteldb.customers  WHERE hoteldb.customers.is_deleted = 0;
END$$

DELIMITER ;

USE `hoteldb`;
DROP procedure IF EXISTS `getCustomerById`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `getCustomerById` (IN id INT)
BEGIN
SELECT * FROM hoteldb.customers 
WHERE hoteldb.customers.cus_id = id AND hoteldb.customers.is_deleted = 0;
END$$

DELIMITER ;

USE `hoteldb`;
DROP procedure IF EXISTS `deleteCustomerById`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `deleteCustomerById` (
IN id INT
)
BEGIN
	UPDATE `hoteldb`.`customers` SET `is_deleted` = '1' WHERE (`cus_id` = id);
END$$

DELIMITER ;

USE `hoteldb`;
DROP procedure IF EXISTS `updateCustomerById`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `updateCustomerById` (
IN id INT,
IN name varchar(100),
IN email varchar(50),
IN address varchar (200),
IN nic varchar (12),
IN phone char(12),
IN password char(100),
IN profile varchar (50)
)
BEGIN
	UPDATE `customers` SET `cus_name` = name, `email` = email, `address` = address, `nic` = nic, `phone` = phone, `password` = password, `profile_pic` = profile WHERE `customers`.`cus_id` = id;
END$$

DELIMITER ;


USE `hoteldb`;
DROP procedure IF EXISTS `addCustomer`;

DELIMITER $$
USE `hoteldb`$$
CREATE PROCEDURE `addCustomer` (
IN name varchar(100),
IN email varchar(50),
IN address varchar (200),
IN nic varchar (12),
IN phone char(12),
IN password char(100),
IN profile varchar (50)
)
BEGIN
	INSERT INTO `customers` (`cus_name`, `email`, `address`, `nic`, `phone`, `password`, `profile_pic`) VALUES (name, email, address, nic, phone, password, profile);
END$$

DELIMITER ;