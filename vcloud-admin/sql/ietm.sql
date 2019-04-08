/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : ietm

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 08/04/2019 11:02:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `module` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `action` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `exception` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
  `create_date` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uid` bigint(20) NULL DEFAULT NULL,
  `ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13402 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (13399, '登录', '登录', NULL, '2019-04-02 16:21:47', 1, '192.168.4.154');
INSERT INTO `sys_log` VALUES (13400, '登录', '登录', NULL, '2019-04-02 16:27:10', NULL, '192.168.4.154');
INSERT INTO `sys_log` VALUES (13401, '登录', '登录', NULL, '2019-04-08 10:35:20', 1, '192.168.4.154');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `enable` bit(1) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `handle` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `permission_key` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `resource` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `weight` int(11) NULL DEFAULT NULL,
  `parent_id` bigint(20) NULL DEFAULT NULL,
  `icon` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKarkyg4p1bouosuixjo7rebdjn`(`parent_id`) USING BTREE,
  CONSTRAINT `sys_permission_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `sys_permission` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, b'1', '系统管理', NULL, NULL, NULL, 'system', '', NULL, NULL, NULL, NULL);
INSERT INTO `sys_permission` VALUES (2, b'1', '菜单管理', 'system:permission:list', 'list', NULL, 'system', 'permission', NULL, NULL, 1, NULL);
INSERT INTO `sys_permission` VALUES (3, b'1', '角色管理', 'system:role:list', 'list', NULL, 'system', 'role', NULL, NULL, 1, NULL);
INSERT INTO `sys_permission` VALUES (4, b'1', '用户管理', 'system:user:list', 'list', NULL, 'system', 'user', NULL, NULL, 1, NULL);
INSERT INTO `sys_permission` VALUES (5, b'1', '创建', 'system:user:add', 'add', NULL, 'system', 'user', NULL, NULL, 4, NULL);
INSERT INTO `sys_permission` VALUES (6, b'1', '编辑', 'system:user:update', 'update', NULL, 'system', 'user', NULL, NULL, 4, NULL);
INSERT INTO `sys_permission` VALUES (7, b'1', '删除', 'system:user:delete', 'delete', NULL, 'system', 'user', NULL, NULL, 4, NULL);
INSERT INTO `sys_permission` VALUES (8, b'1', '创建', 'system:role:add', 'add', NULL, 'system', 'role', NULL, NULL, 3, NULL);
INSERT INTO `sys_permission` VALUES (9, b'1', '编辑', 'system:role:update', 'update', NULL, 'system', 'role', NULL, NULL, 3, NULL);
INSERT INTO `sys_permission` VALUES (10, b'1', '删除', 'system:role:delete', 'delete', NULL, 'system', 'role', NULL, NULL, 3, NULL);
INSERT INTO `sys_permission` VALUES (11, b'1', '创建', 'system:permission:add', 'add', NULL, 'system', 'permission', NULL, NULL, 2, NULL);
INSERT INTO `sys_permission` VALUES (12, b'1', '编辑', 'system:permission:update', 'update', NULL, 'system', 'permission', NULL, NULL, 2, NULL);
INSERT INTO `sys_permission` VALUES (13, b'1', '删除', 'system:permission:delete', 'delete', NULL, 'system', 'permission', NULL, NULL, 2, NULL);
INSERT INTO `sys_permission` VALUES (14, b'1', '系统日志', 'system:log:list', 'list', NULL, 'system', 'log', NULL, NULL, 1, NULL);
INSERT INTO `sys_permission` VALUES (15, b'1', '测试', 'system:test:list', 'list', NULL, 'system', 'test', NULL, NULL, 1, NULL);
INSERT INTO `sys_permission` VALUES (16, b'1', '创建', 'system:test:add', 'list', NULL, 'system', 'test', NULL, NULL, 15, NULL);
INSERT INTO `sys_permission` VALUES (17, b'1', '编辑', 'system:test:update', 'list', NULL, 'system', 'test', NULL, NULL, 15, NULL);
INSERT INTO `sys_permission` VALUES (18, b'1', '删除', 'system:test:delete', 'list', NULL, 'system', 'test', NULL, NULL, 15, NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `enable` bit(1) NULL DEFAULT NULL,
  `role_key` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `role_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_iace11lm41qsi7dstkaiecion`(`role_key`) USING BTREE,
  UNIQUE INDEX `UK_eu9uvi1fl9j2kmtul6bmcu0mh`(`role_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '拥有系统全部权限，请谨慎分配。', b'1', 'admin', '管理员');
INSERT INTO `sys_role` VALUES (2, '普通用户', b'1', 'normal', '普通');
INSERT INTO `sys_role` VALUES (3, '测试', b'1', 'test', '普通用户');
INSERT INTO `sys_role` VALUES (4, '只有用户权限', b'1', 'user', '用户');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`, `permission_id`) USING BTREE,
  INDEX `FK6l1rpsk0jgvg41t538728fjm4`(`permission_id`) USING BTREE,
  CONSTRAINT `sys_role_permission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `sys_role_permission_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `sys_permission` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES (1, 1);
INSERT INTO `sys_role_permission` VALUES (3, 1);
INSERT INTO `sys_role_permission` VALUES (4, 1);
INSERT INTO `sys_role_permission` VALUES (1, 2);
INSERT INTO `sys_role_permission` VALUES (1, 3);
INSERT INTO `sys_role_permission` VALUES (1, 4);
INSERT INTO `sys_role_permission` VALUES (4, 4);
INSERT INTO `sys_role_permission` VALUES (1, 5);
INSERT INTO `sys_role_permission` VALUES (4, 5);
INSERT INTO `sys_role_permission` VALUES (1, 6);
INSERT INTO `sys_role_permission` VALUES (4, 6);
INSERT INTO `sys_role_permission` VALUES (1, 7);
INSERT INTO `sys_role_permission` VALUES (4, 7);
INSERT INTO `sys_role_permission` VALUES (1, 8);
INSERT INTO `sys_role_permission` VALUES (1, 9);
INSERT INTO `sys_role_permission` VALUES (1, 10);
INSERT INTO `sys_role_permission` VALUES (1, 11);
INSERT INTO `sys_role_permission` VALUES (1, 12);
INSERT INTO `sys_role_permission` VALUES (1, 13);
INSERT INTO `sys_role_permission` VALUES (1, 14);
INSERT INTO `sys_role_permission` VALUES (3, 14);
INSERT INTO `sys_role_permission` VALUES (1, 15);
INSERT INTO `sys_role_permission` VALUES (3, 15);
INSERT INTO `sys_role_permission` VALUES (1, 16);
INSERT INTO `sys_role_permission` VALUES (3, 16);
INSERT INTO `sys_role_permission` VALUES (1, 17);
INSERT INTO `sys_role_permission` VALUES (3, 17);
INSERT INTO `sys_role_permission` VALUES (1, 18);

-- ----------------------------
-- Table structure for sys_test
-- ----------------------------
DROP TABLE IF EXISTS `sys_test`;
CREATE TABLE `sys_test`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `age` bigint(20) NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_test
-- ----------------------------
INSERT INTO `sys_test` VALUES (1, 'test', 19, '星火路4号');
INSERT INTO `sys_test` VALUES (2, 'test', 19, '星火路4号');
INSERT INTO `sys_test` VALUES (3, 'test', 19, '星火路4号');
INSERT INTO `sys_test` VALUES (4, 'test', 19, '星火路4号');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `enable` bit(1) NULL DEFAULT NULL,
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `tel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `avatar` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_dxesfklauarqhov4147i100ud`(`account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', b'1', '$2a$10$ItmuMLR4wUb5jjkBzg/CwuQADK7d9qbU725e.KyT/lLJEZeykDL62', '13203314875', '管理员', '');
INSERT INTO `sys_user` VALUES (7, 'admin123', b'1', '$2a$10$ItmuMLR4wUb5jjkBzg/CwuQADK7d9qbU725e.KyT/lLJEZeykDL62', '13203314875', '管理员', '');
INSERT INTO `sys_user` VALUES (8, 'test', b'1', '$2a$10$ItmuMLR4wUb5jjkBzg/CwuQADK7d9qbU725e.KyT/lLJEZeykDL62', '18676037292', 'test', '');
INSERT INTO `sys_user` VALUES (9, 'admin1', b'1', '$2a$10$ItmuMLR4wUb5jjkBzg/CwuQADK7d9qbU725e.KyT/lLJEZeykDL62', '15600000000', '测试账户1', NULL);
INSERT INTO `sys_user` VALUES (12, 'test1', NULL, '$2a$10$g6nwmvlVSh1s1ybQUakEFOpE6/SRQSf2UQmlix2tJ8jWtH2HO/9oO', NULL, '管理员1111111', NULL);
INSERT INTO `sys_user` VALUES (13, 'test11111', NULL, '$2a$10$EwvsuERL1ImPqRtOwSygMOB1eB5uUMDi0pLewW8Ai.wsU3vuAPi4S', NULL, '管理员', NULL);
INSERT INTO `sys_user` VALUES (14, 'test1111112', NULL, '$2a$10$Gn48QVP9pG1D3lKtAgiuUO8qhaNWT6SyQCSb/MYRmGpUUbRFrWurG', NULL, '管理员123123', NULL);
INSERT INTO `sys_user` VALUES (18, 'test222', NULL, '$2a$10$uwuHF6yn2iTohSnmgO5zSeVg2o4sElFfG3u69wZvNy0zEopL7FGA.', NULL, '管理员2', NULL);
INSERT INTO `sys_user` VALUES (19, 'test22122', NULL, '$2a$10$xpZom6xHSL3QITQKN95eIOX3YkO4CJGLDv30Q6KLFCslUprVYpZsW', NULL, '管理员22', NULL);
INSERT INTO `sys_user` VALUES (23, 'test311', NULL, '$2a$10$Bw4O36yXyW15f.n/UmzQzu6N3bZgqoXPnMRBVvDf4WmChlaHlVeui', NULL, '管理员22', NULL);
INSERT INTO `sys_user` VALUES (24, 'test2', NULL, '$2a$10$Ob7ySv8bjS2AQ5/VNUrdNOfqy8ARpXXFaiiu8Y9i563DTQ.Yk7IGK', NULL, '管理员22', NULL);
INSERT INTO `sys_user` VALUES (25, 'test3', NULL, '$2a$10$bpbc1vW2BTBjH/EMQHjoGOtwmthLrRkYfM9I7GOX5DXdVhuIQfNFi', NULL, '管理员22', NULL);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE,
  INDEX `FKnviybsn4jexeg8t4n0n4bagi5`(`role_id`) USING BTREE,
  CONSTRAINT `sys_user_role_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `sys_user_role_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `icloud_sys_user` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (13, 2);
INSERT INTO `sys_user_role` VALUES (14, 2);
INSERT INTO `sys_user_role` VALUES (18, 2);
INSERT INTO `sys_user_role` VALUES (19, 2);
INSERT INTO `sys_user_role` VALUES (23, 2);
INSERT INTO `sys_user_role` VALUES (24, 2);
INSERT INTO `sys_user_role` VALUES (25, 2);
INSERT INTO `sys_user_role` VALUES (26, 2);
INSERT INTO `sys_user_role` VALUES (8, 3);
INSERT INTO `sys_user_role` VALUES (9, 4);

SET FOREIGN_KEY_CHECKS = 1;
