package cn.edu.hfut.watersystem.manage.bean;

import javax.validation.constraints.NotNull;

/**
 * @author 葛学文
 * @date 2019/6/15 0:39
 */
public class AddPurchaseReq {
    @NotNull(message = "waterID 不能为空")
    private Integer waterID;
    @NotNull(message = "supplierID 不能为空")
    private Integer supplierID;
    @NotNull(message = "staffID 不能为空")
    private Integer staffID;
    @NotNull(message = "quantity 不能为空")
    private Integer quantity;

    public Integer getWaterID() {
        return waterID;
    }

    public void setWaterID(Integer waterID) {
        this.waterID = waterID;
    }

    public Integer getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Integer supplierID) {
        this.supplierID = supplierID;
    }

    public Integer getStaffID() {
        return staffID;
    }

    public void setStaffID(Integer staffID) {
        this.staffID = staffID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
