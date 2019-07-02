CREATE TABLE `supplierWater` (
  `supplierID` int(11) NOT NULL,
  `waterID` int(11) NOT NULL,
  PRIMARY KEY (`supplierID`,`waterID`),
  FOREIGN KEY (`supplierID`) REFERENCES `supplier` (`ID`),
  FOREIGN KEY (`waterID`) REFERENCES `water` (`ID`)
);

INSERT INTO `supplierWater` VALUES
(1,1),
(2,1),
(2,2),
(1,3),
(1,4),
(3,5),
(2,6),
(4,6),
(5,7),
(7,8),
(8,9),
(6,10),
(6,11),
(10,11),
(9,12),
(18,14);