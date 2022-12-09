-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: blog
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `collection`
--

DROP TABLE IF EXISTS `collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `collection` (
  `id` smallint NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `collection_name_index` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collection`
--

INSERT INTO `collection` (`id`, `name`, `created`) VALUES (1,'秋招','2022-11-29 09:48:17'),(2,'生活','2022-11-29 09:48:27'),(3,'考研','2022-11-29 09:48:51'),(4,'其他','2022-11-29 09:49:40');

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `post_id` int NOT NULL,
  `content` varchar(255) NOT NULL,
  `disabled` tinyint(1) NOT NULL DEFAULT '0',
  `name` varchar(15) NOT NULL,
  `email` varchar(31) NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `created_uk` (`created` DESC)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`id`, `post_id`, `content`, `disabled`, `name`, `email`, `created`) VALUES (1,1,'测试评论',0,'bty','baotingyu199@gmail.com','2022-11-28 04:17:23'),(2,1,'评论',0,'bty','test@qq.com','2022-11-28 10:25:10'),(3,1,'评df论',0,'bty','test@qq.com','2022-11-28 10:34:17'),(4,1,'你说得对',0,'bty','test@qq.com','2022-11-28 11:02:31'),(5,3,'fd',0,'bty','test@qq.com','2022-11-29 13:25:59');

--
-- Table structure for table `old_record`
--

DROP TABLE IF EXISTS `old_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `old_record` (
  `cid` varchar(255) NOT NULL,
  `title` varchar(63) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `type` tinyint NOT NULL DEFAULT '0' COMMENT '0图片,1视频,2音频,3PDF,4WORD,5EXCEL,6PPT,7其他',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `cover_cid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  UNIQUE KEY `record_creacted_uindex` (`created` DESC),
  UNIQUE KEY `record_title_index` (`title`),
  KEY `record_type_index` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `old_record`
--

INSERT INTO `old_record` (`cid`, `title`, `description`, `type`, `created`, `cover_cid`) VALUES ('Qmads8b2XYqgfXzXR6PwKChyaeWDaM1CBCHTZDamdKm3kk','个人一寸证件照','我',0,'2022-11-29 09:45:41',NULL),('Qmb5hbWvQHG4tFRfGMqUFSofAF1rJbShoWgWiHqRRgxe1T','简历','我的简历',3,'2022-11-29 09:46:02',NULL),('QmcahU89sJ5VNGx6LJ3fcynZxyZgUz34CPU8AcwRRVp4yu','高途意向','高途意向pdf',3,'2022-11-29 09:45:11',NULL),('QmNhxKenYFxowjL9CX5DeHNYmR63cyLrQjDQiz5fbhdQKR','save','请愿',0,'2022-11-29 09:44:27',NULL),('QmTN6xYmWzUHJ23SDfj755sM7DsKRYijS8Zmy7FZxRZhhb','61','kid',1,'2022-11-29 09:43:50',NULL),('QmYdoUq4xXiDQtM7XkevbYqbwJXP883Jvu3hbqmmCTyY3o','考研成绩单','考研成绩，初试排名11/120',0,'2022-11-29 09:43:08',NULL);

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(64) NOT NULL,
  `excerpt` varchar(255) DEFAULT NULL,
  `content` text NOT NULL,
  `disabled` tinyint(1) NOT NULL DEFAULT '0',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `cover_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `create-uk` (`created` DESC),
  UNIQUE KEY `post_title_uindex` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='博文';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

INSERT INTO `post` (`id`, `title`, `excerpt`, `content`, `disabled`, `created`, `updated`, `cover_url`) VALUES (1,'MySQL表字段数量限制以及行大小限制','Row Limits 一般为 MySQL本身65535B限制和存储引擎8126B限制（默认Innodb）。\n针对不定长类型，如varchar，一般首先收到限制的是MySQL本身65535B的限制。受不到存储引擎限制是因为，不定长类型如果长度超过8126B，会采用页外存储，也就是不定长类型的长度过长的话计入65535B而不计入8126B（大致可以这么理解）。另外，如果内容实在过长，则使用BLOB和TEXT，这样65535B只会只会消耗掉9到12个B。\n针对定长类型，首先会受到存储引擎8126B限制。','参考官网链接：[Limits on Table Column Count and Row Size](https://dev.mysql.com/doc/mysql-reslimits-excerpt/5.6/en/column-count-limit.html)\n\n# 字段数量限制 Column Count Limits\nMySQL对于每个表的字段数量是严格控制在4096个，但是实际情况下的限制大小取决于以下因素（也就是基本达不到4096就被限制了）：\n- 表的行最大的`row size`会限制字段数量，如果当前`row size`过大就不能加字段了\n- The storage requirements of individual columns constrain the number of columns that fit within a given maximum row size.\n- 存储引擎本身也会对字段数量有限制，比如`Innodb`最大字段数量为1017\n- 每张表都有一个后缀为`.frm`的表定义文件，表定义可能会影响字段数量大小\n\n# 行大小限制 Row Size Limits\n`row size`由以下因素影响：\n- MySQL本身对`row size`有硬性规定，不能超过`65535bytes`，即使存储引擎允许更大的size. 而`BLOB`和`TEXT`类型列只占行的9到12个字节，具体存储地方不在该行里；但是其他的比如`varchar`还是算在行里的，这里要注意\n- `Innodb`存储引擎对于每行的大小一般限制为页大小的一半：页16KB,row size 8KB。另外对于不定长类型也有不同：If a row containing variable-length columns exceeds the InnoDB maximum row size, InnoDB selects variable-length columns for external off-page storage until the row fits within the InnoDB row size limit. The amount of data stored locally for variable-length columns that are stored off-page differs by row format. For more information, see InnoDB Row Formats.简单来说就是，对于像`varchar`这种不定长类型，如果这种类型长度超过了`Innodb`存储引擎规定的`row size`，那么Innodb会选择页外存储直到行大小符合`Innodb`存储引擎规定的`row size`。（但是即使这样也不能超过65535B，即65535B是包含不定长列中的内容的长度）\n- Different storage formats use different amounts of page header and trailer data, which affects the amount of storage available for rows.\n\n# Row Size Limit Examples\n### 65535B限制\n```sql\nmysql> CREATE TABLE t (a VARCHAR(10000), b VARCHAR(10000),\n       c VARCHAR(10000), d VARCHAR(10000), e VARCHAR(10000),\n       f VARCHAR(10000), g VARCHAR(6000)) ENGINE=InnoDB CHARACTER SET latin1;\nERROR 1118 (42000): Row size too large. The maximum row size for the used\ntable type, not counting BLOBs, is 65535. This includes storage overhead,\ncheck the manual. You have to change some columns to TEXT or BLOBs\n```\n看，由于`Latin1`编码1个字符是1个字节，总共不能超过65535个字符，超过就报错；而常用的`utf8mb4`编码最多1个字符占用4个字节，所以当使用`utf8mb4`编码时，最多只能有`65535/4=16383`个字符(==实际测肯定会小点，因为还有字节去记录变长字段长度==)：\n```sql\ntest> CREATE TABLE t (a VARCHAR(10000), b VARCHAR(6384)\n             ) ENGINE=InnoDB CHARACTER SET utf8mb4\n[2022-07-21 15:05:56] [42000][1118] Row size too large. The maximum row size for the used table type, not counting BLOBs, is 65535. This includes storage overhead, check the manual. You have to change some columns to TEXT or BLOBs\n\ntest> CREATE TABLE t (a VARCHAR(10000), b VARCHAR(6383)\n             ) ENGINE=InnoDB CHARACTER SET utf8mb4\n[2022-07-21 15:09:51] [42000][1118] Row size too large. The maximum row size for the used table type, not counting BLOBs, is 65535. This includes storage overhead, check the manual. You have to change some columns to TEXT or BLOBs\n\ntest> CREATE TABLE t (a VARCHAR(10000), b VARCHAR(6382)\n             ) ENGINE=InnoDB CHARACTER SET utf8mb4\n[2022-07-21 15:09:58] completed in 33 ms\n```\n根据提示，如果超过`row size`限制，可以使用`TEXT or BLOBs`类型，这个在`row size`中只占用9到12个字节。\n\n### 8126B限制\n65535B的限制主要针对不定长类型的限制，而定长类型的限制更为严格，像在Innodb存储引擎中，只能达到8KB多也就是页大小的一半（可以修改）。\n\n> innodb_strict_mode is enabled in the following example to ensure that InnoDB returns an error if the defined columns exceed the InnoDB row size limit. When innodb_strict_mode is disabled (the default), creating a table that uses REDUNDANT or COMPACT row format succeeds with a warning if the InnoDB row size limit is exceeded.\n```sql\nmysql> SET SESSION innodb_strict_mode=1;\nmysql> CREATE TABLE t4 (\n       c1 CHAR(255),c2 CHAR(255),c3 CHAR(255),\n       c4 CHAR(255),c5 CHAR(255),c6 CHAR(255),\n       c7 CHAR(255),c8 CHAR(255),c9 CHAR(255),\n       c10 CHAR(255),c11 CHAR(255),c12 CHAR(255),\n       c13 CHAR(255),c14 CHAR(255),c15 CHAR(255),\n       c16 CHAR(255),c17 CHAR(255),c18 CHAR(255),\n       c19 CHAR(255),c20 CHAR(255),c21 CHAR(255),\n       c22 CHAR(255),c23 CHAR(255),c24 CHAR(255),\n       c25 CHAR(255),c26 CHAR(255),c27 CHAR(255),\n       c28 CHAR(255),c29 CHAR(255),c30 CHAR(255),\n       c31 CHAR(255),c32 CHAR(255),c33 CHAR(255)\n       ) ENGINE=InnoDB ROW_FORMAT=COMPACT DEFAULT CHARSET latin1;\nERROR 1118 (42000): Row size too large (> 8126). Changing some columns to TEXT or BLOB or using\nROW_FORMAT=DYNAMIC or ROW_FORMAT=COMPRESSED may help. In current row format, BLOB prefix of 768\nbytes is stored inline.\n```\n\n### Row Limits总结\nRow Limits 一般为 MySQL本身65535B限制和存储引擎8126B限制（默认Innodb）。\n- 针对不定长类型，如`varchar`，一般首先收到限制的是MySQL本身65535B的限制。受不到存储引擎限制是因为，不定长类型如果长度超过8126B，会采用页外存储，也就是不定长类型的长度过长的话计入65535B而不计入8126B（大致可以这么理解）。另外，如果内容实在过长，则使用BLOB和TEXT，这样65535B只会只会消耗掉9到12个B。\n- 针对定长类型，首先会受到存储引擎8126B限制。',0,'2022-11-28 04:06:01','2022-11-28 04:06:01',NULL),(2,'React调用谷歌OAuth2第三方登录库','变更之前用的js库是 react-google-login，现在创建的clientID已经用不了了。\n这里推荐使用另一个js库 @react-oauth/google。具体使用参见@react-oauth/google.OAuth2.0授权有四种模式，常用的两种为authorization_code和implicit模式。前后端分离架构下如何完成授权，请参见文章[前后端分离：spring security OAuth2.0第三方授权]','# OAuth2.0\nOAuth2.0授权有四种模式，常用的两种为`authorization_code`和`implicit`模式。前后端分离架构下如何完成授权，请参见文章[前后端分离：spring security OAuth2.0第三方授权](https://blog.csdn.net/weixin_41866717/article/details/127092895).\n\n# Google平台库变更\n\n> ==Warning:== The Google Sign-In JavaScript platform library for Web is deprecated, and unavailable for download after March 31, 2023. The solutions in this guide are based on this library and therefore also deprecated.\nUse instead the new Google Identity Services for Web solution to quickly and easily sign users into your app using their Google accounts.\nBy default, new client IDs are now blocked from using the older platform library; existing client IDs are unaffected. ==New client IDs created before July 29th, 2022 may set the plugin_name to enable use of the legacy Google platform library.==\n\n参见[Migrating from Google Sign-In](https://developers.google.com/identity/gsi/web/guides/migration)\n\n# React集成谷歌第三方登录\n我在变更之前用的js库是 `react-google-login`，现在创建的clientID已经用不了了。\n这里推荐使用另一个js库 `@react-oauth/google`。具体使用参见[@react-oauth/google\n](https://www.npmjs.com/package/@react-oauth/google)除此之外，还需要安装jwt的库，因为google返回的是jwt，可使用js库`jwt-decode`\n\n在 `@react-oauth/google`库中有三种方式通过google登录：\n1. `authorization_code`模式，Google会返回前端一个code，这个code需要传回应用后端，让后端去google授权服务器获取access_token，后端再拿着access_token去google资源服务器拿数据\n2. `implicit`模式 ，省区code，Google直接将access_token返回给前端，然后前端把access_token传回后端，后端再拿着access_token去google资源服务器拿数据\n3. 直接登录。在浏览器点击允许谷歌授权后 谷歌会直接把数据返回给前端，code和access_token全部省略了。\n\n另外，谷歌的登录方式有三种配置：\n- `Google Account sign-in` 输入密码\n- `Consent and sign-in with One Tap` 一键登录(谷歌浏览器必须已经登录)\n- `Automatic sign-in` 自动登录(谷歌浏览器必须已经登录)\n\n具体可参考 [Sign in with Google for Web / Overview](https://developers.google.com/identity/gsi/web/guides/overview)\n\n# 实例\n[react-share-me](https://gitee.com/bao-tingyu/react-share-me)\n',0,'2022-11-28 04:07:31','2022-11-28 04:07:31','/image/google.jpg'),(3,'关于PostgreSQL 和 MySQL 预防Partial Page Write 问题的解决方式','当前所有数据库普遍采用 Write Ahead Log 策略，即先写日志在修改磁盘数据，这样可以保证内存中丢失的数据可以通过Log恢复。','### Partial Page Write\n当前所有数据库普遍采用 `Write Ahead Log` 策略，即先写日志在修改磁盘数据，这样可以保证内存中丢失的数据可以通过Log恢复。\n而日志记录的内容是以数据页为单位的（即数据库最小操作单元），以MySQL为例： `log records contain page number for the operation as well as operation data (ie update the row) and log sequence information.`在PSQL中默认page大小为`8KB`，在MySQL中默认page大小为`16KB`，而操作系统一般以4KB为单位进行读写（4K对齐？），所以写完WAL日志（or redo log）后，在往磁盘写数据页的过程中如果一个 $page$ 写到一半出现了问题，那么下次启动在根据 WAL 日志恢复时，再基于这个 $corrupted \\; page$ 进行恢复肯定是不行的。这个就是$Partial \\; Page \\; Write$问题。该问题具体可参考：[Now lets talk a bit about partial page writes ](https://www.percona.com/blog/2006/08/04/innodb-double-write/)\n### 解决方式\n\n - PSQL采用`full_page_write`这个配置来保证Partial Page Write 问题的产生，即在checkpoint之后的第一次change操作，会将整个page都写入磁盘，提高了可用性，降低了效率。\n - MySQL中采用`double write`机制，即先将缓冲池的脏页复制到内存的double write buffer，然后这个buffer会分别先写入共享表空间中（顺序写，速度快）然后写入数据文件中，这个共享表空间中即是完整的页的副本，下次redo时先拷贝一份再redo。\n\n参考：\n[What are advantages of each method to prevent partial page writes?](https://stackoverflow.com/questions/49346078/what-are-advantages-of-each-method-to-prevent-partial-page-writes)\n',0,'2022-11-28 04:08:47','2022-11-28 04:08:47',NULL);

--
-- Table structure for table `post_tag`
--

DROP TABLE IF EXISTS `post_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_tag` (
  `id` int NOT NULL AUTO_INCREMENT,
  `post_id` int NOT NULL,
  `tag_id` smallint NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_tag`
--

INSERT INTO `post_tag` (`id`, `post_id`, `tag_id`, `created`) VALUES (1,1,3,'2022-11-28 04:15:42'),(2,2,2,'2022-11-28 04:15:42'),(3,3,3,'2022-11-28 04:15:42'),(4,3,4,'2022-11-28 04:16:38');

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `url` text NOT NULL,
  `cover_url` text NOT NULL,
  `title` varchar(63) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `type` tinyint NOT NULL COMMENT '0图片,1视频,2音频,3PDF,4WORD,5EXCEL,6PPT,7其他',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `record_title_index` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--


--
-- Table structure for table `record_collection`
--

DROP TABLE IF EXISTS `record_collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `record_collection` (
  `id` int NOT NULL AUTO_INCREMENT,
  `record_id` int NOT NULL,
  `collection_id` smallint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `collection_id_index` (`collection_id`),
  KEY `record_id_index` (`record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record_collection`
--


--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag` (
  `id` smallint NOT NULL AUTO_INCREMENT,
  `name` varchar(15) DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tag_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

INSERT INTO `tag` (`id`, `name`, `created`, `updated`) VALUES (2,'React','2022-11-28 04:09:46','2022-11-28 04:09:46'),(3,'MySQL','2022-11-28 04:11:53','2022-11-28 04:11:53'),(4,'PostgreSQL','2022-11-28 04:16:14','2022-11-28 04:16:14'),(9,'Java','2022-12-09 10:16:39','2022-12-09 10:32:52');

--
-- Table structure for table `timeline`
--

DROP TABLE IF EXISTS `timeline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `timeline` (
  `id` tinyint NOT NULL AUTO_INCREMENT,
  `phase` varchar(10) NOT NULL,
  `title` varchar(15) NOT NULL,
  `link` varchar(255) DEFAULT NULL,
  `sub_title` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `start` varchar(10) NOT NULL,
  `end` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timeline`
--

INSERT INTO `timeline` (`id`, `phase`, `title`, `link`, `sub_title`, `content`, `start`, `end`) VALUES (1,'university','大连海事大学','http://www.dlmu.edu.cn/','本科 自动化专业','主修自动控制原理、电路、模电、数电、C、C++、微机原理等课程；本科期间获得优秀学生二等奖学金，英语四级587、六级553，BEC商务英语中级，全国大学生英语竞赛二等奖；参与新媒体社团，负责微信公众号运维，了解ps、pr软件的基本操作','2016.9','2020.6'),(2,'university','大连理工大学','https://www.dlut.edu.cn/','硕士研究生 电子信息专业','考研，考研成绩391；获得二等奖学金，课题为形状检索、流形排序方向，课题由Python语言实现；参与多个Java后台开发项目以及基于Vue开发的前端项目','2020.9','2023.6'),(3,'university','大连莱克科技','https://www.baidu.com/s?ie=UTF-8&wd=%E5%A4%A7%E8%BF%9E%E8%8E%B1%E5%85%8B%E7%A7%91%E6%8A%80%E5%8F%91%E5%B1%95%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8','实习','大连地铁智能运维云平台：47.104.247.242；基于若依权限管理系统开发：前端基于Vue框架、Element UI组件库开发 后台基于Spring Cloud Alibaba、MyBatis、PostgreSQL、时序数据库TimeScaleDB 测试部署基于docker+docker-compose','2021.7','2022.3'),(4,'graduated','高途集团','https://www.gaotu.cn/','北京 应届生工作','电商平台 服务平台 B端 C端','2023.7','?');

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(15) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`) VALUES ('bty','6b00ca973659ac798d64bedf4ee46323560737b954c5b686a4c212fc20e1cc05');
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-09 19:33:14
