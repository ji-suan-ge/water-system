delimiter $$
CREATE PROCEDURE `deleteCustom`(ID INT)
BEGIN
  UPDATE custom
  SET state = 0 
  WHERE custom.ID = ID;
END$$

CREATE PROCEDURE `deleteRepository`(ID INT)
BEGIN
  UPDATE repository
  SET state = 0 
  WHERE repository.ID = ID;
END$$

CREATE PROCEDURE `deleteStaff`(ID INT)
BEGIN
  UPDATE staff
  SET state = 0 
  WHERE staff.ID = ID;
END$$

CREATE PROCEDURE `deleteSupplier`(ID INT)
BEGIN
  UPDATE supplier
  SET state = 0 
  WHERE supplier.ID = ID;
END$$

CREATE PROCEDURE `deleteSupplierWater`(supplierID INT, waterID INT)
BEGIN
  DELETE FROM supplierWater
  WHERE supplierWater.supplierID = supplierID and supplierWater.waterID = waterID;
END$$

CREATE PROCEDURE `deleteWater`(ID INT)
BEGIN
  UPDATE water
  SET state = 0 
  WHERE water.ID = ID;
END$$

CREATE PROCEDURE `insertCustom`(name VARCHAR(30), gender INT, address VARCHAR(200), phonenumber VARCHAR(11))
BEGIN
  INSERT into custom(name, gender, address, phoneNumber, state)
  VALUES (name, gender, address, phonenumber, 1);
END$$

CREATE PROCEDURE `insertDelivery`(orderDetailID INT, staffID INT, time TIMESTAMP)
BEGIN
  INSERT INTO delivery
  VALUES (orderDetailID, staffID, time);
END$$

CREATE PROCEDURE `insertOrderdetail`(customID INT,waterID INT,number INT,time TIMESTAMP)
BEGIN
  INSERT into orderDetail(customID, waterID, number, time, state)
  VALUES(customID, waterID, number, time, 1);
END$$

CREATE PROCEDURE `insertPurchase`(waterID INT, supplierID INT, staffID INT, quantity INT,time TIMESTAMP)
BEGIN
  INSERT INTO purchase(waterID, supplierID, staffID, quantity, time)
  VALUES (waterID, supplierID, staffID, quantity, time);
END$$

CREATE PROCEDURE `insertRepository`(name VARCHAR(30), address VARCHAR(200))
BEGIN
  INSERT into repository(name, address, state)
  VALUES (name, address, 1);
END$$

CREATE PROCEDURE `insertStaff`(name VARCHAR(30), gender INT, dateOfEntry TIMESTAMP, salary INT, birthday TIMESTAMP)
BEGIN
  INSERT into staff(name, gender, dateOfEntry, salary, birthday, state)
  VALUES (name, gender, dateOfEntry, salary, birthday, 1);
END$$

CREATE PROCEDURE `insertSupplier`(name VARCHAR(30), phonenumber VARCHAR(11), address VARCHAR(200), productNumber INT)
BEGIN
  INSERT into supplier(name, phoneNumber, address, productNumber, state)
  VALUES (name, phoneNumber, address, productNumber, 1);
END$$

CREATE PROCEDURE `insertSupplierWater`(supplierID INT, waterID INT)
BEGIN
  INSERT into supplierWater(supplierID, waterID)
  VALUES (supplierID, waterID);
END$$

CREATE PROCEDURE `insertWater`(name VARCHAR(30), size VARCHAR(11), cost INT, price INT)
BEGIN
  INSERT into water(name, size, cost, price, state)
  VALUES (name, size, cost, price, 1);
END$$

CREATE PROCEDURE `selectAdmin`()
BEGIN
  SELECT * FROM admin;
END$$

CREATE PROCEDURE `selectAdminByID`(para INT)
BEGIN
  SELECT * FROM admin WHERE ID = para;
END$$

CREATE PROCEDURE `selectCustom`()
BEGIN
  SELECT * FROM custom WHERE state = 1;
END$$

CREATE PROCEDURE `selectCustomByID`(ID INT)
BEGIN
  SELECT * FROM custom WHERE state = 1 and custom.ID = ID;
END$$

CREATE PROCEDURE `selectDoneOrder`()
BEGIN
  SELECT * FROM orderDetail WHERE state = 2;
END$$

CREATE PROCEDURE `selectMonthlyDelivery`(_year CHAR(4), _month CHAR(2))
BEGIN
  DECLARE _yearmonth CHAR(6);
  SET _yearmonth = CONCAT(_year,_month);

  IF _yearmonth = '000000' THEN
    SELECT * FROM monthlyDelivery
    ORDER BY yearmonth DESC, totalQuantity DESC;
  ELSE
    SELECT * FROM monthlyDelivery
    WHERE monthlyDelivery.yearmonth = _yearmonth
    ORDER BY yearmonth DESC, totalQuantity DESC;
  END IF;
END$$

CREATE PROCEDURE `selectMonthlyProfit`()
BEGIN
  SELECT * FROM monthlyProfit;
END$$

CREATE PROCEDURE `selectMonthlyPurchase`()
BEGIN
  SELECT * FROM monthlyPurchase
  ORDER BY yearmonth DESC;
END$$

CREATE PROCEDURE `selectMonthlySales`(_year CHAR(4), _month CHAR(2))
BEGIN
  DECLARE _yearmonth CHAR(6);
  SET _yearmonth = CONCAT(_year,_month);

  IF _yearmonth = '000000' THEN
    SELECT * FROM monthlySales
    ORDER BY yearmonth DESC, totalQuantity DESC;
  ELSE
    SELECT * FROM monthlySales
    WHERE monthlySales.yearmonth = _yearmonth
    ORDER BY yearmonth DESC, totalQuantity DESC ;
  END IF;
END$$

CREATE PROCEDURE `selectNotSupplier`( waterID VARCHAR ( 15 ) )
BEGIN
  SELECT * FROM supplier 
  WHERE state = 1 
    AND ID NOT IN (
      SELECT supplierID
      FROM supplierWater
      WHERE supplierWater.waterID = waterID
    );
END$$

CREATE PROCEDURE `selectOrderByState`(para INT)
BEGIN
  SELECT
    orderDetail.ID ID, customID, waterID, number, custom.`name` customName, water.`name` waterName, time,
    orderDetail.state state
  FROM orderDetail, water, custom
  WHERE orderDetail.state = para
    and water.ID = orderDetail.waterID
    and custom.ID = orderDetail.customID;
END$$

CREATE PROCEDURE `selectRepository`()
BEGIN
  SELECT * FROM repository
  WHERE state = 1;
END$$

CREATE PROCEDURE `selectStaff`()
BEGIN
  SELECT * FROM staff
  WHERE state = 1;
END$$

CREATE PROCEDURE `selectSupplier`()
BEGIN
  SELECT * FROM supplier
  WHERE state = 1;
END$$

CREATE PROCEDURE `selectWater`()
BEGIN
  SELECT
    ID, `name`, size, cost, price, number quantity, state
  FROM water, stock
  WHERE state = 1
    and water.ID = stock.waterID;
END$$

CREATE PROCEDURE `selectYetSupplier`( waterID VARCHAR ( 15 ) )
BEGIN
  SELECT * FROM supplier 
  WHERE state = 1 
    AND ID IN (
      SELECT supplierID
      FROM supplierWater
      WHERE supplierWater.waterID = waterID
    );
END$$

CREATE PROCEDURE `updateCustomAddress`(ID INT,address1 VARCHAR(11))
BEGIN
  UPDATE custom
  SET address = address1
  WHERE custom.ID = ID;
END$$

CREATE PROCEDURE `updateCustomPhonenumber`(ID INT,phoneNumber1 VARCHAR(11))
BEGIN
  UPDATE custom
  SET phoneNumber = phoneNumber1
  WHERE custom.ID = ID;
END$$

CREATE PROCEDURE `updateOrderStateByID`(paraID INT, paraState INT)
BEGIN
  UPDATE orderDetail
  SET state = paraState
  WHERE ID = paraID;
END$$

CREATE PROCEDURE `updateRepositoryName`(ID INT,name1 VARCHAR(30))
BEGIN
  UPDATE repository
  SET name = name1
  WHERE repository.ID = ID;
END$$

CREATE PROCEDURE `updateStaffSalary`(ID INT,salary1 INT)
BEGIN
  UPDATE staff
  SET salary = salary1
  WHERE staff.ID = ID;
END$$

CREATE PROCEDURE `updateSupplierPhonenumber`(ID INT,phone VARCHAR(11))
BEGIN
  UPDATE supplier
  SET phoneNumber = phone
  WHERE supplier.ID = ID;
END$$

CREATE PROCEDURE `updateWaterCost`(ID INT,cost1 INT)
BEGIN
  UPDATE water
  SET cost = cost1
  WHERE water.ID = ID;
END$$

CREATE PROCEDURE `updateWaterPrice`(ID INT,price1 INT)
BEGIN
  UPDATE water
  SET price = price1
  WHERE water.ID = ID;
END$$
delimiter ;