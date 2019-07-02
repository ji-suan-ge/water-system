SET FOREIGN_KEY_CHECKS = 0;

source ./table/admin.sql;
source ./table/custom.sql;
source ./table/delivery.sql;
source ./table/flowRecord.sql;
source ./table/orderDetail.sql;
source ./table/purchase.sql;
source ./table/repository.sql;
source ./table/staff.sql;
source ./table/stock.sql;
source ./table/supplier.sql;
source ./table/supplierWater.sql;
source ./table/water.sql;

source ./trigger/delivery-trigger.sql;
source ./trigger/flowRecord-trigger.sql;
source ./trigger/purchase-trigger.sql;
source ./trigger/supplierWater-trigger.sql;
source ./trigger/water-trigger.sql;

source ./view/monthlyDelivery.sql
source ./view/purchaseDetail.sql
source ./view/saleDetail.sql
source ./view/monthlySales.sql
source ./view/monthlyPurchase.sql
source ./view/monthlyProfit.sql

source ./procedure.sql;

SET FOREIGN_KEY_CHECKS = 1;