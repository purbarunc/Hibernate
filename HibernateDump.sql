-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: hibernate
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `addresskey`
--

DROP TABLE IF EXISTS `addresskey`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `addresskey` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresskey`
--

LOCK TABLES `addresskey` WRITE;
/*!40000 ALTER TABLE `addresskey` DISABLE KEYS */;
INSERT INTO `addresskey` VALUES (3);
/*!40000 ALTER TABLE `addresskey` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookdb`
--

DROP TABLE IF EXISTS `bookdb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bookdb` (
  `bookid` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`bookid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookdb`
--

LOCK TABLES `bookdb` WRITE;
/*!40000 ALTER TABLE `bookdb` DISABLE KEYS */;
INSERT INTO `bookdb` VALUES (1,'Hibernate in Action',400);
/*!40000 ALTER TABLE `bookdb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `citydb`
--

DROP TABLE IF EXISTS `citydb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `citydb` (
  `cityid` int(11) NOT NULL,
  `state` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cityid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citydb`
--

LOCK TABLES `citydb` WRITE;
/*!40000 ALTER TABLE `citydb` DISABLE KEYS */;
INSERT INTO `citydb` VALUES (1,'WB','Kolkata'),(2,'TN','Chennai');
/*!40000 ALTER TABLE `citydb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coursedb`
--

DROP TABLE IF EXISTS `coursedb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `coursedb` (
  `courseid` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`courseid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coursedb`
--

LOCK TABLES `coursedb` WRITE;
/*!40000 ALTER TABLE `coursedb` DISABLE KEYS */;
INSERT INTO `coursedb` VALUES (1,'Python'),(2,'Spring Core'),(3,'Java');
/*!40000 ALTER TABLE `coursedb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employee` (
  `empid` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `passportid` int(11) DEFAULT NULL,
  PRIMARY KEY (`empid`),
  KEY `FK57vmrpc80ojd5c1nbihlgi3ui` (`passportid`),
  CONSTRAINT `FK57vmrpc80ojd5c1nbihlgi3ui` FOREIGN KEY (`passportid`) REFERENCES `passport` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Vikas',1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employeedb`
--

DROP TABLE IF EXISTS `employeedb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employeedb` (
  `eid` int(11) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `pincode` int(11) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `office_city` varchar(255) DEFAULT NULL,
  `office_pincode` int(11) DEFAULT NULL,
  `office_State` varchar(255) DEFAULT NULL,
  `office_street` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employeedb`
--

LOCK TABLES `employeedb` WRITE;
/*!40000 ALTER TABLE `employeedb` DISABLE KEYS */;
INSERT INTO `employeedb` VALUES (1,'Kolkata',79699,'WB','48 Belvedre Road','Bengaluru',56745,'Karnataka','28 100 Feet Rd.','Ramesh');
/*!40000 ALTER TABLE `employeedb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employeetbl`
--

DROP TABLE IF EXISTS `employeetbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employeetbl` (
  `eid` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employeetbl`
--

LOCK TABLES `employeetbl` WRITE;
/*!40000 ALTER TABLE `employeetbl` DISABLE KEYS */;
INSERT INTO `employeetbl` VALUES (1,'Rakesh');
/*!40000 ALTER TABLE `employeetbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passport`
--

DROP TABLE IF EXISTS `passport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `passport` (
  `pid` int(11) NOT NULL,
  `place_of_issue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passport`
--

LOCK TABLES `passport` WRITE;
/*!40000 ALTER TABLE `passport` DISABLE KEYS */;
INSERT INTO `passport` VALUES (1,'Mumbai');
/*!40000 ALTER TABLE `passport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playerdb`
--

DROP TABLE IF EXISTS `playerdb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `playerdb` (
  `playerid` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `Nation` varchar(255) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  PRIMARY KEY (`playerid`),
  KEY `FKmv58og8qv7vo8c8wt4l69np33` (`id`),
  CONSTRAINT `FKmv58og8qv7vo8c8wt4l69np33` FOREIGN KEY (`id`) REFERENCES `teamdb` (`teamid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playerdb`
--

LOCK TABLES `playerdb` WRITE;
/*!40000 ALTER TABLE `playerdb` DISABLE KEYS */;
INSERT INTO `playerdb` VALUES (1,'Messi','Argentina',1),(2,'Suarez','Uruguay',1);
/*!40000 ALTER TABLE `playerdb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_course`
--

DROP TABLE IF EXISTS `student_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `student_course` (
  `studentId` int(11) NOT NULL,
  `courseId` int(11) NOT NULL,
  PRIMARY KEY (`studentId`,`courseId`),
  KEY `FK1g385an2nmt0q2p3pn9gog7xi` (`courseId`),
  CONSTRAINT `FK1g385an2nmt0q2p3pn9gog7xi` FOREIGN KEY (`courseId`) REFERENCES `coursedb` (`courseid`),
  CONSTRAINT `FKvu6446iajsa1gr912qbbhloi` FOREIGN KEY (`studentId`) REFERENCES `studentdb` (`studentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_course`
--

LOCK TABLES `student_course` WRITE;
/*!40000 ALTER TABLE `student_course` DISABLE KEYS */;
INSERT INTO `student_course` VALUES (1,1),(2,1),(3,1),(1,2),(3,2),(2,3),(3,3);
/*!40000 ALTER TABLE `student_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentdb`
--

DROP TABLE IF EXISTS `studentdb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `studentdb` (
  `studentid` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`studentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentdb`
--

LOCK TABLES `studentdb` WRITE;
/*!40000 ALTER TABLE `studentdb` DISABLE KEYS */;
INSERT INTO `studentdb` VALUES (1,'Arun'),(2,'Vikas'),(3,'Rahul');
/*!40000 ALTER TABLE `studentdb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `students` (
  `uid` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teamdb`
--

DROP TABLE IF EXISTS `teamdb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `teamdb` (
  `teamid` int(11) NOT NULL,
  `country` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`teamid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teamdb`
--

LOCK TABLES `teamdb` WRITE;
/*!40000 ALTER TABLE `teamdb` DISABLE KEYS */;
INSERT INTO `teamdb` VALUES (1,'Spain','FC Barcelona');
/*!40000 ALTER TABLE `teamdb` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_address`
--

DROP TABLE IF EXISTS `user_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_address` (
  `UserId` int(11) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `pincode` int(11) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `addressid` bigint(20) NOT NULL,
  PRIMARY KEY (`addressid`),
  KEY `FK8in4cmrubj328k5wltm27xaoq` (`UserId`),
  CONSTRAINT `FK8in4cmrubj328k5wltm27xaoq` FOREIGN KEY (`UserId`) REFERENCES `employeetbl` (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_address`
--

LOCK TABLES `user_address` WRITE;
/*!40000 ALTER TABLE `user_address` DISABLE KEYS */;
INSERT INTO `user_address` VALUES (1,'Kolkata',75645,'Bengal','76 Park Street',1),(1,'Bangalore',53434,'Karnataka','100 ft Rd',2);
/*!40000 ALTER TABLE `user_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertbl`
--

DROP TABLE IF EXISTS `usertbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usertbl` (
  `uid` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertbl`
--

LOCK TABLES `usertbl` WRITE;
/*!40000 ALTER TABLE `usertbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `usertbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vehicle` (
  `Vehicle_Type` varchar(31) NOT NULL,
  `vehicleid` int(11) NOT NULL,
  `vehiclename` varchar(255) DEFAULT NULL,
  `Steering_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`vehicleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES ('Vehicle',1,'myvehicle',NULL),('Bike',2,'Bike','Bike Steering Handle'),('Car',3,'Alto','Alto Steering Wheel');
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'hibernate'
--
/*!50003 DROP PROCEDURE IF EXISTS `getAllCities` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getAllCities`()
BEGIN
select *
from citydb;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-04 20:20:15
