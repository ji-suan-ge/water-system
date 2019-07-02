package cn.edu.hfut.watersystem.manage.mapper;

import cn.edu.hfut.watersystem.manage.entity.OrderDetail;
import cn.edu.hfut.watersystem.manage.bean.GetOrderDetailListRes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

/**
 * @author 葛学文
 * @date 2019/6/15 8:25
 */
@Mapper
public interface OrderDetailMapper {

    @Select("CALL selectOrderByState(#{ID})")
    @Options(statementType= StatementType.CALLABLE)
    List<GetOrderDetailListRes.OrderDetail> selectOrderDetailListByState(int ID);

    @Select("CALL updateOrderStateByID(#{ID}, #{state})")
    @Options(statementType= StatementType.CALLABLE)
    List<OrderDetail> updateOrderDetailStateByID(int ID, int state);


    @Select("CALL insertDelivery(#{orderDetailID}, #{staffID}, #{time})")
    @Options(statementType= StatementType.CALLABLE)
    List<OrderDetail> deliverOrder(int orderDetailID, int staffID, String time);
}
