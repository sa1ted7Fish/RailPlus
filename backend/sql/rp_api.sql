/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : railplus

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 11/12/2023 17:23:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rp_api
-- ----------------------------
DROP TABLE IF EXISTS `rp_api`;
CREATE TABLE `rp_api`  (
  `api_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `api_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `api` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `api_params` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `method` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`api_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rp_api
-- ----------------------------
INSERT INTO `rp_api` VALUES ('2e73cd5c-2840-404c-9614-7a4da38586b8', '语言占比情况', 'http://localhost:8080/data/lp', '[{\"paramName\":\"country\",\"default\":\"China\"}]', 'get');
INSERT INTO `rp_api` VALUES ('de9891b1-e0b4-439c-8acc-ef17873d29f0', '商品出租情况', 'http://localhost:8080/data/r', '[{\"paramName\":\"date\",\"default\":\"2005-05\"}]', 'get');

SET FOREIGN_KEY_CHECKS = 1;
