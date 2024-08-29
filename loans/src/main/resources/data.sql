DROP TABLE IF EXISTS loans;

CREATE TABLE IF NOT EXISTS `loan` (
   `loan_id` int NOT NULL AUTO_INCREMENT,
   `loan_number` varchar(100) NOT NULL,
   `loan_type` varchar(100) NOT NULL,
   `total_amount` int NOT NULL,
   `amount_paid` int NOT NULL,
   `outstanding_amount` int NOT NULL,
   `created_at` date DEFAULT NULL,
   `created_by` varchar(20) DEFAULT NULL,
   `updated_at` date DEFAULT NULL,
   `updated_by` varchar(20) DEFAULT NULL,
   PRIMARY KEY (`loan_id`)
 );


