delimiter $$

CREATE DATABASE `generic_store` /*!40100 DEFAULT CHARACTER SET latin1 */$$
USE generic_store $$ 

CREATE TABLE `customers` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) $$

CREATE TABLE `employees` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `firstname_username` varchar(60) DEFAULT NULL,
  `surname` varchar(60) DEFAULT NULL,
  `phone_number_password` varchar(60) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)$$

CREATE TABLE `products` (
  `product_name` varchar(60) NOT NULL,
  `sales_unit_price` bigint(11) unsigned DEFAULT NULL,
  `purchased_unit_price` bigint(11) unsigned DEFAULT NULL,
  `sales_total_price` bigint(11) unsigned DEFAULT NULL,
  `purchased_total_price` bigint(11) unsigned DEFAULT NULL,
   PRIMARY KEY(`product_name`)
) $$



CREATE TABLE `sales` (
   `id` bigint(20) unsigned not null auto_increment,
   `product_name` varchar(60),
   `quantity_sold` varchar(15),
   `unit_price` bigint(11),
   `total_price` bigint(11),
   `customer_name` varchar(60),
   `date` timestamp not null default CURRENT_TIMESTAMP,
   `credit_sales` varchar(10) not null,
   `reimbursement_status` varchar(60) not null,
   PRIMARY KEY (`id`)
) $$


CREATE TABLE `stocks` (
  `product_name` varchar(60) NOT NULL,
  `left_in_stock` bigint(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `history` longtext,
  PRIMARY KEY (`product_name`)
)$$

