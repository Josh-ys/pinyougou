/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : pinyougoudb

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-08-14 00:04:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_address
-- ----------------------------
DROP TABLE IF EXISTS `tb_address`;
CREATE TABLE `tb_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户ID',
  `province_id` varchar(10) DEFAULT NULL COMMENT '省',
  `city_id` varchar(10) DEFAULT NULL COMMENT '市',
  `town_id` varchar(10) DEFAULT NULL COMMENT '县/区',
  `mobile` varchar(255) DEFAULT NULL COMMENT '手机',
  `address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `contact` varchar(255) DEFAULT NULL COMMENT '联系人',
  `is_default` varchar(1) DEFAULT NULL COMMENT '是否是默认 1默认 0否',
  `notes` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `alias` varchar(50) DEFAULT NULL COMMENT '别名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_areas
-- ----------------------------
DROP TABLE IF EXISTS `tb_areas`;
CREATE TABLE `tb_areas` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `areaid` varchar(20) NOT NULL COMMENT '区域ID',
  `area` varchar(50) NOT NULL COMMENT '区域名称',
  `cityid` varchar(20) NOT NULL COMMENT '城市ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3145 DEFAULT CHARSET=utf8 COMMENT='行政区域县区信息表';

-- ----------------------------
-- Table structure for tb_brand
-- ----------------------------
DROP TABLE IF EXISTS `tb_brand`;
CREATE TABLE `tb_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '品牌名称',
  `first_char` varchar(1) DEFAULT NULL COMMENT '品牌首字母',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_cities
-- ----------------------------
DROP TABLE IF EXISTS `tb_cities`;
CREATE TABLE `tb_cities` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `cityid` varchar(20) NOT NULL COMMENT '城市ID',
  `city` varchar(50) NOT NULL COMMENT '城市名称',
  `provinceid` varchar(20) NOT NULL COMMENT '省份ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=346 DEFAULT CHARSET=utf8 COMMENT='行政区域地州市信息表';

-- ----------------------------
-- Table structure for tb_content
-- ----------------------------
DROP TABLE IF EXISTS `tb_content`;
CREATE TABLE `tb_content` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) NOT NULL COMMENT '内容类目ID',
  `title` varchar(200) DEFAULT NULL COMMENT '内容标题',
  `url` varchar(500) DEFAULT NULL COMMENT '链接',
  `pic` varchar(300) DEFAULT NULL COMMENT '图片绝对路径',
  `status` varchar(1) DEFAULT NULL COMMENT '状态',
  `sort_order` int(11) DEFAULT NULL COMMENT '排序',
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `category_id` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_content_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_content_category`;
CREATE TABLE `tb_content_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类目ID',
  `name` varchar(50) DEFAULT NULL COMMENT '分类名称',
  `content_group` varchar(255) DEFAULT NULL,
  `content_key` varchar(255) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='内容分类';

-- ----------------------------
-- Table structure for tb_freight_template
-- ----------------------------
DROP TABLE IF EXISTS `tb_freight_template`;
CREATE TABLE `tb_freight_template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `seller_id` varchar(30) DEFAULT NULL COMMENT '商家ID',
  `is_default` varchar(1) DEFAULT NULL COMMENT '是否默认   （‘Y’是   ''N''否）',
  `name` varchar(50) DEFAULT NULL COMMENT '模版名称',
  `send_time_type` varchar(1) DEFAULT NULL COMMENT '发货时间（1:12h  2:24h  3:48h  4:72h  5:7d 6:15d ）',
  `price` decimal(10,0) DEFAULT NULL COMMENT '统一价格',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_goods
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `seller_id` varchar(20) DEFAULT NULL COMMENT '商家ID',
  `goods_name` varchar(100) DEFAULT NULL COMMENT 'SPU名',
  `default_item_id` bigint(20) DEFAULT NULL COMMENT '默认SKU',
  `audit_status` varchar(2) DEFAULT NULL COMMENT '状态',
  `is_marketable` varchar(1) DEFAULT NULL COMMENT '是否上架',
  `brand_id` bigint(10) DEFAULT NULL COMMENT '品牌',
  `caption` varchar(100) DEFAULT NULL COMMENT '副标题',
  `category1_id` bigint(20) DEFAULT NULL COMMENT '一级类目',
  `category2_id` bigint(10) DEFAULT NULL COMMENT '二级类目',
  `category3_id` bigint(10) DEFAULT NULL COMMENT '三级类目',
  `small_pic` varchar(150) DEFAULT NULL COMMENT '小图',
  `price` decimal(10,2) DEFAULT NULL COMMENT '商城价',
  `type_template_id` bigint(20) DEFAULT NULL COMMENT '分类模板ID',
  `is_enable_spec` varchar(1) DEFAULT NULL COMMENT '是否启用规格',
  `is_delete` varchar(1) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=149187842867970 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_goods_desc
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods_desc`;
CREATE TABLE `tb_goods_desc` (
  `goods_id` bigint(20) NOT NULL COMMENT 'SPU_ID',
  `introduction` varchar(3000) DEFAULT NULL COMMENT '描述',
  `specification_items` varchar(3000) DEFAULT NULL COMMENT '规格结果集，所有规格，包含isSelected',
  `custom_attribute_items` varchar(3000) DEFAULT NULL COMMENT '自定义属性（参数结果）',
  `item_images` varchar(3000) DEFAULT NULL,
  `package_list` varchar(3000) DEFAULT NULL COMMENT '包装列表',
  `sale_service` varchar(3000) DEFAULT NULL COMMENT '售后服务',
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_item
-- ----------------------------
DROP TABLE IF EXISTS `tb_item`;
CREATE TABLE `tb_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品id，同时也是商品编号',
  `title` varchar(100) NOT NULL COMMENT '商品标题',
  `sell_point` varchar(500) DEFAULT NULL COMMENT '商品卖点',
  `price` decimal(20,2) NOT NULL COMMENT '商品价格，单位为：元',
  `stock_count` int(10) DEFAULT NULL,
  `num` int(10) NOT NULL COMMENT '库存数量',
  `barcode` varchar(30) DEFAULT NULL COMMENT '商品条形码',
  `image` varchar(2000) DEFAULT NULL COMMENT '商品图片',
  `categoryId` bigint(10) NOT NULL COMMENT '所属类目，叶子类目',
  `status` varchar(1) NOT NULL COMMENT '商品状态，1-正常，2-下架，3-删除',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `item_sn` varchar(30) DEFAULT NULL,
  `cost_pirce` decimal(10,2) DEFAULT NULL,
  `market_price` decimal(10,2) DEFAULT NULL,
  `is_default` varchar(1) DEFAULT NULL,
  `goods_id` bigint(20) DEFAULT NULL,
  `seller_id` varchar(30) DEFAULT NULL,
  `cart_thumbnail` varchar(150) DEFAULT NULL,
  `category` varchar(200) DEFAULT NULL,
  `brand` varchar(100) DEFAULT NULL,
  `spec` varchar(200) DEFAULT NULL,
  `seller` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cid` (`categoryId`),
  KEY `status` (`status`),
  KEY `updated` (`update_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1369308 DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Table structure for tb_item_cat
-- ----------------------------
DROP TABLE IF EXISTS `tb_item_cat`;
CREATE TABLE `tb_item_cat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类目ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父类目ID=0时，代表的是一级的类目',
  `name` varchar(50) DEFAULT NULL COMMENT '类目名称',
  `type_id` bigint(11) DEFAULT NULL COMMENT '类型id',
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1205 DEFAULT CHARSET=utf8 COMMENT='商品类目';

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `payment` decimal(20,2) DEFAULT NULL COMMENT '实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分',
  `payment_type` varchar(1) COLLATE utf8_bin DEFAULT NULL COMMENT '支付类型，1、在线支付，2、货到付款',
  `post_fee` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '邮费。精确到2位小数;单位:元。如:200.07，表示:200元7分',
  `status` varchar(1) COLLATE utf8_bin DEFAULT NULL COMMENT '状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭,7、待评价',
  `create_time` datetime DEFAULT NULL COMMENT '订单创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '订单更新时间',
  `payment_time` datetime DEFAULT NULL COMMENT '付款时间',
  `consign_time` datetime DEFAULT NULL COMMENT '发货时间',
  `end_time` datetime DEFAULT NULL COMMENT '交易完成时间',
  `close_time` datetime DEFAULT NULL COMMENT '交易关闭时间',
  `shipping_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '物流名称',
  `shipping_code` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '物流单号',
  `user_id` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用户id',
  `buyer_message` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '买家留言',
  `buyer_nick` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '买家昵称',
  `buyer_rate` varchar(2) COLLATE utf8_bin DEFAULT NULL COMMENT '买家是否已经评价',
  `receiver_area_name` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '收货人地区名称(省，市，县)街道',
  `receiver_mobile` varchar(12) COLLATE utf8_bin DEFAULT NULL COMMENT '收货人手机',
  `receiver_zip_code` varchar(15) COLLATE utf8_bin DEFAULT NULL COMMENT '收货人邮编',
  `receiver` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '收货人',
  `expire` datetime DEFAULT NULL COMMENT '过期时间，定期清理',
  `invoice_type` varchar(1) COLLATE utf8_bin DEFAULT NULL COMMENT '发票类型(普通发票，电子发票，增值税发票)',
  `source_type` varchar(1) COLLATE utf8_bin DEFAULT NULL COMMENT '订单来源：1:app端，2：pc端，3：M端，4：微信端，5：手机qq端',
  `seller_id` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '商家ID',
  PRIMARY KEY (`order_id`),
  KEY `create_time` (`create_time`),
  KEY `buyer_nick` (`buyer_nick`),
  KEY `status` (`status`),
  KEY `payment_type` (`payment_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for tb_order_item
-- ----------------------------
DROP TABLE IF EXISTS `tb_order_item`;
CREATE TABLE `tb_order_item` (
  `id` bigint(20) NOT NULL,
  `item_id` bigint(20) NOT NULL COMMENT '商品id',
  `goods_id` bigint(20) DEFAULT NULL COMMENT 'SPU_ID',
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `title` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '商品标题',
  `price` decimal(20,2) DEFAULT NULL COMMENT '商品单价',
  `num` int(10) DEFAULT NULL COMMENT '商品购买数量',
  `total_fee` decimal(20,2) DEFAULT NULL COMMENT '商品总金额',
  `pic_path` varchar(200) COLLATE utf8_bin DEFAULT NULL COMMENT '商品图片地址',
  `seller_id` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `item_id` (`item_id`),
  KEY `order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for tb_pay_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_pay_log`;
CREATE TABLE `tb_pay_log` (
  `out_trade_no` varchar(30) NOT NULL COMMENT '支付订单号',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `pay_time` datetime DEFAULT NULL COMMENT '支付完成时间',
  `total_fee` bigint(20) DEFAULT NULL COMMENT '支付金额（分）',
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户ID',
  `transaction_id` varchar(30) DEFAULT NULL COMMENT '交易号码',
  `trade_state` varchar(1) DEFAULT NULL COMMENT '交易状态',
  `order_list` varchar(200) DEFAULT NULL COMMENT '订单编号列表',
  `pay_type` varchar(1) DEFAULT NULL COMMENT '支付类型',
  PRIMARY KEY (`out_trade_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_provinces
-- ----------------------------
DROP TABLE IF EXISTS `tb_provinces`;
CREATE TABLE `tb_provinces` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `provinceid` varchar(20) NOT NULL COMMENT '省份ID',
  `province` varchar(50) NOT NULL COMMENT '省份名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='省份信息表';

-- ----------------------------
-- Table structure for tb_seckill_goods
-- ----------------------------
DROP TABLE IF EXISTS `tb_seckill_goods`;
CREATE TABLE `tb_seckill_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) DEFAULT NULL COMMENT 'spu ID',
  `item_id` bigint(20) DEFAULT NULL COMMENT 'sku ID',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `small_pic` varchar(150) DEFAULT NULL COMMENT '商品图片',
  `price` decimal(10,2) DEFAULT NULL COMMENT '原价格',
  `cost_price` decimal(10,2) DEFAULT NULL COMMENT '秒杀价格',
  `seller_id` varchar(100) DEFAULT NULL COMMENT '商家ID',
  `create_time` datetime DEFAULT NULL COMMENT '添加日期',
  `check_time` datetime DEFAULT NULL COMMENT '审核日期',
  `status` varchar(1) DEFAULT NULL COMMENT '审核状态',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `num` int(11) DEFAULT NULL COMMENT '秒杀商品数',
  `stock_count` int(11) DEFAULT NULL COMMENT '剩余库存数',
  `introduction` varchar(2000) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_seckill_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_seckill_order`;
CREATE TABLE `tb_seckill_order` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `seckill_id` bigint(20) DEFAULT NULL COMMENT '秒杀商品ID',
  `money` decimal(10,2) DEFAULT NULL COMMENT '支付金额',
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户',
  `seller_id` varchar(50) DEFAULT NULL COMMENT '商家',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `status` varchar(1) DEFAULT NULL COMMENT '状态',
  `receiver_address` varchar(200) DEFAULT NULL COMMENT '收货人地址',
  `receiver_mobile` varchar(20) DEFAULT NULL COMMENT '收货人电话',
  `receiver` varchar(20) DEFAULT NULL COMMENT '收货人',
  `transaction_id` varchar(30) DEFAULT NULL COMMENT '交易流水',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_seller
-- ----------------------------
DROP TABLE IF EXISTS `tb_seller`;
CREATE TABLE `tb_seller` (
  `seller_id` varchar(100) NOT NULL COMMENT '用户ID',
  `name` varchar(80) DEFAULT NULL COMMENT '公司名',
  `nick_name` varchar(50) DEFAULT NULL COMMENT '店铺名称',
  `password` varchar(60) DEFAULT NULL COMMENT '密码',
  `email` varchar(40) DEFAULT NULL COMMENT 'EMAIL',
  `mobile` varchar(11) DEFAULT NULL COMMENT '公司手机',
  `telephone` varchar(50) DEFAULT NULL COMMENT '公司电话',
  `status` varchar(1) DEFAULT '0' COMMENT '状态',
  `address_detail` varchar(100) DEFAULT NULL COMMENT '详细地址',
  `linkman_name` varchar(50) DEFAULT NULL COMMENT '联系人姓名',
  `linkman_qq` varchar(13) DEFAULT NULL COMMENT '联系人QQ',
  `linkman_mobile` varchar(11) DEFAULT NULL COMMENT '联系人电话',
  `linkman_email` varchar(40) DEFAULT NULL COMMENT '联系人EMAIL',
  `license_number` varchar(20) DEFAULT NULL COMMENT '营业执照号',
  `tax_number` varchar(20) DEFAULT NULL COMMENT '税务登记证号',
  `org_number` varchar(20) DEFAULT NULL COMMENT '组织机构代码',
  `address` bigint(20) DEFAULT NULL COMMENT '公司地址',
  `logo_pic` varchar(100) DEFAULT NULL COMMENT '公司LOGO图',
  `brief` varchar(2000) DEFAULT NULL COMMENT '简介',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `legal_person` varchar(40) DEFAULT NULL COMMENT '法定代表人',
  `legal_person_card_id` varchar(25) DEFAULT NULL COMMENT '法定代表人身份证',
  `bank_user` varchar(50) DEFAULT NULL COMMENT '开户行账号名称',
  `bank_name` varchar(100) DEFAULT NULL COMMENT '开户行',
  PRIMARY KEY (`seller_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_specification
-- ----------------------------
DROP TABLE IF EXISTS `tb_specification`;
CREATE TABLE `tb_specification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `spec_name` varchar(255) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_specification_option
-- ----------------------------
DROP TABLE IF EXISTS `tb_specification_option`;
CREATE TABLE `tb_specification_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '规格项ID',
  `option_name` varchar(200) DEFAULT NULL COMMENT '规格项名称',
  `spec_id` bigint(30) DEFAULT NULL COMMENT '规格ID',
  `orders` int(11) DEFAULT NULL COMMENT '排序值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_type_template
-- ----------------------------
DROP TABLE IF EXISTS `tb_type_template`;
CREATE TABLE `tb_type_template` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) DEFAULT NULL COMMENT '模板名称',
  `spec_ids` varchar(1000) DEFAULT NULL COMMENT '关联规格',
  `brand_ids` varchar(1000) DEFAULT NULL COMMENT '关联品牌',
  `custom_attribute_items` varchar(2000) DEFAULT NULL COMMENT '自定义属性',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(32) NOT NULL COMMENT '密码，加密存储',
  `phone` varchar(20) DEFAULT NULL COMMENT '注册手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '注册邮箱',
  `created` datetime NOT NULL COMMENT '创建时间',
  `updated` datetime NOT NULL,
  `source_type` varchar(1) DEFAULT NULL COMMENT '会员来源：1:PC，2：H5，3：Android，4：IOS，5：WeChat',
  `nick_name` varchar(50) DEFAULT NULL COMMENT '昵称',
  `name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `status` varchar(1) DEFAULT NULL COMMENT '使用状态（Y正常 N非正常）',
  `head_pic` varchar(150) DEFAULT NULL COMMENT '头像地址',
  `qq` varchar(20) DEFAULT NULL COMMENT 'QQ号码',
  `account_balance` decimal(10,0) DEFAULT NULL COMMENT '账户余额',
  `is_mobile_check` varchar(1) DEFAULT '0' COMMENT '手机是否验证 （0否  1是）',
  `is_email_check` varchar(1) DEFAULT '0' COMMENT '邮箱是否检测（0否  1是）',
  `sex` varchar(1) DEFAULT '0' COMMENT '性别，1男，2女',
  `user_level` int(11) DEFAULT NULL COMMENT '会员等级',
  `points` int(11) DEFAULT NULL COMMENT '积分',
  `experience_value` int(11) DEFAULT NULL COMMENT '经验值',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='用户表';
