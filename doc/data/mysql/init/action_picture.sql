/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.22 : Database - action_picture
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`action_picture` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `action_picture`;

/*Table structure for table `t_file` */

DROP TABLE IF EXISTS `t_file`;

CREATE TABLE `t_file` (
  `uid` varchar(36) NOT NULL COMMENT '唯一uid',
  `file_old_name` varchar(255) DEFAULT NULL COMMENT '旧文件名',
  `pic_name` varchar(255) DEFAULT NULL COMMENT '文件名',
  `pic_url` varchar(255) DEFAULT NULL COMMENT '文件地址',
  `pic_expanded_name` varchar(255) DEFAULT NULL COMMENT '文件扩展名',
  `file_size` int DEFAULT '0' COMMENT '文件大小',
  `file_sort_uid` varchar(36) DEFAULT NULL COMMENT '文件分类uid',
  `admin_uid` varchar(36) DEFAULT NULL COMMENT '管理员uid',
  `user_uid` varchar(36) DEFAULT NULL COMMENT '用户uid',
  `status` tinyint unsigned NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `qi_niu_url` varchar(255) DEFAULT NULL COMMENT '七牛云地址',
  `minio_url` varchar(255) DEFAULT NULL COMMENT 'Minio文件URL',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件表';

/*Data for the table `t_file` */

insert  into `t_file`(`uid`,`file_old_name`,`pic_name`,`pic_url`,`pic_expanded_name`,`file_size`,`file_sort_uid`,`admin_uid`,`user_uid`,`status`,`create_time`,`update_time`,`qi_niu_url`,`minio_url`) values ('ff738378eefa2f470c8a67abbc861a49','image-20200713094745366.png','1596782616273.png','/blog/admin/png/2020/8/7/1596782616273.png','png',207553,'a9a747d944c24845815356f72723ef8e','uid00000000000000000000000000000000','uid00000000000000000000000000000000',1,'2020-08-07 14:43:36','2020-08-07 14:43:36',NULL,NULL),('ff91d0c9166a5d080d62f23554dcf0bc','http://image.actionit.cn/1578308734860.png','1581691345657.jpg','http://localhost:8600//blog/admin/jpg/2020/2/14/1581691345657.jpg','jpg',0,'a9a747d944c24845815356f72723ef8e','uid00000000000000000000000000000000','uid00000000000000000000000000000000',1,'2020-02-14 22:42:25','2020-02-14 22:42:25',NULL,NULL),('ffe1c088d99304a0c3e40e8421ccffbd','timg.jfif','1584408134679.jfif','blog/admin/jfif/2020/3/17/1584408134679.jfif','jfif',67989,'a9a747d944c24845815356f72723ef8e','uid00000000000000000000000000000000','uid00000000000000000000000000000000',1,'2020-03-17 09:22:14','2020-03-17 09:22:14',NULL,NULL),('fff1c09c5435b782e5ec7e8532883ab2','1_BigPic.png','1580523320754.png','/blog/admin/png/2020/2/1/1580523320754.png','png',46688,'a9a747d944c24845815356f72723ef8e','uid00000000000000000000000000000000','uid00000000000000000000000000000000',1,'2020-02-01 10:15:20','2020-02-01 10:15:20',NULL,NULL);

/*Table structure for table `t_file_sort` */

DROP TABLE IF EXISTS `t_file_sort`;

CREATE TABLE `t_file_sort` (
  `uid` varchar(36) NOT NULL COMMENT '唯一uid',
  `project_name` varchar(255) DEFAULT NULL COMMENT '项目名',
  `sort_name` varchar(255) DEFAULT NULL COMMENT '分类名',
  `url` varchar(255) DEFAULT NULL COMMENT '分类路径',
  `status` tinyint unsigned NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件分类表';

/*Data for the table `t_file_sort` */

insert  into `t_file_sort`(`uid`,`project_name`,`sort_name`,`url`,`status`,`create_time`,`update_time`) values ('a9a747d944c24845815356f72723ef8e','blog','admin','/blog/admin',1,'2020-06-14 21:06:08','2020-06-14 21:06:10'),('a9a747d944c24845815356f72723ef8f','blog','web','/blog/web',1,'2020-06-14 21:06:12','2020-06-14 21:06:13');

/*Table structure for table `t_network_disk` */

DROP TABLE IF EXISTS `t_network_disk`;

CREATE TABLE `t_network_disk` (
  `uid` varchar(32) NOT NULL COMMENT '唯一uid',
  `admin_uid` varchar(32) NOT NULL COMMENT '管理员uid',
  `extend_name` varchar(255) DEFAULT NULL COMMENT '扩展名',
  `file_name` varchar(255) DEFAULT NULL COMMENT '文件名',
  `file_path` varchar(255) DEFAULT NULL COMMENT '文件路径',
  `file_size` bigint NOT NULL COMMENT '文件大小',
  `is_dir` int NOT NULL COMMENT '是否目录',
  `status` tinyint unsigned NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `local_url` varchar(255) DEFAULT NULL COMMENT '本地文件URL',
  `qi_niu_url` varchar(255) DEFAULT NULL COMMENT '七牛云URL',
  `file_old_name` varchar(255) DEFAULT NULL COMMENT '上传前文件名',
  `minio_url` varchar(255) DEFAULT NULL COMMENT 'Minio文件URL',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='网盘文件表';

/*Data for the table `t_network_disk` */

insert  into `t_network_disk`(`uid`,`admin_uid`,`extend_name`,`file_name`,`file_path`,`file_size`,`is_dir`,`status`,`create_time`,`update_time`,`local_url`,`qi_niu_url`,`file_old_name`,`minio_url`) values ('056dda827b16a16243662c4978effa25','1f01cd1d2f474743b241d74008b12333','jpg','1603526874546.jpg','/',165398,0,0,'2020-10-24 16:07:57','2020-10-24 16:39:33','/blog/admin/jpg/2020/10/24/1603526876655.jpg',NULL,'1B8EDA6B1BAEAF07F096426CFE19BE03.jpg',NULL),('d4777e0574b8d310d09dea057d89dcfb','1f01cd1d2f474743b241d74008b12333','webp','1603250952562.webp','/新建文件/',20750,0,0,'2020-10-21 11:29:14','2020-10-21 16:03:45','/blog/admin/webp/2020/10/21/1603250954894.webp','588874c9141947ed99b46ee5ed2470cb','ideaBackground.webp',NULL),('fb38361ab5fcb6d3aa901a169609d257','1f01cd1d2f474743b241d74008b12333','jpg','1603527361497.jpg','/',165398,0,0,'2020-10-24 16:16:05','2020-10-24 16:41:38','/blog/admin/jpg/2020/10/24/1603527363806.jpg',NULL,'1B8EDA6B1BAEAF07F096426CFE19BE03.jpg','/actionblog/1603527361503.jpg');

/*Table structure for table `t_storage` */

DROP TABLE IF EXISTS `t_storage`;

CREATE TABLE `t_storage` (
  `uid` varchar(32) NOT NULL COMMENT '唯一uid',
  `admin_uid` varchar(32) NOT NULL COMMENT '管理员uid',
  `storage_size` bigint NOT NULL,
  `status` tinyint unsigned NOT NULL DEFAULT '1' COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  `max_storage_size` bigint DEFAULT '0' COMMENT '最大容量大小',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='存储信息表';

/*Data for the table `t_storage` */

insert  into `t_storage`(`uid`,`admin_uid`,`storage_size`,`status`,`create_time`,`update_time`,`max_storage_size`) values ('1f01cd1d2f474743b241d74008b12334','1f01cd1d2f474743b241d74008b12333',7780,1,'2020-07-11 22:05:48','2020-12-11 16:11:23',10485760),('2bb52a208f2ed8592cfe2239c2d5350e','0954693eb7ebaa0b693d3c787fb8bab7',0,1,'2020-10-09 16:19:43','2020-10-10 11:18:46',524288000),('f0c2c2021a8021d079d1ed70017bb2d8','7621746caa93ce605e2de7143a3787b5',177619,1,'2020-10-09 15:17:01','2020-12-11 16:14:40',524288000),('f0c2c2021a8021d079d1ed70017bb2d9','72346fe9bfc754023e3495f2614bf18f',0,1,'2020-10-09 10:17:41','2020-10-09 10:17:41',50000);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
