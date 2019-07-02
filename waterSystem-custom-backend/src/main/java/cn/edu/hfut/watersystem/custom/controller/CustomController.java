package cn.edu.hfut.watersystem.custom.controller;

import cn.edu.hfut.watersystem.custom.entity.Message;
import cn.edu.hfut.watersystem.custom.entity.OrderDetail;
import cn.edu.hfut.watersystem.custom.service.CustomService;
import cn.edu.hfut.watersystem.custom.service.OrderDetailService;
import cn.edu.hfut.watersystem.custom.util.ResultUtil;
import cn.edu.hfut.watersystem.custom.util.TimeUtil;
import cn.edu.hfut.watersystem.custom.bean.LoginReq;
import cn.edu.hfut.watersystem.custom.bean.OrderReq;
import cn.edu.hfut.watersystem.custom.entity.Custom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @author 葛学文
 * @date 2019/6/15 9:41
 */
@RestController
@RequestMapping("/custom")
public class CustomController {

    @Autowired
    CustomService customService;
    @Autowired
    OrderDetailService orderDetailService;

    @PostMapping("/login")
    public Message login(@Valid @RequestBody LoginReq loginReq, HttpSession httpSession) {
        Integer ID = loginReq.getCustomID();
        String password = loginReq.getPassword();
        Custom custom = customService.getCustomByID(ID);
        if (custom == null || !password.equals(custom.getPassword())) return ResultUtil.error("密码错误");
        httpSession.setAttribute("custom", custom);
        return ResultUtil.success("登陆成功");
    }

    @PostMapping("/isLogin")
    public Message isLogin(HttpSession httpSession) {
        Object obj = httpSession.getAttribute("custom");
        if (obj == null) return ResultUtil.error("Not");
        return ResultUtil.success("OK");
    }

    @PostMapping("/order")
        public Message order(@Valid @RequestBody OrderReq orderReq) {

        OrderDetail orderDetail = new OrderDetail(
            orderReq.getCustomID(),
                orderReq.getWaterID(),
                orderReq.getNumber(),
                TimeUtil.getFormatTime()
        );

        orderDetailService.addOrderDetail(orderDetail);

        return ResultUtil.success("OK");
    }

}
