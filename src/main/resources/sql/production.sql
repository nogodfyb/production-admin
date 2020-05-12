/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : production

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-05-12 18:41:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for machine
-- ----------------------------
DROP TABLE IF EXISTS `machine`;
CREATE TABLE `machine` (
  `id` smallint(6) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '机台编码',
  `type` int(3) DEFAULT NULL COMMENT '机台类型',
  `description` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '机台类型的描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6037 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of machine
-- ----------------------------
INSERT INTO `machine` VALUES ('6001', 'A01', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6002', 'A02', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6003', 'A03', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6004', 'A04', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6005', 'A05', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6006', 'A06', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6007', 'A07', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6008', 'A08', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6009', 'A09', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6010', 'A10', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6011', 'A11', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6012', 'A12', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6013', 'A13', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6014', 'A14', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6015', 'A15', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6016', 'A16', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6017', 'A17', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6018', 'A18', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6019', 'A19', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6020', 'A20', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6021', 'A21', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6022', 'A22', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6023', 'A23', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6024', 'A24', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6025', 'A25', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6026', 'A26', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6027', 'A27', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6028', 'A28', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6029', 'A29', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6030', 'A30', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6031', 'A31', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6032', 'A32', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6033', 'A33', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6034', 'A34', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6035', 'A35', '1', '液压硫化机');
INSERT INTO `machine` VALUES ('6036', 'A36', '1', '液压硫化机');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  `auth_name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `path` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sort_order` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '0', '用户管理', '', '1');
INSERT INTO `menu` VALUES ('2', '0', '权限管理', '', '2');
INSERT INTO `menu` VALUES ('3', '0', '机台与产品', '', '3');
INSERT INTO `menu` VALUES ('4', '0', '订单与生产计划', '', '4');
INSERT INTO `menu` VALUES ('5', '0', '数据统计', '', '5');
INSERT INTO `menu` VALUES ('6', '1', '用户列表', 'users', '6');
INSERT INTO `menu` VALUES ('7', '2', '角色列表', 'roles', '8');
INSERT INTO `menu` VALUES ('8', '2', '权限列表', 'rights', '9');
INSERT INTO `menu` VALUES ('9', '3', '机台列表', 'machines', '10');
INSERT INTO `menu` VALUES ('10', '3', '产品列表', 'products', '11');
INSERT INTO `menu` VALUES ('11', '3', '机台产能', 'productivitys', '12');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '订单id',
  `plan_batch` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '计划批次',
  `product_code` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '产品编码',
  `scheduled_production` int(10) DEFAULT NULL COMMENT '计划产量',
  `process` int(10) DEFAULT NULL COMMENT '工序代码',
  `process_description` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '工序描述',
  `start_time` datetime DEFAULT NULL COMMENT '计划批次开始时间',
  `deadline` date DEFAULT NULL COMMENT '交单日期',
  `advance_day_count` int(10) DEFAULT NULL COMMENT '提前完成天数'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` smallint(6) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '产品名称',
  `code` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '产品代码',
  `unit_price` decimal(6,2) DEFAULT NULL COMMENT '价格，单位/元',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '天府RD-109', '1001', '205.00');
INSERT INTO `product` VALUES ('2', '天府RD-110A', '1002', '210.00');
INSERT INTO `product` VALUES ('3', '天府RD-123', '1003', '215.00');
INSERT INTO `product` VALUES ('4', '天府RD-209', '1004', '220.00');
INSERT INTO `product` VALUES ('5', '天府RD-224', '1005', '225.00');
INSERT INTO `product` VALUES ('6', '攀达 RD-106', '1006', '230.00');
INSERT INTO `product` VALUES ('7', '攀达 RD-119', '1007', '235.00');
INSERT INTO `product` VALUES ('8', '全钢系列CP265', '1008', '240.00');
INSERT INTO `product` VALUES ('9', '全钢系列CP267', '1009', '245.00');
INSERT INTO `product` VALUES ('10', 'SR965银路全钢', '1010', '250.00');
INSERT INTO `product` VALUES ('11', '天府RD-007A', '1011', '255.00');
INSERT INTO `product` VALUES ('12', '全钢轮胎-HD968', '1012', '260.00');
INSERT INTO `product` VALUES ('13', 'SR266银路全钢', '1013', '265.00');
INSERT INTO `product` VALUES ('14', 'SR166银路全钢', '1014', '270.00');
INSERT INTO `product` VALUES ('15', '工程轮胎EMT502', '1015', '275.00');
INSERT INTO `product` VALUES ('16', '工程轮胎EMT168', '1016', '280.00');
INSERT INTO `product` VALUES ('17', '天府HT606', '1017', '285.00');
INSERT INTO `product` VALUES ('18', '天府MTT-688', '1018', '290.00');
INSERT INTO `product` VALUES ('19', '天府MTT-839', '1019', '295.00');
INSERT INTO `product` VALUES ('20', '金天府HT808', '1020', '300.00');

-- ----------------------------
-- Table structure for production_plan
-- ----------------------------
DROP TABLE IF EXISTS `production_plan`;
CREATE TABLE `production_plan` (
  `production_date` date DEFAULT NULL COMMENT '生产日期',
  `shift` int(10) DEFAULT NULL COMMENT '生产班次，以1开始计数',
  `description` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '班次描述',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `scheduled_production` int(10) DEFAULT NULL COMMENT '计划产量',
  `product_code` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '产品代码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of production_plan
-- ----------------------------

-- ----------------------------
-- Table structure for productivity
-- ----------------------------
DROP TABLE IF EXISTS `productivity`;
CREATE TABLE `productivity` (
  `id` smallint(6) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `machine_code` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '机台代码',
  `product_code` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '产品代码',
  `daily_production` int(10) DEFAULT NULL COMMENT '日产量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of productivity
-- ----------------------------
INSERT INTO `productivity` VALUES ('1', 'A01', '1001', '161');
INSERT INTO `productivity` VALUES ('2', 'A02', '1001', '162');
INSERT INTO `productivity` VALUES ('3', 'A03', '1001', '163');
INSERT INTO `productivity` VALUES ('4', 'A04', '1001', '164');
INSERT INTO `productivity` VALUES ('5', 'A05', '1001', '165');
INSERT INTO `productivity` VALUES ('6', 'A06', '1001', '166');
INSERT INTO `productivity` VALUES ('7', 'A07', '1001', '167');
INSERT INTO `productivity` VALUES ('8', 'A08', '1001', '168');
INSERT INTO `productivity` VALUES ('9', 'A09', '1001', '169');
INSERT INTO `productivity` VALUES ('10', 'A10', '1001', '170');
INSERT INTO `productivity` VALUES ('11', 'A11', '1001', '171');
INSERT INTO `productivity` VALUES ('12', 'A12', '1001', '172');
INSERT INTO `productivity` VALUES ('13', 'A13', '1001', '173');
INSERT INTO `productivity` VALUES ('14', 'A14', '1001', '174');
INSERT INTO `productivity` VALUES ('15', 'A15', '1001', '175');
INSERT INTO `productivity` VALUES ('16', 'A16', '1001', '176');
INSERT INTO `productivity` VALUES ('17', 'A17', '1001', '177');
INSERT INTO `productivity` VALUES ('18', 'A18', '1001', '178');
INSERT INTO `productivity` VALUES ('19', 'A19', '1001', '179');
INSERT INTO `productivity` VALUES ('20', 'A20', '1001', '180');
INSERT INTO `productivity` VALUES ('21', 'A21', '1001', '181');
INSERT INTO `productivity` VALUES ('22', 'A22', '1001', '182');
INSERT INTO `productivity` VALUES ('23', 'A23', '1001', '183');
INSERT INTO `productivity` VALUES ('24', 'A24', '1001', '184');
INSERT INTO `productivity` VALUES ('25', 'A25', '1001', '185');
INSERT INTO `productivity` VALUES ('26', 'A26', '1001', '186');
INSERT INTO `productivity` VALUES ('27', 'A27', '1001', '187');
INSERT INTO `productivity` VALUES ('28', 'A28', '1001', '188');
INSERT INTO `productivity` VALUES ('29', 'A29', '1001', '189');
INSERT INTO `productivity` VALUES ('30', 'A30', '1001', '190');
INSERT INTO `productivity` VALUES ('31', 'A31', '1001', '191');
INSERT INTO `productivity` VALUES ('32', 'A32', '1001', '192');
INSERT INTO `productivity` VALUES ('33', 'A33', '1001', '193');
INSERT INTO `productivity` VALUES ('34', 'A34', '1001', '194');
INSERT INTO `productivity` VALUES ('35', 'A35', '1001', '195');
INSERT INTO `productivity` VALUES ('36', 'A36', '1001', '196');
INSERT INTO `productivity` VALUES ('37', 'A01', '1002', '165');
INSERT INTO `productivity` VALUES ('38', 'A02', '1002', '166');
INSERT INTO `productivity` VALUES ('39', 'A03', '1002', '167');
INSERT INTO `productivity` VALUES ('40', 'A04', '1002', '168');
INSERT INTO `productivity` VALUES ('41', 'A05', '1002', '169');
INSERT INTO `productivity` VALUES ('42', 'A06', '1002', '170');
INSERT INTO `productivity` VALUES ('43', 'A07', '1002', '171');
INSERT INTO `productivity` VALUES ('44', 'A08', '1002', '172');
INSERT INTO `productivity` VALUES ('45', 'A09', '1002', '173');
INSERT INTO `productivity` VALUES ('46', 'A10', '1002', '174');
INSERT INTO `productivity` VALUES ('47', 'A11', '1002', '175');
INSERT INTO `productivity` VALUES ('48', 'A12', '1002', '176');
INSERT INTO `productivity` VALUES ('49', 'A13', '1002', '177');
INSERT INTO `productivity` VALUES ('50', 'A14', '1002', '178');
INSERT INTO `productivity` VALUES ('51', 'A15', '1002', '179');
INSERT INTO `productivity` VALUES ('52', 'A16', '1002', '180');
INSERT INTO `productivity` VALUES ('53', 'A17', '1002', '181');
INSERT INTO `productivity` VALUES ('54', 'A18', '1002', '182');
INSERT INTO `productivity` VALUES ('55', 'A19', '1002', '183');
INSERT INTO `productivity` VALUES ('56', 'A20', '1002', '184');
INSERT INTO `productivity` VALUES ('57', 'A21', '1002', '185');
INSERT INTO `productivity` VALUES ('58', 'A22', '1002', '186');
INSERT INTO `productivity` VALUES ('59', 'A23', '1002', '187');
INSERT INTO `productivity` VALUES ('60', 'A24', '1002', '188');
INSERT INTO `productivity` VALUES ('61', 'A25', '1002', '189');
INSERT INTO `productivity` VALUES ('62', 'A26', '1002', '190');
INSERT INTO `productivity` VALUES ('63', 'A27', '1002', '191');
INSERT INTO `productivity` VALUES ('64', 'A28', '1002', '192');
INSERT INTO `productivity` VALUES ('65', 'A29', '1002', '193');
INSERT INTO `productivity` VALUES ('66', 'A30', '1002', '194');
INSERT INTO `productivity` VALUES ('67', 'A31', '1002', '195');
INSERT INTO `productivity` VALUES ('68', 'A32', '1002', '196');
INSERT INTO `productivity` VALUES ('69', 'A33', '1002', '197');
INSERT INTO `productivity` VALUES ('70', 'A34', '1002', '198');
INSERT INTO `productivity` VALUES ('71', 'A35', '1002', '199');
INSERT INTO `productivity` VALUES ('72', 'A36', '1002', '200');
INSERT INTO `productivity` VALUES ('73', 'A01', '1003', '163');
INSERT INTO `productivity` VALUES ('74', 'A02', '1003', '164');
INSERT INTO `productivity` VALUES ('75', 'A03', '1003', '165');
INSERT INTO `productivity` VALUES ('76', 'A04', '1003', '166');
INSERT INTO `productivity` VALUES ('77', 'A05', '1003', '167');
INSERT INTO `productivity` VALUES ('78', 'A06', '1003', '168');
INSERT INTO `productivity` VALUES ('79', 'A07', '1003', '169');
INSERT INTO `productivity` VALUES ('80', 'A08', '1003', '170');
INSERT INTO `productivity` VALUES ('81', 'A09', '1003', '171');
INSERT INTO `productivity` VALUES ('82', 'A10', '1003', '172');
INSERT INTO `productivity` VALUES ('83', 'A11', '1003', '173');
INSERT INTO `productivity` VALUES ('84', 'A12', '1003', '174');
INSERT INTO `productivity` VALUES ('85', 'A13', '1003', '175');
INSERT INTO `productivity` VALUES ('86', 'A14', '1003', '176');
INSERT INTO `productivity` VALUES ('87', 'A15', '1003', '177');
INSERT INTO `productivity` VALUES ('88', 'A16', '1003', '178');
INSERT INTO `productivity` VALUES ('89', 'A17', '1003', '179');
INSERT INTO `productivity` VALUES ('90', 'A18', '1003', '180');
INSERT INTO `productivity` VALUES ('91', 'A19', '1003', '181');
INSERT INTO `productivity` VALUES ('92', 'A20', '1003', '182');
INSERT INTO `productivity` VALUES ('93', 'A21', '1003', '183');
INSERT INTO `productivity` VALUES ('94', 'A22', '1003', '184');
INSERT INTO `productivity` VALUES ('95', 'A23', '1003', '185');
INSERT INTO `productivity` VALUES ('96', 'A24', '1003', '186');
INSERT INTO `productivity` VALUES ('97', 'A25', '1003', '187');
INSERT INTO `productivity` VALUES ('98', 'A26', '1003', '188');
INSERT INTO `productivity` VALUES ('99', 'A27', '1003', '189');
INSERT INTO `productivity` VALUES ('100', 'A28', '1003', '190');
INSERT INTO `productivity` VALUES ('101', 'A29', '1003', '191');
INSERT INTO `productivity` VALUES ('102', 'A30', '1003', '192');
INSERT INTO `productivity` VALUES ('103', 'A31', '1003', '193');
INSERT INTO `productivity` VALUES ('104', 'A32', '1003', '194');
INSERT INTO `productivity` VALUES ('105', 'A33', '1003', '195');
INSERT INTO `productivity` VALUES ('106', 'A34', '1003', '196');
INSERT INTO `productivity` VALUES ('107', 'A35', '1003', '197');
INSERT INTO `productivity` VALUES ('108', 'A36', '1003', '198');

-- ----------------------------
-- Table structure for rights
-- ----------------------------
DROP TABLE IF EXISTS `rights`;
CREATE TABLE `rights` (
  `id` smallint(6) unsigned NOT NULL AUTO_INCREMENT,
  `auth_name` varchar(20) NOT NULL COMMENT '权限名称',
  `pid` smallint(6) unsigned NOT NULL COMMENT '父id',
  `controller` varchar(32) NOT NULL DEFAULT '' COMMENT '控制器',
  `method` varchar(32) NOT NULL DEFAULT '' COMMENT '操作方法',
  `level` enum('0','1','2') NOT NULL DEFAULT '0' COMMENT '权限等级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=160 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of rights
-- ----------------------------
INSERT INTO `rights` VALUES ('1', '一级权限1', '0', 'index', '', '0');
INSERT INTO `rights` VALUES ('2', '一级权限2', '0', 'index', 'order', '0');
INSERT INTO `rights` VALUES ('3', '一级权限3', '0', 'index', '', '0');
INSERT INTO `rights` VALUES ('4', '一级权限4', '0', 'index', '', '0');
INSERT INTO `rights` VALUES ('5', '一级权限5', '0', 'index', '', '0');
INSERT INTO `rights` VALUES ('11', '二级权限1', '1', 'index', 'index', '1');
INSERT INTO `rights` VALUES ('12', '二级权限3', '1', 'index', 'index', '1');
INSERT INTO `rights` VALUES ('13', '二级权限4', '1', 'index', 'index', '1');
INSERT INTO `rights` VALUES ('14', '二级权限5', '1', 'index', 'index', '1');
INSERT INTO `rights` VALUES ('15', '二级权限6', '2', 'index', 'index', '1');
INSERT INTO `rights` VALUES ('16', '二级权限7', '2', 'index', 'index', '1');
INSERT INTO `rights` VALUES ('17', '二级权限2', '3', 'index', '', '1');
INSERT INTO `rights` VALUES ('18', '二级权限8', '3', 'index', '', '1');
INSERT INTO `rights` VALUES ('101', '三级权限1', '11', 'index', 'tianjia', '2');
INSERT INTO `rights` VALUES ('102', '三级权限2', '11', 'index', 'tianjia', '2');
INSERT INTO `rights` VALUES ('103', '三级权限3', '11', 'index', 'upd', '2');
INSERT INTO `rights` VALUES ('104', '三级权限4', '12', 'index', 'del', '2');
INSERT INTO `rights` VALUES ('105', '三级权限5', '12', 'index', '', '2');
INSERT INTO `rights` VALUES ('106', '三级权限6', '12', 'index', '', '2');
INSERT INTO `rights` VALUES ('107', '三级权限7', '12', 'index', '', '2');
INSERT INTO `rights` VALUES ('108', '三级权限8', '13', 'index', '', '2');
INSERT INTO `rights` VALUES ('109', '三级权限9', '13', 'index', '', '2');
INSERT INTO `rights` VALUES ('110', '三级权限10', '13', 'index', '', '2');
INSERT INTO `rights` VALUES ('111', '三级权限11', '14', 'index', '', '2');
INSERT INTO `rights` VALUES ('112', '三级权限12', '14', 'index', '', '2');
INSERT INTO `rights` VALUES ('113', '三级权限13', '15', 'index', '', '2');
INSERT INTO `rights` VALUES ('114', '三级权限14', '16', 'index', '', '2');
INSERT INTO `rights` VALUES ('115', '三级权限15', '17', 'index', '', '2');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', '管理员类型1');
INSERT INTO `role` VALUES ('2', '普通管理员', '管理员类型2');
INSERT INTO `role` VALUES ('3', '普通用户', '普通用户1');

-- ----------------------------
-- Table structure for role_rights
-- ----------------------------
DROP TABLE IF EXISTS `role_rights`;
CREATE TABLE `role_rights` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `rights_id` int(11) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of role_rights
-- ----------------------------
INSERT INTO `role_rights` VALUES ('1', '1', '1');
INSERT INTO `role_rights` VALUES ('2', '1', '2');
INSERT INTO `role_rights` VALUES ('3', '1', '3');
INSERT INTO `role_rights` VALUES ('4', '1', '11');
INSERT INTO `role_rights` VALUES ('5', '1', '12');
INSERT INTO `role_rights` VALUES ('6', '1', '13');
INSERT INTO `role_rights` VALUES ('7', '1', '14');
INSERT INTO `role_rights` VALUES ('8', '1', '15');
INSERT INTO `role_rights` VALUES ('9', '1', '16');
INSERT INTO `role_rights` VALUES ('10', '1', '17');
INSERT INTO `role_rights` VALUES ('11', '1', '18');
INSERT INTO `role_rights` VALUES ('12', '1', '101');
INSERT INTO `role_rights` VALUES ('13', '1', '102');
INSERT INTO `role_rights` VALUES ('14', '1', '103');
INSERT INTO `role_rights` VALUES ('15', '1', '104');
INSERT INTO `role_rights` VALUES ('16', '1', '105');
INSERT INTO `role_rights` VALUES ('17', '1', '106');
INSERT INTO `role_rights` VALUES ('18', '1', '107');
INSERT INTO `role_rights` VALUES ('19', '1', '108');
INSERT INTO `role_rights` VALUES ('20', '1', '109');
INSERT INTO `role_rights` VALUES ('21', '1', '110');
INSERT INTO `role_rights` VALUES ('22', '1', '111');
INSERT INTO `role_rights` VALUES ('23', '1', '112');
INSERT INTO `role_rights` VALUES ('24', '1', '113');
INSERT INTO `role_rights` VALUES ('25', '1', '114');
INSERT INTO `role_rights` VALUES ('26', '1', '115');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '用户姓名',
  `password` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '用户密码',
  `email` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱号码',
  `mobile` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号码',
  `role_id` int(4) DEFAULT NULL COMMENT '用户角色id，指向role',
  `is_alive` tinyint(1) DEFAULT NULL COMMENT '1代表可以使用，0代表封禁',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '12062481@qq.com', '17396256293', '1', '1', '2020-05-03 23:04:56', '2020-05-03 23:04:59');
INSERT INTO `user` VALUES ('30', 'test', '098f6bcd4621d373cade4e832627b4f6', '12062481@qq.com', '17396256293', '2', '1', null, null);
INSERT INTO `user` VALUES ('31', 'test1', '098f6bcd4621d373cade4e832627b4f6', '12062481@qq.com', '17396256293', '1', '1', null, null);
INSERT INTO `user` VALUES ('32', 'test2', '098f6bcd4621d373cade4e832627b4f6', '12062481@qq.com', '17396256293', '1', '1', null, null);
INSERT INTO `user` VALUES ('33', 'test2', '098f6bcd4621d373cade4e832627b4f6', '12062481@qq.com', '17396256293', '2', '0', null, null);
INSERT INTO `user` VALUES ('34', 'test2', '098f6bcd4621d373cade4e832627b4f6', '12062481@qq.com', '17396256293', '1', '1', null, null);
INSERT INTO `user` VALUES ('35', 'test2', '098f6bcd4621d373cade4e832627b4f6', '12062481@qq.com', '17396256293', '2', '1', null, null);
INSERT INTO `user` VALUES ('36', 'test2', '098f6bcd4621d373cade4e832627b4f6', '12062481@qq.com', '17396256293', '1', '1', null, null);
INSERT INTO `user` VALUES ('37', 'test2', '098f6bcd4621d373cade4e832627b4f6', '12062481@qq.com', '17396256293', '2', '0', null, null);
INSERT INTO `user` VALUES ('38', 'test2', '098f6bcd4621d373cade4e832627b4f6', '12062481@qq.com', '17396256293', '1', '1', null, null);
INSERT INTO `user` VALUES ('39', 'test2', '098f6bcd4621d373cade4e832627b4f6', '12062481@qq.com', '17396256293', '2', '1', null, null);
INSERT INTO `user` VALUES ('40', 'test2', '098f6bcd4621d373cade4e832627b4f6', '12062481@qq.com', '17396256293', '1', '1', null, null);
INSERT INTO `user` VALUES ('41', 'test2', '098f6bcd4621d373cade4e832627b4f6', '12062481@qq.com', '17396256293', '2', '1', null, null);
INSERT INTO `user` VALUES ('42', 'test2', '098f6bcd4621d373cade4e832627b4f6', '12062481@qq.com', '17396256293', '1', '0', null, null);
INSERT INTO `user` VALUES ('43', 'test2', '098f6bcd4621d373cade4e832627b4f6', '12062481@qq.com', '17396256293', '2', '1', null, null);
INSERT INTO `user` VALUES ('44', 'test2', '098f6bcd4621d373cade4e832627b4f6', '12062481@qq.com', '17396256293', '1', '1', null, null);
INSERT INTO `user` VALUES ('45', 'test2', '098f6bcd4621d373cade4e832627b4f6', '12062481@qq.com', '17396256293', '2', '1', null, null);
INSERT INTO `user` VALUES ('46', 'test2', '098f6bcd4621d373cade4e832627b4f6', '12062481@qq.com', '17396256293', '1', '0', null, null);
INSERT INTO `user` VALUES ('47', 'test2', '098f6bcd4621d373cade4e832627b4f6', '12062481@qq.com', '17396256293', '2', '1', null, null);
INSERT INTO `user` VALUES ('48', 'asdad', 'fa1b865d9280d4a488afa30fd60216e7', '120626481@qq.com', '17396256293', '3', '1', null, null);
INSERT INTO `user` VALUES ('49', 'asdad', 'b0c44dc7bd2ecec1ccfd77f4bfbd35cc', '120626488@qq.com', '17396256296', '3', '1', null, null);
INSERT INTO `user` VALUES ('50', 'asdsad', 'ae2d0987c13ad85418765740555d5025', '120626481@qq.com', '17396256293', '3', '1', null, null);
INSERT INTO `user` VALUES ('51', 'qaeqew', '3cba1eb7a5bcd42097c3c3b6ff74c3a0', '120626488@qq.com', '17396256299', '3', '0', null, null);
INSERT INTO `user` VALUES ('52', 'woshi', '60863316485b7ffb873056e6a4ad9f66', '120626481@qq.com', '17396256293', '3', '1', null, null);
