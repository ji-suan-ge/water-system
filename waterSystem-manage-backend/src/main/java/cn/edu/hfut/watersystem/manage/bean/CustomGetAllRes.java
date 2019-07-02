package cn.edu.hfut.watersystem.manage.bean;

import cn.edu.hfut.watersystem.manage.entity.Custom;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/14 20:01
 */
public class CustomGetAllRes {
    private List<Custom> customList;

    public List<Custom> getCustomList() {
        return customList;
    }

    public void setCustomList(List<Custom> customList) {
        this.customList = customList;
    }
}
