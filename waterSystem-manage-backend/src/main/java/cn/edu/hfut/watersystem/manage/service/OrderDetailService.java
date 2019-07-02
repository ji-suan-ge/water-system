package cn.edu.hfut.watersystem.manage.service;

import cn.edu.hfut.watersystem.manage.bean.GetOrderDetailListRes;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/15 8:28
 */
public interface OrderDetailService {

    List<GetOrderDetailListRes.OrderDetail> getOrderDetailListByState(int state);

    void cancelOrder(int orderDetailID);

    void deliverOrder(int orderDetailID, int staffID);
}
