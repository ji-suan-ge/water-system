package cn.edu.hfut.watersystem.manage.bean;

import cn.edu.hfut.watersystem.manage.entity.MonthlySales;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/15 1:36
 */
public class GetMonthlySalesRes {
    private List<MonthlySales> monthlySalesList;

    public List<MonthlySales> getMonthlySalesList() {
        return monthlySalesList;
    }

    public void setMonthlySalesList(List<MonthlySales> monthlySalesList) {
        this.monthlySalesList = monthlySalesList;
    }
}
