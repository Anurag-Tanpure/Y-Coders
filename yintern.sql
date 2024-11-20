/*
SQLyog Enterprise - MySQL GUI v8.14 
MySQL - 5.0.45-community-nt : Database - y_intern
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`y_intern` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `y_intern`;

/*Table structure for table `intern` */

DROP TABLE IF EXISTS `intern`;

CREATE TABLE `intern` (
  `sid` int(11) NOT NULL,
  `cname` varchar(100) default NULL,
  `cnumber` varchar(15) default NULL,
  `caddress` text,
  `city` varchar(50) default NULL,
  `stipend_amount` decimal(10,2) default NULL,
  `mentor_name` varchar(100) default NULL,
  `mentor_contact_number` varchar(15) default NULL,
  `mentor_email` varchar(100) default NULL,
  `start_date` date default NULL,
  `offer_letter_fname` varchar(100) default NULL,
  `marks` int(11) default '0',
  PRIMARY KEY  (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `intern` */

insert  into `intern`(`sid`,`cname`,`cnumber`,`caddress`,`city`,`stipend_amount`,`mentor_name`,`mentor_contact_number`,`mentor_email`,`start_date`,`offer_letter_fname`,`marks`) values (1,'ABC Corp.','1234567890','123 Street, City','New York','1500.50','John Doe','9876543210','johndoe@abc.com','2024-01-01','offer_ABC.pdf',90),(2,'XYZ Ltd','2345678901','5678 Oak St','San Francisco','1200.00','Jane Smith','1234567892','janesmith@xyzltd.com','2024-07-01','offer2.pdf',90),(3,'Tech Innovators','3456789012','9101 Pine St','Los Angeles','1800.00','Alex Johnson','3456789012','alex.johnson@techinnovators.com','2024-08-15','offer3.pdf',95),(7,'ABC Corp.','1234567890','123 Street, City','New York','1500.50','John Doe','9876543210','johndoe@abc.com','2024-01-01','offer_ABC.pdf',90);

/*Table structure for table `mentors` */

DROP TABLE IF EXISTS `mentors`;

CREATE TABLE `mentors` (
  `mentor_id` int(11) NOT NULL auto_increment,
  `mentor_name` varchar(100) NOT NULL,
  `mentor_email` varchar(100) NOT NULL,
  `mentor_password` varchar(255) NOT NULL,
  PRIMARY KEY  (`mentor_id`),
  UNIQUE KEY `mentor_email` (`mentor_email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `mentors` */

insert  into `mentors`(`mentor_id`,`mentor_name`,`mentor_email`,`mentor_password`) values (1,'Aarav Sharma','aarav.sharma@example.com','securepassword'),(2,'Aarav Sharma','aarav@example.com','password123'),(3,'anurag tanpure','anuragtanpure120@gmail.com','1212'),(4,'akash','akash@gmail.com','aka123');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `sid` int(11) NOT NULL,
  `spass` varchar(50) NOT NULL,
  `sname` varchar(100) NOT NULL,
  `internstatus` int(11) default NULL,
  `mentor_id` int(11) default NULL,
  PRIMARY KEY  (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `student` */

insert  into `student`(`sid`,`spass`,`sname`,`internstatus`,`mentor_id`) values (1,'pass123','Alice Johnson',1,3),(2,'pass456','Bob Lee',0,3),(3,'pass789','Charlie Brown',-1,103),(101,'p123','Akash',0,201),(432,'434343t','krishna',0,2323);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
