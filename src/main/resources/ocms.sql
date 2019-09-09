/*
 Navicat Premium Data Transfer

 Source Server         : 3306
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : ocms

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 09/09/2019 12:39:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `loginName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES (1, 'admin', '34d3e0f795e099bc978293f05cc84b91');

-- ----------------------------
-- Table structure for attribute
-- ----------------------------
DROP TABLE IF EXISTS `attribute`;
CREATE TABLE `attribute`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` int(11) NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isDel` tinyint(1) NULL DEFAULT NULL,
  `platformId` bigint(20) NULL DEFAULT NULL,
  `createdBy` bigint(20) NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `lastUpdateBy` bigint(20) NULL DEFAULT NULL,
  `lastUpdateDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for checkemail
-- ----------------------------
DROP TABLE IF EXISTS `checkemail`;
CREATE TABLE `checkemail`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `code` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `createdBy` bigint(20) NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `lastUpdatedBy` bigint(20) NULL DEFAULT NULL,
  `lastUpdateDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of checkemail
-- ----------------------------
INSERT INTO `checkemail` VALUES (30, '2502159904@qq.com', 'pN80lg', 0, NULL, '2019-06-30 09:51:41', NULL, NULL);

-- ----------------------------
-- Table structure for checker
-- ----------------------------
DROP TABLE IF EXISTS `checker`;
CREATE TABLE `checker`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `loginName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mobile` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `clientId` bigint(20) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createdBy` bigint(20) NULL DEFAULT NULL,
  `lastUpdateBy` bigint(20) NULL DEFAULT NULL,
  `lastUpdateDate` datetime(0) NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of checker
-- ----------------------------
INSERT INTO `checker` VALUES (1, 'checker', '34d3e0f795e099bc978293f05cc84b91', NULL, NULL, 1, '独孤求败', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `customerNumber` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isDel` tinyint(1) NULL DEFAULT NULL,
  `corporateName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `corporateAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contacts` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contactsTel` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contactsEmail` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isEffective` tinyint(1) NULL DEFAULT NULL,
  `introduction` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `invoiceCustomerName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `taxPayerIdentificationNum` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bank` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bankAccount` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `summary` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createdBy` bigint(20) NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `lastUpdateBy` bigint(20) NULL DEFAULT NULL,
  `lastUpdateDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES (1, 'S00001', NULL, '上海汉得信息技术股份有限公司', '中国 上海', '潇湘夜雨', '15879562456', '222@shanghaihande.com', NULL, '上海汉得信息技术有限公司(HAND Enterprise Solution Co.,Ltd.SZ:300170) 的核心团队于1996年起从事国内专业的ERP实施服务，公司设立于2002年7月，是国内成立最早、规模最 大、经验最丰富的IT咨询服务公司。', NULL, '111111111111111', NULL, '13032503165', '1111111111111111', '', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `client` VALUES (2, 'S00002', NULL, '中国电信常州分公司新北分部', '江苏 常州', '康德', '17589784569', 'kd@china.com', NULL, '中国电信集团有限公司（英文名称“China Telecom”、简称“中国电信”）成立于2000年9月，是中国特大型国有通信企业、上海世博会全球合作伙伴，连续多年入选\"世界500强企业\"，主要经营固定电话、移动通信、卫星通信、互联网接入及应用等综合信息服务。\r\n截至2011年上半年，拥有固定电话用户1.94亿户，移动电话用户（CDMA）6236万户，宽带用户 6174万户；集团公司总资产6322亿元，人员67万人。', NULL, NULL, NULL, '13023452345', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `client` VALUES (3, 'S00003', NULL, 'Google Inc.', '美国 加州', '黑格尔', '15879562035', 'heigeer@gmail.com', NULL, '谷歌公司（Google Inc.）成立于1998年9月4日，由拉里·佩奇和谢尔盖·布林共同创建，被公认为全球最大的搜索引擎公司。 [1] \r\n谷歌是一家位于美国的跨国科技企业，业务包括互联网搜索、云计算、广告技术等，同时开发并提供大量基于互联网的产品与服务，其主要利润来自于AdWords等广告服务。 [2] \r\n1999年下半年，谷歌网站“Google”正式启用。 [3]  2010年3月23日，宣布关闭在中国大陆市场搜索服务。2015年8月10日，宣布对企业架构进行调整，并创办了一家名为Alphabet的“伞形公司”（Umbrella Company），成为Alphabet旗下子公司。2015年，在2015年度“世界品牌500强”排行中重返榜首，苹果和亚马逊分别位居第二和第三名。2016年6月8日，《2016年BrandZ全球最具价值品牌百强榜》公布，以2291.98亿美元的品牌价值重新超越苹果成为百强第一。 [4]  2017年2月，Brand Finance发布2017年度全球500强品牌榜单，排名第一。 [5]  2017年6月，《2017年BrandZ最具价值全球品牌100强》公布，谷歌公司名列第一位。', '千里奔袭', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `client` VALUES (4, 'S00004', 0, 'Facebook Inc.', '美国 加州', '笛卡尔', '17896541256', 'dikaer@facebook.com', 1, 'Facebook（中文称脸书，也有译为脸谱网 [1]  ）是美国的一个社交网络服务网站 ，创立于2004年2月4日，总部位于美国加利福尼亚州门洛帕克。2012年3月6日发布Windows版桌面聊天软件Facebook Messenger [2]  。主要创始人马克·扎克伯格（Mark Zuckerberg）。\r\nFacebook是世界排名领先的照片分享站点，截至2013年11月每天上传约3.5亿张照片。截至2012年5月，Facebook拥有约9亿用户。Facebook的总部设在硅谷的门洛帕克（Menlo Park）——1 Hacker Way [3-4]  。从2006年9月11日起，任何用户输入有效电子邮件地址和自己的年龄段，即可加入。Facebook自2009年以来一直被中国屏蔽，其被禁的原因有社会和政治等方面的因素，但Facebook也从未间断与中国科技企业界的联系，期望通过投资中国科技企业等方式获得中国政府的开闸。 [5] ', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `client` VALUES (5, 'S00005', 0, 'NASA', '美国 华盛顿', '罗素', '15879634577', 'luosu@nasa.com', 1, '美国国家航空航天局（英语：National Aeronautics and Space Administration，简称NASA /ˈnæsə/），又称美国宇航局、美国太空总署，是美国联邦政府的一个行政性科研机构，负责制定、实施美国的太空计划，并开展航空科学暨太空科学的研究。 [1-2] \r\n1958年7月29日，美国总统艾森豪威尔签署了《美国公共法案85-568》，创立了美国国家航空航天局（NASA）。 [3] \r\nNASA是目前世界上最权威的航空航天科研机构，与许多国内及国际上的科研机构分享其研究数据。 [4] \r\n2018年4月16日晚发射“凌日系外行星勘测卫星”，寻找太阳系外行星，期望发现可能孕育生命的“另一个地球”。 [5] ', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `client` VALUES (6, 'S00006', 0, '无偿的组织', '江苏 徐州', '柏拉图', '18696785412', 'bolatu@xz.com', 1, '国家或国际组织无偿援助和赠送的货物，是指我国根据两国政府间的协议或临时决定，对外提供无偿援助的物资、捐赠品或我国政府、组织基于友好关系向对方国家政府、组织赠送的物资，以及我国政府接受国际组织、外国政府、组织无偿援助、捐赠或赠送的物资。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `client` VALUES (7, 'S00007', 0, '中国航空航天无限非股份公司', '中国 北京', '苏格拉底', '13456795644', 'sugeladi@ht.com', 1, '中华人民共和国的航天事业起始于1956年。中国于1970年4月24日发射第一颗人造地球卫星(见“东方红”1号)，是继苏联、美国、法国、日本之后世界上第5个能独立发射人造卫星的国家。\r\n中国发展航天事业的宗旨是：探索外太空，扩展对地球和宇宙的认识；和平利用外太空，促进人类文明和社会进步，造福全人类；满足经济建设、科技发展、国家安全和社会进步等方面的需求，提高全民科学素质，维护国家权益，增强综合国力。中国发展航天事业贯彻国家科技事业发展的指导方针，即自主创新、重点跨越、支撑发展、引领未来。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `client` VALUES (8, 'S00008', 0, '星环公司', '四川 成都', '泰勒斯', '15987962330', 'tailesi@xinghuan.com', 1, '星环号由星环集团研制，为程心专用飞船。整体呈水滴型并且可以通过轴向自转人造重力，4个球形生态区在最粗处可以将底部朝向各种方向适应各种加速度环境。在太阳系二维化的最后关头，罗辑向程心透露了星环号上搭载的曲率引擎。一旦使用空间曲率引擎，一小时左右就能达到光速。最后的两个太阳系人类程心、艾AA搭载它逃离了向二维世界跌落的太阳系，成为宇宙中最后的太阳系人类。由于达到光速的缘故，原本286光年的航程星环号只用了五十二个小时便到达了云天明送给程心的星系——DX3906。 [1] ', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `client` VALUES (9, 'S00009', 0, '行星防御理事会', '江苏 南京', '维特根斯坦', '13024568978', 'weite@weite.com', 1, '托马斯·维德，刘慈欣作品《三体III：死神永生》中的主要人物，原行星防御理事会战略情报局（PIA）首任局长。人类社会极端理智的代表人物。曾为成为执剑人刺杀程心未遂，在三体的人格分析中威慑度达到100%，且没有罗辑和程心的波动。认为兽性比人性更重要（“失去人性，失去很多；失去兽性，失去一切”）。因为对程心的承诺而放弃光速飞船的研究并交还星环城，后在太阳系联邦法庭审判中被判处死刑。', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `client` VALUES (10, 'S00010', 0, '知乎股份有限公司', '浙江 杭州', '庄周', '15789456877', 'zhuangzhou@zhihu.com', 1, '知乎是网络问答社区，连接各行各业的用户。用户分享着彼此的知识、经验和见解，为中文互联网源源不断地提供多种多样的信息。\r\n准确地讲，知乎更像一个论坛：用户围绕着某一感兴趣的话题进行相关的讨论，同时可以关注兴趣一致的人。对于概念性的解释，网络百科几乎涵盖了你所有的疑问；但是对于发散思维的整合，却是知乎的一大特色。\r\n2017年11月8日，知乎入选时代影响力·中国商业案例TOP30。 [1] \r\n2018年3月2日，北京网信办发布紧急通知，“知乎”平台因管理不严，传播违法违规信息，根据相关法律法规，要求各应用商店下架“知乎”App七天。 [2]  6月6日，原有的“知识市场”业务升级为“知乎大学”。 [3]  7月，知乎完成新一轮融资，融资额接近3亿美元。 [4] ', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `client` VALUES (11, 'S0012', NULL, 'Ufouble', '', 'hehhehehe', '15623456766', 'qq@qq.com', NULL, '', '', '', NULL, '13456789087', '', '', NULL, NULL, '2019-07-24 20:00:46', NULL, NULL);

-- ----------------------------
-- Table structure for commentonuser
-- ----------------------------
DROP TABLE IF EXISTS `commentonuser`;
CREATE TABLE `commentonuser`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `managerId` bigint(20) NULL DEFAULT NULL,
  `userId` bigint(20) NULL DEFAULT NULL,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `clientId` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of commentonuser
-- ----------------------------
INSERT INTO `commentonuser` VALUES (1, 1, 5, '这个人很懒，什么也没有留下', '2019-09-03 08:11:13', 1);

-- ----------------------------
-- Table structure for corporationadmin
-- ----------------------------
DROP TABLE IF EXISTS `corporationadmin`;
CREATE TABLE `corporationadmin`  (
  `id` bigint(20) NOT NULL,
  `loginName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mobile` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `clientId` bigint(20) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createdBy` bigint(20) NULL DEFAULT NULL,
  `lastUpdateBy` bigint(20) NULL DEFAULT NULL,
  `lastUpdateDate` datetime(0) NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of corporationadmin
-- ----------------------------
INSERT INTO `corporationadmin` VALUES (1, 'corporationadmin', '34d3e0f795e099bc978293f05cc84b91', NULL, NULL, 1, 'fly in sky', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for demand
-- ----------------------------
DROP TABLE IF EXISTS `demand`;
CREATE TABLE `demand`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位名称',
  `number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL COMMENT '0为关闭状态，1为开启状态',
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '需求描述',
  `consultantRole` bigint(20) NULL DEFAULT NULL,
  `type` bigint(20) NULL DEFAULT NULL,
  `modular` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `employTime` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `workAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isBoard` tinyint(1) NULL DEFAULT NULL,
  `startDate` datetime(0) NULL DEFAULT NULL,
  `cycle` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `duration` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `priceFluctuation` int(255) NULL DEFAULT NULL,
  `price` int(11) NULL DEFAULT NULL,
  `priceUnit` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `examineId` bigint(20) NULL DEFAULT NULL COMMENT '对应checker表',
  `examineStatus` int(11) NULL DEFAULT NULL COMMENT '审核状态，0为待审核，1为审核通过，2为审核不通过',
  `processNodeId` bigint(20) NULL DEFAULT NULL,
  `objectId` bigint(20) NOT NULL COMMENT '对应object表',
  `releaseTime` datetime(0) NULL DEFAULT NULL,
  `createdBy` bigint(20) NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `lastUpdateBy` bigint(20) NULL DEFAULT NULL,
  `lastUpdateDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `objectId`(`objectId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of demand
-- ----------------------------
INSERT INTO `demand` VALUES (2, 'ASB搬砖力士', NULL, 1, '1.SAP MM外部顾问5年以上工作经验；至少独立完成6个FullCycle实施项目； 2.思维清晰敏捷，逻辑分析能力强；具有分析、解决问题的能力； 3.掌握SAP-MM模块系统功能，熟悉了解生产订单相关的收发料业务和系统操作； 4.具备一定的项目管理经验，以及较强的文档编写和管理能力。', NULL, 1, NULL, '1', '江苏 苏州', 0, NULL, '1个月', '1-2个月', NULL, 1500, '元/天', NULL, 1, NULL, 2, '2019-07-02 15:12:47', NULL, NULL, 1, '2019-09-05 21:50:06');
INSERT INTO `demand` VALUES (3, 'AI工程师', NULL, 1, '1.SAP MM外部顾问5年以上工作经验；至少独立完成6个FullCycle实施项目； 2.思维清晰敏捷，逻辑分析能力强；具有分析、解决问题的能力； 3.掌握SAP-MM模块系统功能，熟悉了解生产订单相关的收发料业务和系统操作； 4.具备一定的项目管理经验，以及较强的文档编写和管理能力。', NULL, 2, NULL, '2', '江苏 徐州', 0, NULL, '2年', '1-2个月', NULL, 3000, '元/天', NULL, 1, NULL, 3, '2019-07-02 15:12:52', NULL, NULL, 1, '2019-09-05 21:50:07');
INSERT INTO `demand` VALUES (4, '算法工程师', NULL, 1, '1.SAP MM外部顾问5年以上工作经验；至少独立完成6个FullCycle实施项目； 2.思维清晰敏捷，逻辑分析能力强；具有分析、解决问题的能力； 3.掌握SAP-MM模块系统功能，熟悉了解生产订单相关的收发料业务和系统操作； 4.具备一定的项目管理经验，以及较强的文档编写和管理能力。', NULL, 2, NULL, '3', '江苏 镇江', 0, NULL, '5个月', '1-2个月', NULL, 1874, '元/天', NULL, 1, NULL, 4, '2019-07-02 15:12:55', NULL, NULL, 1, '2019-09-05 21:50:10');
INSERT INTO `demand` VALUES (5, '底层架构师', NULL, 0, '1.SAP MM外部顾问5年以上工作经验；至少独立完成6个FullCycle实施项目； 2.思维清晰敏捷，逻辑分析能力强；具有分析、解决问题的能力； 3.掌握SAP-MM模块系统功能，熟悉了解生产订单相关的收发料业务和系统操作； 4.具备一定的项目管理经验，以及较强的文档编写和管理能力。', NULL, 2, NULL, '4', '浙江 杭州', 1, NULL, '9个月', '1-2个月', NULL, 300, '元/天', NULL, 1, NULL, 5, '2019-07-01 15:12:59', NULL, NULL, NULL, NULL);
INSERT INTO `demand` VALUES (6, '太空的宇航员', NULL, 0, '1.SAP MM外部顾问5年以上工作经验；至少独立完成6个FullCycle实施项目； 2.思维清晰敏捷，逻辑分析能力强；具有分析、解决问题的能力； 3.掌握SAP-MM模块系统功能，熟悉了解生产订单相关的收发料业务和系统操作； 4.具备一定的项目管理经验，以及较强的文档编写和管理能力。', NULL, 3, NULL, '4', '广东 广州', 1, NULL, '2个月', '1-2个月', NULL, 9000, '元/天', NULL, 1, NULL, 6, '2019-07-02 15:13:05', NULL, NULL, NULL, NULL);
INSERT INTO `demand` VALUES (7, '需求分析师', NULL, 0, '1.SAP MM外部顾问5年以上工作经验；至少独立完成6个FullCycle实施项目； 2.思维清晰敏捷，逻辑分析能力强；具有分析、解决问题的能力； 3.掌握SAP-MM模块系统功能，熟悉了解生产订单相关的收发料业务和系统操作； 4.具备一定的项目管理经验，以及较强的文档编写和管理能力。', NULL, 3, NULL, '3', '广东 深圳', 1, NULL, '1年', '1-2个月', NULL, 4900, '元/天', NULL, 1, NULL, 7, '2019-07-02 15:13:10', NULL, NULL, NULL, NULL);
INSERT INTO `demand` VALUES (8, '数据工程师', NULL, 0, '1.SAP MM外部顾问5年以上工作经验；至少独立完成6个FullCycle实施项目； 2.思维清晰敏捷，逻辑分析能力强；具有分析、解决问题的能力； 3.掌握SAP-MM模块系统功能，熟悉了解生产订单相关的收发料业务和系统操作； 4.具备一定的项目管理经验，以及较强的文档编写和管理能力。', NULL, 3, NULL, '3', '广东 汕头', 1, NULL, '7个月', '1-2个月', NULL, 210, '元/天', NULL, 1, NULL, 8, '2019-07-02 15:13:17', NULL, NULL, NULL, NULL);
INSERT INTO `demand` VALUES (9, '物理科学家曲率引擎方向', NULL, 0, '1.SAP MM外部顾问5年以上工作经验；至少独立完成6个FullCycle实施项目； 2.思维清晰敏捷，逻辑分析能力强；具有分析、解决问题的能力； 3.掌握SAP-MM模块系统功能，熟悉了解生产订单相关的收发料业务和系统操作； 4.具备一定的项目管理经验，以及较强的文档编写和管理能力。', NULL, 1, NULL, '2', '中国 上海', 1, NULL, '15个月', '1-2个月', NULL, 2345, '元/天', NULL, 1, NULL, 9, '2019-07-02 15:13:21', NULL, NULL, NULL, NULL);
INSERT INTO `demand` VALUES (10, '执剑人与面壁者', NULL, 0, '1.SAP MM外部顾问5年以上工作经验；至少独立完成6个FullCycle实施项目； 2.思维清晰敏捷，逻辑分析能力强；具有分析、解决问题的能力； 3.掌握SAP-MM模块系统功能，熟悉了解生产订单相关的收发料业务和系统操作； 4.具备一定的项目管理经验，以及较强的文档编写和管理能力。', NULL, 1, NULL, '2', '山东 济南', 1, NULL, '8个月', '1-2个月', NULL, 3123, '元/天', NULL, 1, NULL, 10, '2019-07-02 15:13:24', NULL, NULL, NULL, NULL);
INSERT INTO `demand` VALUES (11, 'Assassin', NULL, 0, '1.SAP MM外部顾问5年以上工作经验；至少独立完成6个FullCycle实施项目； 2.思维清晰敏捷，逻辑分析能力强；具有分析、解决问题的能力； 3.掌握SAP-MM模块系统功能，熟悉了解生产订单相关的收发料业务和系统操作； 4.具备一定的项目管理经验，以及较强的文档编写和管理能力。', NULL, 0, NULL, '0', '四川 成都', 1, NULL, '1个月', '1-2个月', NULL, 899, '元/天', NULL, 1, NULL, 11, '2019-07-02 15:13:26', NULL, NULL, NULL, NULL);
INSERT INTO `demand` VALUES (12, 'Java Web工程师', NULL, 0, '1.SAP MM外部顾问5年以上工作经验；至少独立完成6个FullCycle实施项目； 2.思维清晰敏捷，逻辑分析能力强；具有分析、解决问题的能力； 3.掌握SAP-MM模块系统功能，熟悉了解生产订单相关的收发料业务和系统操作； 4.具备一定的项目管理经验，以及较强的文档编写和管理能力。', NULL, 0, NULL, '0', '中国 天津', 0, NULL, '2个月', '1-2个月', NULL, 998, '元/天', NULL, 1, NULL, 12, '2019-07-02 15:13:29', NULL, NULL, NULL, NULL);
INSERT INTO `demand` VALUES (13, '摸鱼的人', NULL, 0, '1.SAP MM外部顾问5年以上工作经验；至少独立完成6个FullCycle实施项目； 2.思维清晰敏捷，逻辑分析能力强；具有分析、解决问题的能力； 3.掌握SAP-MM模块系统功能，熟悉了解生产订单相关的收发料业务和系统操作； 4.具备一定的项目管理经验，以及较强的文档编写和管理能力。', NULL, 1, NULL, '1', '江苏 南京', 0, NULL, '2个月', '1-3世纪', NULL, 2500, '元/天', NULL, 1, NULL, 12, '2019-07-07 20:19:21', NULL, NULL, NULL, NULL);
INSERT INTO `demand` VALUES (15, '无限剑制', 'SDM', 1, '布拉布拉', NULL, 0, '自动化、光电', '0', '江苏 南京', 1, '2019-08-12 08:00:00', '2周', '2年', 100, 3100, '元/天', 1, 1, NULL, 1, NULL, NULL, '2019-08-26 20:21:47', 1, '2019-09-05 22:31:34');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `loginName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mobile` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `clientId` bigint(20) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createdBy` bigint(20) NULL DEFAULT NULL,
  `lastUpdateBy` bigint(20) NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `lastUpdateDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES (1, 'manager', '34d3e0f795e099bc978293f05cc84b91', NULL, NULL, 1, '云天明', NULL, NULL, NULL, NULL);
INSERT INTO `manager` VALUES (2, 'manager2', '34d3e0f795e099bc978293f05cc84b91', NULL, NULL, 2, '远坂凛', NULL, NULL, NULL, NULL);
INSERT INTO `manager` VALUES (3, 'manager3', '34d3e0f795e099bc978293f05cc84b91', NULL, NULL, 3, '远坂凛！', NULL, NULL, NULL, NULL);
INSERT INTO `manager` VALUES (4, 'manager4', '34d3e0f795e099bc978293f05cc84b91', NULL, NULL, 4, '远坂凛@', NULL, NULL, NULL, NULL);
INSERT INTO `manager` VALUES (5, 'manager5', '34d3e0f795e099bc978293f05cc84b91', NULL, NULL, 5, '远坂凛#', NULL, NULL, NULL, NULL);
INSERT INTO `manager` VALUES (6, 'manager6', '34d3e0f795e099bc978293f05cc84b91', NULL, NULL, 6, '远坂凛￥', NULL, NULL, NULL, NULL);
INSERT INTO `manager` VALUES (7, 'manager7', '34d3e0f795e099bc978293f05cc84b91', NULL, NULL, 7, '远坂凛%', NULL, NULL, NULL, NULL);
INSERT INTO `manager` VALUES (8, 'manager8', '34d3e0f795e099bc978293f05cc84b91', NULL, NULL, 8, '远坂凛^', NULL, NULL, NULL, NULL);
INSERT INTO `manager` VALUES (9, 'manager9', '34d3e0f795e099bc978293f05cc84b91', NULL, NULL, 9, '远坂凛&', NULL, NULL, NULL, NULL);
INSERT INTO `manager` VALUES (10, 'manager10', '34d3e0f795e099bc978293f05cc84b91', NULL, NULL, 10, '远坂凛+', NULL, NULL, NULL, NULL);
INSERT INTO `manager` VALUES (11, 'manager11', '34d3e0f795e099bc978293f05cc84b91', NULL, NULL, 12, '远坂凛++', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for messagefromcheckertomanager
-- ----------------------------
DROP TABLE IF EXISTS `messagefromcheckertomanager`;
CREATE TABLE `messagefromcheckertomanager`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `demandId` bigint(20) NOT NULL,
  `checkerId` bigint(20) NOT NULL,
  `managerId` bigint(20) NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isRead` tinyint(1) NULL DEFAULT NULL,
  `examineStatus` tinyint(1) NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of messagefromcheckertomanager
-- ----------------------------
INSERT INTO `messagefromcheckertomanager` VALUES (3, 15, 1, 1, 'xiedebucuo', 0, 1, '2019-08-28 14:30:11');

-- ----------------------------
-- Table structure for object
-- ----------------------------
DROP TABLE IF EXISTS `object`;
CREATE TABLE `object`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目的名称',
  `number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `managerId` bigint(20) NULL DEFAULT NULL COMMENT '项目经理，对应manager表',
  `startDate` datetime(0) NULL DEFAULT NULL,
  `endDate` datetime(0) NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL COMMENT '项目的状态，0为已经删除，1为未删除',
  `clientId` bigint(20) NOT NULL COMMENT '对应client表',
  `createdBy` bigint(20) NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `lastUpdateBy` bigint(20) NULL DEFAULT NULL,
  `lastUpdateDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `customerId`(`clientId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of object
-- ----------------------------
INSERT INTO `object` VALUES (1, '上海汉得-外协项目管理', 'P12345678772', 1, '2019-07-03 08:00:00', '2019-07-10 08:00:00', 1, 1, NULL, NULL, NULL, NULL);
INSERT INTO `object` VALUES (2, '中国电信', 'P12345672', 2, '2019-07-01 20:54:53', '2019-07-27 20:54:58', 0, 2, NULL, NULL, NULL, NULL);
INSERT INTO `object` VALUES (3, 'Deep Mind-Alpha go', 'P12345600', 3, '2019-07-01 20:55:09', '2019-07-19 20:55:14', 0, 3, NULL, NULL, NULL, NULL);
INSERT INTO `object` VALUES (4, 'Google-Tensor Flow', 'P12345601', 3, '2019-07-01 20:55:19', '2019-07-27 20:55:24', 0, 3, NULL, NULL, NULL, NULL);
INSERT INTO `object` VALUES (5, 'Node.js/React Native', 'P12345602', 4, '2019-07-15 20:55:30', '2019-07-27 20:55:36', 1, 4, NULL, NULL, NULL, NULL);
INSERT INTO `object` VALUES (6, 'NASA-载人航天登陆火星', 'P12345603', 5, '2019-07-15 20:55:40', '2019-07-27 20:55:44', 1, 5, NULL, NULL, NULL, NULL);
INSERT INTO `object` VALUES (7, '图书管理系统', 'P12345604', 6, '2019-07-15 20:55:50', '2019-07-27 20:55:54', 1, 6, NULL, NULL, NULL, NULL);
INSERT INTO `object` VALUES (8, '中国航天-神舟载人飞船', 'P12345605', 7, '2019-07-02 20:55:58', '2019-07-27 20:56:02', 0, 7, NULL, NULL, NULL, NULL);
INSERT INTO `object` VALUES (9, '黑域项目', 'P12345606', 8, '2019-07-02 20:56:06', '2019-08-23 20:56:13', 1, 8, NULL, NULL, NULL, NULL);
INSERT INTO `object` VALUES (10, '危机纪元-掩体计划', 'P12345607', 9, '2019-07-08 20:56:18', '2019-07-27 20:56:22', 0, 9, NULL, NULL, NULL, NULL);
INSERT INTO `object` VALUES (11, '追捕“启示录”号', 'P12345608', 9, '2019-07-08 20:56:27', '2019-08-02 20:56:30', 1, 9, NULL, NULL, NULL, NULL);
INSERT INTO `object` VALUES (12, '知乎网后台搭建hhh', 'P12345609', 10, '2019-06-24 08:00:00', '2019-08-04 08:00:00', 1, 10, NULL, NULL, NULL, NULL);
INSERT INTO `object` VALUES (13, '沙漠植树', 'ytm', 1, '2019-08-04 08:00:00', '2019-08-22 08:00:00', 0, 1, NULL, '2019-08-18 14:26:07', NULL, NULL);
INSERT INTO `object` VALUES (14, '保护大熊猫', 'ytm2', 1, '2019-08-04 08:00:00', '2019-08-29 08:00:00', 1, 1, NULL, '2019-08-19 20:34:48', NULL, NULL);

-- ----------------------------
-- Table structure for processnode
-- ----------------------------
DROP TABLE IF EXISTS `processnode`;
CREATE TABLE `processnode`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `clientId` bigint(20) NOT NULL,
  `checkerId` bigint(20) NOT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `createBy` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of processnode
-- ----------------------------
INSERT INTO `processnode` VALUES (9, 1, 1, '2019-08-22 17:00:30', NULL);
INSERT INTO `processnode` VALUES (10, 2, 1, '2019-09-02 16:05:38', NULL);
INSERT INTO `processnode` VALUES (11, 3, 1, '2019-09-02 16:05:50', NULL);

-- ----------------------------
-- Table structure for resume
-- ----------------------------
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mobile` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `idNumber` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qq` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `employYears` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `goodAt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `estimateLevel` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `planDate` datetime(0) NULL DEFAULT NULL,
  `communicateDate` datetime(0) NULL DEFAULT NULL,
  `isBeingUsed` tinyint(1) NULL DEFAULT NULL,
  `communicatePerson` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `employNumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `idealSalary` int(10) NULL DEFAULT NULL,
  `birth` datetime(0) NULL DEFAULT NULL,
  `degree` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `priceUnit` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `school` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` tinyint(1) NULL DEFAULT NULL,
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `otherInfo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createdBy` bigint(20) NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `lastUpdateBy` bigint(20) NULL DEFAULT NULL,
  `lastUpdateDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resume
-- ----------------------------
INSERT INTO `resume` VALUES (5, '15396808623', '320381199807261819', '吴留承', '2502159904@qq.com', '2502159904', '100年', 'Java', 'SSSSS级', '2019-06-01 00:00:00', '2019-06-05 00:00:00', 1, '千子村正', 'HGLHJK', 10, '2019-06-15 00:00:00', '本科', '元/天', '常州工学院', 1, '江苏省常州市新北区', '多年以后，在面临生命的终结的时候，吴留承可能会想起自己毫无意义的开始写《心灵起源的那个晚上。这个晚上所做的事情并非即兴的想法，而是自高中时代就有的念头。可能是当时看过了几本现在已经忘了差不多的书，觉得自己有写东西的天赋，就萌生了这个念头。现在是2019年了，就自身而言，从小的尺度来看，笔者本人还有一年大学毕业了。从大的尺度来说，为什么笔者要说这些看起来没用任何意义的那么大尺度的时间。因为笔者太无聊了吧。什么是永恒，是时间的无限延续吗，还是没有了时间这个尺度。时间真的存在过吗.', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for signup
-- ----------------------------
DROP TABLE IF EXISTS `signup`;
CREATE TABLE `signup`  (
  `userId` bigint(20) NOT NULL,
  `demandId` bigint(20) NOT NULL,
  `status` int(11) NULL DEFAULT NULL,
  `createdBy` bigint(20) NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `lastUpdateBy` bigint(20) NULL DEFAULT NULL,
  `lastUpdateDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`userId`, `demandId`) USING BTREE,
  INDEX `demandId`(`demandId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of signup
-- ----------------------------
INSERT INTO `signup` VALUES (5, 2, 0, NULL, '2019-07-07 10:00:42', 1, '2019-09-06 21:34:58');
INSERT INTO `signup` VALUES (5, 4, 1, NULL, '2019-07-07 20:05:59', 1, '2019-09-06 21:35:10');
INSERT INTO `signup` VALUES (5, 7, 1, NULL, '2019-07-07 06:42:23', NULL, NULL);
INSERT INTO `signup` VALUES (5, 10, 1, NULL, '2019-07-07 21:24:41', NULL, NULL);
INSERT INTO `signup` VALUES (5, 11, 1, NULL, '2019-07-07 21:24:35', NULL, NULL);

-- ----------------------------
-- Table structure for upload
-- ----------------------------
DROP TABLE IF EXISTS `upload`;
CREATE TABLE `upload`  (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `path` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createdBy` bigint(20) NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  `lastUpdateBy` bigint(20) NULL DEFAULT NULL,
  `lastUpdateDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for userbindtodemand
-- ----------------------------
DROP TABLE IF EXISTS `userbindtodemand`;
CREATE TABLE `userbindtodemand`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `demandId` bigint(20) NULL DEFAULT NULL,
  `userId` bigint(20) NULL DEFAULT NULL,
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '0表示需求结束，1表示正在工作中',
  `createBy` bigint(20) NULL DEFAULT NULL COMMENT '外协专员id',
  `createDate` datetime(0) NULL DEFAULT NULL,
  `lastUpdateDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userbindtodemand
-- ----------------------------
INSERT INTO `userbindtodemand` VALUES (4, 2, 5, 1, 1, '2019-09-06 21:34:58', NULL);

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `loginName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createdBy` bigint(20) NULL DEFAULT NULL,
  `lastUpdateBy` bigint(20) NULL DEFAULT NULL,
  `lastUpdateDate` datetime(0) NULL DEFAULT NULL,
  `createDate` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (5, 'wlc', 'c81088bf7385d71488035b73d453a4f7', '2502159904@qq.com', NULL, NULL, NULL, '2019-06-25 21:18:57');

SET FOREIGN_KEY_CHECKS = 1;
