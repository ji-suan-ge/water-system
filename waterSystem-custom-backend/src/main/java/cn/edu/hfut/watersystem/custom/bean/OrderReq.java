package cn.edu.hfut.watersystem.custom.bean;

import javax.validation.constraints.NotNull;

/**
 * @author 葛学文
 * @date 2019/6/15 9:53
 */
public class OrderReq {
    @NotNull(message = "customID 不能为空")
    private Integer customID;
    @NotNull(message = "waterID 不能为空")
    private Integer waterID;
    @NotNull(message = "number 不能为空")
    private Integer number;

    public OrderReq() {
    }

    public OrderReq(Integer customID, Integer waterID, Integer number, String time) {
        this.customID = customID;
        this.waterID = waterID;
        this.number = number;
    }

    public Integer getCustomID() {
        return customID;
    }

    public void setCustomID(Integer customID) {
        this.customID = customID;
    }

    public Integer getWaterID() {
        return waterID;
    }

    public void setWaterID(Integer waterID) {
        this.waterID = waterID;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
