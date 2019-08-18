
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除，0表示未删除，1表示删除',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `user_name` varchar(256) NOT NULL DEFAULT '' COMMENT '用户名称',
  `password` varchar(32) NOT NULL DEFAULT '' COMMENT '登录密码',
  `openid` varchar(32) NOT NULL DEFAULT '' COMMENT '小程序返回的用户openid',
  `mobile` varchar(11) NOT NULL DEFAULT '' COMMENT '用户手机号',
  `nick_name` varchar(32) NOT NULL DEFAULT '' COMMENT '昵称',
  `gender` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0 未知，1男，2女',
  `email` varchar(32) NOT NULL DEFAULT '' COMMENT '用户邮箱',
  `third_session_id` varchar(128) DEFAULT '' COMMENT '本来这个值应该放缓存，只好用数据库暂代一下',
  `creater` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人',
  `modifier` varchar(32) NOT NULL DEFAULT '' COMMENT '修改人',
  `avatar_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '头像',
  `city` varchar(32) NOT NULL DEFAULT '' COMMENT '市',
  `country` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '国家（China 中国）',
  `language` varchar(32) NOT NULL COMMENT '语言（zh_CN 中文）',
  `province` varchar(32) NOT NULL DEFAULT '' COMMENT '省',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

CREATE TABLE `passenger_publish_msg` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除，0表示未删除，1表示删除',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `openid` varchar(32) NOT NULL DEFAULT '' COMMENT '小程序用户openid',
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '乘客出发时间',
  `start` varchar(64) NOT NULL DEFAULT '' COMMENT '起始地址',
  `end` varchar(64) NOT NULL DEFAULT '' COMMENT '到达地址',
  `person_num` tinyint(4) NOT NULL DEFAULT '0' COMMENT '人数',
  `phone` varchar(11) NOT NULL DEFAULT '' COMMENT '乘客联系手机号',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '可接受价',
  `note` varchar(256) NOT NULL DEFAULT '' COMMENT '备注',
  `is_complete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0表示未完成，1表示为已完成订单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='乘客发布信息表';


DROP TABLE IF EXISTS `passenger_publish_msg_address`;
CREATE TABLE `passenger_publish_msg_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除，0表示未删除，1表示删除',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
	`type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0表示出发地址，1表示到达地址',
	`msg_id` bigint(20) NOT NULL COMMENT 'publish_msg表主键',
	`name` varchar(64) NOT NULL DEFAULT '' COMMENT '地址名称',
	`address` varchar(64) NOT NULL DEFAULT '' COMMENT '详细地址',
	`longitude` decimal(12,8) NOT NULL DEFAULT '0.00' COMMENT '经度',
	`latitude` decimal(12,8) NOT NULL DEFAULT '0.00' COMMENT '纬度',
	`nation` varchar(12) NOT NULL DEFAULT '' COMMENT '国家',
	`province` varchar(12) NOT NULL DEFAULT '' COMMENT '省',
	`city` varchar(12) NOT NULL DEFAULT '' COMMENT '市',
	`district` varchar(12) NOT NULL DEFAULT '' COMMENT '区',
	`street` varchar(12) NOT NULL DEFAULT '' COMMENT '路',
	`street_number` varchar(12) NOT NULL DEFAULT '' COMMENT '路号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='乘客发布信息——详细地址表';


CREATE TABLE `driver` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `car_name` varchar(32) NOT NULL DEFAULT '' COMMENT '车辆信息',
  `car_color` varchar(32) NOT NULL DEFAULT '' COMMENT '车辆颜色',
  `car_number` varchar(32) NOT NULL DEFAULT '' COMMENT '车牌号',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户id',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `creater` varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '创建人',
  `modifier` varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `order` (
  `id` bigint(20) NOT NULL,
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除，0表示未删除，1表示删除',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `creater` varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '创建人',
  `modifier` varchar(32) CHARACTER SET utf8mb4 NOT NULL DEFAULT '' COMMENT '修改人',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '金额',
  `start_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `end_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `start_site` varchar(64) NOT NULL DEFAULT '' COMMENT '起点',
  `end_site` varchar(64) NOT NULL DEFAULT '' COMMENT '终点',
  `seats` tinyint(3) NOT NULL DEFAULT '0' COMMENT '余座',
  `mobile` varchar(32) NOT NULL DEFAULT '',
  `remark` varchar(255) NOT NULL DEFAULT '' COMMENT '备注',
  `type` tinyint(3) NOT NULL DEFAULT '1' COMMENT '类型：1乘客，2司机',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '发布人',
  `driver_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '接单者id',
  `pay_status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '0：未支付，1：已支付；2支付失败',
  `settlement_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '结算金额',
  `status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '订单状态：0发布中，1已结单，2已完成，3已结算',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `driver_publish_msg`;
CREATE TABLE `driver_publish_msg` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除，0表示未删除，1表示删除',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `openid` varchar(32) NOT NULL DEFAULT '' COMMENT '小程序用户openid',
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '乘客出发时间',
  `start` varchar(64) NOT NULL DEFAULT '' COMMENT '起始地址',
  `end` varchar(64) NOT NULL DEFAULT '' COMMENT '到达地址',
  `surplus_seat` tinyint(4) NOT NULL DEFAULT '0' COMMENT '余座',
  `phone` varchar(11) NOT NULL DEFAULT '' COMMENT '乘客联系手机号',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '可接受价',
  `note` varchar(256) NOT NULL DEFAULT '' COMMENT '备注',
	`car_info` varchar(16) NOT NULL DEFAULT '' COMMENT '车辆品牌型号颜色',
	`car_num` varchar(16) NOT NULL DEFAULT '' COMMENT '车牌号',
	`is_complete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0表示未完成，1表示为已完成订单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='司机发布信息表';


DROP TABLE IF EXISTS `driver_publish_msg_address`;
CREATE TABLE `driver_publish_msg_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除，0表示未删除，1表示删除',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0表示出发地址，1表示到达地址',
  `msg_id` bigint(20) NOT NULL COMMENT 'publish_msg表主键',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '地址名称',
  `address` varchar(64) NOT NULL DEFAULT '' COMMENT '详细地址',
  `longitude` decimal(12,8) NOT NULL DEFAULT '0.00000000' COMMENT '经度',
  `latitude` decimal(12,8) NOT NULL DEFAULT '0.00000000' COMMENT '纬度',
  `nation` varchar(12) NOT NULL DEFAULT '' COMMENT '国家',
  `province` varchar(12) NOT NULL DEFAULT '' COMMENT '省',
  `city` varchar(12) NOT NULL DEFAULT '' COMMENT '市',
  `district` varchar(12) NOT NULL DEFAULT '' COMMENT '区',
  `street` varchar(12) NOT NULL DEFAULT '' COMMENT '路',
  `street_number` varchar(12) NOT NULL DEFAULT '' COMMENT '路号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='司机发布信息——详细地址表';

DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除，0表示未删除，1表示删除',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `openid` varchar(32) NOT NULL DEFAULT '' COMMENT '用户openid',
	`course_id` bigint(20) NOT NULL COMMENT '对应publish_msg表主键',
	`course_type` tinyint(4) NOT NULL COMMENT '0: 乘客行程， 1：司机行程',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户收藏行程表';

