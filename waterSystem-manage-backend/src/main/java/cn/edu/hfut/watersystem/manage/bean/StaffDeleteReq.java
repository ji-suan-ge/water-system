package cn.edu.hfut.watersystem.manage.bean;

import javax.validation.constraints.NotNull;

/**
 * @author 葛学文
 * @date 2019/6/14 15:05
 */
public class StaffDeleteReq {
    @NotNull(message = "staffID 不能为空")
    private Integer staffID;

    public Integer getStaffID() {
        return staffID;
    }

    public void setStaffID(Integer staffID) {
        this.staffID = staffID;
    }
}
