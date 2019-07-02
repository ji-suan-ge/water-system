CREATE TABLE `stock` (
  `repositoryID` int(11) NOT NULL AUTO_INCREMENT,
  `waterID` int(11) NOT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`repositoryID`,`waterID`),
  FOREIGN KEY (`repositoryID`) REFERENCES `repository` (`ID`),
  FOREIGN KEY (`waterID`) REFERENCES `water` (`ID`)
);

INSERT INTO `stock` VALUES
(1,1,34),
(1,2,16),
(1,3,476),
(1,4,0),
(1,5,280),
(1,6,60),
(1,7,150),
(1,8,0),
(1,9,0),
(1,10,0),
(1,11,0),
(1,12,0),
(1,13,0),
(1,14,0);