package cn.edu.hfut.watersystem.manage.service.Impl;

import cn.edu.hfut.watersystem.manage.entity.MonthlyProfit;
import cn.edu.hfut.watersystem.manage.mapper.MonthlyProfitMapper;
import cn.edu.hfut.watersystem.manage.service.MonthlyProfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/15 1:30
 */
@Service
public class MonthlyProfitServiceImpl implements MonthlyProfitService {

    @Autowired
    MonthlyProfitMapper monthlyProfitMapper;

    @Override
    public List<MonthlyProfit> getMonthlyProfitList() {
        return monthlyProfitMapper.selectMonthlyProfitList();
    }
}
