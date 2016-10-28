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
DROP TABLE IF EXISTS `admin`;
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
DROP TABLE IF EXISTS `article`;
CREATE TABLE IF NOT EXISTS `article` (
  `id` int(36) NOT NULL AUTO_INCREMENT,
  `title` varchar(32) CHARACTER SET utf8mb4 NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `simple` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- 正在导出表  blog.article 的数据：~4 rows (大约)
DELETE FROM `article`;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` (`id`, `title`, `content`, `simple`, `create_time`) VALUES
	(11, '幅度萨芬', '<pre><code>热情放大撒幅度萨芬剁手发大方第三方倒萨到处撒\r\n热闻犬吠\r\n</code></pre><ol>\r\n<li>富士达</li><li>放大撒王菲<br> 热武器</li></ol>\r\n<ul>\r\n<li>奋斗的撒</li><li>放大撒</li><li>发的阿德</li></ul>\r\n<p>亲热</p>\r\n', '', '2016-10-28 21:07:25'),
	(13, '热发电', '<pre><code>fda发热情方法\r\n</code></pre><ul>\r\n<li>放大撒</li><li>惹我欺负</li></ul>\r\n<ol>\r\n<li>热啊发的</li><li>反对法</li></ol>\r\n', 'fda发热情方法', '2016-10-28 21:27:43'),
	(15, '热放大撒', '<pre><code>发达的\r\n放大few去\r\n</code></pre><ul>\r\n<li>热武器软武器</li><li>热风234</li></ul>\r\n<ol>\r\n<li>人放大撒</li><li>惹我发</li></ol>\r\n', '发达的\r\n放大few去\r\n\r\n\r\n\r\n\r\n', '2016-10-28 21:51:59'),
	(16, '放大撒', '<pre><code>日期fda热情无法\r\n</code></pre><ul>\r\n<li>让我飞</li><li>热v自行车432</li></ul>\r\n<ol>\r\n<li>热度惹我欺负的</li><li>热物权法擦拭</li><li>vzfd惹我欺负</li></ol>\r\n', '\r\n\r\n\r\n\r\n\r\n', '2016-10-28 21:54:17'),
	(17, '放大撒', '<pre><code>浮动球阀\r\n- 热武器\r\n</code></pre><ul>\r\n<li>热风</li></ul>\r\n<ol>\r\n<li>乳房肥大</li><li>人情味</li></ol>\r\n', '\r\n- 热武器\r\n\r\n\r\n\r\n\r\n', '2016-10-28 21:57:42'),
	(18, '放大撒', '<pre><code>日发生大为人\r\n</code></pre><ul>\r\n<li>放大撒</li><li>热武器飞洒</li></ul>\r\n<ol>\r\n<li>4分啊</li><li>热啊发的</li></ol>\r\n', '日发生大为人\r\n\r\n\r\n\r\n\r\n', '2016-10-28 21:59:07'),
	(19, '放大撒', '<pre><code>热丰富的\r\n</code></pre><ul>\r\n<li>热风热情434</li><li>发v出现</li></ul>\r\n<ol>\r\n<li>2奋斗的撒</li><li>热</li></ol>\r\n', '热丰富的', '2016-10-28 21:59:54');
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
