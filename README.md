[TOC]

# 一、系统开发概述

随着经济不断发展，城市的不断扩张，城市居民的用水需求量也在不断的攀高。为了适应人们的消费需求，近年来我国的饮用水市场发展极快，据不完全统计，目前全国各类饮用水生产厂家有2000多个。各地类似“送水公司”这样的服务业也随之不断发展。各企业竞争激烈，提高公司员工工作效率和服务质量是制胜的重要因素，另一方面在于与客户的沟通和公司自我形象的不断完善。

现今的社会，计算机已经成为人们处理日常事务不可缺少的一种工具，他能够把事情的复杂化转为简单化，使流程更加顺畅方便。对于大多数的中小型送水服务公司来说，产品、价格及质量都逐渐趋同。一个专门针对送水行业的软件，就能成为同行竞争中有利的优势。

# 二、系统规划

# 三、需求分析

## 3.1 信息要求

### 3.1.1 基本信息管理

本系统应该如下对象的基本信息进行管理：

- 员工（姓名、工号、工资、联系方式等）
- 客户（姓名、地址、联系方式等）
- 供应商（名称、地址、联系方式等）
- 矿泉水（名称、规格、成本价、零售价）

针对以上信息要向管理员分别提供单独的管理页面，允许系统管理员对四类的基本信息进行管理，即：新增信息、修改信息、删除信息。

### 3.1.2 记录型信息管理

同时还要对记录型信息进行管理：

- 订单
- 库存
- 费用

首先，订单管理涉及到几个功能上的需求：

- 客户下单（矿泉水种类、数量）
- 订单取消（库存不足或客户取消）
- 员工接单（员工、订单）
- 记录供货商供应矿泉水种类情况
- 进货（矿泉水、数量）
- 根据进货和接单情况更新库存

订单管理涉及到三个记录型信息的管理：订单管理、工单管理、库存管理，此外还有一个相关的供货管理，详情分析如下：

- 订单（订单号、客户、矿泉水、数量、下单时间、订单状态）
- 工单（工单号、客户、矿泉水、数量、接单时间、接单员工）
- 库存（矿泉水编号、数量）
- 供货详情（矿泉水编号、供货商号）

针对上述订单相关记录作详细阐述：订单是最核心的要素，客户下单的同时会创建订单的基本信息，如客户、矿泉水、数量、时间等，此时订单进入已下单状态；对于已下单的状态，系统能够指派员工接单并从库存中取货（减少库存），此时订单处于已接单（默认为已完成）状态；已下单但未接单的订单可以随时取消，此时订单会进入已取消状态。只有已经接单的订单才会拥有送货员工信息，所以需要额外的条目，即工单来记录，工单其实并不需要保存这么多信息，只需要根据订单号去查询详细信息即可，这属于之后逻辑设计过程中应该优化的部分。库存会因为派送订单而减少，同样也会因为进货而增加，这一过程随着订单创建和进货创建而自动完成。进货需要矿泉水、供货商和数量等信息，因此需要供货详情来允许供货商与矿泉水种类之间的多对多关系（即每个供货商可以供应多种矿泉水，每种矿泉水也可以由多个供应商提供）。

### 3.1.3 统计型信息管理


最终还要对数据信息进行统计：

- 月度开支、销售与盈利
- 月度工单数据
- 月度客户订单数据

本系统的基本功能要求如下：

- 实现工作人员、客户信息的管理

- 实现矿泉水类别和供应商的管理

- 实现矿泉水入库管理和出库管理

- 实现费用管理

- 创建触发器，实现入库、出库时相应类型矿泉水的数量的增加或减少

- 创建存储过程统计每个送水员工指定月份送水的数量

- 创建存储过程查询指定月份用水量最大的前10个用户，并按用水量递减排列

- 具有数据备份和数据恢复功能

![系统功能模块图](./image/module.png)




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

### 4.4.1 客户信息表

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

### 4.4.2 员工信息表

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

### 4.4.3 供应商表

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

### 4.4.4 矿泉水表

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

### 4.4.5 订单信息表

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

### 4.4.6 仓库表

```sql
CREATE TABLE `repository` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
);
```

### 4.4.7 仓库存放信息表

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

### 4.4.8 供应产品表

```sql
CREATE TABLE `supplierWater` (
  `supplierID` int(11) NOT NULL,
  `waterID` int(11) NOT NULL,
  PRIMARY KEY (`supplierID`,`waterID`),
  FOREIGN KEY (`supplierID`) REFERENCES `supplier` (`ID`),
  FOREIGN KEY (`waterID`) REFERENCES `water` (`ID`)
);
```

### 4.4.9 送货记录表

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

### 4.4.10 进货记录表

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

### 4.4.11 存/取货记录表

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

### 4.4.12 管理员表

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

##### 4.5.3.2.1 增加```矿泉水表```记录

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

##### 4.5.3.2.2 增加```供应产品表```记录

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

##### 4.5.3.2.3 删除```供应产品表```记录

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

##### 4.5.3.2.4 增加进货记录表

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

##### 4.5.3.2.5 增加送货记录

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

##### 4.5.3.2.6 增加```存/取货记录表```

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

