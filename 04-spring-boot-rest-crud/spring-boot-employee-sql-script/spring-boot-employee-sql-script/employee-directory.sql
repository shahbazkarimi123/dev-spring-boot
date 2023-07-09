CREATE DATABASE  IF NOT EXISTS `student_directory`;
USE `student_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `fee_payment` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `student` VALUES 
	(1,'Leslie','Andrews','leslie@luv2code.com','paid'),
	(2,'Emma','Baumgarten','emma@luv2code.com','not paid'),
	(3,'Avani','Gupta','avani@luv2code.com','paid'),
	(4,'Yuri','Petrov','yuri@luv2code.com','paid'),
	(5,'Juan','Vega','juan@luv2code.com','paid');

