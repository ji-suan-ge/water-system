[TOC]

# 一、系统开发概述

# 二、系统规划

# 三、需求分析

# 四、数据库逻辑设计


## 4.1 E-R 图

![ER图](./image/ER.svg)

## 4.2 数据项

| 数据项      | 类型  | 长度 | 备注                                                         |
| ----------- | ----- | ---- | ------------------------------------------------------------ |
| 客户编号    | INT   | -    | 自动递增，不能为 Null                                        |
| 联系人姓名  | VCHAR | 30   | 不能为 Null，联系人姓名可以重复                              |
| 客户地址    | VCHAR | 200  | -                                                            |
| 联系电话    | VCHAR | 11   | -                                                            |
| 订单号      | INT   | -    | 自动递增，订单号是唯一的                                     |
| 处理时间    | TIME  | -    | 不能为 Null                                                  |
| 矿泉水编号  | INT   | -    | 自动递增，编号唯一                                           |
| 数量        | INT   | -    | 不能为 Null，正数为增加，负数为减少                          |
| 工号        | INT   | -    | 自动递增，工号唯一                                           |
| 姓名        | VCHAR | 30   | 不能为 Null，姓名可以重复                                    |
| 性别        | INT   | -    | 只能取 “0” 或 "1" ，“0” 为 “男”， “1” 为 女                  |
| 入职年份    | TIME  | -    | 不能为 Null                                                  |
| 基本工资    | INT   | -    | 大于 0 ，单位为 “分”                                         |
| 出生日期    | TIME  | -    | -                                                            |
| 仓库名      | VCHAR | 30   | 不能为 Null                                                  |
| 仓库编号    | INT   | -    | 自动递增，编号唯一                                           |
| 仓库地址    | VCHAR | 200  | -                                                            |
| 出/入库时间 | TIME  | -    | 不能为 Null，当数量为正数时，表示入库时间，当数量为负数时，表示出库时间 |
| 供应商编号  | INT   | -    | 自动递增，编号唯一                                           |
| 供应商名称  | VCHAR | 30   | 不能为 Null，可重复                                          |
| 供应商地址  | VCHAR | 200  | -                                                            |
| 矿泉水名称  | VCHAR | 30   | 不能为 Null                                                  |
| 矿泉水规格  | INT   | -    | 单位为 mL                                                    |
| 矿泉水成本  | INT   | -    | 大于 0 ，单位为分                                            |
| 矿泉水售价  | INT   | -    | 大于 0 ，单位为分                                            |
| 种类数      | INT   | -    | 非负                                                         |

## 4.3 关系模式

根据 **E-R** 图可以进一步分解出关系模型，如下：

| 关系名       | 属性                                                         | 外键                             |
| ------------ | ------------------------------------------------------------ | -------------------------------- |
| 客户信息     | <u>客户编号</u>、联系人姓名、联系人性别、联系地址、联系电话、客户状态、登录密码 | -                                |
| 员工信息     | <u>工号</u>、姓名、性别、入职年份、基本工资、出生日期、员工状态 |                                  |
| 供应商       | <u>供应商编号</u>、供应商名称、联系电话、供应商地址、供应产品的种类数、供应商状态 | -                                |
| 矿泉水       | <u>矿泉水编号</u>、矿泉水名称、规格、成本、售价、矿泉水状态  | -                                |
| 订单信息     | <u>订单号</u>、客户编号、矿泉水编号、产品数量、下单时间、订单状态 | 客户编号、矿泉水编号             |
| 仓库         | <u>仓库编号</u>、仓库名、仓库地址、仓库状态                  | -                                |
| 仓库存放信息 | <u>仓库编号、矿泉水编号</u>、数量                            | 仓库编号、矿泉水编号             |
| 供应产品     | <u>矿泉水编号、供应商编号</u>                                | 矿泉水编号、供应商编号           |
| 送货记录     | <u>订单号</u>、工号、处理时间                                | 订单号、工号                     |
| 进货记录     | <u>进货记录编号</u>、矿泉水编号、供应商编号、员工编号、进货数量、进货时间 | 矿泉水编号、供应商编号、员工编号 |
| 存/取货记录  | <u>记录编号</u>、工号、矿泉水编号、数量、存货时间            | 工号、矿泉水编号                 |
| 管理员表     | <u>管理员编号</u>、管理员姓名、密码                          | -                                |


## 4.4 SQL建表语句

客户信息表

```sql
CREATE TABLE `custom` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `gender` int(11) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `phoneNumber` varchar(11) DEFAULT NULL,
  `state` int(11) NOT NULL,
  `password` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ID`)
);
```

员工信息表

```sql
CREATE TABLE `staff` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `gender` int(11) DEFAULT NULL,
  `dateOfEntry` timestamp NOT NULL,
  `salary` int(11) DEFAULT NULL,
  `birthday` timestamp NOT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
);
```

供应商表

```sql
CREATE TABLE `supplier` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `phoneNumber` varchar(11) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `productNumber` int(11) DEFAULT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
);
```

矿泉水表

```sql
CREATE TABLE `water` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `size` varchar(11) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
);
```

订单信息表

```sql
CREATE TABLE `orderDetail` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `customID` int(11) DEFAULT NULL,
  `waterID` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `time` timestamp NOT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`waterID`) REFERENCES `water` (`ID`),
  FOREIGN KEY (`customID`) REFERENCES `custom` (`ID`)
);
```

仓库表

```sql
CREATE TABLE `repository` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
);
```

仓库存放信息表

```sql
CREATE TABLE `stock` (
  `repositoryID` int(11) NOT NULL AUTO_INCREMENT,
  `waterID` int(11) NOT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`repositoryID`,`waterID`),
  FOREIGN KEY (`repositoryID`) REFERENCES `repository` (`ID`),
  FOREIGN KEY (`waterID`) REFERENCES `water` (`ID`)
);
```

供应产品表

```sql
CREATE TABLE `supplierWater` (
  `supplierID` int(11) NOT NULL,
  `waterID` int(11) NOT NULL,
  PRIMARY KEY (`supplierID`,`waterID`),
  FOREIGN KEY (`supplierID`) REFERENCES `supplier` (`ID`),
  FOREIGN KEY (`waterID`) REFERENCES `water` (`ID`)
);
```

送货记录表

```sql
CREATE TABLE `delivery` (
  `orderDetailID` int(11) NOT NULL AUTO_INCREMENT,
  `staffID` int(11) DEFAULT NULL,
  `time` timestamp NOT NULL,
  PRIMARY KEY (`orderDetailID`),
  FOREIGN KEY (`orderDetailID`) REFERENCES `orderDetail` (`ID`),
  FOREIGN KEY (`staffID`) REFERENCES `staff` (`ID`)
);
```

进货记录表

```sql
CREATE TABLE `purchase` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `waterID` int(11) DEFAULT NULL,
  `supplierID` int(11) DEFAULT NULL,
  `staffID` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `time` timestamp NOT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`waterID`) REFERENCES `water` (`ID`),
  FOREIGN KEY (`supplierID`) REFERENCES `supplier` (`ID`),
  FOREIGN KEY (`staffID`) REFERENCES `staff` (`ID`)
);
```

存/取货记录表

```sql
CREATE TABLE `flowRecord` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `staffID` int(11) DEFAULT NULL,
  `waterID` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `time` timestamp NOT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`staffID`) REFERENCES `staff` (`ID`),
  FOREIGN KEY (`waterID`) REFERENCES `water` (`ID`)
);
```

管理员表

```sql
CREATE TABLE `admin` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(15) NOT NULL,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`)
);
```

## 4.5 完整性设计

数据的完整性分为实体完整性、数据完整性以及用户自定义的完整性，下面分别从这三个方面对本系统的数据完整性进行说明。

### 4.5.1 实体完整性

实体完整性是对关系中的记录唯一性，也就是主键的约束。一般情况下，实体完整性要求关系中的主属性值不能为 Null 并且取值唯一。比如，```身份证号码```——身份证号码可以唯一的标识一个个体并且每个人都要有一个身份证号码。

本系统采用定义```PRIMARY KEY```和```UNIQUE```的方式来实现实体完整性。

| 表名         | 主键                   |
| ------------ | ---------------------- |
| 客户信息     | 客户编号               |
| 员工信息     | 员工编号               |
| 供应商       | 供应商编号             |
| 矿泉水       | 矿泉水编号             |
| 订单信息     | 订单编号               |
| 仓库         | 仓库编号               |
| 仓库存放信息 | 仓库编号、矿泉水编号   |
| 供应产品     | 供应商编号、矿泉水编号 |
| 送货记录     | 订单编号               |
| 进货记录     | 进货编号               |
| 存取货记录   | 存取货编号             |
| 管理员       | 管理员编号             |

### 4.5.2 参照完整性

参照完整性是对关系数据库中建立关联关系的数据表间数据参照引用的约束，也就是对外键的约束。准确地说，参照完整性是指关系中的外键必须是另一个关系的主键有效值，或者是NULL。
参考完整性维护表间数据的有效性、完整性。通常通过建立外部键联系另一表的主键实现，还可以用触发器来维护参考完整性。

本系统设计了```外键```来实现关系之间的参照完整性。

| 关系名       | 外键                             |
| ------------| -------------------------------- |
| 订单信息     | 客户编号、矿泉水编号             |
| 仓库存放信息 | 仓库编号、矿泉水编号             |
| 供应产品     | 矿泉水编号、供应商编号           |
| 送货记录     | 订单号、工号                     |
| 进货记录     | 矿泉水编号、供应商编号、员工编号   |
| 存/取货记录  | 工号、矿泉水编号                 |

### 4.5.3 用户自定义完整性

用户自定义完整性指针对某一具体关系数据库的约束条件，它反映某一具体应用所涉及的数据必须满足的语义要求。例如，员工的```基本工资```不应为负数，用户的订单数量不应为负数等。

在本系统中采用```CHECK```和```TRIGGER```来实现用户自定义完整性。当进行数据更新时，会自动检查是否符合约束条件，并且自动触发对应的事件，修改相关的数据，来保证数据的完整性。

#### 4.5.3.1 CHECK 语句

每个表的约束条件可在对应的建表语句中查询。

#### 4.5.3.2 触发器

增加```矿泉水表```记录

自动增加```仓库存放信息表记录```

```sql
CREATE TRIGGER
  `insertWater`
AFTER INSERT ON
  water
FOR EACH ROW
BEGIN
  INSERT INTO
    stock(repositoryID, waterID, number)
  VALUES
    (1, new.ID, 0);
END;
```


增加```供应产品表```记录

自动增加```供应商表```中的供应产品种类数

```sql
CREATE TRIGGER
  `insertSupplierWater`
AFTER INSERT ON
  supplierWater
FOR EACH ROW
BEGIN
  UPDATE
    supplier
  SET
    supplier.productNumber = supplier.productNumber + 1
  WHERE
    supplier.ID = new.supplierID;
END;
```

删除```供应产品表```记录
自动减少```供应商表```中的供应产品种类数

```sql
CREATE TRIGGER
  deleteSupplierWater
AFTER DELETE ON
  supplierWater
FOR EACH ROW
BEGIN
  UPDATE
    supplier 
  SET
    supplier.productNumber = supplier.productNumber - 1
  WHERE
    supplier.ID = old.supplierID;
END;
```

增加进货记录表

自动增加```存/取货记录表```

```sql
CREATE TRIGGER
  `insertPurchase`
AFTER INSERT ON
  purchase
FOR EACH ROW
BEGIN
  INSERT
    flowRecord(staffID, waterID, number, time)
  VALUES
    (new.staffID, new.waterID, new.quantity, CURRENT_TIMESTAMP);
END;
```

增加送货记录

自动增加```存/取货记录表```

```sql
CREATE TRIGGER
  `insertDelivery`
AFTER INSERT ON
  delivery
FOR EACH ROW
BEGIN
  DECLARE newNumber INT;
  DECLARE newWaterID decimal(8,4);

  SELECT
    number, waterID
  INTO
    newNumber, newWaterID
  FROM
    orderDetail
  WHERE
    ID = new.orderDetailID;
      
  SET newNumber = 0 - newNumber;

  INSERT INTO
    flowRecord(staffID, waterID, number, time)
  VALUES
    (new.staffID, newWaterID, newNumber, new.time);     
  UPDATE
    orderDetail
  SET
    orderDetail.state = 2
  WHERE
    ID = new.orderDetailID;
END;
```

增加```存/取货记录表```
自动修改```仓库存放信息表```

```sql
CREATE TRIGGER
  `insertFlowRecord`
AFTER INSERT ON
  flowRecord
FOR EACH ROW
BEGIN
  UPDATE
    stock 
  SET
    number = number + new.number 
  WHERE
    waterID = new.waterID;
END;
```

# 五、物理结构设计

## 5.1 索引

1、在客户信息表主码属性列上建立主键索引
2、在员工信息表主码属性列上建立主键索引
3、在供应商表主码属性列上建立主键索引
4、在矿泉水表主码属性列上建立主键索引
5、在订单信息表主码属性列上建立主键索引
6、在仓库表主码属性列上建立主键索引
7、在送货记录主码属性列上建立主键索引
8、存/取记录表主码属性列上建立主键索引

## 5.2 视图

### 5.2.1 月度财务报表

月份，月销售总额，月进货总额，月工资总额，月利润

```sql
CREATE VIEW `monthlyProfit`
AS
SELECT
  `monthlySales`.`yearmonth` AS `yearmonth`,
  sum(`monthlySales`.`totalSales`) AS `totalSales`,
  sum(`monthlyPurchase`.`totalPurchase`) AS `totalPurchase`,
  (SELECT sum(`staff`.`salary`) FROM `staff`) AS `totalSalary`,
  (
    (sum(`monthlySales`.`totalSales`) - sum(`monthlyPurchase`.`totalPurchase`)) - (SELECT sum(`staff`.`salary`) FROM `staff`)
  ) AS `totalProfit`
FROM
  (`monthlySales` JOIN `monthlyPurchase`)
WHERE
  (`monthlyPurchase`.`yearmonth` = `monthlySales`.`yearmonth`)
GROUP BY
  `monthlySales`.`yearmonth`;
```

### 5.2.2 月度工单统计

月份，工号，姓名，送货单总数，送水数量，销售总额

```sql
CREATE VIEW `monthlyDelivery`
AS
SELECT
  extract(YEAR_MONTH FROM `delivery`.`time`) AS `yearmonth`,
  `staff`.`ID` AS `staffID`,
  `staff`.`name` AS `staffName`,
  count(`delivery`.`orderDetailID`) AS `totalDelivery`,
  sum(`orderDetail`.`number`) AS `totalQuantity`,
  sum((`orderDetail`.`number` * `water`.`price`)) AS `totalSales`
FROM
  (((`delivery` JOIN `orderDetail`) JOIN `staff`) JOIN `water`)
WHERE
  (
    (`delivery`.`staffID` = `staff`.`ID`)
    AND (`orderDetail`.`ID` = `delivery`.`orderDetailID`)
    AND (`water`.`ID` = `orderDetail`.`waterID`)
  ) 
GROUP BY
  extract(YEAR_MONTH FROM `delivery`.`time`),
  `delivery`.`staffID`;
```

### 5.2.3 月度销售统计

月份，客户名称，订单总数，用水量总额，销售总额

```sql
CREATE VIEW `monthlySales`
AS
SELECT
  extract(YEAR_MONTH FROM `saleDetail`.`time`) AS `yearmonth`,
  `saleDetail`.`customName` AS `customName`,
  count(`saleDetail`.`customName`) AS `totalOrder`,
  sum(`saleDetail`.`quantity`) AS `totalQuantity`,
  sum(`saleDetail`.`totalPrice`) AS `totalSales`
FROM
  `saleDetail`
GROUP BY
  extract(YEAR_MONTH FROM `saleDetail`.`time`),
  `saleDetail`.`customName`;
```

### 5.2.4 进货记录

矿泉水名称，矿泉水成本，供应商名称，数量，总价，进货时间

```sql
CREATE VIEW `purchaseDetail`
AS
SELECT
  `purchase`.`time` AS `time`,
  `water`.`name` AS `waterName`,
  `water`.`cost` AS `waterCost`,
  `supplier`.`name` AS `supplierName`,
  `purchase`.`quantity` AS `quantity`,
  (`water`.`cost` * `purchase`.`quantity`) AS `totalCost`
FROM
  ((`water` JOIN `purchase`) JOIN `supplier`)
WHERE
  ((`water`.`ID` = `purchase`.`waterID`) AND (`supplier`.`ID` = `purchase`.`supplierID`));
```

### 5.2.5 销售记录

矿泉水名称，矿泉水售价，客户名称，数量，总价，销售时间

```sql
CREATE VIEW `saleDetail`
AS
SELECT
  `delivery`.`time` AS `time`,
  `water`.`name` AS `waterName`,
  `water`.`price` AS `waterPrice`,
  `custom`.`name` AS `customName`,
  `orderDetail`.`number` AS `quantity`,
  (`water`.`price` * `orderDetail`.`number`) AS `totalPrice`
FROM
  (((`water` JOIN `custom`) JOIN `orderDetail`) JOIN `delivery`)
WHERE
  (
    (`water`.`ID` = `orderDetail`.`waterID`)
    AND (`delivery`.`orderDetailID` = `orderDetail`.`ID`)
  AND (`orderDetail`.`customID` = `custom`.`ID`)
  );
```

## 5.3 安全机制



# 六、应用程序设计



# 七、测试和运行



# 八、总结

