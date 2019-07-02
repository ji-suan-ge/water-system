package cn.edu.hfut.watersystem.manage.bean;

import javax.validation.constraints.NotNull;

/**
 * @author 葛学文
 * @date 2019/6/14 20:28
 */
public class WaterDeleteReq {
    @NotNull(message = "waterID 不能为空")
    private Integer waterID;

    public Integer getWaterID() {
        return waterID;
    }

    public void setWaterID(Integer waterID) {
        this.waterID = waterID;
    }
}
