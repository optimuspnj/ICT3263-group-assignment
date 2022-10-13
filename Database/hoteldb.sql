-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Oct 11, 2022 at 08:21 PM
-- Server version: 8.0.30-0ubuntu0.20.04.2
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hoteldb`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`webuser`@`%` PROCEDURE `addBooking` (IN `bdate` DATE, IN `adate` DATE, IN `ddate` DATE, IN `amount` DOUBLE, IN `cus` INT)  BEGIN
	INSERT INTO `bookings` (`booking_date`, `arrival_date`, `departure_date`, `booking_amount`, `cus_id`) 
	VALUES (bdate, adate, ddate, amount, cus);
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `addCustomer` (IN `name` VARCHAR(100), IN `email` VARCHAR(50), IN `address` VARCHAR(200), IN `nic` VARCHAR(12), IN `phone` CHAR(12), IN `password` CHAR(100), IN `profile` VARCHAR(50))  BEGIN
	INSERT INTO `customers` (`cus_name`, `email`, `address`, `nic`, `phone`, `password`, `profile_pic`) VALUES (name, email, address, nic, phone, password, profile);
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `addEmployee` (IN `name` VARCHAR(50), IN `phone` CHAR(12), IN `email` VARCHAR(50), IN `type` VARCHAR(20), IN `password` VARCHAR(50), IN `profile` VARCHAR(20))  BEGIN
	INSERT INTO `employees` (`emp_name`, `phone`, `email`, `type`, `password`, `profile_pic`) 
	VALUES (name, phone, email, type, password, profile);
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `addFood` (IN `fname` VARCHAR(50), IN `descr` VARCHAR(2000), IN `fprice` DECIMAL(10,0), IN `fimage` VARCHAR(50), IN `fcategory` INT)  BEGIN
	INSERT INTO `foods` (`food_name`, `description`, `price`, `image`, `food_category`) 
	VALUES (fname, descr, fprice, fimage, fcategory);
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `addFoodCategory` (IN `f_category` VARCHAR(50))  BEGIN
	INSERT INTO `food_category` (`fc_name`) 
	VALUES (f_category);
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `addFoodOrder` (IN `pday` DATE, IN `c_id` INT, IN `pay` DOUBLE)  BEGIN
INSERT INTO `food_orders` (`date`, `cus_id`, `total_payment`) 
	VALUES (pday, c_id,pay);
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `addMessage` (IN `name` VARCHAR(50), IN `email` VARCHAR(50), IN `phone` CHAR(12), IN `title` VARCHAR(50), IN `message` VARCHAR(200))  BEGIN
	INSERT INTO `hoteldb`.`messages` (`name`, `email`, `phone`, `title`, `message`) VALUES (name, email, phone, title, message);
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `addRoom` (IN `room_name` VARCHAR(50), IN `room_description` VARCHAR(2000), IN `room_status` VARCHAR(50), IN `daily_rate` DOUBLE, IN `room_qty` INT, IN `max_guest` INT, IN `room_image` VARCHAR(50), IN `room_category` INT)  BEGIN
	INSERT INTO `rooms` (`room_name`, `room_description`, `room_status`, `daily_rate`, `room_qty`,`max_guest`,`room_image`,`room_category`) 
	VALUES (room_name, room_description, room_status, daily_rate, room_qty,max_guest,room_image,room_category);
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `addRoomCategory` (IN `cat_name` VARCHAR(50), IN `cat_image` VARCHAR(50))  BEGIN
	INSERT INTO `hoteldb`.`room_category` (`cat_name`, `cat_image`) VALUES (cat_name, cat_image);
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `addRoomFacility` (IN `fac_name` VARCHAR(50), IN `image` VARCHAR(50))  BEGIN
	INSERT INTO `hoteldb`.`facilities` (`fac_name`, `image`) VALUES (fac_name, image);
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `deleteBookingById` (IN `id` INT)  BEGIN
	UPDATE `hoteldb`.`bookings` SET `is_deleted` = '1' WHERE (`booking_id` = id);
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `deleteCustomerById` (IN `id` INT)  BEGIN
	UPDATE `hoteldb`.`customers` SET `is_deleted` = '1' WHERE (`cus_id` = id);
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `deleteEmployeeById` (IN `id` INT)  BEGIN
	UPDATE `hoteldb`.`employees` SET `is_deleted` = '1' WHERE (`emp_id` = id);
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `deleteFoodById` (IN `id` INT)  BEGIN
	UPDATE `hoteldb`.`foods` SET `is_deleted` = '1' WHERE (`food_id` = id);
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `deleteFoodCategoryById` (IN `id` INT)  BEGIN
	UPDATE `hoteldb`.`food_category` SET `is_deleted` = '1' WHERE (`fc_id` = id);
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `deleteFoodOrderById` (IN `id` INT)  BEGIN
UPDATE `hoteldb`.`food_orders` SET `is_deleted` = '1' WHERE (`fo_id` = id);
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `deleteMessageById` (IN `id` INT)  BEGIN
	DELETE FROM `hoteldb`.`messages` WHERE (`msg_id` = id);
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `deleteRoomById` (IN `id` INT)  BEGIN
	UPDATE `hoteldb`.`rooms` SET `is_deleted` = '1' WHERE (`room_id` = id);
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `deleteRoomCategoryById` (IN `id` INT)  BEGIN
	DELETE FROM `hoteldb`.`room_category` WHERE (`cat_id` = id);
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `deleteRoomFacilityById` (IN `id` INT)  BEGIN
	UPDATE `hoteldb`.`facilities` SET `is_deleted` = '1' WHERE (`fac_id` = id);
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `getAllBookings` ()  BEGIN
	SELECT * FROM hoteldb.bookings WHERE hoteldb.bookings.is_deleted = 0;
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `getAllCustomers` ()  BEGIN
SELECT * FROM hoteldb.customers  WHERE hoteldb.customers.is_deleted = 0;
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `getAllEmployees` ()  BEGIN
	SELECT * FROM hoteldb.employees  WHERE hoteldb.employees.is_deleted = 0;
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `getAllFoodCategory` ()  BEGIN
	SELECT * FROM hoteldb.food_category WHERE hoteldb.food_category.is_deleted = 0;
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `getAllFoodOrder` ()  BEGIN
SELECT * FROM hoteldb.food_orders WHERE hoteldb.food_orders.is_deleted = 0;
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `getAllFoods` ()  BEGIN
	SELECT * FROM hoteldb.foods WHERE hoteldb.foods.is_deleted = 0;
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `getAllMessages` ()  BEGIN
	SELECT * FROM hoteldb.messages;
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `getAllRoomCategories` ()  BEGIN
	SELECT * FROM hoteldb.room_category;
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `getAllRoomFacilities` ()  BEGIN
	SELECT * FROM hoteldb.facilities;
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `getAllRooms` ()  BEGIN
	SELECT * FROM hoteldb.rooms WHERE hoteldb.rooms.is_deleted = 0;
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `getBookingById` (IN `id` INT)  BEGIN
	SELECT * FROM hoteldb.bookings WHERE hoteldb.bookings.booking_id = id AND hoteldb.bookings.is_deleted = 0;
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `getBookingsByDateRange` (IN `start_date` DATE, IN `end_date` DATE)  BEGIN
SELECT * 
	FROM hoteldb.bookings
    WHERE booking_date > start_date AND  booking_date < end_date AND is_deleted = 0;
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `getCustomerById` (IN `id` INT)  BEGIN
SELECT * FROM hoteldb.customers 
WHERE hoteldb.customers.cus_id = id AND hoteldb.customers.is_deleted = 0;
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `getCutomerRewardDiscounts` (IN `customer_id` INT, IN `discount` INT, OUT `reward` DOUBLE)  BEGIN


SELECT sum(booking_amount * discount/100) 
INTO reward 
FROM customers
LEFT JOIN bookings
ON customers.cus_id = bookings.cus_id
GROUP BY customers.cus_id
Having customers.cus_id = customer_id;


END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `getEmployeeById` (IN `id` INT)  BEGIN
	SELECT * FROM hoteldb.employees WHERE hoteldb.employees.emp_id = id AND hoteldb.employees.is_deleted = 0;
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `getFoodById` (IN `id` INT)  BEGIN
	SELECT * FROM hoteldb.foods WHERE hoteldb.foods.food_id = id AND hoteldb.foods.is_deleted = 0;
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `getFoodOrdersById` (IN `id` INT)  BEGIN
SELECT * FROM hoteldb.food_orders WHERE hoteldb.food_orders.fo_id = id AND hoteldb.food_orders.is_deleted = 0;
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `getMonthlyFoodOrderRevenue` (IN `month` VARCHAR(20))  BEGIN

DECLARE month_val INT;

    IF month = "january" THEN
        SET month_val = 1;
        
	ELSEIF  month = "february" THEN
		SET month_val = 2;
	
	ELSEIF  month = "march" THEN
		SET month_val = 3;
        
	ELSEIF  month = "april" THEN
		SET month_val = 4;
        
	ELSEIF  month = "may" THEN
		SET month_val = 5;
        
	ELSEIF  month = "june" THEN
		SET month_val = 6;
        
	ELSEIF  month = "july" THEN
		SET month_val = 7;
        
	ELSEIF  month = "august" THEN
		SET month_val = 82;
        
	ELSEIF  month = "september" THEN
		SET month_val = 9;
        
	ELSEIF  month = "october" THEN
		SET month_val = 10;
        
	ELSEIF  month = "november" THEN
		SET month_val = 11;
        
	ELSEIF  month = "december" THEN
		SET month_val = 12;
        
    END IF;




SELECT sum(total_payment)  FROM food_orders
WHERE  EXTRACT(MONTH FROM date) = month_val AND  EXTRACT(YEAR FROM date) = YEAR(CURRENT_DATE());
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `getRoomById` (IN `id` INT)  BEGIN
	SELECT * FROM hoteldb.rooms WHERE hoteldb.rooms.room_id = id AND hoteldb.rooms.is_deleted = 0;
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `getSummary` (OUT `monthly_income` DOUBLE, OUT `total_rooms` INT, OUT `total_bookings` INT, OUT `total_food_orders` INT, OUT `total_food_items` INT, OUT `total_customers` INT, OUT `total_employees` INT, OUT `total_messages` INT)  BEGIN

SELECT sum(bookings.booking_amount) + sum(food_orders.total_payment) 
INTO monthly_income
FROM bookings,food_orders where booking_date > MONTH(current_date()) AND bookings.is_deleted=0 AND food_orders.is_deleted=0 ;


SELECT count(room_id) 
INTO total_rooms
FROM rooms WHERE is_deleted = 0;


SELECT count(booking_id)
INTO total_bookings
FROM bookings WHERE is_deleted = 0;


SELECT count(fo_id)
INTO total_food_orders
FROM food_orders WHERE is_deleted = 0;



SELECT count(food_id)
INTO total_food_items
FROM foods WHERE is_deleted = 0;


SELECT count(cus_id)
INTO total_customers
FROM customers WHERE is_deleted = 0;

SELECT count(emp_id)
INTO total_employees
FROM employees WHERE is_deleted = 0;


SELECT count(msg_id)
INTO total_messages
FROM messages;




END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `getSummaryData` ()  BEGIN
SELECT 
(SELECT sum(bookings.booking_amount) + sum(food_orders.total_payment) FROM bookings,food_orders where booking_date > MONTH(current_date()) AND bookings.is_deleted=0 AND food_orders.is_deleted= 0) AS `monthly_income`, 
(SELECT count(room_id) FROM rooms WHERE is_deleted = 0) As `total_rooms`,
(SELECT count(booking_id) FROM bookings WHERE is_deleted = 0) AS `total_bookings`,
(SELECT count(fo_id) FROM food_orders WHERE is_deleted = 0) AS `total_food_orders`,
(SELECT count(food_id) FROM foods WHERE is_deleted = 0) AS `total_food_items`,
(SELECT count(cus_id) FROM customers WHERE is_deleted = 0) AS `total_customers`,
(SELECT count(emp_id) FROM employees WHERE is_deleted = 0) AS `total_employees`,
(SELECT count(msg_id) AS `test8` FROM messages) AS `total_messages`;
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `loginHandler` (IN `input_email` VARCHAR(50), IN `input_password` VARCHAR(50), OUT `message` VARCHAR(50))  BEGIN

DECLARE count INT;
DECLARE user_type VARCHAR(50);

SELECT count(emp_id),
type
INTO count,user_type
FROM employees WHERE email = input_email AND password = input_password
GROUP BY emp_id;

IF count=1 THEN 
	SET message = CONCAT("Login Detalis Validated & You logged as a ",user_type);
ELSE 
	SET message = "Login Details Invalid";
END IF;

END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `monthlyFoodOrderRevenue` (IN `month` VARCHAR(20))  BEGIN

DECLARE month_val INT;

    IF month > "january" THEN
        SET month_val = 1;
        
	ELSEIF  month > "february" THEN
		SET month_val = 2;
	
	ELSEIF  month > "march" THEN
		SET month_val = 3;
        
	ELSEIF  month > "april" THEN
		SET month_val = 4;
        
	ELSEIF  month > "may" THEN
		SET month_val = 5;
        
	ELSEIF  month > "june" THEN
		SET month_val = 6;
        
	ELSEIF  month > "july" THEN
		SET month_val = 7;
        
	ELSEIF  month > "august" THEN
		SET month_val = 82;
        
	ELSEIF  month > "september" THEN
		SET month_val = 9;
        
	ELSEIF  month > "october" THEN
		SET month_val = 10;
        
	ELSEIF  month > "november" THEN
		SET month_val = 11;
        
	ELSEIF  month > "december" THEN
		SET month_val = 12;
        
    END IF;




SELECT sum(total_payment)  FROM food_orders
WHERE  EXTRACT(MONTH FROM date) = month_val AND  EXTRACT(YEAR FROM date) = YEAR(CURRENT_DATE());
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `searchMessageByKeyword` (IN `keyword` VARCHAR(50))  BEGIN
SELECT * FROM messages
	WHERE title LIKE CONCAT('%', keyword , '%')OR message LIKE CONCAT('%',keyword , '%');
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `updateBookingById` (IN `id` INT, IN `bdate` DATE, IN `adate` DATE, IN `ddate` DATE, IN `amount` DOUBLE)  BEGIN
	UPDATE `hoteldb`.`bookings` SET `booking_date` = bdate, `arrival_date` = adate, `departure_date` = ddate, `booking_amount` = amount WHERE (`booking_id` = id);
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `updateCustomerById` (IN `id` INT, IN `name` VARCHAR(100), IN `email` VARCHAR(50), IN `address` VARCHAR(200), IN `nic` VARCHAR(12), IN `phone` CHAR(12), IN `password` CHAR(100), IN `profile` VARCHAR(50))  BEGIN
	UPDATE `customers` SET `cus_name` = name, `email` = email, `address` = address, `nic` = nic, `phone` = phone, `password` = password, `profile_pic` = profile WHERE `customers`.`cus_id` = id;
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `updateEmployeeById` (IN `id` INTEGER, IN `name` VARCHAR(50), IN `phone` CHAR(12), IN `email` VARCHAR(50), IN `type` VARCHAR(20), IN `password` VARCHAR(50), IN `profile` VARCHAR(20))  BEGIN
	UPDATE `employees` SET `emp_name` = name, `phone` = phone, `email` = email, `type` = type, `password` = password, `profile_pic` = profile WHERE `employees`.`emp_id` = id;
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `updateFoodById` (IN `id` INT, IN `fname` VARCHAR(50), IN `descr` VARCHAR(2000), IN `fprice` DECIMAL(10,0), IN `fimage` VARCHAR(50), IN `fcategory` INT)  BEGIN
	UPDATE `hoteldb`.`foods` SET `food_name` = fname, `description` = descr, `price` = fprice, `image` = fimage, `food_category` = fcategory WHERE (`food_id` = id);
END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `updateFoodOrderById` (IN `id` INT, IN `pday` DATE, IN `pay` DOUBLE)  BEGIN
UPDATE `hoteldb`.`food_orders` SET `date` = pday, `total_payment` = pay  WHERE food_orders.fo_id = id;

END$$

CREATE DEFINER=`webuser`@`%` PROCEDURE `updateRoomById` (IN `id` INT, IN `room_name` VARCHAR(50), IN `room_description` VARCHAR(2000), IN `room_status` VARCHAR(50), IN `daily_rate` DOUBLE, IN `room_qty` INT, IN `max_guest` INT, IN `room_image` VARCHAR(50), IN `room_category` INT)  BEGIN
	UPDATE `hoteldb`.`rooms` SET `room_name` = room_name, `room_description` = room_description, `room_status` = room_status, `daily_rate` = daily_rate, `room_qty` = room_qty, `max_guest` = max_guest, `room_image` = room_image, `room_category` = room_category WHERE (`room_id` = id);
END$$

--
-- Functions
--
$$

$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE `bookings` (
  `booking_id` int NOT NULL,
  `booking_date` date NOT NULL,
  `arrival_date` date NOT NULL,
  `departure_date` date NOT NULL,
  `booking_amount` double NOT NULL,
  `cus_id` int NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `bookings`
--

INSERT INTO `bookings` (`booking_id`, `booking_date`, `arrival_date`, `departure_date`, `booking_amount`, `cus_id`, `is_deleted`) VALUES
(3, '2022-10-04', '2022-10-08', '2022-10-12', 15000, 3, 1),
(4, '2022-10-12', '2022-10-18', '2022-10-26', 14000, 2, 0),
(5, '2022-10-25', '2022-10-30', '2022-11-02', 36000, 2, 0),
(6, '2022-10-09', '2022-10-08', '2022-10-12', 55000, 3, 1),
(7, '2022-10-22', '2022-10-18', '2022-10-26', 54000, 2, 1),
(8, '2022-10-22', '2022-10-18', '2022-10-26', 69000, 2, 1),
(9, '2022-10-22', '2022-10-18', '2022-10-26', 21000, 2, 1),
(10, '2022-01-30', '2022-01-30', '2022-01-30', 25000, 2, 1),
(11, '2022-10-22', '2022-10-18', '2022-10-26', 50000, 2, 1),
(12, '2022-10-22', '2022-10-18', '2022-10-26', 50000, 2, 1),
(13, '2022-10-22', '2022-10-18', '2022-10-26', 25000, 2, 1),
(14, '2022-10-22', '2022-10-18', '2022-10-26', 27000, 2, 1),
(15, '2022-10-22', '2022-10-18', '2022-10-26', 27000, 2, 1),
(16, '2022-10-11', '2022-10-31', '2022-10-21', 6000, 1, 0),
(17, '2022-10-11', '2022-10-30', '2022-10-30', 6000, 1, 0),
(18, '2022-10-11', '2022-10-09', '2022-10-09', 6000, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `booking_payments`
--

CREATE TABLE `booking_payments` (
  `bp_id` int NOT NULL,
  `date` date NOT NULL,
  `payment_type` varchar(20) NOT NULL,
  `payment_amount` double NOT NULL,
  `booking_id` int NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `booking_rooms`
--

CREATE TABLE `booking_rooms` (
  `br_id` int NOT NULL,
  `booking_id` int NOT NULL,
  `room_id` int NOT NULL,
  `room_count` int NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `cus_id` int NOT NULL,
  `cus_name` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(200) NOT NULL,
  `nic` varchar(12) NOT NULL,
  `phone` char(12) NOT NULL,
  `password` varchar(100) NOT NULL,
  `profile_pic` varchar(50) NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`cus_id`, `cus_name`, `email`, `address`, `nic`, `phone`, `password`, `profile_pic`, `is_deleted`) VALUES
(1, 'Vinod', 'vinod@gmail.com', 'Matara', '982132452147', '0775236524', 'pass', 'No Pic', 1),
(2, 'Gayanga', 'gayanga@gmail.com', 'Kuliyapitiya', '9865421347', '0777777777', 'passwd', 'img', 1),
(3, 'Dinuka', 'dinuka@gmail.com', 'Wallawaya', '975632145213', '0753214569', 'pass', 'No Pic', 1),
(5, 'Sudeera', 'sudeera@gmail.com', 'Balangoda', '986541235', '0786521541', 'pass', 'no', 0),
(6, 'Yohan', 'yohan@gmail.com', 'Balangoda', '984213654', '0788888888', 'passwd', 'No Pics', 1),
(7, 'new cus', 'test@gmail.com', 'test address', '123124314', '234234', '234234', 'img', 0);

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `emp_id` int NOT NULL,
  `emp_name` varchar(50) NOT NULL,
  `phone` char(12) NOT NULL,
  `email` varchar(50) NOT NULL,
  `type` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `profile_pic` varchar(20) NOT NULL,
  `is_deleted` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`emp_id`, `emp_name`, `phone`, `email`, `type`, `password`, `profile_pic`, `is_deleted`) VALUES
(1, 'Lakshan', '0715423687', 'lakshan@gmail.com', 'Cook', 'pass', 'no', 0),
(2, 'Dinuka', '0779856324', 'dinuka@gmail.com', 'Waiter', 'pass', 'no', 1),
(3, 'Madushan Gunarathne', '0754521364', 'madushan@gmail.com', 'Manager', 'pass', 'img', 0),
(4, 'Prageeth', '0717852147', 'prageeth@gmail.com', 'Reciption', 'pass', 'no', 0),
(5, 'Wihanga', '0719635874', 'wihanga@gmail.com', 'Chef', 'pass', 'no', 1),
(6, 'Shanika', '0728564125', 'shanika@gmail.com', 'Reciption', 'pass', 'no', 1),
(7, 'a', '2', 'a', 'Manager', '2', 'img', 0);

-- --------------------------------------------------------

--
-- Table structure for table `facilities`
--

CREATE TABLE `facilities` (
  `fac_id` int NOT NULL,
  `fac_name` varchar(50) NOT NULL,
  `image` varchar(50) NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `facilities`
--

INSERT INTO `facilities` (`fac_id`, `fac_name`, `image`, `is_deleted`) VALUES
(1, 'AC', 'dwerer', 0),
(2, 'Swimming Pool', 'dwerer', 1),
(3, 'Test', 'dwerer', 0),
(4, 'wewgerg', 'test', 1),
(5, 'new t', 'test', 1),
(6, 'AA', 'test', 1);

-- --------------------------------------------------------

--
-- Stand-in structure for view `foodCategoryTotalSoldPrice`
-- (See below for the actual view)
--
CREATE TABLE `foodCategoryTotalSoldPrice` (
`Food Category` varchar(50)
,`Total Price` decimal(32,0)
);

-- --------------------------------------------------------

--
-- Table structure for table `foods`
--

CREATE TABLE `foods` (
  `food_id` int NOT NULL,
  `food_name` varchar(50) NOT NULL,
  `description` varchar(2000) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `image` varchar(50) NOT NULL,
  `food_category` int NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `foods`
--

INSERT INTO `foods` (`food_id`, `food_name`, `description`, `price`, `image`, `food_category`, `is_deleted`) VALUES
(1, 'rice', 'rice is rice test', '200', 'url/rf.png', 1, 0),
(2, 'Fried rice-carrot', 'fris rice', '1420', 'url/rf.png', 1, 1),
(3, 'Kottu', 'Cheese KOttu', '1000', 'no', 3, 1),
(4, 'New Food', 'wgerg', '10', 'url/rf.png', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `food_category`
--

CREATE TABLE `food_category` (
  `fc_id` int NOT NULL,
  `fc_name` varchar(50) NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `food_category`
--

INSERT INTO `food_category` (`fc_id`, `fc_name`, `is_deleted`) VALUES
(1, 'breakfast', 1),
(2, 'launch', 1),
(3, 'Dinner', 1),
(4, 'wefwf', 0),
(5, 'tt', 1),
(6, 't', 0);

--
-- Triggers `food_category`
--
DELIMITER $$
CREATE TRIGGER `deleteFoodOnFoodCatDelete` BEFORE UPDATE ON `food_category` FOR EACH ROW BEGIN
	IF NEW.is_deleted = 1 THEN
		UPDATE `hoteldb`.`foods` SET `is_deleted` = '1' WHERE (`food_category` = OLD.fc_id);
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `food_orders`
--

CREATE TABLE `food_orders` (
  `fo_id` int NOT NULL,
  `date` date NOT NULL,
  `cus_id` int NOT NULL,
  `total_payment` double NOT NULL,
  `is_deleted` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `food_orders`
--

INSERT INTO `food_orders` (`fo_id`, `date`, `cus_id`, `total_payment`, `is_deleted`) VALUES
(1, '2022-09-05', 2, 20000, 0),
(2, '2022-10-12', 3, 60005, 0),
(3, '2022-11-16', 3, 90000, 0),
(4, '2022-01-05', 3, 65000, 1),
(5, '2018-01-06', 2, 96000, 1),
(6, '2022-09-07', 2, 50000, 1),
(7, '2022-10-11', 2, 20000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `gallery`
--

CREATE TABLE `gallery` (
  `gal_id` int NOT NULL,
  `gal_title` varchar(50) NOT NULL,
  `gal_category` int NOT NULL,
  `image` varchar(50) NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(2);

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE `messages` (
  `msg_id` int NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` char(12) NOT NULL,
  `title` varchar(50) NOT NULL,
  `message` varchar(200) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `messages`
--

INSERT INTO `messages` (`msg_id`, `name`, `email`, `phone`, `title`, `message`, `date`) VALUES
(7, 'Dinuka', 'dinuka@gmail.com', '0718653241', 'Help', 'Content', '2022-10-10 17:03:37'),
(9, 'kamal', '', '', '', '', '2022-10-11 07:48:53');

-- --------------------------------------------------------

--
-- Table structure for table `order_food_items`
--

CREATE TABLE `order_food_items` (
  `ofi_id` int NOT NULL,
  `order_id` int NOT NULL,
  `food_id` int NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `order_food_items`
--

INSERT INTO `order_food_items` (`ofi_id`, `order_id`, `food_id`, `is_deleted`) VALUES
(1, 1, 1, 0),
(2, 1, 2, 0);

-- --------------------------------------------------------

--
-- Table structure for table `rooms`
--

CREATE TABLE `rooms` (
  `room_id` int NOT NULL,
  `room_name` varchar(100) NOT NULL,
  `room_description` varchar(2000) NOT NULL,
  `room_status` varchar(20) NOT NULL,
  `daily_rate` decimal(10,0) NOT NULL,
  `room_qty` int NOT NULL,
  `max_guest` int NOT NULL,
  `room_image` varchar(50) NOT NULL,
  `room_category` int NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `rooms`
--

INSERT INTO `rooms` (`room_id`, `room_name`, `room_description`, `room_status`, `daily_rate`, `room_qty`, `max_guest`, `room_image`, `room_category`, `is_deleted`) VALUES
(1, 'Double Bed Non AC With Balcony', 'Double Bed Non AC', 'Available', '1000', 10, 2, '', 1, 1),
(2, 'fwefwe', 'wefwef', 'fwef', '32', 2, 2, 'wefwe', 1, 1),
(3, 'Double Bed Non AC', 'Test', 'Available', '50', 10, 2, '', 1, 1),
(4, 'AC Room with Balcony', 'Double Bed Non AC', 'Available', '800', 34, 34, '', 1, 1),
(5, 'Non AC Room', 'Non AC Room', 'Available', '1500', 23, 23, '', 1, 1),
(6, 'New Room', 'New Room', 'AK', '1200', 10, 5, '', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `room_category`
--

CREATE TABLE `room_category` (
  `cat_id` int NOT NULL,
  `cat_name` varchar(100) NOT NULL,
  `cat_image` varchar(50) NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `room_category`
--

INSERT INTO `room_category` (`cat_id`, `cat_name`, `cat_image`, `is_deleted`) VALUES
(1, 'Luxury Double Room', 'no', 0),
(5, 'qwdqd', 'test', 0),
(6, 'wefwef', 'test', 0),
(7, 'test', 'test', 0),
(8, 'test', 'test', 0),
(9, 'new test', 'test', 0),
(10, 'test item', 'test', 0),
(11, 'temp', 'test', 0),
(12, 'ne', 'test', 0),
(13, 'tett', 'test', 0),
(15, '', 'password', 0),
(16, '', 'password', 0),
(20, '', 'password', 0),
(22, 'AC', 'test', 0),
(23, 'AC', 'test', 0),
(24, 'AC', 'test', 0);

--
-- Triggers `room_category`
--
DELIMITER $$
CREATE TRIGGER `deleteRoomOnRoomCatDelete` BEFORE UPDATE ON `room_category` FOR EACH ROW BEGIN
	IF NEW.is_deleted = 1 THEN
		UPDATE `hoteldb`.`rooms` SET `is_deleted` = '1' WHERE (`room_category` = OLD.cat_id);
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `room_facilities`
--

CREATE TABLE `room_facilities` (
  `room_facility_id` int NOT NULL,
  `room_id` int NOT NULL,
  `facility_id` int NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `room_gallery`
--

CREATE TABLE `room_gallery` (
  `gallery_id` int NOT NULL,
  `gallery_image` varchar(50) NOT NULL,
  `room_id` int NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Stand-in structure for view `totalPaymentsByCustomer`
-- (See below for the actual view)
--
CREATE TABLE `totalPaymentsByCustomer` (
`Customer Name` varchar(100)
,`Total Payments` double
);

-- --------------------------------------------------------

--
-- Structure for view `foodCategoryTotalSoldPrice`
--
DROP TABLE IF EXISTS `foodCategoryTotalSoldPrice`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `foodCategoryTotalSoldPrice`  AS  select `food_category`.`fc_name` AS `Food Category`,sum(`foods`.`price`) AS `Total Price` from (`foods` join `food_category`) where ((`foods`.`food_category` = `food_category`.`fc_id`) and (`foods`.`is_deleted` = 0)) group by `foods`.`food_category` ;

-- --------------------------------------------------------

--
-- Structure for view `totalPaymentsByCustomer`
--
DROP TABLE IF EXISTS `totalPaymentsByCustomer`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `totalPaymentsByCustomer`  AS  select `customers`.`cus_name` AS `Customer Name`,sum(`bookings`.`booking_amount`) AS `Total Payments` from (`customers` left join `bookings` on((`customers`.`cus_id` = `bookings`.`cus_id`))) group by `customers`.`cus_id` ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`booking_id`),
  ADD KEY `cus_id` (`cus_id`);

--
-- Indexes for table `booking_payments`
--
ALTER TABLE `booking_payments`
  ADD PRIMARY KEY (`bp_id`),
  ADD KEY `booking_id` (`booking_id`);

--
-- Indexes for table `booking_rooms`
--
ALTER TABLE `booking_rooms`
  ADD PRIMARY KEY (`br_id`),
  ADD KEY `room_id` (`room_id`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`cus_id`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`emp_id`);

--
-- Indexes for table `facilities`
--
ALTER TABLE `facilities`
  ADD PRIMARY KEY (`fac_id`);

--
-- Indexes for table `foods`
--
ALTER TABLE `foods`
  ADD PRIMARY KEY (`food_id`),
  ADD KEY `food_category` (`food_category`);

--
-- Indexes for table `food_category`
--
ALTER TABLE `food_category`
  ADD PRIMARY KEY (`fc_id`);

--
-- Indexes for table `food_orders`
--
ALTER TABLE `food_orders`
  ADD PRIMARY KEY (`fo_id`),
  ADD KEY `cus_id` (`cus_id`);

--
-- Indexes for table `gallery`
--
ALTER TABLE `gallery`
  ADD PRIMARY KEY (`gal_id`);

--
-- Indexes for table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`msg_id`);

--
-- Indexes for table `order_food_items`
--
ALTER TABLE `order_food_items`
  ADD PRIMARY KEY (`ofi_id`),
  ADD KEY `order_id` (`order_id`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`room_id`),
  ADD KEY `room_category` (`room_category`);

--
-- Indexes for table `room_category`
--
ALTER TABLE `room_category`
  ADD PRIMARY KEY (`cat_id`);

--
-- Indexes for table `room_facilities`
--
ALTER TABLE `room_facilities`
  ADD PRIMARY KEY (`room_facility_id`),
  ADD KEY `facility_id` (`facility_id`),
  ADD KEY `room_id` (`room_id`);

--
-- Indexes for table `room_gallery`
--
ALTER TABLE `room_gallery`
  ADD PRIMARY KEY (`gallery_id`),
  ADD KEY `room_id` (`room_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bookings`
--
ALTER TABLE `bookings`
  MODIFY `booking_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `booking_payments`
--
ALTER TABLE `booking_payments`
  MODIFY `bp_id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `booking_rooms`
--
ALTER TABLE `booking_rooms`
  MODIFY `br_id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `cus_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `emp_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `facilities`
--
ALTER TABLE `facilities`
  MODIFY `fac_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `foods`
--
ALTER TABLE `foods`
  MODIFY `food_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `food_category`
--
ALTER TABLE `food_category`
  MODIFY `fc_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `food_orders`
--
ALTER TABLE `food_orders`
  MODIFY `fo_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `gallery`
--
ALTER TABLE `gallery`
  MODIFY `gal_id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `messages`
--
ALTER TABLE `messages`
  MODIFY `msg_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `order_food_items`
--
ALTER TABLE `order_food_items`
  MODIFY `ofi_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `rooms`
--
ALTER TABLE `rooms`
  MODIFY `room_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `room_category`
--
ALTER TABLE `room_category`
  MODIFY `cat_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `room_facilities`
--
ALTER TABLE `room_facilities`
  MODIFY `room_facility_id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `room_gallery`
--
ALTER TABLE `room_gallery`
  MODIFY `gallery_id` int NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bookings`
--
ALTER TABLE `bookings`
  ADD CONSTRAINT `bookings_ibfk_1` FOREIGN KEY (`cus_id`) REFERENCES `customers` (`cus_id`);

--
-- Constraints for table `booking_payments`
--
ALTER TABLE `booking_payments`
  ADD CONSTRAINT `booking_payments_ibfk_1` FOREIGN KEY (`booking_id`) REFERENCES `bookings` (`booking_id`),
  ADD CONSTRAINT `FKfhwt29c9x2ibo2o6r2ieq84ej` FOREIGN KEY (`booking_id`) REFERENCES `bookings` (`booking_id`);

--
-- Constraints for table `booking_rooms`
--
ALTER TABLE `booking_rooms`
  ADD CONSTRAINT `booking_rooms_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`room_id`),
  ADD CONSTRAINT `FKcjk0abrppkbsw5w03uq8tvgfc` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`room_id`);

--
-- Constraints for table `foods`
--
ALTER TABLE `foods`
  ADD CONSTRAINT `FK1t2xc0g38w9502wxp1fi5ck7e` FOREIGN KEY (`food_category`) REFERENCES `food_category` (`fc_id`),
  ADD CONSTRAINT `foods_ibfk_1` FOREIGN KEY (`food_category`) REFERENCES `food_category` (`fc_id`);

--
-- Constraints for table `food_orders`
--
ALTER TABLE `food_orders`
  ADD CONSTRAINT `FK13iw0bevsibtf8e9nlmobdjtg` FOREIGN KEY (`cus_id`) REFERENCES `customers` (`cus_id`),
  ADD CONSTRAINT `food_orders_ibfk_1` FOREIGN KEY (`cus_id`) REFERENCES `customers` (`cus_id`);

--
-- Constraints for table `order_food_items`
--
ALTER TABLE `order_food_items`
  ADD CONSTRAINT `FKql6cgfg643gpp9m45bimwgg2o` FOREIGN KEY (`order_id`) REFERENCES `food_orders` (`fo_id`),
  ADD CONSTRAINT `order_food_items_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `food_orders` (`fo_id`);

--
-- Constraints for table `rooms`
--
ALTER TABLE `rooms`
  ADD CONSTRAINT `FKo5gn8tb53vbnly47f0s8ulsso` FOREIGN KEY (`room_category`) REFERENCES `room_category` (`cat_id`),
  ADD CONSTRAINT `rooms_ibfk_1` FOREIGN KEY (`room_category`) REFERENCES `room_category` (`cat_id`);

--
-- Constraints for table `room_facilities`
--
ALTER TABLE `room_facilities`
  ADD CONSTRAINT `FK9b8jqgn5q1jc4ic2lg7lx5awu` FOREIGN KEY (`facility_id`) REFERENCES `facilities` (`fac_id`),
  ADD CONSTRAINT `FKpcm3y9epd2gi7y1ueiuktx1s1` FOREIGN KEY (`room_id`) REFERENCES `room_category` (`cat_id`),
  ADD CONSTRAINT `room_facilities_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `room_category` (`cat_id`),
  ADD CONSTRAINT `room_facilities_ibfk_2` FOREIGN KEY (`facility_id`) REFERENCES `facilities` (`fac_id`),
  ADD CONSTRAINT `room_facilities_ibfk_3` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`room_id`);

--
-- Constraints for table `room_gallery`
--
ALTER TABLE `room_gallery`
  ADD CONSTRAINT `FKo7au4eoty4403mr26mqhxukux` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`room_id`),
  ADD CONSTRAINT `room_gallery_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `rooms` (`room_id`);

DELIMITER $$
--
-- Events
--
CREATE DEFINER=`root`@`localhost` EVENT `message_cleaner_event` ON SCHEDULE EVERY '0 1' DAY_HOUR STARTS '2022-10-09 21:23:26' ON COMPLETION NOT PRESERVE ENABLE DO DELETE FROM `messages` where `messages`.`date` < now() - interval 30 day$$

DELIMITER ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
