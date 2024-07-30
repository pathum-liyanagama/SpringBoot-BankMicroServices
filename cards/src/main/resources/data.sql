DROP TABLE IF EXISTS card;

--CREATE TABLE IF NOT EXISTS `customer` {
--    `customer_id` int AUTO_INCREMENT PRIMARY KEY,
--    `name` VARCHAR(100) NOT NULL,
--    `email` VARCHAR(100) NOT NULL,
--    `mobile_number` varchar(20) NOT NULL,
--    `created_by` varchar(20),
--    `create_at` date DEFAULT NULL,
--    `updated_by` varchar(20),
--    `updated_at` date DEFAULT NULL,
--}

CREATE TABLE IF NOT EXISTS `card` (
  `card_id` int NOT NULL AUTO_INCREMENT,
  `card_number` varchar(100) NOT NULL,
  `customer_id` int NOT NULL,
  `card_type` varchar(100) NOT NULL,
  `total_limit` int NOT NULL,
  `amount_used` int NOT NULL,
  `available_amount` int NOT NULL,
  `created_by` varchar(100),
  `created_at` timestamp DEFAULT NULL,
  `updated_by` varchar(100),
  `updated_at` timestamp DEFAULT NULL,
  PRIMARY KEY (`card_id`)
);


INSERT INTO `card` (`card_number`, `customer_id`, `card_type`, `total_limit`, `amount_used`, `available_amount`, `created_by`, `created_at`)
 VALUES ('4565XXXX4656', 1, 'Credit', 10000, 500, 9500, 'ADMIN', CURRENT_TIMESTAMP);

INSERT INTO `card` (`card_number`, `customer_id`, `card_type`, `total_limit`, `amount_used`, `available_amount`, `created_by`, `created_at`)
 VALUES ('3455XXXX8673', 1, 'Credit', 7500, 600, 6900, 'ADMIN', CURRENT_TIMESTAMP);

INSERT INTO `card` (`card_number`, `customer_id`, `card_type`, `total_limit`, `amount_used`, `available_amount`, `created_by`, `created_at`)
 VALUES ('2359XXXX9346', 1, 'Credit', 20000, 4000, 16000, 'ADMIN', CURRENT_TIMESTAMP);
