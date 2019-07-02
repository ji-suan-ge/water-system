package cn.edu.hfut.watersystem.manage.controller;

import cn.edu.hfut.watersystem.manage.entity.Message;
import cn.edu.hfut.watersystem.manage.util.ResultUtil;
import cn.edu.hfut.watersystem.manage.bean.GetMonthlyDeliveryListReq;
import cn.edu.hfut.watersystem.manage.bean.GetMonthlyDeliveryListRes;
import cn.edu.hfut.watersystem.manage.service.MonthlyDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author 葛学文
 * @date 2019/6/15 1:16
 */
@RestController
@RequestMapping("/monthlyDelivery")
public class MonthlyDeliveryController {

    @Autowired
    MonthlyDeliveryService monthlyDeliveryService;

    @PostMapping("/getAll")
    public Message getMonthlyDeliveryList(@Valid @RequestBody GetMonthlyDeliveryListReq getMonthlyDeliveryListReq) {
        String year = getMonthlyDeliveryListReq.getYear();
        String month = getMonthlyDeliveryListReq.getMonth();

        GetMonthlyDeliveryListRes getMonthlyDeliveryListRes = new GetMonthlyDeliveryListRes();
        getMonthlyDeliveryListRes.setMonthlyDeliveryList(monthlyDeliveryService.getMonthlyDeliveryList(year, month));

        return ResultUtil.success(getMonthlyDeliveryListRes);
    }
}
