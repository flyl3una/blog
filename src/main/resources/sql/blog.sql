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
CREATE DATABASE IF NOT EXISTS `blog` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `blog`;

-- 导出  表 blog.admin 结构
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET latin1 NOT NULL,
  `password` varchar(20) CHARACTER SET latin1 NOT NULL,
  `email` varchar(30) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- 正在导出表  blog.admin 的数据：~2 rows (大约)
DELETE FROM `admin`;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`id`, `username`, `password`, `email`) VALUES
	(1, 'aaa', 'aaa', 'aaa@aaa.com');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

-- 导出  表 blog.article 结构
CREATE TABLE IF NOT EXISTS `article` (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `title` varchar(32) CHARACTER SET utf8mb4 NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `simple` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `original` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- 正在导出表  blog.article 的数据：~0 rows (大约)
DELETE FROM `article`;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` (`id`, `title`, `content`, `simple`, `original`, `createTime`) VALUES
	(35, 'fdsa', '<p>fdas</p>\r\n<h6 id="h6-hgf"><a name="hgf" class="reference-link"></a><span class="header-link octicon octicon-link"></span>hgf</h6><h4 id="h4-rweq"><a name="rweq" class="reference-link"></a><span class="header-link octicon octicon-link"></span>rweq</h4>', '<p>fdas</p>\r\n<h6 id=', 'fdas\r\n###### hgf\r\n#### rweq', '2016-11-07 21:12:39'),
	(36, 'rewq', '<p>dfafrewqe</p>\r\n', '<p>dfafrewqe</p>', 'dfafrewqe', '2016-11-07 21:12:17'),
	(37, 'fdas', '<p>rewq</p>\r\n<h2 id="h2-u7A7A"><a name="空" class="reference-link"></a><span class="header-link octicon octicon-link"></span>空</h2>', '<p>rewq</p>\r\n<h2 id=', 'rewq\r\n## 空', '2016-11-07 21:17:16');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;

-- 导出  表 blog.article_of_catalogue 结构
CREATE TABLE IF NOT EXISTS `article_of_catalogue` (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `article_id` int(36) DEFAULT NULL,
  `catalogue_id` int(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

-- 正在导出表  blog.article_of_catalogue 的数据：~0 rows (大约)
DELETE FROM `article_of_catalogue`;
/*!40000 ALTER TABLE `article_of_catalogue` DISABLE KEYS */;
INSERT INTO `article_of_catalogue` (`id`, `article_id`, `catalogue_id`) VALUES
	(18, 35, 11),
	(19, 36, 12),
	(20, 37, 14);
/*!40000 ALTER TABLE `article_of_catalogue` ENABLE KEYS */;

-- 导出  表 blog.article_of_label 结构
CREATE TABLE IF NOT EXISTS `article_of_label` (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `article_id` int(36) DEFAULT NULL,
  `label_id` int(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

-- 正在导出表  blog.article_of_label 的数据：~0 rows (大约)
DELETE FROM `article_of_label`;
/*!40000 ALTER TABLE `article_of_label` DISABLE KEYS */;
INSERT INTO `article_of_label` (`id`, `article_id`, `label_id`) VALUES
	(25, 36, 8),
	(26, 35, 9),
	(27, 35, 10);
/*!40000 ALTER TABLE `article_of_label` ENABLE KEYS */;

-- 导出  表 blog.catalogue 结构
CREATE TABLE IF NOT EXISTS `catalogue` (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- 正在导出表  blog.catalogue 的数据：~2 rows (大约)
DELETE FROM `catalogue`;
/*!40000 ALTER TABLE `catalogue` DISABLE KEYS */;
INSERT INTO `catalogue` (`id`, `name`) VALUES
	(10, 'project'),
	(11, 'home'),
	(12, '心情'),
	(13, 'sec'),
	(14, '');
/*!40000 ALTER TABLE `catalogue` ENABLE KEYS */;

-- 导出  表 blog.label 结构
CREATE TABLE IF NOT EXISTS `label` (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- 正在导出表  blog.label 的数据：~0 rows (大约)
DELETE FROM `label`;
/*!40000 ALTER TABLE `label` DISABLE KEYS */;
INSERT INTO `label` (`id`, `name`) VALUES
	(8, 'java'),
	(9, 'c'),
	(10, 'c++'),
	(12, 'c#'),
	(13, 'php'),
	(14, 'python'),
	(15, 'ruby'),
	(16, 'javascript');
/*!40000 ALTER TABLE `label` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
