package cn.edu.hfut.watersystem.manage.controller;

import cn.edu.hfut.watersystem.manage.entity.Message;
import cn.edu.hfut.watersystem.manage.util.ResultUtil;
import cn.edu.hfut.watersystem.manage.bean.GetMonthlyDeliveryListReq;
import cn.edu.hfut.watersystem.manage.bean.GetMonthlySalesRes;
import cn.edu.hfut.watersystem.manage.service.MonthlySalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author 葛学文
 * @date 2019/6/15 1:36
 */
@RestController
@RequestMapping("/monthlySales")
public class MonthlySalesController {

    @Autowired
    MonthlySalesService monthlySalesService;

    @PostMapping("/getAll")
    public Message getMonthlySalesList(@Valid @RequestBody GetMonthlyDeliveryListReq getMonthlyDeliveryListReq) {
        String year = getMonthlyDeliveryListReq.getYear();
        String month = getMonthlyDeliveryListReq.getMonth();

        GetMonthlySalesRes getMonthlySalesRes = new GetMonthlySalesRes();
        getMonthlySalesRes.setMonthlySalesList(monthlySalesService.getMonthlySalesList(year, month));

        return ResultUtil.success(getMonthlySalesRes);
    }
}
