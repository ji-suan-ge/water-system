package cn.edu.hfut.watersystem.custom.service;

import cn.edu.hfut.watersystem.custom.mapper.OrderDetailMapper;
import cn.edu.hfut.watersystem.custom.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 葛学文
 * @date 2019/6/15 8:28
 */
@Service
public class OrderDetailService {

    @Autowired
    OrderDetailMapper orderDetailMapper;

    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetailMapper.insertOrderDetail(orderDetail);
    }


}
