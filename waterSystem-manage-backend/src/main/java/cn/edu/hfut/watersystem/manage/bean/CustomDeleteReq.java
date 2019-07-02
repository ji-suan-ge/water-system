package cn.edu.hfut.watersystem.manage.bean;

import javax.validation.constraints.NotNull;

/**
 * @author 葛学文
 * @date 2019/6/14 20:08
 */
public class CustomDeleteReq {
    @NotNull(message = "customID 不能为空")
    private Integer customID;

    public Integer getCustomID() {
        return customID;
    }

    public void setCustomID(Integer customID) {
        this.customID = customID;
    }
}
