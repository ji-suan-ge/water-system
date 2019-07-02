package cn.edu.hfut.watersystem.manage.service;

import cn.edu.hfut.watersystem.manage.entity.MonthlySales;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/15 1:31
 */
public interface MonthlySalesService {

    List<MonthlySales> getMonthlySalesList(String year, String month);
}
