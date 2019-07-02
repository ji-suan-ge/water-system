package cn.edu.hfut.watersystem.manage.service;

import cn.edu.hfut.watersystem.manage.entity.MonthlyDelivery;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/15 1:13
 */
public interface MonthlyDeliveryService {

    List<MonthlyDelivery> getMonthlyDeliveryList(String year, String month);
}
