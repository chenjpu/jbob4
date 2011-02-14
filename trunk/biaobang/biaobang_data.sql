-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.24-rc-community


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

CREATE DATABASE IF NOT EXISTS biaobang;
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
  `orderNum` int(11) NOT NULL COMMENT '序号',
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


--
-- Definition of table `forwarder`
--

DROP TABLE IF EXISTS `forwarder`;
CREATE TABLE `forwarder` (
  `id` bigint(11) NOT NULL DEFAULT '0',
  `name` varchar(256) DEFAULT NULL COMMENT '货运公司',
  `telephone` varchar(32) DEFAULT NULL COMMENT '货运电话',
  `address` varchar(256) DEFAULT NULL COMMENT '货运地址',
  `franchiserId` bigint(11) DEFAULT NULL COMMENT '经销商',
  PRIMARY KEY (`id`),
  KEY `forwarder_pk` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='货运公司';

--
-- Dumping data for table `forwarder`
--

/*!40000 ALTER TABLE `forwarder` DISABLE KEYS */;
/*!40000 ALTER TABLE `forwarder` ENABLE KEYS */;


--
-- Definition of table `franchiser`
--

DROP TABLE IF EXISTS `franchiser`;
CREATE TABLE `franchiser` (
  `id` bigint(11) NOT NULL DEFAULT '0' COMMENT '主键',
  `number` varchar(128) NOT NULL COMMENT '编号',
  `level` varchar(10) NOT NULL COMMENT '级别',
  `area` varchar(32) NOT NULL COMMENT '区域',
  `phoneCode` varchar(32) DEFAULT NULL COMMENT '电话号码',
  `faxNumber` varchar(32) DEFAULT NULL COMMENT '传真号码',
  `receivingDetails` varchar(256) DEFAULT NULL COMMENT '收货明细',
  `parentId` bigint(11) DEFAULT NULL COMMENT '经销商ID',
  PRIMARY KEY (`id`),
  KEY `franchiser_pk` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='经销商或分销商';

--
-- Dumping data for table `franchiser`
--

/*!40000 ALTER TABLE `franchiser` DISABLE KEYS */;
/*!40000 ALTER TABLE `franchiser` ENABLE KEYS */;


--
-- Definition of table `goods`
--

DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` bigint(11) NOT NULL DEFAULT '0',
  `type` varchar(128) DEFAULT NULL COMMENT '类型',
  `name` varchar(128) DEFAULT NULL COMMENT '名称',
  `netMass` varchar(128) DEFAULT NULL COMMENT '净含量',
  `netWeight` varchar(128) DEFAULT NULL COMMENT '净重量',
  `length` double DEFAULT NULL COMMENT ' 长(cm)',
  `width` double DEFAULT NULL COMMENT '宽(cm)',
  `height` double DEFAULT NULL COMMENT '高(cm)',
  `volume` double DEFAULT NULL COMMENT '体积(CBM)',
  `bottleWeight` double DEFAULT NULL COMMENT '瓶重(g)',
  `boxWeight` double DEFAULT NULL COMMENT '箱重(kg)',
  `barCode` varchar(32) DEFAULT NULL COMMENT '条形码',
  `number` varchar(32) DEFAULT NULL COMMENT '编码',
  `specification` int(11) DEFAULT NULL COMMENT '包装规格',
  `standard` varchar(32) DEFAULT NULL COMMENT '执行标准',
  PRIMARY KEY (`id`),
  KEY `goods_pk` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='货物';

--
-- Dumping data for table `goods`
--

/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;


--
-- Definition of table `pricelist`
--

DROP TABLE IF EXISTS `pricelist`;
CREATE TABLE `pricelist` (
  `id` bigint(11) NOT NULL DEFAULT '0',
  `franchiserId` bigint(11) DEFAULT NULL COMMENT '经销商Id',
  `goodsId` bigint(11) DEFAULT NULL COMMENT '货物Id',
  `price` double DEFAULT NULL COMMENT '价格(元)',
  PRIMARY KEY (`id`),
  KEY `pricelist_pk` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='价格明细';

--
-- Dumping data for table `pricelist`
--
--
-- Definition of table `operatorinfo`
--

DROP TABLE IF EXISTS `operatorinfo`;
CREATE TABLE `operatorinfo` (
  `id` varchar(32) NOT NULL,
  `user` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `cUser` varchar(32) DEFAULT NULL,
  `cTime` datetime DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `roleID` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_ROLE_ID` (`roleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `operatorinfo`
--

/*!40000 ALTER TABLE `operatorinfo` DISABLE KEYS */;
INSERT INTO `operatorinfo` (`id`,`user`,`password`,`name`,`phone`,`cUser`,`cTime`,`remark`,`roleID`) VALUES 
 ('1234567890','root','123456','超级管理员','88888888',NULL,NULL,NULL,'1234567980');
/*!40000 ALTER TABLE `operatorinfo` ENABLE KEYS */;


--
-- Definition of table `sysmenuinfo`
--

DROP TABLE IF EXISTS `sysmenuinfo`;
CREATE TABLE `sysmenuinfo` (
  `id` varchar(32) NOT NULL,
  `menuName` varchar(32) DEFAULT NULL,
  `menuCode` varchar(32) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `cUser` varchar(32) DEFAULT NULL,
  `cTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sysmenuinfo`
--

/*!40000 ALTER TABLE `sysmenuinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `sysmenuinfo` ENABLE KEYS */;


--
-- Definition of table `sysroleinfo`
--

DROP TABLE IF EXISTS `sysroleinfo`;
CREATE TABLE `sysroleinfo` (
  `id` varchar(32) NOT NULL,
  `roleName` varchar(32) DEFAULT NULL,
  `roleCode` varchar(32) DEFAULT NULL,
  `functionScope` varchar(1000) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  `cUser` varchar(10) DEFAULT NULL,
  `cTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sysroleinfo`
--

/*!40000 ALTER TABLE `sysroleinfo` DISABLE KEYS */;
INSERT INTO `sysroleinfo` (`id`,`roleName`,`roleCode`,`functionScope`,`remark`,`cUser`,`cTime`) VALUES 
 ('1234567980','超级管理员','rootRloe','inventoryC, inventoryU, inventoryR,inventoryD,produceVarietyLogC, produceVarietyLogU, produceVarietyLogR,produceVarietyLogD,shipmentInfoC, shipmentInfoU, shipmentInfoR,shipmentInfoD,trackClothTempletC, trackClothTempletU, trackClothTempletR,trackClothTempletD,trackOrderC, trackOrderU, trackOrderR,trackOrderD',NULL,NULL,NULL);
/*!40000 ALTER TABLE `sysroleinfo` ENABLE KEYS */;
/*!40000 ALTER TABLE `pricelist` DISABLE KEYS */;
/*!40000 ALTER TABLE `pricelist` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
