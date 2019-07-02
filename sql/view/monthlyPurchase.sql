CREATE VIEW `monthlyPurchase`
AS
SELECT
	extract( YEAR_MONTH FROM `purchaseDetail`.`time` ) AS `yearmonth`,
	`purchaseDetail`.`waterName` AS `waterName`,
	sum( `purchaseDetail`.`quantity` ) AS `totalQuantity`,
	sum( `purchaseDetail`.`totalCost` ) AS `totalPurchase`
FROM
	`purchaseDetail` 
GROUP BY
	extract( YEAR_MONTH FROM `purchaseDetail`.`time` ),
	`purchaseDetail`.`waterName`;