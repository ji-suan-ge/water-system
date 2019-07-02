package cn.edu.hfut.watersystem.manage.bean;

import javax.validation.constraints.NotNull;

/**
 * @author 葛学文
 * @date 2019/6/14 23:59
 */
public class AddSupplierWaterReqBean {
    @NotNull(message = "supplierID 不能为空")
    private Integer supplierID;
    @NotNull(message = "waterID 不能为空")
    private Integer waterID;

    public Integer getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Integer supplierID) {
        this.supplierID = supplierID;
    }

    public Integer getWaterID() {
        return waterID;
    }

    public void setWaterID(Integer waterID) {
        this.waterID = waterID;
    }
}
