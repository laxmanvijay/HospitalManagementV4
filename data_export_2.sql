-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: hospital_db
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `jpaexample_table`
--

DROP TABLE IF EXISTS `jpaexample_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jpaexample_table` (
  `value` int(11) NOT NULL,
  PRIMARY KEY (`value`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jpaexample_table`
--

LOCK TABLES `jpaexample_table` WRITE;
/*!40000 ALTER TABLE `jpaexample_table` DISABLE KEYS */;
INSERT INTO `jpaexample_table` VALUES (1);
/*!40000 ALTER TABLE `jpaexample_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_branch`
--

DROP TABLE IF EXISTS `t_branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_branch` (
  `pk_branch_id` int(11) NOT NULL AUTO_INCREMENT,
  `location` varchar(20) NOT NULL,
  `fk_hospital_id` int(11) NOT NULL,
  `is_active` tinyint(4) NOT NULL DEFAULT '1',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pk_branch_id`),
  UNIQUE KEY `branchid_UNIQUE` (`pk_branch_id`),
  KEY `hospitalid_idx` (`fk_hospital_id`),
  CONSTRAINT `hospitalid` FOREIGN KEY (`fk_hospital_id`) REFERENCES `t_hospital` (`hospital_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_branch`
--

LOCK TABLES `t_branch` WRITE;
/*!40000 ALTER TABLE `t_branch` DISABLE KEYS */;
INSERT INTO `t_branch` VALUES (1,'t nagar',2,0,'2020-01-11 04:22:24','2020-01-11 04:22:24'),(2,'t nagar',2,0,'2020-01-11 04:22:24','2020-01-11 04:22:24'),(3,'t nagar',2,1,'2020-01-11 04:22:24','2020-01-11 04:22:24'),(4,'nungambakkam',2,0,'2020-01-11 04:22:24','2020-01-11 04:22:24'),(5,'t nagar',2,0,'2020-01-11 04:30:38','2020-01-11 04:30:38'),(6,'t nagar',2,0,'2020-01-11 04:30:38','2020-01-11 04:30:38'),(7,'t nagar',2,0,'2020-01-11 04:30:38','2020-01-11 04:30:38'),(8,'nungambakkam',2,0,'2020-01-11 04:30:39','2020-01-11 04:30:39');
/*!40000 ALTER TABLE `t_branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_branch_has_admin`
--

DROP TABLE IF EXISTS `t_branch_has_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_branch_has_admin` (
  `pk_key` int(11) NOT NULL AUTO_INCREMENT,
  `fk_branch_id` int(11) NOT NULL,
  `fk_admin_id` int(11) NOT NULL,
  `is_active` tinyint(4) NOT NULL DEFAULT '1',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pk_key`),
  UNIQUE KEY `pk_key_UNIQUE` (`pk_key`),
  KEY `pk_branch_id_idx` (`fk_branch_id`),
  KEY `pk_user_id_idx` (`fk_admin_id`),
  CONSTRAINT `admin_branch_id` FOREIGN KEY (`fk_branch_id`) REFERENCES `t_branch` (`pk_branch_id`),
  CONSTRAINT `admin_id` FOREIGN KEY (`fk_admin_id`) REFERENCES `t_user` (`pk_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_branch_has_admin`
--

LOCK TABLES `t_branch_has_admin` WRITE;
/*!40000 ALTER TABLE `t_branch_has_admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_branch_has_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_branch_has_patient_doctor`
--

DROP TABLE IF EXISTS `t_branch_has_patient_doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_branch_has_patient_doctor` (
  `pk_key` int(11) NOT NULL AUTO_INCREMENT,
  `fk_branch_id` int(11) NOT NULL,
  `fk_user_id` int(11) NOT NULL,
  `is_active` tinyint(4) NOT NULL DEFAULT '1',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pk_key`),
  UNIQUE KEY `pk_key_UNIQUE` (`pk_key`),
  KEY `pk_branch_id_idx` (`fk_branch_id`),
  KEY `pk_user_id_idx` (`fk_user_id`),
  CONSTRAINT `user_branch_id` FOREIGN KEY (`fk_branch_id`) REFERENCES `t_branch` (`pk_branch_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`fk_user_id`) REFERENCES `t_user` (`pk_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_branch_has_patient_doctor`
--

LOCK TABLES `t_branch_has_patient_doctor` WRITE;
/*!40000 ALTER TABLE `t_branch_has_patient_doctor` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_branch_has_patient_doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_doctor`
--

DROP TABLE IF EXISTS `t_doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_doctor` (
  `pk_doctor_id` int(11) NOT NULL AUTO_INCREMENT,
  `specialist` varchar(30) NOT NULL,
  `fk_user_id` int(11) NOT NULL,
  PRIMARY KEY (`pk_doctor_id`),
  UNIQUE KEY `pk_doctor_id_UNIQUE` (`pk_doctor_id`),
  KEY `pk_user_id_idx` (`fk_user_id`),
  CONSTRAINT `doctor_user_id` FOREIGN KEY (`fk_user_id`) REFERENCES `t_user` (`pk_user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_doctor`
--

LOCK TABLES `t_doctor` WRITE;
/*!40000 ALTER TABLE `t_doctor` DISABLE KEYS */;
INSERT INTO `t_doctor` VALUES (19,'md',11),(20,'md',108),(21,'not specified',116),(22,'not specified',117),(23,'not specified',118),(24,'not specified',119),(25,'not specified',120),(26,'not specified',121),(27,'not specified',122),(28,'not specified',123),(29,'not specified',124),(30,'not specified',125),(31,'not specified',126);
/*!40000 ALTER TABLE `t_doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_hospital`
--

DROP TABLE IF EXISTS `t_hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_hospital` (
  `hospital_id` int(11) NOT NULL AUTO_INCREMENT,
  `hospital_name` varchar(16) NOT NULL,
  `is_active` tinyint(4) NOT NULL DEFAULT '1',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`hospital_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_hospital`
--

LOCK TABLES `t_hospital` WRITE;
/*!40000 ALTER TABLE `t_hospital` DISABLE KEYS */;
INSERT INTO `t_hospital` VALUES (1,'siims',1,'2020-01-10 18:48:51','2020-01-10 18:48:51'),(2,'siims',1,'2020-01-10 18:48:51','2020-01-10 18:48:51');
/*!40000 ALTER TABLE `t_hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_patient`
--

DROP TABLE IF EXISTS `t_patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_patient` (
  `pk_patient_id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_user_id` int(11) NOT NULL,
  `weight` int(11) NOT NULL,
  PRIMARY KEY (`pk_patient_id`),
  UNIQUE KEY `pk_patient_id_UNIQUE` (`pk_patient_id`),
  KEY `pk_user_id_idx` (`fk_user_id`),
  CONSTRAINT `patient_user_id` FOREIGN KEY (`fk_user_id`) REFERENCES `t_user` (`pk_user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_patient`
--

LOCK TABLES `t_patient` WRITE;
/*!40000 ALTER TABLE `t_patient` DISABLE KEYS */;
INSERT INTO `t_patient` VALUES (57,10,50);
/*!40000 ALTER TABLE `t_patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_patient_has_doctor`
--

DROP TABLE IF EXISTS `t_patient_has_doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_patient_has_doctor` (
  `pk_key` int(11) NOT NULL AUTO_INCREMENT,
  `fk_patient_id` int(11) NOT NULL,
  `fk_doctor_id` int(11) NOT NULL,
  `is_active` tinyint(4) NOT NULL DEFAULT '1',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pk_key`),
  UNIQUE KEY `pk_key_UNIQUE` (`pk_key`),
  KEY `fk_doctor_id_idx` (`fk_doctor_id`),
  KEY `fk_patient_id_idx` (`fk_patient_id`,`fk_doctor_id`),
  CONSTRAINT `fk_doctor_id` FOREIGN KEY (`fk_doctor_id`) REFERENCES `t_user` (`pk_user_id`) ON DELETE CASCADE,
  CONSTRAINT `fk_patient_id` FOREIGN KEY (`fk_patient_id`) REFERENCES `t_user` (`pk_user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_patient_has_doctor`
--

LOCK TABLES `t_patient_has_doctor` WRITE;
/*!40000 ALTER TABLE `t_patient_has_doctor` DISABLE KEYS */;
INSERT INTO `t_patient_has_doctor` VALUES (2,10,11,1,'2020-01-13 05:26:01','2020-01-13 06:45:05'),(3,10,108,1,'2020-01-20 08:38:18','2020-01-20 08:38:18');
/*!40000 ALTER TABLE `t_patient_has_doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_role` (
  `pk_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `is_active` tinyint(4) NOT NULL DEFAULT '1',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`pk_role_id`),
  UNIQUE KEY `roleid_UNIQUE` (`pk_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role`
--

LOCK TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` VALUES (1,'GLOBAL_ADMIN',1,'2020-01-07 04:23:44','2020-01-07 04:23:44'),(2,'BRANCH_ADMIN',1,'2020-01-07 04:23:44','2020-01-07 04:23:44'),(3,'DOCTOR',1,'2020-01-07 04:23:44','2020-01-07 04:23:44'),(4,'PATIENT',1,'2020-01-07 04:23:44','2020-01-07 04:23:44');
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user` (
  `pk_user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(32) NOT NULL,
  `fk_role_id` int(11) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `is_active` tinyint(4) NOT NULL DEFAULT '1',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`pk_user_id`),
  UNIQUE KEY `userid_UNIQUE` (`pk_user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `roleid_idx` (`fk_role_id`),
  CONSTRAINT `roleid` FOREIGN KEY (`fk_role_id`) REFERENCES `t_role` (`pk_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (9,'vijay','laxmanvijay24@gmail.com','8903040410',1,'8903040410',1,'2020-01-07 04:54:16','2020-01-08 08:53:40',50),(10,'patient1','patient1@gmail.com','patient1',4,'123',0,'2020-01-07 04:54:16','2020-01-27 05:36:50',28),(11,'doctor1','doctor1@gmail.com','doctor1',3,'1231',0,'2020-01-07 04:54:16','2020-01-25 15:26:20',35),(108,'doc4','doc4@gmail.com','doc4',3,'83927492374932',1,'2020-01-17 12:34:04','2020-01-29 05:50:12',104),(116,'abc','abc@gmail.com','abc',3,'123',0,'2020-01-25 15:17:45','2020-01-27 05:06:22',20),(117,'def','def@gmail.com','def',3,'123',0,'2020-01-27 05:27:59','2020-01-27 05:28:21',20),(118,'hij','hij','hij',3,'123',0,'2020-01-27 05:47:49','2020-01-27 05:47:58',12),(119,'xyz','xyz','xyz',3,'123',0,'2020-01-27 05:56:16','2020-01-27 05:56:23',20),(120,'qwe','qwe','qwe',3,'123',0,'2020-01-27 05:56:57','2020-01-27 05:57:04',20),(121,'sd','sd','sd',3,'123',0,'2020-01-27 05:59:45','2020-01-27 06:03:30',20),(122,'sdsd','sds','sdfs',3,'123',0,'2020-01-27 06:03:54','2020-01-27 06:04:26',20),(123,'sdsdsdf','sdssdsd','sdsds',3,'123',0,'2020-01-27 06:04:02','2020-01-27 06:04:11',20),(124,'siufdhdiu','dskhf','123',3,'123',1,'2020-01-27 06:04:44','2020-01-27 09:27:32',245),(125,'siufdhdiu','dskhfsds','sfduhdif',3,'123',1,'2020-01-27 06:04:53','2020-01-27 06:04:53',2),(126,'slidjfsldjflsj','skdjkhd','123',3,'123',1,'2020-01-27 09:38:19','2020-01-27 09:38:19',44444);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'hospital_db'
--

--
-- Dumping routines for database 'hospital_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-03 14:06:34
