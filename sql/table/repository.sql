CREATE TABLE `repository` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
);

INSERT INTO `repository` VALUES
(1,'主仓库','安徽合肥',1),
(2,'副仓库','福建福州',1);