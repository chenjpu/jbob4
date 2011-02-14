-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.42-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema biaobang
--

USE biaobang;

--
-- Definition of table `bill_of_lading`
--

DROP TABLE IF EXISTS `bill_of_lading`;
CREATE TABLE `bill_of_lading` (
  `id` bigint(11) NOT NULL COMMENT 'ID',
  `customer` varchar(256) NOT NULL COMMENT '客户资料',
  `contactInformation` varchar(256) NOT NULL COMMENT '联系方式',
  `receivingDetial` varchar(256) DEFAULT NULL COMMENT '收货明细',
  `freightName` varchar(256) NOT NULL COMMENT '货运公司名称',
  `freightPhone` varchar(128) DEFAULT NULL COMMENT '货运公司电话',
  `freightAddress` varchar(256) DEFAULT NULL COMMENT '货运公司地址',
  `remark1` text COMMENT '备注1',
  `remark2` text COMMENT '备注2',
  `remark3` text COMMENT '备注3',
  `sheetName` varchar(128) DEFAULT NULL COMMENT '制单',
  `auditor` varchar(128) DEFAULT NULL COMMENT '审核',
  `sender` varchar(128) DEFAULT NULL COMMENT '送货',
  `client` varchar(128) DEFAULT NULL COMMENT '客户',
  `otherFee` double DEFAULT '0' COMMENT '其他费用',
  `busiKey` varchar(10) DEFAULT NULL COMMENT '业务KEY',
  `tTime` datetime DEFAULT NULL COMMENT '创建日期',
  `cTime` datetime DEFAULT NULL COMMENT '修改日期',
  `cUser` varchar(10) DEFAULT NULL COMMENT '修改人',
  `remark4` text COMMENT '备注4',
  `remark5` text COMMENT '备注5',
  PRIMARY KEY (`id`),
  UNIQUE KEY `bill_of_lading_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='提货单';

--
-- Dumping data for table `bill_of_lading`
--

/*!40000 ALTER TABLE `bill_of_lading` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill_of_lading` ENABLE KEYS */;


--
-- Definition of table `bill_of_particulars`
--

DROP TABLE IF EXISTS `bill_of_particulars`;
CREATE TABLE `bill_of_particulars` (
  `id` bigint(11) NOT NULL DEFAULT '0' COMMENT 'ID',
  `ladingId` bigint(11) NOT NULL COMMENT '提货单id',
  `code` varchar(128) NOT NULL COMMENT '编码',
  `specificationModel` varchar(32) DEFAULT NULL COMMENT '货名规格',
  `sort` varchar(32) DEFAULT NULL COMMENT '类别',
  `spec` varchar(32) DEFAULT NULL COMMENT '规格',
  `unitPrice` double DEFAULT NULL COMMENT '单价',
  `amount` int(11) DEFAULT NULL COMMENT '数量',
  `units` varchar(32) DEFAULT NULL COMMENT '单位',
  `weight` double DEFAULT NULL COMMENT '重量/吨',
  `volume` double DEFAULT NULL COMMENT '体积/M3',
  `sum` double DEFAULT NULL COMMENT '金额',
  PRIMARY KEY (`id`),
  KEY `bill_of_particulars_id` (`id`),
  KEY `bill_of_particulars_fk` (`ladingId`),
  CONSTRAINT `bill_of_particulars_fk` FOREIGN KEY (`ladingId`) REFERENCES `bill_of_lading` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='明细单';

--
-- Dumping data for table `bill_of_particulars`
--

/*!40000 ALTER TABLE `bill_of_particulars` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill_of_particulars` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
