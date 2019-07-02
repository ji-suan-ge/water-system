package cn.edu.hfut.watersystem.manage.bean;

import cn.edu.hfut.watersystem.manage.entity.MonthlyDelivery;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/15 1:19
 */
public class GetMonthlyDeliveryListRes {
    private List<MonthlyDelivery> monthlyDeliveryList;

    public List<MonthlyDelivery> getMonthlyDeliveryList() {
        return monthlyDeliveryList;
    }

    public void setMonthlyDeliveryList(List<MonthlyDelivery> monthlyDeliveryList) {
        this.monthlyDeliveryList = monthlyDeliveryList;
    }
}
