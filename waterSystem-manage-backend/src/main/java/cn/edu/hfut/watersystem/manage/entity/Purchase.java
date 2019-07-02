package cn.edu.hfut.watersystem.manage.entity;

/**
 * @author 葛学文
 * @date 2019/6/15 0:29
 */
public class Purchase {
    private Integer ID;
    private Integer waterID;
    private Integer supplierID;
    private Integer staffID;
    private Integer quantity;
    private String time;

    public Purchase() {
    }

    public Purchase(Integer waterID, Integer supplierID, Integer staffID, Integer quantity, String time) {
        this.waterID = waterID;
        this.supplierID = supplierID;
        this.staffID = staffID;
        this.quantity = quantity;
        this.time = time;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
