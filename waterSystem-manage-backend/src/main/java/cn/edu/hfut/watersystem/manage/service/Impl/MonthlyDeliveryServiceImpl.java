package cn.edu.hfut.watersystem.manage.service.Impl;

import cn.edu.hfut.watersystem.manage.entity.MonthlyDelivery;
import cn.edu.hfut.watersystem.manage.mapper.MonthlyDeliveryMapper;
import cn.edu.hfut.watersystem.manage.service.MonthlyDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/15 1:14
 */
@Service
public class MonthlyDeliveryServiceImpl implements MonthlyDeliveryService {

    @Autowired
    MonthlyDeliveryMapper monthlyDeliveryMapper;


    @Override
    public List<MonthlyDelivery> getMonthlyDeliveryList(String year, String month) {
        return monthlyDeliveryMapper.selectMonthlyDeliveryList(year, month);
    }
}
