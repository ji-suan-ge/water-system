package cn.edu.hfut.watersystem.manage.service.Impl;

import cn.edu.hfut.watersystem.manage.bean.GetOrderDetailListRes;
import cn.edu.hfut.watersystem.manage.mapper.OrderDetailMapper;
import cn.edu.hfut.watersystem.manage.util.TimeUtil;
import cn.edu.hfut.watersystem.manage.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/15 8:29
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Override
    public List<GetOrderDetailListRes.OrderDetail> getOrderDetailListByState(int state) {
        return orderDetailMapper.selectOrderDetailListByState(state);
    }

    @Override
    public void cancelOrder(int orderDetailID) {
        orderDetailMapper.updateOrderDetailStateByID(orderDetailID, 0);
    }

    @Override
    public void deliverOrder(int orderDetailID, int staffID) {
        orderDetailMapper.deliverOrder(orderDetailID, staffID, TimeUtil.getFormatTime());
    }


}
