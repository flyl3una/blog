-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.1.16-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  9.3.0.5107
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 blog 的数据库结构
DROP DATABASE IF EXISTS `blog`;
CREATE DATABASE IF NOT EXISTS `blog` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `blog`;

-- 导出  表 blog.admin 结构
DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET latin1 NOT NULL,
  `password` varchar(20) CHARACTER SET latin1 NOT NULL,
  `email` varchar(30) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  blog.admin 的数据：~1 rows (大约)
DELETE FROM `admin`;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`id`, `username`, `password`, `email`) VALUES
	(1, 'aaa', 'aaa', 'aaa@aaa.com');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

-- 导出  表 blog.article 结构
DROP TABLE IF EXISTS `article`;
CREATE TABLE IF NOT EXISTS `article` (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `title` varchar(32) CHARACTER SET utf8mb4 NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- 正在导出表  blog.article 的数据：~3 rows (大约)
DELETE FROM `article`;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` (`id`, `title`, `content`, `create_time`) VALUES
	(1, 'aaa', 'aaa', '2016-10-23 22:16:11'),
	(2, 'bbac', 'ewrwqtq', '2016-10-24 20:29:52'),
	(10, '', '<p><img src="/upload/images/1477489058903.jpg" alt=""></p>\r\n', '2016-10-26 21:38:04');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;

-- 导出  表 blog.article_of_directory 结构
DROP TABLE IF EXISTS `article_of_directory`;
CREATE TABLE IF NOT EXISTS `article_of_directory` (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `article_id` int(36) DEFAULT NULL,
  `directory_id` int(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 正在导出表  blog.article_of_directory 的数据：~0 rows (大约)
DELETE FROM `article_of_directory`;
/*!40000 ALTER TABLE `article_of_directory` DISABLE KEYS */;
/*!40000 ALTER TABLE `article_of_directory` ENABLE KEYS */;

-- 导出  表 blog.article_of_label 结构
DROP TABLE IF EXISTS `article_of_label`;
CREATE TABLE IF NOT EXISTS `article_of_label` (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `article_id` int(36) DEFAULT NULL,
  `label_id` int(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 正在导出表  blog.article_of_label 的数据：~0 rows (大约)
DELETE FROM `article_of_label`;
/*!40000 ALTER TABLE `article_of_label` DISABLE KEYS */;
/*!40000 ALTER TABLE `article_of_label` ENABLE KEYS */;

-- 导出  表 blog.catalogue 结构
DROP TABLE IF EXISTS `catalogue`;
CREATE TABLE IF NOT EXISTS `catalogue` (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- 正在导出表  blog.catalogue 的数据：~2 rows (大约)
DELETE FROM `catalogue`;
/*!40000 ALTER TABLE `catalogue` DISABLE KEYS */;
INSERT INTO `catalogue` (`id`, `name`) VALUES
	(1, 'abc'),
	(2, 'add');
/*!40000 ALTER TABLE `catalogue` ENABLE KEYS */;

-- 导出  表 blog.label 结构
DROP TABLE IF EXISTS `label`;
CREATE TABLE IF NOT EXISTS `label` (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- 正在导出表  blog.label 的数据：~2 rows (大约)
DELETE FROM `label`;
/*!40000 ALTER TABLE `label` DISABLE KEYS */;
INSERT INTO `label` (`id`, `name`) VALUES
	(1, 'css'),
	(2, 'c');
/*!40000 ALTER TABLE `label` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
