package cn.edu.hfut.watersystem.manage.controller;

import cn.edu.hfut.watersystem.manage.entity.Message;
import cn.edu.hfut.watersystem.manage.util.ResultUtil;
import cn.edu.hfut.watersystem.manage.bean.GetMonthlyProfitRes;
import cn.edu.hfut.watersystem.manage.service.MonthlyProfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 葛学文
 * @date 2019/6/15 1:35
 */
@RestController
@RequestMapping("/monthlyProfit")
public class MonthlyProfitController {

    @Autowired
    MonthlyProfitService monthlyProfitService;

    @PostMapping("/getAll")
    public Message getMonthlyProfitList() {

        GetMonthlyProfitRes getMonthlyProfitRes = new GetMonthlyProfitRes();
        getMonthlyProfitRes.setMonthlyProfitList(monthlyProfitService.getMonthlyProfitList());

        return ResultUtil.success(getMonthlyProfitRes);
    }
}
