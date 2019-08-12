

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

