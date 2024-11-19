/*
SQLyog Enterprise - MySQL GUI v8.14 
MySQL - 8.0.36 : Database - y_intern
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`y_intern` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `y_intern`;

/*Table structure for table `intern` */

DROP TABLE IF EXISTS `intern`;

CREATE TABLE `intern` (
  `sid` int NOT NULL,
  `cname` varchar(100) DEFAULT NULL,
  `cnumber` varchar(15) DEFAULT NULL,
  `caddress` text,
  `city` varchar(50) DEFAULT NULL,
  `stipend_amount` decimal(10,2) DEFAULT NULL,
  `mentor_name` varchar(100) DEFAULT NULL,
  `mentor_contact_number` varchar(15) DEFAULT NULL,
  `mentor_email` varchar(100) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `offer_letter_fname` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`sid`),
  CONSTRAINT `intern_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `student` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `intern` */

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `sid` int NOT NULL,
  `spass` varchar(50) NOT NULL,
  `sname` varchar(100) NOT NULL,
  `internstatus` int DEFAULT NULL,
  `mentor_id` int DEFAULT NULL,
  PRIMARY KEY (`sid`),
  CONSTRAINT `student_chk_1` CHECK ((`internstatus` in (-(1),0,1)))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `student` */

insert  into `student`(`sid`,`spass`,`sname`,`internstatus`,`mentor_id`) values (1,'pass123','Ankit',0,NULL),(262,'ankit123','ankit parmar',1,NULL),(383,'vivek','vivek',-1,99994),(567,'sdsd32','nirmal',0,234),(1212,'anurag','anulag',0,NULL),(1232,'22323','ayushi panwar',1,232);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
