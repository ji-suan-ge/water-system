package cn.edu.hfut.watersystem.manage.bean;

import cn.edu.hfut.watersystem.manage.entity.MonthlyProfit;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/15 1:37
 */
public class GetMonthlyProfitRes {
    private List<MonthlyProfit> monthlyProfitList;

    public List<MonthlyProfit> getMonthlyProfitList() {
        return monthlyProfitList;
    }

    public void setMonthlyProfitList(List<MonthlyProfit> monthlyProfitList) {
        this.monthlyProfitList = monthlyProfitList;
    }
}
