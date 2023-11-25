DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS accounts;

CREATE TABLE IF NOT EXISTS `customer` (
  `customer_id` int AUTO_INCREMENT  PRIMARY KEY,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mobile_number` varchar(20) NOT NULL,
  `created_at` date,
  `created_by` varchar(20),
  `updated_at` date DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `account` (
  `customer_id` int NOT NULL,
  `account_number` int AUTO_INCREMENT  PRIMARY KEY,
  `account_type` varchar(100) NOT NULL,
  `branch_address` varchar(200) NOT NULL,
  `created_at` date,
  `created_by` varchar(20),
  `updated_at` date DEFAULT NULL,
  `updated_by` varchar(20) DEFAULT NULL
);

INSERT INTO `customer` (`name`,`email`,`mobile_number`,`created_at`, `created_by`)
 VALUES ('Pathum','pathum@pml.com','94712345678',CURDATE(), 'user1');

INSERT INTO `account` (`customer_id`, `account_number`, `account_type`, `branch_address`, `created_at`, created_by)
 VALUES (1, 186576453, 'Savings', '123 Main Street, Galle, Sri Lanka', CURDATE(), 'user1');
