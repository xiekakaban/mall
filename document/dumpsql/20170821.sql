-- MySQL dump 10.13  Distrib 5.7.17, for Win32 (AMD64)
--
-- Host: localhost    Database: mall_dev
-- ------------------------------------------------------
-- Server version	5.7.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_administrator`
--

DROP TABLE IF EXISTS `tb_administrator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_administrator` (
  `id` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `avator` varchar(50) COLLATE utf8_unicode_ci DEFAULT 'default.jpg',
  `pwd` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `extern_info` text COLLATE utf8_unicode_ci,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_administrator`
--

LOCK TABLES `tb_administrator` WRITE;
/*!40000 ALTER TABLE `tb_administrator` DISABLE KEYS */;
INSERT INTO `tb_administrator` VALUES ('9527','supermall','default.jpg','XZxoxsUO09AqL89U9jmTtg==','ruantianbo@163.com','12345678910',NULL,'2017-08-12 17:17:50');
/*!40000 ALTER TABLE `tb_administrator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_category`
--

DROP TABLE IF EXISTS `tb_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_category` (
  `id` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `title` varchar(100) CHARACTER SET ucs2 NOT NULL,
  `banner` varchar(100) COLLATE utf8_unicode_ci DEFAULT 'defaultCategoryBanner.jpg',
  `create_by` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `last_modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_category`
--

LOCK TABLES `tb_category` WRITE;
/*!40000 ALTER TABLE `tb_category` DISABLE KEYS */;
INSERT INTO `tb_category` VALUES ('31454ad6-7c32-4f75-82dd-4b9a0481b6a5','3K党','defaultCategoryBanner.jpg','9527','2017-08-18 15:59:27'),('e0b5cb9e-cdf4-480a-b915-628bf80ac8c3','3K党','defaultCategoryBanner.jpg','9527','2017-08-17 13:37:01');
/*!40000 ALTER TABLE `tb_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_product_prop`
--

DROP TABLE IF EXISTS `tb_product_prop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_product_prop` (
  `id` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `prop_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `is_limit` varchar(1) COLLATE utf8_unicode_ci DEFAULT 'N',
  `create_by` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `last_modify_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `category_id` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `limit_props` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_product_prop`
--

LOCK TABLES `tb_product_prop` WRITE;
/*!40000 ALTER TABLE `tb_product_prop` DISABLE KEYS */;
INSERT INTO `tb_product_prop` VALUES ('0005c92f-6034-4040-a92f-923e3e2e0f08','WhosYourDaddy','Y','9527','2017-08-18 15:59:27','31454ad6-7c32-4f75-82dd-4b9a0481b6a5','Father#WOW'),('4871958f-aae0-4385-83e5-9230947b785c','WhosYourDaddy','Y','9527','2017-08-17 13:37:01','e0b5cb9e-cdf4-480a-b915-628bf80ac8c3','Father#WOW'),('6cdf005f-e58d-48d1-b7cd-a3ec5bdc2974','GreedIsGood','N','9527','2017-08-17 13:37:01','e0b5cb9e-cdf4-480a-b915-628bf80ac8c3',''),('eddfd81d-c755-4236-abe7-6e0f678007e6','GreedIsGood','N','9527','2017-08-18 15:59:27','31454ad6-7c32-4f75-82dd-4b9a0481b6a5','');
/*!40000 ALTER TABLE `tb_product_prop` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-21 13:54:00
