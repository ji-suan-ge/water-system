package cn.edu.hfut.watersystem.manage.bean;

import javax.validation.constraints.NotNull;

/**
 * @author 葛学文
 * @date 2019/6/15 8:53
 */
public class DeliverOrderReq {
    @NotNull(message = "orderDetailID 不能为空")
    private Integer orderDetailID;
    @NotNull(message = "staffID 不能为空")
    private Integer staffID;

    public Integer getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(Integer orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public Integer getStaffID() {
        return staffID;
    }

    public void setStaffID(Integer staffID) {
        this.staffID = staffID;
    }
}
