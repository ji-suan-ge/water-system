package cn.edu.hfut.watersystem.manage.controller;

import cn.edu.hfut.watersystem.manage.bean.*;
import cn.edu.hfut.watersystem.manage.entity.Message;
import cn.edu.hfut.watersystem.manage.util.ResultUtil;
import cn.edu.hfut.watersystem.manage.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author 葛学文
 * @date 2019/6/15 8:30
 */
@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {

    @Autowired
    OrderDetailService orderDetailService;

    @PostMapping("/getAll")
    public Message getOrderDetailListByState(@RequestBody GetOrderDetailListReq getOrderDetailListReq) {
        Integer state = getOrderDetailListReq.getState();
        state = state == null ? 1 : state;

        GetOrderDetailListRes getOrderDetailListRes = new GetOrderDetailListRes();
        getOrderDetailListRes.setOrderDetailList(orderDetailService.getOrderDetailListByState(state));
        return ResultUtil.success(getOrderDetailListRes);
    }

    @PostMapping("/delete")
    public Message cancelOrder(@Valid @RequestBody CancelOrderReq cancelOrderReq) {
        Integer orderDetailID = cancelOrderReq.getOrderDetailID();

        orderDetailService.cancelOrder(orderDetailID);
        CancelOrderRes cancelOrderRes = new CancelOrderRes();
        cancelOrderRes.setCancelSuccess(true);

        return ResultUtil.success(cancelOrderRes);
    }

    @PostMapping("/deliver")
    public Message deliverOrder(@Valid @RequestBody DeliverOrderReq deliverOrderReq) {
        Integer orderDetailID = deliverOrderReq.getOrderDetailID();
        Integer staffID = deliverOrderReq.getStaffID();

        orderDetailService.deliverOrder(orderDetailID, staffID);
        DeliverOrderRes deliverOrderRes = new DeliverOrderRes();
        deliverOrderRes.setDeliverSuccess(true);

        return ResultUtil.success(deliverOrderRes);
    }
}
