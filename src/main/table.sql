

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