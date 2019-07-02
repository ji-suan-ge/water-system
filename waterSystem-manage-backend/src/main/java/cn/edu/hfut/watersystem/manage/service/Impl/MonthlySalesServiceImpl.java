package cn.edu.hfut.watersystem.manage.service.Impl;

import cn.edu.hfut.watersystem.manage.entity.MonthlySales;
import cn.edu.hfut.watersystem.manage.mapper.MonthlySalesMapper;
import cn.edu.hfut.watersystem.manage.service.MonthlySalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/15 1:31
 */
@Service
public class MonthlySalesServiceImpl implements MonthlySalesService {

    @Autowired
    MonthlySalesMapper monthlySalesMapper;

    @Override
    public List<MonthlySales> getMonthlySalesList(String year, String month) {
        return monthlySalesMapper.selectMonthlySalesList(year, month);
    }
}
